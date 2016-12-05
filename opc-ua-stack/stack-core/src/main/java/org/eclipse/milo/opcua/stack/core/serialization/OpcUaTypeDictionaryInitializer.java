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

import org.eclipse.milo.opcua.stack.core.types.structured.ActivateSessionRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.ActivateSessionResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.AddNodesItem;
import org.eclipse.milo.opcua.stack.core.types.structured.AddNodesRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.AddNodesResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.AddNodesResult;
import org.eclipse.milo.opcua.stack.core.types.structured.AddReferencesItem;
import org.eclipse.milo.opcua.stack.core.types.structured.AddReferencesRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.AddReferencesResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.AggregateConfiguration;
import org.eclipse.milo.opcua.stack.core.types.structured.AggregateFilter;
import org.eclipse.milo.opcua.stack.core.types.structured.AggregateFilterResult;
import org.eclipse.milo.opcua.stack.core.types.structured.Annotation;
import org.eclipse.milo.opcua.stack.core.types.structured.AnonymousIdentityToken;
import org.eclipse.milo.opcua.stack.core.types.structured.ApplicationDescription;
import org.eclipse.milo.opcua.stack.core.types.structured.Argument;
import org.eclipse.milo.opcua.stack.core.types.structured.AttributeOperand;
import org.eclipse.milo.opcua.stack.core.types.structured.AxisInformation;
import org.eclipse.milo.opcua.stack.core.types.structured.BrowseDescription;
import org.eclipse.milo.opcua.stack.core.types.structured.BrowseNextRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.BrowseNextResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.BrowsePath;
import org.eclipse.milo.opcua.stack.core.types.structured.BrowsePathResult;
import org.eclipse.milo.opcua.stack.core.types.structured.BrowsePathTarget;
import org.eclipse.milo.opcua.stack.core.types.structured.BrowseRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.BrowseResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.BrowseResult;
import org.eclipse.milo.opcua.stack.core.types.structured.BuildInfo;
import org.eclipse.milo.opcua.stack.core.types.structured.CallMethodRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.CallMethodResult;
import org.eclipse.milo.opcua.stack.core.types.structured.CallRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.CallResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.CancelRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.CancelResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.ChannelSecurityToken;
import org.eclipse.milo.opcua.stack.core.types.structured.CloseSecureChannelRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.CloseSecureChannelResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.CloseSessionRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.CloseSessionResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.ComplexNumberType;
import org.eclipse.milo.opcua.stack.core.types.structured.ContentFilter;
import org.eclipse.milo.opcua.stack.core.types.structured.ContentFilterElement;
import org.eclipse.milo.opcua.stack.core.types.structured.ContentFilterElementResult;
import org.eclipse.milo.opcua.stack.core.types.structured.ContentFilterResult;
import org.eclipse.milo.opcua.stack.core.types.structured.CreateMonitoredItemsRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.CreateMonitoredItemsResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.CreateSessionRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.CreateSessionResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.CreateSubscriptionRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.CreateSubscriptionResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.DataChangeFilter;
import org.eclipse.milo.opcua.stack.core.types.structured.DataChangeNotification;
import org.eclipse.milo.opcua.stack.core.types.structured.DataTypeAttributes;
import org.eclipse.milo.opcua.stack.core.types.structured.DataTypeNode;
import org.eclipse.milo.opcua.stack.core.types.structured.DeleteAtTimeDetails;
import org.eclipse.milo.opcua.stack.core.types.structured.DeleteEventDetails;
import org.eclipse.milo.opcua.stack.core.types.structured.DeleteMonitoredItemsRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.DeleteMonitoredItemsResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.DeleteNodesItem;
import org.eclipse.milo.opcua.stack.core.types.structured.DeleteNodesRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.DeleteNodesResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.DeleteRawModifiedDetails;
import org.eclipse.milo.opcua.stack.core.types.structured.DeleteReferencesItem;
import org.eclipse.milo.opcua.stack.core.types.structured.DeleteReferencesRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.DeleteReferencesResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.DeleteSubscriptionsRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.DeleteSubscriptionsResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.DiscoveryConfiguration;
import org.eclipse.milo.opcua.stack.core.types.structured.DoubleComplexNumberType;
import org.eclipse.milo.opcua.stack.core.types.structured.EUInformation;
import org.eclipse.milo.opcua.stack.core.types.structured.ElementOperand;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointConfiguration;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointUrlListDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.EnumValueType;
import org.eclipse.milo.opcua.stack.core.types.structured.EventFieldList;
import org.eclipse.milo.opcua.stack.core.types.structured.EventFilter;
import org.eclipse.milo.opcua.stack.core.types.structured.EventFilterResult;
import org.eclipse.milo.opcua.stack.core.types.structured.EventNotificationList;
import org.eclipse.milo.opcua.stack.core.types.structured.FilterOperand;
import org.eclipse.milo.opcua.stack.core.types.structured.FindServersOnNetworkRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.FindServersOnNetworkResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.FindServersRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.FindServersResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.GetEndpointsRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.GetEndpointsResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryData;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryEvent;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryEventFieldList;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryModifiedData;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryReadDetails;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryReadRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryReadResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryReadResult;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryReadValueId;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryUpdateDetails;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryUpdateRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryUpdateResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.HistoryUpdateResult;
import org.eclipse.milo.opcua.stack.core.types.structured.InstanceNode;
import org.eclipse.milo.opcua.stack.core.types.structured.IssuedIdentityToken;
import org.eclipse.milo.opcua.stack.core.types.structured.KerberosIdentityToken;
import org.eclipse.milo.opcua.stack.core.types.structured.LiteralOperand;
import org.eclipse.milo.opcua.stack.core.types.structured.MdnsDiscoveryConfiguration;
import org.eclipse.milo.opcua.stack.core.types.structured.MethodAttributes;
import org.eclipse.milo.opcua.stack.core.types.structured.MethodNode;
import org.eclipse.milo.opcua.stack.core.types.structured.ModelChangeStructureDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.ModificationInfo;
import org.eclipse.milo.opcua.stack.core.types.structured.ModifyMonitoredItemsRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.ModifyMonitoredItemsResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.ModifySubscriptionRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.ModifySubscriptionResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoredItemCreateRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoredItemCreateResult;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoredItemModifyRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoredItemModifyResult;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoredItemNotification;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoringFilter;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoringFilterResult;
import org.eclipse.milo.opcua.stack.core.types.structured.MonitoringParameters;
import org.eclipse.milo.opcua.stack.core.types.structured.NetworkGroupDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.Node;
import org.eclipse.milo.opcua.stack.core.types.structured.NodeAttributes;
import org.eclipse.milo.opcua.stack.core.types.structured.NodeReference;
import org.eclipse.milo.opcua.stack.core.types.structured.NodeTypeDescription;
import org.eclipse.milo.opcua.stack.core.types.structured.NotificationData;
import org.eclipse.milo.opcua.stack.core.types.structured.NotificationMessage;
import org.eclipse.milo.opcua.stack.core.types.structured.ObjectAttributes;
import org.eclipse.milo.opcua.stack.core.types.structured.ObjectNode;
import org.eclipse.milo.opcua.stack.core.types.structured.ObjectTypeAttributes;
import org.eclipse.milo.opcua.stack.core.types.structured.ObjectTypeNode;
import org.eclipse.milo.opcua.stack.core.types.structured.OpenSecureChannelRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.OpenSecureChannelResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.OptionSet;
import org.eclipse.milo.opcua.stack.core.types.structured.ParsingResult;
import org.eclipse.milo.opcua.stack.core.types.structured.ProgramDiagnosticDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.PublishRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.PublishResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.QueryDataDescription;
import org.eclipse.milo.opcua.stack.core.types.structured.QueryDataSet;
import org.eclipse.milo.opcua.stack.core.types.structured.QueryFirstRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.QueryFirstResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.QueryNextRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.QueryNextResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.Range;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadAtTimeDetails;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadEventDetails;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadProcessedDetails;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadRawModifiedDetails;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadValueId;
import org.eclipse.milo.opcua.stack.core.types.structured.RedundantServerDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.ReferenceDescription;
import org.eclipse.milo.opcua.stack.core.types.structured.ReferenceNode;
import org.eclipse.milo.opcua.stack.core.types.structured.ReferenceTypeAttributes;
import org.eclipse.milo.opcua.stack.core.types.structured.ReferenceTypeNode;
import org.eclipse.milo.opcua.stack.core.types.structured.RegisterNodesRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.RegisterNodesResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.RegisterServer2Request;
import org.eclipse.milo.opcua.stack.core.types.structured.RegisterServer2Response;
import org.eclipse.milo.opcua.stack.core.types.structured.RegisterServerRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.RegisterServerResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.RegisteredServer;
import org.eclipse.milo.opcua.stack.core.types.structured.RelativePath;
import org.eclipse.milo.opcua.stack.core.types.structured.RelativePathElement;
import org.eclipse.milo.opcua.stack.core.types.structured.RepublishRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.RepublishResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.RequestHeader;
import org.eclipse.milo.opcua.stack.core.types.structured.ResponseHeader;
import org.eclipse.milo.opcua.stack.core.types.structured.SamplingIntervalDiagnosticsDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.SemanticChangeStructureDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.ServerDiagnosticsSummaryDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.ServerOnNetwork;
import org.eclipse.milo.opcua.stack.core.types.structured.ServerStatusDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.ServiceCounterDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.ServiceFault;
import org.eclipse.milo.opcua.stack.core.types.structured.SessionDiagnosticsDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.SessionSecurityDiagnosticsDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.SetMonitoringModeRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.SetMonitoringModeResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.SetPublishingModeRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.SetPublishingModeResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.SetTriggeringRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.SetTriggeringResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.SignatureData;
import org.eclipse.milo.opcua.stack.core.types.structured.SignedSoftwareCertificate;
import org.eclipse.milo.opcua.stack.core.types.structured.SimpleAttributeOperand;
import org.eclipse.milo.opcua.stack.core.types.structured.SoftwareCertificate;
import org.eclipse.milo.opcua.stack.core.types.structured.StatusChangeNotification;
import org.eclipse.milo.opcua.stack.core.types.structured.StatusResult;
import org.eclipse.milo.opcua.stack.core.types.structured.SubscriptionAcknowledgement;
import org.eclipse.milo.opcua.stack.core.types.structured.SubscriptionDiagnosticsDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.SupportedProfile;
import org.eclipse.milo.opcua.stack.core.types.structured.TimeZoneDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.TransferResult;
import org.eclipse.milo.opcua.stack.core.types.structured.TransferSubscriptionsRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.TransferSubscriptionsResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.TranslateBrowsePathsToNodeIdsRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.TranslateBrowsePathsToNodeIdsResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.TrustListDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.TypeNode;
import org.eclipse.milo.opcua.stack.core.types.structured.Union;
import org.eclipse.milo.opcua.stack.core.types.structured.UnregisterNodesRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.UnregisterNodesResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.UpdateDataDetails;
import org.eclipse.milo.opcua.stack.core.types.structured.UpdateEventDetails;
import org.eclipse.milo.opcua.stack.core.types.structured.UpdateStructureDataDetails;
import org.eclipse.milo.opcua.stack.core.types.structured.UserIdentityToken;
import org.eclipse.milo.opcua.stack.core.types.structured.UserNameIdentityToken;
import org.eclipse.milo.opcua.stack.core.types.structured.UserTokenPolicy;
import org.eclipse.milo.opcua.stack.core.types.structured.VariableAttributes;
import org.eclipse.milo.opcua.stack.core.types.structured.VariableNode;
import org.eclipse.milo.opcua.stack.core.types.structured.VariableTypeAttributes;
import org.eclipse.milo.opcua.stack.core.types.structured.VariableTypeNode;
import org.eclipse.milo.opcua.stack.core.types.structured.ViewAttributes;
import org.eclipse.milo.opcua.stack.core.types.structured.ViewDescription;
import org.eclipse.milo.opcua.stack.core.types.structured.ViewNode;
import org.eclipse.milo.opcua.stack.core.types.structured.WriteRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.WriteResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.WriteValue;
import org.eclipse.milo.opcua.stack.core.types.structured.X509IdentityToken;
import org.eclipse.milo.opcua.stack.core.types.structured.XVType;

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
            "ActivateSessionRequest",
            ActivateSessionRequest.BinaryEncodingId,
            new ActivateSessionRequest.BinaryCodec(),
            ActivateSessionRequest.XmlEncodingId,
            new ActivateSessionRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ActivateSessionResponse",
            ActivateSessionResponse.BinaryEncodingId,
            new ActivateSessionResponse.BinaryCodec(),
            ActivateSessionResponse.XmlEncodingId,
            new ActivateSessionResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "AddNodesRequest",
            AddNodesRequest.BinaryEncodingId,
            new AddNodesRequest.BinaryCodec(),
            AddNodesRequest.XmlEncodingId,
            new AddNodesRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "AddNodesResult",
            AddNodesResult.BinaryEncodingId,
            new AddNodesResult.BinaryCodec(),
            AddNodesResult.XmlEncodingId,
            new AddNodesResult.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "AddReferencesRequest",
            AddReferencesRequest.BinaryEncodingId,
            new AddReferencesRequest.BinaryCodec(),
            AddReferencesRequest.XmlEncodingId,
            new AddReferencesRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "AggregateConfiguration",
            AggregateConfiguration.BinaryEncodingId,
            new AggregateConfiguration.BinaryCodec(),
            AggregateConfiguration.XmlEncodingId,
            new AggregateConfiguration.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "AggregateFilter",
            AggregateFilter.BinaryEncodingId,
            new AggregateFilter.BinaryCodec(),
            AggregateFilter.XmlEncodingId,
            new AggregateFilter.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "Annotation",
            Annotation.BinaryEncodingId,
            new Annotation.BinaryCodec(),
            Annotation.XmlEncodingId,
            new Annotation.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ApplicationDescription",
            ApplicationDescription.BinaryEncodingId,
            new ApplicationDescription.BinaryCodec(),
            ApplicationDescription.XmlEncodingId,
            new ApplicationDescription.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "AxisInformation",
            AxisInformation.BinaryEncodingId,
            new AxisInformation.BinaryCodec(),
            AxisInformation.XmlEncodingId,
            new AxisInformation.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "BrowseDescription",
            BrowseDescription.BinaryEncodingId,
            new BrowseDescription.BinaryCodec(),
            BrowseDescription.XmlEncodingId,
            new BrowseDescription.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "BrowsePath",
            BrowsePath.BinaryEncodingId,
            new BrowsePath.BinaryCodec(),
            BrowsePath.XmlEncodingId,
            new BrowsePath.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "BrowseRequest",
            BrowseRequest.BinaryEncodingId,
            new BrowseRequest.BinaryCodec(),
            BrowseRequest.XmlEncodingId,
            new BrowseRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "BuildInfo",
            BuildInfo.BinaryEncodingId,
            new BuildInfo.BinaryCodec(),
            BuildInfo.XmlEncodingId,
            new BuildInfo.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "CallRequest",
            CallRequest.BinaryEncodingId,
            new CallRequest.BinaryCodec(),
            CallRequest.XmlEncodingId,
            new CallRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "CancelResponse",
            CancelResponse.BinaryEncodingId,
            new CancelResponse.BinaryCodec(),
            CancelResponse.XmlEncodingId,
            new CancelResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "CloseSecureChannelResponse",
            CloseSecureChannelResponse.BinaryEncodingId,
            new CloseSecureChannelResponse.BinaryCodec(),
            CloseSecureChannelResponse.XmlEncodingId,
            new CloseSecureChannelResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ComplexNumberType",
            ComplexNumberType.BinaryEncodingId,
            new ComplexNumberType.BinaryCodec(),
            ComplexNumberType.XmlEncodingId,
            new ComplexNumberType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ContentFilter",
            ContentFilter.BinaryEncodingId,
            new ContentFilter.BinaryCodec(),
            ContentFilter.XmlEncodingId,
            new ContentFilter.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ContentFilterElement",
            ContentFilterElement.BinaryEncodingId,
            new ContentFilterElement.BinaryCodec(),
            ContentFilterElement.XmlEncodingId,
            new ContentFilterElement.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ContentFilterElementResult",
            ContentFilterElementResult.BinaryEncodingId,
            new ContentFilterElementResult.BinaryCodec(),
            ContentFilterElementResult.XmlEncodingId,
            new ContentFilterElementResult.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ContentFilterResult",
            ContentFilterResult.BinaryEncodingId,
            new ContentFilterResult.BinaryCodec(),
            ContentFilterResult.XmlEncodingId,
            new ContentFilterResult.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "CreateMonitoredItemsRequest",
            CreateMonitoredItemsRequest.BinaryEncodingId,
            new CreateMonitoredItemsRequest.BinaryCodec(),
            CreateMonitoredItemsRequest.XmlEncodingId,
            new CreateMonitoredItemsRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "CreateMonitoredItemsResponse",
            CreateMonitoredItemsResponse.BinaryEncodingId,
            new CreateMonitoredItemsResponse.BinaryCodec(),
            CreateMonitoredItemsResponse.XmlEncodingId,
            new CreateMonitoredItemsResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "CreateSessionRequest",
            CreateSessionRequest.BinaryEncodingId,
            new CreateSessionRequest.BinaryCodec(),
            CreateSessionRequest.XmlEncodingId,
            new CreateSessionRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "CreateSessionResponse",
            CreateSessionResponse.BinaryEncodingId,
            new CreateSessionResponse.BinaryCodec(),
            CreateSessionResponse.XmlEncodingId,
            new CreateSessionResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "CreateSubscriptionRequest",
            CreateSubscriptionRequest.BinaryEncodingId,
            new CreateSubscriptionRequest.BinaryCodec(),
            CreateSubscriptionRequest.XmlEncodingId,
            new CreateSubscriptionRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "CreateSubscriptionResponse",
            CreateSubscriptionResponse.BinaryEncodingId,
            new CreateSubscriptionResponse.BinaryCodec(),
            CreateSubscriptionResponse.XmlEncodingId,
            new CreateSubscriptionResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DataChangeFilter",
            DataChangeFilter.BinaryEncodingId,
            new DataChangeFilter.BinaryCodec(),
            DataChangeFilter.XmlEncodingId,
            new DataChangeFilter.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DataChangeNotification",
            DataChangeNotification.BinaryEncodingId,
            new DataChangeNotification.BinaryCodec(),
            DataChangeNotification.XmlEncodingId,
            new DataChangeNotification.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DataTypeAttributes",
            DataTypeAttributes.BinaryEncodingId,
            new DataTypeAttributes.BinaryCodec(),
            DataTypeAttributes.XmlEncodingId,
            new DataTypeAttributes.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DataTypeNode",
            DataTypeNode.BinaryEncodingId,
            new DataTypeNode.BinaryCodec(),
            DataTypeNode.XmlEncodingId,
            new DataTypeNode.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DeleteAtTimeDetails",
            DeleteAtTimeDetails.BinaryEncodingId,
            new DeleteAtTimeDetails.BinaryCodec(),
            DeleteAtTimeDetails.XmlEncodingId,
            new DeleteAtTimeDetails.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DeleteEventDetails",
            DeleteEventDetails.BinaryEncodingId,
            new DeleteEventDetails.BinaryCodec(),
            DeleteEventDetails.XmlEncodingId,
            new DeleteEventDetails.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DeleteMonitoredItemsRequest",
            DeleteMonitoredItemsRequest.BinaryEncodingId,
            new DeleteMonitoredItemsRequest.BinaryCodec(),
            DeleteMonitoredItemsRequest.XmlEncodingId,
            new DeleteMonitoredItemsRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DeleteMonitoredItemsResponse",
            DeleteMonitoredItemsResponse.BinaryEncodingId,
            new DeleteMonitoredItemsResponse.BinaryCodec(),
            DeleteMonitoredItemsResponse.XmlEncodingId,
            new DeleteMonitoredItemsResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DeleteNodesItem",
            DeleteNodesItem.BinaryEncodingId,
            new DeleteNodesItem.BinaryCodec(),
            DeleteNodesItem.XmlEncodingId,
            new DeleteNodesItem.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DeleteNodesResponse",
            DeleteNodesResponse.BinaryEncodingId,
            new DeleteNodesResponse.BinaryCodec(),
            DeleteNodesResponse.XmlEncodingId,
            new DeleteNodesResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DeleteRawModifiedDetails",
            DeleteRawModifiedDetails.BinaryEncodingId,
            new DeleteRawModifiedDetails.BinaryCodec(),
            DeleteRawModifiedDetails.XmlEncodingId,
            new DeleteRawModifiedDetails.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DeleteReferencesItem",
            DeleteReferencesItem.BinaryEncodingId,
            new DeleteReferencesItem.BinaryCodec(),
            DeleteReferencesItem.XmlEncodingId,
            new DeleteReferencesItem.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DeleteReferencesResponse",
            DeleteReferencesResponse.BinaryEncodingId,
            new DeleteReferencesResponse.BinaryCodec(),
            DeleteReferencesResponse.XmlEncodingId,
            new DeleteReferencesResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DeleteSubscriptionsResponse",
            DeleteSubscriptionsResponse.BinaryEncodingId,
            new DeleteSubscriptionsResponse.BinaryCodec(),
            DeleteSubscriptionsResponse.XmlEncodingId,
            new DeleteSubscriptionsResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DiscoveryConfiguration",
            DiscoveryConfiguration.BinaryEncodingId,
            new DiscoveryConfiguration.BinaryCodec(),
            DiscoveryConfiguration.XmlEncodingId,
            new DiscoveryConfiguration.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DoubleComplexNumberType",
            DoubleComplexNumberType.BinaryEncodingId,
            new DoubleComplexNumberType.BinaryCodec(),
            DoubleComplexNumberType.XmlEncodingId,
            new DoubleComplexNumberType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ElementOperand",
            ElementOperand.BinaryEncodingId,
            new ElementOperand.BinaryCodec(),
            ElementOperand.XmlEncodingId,
            new ElementOperand.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "EndpointConfiguration",
            EndpointConfiguration.BinaryEncodingId,
            new EndpointConfiguration.BinaryCodec(),
            EndpointConfiguration.XmlEncodingId,
            new EndpointConfiguration.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "EndpointDescription",
            EndpointDescription.BinaryEncodingId,
            new EndpointDescription.BinaryCodec(),
            EndpointDescription.XmlEncodingId,
            new EndpointDescription.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "EndpointUrlListDataType",
            EndpointUrlListDataType.BinaryEncodingId,
            new EndpointUrlListDataType.BinaryCodec(),
            EndpointUrlListDataType.XmlEncodingId,
            new EndpointUrlListDataType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "EnumValueType",
            EnumValueType.BinaryEncodingId,
            new EnumValueType.BinaryCodec(),
            EnumValueType.XmlEncodingId,
            new EnumValueType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "EUInformation",
            EUInformation.BinaryEncodingId,
            new EUInformation.BinaryCodec(),
            EUInformation.XmlEncodingId,
            new EUInformation.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "EventFieldList",
            EventFieldList.BinaryEncodingId,
            new EventFieldList.BinaryCodec(),
            EventFieldList.XmlEncodingId,
            new EventFieldList.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "EventFilterResult",
            EventFilterResult.BinaryEncodingId,
            new EventFilterResult.BinaryCodec(),
            EventFilterResult.XmlEncodingId,
            new EventFilterResult.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "FilterOperand",
            FilterOperand.BinaryEncodingId,
            new FilterOperand.BinaryCodec(),
            FilterOperand.XmlEncodingId,
            new FilterOperand.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "FindServersOnNetworkResponse",
            FindServersOnNetworkResponse.BinaryEncodingId,
            new FindServersOnNetworkResponse.BinaryCodec(),
            FindServersOnNetworkResponse.XmlEncodingId,
            new FindServersOnNetworkResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "FindServersResponse",
            FindServersResponse.BinaryEncodingId,
            new FindServersResponse.BinaryCodec(),
            FindServersResponse.XmlEncodingId,
            new FindServersResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "GetEndpointsResponse",
            GetEndpointsResponse.BinaryEncodingId,
            new GetEndpointsResponse.BinaryCodec(),
            GetEndpointsResponse.XmlEncodingId,
            new GetEndpointsResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "HistoryEvent",
            HistoryEvent.BinaryEncodingId,
            new HistoryEvent.BinaryCodec(),
            HistoryEvent.XmlEncodingId,
            new HistoryEvent.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "HistoryModifiedData",
            HistoryModifiedData.BinaryEncodingId,
            new HistoryModifiedData.BinaryCodec(),
            HistoryModifiedData.XmlEncodingId,
            new HistoryModifiedData.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "HistoryReadRequest",
            HistoryReadRequest.BinaryEncodingId,
            new HistoryReadRequest.BinaryCodec(),
            HistoryReadRequest.XmlEncodingId,
            new HistoryReadRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "HistoryReadResponse",
            HistoryReadResponse.BinaryEncodingId,
            new HistoryReadResponse.BinaryCodec(),
            HistoryReadResponse.XmlEncodingId,
            new HistoryReadResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "HistoryReadResult",
            HistoryReadResult.BinaryEncodingId,
            new HistoryReadResult.BinaryCodec(),
            HistoryReadResult.XmlEncodingId,
            new HistoryReadResult.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "HistoryReadValueId",
            HistoryReadValueId.BinaryEncodingId,
            new HistoryReadValueId.BinaryCodec(),
            HistoryReadValueId.XmlEncodingId,
            new HistoryReadValueId.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "HistoryUpdateDetails",
            HistoryUpdateDetails.BinaryEncodingId,
            new HistoryUpdateDetails.BinaryCodec(),
            HistoryUpdateDetails.XmlEncodingId,
            new HistoryUpdateDetails.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "HistoryUpdateRequest",
            HistoryUpdateRequest.BinaryEncodingId,
            new HistoryUpdateRequest.BinaryCodec(),
            HistoryUpdateRequest.XmlEncodingId,
            new HistoryUpdateRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "HistoryUpdateResponse",
            HistoryUpdateResponse.BinaryEncodingId,
            new HistoryUpdateResponse.BinaryCodec(),
            HistoryUpdateResponse.XmlEncodingId,
            new HistoryUpdateResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "RelativePathElement",
            RelativePathElement.BinaryEncodingId,
            new RelativePathElement.BinaryCodec(),
            RelativePathElement.XmlEncodingId,
            new RelativePathElement.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ResponseHeader",
            ResponseHeader.BinaryEncodingId,
            new ResponseHeader.BinaryCodec(),
            ResponseHeader.XmlEncodingId,
            new ResponseHeader.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SessionSecurityDiagnosticsDataType",
            SessionSecurityDiagnosticsDataType.BinaryEncodingId,
            new SessionSecurityDiagnosticsDataType.BinaryCodec(),
            SessionSecurityDiagnosticsDataType.XmlEncodingId,
            new SessionSecurityDiagnosticsDataType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SetMonitoringModeRequest",
            SetMonitoringModeRequest.BinaryEncodingId,
            new SetMonitoringModeRequest.BinaryCodec(),
            SetMonitoringModeRequest.XmlEncodingId,
            new SetMonitoringModeRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SetPublishingModeRequest",
            SetPublishingModeRequest.BinaryEncodingId,
            new SetPublishingModeRequest.BinaryCodec(),
            SetPublishingModeRequest.XmlEncodingId,
            new SetPublishingModeRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SetTriggeringRequest",
            SetTriggeringRequest.BinaryEncodingId,
            new SetTriggeringRequest.BinaryCodec(),
            SetTriggeringRequest.XmlEncodingId,
            new SetTriggeringRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SignatureData",
            SignatureData.BinaryEncodingId,
            new SignatureData.BinaryCodec(),
            SignatureData.XmlEncodingId,
            new SignatureData.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SimpleAttributeOperand",
            SimpleAttributeOperand.BinaryEncodingId,
            new SimpleAttributeOperand.BinaryCodec(),
            SimpleAttributeOperand.XmlEncodingId,
            new SimpleAttributeOperand.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "StatusChangeNotification",
            StatusChangeNotification.BinaryEncodingId,
            new StatusChangeNotification.BinaryCodec(),
            StatusChangeNotification.XmlEncodingId,
            new StatusChangeNotification.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "TransferSubscriptionsResponse",
            TransferSubscriptionsResponse.BinaryEncodingId,
            new TransferSubscriptionsResponse.BinaryCodec(),
            TransferSubscriptionsResponse.XmlEncodingId,
            new TransferSubscriptionsResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "TypeNode",
            TypeNode.BinaryEncodingId,
            new TypeNode.BinaryCodec(),
            TypeNode.XmlEncodingId,
            new TypeNode.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "UpdateStructureDataDetails",
            UpdateStructureDataDetails.BinaryEncodingId,
            new UpdateStructureDataDetails.BinaryCodec(),
            UpdateStructureDataDetails.XmlEncodingId,
            new UpdateStructureDataDetails.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "AddNodesItem",
            AddNodesItem.BinaryEncodingId,
            new AddNodesItem.BinaryCodec(),
            AddNodesItem.XmlEncodingId,
            new AddNodesItem.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "BrowseNextRequest",
            BrowseNextRequest.BinaryEncodingId,
            new BrowseNextRequest.BinaryCodec(),
            BrowseNextRequest.XmlEncodingId,
            new BrowseNextRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "BrowsePathResult",
            BrowsePathResult.BinaryEncodingId,
            new BrowsePathResult.BinaryCodec(),
            BrowsePathResult.XmlEncodingId,
            new BrowsePathResult.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "BrowseResponse",
            BrowseResponse.BinaryEncodingId,
            new BrowseResponse.BinaryCodec(),
            BrowseResponse.XmlEncodingId,
            new BrowseResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "CallMethodRequest",
            CallMethodRequest.BinaryEncodingId,
            new CallMethodRequest.BinaryCodec(),
            CallMethodRequest.XmlEncodingId,
            new CallMethodRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "CallResponse",
            CallResponse.BinaryEncodingId,
            new CallResponse.BinaryCodec(),
            CallResponse.XmlEncodingId,
            new CallResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ChannelSecurityToken",
            ChannelSecurityToken.BinaryEncodingId,
            new ChannelSecurityToken.BinaryCodec(),
            ChannelSecurityToken.XmlEncodingId,
            new ChannelSecurityToken.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "CloseSessionRequest",
            CloseSessionRequest.BinaryEncodingId,
            new CloseSessionRequest.BinaryCodec(),
            CloseSessionRequest.XmlEncodingId,
            new CloseSessionRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "Node",
            Node.BinaryEncodingId,
            new Node.BinaryCodec(),
            Node.XmlEncodingId,
            new Node.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "RepublishRequest",
            RepublishRequest.BinaryEncodingId,
            new RepublishRequest.BinaryCodec(),
            RepublishRequest.XmlEncodingId,
            new RepublishRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SamplingIntervalDiagnosticsDataType",
            SamplingIntervalDiagnosticsDataType.BinaryEncodingId,
            new SamplingIntervalDiagnosticsDataType.BinaryCodec(),
            SamplingIntervalDiagnosticsDataType.XmlEncodingId,
            new SamplingIntervalDiagnosticsDataType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "StatusResult",
            StatusResult.BinaryEncodingId,
            new StatusResult.BinaryCodec(),
            StatusResult.XmlEncodingId,
            new StatusResult.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SubscriptionAcknowledgement",
            SubscriptionAcknowledgement.BinaryEncodingId,
            new SubscriptionAcknowledgement.BinaryCodec(),
            SubscriptionAcknowledgement.XmlEncodingId,
            new SubscriptionAcknowledgement.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SubscriptionDiagnosticsDataType",
            SubscriptionDiagnosticsDataType.BinaryEncodingId,
            new SubscriptionDiagnosticsDataType.BinaryCodec(),
            SubscriptionDiagnosticsDataType.XmlEncodingId,
            new SubscriptionDiagnosticsDataType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "TimeZoneDataType",
            TimeZoneDataType.BinaryEncodingId,
            new TimeZoneDataType.BinaryCodec(),
            TimeZoneDataType.XmlEncodingId,
            new TimeZoneDataType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "TransferResult",
            TransferResult.BinaryEncodingId,
            new TransferResult.BinaryCodec(),
            TransferResult.XmlEncodingId,
            new TransferResult.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "TranslateBrowsePathsToNodeIdsRequest",
            TranslateBrowsePathsToNodeIdsRequest.BinaryEncodingId,
            new TranslateBrowsePathsToNodeIdsRequest.BinaryCodec(),
            TranslateBrowsePathsToNodeIdsRequest.XmlEncodingId,
            new TranslateBrowsePathsToNodeIdsRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "Union",
            Union.BinaryEncodingId,
            new Union.BinaryCodec(),
            Union.XmlEncodingId,
            new Union.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "UnregisterNodesRequest",
            UnregisterNodesRequest.BinaryEncodingId,
            new UnregisterNodesRequest.BinaryCodec(),
            UnregisterNodesRequest.XmlEncodingId,
            new UnregisterNodesRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DeleteNodesRequest",
            DeleteNodesRequest.BinaryEncodingId,
            new DeleteNodesRequest.BinaryCodec(),
            DeleteNodesRequest.XmlEncodingId,
            new DeleteNodesRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DeleteReferencesRequest",
            DeleteReferencesRequest.BinaryEncodingId,
            new DeleteReferencesRequest.BinaryCodec(),
            DeleteReferencesRequest.XmlEncodingId,
            new DeleteReferencesRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "DeleteSubscriptionsRequest",
            DeleteSubscriptionsRequest.BinaryEncodingId,
            new DeleteSubscriptionsRequest.BinaryCodec(),
            DeleteSubscriptionsRequest.XmlEncodingId,
            new DeleteSubscriptionsRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "EventFilter",
            EventFilter.BinaryEncodingId,
            new EventFilter.BinaryCodec(),
            EventFilter.XmlEncodingId,
            new EventFilter.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "EventNotificationList",
            EventNotificationList.BinaryEncodingId,
            new EventNotificationList.BinaryCodec(),
            EventNotificationList.XmlEncodingId,
            new EventNotificationList.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "FindServersOnNetworkRequest",
            FindServersOnNetworkRequest.BinaryEncodingId,
            new FindServersOnNetworkRequest.BinaryCodec(),
            FindServersOnNetworkRequest.XmlEncodingId,
            new FindServersOnNetworkRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "FindServersRequest",
            FindServersRequest.BinaryEncodingId,
            new FindServersRequest.BinaryCodec(),
            FindServersRequest.XmlEncodingId,
            new FindServersRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "GetEndpointsRequest",
            GetEndpointsRequest.BinaryEncodingId,
            new GetEndpointsRequest.BinaryCodec(),
            GetEndpointsRequest.XmlEncodingId,
            new GetEndpointsRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "HistoryData",
            HistoryData.BinaryEncodingId,
            new HistoryData.BinaryCodec(),
            HistoryData.XmlEncodingId,
            new HistoryData.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "HistoryEventFieldList",
            HistoryEventFieldList.BinaryEncodingId,
            new HistoryEventFieldList.BinaryCodec(),
            HistoryEventFieldList.XmlEncodingId,
            new HistoryEventFieldList.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "HistoryReadDetails",
            HistoryReadDetails.BinaryEncodingId,
            new HistoryReadDetails.BinaryCodec(),
            HistoryReadDetails.XmlEncodingId,
            new HistoryReadDetails.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "HistoryUpdateResult",
            HistoryUpdateResult.BinaryEncodingId,
            new HistoryUpdateResult.BinaryCodec(),
            HistoryUpdateResult.XmlEncodingId,
            new HistoryUpdateResult.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "InstanceNode",
            InstanceNode.BinaryEncodingId,
            new InstanceNode.BinaryCodec(),
            InstanceNode.XmlEncodingId,
            new InstanceNode.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "IssuedIdentityToken",
            IssuedIdentityToken.BinaryEncodingId,
            new IssuedIdentityToken.BinaryCodec(),
            IssuedIdentityToken.XmlEncodingId,
            new IssuedIdentityToken.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "KerberosIdentityToken",
            KerberosIdentityToken.BinaryEncodingId,
            new KerberosIdentityToken.BinaryCodec(),
            KerberosIdentityToken.XmlEncodingId,
            new KerberosIdentityToken.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "LiteralOperand",
            LiteralOperand.BinaryEncodingId,
            new LiteralOperand.BinaryCodec(),
            LiteralOperand.XmlEncodingId,
            new LiteralOperand.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "MdnsDiscoveryConfiguration",
            MdnsDiscoveryConfiguration.BinaryEncodingId,
            new MdnsDiscoveryConfiguration.BinaryCodec(),
            MdnsDiscoveryConfiguration.XmlEncodingId,
            new MdnsDiscoveryConfiguration.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "MethodAttributes",
            MethodAttributes.BinaryEncodingId,
            new MethodAttributes.BinaryCodec(),
            MethodAttributes.XmlEncodingId,
            new MethodAttributes.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "MethodNode",
            MethodNode.BinaryEncodingId,
            new MethodNode.BinaryCodec(),
            MethodNode.XmlEncodingId,
            new MethodNode.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ModelChangeStructureDataType",
            ModelChangeStructureDataType.BinaryEncodingId,
            new ModelChangeStructureDataType.BinaryCodec(),
            ModelChangeStructureDataType.XmlEncodingId,
            new ModelChangeStructureDataType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ModificationInfo",
            ModificationInfo.BinaryEncodingId,
            new ModificationInfo.BinaryCodec(),
            ModificationInfo.XmlEncodingId,
            new ModificationInfo.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ModifyMonitoredItemsRequest",
            ModifyMonitoredItemsRequest.BinaryEncodingId,
            new ModifyMonitoredItemsRequest.BinaryCodec(),
            ModifyMonitoredItemsRequest.XmlEncodingId,
            new ModifyMonitoredItemsRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ModifyMonitoredItemsResponse",
            ModifyMonitoredItemsResponse.BinaryEncodingId,
            new ModifyMonitoredItemsResponse.BinaryCodec(),
            ModifyMonitoredItemsResponse.XmlEncodingId,
            new ModifyMonitoredItemsResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ModifySubscriptionRequest",
            ModifySubscriptionRequest.BinaryEncodingId,
            new ModifySubscriptionRequest.BinaryCodec(),
            ModifySubscriptionRequest.XmlEncodingId,
            new ModifySubscriptionRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ModifySubscriptionResponse",
            ModifySubscriptionResponse.BinaryEncodingId,
            new ModifySubscriptionResponse.BinaryCodec(),
            ModifySubscriptionResponse.XmlEncodingId,
            new ModifySubscriptionResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "MonitoredItemCreateRequest",
            MonitoredItemCreateRequest.BinaryEncodingId,
            new MonitoredItemCreateRequest.BinaryCodec(),
            MonitoredItemCreateRequest.XmlEncodingId,
            new MonitoredItemCreateRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "MonitoredItemCreateResult",
            MonitoredItemCreateResult.BinaryEncodingId,
            new MonitoredItemCreateResult.BinaryCodec(),
            MonitoredItemCreateResult.XmlEncodingId,
            new MonitoredItemCreateResult.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "MonitoredItemModifyRequest",
            MonitoredItemModifyRequest.BinaryEncodingId,
            new MonitoredItemModifyRequest.BinaryCodec(),
            MonitoredItemModifyRequest.XmlEncodingId,
            new MonitoredItemModifyRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "MonitoredItemModifyResult",
            MonitoredItemModifyResult.BinaryEncodingId,
            new MonitoredItemModifyResult.BinaryCodec(),
            MonitoredItemModifyResult.XmlEncodingId,
            new MonitoredItemModifyResult.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "MonitoredItemNotification",
            MonitoredItemNotification.BinaryEncodingId,
            new MonitoredItemNotification.BinaryCodec(),
            MonitoredItemNotification.XmlEncodingId,
            new MonitoredItemNotification.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "MonitoringFilter",
            MonitoringFilter.BinaryEncodingId,
            new MonitoringFilter.BinaryCodec(),
            MonitoringFilter.XmlEncodingId,
            new MonitoringFilter.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "MonitoringFilterResult",
            MonitoringFilterResult.BinaryEncodingId,
            new MonitoringFilterResult.BinaryCodec(),
            MonitoringFilterResult.XmlEncodingId,
            new MonitoringFilterResult.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "MonitoringParameters",
            MonitoringParameters.BinaryEncodingId,
            new MonitoringParameters.BinaryCodec(),
            MonitoringParameters.XmlEncodingId,
            new MonitoringParameters.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "NetworkGroupDataType",
            NetworkGroupDataType.BinaryEncodingId,
            new NetworkGroupDataType.BinaryCodec(),
            NetworkGroupDataType.XmlEncodingId,
            new NetworkGroupDataType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "NodeReference",
            NodeReference.BinaryEncodingId,
            new NodeReference.BinaryCodec(),
            NodeReference.XmlEncodingId,
            new NodeReference.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ObjectNode",
            ObjectNode.BinaryEncodingId,
            new ObjectNode.BinaryCodec(),
            ObjectNode.XmlEncodingId,
            new ObjectNode.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "OpenSecureChannelRequest",
            OpenSecureChannelRequest.BinaryEncodingId,
            new OpenSecureChannelRequest.BinaryCodec(),
            OpenSecureChannelRequest.XmlEncodingId,
            new OpenSecureChannelRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ProgramDiagnosticDataType",
            ProgramDiagnosticDataType.BinaryEncodingId,
            new ProgramDiagnosticDataType.BinaryCodec(),
            ProgramDiagnosticDataType.XmlEncodingId,
            new ProgramDiagnosticDataType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "PublishResponse",
            PublishResponse.BinaryEncodingId,
            new PublishResponse.BinaryCodec(),
            PublishResponse.XmlEncodingId,
            new PublishResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "QueryDataSet",
            QueryDataSet.BinaryEncodingId,
            new QueryDataSet.BinaryCodec(),
            QueryDataSet.XmlEncodingId,
            new QueryDataSet.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "QueryFirstResponse",
            QueryFirstResponse.BinaryEncodingId,
            new QueryFirstResponse.BinaryCodec(),
            QueryFirstResponse.XmlEncodingId,
            new QueryFirstResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ReadAtTimeDetails",
            ReadAtTimeDetails.BinaryEncodingId,
            new ReadAtTimeDetails.BinaryCodec(),
            ReadAtTimeDetails.XmlEncodingId,
            new ReadAtTimeDetails.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ReadProcessedDetails",
            ReadProcessedDetails.BinaryEncodingId,
            new ReadProcessedDetails.BinaryCodec(),
            ReadProcessedDetails.XmlEncodingId,
            new ReadProcessedDetails.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ReadRequest",
            ReadRequest.BinaryEncodingId,
            new ReadRequest.BinaryCodec(),
            ReadRequest.XmlEncodingId,
            new ReadRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ReadValueId",
            ReadValueId.BinaryEncodingId,
            new ReadValueId.BinaryCodec(),
            ReadValueId.XmlEncodingId,
            new ReadValueId.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ReferenceDescription",
            ReferenceDescription.BinaryEncodingId,
            new ReferenceDescription.BinaryCodec(),
            ReferenceDescription.XmlEncodingId,
            new ReferenceDescription.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ReferenceTypeAttributes",
            ReferenceTypeAttributes.BinaryEncodingId,
            new ReferenceTypeAttributes.BinaryCodec(),
            ReferenceTypeAttributes.XmlEncodingId,
            new ReferenceTypeAttributes.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "RegisteredServer",
            RegisteredServer.BinaryEncodingId,
            new RegisteredServer.BinaryCodec(),
            RegisteredServer.XmlEncodingId,
            new RegisteredServer.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "RegisterNodesResponse",
            RegisterNodesResponse.BinaryEncodingId,
            new RegisterNodesResponse.BinaryCodec(),
            RegisterNodesResponse.XmlEncodingId,
            new RegisterNodesResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "RegisterServer2Response",
            RegisterServer2Response.BinaryEncodingId,
            new RegisterServer2Response.BinaryCodec(),
            RegisterServer2Response.XmlEncodingId,
            new RegisterServer2Response.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "RegisterServerResponse",
            RegisterServerResponse.BinaryEncodingId,
            new RegisterServerResponse.BinaryCodec(),
            RegisterServerResponse.XmlEncodingId,
            new RegisterServerResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "RepublishResponse",
            RepublishResponse.BinaryEncodingId,
            new RepublishResponse.BinaryCodec(),
            RepublishResponse.XmlEncodingId,
            new RepublishResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ServerOnNetwork",
            ServerOnNetwork.BinaryEncodingId,
            new ServerOnNetwork.BinaryCodec(),
            ServerOnNetwork.XmlEncodingId,
            new ServerOnNetwork.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ServiceCounterDataType",
            ServiceCounterDataType.BinaryEncodingId,
            new ServiceCounterDataType.BinaryCodec(),
            ServiceCounterDataType.XmlEncodingId,
            new ServiceCounterDataType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SessionDiagnosticsDataType",
            SessionDiagnosticsDataType.BinaryEncodingId,
            new SessionDiagnosticsDataType.BinaryCodec(),
            SessionDiagnosticsDataType.XmlEncodingId,
            new SessionDiagnosticsDataType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SetMonitoringModeResponse",
            SetMonitoringModeResponse.BinaryEncodingId,
            new SetMonitoringModeResponse.BinaryCodec(),
            SetMonitoringModeResponse.XmlEncodingId,
            new SetMonitoringModeResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SetPublishingModeResponse",
            SetPublishingModeResponse.BinaryEncodingId,
            new SetPublishingModeResponse.BinaryCodec(),
            SetPublishingModeResponse.XmlEncodingId,
            new SetPublishingModeResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SetTriggeringResponse",
            SetTriggeringResponse.BinaryEncodingId,
            new SetTriggeringResponse.BinaryCodec(),
            SetTriggeringResponse.XmlEncodingId,
            new SetTriggeringResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SignedSoftwareCertificate",
            SignedSoftwareCertificate.BinaryEncodingId,
            new SignedSoftwareCertificate.BinaryCodec(),
            SignedSoftwareCertificate.XmlEncodingId,
            new SignedSoftwareCertificate.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SoftwareCertificate",
            SoftwareCertificate.BinaryEncodingId,
            new SoftwareCertificate.BinaryCodec(),
            SoftwareCertificate.XmlEncodingId,
            new SoftwareCertificate.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "TransferSubscriptionsRequest",
            TransferSubscriptionsRequest.BinaryEncodingId,
            new TransferSubscriptionsRequest.BinaryCodec(),
            TransferSubscriptionsRequest.XmlEncodingId,
            new TransferSubscriptionsRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "TrustListDataType",
            TrustListDataType.BinaryEncodingId,
            new TrustListDataType.BinaryCodec(),
            TrustListDataType.XmlEncodingId,
            new TrustListDataType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "UnregisterNodesResponse",
            UnregisterNodesResponse.BinaryEncodingId,
            new UnregisterNodesResponse.BinaryCodec(),
            UnregisterNodesResponse.XmlEncodingId,
            new UnregisterNodesResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "UpdateDataDetails",
            UpdateDataDetails.BinaryEncodingId,
            new UpdateDataDetails.BinaryCodec(),
            UpdateDataDetails.XmlEncodingId,
            new UpdateDataDetails.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "UpdateEventDetails",
            UpdateEventDetails.BinaryEncodingId,
            new UpdateEventDetails.BinaryCodec(),
            UpdateEventDetails.XmlEncodingId,
            new UpdateEventDetails.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "UserIdentityToken",
            UserIdentityToken.BinaryEncodingId,
            new UserIdentityToken.BinaryCodec(),
            UserIdentityToken.XmlEncodingId,
            new UserIdentityToken.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "AddNodesResponse",
            AddNodesResponse.BinaryEncodingId,
            new AddNodesResponse.BinaryCodec(),
            AddNodesResponse.XmlEncodingId,
            new AddNodesResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "AddReferencesItem",
            AddReferencesItem.BinaryEncodingId,
            new AddReferencesItem.BinaryCodec(),
            AddReferencesItem.XmlEncodingId,
            new AddReferencesItem.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "AddReferencesResponse",
            AddReferencesResponse.BinaryEncodingId,
            new AddReferencesResponse.BinaryCodec(),
            AddReferencesResponse.XmlEncodingId,
            new AddReferencesResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "AggregateFilterResult",
            AggregateFilterResult.BinaryEncodingId,
            new AggregateFilterResult.BinaryCodec(),
            AggregateFilterResult.XmlEncodingId,
            new AggregateFilterResult.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "AnonymousIdentityToken",
            AnonymousIdentityToken.BinaryEncodingId,
            new AnonymousIdentityToken.BinaryCodec(),
            AnonymousIdentityToken.XmlEncodingId,
            new AnonymousIdentityToken.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "Argument",
            Argument.BinaryEncodingId,
            new Argument.BinaryCodec(),
            Argument.XmlEncodingId,
            new Argument.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "AttributeOperand",
            AttributeOperand.BinaryEncodingId,
            new AttributeOperand.BinaryCodec(),
            AttributeOperand.XmlEncodingId,
            new AttributeOperand.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "BrowseNextResponse",
            BrowseNextResponse.BinaryEncodingId,
            new BrowseNextResponse.BinaryCodec(),
            BrowseNextResponse.XmlEncodingId,
            new BrowseNextResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "BrowsePathTarget",
            BrowsePathTarget.BinaryEncodingId,
            new BrowsePathTarget.BinaryCodec(),
            BrowsePathTarget.XmlEncodingId,
            new BrowsePathTarget.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "BrowseResult",
            BrowseResult.BinaryEncodingId,
            new BrowseResult.BinaryCodec(),
            BrowseResult.XmlEncodingId,
            new BrowseResult.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "CallMethodResult",
            CallMethodResult.BinaryEncodingId,
            new CallMethodResult.BinaryCodec(),
            CallMethodResult.XmlEncodingId,
            new CallMethodResult.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "CancelRequest",
            CancelRequest.BinaryEncodingId,
            new CancelRequest.BinaryCodec(),
            CancelRequest.XmlEncodingId,
            new CancelRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "CloseSecureChannelRequest",
            CloseSecureChannelRequest.BinaryEncodingId,
            new CloseSecureChannelRequest.BinaryCodec(),
            CloseSecureChannelRequest.XmlEncodingId,
            new CloseSecureChannelRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "CloseSessionResponse",
            CloseSessionResponse.BinaryEncodingId,
            new CloseSessionResponse.BinaryCodec(),
            CloseSessionResponse.XmlEncodingId,
            new CloseSessionResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "NodeAttributes",
            NodeAttributes.BinaryEncodingId,
            new NodeAttributes.BinaryCodec(),
            NodeAttributes.XmlEncodingId,
            new NodeAttributes.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "NodeTypeDescription",
            NodeTypeDescription.BinaryEncodingId,
            new NodeTypeDescription.BinaryCodec(),
            NodeTypeDescription.XmlEncodingId,
            new NodeTypeDescription.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "NotificationData",
            NotificationData.BinaryEncodingId,
            new NotificationData.BinaryCodec(),
            NotificationData.XmlEncodingId,
            new NotificationData.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "NotificationMessage",
            NotificationMessage.BinaryEncodingId,
            new NotificationMessage.BinaryCodec(),
            NotificationMessage.XmlEncodingId,
            new NotificationMessage.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ObjectAttributes",
            ObjectAttributes.BinaryEncodingId,
            new ObjectAttributes.BinaryCodec(),
            ObjectAttributes.XmlEncodingId,
            new ObjectAttributes.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ObjectTypeAttributes",
            ObjectTypeAttributes.BinaryEncodingId,
            new ObjectTypeAttributes.BinaryCodec(),
            ObjectTypeAttributes.XmlEncodingId,
            new ObjectTypeAttributes.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ObjectTypeNode",
            ObjectTypeNode.BinaryEncodingId,
            new ObjectTypeNode.BinaryCodec(),
            ObjectTypeNode.XmlEncodingId,
            new ObjectTypeNode.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "OpenSecureChannelResponse",
            OpenSecureChannelResponse.BinaryEncodingId,
            new OpenSecureChannelResponse.BinaryCodec(),
            OpenSecureChannelResponse.XmlEncodingId,
            new OpenSecureChannelResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "OptionSet",
            OptionSet.BinaryEncodingId,
            new OptionSet.BinaryCodec(),
            OptionSet.XmlEncodingId,
            new OptionSet.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ParsingResult",
            ParsingResult.BinaryEncodingId,
            new ParsingResult.BinaryCodec(),
            ParsingResult.XmlEncodingId,
            new ParsingResult.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "PublishRequest",
            PublishRequest.BinaryEncodingId,
            new PublishRequest.BinaryCodec(),
            PublishRequest.XmlEncodingId,
            new PublishRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "QueryDataDescription",
            QueryDataDescription.BinaryEncodingId,
            new QueryDataDescription.BinaryCodec(),
            QueryDataDescription.XmlEncodingId,
            new QueryDataDescription.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "QueryFirstRequest",
            QueryFirstRequest.BinaryEncodingId,
            new QueryFirstRequest.BinaryCodec(),
            QueryFirstRequest.XmlEncodingId,
            new QueryFirstRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "QueryNextRequest",
            QueryNextRequest.BinaryEncodingId,
            new QueryNextRequest.BinaryCodec(),
            QueryNextRequest.XmlEncodingId,
            new QueryNextRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "QueryNextResponse",
            QueryNextResponse.BinaryEncodingId,
            new QueryNextResponse.BinaryCodec(),
            QueryNextResponse.XmlEncodingId,
            new QueryNextResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "Range",
            Range.BinaryEncodingId,
            new Range.BinaryCodec(),
            Range.XmlEncodingId,
            new Range.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ReadEventDetails",
            ReadEventDetails.BinaryEncodingId,
            new ReadEventDetails.BinaryCodec(),
            ReadEventDetails.XmlEncodingId,
            new ReadEventDetails.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ReadRawModifiedDetails",
            ReadRawModifiedDetails.BinaryEncodingId,
            new ReadRawModifiedDetails.BinaryCodec(),
            ReadRawModifiedDetails.XmlEncodingId,
            new ReadRawModifiedDetails.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ReadResponse",
            ReadResponse.BinaryEncodingId,
            new ReadResponse.BinaryCodec(),
            ReadResponse.XmlEncodingId,
            new ReadResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "RedundantServerDataType",
            RedundantServerDataType.BinaryEncodingId,
            new RedundantServerDataType.BinaryCodec(),
            RedundantServerDataType.XmlEncodingId,
            new RedundantServerDataType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ReferenceNode",
            ReferenceNode.BinaryEncodingId,
            new ReferenceNode.BinaryCodec(),
            ReferenceNode.XmlEncodingId,
            new ReferenceNode.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ReferenceTypeNode",
            ReferenceTypeNode.BinaryEncodingId,
            new ReferenceTypeNode.BinaryCodec(),
            ReferenceTypeNode.XmlEncodingId,
            new ReferenceTypeNode.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "RegisterNodesRequest",
            RegisterNodesRequest.BinaryEncodingId,
            new RegisterNodesRequest.BinaryCodec(),
            RegisterNodesRequest.XmlEncodingId,
            new RegisterNodesRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "RegisterServer2Request",
            RegisterServer2Request.BinaryEncodingId,
            new RegisterServer2Request.BinaryCodec(),
            RegisterServer2Request.XmlEncodingId,
            new RegisterServer2Request.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "RegisterServerRequest",
            RegisterServerRequest.BinaryEncodingId,
            new RegisterServerRequest.BinaryCodec(),
            RegisterServerRequest.XmlEncodingId,
            new RegisterServerRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "RelativePath",
            RelativePath.BinaryEncodingId,
            new RelativePath.BinaryCodec(),
            RelativePath.XmlEncodingId,
            new RelativePath.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "RequestHeader",
            RequestHeader.BinaryEncodingId,
            new RequestHeader.BinaryCodec(),
            RequestHeader.XmlEncodingId,
            new RequestHeader.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SemanticChangeStructureDataType",
            SemanticChangeStructureDataType.BinaryEncodingId,
            new SemanticChangeStructureDataType.BinaryCodec(),
            SemanticChangeStructureDataType.XmlEncodingId,
            new SemanticChangeStructureDataType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ServerDiagnosticsSummaryDataType",
            ServerDiagnosticsSummaryDataType.BinaryEncodingId,
            new ServerDiagnosticsSummaryDataType.BinaryCodec(),
            ServerDiagnosticsSummaryDataType.XmlEncodingId,
            new ServerDiagnosticsSummaryDataType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ServerStatusDataType",
            ServerStatusDataType.BinaryEncodingId,
            new ServerStatusDataType.BinaryCodec(),
            ServerStatusDataType.XmlEncodingId,
            new ServerStatusDataType.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ServiceFault",
            ServiceFault.BinaryEncodingId,
            new ServiceFault.BinaryCodec(),
            ServiceFault.XmlEncodingId,
            new ServiceFault.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "SupportedProfile",
            SupportedProfile.BinaryEncodingId,
            new SupportedProfile.BinaryCodec(),
            SupportedProfile.XmlEncodingId,
            new SupportedProfile.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "TranslateBrowsePathsToNodeIdsResponse",
            TranslateBrowsePathsToNodeIdsResponse.BinaryEncodingId,
            new TranslateBrowsePathsToNodeIdsResponse.BinaryCodec(),
            TranslateBrowsePathsToNodeIdsResponse.XmlEncodingId,
            new TranslateBrowsePathsToNodeIdsResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "UserNameIdentityToken",
            UserNameIdentityToken.BinaryEncodingId,
            new UserNameIdentityToken.BinaryCodec(),
            UserNameIdentityToken.XmlEncodingId,
            new UserNameIdentityToken.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "UserTokenPolicy",
            UserTokenPolicy.BinaryEncodingId,
            new UserTokenPolicy.BinaryCodec(),
            UserTokenPolicy.XmlEncodingId,
            new UserTokenPolicy.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "VariableAttributes",
            VariableAttributes.BinaryEncodingId,
            new VariableAttributes.BinaryCodec(),
            VariableAttributes.XmlEncodingId,
            new VariableAttributes.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "VariableNode",
            VariableNode.BinaryEncodingId,
            new VariableNode.BinaryCodec(),
            VariableNode.XmlEncodingId,
            new VariableNode.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "VariableTypeAttributes",
            VariableTypeAttributes.BinaryEncodingId,
            new VariableTypeAttributes.BinaryCodec(),
            VariableTypeAttributes.XmlEncodingId,
            new VariableTypeAttributes.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "VariableTypeNode",
            VariableTypeNode.BinaryEncodingId,
            new VariableTypeNode.BinaryCodec(),
            VariableTypeNode.XmlEncodingId,
            new VariableTypeNode.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ViewAttributes",
            ViewAttributes.BinaryEncodingId,
            new ViewAttributes.BinaryCodec(),
            ViewAttributes.XmlEncodingId,
            new ViewAttributes.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ViewDescription",
            ViewDescription.BinaryEncodingId,
            new ViewDescription.BinaryCodec(),
            ViewDescription.XmlEncodingId,
            new ViewDescription.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "ViewNode",
            ViewNode.BinaryEncodingId,
            new ViewNode.BinaryCodec(),
            ViewNode.XmlEncodingId,
            new ViewNode.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "WriteRequest",
            WriteRequest.BinaryEncodingId,
            new WriteRequest.BinaryCodec(),
            WriteRequest.XmlEncodingId,
            new WriteRequest.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "WriteResponse",
            WriteResponse.BinaryEncodingId,
            new WriteResponse.BinaryCodec(),
            WriteResponse.XmlEncodingId,
            new WriteResponse.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "WriteValue",
            WriteValue.BinaryEncodingId,
            new WriteValue.BinaryCodec(),
            WriteValue.XmlEncodingId,
            new WriteValue.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "X509IdentityToken",
            X509IdentityToken.BinaryEncodingId,
            new X509IdentityToken.BinaryCodec(),
            X509IdentityToken.XmlEncodingId,
            new X509IdentityToken.XmlCodec()
        );

        OpcUaTypeDictionary.register(
            "XVType",
            XVType.BinaryEncodingId,
            new XVType.BinaryCodec(),
            XVType.XmlEncodingId,
            new XVType.XmlCodec()
        );
    }

}

