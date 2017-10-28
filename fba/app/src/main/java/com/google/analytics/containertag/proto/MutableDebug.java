package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.analytics.midtier.proto.containertag.MutableTypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
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
import com.google.tagmanager.protobuf.Utf8;
import com.google.tagmanager.protobuf.WireFormat.FieldType;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MutableDebug {
	public static final class DataLayerEventEvaluationInfo extends GeneratedMutableMessageLite<MutableDebug.DataLayerEventEvaluationInfo> implements MutableMessageLite {
		public static Parser<MutableDebug.DataLayerEventEvaluationInfo> PARSER = null;
		public static final int RESULTS_FIELD_NUMBER = 2;
		public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
		private static final MutableDebug.DataLayerEventEvaluationInfo defaultInstance;
		private static volatile MessageLite immutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private List<MutableDebug.ResolvedFunctionCall> results_;
		private MutableDebug.RuleEvaluationStepInfo rulesEvaluation_;

		static {
			immutableDefault = null;
			defaultInstance = new MutableDebug.DataLayerEventEvaluationInfo(true);
			defaultInstance.initFields();
			defaultInstance.makeImmutable();
			PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
		}

		private DataLayerEventEvaluationInfo() {
			this.results_ = null;
			initFields();
		}

		private DataLayerEventEvaluationInfo(boolean noInit) {
			this.results_ = null;
		}

		private void ensureResultsInitialized() {
			if (this.results_ == null) {
				this.results_ = new ArrayList();
			}
		}

		private void ensureRulesEvaluationInitialized() {
			if (this.rulesEvaluation_ == MutableDebug.RuleEvaluationStepInfo.getDefaultInstance()) {
				this.rulesEvaluation_ = MutableDebug.RuleEvaluationStepInfo.newMessage();
			}
		}

		public static MutableDebug.DataLayerEventEvaluationInfo getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.rulesEvaluation_ = MutableDebug.RuleEvaluationStepInfo.getDefaultInstance();
		}

		public static MutableDebug.DataLayerEventEvaluationInfo newMessage() {
			return new MutableDebug.DataLayerEventEvaluationInfo();
		}

		public MutableDebug.DataLayerEventEvaluationInfo addAllResults(Iterable<MutableDebug.ResolvedFunctionCall> values) {
			assertMutable();
			ensureResultsInitialized();
			AbstractMutableMessageLite.addAll(values, this.results_);
			return this;
		}

		public MutableDebug.DataLayerEventEvaluationInfo addResults(MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureResultsInitialized();
				this.results_.add(value);
				return this;
			}
		}

		public MutableDebug.ResolvedFunctionCall addResults() {
			assertMutable();
			ensureResultsInitialized();
			MutableDebug.ResolvedFunctionCall value = MutableDebug.ResolvedFunctionCall.newMessage();
			this.results_.add(value);
			return value;
		}

		public MutableDebug.DataLayerEventEvaluationInfo clear() {
			assertMutable();
			super.clear();
			if (this.rulesEvaluation_ != MutableDebug.RuleEvaluationStepInfo.getDefaultInstance()) {
				this.rulesEvaluation_.clear();
			}
			this.bitField0_ &= -2;
			this.results_ = null;
			return this;
		}

		public MutableDebug.DataLayerEventEvaluationInfo clearResults() {
			assertMutable();
			this.results_ = null;
			return this;
		}

		public MutableDebug.DataLayerEventEvaluationInfo clearRulesEvaluation() {
			assertMutable();
			this.bitField0_ &= -2;
			if (this.rulesEvaluation_ != MutableDebug.RuleEvaluationStepInfo.getDefaultInstance()) {
				this.rulesEvaluation_.clear();
			}
			return this;
		}

		public MutableDebug.DataLayerEventEvaluationInfo clone() {
			return newMessageForType().mergeFrom(this);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof MutableDebug.DataLayerEventEvaluationInfo))) {
				return super.equals(obj);
			} else {
				boolean result;
				MutableDebug.DataLayerEventEvaluationInfo other = (MutableDebug.DataLayerEventEvaluationInfo) obj;
				if (!true || hasRulesEvaluation() != other.hasRulesEvaluation()) {
					result = false;
				} else {
					result = true;
				}
				if (hasRulesEvaluation()) {
					result = (!result || !getRulesEvaluation().equals(other.getRulesEvaluation())) ? false : true;
				}
				result = (!result || !getResultsList().equals(other.getResultsList())) ? false : true;
				return result;
			}
		}

		public final MutableDebug.DataLayerEventEvaluationInfo getDefaultInstanceForType() {
			return defaultInstance;
		}

		public MutableDebug.ResolvedFunctionCall getMutableResults(int index) {
			return (MutableDebug.ResolvedFunctionCall) this.results_.get(index);
		}

		public List<MutableDebug.ResolvedFunctionCall> getMutableResultsList() {
			assertMutable();
			ensureResultsInitialized();
			return this.results_;
		}

		public MutableDebug.RuleEvaluationStepInfo getMutableRulesEvaluation() {
			assertMutable();
			ensureRulesEvaluationInitialized();
			this.bitField0_ |= 1;
			return this.rulesEvaluation_;
		}

		public Parser<MutableDebug.DataLayerEventEvaluationInfo> getParserForType() {
			return PARSER;
		}

		public MutableDebug.ResolvedFunctionCall getResults(int index) {
			return (MutableDebug.ResolvedFunctionCall) this.results_.get(index);
		}

		public int getResultsCount() {
			return (this.results_ == null) ? 0 : this.results_.size();
		}

		public List<MutableDebug.ResolvedFunctionCall> getResultsList() {
			return (this.results_ == null) ? Collections.emptyList() : Collections.unmodifiableList(this.results_);
		}

		public MutableDebug.RuleEvaluationStepInfo getRulesEvaluation() {
			return this.rulesEvaluation_;
		}

		public int getSerializedSize() {
			int size = 0;
			if ((this.bitField0_ & 1) == 1) {
				size += CodedOutputStream.computeMessageSize(RULES_EVALUATION_FIELD_NUMBER, this.rulesEvaluation_);
			}
			if (this.results_ != null) {
				int i = 0;
				while (i < this.results_.size()) {
					size += CodedOutputStream.computeMessageSize(RESULTS_FIELD_NUMBER, (MessageLite) this.results_.get(i));
					i++;
				}
			}
			size += this.unknownFields.size();
			this.cachedSize = size;
			return size;
		}

		public boolean hasRulesEvaluation() {
			return (this.bitField0_ & 1) == 1;
		}

		public int hashCode() {
			int hash = 41;
			if (hasRulesEvaluation()) {
				hash = 1517 + 1;
				hash = 80454 + getRulesEvaluation().hashCode();
			}
			if (getResultsCount() > 0) {
				hash = (((hash * 37) + 2) * 53) + getResultsList().hashCode();
			}
			return (hash * 29) + this.unknownFields.hashCode();
		}

		protected MessageLite internalImmutableDefault() {
			if (immutableDefault == null) {
				immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$DataLayerEventEvaluationInfo");
			}
			return immutableDefault;
		}

		public final boolean isInitialized() {
			if (!hasRulesEvaluation() || getRulesEvaluation().isInitialized()) {
				int i = 0;
				while (i < getResultsCount()) {
					if (getResults(i).isInitialized()) {
						i++;
					}
					return false;
				}
				return true;
			}
			return false;
		}

		public MutableDebug.DataLayerEventEvaluationInfo mergeFrom(MutableDebug.DataLayerEventEvaluationInfo other) {
			if (this == other) {
				throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
			} else {
				assertMutable();
				if (other == getDefaultInstance()) {
					return this;
				} else {
					if (other.hasRulesEvaluation()) {
						ensureRulesEvaluationInitialized();
						this.rulesEvaluation_.mergeFrom(other.getRulesEvaluation());
						this.bitField0_ |= 1;
					}
					if (other.results_ == null || other.results_.isEmpty()) {
						this.unknownFields = this.unknownFields.concat(other.unknownFields);
						return this;
					} else {
						ensureResultsInitialized();
						AbstractMutableMessageLite.addAll(other.results_, this.results_);
						this.unknownFields = this.unknownFields.concat(other.unknownFields);
						return this;
					}
				}
			}
		}

		public boolean mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) {
			CodedOutputStream unknownFieldsCodedOutput;
			boolean done;
			boolean r5z;
			assertMutable();
			try {
				OutputStream unknownFieldsOutput = ByteString.newOutput();
				unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
				done = false;
				while (!done) {
					int tag = input.readTag();
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case Value.ESCAPING_FIELD_NUMBER:
						if (this.rulesEvaluation_ == MutableDebug.RuleEvaluationStepInfo.getDefaultInstance()) {
							this.rulesEvaluation_ = MutableDebug.RuleEvaluationStepInfo.newMessage();
						}
						this.bitField0_ |= 1;
						input.readMessage(this.rulesEvaluation_, extensionRegistry);
						break;
					case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						input.readMessage(addResults(), extensionRegistry);
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				}
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
				r5z = true;
			} catch (IOException e) {
				r5z = false;
			}
			return r5z;
		}

		public MutableDebug.DataLayerEventEvaluationInfo newMessageForType() {
			return new MutableDebug.DataLayerEventEvaluationInfo();
		}

		public MutableDebug.DataLayerEventEvaluationInfo setResults(int index, MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureResultsInitialized();
				this.results_.set(index, value);
				return this;
			}
		}

		public MutableDebug.DataLayerEventEvaluationInfo setRulesEvaluation(MutableDebug.RuleEvaluationStepInfo value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 1;
				this.rulesEvaluation_ = value;
				return this;
			}
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeToWithCachedSizes(CodedOutputStream output) throws IOException {
			int bytesWrittenBefore = output.getTotalBytesWritten();
			if ((this.bitField0_ & 1) == 1) {
				output.writeMessageWithCachedSizes(RULES_EVALUATION_FIELD_NUMBER, this.rulesEvaluation_);
			}
			if (this.results_ != null) {
				int i = 0;
				while (i < this.results_.size()) {
					output.writeMessageWithCachedSizes(RESULTS_FIELD_NUMBER, (MutableMessageLite) this.results_.get(i));
					i++;
				}
			}
			output.writeRawBytes(this.unknownFields);
			if (getCachedSize() != output.getTotalBytesWritten() - bytesWrittenBefore) {
				throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
			}
		}
	}

	public static final class DebugEvents extends GeneratedMutableMessageLite<MutableDebug.DebugEvents> implements MutableMessageLite {
		public static final int EVENT_FIELD_NUMBER = 1;
		public static Parser<MutableDebug.DebugEvents> PARSER;
		private static final MutableDebug.DebugEvents defaultInstance;
		private static volatile MessageLite immutableDefault;
		private static final long serialVersionUID = 0;
		private List<MutableDebug.EventInfo> event_;

		static {
			immutableDefault = null;
			defaultInstance = new MutableDebug.DebugEvents(true);
			defaultInstance.initFields();
			defaultInstance.makeImmutable();
			PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
		}

		private DebugEvents() {
			this.event_ = null;
			initFields();
		}

		private DebugEvents(boolean noInit) {
			this.event_ = null;
		}

		private void ensureEventInitialized() {
			if (this.event_ == null) {
				this.event_ = new ArrayList();
			}
		}

		public static MutableDebug.DebugEvents getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
		}

		public static MutableDebug.DebugEvents newMessage() {
			return new MutableDebug.DebugEvents();
		}

		public MutableDebug.DebugEvents addAllEvent(Iterable<MutableDebug.EventInfo> values) {
			assertMutable();
			ensureEventInitialized();
			AbstractMutableMessageLite.addAll(values, this.event_);
			return this;
		}

		public MutableDebug.DebugEvents addEvent(MutableDebug.EventInfo value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureEventInitialized();
				this.event_.add(value);
				return this;
			}
		}

		public MutableDebug.EventInfo addEvent() {
			assertMutable();
			ensureEventInitialized();
			MutableDebug.EventInfo value = MutableDebug.EventInfo.newMessage();
			this.event_.add(value);
			return value;
		}

		public MutableDebug.DebugEvents clear() {
			assertMutable();
			super.clear();
			this.event_ = null;
			return this;
		}

		public MutableDebug.DebugEvents clearEvent() {
			assertMutable();
			this.event_ = null;
			return this;
		}

		public MutableDebug.DebugEvents clone() {
			return newMessageForType().mergeFrom(this);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof MutableDebug.DebugEvents))) {
				return super.equals(obj);
			} else {
				boolean result;
				MutableDebug.DebugEvents other = (MutableDebug.DebugEvents) obj;
				result = (!true || !getEventList().equals(other.getEventList())) ? false : true;
				return result;
			}
		}

		public final MutableDebug.DebugEvents getDefaultInstanceForType() {
			return defaultInstance;
		}

		public MutableDebug.EventInfo getEvent(int index) {
			return (MutableDebug.EventInfo) this.event_.get(index);
		}

		public int getEventCount() {
			return (this.event_ == null) ? 0 : this.event_.size();
		}

		public List<MutableDebug.EventInfo> getEventList() {
			return (this.event_ == null) ? Collections.emptyList() : Collections.unmodifiableList(this.event_);
		}

		public MutableDebug.EventInfo getMutableEvent(int index) {
			return (MutableDebug.EventInfo) this.event_.get(index);
		}

		public List<MutableDebug.EventInfo> getMutableEventList() {
			assertMutable();
			ensureEventInitialized();
			return this.event_;
		}

		public Parser<MutableDebug.DebugEvents> getParserForType() {
			return PARSER;
		}

		public int getSerializedSize() {
			int size = 0;
			if (this.event_ != null) {
				int i = 0;
				while (i < this.event_.size()) {
					size += CodedOutputStream.computeMessageSize(EVENT_FIELD_NUMBER, (MessageLite) this.event_.get(i));
					i++;
				}
			}
			size += this.unknownFields.size();
			this.cachedSize = size;
			return size;
		}

		public int hashCode() {
			int hash = 41;
			if (getEventCount() > 0) {
				hash = 1517 + 1;
				hash = 80454 + getEventList().hashCode();
			}
			return (hash * 29) + this.unknownFields.hashCode();
		}

		protected MessageLite internalImmutableDefault() {
			if (immutableDefault == null) {
				immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$DebugEvents");
			}
			return immutableDefault;
		}

		public final boolean isInitialized() {
			int i = 0;
			while (i < getEventCount()) {
				if (!getEvent(i).isInitialized()) {
					return false;
				} else {
					i++;
				}
			}
			return true;
		}

		public MutableDebug.DebugEvents mergeFrom(MutableDebug.DebugEvents other) {
			if (this == other) {
				throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
			} else {
				assertMutable();
				if (other == getDefaultInstance()) {
					return this;
				} else if (other.event_ == null || other.event_.isEmpty()) {
					this.unknownFields = this.unknownFields.concat(other.unknownFields);
					return this;
				} else {
					ensureEventInitialized();
					AbstractMutableMessageLite.addAll(other.event_, this.event_);
					this.unknownFields = this.unknownFields.concat(other.unknownFields);
					return this;
				}
			}
		}

		public boolean mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) {
			CodedOutputStream unknownFieldsCodedOutput;
			boolean done;
			boolean r5z;
			assertMutable();
			try {
				OutputStream unknownFieldsOutput = ByteString.newOutput();
				unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
				done = false;
				while (!done) {
					int tag = input.readTag();
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case Value.ESCAPING_FIELD_NUMBER:
						input.readMessage(addEvent(), extensionRegistry);
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				}
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
				r5z = true;
			} catch (IOException e) {
				r5z = false;
			}
			return r5z;
		}

		public MutableDebug.DebugEvents newMessageForType() {
			return new MutableDebug.DebugEvents();
		}

		public MutableDebug.DebugEvents setEvent(int index, MutableDebug.EventInfo value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureEventInitialized();
				this.event_.set(index, value);
				return this;
			}
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeToWithCachedSizes(CodedOutputStream output) throws IOException {
			int bytesWrittenBefore = output.getTotalBytesWritten();
			if (this.event_ != null) {
				int i = 0;
				while (i < this.event_.size()) {
					output.writeMessageWithCachedSizes(EVENT_FIELD_NUMBER, (MutableMessageLite) this.event_.get(i));
					i++;
				}
			}
			output.writeRawBytes(this.unknownFields);
			if (getCachedSize() != output.getTotalBytesWritten() - bytesWrittenBefore) {
				throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
			}
		}
	}

	public static final class EventInfo extends GeneratedMutableMessageLite<MutableDebug.EventInfo> implements MutableMessageLite {
		public static final int CONTAINER_ID_FIELD_NUMBER = 3;
		public static final int CONTAINER_VERSION_FIELD_NUMBER = 2;
		public static final int DATA_LAYER_EVENT_RESULT_FIELD_NUMBER = 7;
		public static final int EVENT_TYPE_FIELD_NUMBER = 1;
		public static final int KEY_FIELD_NUMBER = 4;
		public static final int MACRO_RESULT_FIELD_NUMBER = 6;
		public static Parser<MutableDebug.EventInfo> PARSER;
		private static final MutableDebug.EventInfo defaultInstance;
		private static volatile MessageLite immutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private Object containerId_;
		private Object containerVersion_;
		private MutableDebug.DataLayerEventEvaluationInfo dataLayerEventResult_;
		private EventType eventType_;
		private Object key_;
		private MutableDebug.MacroEvaluationInfo macroResult_;

		public static enum EventType implements EnumLite {
			DATA_LAYER_EVENT(0, 1),
			MACRO_REFERENCE(1, 2);

			public static final int DATA_LAYER_EVENT_VALUE = 1;
			public static final int MACRO_REFERENCE_VALUE = 2;
			private static EnumLiteMap<MutableDebug.EventInfo.EventType> internalValueMap;
			private final int value;


			static {
				internalValueMap = new EnumLiteMap<MutableDebug.EventInfo.EventType>() {
			public MutableDebug.EventInfo.EventType findValueByNumber(int number) {
				return MutableDebug.EventInfo.EventType.valueOf(number);
			}
		};
			}

			private EventType(int index, int value) {
				this.value = value;
			}

			public static EnumLiteMap<MutableDebug.EventInfo.EventType> internalGetValueMap() {
				return internalValueMap;
			}

			public static MutableDebug.EventInfo.EventType valueOf(int value) {
				switch(value) {
				case DATA_LAYER_EVENT_VALUE:
					return DATA_LAYER_EVENT;
				case MACRO_REFERENCE_VALUE:
					return MACRO_REFERENCE;
				}
				return null;
			}

			public final int getNumber() {
				return this.value;
			}
		}


		static {
			immutableDefault = null;
			defaultInstance = new MutableDebug.EventInfo(true);
			defaultInstance.initFields();
			defaultInstance.makeImmutable();
			PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
		}

		private EventInfo() {
			this.eventType_ = EventType.DATA_LAYER_EVENT;
			this.containerVersion_ = Internal.EMPTY_BYTE_ARRAY;
			this.containerId_ = Internal.EMPTY_BYTE_ARRAY;
			this.key_ = Internal.EMPTY_BYTE_ARRAY;
			initFields();
		}

		private EventInfo(boolean noInit) {
			this.eventType_ = EventType.DATA_LAYER_EVENT;
			this.containerVersion_ = Internal.EMPTY_BYTE_ARRAY;
			this.containerId_ = Internal.EMPTY_BYTE_ARRAY;
			this.key_ = Internal.EMPTY_BYTE_ARRAY;
		}

		private void ensureDataLayerEventResultInitialized() {
			if (this.dataLayerEventResult_ == MutableDebug.DataLayerEventEvaluationInfo.getDefaultInstance()) {
				this.dataLayerEventResult_ = MutableDebug.DataLayerEventEvaluationInfo.newMessage();
			}
		}

		private void ensureMacroResultInitialized() {
			if (this.macroResult_ == MutableDebug.MacroEvaluationInfo.getDefaultInstance()) {
				this.macroResult_ = MutableDebug.MacroEvaluationInfo.newMessage();
			}
		}

		public static MutableDebug.EventInfo getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.eventType_ = EventType.DATA_LAYER_EVENT;
			this.macroResult_ = MutableDebug.MacroEvaluationInfo.getDefaultInstance();
			this.dataLayerEventResult_ = MutableDebug.DataLayerEventEvaluationInfo.getDefaultInstance();
		}

		public static MutableDebug.EventInfo newMessage() {
			return new MutableDebug.EventInfo();
		}

		public MutableDebug.EventInfo clear() {
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
			if (this.macroResult_ != MutableDebug.MacroEvaluationInfo.getDefaultInstance()) {
				this.macroResult_.clear();
			}
			this.bitField0_ &= -17;
			if (this.dataLayerEventResult_ != MutableDebug.DataLayerEventEvaluationInfo.getDefaultInstance()) {
				this.dataLayerEventResult_.clear();
			}
			this.bitField0_ &= -33;
			return this;
		}

		public MutableDebug.EventInfo clearContainerId() {
			assertMutable();
			this.bitField0_ &= -5;
			this.containerId_ = Internal.EMPTY_BYTE_ARRAY;
			return this;
		}

		public MutableDebug.EventInfo clearContainerVersion() {
			assertMutable();
			this.bitField0_ &= -3;
			this.containerVersion_ = Internal.EMPTY_BYTE_ARRAY;
			return this;
		}

		public MutableDebug.EventInfo clearDataLayerEventResult() {
			assertMutable();
			this.bitField0_ &= -33;
			if (this.dataLayerEventResult_ != MutableDebug.DataLayerEventEvaluationInfo.getDefaultInstance()) {
				this.dataLayerEventResult_.clear();
			}
			return this;
		}

		public MutableDebug.EventInfo clearEventType() {
			assertMutable();
			this.bitField0_ &= -2;
			this.eventType_ = EventType.DATA_LAYER_EVENT;
			return this;
		}

		public MutableDebug.EventInfo clearKey() {
			assertMutable();
			this.bitField0_ &= -9;
			this.key_ = Internal.EMPTY_BYTE_ARRAY;
			return this;
		}

		public MutableDebug.EventInfo clearMacroResult() {
			assertMutable();
			this.bitField0_ &= -17;
			if (this.macroResult_ != MutableDebug.MacroEvaluationInfo.getDefaultInstance()) {
				this.macroResult_.clear();
			}
			return this;
		}

		public MutableDebug.EventInfo clone() {
			return newMessageForType().mergeFrom(this);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof MutableDebug.EventInfo))) {
				return super.equals(obj);
			} else {
				boolean result;
				MutableDebug.EventInfo other = (MutableDebug.EventInfo) obj;
				if (!true || hasEventType() != other.hasEventType()) {
					result = false;
				} else {
					result = true;
				}
				if (hasEventType()) {
					result = (!result || getEventType() != other.getEventType()) ? false : true;
				}
				if (!result || hasContainerVersion() != other.hasContainerVersion()) {
					result = false;
				} else {
					result = true;
				}
				if (hasContainerVersion()) {
					result = (!result || !getContainerVersion().equals(other.getContainerVersion())) ? false : true;
				}
				if (!result || hasContainerId() != other.hasContainerId()) {
					result = false;
				} else {
					result = true;
				}
				if (hasContainerId()) {
					result = (!result || !getContainerId().equals(other.getContainerId())) ? false : true;
				}
				if (!result || hasKey() != other.hasKey()) {
					result = false;
				} else {
					result = true;
				}
				if (hasKey()) {
					result = (!result || !getKey().equals(other.getKey())) ? false : true;
				}
				if (!result || hasMacroResult() != other.hasMacroResult()) {
					result = false;
				} else {
					result = true;
				}
				if (hasMacroResult()) {
					result = (!result || !getMacroResult().equals(other.getMacroResult())) ? false : true;
				}
				if (!result || hasDataLayerEventResult() != other.hasDataLayerEventResult()) {
					result = false;
				} else {
					result = true;
				}
				if (hasDataLayerEventResult()) {
					result = (!result || !getDataLayerEventResult().equals(other.getDataLayerEventResult())) ? false : true;
				}
				return result;
			}
		}

		public String getContainerId() {
			Object ref = this.containerId_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				byte[] byteArray = (byte[]) ((byte[]) ref);
				String s = Internal.toStringUtf8(byteArray);
				if (Internal.isValidUtf8(byteArray)) {
					this.containerId_ = s;
				}
				return s;
			}
		}

		public byte[] getContainerIdAsBytes() {
			Object ref = this.containerId_;
			if (ref instanceof String) {
				Object byteArray = Internal.toByteArray((String) ref);
				this.containerId_ = byteArray;
				return byteArray;
			} else {
				return (byte[]) ((byte[]) ref);
			}
		}

		public String getContainerVersion() {
			Object ref = this.containerVersion_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				byte[] byteArray = (byte[]) ((byte[]) ref);
				String s = Internal.toStringUtf8(byteArray);
				if (Internal.isValidUtf8(byteArray)) {
					this.containerVersion_ = s;
				}
				return s;
			}
		}

		public byte[] getContainerVersionAsBytes() {
			Object ref = this.containerVersion_;
			if (ref instanceof String) {
				Object byteArray = Internal.toByteArray((String) ref);
				this.containerVersion_ = byteArray;
				return byteArray;
			} else {
				return (byte[]) ((byte[]) ref);
			}
		}

		public MutableDebug.DataLayerEventEvaluationInfo getDataLayerEventResult() {
			return this.dataLayerEventResult_;
		}

		public final MutableDebug.EventInfo getDefaultInstanceForType() {
			return defaultInstance;
		}

		public EventType getEventType() {
			return this.eventType_;
		}

		public String getKey() {
			Object ref = this.key_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				byte[] byteArray = (byte[]) ((byte[]) ref);
				String s = Internal.toStringUtf8(byteArray);
				if (Internal.isValidUtf8(byteArray)) {
					this.key_ = s;
				}
				return s;
			}
		}

		public byte[] getKeyAsBytes() {
			Object ref = this.key_;
			if (ref instanceof String) {
				Object byteArray = Internal.toByteArray((String) ref);
				this.key_ = byteArray;
				return byteArray;
			} else {
				return (byte[]) ((byte[]) ref);
			}
		}

		public MutableDebug.MacroEvaluationInfo getMacroResult() {
			return this.macroResult_;
		}

		public MutableDebug.DataLayerEventEvaluationInfo getMutableDataLayerEventResult() {
			assertMutable();
			ensureDataLayerEventResultInitialized();
			this.bitField0_ |= 32;
			return this.dataLayerEventResult_;
		}

		public MutableDebug.MacroEvaluationInfo getMutableMacroResult() {
			assertMutable();
			ensureMacroResultInitialized();
			this.bitField0_ |= 16;
			return this.macroResult_;
		}

		public Parser<MutableDebug.EventInfo> getParserForType() {
			return PARSER;
		}

		public int getSerializedSize() {
			int size = 0;
			if ((this.bitField0_ & 1) == 1) {
				size += CodedOutputStream.computeEnumSize(EVENT_TYPE_FIELD_NUMBER, this.eventType_.getNumber());
			}
			if ((this.bitField0_ & 2) == 2) {
				size += CodedOutputStream.computeByteArraySize(CONTAINER_VERSION_FIELD_NUMBER, getContainerVersionAsBytes());
			}
			if ((this.bitField0_ & 4) == 4) {
				size += CodedOutputStream.computeByteArraySize(CONTAINER_ID_FIELD_NUMBER, getContainerIdAsBytes());
			}
			if ((this.bitField0_ & 8) == 8) {
				size += CodedOutputStream.computeByteArraySize(KEY_FIELD_NUMBER, getKeyAsBytes());
			}
			if ((this.bitField0_ & 16) == 16) {
				size += CodedOutputStream.computeMessageSize(MACRO_RESULT_FIELD_NUMBER, this.macroResult_);
			}
			if ((this.bitField0_ & 32) == 32) {
				size += CodedOutputStream.computeMessageSize(DATA_LAYER_EVENT_RESULT_FIELD_NUMBER, this.dataLayerEventResult_);
			}
			size += this.unknownFields.size();
			this.cachedSize = size;
			return size;
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
			int hash = 41;
			if (hasEventType()) {
				hash = 1517 + 1;
				hash = 80454 + Internal.hashEnum(getEventType());
			}
			if (hasContainerVersion()) {
				hash = (((hash * 37) + 2) * 53) + getContainerVersion().hashCode();
			}
			if (hasContainerId()) {
				hash = (((hash * 37) + 3) * 53) + getContainerId().hashCode();
			}
			if (hasKey()) {
				hash = (((hash * 37) + 4) * 53) + getKey().hashCode();
			}
			if (hasMacroResult()) {
				hash = (((hash * 37) + 6) * 53) + getMacroResult().hashCode();
			}
			if (hasDataLayerEventResult()) {
				hash = (((hash * 37) + 7) * 53) + getDataLayerEventResult().hashCode();
			}
			return (hash * 29) + this.unknownFields.hashCode();
		}

		protected MessageLite internalImmutableDefault() {
			if (immutableDefault == null) {
				immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$EventInfo");
			}
			return immutableDefault;
		}

		public final boolean isInitialized() {
			if (!hasMacroResult() || getMacroResult().isInitialized()) {
				if (!hasDataLayerEventResult() || getDataLayerEventResult().isInitialized()) {
					return true;
				}
				return false;
			}
			return false;
		}

		public MutableDebug.EventInfo mergeFrom(MutableDebug.EventInfo other) {
			if (this == other) {
				throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
			} else {
				assertMutable();
				if (other == getDefaultInstance()) {
					return this;
				} else {
					byte[] ba;
					if (other.hasEventType()) {
						setEventType(other.getEventType());
					}
					if (other.hasContainerVersion()) {
						this.bitField0_ |= 2;
						if (other.containerVersion_ instanceof String) {
							this.containerVersion_ = other.containerVersion_;
						} else {
							ba = (byte[]) other.containerVersion_;
							this.containerVersion_ = Arrays.copyOf(ba, ba.length);
						}
					}
					if (other.hasContainerId()) {
						this.bitField0_ |= 4;
						if (other.containerId_ instanceof String) {
							this.containerId_ = other.containerId_;
						} else {
							ba = (byte[]) other.containerId_;
							this.containerId_ = Arrays.copyOf(ba, ba.length);
						}
					}
					if (other.hasKey()) {
						this.bitField0_ |= 8;
						if (other.key_ instanceof String) {
							this.key_ = other.key_;
						} else {
							ba = (byte[]) other.key_;
							this.key_ = Arrays.copyOf(ba, ba.length);
						}
					}
					if (other.hasMacroResult()) {
						ensureMacroResultInitialized();
						this.macroResult_.mergeFrom(other.getMacroResult());
						this.bitField0_ |= 16;
					}
					if (other.hasDataLayerEventResult()) {
						ensureDataLayerEventResultInitialized();
						this.dataLayerEventResult_.mergeFrom(other.getDataLayerEventResult());
						this.bitField0_ |= 32;
					}
					this.unknownFields = this.unknownFields.concat(other.unknownFields);
					return this;
				}
			}
		}

		public boolean mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) {
			CodedOutputStream unknownFieldsCodedOutput;
			boolean done;
			boolean r7z;
			assertMutable();
			try {
				OutputStream unknownFieldsOutput = ByteString.newOutput();
				unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
				done = false;
				while (!done) {
					int tag = input.readTag();
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case CodedOutputStream.LITTLE_ENDIAN_64_SIZE:
						int rawValue = input.readEnum();
						EventType value = EventType.valueOf(rawValue);
						if (value == null) {
							unknownFieldsCodedOutput.writeRawVarint32(tag);
							unknownFieldsCodedOutput.writeRawVarint32(rawValue);
						} else {
							this.bitField0_ |= 1;
							this.eventType_ = value;
						}
						break;
					case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						this.bitField0_ |= 2;
						this.containerVersion_ = input.readByteArray();
						break;
					case 26:
						this.bitField0_ |= 4;
						this.containerId_ = input.readByteArray();
						break;
					case 34:
						this.bitField0_ |= 8;
						this.key_ = input.readByteArray();
						break;
					case 50:
						if (this.macroResult_ == MutableDebug.MacroEvaluationInfo.getDefaultInstance()) {
							this.macroResult_ = MutableDebug.MacroEvaluationInfo.newMessage();
						}
						this.bitField0_ |= 16;
						input.readMessage(this.macroResult_, extensionRegistry);
						break;
					case 58:
						if (this.dataLayerEventResult_ == MutableDebug.DataLayerEventEvaluationInfo.getDefaultInstance()) {
							this.dataLayerEventResult_ = MutableDebug.DataLayerEventEvaluationInfo.newMessage();
						}
						this.bitField0_ |= 32;
						input.readMessage(this.dataLayerEventResult_, extensionRegistry);
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				}
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
				r7z = true;
			} catch (IOException e) {
				r7z = false;
			}
			return r7z;
		}

		public MutableDebug.EventInfo newMessageForType() {
			return new MutableDebug.EventInfo();
		}

		public MutableDebug.EventInfo setContainerId(String value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 4;
				this.containerId_ = value;
				return this;
			}
		}

		public MutableDebug.EventInfo setContainerIdAsBytes(byte[] value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 4;
				this.containerId_ = value;
				return this;
			}
		}

		public MutableDebug.EventInfo setContainerVersion(String value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 2;
				this.containerVersion_ = value;
				return this;
			}
		}

		public MutableDebug.EventInfo setContainerVersionAsBytes(byte[] value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 2;
				this.containerVersion_ = value;
				return this;
			}
		}

		public MutableDebug.EventInfo setDataLayerEventResult(MutableDebug.DataLayerEventEvaluationInfo value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 32;
				this.dataLayerEventResult_ = value;
				return this;
			}
		}

		public MutableDebug.EventInfo setEventType(EventType value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 1;
				this.eventType_ = value;
				return this;
			}
		}

		public MutableDebug.EventInfo setKey(String value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 8;
				this.key_ = value;
				return this;
			}
		}

		public MutableDebug.EventInfo setKeyAsBytes(byte[] value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 8;
				this.key_ = value;
				return this;
			}
		}

		public MutableDebug.EventInfo setMacroResult(MutableDebug.MacroEvaluationInfo value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 16;
				this.macroResult_ = value;
				return this;
			}
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeToWithCachedSizes(CodedOutputStream output) throws IOException {
			int bytesWrittenBefore = output.getTotalBytesWritten();
			if ((this.bitField0_ & 1) == 1) {
				output.writeEnum(EVENT_TYPE_FIELD_NUMBER, this.eventType_.getNumber());
			}
			if ((this.bitField0_ & 2) == 2) {
				output.writeByteArray(CONTAINER_VERSION_FIELD_NUMBER, getContainerVersionAsBytes());
			}
			if ((this.bitField0_ & 4) == 4) {
				output.writeByteArray(CONTAINER_ID_FIELD_NUMBER, getContainerIdAsBytes());
			}
			if ((this.bitField0_ & 8) == 8) {
				output.writeByteArray(KEY_FIELD_NUMBER, getKeyAsBytes());
			}
			if ((this.bitField0_ & 16) == 16) {
				output.writeMessageWithCachedSizes(MACRO_RESULT_FIELD_NUMBER, this.macroResult_);
			}
			if ((this.bitField0_ & 32) == 32) {
				output.writeMessageWithCachedSizes(DATA_LAYER_EVENT_RESULT_FIELD_NUMBER, this.dataLayerEventResult_);
			}
			output.writeRawBytes(this.unknownFields);
			if (getCachedSize() != output.getTotalBytesWritten() - bytesWrittenBefore) {
				throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
			}
		}
	}

	public static final class MacroEvaluationInfo extends GeneratedMutableMessageLite<MutableDebug.MacroEvaluationInfo> implements MutableMessageLite {
		public static final int MACRO_FIELD_NUMBER = 47497405;
		public static Parser<MutableDebug.MacroEvaluationInfo> PARSER = null;
		public static final int RESULT_FIELD_NUMBER = 3;
		public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
		private static final MutableDebug.MacroEvaluationInfo defaultInstance;
		private static volatile MessageLite immutableDefault;
		public static final GeneratedExtension<Value, MutableDebug.MacroEvaluationInfo> macro;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private MutableDebug.ResolvedFunctionCall result_;
		private MutableDebug.RuleEvaluationStepInfo rulesEvaluation_;

		static {
			immutableDefault = null;
			defaultInstance = new MutableDebug.MacroEvaluationInfo(true);
			defaultInstance.initFields();
			defaultInstance.makeImmutable();
			PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
			macro = GeneratedMessageLite.newSingularGeneratedExtension(Value.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, MACRO_FIELD_NUMBER, FieldType.MESSAGE, MutableDebug.MacroEvaluationInfo.class);
		}

		private MacroEvaluationInfo() {
			initFields();
		}

		private MacroEvaluationInfo(boolean noInit) {
		}

		private void ensureResultInitialized() {
			if (this.result_ == MutableDebug.ResolvedFunctionCall.getDefaultInstance()) {
				this.result_ = MutableDebug.ResolvedFunctionCall.newMessage();
			}
		}

		private void ensureRulesEvaluationInitialized() {
			if (this.rulesEvaluation_ == MutableDebug.RuleEvaluationStepInfo.getDefaultInstance()) {
				this.rulesEvaluation_ = MutableDebug.RuleEvaluationStepInfo.newMessage();
			}
		}

		public static MutableDebug.MacroEvaluationInfo getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.rulesEvaluation_ = MutableDebug.RuleEvaluationStepInfo.getDefaultInstance();
			this.result_ = MutableDebug.ResolvedFunctionCall.getDefaultInstance();
		}

		public static MutableDebug.MacroEvaluationInfo newMessage() {
			return new MutableDebug.MacroEvaluationInfo();
		}

		public MutableDebug.MacroEvaluationInfo clear() {
			assertMutable();
			super.clear();
			if (this.rulesEvaluation_ != MutableDebug.RuleEvaluationStepInfo.getDefaultInstance()) {
				this.rulesEvaluation_.clear();
			}
			this.bitField0_ &= -2;
			if (this.result_ != MutableDebug.ResolvedFunctionCall.getDefaultInstance()) {
				this.result_.clear();
			}
			this.bitField0_ &= -3;
			return this;
		}

		public MutableDebug.MacroEvaluationInfo clearResult() {
			assertMutable();
			this.bitField0_ &= -3;
			if (this.result_ != MutableDebug.ResolvedFunctionCall.getDefaultInstance()) {
				this.result_.clear();
			}
			return this;
		}

		public MutableDebug.MacroEvaluationInfo clearRulesEvaluation() {
			assertMutable();
			this.bitField0_ &= -2;
			if (this.rulesEvaluation_ != MutableDebug.RuleEvaluationStepInfo.getDefaultInstance()) {
				this.rulesEvaluation_.clear();
			}
			return this;
		}

		public MutableDebug.MacroEvaluationInfo clone() {
			return newMessageForType().mergeFrom(this);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof MutableDebug.MacroEvaluationInfo))) {
				return super.equals(obj);
			} else {
				boolean result;
				MutableDebug.MacroEvaluationInfo other = (MutableDebug.MacroEvaluationInfo) obj;
				if (!true || hasRulesEvaluation() != other.hasRulesEvaluation()) {
					result = false;
				} else {
					result = true;
				}
				if (hasRulesEvaluation()) {
					result = (!result || !getRulesEvaluation().equals(other.getRulesEvaluation())) ? false : true;
				}
				if (!result || hasResult() != other.hasResult()) {
					result = false;
				} else {
					result = true;
				}
				if (hasResult()) {
					result = (!result || !getResult().equals(other.getResult())) ? false : true;
				}
				return result;
			}
		}

		public final MutableDebug.MacroEvaluationInfo getDefaultInstanceForType() {
			return defaultInstance;
		}

		public MutableDebug.ResolvedFunctionCall getMutableResult() {
			assertMutable();
			ensureResultInitialized();
			this.bitField0_ |= 2;
			return this.result_;
		}

		public MutableDebug.RuleEvaluationStepInfo getMutableRulesEvaluation() {
			assertMutable();
			ensureRulesEvaluationInitialized();
			this.bitField0_ |= 1;
			return this.rulesEvaluation_;
		}

		public Parser<MutableDebug.MacroEvaluationInfo> getParserForType() {
			return PARSER;
		}

		public MutableDebug.ResolvedFunctionCall getResult() {
			return this.result_;
		}

		public MutableDebug.RuleEvaluationStepInfo getRulesEvaluation() {
			return this.rulesEvaluation_;
		}

		public int getSerializedSize() {
			int size = 0;
			if ((this.bitField0_ & 1) == 1) {
				size += CodedOutputStream.computeMessageSize(RULES_EVALUATION_FIELD_NUMBER, this.rulesEvaluation_);
			}
			if ((this.bitField0_ & 2) == 2) {
				size += CodedOutputStream.computeMessageSize(RESULT_FIELD_NUMBER, this.result_);
			}
			size += this.unknownFields.size();
			this.cachedSize = size;
			return size;
		}

		public boolean hasResult() {
			return (this.bitField0_ & 2) == 2;
		}

		public boolean hasRulesEvaluation() {
			return (this.bitField0_ & 1) == 1;
		}

		public int hashCode() {
			int hash = 41;
			if (hasRulesEvaluation()) {
				hash = 1517 + 1;
				hash = 80454 + getRulesEvaluation().hashCode();
			}
			if (hasResult()) {
				hash = (((hash * 37) + 3) * 53) + getResult().hashCode();
			}
			return (hash * 29) + this.unknownFields.hashCode();
		}

		protected MessageLite internalImmutableDefault() {
			if (immutableDefault == null) {
				immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$MacroEvaluationInfo");
			}
			return immutableDefault;
		}

		public final boolean isInitialized() {
			if (!hasRulesEvaluation() || getRulesEvaluation().isInitialized()) {
				if (!hasResult() || getResult().isInitialized()) {
					return true;
				}
				return false;
			}
			return false;
		}

		public MutableDebug.MacroEvaluationInfo mergeFrom(MutableDebug.MacroEvaluationInfo other) {
			if (this == other) {
				throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
			} else {
				assertMutable();
				if (other == getDefaultInstance()) {
					return this;
				} else {
					if (other.hasRulesEvaluation()) {
						ensureRulesEvaluationInitialized();
						this.rulesEvaluation_.mergeFrom(other.getRulesEvaluation());
						this.bitField0_ |= 1;
					}
					if (other.hasResult()) {
						ensureResultInitialized();
						this.result_.mergeFrom(other.getResult());
						this.bitField0_ |= 2;
					}
					this.unknownFields = this.unknownFields.concat(other.unknownFields);
					return this;
				}
			}
		}

		public boolean mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) {
			CodedOutputStream unknownFieldsCodedOutput;
			boolean done;
			boolean r5z;
			assertMutable();
			try {
				OutputStream unknownFieldsOutput = ByteString.newOutput();
				unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
				done = false;
				while (!done) {
					int tag = input.readTag();
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case Value.ESCAPING_FIELD_NUMBER:
						if (this.rulesEvaluation_ == MutableDebug.RuleEvaluationStepInfo.getDefaultInstance()) {
							this.rulesEvaluation_ = MutableDebug.RuleEvaluationStepInfo.newMessage();
						}
						this.bitField0_ |= 1;
						input.readMessage(this.rulesEvaluation_, extensionRegistry);
						break;
					case 26:
						if (this.result_ == MutableDebug.ResolvedFunctionCall.getDefaultInstance()) {
							this.result_ = MutableDebug.ResolvedFunctionCall.newMessage();
						}
						this.bitField0_ |= 2;
						input.readMessage(this.result_, extensionRegistry);
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				}
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
				r5z = true;
			} catch (IOException e) {
				r5z = false;
			}
			return r5z;
		}

		public MutableDebug.MacroEvaluationInfo newMessageForType() {
			return new MutableDebug.MacroEvaluationInfo();
		}

		public MutableDebug.MacroEvaluationInfo setResult(MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 2;
				this.result_ = value;
				return this;
			}
		}

		public MutableDebug.MacroEvaluationInfo setRulesEvaluation(MutableDebug.RuleEvaluationStepInfo value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 1;
				this.rulesEvaluation_ = value;
				return this;
			}
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeToWithCachedSizes(CodedOutputStream output) throws IOException {
			int bytesWrittenBefore = output.getTotalBytesWritten();
			if ((this.bitField0_ & 1) == 1) {
				output.writeMessageWithCachedSizes(RULES_EVALUATION_FIELD_NUMBER, this.rulesEvaluation_);
			}
			if ((this.bitField0_ & 2) == 2) {
				output.writeMessageWithCachedSizes(RESULT_FIELD_NUMBER, this.result_);
			}
			output.writeRawBytes(this.unknownFields);
			if (getCachedSize() != output.getTotalBytesWritten() - bytesWrittenBefore) {
				throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
			}
		}
	}

	public static final class ResolvedFunctionCall extends GeneratedMutableMessageLite<MutableDebug.ResolvedFunctionCall> implements MutableMessageLite {
		public static final int ASSOCIATED_RULE_NAME_FIELD_NUMBER = 3;
		public static Parser<MutableDebug.ResolvedFunctionCall> PARSER = null;
		public static final int PROPERTIES_FIELD_NUMBER = 1;
		public static final int RESULT_FIELD_NUMBER = 2;
		private static final MutableDebug.ResolvedFunctionCall defaultInstance;
		private static volatile MessageLite immutableDefault;
		private static final long serialVersionUID = 0;
		private Object associatedRuleName_;
		private int bitField0_;
		private List<MutableDebug.ResolvedProperty> properties_;
		private Value result_;

		static {
			immutableDefault = null;
			defaultInstance = new MutableDebug.ResolvedFunctionCall(true);
			defaultInstance.initFields();
			defaultInstance.makeImmutable();
			PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
		}

		private ResolvedFunctionCall() {
			this.properties_ = null;
			this.associatedRuleName_ = Internal.EMPTY_BYTE_ARRAY;
			initFields();
		}

		private ResolvedFunctionCall(boolean noInit) {
			this.properties_ = null;
			this.associatedRuleName_ = Internal.EMPTY_BYTE_ARRAY;
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

		public static MutableDebug.ResolvedFunctionCall getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.result_ = Value.getDefaultInstance();
		}

		public static MutableDebug.ResolvedFunctionCall newMessage() {
			return new MutableDebug.ResolvedFunctionCall();
		}

		public MutableDebug.ResolvedFunctionCall addAllProperties(Iterable<MutableDebug.ResolvedProperty> values) {
			assertMutable();
			ensurePropertiesInitialized();
			AbstractMutableMessageLite.addAll(values, this.properties_);
			return this;
		}

		public MutableDebug.ResolvedFunctionCall addProperties(MutableDebug.ResolvedProperty value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensurePropertiesInitialized();
				this.properties_.add(value);
				return this;
			}
		}

		public MutableDebug.ResolvedProperty addProperties() {
			assertMutable();
			ensurePropertiesInitialized();
			MutableDebug.ResolvedProperty value = MutableDebug.ResolvedProperty.newMessage();
			this.properties_.add(value);
			return value;
		}

		public MutableDebug.ResolvedFunctionCall clear() {
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

		public MutableDebug.ResolvedFunctionCall clearAssociatedRuleName() {
			assertMutable();
			this.bitField0_ &= -3;
			this.associatedRuleName_ = Internal.EMPTY_BYTE_ARRAY;
			return this;
		}

		public MutableDebug.ResolvedFunctionCall clearProperties() {
			assertMutable();
			this.properties_ = null;
			return this;
		}

		public MutableDebug.ResolvedFunctionCall clearResult() {
			assertMutable();
			this.bitField0_ &= -2;
			if (this.result_ != Value.getDefaultInstance()) {
				this.result_.clear();
			}
			return this;
		}

		public MutableDebug.ResolvedFunctionCall clone() {
			return newMessageForType().mergeFrom(this);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof MutableDebug.ResolvedFunctionCall))) {
				return super.equals(obj);
			} else {
				boolean result;
				MutableDebug.ResolvedFunctionCall other = (MutableDebug.ResolvedFunctionCall) obj;
				result = (!true || !getPropertiesList().equals(other.getPropertiesList())) ? false : true;
				if (!result || hasResult() != other.hasResult()) {
					result = false;
				} else {
					result = true;
				}
				if (hasResult()) {
					result = (!result || !getResult().equals(other.getResult())) ? false : true;
				}
				if (!result || hasAssociatedRuleName() != other.hasAssociatedRuleName()) {
					result = false;
				} else {
					result = true;
				}
				if (hasAssociatedRuleName()) {
					result = (!result || !getAssociatedRuleName().equals(other.getAssociatedRuleName())) ? false : true;
				}
				return result;
			}
		}

		public String getAssociatedRuleName() {
			Object ref = this.associatedRuleName_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				byte[] byteArray = (byte[]) ((byte[]) ref);
				String s = Internal.toStringUtf8(byteArray);
				if (Internal.isValidUtf8(byteArray)) {
					this.associatedRuleName_ = s;
				}
				return s;
			}
		}

		public byte[] getAssociatedRuleNameAsBytes() {
			Object ref = this.associatedRuleName_;
			if (ref instanceof String) {
				Object byteArray = Internal.toByteArray((String) ref);
				this.associatedRuleName_ = byteArray;
				return byteArray;
			} else {
				return (byte[]) ((byte[]) ref);
			}
		}

		public final MutableDebug.ResolvedFunctionCall getDefaultInstanceForType() {
			return defaultInstance;
		}

		public MutableDebug.ResolvedProperty getMutableProperties(int index) {
			return (MutableDebug.ResolvedProperty) this.properties_.get(index);
		}

		public List<MutableDebug.ResolvedProperty> getMutablePropertiesList() {
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

		public Parser<MutableDebug.ResolvedFunctionCall> getParserForType() {
			return PARSER;
		}

		public MutableDebug.ResolvedProperty getProperties(int index) {
			return (MutableDebug.ResolvedProperty) this.properties_.get(index);
		}

		public int getPropertiesCount() {
			return (this.properties_ == null) ? 0 : this.properties_.size();
		}

		public List<MutableDebug.ResolvedProperty> getPropertiesList() {
			return (this.properties_ == null) ? Collections.emptyList() : Collections.unmodifiableList(this.properties_);
		}

		public Value getResult() {
			return this.result_;
		}

		public int getSerializedSize() {
			int size = 0;
			if (this.properties_ != null) {
				int i = 0;
				while (i < this.properties_.size()) {
					size += CodedOutputStream.computeMessageSize(PROPERTIES_FIELD_NUMBER, (MessageLite) this.properties_.get(i));
					i++;
				}
			}
			if ((this.bitField0_ & 1) == 1) {
				size += CodedOutputStream.computeMessageSize(RESULT_FIELD_NUMBER, this.result_);
			}
			if ((this.bitField0_ & 2) == 2) {
				size += CodedOutputStream.computeByteArraySize(ASSOCIATED_RULE_NAME_FIELD_NUMBER, getAssociatedRuleNameAsBytes());
			}
			size += this.unknownFields.size();
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
			int hash = 41;
			if (getPropertiesCount() > 0) {
				hash = 1517 + 1;
				hash = 80454 + getPropertiesList().hashCode();
			}
			if (hasResult()) {
				hash = (((hash * 37) + 2) * 53) + getResult().hashCode();
			}
			if (hasAssociatedRuleName()) {
				hash = (((hash * 37) + 3) * 53) + getAssociatedRuleName().hashCode();
			}
			return (hash * 29) + this.unknownFields.hashCode();
		}

		protected MessageLite internalImmutableDefault() {
			if (immutableDefault == null) {
				immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$ResolvedFunctionCall");
			}
			return immutableDefault;
		}

		public final boolean isInitialized() {
			int i = 0;
			while (i < getPropertiesCount()) {
				if (!getProperties(i).isInitialized()) {
					return false;
				} else {
					i++;
				}
			}
			if (!hasResult() || getResult().isInitialized()) {
				return true;
			}
			return false;
		}

		public MutableDebug.ResolvedFunctionCall mergeFrom(MutableDebug.ResolvedFunctionCall other) {
			if (this == other) {
				throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
			} else {
				assertMutable();
				if (other == getDefaultInstance()) {
					return this;
				} else if (other.properties_ == null || other.properties_.isEmpty()) {
					if (!other.hasResult()) {
						ensureResultInitialized();
						this.result_.mergeFrom(other.getResult());
						this.bitField0_ |= 1;
					}
					if (other.hasAssociatedRuleName()) {
						this.bitField0_ |= 2;
						if (other.associatedRuleName_ instanceof String) {
							this.associatedRuleName_ = other.associatedRuleName_;
						} else {
							ba = (byte[]) other.associatedRuleName_;
							this.associatedRuleName_ = Arrays.copyOf(ba, ba.length);
						}
					}
					this.unknownFields = this.unknownFields.concat(other.unknownFields);
					return this;
				} else {
					ensurePropertiesInitialized();
					AbstractMutableMessageLite.addAll(other.properties_, this.properties_);
					if (!other.hasResult()) {
						if (other.hasAssociatedRuleName()) {
							this.unknownFields = this.unknownFields.concat(other.unknownFields);
							return this;
						} else {
							this.bitField0_ |= 2;
							if (other.associatedRuleName_ instanceof String) {
								ba = (byte[]) other.associatedRuleName_;
								this.associatedRuleName_ = Arrays.copyOf(ba, ba.length);
								this.unknownFields = this.unknownFields.concat(other.unknownFields);
								return this;
							} else {
								this.associatedRuleName_ = other.associatedRuleName_;
								this.unknownFields = this.unknownFields.concat(other.unknownFields);
								return this;
							}
						}
					} else {
						ensureResultInitialized();
						this.result_.mergeFrom(other.getResult());
						this.bitField0_ |= 1;
						if (other.hasAssociatedRuleName()) {
							this.bitField0_ |= 2;
							if (other.associatedRuleName_ instanceof String) {
								this.associatedRuleName_ = other.associatedRuleName_;
							} else {
								ba = (byte[]) other.associatedRuleName_;
								this.associatedRuleName_ = Arrays.copyOf(ba, ba.length);
							}
						}
						this.unknownFields = this.unknownFields.concat(other.unknownFields);
						return this;
					}
				}
			}
		}

		public boolean mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) {
			CodedOutputStream unknownFieldsCodedOutput;
			boolean done;
			boolean r5z;
			assertMutable();
			try {
				OutputStream unknownFieldsOutput = ByteString.newOutput();
				unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
				done = false;
				while (!done) {
					int tag = input.readTag();
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case Value.ESCAPING_FIELD_NUMBER:
						input.readMessage(addProperties(), extensionRegistry);
						break;
					case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						if (this.result_ == Value.getDefaultInstance()) {
							this.result_ = Value.newMessage();
						}
						this.bitField0_ |= 1;
						input.readMessage(this.result_, extensionRegistry);
						break;
					case 26:
						this.bitField0_ |= 2;
						this.associatedRuleName_ = input.readByteArray();
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				}
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
				r5z = true;
			} catch (IOException e) {
				r5z = false;
			}
			return r5z;
		}

		public MutableDebug.ResolvedFunctionCall newMessageForType() {
			return new MutableDebug.ResolvedFunctionCall();
		}

		public MutableDebug.ResolvedFunctionCall setAssociatedRuleName(String value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 2;
				this.associatedRuleName_ = value;
				return this;
			}
		}

		public MutableDebug.ResolvedFunctionCall setAssociatedRuleNameAsBytes(byte[] value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 2;
				this.associatedRuleName_ = value;
				return this;
			}
		}

		public MutableDebug.ResolvedFunctionCall setProperties(int index, MutableDebug.ResolvedProperty value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensurePropertiesInitialized();
				this.properties_.set(index, value);
				return this;
			}
		}

		public MutableDebug.ResolvedFunctionCall setResult(Value value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 1;
				this.result_ = value;
				return this;
			}
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeToWithCachedSizes(CodedOutputStream output) throws IOException {
			int bytesWrittenBefore = output.getTotalBytesWritten();
			if (this.properties_ != null) {
				int i = 0;
				while (i < this.properties_.size()) {
					output.writeMessageWithCachedSizes(PROPERTIES_FIELD_NUMBER, (MutableMessageLite) this.properties_.get(i));
					i++;
				}
			}
			if ((this.bitField0_ & 1) == 1) {
				output.writeMessageWithCachedSizes(RESULT_FIELD_NUMBER, this.result_);
			}
			if ((this.bitField0_ & 2) == 2) {
				output.writeByteArray(ASSOCIATED_RULE_NAME_FIELD_NUMBER, getAssociatedRuleNameAsBytes());
			}
			output.writeRawBytes(this.unknownFields);
			if (getCachedSize() != output.getTotalBytesWritten() - bytesWrittenBefore) {
				throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
			}
		}
	}

	public static final class ResolvedProperty extends GeneratedMutableMessageLite<MutableDebug.ResolvedProperty> implements MutableMessageLite {
		public static final int KEY_FIELD_NUMBER = 1;
		public static Parser<MutableDebug.ResolvedProperty> PARSER = null;
		public static final int VALUE_FIELD_NUMBER = 2;
		private static final MutableDebug.ResolvedProperty defaultInstance;
		private static volatile MessageLite immutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private Object key_;
		private Value value_;

		static {
			immutableDefault = null;
			defaultInstance = new MutableDebug.ResolvedProperty(true);
			defaultInstance.initFields();
			defaultInstance.makeImmutable();
			PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
		}

		private ResolvedProperty() {
			this.key_ = Internal.EMPTY_BYTE_ARRAY;
			initFields();
		}

		private ResolvedProperty(boolean noInit) {
			this.key_ = Internal.EMPTY_BYTE_ARRAY;
		}

		private void ensureValueInitialized() {
			if (this.value_ == Value.getDefaultInstance()) {
				this.value_ = Value.newMessage();
			}
		}

		public static MutableDebug.ResolvedProperty getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.value_ = Value.getDefaultInstance();
		}

		public static MutableDebug.ResolvedProperty newMessage() {
			return new MutableDebug.ResolvedProperty();
		}

		public MutableDebug.ResolvedProperty clear() {
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

		public MutableDebug.ResolvedProperty clearKey() {
			assertMutable();
			this.bitField0_ &= -2;
			this.key_ = Internal.EMPTY_BYTE_ARRAY;
			return this;
		}

		public MutableDebug.ResolvedProperty clearValue() {
			assertMutable();
			this.bitField0_ &= -3;
			if (this.value_ != Value.getDefaultInstance()) {
				this.value_.clear();
			}
			return this;
		}

		public MutableDebug.ResolvedProperty clone() {
			return newMessageForType().mergeFrom(this);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof MutableDebug.ResolvedProperty))) {
				return super.equals(obj);
			} else {
				boolean result;
				MutableDebug.ResolvedProperty other = (MutableDebug.ResolvedProperty) obj;
				if (!true || hasKey() != other.hasKey()) {
					result = false;
				} else {
					result = true;
				}
				if (hasKey()) {
					result = (!result || !getKey().equals(other.getKey())) ? false : true;
				}
				if (!result || hasValue() != other.hasValue()) {
					result = false;
				} else {
					result = true;
				}
				if (hasValue()) {
					result = (!result || !getValue().equals(other.getValue())) ? false : true;
				}
				return result;
			}
		}

		public final MutableDebug.ResolvedProperty getDefaultInstanceForType() {
			return defaultInstance;
		}

		public String getKey() {
			Object ref = this.key_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				byte[] byteArray = (byte[]) ((byte[]) ref);
				String s = Internal.toStringUtf8(byteArray);
				if (Internal.isValidUtf8(byteArray)) {
					this.key_ = s;
				}
				return s;
			}
		}

		public byte[] getKeyAsBytes() {
			Object ref = this.key_;
			if (ref instanceof String) {
				Object byteArray = Internal.toByteArray((String) ref);
				this.key_ = byteArray;
				return byteArray;
			} else {
				return (byte[]) ((byte[]) ref);
			}
		}

		public Value getMutableValue() {
			assertMutable();
			ensureValueInitialized();
			this.bitField0_ |= 2;
			return this.value_;
		}

		public Parser<MutableDebug.ResolvedProperty> getParserForType() {
			return PARSER;
		}

		public int getSerializedSize() {
			int size = 0;
			if ((this.bitField0_ & 1) == 1) {
				size += CodedOutputStream.computeByteArraySize(KEY_FIELD_NUMBER, getKeyAsBytes());
			}
			if ((this.bitField0_ & 2) == 2) {
				size += CodedOutputStream.computeMessageSize(VALUE_FIELD_NUMBER, this.value_);
			}
			size += this.unknownFields.size();
			this.cachedSize = size;
			return size;
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
			int hash = 41;
			if (hasKey()) {
				hash = 1517 + 1;
				hash = 80454 + getKey().hashCode();
			}
			if (hasValue()) {
				hash = (((hash * 37) + 2) * 53) + getValue().hashCode();
			}
			return (hash * 29) + this.unknownFields.hashCode();
		}

		protected MessageLite internalImmutableDefault() {
			if (immutableDefault == null) {
				immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$ResolvedProperty");
			}
			return immutableDefault;
		}

		public final boolean isInitialized() {
			return !hasValue() || getValue().isInitialized();
		}

		public MutableDebug.ResolvedProperty mergeFrom(MutableDebug.ResolvedProperty other) {
			if (this == other) {
				throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
			} else {
				assertMutable();
				if (other == getDefaultInstance()) {
					return this;
				} else {
					if (other.hasKey()) {
						this.bitField0_ |= 1;
						if (other.key_ instanceof String) {
							this.key_ = other.key_;
						} else {
							byte[] ba = (byte[]) other.key_;
							this.key_ = Arrays.copyOf(ba, ba.length);
						}
					}
					if (other.hasValue()) {
						ensureValueInitialized();
						this.value_.mergeFrom(other.getValue());
						this.bitField0_ |= 2;
					}
					this.unknownFields = this.unknownFields.concat(other.unknownFields);
					return this;
				}
			}
		}

		public boolean mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) {
			CodedOutputStream unknownFieldsCodedOutput;
			boolean done;
			boolean r5z;
			assertMutable();
			try {
				OutputStream unknownFieldsOutput = ByteString.newOutput();
				unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
				done = false;
				while (!done) {
					int tag = input.readTag();
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case Value.ESCAPING_FIELD_NUMBER:
						this.bitField0_ |= 1;
						this.key_ = input.readByteArray();
						break;
					case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						if (this.value_ == Value.getDefaultInstance()) {
							this.value_ = Value.newMessage();
						}
						this.bitField0_ |= 2;
						input.readMessage(this.value_, extensionRegistry);
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				}
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
				r5z = true;
			} catch (IOException e) {
				r5z = false;
			}
			return r5z;
		}

		public MutableDebug.ResolvedProperty newMessageForType() {
			return new MutableDebug.ResolvedProperty();
		}

		public MutableDebug.ResolvedProperty setKey(String value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 1;
				this.key_ = value;
				return this;
			}
		}

		public MutableDebug.ResolvedProperty setKeyAsBytes(byte[] value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 1;
				this.key_ = value;
				return this;
			}
		}

		public MutableDebug.ResolvedProperty setValue(Value value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 2;
				this.value_ = value;
				return this;
			}
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeToWithCachedSizes(CodedOutputStream output) throws IOException {
			int bytesWrittenBefore = output.getTotalBytesWritten();
			if ((this.bitField0_ & 1) == 1) {
				output.writeByteArray(KEY_FIELD_NUMBER, getKeyAsBytes());
			}
			if ((this.bitField0_ & 2) == 2) {
				output.writeMessageWithCachedSizes(VALUE_FIELD_NUMBER, this.value_);
			}
			output.writeRawBytes(this.unknownFields);
			if (getCachedSize() != output.getTotalBytesWritten() - bytesWrittenBefore) {
				throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
			}
		}
	}

	public static final class ResolvedRule extends GeneratedMutableMessageLite<MutableDebug.ResolvedRule> implements MutableMessageLite {
		public static final int ADD_MACROS_FIELD_NUMBER = 5;
		public static final int ADD_TAGS_FIELD_NUMBER = 3;
		public static final int NEGATIVE_PREDICATES_FIELD_NUMBER = 2;
		public static Parser<MutableDebug.ResolvedRule> PARSER = null;
		public static final int POSITIVE_PREDICATES_FIELD_NUMBER = 1;
		public static final int REMOVE_MACROS_FIELD_NUMBER = 6;
		public static final int REMOVE_TAGS_FIELD_NUMBER = 4;
		public static final int RESULT_FIELD_NUMBER = 7;
		private static final MutableDebug.ResolvedRule defaultInstance;
		private static volatile MessageLite immutableDefault;
		private static final long serialVersionUID = 0;
		private List<MutableDebug.ResolvedFunctionCall> addMacros_;
		private List<MutableDebug.ResolvedFunctionCall> addTags_;
		private int bitField0_;
		private List<MutableDebug.ResolvedFunctionCall> negativePredicates_;
		private List<MutableDebug.ResolvedFunctionCall> positivePredicates_;
		private List<MutableDebug.ResolvedFunctionCall> removeMacros_;
		private List<MutableDebug.ResolvedFunctionCall> removeTags_;
		private Value result_;

		static {
			immutableDefault = null;
			defaultInstance = new MutableDebug.ResolvedRule(true);
			defaultInstance.initFields();
			defaultInstance.makeImmutable();
			PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
		}

		private ResolvedRule() {
			this.positivePredicates_ = null;
			this.negativePredicates_ = null;
			this.addTags_ = null;
			this.removeTags_ = null;
			this.addMacros_ = null;
			this.removeMacros_ = null;
			initFields();
		}

		private ResolvedRule(boolean noInit) {
			this.positivePredicates_ = null;
			this.negativePredicates_ = null;
			this.addTags_ = null;
			this.removeTags_ = null;
			this.addMacros_ = null;
			this.removeMacros_ = null;
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

		public static MutableDebug.ResolvedRule getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.result_ = Value.getDefaultInstance();
		}

		public static MutableDebug.ResolvedRule newMessage() {
			return new MutableDebug.ResolvedRule();
		}

		public MutableDebug.ResolvedFunctionCall addAddMacros() {
			assertMutable();
			ensureAddMacrosInitialized();
			MutableDebug.ResolvedFunctionCall value = MutableDebug.ResolvedFunctionCall.newMessage();
			this.addMacros_.add(value);
			return value;
		}

		public MutableDebug.ResolvedRule addAddMacros(MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureAddMacrosInitialized();
				this.addMacros_.add(value);
				return this;
			}
		}

		public MutableDebug.ResolvedFunctionCall addAddTags() {
			assertMutable();
			ensureAddTagsInitialized();
			MutableDebug.ResolvedFunctionCall value = MutableDebug.ResolvedFunctionCall.newMessage();
			this.addTags_.add(value);
			return value;
		}

		public MutableDebug.ResolvedRule addAddTags(MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureAddTagsInitialized();
				this.addTags_.add(value);
				return this;
			}
		}

		public MutableDebug.ResolvedRule addAllAddMacros(Iterable<MutableDebug.ResolvedFunctionCall> values) {
			assertMutable();
			ensureAddMacrosInitialized();
			AbstractMutableMessageLite.addAll(values, this.addMacros_);
			return this;
		}

		public MutableDebug.ResolvedRule addAllAddTags(Iterable<MutableDebug.ResolvedFunctionCall> values) {
			assertMutable();
			ensureAddTagsInitialized();
			AbstractMutableMessageLite.addAll(values, this.addTags_);
			return this;
		}

		public MutableDebug.ResolvedRule addAllNegativePredicates(Iterable<MutableDebug.ResolvedFunctionCall> values) {
			assertMutable();
			ensureNegativePredicatesInitialized();
			AbstractMutableMessageLite.addAll(values, this.negativePredicates_);
			return this;
		}

		public MutableDebug.ResolvedRule addAllPositivePredicates(Iterable<MutableDebug.ResolvedFunctionCall> values) {
			assertMutable();
			ensurePositivePredicatesInitialized();
			AbstractMutableMessageLite.addAll(values, this.positivePredicates_);
			return this;
		}

		public MutableDebug.ResolvedRule addAllRemoveMacros(Iterable<MutableDebug.ResolvedFunctionCall> values) {
			assertMutable();
			ensureRemoveMacrosInitialized();
			AbstractMutableMessageLite.addAll(values, this.removeMacros_);
			return this;
		}

		public MutableDebug.ResolvedRule addAllRemoveTags(Iterable<MutableDebug.ResolvedFunctionCall> values) {
			assertMutable();
			ensureRemoveTagsInitialized();
			AbstractMutableMessageLite.addAll(values, this.removeTags_);
			return this;
		}

		public MutableDebug.ResolvedFunctionCall addNegativePredicates() {
			assertMutable();
			ensureNegativePredicatesInitialized();
			MutableDebug.ResolvedFunctionCall value = MutableDebug.ResolvedFunctionCall.newMessage();
			this.negativePredicates_.add(value);
			return value;
		}

		public MutableDebug.ResolvedRule addNegativePredicates(MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureNegativePredicatesInitialized();
				this.negativePredicates_.add(value);
				return this;
			}
		}

		public MutableDebug.ResolvedFunctionCall addPositivePredicates() {
			assertMutable();
			ensurePositivePredicatesInitialized();
			MutableDebug.ResolvedFunctionCall value = MutableDebug.ResolvedFunctionCall.newMessage();
			this.positivePredicates_.add(value);
			return value;
		}

		public MutableDebug.ResolvedRule addPositivePredicates(MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensurePositivePredicatesInitialized();
				this.positivePredicates_.add(value);
				return this;
			}
		}

		public MutableDebug.ResolvedFunctionCall addRemoveMacros() {
			assertMutable();
			ensureRemoveMacrosInitialized();
			MutableDebug.ResolvedFunctionCall value = MutableDebug.ResolvedFunctionCall.newMessage();
			this.removeMacros_.add(value);
			return value;
		}

		public MutableDebug.ResolvedRule addRemoveMacros(MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureRemoveMacrosInitialized();
				this.removeMacros_.add(value);
				return this;
			}
		}

		public MutableDebug.ResolvedFunctionCall addRemoveTags() {
			assertMutable();
			ensureRemoveTagsInitialized();
			MutableDebug.ResolvedFunctionCall value = MutableDebug.ResolvedFunctionCall.newMessage();
			this.removeTags_.add(value);
			return value;
		}

		public MutableDebug.ResolvedRule addRemoveTags(MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureRemoveTagsInitialized();
				this.removeTags_.add(value);
				return this;
			}
		}

		public MutableDebug.ResolvedRule clear() {
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

		public MutableDebug.ResolvedRule clearAddMacros() {
			assertMutable();
			this.addMacros_ = null;
			return this;
		}

		public MutableDebug.ResolvedRule clearAddTags() {
			assertMutable();
			this.addTags_ = null;
			return this;
		}

		public MutableDebug.ResolvedRule clearNegativePredicates() {
			assertMutable();
			this.negativePredicates_ = null;
			return this;
		}

		public MutableDebug.ResolvedRule clearPositivePredicates() {
			assertMutable();
			this.positivePredicates_ = null;
			return this;
		}

		public MutableDebug.ResolvedRule clearRemoveMacros() {
			assertMutable();
			this.removeMacros_ = null;
			return this;
		}

		public MutableDebug.ResolvedRule clearRemoveTags() {
			assertMutable();
			this.removeTags_ = null;
			return this;
		}

		public MutableDebug.ResolvedRule clearResult() {
			assertMutable();
			this.bitField0_ &= -2;
			if (this.result_ != Value.getDefaultInstance()) {
				this.result_.clear();
			}
			return this;
		}

		public MutableDebug.ResolvedRule clone() {
			return newMessageForType().mergeFrom(this);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof MutableDebug.ResolvedRule))) {
				return super.equals(obj);
			} else {
				boolean result;
				MutableDebug.ResolvedRule other = (MutableDebug.ResolvedRule) obj;
				result = (!true || !getPositivePredicatesList().equals(other.getPositivePredicatesList())) ? false : true;
				result = (!result || !getNegativePredicatesList().equals(other.getNegativePredicatesList())) ? false : true;
				result = (!result || !getAddTagsList().equals(other.getAddTagsList())) ? false : true;
				result = (!result || !getRemoveTagsList().equals(other.getRemoveTagsList())) ? false : true;
				result = (!result || !getAddMacrosList().equals(other.getAddMacrosList())) ? false : true;
				result = (!result || !getRemoveMacrosList().equals(other.getRemoveMacrosList())) ? false : true;
				if (!result || hasResult() != other.hasResult()) {
					result = false;
				} else {
					result = true;
				}
				if (hasResult()) {
					result = (!result || !getResult().equals(other.getResult())) ? false : true;
				}
				return result;
			}
		}

		public MutableDebug.ResolvedFunctionCall getAddMacros(int index) {
			return (MutableDebug.ResolvedFunctionCall) this.addMacros_.get(index);
		}

		public int getAddMacrosCount() {
			return (this.addMacros_ == null) ? 0 : this.addMacros_.size();
		}

		public List<MutableDebug.ResolvedFunctionCall> getAddMacrosList() {
			return (this.addMacros_ == null) ? Collections.emptyList() : Collections.unmodifiableList(this.addMacros_);
		}

		public MutableDebug.ResolvedFunctionCall getAddTags(int index) {
			return (MutableDebug.ResolvedFunctionCall) this.addTags_.get(index);
		}

		public int getAddTagsCount() {
			return (this.addTags_ == null) ? 0 : this.addTags_.size();
		}

		public List<MutableDebug.ResolvedFunctionCall> getAddTagsList() {
			return (this.addTags_ == null) ? Collections.emptyList() : Collections.unmodifiableList(this.addTags_);
		}

		public final MutableDebug.ResolvedRule getDefaultInstanceForType() {
			return defaultInstance;
		}

		public MutableDebug.ResolvedFunctionCall getMutableAddMacros(int index) {
			return (MutableDebug.ResolvedFunctionCall) this.addMacros_.get(index);
		}

		public List<MutableDebug.ResolvedFunctionCall> getMutableAddMacrosList() {
			assertMutable();
			ensureAddMacrosInitialized();
			return this.addMacros_;
		}

		public MutableDebug.ResolvedFunctionCall getMutableAddTags(int index) {
			return (MutableDebug.ResolvedFunctionCall) this.addTags_.get(index);
		}

		public List<MutableDebug.ResolvedFunctionCall> getMutableAddTagsList() {
			assertMutable();
			ensureAddTagsInitialized();
			return this.addTags_;
		}

		public MutableDebug.ResolvedFunctionCall getMutableNegativePredicates(int index) {
			return (MutableDebug.ResolvedFunctionCall) this.negativePredicates_.get(index);
		}

		public List<MutableDebug.ResolvedFunctionCall> getMutableNegativePredicatesList() {
			assertMutable();
			ensureNegativePredicatesInitialized();
			return this.negativePredicates_;
		}

		public MutableDebug.ResolvedFunctionCall getMutablePositivePredicates(int index) {
			return (MutableDebug.ResolvedFunctionCall) this.positivePredicates_.get(index);
		}

		public List<MutableDebug.ResolvedFunctionCall> getMutablePositivePredicatesList() {
			assertMutable();
			ensurePositivePredicatesInitialized();
			return this.positivePredicates_;
		}

		public MutableDebug.ResolvedFunctionCall getMutableRemoveMacros(int index) {
			return (MutableDebug.ResolvedFunctionCall) this.removeMacros_.get(index);
		}

		public List<MutableDebug.ResolvedFunctionCall> getMutableRemoveMacrosList() {
			assertMutable();
			ensureRemoveMacrosInitialized();
			return this.removeMacros_;
		}

		public MutableDebug.ResolvedFunctionCall getMutableRemoveTags(int index) {
			return (MutableDebug.ResolvedFunctionCall) this.removeTags_.get(index);
		}

		public List<MutableDebug.ResolvedFunctionCall> getMutableRemoveTagsList() {
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

		public MutableDebug.ResolvedFunctionCall getNegativePredicates(int index) {
			return (MutableDebug.ResolvedFunctionCall) this.negativePredicates_.get(index);
		}

		public int getNegativePredicatesCount() {
			return (this.negativePredicates_ == null) ? 0 : this.negativePredicates_.size();
		}

		public List<MutableDebug.ResolvedFunctionCall> getNegativePredicatesList() {
			return (this.negativePredicates_ == null) ? Collections.emptyList() : Collections.unmodifiableList(this.negativePredicates_);
		}

		public Parser<MutableDebug.ResolvedRule> getParserForType() {
			return PARSER;
		}

		public MutableDebug.ResolvedFunctionCall getPositivePredicates(int index) {
			return (MutableDebug.ResolvedFunctionCall) this.positivePredicates_.get(index);
		}

		public int getPositivePredicatesCount() {
			return (this.positivePredicates_ == null) ? 0 : this.positivePredicates_.size();
		}

		public List<MutableDebug.ResolvedFunctionCall> getPositivePredicatesList() {
			return (this.positivePredicates_ == null) ? Collections.emptyList() : Collections.unmodifiableList(this.positivePredicates_);
		}

		public MutableDebug.ResolvedFunctionCall getRemoveMacros(int index) {
			return (MutableDebug.ResolvedFunctionCall) this.removeMacros_.get(index);
		}

		public int getRemoveMacrosCount() {
			return (this.removeMacros_ == null) ? 0 : this.removeMacros_.size();
		}

		public List<MutableDebug.ResolvedFunctionCall> getRemoveMacrosList() {
			return (this.removeMacros_ == null) ? Collections.emptyList() : Collections.unmodifiableList(this.removeMacros_);
		}

		public MutableDebug.ResolvedFunctionCall getRemoveTags(int index) {
			return (MutableDebug.ResolvedFunctionCall) this.removeTags_.get(index);
		}

		public int getRemoveTagsCount() {
			return (this.removeTags_ == null) ? 0 : this.removeTags_.size();
		}

		public List<MutableDebug.ResolvedFunctionCall> getRemoveTagsList() {
			return (this.removeTags_ == null) ? Collections.emptyList() : Collections.unmodifiableList(this.removeTags_);
		}

		public Value getResult() {
			return this.result_;
		}

		public int getSerializedSize() {
			int i;
			int size = 0;
			if (this.positivePredicates_ != null) {
				i = 0;
				while (i < this.positivePredicates_.size()) {
					size += CodedOutputStream.computeMessageSize(POSITIVE_PREDICATES_FIELD_NUMBER, (MessageLite) this.positivePredicates_.get(i));
					i++;
				}
			}
			if (this.negativePredicates_ != null) {
				i = 0;
				while (i < this.negativePredicates_.size()) {
					size += CodedOutputStream.computeMessageSize(NEGATIVE_PREDICATES_FIELD_NUMBER, (MessageLite) this.negativePredicates_.get(i));
					i++;
				}
			}
			if (this.addTags_ != null) {
				i = 0;
				while (i < this.addTags_.size()) {
					size += CodedOutputStream.computeMessageSize(ADD_TAGS_FIELD_NUMBER, (MessageLite) this.addTags_.get(i));
					i++;
				}
			}
			if (this.removeTags_ != null) {
				i = 0;
				while (i < this.removeTags_.size()) {
					size += CodedOutputStream.computeMessageSize(REMOVE_TAGS_FIELD_NUMBER, (MessageLite) this.removeTags_.get(i));
					i++;
				}
			}
			if (this.addMacros_ != null) {
				i = 0;
				while (i < this.addMacros_.size()) {
					size += CodedOutputStream.computeMessageSize(ADD_MACROS_FIELD_NUMBER, (MessageLite) this.addMacros_.get(i));
					i++;
				}
			}
			if (this.removeMacros_ != null) {
				i = 0;
				while (i < this.removeMacros_.size()) {
					i++;
				}
			}
			if ((this.bitField0_ & 1) == 1) {
				size += CodedOutputStream.computeMessageSize(RESULT_FIELD_NUMBER, this.result_);
			}
			size += this.unknownFields.size();
			this.cachedSize = size;
			return size;
		}

		public boolean hasResult() {
			return (this.bitField0_ & 1) == 1;
		}

		public int hashCode() {
			int hash = 41;
			if (getPositivePredicatesCount() > 0) {
				hash = 1517 + 1;
				hash = 80454 + getPositivePredicatesList().hashCode();
			}
			if (getNegativePredicatesCount() > 0) {
				hash = (((hash * 37) + 2) * 53) + getNegativePredicatesList().hashCode();
			}
			if (getAddTagsCount() > 0) {
				hash = (((hash * 37) + 3) * 53) + getAddTagsList().hashCode();
			}
			if (getRemoveTagsCount() > 0) {
				hash = (((hash * 37) + 4) * 53) + getRemoveTagsList().hashCode();
			}
			if (getAddMacrosCount() > 0) {
				hash = (((hash * 37) + 5) * 53) + getAddMacrosList().hashCode();
			}
			if (getRemoveMacrosCount() > 0) {
				hash = (((hash * 37) + 6) * 53) + getRemoveMacrosList().hashCode();
			}
			if (hasResult()) {
				hash = (((hash * 37) + 7) * 53) + getResult().hashCode();
			}
			return (hash * 29) + this.unknownFields.hashCode();
		}

		protected MessageLite internalImmutableDefault() {
			if (immutableDefault == null) {
				immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$ResolvedRule");
			}
			return immutableDefault;
		}

		public final boolean isInitialized() {
			int i = 0;
			while (i < getPositivePredicatesCount()) {
				if (!getPositivePredicates(i).isInitialized()) {
					return false;
				} else {
					i++;
				}
			}
			i = 0;
			while (i < getNegativePredicatesCount()) {
				if (getNegativePredicates(i).isInitialized()) {
					i++;
				}
				return false;
			}
			i = 0;
			while (i < getAddTagsCount()) {
				if (getAddTags(i).isInitialized()) {
					i++;
				}
				return false;
			}
			i = 0;
			while (i < getRemoveTagsCount()) {
				if (getRemoveTags(i).isInitialized()) {
					i++;
				}
				return false;
			}
			i = 0;
			while (i < getAddMacrosCount()) {
				if (getAddMacros(i).isInitialized()) {
					i++;
				}
				return false;
			}
			i = 0;
			while (i < getRemoveMacrosCount()) {
				if (getRemoveMacros(i).isInitialized()) {
					i++;
				}
				return false;
			}
			if (!hasResult() || getResult().isInitialized()) {
				return true;
			}
			return false;
		}

		public MutableDebug.ResolvedRule mergeFrom(MutableDebug.ResolvedRule other) {
			if (this == other) {
				throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
			} else {
				assertMutable();
				if (other == getDefaultInstance()) {
					return this;
				} else if (other.positivePredicates_ == null || other.positivePredicates_.isEmpty()) {
					if (other.negativePredicates_ == null || other.negativePredicates_.isEmpty()) {
						if (other.addTags_ == null || other.addTags_.isEmpty()) {
							if (other.removeTags_ == null || other.removeTags_.isEmpty()) {
								if (other.addMacros_ == null || other.addMacros_.isEmpty()) {
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureAddMacrosInitialized();
									AbstractMutableMessageLite.addAll(other.addMacros_, this.addMacros_);
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							} else {
								ensureRemoveTagsInitialized();
								AbstractMutableMessageLite.addAll(other.removeTags_, this.removeTags_);
								if (other.addMacros_ == null || other.addMacros_.isEmpty()) {
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureAddMacrosInitialized();
									AbstractMutableMessageLite.addAll(other.addMacros_, this.addMacros_);
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							}
						} else {
							ensureAddTagsInitialized();
							AbstractMutableMessageLite.addAll(other.addTags_, this.addTags_);
							if (other.removeTags_ == null || other.removeTags_.isEmpty()) {
								if (other.addMacros_ == null || other.addMacros_.isEmpty()) {
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureAddMacrosInitialized();
									AbstractMutableMessageLite.addAll(other.addMacros_, this.addMacros_);
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							} else {
								ensureRemoveTagsInitialized();
								AbstractMutableMessageLite.addAll(other.removeTags_, this.removeTags_);
								if (other.addMacros_ == null || other.addMacros_.isEmpty()) {
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureAddMacrosInitialized();
									AbstractMutableMessageLite.addAll(other.addMacros_, this.addMacros_);
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							}
						}
					} else {
						ensureNegativePredicatesInitialized();
						AbstractMutableMessageLite.addAll(other.negativePredicates_, this.negativePredicates_);
						if (other.addTags_ == null || other.addTags_.isEmpty()) {
							if (other.removeTags_ == null || other.removeTags_.isEmpty()) {
								if (other.addMacros_ == null || other.addMacros_.isEmpty()) {
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureAddMacrosInitialized();
									AbstractMutableMessageLite.addAll(other.addMacros_, this.addMacros_);
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							} else {
								ensureRemoveTagsInitialized();
								AbstractMutableMessageLite.addAll(other.removeTags_, this.removeTags_);
								if (other.addMacros_ == null || other.addMacros_.isEmpty()) {
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureAddMacrosInitialized();
									AbstractMutableMessageLite.addAll(other.addMacros_, this.addMacros_);
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							}
						} else {
							ensureAddTagsInitialized();
							AbstractMutableMessageLite.addAll(other.addTags_, this.addTags_);
							if (other.removeTags_ == null || other.removeTags_.isEmpty()) {
								if (other.addMacros_ == null || other.addMacros_.isEmpty()) {
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureAddMacrosInitialized();
									AbstractMutableMessageLite.addAll(other.addMacros_, this.addMacros_);
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							} else {
								ensureRemoveTagsInitialized();
								AbstractMutableMessageLite.addAll(other.removeTags_, this.removeTags_);
								if (other.addMacros_ == null || other.addMacros_.isEmpty()) {
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureAddMacrosInitialized();
									AbstractMutableMessageLite.addAll(other.addMacros_, this.addMacros_);
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							}
						}
					}
				} else {
					ensurePositivePredicatesInitialized();
					AbstractMutableMessageLite.addAll(other.positivePredicates_, this.positivePredicates_);
					if (other.negativePredicates_ == null || other.negativePredicates_.isEmpty()) {
						if (other.addTags_ == null || other.addTags_.isEmpty()) {
							if (other.removeTags_ == null || other.removeTags_.isEmpty()) {
								if (other.addMacros_ == null || other.addMacros_.isEmpty()) {
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureAddMacrosInitialized();
									AbstractMutableMessageLite.addAll(other.addMacros_, this.addMacros_);
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							} else {
								ensureRemoveTagsInitialized();
								AbstractMutableMessageLite.addAll(other.removeTags_, this.removeTags_);
								if (other.addMacros_ == null || other.addMacros_.isEmpty()) {
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureAddMacrosInitialized();
									AbstractMutableMessageLite.addAll(other.addMacros_, this.addMacros_);
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							}
						} else {
							ensureAddTagsInitialized();
							AbstractMutableMessageLite.addAll(other.addTags_, this.addTags_);
							if (other.removeTags_ == null || other.removeTags_.isEmpty()) {
								if (other.addMacros_ == null || other.addMacros_.isEmpty()) {
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureAddMacrosInitialized();
									AbstractMutableMessageLite.addAll(other.addMacros_, this.addMacros_);
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							} else {
								ensureRemoveTagsInitialized();
								AbstractMutableMessageLite.addAll(other.removeTags_, this.removeTags_);
								if (other.addMacros_ == null || other.addMacros_.isEmpty()) {
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureAddMacrosInitialized();
									AbstractMutableMessageLite.addAll(other.addMacros_, this.addMacros_);
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							}
						}
					} else {
						ensureNegativePredicatesInitialized();
						AbstractMutableMessageLite.addAll(other.negativePredicates_, this.negativePredicates_);
						if (other.addTags_ == null || other.addTags_.isEmpty()) {
							if (other.removeTags_ == null || other.removeTags_.isEmpty()) {
								if (other.addMacros_ == null || other.addMacros_.isEmpty()) {
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureAddMacrosInitialized();
									AbstractMutableMessageLite.addAll(other.addMacros_, this.addMacros_);
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							} else {
								ensureRemoveTagsInitialized();
								AbstractMutableMessageLite.addAll(other.removeTags_, this.removeTags_);
								if (other.addMacros_ == null || other.addMacros_.isEmpty()) {
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureAddMacrosInitialized();
									AbstractMutableMessageLite.addAll(other.addMacros_, this.addMacros_);
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							}
						} else {
							ensureAddTagsInitialized();
							AbstractMutableMessageLite.addAll(other.addTags_, this.addTags_);
							if (other.removeTags_ == null || other.removeTags_.isEmpty()) {
								if (other.addMacros_ == null || other.addMacros_.isEmpty()) {
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureAddMacrosInitialized();
									AbstractMutableMessageLite.addAll(other.addMacros_, this.addMacros_);
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							} else {
								ensureRemoveTagsInitialized();
								AbstractMutableMessageLite.addAll(other.removeTags_, this.removeTags_);
								if (other.addMacros_ == null || other.addMacros_.isEmpty()) {
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureAddMacrosInitialized();
									AbstractMutableMessageLite.addAll(other.addMacros_, this.addMacros_);
									if (other.removeMacros_ == null || other.removeMacros_.isEmpty()) {
										if (!other.hasResult()) {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
										}
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureRemoveMacrosInitialized();
										AbstractMutableMessageLite.addAll(other.removeMacros_, this.removeMacros_);
										if (!other.hasResult()) {
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											ensureResultInitialized();
											this.result_.mergeFrom(other.getResult());
											this.bitField0_ |= 1;
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							}
						}
					}
				}
			}
		}

		public boolean mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) {
			CodedOutputStream unknownFieldsCodedOutput;
			boolean done;
			boolean r5z;
			assertMutable();
			try {
				OutputStream unknownFieldsOutput = ByteString.newOutput();
				unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
				done = false;
				while (!done) {
					int tag = input.readTag();
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case Value.ESCAPING_FIELD_NUMBER:
						input.readMessage(addPositivePredicates(), extensionRegistry);
						break;
					case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						input.readMessage(addNegativePredicates(), extensionRegistry);
						break;
					case 26:
						input.readMessage(addAddTags(), extensionRegistry);
						break;
					case 34:
						input.readMessage(addRemoveTags(), extensionRegistry);
						break;
					case 42:
						input.readMessage(addAddMacros(), extensionRegistry);
						break;
					case 50:
						input.readMessage(addRemoveMacros(), extensionRegistry);
						break;
					case 58:
						if (this.result_ == Value.getDefaultInstance()) {
							this.result_ = Value.newMessage();
						}
						this.bitField0_ |= 1;
						input.readMessage(this.result_, extensionRegistry);
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				}
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
				r5z = true;
			} catch (IOException e) {
				r5z = false;
			}
			return r5z;
		}

		public MutableDebug.ResolvedRule newMessageForType() {
			return new MutableDebug.ResolvedRule();
		}

		public MutableDebug.ResolvedRule setAddMacros(int index, MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureAddMacrosInitialized();
				this.addMacros_.set(index, value);
				return this;
			}
		}

		public MutableDebug.ResolvedRule setAddTags(int index, MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureAddTagsInitialized();
				this.addTags_.set(index, value);
				return this;
			}
		}

		public MutableDebug.ResolvedRule setNegativePredicates(int index, MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureNegativePredicatesInitialized();
				this.negativePredicates_.set(index, value);
				return this;
			}
		}

		public MutableDebug.ResolvedRule setPositivePredicates(int index, MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensurePositivePredicatesInitialized();
				this.positivePredicates_.set(index, value);
				return this;
			}
		}

		public MutableDebug.ResolvedRule setRemoveMacros(int index, MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureRemoveMacrosInitialized();
				this.removeMacros_.set(index, value);
				return this;
			}
		}

		public MutableDebug.ResolvedRule setRemoveTags(int index, MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureRemoveTagsInitialized();
				this.removeTags_.set(index, value);
				return this;
			}
		}

		public MutableDebug.ResolvedRule setResult(Value value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 1;
				this.result_ = value;
				return this;
			}
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeToWithCachedSizes(CodedOutputStream output) throws IOException {
			int i;
			int bytesWrittenBefore = output.getTotalBytesWritten();
			if (this.positivePredicates_ != null) {
				i = 0;
				while (i < this.positivePredicates_.size()) {
					output.writeMessageWithCachedSizes(POSITIVE_PREDICATES_FIELD_NUMBER, (MutableMessageLite) this.positivePredicates_.get(i));
					i++;
				}
			}
			if (this.negativePredicates_ != null) {
				i = 0;
				while (i < this.negativePredicates_.size()) {
					output.writeMessageWithCachedSizes(NEGATIVE_PREDICATES_FIELD_NUMBER, (MutableMessageLite) this.negativePredicates_.get(i));
					i++;
				}
			}
			if (this.addTags_ != null) {
				i = 0;
				while (i < this.addTags_.size()) {
					output.writeMessageWithCachedSizes(ADD_TAGS_FIELD_NUMBER, (MutableMessageLite) this.addTags_.get(i));
					i++;
				}
			}
			if (this.removeTags_ != null) {
				i = 0;
				while (i < this.removeTags_.size()) {
					output.writeMessageWithCachedSizes(REMOVE_TAGS_FIELD_NUMBER, (MutableMessageLite) this.removeTags_.get(i));
					i++;
				}
			}
			if (this.addMacros_ != null) {
				i = 0;
				while (i < this.addMacros_.size()) {
					output.writeMessageWithCachedSizes(ADD_MACROS_FIELD_NUMBER, (MutableMessageLite) this.addMacros_.get(i));
					i++;
				}
			}
			if (this.removeMacros_ != null) {
				i = 0;
				while (i < this.removeMacros_.size()) {
					output.writeMessageWithCachedSizes(REMOVE_MACROS_FIELD_NUMBER, (MutableMessageLite) this.removeMacros_.get(i));
					i++;
				}
			}
			if ((this.bitField0_ & 1) == 1) {
				output.writeMessageWithCachedSizes(RESULT_FIELD_NUMBER, this.result_);
			}
			output.writeRawBytes(this.unknownFields);
			if (getCachedSize() != output.getTotalBytesWritten() - bytesWrittenBefore) {
				throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
			}
		}
	}

	public static final class RuleEvaluationStepInfo extends GeneratedMutableMessageLite<MutableDebug.RuleEvaluationStepInfo> implements MutableMessageLite {
		public static final int ENABLED_FUNCTIONS_FIELD_NUMBER = 2;
		public static Parser<MutableDebug.RuleEvaluationStepInfo> PARSER = null;
		public static final int RULES_FIELD_NUMBER = 1;
		private static final MutableDebug.RuleEvaluationStepInfo defaultInstance;
		private static volatile MessageLite immutableDefault;
		private static final long serialVersionUID = 0;
		private List<MutableDebug.ResolvedFunctionCall> enabledFunctions_;
		private List<MutableDebug.ResolvedRule> rules_;

		static {
			immutableDefault = null;
			defaultInstance = new MutableDebug.RuleEvaluationStepInfo(true);
			defaultInstance.initFields();
			defaultInstance.makeImmutable();
			PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
		}

		private RuleEvaluationStepInfo() {
			this.rules_ = null;
			this.enabledFunctions_ = null;
			initFields();
		}

		private RuleEvaluationStepInfo(boolean noInit) {
			this.rules_ = null;
			this.enabledFunctions_ = null;
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

		public static MutableDebug.RuleEvaluationStepInfo getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
		}

		public static MutableDebug.RuleEvaluationStepInfo newMessage() {
			return new MutableDebug.RuleEvaluationStepInfo();
		}

		public MutableDebug.RuleEvaluationStepInfo addAllEnabledFunctions(Iterable<MutableDebug.ResolvedFunctionCall> values) {
			assertMutable();
			ensureEnabledFunctionsInitialized();
			AbstractMutableMessageLite.addAll(values, this.enabledFunctions_);
			return this;
		}

		public MutableDebug.RuleEvaluationStepInfo addAllRules(Iterable<MutableDebug.ResolvedRule> values) {
			assertMutable();
			ensureRulesInitialized();
			AbstractMutableMessageLite.addAll(values, this.rules_);
			return this;
		}

		public MutableDebug.ResolvedFunctionCall addEnabledFunctions() {
			assertMutable();
			ensureEnabledFunctionsInitialized();
			MutableDebug.ResolvedFunctionCall value = MutableDebug.ResolvedFunctionCall.newMessage();
			this.enabledFunctions_.add(value);
			return value;
		}

		public MutableDebug.RuleEvaluationStepInfo addEnabledFunctions(MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureEnabledFunctionsInitialized();
				this.enabledFunctions_.add(value);
				return this;
			}
		}

		public MutableDebug.ResolvedRule addRules() {
			assertMutable();
			ensureRulesInitialized();
			MutableDebug.ResolvedRule value = MutableDebug.ResolvedRule.newMessage();
			this.rules_.add(value);
			return value;
		}

		public MutableDebug.RuleEvaluationStepInfo addRules(MutableDebug.ResolvedRule value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureRulesInitialized();
				this.rules_.add(value);
				return this;
			}
		}

		public MutableDebug.RuleEvaluationStepInfo clear() {
			assertMutable();
			super.clear();
			this.rules_ = null;
			this.enabledFunctions_ = null;
			return this;
		}

		public MutableDebug.RuleEvaluationStepInfo clearEnabledFunctions() {
			assertMutable();
			this.enabledFunctions_ = null;
			return this;
		}

		public MutableDebug.RuleEvaluationStepInfo clearRules() {
			assertMutable();
			this.rules_ = null;
			return this;
		}

		public MutableDebug.RuleEvaluationStepInfo clone() {
			return newMessageForType().mergeFrom(this);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof MutableDebug.RuleEvaluationStepInfo))) {
				return super.equals(obj);
			} else {
				boolean result;
				MutableDebug.RuleEvaluationStepInfo other = (MutableDebug.RuleEvaluationStepInfo) obj;
				result = (!true || !getRulesList().equals(other.getRulesList())) ? false : true;
				result = (!result || !getEnabledFunctionsList().equals(other.getEnabledFunctionsList())) ? false : true;
				return result;
			}
		}

		public final MutableDebug.RuleEvaluationStepInfo getDefaultInstanceForType() {
			return defaultInstance;
		}

		public MutableDebug.ResolvedFunctionCall getEnabledFunctions(int index) {
			return (MutableDebug.ResolvedFunctionCall) this.enabledFunctions_.get(index);
		}

		public int getEnabledFunctionsCount() {
			return (this.enabledFunctions_ == null) ? 0 : this.enabledFunctions_.size();
		}

		public List<MutableDebug.ResolvedFunctionCall> getEnabledFunctionsList() {
			return (this.enabledFunctions_ == null) ? Collections.emptyList() : Collections.unmodifiableList(this.enabledFunctions_);
		}

		public MutableDebug.ResolvedFunctionCall getMutableEnabledFunctions(int index) {
			return (MutableDebug.ResolvedFunctionCall) this.enabledFunctions_.get(index);
		}

		public List<MutableDebug.ResolvedFunctionCall> getMutableEnabledFunctionsList() {
			assertMutable();
			ensureEnabledFunctionsInitialized();
			return this.enabledFunctions_;
		}

		public MutableDebug.ResolvedRule getMutableRules(int index) {
			return (MutableDebug.ResolvedRule) this.rules_.get(index);
		}

		public List<MutableDebug.ResolvedRule> getMutableRulesList() {
			assertMutable();
			ensureRulesInitialized();
			return this.rules_;
		}

		public Parser<MutableDebug.RuleEvaluationStepInfo> getParserForType() {
			return PARSER;
		}

		public MutableDebug.ResolvedRule getRules(int index) {
			return (MutableDebug.ResolvedRule) this.rules_.get(index);
		}

		public int getRulesCount() {
			return (this.rules_ == null) ? 0 : this.rules_.size();
		}

		public List<MutableDebug.ResolvedRule> getRulesList() {
			return (this.rules_ == null) ? Collections.emptyList() : Collections.unmodifiableList(this.rules_);
		}

		public int getSerializedSize() {
			int i;
			int size = 0;
			if (this.rules_ != null) {
				i = 0;
				while (i < this.rules_.size()) {
					size += CodedOutputStream.computeMessageSize(RULES_FIELD_NUMBER, (MessageLite) this.rules_.get(i));
					i++;
				}
			}
			if (this.enabledFunctions_ != null) {
				i = 0;
				while (i < this.enabledFunctions_.size()) {
					i++;
				}
			}
			size += this.unknownFields.size();
			this.cachedSize = size;
			return size;
		}

		public int hashCode() {
			int hash = 41;
			if (getRulesCount() > 0) {
				hash = 1517 + 1;
				hash = 80454 + getRulesList().hashCode();
			}
			if (getEnabledFunctionsCount() > 0) {
				hash = (((hash * 37) + 2) * 53) + getEnabledFunctionsList().hashCode();
			}
			return (hash * 29) + this.unknownFields.hashCode();
		}

		protected MessageLite internalImmutableDefault() {
			if (immutableDefault == null) {
				immutableDefault = internalImmutableDefault("com.google.analytics.containertag.proto.Debug$RuleEvaluationStepInfo");
			}
			return immutableDefault;
		}

		public final boolean isInitialized() {
			int i = 0;
			while (i < getRulesCount()) {
				if (!getRules(i).isInitialized()) {
					return false;
				} else {
					i++;
				}
			}
			i = 0;
			while (i < getEnabledFunctionsCount()) {
				if (getEnabledFunctions(i).isInitialized()) {
					i++;
				}
				return false;
			}
			return true;
		}

		public MutableDebug.RuleEvaluationStepInfo mergeFrom(MutableDebug.RuleEvaluationStepInfo other) {
			if (this == other) {
				throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
			} else {
				assertMutable();
				if (other == getDefaultInstance()) {
					return this;
				} else if (other.rules_ == null || other.rules_.isEmpty()) {
					if (other.enabledFunctions_ == null || other.enabledFunctions_.isEmpty()) {
						this.unknownFields = this.unknownFields.concat(other.unknownFields);
						return this;
					} else {
						ensureEnabledFunctionsInitialized();
						AbstractMutableMessageLite.addAll(other.enabledFunctions_, this.enabledFunctions_);
						this.unknownFields = this.unknownFields.concat(other.unknownFields);
						return this;
					}
				} else {
					ensureRulesInitialized();
					AbstractMutableMessageLite.addAll(other.rules_, this.rules_);
					if (other.enabledFunctions_ == null || other.enabledFunctions_.isEmpty()) {
						this.unknownFields = this.unknownFields.concat(other.unknownFields);
						return this;
					} else {
						ensureEnabledFunctionsInitialized();
						AbstractMutableMessageLite.addAll(other.enabledFunctions_, this.enabledFunctions_);
						this.unknownFields = this.unknownFields.concat(other.unknownFields);
						return this;
					}
				}
			}
		}

		public boolean mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) {
			CodedOutputStream unknownFieldsCodedOutput;
			boolean done;
			boolean r5z;
			assertMutable();
			try {
				OutputStream unknownFieldsOutput = ByteString.newOutput();
				unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
				done = false;
				while (!done) {
					int tag = input.readTag();
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case Value.ESCAPING_FIELD_NUMBER:
						input.readMessage(addRules(), extensionRegistry);
						break;
					case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						input.readMessage(addEnabledFunctions(), extensionRegistry);
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				}
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
				r5z = true;
			} catch (IOException e) {
				r5z = false;
			}
			return r5z;
		}

		public MutableDebug.RuleEvaluationStepInfo newMessageForType() {
			return new MutableDebug.RuleEvaluationStepInfo();
		}

		public MutableDebug.RuleEvaluationStepInfo setEnabledFunctions(int index, MutableDebug.ResolvedFunctionCall value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureEnabledFunctionsInitialized();
				this.enabledFunctions_.set(index, value);
				return this;
			}
		}

		public MutableDebug.RuleEvaluationStepInfo setRules(int index, MutableDebug.ResolvedRule value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureRulesInitialized();
				this.rules_.set(index, value);
				return this;
			}
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeToWithCachedSizes(CodedOutputStream output) throws IOException {
			int i;
			int bytesWrittenBefore = output.getTotalBytesWritten();
			if (this.rules_ != null) {
				i = 0;
				while (i < this.rules_.size()) {
					output.writeMessageWithCachedSizes(RULES_FIELD_NUMBER, (MutableMessageLite) this.rules_.get(i));
					i++;
				}
			}
			if (this.enabledFunctions_ != null) {
				i = 0;
				while (i < this.enabledFunctions_.size()) {
					output.writeMessageWithCachedSizes(ENABLED_FUNCTIONS_FIELD_NUMBER, (MutableMessageLite) this.enabledFunctions_.get(i));
					i++;
				}
			}
			output.writeRawBytes(this.unknownFields);
			if (getCachedSize() != output.getTotalBytesWritten() - bytesWrittenBefore) {
				throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
			}
		}
	}


	static {
	}

	private MutableDebug() {
	}

	public static void registerAllExtensions(ExtensionRegistryLite registry) {
		registry.add(MacroEvaluationInfo.macro);
	}
}
