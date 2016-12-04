///*
// * Copyright (c) 2016 Kevin Herron
// *
// * All rights reserved. This program and the accompanying materials
// * are made available under the terms of the Eclipse Public License v1.0
// * and Eclipse Distribution License v1.0 which accompany this distribution.
// *
// * The Eclipse Public License is available at
// *   http://www.eclipse.org/legal/epl-v10.html
// * and the Eclipse Distribution License is available at
// *   http://www.eclipse.org/org/documents/edl-v10.html.
// */
//
//package org.eclipse.milo.opcua.stack.core.serialization;
//
//import java.util.Arrays;
//import java.util.concurrent.ConcurrentMap;
//import javax.annotation.Nullable;
//
//import com.google.common.collect.ForwardingConcurrentMap;
//import com.google.common.collect.Maps;
//import org.eclipse.milo.opcua.stack.core.NamespaceTable;
//import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
//
//public class OpcUaTypeManager extends ForwardingConcurrentMap<String, TypeDictionary> implements TypeManager {
//
//    private final ConcurrentMap<String, TypeDictionary> typeDictionaries = Maps.newConcurrentMap();
//
//    private final NamespaceTable namespaceTable;
//
//    public OpcUaTypeManager(NamespaceTable namespaceTable) {
//        this(namespaceTable, OpcUaTypeDictionary.getInstance());
//    }
//
//    public OpcUaTypeManager(NamespaceTable namespaceTable, TypeDictionary... dictionaries) {
//        this.namespaceTable = namespaceTable;
//
//        Arrays.stream(dictionaries).forEach(d -> typeDictionaries.put(d.getNamespaceUri(), d));
//    }
//
//    @Override
//    protected ConcurrentMap<String, TypeDictionary> delegate() {
//        return typeDictionaries;
//    }
//
//    @Nullable
//    @Override
//    public TypeDictionary getTypeDictionary(String namespaceUri) {
//        return typeDictionaries.get(namespaceUri);
//    }
//
//    @Nullable
//    @Override
//    public TypeDecoder<?> getDecoder(NodeId encodingId) {
//        String uri = namespaceTable.getUri(encodingId.getNamespaceIndex());
//
//        TypeDictionary dictionary = typeDictionaries.get(uri);
//
//        return dictionary != null ? dictionary.getDecoder(encodingId) : null;
//    }
//
//    @Nullable
//    @Override
//    public TypeEncoder<?> getEncoder(NodeId encodingId) {
//        String uri = namespaceTable.getUri(encodingId.getNamespaceIndex());
//
//        TypeDictionary dictionary = typeDictionaries.get(uri);
//
//        return dictionary != null ? dictionary.getEncoder(encodingId) : null;
//    }
//
//}
