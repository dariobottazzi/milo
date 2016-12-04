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

import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import org.eclipse.milo.opcua.stack.core.NamespaceTable;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

public class TypeManagerImpl implements TypeManager {

    private final ConcurrentMap<String, TypeDictionary> typeDictionaries = Maps.newConcurrentMap();

    private final NamespaceTable namespaceTable;

    public TypeManagerImpl(NamespaceTable namespaceTable) {
        this.namespaceTable = namespaceTable;
    }

    public TypeManagerImpl(NamespaceTable namespaceTable, TypeDictionary... typeDictionaries) {
        this.namespaceTable = namespaceTable;

        for (TypeDictionary d : typeDictionaries) {
            registerTypeDictionary(d.getNamespaceUri(), d);
        }
    }

    @Override
    public void registerTypeDictionary(String namespaceUri, TypeDictionary typeDictionary) {
        typeDictionaries.put(namespaceUri, typeDictionary);
    }

    @Nullable
    @Override
    public TypeDictionary getTypeDictionary(String namespaceUri) {
        return typeDictionaries.get(namespaceUri);
    }

    @Nullable
    @Override
    public OpcBinaryTypeCodec<?> getBinaryCodec(NodeId encodingId) {
        String uri = namespaceTable.getUri(encodingId.getNamespaceIndex());

        TypeDictionary dictionary = typeDictionaries.get(uri);

        return dictionary != null ? dictionary.getBinaryCodec(encodingId) : null;
    }

    @Nullable
    @Override
    public OpcXmlTypeCodec<?> getXmlCodec(NodeId encodingId) {
        String uri = namespaceTable.getUri(encodingId.getNamespaceIndex());

        TypeDictionary dictionary = typeDictionaries.get(uri);

        return dictionary != null ? dictionary.getXmlCodec(encodingId) : null;
    }

}
