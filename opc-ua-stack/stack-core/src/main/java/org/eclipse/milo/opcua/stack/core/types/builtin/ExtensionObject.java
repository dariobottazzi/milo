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

package org.eclipse.milo.opcua.stack.core.types.builtin;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.eclipse.milo.opcua.stack.core.UaSerializationException;
import org.eclipse.milo.opcua.stack.core.serialization.DataTypeEncoding;
import org.eclipse.milo.opcua.stack.core.serialization.UaStructure;
import org.eclipse.milo.opcua.stack.core.serialization.codec.TypeManager;

public final class ExtensionObject {

    public enum BodyType {
        ByteString,
        XmlElement
    }

    private volatile Object decoded;

    private final BodyType bodyType;

    private final Object encoded;
    private final NodeId encodingTypeId;

    public ExtensionObject(ByteString encoded, NodeId encodingTypeId) {
        this.encoded = encoded;
        this.encodingTypeId = encodingTypeId;

        bodyType = BodyType.ByteString;
    }

    public ExtensionObject(XmlElement encoded, NodeId encodingTypeId) {
        this.encoded = encoded;
        this.encodingTypeId = encodingTypeId;

        bodyType = BodyType.XmlElement;
    }

    public Object getEncoded() {
        return encoded;
    }

    public NodeId getEncodingTypeId() {
        return encodingTypeId;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public <T> T decode() throws UaSerializationException {
        return decode(DataTypeEncoding.OPC_UA);
    }

    public <T> T decode(TypeManager typeManager) throws UaSerializationException {
        return decode(DataTypeEncoding.OPC_UA, typeManager);
    }

    public <T> T decode(DataTypeEncoding encoding) throws UaSerializationException {
        return decode(encoding, TypeManager.BUILTIN);
    }

    public <T> T decode(DataTypeEncoding encoding, TypeManager typeManager) throws UaSerializationException {
        if (decoded != null) return (T) decoded;

        switch (bodyType) {
            case ByteString: {
                ByteString bs = (ByteString) encoded;
                if (bs == null || bs.isNull()) {
                    return null;
                } else {
                    decoded = encoding.decodeFromByteString((ByteString) encoded, encodingTypeId, typeManager);
                    return (T) decoded;
                }
            }

            case XmlElement: {
                XmlElement e = (XmlElement) encoded;
                if (e == null || e.isNull()) {
                    return null;
                } else {
                    decoded = encoding.decodeFromXmlElement((XmlElement) encoded, encodingTypeId, typeManager);
                    return (T) decoded;
                }
            }

            default:
                throw new IllegalStateException("unknown body type: " + bodyType);
        }
    }

    public static ExtensionObject encode(UaStructure structure) throws UaSerializationException {
        return encodeAsByteString(structure, structure.getBinaryEncodingId());
    }

    public static ExtensionObject encode(UaStructure structure,
                                         TypeManager typeManager) throws UaSerializationException {

        return encodeAsByteString(structure, structure.getBinaryEncodingId(), typeManager);
    }

    public static ExtensionObject encodeAsByteString(Object object,
                                                     NodeId encodingTypeId) throws UaSerializationException {

        return encodeAsByteString(object, encodingTypeId, DataTypeEncoding.OPC_UA);
    }

    public static ExtensionObject encodeAsByteString(Object object,
                                                     NodeId encodingTypeId,
                                                     TypeManager typeManager) throws UaSerializationException {

        return encodeAsByteString(object, encodingTypeId, DataTypeEncoding.OPC_UA, typeManager);
    }

    public static ExtensionObject encodeAsByteString(Object object,
                                                     NodeId encodingTypeId,
                                                     DataTypeEncoding context) throws UaSerializationException {

        return encodeAsByteString(object, encodingTypeId, context, TypeManager.BUILTIN);
    }

    public static ExtensionObject encodeAsByteString(Object object,
                                                     NodeId encodingTypeId,
                                                     DataTypeEncoding context,
                                                     TypeManager typeManager) throws UaSerializationException {

        ByteString encoded = context.encodeToByteString(object, encodingTypeId, typeManager);

        return new ExtensionObject(encoded, encodingTypeId);
    }

    public static ExtensionObject encodeAsXmlElement(Object object,
                                                     NodeId encodingTypeId) throws UaSerializationException {

        return encodeAsXmlElement(object, encodingTypeId, DataTypeEncoding.OPC_UA);
    }

    public static ExtensionObject encodeAsXmlElement(Object object,
                                                     NodeId encodingTypeId,
                                                     TypeManager typeManager) throws UaSerializationException {

        return encodeAsXmlElement(object, encodingTypeId, DataTypeEncoding.OPC_UA, typeManager);
    }

    public static ExtensionObject encodeAsXmlElement(Object object,
                                                     NodeId encodingTypeId,
                                                     DataTypeEncoding context) throws UaSerializationException {

        return encodeAsXmlElement(object, encodingTypeId, context, TypeManager.BUILTIN);
    }

    public static ExtensionObject encodeAsXmlElement(Object object,
                                                     NodeId encodingTypeId,
                                                     DataTypeEncoding context,
                                                     TypeManager typeManager) throws UaSerializationException {

        XmlElement encoded = context.encodeToXmlElement(object, encodingTypeId, typeManager);

        return new ExtensionObject(encoded, encodingTypeId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtensionObject that = (ExtensionObject) o;

        return Objects.equal(encoded, that.encoded) &&
            Objects.equal(encodingTypeId, that.encodingTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(encoded, encodingTypeId);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("encoded", encoded)
            .add("encodingTypeId", encodingTypeId)
            .toString();
    }

}
