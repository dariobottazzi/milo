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

import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

public interface TypeDictionary {

    /**
     * @return the namespace URI this {@link TypeDictionary} belongs to.
     */
    String getNamespaceUri();

    /**
     * Link the codec for an encoding id or type name.
     * <p>
     * If a {@link OpcBinaryTypeCodec} is registered for either the encodingId or the typeName then it will be
     * registered to both after this call.
     *
     * @param encodingId the binary encoding id.
     * @param typeName   the type name.
     */
    void linkBinaryCodec(NodeId encodingId, String typeName);

    /**
     * Link the codec for an encoding id or type name.
     * <p>
     * If a {@link OpcXmlTypeCodec} is registered for either the encodingId or the typeName then it will be
     * registered to both after this call.
     *
     * @param encodingId the XML encoding id.
     * @param typeName   the type name.
     */
    void linkXmlCodec(NodeId encodingId, String typeName);

    void registerBinaryCodec(OpcBinaryTypeCodec<?> codec, String typeName);

    void registerBinaryCodec(OpcBinaryTypeCodec<?> codec, String typeName, NodeId binaryEncodingId);

    void registerXmlCodec(OpcXmlTypeCodec<?> codec, String typeName);

    void registerXmlCodec(OpcXmlTypeCodec<?> codec, String typeName, NodeId xmlEncodingId);

    OpcBinaryTypeCodec<?> getBinaryCodec(NodeId encodingId);

    OpcBinaryTypeCodec<?> getBinaryCodec(String typeName);

    OpcXmlTypeCodec<?> getXmlCodec(NodeId encodingId);

    OpcXmlTypeCodec<?> getXmlCodec(String typeName);

}
