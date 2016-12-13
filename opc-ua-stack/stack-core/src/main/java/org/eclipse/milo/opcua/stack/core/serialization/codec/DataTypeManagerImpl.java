/*
 * Copyright (c) 2016 Kevin Herron
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *
 * The Eclipse Public License is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 *   http://www.eclipse.org/org/documents/edl-v10.html.
 */

package org.eclipse.milo.opcua.stack.core.serialization.codec;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import org.eclipse.milo.opcua.stack.core.NamespaceTable;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

public class DataTypeManagerImpl implements DataTypeManager {

    private final ConcurrentMap<String, DataTypeDictionary> typeDictionaries = Maps.newConcurrentMap();

    private final NamespaceTable namespaceTable;

    public DataTypeManagerImpl(NamespaceTable namespaceTable) {
        this.namespaceTable = namespaceTable;
    }

    public DataTypeManagerImpl(NamespaceTable namespaceTable, DataTypeDictionary... typeDictionaries) {
        this.namespaceTable = namespaceTable;

        for (DataTypeDictionary d : typeDictionaries) {
            registerTypeDictionary(d);
        }
    }

    public DataTypeManagerImpl(NamespaceTable namespaceTable, List<DataTypeDictionary> typeDictionaries) {
        this.namespaceTable = namespaceTable;

        for (DataTypeDictionary d : typeDictionaries) {
            registerTypeDictionary(d);
        }
    }

    @Override
    public void registerTypeDictionary(DataTypeDictionary dataTypeDictionary) {
        typeDictionaries.put(dataTypeDictionary.getNamespaceUri(), dataTypeDictionary);
    }

    @Nullable
    @Override
    public DataTypeDictionary getTypeDictionary(String namespaceUri) {
        return typeDictionaries.get(namespaceUri);
    }

    @Nullable
    @Override
    public OpcBinaryDataTypeCodec<?> getBinaryCodec(NodeId encodingId) {
        String uri = namespaceTable.getUri(encodingId.getNamespaceIndex());

        DataTypeDictionary dictionary = typeDictionaries.get(uri);

        return dictionary != null ? dictionary.getBinaryCodec(encodingId) : null;
    }

    @Nullable
    @Override
    public OpcXmlDataTypeCodec<?> getXmlCodec(NodeId encodingId) {
        String uri = namespaceTable.getUri(encodingId.getNamespaceIndex());

        DataTypeDictionary dictionary = typeDictionaries.get(uri);

        return dictionary != null ? dictionary.getXmlCodec(encodingId) : null;
    }

}
