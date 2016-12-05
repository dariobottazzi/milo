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

package org.eclipse.milo.opcua.stack.core.serialization;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;

import com.google.common.collect.Maps;
import org.eclipse.milo.opcua.stack.core.serialization.codec.DataTypeDictionary;
import org.eclipse.milo.opcua.stack.core.serialization.codec.DataTypeDictionaryImpl;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcBinaryDataTypeCodec;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcXmlDataTypeCodec;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

public class OpcUaDataTypeDictionary {

    public static final String NAMESPACE_URI = "http://opcfoundation.org/UA/";

    /**
     * Get the singleton instance of the OPC UA namespace type dictionary
     *
     * @return the singleton instance of the OPC UA namespace type dictionary.
     */
    public static DataTypeDictionary getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final DataTypeDictionary INSTANCE = getOrInitialize();
    }

    private static final ConcurrentMap<NodeId, OpcBinaryDataTypeCodec<?>> BINARY_CODECS_BY_ID
        = Maps.newConcurrentMap();
    private static final ConcurrentMap<String, OpcBinaryDataTypeCodec<?>> BINARY_CODECS_BY_NAME
        = Maps.newConcurrentMap();

    private static final ConcurrentMap<NodeId, OpcXmlDataTypeCodec<?>> XML_CODECS_BY_ID
        = Maps.newConcurrentMap();
    private static final ConcurrentMap<String, OpcXmlDataTypeCodec<?>> XML_CODECS_BY_NAME
        = Maps.newConcurrentMap();

    private static final AtomicReference<DataTypeDictionary> INSTANCE_REF = new AtomicReference<>();

    private static synchronized DataTypeDictionary getOrInitialize() {
        DataTypeDictionary instance = INSTANCE_REF.get();

        if (instance == null) {
            OpcUaDataTypeDictionaryInitializer.initialize();

            instance = new DataTypeDictionaryImpl(
                NAMESPACE_URI,
                BINARY_CODECS_BY_ID,
                BINARY_CODECS_BY_NAME,
                XML_CODECS_BY_ID,
                XML_CODECS_BY_NAME
            );

            // TODO register codecs for built-in types

            INSTANCE_REF.set(instance);

            return instance;
        } else {
            return instance;
        }
    }

    public static synchronized <T> void register(
        String typeName,
        NodeId binaryEncodingId,
        OpcBinaryDataTypeCodec<T> binaryTypeCodec,
        NodeId xmlEncodingId,
        OpcXmlDataTypeCodec<T> xmlTypeCodec) {

        registerBinaryCodec(binaryTypeCodec, binaryEncodingId, typeName);
        registerXmlCodec(xmlTypeCodec, xmlEncodingId, typeName);
    }

    public static synchronized <T> void registerBinaryCodec(
        OpcBinaryDataTypeCodec<T> codec, NodeId encodingId, String typeName) {

        BINARY_CODECS_BY_ID.put(encodingId, codec);
        BINARY_CODECS_BY_NAME.put(typeName, codec);
    }

    public static synchronized <T> void registerXmlCodec(
        OpcXmlDataTypeCodec<T> codec, NodeId encodingId, String typeName) {

        XML_CODECS_BY_ID.put(encodingId, codec);
        XML_CODECS_BY_NAME.put(typeName, codec);
    }

}
