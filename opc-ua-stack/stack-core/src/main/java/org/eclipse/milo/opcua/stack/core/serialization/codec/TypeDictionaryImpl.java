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

import com.google.common.collect.Maps;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

public class TypeDictionaryImpl implements TypeDictionary {

    private final String namespaceUri;

    private final ConcurrentMap<NodeId, OpcBinaryTypeCodec<?>> binaryCodecsById;
    private final ConcurrentMap<String, OpcBinaryTypeCodec<?>> binaryCodecsByName;
    private final ConcurrentMap<NodeId, OpcXmlTypeCodec<?>> xmlCodecsById;
    private final ConcurrentMap<String, OpcXmlTypeCodec<?>> xmlCodecsByName;

    public TypeDictionaryImpl(String namespaceUri) {
        this(namespaceUri,
            Maps.newConcurrentMap(),
            Maps.newConcurrentMap(),
            Maps.newConcurrentMap(),
            Maps.newConcurrentMap());
    }

    public TypeDictionaryImpl(
        String namespaceUri,
        ConcurrentMap<NodeId, OpcBinaryTypeCodec<?>> binaryCodecsById,
        ConcurrentMap<String, OpcBinaryTypeCodec<?>> binaryCodecsByName,
        ConcurrentMap<NodeId, OpcXmlTypeCodec<?>> xmlCodecsById,
        ConcurrentMap<String, OpcXmlTypeCodec<?>> xmlCodecsByName) {

        this.namespaceUri = namespaceUri;
        this.binaryCodecsById = binaryCodecsById;
        this.binaryCodecsByName = binaryCodecsByName;
        this.xmlCodecsById = xmlCodecsById;
        this.xmlCodecsByName = xmlCodecsByName;
    }

    @Override
    public String getNamespaceUri() {
        return namespaceUri;
    }

    @Override
    public void linkBinaryCodec(NodeId encodingId, String typeName) {
        OpcBinaryTypeCodec<?> codec = binaryCodecsById.get(encodingId);
        if (codec != null) {
            binaryCodecsByName.putIfAbsent(typeName, codec);
        } else {
            codec = binaryCodecsByName.get(typeName);
            if (codec != null) {
                binaryCodecsById.put(encodingId, codec);
            }
        }
    }

    @Override
    public void linkXmlCodec(NodeId encodingId, String typeName) {
        OpcXmlTypeCodec<?> codec = xmlCodecsById.get(encodingId);
        if (codec != null) {
            xmlCodecsByName.putIfAbsent(typeName, codec);
        } else {
            codec = xmlCodecsByName.get(typeName);
            if (codec != null) {
                xmlCodecsById.put(encodingId, codec);
            }
        }
    }

    @Override
    public void registerBinaryCodec(OpcBinaryTypeCodec<?> codec, String typeName) {
        binaryCodecsByName.put(typeName, codec);
    }

    @Override
    public void registerBinaryCodec(OpcBinaryTypeCodec<?> codec, String typeName, NodeId binaryEncodingId) {
        binaryCodecsByName.put(typeName, codec);
        binaryCodecsById.put(binaryEncodingId, codec);
    }

    @Override
    public void registerXmlCodec(OpcXmlTypeCodec<?> codec, String typeName) {
        xmlCodecsByName.put(typeName, codec);
    }

    @Override
    public void registerXmlCodec(OpcXmlTypeCodec<?> codec, String typeName, NodeId xmlEncodingId) {
        xmlCodecsByName.put(typeName, codec);
        xmlCodecsById.put(xmlEncodingId, codec);
    }

    @Override
    public OpcBinaryTypeCodec<?> getBinaryCodec(NodeId encodingId) {
        return binaryCodecsById.get(encodingId);
    }

    @Override
    public OpcBinaryTypeCodec<?> getBinaryCodec(String typeName) {
        return binaryCodecsByName.get(typeName);
    }

    @Override
    public OpcXmlTypeCodec<?> getXmlCodec(NodeId encodingId) {
        return xmlCodecsById.get(encodingId);
    }

    @Override
    public OpcXmlTypeCodec<?> getXmlCodec(String typeName) {
        return xmlCodecsByName.get(typeName);
    }

}
