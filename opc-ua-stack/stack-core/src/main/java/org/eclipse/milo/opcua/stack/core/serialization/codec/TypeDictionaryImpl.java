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

import java.util.Map;

import com.google.common.collect.Maps;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

public class TypeDictionaryImpl implements TypeDictionary {

    private final Map<String, OpcBinaryTypeCodec<?>> binaryCodecsByName = Maps.newConcurrentMap();
    private final Map<NodeId, OpcBinaryTypeCodec<?>> binaryCodecsByEncoding = Maps.newConcurrentMap();
    private final Map<String, OpcXmlTypeCodec<?>> xmlCodecsByName = Maps.newConcurrentMap();
    private final Map<NodeId, OpcXmlTypeCodec<?>> xmlCodecsByEncoding = Maps.newConcurrentMap();

    private final String namespaceUri;

    public TypeDictionaryImpl(String namespaceUri) {
        this.namespaceUri = namespaceUri;
    }

    @Override
    public String getNamespaceUri() {
        return namespaceUri;
    }

    @Override
    public void registerBinaryCodec(OpcBinaryTypeCodec<?> codec, String typeName) {
        binaryCodecsByName.put(typeName, codec);
    }

    @Override
    public void registerBinaryCodec(OpcBinaryTypeCodec<?> codec, String typeName, NodeId binaryEncodingId) {
        binaryCodecsByName.put(typeName, codec);
        binaryCodecsByEncoding.put(binaryEncodingId, codec);
    }

    @Override
    public void registerXmlCodec(OpcXmlTypeCodec<?> codec, String typeName) {
        xmlCodecsByName.put(typeName, codec);
    }

    @Override
    public void registerXmlCodec(OpcXmlTypeCodec<?> codec, String typeName, NodeId xmlEncodingId) {
        xmlCodecsByName.put(typeName, codec);
        xmlCodecsByEncoding.put(xmlEncodingId, codec);
    }

    @Override
    public OpcBinaryTypeCodec<?> getBinaryCodec(NodeId encodingId) {
        return binaryCodecsByEncoding.get(encodingId);
    }

    @Override
    public OpcBinaryTypeCodec<?> getBinaryCodec(String typeName) {
        return binaryCodecsByName.get(typeName);
    }

    @Override
    public OpcXmlTypeCodec<?> getXmlCodec(NodeId encodingId) {
        return xmlCodecsByEncoding.get(encodingId);
    }

    @Override
    public OpcXmlTypeCodec<?> getXmlCodec(String typeName) {
        return xmlCodecsByName.get(typeName);
    }

}
