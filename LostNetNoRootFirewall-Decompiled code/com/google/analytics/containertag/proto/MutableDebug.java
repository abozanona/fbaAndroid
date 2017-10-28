package com.google.analytics.containertag.proto;

import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.android.vending.licensing.APKExpansionPolicy;
import com.google.tagmanager.protobuf.AbstractMutableMessageLite;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite.GeneratedExtension;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import com.google.tagmanager.protobuf.WireFormat.FieldType;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MutableDebug {

    public final class DataLayerEventEvaluationInfo extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        public static final int RESULTS_FIELD_NUMBER = 2;
        public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
        private static final DataLayerEventEvaluationInfo defaultInstance = new DataLayerEventEvaluationInfo(true);
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List results_ = null;
        private RuleEvaluationStepInfo rulesEvaluation_;

        static {
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
        }

        private DataLayerEventEvaluationInfo() {
            initFields();
        }

        private DataLayerEventEvaluationInfo(boolean z) {
        }

        private void ensureResultsInitialized() {
            if (this.results_ == null) {
                this.results_ = new ArrayList();
            }
        }

        private void ensureRulesEvaluationInitialized() {
            if (this.rulesEvaluation_ == RuleEvaluationStepInfo.getDefaultInstance()) {
                this.rulesEvaluation_ = RuleEvaluationStepInfo.newMessage();
            }
        }

        public static DataLayerEventEvaluationInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
        }

        public static DataLayerEventEvaluationInfo newMessage() {
            return new DataLayerEventEvaluationInfo();
        }

        public DataLayerEventEvaluationInfo addAllResults(Iterable iterable) {
            assertMutable();
            ensureResultsInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.results_);
            return this;
        }

        public DataLayerEventEvaluationInfo addResults(ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            ensureResultsInitialized();
            this.results_.add(resolvedFunctionCall);
            return this;
        }

        public ResolvedFunctionCall addResults() {
            assertMutable();
            ensureResultsInitialized();
            ResolvedFunctionCall newMessage = ResolvedFunctionCall.newMessage();
            this.results_.add(newMessage);
            return newMessage;
        }

        public DataLayerEventEvaluationInfo clear() {
            assertMutable();
            super.clear();
            if (this.rulesEvaluation_ != RuleEvaluationStepInfo.getDefaultInstance()) {
                this.rulesEvaluation_.clear();
            }
            this.bitField0_ &= -2;
            this.results_ = null;
            return this;
        }

        public DataLayerEventEvaluationInfo clearResults() {
            assertMutable();
            this.results_ = null;
            return this;
        }

        public DataLayerEventEvaluationInfo clearRulesEvaluation() {
            assertMutable();
            this.bitField0_ &= -2;
            if (this.rulesEvaluation_ != RuleEvaluationStepInfo.getDefaultInstance()) {
                this.rulesEvaluation_.clear();
            }
            return this;
        }

        public DataLayerEventEvaluationInfo clone() {
            return newMessageForType().mergeFrom(this);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DataLayerEventEvaluationInfo)) {
                return super.equals(obj);
            }
            DataLayerEventEvaluationInfo dataLayerEventEvaluationInfo = (DataLayerEventEvaluationInfo) obj;
            boolean z = hasRulesEvaluation() == dataLayerEventEvaluationInfo.hasRulesEvaluation();
            if (hasRulesEvaluation()) {
                z = z && getRulesEvaluation().equals(dataLayerEventEvaluationInfo.getRulesEvaluation());
            }
            return z && getResultsList().equals(dataLayerEventEvaluationInfo.getResultsList());
        }

        public final DataLayerEventEvaluationInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public ResolvedFunctionCall getMutableResults(int i) {
            return (ResolvedFunctionCall) this.results_.get(i);
        }

        public List getMutableResultsList() {
            assertMutable();
            ensureResultsInitialized();
            return this.results_;
        }

        public RuleEvaluationStepInfo getMutableRulesEvaluation() {
            assertMutable();
            ensureRulesEvaluationInitialized();
            this.bitField0_ |= 1;
            return this.rulesEvaluation_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public ResolvedFunctionCall getResults(int i) {
            return (ResolvedFunctionCall) this.results_.get(i);
        }

        public int getResultsCount() {
            return this.results_ == null ? 0 : this.results_.size();
        }

        public List getResultsList() {
            return this.results_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.results_);
        }

        public RuleEvaluationStepInfo getRulesEvaluation() {
            return this.rulesEvaluation_;
        }

        public int getSerializedSize() {
            int i;
            int i2 = 0;
            int computeMessageSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.rulesEvaluation_) + 0 : 0;
            if (this.results_ != null) {
                i = computeMessageSize;
                while (i2 < this.results_.size()) {
                    i2++;
                    i = CodedOutputStream.computeMessageSize(2, (MessageLite) this.results_.get(i2)) + i;
                }
            } else {
                i = computeMessageSize;
            }
            computeMessageSize = this.unknownFields.size() + i;
            this.cachedSize = computeMessageSize;
            return computeMessageSize;
        }

        public boolean hasRulesEvaluation() {
            return (this.bitField0_ & 1) == 1;
        }

        public int hashCode() {
            int i = 41;
            if (hasRulesEvaluation()) {
                i = 80454 + getRulesEvaluation().hashCode();
            }
            if (getResultsCount() > 0) {
                i = (((i * 37) + 2) * 53) + getResultsList().hashCode();
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.containertag.proto.Debug$DataLayerEventEvaluationInfo");
            }
            return immutableDefault;
        }

        public final boolean isInitialized() {
            if (hasRulesEvaluation() && !getRulesEvaluation().isInitialized()) {
                return false;
            }
            for (int i = 0; i < getResultsCount(); i++) {
                if (!getResults(i).isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public DataLayerEventEvaluationInfo mergeFrom(DataLayerEventEvaluationInfo dataLayerEventEvaluationInfo) {
            if (this == dataLayerEventEvaluationInfo) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (dataLayerEventEvaluationInfo != getDefaultInstance()) {
                if (dataLayerEventEvaluationInfo.hasRulesEvaluation()) {
                    ensureRulesEvaluationInitialized();
                    this.rulesEvaluation_.mergeFrom(dataLayerEventEvaluationInfo.getRulesEvaluation());
                    this.bitField0_ |= 1;
                }
                if (!(dataLayerEventEvaluationInfo.results_ == null || dataLayerEventEvaluationInfo.results_.isEmpty())) {
                    ensureResultsInitialized();
                    AbstractMutableMessageLite.addAll(dataLayerEventEvaluationInfo.results_, this.results_);
                }
                this.unknownFields = this.unknownFields.concat(dataLayerEventEvaluationInfo.unknownFields);
            }
            return this;
        }

        public boolean mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            assertMutable();
            try {
                OutputStream newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
                boolean z = false;
                while (!z) {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            z = true;
                            break;
                        case 10:
                            if (this.rulesEvaluation_ == RuleEvaluationStepInfo.getDefaultInstance()) {
                                this.rulesEvaluation_ = RuleEvaluationStepInfo.newMessage();
                            }
                            this.bitField0_ |= 1;
                            codedInputStream.readMessage(this.rulesEvaluation_, extensionRegistryLite);
                            break;
                        case 18:
                            codedInputStream.readMessage(addResults(), extensionRegistryLite);
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                z = true;
                                break;
                            }
                            break;
                    }
                }
                newInstance.flush();
                this.unknownFields = newOutput.toByteString();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        public DataLayerEventEvaluationInfo newMessageForType() {
            return new DataLayerEventEvaluationInfo();
        }

        public DataLayerEventEvaluationInfo setResults(int i, ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            ensureResultsInitialized();
            this.results_.set(i, resolvedFunctionCall);
            return this;
        }

        public DataLayerEventEvaluationInfo setRulesEvaluation(RuleEvaluationStepInfo ruleEvaluationStepInfo) {
            assertMutable();
            if (ruleEvaluationStepInfo == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.rulesEvaluation_ = ruleEvaluationStepInfo;
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessageWithCachedSizes(1, this.rulesEvaluation_);
            }
            if (this.results_ != null) {
                for (int i = 0; i < this.results_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(2, (MutableMessageLite) this.results_.get(i));
                }
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    public final class DebugEvents extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static final int EVENT_FIELD_NUMBER = 1;
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        private static final DebugEvents defaultInstance = new DebugEvents(true);
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private List event_ = null;

        static {
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
        }

        private DebugEvents() {
            initFields();
        }

        private DebugEvents(boolean z) {
        }

        private void ensureEventInitialized() {
            if (this.event_ == null) {
                this.event_ = new ArrayList();
            }
        }

        public static DebugEvents getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static DebugEvents newMessage() {
            return new DebugEvents();
        }

        public DebugEvents addAllEvent(Iterable iterable) {
            assertMutable();
            ensureEventInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.event_);
            return this;
        }

        public DebugEvents addEvent(EventInfo eventInfo) {
            assertMutable();
            if (eventInfo == null) {
                throw new NullPointerException();
            }
            ensureEventInitialized();
            this.event_.add(eventInfo);
            return this;
        }

        public EventInfo addEvent() {
            assertMutable();
            ensureEventInitialized();
            EventInfo newMessage = EventInfo.newMessage();
            this.event_.add(newMessage);
            return newMessage;
        }

        public DebugEvents clear() {
            assertMutable();
            super.clear();
            this.event_ = null;
            return this;
        }

        public DebugEvents clearEvent() {
            assertMutable();
            this.event_ = null;
            return this;
        }

        public DebugEvents clone() {
            return newMessageForType().mergeFrom(this);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DebugEvents)) {
                return super.equals(obj);
            }
            return getEventList().equals(((DebugEvents) obj).getEventList());
        }

        public final DebugEvents getDefaultInstanceForType() {
            return defaultInstance;
        }

        public EventInfo getEvent(int i) {
            return (EventInfo) this.event_.get(i);
        }

        public int getEventCount() {
            return this.event_ == null ? 0 : this.event_.size();
        }

        public List getEventList() {
            return this.event_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.event_);
        }

        public EventInfo getMutableEvent(int i) {
            return (EventInfo) this.event_.get(i);
        }

        public List getMutableEventList() {
            assertMutable();
            ensureEventInitialized();
            return this.event_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i;
            if (this.event_ != null) {
                i = 0;
                for (int i2 = 0; i2 < this.event_.size(); i2++) {
                    i += CodedOutputStream.computeMessageSize(1, (MessageLite) this.event_.get(i2));
                }
            } else {
                i = 0;
            }
            int size = this.unknownFields.size() + i;
            this.cachedSize = size;
            return size;
        }

        public int hashCode() {
            int i = 41;
            if (getEventCount() > 0) {
                i = 80454 + getEventList().hashCode();
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.containertag.proto.Debug$DebugEvents");
            }
            return immutableDefault;
        }

        public final boolean isInitialized() {
            for (int i = 0; i < getEventCount(); i++) {
                if (!getEvent(i).isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public DebugEvents mergeFrom(DebugEvents debugEvents) {
            if (this == debugEvents) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (debugEvents != getDefaultInstance()) {
                if (!(debugEvents.event_ == null || debugEvents.event_.isEmpty())) {
                    ensureEventInitialized();
                    AbstractMutableMessageLite.addAll(debugEvents.event_, this.event_);
                }
                this.unknownFields = this.unknownFields.concat(debugEvents.unknownFields);
            }
            return this;
        }

        public boolean mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            assertMutable();
            try {
                OutputStream newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
                boolean z = false;
                while (!z) {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            z = true;
                            break;
                        case 10:
                            codedInputStream.readMessage(addEvent(), extensionRegistryLite);
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                z = true;
                                break;
                            }
                            break;
                    }
                }
                newInstance.flush();
                this.unknownFields = newOutput.toByteString();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        public DebugEvents newMessageForType() {
            return new DebugEvents();
        }

        public DebugEvents setEvent(int i, EventInfo eventInfo) {
            assertMutable();
            if (eventInfo == null) {
                throw new NullPointerException();
            }
            ensureEventInitialized();
            this.event_.set(i, eventInfo);
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            if (this.event_ != null) {
                for (int i = 0; i < this.event_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(1, (MutableMessageLite) this.event_.get(i));
                }
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    public final class EventInfo extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static final int CONTAINER_ID_FIELD_NUMBER = 3;
        public static final int CONTAINER_VERSION_FIELD_NUMBER = 2;
        public static final int DATA_LAYER_EVENT_RESULT_FIELD_NUMBER = 7;
        public static final int EVENT_TYPE_FIELD_NUMBER = 1;
        public static final int KEY_FIELD_NUMBER = 4;
        public static final int MACRO_RESULT_FIELD_NUMBER = 6;
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        private static final EventInfo defaultInstance = new EventInfo(true);
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object containerId_ = Internal.EMPTY_BYTE_ARRAY;
        private Object containerVersion_ = Internal.EMPTY_BYTE_ARRAY;
        private DataLayerEventEvaluationInfo dataLayerEventResult_;
        private EventType eventType_ = EventType.DATA_LAYER_EVENT;
        private Object key_ = Internal.EMPTY_BYTE_ARRAY;
        private MacroEvaluationInfo macroResult_;

        public enum EventType implements EnumLite {
            DATA_LAYER_EVENT(0, 1),
            MACRO_REFERENCE(1, 2);
            
            public static final int DATA_LAYER_EVENT_VALUE = 1;
            public static final int MACRO_REFERENCE_VALUE = 2;
            private static EnumLiteMap internalValueMap;
            private final int value;

            static {
                internalValueMap = new C0160k();
            }

            private EventType(int i, int i2) {
                this.value = i2;
            }

            public static EnumLiteMap internalGetValueMap() {
                return internalValueMap;
            }

            public static EventType valueOf(int i) {
                switch (i) {
                    case 1:
                        return DATA_LAYER_EVENT;
                    case 2:
                        return MACRO_REFERENCE;
                    default:
                        return null;
                }
            }

            public final int getNumber() {
                return this.value;
            }
        }

        static {
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
        }

        private EventInfo() {
            initFields();
        }

        private EventInfo(boolean z) {
        }

        private void ensureDataLayerEventResultInitialized() {
            if (this.dataLayerEventResult_ == DataLayerEventEvaluationInfo.getDefaultInstance()) {
                this.dataLayerEventResult_ = DataLayerEventEvaluationInfo.newMessage();
            }
        }

        private void ensureMacroResultInitialized() {
            if (this.macroResult_ == MacroEvaluationInfo.getDefaultInstance()) {
                this.macroResult_ = MacroEvaluationInfo.newMessage();
            }
        }

        public static EventInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.eventType_ = EventType.DATA_LAYER_EVENT;
            this.macroResult_ = MacroEvaluationInfo.getDefaultInstance();
            this.dataLayerEventResult_ = DataLayerEventEvaluationInfo.getDefaultInstance();
        }

        public static EventInfo newMessage() {
            return new EventInfo();
        }

        public EventInfo clear() {
            assertMutable();
            super.clear();
            this.eventType_ = EventType.DATA_LAYER_EVENT;
            this.bitField0_ &= -2;
            this.containerVersion_ = Internal.EMPTY_BYTE_ARRAY;
            this.bitField0_ &= -3;
            this.containerId_ = Internal.EMPTY_BYTE_ARRAY;
            this.bitField0_ &= -5;
            this.key_ = Internal.EMPTY_BYTE_ARRAY;
            this.bitField0_ &= -9;
            if (this.macroResult_ != MacroEvaluationInfo.getDefaultInstance()) {
                this.macroResult_.clear();
            }
            this.bitField0_ &= -17;
            if (this.dataLayerEventResult_ != DataLayerEventEvaluationInfo.getDefaultInstance()) {
                this.dataLayerEventResult_.clear();
            }
            this.bitField0_ &= -33;
            return this;
        }

        public EventInfo clearContainerId() {
            assertMutable();
            this.bitField0_ &= -5;
            this.containerId_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public EventInfo clearContainerVersion() {
            assertMutable();
            this.bitField0_ &= -3;
            this.containerVersion_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public EventInfo clearDataLayerEventResult() {
            assertMutable();
            this.bitField0_ &= -33;
            if (this.dataLayerEventResult_ != DataLayerEventEvaluationInfo.getDefaultInstance()) {
                this.dataLayerEventResult_.clear();
            }
            return this;
        }

        public EventInfo clearEventType() {
            assertMutable();
            this.bitField0_ &= -2;
            this.eventType_ = EventType.DATA_LAYER_EVENT;
            return this;
        }

        public EventInfo clearKey() {
            assertMutable();
            this.bitField0_ &= -9;
            this.key_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public EventInfo clearMacroResult() {
            assertMutable();
            this.bitField0_ &= -17;
            if (this.macroResult_ != MacroEvaluationInfo.getDefaultInstance()) {
                this.macroResult_.clear();
            }
            return this;
        }

        public EventInfo clone() {
            return newMessageForType().mergeFrom(this);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EventInfo)) {
                return super.equals(obj);
            }
            EventInfo eventInfo = (EventInfo) obj;
            boolean z = hasEventType() == eventInfo.hasEventType();
            if (hasEventType()) {
                z = z && getEventType() == eventInfo.getEventType();
            }
            z = z && hasContainerVersion() == eventInfo.hasContainerVersion();
            if (hasContainerVersion()) {
                z = z && getContainerVersion().equals(eventInfo.getContainerVersion());
            }
            z = z && hasContainerId() == eventInfo.hasContainerId();
            if (hasContainerId()) {
                z = z && getContainerId().equals(eventInfo.getContainerId());
            }
            z = z && hasKey() == eventInfo.hasKey();
            if (hasKey()) {
                z = z && getKey().equals(eventInfo.getKey());
            }
            z = z && hasMacroResult() == eventInfo.hasMacroResult();
            if (hasMacroResult()) {
                z = z && getMacroResult().equals(eventInfo.getMacroResult());
            }
            z = z && hasDataLayerEventResult() == eventInfo.hasDataLayerEventResult();
            return hasDataLayerEventResult() ? z && getDataLayerEventResult().equals(eventInfo.getDataLayerEventResult()) : z;
        }

        public String getContainerId() {
            Object obj = this.containerId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            byte[] bArr = (byte[]) obj;
            String toStringUtf8 = Internal.toStringUtf8(bArr);
            if (Internal.isValidUtf8(bArr)) {
                this.containerId_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public byte[] getContainerIdAsBytes() {
            Object obj = this.containerId_;
            if (!(obj instanceof String)) {
                return (byte[]) obj;
            }
            obj = Internal.toByteArray((String) obj);
            this.containerId_ = obj;
            return obj;
        }

        public String getContainerVersion() {
            Object obj = this.containerVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            byte[] bArr = (byte[]) obj;
            String toStringUtf8 = Internal.toStringUtf8(bArr);
            if (Internal.isValidUtf8(bArr)) {
                this.containerVersion_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public byte[] getContainerVersionAsBytes() {
            Object obj = this.containerVersion_;
            if (!(obj instanceof String)) {
                return (byte[]) obj;
            }
            obj = Internal.toByteArray((String) obj);
            this.containerVersion_ = obj;
            return obj;
        }

        public DataLayerEventEvaluationInfo getDataLayerEventResult() {
            return this.dataLayerEventResult_;
        }

        public final EventInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public EventType getEventType() {
            return this.eventType_;
        }

        public String getKey() {
            Object obj = this.key_;
            if (obj instanceof String) {
                return (String) obj;
            }
            byte[] bArr = (byte[]) obj;
            String toStringUtf8 = Internal.toStringUtf8(bArr);
            if (Internal.isValidUtf8(bArr)) {
                this.key_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public byte[] getKeyAsBytes() {
            Object obj = this.key_;
            if (!(obj instanceof String)) {
                return (byte[]) obj;
            }
            obj = Internal.toByteArray((String) obj);
            this.key_ = obj;
            return obj;
        }

        public MacroEvaluationInfo getMacroResult() {
            return this.macroResult_;
        }

        public DataLayerEventEvaluationInfo getMutableDataLayerEventResult() {
            assertMutable();
            ensureDataLayerEventResultInitialized();
            this.bitField0_ |= 32;
            return this.dataLayerEventResult_;
        }

        public MacroEvaluationInfo getMutableMacroResult() {
            assertMutable();
            ensureMacroResultInitialized();
            this.bitField0_ |= 16;
            return this.macroResult_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = 0 + CodedOutputStream.computeEnumSize(1, this.eventType_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.computeByteArraySize(2, getContainerVersionAsBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.computeByteArraySize(3, getContainerIdAsBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.computeByteArraySize(4, getKeyAsBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                i += CodedOutputStream.computeMessageSize(6, this.macroResult_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i += CodedOutputStream.computeMessageSize(7, this.dataLayerEventResult_);
            }
            i += this.unknownFields.size();
            this.cachedSize = i;
            return i;
        }

        public boolean hasContainerId() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasContainerVersion() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasDataLayerEventResult() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasEventType() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasKey() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasMacroResult() {
            return (this.bitField0_ & 16) == 16;
        }

        public int hashCode() {
            int i = 41;
            if (hasEventType()) {
                i = 80454 + Internal.hashEnum(getEventType());
            }
            if (hasContainerVersion()) {
                i = (((i * 37) + 2) * 53) + getContainerVersion().hashCode();
            }
            if (hasContainerId()) {
                i = (((i * 37) + 3) * 53) + getContainerId().hashCode();
            }
            if (hasKey()) {
                i = (((i * 37) + 4) * 53) + getKey().hashCode();
            }
            if (hasMacroResult()) {
                i = (((i * 37) + 6) * 53) + getMacroResult().hashCode();
            }
            if (hasDataLayerEventResult()) {
                i = (((i * 37) + 7) * 53) + getDataLayerEventResult().hashCode();
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.containertag.proto.Debug$EventInfo");
            }
            return immutableDefault;
        }

        public final boolean isInitialized() {
            return (!hasMacroResult() || getMacroResult().isInitialized()) ? !hasDataLayerEventResult() || getDataLayerEventResult().isInitialized() : false;
        }

        public EventInfo mergeFrom(EventInfo eventInfo) {
            if (this == eventInfo) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (eventInfo != getDefaultInstance()) {
                byte[] bArr;
                if (eventInfo.hasEventType()) {
                    setEventType(eventInfo.getEventType());
                }
                if (eventInfo.hasContainerVersion()) {
                    this.bitField0_ |= 2;
                    if (eventInfo.containerVersion_ instanceof String) {
                        this.containerVersion_ = eventInfo.containerVersion_;
                    } else {
                        bArr = (byte[]) eventInfo.containerVersion_;
                        this.containerVersion_ = Arrays.copyOf(bArr, bArr.length);
                    }
                }
                if (eventInfo.hasContainerId()) {
                    this.bitField0_ |= 4;
                    if (eventInfo.containerId_ instanceof String) {
                        this.containerId_ = eventInfo.containerId_;
                    } else {
                        bArr = (byte[]) eventInfo.containerId_;
                        this.containerId_ = Arrays.copyOf(bArr, bArr.length);
                    }
                }
                if (eventInfo.hasKey()) {
                    this.bitField0_ |= 8;
                    if (eventInfo.key_ instanceof String) {
                        this.key_ = eventInfo.key_;
                    } else {
                        bArr = (byte[]) eventInfo.key_;
                        this.key_ = Arrays.copyOf(bArr, bArr.length);
                    }
                }
                if (eventInfo.hasMacroResult()) {
                    ensureMacroResultInitialized();
                    this.macroResult_.mergeFrom(eventInfo.getMacroResult());
                    this.bitField0_ |= 16;
                }
                if (eventInfo.hasDataLayerEventResult()) {
                    ensureDataLayerEventResultInitialized();
                    this.dataLayerEventResult_.mergeFrom(eventInfo.getDataLayerEventResult());
                    this.bitField0_ |= 32;
                }
                this.unknownFields = this.unknownFields.concat(eventInfo.unknownFields);
            }
            return this;
        }

        public boolean mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            assertMutable();
            try {
                OutputStream newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
                boolean z = false;
                while (!z) {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            z = true;
                            break;
                        case 8:
                            int readEnum = codedInputStream.readEnum();
                            EventType valueOf = EventType.valueOf(readEnum);
                            if (valueOf != null) {
                                this.bitField0_ |= 1;
                                this.eventType_ = valueOf;
                                break;
                            }
                            newInstance.writeRawVarint32(readTag);
                            newInstance.writeRawVarint32(readEnum);
                            break;
                        case 18:
                            this.bitField0_ |= 2;
                            this.containerVersion_ = codedInputStream.readByteArray();
                            break;
                        case 26:
                            this.bitField0_ |= 4;
                            this.containerId_ = codedInputStream.readByteArray();
                            break;
                        case 34:
                            this.bitField0_ |= 8;
                            this.key_ = codedInputStream.readByteArray();
                            break;
                        case 50:
                            if (this.macroResult_ == MacroEvaluationInfo.getDefaultInstance()) {
                                this.macroResult_ = MacroEvaluationInfo.newMessage();
                            }
                            this.bitField0_ |= 16;
                            codedInputStream.readMessage(this.macroResult_, extensionRegistryLite);
                            break;
                        case 58:
                            if (this.dataLayerEventResult_ == DataLayerEventEvaluationInfo.getDefaultInstance()) {
                                this.dataLayerEventResult_ = DataLayerEventEvaluationInfo.newMessage();
                            }
                            this.bitField0_ |= 32;
                            codedInputStream.readMessage(this.dataLayerEventResult_, extensionRegistryLite);
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                z = true;
                                break;
                            }
                            break;
                    }
                }
                newInstance.flush();
                this.unknownFields = newOutput.toByteString();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        public EventInfo newMessageForType() {
            return new EventInfo();
        }

        public EventInfo setContainerId(String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 4;
            this.containerId_ = str;
            return this;
        }

        public EventInfo setContainerIdAsBytes(byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 4;
            this.containerId_ = bArr;
            return this;
        }

        public EventInfo setContainerVersion(String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.containerVersion_ = str;
            return this;
        }

        public EventInfo setContainerVersionAsBytes(byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.containerVersion_ = bArr;
            return this;
        }

        public EventInfo setDataLayerEventResult(DataLayerEventEvaluationInfo dataLayerEventEvaluationInfo) {
            assertMutable();
            if (dataLayerEventEvaluationInfo == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 32;
            this.dataLayerEventResult_ = dataLayerEventEvaluationInfo;
            return this;
        }

        public EventInfo setEventType(EventType eventType) {
            assertMutable();
            if (eventType == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.eventType_ = eventType;
            return this;
        }

        public EventInfo setKey(String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 8;
            this.key_ = str;
            return this;
        }

        public EventInfo setKeyAsBytes(byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 8;
            this.key_ = bArr;
            return this;
        }

        public EventInfo setMacroResult(MacroEvaluationInfo macroEvaluationInfo) {
            assertMutable();
            if (macroEvaluationInfo == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 16;
            this.macroResult_ = macroEvaluationInfo;
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeEnum(1, this.eventType_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeByteArray(2, getContainerVersionAsBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeByteArray(3, getContainerIdAsBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeByteArray(4, getKeyAsBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessageWithCachedSizes(6, this.macroResult_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeMessageWithCachedSizes(7, this.dataLayerEventResult_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    public final class MacroEvaluationInfo extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static final int MACRO_FIELD_NUMBER = 47497405;
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        public static final int RESULT_FIELD_NUMBER = 3;
        public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
        private static final MacroEvaluationInfo defaultInstance = new MacroEvaluationInfo(true);
        private static volatile MessageLite immutableDefault = null;
        public static final GeneratedExtension macro = GeneratedMessageLite.newSingularGeneratedExtension(Value.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, 47497405, FieldType.MESSAGE, MacroEvaluationInfo.class);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private ResolvedFunctionCall result_;
        private RuleEvaluationStepInfo rulesEvaluation_;

        static {
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
        }

        private MacroEvaluationInfo() {
            initFields();
        }

        private MacroEvaluationInfo(boolean z) {
        }

        private void ensureResultInitialized() {
            if (this.result_ == ResolvedFunctionCall.getDefaultInstance()) {
                this.result_ = ResolvedFunctionCall.newMessage();
            }
        }

        private void ensureRulesEvaluationInitialized() {
            if (this.rulesEvaluation_ == RuleEvaluationStepInfo.getDefaultInstance()) {
                this.rulesEvaluation_ = RuleEvaluationStepInfo.newMessage();
            }
        }

        public static MacroEvaluationInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.rulesEvaluation_ = RuleEvaluationStepInfo.getDefaultInstance();
            this.result_ = ResolvedFunctionCall.getDefaultInstance();
        }

        public static MacroEvaluationInfo newMessage() {
            return new MacroEvaluationInfo();
        }

        public MacroEvaluationInfo clear() {
            assertMutable();
            super.clear();
            if (this.rulesEvaluation_ != RuleEvaluationStepInfo.getDefaultInstance()) {
                this.rulesEvaluation_.clear();
            }
            this.bitField0_ &= -2;
            if (this.result_ != ResolvedFunctionCall.getDefaultInstance()) {
                this.result_.clear();
            }
            this.bitField0_ &= -3;
            return this;
        }

        public MacroEvaluationInfo clearResult() {
            assertMutable();
            this.bitField0_ &= -3;
            if (this.result_ != ResolvedFunctionCall.getDefaultInstance()) {
                this.result_.clear();
            }
            return this;
        }

        public MacroEvaluationInfo clearRulesEvaluation() {
            assertMutable();
            this.bitField0_ &= -2;
            if (this.rulesEvaluation_ != RuleEvaluationStepInfo.getDefaultInstance()) {
                this.rulesEvaluation_.clear();
            }
            return this;
        }

        public MacroEvaluationInfo clone() {
            return newMessageForType().mergeFrom(this);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MacroEvaluationInfo)) {
                return super.equals(obj);
            }
            MacroEvaluationInfo macroEvaluationInfo = (MacroEvaluationInfo) obj;
            boolean z = hasRulesEvaluation() == macroEvaluationInfo.hasRulesEvaluation();
            if (hasRulesEvaluation()) {
                z = z && getRulesEvaluation().equals(macroEvaluationInfo.getRulesEvaluation());
            }
            z = z && hasResult() == macroEvaluationInfo.hasResult();
            return hasResult() ? z && getResult().equals(macroEvaluationInfo.getResult()) : z;
        }

        public final MacroEvaluationInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public ResolvedFunctionCall getMutableResult() {
            assertMutable();
            ensureResultInitialized();
            this.bitField0_ |= 2;
            return this.result_;
        }

        public RuleEvaluationStepInfo getMutableRulesEvaluation() {
            assertMutable();
            ensureRulesEvaluationInitialized();
            this.bitField0_ |= 1;
            return this.rulesEvaluation_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public ResolvedFunctionCall getResult() {
            return this.result_;
        }

        public RuleEvaluationStepInfo getRulesEvaluation() {
            return this.rulesEvaluation_;
        }

        public int getSerializedSize() {
            int i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = 0 + CodedOutputStream.computeMessageSize(1, this.rulesEvaluation_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.computeMessageSize(3, this.result_);
            }
            i += this.unknownFields.size();
            this.cachedSize = i;
            return i;
        }

        public boolean hasResult() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasRulesEvaluation() {
            return (this.bitField0_ & 1) == 1;
        }

        public int hashCode() {
            int i = 41;
            if (hasRulesEvaluation()) {
                i = 80454 + getRulesEvaluation().hashCode();
            }
            if (hasResult()) {
                i = (((i * 37) + 3) * 53) + getResult().hashCode();
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.containertag.proto.Debug$MacroEvaluationInfo");
            }
            return immutableDefault;
        }

        public final boolean isInitialized() {
            return (!hasRulesEvaluation() || getRulesEvaluation().isInitialized()) ? !hasResult() || getResult().isInitialized() : false;
        }

        public MacroEvaluationInfo mergeFrom(MacroEvaluationInfo macroEvaluationInfo) {
            if (this == macroEvaluationInfo) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (macroEvaluationInfo != getDefaultInstance()) {
                if (macroEvaluationInfo.hasRulesEvaluation()) {
                    ensureRulesEvaluationInitialized();
                    this.rulesEvaluation_.mergeFrom(macroEvaluationInfo.getRulesEvaluation());
                    this.bitField0_ |= 1;
                }
                if (macroEvaluationInfo.hasResult()) {
                    ensureResultInitialized();
                    this.result_.mergeFrom(macroEvaluationInfo.getResult());
                    this.bitField0_ |= 2;
                }
                this.unknownFields = this.unknownFields.concat(macroEvaluationInfo.unknownFields);
            }
            return this;
        }

        public boolean mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            assertMutable();
            try {
                OutputStream newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
                boolean z = false;
                while (!z) {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            z = true;
                            break;
                        case 10:
                            if (this.rulesEvaluation_ == RuleEvaluationStepInfo.getDefaultInstance()) {
                                this.rulesEvaluation_ = RuleEvaluationStepInfo.newMessage();
                            }
                            this.bitField0_ |= 1;
                            codedInputStream.readMessage(this.rulesEvaluation_, extensionRegistryLite);
                            break;
                        case 26:
                            if (this.result_ == ResolvedFunctionCall.getDefaultInstance()) {
                                this.result_ = ResolvedFunctionCall.newMessage();
                            }
                            this.bitField0_ |= 2;
                            codedInputStream.readMessage(this.result_, extensionRegistryLite);
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                z = true;
                                break;
                            }
                            break;
                    }
                }
                newInstance.flush();
                this.unknownFields = newOutput.toByteString();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        public MacroEvaluationInfo newMessageForType() {
            return new MacroEvaluationInfo();
        }

        public MacroEvaluationInfo setResult(ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.result_ = resolvedFunctionCall;
            return this;
        }

        public MacroEvaluationInfo setRulesEvaluation(RuleEvaluationStepInfo ruleEvaluationStepInfo) {
            assertMutable();
            if (ruleEvaluationStepInfo == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.rulesEvaluation_ = ruleEvaluationStepInfo;
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessageWithCachedSizes(1, this.rulesEvaluation_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessageWithCachedSizes(3, this.result_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    public final class ResolvedFunctionCall extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static final int ASSOCIATED_RULE_NAME_FIELD_NUMBER = 3;
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        public static final int PROPERTIES_FIELD_NUMBER = 1;
        public static final int RESULT_FIELD_NUMBER = 2;
        private static final ResolvedFunctionCall defaultInstance = new ResolvedFunctionCall(true);
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private Object associatedRuleName_ = Internal.EMPTY_BYTE_ARRAY;
        private int bitField0_;
        private List properties_ = null;
        private Value result_;

        static {
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
        }

        private ResolvedFunctionCall() {
            initFields();
        }

        private ResolvedFunctionCall(boolean z) {
        }

        private void ensurePropertiesInitialized() {
            if (this.properties_ == null) {
                this.properties_ = new ArrayList();
            }
        }

        private void ensureResultInitialized() {
            if (this.result_ == Value.getDefaultInstance()) {
                this.result_ = Value.newMessage();
            }
        }

        public static ResolvedFunctionCall getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.result_ = Value.getDefaultInstance();
        }

        public static ResolvedFunctionCall newMessage() {
            return new ResolvedFunctionCall();
        }

        public ResolvedFunctionCall addAllProperties(Iterable iterable) {
            assertMutable();
            ensurePropertiesInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.properties_);
            return this;
        }

        public ResolvedFunctionCall addProperties(ResolvedProperty resolvedProperty) {
            assertMutable();
            if (resolvedProperty == null) {
                throw new NullPointerException();
            }
            ensurePropertiesInitialized();
            this.properties_.add(resolvedProperty);
            return this;
        }

        public ResolvedProperty addProperties() {
            assertMutable();
            ensurePropertiesInitialized();
            ResolvedProperty newMessage = ResolvedProperty.newMessage();
            this.properties_.add(newMessage);
            return newMessage;
        }

        public ResolvedFunctionCall clear() {
            assertMutable();
            super.clear();
            this.properties_ = null;
            if (this.result_ != Value.getDefaultInstance()) {
                this.result_.clear();
            }
            this.bitField0_ &= -2;
            this.associatedRuleName_ = Internal.EMPTY_BYTE_ARRAY;
            this.bitField0_ &= -3;
            return this;
        }

        public ResolvedFunctionCall clearAssociatedRuleName() {
            assertMutable();
            this.bitField0_ &= -3;
            this.associatedRuleName_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public ResolvedFunctionCall clearProperties() {
            assertMutable();
            this.properties_ = null;
            return this;
        }

        public ResolvedFunctionCall clearResult() {
            assertMutable();
            this.bitField0_ &= -2;
            if (this.result_ != Value.getDefaultInstance()) {
                this.result_.clear();
            }
            return this;
        }

        public ResolvedFunctionCall clone() {
            return newMessageForType().mergeFrom(this);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ResolvedFunctionCall)) {
                return super.equals(obj);
            }
            ResolvedFunctionCall resolvedFunctionCall = (ResolvedFunctionCall) obj;
            boolean z = (getPropertiesList().equals(resolvedFunctionCall.getPropertiesList())) && hasResult() == resolvedFunctionCall.hasResult();
            if (hasResult()) {
                z = z && getResult().equals(resolvedFunctionCall.getResult());
            }
            z = z && hasAssociatedRuleName() == resolvedFunctionCall.hasAssociatedRuleName();
            return hasAssociatedRuleName() ? z && getAssociatedRuleName().equals(resolvedFunctionCall.getAssociatedRuleName()) : z;
        }

        public String getAssociatedRuleName() {
            Object obj = this.associatedRuleName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            byte[] bArr = (byte[]) obj;
            String toStringUtf8 = Internal.toStringUtf8(bArr);
            if (Internal.isValidUtf8(bArr)) {
                this.associatedRuleName_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public byte[] getAssociatedRuleNameAsBytes() {
            Object obj = this.associatedRuleName_;
            if (!(obj instanceof String)) {
                return (byte[]) obj;
            }
            obj = Internal.toByteArray((String) obj);
            this.associatedRuleName_ = obj;
            return obj;
        }

        public final ResolvedFunctionCall getDefaultInstanceForType() {
            return defaultInstance;
        }

        public ResolvedProperty getMutableProperties(int i) {
            return (ResolvedProperty) this.properties_.get(i);
        }

        public List getMutablePropertiesList() {
            assertMutable();
            ensurePropertiesInitialized();
            return this.properties_;
        }

        public Value getMutableResult() {
            assertMutable();
            ensureResultInitialized();
            this.bitField0_ |= 1;
            return this.result_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public ResolvedProperty getProperties(int i) {
            return (ResolvedProperty) this.properties_.get(i);
        }

        public int getPropertiesCount() {
            return this.properties_ == null ? 0 : this.properties_.size();
        }

        public List getPropertiesList() {
            return this.properties_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.properties_);
        }

        public Value getResult() {
            return this.result_;
        }

        public int getSerializedSize() {
            int i;
            if (this.properties_ != null) {
                i = 0;
                for (int i2 = 0; i2 < this.properties_.size(); i2++) {
                    i += CodedOutputStream.computeMessageSize(1, (MessageLite) this.properties_.get(i2));
                }
            } else {
                i = 0;
            }
            if ((this.bitField0_ & 1) == 1) {
                i += CodedOutputStream.computeMessageSize(2, this.result_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.computeByteArraySize(3, getAssociatedRuleNameAsBytes());
            }
            int size = this.unknownFields.size() + i;
            this.cachedSize = size;
            return size;
        }

        public boolean hasAssociatedRuleName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasResult() {
            return (this.bitField0_ & 1) == 1;
        }

        public int hashCode() {
            int i = 41;
            if (getPropertiesCount() > 0) {
                i = 80454 + getPropertiesList().hashCode();
            }
            if (hasResult()) {
                i = (((i * 37) + 2) * 53) + getResult().hashCode();
            }
            if (hasAssociatedRuleName()) {
                i = (((i * 37) + 3) * 53) + getAssociatedRuleName().hashCode();
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.containertag.proto.Debug$ResolvedFunctionCall");
            }
            return immutableDefault;
        }

        public final boolean isInitialized() {
            for (int i = 0; i < getPropertiesCount(); i++) {
                if (!getProperties(i).isInitialized()) {
                    return false;
                }
            }
            return !hasResult() || getResult().isInitialized();
        }

        public ResolvedFunctionCall mergeFrom(ResolvedFunctionCall resolvedFunctionCall) {
            if (this == resolvedFunctionCall) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (resolvedFunctionCall != getDefaultInstance()) {
                if (!(resolvedFunctionCall.properties_ == null || resolvedFunctionCall.properties_.isEmpty())) {
                    ensurePropertiesInitialized();
                    AbstractMutableMessageLite.addAll(resolvedFunctionCall.properties_, this.properties_);
                }
                if (resolvedFunctionCall.hasResult()) {
                    ensureResultInitialized();
                    this.result_.mergeFrom(resolvedFunctionCall.getResult());
                    this.bitField0_ |= 1;
                }
                if (resolvedFunctionCall.hasAssociatedRuleName()) {
                    this.bitField0_ |= 2;
                    if (resolvedFunctionCall.associatedRuleName_ instanceof String) {
                        this.associatedRuleName_ = resolvedFunctionCall.associatedRuleName_;
                    } else {
                        byte[] bArr = (byte[]) resolvedFunctionCall.associatedRuleName_;
                        this.associatedRuleName_ = Arrays.copyOf(bArr, bArr.length);
                    }
                }
                this.unknownFields = this.unknownFields.concat(resolvedFunctionCall.unknownFields);
            }
            return this;
        }

        public boolean mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            assertMutable();
            try {
                OutputStream newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
                boolean z = false;
                while (!z) {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            z = true;
                            break;
                        case 10:
                            codedInputStream.readMessage(addProperties(), extensionRegistryLite);
                            break;
                        case 18:
                            if (this.result_ == Value.getDefaultInstance()) {
                                this.result_ = Value.newMessage();
                            }
                            this.bitField0_ |= 1;
                            codedInputStream.readMessage(this.result_, extensionRegistryLite);
                            break;
                        case 26:
                            this.bitField0_ |= 2;
                            this.associatedRuleName_ = codedInputStream.readByteArray();
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                z = true;
                                break;
                            }
                            break;
                    }
                }
                newInstance.flush();
                this.unknownFields = newOutput.toByteString();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        public ResolvedFunctionCall newMessageForType() {
            return new ResolvedFunctionCall();
        }

        public ResolvedFunctionCall setAssociatedRuleName(String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.associatedRuleName_ = str;
            return this;
        }

        public ResolvedFunctionCall setAssociatedRuleNameAsBytes(byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.associatedRuleName_ = bArr;
            return this;
        }

        public ResolvedFunctionCall setProperties(int i, ResolvedProperty resolvedProperty) {
            assertMutable();
            if (resolvedProperty == null) {
                throw new NullPointerException();
            }
            ensurePropertiesInitialized();
            this.properties_.set(i, resolvedProperty);
            return this;
        }

        public ResolvedFunctionCall setResult(Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.result_ = value;
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            if (this.properties_ != null) {
                for (int i = 0; i < this.properties_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(1, (MutableMessageLite) this.properties_.get(i));
                }
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessageWithCachedSizes(2, this.result_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeByteArray(3, getAssociatedRuleNameAsBytes());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    public final class ResolvedProperty extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static final int KEY_FIELD_NUMBER = 1;
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final ResolvedProperty defaultInstance = new ResolvedProperty(true);
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object key_ = Internal.EMPTY_BYTE_ARRAY;
        private Value value_;

        static {
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
        }

        private ResolvedProperty() {
            initFields();
        }

        private ResolvedProperty(boolean z) {
        }

        private void ensureValueInitialized() {
            if (this.value_ == Value.getDefaultInstance()) {
                this.value_ = Value.newMessage();
            }
        }

        public static ResolvedProperty getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.value_ = Value.getDefaultInstance();
        }

        public static ResolvedProperty newMessage() {
            return new ResolvedProperty();
        }

        public ResolvedProperty clear() {
            assertMutable();
            super.clear();
            this.key_ = Internal.EMPTY_BYTE_ARRAY;
            this.bitField0_ &= -2;
            if (this.value_ != Value.getDefaultInstance()) {
                this.value_.clear();
            }
            this.bitField0_ &= -3;
            return this;
        }

        public ResolvedProperty clearKey() {
            assertMutable();
            this.bitField0_ &= -2;
            this.key_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public ResolvedProperty clearValue() {
            assertMutable();
            this.bitField0_ &= -3;
            if (this.value_ != Value.getDefaultInstance()) {
                this.value_.clear();
            }
            return this;
        }

        public ResolvedProperty clone() {
            return newMessageForType().mergeFrom(this);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ResolvedProperty)) {
                return super.equals(obj);
            }
            ResolvedProperty resolvedProperty = (ResolvedProperty) obj;
            boolean z = hasKey() == resolvedProperty.hasKey();
            if (hasKey()) {
                z = z && getKey().equals(resolvedProperty.getKey());
            }
            z = z && hasValue() == resolvedProperty.hasValue();
            return hasValue() ? z && getValue().equals(resolvedProperty.getValue()) : z;
        }

        public final ResolvedProperty getDefaultInstanceForType() {
            return defaultInstance;
        }

        public String getKey() {
            Object obj = this.key_;
            if (obj instanceof String) {
                return (String) obj;
            }
            byte[] bArr = (byte[]) obj;
            String toStringUtf8 = Internal.toStringUtf8(bArr);
            if (Internal.isValidUtf8(bArr)) {
                this.key_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public byte[] getKeyAsBytes() {
            Object obj = this.key_;
            if (!(obj instanceof String)) {
                return (byte[]) obj;
            }
            obj = Internal.toByteArray((String) obj);
            this.key_ = obj;
            return obj;
        }

        public Value getMutableValue() {
            assertMutable();
            ensureValueInitialized();
            this.bitField0_ |= 2;
            return this.value_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = 0 + CodedOutputStream.computeByteArraySize(1, getKeyAsBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.computeMessageSize(2, this.value_);
            }
            i += this.unknownFields.size();
            this.cachedSize = i;
            return i;
        }

        public Value getValue() {
            return this.value_;
        }

        public boolean hasKey() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasValue() {
            return (this.bitField0_ & 2) == 2;
        }

        public int hashCode() {
            int i = 41;
            if (hasKey()) {
                i = 80454 + getKey().hashCode();
            }
            if (hasValue()) {
                i = (((i * 37) + 2) * 53) + getValue().hashCode();
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.containertag.proto.Debug$ResolvedProperty");
            }
            return immutableDefault;
        }

        public final boolean isInitialized() {
            return !hasValue() || getValue().isInitialized();
        }

        public ResolvedProperty mergeFrom(ResolvedProperty resolvedProperty) {
            if (this == resolvedProperty) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (resolvedProperty != getDefaultInstance()) {
                if (resolvedProperty.hasKey()) {
                    this.bitField0_ |= 1;
                    if (resolvedProperty.key_ instanceof String) {
                        this.key_ = resolvedProperty.key_;
                    } else {
                        byte[] bArr = (byte[]) resolvedProperty.key_;
                        this.key_ = Arrays.copyOf(bArr, bArr.length);
                    }
                }
                if (resolvedProperty.hasValue()) {
                    ensureValueInitialized();
                    this.value_.mergeFrom(resolvedProperty.getValue());
                    this.bitField0_ |= 2;
                }
                this.unknownFields = this.unknownFields.concat(resolvedProperty.unknownFields);
            }
            return this;
        }

        public boolean mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            assertMutable();
            try {
                OutputStream newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
                boolean z = false;
                while (!z) {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            z = true;
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.key_ = codedInputStream.readByteArray();
                            break;
                        case 18:
                            if (this.value_ == Value.getDefaultInstance()) {
                                this.value_ = Value.newMessage();
                            }
                            this.bitField0_ |= 2;
                            codedInputStream.readMessage(this.value_, extensionRegistryLite);
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                z = true;
                                break;
                            }
                            break;
                    }
                }
                newInstance.flush();
                this.unknownFields = newOutput.toByteString();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        public ResolvedProperty newMessageForType() {
            return new ResolvedProperty();
        }

        public ResolvedProperty setKey(String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.key_ = str;
            return this;
        }

        public ResolvedProperty setKeyAsBytes(byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.key_ = bArr;
            return this;
        }

        public ResolvedProperty setValue(Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.value_ = value;
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeByteArray(1, getKeyAsBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessageWithCachedSizes(2, this.value_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    public final class ResolvedRule extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static final int ADD_MACROS_FIELD_NUMBER = 5;
        public static final int ADD_TAGS_FIELD_NUMBER = 3;
        public static final int NEGATIVE_PREDICATES_FIELD_NUMBER = 2;
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        public static final int POSITIVE_PREDICATES_FIELD_NUMBER = 1;
        public static final int REMOVE_MACROS_FIELD_NUMBER = 6;
        public static final int REMOVE_TAGS_FIELD_NUMBER = 4;
        public static final int RESULT_FIELD_NUMBER = 7;
        private static final ResolvedRule defaultInstance = new ResolvedRule(true);
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private List addMacros_ = null;
        private List addTags_ = null;
        private int bitField0_;
        private List negativePredicates_ = null;
        private List positivePredicates_ = null;
        private List removeMacros_ = null;
        private List removeTags_ = null;
        private Value result_;

        static {
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
        }

        private ResolvedRule() {
            initFields();
        }

        private ResolvedRule(boolean z) {
        }

        private void ensureAddMacrosInitialized() {
            if (this.addMacros_ == null) {
                this.addMacros_ = new ArrayList();
            }
        }

        private void ensureAddTagsInitialized() {
            if (this.addTags_ == null) {
                this.addTags_ = new ArrayList();
            }
        }

        private void ensureNegativePredicatesInitialized() {
            if (this.negativePredicates_ == null) {
                this.negativePredicates_ = new ArrayList();
            }
        }

        private void ensurePositivePredicatesInitialized() {
            if (this.positivePredicates_ == null) {
                this.positivePredicates_ = new ArrayList();
            }
        }

        private void ensureRemoveMacrosInitialized() {
            if (this.removeMacros_ == null) {
                this.removeMacros_ = new ArrayList();
            }
        }

        private void ensureRemoveTagsInitialized() {
            if (this.removeTags_ == null) {
                this.removeTags_ = new ArrayList();
            }
        }

        private void ensureResultInitialized() {
            if (this.result_ == Value.getDefaultInstance()) {
                this.result_ = Value.newMessage();
            }
        }

        public static ResolvedRule getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.result_ = Value.getDefaultInstance();
        }

        public static ResolvedRule newMessage() {
            return new ResolvedRule();
        }

        public ResolvedFunctionCall addAddMacros() {
            assertMutable();
            ensureAddMacrosInitialized();
            ResolvedFunctionCall newMessage = ResolvedFunctionCall.newMessage();
            this.addMacros_.add(newMessage);
            return newMessage;
        }

        public ResolvedRule addAddMacros(ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            ensureAddMacrosInitialized();
            this.addMacros_.add(resolvedFunctionCall);
            return this;
        }

        public ResolvedFunctionCall addAddTags() {
            assertMutable();
            ensureAddTagsInitialized();
            ResolvedFunctionCall newMessage = ResolvedFunctionCall.newMessage();
            this.addTags_.add(newMessage);
            return newMessage;
        }

        public ResolvedRule addAddTags(ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            ensureAddTagsInitialized();
            this.addTags_.add(resolvedFunctionCall);
            return this;
        }

        public ResolvedRule addAllAddMacros(Iterable iterable) {
            assertMutable();
            ensureAddMacrosInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.addMacros_);
            return this;
        }

        public ResolvedRule addAllAddTags(Iterable iterable) {
            assertMutable();
            ensureAddTagsInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.addTags_);
            return this;
        }

        public ResolvedRule addAllNegativePredicates(Iterable iterable) {
            assertMutable();
            ensureNegativePredicatesInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.negativePredicates_);
            return this;
        }

        public ResolvedRule addAllPositivePredicates(Iterable iterable) {
            assertMutable();
            ensurePositivePredicatesInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.positivePredicates_);
            return this;
        }

        public ResolvedRule addAllRemoveMacros(Iterable iterable) {
            assertMutable();
            ensureRemoveMacrosInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.removeMacros_);
            return this;
        }

        public ResolvedRule addAllRemoveTags(Iterable iterable) {
            assertMutable();
            ensureRemoveTagsInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.removeTags_);
            return this;
        }

        public ResolvedFunctionCall addNegativePredicates() {
            assertMutable();
            ensureNegativePredicatesInitialized();
            ResolvedFunctionCall newMessage = ResolvedFunctionCall.newMessage();
            this.negativePredicates_.add(newMessage);
            return newMessage;
        }

        public ResolvedRule addNegativePredicates(ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            ensureNegativePredicatesInitialized();
            this.negativePredicates_.add(resolvedFunctionCall);
            return this;
        }

        public ResolvedFunctionCall addPositivePredicates() {
            assertMutable();
            ensurePositivePredicatesInitialized();
            ResolvedFunctionCall newMessage = ResolvedFunctionCall.newMessage();
            this.positivePredicates_.add(newMessage);
            return newMessage;
        }

        public ResolvedRule addPositivePredicates(ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            ensurePositivePredicatesInitialized();
            this.positivePredicates_.add(resolvedFunctionCall);
            return this;
        }

        public ResolvedFunctionCall addRemoveMacros() {
            assertMutable();
            ensureRemoveMacrosInitialized();
            ResolvedFunctionCall newMessage = ResolvedFunctionCall.newMessage();
            this.removeMacros_.add(newMessage);
            return newMessage;
        }

        public ResolvedRule addRemoveMacros(ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            ensureRemoveMacrosInitialized();
            this.removeMacros_.add(resolvedFunctionCall);
            return this;
        }

        public ResolvedFunctionCall addRemoveTags() {
            assertMutable();
            ensureRemoveTagsInitialized();
            ResolvedFunctionCall newMessage = ResolvedFunctionCall.newMessage();
            this.removeTags_.add(newMessage);
            return newMessage;
        }

        public ResolvedRule addRemoveTags(ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            ensureRemoveTagsInitialized();
            this.removeTags_.add(resolvedFunctionCall);
            return this;
        }

        public ResolvedRule clear() {
            assertMutable();
            super.clear();
            this.positivePredicates_ = null;
            this.negativePredicates_ = null;
            this.addTags_ = null;
            this.removeTags_ = null;
            this.addMacros_ = null;
            this.removeMacros_ = null;
            if (this.result_ != Value.getDefaultInstance()) {
                this.result_.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        public ResolvedRule clearAddMacros() {
            assertMutable();
            this.addMacros_ = null;
            return this;
        }

        public ResolvedRule clearAddTags() {
            assertMutable();
            this.addTags_ = null;
            return this;
        }

        public ResolvedRule clearNegativePredicates() {
            assertMutable();
            this.negativePredicates_ = null;
            return this;
        }

        public ResolvedRule clearPositivePredicates() {
            assertMutable();
            this.positivePredicates_ = null;
            return this;
        }

        public ResolvedRule clearRemoveMacros() {
            assertMutable();
            this.removeMacros_ = null;
            return this;
        }

        public ResolvedRule clearRemoveTags() {
            assertMutable();
            this.removeTags_ = null;
            return this;
        }

        public ResolvedRule clearResult() {
            assertMutable();
            this.bitField0_ &= -2;
            if (this.result_ != Value.getDefaultInstance()) {
                this.result_.clear();
            }
            return this;
        }

        public ResolvedRule clone() {
            return newMessageForType().mergeFrom(this);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ResolvedRule)) {
                return super.equals(obj);
            }
            ResolvedRule resolvedRule = (ResolvedRule) obj;
            boolean z = (getPositivePredicatesList().equals(resolvedRule.getPositivePredicatesList())) && getNegativePredicatesList().equals(resolvedRule.getNegativePredicatesList());
            z = z && getAddTagsList().equals(resolvedRule.getAddTagsList());
            z = z && getRemoveTagsList().equals(resolvedRule.getRemoveTagsList());
            z = z && getAddMacrosList().equals(resolvedRule.getAddMacrosList());
            z = z && getRemoveMacrosList().equals(resolvedRule.getRemoveMacrosList());
            z = z && hasResult() == resolvedRule.hasResult();
            return hasResult() ? z && getResult().equals(resolvedRule.getResult()) : z;
        }

        public ResolvedFunctionCall getAddMacros(int i) {
            return (ResolvedFunctionCall) this.addMacros_.get(i);
        }

        public int getAddMacrosCount() {
            return this.addMacros_ == null ? 0 : this.addMacros_.size();
        }

        public List getAddMacrosList() {
            return this.addMacros_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.addMacros_);
        }

        public ResolvedFunctionCall getAddTags(int i) {
            return (ResolvedFunctionCall) this.addTags_.get(i);
        }

        public int getAddTagsCount() {
            return this.addTags_ == null ? 0 : this.addTags_.size();
        }

        public List getAddTagsList() {
            return this.addTags_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.addTags_);
        }

        public final ResolvedRule getDefaultInstanceForType() {
            return defaultInstance;
        }

        public ResolvedFunctionCall getMutableAddMacros(int i) {
            return (ResolvedFunctionCall) this.addMacros_.get(i);
        }

        public List getMutableAddMacrosList() {
            assertMutable();
            ensureAddMacrosInitialized();
            return this.addMacros_;
        }

        public ResolvedFunctionCall getMutableAddTags(int i) {
            return (ResolvedFunctionCall) this.addTags_.get(i);
        }

        public List getMutableAddTagsList() {
            assertMutable();
            ensureAddTagsInitialized();
            return this.addTags_;
        }

        public ResolvedFunctionCall getMutableNegativePredicates(int i) {
            return (ResolvedFunctionCall) this.negativePredicates_.get(i);
        }

        public List getMutableNegativePredicatesList() {
            assertMutable();
            ensureNegativePredicatesInitialized();
            return this.negativePredicates_;
        }

        public ResolvedFunctionCall getMutablePositivePredicates(int i) {
            return (ResolvedFunctionCall) this.positivePredicates_.get(i);
        }

        public List getMutablePositivePredicatesList() {
            assertMutable();
            ensurePositivePredicatesInitialized();
            return this.positivePredicates_;
        }

        public ResolvedFunctionCall getMutableRemoveMacros(int i) {
            return (ResolvedFunctionCall) this.removeMacros_.get(i);
        }

        public List getMutableRemoveMacrosList() {
            assertMutable();
            ensureRemoveMacrosInitialized();
            return this.removeMacros_;
        }

        public ResolvedFunctionCall getMutableRemoveTags(int i) {
            return (ResolvedFunctionCall) this.removeTags_.get(i);
        }

        public List getMutableRemoveTagsList() {
            assertMutable();
            ensureRemoveTagsInitialized();
            return this.removeTags_;
        }

        public Value getMutableResult() {
            assertMutable();
            ensureResultInitialized();
            this.bitField0_ |= 1;
            return this.result_;
        }

        public ResolvedFunctionCall getNegativePredicates(int i) {
            return (ResolvedFunctionCall) this.negativePredicates_.get(i);
        }

        public int getNegativePredicatesCount() {
            return this.negativePredicates_ == null ? 0 : this.negativePredicates_.size();
        }

        public List getNegativePredicatesList() {
            return this.negativePredicates_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.negativePredicates_);
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public ResolvedFunctionCall getPositivePredicates(int i) {
            return (ResolvedFunctionCall) this.positivePredicates_.get(i);
        }

        public int getPositivePredicatesCount() {
            return this.positivePredicates_ == null ? 0 : this.positivePredicates_.size();
        }

        public List getPositivePredicatesList() {
            return this.positivePredicates_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.positivePredicates_);
        }

        public ResolvedFunctionCall getRemoveMacros(int i) {
            return (ResolvedFunctionCall) this.removeMacros_.get(i);
        }

        public int getRemoveMacrosCount() {
            return this.removeMacros_ == null ? 0 : this.removeMacros_.size();
        }

        public List getRemoveMacrosList() {
            return this.removeMacros_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.removeMacros_);
        }

        public ResolvedFunctionCall getRemoveTags(int i) {
            return (ResolvedFunctionCall) this.removeTags_.get(i);
        }

        public int getRemoveTagsCount() {
            return this.removeTags_ == null ? 0 : this.removeTags_.size();
        }

        public List getRemoveTagsList() {
            return this.removeTags_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.removeTags_);
        }

        public Value getResult() {
            return this.result_;
        }

        public int getSerializedSize() {
            int i;
            int i2;
            int i3 = 0;
            if (this.positivePredicates_ != null) {
                i = 0;
                for (i2 = 0; i2 < this.positivePredicates_.size(); i2++) {
                    i += CodedOutputStream.computeMessageSize(1, (MessageLite) this.positivePredicates_.get(i2));
                }
            } else {
                i = 0;
            }
            if (this.negativePredicates_ != null) {
                for (i2 = 0; i2 < this.negativePredicates_.size(); i2++) {
                    i += CodedOutputStream.computeMessageSize(2, (MessageLite) this.negativePredicates_.get(i2));
                }
            }
            if (this.addTags_ != null) {
                for (i2 = 0; i2 < this.addTags_.size(); i2++) {
                    i += CodedOutputStream.computeMessageSize(3, (MessageLite) this.addTags_.get(i2));
                }
            }
            if (this.removeTags_ != null) {
                for (i2 = 0; i2 < this.removeTags_.size(); i2++) {
                    i += CodedOutputStream.computeMessageSize(4, (MessageLite) this.removeTags_.get(i2));
                }
            }
            if (this.addMacros_ != null) {
                for (i2 = 0; i2 < this.addMacros_.size(); i2++) {
                    i += CodedOutputStream.computeMessageSize(5, (MessageLite) this.addMacros_.get(i2));
                }
            }
            if (this.removeMacros_ != null) {
                while (i3 < this.removeMacros_.size()) {
                    i += CodedOutputStream.computeMessageSize(6, (MessageLite) this.removeMacros_.get(i3));
                    i3++;
                }
            }
            if ((this.bitField0_ & 1) == 1) {
                i += CodedOutputStream.computeMessageSize(7, this.result_);
            }
            int size = this.unknownFields.size() + i;
            this.cachedSize = size;
            return size;
        }

        public boolean hasResult() {
            return (this.bitField0_ & 1) == 1;
        }

        public int hashCode() {
            int i = 41;
            if (getPositivePredicatesCount() > 0) {
                i = 80454 + getPositivePredicatesList().hashCode();
            }
            if (getNegativePredicatesCount() > 0) {
                i = (((i * 37) + 2) * 53) + getNegativePredicatesList().hashCode();
            }
            if (getAddTagsCount() > 0) {
                i = (((i * 37) + 3) * 53) + getAddTagsList().hashCode();
            }
            if (getRemoveTagsCount() > 0) {
                i = (((i * 37) + 4) * 53) + getRemoveTagsList().hashCode();
            }
            if (getAddMacrosCount() > 0) {
                i = (((i * 37) + 5) * 53) + getAddMacrosList().hashCode();
            }
            if (getRemoveMacrosCount() > 0) {
                i = (((i * 37) + 6) * 53) + getRemoveMacrosList().hashCode();
            }
            if (hasResult()) {
                i = (((i * 37) + 7) * 53) + getResult().hashCode();
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.containertag.proto.Debug$ResolvedRule");
            }
            return immutableDefault;
        }

        public final boolean isInitialized() {
            int i;
            for (i = 0; i < getPositivePredicatesCount(); i++) {
                if (!getPositivePredicates(i).isInitialized()) {
                    return false;
                }
            }
            for (i = 0; i < getNegativePredicatesCount(); i++) {
                if (!getNegativePredicates(i).isInitialized()) {
                    return false;
                }
            }
            for (i = 0; i < getAddTagsCount(); i++) {
                if (!getAddTags(i).isInitialized()) {
                    return false;
                }
            }
            for (i = 0; i < getRemoveTagsCount(); i++) {
                if (!getRemoveTags(i).isInitialized()) {
                    return false;
                }
            }
            for (i = 0; i < getAddMacrosCount(); i++) {
                if (!getAddMacros(i).isInitialized()) {
                    return false;
                }
            }
            for (i = 0; i < getRemoveMacrosCount(); i++) {
                if (!getRemoveMacros(i).isInitialized()) {
                    return false;
                }
            }
            return !hasResult() || getResult().isInitialized();
        }

        public ResolvedRule mergeFrom(ResolvedRule resolvedRule) {
            if (this == resolvedRule) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (resolvedRule != getDefaultInstance()) {
                if (!(resolvedRule.positivePredicates_ == null || resolvedRule.positivePredicates_.isEmpty())) {
                    ensurePositivePredicatesInitialized();
                    AbstractMutableMessageLite.addAll(resolvedRule.positivePredicates_, this.positivePredicates_);
                }
                if (!(resolvedRule.negativePredicates_ == null || resolvedRule.negativePredicates_.isEmpty())) {
                    ensureNegativePredicatesInitialized();
                    AbstractMutableMessageLite.addAll(resolvedRule.negativePredicates_, this.negativePredicates_);
                }
                if (!(resolvedRule.addTags_ == null || resolvedRule.addTags_.isEmpty())) {
                    ensureAddTagsInitialized();
                    AbstractMutableMessageLite.addAll(resolvedRule.addTags_, this.addTags_);
                }
                if (!(resolvedRule.removeTags_ == null || resolvedRule.removeTags_.isEmpty())) {
                    ensureRemoveTagsInitialized();
                    AbstractMutableMessageLite.addAll(resolvedRule.removeTags_, this.removeTags_);
                }
                if (!(resolvedRule.addMacros_ == null || resolvedRule.addMacros_.isEmpty())) {
                    ensureAddMacrosInitialized();
                    AbstractMutableMessageLite.addAll(resolvedRule.addMacros_, this.addMacros_);
                }
                if (!(resolvedRule.removeMacros_ == null || resolvedRule.removeMacros_.isEmpty())) {
                    ensureRemoveMacrosInitialized();
                    AbstractMutableMessageLite.addAll(resolvedRule.removeMacros_, this.removeMacros_);
                }
                if (resolvedRule.hasResult()) {
                    ensureResultInitialized();
                    this.result_.mergeFrom(resolvedRule.getResult());
                    this.bitField0_ |= 1;
                }
                this.unknownFields = this.unknownFields.concat(resolvedRule.unknownFields);
            }
            return this;
        }

        public boolean mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            assertMutable();
            try {
                OutputStream newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
                boolean z = false;
                while (!z) {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            z = true;
                            break;
                        case 10:
                            codedInputStream.readMessage(addPositivePredicates(), extensionRegistryLite);
                            break;
                        case 18:
                            codedInputStream.readMessage(addNegativePredicates(), extensionRegistryLite);
                            break;
                        case 26:
                            codedInputStream.readMessage(addAddTags(), extensionRegistryLite);
                            break;
                        case 34:
                            codedInputStream.readMessage(addRemoveTags(), extensionRegistryLite);
                            break;
                        case 42:
                            codedInputStream.readMessage(addAddMacros(), extensionRegistryLite);
                            break;
                        case 50:
                            codedInputStream.readMessage(addRemoveMacros(), extensionRegistryLite);
                            break;
                        case 58:
                            if (this.result_ == Value.getDefaultInstance()) {
                                this.result_ = Value.newMessage();
                            }
                            this.bitField0_ |= 1;
                            codedInputStream.readMessage(this.result_, extensionRegistryLite);
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                z = true;
                                break;
                            }
                            break;
                    }
                }
                newInstance.flush();
                this.unknownFields = newOutput.toByteString();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        public ResolvedRule newMessageForType() {
            return new ResolvedRule();
        }

        public ResolvedRule setAddMacros(int i, ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            ensureAddMacrosInitialized();
            this.addMacros_.set(i, resolvedFunctionCall);
            return this;
        }

        public ResolvedRule setAddTags(int i, ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            ensureAddTagsInitialized();
            this.addTags_.set(i, resolvedFunctionCall);
            return this;
        }

        public ResolvedRule setNegativePredicates(int i, ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            ensureNegativePredicatesInitialized();
            this.negativePredicates_.set(i, resolvedFunctionCall);
            return this;
        }

        public ResolvedRule setPositivePredicates(int i, ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            ensurePositivePredicatesInitialized();
            this.positivePredicates_.set(i, resolvedFunctionCall);
            return this;
        }

        public ResolvedRule setRemoveMacros(int i, ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            ensureRemoveMacrosInitialized();
            this.removeMacros_.set(i, resolvedFunctionCall);
            return this;
        }

        public ResolvedRule setRemoveTags(int i, ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            ensureRemoveTagsInitialized();
            this.removeTags_.set(i, resolvedFunctionCall);
            return this;
        }

        public ResolvedRule setResult(Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.result_ = value;
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int i;
            int i2 = 0;
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            if (this.positivePredicates_ != null) {
                for (i = 0; i < this.positivePredicates_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(1, (MutableMessageLite) this.positivePredicates_.get(i));
                }
            }
            if (this.negativePredicates_ != null) {
                for (i = 0; i < this.negativePredicates_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(2, (MutableMessageLite) this.negativePredicates_.get(i));
                }
            }
            if (this.addTags_ != null) {
                for (i = 0; i < this.addTags_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(3, (MutableMessageLite) this.addTags_.get(i));
                }
            }
            if (this.removeTags_ != null) {
                for (i = 0; i < this.removeTags_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(4, (MutableMessageLite) this.removeTags_.get(i));
                }
            }
            if (this.addMacros_ != null) {
                for (i = 0; i < this.addMacros_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(5, (MutableMessageLite) this.addMacros_.get(i));
                }
            }
            if (this.removeMacros_ != null) {
                while (i2 < this.removeMacros_.size()) {
                    codedOutputStream.writeMessageWithCachedSizes(6, (MutableMessageLite) this.removeMacros_.get(i2));
                    i2++;
                }
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessageWithCachedSizes(7, this.result_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    public final class RuleEvaluationStepInfo extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static final int ENABLED_FUNCTIONS_FIELD_NUMBER = 2;
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        public static final int RULES_FIELD_NUMBER = 1;
        private static final RuleEvaluationStepInfo defaultInstance = new RuleEvaluationStepInfo(true);
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private List enabledFunctions_ = null;
        private List rules_ = null;

        static {
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
        }

        private RuleEvaluationStepInfo() {
            initFields();
        }

        private RuleEvaluationStepInfo(boolean z) {
        }

        private void ensureEnabledFunctionsInitialized() {
            if (this.enabledFunctions_ == null) {
                this.enabledFunctions_ = new ArrayList();
            }
        }

        private void ensureRulesInitialized() {
            if (this.rules_ == null) {
                this.rules_ = new ArrayList();
            }
        }

        public static RuleEvaluationStepInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static RuleEvaluationStepInfo newMessage() {
            return new RuleEvaluationStepInfo();
        }

        public RuleEvaluationStepInfo addAllEnabledFunctions(Iterable iterable) {
            assertMutable();
            ensureEnabledFunctionsInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.enabledFunctions_);
            return this;
        }

        public RuleEvaluationStepInfo addAllRules(Iterable iterable) {
            assertMutable();
            ensureRulesInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.rules_);
            return this;
        }

        public ResolvedFunctionCall addEnabledFunctions() {
            assertMutable();
            ensureEnabledFunctionsInitialized();
            ResolvedFunctionCall newMessage = ResolvedFunctionCall.newMessage();
            this.enabledFunctions_.add(newMessage);
            return newMessage;
        }

        public RuleEvaluationStepInfo addEnabledFunctions(ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            ensureEnabledFunctionsInitialized();
            this.enabledFunctions_.add(resolvedFunctionCall);
            return this;
        }

        public ResolvedRule addRules() {
            assertMutable();
            ensureRulesInitialized();
            ResolvedRule newMessage = ResolvedRule.newMessage();
            this.rules_.add(newMessage);
            return newMessage;
        }

        public RuleEvaluationStepInfo addRules(ResolvedRule resolvedRule) {
            assertMutable();
            if (resolvedRule == null) {
                throw new NullPointerException();
            }
            ensureRulesInitialized();
            this.rules_.add(resolvedRule);
            return this;
        }

        public RuleEvaluationStepInfo clear() {
            assertMutable();
            super.clear();
            this.rules_ = null;
            this.enabledFunctions_ = null;
            return this;
        }

        public RuleEvaluationStepInfo clearEnabledFunctions() {
            assertMutable();
            this.enabledFunctions_ = null;
            return this;
        }

        public RuleEvaluationStepInfo clearRules() {
            assertMutable();
            this.rules_ = null;
            return this;
        }

        public RuleEvaluationStepInfo clone() {
            return newMessageForType().mergeFrom(this);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RuleEvaluationStepInfo)) {
                return super.equals(obj);
            }
            RuleEvaluationStepInfo ruleEvaluationStepInfo = (RuleEvaluationStepInfo) obj;
            return (getRulesList().equals(ruleEvaluationStepInfo.getRulesList())) && getEnabledFunctionsList().equals(ruleEvaluationStepInfo.getEnabledFunctionsList());
        }

        public final RuleEvaluationStepInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public ResolvedFunctionCall getEnabledFunctions(int i) {
            return (ResolvedFunctionCall) this.enabledFunctions_.get(i);
        }

        public int getEnabledFunctionsCount() {
            return this.enabledFunctions_ == null ? 0 : this.enabledFunctions_.size();
        }

        public List getEnabledFunctionsList() {
            return this.enabledFunctions_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.enabledFunctions_);
        }

        public ResolvedFunctionCall getMutableEnabledFunctions(int i) {
            return (ResolvedFunctionCall) this.enabledFunctions_.get(i);
        }

        public List getMutableEnabledFunctionsList() {
            assertMutable();
            ensureEnabledFunctionsInitialized();
            return this.enabledFunctions_;
        }

        public ResolvedRule getMutableRules(int i) {
            return (ResolvedRule) this.rules_.get(i);
        }

        public List getMutableRulesList() {
            assertMutable();
            ensureRulesInitialized();
            return this.rules_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public ResolvedRule getRules(int i) {
            return (ResolvedRule) this.rules_.get(i);
        }

        public int getRulesCount() {
            return this.rules_ == null ? 0 : this.rules_.size();
        }

        public List getRulesList() {
            return this.rules_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.rules_);
        }

        public int getSerializedSize() {
            int i;
            int i2 = 0;
            if (this.rules_ != null) {
                i = 0;
                for (int i3 = 0; i3 < this.rules_.size(); i3++) {
                    i += CodedOutputStream.computeMessageSize(1, (MessageLite) this.rules_.get(i3));
                }
            } else {
                i = 0;
            }
            if (this.enabledFunctions_ != null) {
                while (i2 < this.enabledFunctions_.size()) {
                    i += CodedOutputStream.computeMessageSize(2, (MessageLite) this.enabledFunctions_.get(i2));
                    i2++;
                }
            }
            int size = this.unknownFields.size() + i;
            this.cachedSize = size;
            return size;
        }

        public int hashCode() {
            int i = 41;
            if (getRulesCount() > 0) {
                i = 80454 + getRulesList().hashCode();
            }
            if (getEnabledFunctionsCount() > 0) {
                i = (((i * 37) + 2) * 53) + getEnabledFunctionsList().hashCode();
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.containertag.proto.Debug$RuleEvaluationStepInfo");
            }
            return immutableDefault;
        }

        public final boolean isInitialized() {
            int i;
            for (i = 0; i < getRulesCount(); i++) {
                if (!getRules(i).isInitialized()) {
                    return false;
                }
            }
            for (i = 0; i < getEnabledFunctionsCount(); i++) {
                if (!getEnabledFunctions(i).isInitialized()) {
                    return false;
                }
            }
            return true;
        }

        public RuleEvaluationStepInfo mergeFrom(RuleEvaluationStepInfo ruleEvaluationStepInfo) {
            if (this == ruleEvaluationStepInfo) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (ruleEvaluationStepInfo != getDefaultInstance()) {
                if (!(ruleEvaluationStepInfo.rules_ == null || ruleEvaluationStepInfo.rules_.isEmpty())) {
                    ensureRulesInitialized();
                    AbstractMutableMessageLite.addAll(ruleEvaluationStepInfo.rules_, this.rules_);
                }
                if (!(ruleEvaluationStepInfo.enabledFunctions_ == null || ruleEvaluationStepInfo.enabledFunctions_.isEmpty())) {
                    ensureEnabledFunctionsInitialized();
                    AbstractMutableMessageLite.addAll(ruleEvaluationStepInfo.enabledFunctions_, this.enabledFunctions_);
                }
                this.unknownFields = this.unknownFields.concat(ruleEvaluationStepInfo.unknownFields);
            }
            return this;
        }

        public boolean mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            assertMutable();
            try {
                OutputStream newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
                boolean z = false;
                while (!z) {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            z = true;
                            break;
                        case 10:
                            codedInputStream.readMessage(addRules(), extensionRegistryLite);
                            break;
                        case 18:
                            codedInputStream.readMessage(addEnabledFunctions(), extensionRegistryLite);
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                z = true;
                                break;
                            }
                            break;
                    }
                }
                newInstance.flush();
                this.unknownFields = newOutput.toByteString();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        public RuleEvaluationStepInfo newMessageForType() {
            return new RuleEvaluationStepInfo();
        }

        public RuleEvaluationStepInfo setEnabledFunctions(int i, ResolvedFunctionCall resolvedFunctionCall) {
            assertMutable();
            if (resolvedFunctionCall == null) {
                throw new NullPointerException();
            }
            ensureEnabledFunctionsInitialized();
            this.enabledFunctions_.set(i, resolvedFunctionCall);
            return this;
        }

        public RuleEvaluationStepInfo setRules(int i, ResolvedRule resolvedRule) {
            assertMutable();
            if (resolvedRule == null) {
                throw new NullPointerException();
            }
            ensureRulesInitialized();
            this.rules_.set(i, resolvedRule);
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int i = 0;
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            if (this.rules_ != null) {
                for (int i2 = 0; i2 < this.rules_.size(); i2++) {
                    codedOutputStream.writeMessageWithCachedSizes(1, (MutableMessageLite) this.rules_.get(i2));
                }
            }
            if (this.enabledFunctions_ != null) {
                while (i < this.enabledFunctions_.size()) {
                    codedOutputStream.writeMessageWithCachedSizes(2, (MutableMessageLite) this.enabledFunctions_.get(i));
                    i++;
                }
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    private MutableDebug() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add(MacroEvaluationInfo.macro);
    }
}
