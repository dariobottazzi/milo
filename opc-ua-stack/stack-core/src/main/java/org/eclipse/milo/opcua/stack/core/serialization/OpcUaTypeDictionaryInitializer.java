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

import org.eclipse.milo.opcua.stack.core.types.enumerated.ApplicationType;
import org.eclipse.milo.opcua.stack.core.types.enumerated.AttributeWriteMask;
import org.eclipse.milo.opcua.stack.core.types.enumerated.AxisScaleEnumeration;
import org.eclipse.milo.opcua.stack.core.types.enumerated.BrowseDirection;
import org.eclipse.milo.opcua.stack.core.types.enumerated.BrowseResultMask;
import org.eclipse.milo.opcua.stack.core.types.enumerated.ComplianceLevel;
import org.eclipse.milo.opcua.stack.core.types.enumerated.DataChangeTrigger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.DeadbandType;
import org.eclipse.milo.opcua.stack.core.types.enumerated.EnumeratedTestType;
import org.eclipse.milo.opcua.stack.core.types.enumerated.ExceptionDeviationFormat;
import org.eclipse.milo.opcua.stack.core.types.enumerated.FilterOperator;
import org.eclipse.milo.opcua.stack.core.types.enumerated.HistoryUpdateType;
import org.eclipse.milo.opcua.stack.core.types.enumerated.IdType;
import org.eclipse.milo.opcua.stack.core.types.enumerated.MessageSecurityMode;
import org.eclipse.milo.opcua.stack.core.types.enumerated.ModelChangeStructureVerbMask;
import org.eclipse.milo.opcua.stack.core.types.enumerated.MonitoringMode;
import org.eclipse.milo.opcua.stack.core.types.enumerated.NamingRuleType;
import org.eclipse.milo.opcua.stack.core.types.enumerated.NodeAttributesMask;
import org.eclipse.milo.opcua.stack.core.types.enumerated.NodeClass;
import org.eclipse.milo.opcua.stack.core.types.enumerated.NodeIdType;
import org.eclipse.milo.opcua.stack.core.types.enumerated.OpenFileMode;
import org.eclipse.milo.opcua.stack.core.types.enumerated.PerformUpdateType;
import org.eclipse.milo.opcua.stack.core.types.enumerated.RedundancySupport;
import org.eclipse.milo.opcua.stack.core.types.enumerated.SecurityTokenRequestType;
import org.eclipse.milo.opcua.stack.core.types.enumerated.ServerState;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TrustListMasks;
import org.eclipse.milo.opcua.stack.core.types.enumerated.UserTokenType;
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
import org.eclipse.milo.opcua.stack.core.types.structured.ArrayTestType;
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
import org.eclipse.milo.opcua.stack.core.types.structured.CompositeTestType;
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
import org.eclipse.milo.opcua.stack.core.types.structured.ScalarTestType;
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
import org.eclipse.milo.opcua.stack.core.types.structured.TestStackExRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.TestStackExResponse;
import org.eclipse.milo.opcua.stack.core.types.structured.TestStackRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.TestStackResponse;
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
        initializeEnumerated();
        initializeStructured();
    }

    private static void initializeEnumerated() {
        OpcUaTypeDictionary.register(
            ApplicationType::encode,
            ApplicationType::decode,
            ApplicationType.class
        );
        OpcUaTypeDictionary.register(
            AttributeWriteMask::encode,
            AttributeWriteMask::decode,
            AttributeWriteMask.class
        );
        OpcUaTypeDictionary.register(
            AxisScaleEnumeration::encode,
            AxisScaleEnumeration::decode,
            AxisScaleEnumeration.class
        );
        OpcUaTypeDictionary.register(
            BrowseDirection::encode,
            BrowseDirection::decode,
            BrowseDirection.class
        );
        OpcUaTypeDictionary.register(
            BrowseResultMask::encode,
            BrowseResultMask::decode,
            BrowseResultMask.class
        );
        OpcUaTypeDictionary.register(
            ComplianceLevel::encode,
            ComplianceLevel::decode,
            ComplianceLevel.class
        );
        OpcUaTypeDictionary.register(
            DataChangeTrigger::encode,
            DataChangeTrigger::decode,
            DataChangeTrigger.class
        );
        OpcUaTypeDictionary.register(
            DeadbandType::encode,
            DeadbandType::decode,
            DeadbandType.class
        );
        OpcUaTypeDictionary.register(
            EnumeratedTestType::encode,
            EnumeratedTestType::decode,
            EnumeratedTestType.class
        );
        OpcUaTypeDictionary.register(
            ExceptionDeviationFormat::encode,
            ExceptionDeviationFormat::decode,
            ExceptionDeviationFormat.class
        );
        OpcUaTypeDictionary.register(
            FilterOperator::encode,
            FilterOperator::decode,
            FilterOperator.class
        );
        OpcUaTypeDictionary.register(
            HistoryUpdateType::encode,
            HistoryUpdateType::decode,
            HistoryUpdateType.class
        );
        OpcUaTypeDictionary.register(
            IdType::encode,
            IdType::decode,
            IdType.class
        );
        OpcUaTypeDictionary.register(
            MessageSecurityMode::encode,
            MessageSecurityMode::decode,
            MessageSecurityMode.class
        );
        OpcUaTypeDictionary.register(
            ModelChangeStructureVerbMask::encode,
            ModelChangeStructureVerbMask::decode,
            ModelChangeStructureVerbMask.class
        );
        OpcUaTypeDictionary.register(
            MonitoringMode::encode,
            MonitoringMode::decode,
            MonitoringMode.class
        );
        OpcUaTypeDictionary.register(
            NamingRuleType::encode,
            NamingRuleType::decode,
            NamingRuleType.class
        );
        OpcUaTypeDictionary.register(
            NodeAttributesMask::encode,
            NodeAttributesMask::decode,
            NodeAttributesMask.class
        );
        OpcUaTypeDictionary.register(
            NodeClass::encode,
            NodeClass::decode,
            NodeClass.class
        );
        OpcUaTypeDictionary.register(
            NodeIdType::encode,
            NodeIdType::decode,
            NodeIdType.class
        );
        OpcUaTypeDictionary.register(
            OpenFileMode::encode,
            OpenFileMode::decode,
            OpenFileMode.class
        );
        OpcUaTypeDictionary.register(
            PerformUpdateType::encode,
            PerformUpdateType::decode,
            PerformUpdateType.class
        );
        OpcUaTypeDictionary.register(
            RedundancySupport::encode,
            RedundancySupport::decode,
            RedundancySupport.class
        );
        OpcUaTypeDictionary.register(
            SecurityTokenRequestType::encode,
            SecurityTokenRequestType::decode,
            SecurityTokenRequestType.class
        );
        OpcUaTypeDictionary.register(
            ServerState::encode,
            ServerState::decode,
            ServerState.class
        );
        OpcUaTypeDictionary.register(
            TimestampsToReturn::encode,
            TimestampsToReturn::decode,
            TimestampsToReturn.class
        );
        OpcUaTypeDictionary.register(
            TrustListMasks::encode,
            TrustListMasks::decode,
            TrustListMasks.class
        );
        OpcUaTypeDictionary.register(
            UserTokenType::encode,
            UserTokenType::decode,
            UserTokenType.class
        );
    }

    private static void initializeStructured() {
        OpcUaTypeDictionary.register(
            ActivateSessionRequest::encode,
            ActivateSessionRequest::decode,
            ActivateSessionRequest.class,
            ActivateSessionRequest.BinaryEncodingId,
            ActivateSessionRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ActivateSessionResponse::encode,
            ActivateSessionResponse::decode,
            ActivateSessionResponse.class,
            ActivateSessionResponse.BinaryEncodingId,
            ActivateSessionResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            AddNodesItem::encode,
            AddNodesItem::decode,
            AddNodesItem.class,
            AddNodesItem.BinaryEncodingId,
            AddNodesItem.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            AddNodesRequest::encode,
            AddNodesRequest::decode,
            AddNodesRequest.class,
            AddNodesRequest.BinaryEncodingId,
            AddNodesRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            AddNodesResponse::encode,
            AddNodesResponse::decode,
            AddNodesResponse.class,
            AddNodesResponse.BinaryEncodingId,
            AddNodesResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            AddNodesResult::encode,
            AddNodesResult::decode,
            AddNodesResult.class,
            AddNodesResult.BinaryEncodingId,
            AddNodesResult.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            AddReferencesItem::encode,
            AddReferencesItem::decode,
            AddReferencesItem.class,
            AddReferencesItem.BinaryEncodingId,
            AddReferencesItem.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            AddReferencesRequest::encode,
            AddReferencesRequest::decode,
            AddReferencesRequest.class,
            AddReferencesRequest.BinaryEncodingId,
            AddReferencesRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            AddReferencesResponse::encode,
            AddReferencesResponse::decode,
            AddReferencesResponse.class,
            AddReferencesResponse.BinaryEncodingId,
            AddReferencesResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            AggregateConfiguration::encode,
            AggregateConfiguration::decode,
            AggregateConfiguration.class,
            AggregateConfiguration.BinaryEncodingId,
            AggregateConfiguration.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            AggregateFilter::encode,
            AggregateFilter::decode,
            AggregateFilter.class,
            AggregateFilter.BinaryEncodingId,
            AggregateFilter.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            AggregateFilterResult::encode,
            AggregateFilterResult::decode,
            AggregateFilterResult.class,
            AggregateFilterResult.BinaryEncodingId,
            AggregateFilterResult.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            Annotation::encode,
            Annotation::decode,
            Annotation.class,
            Annotation.BinaryEncodingId,
            Annotation.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            AnonymousIdentityToken::encode,
            AnonymousIdentityToken::decode,
            AnonymousIdentityToken.class,
            AnonymousIdentityToken.BinaryEncodingId,
            AnonymousIdentityToken.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ApplicationDescription::encode,
            ApplicationDescription::decode,
            ApplicationDescription.class,
            ApplicationDescription.BinaryEncodingId,
            ApplicationDescription.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            Argument::encode,
            Argument::decode,
            Argument.class,
            Argument.BinaryEncodingId,
            Argument.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ArrayTestType::encode,
            ArrayTestType::decode,
            ArrayTestType.class,
            ArrayTestType.BinaryEncodingId,
            ArrayTestType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            AttributeOperand::encode,
            AttributeOperand::decode,
            AttributeOperand.class,
            AttributeOperand.BinaryEncodingId,
            AttributeOperand.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            AxisInformation::encode,
            AxisInformation::decode,
            AxisInformation.class,
            AxisInformation.BinaryEncodingId,
            AxisInformation.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            BrowseDescription::encode,
            BrowseDescription::decode,
            BrowseDescription.class,
            BrowseDescription.BinaryEncodingId,
            BrowseDescription.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            BrowseNextRequest::encode,
            BrowseNextRequest::decode,
            BrowseNextRequest.class,
            BrowseNextRequest.BinaryEncodingId,
            BrowseNextRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            BrowseNextResponse::encode,
            BrowseNextResponse::decode,
            BrowseNextResponse.class,
            BrowseNextResponse.BinaryEncodingId,
            BrowseNextResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            BrowsePath::encode,
            BrowsePath::decode,
            BrowsePath.class,
            BrowsePath.BinaryEncodingId,
            BrowsePath.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            BrowsePathResult::encode,
            BrowsePathResult::decode,
            BrowsePathResult.class,
            BrowsePathResult.BinaryEncodingId,
            BrowsePathResult.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            BrowsePathTarget::encode,
            BrowsePathTarget::decode,
            BrowsePathTarget.class,
            BrowsePathTarget.BinaryEncodingId,
            BrowsePathTarget.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            BrowseRequest::encode,
            BrowseRequest::decode,
            BrowseRequest.class,
            BrowseRequest.BinaryEncodingId,
            BrowseRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            BrowseResponse::encode,
            BrowseResponse::decode,
            BrowseResponse.class,
            BrowseResponse.BinaryEncodingId,
            BrowseResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            BrowseResult::encode,
            BrowseResult::decode,
            BrowseResult.class,
            BrowseResult.BinaryEncodingId,
            BrowseResult.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            BuildInfo::encode,
            BuildInfo::decode,
            BuildInfo.class,
            BuildInfo.BinaryEncodingId,
            BuildInfo.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CallMethodRequest::encode,
            CallMethodRequest::decode,
            CallMethodRequest.class,
            CallMethodRequest.BinaryEncodingId,
            CallMethodRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CallMethodResult::encode,
            CallMethodResult::decode,
            CallMethodResult.class,
            CallMethodResult.BinaryEncodingId,
            CallMethodResult.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CallRequest::encode,
            CallRequest::decode,
            CallRequest.class,
            CallRequest.BinaryEncodingId,
            CallRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CallResponse::encode,
            CallResponse::decode,
            CallResponse.class,
            CallResponse.BinaryEncodingId,
            CallResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CancelRequest::encode,
            CancelRequest::decode,
            CancelRequest.class,
            CancelRequest.BinaryEncodingId,
            CancelRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CancelResponse::encode,
            CancelResponse::decode,
            CancelResponse.class,
            CancelResponse.BinaryEncodingId,
            CancelResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ChannelSecurityToken::encode,
            ChannelSecurityToken::decode,
            ChannelSecurityToken.class,
            ChannelSecurityToken.BinaryEncodingId,
            ChannelSecurityToken.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CloseSecureChannelRequest::encode,
            CloseSecureChannelRequest::decode,
            CloseSecureChannelRequest.class,
            CloseSecureChannelRequest.BinaryEncodingId,
            CloseSecureChannelRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CloseSecureChannelResponse::encode,
            CloseSecureChannelResponse::decode,
            CloseSecureChannelResponse.class,
            CloseSecureChannelResponse.BinaryEncodingId,
            CloseSecureChannelResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CloseSessionRequest::encode,
            CloseSessionRequest::decode,
            CloseSessionRequest.class,
            CloseSessionRequest.BinaryEncodingId,
            CloseSessionRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CloseSessionResponse::encode,
            CloseSessionResponse::decode,
            CloseSessionResponse.class,
            CloseSessionResponse.BinaryEncodingId,
            CloseSessionResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ComplexNumberType::encode,
            ComplexNumberType::decode,
            ComplexNumberType.class,
            ComplexNumberType.BinaryEncodingId,
            ComplexNumberType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CompositeTestType::encode,
            CompositeTestType::decode,
            CompositeTestType.class,
            CompositeTestType.BinaryEncodingId,
            CompositeTestType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ContentFilter::encode,
            ContentFilter::decode,
            ContentFilter.class,
            ContentFilter.BinaryEncodingId,
            ContentFilter.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ContentFilterElement::encode,
            ContentFilterElement::decode,
            ContentFilterElement.class,
            ContentFilterElement.BinaryEncodingId,
            ContentFilterElement.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ContentFilterElementResult::encode,
            ContentFilterElementResult::decode,
            ContentFilterElementResult.class,
            ContentFilterElementResult.BinaryEncodingId,
            ContentFilterElementResult.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ContentFilterResult::encode,
            ContentFilterResult::decode,
            ContentFilterResult.class,
            ContentFilterResult.BinaryEncodingId,
            ContentFilterResult.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CreateMonitoredItemsRequest::encode,
            CreateMonitoredItemsRequest::decode,
            CreateMonitoredItemsRequest.class,
            CreateMonitoredItemsRequest.BinaryEncodingId,
            CreateMonitoredItemsRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CreateMonitoredItemsResponse::encode,
            CreateMonitoredItemsResponse::decode,
            CreateMonitoredItemsResponse.class,
            CreateMonitoredItemsResponse.BinaryEncodingId,
            CreateMonitoredItemsResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CreateSessionRequest::encode,
            CreateSessionRequest::decode,
            CreateSessionRequest.class,
            CreateSessionRequest.BinaryEncodingId,
            CreateSessionRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CreateSessionResponse::encode,
            CreateSessionResponse::decode,
            CreateSessionResponse.class,
            CreateSessionResponse.BinaryEncodingId,
            CreateSessionResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CreateSubscriptionRequest::encode,
            CreateSubscriptionRequest::decode,
            CreateSubscriptionRequest.class,
            CreateSubscriptionRequest.BinaryEncodingId,
            CreateSubscriptionRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            CreateSubscriptionResponse::encode,
            CreateSubscriptionResponse::decode,
            CreateSubscriptionResponse.class,
            CreateSubscriptionResponse.BinaryEncodingId,
            CreateSubscriptionResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DataChangeFilter::encode,
            DataChangeFilter::decode,
            DataChangeFilter.class,
            DataChangeFilter.BinaryEncodingId,
            DataChangeFilter.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DataChangeNotification::encode,
            DataChangeNotification::decode,
            DataChangeNotification.class,
            DataChangeNotification.BinaryEncodingId,
            DataChangeNotification.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DataTypeAttributes::encode,
            DataTypeAttributes::decode,
            DataTypeAttributes.class,
            DataTypeAttributes.BinaryEncodingId,
            DataTypeAttributes.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DataTypeNode::encode,
            DataTypeNode::decode,
            DataTypeNode.class,
            DataTypeNode.BinaryEncodingId,
            DataTypeNode.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DeleteAtTimeDetails::encode,
            DeleteAtTimeDetails::decode,
            DeleteAtTimeDetails.class,
            DeleteAtTimeDetails.BinaryEncodingId,
            DeleteAtTimeDetails.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DeleteEventDetails::encode,
            DeleteEventDetails::decode,
            DeleteEventDetails.class,
            DeleteEventDetails.BinaryEncodingId,
            DeleteEventDetails.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DeleteMonitoredItemsRequest::encode,
            DeleteMonitoredItemsRequest::decode,
            DeleteMonitoredItemsRequest.class,
            DeleteMonitoredItemsRequest.BinaryEncodingId,
            DeleteMonitoredItemsRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DeleteMonitoredItemsResponse::encode,
            DeleteMonitoredItemsResponse::decode,
            DeleteMonitoredItemsResponse.class,
            DeleteMonitoredItemsResponse.BinaryEncodingId,
            DeleteMonitoredItemsResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DeleteNodesItem::encode,
            DeleteNodesItem::decode,
            DeleteNodesItem.class,
            DeleteNodesItem.BinaryEncodingId,
            DeleteNodesItem.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DeleteNodesRequest::encode,
            DeleteNodesRequest::decode,
            DeleteNodesRequest.class,
            DeleteNodesRequest.BinaryEncodingId,
            DeleteNodesRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DeleteNodesResponse::encode,
            DeleteNodesResponse::decode,
            DeleteNodesResponse.class,
            DeleteNodesResponse.BinaryEncodingId,
            DeleteNodesResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DeleteRawModifiedDetails::encode,
            DeleteRawModifiedDetails::decode,
            DeleteRawModifiedDetails.class,
            DeleteRawModifiedDetails.BinaryEncodingId,
            DeleteRawModifiedDetails.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DeleteReferencesItem::encode,
            DeleteReferencesItem::decode,
            DeleteReferencesItem.class,
            DeleteReferencesItem.BinaryEncodingId,
            DeleteReferencesItem.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DeleteReferencesRequest::encode,
            DeleteReferencesRequest::decode,
            DeleteReferencesRequest.class,
            DeleteReferencesRequest.BinaryEncodingId,
            DeleteReferencesRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DeleteReferencesResponse::encode,
            DeleteReferencesResponse::decode,
            DeleteReferencesResponse.class,
            DeleteReferencesResponse.BinaryEncodingId,
            DeleteReferencesResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DeleteSubscriptionsRequest::encode,
            DeleteSubscriptionsRequest::decode,
            DeleteSubscriptionsRequest.class,
            DeleteSubscriptionsRequest.BinaryEncodingId,
            DeleteSubscriptionsRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DeleteSubscriptionsResponse::encode,
            DeleteSubscriptionsResponse::decode,
            DeleteSubscriptionsResponse.class,
            DeleteSubscriptionsResponse.BinaryEncodingId,
            DeleteSubscriptionsResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DiscoveryConfiguration::encode,
            DiscoveryConfiguration::decode,
            DiscoveryConfiguration.class,
            DiscoveryConfiguration.BinaryEncodingId,
            DiscoveryConfiguration.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            DoubleComplexNumberType::encode,
            DoubleComplexNumberType::decode,
            DoubleComplexNumberType.class,
            DoubleComplexNumberType.BinaryEncodingId,
            DoubleComplexNumberType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ElementOperand::encode,
            ElementOperand::decode,
            ElementOperand.class,
            ElementOperand.BinaryEncodingId,
            ElementOperand.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            EndpointConfiguration::encode,
            EndpointConfiguration::decode,
            EndpointConfiguration.class,
            EndpointConfiguration.BinaryEncodingId,
            EndpointConfiguration.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            EndpointDescription::encode,
            EndpointDescription::decode,
            EndpointDescription.class,
            EndpointDescription.BinaryEncodingId,
            EndpointDescription.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            EndpointUrlListDataType::encode,
            EndpointUrlListDataType::decode,
            EndpointUrlListDataType.class,
            EndpointUrlListDataType.BinaryEncodingId,
            EndpointUrlListDataType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            EnumValueType::encode,
            EnumValueType::decode,
            EnumValueType.class,
            EnumValueType.BinaryEncodingId,
            EnumValueType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            EUInformation::encode,
            EUInformation::decode,
            EUInformation.class,
            EUInformation.BinaryEncodingId,
            EUInformation.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            EventFieldList::encode,
            EventFieldList::decode,
            EventFieldList.class,
            EventFieldList.BinaryEncodingId,
            EventFieldList.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            EventFilter::encode,
            EventFilter::decode,
            EventFilter.class,
            EventFilter.BinaryEncodingId,
            EventFilter.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            EventFilterResult::encode,
            EventFilterResult::decode,
            EventFilterResult.class,
            EventFilterResult.BinaryEncodingId,
            EventFilterResult.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            EventNotificationList::encode,
            EventNotificationList::decode,
            EventNotificationList.class,
            EventNotificationList.BinaryEncodingId,
            EventNotificationList.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            FilterOperand::encode,
            FilterOperand::decode,
            FilterOperand.class,
            FilterOperand.BinaryEncodingId,
            FilterOperand.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            FindServersOnNetworkRequest::encode,
            FindServersOnNetworkRequest::decode,
            FindServersOnNetworkRequest.class,
            FindServersOnNetworkRequest.BinaryEncodingId,
            FindServersOnNetworkRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            FindServersOnNetworkResponse::encode,
            FindServersOnNetworkResponse::decode,
            FindServersOnNetworkResponse.class,
            FindServersOnNetworkResponse.BinaryEncodingId,
            FindServersOnNetworkResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            FindServersRequest::encode,
            FindServersRequest::decode,
            FindServersRequest.class,
            FindServersRequest.BinaryEncodingId,
            FindServersRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            FindServersResponse::encode,
            FindServersResponse::decode,
            FindServersResponse.class,
            FindServersResponse.BinaryEncodingId,
            FindServersResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            GetEndpointsRequest::encode,
            GetEndpointsRequest::decode,
            GetEndpointsRequest.class,
            GetEndpointsRequest.BinaryEncodingId,
            GetEndpointsRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            GetEndpointsResponse::encode,
            GetEndpointsResponse::decode,
            GetEndpointsResponse.class,
            GetEndpointsResponse.BinaryEncodingId,
            GetEndpointsResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            HistoryData::encode,
            HistoryData::decode,
            HistoryData.class,
            HistoryData.BinaryEncodingId,
            HistoryData.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            HistoryEvent::encode,
            HistoryEvent::decode,
            HistoryEvent.class,
            HistoryEvent.BinaryEncodingId,
            HistoryEvent.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            HistoryEventFieldList::encode,
            HistoryEventFieldList::decode,
            HistoryEventFieldList.class,
            HistoryEventFieldList.BinaryEncodingId,
            HistoryEventFieldList.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            HistoryModifiedData::encode,
            HistoryModifiedData::decode,
            HistoryModifiedData.class,
            HistoryModifiedData.BinaryEncodingId,
            HistoryModifiedData.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            HistoryReadDetails::encode,
            HistoryReadDetails::decode,
            HistoryReadDetails.class,
            HistoryReadDetails.BinaryEncodingId,
            HistoryReadDetails.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            HistoryReadRequest::encode,
            HistoryReadRequest::decode,
            HistoryReadRequest.class,
            HistoryReadRequest.BinaryEncodingId,
            HistoryReadRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            HistoryReadResponse::encode,
            HistoryReadResponse::decode,
            HistoryReadResponse.class,
            HistoryReadResponse.BinaryEncodingId,
            HistoryReadResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            HistoryReadResult::encode,
            HistoryReadResult::decode,
            HistoryReadResult.class,
            HistoryReadResult.BinaryEncodingId,
            HistoryReadResult.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            HistoryReadValueId::encode,
            HistoryReadValueId::decode,
            HistoryReadValueId.class,
            HistoryReadValueId.BinaryEncodingId,
            HistoryReadValueId.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            HistoryUpdateDetails::encode,
            HistoryUpdateDetails::decode,
            HistoryUpdateDetails.class,
            HistoryUpdateDetails.BinaryEncodingId,
            HistoryUpdateDetails.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            HistoryUpdateRequest::encode,
            HistoryUpdateRequest::decode,
            HistoryUpdateRequest.class,
            HistoryUpdateRequest.BinaryEncodingId,
            HistoryUpdateRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            HistoryUpdateResponse::encode,
            HistoryUpdateResponse::decode,
            HistoryUpdateResponse.class,
            HistoryUpdateResponse.BinaryEncodingId,
            HistoryUpdateResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            HistoryUpdateResult::encode,
            HistoryUpdateResult::decode,
            HistoryUpdateResult.class,
            HistoryUpdateResult.BinaryEncodingId,
            HistoryUpdateResult.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            InstanceNode::encode,
            InstanceNode::decode,
            InstanceNode.class,
            InstanceNode.BinaryEncodingId,
            InstanceNode.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            IssuedIdentityToken::encode,
            IssuedIdentityToken::decode,
            IssuedIdentityToken.class,
            IssuedIdentityToken.BinaryEncodingId,
            IssuedIdentityToken.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            KerberosIdentityToken::encode,
            KerberosIdentityToken::decode,
            KerberosIdentityToken.class,
            KerberosIdentityToken.BinaryEncodingId,
            KerberosIdentityToken.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            LiteralOperand::encode,
            LiteralOperand::decode,
            LiteralOperand.class,
            LiteralOperand.BinaryEncodingId,
            LiteralOperand.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            MdnsDiscoveryConfiguration::encode,
            MdnsDiscoveryConfiguration::decode,
            MdnsDiscoveryConfiguration.class,
            MdnsDiscoveryConfiguration.BinaryEncodingId,
            MdnsDiscoveryConfiguration.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            MethodAttributes::encode,
            MethodAttributes::decode,
            MethodAttributes.class,
            MethodAttributes.BinaryEncodingId,
            MethodAttributes.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            MethodNode::encode,
            MethodNode::decode,
            MethodNode.class,
            MethodNode.BinaryEncodingId,
            MethodNode.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ModelChangeStructureDataType::encode,
            ModelChangeStructureDataType::decode,
            ModelChangeStructureDataType.class,
            ModelChangeStructureDataType.BinaryEncodingId,
            ModelChangeStructureDataType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ModificationInfo::encode,
            ModificationInfo::decode,
            ModificationInfo.class,
            ModificationInfo.BinaryEncodingId,
            ModificationInfo.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ModifyMonitoredItemsRequest::encode,
            ModifyMonitoredItemsRequest::decode,
            ModifyMonitoredItemsRequest.class,
            ModifyMonitoredItemsRequest.BinaryEncodingId,
            ModifyMonitoredItemsRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ModifyMonitoredItemsResponse::encode,
            ModifyMonitoredItemsResponse::decode,
            ModifyMonitoredItemsResponse.class,
            ModifyMonitoredItemsResponse.BinaryEncodingId,
            ModifyMonitoredItemsResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ModifySubscriptionRequest::encode,
            ModifySubscriptionRequest::decode,
            ModifySubscriptionRequest.class,
            ModifySubscriptionRequest.BinaryEncodingId,
            ModifySubscriptionRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ModifySubscriptionResponse::encode,
            ModifySubscriptionResponse::decode,
            ModifySubscriptionResponse.class,
            ModifySubscriptionResponse.BinaryEncodingId,
            ModifySubscriptionResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            MonitoredItemCreateRequest::encode,
            MonitoredItemCreateRequest::decode,
            MonitoredItemCreateRequest.class,
            MonitoredItemCreateRequest.BinaryEncodingId,
            MonitoredItemCreateRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            MonitoredItemCreateResult::encode,
            MonitoredItemCreateResult::decode,
            MonitoredItemCreateResult.class,
            MonitoredItemCreateResult.BinaryEncodingId,
            MonitoredItemCreateResult.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            MonitoredItemModifyRequest::encode,
            MonitoredItemModifyRequest::decode,
            MonitoredItemModifyRequest.class,
            MonitoredItemModifyRequest.BinaryEncodingId,
            MonitoredItemModifyRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            MonitoredItemModifyResult::encode,
            MonitoredItemModifyResult::decode,
            MonitoredItemModifyResult.class,
            MonitoredItemModifyResult.BinaryEncodingId,
            MonitoredItemModifyResult.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            MonitoredItemNotification::encode,
            MonitoredItemNotification::decode,
            MonitoredItemNotification.class,
            MonitoredItemNotification.BinaryEncodingId,
            MonitoredItemNotification.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            MonitoringFilter::encode,
            MonitoringFilter::decode,
            MonitoringFilter.class,
            MonitoringFilter.BinaryEncodingId,
            MonitoringFilter.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            MonitoringFilterResult::encode,
            MonitoringFilterResult::decode,
            MonitoringFilterResult.class,
            MonitoringFilterResult.BinaryEncodingId,
            MonitoringFilterResult.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            MonitoringParameters::encode,
            MonitoringParameters::decode,
            MonitoringParameters.class,
            MonitoringParameters.BinaryEncodingId,
            MonitoringParameters.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            NetworkGroupDataType::encode,
            NetworkGroupDataType::decode,
            NetworkGroupDataType.class,
            NetworkGroupDataType.BinaryEncodingId,
            NetworkGroupDataType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            Node::encode,
            Node::decode,
            Node.class,
            Node.BinaryEncodingId,
            Node.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            NodeAttributes::encode,
            NodeAttributes::decode,
            NodeAttributes.class,
            NodeAttributes.BinaryEncodingId,
            NodeAttributes.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            NodeReference::encode,
            NodeReference::decode,
            NodeReference.class,
            NodeReference.BinaryEncodingId,
            NodeReference.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            NodeTypeDescription::encode,
            NodeTypeDescription::decode,
            NodeTypeDescription.class,
            NodeTypeDescription.BinaryEncodingId,
            NodeTypeDescription.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            NotificationData::encode,
            NotificationData::decode,
            NotificationData.class,
            NotificationData.BinaryEncodingId,
            NotificationData.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            NotificationMessage::encode,
            NotificationMessage::decode,
            NotificationMessage.class,
            NotificationMessage.BinaryEncodingId,
            NotificationMessage.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ObjectAttributes::encode,
            ObjectAttributes::decode,
            ObjectAttributes.class,
            ObjectAttributes.BinaryEncodingId,
            ObjectAttributes.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ObjectNode::encode,
            ObjectNode::decode,
            ObjectNode.class,
            ObjectNode.BinaryEncodingId,
            ObjectNode.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ObjectTypeAttributes::encode,
            ObjectTypeAttributes::decode,
            ObjectTypeAttributes.class,
            ObjectTypeAttributes.BinaryEncodingId,
            ObjectTypeAttributes.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ObjectTypeNode::encode,
            ObjectTypeNode::decode,
            ObjectTypeNode.class,
            ObjectTypeNode.BinaryEncodingId,
            ObjectTypeNode.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            OpenSecureChannelRequest::encode,
            OpenSecureChannelRequest::decode,
            OpenSecureChannelRequest.class,
            OpenSecureChannelRequest.BinaryEncodingId,
            OpenSecureChannelRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            OpenSecureChannelResponse::encode,
            OpenSecureChannelResponse::decode,
            OpenSecureChannelResponse.class,
            OpenSecureChannelResponse.BinaryEncodingId,
            OpenSecureChannelResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            OptionSet::encode,
            OptionSet::decode,
            OptionSet.class,
            OptionSet.BinaryEncodingId,
            OptionSet.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ParsingResult::encode,
            ParsingResult::decode,
            ParsingResult.class,
            ParsingResult.BinaryEncodingId,
            ParsingResult.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ProgramDiagnosticDataType::encode,
            ProgramDiagnosticDataType::decode,
            ProgramDiagnosticDataType.class,
            ProgramDiagnosticDataType.BinaryEncodingId,
            ProgramDiagnosticDataType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            PublishRequest::encode,
            PublishRequest::decode,
            PublishRequest.class,
            PublishRequest.BinaryEncodingId,
            PublishRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            PublishResponse::encode,
            PublishResponse::decode,
            PublishResponse.class,
            PublishResponse.BinaryEncodingId,
            PublishResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            QueryDataDescription::encode,
            QueryDataDescription::decode,
            QueryDataDescription.class,
            QueryDataDescription.BinaryEncodingId,
            QueryDataDescription.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            QueryDataSet::encode,
            QueryDataSet::decode,
            QueryDataSet.class,
            QueryDataSet.BinaryEncodingId,
            QueryDataSet.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            QueryFirstRequest::encode,
            QueryFirstRequest::decode,
            QueryFirstRequest.class,
            QueryFirstRequest.BinaryEncodingId,
            QueryFirstRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            QueryFirstResponse::encode,
            QueryFirstResponse::decode,
            QueryFirstResponse.class,
            QueryFirstResponse.BinaryEncodingId,
            QueryFirstResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            QueryNextRequest::encode,
            QueryNextRequest::decode,
            QueryNextRequest.class,
            QueryNextRequest.BinaryEncodingId,
            QueryNextRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            QueryNextResponse::encode,
            QueryNextResponse::decode,
            QueryNextResponse.class,
            QueryNextResponse.BinaryEncodingId,
            QueryNextResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            Range::encode,
            Range::decode,
            Range.class,
            Range.BinaryEncodingId,
            Range.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ReadAtTimeDetails::encode,
            ReadAtTimeDetails::decode,
            ReadAtTimeDetails.class,
            ReadAtTimeDetails.BinaryEncodingId,
            ReadAtTimeDetails.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ReadEventDetails::encode,
            ReadEventDetails::decode,
            ReadEventDetails.class,
            ReadEventDetails.BinaryEncodingId,
            ReadEventDetails.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ReadProcessedDetails::encode,
            ReadProcessedDetails::decode,
            ReadProcessedDetails.class,
            ReadProcessedDetails.BinaryEncodingId,
            ReadProcessedDetails.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ReadRawModifiedDetails::encode,
            ReadRawModifiedDetails::decode,
            ReadRawModifiedDetails.class,
            ReadRawModifiedDetails.BinaryEncodingId,
            ReadRawModifiedDetails.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ReadRequest::encode,
            ReadRequest::decode,
            ReadRequest.class,
            ReadRequest.BinaryEncodingId,
            ReadRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ReadResponse::encode,
            ReadResponse::decode,
            ReadResponse.class,
            ReadResponse.BinaryEncodingId,
            ReadResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ReadValueId::encode,
            ReadValueId::decode,
            ReadValueId.class,
            ReadValueId.BinaryEncodingId,
            ReadValueId.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            RedundantServerDataType::encode,
            RedundantServerDataType::decode,
            RedundantServerDataType.class,
            RedundantServerDataType.BinaryEncodingId,
            RedundantServerDataType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ReferenceDescription::encode,
            ReferenceDescription::decode,
            ReferenceDescription.class,
            ReferenceDescription.BinaryEncodingId,
            ReferenceDescription.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ReferenceNode::encode,
            ReferenceNode::decode,
            ReferenceNode.class,
            ReferenceNode.BinaryEncodingId,
            ReferenceNode.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ReferenceTypeAttributes::encode,
            ReferenceTypeAttributes::decode,
            ReferenceTypeAttributes.class,
            ReferenceTypeAttributes.BinaryEncodingId,
            ReferenceTypeAttributes.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ReferenceTypeNode::encode,
            ReferenceTypeNode::decode,
            ReferenceTypeNode.class,
            ReferenceTypeNode.BinaryEncodingId,
            ReferenceTypeNode.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            RegisteredServer::encode,
            RegisteredServer::decode,
            RegisteredServer.class,
            RegisteredServer.BinaryEncodingId,
            RegisteredServer.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            RegisterNodesRequest::encode,
            RegisterNodesRequest::decode,
            RegisterNodesRequest.class,
            RegisterNodesRequest.BinaryEncodingId,
            RegisterNodesRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            RegisterNodesResponse::encode,
            RegisterNodesResponse::decode,
            RegisterNodesResponse.class,
            RegisterNodesResponse.BinaryEncodingId,
            RegisterNodesResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            RegisterServer2Request::encode,
            RegisterServer2Request::decode,
            RegisterServer2Request.class,
            RegisterServer2Request.BinaryEncodingId,
            RegisterServer2Request.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            RegisterServer2Response::encode,
            RegisterServer2Response::decode,
            RegisterServer2Response.class,
            RegisterServer2Response.BinaryEncodingId,
            RegisterServer2Response.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            RegisterServerRequest::encode,
            RegisterServerRequest::decode,
            RegisterServerRequest.class,
            RegisterServerRequest.BinaryEncodingId,
            RegisterServerRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            RegisterServerResponse::encode,
            RegisterServerResponse::decode,
            RegisterServerResponse.class,
            RegisterServerResponse.BinaryEncodingId,
            RegisterServerResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            RelativePath::encode,
            RelativePath::decode,
            RelativePath.class,
            RelativePath.BinaryEncodingId,
            RelativePath.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            RelativePathElement::encode,
            RelativePathElement::decode,
            RelativePathElement.class,
            RelativePathElement.BinaryEncodingId,
            RelativePathElement.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            RepublishRequest::encode,
            RepublishRequest::decode,
            RepublishRequest.class,
            RepublishRequest.BinaryEncodingId,
            RepublishRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            RepublishResponse::encode,
            RepublishResponse::decode,
            RepublishResponse.class,
            RepublishResponse.BinaryEncodingId,
            RepublishResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            RequestHeader::encode,
            RequestHeader::decode,
            RequestHeader.class,
            RequestHeader.BinaryEncodingId,
            RequestHeader.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ResponseHeader::encode,
            ResponseHeader::decode,
            ResponseHeader.class,
            ResponseHeader.BinaryEncodingId,
            ResponseHeader.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SamplingIntervalDiagnosticsDataType::encode,
            SamplingIntervalDiagnosticsDataType::decode,
            SamplingIntervalDiagnosticsDataType.class,
            SamplingIntervalDiagnosticsDataType.BinaryEncodingId,
            SamplingIntervalDiagnosticsDataType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ScalarTestType::encode,
            ScalarTestType::decode,
            ScalarTestType.class,
            ScalarTestType.BinaryEncodingId,
            ScalarTestType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SemanticChangeStructureDataType::encode,
            SemanticChangeStructureDataType::decode,
            SemanticChangeStructureDataType.class,
            SemanticChangeStructureDataType.BinaryEncodingId,
            SemanticChangeStructureDataType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ServerDiagnosticsSummaryDataType::encode,
            ServerDiagnosticsSummaryDataType::decode,
            ServerDiagnosticsSummaryDataType.class,
            ServerDiagnosticsSummaryDataType.BinaryEncodingId,
            ServerDiagnosticsSummaryDataType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ServerOnNetwork::encode,
            ServerOnNetwork::decode,
            ServerOnNetwork.class,
            ServerOnNetwork.BinaryEncodingId,
            ServerOnNetwork.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ServerStatusDataType::encode,
            ServerStatusDataType::decode,
            ServerStatusDataType.class,
            ServerStatusDataType.BinaryEncodingId,
            ServerStatusDataType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ServiceCounterDataType::encode,
            ServiceCounterDataType::decode,
            ServiceCounterDataType.class,
            ServiceCounterDataType.BinaryEncodingId,
            ServiceCounterDataType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ServiceFault::encode,
            ServiceFault::decode,
            ServiceFault.class,
            ServiceFault.BinaryEncodingId,
            ServiceFault.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SessionDiagnosticsDataType::encode,
            SessionDiagnosticsDataType::decode,
            SessionDiagnosticsDataType.class,
            SessionDiagnosticsDataType.BinaryEncodingId,
            SessionDiagnosticsDataType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SessionSecurityDiagnosticsDataType::encode,
            SessionSecurityDiagnosticsDataType::decode,
            SessionSecurityDiagnosticsDataType.class,
            SessionSecurityDiagnosticsDataType.BinaryEncodingId,
            SessionSecurityDiagnosticsDataType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SetMonitoringModeRequest::encode,
            SetMonitoringModeRequest::decode,
            SetMonitoringModeRequest.class,
            SetMonitoringModeRequest.BinaryEncodingId,
            SetMonitoringModeRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SetMonitoringModeResponse::encode,
            SetMonitoringModeResponse::decode,
            SetMonitoringModeResponse.class,
            SetMonitoringModeResponse.BinaryEncodingId,
            SetMonitoringModeResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SetPublishingModeRequest::encode,
            SetPublishingModeRequest::decode,
            SetPublishingModeRequest.class,
            SetPublishingModeRequest.BinaryEncodingId,
            SetPublishingModeRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SetPublishingModeResponse::encode,
            SetPublishingModeResponse::decode,
            SetPublishingModeResponse.class,
            SetPublishingModeResponse.BinaryEncodingId,
            SetPublishingModeResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SetTriggeringRequest::encode,
            SetTriggeringRequest::decode,
            SetTriggeringRequest.class,
            SetTriggeringRequest.BinaryEncodingId,
            SetTriggeringRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SetTriggeringResponse::encode,
            SetTriggeringResponse::decode,
            SetTriggeringResponse.class,
            SetTriggeringResponse.BinaryEncodingId,
            SetTriggeringResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SignatureData::encode,
            SignatureData::decode,
            SignatureData.class,
            SignatureData.BinaryEncodingId,
            SignatureData.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SignedSoftwareCertificate::encode,
            SignedSoftwareCertificate::decode,
            SignedSoftwareCertificate.class,
            SignedSoftwareCertificate.BinaryEncodingId,
            SignedSoftwareCertificate.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SimpleAttributeOperand::encode,
            SimpleAttributeOperand::decode,
            SimpleAttributeOperand.class,
            SimpleAttributeOperand.BinaryEncodingId,
            SimpleAttributeOperand.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SoftwareCertificate::encode,
            SoftwareCertificate::decode,
            SoftwareCertificate.class,
            SoftwareCertificate.BinaryEncodingId,
            SoftwareCertificate.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            StatusChangeNotification::encode,
            StatusChangeNotification::decode,
            StatusChangeNotification.class,
            StatusChangeNotification.BinaryEncodingId,
            StatusChangeNotification.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            StatusResult::encode,
            StatusResult::decode,
            StatusResult.class,
            StatusResult.BinaryEncodingId,
            StatusResult.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SubscriptionAcknowledgement::encode,
            SubscriptionAcknowledgement::decode,
            SubscriptionAcknowledgement.class,
            SubscriptionAcknowledgement.BinaryEncodingId,
            SubscriptionAcknowledgement.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SubscriptionDiagnosticsDataType::encode,
            SubscriptionDiagnosticsDataType::decode,
            SubscriptionDiagnosticsDataType.class,
            SubscriptionDiagnosticsDataType.BinaryEncodingId,
            SubscriptionDiagnosticsDataType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            SupportedProfile::encode,
            SupportedProfile::decode,
            SupportedProfile.class,
            SupportedProfile.BinaryEncodingId,
            SupportedProfile.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            TestStackExRequest::encode,
            TestStackExRequest::decode,
            TestStackExRequest.class,
            TestStackExRequest.BinaryEncodingId,
            TestStackExRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            TestStackExResponse::encode,
            TestStackExResponse::decode,
            TestStackExResponse.class,
            TestStackExResponse.BinaryEncodingId,
            TestStackExResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            TestStackRequest::encode,
            TestStackRequest::decode,
            TestStackRequest.class,
            TestStackRequest.BinaryEncodingId,
            TestStackRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            TestStackResponse::encode,
            TestStackResponse::decode,
            TestStackResponse.class,
            TestStackResponse.BinaryEncodingId,
            TestStackResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            TimeZoneDataType::encode,
            TimeZoneDataType::decode,
            TimeZoneDataType.class,
            TimeZoneDataType.BinaryEncodingId,
            TimeZoneDataType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            TransferResult::encode,
            TransferResult::decode,
            TransferResult.class,
            TransferResult.BinaryEncodingId,
            TransferResult.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            TransferSubscriptionsRequest::encode,
            TransferSubscriptionsRequest::decode,
            TransferSubscriptionsRequest.class,
            TransferSubscriptionsRequest.BinaryEncodingId,
            TransferSubscriptionsRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            TransferSubscriptionsResponse::encode,
            TransferSubscriptionsResponse::decode,
            TransferSubscriptionsResponse.class,
            TransferSubscriptionsResponse.BinaryEncodingId,
            TransferSubscriptionsResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            TranslateBrowsePathsToNodeIdsRequest::encode,
            TranslateBrowsePathsToNodeIdsRequest::decode,
            TranslateBrowsePathsToNodeIdsRequest.class,
            TranslateBrowsePathsToNodeIdsRequest.BinaryEncodingId,
            TranslateBrowsePathsToNodeIdsRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            TranslateBrowsePathsToNodeIdsResponse::encode,
            TranslateBrowsePathsToNodeIdsResponse::decode,
            TranslateBrowsePathsToNodeIdsResponse.class,
            TranslateBrowsePathsToNodeIdsResponse.BinaryEncodingId,
            TranslateBrowsePathsToNodeIdsResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            TrustListDataType::encode,
            TrustListDataType::decode,
            TrustListDataType.class,
            TrustListDataType.BinaryEncodingId,
            TrustListDataType.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            TypeNode::encode,
            TypeNode::decode,
            TypeNode.class,
            TypeNode.BinaryEncodingId,
            TypeNode.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            Union::encode,
            Union::decode,
            Union.class,
            Union.BinaryEncodingId,
            Union.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            UnregisterNodesRequest::encode,
            UnregisterNodesRequest::decode,
            UnregisterNodesRequest.class,
            UnregisterNodesRequest.BinaryEncodingId,
            UnregisterNodesRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            UnregisterNodesResponse::encode,
            UnregisterNodesResponse::decode,
            UnregisterNodesResponse.class,
            UnregisterNodesResponse.BinaryEncodingId,
            UnregisterNodesResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            UpdateDataDetails::encode,
            UpdateDataDetails::decode,
            UpdateDataDetails.class,
            UpdateDataDetails.BinaryEncodingId,
            UpdateDataDetails.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            UpdateEventDetails::encode,
            UpdateEventDetails::decode,
            UpdateEventDetails.class,
            UpdateEventDetails.BinaryEncodingId,
            UpdateEventDetails.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            UpdateStructureDataDetails::encode,
            UpdateStructureDataDetails::decode,
            UpdateStructureDataDetails.class,
            UpdateStructureDataDetails.BinaryEncodingId,
            UpdateStructureDataDetails.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            UserIdentityToken::encode,
            UserIdentityToken::decode,
            UserIdentityToken.class,
            UserIdentityToken.BinaryEncodingId,
            UserIdentityToken.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            UserNameIdentityToken::encode,
            UserNameIdentityToken::decode,
            UserNameIdentityToken.class,
            UserNameIdentityToken.BinaryEncodingId,
            UserNameIdentityToken.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            UserTokenPolicy::encode,
            UserTokenPolicy::decode,
            UserTokenPolicy.class,
            UserTokenPolicy.BinaryEncodingId,
            UserTokenPolicy.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            VariableAttributes::encode,
            VariableAttributes::decode,
            VariableAttributes.class,
            VariableAttributes.BinaryEncodingId,
            VariableAttributes.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            VariableNode::encode,
            VariableNode::decode,
            VariableNode.class,
            VariableNode.BinaryEncodingId,
            VariableNode.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            VariableTypeAttributes::encode,
            VariableTypeAttributes::decode,
            VariableTypeAttributes.class,
            VariableTypeAttributes.BinaryEncodingId,
            VariableTypeAttributes.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            VariableTypeNode::encode,
            VariableTypeNode::decode,
            VariableTypeNode.class,
            VariableTypeNode.BinaryEncodingId,
            VariableTypeNode.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ViewAttributes::encode,
            ViewAttributes::decode,
            ViewAttributes.class,
            ViewAttributes.BinaryEncodingId,
            ViewAttributes.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ViewDescription::encode,
            ViewDescription::decode,
            ViewDescription.class,
            ViewDescription.BinaryEncodingId,
            ViewDescription.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            ViewNode::encode,
            ViewNode::decode,
            ViewNode.class,
            ViewNode.BinaryEncodingId,
            ViewNode.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            WriteRequest::encode,
            WriteRequest::decode,
            WriteRequest.class,
            WriteRequest.BinaryEncodingId,
            WriteRequest.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            WriteResponse::encode,
            WriteResponse::decode,
            WriteResponse.class,
            WriteResponse.BinaryEncodingId,
            WriteResponse.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            WriteValue::encode,
            WriteValue::decode,
            WriteValue.class,
            WriteValue.BinaryEncodingId,
            WriteValue.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            X509IdentityToken::encode,
            X509IdentityToken::decode,
            X509IdentityToken.class,
            X509IdentityToken.BinaryEncodingId,
            X509IdentityToken.XmlEncodingId
        );
        OpcUaTypeDictionary.register(
            XVType::encode,
            XVType::decode,
            XVType.class,
            XVType.BinaryEncodingId,
            XVType.XmlEncodingId
        );
    }

}

