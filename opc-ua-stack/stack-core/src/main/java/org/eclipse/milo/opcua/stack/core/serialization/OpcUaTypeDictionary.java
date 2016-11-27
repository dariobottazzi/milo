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

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import com.google.common.collect.Maps;
import org.eclipse.milo.opcua.stack.core.StatusCodes;
import org.eclipse.milo.opcua.stack.core.UaSerializationException;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

public class OpcUaTypeDictionary {

    /**
     * Get the singleton instance of the OpcUaTypeDictionary: {@link OpcUaTypeDictionary.Instance}.
     *
     * @return the singleton instance of the OpcUaTypeDictionary: {@link OpcUaTypeDictionary.Instance}.
     */
    public static Instance getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder {
        private static final Instance INSTANCE = getOrInitialize();
    }

    private static final Map<NodeId, TypeEncoder<?>> ENCODERS_BY_ID = Maps.newConcurrentMap();
    private static final Map<String, TypeEncoder<?>> ENCODERS_BY_NAME = Maps.newConcurrentMap();
    private static final Map<Class<?>, TypeEncoder<?>> ENCODERS_BY_CLASS = Maps.newConcurrentMap();

    private static final Map<NodeId, TypeDecoder<?>> DECODERS_BY_ID = Maps.newConcurrentMap();
    private static final Map<String, TypeDecoder<?>> DECODERS_BY_NAME = Maps.newConcurrentMap();
    private static final Map<Class<?>, TypeDecoder<?>> DECODERS_BY_CLASS = Maps.newConcurrentMap();

    private static final AtomicReference<Instance> INSTANCE_REF = new AtomicReference<>();

    private static synchronized Instance getOrInitialize() {
        Instance instance = INSTANCE_REF.get();

        if (instance == null) {
            OpcUaTypeDictionaryInitializer.initialize();

            instance = new Instance(
                ENCODERS_BY_ID,
                ENCODERS_BY_NAME,
                ENCODERS_BY_CLASS,
                DECODERS_BY_ID,
                DECODERS_BY_NAME,
                DECODERS_BY_CLASS
            );

            INSTANCE_REF.set(instance);

            return instance;
        } else {
            return instance;
        }
    }

    static synchronized <T> void register(
        TypeEncoder<T> encoder,
        TypeDecoder<T> decoder,
        Class<T> clazz,
        NodeId... ids) {

        registerEncoder(encoder, clazz, ids);
        registerDecoder(decoder, clazz, ids);
    }

    public static synchronized <T> void registerEncoder(TypeEncoder<T> delegate, Class<T> clazz, NodeId... ids) {
        ENCODERS_BY_CLASS.put(clazz, delegate);
        ENCODERS_BY_NAME.put(clazz.getSimpleName(), delegate);

        if (ids != null) {
            Arrays.stream(ids).forEach(id -> ENCODERS_BY_ID.put(id, delegate));
        }
    }

    public static synchronized <T> void registerDecoder(TypeDecoder<T> delegate, Class<T> clazz, NodeId... ids) {
        DECODERS_BY_CLASS.put(clazz, delegate);
        DECODERS_BY_NAME.put(clazz.getSimpleName(), delegate);

        if (ids != null) {
            Arrays.stream(ids).forEach(id -> DECODERS_BY_ID.put(id, delegate));
        }
    }

    public static class Instance implements TypeDictionary {

        static final String OPC_UA_TYPES_NAMESPACE = "http://opcfoundation.org/UA/";

        private final Map<NodeId, TypeEncoder<?>> encodersById;
        private final Map<String, TypeEncoder<?>> encodersByName;
        private final Map<Class<?>, TypeEncoder<?>> encodersByClass;

        private final Map<NodeId, TypeDecoder<?>> decodersById;
        private final Map<String, TypeDecoder<?>> decodersByName;
        private final Map<Class<?>, TypeDecoder<?>> decodersByClass;

        private Instance(
            Map<NodeId, TypeEncoder<?>> encodersById,
            Map<String, TypeEncoder<?>> encodersByName,
            Map<Class<?>, TypeEncoder<?>> encodersByClass,
            Map<NodeId, TypeDecoder<?>> decodersById,
            Map<String, TypeDecoder<?>> decodersByName,
            Map<Class<?>, TypeDecoder<?>> decodersByClass) {

            this.encodersByClass = encodersByClass;
            this.encodersById = encodersById;
            this.encodersByName = encodersByName;
            this.decodersByClass = decodersByClass;
            this.decodersById = decodersById;
            this.decodersByName = decodersByName;
        }

        @Override
        public String getNamespaceUri() {
            return OPC_UA_TYPES_NAMESPACE;
        }

        @SuppressWarnings("unchecked")
        public <T> TypeEncoder<T> getEncoder(Object t) throws UaSerializationException {
            try {
                return (TypeEncoder<T>) encodersByClass.get(t.getClass());
            } catch (NullPointerException e) {
                throw new UaSerializationException(StatusCodes.Bad_EncodingError,
                    "no encoder registered for class=" + t);
            }
        }

        @Override
        public TypeEncoder<?> getEncoder(String typeName) throws UaSerializationException {
            TypeEncoder<?> typeEncoder = encodersByName.get(typeName);

            if (typeEncoder != null) {
                return typeEncoder;
            } else {
                throw new UaSerializationException(StatusCodes.Bad_EncodingError,
                    "no encoder registered for name=" + typeName);
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public TypeEncoder<?> getEncoder(NodeId encodingId) throws UaSerializationException {
            TypeEncoder<?> typeEncoder = encodersById.get(encodingId);

            if (typeEncoder != null) {
                return typeEncoder;
            } else {
                throw new UaSerializationException(StatusCodes.Bad_EncodingError,
                    "no encoder registered for encodingId=" + encodingId);
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> TypeEncoder<T> getEncoder(Class<T> clazz) throws UaSerializationException {
            TypeEncoder<?> typeEncoder = encodersByClass.get(clazz);

            if (typeEncoder != null) {
                try {
                    return (TypeEncoder<T>) typeEncoder;
                } catch (Exception e) {
                    throw new UaSerializationException(StatusCodes.Bad_EncodingError, e);
                }
            } else {
                throw new UaSerializationException(StatusCodes.Bad_EncodingError,
                    "no encoder registered for class=" + clazz);
            }
        }

        @Override
        public TypeDecoder<?> getDecoder(String typeName) throws UaSerializationException {
            TypeDecoder<?> typeDecoder = decodersByName.get(typeName);

            if (typeDecoder != null) {
                return typeDecoder;
            } else {
                throw new UaSerializationException(StatusCodes.Bad_DecodingError,
                    "no decoder registered for typeName=" + typeName);
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public TypeDecoder<?> getDecoder(NodeId encodingId) {
            TypeDecoder<?> typeDecoder = decodersById.get(encodingId);

            if (typeDecoder != null) {
                return typeDecoder;
            } else {
                throw new UaSerializationException(StatusCodes.Bad_DecodingError,
                    "no decoder registered for encodingId=" + encodingId);
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> TypeDecoder<T> getDecoder(Class<T> clazz) throws UaSerializationException {
            TypeDecoder<?> typeDecoder = decodersByClass.get(clazz);

            if (typeDecoder != null) {
                try {
                    return (TypeDecoder<T>) typeDecoder;
                } catch (Exception e) {
                    throw new UaSerializationException(StatusCodes.Bad_DecodingError, e);
                }
            } else {
                throw new UaSerializationException(StatusCodes.Bad_DecodingError,
                    "no decoder registered for class=" + clazz);
            }
        }

    }

}
