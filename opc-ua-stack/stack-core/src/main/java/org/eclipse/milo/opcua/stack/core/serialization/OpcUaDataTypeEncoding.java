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

import java.io.StringReader;
import java.io.StringWriter;
import java.nio.ByteOrder;
import javax.xml.stream.XMLStreamException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import org.eclipse.milo.opcua.stack.core.StatusCodes;
import org.eclipse.milo.opcua.stack.core.UaSerializationException;
import org.eclipse.milo.opcua.stack.core.serialization.binary.BinaryDecoder;
import org.eclipse.milo.opcua.stack.core.serialization.binary.BinaryEncoder;
import org.eclipse.milo.opcua.stack.core.serialization.xml.XmlDecoder;
import org.eclipse.milo.opcua.stack.core.serialization.xml.XmlEncoder;
import org.eclipse.milo.opcua.stack.core.types.builtin.ByteString;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.XmlElement;

public class OpcUaDataTypeEncoding implements DataTypeEncoding {

    private static final OpcUaTypeDictionary.Instance TYPE_DICTIONARY = OpcUaTypeDictionary.getInstance();

    private final ByteBufAllocator allocator = ByteBufAllocator.DEFAULT;

    @Override
    public ByteString encodeToByteString(Object object, NodeId encodingTypeId) {
        try {
            @SuppressWarnings("unchecked")
            TypeEncoder<Object> typeEncoder = (TypeEncoder<Object>) TYPE_DICTIONARY.getEncoder(encodingTypeId);

            ByteBuf buffer = allocator.buffer().order(ByteOrder.LITTLE_ENDIAN);

            BinaryEncoder encoder = new BinaryEncoder();
            encoder.setBuffer(buffer);

            typeEncoder.encode(object, encoder);

            byte[] bs = new byte[buffer.readableBytes()];
            buffer.readBytes(bs);
            buffer.release();

            return ByteString.of(bs);
        } catch (ClassCastException e) {
            throw new UaSerializationException(StatusCodes.Bad_EncodingError, e);
        }
    }

    @Override
    public ByteString encodeToByteString(
        Object object,
        NodeId encodingTypeId,
        TypeManager typeManager) throws UaSerializationException {

        try {
            @SuppressWarnings("unchecked")
            TypeEncoder<Object> typeEncoder = (TypeEncoder<Object>) typeManager.getEncoder(encodingTypeId);

            ByteBuf buffer = allocator.buffer().order(ByteOrder.LITTLE_ENDIAN);

            BinaryEncoder encoder = new BinaryEncoder(typeManager);
            encoder.setBuffer(buffer);

            typeEncoder.encode(object, encoder);

            byte[] bs = new byte[buffer.readableBytes()];
            buffer.readBytes(bs);
            buffer.release();

            return ByteString.of(bs);
        } catch (ClassCastException e) {
            throw new UaSerializationException(StatusCodes.Bad_EncodingError, e);
        }
    }

    @Override
    public XmlElement encodeToXmlElement(Object object, NodeId encodingTypeId) {
        try {
            @SuppressWarnings("unchecked")
            TypeEncoder<Object> typeEncoder = (TypeEncoder<Object>) TYPE_DICTIONARY.getEncoder(encodingTypeId);

            StringWriter stringWriter = new StringWriter();

            XmlEncoder encoder = new XmlEncoder();
            encoder.setOutput(stringWriter);

            typeEncoder.encode(object, encoder);

            return new XmlElement(stringWriter.toString());
        } catch (ClassCastException | XMLStreamException e) {
            throw new UaSerializationException(StatusCodes.Bad_EncodingError, e);
        }
    }

    @Override
    public XmlElement encodeToXmlElement(
        Object object,
        NodeId encodingTypeId,
        TypeManager typeManager) throws UaSerializationException {

        try {
            @SuppressWarnings("unchecked")
            TypeEncoder<Object> typeEncoder = (TypeEncoder<Object>) typeManager.getEncoder(encodingTypeId);

            StringWriter stringWriter = new StringWriter();

            XmlEncoder encoder = new XmlEncoder(typeManager);
            encoder.setOutput(stringWriter);

            typeEncoder.encode(object, encoder);

            return new XmlElement(stringWriter.toString());
        } catch (ClassCastException | XMLStreamException e) {
            throw new UaSerializationException(StatusCodes.Bad_EncodingError, e);
        }
    }

    @Override
    public Object decodeFromByteString(ByteString encoded, NodeId encodingTypeId) {
        try {
            @SuppressWarnings("unchecked")
            TypeDecoder<Object> typeDecoder = (TypeDecoder<Object>) TYPE_DICTIONARY.getDecoder(encodingTypeId);

            byte[] bs = encoded.bytes();
            if (bs == null) bs = new byte[0];

            ByteBuf buffer = Unpooled
                .wrappedBuffer(bs)
                .order(ByteOrder.LITTLE_ENDIAN);

            BinaryDecoder decoder = new BinaryDecoder();
            decoder.setBuffer(buffer);

            return typeDecoder.decode(decoder);
        } catch (ClassCastException e) {
            throw new UaSerializationException(StatusCodes.Bad_DecodingError, e);
        }
    }

    @Override
    public Object decodeFromByteString(
        ByteString encoded,
        NodeId encodingTypeId,
        TypeManager typeManager) throws UaSerializationException {

        try {
            @SuppressWarnings("unchecked")
            TypeDecoder<Object> typeDecoder = (TypeDecoder<Object>) typeManager.getDecoder(encodingTypeId);

            byte[] bs = encoded.bytes();
            if (bs == null) bs = new byte[0];

            ByteBuf buffer = Unpooled
                .wrappedBuffer(bs)
                .order(ByteOrder.LITTLE_ENDIAN);

            BinaryDecoder decoder = new BinaryDecoder(typeManager);
            decoder.setBuffer(buffer);

            return typeDecoder.decode(decoder);
        } catch (ClassCastException e) {
            throw new UaSerializationException(StatusCodes.Bad_DecodingError, e);
        }
    }

    @Override
    public Object decodeFromXmlElement(XmlElement encoded, NodeId encodingTypeId) {
        try {
            @SuppressWarnings("unchecked")
            TypeDecoder<Object> typeDecoder = (TypeDecoder<Object>) TYPE_DICTIONARY.getDecoder(encodingTypeId);

            XmlDecoder decoder = new XmlDecoder();
            decoder.setInput(new StringReader(encoded.getFragment()));

            return typeDecoder.decode(decoder);
        } catch (ClassCastException | XMLStreamException e) {
            throw new UaSerializationException(StatusCodes.Bad_DecodingError, e);
        }
    }

    @Override
    public Object decodeFromXmlElement(
        XmlElement encoded,
        NodeId encodingTypeId,
        TypeManager typeManager) throws UaSerializationException {

        try {
            @SuppressWarnings("unchecked")
            TypeDecoder<Object> typeDecoder = (TypeDecoder<Object>) typeManager.getDecoder(encodingTypeId);

            XmlDecoder decoder = new XmlDecoder(typeManager);
            decoder.setInput(new StringReader(encoded.getFragment()));

            return typeDecoder.decode(decoder);
        } catch (ClassCastException | XMLStreamException e) {
            throw new UaSerializationException(StatusCodes.Bad_DecodingError, e);
        }
    }

}
