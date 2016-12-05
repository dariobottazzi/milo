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

package org.eclipse.milo.opcua.stack.core.types.structured;

import com.google.common.base.MoreObjects;
import org.eclipse.milo.opcua.stack.core.Identifiers;
import org.eclipse.milo.opcua.stack.core.UaSerializationException;
import org.eclipse.milo.opcua.stack.core.serialization.OpcUaTypeDictionary;
import org.eclipse.milo.opcua.stack.core.serialization.UaStructure;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcBinaryStreamReader;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcBinaryStreamWriter;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcBinaryTypeCodec;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcXmlStreamReader;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcXmlStreamWriter;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcXmlTypeCodec;
import org.eclipse.milo.opcua.stack.core.serialization.codec.SerializationContext;
import org.eclipse.milo.opcua.stack.core.types.UaDataType;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;

@UaDataType("MonitoredItemModifyRequest")
public class MonitoredItemModifyRequest implements UaStructure {

    public static final NodeId TypeId = Identifiers.MonitoredItemModifyRequest;
    public static final NodeId BinaryEncodingId = Identifiers.MonitoredItemModifyRequest_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.MonitoredItemModifyRequest_Encoding_DefaultXml;

    protected final UInteger _monitoredItemId;
    protected final MonitoringParameters _requestedParameters;

    public MonitoredItemModifyRequest() {
        this._monitoredItemId = null;
        this._requestedParameters = null;
    }

    public MonitoredItemModifyRequest(UInteger _monitoredItemId, MonitoringParameters _requestedParameters) {
        this._monitoredItemId = _monitoredItemId;
        this._requestedParameters = _requestedParameters;
    }

    public UInteger getMonitoredItemId() { return _monitoredItemId; }

    public MonitoringParameters getRequestedParameters() { return _requestedParameters; }

    @Override
    public NodeId getTypeId() { return TypeId; }

    @Override
    public NodeId getBinaryEncodingId() { return BinaryEncodingId; }

    @Override
    public NodeId getXmlEncodingId() { return XmlEncodingId; }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("MonitoredItemId", _monitoredItemId)
            .add("RequestedParameters", _requestedParameters)
            .toString();
    }

    public static class BinaryCodec implements OpcBinaryTypeCodec<MonitoredItemModifyRequest> {
        @Override
        public MonitoredItemModifyRequest decode(SerializationContext context, OpcBinaryStreamReader reader) throws UaSerializationException {
            UInteger _monitoredItemId = reader.readUInt32();
            MonitoringParameters _requestedParameters = (MonitoringParameters) context.decode(OpcUaTypeDictionary.NAMESPACE_URI, "MonitoringParameters", reader);

            return new MonitoredItemModifyRequest(_monitoredItemId, _requestedParameters);
        }

        @Override
        public void encode(SerializationContext context, MonitoredItemModifyRequest encodable, OpcBinaryStreamWriter writer) throws UaSerializationException {
            writer.writeUInt32(encodable._monitoredItemId);
            context.encode(OpcUaTypeDictionary.NAMESPACE_URI, "MonitoringParameters", encodable._requestedParameters, writer);
        }
    }

    public static class XmlCodec implements OpcXmlTypeCodec<MonitoredItemModifyRequest> {
        @Override
        public MonitoredItemModifyRequest decode(SerializationContext context, OpcXmlStreamReader reader) throws UaSerializationException {
            UInteger _monitoredItemId = reader.readUInt32("MonitoredItemId");
            MonitoringParameters _requestedParameters = (MonitoringParameters) context.decode(OpcUaTypeDictionary.NAMESPACE_URI, "MonitoringParameters", reader);

            return new MonitoredItemModifyRequest(_monitoredItemId, _requestedParameters);
        }

        @Override
        public void encode(SerializationContext context, MonitoredItemModifyRequest encodable, OpcXmlStreamWriter writer) throws UaSerializationException {
            writer.writeUInt32("MonitoredItemId", encodable._monitoredItemId);
            context.encode(OpcUaTypeDictionary.NAMESPACE_URI, "MonitoringParameters", encodable._requestedParameters, writer);
        }
    }

}
