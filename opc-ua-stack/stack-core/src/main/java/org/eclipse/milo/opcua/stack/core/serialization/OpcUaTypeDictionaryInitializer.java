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

import org.eclipse.milo.opcua.stack.core.types.structured.Argument;

/**
 * Registers the encoders and decoders for all the built-in enumerations and structures with
 * {@link OpcUaTypeDictionary}.
 * <p>
 * This class is semi-auto-generated; if the UA spec version changes and adds or removes structures these methods will
 * need to be updated.
 */
class OpcUaTypeDictionaryInitializer {

    static void initialize() {
        initializeStructured();
    }

    private static void initializeStructured() {
        OpcUaTypeDictionary.register(
            "Argument",
            Argument.BinaryEncodingId, new Argument.BinaryCodec(),
            Argument.XmlEncodingId, new Argument.XmlCodec()
        );

    }

}

