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
import java.util.function.Consumer;

import org.eclipse.milo.opcua.stack.core.UaSerializationException;
import org.eclipse.milo.opcua.stack.core.types.builtin.ByteString;
import org.eclipse.milo.opcua.stack.core.types.builtin.DateTime;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UByte;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.ULong;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;

public interface OpcBinaryStreamWriter {

    void writeBit(int value) throws UaSerializationException;

    void writeBoolean(boolean value) throws UaSerializationException;

    void writeSByte(Byte value) throws UaSerializationException;

    void writeByte(UByte value) throws UaSerializationException;

    void writeInt16(Short value) throws UaSerializationException;

    void writeUInt16(UShort value) throws UaSerializationException;

    void writeInt32(Integer value) throws UaSerializationException;

    void writeUInt32(UInteger value) throws UaSerializationException;

    void writeInt64(Long value) throws UaSerializationException;

    void writeUInt64(ULong value) throws UaSerializationException;

    void writeFloat(Float value) throws UaSerializationException;

    void writeDouble(Double value) throws UaSerializationException;

    void writeCharacter(Character value) throws UaSerializationException;

    void writeWideChar(Character value) throws UaSerializationException;

    void writeString(String value) throws UaSerializationException;

    void writeCharArray(Character[] value) throws UaSerializationException;

    void writeWideString(String value) throws UaSerializationException;

    void writeWideCharArray(String value) throws UaSerializationException;

    void writeDateTime(DateTime value) throws UaSerializationException;

    void writeByteString(ByteString value) throws UaSerializationException;

    void writeGuid(UUID value) throws UaSerializationException;

    <T> void writeArray(T[] values, Consumer<T> writer) throws UaSerializationException;

}
