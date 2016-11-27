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

import org.eclipse.milo.opcua.stack.core.UaSerializationException;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

public interface TypeDictionary {

    String getNamespaceUri();

    TypeEncoder<?> getEncoder(String typeName) throws UaSerializationException;

    TypeEncoder<?> getEncoder(NodeId encodingId) throws UaSerializationException;

    <T> TypeEncoder<T> getEncoder(Class<T> typeClass) throws UaSerializationException;

    TypeDecoder<?> getDecoder(String typeName) throws UaSerializationException;

    TypeDecoder<?> getDecoder(NodeId encodingId) throws UaSerializationException;

    <T> TypeDecoder<T> getDecoder(Class<T> typeClass) throws UaSerializationException;

}
