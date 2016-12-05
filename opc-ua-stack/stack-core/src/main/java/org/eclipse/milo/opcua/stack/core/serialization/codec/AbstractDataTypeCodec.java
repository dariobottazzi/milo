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

import org.eclipse.milo.opcua.stack.core.UaSerializationException;

public abstract class AbstractDataTypeCodec<T> implements OpcBinaryDataTypeCodec<T>, OpcXmlDataTypeCodec<T> {

    // TODO measure performance of ThreadLocal vs just creating new instances

    @Override
    public void encode(
        SerializationContext context, T t, OpcXmlStreamWriter writer) throws UaSerializationException {

        encode(t, new UnifiedXmlEncoder(writer));
    }

    @Override
    public void encode(
        SerializationContext context, T t, OpcBinaryStreamWriter writer) throws UaSerializationException {

        encode(t, new UnifiedBinaryEncoder(writer));
    }

    @Override
    public T decode(SerializationContext context, OpcXmlStreamReader reader) throws UaSerializationException {
        return decode(new UnifiedXmlDecoder(reader));
    }

    @Override
    public T decode(SerializationContext context, OpcBinaryStreamReader reader) throws UaSerializationException {
        return decode(new UnifiedBinaryDecoder(reader));
    }

    abstract void encode(T encodable, UnifiedEncoder encoder);

    abstract T decode(UnifiedDecoder decoder);

    interface UnifiedEncoder {

    }

    interface UnifiedDecoder {

    }

    static class UnifiedBinaryEncoder implements UnifiedEncoder {
        final OpcBinaryStreamWriter writer;

        UnifiedBinaryEncoder(OpcBinaryStreamWriter writer) {
            this.writer = writer;
        }
    }

    static class UnifiedBinaryDecoder implements UnifiedDecoder {
        final OpcBinaryStreamReader reader;

        UnifiedBinaryDecoder(OpcBinaryStreamReader reader) {
            this.reader = reader;
        }
    }

    static class UnifiedXmlEncoder implements UnifiedEncoder {
        final OpcXmlStreamWriter writer;

        UnifiedXmlEncoder(OpcXmlStreamWriter writer) {
            this.writer = writer;
        }
    }

    static class UnifiedXmlDecoder implements UnifiedDecoder {
        final OpcXmlStreamReader reader;

        UnifiedXmlDecoder(OpcXmlStreamReader reader) {
            this.reader = reader;
        }
    }

}
