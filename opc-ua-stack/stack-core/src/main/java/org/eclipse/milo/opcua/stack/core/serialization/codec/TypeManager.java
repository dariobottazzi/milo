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
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

public interface TypeManager {

    TypeManager BUILTIN = new TypeManagerImpl(new NamespaceTable());

    @Nullable
    TypeDictionary getTypeDictionary(String namespaceUri);

    @Nullable
    OpcBinaryTypeCodec<?> getBinaryCodec(NodeId encodingId);

    @Nullable
    default OpcBinaryTypeCodec<?> getBinaryCodec(String namespaceUri, String typeName) {
        TypeDictionary dictionary = getTypeDictionary(namespaceUri);

        return dictionary != null ? dictionary.getBinaryCodec(typeName) : null;
    }

    @Nullable
    OpcXmlTypeCodec<?> getXmlCodec(NodeId encodingId);

    @Nullable
    default OpcXmlTypeCodec<?> getXmlCodec(String namespaceUri, String typeName) {
        TypeDictionary dictionary = getTypeDictionary(namespaceUri);

        return dictionary != null ? dictionary.getXmlCodec(typeName) : null;
    }


}
