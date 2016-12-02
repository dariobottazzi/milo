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

import java.util.UUID;
import java.util.function.Supplier;

import org.eclipse.milo.opcua.stack.core.UaSerializationException;
import org.eclipse.milo.opcua.stack.core.types.builtin.ByteString;
import org.eclipse.milo.opcua.stack.core.types.builtin.DateTime;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UByte;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.ULong;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UNumber;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;

public interface OpcBinaryStreamReader {

    int readBit() throws UaSerializationException;

    Boolean readBoolean() throws UaSerializationException;

    Byte readSByte() throws UaSerializationException;

    UByte readByte() throws UaSerializationException;

    Short readInt16() throws UaSerializationException;

    UShort readUInt16() throws UaSerializationException;

    Integer readInt32() throws UaSerializationException;

    UInteger readUInt32() throws UaSerializationException;

    Long readInt64() throws UaSerializationException;

    ULong readUInt64() throws UaSerializationException;

    Float readFloat() throws UaSerializationException;

    Double readDouble() throws UaSerializationException;

    Character readCharacter() throws UaSerializationException;

    Character readWideChar() throws UaSerializationException;

    String readString() throws UaSerializationException;

    Character[] readCharArray() throws UaSerializationException;

    String readWideString() throws UaSerializationException;

    String readWideCharArray() throws UaSerializationException;

    DateTime readDateTime() throws UaSerializationException;

    ByteString readByteString() throws UaSerializationException;

    UUID readGuid() throws UaSerializationException;

    // TODO do these belong here? SerializationContext in codec encode/decode?

    UNumber readEnumeratedType(int lengthInBits) throws UaSerializationException;

    UNumber readEnumeratedType(String namespaceUri, String typeName) throws UaSerializationException;

    ByteString readOpaqueType(int lengthInBits) throws UaSerializationException;

    Object readOpaqueType(String namespaceUri, String typeName) throws UaSerializationException;

    Object readStructuredType(NodeId encodingId) throws UaSerializationException;

    Object readStructuredType(String namespaceUri, String typeName) throws UaSerializationException;

    <T> T[] readArray(Supplier<T> supplier, Class<T> clazz) throws UaSerializationException;

}
