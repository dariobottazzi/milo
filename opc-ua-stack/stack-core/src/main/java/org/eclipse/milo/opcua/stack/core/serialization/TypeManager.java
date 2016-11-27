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

import org.eclipse.milo.opcua.stack.core.NamespaceTable;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

public interface TypeManager extends ConcurrentMap<String, TypeDictionary> {

    /**
     * A {@link TypeManager} that only knows about built-in types in the UA namespace http://opcfoundation.org/UA/).
     */
    TypeManager BUILTIN = new OpcUaTypeManager(new NamespaceTable(), OpcUaTypeDictionary.getInstance());

    TypeDictionary getTypeDictionary(String namespaceUri);

    TypeDecoder<?> getDecoder(NodeId encodingId);

    TypeEncoder<?> getEncoder(NodeId encodingId);

    default TypeDecoder<?> getDecoder(String namespaceUri, String typeName) {
        TypeDictionary dictionary = getTypeDictionary(namespaceUri);

        return dictionary != null ? dictionary.getDecoder(typeName) : null;
    }

}
