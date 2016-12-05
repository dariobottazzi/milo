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

import javax.annotation.Nullable;

import org.eclipse.milo.opcua.stack.core.NamespaceTable;
import org.eclipse.milo.opcua.stack.core.serialization.OpcUaDataTypeDictionary;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

public interface DataTypeManager {

    DataTypeManager BUILTIN = new DataTypeManagerImpl(new NamespaceTable(), OpcUaDataTypeDictionary.getInstance());

    void registerTypeDictionary(String namespaceUri, DataTypeDictionary dataTypeDictionary);

    @Nullable
    DataTypeDictionary getTypeDictionary(String namespaceUri);

    @Nullable
    OpcBinaryDataTypeCodec<?> getBinaryCodec(NodeId encodingId);

    @Nullable
    default OpcBinaryDataTypeCodec<?> getBinaryCodec(String namespaceUri, String typeName) {
        DataTypeDictionary dictionary = getTypeDictionary(namespaceUri);

        return dictionary != null ? dictionary.getBinaryCodec(typeName) : null;
    }

    @Nullable
    OpcXmlDataTypeCodec<?> getXmlCodec(NodeId encodingId);

    @Nullable
    default OpcXmlDataTypeCodec<?> getXmlCodec(String namespaceUri, String typeName) {
        DataTypeDictionary dictionary = getTypeDictionary(namespaceUri);

        return dictionary != null ? dictionary.getXmlCodec(typeName) : null;
    }


}
