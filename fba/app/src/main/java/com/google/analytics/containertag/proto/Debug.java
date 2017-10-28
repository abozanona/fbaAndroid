package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Debug.EventInfo.EventType;
import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite.GeneratedExtension;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;
import com.google.tagmanager.protobuf.InvalidProtocolBufferException;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MessageLiteOrBuilder;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import com.google.tagmanager.protobuf.Utf8;
import com.google.tagmanager.protobuf.WireFormat.FieldType;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Debug {
	public static interface DataLayerEventEvaluationInfoOrBuilder extends MessageLiteOrBuilder {
		public Debug.ResolvedFunctionCall getResults(int r1i);

		public int getResultsCount();

		public List<Debug.ResolvedFunctionCall> getResultsList();

		public Debug.RuleEvaluationStepInfo getRulesEvaluation();

		public boolean hasRulesEvaluation();
	}

	public static final class DataLayerEventEvaluationInfo extends GeneratedMessageLite implements Debug.DataLayerEventEvaluationInfoOrBuilder {
		public static Parser<Debug.DataLayerEventEvaluationInfo> PARSER = null;
		public static final int RESULTS_FIELD_NUMBER = 2;
		public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
		private static final Debug.DataLayerEventEvaluationInfo defaultInstance;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private List<Debug.ResolvedFunctionCall> results_;
		private Debug.RuleEvaluationStepInfo rulesEvaluation_;
		private final ByteString unknownFields;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Debug.DataLayerEventEvaluationInfo, Debug.DataLayerEventEvaluationInfo.Builder> implements Debug.DataLayerEventEvaluationInfoOrBuilder {
			private int bitField0_;
			private List<Debug.ResolvedFunctionCall> results_;
			private Debug.RuleEvaluationStepInfo rulesEvaluation_;

			private Builder() {
				this.rulesEvaluation_ = Debug.RuleEvaluationStepInfo.getDefaultInstance();
				this.results_ = Collections.emptyList();
				maybeForceBuilderInitialization();
			}

			private static Debug.DataLayerEventEvaluationInfo.Builder create() {
				return new Debug.DataLayerEventEvaluationInfo.Builder();
			}

			private void ensureResultsIsMutable() {
				if ((this.bitField0_ & 2) != 2) {
					this.results_ = new ArrayList(this.results_);
					this.bitField0_ |= 2;
				}
			}

			private void maybeForceBuilderInitialization() {
			}

			public Debug.DataLayerEventEvaluationInfo.Builder addAllResults(Iterable<Debug.ResolvedFunctionCall> values) {
				ensureResultsIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.results_);
				return this;
			}

			public Debug.DataLayerEventEvaluationInfo.Builder addResults(int index, Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureResultsIsMutable();
				this.results_.add(index, builderForValue.build());
				return this;
			}

			public Debug.DataLayerEventEvaluationInfo.Builder addResults(int index, Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureResultsIsMutable();
					this.results_.add(index, value);
					return this;
				}
			}

			public Debug.DataLayerEventEvaluationInfo.Builder addResults(Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureResultsIsMutable();
				this.results_.add(builderForValue.build());
				return this;
			}

			public Debug.DataLayerEventEvaluationInfo.Builder addResults(Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureResultsIsMutable();
					this.results_.add(value);
					return this;
				}
			}

			public Debug.DataLayerEventEvaluationInfo build() {
				Debug.DataLayerEventEvaluationInfo result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Debug.DataLayerEventEvaluationInfo buildPartial() {
				Debug.DataLayerEventEvaluationInfo result = new Debug.DataLayerEventEvaluationInfo((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
				int to_bitField0_ = 0;
				if ((this.bitField0_ & 1) == 1) {
					to_bitField0_ |= 1;
				}
				result.rulesEvaluation_ = this.rulesEvaluation_;
				if ((this.bitField0_ & 2) == 2) {
					this.results_ = Collections.unmodifiableList(this.results_);
					this.bitField0_ &= -3;
				}
				result.results_ = this.results_;
				result.bitField0_ = to_bitField0_;
				return result;
			}

			public Debug.DataLayerEventEvaluationInfo.Builder clear() {
				super.clear();
				this.rulesEvaluation_ = Debug.RuleEvaluationStepInfo.getDefaultInstance();
				this.bitField0_ &= -2;
				this.results_ = Collections.emptyList();
				this.bitField0_ &= -3;
				return this;
			}

			public Debug.DataLayerEventEvaluationInfo.Builder clearResults() {
				this.results_ = Collections.emptyList();
				this.bitField0_ &= -3;
				return this;
			}

			public Debug.DataLayerEventEvaluationInfo.Builder clearRulesEvaluation() {
				this.rulesEvaluation_ = Debug.RuleEvaluationStepInfo.getDefaultInstance();
				this.bitField0_ &= -2;
				return this;
			}

			public Debug.DataLayerEventEvaluationInfo.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public Debug.DataLayerEventEvaluationInfo getDefaultInstanceForType() {
				return Debug.DataLayerEventEvaluationInfo.getDefaultInstance();
			}

			public Debug.ResolvedFunctionCall getResults(int index) {
				return (Debug.ResolvedFunctionCall) this.results_.get(index);
			}

			public int getResultsCount() {
				return this.results_.size();
			}

			public List<Debug.ResolvedFunctionCall> getResultsList() {
				return Collections.unmodifiableList(this.results_);
			}

			public Debug.RuleEvaluationStepInfo getRulesEvaluation() {
				return this.rulesEvaluation_;
			}

			public boolean hasRulesEvaluation() {
				return (this.bitField0_ & 1) == 1;
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

			public Debug.DataLayerEventEvaluationInfo.Builder mergeFrom(Debug.DataLayerEventEvaluationInfo other) {
				if (other == Debug.DataLayerEventEvaluationInfo.getDefaultInstance()) {
					return this;
				} else {
					if (other.hasRulesEvaluation()) {
						mergeRulesEvaluation(other.getRulesEvaluation());
					}
					if (!other.results_.isEmpty()) {
						if (this.results_.isEmpty()) {
							this.results_ = other.results_;
							this.bitField0_ &= -3;
						} else {
							ensureResultsIsMutable();
							this.results_.addAll(other.results_);
						}
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Debug.DataLayerEventEvaluationInfo.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Debug.DataLayerEventEvaluationInfo parsedMessage;
				try {
					parsedMessage = (Debug.DataLayerEventEvaluationInfo) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Debug.DataLayerEventEvaluationInfo) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Debug.DataLayerEventEvaluationInfo.Builder mergeRulesEvaluation(Debug.RuleEvaluationStepInfo value) {
				if ((this.bitField0_ & 1) != 1 || this.rulesEvaluation_ == Debug.RuleEvaluationStepInfo.getDefaultInstance()) {
					this.rulesEvaluation_ = value;
				} else {
					this.rulesEvaluation_ = Debug.RuleEvaluationStepInfo.newBuilder(this.rulesEvaluation_).mergeFrom(value).buildPartial();
				}
				this.bitField0_ |= 1;
				return this;
			}

			public Debug.DataLayerEventEvaluationInfo.Builder removeResults(int index) {
				ensureResultsIsMutable();
				this.results_.remove(index);
				return this;
			}

			public Debug.DataLayerEventEvaluationInfo.Builder setResults(int index, Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureResultsIsMutable();
				this.results_.set(index, builderForValue.build());
				return this;
			}

			public Debug.DataLayerEventEvaluationInfo.Builder setResults(int index, Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureResultsIsMutable();
					this.results_.set(index, value);
					return this;
				}
			}

			public Debug.DataLayerEventEvaluationInfo.Builder setRulesEvaluation(Debug.RuleEvaluationStepInfo.Builder builderForValue) {
				this.rulesEvaluation_ = builderForValue.build();
				this.bitField0_ |= 1;
				return this;
			}

			public Debug.DataLayerEventEvaluationInfo.Builder setRulesEvaluation(Debug.RuleEvaluationStepInfo value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.rulesEvaluation_ = value;
					this.bitField0_ |= 1;
					return this;
				}
			}
		}


		static {
			PARSER = new AbstractParser<Debug.DataLayerEventEvaluationInfo>() {
			public Debug.DataLayerEventEvaluationInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Debug.DataLayerEventEvaluationInfo(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Debug.DataLayerEventEvaluationInfo(true);
			defaultInstance.initFields();
		}

		private DataLayerEventEvaluationInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			OutputStream unknownFieldsOutput;
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			initFields();
			int mutable_bitField0_ = 0;
			unknownFieldsOutput = ByteString.newOutput();
			CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
			boolean done = false;
			while (!done) {
				int tag;
				try {
					tag = input.readTag();
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case Value.ESCAPING_FIELD_NUMBER:
						Debug.RuleEvaluationStepInfo.Builder subBuilder = null;
						if ((this.bitField0_ & 1) == 1) {
							subBuilder = this.rulesEvaluation_.toBuilder();
						}
						this.rulesEvaluation_ = (Debug.RuleEvaluationStepInfo) input.readMessage(Debug.RuleEvaluationStepInfo.PARSER, extensionRegistry);
						if (subBuilder != null) {
							subBuilder.mergeFrom(this.rulesEvaluation_);
							this.rulesEvaluation_ = subBuilder.buildPartial();
						}
						this.bitField0_ |= 1;
						break;
					case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						if ((mutable_bitField0_ & 2) != 2) {
							this.results_ = new ArrayList();
							mutable_bitField0_ |= 2;
						}
						this.results_.add(input.readMessage(Debug.ResolvedFunctionCall.PARSER, extensionRegistry));
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				} catch (InvalidProtocolBufferException e) {
					throw e.setUnfinishedMessage(this);
				} catch (IOException e_2) {
					throw new InvalidProtocolBufferException(e_2.getMessage()).setUnfinishedMessage(this);
				} catch (Throwable th) {
					if ((mutable_bitField0_ & 2) == 2) {
						this.results_ = Collections.unmodifiableList(this.results_);
					}
					unknownFieldsCodedOutput.flush();
					this.unknownFields = unknownFieldsOutput.toByteString();
				}
			}
			if ((mutable_bitField0_ & 2) == 2) {
				this.results_ = Collections.unmodifiableList(this.results_);
			}
			try {
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
			} catch (IOException e_3) {
				this.unknownFields = unknownFieldsOutput.toByteString();
			}
			makeExtensionsImmutable();
		}

		private DataLayerEventEvaluationInfo(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private DataLayerEventEvaluationInfo(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Debug.DataLayerEventEvaluationInfo getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.rulesEvaluation_ = Debug.RuleEvaluationStepInfo.getDefaultInstance();
			this.results_ = Collections.emptyList();
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Debug.DataLayerEventEvaluationInfo prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Debug.DataLayerEventEvaluationInfo parseDelimitedFrom(InputStream input) throws IOException {
			return (Debug.DataLayerEventEvaluationInfo) PARSER.parseDelimitedFrom(input);
		}

		public static Debug.DataLayerEventEvaluationInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.DataLayerEventEvaluationInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Debug.DataLayerEventEvaluationInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Debug.DataLayerEventEvaluationInfo) PARSER.parseFrom(data);
		}

		public static Debug.DataLayerEventEvaluationInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Debug.DataLayerEventEvaluationInfo) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Debug.DataLayerEventEvaluationInfo parseFrom(CodedInputStream input) throws IOException {
			return (Debug.DataLayerEventEvaluationInfo) PARSER.parseFrom(input);
		}

		public static Debug.DataLayerEventEvaluationInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.DataLayerEventEvaluationInfo) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Debug.DataLayerEventEvaluationInfo parseFrom(InputStream input) throws IOException {
			return (Debug.DataLayerEventEvaluationInfo) PARSER.parseFrom(input);
		}

		public static Debug.DataLayerEventEvaluationInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.DataLayerEventEvaluationInfo) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Debug.DataLayerEventEvaluationInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Debug.DataLayerEventEvaluationInfo) PARSER.parseFrom(data);
		}

		public static Debug.DataLayerEventEvaluationInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Debug.DataLayerEventEvaluationInfo) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Debug.DataLayerEventEvaluationInfo))) {
				return super.equals(obj);
			} else {
				boolean result;
				Debug.DataLayerEventEvaluationInfo other = (Debug.DataLayerEventEvaluationInfo) obj;
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

		public Debug.DataLayerEventEvaluationInfo getDefaultInstanceForType() {
			return defaultInstance;
		}

		public Parser<Debug.DataLayerEventEvaluationInfo> getParserForType() {
			return PARSER;
		}

		public Debug.ResolvedFunctionCall getResults(int index) {
			return (Debug.ResolvedFunctionCall) this.results_.get(index);
		}

		public int getResultsCount() {
			return this.results_.size();
		}

		public List<Debug.ResolvedFunctionCall> getResultsList() {
			return this.results_;
		}

		public Debug.ResolvedFunctionCallOrBuilder getResultsOrBuilder(int index) {
			return (Debug.ResolvedFunctionCallOrBuilder) this.results_.get(index);
		}

		public List<Debug.ResolvedFunctionCallOrBuilder> getResultsOrBuilderList() {
			return this.results_;
		}

		public Debug.RuleEvaluationStepInfo getRulesEvaluation() {
			return this.rulesEvaluation_;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				if ((this.bitField0_ & 1) == 1) {
					size += CodedOutputStream.computeMessageSize(RULES_EVALUATION_FIELD_NUMBER, this.rulesEvaluation_);
				}
				int i = 0;
				while (i < this.results_.size()) {
					size += CodedOutputStream.computeMessageSize(RESULTS_FIELD_NUMBER, (MessageLite) this.results_.get(i));
					i++;
				}
				size += this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
		}

		public boolean hasRulesEvaluation() {
			return (this.bitField0_ & 1) == 1;
		}

		public int hashCode() {
			if (this.memoizedHashCode != 0) {
				return this.memoizedHashCode;
			} else {
				int hash = Debug.DataLayerEventEvaluationInfo.class.hashCode() + 779;
				if (hasRulesEvaluation()) {
					hash = (((hash * 37) + 1) * 53) + getRulesEvaluation().hashCode();
				}
				if (getResultsCount() > 0) {
					hash = (((hash * 37) + 2) * 53) + getResultsList().hashCode();
				}
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$DataLayerEventEvaluationInfo");
			}
			return mutableDefault;
		}

		public final boolean isInitialized() {
			byte isInitialized = this.memoizedIsInitialized;
			if (isInitialized != (byte) -1) {
				return isInitialized == (byte) 1;
			} else if (!hasRulesEvaluation() || getRulesEvaluation().isInitialized()) {
				int i = 0;
				while (i < getResultsCount()) {
					if (!getResults(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				this.memoizedIsInitialized = (byte) 1;
				return true;
			} else {
				this.memoizedIsInitialized = (byte) 0;
				return false;
			}
		}

		public Builder newBuilderForType() {
			return newBuilder();
		}

		public Builder toBuilder() {
			return newBuilder(this);
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeTo(CodedOutputStream output) throws IOException {
			getSerializedSize();
			if ((this.bitField0_ & 1) == 1) {
				output.writeMessage(RULES_EVALUATION_FIELD_NUMBER, this.rulesEvaluation_);
			}
			int i = 0;
			while (i < this.results_.size()) {
				output.writeMessage(RESULTS_FIELD_NUMBER, (MessageLite) this.results_.get(i));
				i++;
			}
			output.writeRawBytes(this.unknownFields);
		}
	}

	public static interface DebugEventsOrBuilder extends MessageLiteOrBuilder {
		public Debug.EventInfo getEvent(int r1i);

		public int getEventCount();

		public List<Debug.EventInfo> getEventList();
	}

	public static final class DebugEvents extends GeneratedMessageLite implements Debug.DebugEventsOrBuilder {
		public static final int EVENT_FIELD_NUMBER = 1;
		public static Parser<Debug.DebugEvents> PARSER;
		private static final Debug.DebugEvents defaultInstance;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private List<Debug.EventInfo> event_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private final ByteString unknownFields;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Debug.DebugEvents, Debug.DebugEvents.Builder> implements Debug.DebugEventsOrBuilder {
			private int bitField0_;
			private List<Debug.EventInfo> event_;

			private Builder() {
				this.event_ = Collections.emptyList();
				maybeForceBuilderInitialization();
			}

			private static Debug.DebugEvents.Builder create() {
				return new Debug.DebugEvents.Builder();
			}

			private void ensureEventIsMutable() {
				if ((this.bitField0_ & 1) != 1) {
					this.event_ = new ArrayList(this.event_);
					this.bitField0_ |= 1;
				}
			}

			private void maybeForceBuilderInitialization() {
			}

			public Debug.DebugEvents.Builder addAllEvent(Iterable<Debug.EventInfo> values) {
				ensureEventIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.event_);
				return this;
			}

			public Debug.DebugEvents.Builder addEvent(int index, Debug.EventInfo.Builder builderForValue) {
				ensureEventIsMutable();
				this.event_.add(index, builderForValue.build());
				return this;
			}

			public Debug.DebugEvents.Builder addEvent(int index, Debug.EventInfo value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureEventIsMutable();
					this.event_.add(index, value);
					return this;
				}
			}

			public Debug.DebugEvents.Builder addEvent(Debug.EventInfo.Builder builderForValue) {
				ensureEventIsMutable();
				this.event_.add(builderForValue.build());
				return this;
			}

			public Debug.DebugEvents.Builder addEvent(Debug.EventInfo value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureEventIsMutable();
					this.event_.add(value);
					return this;
				}
			}

			public Debug.DebugEvents build() {
				Debug.DebugEvents result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Debug.DebugEvents buildPartial() {
				Debug.DebugEvents result = new Debug.DebugEvents((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
				int from_bitField0_ = this.bitField0_;
				if ((this.bitField0_ & 1) == 1) {
					this.event_ = Collections.unmodifiableList(this.event_);
					this.bitField0_ &= -2;
				}
				result.event_ = this.event_;
				return result;
			}

			public Debug.DebugEvents.Builder clear() {
				super.clear();
				this.event_ = Collections.emptyList();
				this.bitField0_ &= -2;
				return this;
			}

			public Debug.DebugEvents.Builder clearEvent() {
				this.event_ = Collections.emptyList();
				this.bitField0_ &= -2;
				return this;
			}

			public Debug.DebugEvents.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public Debug.DebugEvents getDefaultInstanceForType() {
				return Debug.DebugEvents.getDefaultInstance();
			}

			public Debug.EventInfo getEvent(int index) {
				return (Debug.EventInfo) this.event_.get(index);
			}

			public int getEventCount() {
				return this.event_.size();
			}

			public List<Debug.EventInfo> getEventList() {
				return Collections.unmodifiableList(this.event_);
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

			public Debug.DebugEvents.Builder mergeFrom(Debug.DebugEvents other) {
				if (other == Debug.DebugEvents.getDefaultInstance()) {
					return this;
				} else {
					if (!other.event_.isEmpty()) {
						if (this.event_.isEmpty()) {
							this.event_ = other.event_;
							this.bitField0_ &= -2;
						} else {
							ensureEventIsMutable();
							this.event_.addAll(other.event_);
						}
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Debug.DebugEvents.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Debug.DebugEvents parsedMessage;
				try {
					parsedMessage = (Debug.DebugEvents) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Debug.DebugEvents) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Debug.DebugEvents.Builder removeEvent(int index) {
				ensureEventIsMutable();
				this.event_.remove(index);
				return this;
			}

			public Debug.DebugEvents.Builder setEvent(int index, Debug.EventInfo.Builder builderForValue) {
				ensureEventIsMutable();
				this.event_.set(index, builderForValue.build());
				return this;
			}

			public Debug.DebugEvents.Builder setEvent(int index, Debug.EventInfo value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureEventIsMutable();
					this.event_.set(index, value);
					return this;
				}
			}
		}


		static {
			PARSER = new AbstractParser<Debug.DebugEvents>() {
			public Debug.DebugEvents parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Debug.DebugEvents(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Debug.DebugEvents(true);
			defaultInstance.initFields();
		}

		private DebugEvents(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			OutputStream unknownFieldsOutput;
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			initFields();
			int mutable_bitField0_ = 0;
			unknownFieldsOutput = ByteString.newOutput();
			CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
			boolean done = false;
			while (!done) {
				int tag;
				try {
					tag = input.readTag();
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case Value.ESCAPING_FIELD_NUMBER:
						if ((mutable_bitField0_ & 1) != 1) {
							this.event_ = new ArrayList();
							mutable_bitField0_ |= 1;
						}
						this.event_.add(input.readMessage(Debug.EventInfo.PARSER, extensionRegistry));
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				} catch (InvalidProtocolBufferException e) {
					throw e.setUnfinishedMessage(this);
				} catch (IOException e_2) {
					throw new InvalidProtocolBufferException(e_2.getMessage()).setUnfinishedMessage(this);
				} catch (Throwable th) {
					if ((mutable_bitField0_ & 1) == 1) {
						this.event_ = Collections.unmodifiableList(this.event_);
					}
					unknownFieldsCodedOutput.flush();
					this.unknownFields = unknownFieldsOutput.toByteString();
				}
			}
			if ((mutable_bitField0_ & 1) == 1) {
				this.event_ = Collections.unmodifiableList(this.event_);
			}
			try {
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
			} catch (IOException e_3) {
				this.unknownFields = unknownFieldsOutput.toByteString();
			}
			makeExtensionsImmutable();
		}

		private DebugEvents(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private DebugEvents(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Debug.DebugEvents getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.event_ = Collections.emptyList();
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Debug.DebugEvents prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Debug.DebugEvents parseDelimitedFrom(InputStream input) throws IOException {
			return (Debug.DebugEvents) PARSER.parseDelimitedFrom(input);
		}

		public static Debug.DebugEvents parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.DebugEvents) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Debug.DebugEvents parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Debug.DebugEvents) PARSER.parseFrom(data);
		}

		public static Debug.DebugEvents parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Debug.DebugEvents) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Debug.DebugEvents parseFrom(CodedInputStream input) throws IOException {
			return (Debug.DebugEvents) PARSER.parseFrom(input);
		}

		public static Debug.DebugEvents parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.DebugEvents) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Debug.DebugEvents parseFrom(InputStream input) throws IOException {
			return (Debug.DebugEvents) PARSER.parseFrom(input);
		}

		public static Debug.DebugEvents parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.DebugEvents) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Debug.DebugEvents parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Debug.DebugEvents) PARSER.parseFrom(data);
		}

		public static Debug.DebugEvents parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Debug.DebugEvents) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Debug.DebugEvents))) {
				return super.equals(obj);
			} else {
				boolean result;
				Debug.DebugEvents other = (Debug.DebugEvents) obj;
				result = (!true || !getEventList().equals(other.getEventList())) ? false : true;
				return result;
			}
		}

		public Debug.DebugEvents getDefaultInstanceForType() {
			return defaultInstance;
		}

		public Debug.EventInfo getEvent(int index) {
			return (Debug.EventInfo) this.event_.get(index);
		}

		public int getEventCount() {
			return this.event_.size();
		}

		public List<Debug.EventInfo> getEventList() {
			return this.event_;
		}

		public Debug.EventInfoOrBuilder getEventOrBuilder(int index) {
			return (Debug.EventInfoOrBuilder) this.event_.get(index);
		}

		public List<Debug.EventInfoOrBuilder> getEventOrBuilderList() {
			return this.event_;
		}

		public Parser<Debug.DebugEvents> getParserForType() {
			return PARSER;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				int i = 0;
				while (i < this.event_.size()) {
					size += CodedOutputStream.computeMessageSize(EVENT_FIELD_NUMBER, (MessageLite) this.event_.get(i));
					i++;
				}
				size += this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
		}

		public int hashCode() {
			if (this.memoizedHashCode != 0) {
				return this.memoizedHashCode;
			} else {
				int hash = Debug.DebugEvents.class.hashCode() + 779;
				if (getEventCount() > 0) {
					hash = (((hash * 37) + 1) * 53) + getEventList().hashCode();
				}
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$DebugEvents");
			}
			return mutableDefault;
		}

		public final boolean isInitialized() {
			byte isInitialized = this.memoizedIsInitialized;
			if (isInitialized != (byte) -1) {
				return isInitialized == (byte) 1;
			} else {
				int i = 0;
				while (i < getEventCount()) {
					if (!getEvent(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				this.memoizedIsInitialized = (byte) 1;
				return true;
			}
		}

		public Builder newBuilderForType() {
			return newBuilder();
		}

		public Builder toBuilder() {
			return newBuilder(this);
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeTo(CodedOutputStream output) throws IOException {
			getSerializedSize();
			int i = 0;
			while (i < this.event_.size()) {
				output.writeMessage(EVENT_FIELD_NUMBER, (MessageLite) this.event_.get(i));
				i++;
			}
			output.writeRawBytes(this.unknownFields);
		}
	}

	public static interface EventInfoOrBuilder extends MessageLiteOrBuilder {
		public String getContainerId();

		public ByteString getContainerIdBytes();

		public String getContainerVersion();

		public ByteString getContainerVersionBytes();

		public Debug.DataLayerEventEvaluationInfo getDataLayerEventResult();

		public EventType getEventType();

		public String getKey();

		public ByteString getKeyBytes();

		public Debug.MacroEvaluationInfo getMacroResult();

		public boolean hasContainerId();

		public boolean hasContainerVersion();

		public boolean hasDataLayerEventResult();

		public boolean hasEventType();

		public boolean hasKey();

		public boolean hasMacroResult();
	}

	public static final class EventInfo extends GeneratedMessageLite implements Debug.EventInfoOrBuilder {
		public static final int CONTAINER_ID_FIELD_NUMBER = 3;
		public static final int CONTAINER_VERSION_FIELD_NUMBER = 2;
		public static final int DATA_LAYER_EVENT_RESULT_FIELD_NUMBER = 7;
		public static final int EVENT_TYPE_FIELD_NUMBER = 1;
		public static final int KEY_FIELD_NUMBER = 4;
		public static final int MACRO_RESULT_FIELD_NUMBER = 6;
		public static Parser<Debug.EventInfo> PARSER;
		private static final Debug.EventInfo defaultInstance;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private Object containerId_;
		private Object containerVersion_;
		private Debug.DataLayerEventEvaluationInfo dataLayerEventResult_;
		private EventType eventType_;
		private Object key_;
		private Debug.MacroEvaluationInfo macroResult_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private final ByteString unknownFields;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Debug.EventInfo, Debug.EventInfo.Builder> implements Debug.EventInfoOrBuilder {
			private int bitField0_;
			private Object containerId_;
			private Object containerVersion_;
			private Debug.DataLayerEventEvaluationInfo dataLayerEventResult_;
			private Debug.EventInfo.EventType eventType_;
			private Object key_;
			private Debug.MacroEvaluationInfo macroResult_;

			private Builder() {
				this.eventType_ = Debug.EventInfo.EventType.DATA_LAYER_EVENT;
				this.containerVersion_ = "";
				this.containerId_ = "";
				this.key_ = "";
				this.macroResult_ = Debug.MacroEvaluationInfo.getDefaultInstance();
				this.dataLayerEventResult_ = Debug.DataLayerEventEvaluationInfo.getDefaultInstance();
				maybeForceBuilderInitialization();
			}

			private static Debug.EventInfo.Builder create() {
				return new Debug.EventInfo.Builder();
			}

			private void maybeForceBuilderInitialization() {
			}

			public Debug.EventInfo build() {
				Debug.EventInfo result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Debug.EventInfo buildPartial() {
				Debug.EventInfo result = new Debug.EventInfo((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
				int from_bitField0_ = this.bitField0_;
				int to_bitField0_ = 0;
				if ((from_bitField0_ & 1) == 1) {
					to_bitField0_ |= 1;
				}
				result.eventType_ = this.eventType_;
				if ((from_bitField0_ & 2) == 2) {
					to_bitField0_ |= 2;
				}
				result.containerVersion_ = this.containerVersion_;
				if ((from_bitField0_ & 4) == 4) {
					to_bitField0_ |= 4;
				}
				result.containerId_ = this.containerId_;
				if ((from_bitField0_ & 8) == 8) {
					to_bitField0_ |= 8;
				}
				result.key_ = this.key_;
				if ((from_bitField0_ & 16) == 16) {
					to_bitField0_ |= 16;
				}
				result.macroResult_ = this.macroResult_;
				if ((from_bitField0_ & 32) == 32) {
					to_bitField0_ |= 32;
				}
				result.dataLayerEventResult_ = this.dataLayerEventResult_;
				result.bitField0_ = to_bitField0_;
				return result;
			}

			public Debug.EventInfo.Builder clear() {
				super.clear();
				this.eventType_ = Debug.EventInfo.EventType.DATA_LAYER_EVENT;
				this.bitField0_ &= -2;
				this.containerVersion_ = "";
				this.bitField0_ &= -3;
				this.containerId_ = "";
				this.bitField0_ &= -5;
				this.key_ = "";
				this.bitField0_ &= -9;
				this.macroResult_ = Debug.MacroEvaluationInfo.getDefaultInstance();
				this.bitField0_ &= -17;
				this.dataLayerEventResult_ = Debug.DataLayerEventEvaluationInfo.getDefaultInstance();
				this.bitField0_ &= -33;
				return this;
			}

			public Debug.EventInfo.Builder clearContainerId() {
				this.bitField0_ &= -5;
				this.containerId_ = Debug.EventInfo.getDefaultInstance().getContainerId();
				return this;
			}

			public Debug.EventInfo.Builder clearContainerVersion() {
				this.bitField0_ &= -3;
				this.containerVersion_ = Debug.EventInfo.getDefaultInstance().getContainerVersion();
				return this;
			}

			public Debug.EventInfo.Builder clearDataLayerEventResult() {
				this.dataLayerEventResult_ = Debug.DataLayerEventEvaluationInfo.getDefaultInstance();
				this.bitField0_ &= -33;
				return this;
			}

			public Debug.EventInfo.Builder clearEventType() {
				this.bitField0_ &= -2;
				this.eventType_ = Debug.EventInfo.EventType.DATA_LAYER_EVENT;
				return this;
			}

			public Debug.EventInfo.Builder clearKey() {
				this.bitField0_ &= -9;
				this.key_ = Debug.EventInfo.getDefaultInstance().getKey();
				return this;
			}

			public Debug.EventInfo.Builder clearMacroResult() {
				this.macroResult_ = Debug.MacroEvaluationInfo.getDefaultInstance();
				this.bitField0_ &= -17;
				return this;
			}

			public Debug.EventInfo.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public String getContainerId() {
				Object ref = this.containerId_;
				if (!((ref instanceof String))) {
					ByteString bs = (ByteString) ref;
					String s = bs.toStringUtf8();
					if (bs.isValidUtf8()) {
						this.containerId_ = s;
						return s;
					}
					return s;
				} else {
					return (String) ref;
				}
			}

			public ByteString getContainerIdBytes() {
				Object ref = this.containerId_;
				if (ref instanceof String) {
					ByteString b = ByteString.copyFromUtf8((String) ref);
					this.containerId_ = b;
					return b;
				} else {
					return (ByteString) ref;
				}
			}

			public String getContainerVersion() {
				Object ref = this.containerVersion_;
				if (!((ref instanceof String))) {
					ByteString bs = (ByteString) ref;
					String s = bs.toStringUtf8();
					if (bs.isValidUtf8()) {
						this.containerVersion_ = s;
						return s;
					}
					return s;
				} else {
					return (String) ref;
				}
			}

			public ByteString getContainerVersionBytes() {
				Object ref = this.containerVersion_;
				if (ref instanceof String) {
					ByteString b = ByteString.copyFromUtf8((String) ref);
					this.containerVersion_ = b;
					return b;
				} else {
					return (ByteString) ref;
				}
			}

			public Debug.DataLayerEventEvaluationInfo getDataLayerEventResult() {
				return this.dataLayerEventResult_;
			}

			public Debug.EventInfo getDefaultInstanceForType() {
				return Debug.EventInfo.getDefaultInstance();
			}

			public Debug.EventInfo.EventType getEventType() {
				return this.eventType_;
			}

			public String getKey() {
				Object ref = this.key_;
				if (!((ref instanceof String))) {
					ByteString bs = (ByteString) ref;
					String s = bs.toStringUtf8();
					if (bs.isValidUtf8()) {
						this.key_ = s;
						return s;
					}
					return s;
				} else {
					return (String) ref;
				}
			}

			public ByteString getKeyBytes() {
				Object ref = this.key_;
				if (ref instanceof String) {
					ByteString b = ByteString.copyFromUtf8((String) ref);
					this.key_ = b;
					return b;
				} else {
					return (ByteString) ref;
				}
			}

			public Debug.MacroEvaluationInfo getMacroResult() {
				return this.macroResult_;
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

			public final boolean isInitialized() {
				if (!hasMacroResult() || getMacroResult().isInitialized()) {
					if (!hasDataLayerEventResult() || getDataLayerEventResult().isInitialized()) {
						return true;
					}
					return false;
				}
				return false;
			}

			public Debug.EventInfo.Builder mergeDataLayerEventResult(Debug.DataLayerEventEvaluationInfo value) {
				if ((this.bitField0_ & 32) != 32 || this.dataLayerEventResult_ == Debug.DataLayerEventEvaluationInfo.getDefaultInstance()) {
					this.dataLayerEventResult_ = value;
				} else {
					this.dataLayerEventResult_ = Debug.DataLayerEventEvaluationInfo.newBuilder(this.dataLayerEventResult_).mergeFrom(value).buildPartial();
				}
				this.bitField0_ |= 32;
				return this;
			}

			public Debug.EventInfo.Builder mergeFrom(Debug.EventInfo other) {
				if (other == Debug.EventInfo.getDefaultInstance()) {
					return this;
				} else {
					if (other.hasEventType()) {
						setEventType(other.getEventType());
					}
					if (other.hasContainerVersion()) {
						this.bitField0_ |= 2;
						this.containerVersion_ = other.containerVersion_;
					}
					if (other.hasContainerId()) {
						this.bitField0_ |= 4;
						this.containerId_ = other.containerId_;
					}
					if (other.hasKey()) {
						this.bitField0_ |= 8;
						this.key_ = other.key_;
					}
					if (other.hasMacroResult()) {
						mergeMacroResult(other.getMacroResult());
					}
					if (other.hasDataLayerEventResult()) {
						mergeDataLayerEventResult(other.getDataLayerEventResult());
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Debug.EventInfo.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Debug.EventInfo parsedMessage;
				try {
					parsedMessage = (Debug.EventInfo) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Debug.EventInfo) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Debug.EventInfo.Builder mergeMacroResult(Debug.MacroEvaluationInfo value) {
				if ((this.bitField0_ & 16) != 16 || this.macroResult_ == Debug.MacroEvaluationInfo.getDefaultInstance()) {
					this.macroResult_ = value;
				} else {
					this.macroResult_ = Debug.MacroEvaluationInfo.newBuilder(this.macroResult_).mergeFrom(value).buildPartial();
				}
				this.bitField0_ |= 16;
				return this;
			}

			public Debug.EventInfo.Builder setContainerId(String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 4;
					this.containerId_ = value;
					return this;
				}
			}

			public Debug.EventInfo.Builder setContainerIdBytes(ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 4;
					this.containerId_ = value;
					return this;
				}
			}

			public Debug.EventInfo.Builder setContainerVersion(String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 2;
					this.containerVersion_ = value;
					return this;
				}
			}

			public Debug.EventInfo.Builder setContainerVersionBytes(ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 2;
					this.containerVersion_ = value;
					return this;
				}
			}

			public Debug.EventInfo.Builder setDataLayerEventResult(Debug.DataLayerEventEvaluationInfo.Builder builderForValue) {
				this.dataLayerEventResult_ = builderForValue.build();
				this.bitField0_ |= 32;
				return this;
			}

			public Debug.EventInfo.Builder setDataLayerEventResult(Debug.DataLayerEventEvaluationInfo value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.dataLayerEventResult_ = value;
					this.bitField0_ |= 32;
					return this;
				}
			}

			public Debug.EventInfo.Builder setEventType(Debug.EventInfo.EventType value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 1;
					this.eventType_ = value;
					return this;
				}
			}

			public Debug.EventInfo.Builder setKey(String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 8;
					this.key_ = value;
					return this;
				}
			}

			public Debug.EventInfo.Builder setKeyBytes(ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 8;
					this.key_ = value;
					return this;
				}
			}

			public Debug.EventInfo.Builder setMacroResult(Debug.MacroEvaluationInfo.Builder builderForValue) {
				this.macroResult_ = builderForValue.build();
				this.bitField0_ |= 16;
				return this;
			}

			public Debug.EventInfo.Builder setMacroResult(Debug.MacroEvaluationInfo value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.macroResult_ = value;
					this.bitField0_ |= 16;
					return this;
				}
			}
		}

		public static enum EventType implements EnumLite {
			DATA_LAYER_EVENT(0, 1),
			MACRO_REFERENCE(1, 2);

			public static final int DATA_LAYER_EVENT_VALUE = 1;
			public static final int MACRO_REFERENCE_VALUE = 2;
			private static EnumLiteMap<Debug.EventInfo.EventType> internalValueMap;
			private final int value;


			static {
				internalValueMap = new EnumLiteMap<Debug.EventInfo.EventType>() {
			public Debug.EventInfo.EventType findValueByNumber(int number) {
				return Debug.EventInfo.EventType.valueOf(number);
			}
		};
			}

			private EventType(int index, int value) {
				this.value = value;
			}

			public static EnumLiteMap<Debug.EventInfo.EventType> internalGetValueMap() {
				return internalValueMap;
			}

			public static Debug.EventInfo.EventType valueOf(int value) {
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
			PARSER = new AbstractParser<Debug.EventInfo>() {
			public Debug.EventInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Debug.EventInfo(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Debug.EventInfo(true);
			defaultInstance.initFields();
		}

		private EventInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			OutputStream unknownFieldsOutput;
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			initFields();
			unknownFieldsOutput = ByteString.newOutput();
			CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
			boolean done = false;
			while (!done) {
				int tag;
				try {
					tag = input.readTag();
					ByteString bs;
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
						bs = input.readBytes();
						this.bitField0_ |= 2;
						this.containerVersion_ = bs;
						break;
					case 26:
						bs = input.readBytes();
						this.bitField0_ |= 4;
						this.containerId_ = bs;
						break;
					case 34:
						bs = input.readBytes();
						this.bitField0_ |= 8;
						this.key_ = bs;
						break;
					case 50:
						Debug.MacroEvaluationInfo.Builder subBuilder = null;
						if ((this.bitField0_ & 16) == 16) {
							subBuilder = this.macroResult_.toBuilder();
						}
						this.macroResult_ = (Debug.MacroEvaluationInfo) input.readMessage(Debug.MacroEvaluationInfo.PARSER, extensionRegistry);
						if (subBuilder != null) {
							subBuilder.mergeFrom(this.macroResult_);
							this.macroResult_ = subBuilder.buildPartial();
						}
						this.bitField0_ |= 16;
						break;
					case 58:
						com.google.tagmanager.protobuf.GeneratedMessageLite.Builder subBuilder_2 = null;
						if ((this.bitField0_ & 32) == 32) {
							subBuilder_2 = this.dataLayerEventResult_.toBuilder();
						}
						this.dataLayerEventResult_ = (Debug.DataLayerEventEvaluationInfo) input.readMessage(Debug.DataLayerEventEvaluationInfo.PARSER, extensionRegistry);
						if (subBuilder_2 != null) {
							subBuilder_2.mergeFrom(this.dataLayerEventResult_);
							this.dataLayerEventResult_ = subBuilder_2.buildPartial();
						}
						this.bitField0_ |= 32;
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				} catch (InvalidProtocolBufferException e) {
					throw e.setUnfinishedMessage(this);
				} catch (IOException e_2) {
					throw new InvalidProtocolBufferException(e_2.getMessage()).setUnfinishedMessage(this);
				} catch (Throwable th) {
					unknownFieldsCodedOutput.flush();
					this.unknownFields = unknownFieldsOutput.toByteString();
				}
			}
			try {
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
			} catch (IOException e_3) {
				this.unknownFields = unknownFieldsOutput.toByteString();
			}
			makeExtensionsImmutable();
		}

		private EventInfo(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private EventInfo(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Debug.EventInfo getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.eventType_ = EventType.DATA_LAYER_EVENT;
			this.containerVersion_ = "";
			this.containerId_ = "";
			this.key_ = "";
			this.macroResult_ = Debug.MacroEvaluationInfo.getDefaultInstance();
			this.dataLayerEventResult_ = Debug.DataLayerEventEvaluationInfo.getDefaultInstance();
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Debug.EventInfo prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Debug.EventInfo parseDelimitedFrom(InputStream input) throws IOException {
			return (Debug.EventInfo) PARSER.parseDelimitedFrom(input);
		}

		public static Debug.EventInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.EventInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Debug.EventInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Debug.EventInfo) PARSER.parseFrom(data);
		}

		public static Debug.EventInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Debug.EventInfo) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Debug.EventInfo parseFrom(CodedInputStream input) throws IOException {
			return (Debug.EventInfo) PARSER.parseFrom(input);
		}

		public static Debug.EventInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.EventInfo) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Debug.EventInfo parseFrom(InputStream input) throws IOException {
			return (Debug.EventInfo) PARSER.parseFrom(input);
		}

		public static Debug.EventInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.EventInfo) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Debug.EventInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Debug.EventInfo) PARSER.parseFrom(data);
		}

		public static Debug.EventInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Debug.EventInfo) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Debug.EventInfo))) {
				return super.equals(obj);
			} else {
				boolean result;
				Debug.EventInfo other = (Debug.EventInfo) obj;
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
				ByteString bs = (ByteString) ref;
				String s = bs.toStringUtf8();
				if (bs.isValidUtf8()) {
					this.containerId_ = s;
				}
				return s;
			}
		}

		public ByteString getContainerIdBytes() {
			Object ref = this.containerId_;
			if (ref instanceof String) {
				ByteString b = ByteString.copyFromUtf8((String) ref);
				this.containerId_ = b;
				return b;
			} else {
				return (ByteString) ref;
			}
		}

		public String getContainerVersion() {
			Object ref = this.containerVersion_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				ByteString bs = (ByteString) ref;
				String s = bs.toStringUtf8();
				if (bs.isValidUtf8()) {
					this.containerVersion_ = s;
				}
				return s;
			}
		}

		public ByteString getContainerVersionBytes() {
			Object ref = this.containerVersion_;
			if (ref instanceof String) {
				ByteString b = ByteString.copyFromUtf8((String) ref);
				this.containerVersion_ = b;
				return b;
			} else {
				return (ByteString) ref;
			}
		}

		public Debug.DataLayerEventEvaluationInfo getDataLayerEventResult() {
			return this.dataLayerEventResult_;
		}

		public Debug.EventInfo getDefaultInstanceForType() {
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
				ByteString bs = (ByteString) ref;
				String s = bs.toStringUtf8();
				if (bs.isValidUtf8()) {
					this.key_ = s;
				}
				return s;
			}
		}

		public ByteString getKeyBytes() {
			Object ref = this.key_;
			if (ref instanceof String) {
				ByteString b = ByteString.copyFromUtf8((String) ref);
				this.key_ = b;
				return b;
			} else {
				return (ByteString) ref;
			}
		}

		public Debug.MacroEvaluationInfo getMacroResult() {
			return this.macroResult_;
		}

		public Parser<Debug.EventInfo> getParserForType() {
			return PARSER;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				if ((this.bitField0_ & 1) == 1) {
					size += CodedOutputStream.computeEnumSize(EVENT_TYPE_FIELD_NUMBER, this.eventType_.getNumber());
				}
				if ((this.bitField0_ & 2) == 2) {
					size += CodedOutputStream.computeBytesSize(CONTAINER_VERSION_FIELD_NUMBER, getContainerVersionBytes());
				}
				if ((this.bitField0_ & 4) == 4) {
					size += CodedOutputStream.computeBytesSize(CONTAINER_ID_FIELD_NUMBER, getContainerIdBytes());
				}
				if ((this.bitField0_ & 8) == 8) {
					size += CodedOutputStream.computeBytesSize(KEY_FIELD_NUMBER, getKeyBytes());
				}
				if ((this.bitField0_ & 16) == 16) {
					size += CodedOutputStream.computeMessageSize(MACRO_RESULT_FIELD_NUMBER, this.macroResult_);
				}
				if ((this.bitField0_ & 32) == 32) {
					size += CodedOutputStream.computeMessageSize(DATA_LAYER_EVENT_RESULT_FIELD_NUMBER, this.dataLayerEventResult_);
				}
				size += this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
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
			if (this.memoizedHashCode != 0) {
				return this.memoizedHashCode;
			} else {
				int hash = Debug.EventInfo.class.hashCode() + 779;
				if (hasEventType()) {
					hash = (((hash * 37) + 1) * 53) + Internal.hashEnum(getEventType());
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
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$EventInfo");
			}
			return mutableDefault;
		}

		public final boolean isInitialized() {
			byte isInitialized = this.memoizedIsInitialized;
			if (isInitialized != (byte) -1) {
				return isInitialized == (byte) 1;
			} else if (!hasMacroResult() || getMacroResult().isInitialized()) {
				if (!hasDataLayerEventResult() || getDataLayerEventResult().isInitialized()) {
					this.memoizedIsInitialized = (byte) 1;
					return true;
				} else {
					this.memoizedIsInitialized = (byte) 0;
					return false;
				}
			} else {
				this.memoizedIsInitialized = (byte) 0;
				return false;
			}
		}

		public Builder newBuilderForType() {
			return newBuilder();
		}

		public Builder toBuilder() {
			return newBuilder(this);
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeTo(CodedOutputStream output) throws IOException {
			getSerializedSize();
			if ((this.bitField0_ & 1) == 1) {
				output.writeEnum(EVENT_TYPE_FIELD_NUMBER, this.eventType_.getNumber());
			}
			if ((this.bitField0_ & 2) == 2) {
				output.writeBytes(CONTAINER_VERSION_FIELD_NUMBER, getContainerVersionBytes());
			}
			if ((this.bitField0_ & 4) == 4) {
				output.writeBytes(CONTAINER_ID_FIELD_NUMBER, getContainerIdBytes());
			}
			if ((this.bitField0_ & 8) == 8) {
				output.writeBytes(KEY_FIELD_NUMBER, getKeyBytes());
			}
			if ((this.bitField0_ & 16) == 16) {
				output.writeMessage(MACRO_RESULT_FIELD_NUMBER, this.macroResult_);
			}
			if ((this.bitField0_ & 32) == 32) {
				output.writeMessage(DATA_LAYER_EVENT_RESULT_FIELD_NUMBER, this.dataLayerEventResult_);
			}
			output.writeRawBytes(this.unknownFields);
		}
	}

	public static interface MacroEvaluationInfoOrBuilder extends MessageLiteOrBuilder {
		public Debug.ResolvedFunctionCall getResult();

		public Debug.RuleEvaluationStepInfo getRulesEvaluation();

		public boolean hasResult();

		public boolean hasRulesEvaluation();
	}

	public static final class MacroEvaluationInfo extends GeneratedMessageLite implements Debug.MacroEvaluationInfoOrBuilder {
		public static final int MACRO_FIELD_NUMBER = 47497405;
		public static Parser<Debug.MacroEvaluationInfo> PARSER = null;
		public static final int RESULT_FIELD_NUMBER = 3;
		public static final int RULES_EVALUATION_FIELD_NUMBER = 1;
		private static final Debug.MacroEvaluationInfo defaultInstance;
		public static final GeneratedExtension<Value, Debug.MacroEvaluationInfo> macro;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private Debug.ResolvedFunctionCall result_;
		private Debug.RuleEvaluationStepInfo rulesEvaluation_;
		private final ByteString unknownFields;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Debug.MacroEvaluationInfo, Debug.MacroEvaluationInfo.Builder> implements Debug.MacroEvaluationInfoOrBuilder {
			private int bitField0_;
			private Debug.ResolvedFunctionCall result_;
			private Debug.RuleEvaluationStepInfo rulesEvaluation_;

			private Builder() {
				this.rulesEvaluation_ = Debug.RuleEvaluationStepInfo.getDefaultInstance();
				this.result_ = Debug.ResolvedFunctionCall.getDefaultInstance();
				maybeForceBuilderInitialization();
			}

			private static Debug.MacroEvaluationInfo.Builder create() {
				return new Debug.MacroEvaluationInfo.Builder();
			}

			private void maybeForceBuilderInitialization() {
			}

			public Debug.MacroEvaluationInfo build() {
				Debug.MacroEvaluationInfo result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Debug.MacroEvaluationInfo buildPartial() {
				Debug.MacroEvaluationInfo result = new Debug.MacroEvaluationInfo((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
				int from_bitField0_ = this.bitField0_;
				int to_bitField0_ = 0;
				if ((from_bitField0_ & 1) == 1) {
					to_bitField0_ |= 1;
				}
				result.rulesEvaluation_ = this.rulesEvaluation_;
				if ((from_bitField0_ & 2) == 2) {
					to_bitField0_ |= 2;
				}
				result.result_ = this.result_;
				result.bitField0_ = to_bitField0_;
				return result;
			}

			public Debug.MacroEvaluationInfo.Builder clear() {
				super.clear();
				this.rulesEvaluation_ = Debug.RuleEvaluationStepInfo.getDefaultInstance();
				this.bitField0_ &= -2;
				this.result_ = Debug.ResolvedFunctionCall.getDefaultInstance();
				this.bitField0_ &= -3;
				return this;
			}

			public Debug.MacroEvaluationInfo.Builder clearResult() {
				this.result_ = Debug.ResolvedFunctionCall.getDefaultInstance();
				this.bitField0_ &= -3;
				return this;
			}

			public Debug.MacroEvaluationInfo.Builder clearRulesEvaluation() {
				this.rulesEvaluation_ = Debug.RuleEvaluationStepInfo.getDefaultInstance();
				this.bitField0_ &= -2;
				return this;
			}

			public Debug.MacroEvaluationInfo.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public Debug.MacroEvaluationInfo getDefaultInstanceForType() {
				return Debug.MacroEvaluationInfo.getDefaultInstance();
			}

			public Debug.ResolvedFunctionCall getResult() {
				return this.result_;
			}

			public Debug.RuleEvaluationStepInfo getRulesEvaluation() {
				return this.rulesEvaluation_;
			}

			public boolean hasResult() {
				return (this.bitField0_ & 2) == 2;
			}

			public boolean hasRulesEvaluation() {
				return (this.bitField0_ & 1) == 1;
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

			public Debug.MacroEvaluationInfo.Builder mergeFrom(Debug.MacroEvaluationInfo other) {
				if (other == Debug.MacroEvaluationInfo.getDefaultInstance()) {
					return this;
				} else {
					if (other.hasRulesEvaluation()) {
						mergeRulesEvaluation(other.getRulesEvaluation());
					}
					if (other.hasResult()) {
						mergeResult(other.getResult());
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Debug.MacroEvaluationInfo.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Debug.MacroEvaluationInfo parsedMessage;
				try {
					parsedMessage = (Debug.MacroEvaluationInfo) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Debug.MacroEvaluationInfo) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Debug.MacroEvaluationInfo.Builder mergeResult(Debug.ResolvedFunctionCall value) {
				if ((this.bitField0_ & 2) != 2 || this.result_ == Debug.ResolvedFunctionCall.getDefaultInstance()) {
					this.result_ = value;
				} else {
					this.result_ = Debug.ResolvedFunctionCall.newBuilder(this.result_).mergeFrom(value).buildPartial();
				}
				this.bitField0_ |= 2;
				return this;
			}

			public Debug.MacroEvaluationInfo.Builder mergeRulesEvaluation(Debug.RuleEvaluationStepInfo value) {
				if ((this.bitField0_ & 1) != 1 || this.rulesEvaluation_ == Debug.RuleEvaluationStepInfo.getDefaultInstance()) {
					this.rulesEvaluation_ = value;
				} else {
					this.rulesEvaluation_ = Debug.RuleEvaluationStepInfo.newBuilder(this.rulesEvaluation_).mergeFrom(value).buildPartial();
				}
				this.bitField0_ |= 1;
				return this;
			}

			public Debug.MacroEvaluationInfo.Builder setResult(Debug.ResolvedFunctionCall.Builder builderForValue) {
				this.result_ = builderForValue.build();
				this.bitField0_ |= 2;
				return this;
			}

			public Debug.MacroEvaluationInfo.Builder setResult(Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.result_ = value;
					this.bitField0_ |= 2;
					return this;
				}
			}

			public Debug.MacroEvaluationInfo.Builder setRulesEvaluation(Debug.RuleEvaluationStepInfo.Builder builderForValue) {
				this.rulesEvaluation_ = builderForValue.build();
				this.bitField0_ |= 1;
				return this;
			}

			public Debug.MacroEvaluationInfo.Builder setRulesEvaluation(Debug.RuleEvaluationStepInfo value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.rulesEvaluation_ = value;
					this.bitField0_ |= 1;
					return this;
				}
			}
		}


		static {
			PARSER = new AbstractParser<Debug.MacroEvaluationInfo>() {
			public Debug.MacroEvaluationInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Debug.MacroEvaluationInfo(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Debug.MacroEvaluationInfo(true);
			defaultInstance.initFields();
			macro = GeneratedMessageLite.newSingularGeneratedExtension(Value.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, MACRO_FIELD_NUMBER, FieldType.MESSAGE, Debug.MacroEvaluationInfo.class);
		}

		private MacroEvaluationInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			OutputStream unknownFieldsOutput;
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			initFields();
			unknownFieldsOutput = ByteString.newOutput();
			CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
			boolean done = false;
			while (!done) {
				int tag;
				try {
					tag = input.readTag();
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case Value.ESCAPING_FIELD_NUMBER:
						Debug.RuleEvaluationStepInfo.Builder subBuilder = null;
						if ((this.bitField0_ & 1) == 1) {
							subBuilder = this.rulesEvaluation_.toBuilder();
						}
						this.rulesEvaluation_ = (Debug.RuleEvaluationStepInfo) input.readMessage(Debug.RuleEvaluationStepInfo.PARSER, extensionRegistry);
						if (subBuilder != null) {
							subBuilder.mergeFrom(this.rulesEvaluation_);
							this.rulesEvaluation_ = subBuilder.buildPartial();
						}
						this.bitField0_ |= 1;
						break;
					case 26:
						Debug.ResolvedFunctionCall.Builder subBuilder_2 = null;
						if ((this.bitField0_ & 2) == 2) {
							subBuilder_2 = this.result_.toBuilder();
						}
						this.result_ = (Debug.ResolvedFunctionCall) input.readMessage(Debug.ResolvedFunctionCall.PARSER, extensionRegistry);
						if (subBuilder_2 != null) {
							subBuilder_2.mergeFrom(this.result_);
							this.result_ = subBuilder_2.buildPartial();
						}
						this.bitField0_ |= 2;
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				} catch (InvalidProtocolBufferException e) {
					throw e.setUnfinishedMessage(this);
				} catch (IOException e_2) {
					throw new InvalidProtocolBufferException(e_2.getMessage()).setUnfinishedMessage(this);
				} catch (Throwable th) {
					unknownFieldsCodedOutput.flush();
					this.unknownFields = unknownFieldsOutput.toByteString();
				}
			}
			try {
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
			} catch (IOException e_3) {
				this.unknownFields = unknownFieldsOutput.toByteString();
			}
			makeExtensionsImmutable();
		}

		private MacroEvaluationInfo(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private MacroEvaluationInfo(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Debug.MacroEvaluationInfo getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.rulesEvaluation_ = Debug.RuleEvaluationStepInfo.getDefaultInstance();
			this.result_ = Debug.ResolvedFunctionCall.getDefaultInstance();
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Debug.MacroEvaluationInfo prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Debug.MacroEvaluationInfo parseDelimitedFrom(InputStream input) throws IOException {
			return (Debug.MacroEvaluationInfo) PARSER.parseDelimitedFrom(input);
		}

		public static Debug.MacroEvaluationInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.MacroEvaluationInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Debug.MacroEvaluationInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Debug.MacroEvaluationInfo) PARSER.parseFrom(data);
		}

		public static Debug.MacroEvaluationInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Debug.MacroEvaluationInfo) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Debug.MacroEvaluationInfo parseFrom(CodedInputStream input) throws IOException {
			return (Debug.MacroEvaluationInfo) PARSER.parseFrom(input);
		}

		public static Debug.MacroEvaluationInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.MacroEvaluationInfo) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Debug.MacroEvaluationInfo parseFrom(InputStream input) throws IOException {
			return (Debug.MacroEvaluationInfo) PARSER.parseFrom(input);
		}

		public static Debug.MacroEvaluationInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.MacroEvaluationInfo) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Debug.MacroEvaluationInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Debug.MacroEvaluationInfo) PARSER.parseFrom(data);
		}

		public static Debug.MacroEvaluationInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Debug.MacroEvaluationInfo) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Debug.MacroEvaluationInfo))) {
				return super.equals(obj);
			} else {
				boolean result;
				Debug.MacroEvaluationInfo other = (Debug.MacroEvaluationInfo) obj;
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

		public Debug.MacroEvaluationInfo getDefaultInstanceForType() {
			return defaultInstance;
		}

		public Parser<Debug.MacroEvaluationInfo> getParserForType() {
			return PARSER;
		}

		public Debug.ResolvedFunctionCall getResult() {
			return this.result_;
		}

		public Debug.RuleEvaluationStepInfo getRulesEvaluation() {
			return this.rulesEvaluation_;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				if ((this.bitField0_ & 1) == 1) {
					size += CodedOutputStream.computeMessageSize(RULES_EVALUATION_FIELD_NUMBER, this.rulesEvaluation_);
				}
				if ((this.bitField0_ & 2) == 2) {
					size += CodedOutputStream.computeMessageSize(RESULT_FIELD_NUMBER, this.result_);
				}
				size += this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
		}

		public boolean hasResult() {
			return (this.bitField0_ & 2) == 2;
		}

		public boolean hasRulesEvaluation() {
			return (this.bitField0_ & 1) == 1;
		}

		public int hashCode() {
			if (this.memoizedHashCode != 0) {
				return this.memoizedHashCode;
			} else {
				int hash = Debug.MacroEvaluationInfo.class.hashCode() + 779;
				if (hasRulesEvaluation()) {
					hash = (((hash * 37) + 1) * 53) + getRulesEvaluation().hashCode();
				}
				if (hasResult()) {
					hash = (((hash * 37) + 3) * 53) + getResult().hashCode();
				}
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$MacroEvaluationInfo");
			}
			return mutableDefault;
		}

		public final boolean isInitialized() {
			byte isInitialized = this.memoizedIsInitialized;
			if (isInitialized != (byte) -1) {
				return isInitialized == (byte) 1;
			} else if (!hasRulesEvaluation() || getRulesEvaluation().isInitialized()) {
				if (!hasResult() || getResult().isInitialized()) {
					this.memoizedIsInitialized = (byte) 1;
					return true;
				} else {
					this.memoizedIsInitialized = (byte) 0;
					return false;
				}
			} else {
				this.memoizedIsInitialized = (byte) 0;
				return false;
			}
		}

		public Builder newBuilderForType() {
			return newBuilder();
		}

		public Builder toBuilder() {
			return newBuilder(this);
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeTo(CodedOutputStream output) throws IOException {
			getSerializedSize();
			if ((this.bitField0_ & 1) == 1) {
				output.writeMessage(RULES_EVALUATION_FIELD_NUMBER, this.rulesEvaluation_);
			}
			if ((this.bitField0_ & 2) == 2) {
				output.writeMessage(RESULT_FIELD_NUMBER, this.result_);
			}
			output.writeRawBytes(this.unknownFields);
		}
	}

	public static interface ResolvedFunctionCallOrBuilder extends MessageLiteOrBuilder {
		public String getAssociatedRuleName();

		public ByteString getAssociatedRuleNameBytes();

		public Debug.ResolvedProperty getProperties(int r1i);

		public int getPropertiesCount();

		public List<Debug.ResolvedProperty> getPropertiesList();

		public Value getResult();

		public boolean hasAssociatedRuleName();

		public boolean hasResult();
	}

	public static final class ResolvedFunctionCall extends GeneratedMessageLite implements Debug.ResolvedFunctionCallOrBuilder {
		public static final int ASSOCIATED_RULE_NAME_FIELD_NUMBER = 3;
		public static Parser<Debug.ResolvedFunctionCall> PARSER = null;
		public static final int PROPERTIES_FIELD_NUMBER = 1;
		public static final int RESULT_FIELD_NUMBER = 2;
		private static final Debug.ResolvedFunctionCall defaultInstance;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private Object associatedRuleName_;
		private int bitField0_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private List<Debug.ResolvedProperty> properties_;
		private Value result_;
		private final ByteString unknownFields;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Debug.ResolvedFunctionCall, Debug.ResolvedFunctionCall.Builder> implements Debug.ResolvedFunctionCallOrBuilder {
			private Object associatedRuleName_;
			private int bitField0_;
			private List<Debug.ResolvedProperty> properties_;
			private Value result_;

			private Builder() {
				this.properties_ = Collections.emptyList();
				this.result_ = Value.getDefaultInstance();
				this.associatedRuleName_ = "";
				maybeForceBuilderInitialization();
			}

			private static Debug.ResolvedFunctionCall.Builder create() {
				return new Debug.ResolvedFunctionCall.Builder();
			}

			private void ensurePropertiesIsMutable() {
				if ((this.bitField0_ & 1) != 1) {
					this.properties_ = new ArrayList(this.properties_);
					this.bitField0_ |= 1;
				}
			}

			private void maybeForceBuilderInitialization() {
			}

			public Debug.ResolvedFunctionCall.Builder addAllProperties(Iterable<Debug.ResolvedProperty> values) {
				ensurePropertiesIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.properties_);
				return this;
			}

			public Debug.ResolvedFunctionCall.Builder addProperties(int index, Debug.ResolvedProperty.Builder builderForValue) {
				ensurePropertiesIsMutable();
				this.properties_.add(index, builderForValue.build());
				return this;
			}

			public Debug.ResolvedFunctionCall.Builder addProperties(int index, Debug.ResolvedProperty value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensurePropertiesIsMutable();
					this.properties_.add(index, value);
					return this;
				}
			}

			public Debug.ResolvedFunctionCall.Builder addProperties(Debug.ResolvedProperty.Builder builderForValue) {
				ensurePropertiesIsMutable();
				this.properties_.add(builderForValue.build());
				return this;
			}

			public Debug.ResolvedFunctionCall.Builder addProperties(Debug.ResolvedProperty value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensurePropertiesIsMutable();
					this.properties_.add(value);
					return this;
				}
			}

			public Debug.ResolvedFunctionCall build() {
				Debug.ResolvedFunctionCall result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Debug.ResolvedFunctionCall buildPartial() {
				Debug.ResolvedFunctionCall result = new Debug.ResolvedFunctionCall((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
				int from_bitField0_ = this.bitField0_;
				int to_bitField0_ = 0;
				if ((this.bitField0_ & 1) == 1) {
					this.properties_ = Collections.unmodifiableList(this.properties_);
					this.bitField0_ &= -2;
				}
				result.properties_ = this.properties_;
				if ((from_bitField0_ & 2) == 2) {
					to_bitField0_ |= 1;
				}
				result.result_ = this.result_;
				if ((from_bitField0_ & 4) == 4) {
					to_bitField0_ |= 2;
				}
				result.associatedRuleName_ = this.associatedRuleName_;
				result.bitField0_ = to_bitField0_;
				return result;
			}

			public Debug.ResolvedFunctionCall.Builder clear() {
				super.clear();
				this.properties_ = Collections.emptyList();
				this.bitField0_ &= -2;
				this.result_ = Value.getDefaultInstance();
				this.bitField0_ &= -3;
				this.associatedRuleName_ = "";
				this.bitField0_ &= -5;
				return this;
			}

			public Debug.ResolvedFunctionCall.Builder clearAssociatedRuleName() {
				this.bitField0_ &= -5;
				this.associatedRuleName_ = Debug.ResolvedFunctionCall.getDefaultInstance().getAssociatedRuleName();
				return this;
			}

			public Debug.ResolvedFunctionCall.Builder clearProperties() {
				this.properties_ = Collections.emptyList();
				this.bitField0_ &= -2;
				return this;
			}

			public Debug.ResolvedFunctionCall.Builder clearResult() {
				this.result_ = Value.getDefaultInstance();
				this.bitField0_ &= -3;
				return this;
			}

			public Debug.ResolvedFunctionCall.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public String getAssociatedRuleName() {
				Object ref = this.associatedRuleName_;
				if (!((ref instanceof String))) {
					ByteString bs = (ByteString) ref;
					String s = bs.toStringUtf8();
					if (bs.isValidUtf8()) {
						this.associatedRuleName_ = s;
						return s;
					}
					return s;
				} else {
					return (String) ref;
				}
			}

			public ByteString getAssociatedRuleNameBytes() {
				Object ref = this.associatedRuleName_;
				if (ref instanceof String) {
					ByteString b = ByteString.copyFromUtf8((String) ref);
					this.associatedRuleName_ = b;
					return b;
				} else {
					return (ByteString) ref;
				}
			}

			public Debug.ResolvedFunctionCall getDefaultInstanceForType() {
				return Debug.ResolvedFunctionCall.getDefaultInstance();
			}

			public Debug.ResolvedProperty getProperties(int index) {
				return (Debug.ResolvedProperty) this.properties_.get(index);
			}

			public int getPropertiesCount() {
				return this.properties_.size();
			}

			public List<Debug.ResolvedProperty> getPropertiesList() {
				return Collections.unmodifiableList(this.properties_);
			}

			public Value getResult() {
				return this.result_;
			}

			public boolean hasAssociatedRuleName() {
				return (this.bitField0_ & 4) == 4;
			}

			public boolean hasResult() {
				return (this.bitField0_ & 2) == 2;
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

			public Debug.ResolvedFunctionCall.Builder mergeFrom(Debug.ResolvedFunctionCall other) {
				if (other == Debug.ResolvedFunctionCall.getDefaultInstance()) {
					return this;
				} else {
					if (!other.properties_.isEmpty()) {
						if (this.properties_.isEmpty()) {
							this.properties_ = other.properties_;
							this.bitField0_ &= -2;
						} else {
							ensurePropertiesIsMutable();
							this.properties_.addAll(other.properties_);
						}
					}
					if (other.hasResult()) {
						mergeResult(other.getResult());
					}
					if (other.hasAssociatedRuleName()) {
						this.bitField0_ |= 4;
						this.associatedRuleName_ = other.associatedRuleName_;
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Debug.ResolvedFunctionCall.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Debug.ResolvedFunctionCall parsedMessage;
				try {
					parsedMessage = (Debug.ResolvedFunctionCall) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Debug.ResolvedFunctionCall) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Debug.ResolvedFunctionCall.Builder mergeResult(Value value) {
				if ((this.bitField0_ & 2) != 2 || this.result_ == Value.getDefaultInstance()) {
					this.result_ = value;
				} else {
					this.result_ = Value.newBuilder(this.result_).mergeFrom(value).buildPartial();
				}
				this.bitField0_ |= 2;
				return this;
			}

			public Debug.ResolvedFunctionCall.Builder removeProperties(int index) {
				ensurePropertiesIsMutable();
				this.properties_.remove(index);
				return this;
			}

			public Debug.ResolvedFunctionCall.Builder setAssociatedRuleName(String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 4;
					this.associatedRuleName_ = value;
					return this;
				}
			}

			public Debug.ResolvedFunctionCall.Builder setAssociatedRuleNameBytes(ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 4;
					this.associatedRuleName_ = value;
					return this;
				}
			}

			public Debug.ResolvedFunctionCall.Builder setProperties(int index, Debug.ResolvedProperty.Builder builderForValue) {
				ensurePropertiesIsMutable();
				this.properties_.set(index, builderForValue.build());
				return this;
			}

			public Debug.ResolvedFunctionCall.Builder setProperties(int index, Debug.ResolvedProperty value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensurePropertiesIsMutable();
					this.properties_.set(index, value);
					return this;
				}
			}

			public Debug.ResolvedFunctionCall.Builder setResult(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builderForValue) {
				this.result_ = builderForValue.build();
				this.bitField0_ |= 2;
				return this;
			}

			public Debug.ResolvedFunctionCall.Builder setResult(Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.result_ = value;
					this.bitField0_ |= 2;
					return this;
				}
			}
		}


		static {
			PARSER = new AbstractParser<Debug.ResolvedFunctionCall>() {
			public Debug.ResolvedFunctionCall parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Debug.ResolvedFunctionCall(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Debug.ResolvedFunctionCall(true);
			defaultInstance.initFields();
		}

		private ResolvedFunctionCall(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			OutputStream unknownFieldsOutput;
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			initFields();
			int mutable_bitField0_ = 0;
			unknownFieldsOutput = ByteString.newOutput();
			CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
			boolean done = false;
			while (!done) {
				int tag;
				try {
					tag = input.readTag();
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case Value.ESCAPING_FIELD_NUMBER:
						if ((mutable_bitField0_ & 1) != 1) {
							this.properties_ = new ArrayList();
							mutable_bitField0_ |= 1;
						}
						this.properties_.add(input.readMessage(Debug.ResolvedProperty.PARSER, extensionRegistry));
						break;
					case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder subBuilder = null;
						if ((this.bitField0_ & 1) == 1) {
							subBuilder = this.result_.toBuilder();
						}
						this.result_ = (Value) input.readMessage(Value.PARSER, extensionRegistry);
						if (subBuilder != null) {
							subBuilder.mergeFrom(this.result_);
							this.result_ = subBuilder.buildPartial();
						}
						this.bitField0_ |= 1;
						break;
					case 26:
						ByteString bs = input.readBytes();
						this.bitField0_ |= 2;
						this.associatedRuleName_ = bs;
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				} catch (InvalidProtocolBufferException e) {
					throw e.setUnfinishedMessage(this);
				} catch (IOException e_2) {
					throw new InvalidProtocolBufferException(e_2.getMessage()).setUnfinishedMessage(this);
				} catch (Throwable th) {
					if ((mutable_bitField0_ & 1) == 1) {
						this.properties_ = Collections.unmodifiableList(this.properties_);
					}
					unknownFieldsCodedOutput.flush();
					this.unknownFields = unknownFieldsOutput.toByteString();
				}
			}
			if ((mutable_bitField0_ & 1) == 1) {
				this.properties_ = Collections.unmodifiableList(this.properties_);
			}
			try {
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
			} catch (IOException e_3) {
				this.unknownFields = unknownFieldsOutput.toByteString();
			}
			makeExtensionsImmutable();
		}

		private ResolvedFunctionCall(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private ResolvedFunctionCall(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Debug.ResolvedFunctionCall getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.properties_ = Collections.emptyList();
			this.result_ = Value.getDefaultInstance();
			this.associatedRuleName_ = "";
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Debug.ResolvedFunctionCall prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Debug.ResolvedFunctionCall parseDelimitedFrom(InputStream input) throws IOException {
			return (Debug.ResolvedFunctionCall) PARSER.parseDelimitedFrom(input);
		}

		public static Debug.ResolvedFunctionCall parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.ResolvedFunctionCall) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Debug.ResolvedFunctionCall parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Debug.ResolvedFunctionCall) PARSER.parseFrom(data);
		}

		public static Debug.ResolvedFunctionCall parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Debug.ResolvedFunctionCall) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Debug.ResolvedFunctionCall parseFrom(CodedInputStream input) throws IOException {
			return (Debug.ResolvedFunctionCall) PARSER.parseFrom(input);
		}

		public static Debug.ResolvedFunctionCall parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.ResolvedFunctionCall) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Debug.ResolvedFunctionCall parseFrom(InputStream input) throws IOException {
			return (Debug.ResolvedFunctionCall) PARSER.parseFrom(input);
		}

		public static Debug.ResolvedFunctionCall parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.ResolvedFunctionCall) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Debug.ResolvedFunctionCall parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Debug.ResolvedFunctionCall) PARSER.parseFrom(data);
		}

		public static Debug.ResolvedFunctionCall parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Debug.ResolvedFunctionCall) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Debug.ResolvedFunctionCall))) {
				return super.equals(obj);
			} else {
				boolean result;
				Debug.ResolvedFunctionCall other = (Debug.ResolvedFunctionCall) obj;
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
				ByteString bs = (ByteString) ref;
				String s = bs.toStringUtf8();
				if (bs.isValidUtf8()) {
					this.associatedRuleName_ = s;
				}
				return s;
			}
		}

		public ByteString getAssociatedRuleNameBytes() {
			Object ref = this.associatedRuleName_;
			if (ref instanceof String) {
				ByteString b = ByteString.copyFromUtf8((String) ref);
				this.associatedRuleName_ = b;
				return b;
			} else {
				return (ByteString) ref;
			}
		}

		public Debug.ResolvedFunctionCall getDefaultInstanceForType() {
			return defaultInstance;
		}

		public Parser<Debug.ResolvedFunctionCall> getParserForType() {
			return PARSER;
		}

		public Debug.ResolvedProperty getProperties(int index) {
			return (Debug.ResolvedProperty) this.properties_.get(index);
		}

		public int getPropertiesCount() {
			return this.properties_.size();
		}

		public List<Debug.ResolvedProperty> getPropertiesList() {
			return this.properties_;
		}

		public Debug.ResolvedPropertyOrBuilder getPropertiesOrBuilder(int index) {
			return (Debug.ResolvedPropertyOrBuilder) this.properties_.get(index);
		}

		public List<Debug.ResolvedPropertyOrBuilder> getPropertiesOrBuilderList() {
			return this.properties_;
		}

		public Value getResult() {
			return this.result_;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				int i = 0;
				while (i < this.properties_.size()) {
					size += CodedOutputStream.computeMessageSize(PROPERTIES_FIELD_NUMBER, (MessageLite) this.properties_.get(i));
					i++;
				}
				if ((this.bitField0_ & 1) == 1) {
					size += CodedOutputStream.computeMessageSize(RESULT_FIELD_NUMBER, this.result_);
				}
				if ((this.bitField0_ & 2) == 2) {
					size += CodedOutputStream.computeBytesSize(ASSOCIATED_RULE_NAME_FIELD_NUMBER, getAssociatedRuleNameBytes());
				}
				size += this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
		}

		public boolean hasAssociatedRuleName() {
			return (this.bitField0_ & 2) == 2;
		}

		public boolean hasResult() {
			return (this.bitField0_ & 1) == 1;
		}

		public int hashCode() {
			if (this.memoizedHashCode != 0) {
				return this.memoizedHashCode;
			} else {
				int hash = Debug.ResolvedFunctionCall.class.hashCode() + 779;
				if (getPropertiesCount() > 0) {
					hash = (((hash * 37) + 1) * 53) + getPropertiesList().hashCode();
				}
				if (hasResult()) {
					hash = (((hash * 37) + 2) * 53) + getResult().hashCode();
				}
				if (hasAssociatedRuleName()) {
					hash = (((hash * 37) + 3) * 53) + getAssociatedRuleName().hashCode();
				}
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$ResolvedFunctionCall");
			}
			return mutableDefault;
		}

		public final boolean isInitialized() {
			byte isInitialized = this.memoizedIsInitialized;
			if (isInitialized != (byte) -1) {
				return isInitialized == (byte) 1;
			} else {
				int i = 0;
				while (i < getPropertiesCount()) {
					if (!getProperties(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				if (!hasResult() || getResult().isInitialized()) {
					this.memoizedIsInitialized = (byte) 1;
					return true;
				} else {
					this.memoizedIsInitialized = (byte) 0;
					return false;
				}
			}
		}

		public Builder newBuilderForType() {
			return newBuilder();
		}

		public Builder toBuilder() {
			return newBuilder(this);
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeTo(CodedOutputStream output) throws IOException {
			getSerializedSize();
			int i = 0;
			while (i < this.properties_.size()) {
				output.writeMessage(PROPERTIES_FIELD_NUMBER, (MessageLite) this.properties_.get(i));
				i++;
			}
			if ((this.bitField0_ & 1) == 1) {
				output.writeMessage(RESULT_FIELD_NUMBER, this.result_);
			}
			if ((this.bitField0_ & 2) == 2) {
				output.writeBytes(ASSOCIATED_RULE_NAME_FIELD_NUMBER, getAssociatedRuleNameBytes());
			}
			output.writeRawBytes(this.unknownFields);
		}
	}

	public static interface ResolvedPropertyOrBuilder extends MessageLiteOrBuilder {
		public String getKey();

		public ByteString getKeyBytes();

		public Value getValue();

		public boolean hasKey();

		public boolean hasValue();
	}

	public static final class ResolvedProperty extends GeneratedMessageLite implements Debug.ResolvedPropertyOrBuilder {
		public static final int KEY_FIELD_NUMBER = 1;
		public static Parser<Debug.ResolvedProperty> PARSER = null;
		public static final int VALUE_FIELD_NUMBER = 2;
		private static final Debug.ResolvedProperty defaultInstance;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private Object key_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private final ByteString unknownFields;
		private Value value_;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Debug.ResolvedProperty, Debug.ResolvedProperty.Builder> implements Debug.ResolvedPropertyOrBuilder {
			private int bitField0_;
			private Object key_;
			private Value value_;

			private Builder() {
				this.key_ = "";
				this.value_ = Value.getDefaultInstance();
				maybeForceBuilderInitialization();
			}

			private static Debug.ResolvedProperty.Builder create() {
				return new Debug.ResolvedProperty.Builder();
			}

			private void maybeForceBuilderInitialization() {
			}

			public Debug.ResolvedProperty build() {
				Debug.ResolvedProperty result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Debug.ResolvedProperty buildPartial() {
				Debug.ResolvedProperty result = new Debug.ResolvedProperty((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
				int from_bitField0_ = this.bitField0_;
				int to_bitField0_ = 0;
				if ((from_bitField0_ & 1) == 1) {
					to_bitField0_ |= 1;
				}
				result.key_ = this.key_;
				if ((from_bitField0_ & 2) == 2) {
					to_bitField0_ |= 2;
				}
				result.value_ = this.value_;
				result.bitField0_ = to_bitField0_;
				return result;
			}

			public Debug.ResolvedProperty.Builder clear() {
				super.clear();
				this.key_ = "";
				this.bitField0_ &= -2;
				this.value_ = Value.getDefaultInstance();
				this.bitField0_ &= -3;
				return this;
			}

			public Debug.ResolvedProperty.Builder clearKey() {
				this.bitField0_ &= -2;
				this.key_ = Debug.ResolvedProperty.getDefaultInstance().getKey();
				return this;
			}

			public Debug.ResolvedProperty.Builder clearValue() {
				this.value_ = Value.getDefaultInstance();
				this.bitField0_ &= -3;
				return this;
			}

			public Debug.ResolvedProperty.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public Debug.ResolvedProperty getDefaultInstanceForType() {
				return Debug.ResolvedProperty.getDefaultInstance();
			}

			public String getKey() {
				Object ref = this.key_;
				if (!((ref instanceof String))) {
					ByteString bs = (ByteString) ref;
					String s = bs.toStringUtf8();
					if (bs.isValidUtf8()) {
						this.key_ = s;
						return s;
					}
					return s;
				} else {
					return (String) ref;
				}
			}

			public ByteString getKeyBytes() {
				Object ref = this.key_;
				if (ref instanceof String) {
					ByteString b = ByteString.copyFromUtf8((String) ref);
					this.key_ = b;
					return b;
				} else {
					return (ByteString) ref;
				}
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

			public final boolean isInitialized() {
				return !hasValue() || getValue().isInitialized();
			}

			public Debug.ResolvedProperty.Builder mergeFrom(Debug.ResolvedProperty other) {
				if (other == Debug.ResolvedProperty.getDefaultInstance()) {
					return this;
				} else {
					if (other.hasKey()) {
						this.bitField0_ |= 1;
						this.key_ = other.key_;
					}
					if (other.hasValue()) {
						mergeValue(other.getValue());
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Debug.ResolvedProperty.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Debug.ResolvedProperty parsedMessage;
				try {
					parsedMessage = (Debug.ResolvedProperty) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Debug.ResolvedProperty) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Debug.ResolvedProperty.Builder mergeValue(Value value) {
				if ((this.bitField0_ & 2) != 2 || this.value_ == Value.getDefaultInstance()) {
					this.value_ = value;
				} else {
					this.value_ = Value.newBuilder(this.value_).mergeFrom(value).buildPartial();
				}
				this.bitField0_ |= 2;
				return this;
			}

			public Debug.ResolvedProperty.Builder setKey(String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 1;
					this.key_ = value;
					return this;
				}
			}

			public Debug.ResolvedProperty.Builder setKeyBytes(ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 1;
					this.key_ = value;
					return this;
				}
			}

			public Debug.ResolvedProperty.Builder setValue(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builderForValue) {
				this.value_ = builderForValue.build();
				this.bitField0_ |= 2;
				return this;
			}

			public Debug.ResolvedProperty.Builder setValue(Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.value_ = value;
					this.bitField0_ |= 2;
					return this;
				}
			}
		}


		static {
			PARSER = new AbstractParser<Debug.ResolvedProperty>() {
			public Debug.ResolvedProperty parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Debug.ResolvedProperty(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Debug.ResolvedProperty(true);
			defaultInstance.initFields();
		}

		private ResolvedProperty(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			OutputStream unknownFieldsOutput;
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			initFields();
			unknownFieldsOutput = ByteString.newOutput();
			CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
			boolean done = false;
			while (!done) {
				int tag;
				try {
					tag = input.readTag();
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case Value.ESCAPING_FIELD_NUMBER:
						ByteString bs = input.readBytes();
						this.bitField0_ |= 1;
						this.key_ = bs;
						break;
					case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder subBuilder = null;
						if ((this.bitField0_ & 2) == 2) {
							subBuilder = this.value_.toBuilder();
						}
						this.value_ = (Value) input.readMessage(Value.PARSER, extensionRegistry);
						if (subBuilder != null) {
							subBuilder.mergeFrom(this.value_);
							this.value_ = subBuilder.buildPartial();
						}
						this.bitField0_ |= 2;
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				} catch (InvalidProtocolBufferException e) {
					throw e.setUnfinishedMessage(this);
				} catch (IOException e_2) {
					throw new InvalidProtocolBufferException(e_2.getMessage()).setUnfinishedMessage(this);
				} catch (Throwable th) {
					unknownFieldsCodedOutput.flush();
					this.unknownFields = unknownFieldsOutput.toByteString();
				}
			}
			try {
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
			} catch (IOException e_3) {
				this.unknownFields = unknownFieldsOutput.toByteString();
			}
			makeExtensionsImmutable();
		}

		private ResolvedProperty(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private ResolvedProperty(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Debug.ResolvedProperty getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.key_ = "";
			this.value_ = Value.getDefaultInstance();
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Debug.ResolvedProperty prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Debug.ResolvedProperty parseDelimitedFrom(InputStream input) throws IOException {
			return (Debug.ResolvedProperty) PARSER.parseDelimitedFrom(input);
		}

		public static Debug.ResolvedProperty parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.ResolvedProperty) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Debug.ResolvedProperty parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Debug.ResolvedProperty) PARSER.parseFrom(data);
		}

		public static Debug.ResolvedProperty parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Debug.ResolvedProperty) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Debug.ResolvedProperty parseFrom(CodedInputStream input) throws IOException {
			return (Debug.ResolvedProperty) PARSER.parseFrom(input);
		}

		public static Debug.ResolvedProperty parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.ResolvedProperty) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Debug.ResolvedProperty parseFrom(InputStream input) throws IOException {
			return (Debug.ResolvedProperty) PARSER.parseFrom(input);
		}

		public static Debug.ResolvedProperty parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.ResolvedProperty) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Debug.ResolvedProperty parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Debug.ResolvedProperty) PARSER.parseFrom(data);
		}

		public static Debug.ResolvedProperty parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Debug.ResolvedProperty) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Debug.ResolvedProperty))) {
				return super.equals(obj);
			} else {
				boolean result;
				Debug.ResolvedProperty other = (Debug.ResolvedProperty) obj;
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

		public Debug.ResolvedProperty getDefaultInstanceForType() {
			return defaultInstance;
		}

		public String getKey() {
			Object ref = this.key_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				ByteString bs = (ByteString) ref;
				String s = bs.toStringUtf8();
				if (bs.isValidUtf8()) {
					this.key_ = s;
				}
				return s;
			}
		}

		public ByteString getKeyBytes() {
			Object ref = this.key_;
			if (ref instanceof String) {
				ByteString b = ByteString.copyFromUtf8((String) ref);
				this.key_ = b;
				return b;
			} else {
				return (ByteString) ref;
			}
		}

		public Parser<Debug.ResolvedProperty> getParserForType() {
			return PARSER;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				if ((this.bitField0_ & 1) == 1) {
					size += CodedOutputStream.computeBytesSize(KEY_FIELD_NUMBER, getKeyBytes());
				}
				if ((this.bitField0_ & 2) == 2) {
					size += CodedOutputStream.computeMessageSize(VALUE_FIELD_NUMBER, this.value_);
				}
				size += this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
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
			if (this.memoizedHashCode != 0) {
				return this.memoizedHashCode;
			} else {
				int hash = Debug.ResolvedProperty.class.hashCode() + 779;
				if (hasKey()) {
					hash = (((hash * 37) + 1) * 53) + getKey().hashCode();
				}
				if (hasValue()) {
					hash = (((hash * 37) + 2) * 53) + getValue().hashCode();
				}
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$ResolvedProperty");
			}
			return mutableDefault;
		}

		public final boolean isInitialized() {
			byte isInitialized = this.memoizedIsInitialized;
			if (isInitialized != (byte) -1) {
				return isInitialized == (byte) 1;
			} else if (!hasValue() || getValue().isInitialized()) {
				this.memoizedIsInitialized = (byte) 1;
				return true;
			} else {
				this.memoizedIsInitialized = (byte) 0;
				return false;
			}
		}

		public Builder newBuilderForType() {
			return newBuilder();
		}

		public Builder toBuilder() {
			return newBuilder(this);
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeTo(CodedOutputStream output) throws IOException {
			getSerializedSize();
			if ((this.bitField0_ & 1) == 1) {
				output.writeBytes(KEY_FIELD_NUMBER, getKeyBytes());
			}
			if ((this.bitField0_ & 2) == 2) {
				output.writeMessage(VALUE_FIELD_NUMBER, this.value_);
			}
			output.writeRawBytes(this.unknownFields);
		}
	}

	public static interface ResolvedRuleOrBuilder extends MessageLiteOrBuilder {
		public Debug.ResolvedFunctionCall getAddMacros(int r1i);

		public int getAddMacrosCount();

		public List<Debug.ResolvedFunctionCall> getAddMacrosList();

		public Debug.ResolvedFunctionCall getAddTags(int r1i);

		public int getAddTagsCount();

		public List<Debug.ResolvedFunctionCall> getAddTagsList();

		public Debug.ResolvedFunctionCall getNegativePredicates(int r1i);

		public int getNegativePredicatesCount();

		public List<Debug.ResolvedFunctionCall> getNegativePredicatesList();

		public Debug.ResolvedFunctionCall getPositivePredicates(int r1i);

		public int getPositivePredicatesCount();

		public List<Debug.ResolvedFunctionCall> getPositivePredicatesList();

		public Debug.ResolvedFunctionCall getRemoveMacros(int r1i);

		public int getRemoveMacrosCount();

		public List<Debug.ResolvedFunctionCall> getRemoveMacrosList();

		public Debug.ResolvedFunctionCall getRemoveTags(int r1i);

		public int getRemoveTagsCount();

		public List<Debug.ResolvedFunctionCall> getRemoveTagsList();

		public Value getResult();

		public boolean hasResult();
	}

	public static final class ResolvedRule extends GeneratedMessageLite implements Debug.ResolvedRuleOrBuilder {
		public static final int ADD_MACROS_FIELD_NUMBER = 5;
		public static final int ADD_TAGS_FIELD_NUMBER = 3;
		public static final int NEGATIVE_PREDICATES_FIELD_NUMBER = 2;
		public static Parser<Debug.ResolvedRule> PARSER = null;
		public static final int POSITIVE_PREDICATES_FIELD_NUMBER = 1;
		public static final int REMOVE_MACROS_FIELD_NUMBER = 6;
		public static final int REMOVE_TAGS_FIELD_NUMBER = 4;
		public static final int RESULT_FIELD_NUMBER = 7;
		private static final Debug.ResolvedRule defaultInstance;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private List<Debug.ResolvedFunctionCall> addMacros_;
		private List<Debug.ResolvedFunctionCall> addTags_;
		private int bitField0_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private List<Debug.ResolvedFunctionCall> negativePredicates_;
		private List<Debug.ResolvedFunctionCall> positivePredicates_;
		private List<Debug.ResolvedFunctionCall> removeMacros_;
		private List<Debug.ResolvedFunctionCall> removeTags_;
		private Value result_;
		private final ByteString unknownFields;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Debug.ResolvedRule, Debug.ResolvedRule.Builder> implements Debug.ResolvedRuleOrBuilder {
			private List<Debug.ResolvedFunctionCall> addMacros_;
			private List<Debug.ResolvedFunctionCall> addTags_;
			private int bitField0_;
			private List<Debug.ResolvedFunctionCall> negativePredicates_;
			private List<Debug.ResolvedFunctionCall> positivePredicates_;
			private List<Debug.ResolvedFunctionCall> removeMacros_;
			private List<Debug.ResolvedFunctionCall> removeTags_;
			private Value result_;

			private Builder() {
				this.positivePredicates_ = Collections.emptyList();
				this.negativePredicates_ = Collections.emptyList();
				this.addTags_ = Collections.emptyList();
				this.removeTags_ = Collections.emptyList();
				this.addMacros_ = Collections.emptyList();
				this.removeMacros_ = Collections.emptyList();
				this.result_ = Value.getDefaultInstance();
				maybeForceBuilderInitialization();
			}

			private static Debug.ResolvedRule.Builder create() {
				return new Debug.ResolvedRule.Builder();
			}

			private void ensureAddMacrosIsMutable() {
				if ((this.bitField0_ & 16) != 16) {
					this.addMacros_ = new ArrayList(this.addMacros_);
					this.bitField0_ |= 16;
				}
			}

			private void ensureAddTagsIsMutable() {
				if ((this.bitField0_ & 4) != 4) {
					this.addTags_ = new ArrayList(this.addTags_);
					this.bitField0_ |= 4;
				}
			}

			private void ensureNegativePredicatesIsMutable() {
				if ((this.bitField0_ & 2) != 2) {
					this.negativePredicates_ = new ArrayList(this.negativePredicates_);
					this.bitField0_ |= 2;
				}
			}

			private void ensurePositivePredicatesIsMutable() {
				if ((this.bitField0_ & 1) != 1) {
					this.positivePredicates_ = new ArrayList(this.positivePredicates_);
					this.bitField0_ |= 1;
				}
			}

			private void ensureRemoveMacrosIsMutable() {
				if ((this.bitField0_ & 32) != 32) {
					this.removeMacros_ = new ArrayList(this.removeMacros_);
					this.bitField0_ |= 32;
				}
			}

			private void ensureRemoveTagsIsMutable() {
				if ((this.bitField0_ & 8) != 8) {
					this.removeTags_ = new ArrayList(this.removeTags_);
					this.bitField0_ |= 8;
				}
			}

			private void maybeForceBuilderInitialization() {
			}

			public Debug.ResolvedRule.Builder addAddMacros(int index, Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureAddMacrosIsMutable();
				this.addMacros_.add(index, builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder addAddMacros(int index, Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureAddMacrosIsMutable();
					this.addMacros_.add(index, value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder addAddMacros(Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureAddMacrosIsMutable();
				this.addMacros_.add(builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder addAddMacros(Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureAddMacrosIsMutable();
					this.addMacros_.add(value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder addAddTags(int index, Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureAddTagsIsMutable();
				this.addTags_.add(index, builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder addAddTags(int index, Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureAddTagsIsMutable();
					this.addTags_.add(index, value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder addAddTags(Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureAddTagsIsMutable();
				this.addTags_.add(builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder addAddTags(Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureAddTagsIsMutable();
					this.addTags_.add(value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder addAllAddMacros(Iterable<Debug.ResolvedFunctionCall> values) {
				ensureAddMacrosIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.addMacros_);
				return this;
			}

			public Debug.ResolvedRule.Builder addAllAddTags(Iterable<Debug.ResolvedFunctionCall> values) {
				ensureAddTagsIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.addTags_);
				return this;
			}

			public Debug.ResolvedRule.Builder addAllNegativePredicates(Iterable<Debug.ResolvedFunctionCall> values) {
				ensureNegativePredicatesIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.negativePredicates_);
				return this;
			}

			public Debug.ResolvedRule.Builder addAllPositivePredicates(Iterable<Debug.ResolvedFunctionCall> values) {
				ensurePositivePredicatesIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.positivePredicates_);
				return this;
			}

			public Debug.ResolvedRule.Builder addAllRemoveMacros(Iterable<Debug.ResolvedFunctionCall> values) {
				ensureRemoveMacrosIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.removeMacros_);
				return this;
			}

			public Debug.ResolvedRule.Builder addAllRemoveTags(Iterable<Debug.ResolvedFunctionCall> values) {
				ensureRemoveTagsIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.removeTags_);
				return this;
			}

			public Debug.ResolvedRule.Builder addNegativePredicates(int index, Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureNegativePredicatesIsMutable();
				this.negativePredicates_.add(index, builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder addNegativePredicates(int index, Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureNegativePredicatesIsMutable();
					this.negativePredicates_.add(index, value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder addNegativePredicates(Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureNegativePredicatesIsMutable();
				this.negativePredicates_.add(builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder addNegativePredicates(Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureNegativePredicatesIsMutable();
					this.negativePredicates_.add(value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder addPositivePredicates(int index, Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensurePositivePredicatesIsMutable();
				this.positivePredicates_.add(index, builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder addPositivePredicates(int index, Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensurePositivePredicatesIsMutable();
					this.positivePredicates_.add(index, value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder addPositivePredicates(Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensurePositivePredicatesIsMutable();
				this.positivePredicates_.add(builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder addPositivePredicates(Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensurePositivePredicatesIsMutable();
					this.positivePredicates_.add(value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder addRemoveMacros(int index, Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureRemoveMacrosIsMutable();
				this.removeMacros_.add(index, builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder addRemoveMacros(int index, Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureRemoveMacrosIsMutable();
					this.removeMacros_.add(index, value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder addRemoveMacros(Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureRemoveMacrosIsMutable();
				this.removeMacros_.add(builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder addRemoveMacros(Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureRemoveMacrosIsMutable();
					this.removeMacros_.add(value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder addRemoveTags(int index, Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureRemoveTagsIsMutable();
				this.removeTags_.add(index, builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder addRemoveTags(int index, Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureRemoveTagsIsMutable();
					this.removeTags_.add(index, value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder addRemoveTags(Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureRemoveTagsIsMutable();
				this.removeTags_.add(builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder addRemoveTags(Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureRemoveTagsIsMutable();
					this.removeTags_.add(value);
					return this;
				}
			}

			public Debug.ResolvedRule build() {
				Debug.ResolvedRule result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Debug.ResolvedRule buildPartial() {
				Debug.ResolvedRule result = new Debug.ResolvedRule((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
				int from_bitField0_ = this.bitField0_;
				int to_bitField0_ = 0;
				if ((this.bitField0_ & 1) == 1) {
					this.positivePredicates_ = Collections.unmodifiableList(this.positivePredicates_);
					this.bitField0_ &= -2;
				}
				result.positivePredicates_ = this.positivePredicates_;
				if ((this.bitField0_ & 2) == 2) {
					this.negativePredicates_ = Collections.unmodifiableList(this.negativePredicates_);
					this.bitField0_ &= -3;
				}
				result.negativePredicates_ = this.negativePredicates_;
				if ((this.bitField0_ & 4) == 4) {
					this.addTags_ = Collections.unmodifiableList(this.addTags_);
					this.bitField0_ &= -5;
				}
				result.addTags_ = this.addTags_;
				if ((this.bitField0_ & 8) == 8) {
					this.removeTags_ = Collections.unmodifiableList(this.removeTags_);
					this.bitField0_ &= -9;
				}
				result.removeTags_ = this.removeTags_;
				if ((this.bitField0_ & 16) == 16) {
					this.addMacros_ = Collections.unmodifiableList(this.addMacros_);
					this.bitField0_ &= -17;
				}
				result.addMacros_ = this.addMacros_;
				if ((this.bitField0_ & 32) == 32) {
					this.removeMacros_ = Collections.unmodifiableList(this.removeMacros_);
					this.bitField0_ &= -33;
				}
				result.removeMacros_ = this.removeMacros_;
				if ((from_bitField0_ & 64) == 64) {
					to_bitField0_ |= 1;
				}
				result.result_ = this.result_;
				result.bitField0_ = to_bitField0_;
				return result;
			}

			public Debug.ResolvedRule.Builder clear() {
				super.clear();
				this.positivePredicates_ = Collections.emptyList();
				this.bitField0_ &= -2;
				this.negativePredicates_ = Collections.emptyList();
				this.bitField0_ &= -3;
				this.addTags_ = Collections.emptyList();
				this.bitField0_ &= -5;
				this.removeTags_ = Collections.emptyList();
				this.bitField0_ &= -9;
				this.addMacros_ = Collections.emptyList();
				this.bitField0_ &= -17;
				this.removeMacros_ = Collections.emptyList();
				this.bitField0_ &= -33;
				this.result_ = Value.getDefaultInstance();
				this.bitField0_ &= -65;
				return this;
			}

			public Debug.ResolvedRule.Builder clearAddMacros() {
				this.addMacros_ = Collections.emptyList();
				this.bitField0_ &= -17;
				return this;
			}

			public Debug.ResolvedRule.Builder clearAddTags() {
				this.addTags_ = Collections.emptyList();
				this.bitField0_ &= -5;
				return this;
			}

			public Debug.ResolvedRule.Builder clearNegativePredicates() {
				this.negativePredicates_ = Collections.emptyList();
				this.bitField0_ &= -3;
				return this;
			}

			public Debug.ResolvedRule.Builder clearPositivePredicates() {
				this.positivePredicates_ = Collections.emptyList();
				this.bitField0_ &= -2;
				return this;
			}

			public Debug.ResolvedRule.Builder clearRemoveMacros() {
				this.removeMacros_ = Collections.emptyList();
				this.bitField0_ &= -33;
				return this;
			}

			public Debug.ResolvedRule.Builder clearRemoveTags() {
				this.removeTags_ = Collections.emptyList();
				this.bitField0_ &= -9;
				return this;
			}

			public Debug.ResolvedRule.Builder clearResult() {
				this.result_ = Value.getDefaultInstance();
				this.bitField0_ &= -65;
				return this;
			}

			public Debug.ResolvedRule.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public Debug.ResolvedFunctionCall getAddMacros(int index) {
				return (Debug.ResolvedFunctionCall) this.addMacros_.get(index);
			}

			public int getAddMacrosCount() {
				return this.addMacros_.size();
			}

			public List<Debug.ResolvedFunctionCall> getAddMacrosList() {
				return Collections.unmodifiableList(this.addMacros_);
			}

			public Debug.ResolvedFunctionCall getAddTags(int index) {
				return (Debug.ResolvedFunctionCall) this.addTags_.get(index);
			}

			public int getAddTagsCount() {
				return this.addTags_.size();
			}

			public List<Debug.ResolvedFunctionCall> getAddTagsList() {
				return Collections.unmodifiableList(this.addTags_);
			}

			public Debug.ResolvedRule getDefaultInstanceForType() {
				return Debug.ResolvedRule.getDefaultInstance();
			}

			public Debug.ResolvedFunctionCall getNegativePredicates(int index) {
				return (Debug.ResolvedFunctionCall) this.negativePredicates_.get(index);
			}

			public int getNegativePredicatesCount() {
				return this.negativePredicates_.size();
			}

			public List<Debug.ResolvedFunctionCall> getNegativePredicatesList() {
				return Collections.unmodifiableList(this.negativePredicates_);
			}

			public Debug.ResolvedFunctionCall getPositivePredicates(int index) {
				return (Debug.ResolvedFunctionCall) this.positivePredicates_.get(index);
			}

			public int getPositivePredicatesCount() {
				return this.positivePredicates_.size();
			}

			public List<Debug.ResolvedFunctionCall> getPositivePredicatesList() {
				return Collections.unmodifiableList(this.positivePredicates_);
			}

			public Debug.ResolvedFunctionCall getRemoveMacros(int index) {
				return (Debug.ResolvedFunctionCall) this.removeMacros_.get(index);
			}

			public int getRemoveMacrosCount() {
				return this.removeMacros_.size();
			}

			public List<Debug.ResolvedFunctionCall> getRemoveMacrosList() {
				return Collections.unmodifiableList(this.removeMacros_);
			}

			public Debug.ResolvedFunctionCall getRemoveTags(int index) {
				return (Debug.ResolvedFunctionCall) this.removeTags_.get(index);
			}

			public int getRemoveTagsCount() {
				return this.removeTags_.size();
			}

			public List<Debug.ResolvedFunctionCall> getRemoveTagsList() {
				return Collections.unmodifiableList(this.removeTags_);
			}

			public Value getResult() {
				return this.result_;
			}

			public boolean hasResult() {
				return (this.bitField0_ & 64) == 64;
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

			public Debug.ResolvedRule.Builder mergeFrom(Debug.ResolvedRule other) {
				if (other == Debug.ResolvedRule.getDefaultInstance()) {
					return this;
				} else {
					if (!other.positivePredicates_.isEmpty()) {
						if (this.positivePredicates_.isEmpty()) {
							this.positivePredicates_ = other.positivePredicates_;
							this.bitField0_ &= -2;
						} else {
							ensurePositivePredicatesIsMutable();
							this.positivePredicates_.addAll(other.positivePredicates_);
						}
					}
					if (!other.negativePredicates_.isEmpty()) {
						if (this.negativePredicates_.isEmpty()) {
							this.negativePredicates_ = other.negativePredicates_;
							this.bitField0_ &= -3;
						} else {
							ensureNegativePredicatesIsMutable();
							this.negativePredicates_.addAll(other.negativePredicates_);
						}
					}
					if (!other.addTags_.isEmpty()) {
						if (this.addTags_.isEmpty()) {
							this.addTags_ = other.addTags_;
							this.bitField0_ &= -5;
						} else {
							ensureAddTagsIsMutable();
							this.addTags_.addAll(other.addTags_);
						}
					}
					if (!other.removeTags_.isEmpty()) {
						if (this.removeTags_.isEmpty()) {
							this.removeTags_ = other.removeTags_;
							this.bitField0_ &= -9;
						} else {
							ensureRemoveTagsIsMutable();
							this.removeTags_.addAll(other.removeTags_);
						}
					}
					if (!other.addMacros_.isEmpty()) {
						if (this.addMacros_.isEmpty()) {
							this.addMacros_ = other.addMacros_;
							this.bitField0_ &= -17;
						} else {
							ensureAddMacrosIsMutable();
							this.addMacros_.addAll(other.addMacros_);
						}
					}
					if (!other.removeMacros_.isEmpty()) {
						if (this.removeMacros_.isEmpty()) {
							this.removeMacros_ = other.removeMacros_;
							this.bitField0_ &= -33;
						} else {
							ensureRemoveMacrosIsMutable();
							this.removeMacros_.addAll(other.removeMacros_);
						}
					}
					if (other.hasResult()) {
						mergeResult(other.getResult());
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Debug.ResolvedRule.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Debug.ResolvedRule parsedMessage;
				try {
					parsedMessage = (Debug.ResolvedRule) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Debug.ResolvedRule) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Debug.ResolvedRule.Builder mergeResult(Value value) {
				if ((this.bitField0_ & 64) != 64 || this.result_ == Value.getDefaultInstance()) {
					this.result_ = value;
				} else {
					this.result_ = Value.newBuilder(this.result_).mergeFrom(value).buildPartial();
				}
				this.bitField0_ |= 64;
				return this;
			}

			public Debug.ResolvedRule.Builder removeAddMacros(int index) {
				ensureAddMacrosIsMutable();
				this.addMacros_.remove(index);
				return this;
			}

			public Debug.ResolvedRule.Builder removeAddTags(int index) {
				ensureAddTagsIsMutable();
				this.addTags_.remove(index);
				return this;
			}

			public Debug.ResolvedRule.Builder removeNegativePredicates(int index) {
				ensureNegativePredicatesIsMutable();
				this.negativePredicates_.remove(index);
				return this;
			}

			public Debug.ResolvedRule.Builder removePositivePredicates(int index) {
				ensurePositivePredicatesIsMutable();
				this.positivePredicates_.remove(index);
				return this;
			}

			public Debug.ResolvedRule.Builder removeRemoveMacros(int index) {
				ensureRemoveMacrosIsMutable();
				this.removeMacros_.remove(index);
				return this;
			}

			public Debug.ResolvedRule.Builder removeRemoveTags(int index) {
				ensureRemoveTagsIsMutable();
				this.removeTags_.remove(index);
				return this;
			}

			public Debug.ResolvedRule.Builder setAddMacros(int index, Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureAddMacrosIsMutable();
				this.addMacros_.set(index, builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder setAddMacros(int index, Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureAddMacrosIsMutable();
					this.addMacros_.set(index, value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder setAddTags(int index, Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureAddTagsIsMutable();
				this.addTags_.set(index, builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder setAddTags(int index, Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureAddTagsIsMutable();
					this.addTags_.set(index, value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder setNegativePredicates(int index, Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureNegativePredicatesIsMutable();
				this.negativePredicates_.set(index, builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder setNegativePredicates(int index, Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureNegativePredicatesIsMutable();
					this.negativePredicates_.set(index, value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder setPositivePredicates(int index, Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensurePositivePredicatesIsMutable();
				this.positivePredicates_.set(index, builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder setPositivePredicates(int index, Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensurePositivePredicatesIsMutable();
					this.positivePredicates_.set(index, value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder setRemoveMacros(int index, Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureRemoveMacrosIsMutable();
				this.removeMacros_.set(index, builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder setRemoveMacros(int index, Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureRemoveMacrosIsMutable();
					this.removeMacros_.set(index, value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder setRemoveTags(int index, Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureRemoveTagsIsMutable();
				this.removeTags_.set(index, builderForValue.build());
				return this;
			}

			public Debug.ResolvedRule.Builder setRemoveTags(int index, Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureRemoveTagsIsMutable();
					this.removeTags_.set(index, value);
					return this;
				}
			}

			public Debug.ResolvedRule.Builder setResult(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builderForValue) {
				this.result_ = builderForValue.build();
				this.bitField0_ |= 64;
				return this;
			}

			public Debug.ResolvedRule.Builder setResult(Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.result_ = value;
					this.bitField0_ |= 64;
					return this;
				}
			}
		}


		static {
			PARSER = new AbstractParser<Debug.ResolvedRule>() {
			public Debug.ResolvedRule parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Debug.ResolvedRule(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Debug.ResolvedRule(true);
			defaultInstance.initFields();
		}

		private ResolvedRule(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			OutputStream unknownFieldsOutput;
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			initFields();
			int mutable_bitField0_ = 0;
			unknownFieldsOutput = ByteString.newOutput();
			CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
			boolean done = false;
			while (!done) {
				int tag;
				try {
					tag = input.readTag();
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case Value.ESCAPING_FIELD_NUMBER:
						if ((mutable_bitField0_ & 1) != 1) {
							this.positivePredicates_ = new ArrayList();
							mutable_bitField0_ |= 1;
						}
						this.positivePredicates_.add(input.readMessage(Debug.ResolvedFunctionCall.PARSER, extensionRegistry));
						break;
					case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						if ((mutable_bitField0_ & 2) != 2) {
							this.negativePredicates_ = new ArrayList();
							mutable_bitField0_ |= 2;
						}
						this.negativePredicates_.add(input.readMessage(Debug.ResolvedFunctionCall.PARSER, extensionRegistry));
						break;
					case 26:
						if ((mutable_bitField0_ & 4) != 4) {
							this.addTags_ = new ArrayList();
							mutable_bitField0_ |= 4;
						}
						this.addTags_.add(input.readMessage(Debug.ResolvedFunctionCall.PARSER, extensionRegistry));
						break;
					case 34:
						if ((mutable_bitField0_ & 8) != 8) {
							this.removeTags_ = new ArrayList();
							mutable_bitField0_ |= 8;
						}
						this.removeTags_.add(input.readMessage(Debug.ResolvedFunctionCall.PARSER, extensionRegistry));
						break;
					case 42:
						if ((mutable_bitField0_ & 16) != 16) {
							this.addMacros_ = new ArrayList();
							mutable_bitField0_ |= 16;
						}
						this.addMacros_.add(input.readMessage(Debug.ResolvedFunctionCall.PARSER, extensionRegistry));
						break;
					case 50:
						if ((mutable_bitField0_ & 32) != 32) {
							this.removeMacros_ = new ArrayList();
							mutable_bitField0_ |= 32;
						}
						this.removeMacros_.add(input.readMessage(Debug.ResolvedFunctionCall.PARSER, extensionRegistry));
						break;
					case 58:
						com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder subBuilder = null;
						if ((this.bitField0_ & 1) == 1) {
							subBuilder = this.result_.toBuilder();
						}
						this.result_ = (Value) input.readMessage(Value.PARSER, extensionRegistry);
						if (subBuilder != null) {
							subBuilder.mergeFrom(this.result_);
							this.result_ = subBuilder.buildPartial();
						}
						this.bitField0_ |= 1;
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				} catch (InvalidProtocolBufferException e) {
					throw e.setUnfinishedMessage(this);
				} catch (IOException e_2) {
					throw new InvalidProtocolBufferException(e_2.getMessage()).setUnfinishedMessage(this);
				} catch (Throwable th) {
					if ((mutable_bitField0_ & 1) == 1) {
						this.positivePredicates_ = Collections.unmodifiableList(this.positivePredicates_);
					}
					if ((mutable_bitField0_ & 2) == 2) {
						this.negativePredicates_ = Collections.unmodifiableList(this.negativePredicates_);
					}
					if ((mutable_bitField0_ & 4) == 4) {
						this.addTags_ = Collections.unmodifiableList(this.addTags_);
					}
					if ((mutable_bitField0_ & 8) == 8) {
						this.removeTags_ = Collections.unmodifiableList(this.removeTags_);
					}
					if ((mutable_bitField0_ & 16) == 16) {
						this.addMacros_ = Collections.unmodifiableList(this.addMacros_);
					}
					if ((mutable_bitField0_ & 32) == 32) {
						this.removeMacros_ = Collections.unmodifiableList(this.removeMacros_);
					}
					unknownFieldsCodedOutput.flush();
					this.unknownFields = unknownFieldsOutput.toByteString();
				}
			}
			if ((mutable_bitField0_ & 1) == 1) {
				this.positivePredicates_ = Collections.unmodifiableList(this.positivePredicates_);
			}
			if ((mutable_bitField0_ & 2) == 2) {
				this.negativePredicates_ = Collections.unmodifiableList(this.negativePredicates_);
			}
			if ((mutable_bitField0_ & 4) == 4) {
				this.addTags_ = Collections.unmodifiableList(this.addTags_);
			}
			if ((mutable_bitField0_ & 8) == 8) {
				this.removeTags_ = Collections.unmodifiableList(this.removeTags_);
			}
			if ((mutable_bitField0_ & 16) == 16) {
				this.addMacros_ = Collections.unmodifiableList(this.addMacros_);
			}
			if ((mutable_bitField0_ & 32) == 32) {
				this.removeMacros_ = Collections.unmodifiableList(this.removeMacros_);
			}
			try {
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
			} catch (IOException e_3) {
				this.unknownFields = unknownFieldsOutput.toByteString();
			}
			makeExtensionsImmutable();
		}

		private ResolvedRule(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private ResolvedRule(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Debug.ResolvedRule getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.positivePredicates_ = Collections.emptyList();
			this.negativePredicates_ = Collections.emptyList();
			this.addTags_ = Collections.emptyList();
			this.removeTags_ = Collections.emptyList();
			this.addMacros_ = Collections.emptyList();
			this.removeMacros_ = Collections.emptyList();
			this.result_ = Value.getDefaultInstance();
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Debug.ResolvedRule prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Debug.ResolvedRule parseDelimitedFrom(InputStream input) throws IOException {
			return (Debug.ResolvedRule) PARSER.parseDelimitedFrom(input);
		}

		public static Debug.ResolvedRule parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.ResolvedRule) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Debug.ResolvedRule parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Debug.ResolvedRule) PARSER.parseFrom(data);
		}

		public static Debug.ResolvedRule parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Debug.ResolvedRule) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Debug.ResolvedRule parseFrom(CodedInputStream input) throws IOException {
			return (Debug.ResolvedRule) PARSER.parseFrom(input);
		}

		public static Debug.ResolvedRule parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.ResolvedRule) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Debug.ResolvedRule parseFrom(InputStream input) throws IOException {
			return (Debug.ResolvedRule) PARSER.parseFrom(input);
		}

		public static Debug.ResolvedRule parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.ResolvedRule) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Debug.ResolvedRule parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Debug.ResolvedRule) PARSER.parseFrom(data);
		}

		public static Debug.ResolvedRule parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Debug.ResolvedRule) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Debug.ResolvedRule))) {
				return super.equals(obj);
			} else {
				boolean result;
				Debug.ResolvedRule other = (Debug.ResolvedRule) obj;
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

		public Debug.ResolvedFunctionCall getAddMacros(int index) {
			return (Debug.ResolvedFunctionCall) this.addMacros_.get(index);
		}

		public int getAddMacrosCount() {
			return this.addMacros_.size();
		}

		public List<Debug.ResolvedFunctionCall> getAddMacrosList() {
			return this.addMacros_;
		}

		public Debug.ResolvedFunctionCallOrBuilder getAddMacrosOrBuilder(int index) {
			return (Debug.ResolvedFunctionCallOrBuilder) this.addMacros_.get(index);
		}

		public List<Debug.ResolvedFunctionCallOrBuilder> getAddMacrosOrBuilderList() {
			return this.addMacros_;
		}

		public Debug.ResolvedFunctionCall getAddTags(int index) {
			return (Debug.ResolvedFunctionCall) this.addTags_.get(index);
		}

		public int getAddTagsCount() {
			return this.addTags_.size();
		}

		public List<Debug.ResolvedFunctionCall> getAddTagsList() {
			return this.addTags_;
		}

		public Debug.ResolvedFunctionCallOrBuilder getAddTagsOrBuilder(int index) {
			return (Debug.ResolvedFunctionCallOrBuilder) this.addTags_.get(index);
		}

		public List<Debug.ResolvedFunctionCallOrBuilder> getAddTagsOrBuilderList() {
			return this.addTags_;
		}

		public Debug.ResolvedRule getDefaultInstanceForType() {
			return defaultInstance;
		}

		public Debug.ResolvedFunctionCall getNegativePredicates(int index) {
			return (Debug.ResolvedFunctionCall) this.negativePredicates_.get(index);
		}

		public int getNegativePredicatesCount() {
			return this.negativePredicates_.size();
		}

		public List<Debug.ResolvedFunctionCall> getNegativePredicatesList() {
			return this.negativePredicates_;
		}

		public Debug.ResolvedFunctionCallOrBuilder getNegativePredicatesOrBuilder(int index) {
			return (Debug.ResolvedFunctionCallOrBuilder) this.negativePredicates_.get(index);
		}

		public List<Debug.ResolvedFunctionCallOrBuilder> getNegativePredicatesOrBuilderList() {
			return this.negativePredicates_;
		}

		public Parser<Debug.ResolvedRule> getParserForType() {
			return PARSER;
		}

		public Debug.ResolvedFunctionCall getPositivePredicates(int index) {
			return (Debug.ResolvedFunctionCall) this.positivePredicates_.get(index);
		}

		public int getPositivePredicatesCount() {
			return this.positivePredicates_.size();
		}

		public List<Debug.ResolvedFunctionCall> getPositivePredicatesList() {
			return this.positivePredicates_;
		}

		public Debug.ResolvedFunctionCallOrBuilder getPositivePredicatesOrBuilder(int index) {
			return (Debug.ResolvedFunctionCallOrBuilder) this.positivePredicates_.get(index);
		}

		public List<Debug.ResolvedFunctionCallOrBuilder> getPositivePredicatesOrBuilderList() {
			return this.positivePredicates_;
		}

		public Debug.ResolvedFunctionCall getRemoveMacros(int index) {
			return (Debug.ResolvedFunctionCall) this.removeMacros_.get(index);
		}

		public int getRemoveMacrosCount() {
			return this.removeMacros_.size();
		}

		public List<Debug.ResolvedFunctionCall> getRemoveMacrosList() {
			return this.removeMacros_;
		}

		public Debug.ResolvedFunctionCallOrBuilder getRemoveMacrosOrBuilder(int index) {
			return (Debug.ResolvedFunctionCallOrBuilder) this.removeMacros_.get(index);
		}

		public List<Debug.ResolvedFunctionCallOrBuilder> getRemoveMacrosOrBuilderList() {
			return this.removeMacros_;
		}

		public Debug.ResolvedFunctionCall getRemoveTags(int index) {
			return (Debug.ResolvedFunctionCall) this.removeTags_.get(index);
		}

		public int getRemoveTagsCount() {
			return this.removeTags_.size();
		}

		public List<Debug.ResolvedFunctionCall> getRemoveTagsList() {
			return this.removeTags_;
		}

		public Debug.ResolvedFunctionCallOrBuilder getRemoveTagsOrBuilder(int index) {
			return (Debug.ResolvedFunctionCallOrBuilder) this.removeTags_.get(index);
		}

		public List<Debug.ResolvedFunctionCallOrBuilder> getRemoveTagsOrBuilderList() {
			return this.removeTags_;
		}

		public Value getResult() {
			return this.result_;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				int i = 0;
				while (i < this.positivePredicates_.size()) {
					size += CodedOutputStream.computeMessageSize(POSITIVE_PREDICATES_FIELD_NUMBER, (MessageLite) this.positivePredicates_.get(i));
					i++;
				}
				i = 0;
				while (i < this.negativePredicates_.size()) {
					size += CodedOutputStream.computeMessageSize(NEGATIVE_PREDICATES_FIELD_NUMBER, (MessageLite) this.negativePredicates_.get(i));
					i++;
				}
				i = 0;
				while (i < this.addTags_.size()) {
					size += CodedOutputStream.computeMessageSize(ADD_TAGS_FIELD_NUMBER, (MessageLite) this.addTags_.get(i));
					i++;
				}
				i = 0;
				while (i < this.removeTags_.size()) {
					size += CodedOutputStream.computeMessageSize(REMOVE_TAGS_FIELD_NUMBER, (MessageLite) this.removeTags_.get(i));
					i++;
				}
				i = 0;
				while (i < this.addMacros_.size()) {
					size += CodedOutputStream.computeMessageSize(ADD_MACROS_FIELD_NUMBER, (MessageLite) this.addMacros_.get(i));
					i++;
				}
				i = 0;
				while (i < this.removeMacros_.size()) {
					size += CodedOutputStream.computeMessageSize(REMOVE_MACROS_FIELD_NUMBER, (MessageLite) this.removeMacros_.get(i));
					i++;
				}
				if ((this.bitField0_ & 1) == 1) {
					size += CodedOutputStream.computeMessageSize(RESULT_FIELD_NUMBER, this.result_);
				}
				size += this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
		}

		public boolean hasResult() {
			return (this.bitField0_ & 1) == 1;
		}

		public int hashCode() {
			if (this.memoizedHashCode != 0) {
				return this.memoizedHashCode;
			} else {
				int hash = Debug.ResolvedRule.class.hashCode() + 779;
				if (getPositivePredicatesCount() > 0) {
					hash = (((hash * 37) + 1) * 53) + getPositivePredicatesList().hashCode();
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
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$ResolvedRule");
			}
			return mutableDefault;
		}

		public final boolean isInitialized() {
			boolean r2z = true;
			byte isInitialized = this.memoizedIsInitialized;
			if (isInitialized != (byte) -1) {
				if (isInitialized == (byte) 1) {
					return r2z;
				} else {
					r2z = false;
					return r2z;
				}
			} else {
				int i = 0;
				while (i < getPositivePredicatesCount()) {
					if (!getPositivePredicates(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				i = 0;
				while (i < getNegativePredicatesCount()) {
					if (!getNegativePredicates(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				i = 0;
				while (i < getAddTagsCount()) {
					if (!getAddTags(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				i = 0;
				while (i < getRemoveTagsCount()) {
					if (!getRemoveTags(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				i = 0;
				while (i < getAddMacrosCount()) {
					if (!getAddMacros(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				i = 0;
				while (i < getRemoveMacrosCount()) {
					if (!getRemoveMacros(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				if (!hasResult() || getResult().isInitialized()) {
					this.memoizedIsInitialized = (byte) 1;
					return true;
				} else {
					this.memoizedIsInitialized = (byte) 0;
					return false;
				}
			}
		}

		public Builder newBuilderForType() {
			return newBuilder();
		}

		public Builder toBuilder() {
			return newBuilder(this);
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeTo(CodedOutputStream output) throws IOException {
			getSerializedSize();
			int i = 0;
			while (i < this.positivePredicates_.size()) {
				output.writeMessage(POSITIVE_PREDICATES_FIELD_NUMBER, (MessageLite) this.positivePredicates_.get(i));
				i++;
			}
			i = 0;
			while (i < this.negativePredicates_.size()) {
				output.writeMessage(NEGATIVE_PREDICATES_FIELD_NUMBER, (MessageLite) this.negativePredicates_.get(i));
				i++;
			}
			i = 0;
			while (i < this.addTags_.size()) {
				output.writeMessage(ADD_TAGS_FIELD_NUMBER, (MessageLite) this.addTags_.get(i));
				i++;
			}
			i = 0;
			while (i < this.removeTags_.size()) {
				output.writeMessage(REMOVE_TAGS_FIELD_NUMBER, (MessageLite) this.removeTags_.get(i));
				i++;
			}
			i = 0;
			while (i < this.addMacros_.size()) {
				output.writeMessage(ADD_MACROS_FIELD_NUMBER, (MessageLite) this.addMacros_.get(i));
				i++;
			}
			i = 0;
			while (i < this.removeMacros_.size()) {
				output.writeMessage(REMOVE_MACROS_FIELD_NUMBER, (MessageLite) this.removeMacros_.get(i));
				i++;
			}
			if ((this.bitField0_ & 1) == 1) {
				output.writeMessage(RESULT_FIELD_NUMBER, this.result_);
			}
			output.writeRawBytes(this.unknownFields);
		}
	}

	public static interface RuleEvaluationStepInfoOrBuilder extends MessageLiteOrBuilder {
		public Debug.ResolvedFunctionCall getEnabledFunctions(int r1i);

		public int getEnabledFunctionsCount();

		public List<Debug.ResolvedFunctionCall> getEnabledFunctionsList();

		public Debug.ResolvedRule getRules(int r1i);

		public int getRulesCount();

		public List<Debug.ResolvedRule> getRulesList();
	}

	public static final class RuleEvaluationStepInfo extends GeneratedMessageLite implements Debug.RuleEvaluationStepInfoOrBuilder {
		public static final int ENABLED_FUNCTIONS_FIELD_NUMBER = 2;
		public static Parser<Debug.RuleEvaluationStepInfo> PARSER = null;
		public static final int RULES_FIELD_NUMBER = 1;
		private static final Debug.RuleEvaluationStepInfo defaultInstance;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private List<Debug.ResolvedFunctionCall> enabledFunctions_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private List<Debug.ResolvedRule> rules_;
		private final ByteString unknownFields;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Debug.RuleEvaluationStepInfo, Debug.RuleEvaluationStepInfo.Builder> implements Debug.RuleEvaluationStepInfoOrBuilder {
			private int bitField0_;
			private List<Debug.ResolvedFunctionCall> enabledFunctions_;
			private List<Debug.ResolvedRule> rules_;

			private Builder() {
				this.rules_ = Collections.emptyList();
				this.enabledFunctions_ = Collections.emptyList();
				maybeForceBuilderInitialization();
			}

			private static Debug.RuleEvaluationStepInfo.Builder create() {
				return new Debug.RuleEvaluationStepInfo.Builder();
			}

			private void ensureEnabledFunctionsIsMutable() {
				if ((this.bitField0_ & 2) != 2) {
					this.enabledFunctions_ = new ArrayList(this.enabledFunctions_);
					this.bitField0_ |= 2;
				}
			}

			private void ensureRulesIsMutable() {
				if ((this.bitField0_ & 1) != 1) {
					this.rules_ = new ArrayList(this.rules_);
					this.bitField0_ |= 1;
				}
			}

			private void maybeForceBuilderInitialization() {
			}

			public Debug.RuleEvaluationStepInfo.Builder addAllEnabledFunctions(Iterable<Debug.ResolvedFunctionCall> values) {
				ensureEnabledFunctionsIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.enabledFunctions_);
				return this;
			}

			public Debug.RuleEvaluationStepInfo.Builder addAllRules(Iterable<Debug.ResolvedRule> values) {
				ensureRulesIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.rules_);
				return this;
			}

			public Debug.RuleEvaluationStepInfo.Builder addEnabledFunctions(int index, Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureEnabledFunctionsIsMutable();
				this.enabledFunctions_.add(index, builderForValue.build());
				return this;
			}

			public Debug.RuleEvaluationStepInfo.Builder addEnabledFunctions(int index, Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureEnabledFunctionsIsMutable();
					this.enabledFunctions_.add(index, value);
					return this;
				}
			}

			public Debug.RuleEvaluationStepInfo.Builder addEnabledFunctions(Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureEnabledFunctionsIsMutable();
				this.enabledFunctions_.add(builderForValue.build());
				return this;
			}

			public Debug.RuleEvaluationStepInfo.Builder addEnabledFunctions(Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureEnabledFunctionsIsMutable();
					this.enabledFunctions_.add(value);
					return this;
				}
			}

			public Debug.RuleEvaluationStepInfo.Builder addRules(int index, Debug.ResolvedRule.Builder builderForValue) {
				ensureRulesIsMutable();
				this.rules_.add(index, builderForValue.build());
				return this;
			}

			public Debug.RuleEvaluationStepInfo.Builder addRules(int index, Debug.ResolvedRule value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureRulesIsMutable();
					this.rules_.add(index, value);
					return this;
				}
			}

			public Debug.RuleEvaluationStepInfo.Builder addRules(Debug.ResolvedRule.Builder builderForValue) {
				ensureRulesIsMutable();
				this.rules_.add(builderForValue.build());
				return this;
			}

			public Debug.RuleEvaluationStepInfo.Builder addRules(Debug.ResolvedRule value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureRulesIsMutable();
					this.rules_.add(value);
					return this;
				}
			}

			public Debug.RuleEvaluationStepInfo build() {
				Debug.RuleEvaluationStepInfo result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Debug.RuleEvaluationStepInfo buildPartial() {
				Debug.RuleEvaluationStepInfo result = new Debug.RuleEvaluationStepInfo((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
				int from_bitField0_ = this.bitField0_;
				if ((this.bitField0_ & 1) == 1) {
					this.rules_ = Collections.unmodifiableList(this.rules_);
					this.bitField0_ &= -2;
				}
				result.rules_ = this.rules_;
				if ((this.bitField0_ & 2) == 2) {
					this.enabledFunctions_ = Collections.unmodifiableList(this.enabledFunctions_);
					this.bitField0_ &= -3;
				}
				result.enabledFunctions_ = this.enabledFunctions_;
				return result;
			}

			public Debug.RuleEvaluationStepInfo.Builder clear() {
				super.clear();
				this.rules_ = Collections.emptyList();
				this.bitField0_ &= -2;
				this.enabledFunctions_ = Collections.emptyList();
				this.bitField0_ &= -3;
				return this;
			}

			public Debug.RuleEvaluationStepInfo.Builder clearEnabledFunctions() {
				this.enabledFunctions_ = Collections.emptyList();
				this.bitField0_ &= -3;
				return this;
			}

			public Debug.RuleEvaluationStepInfo.Builder clearRules() {
				this.rules_ = Collections.emptyList();
				this.bitField0_ &= -2;
				return this;
			}

			public Debug.RuleEvaluationStepInfo.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public Debug.RuleEvaluationStepInfo getDefaultInstanceForType() {
				return Debug.RuleEvaluationStepInfo.getDefaultInstance();
			}

			public Debug.ResolvedFunctionCall getEnabledFunctions(int index) {
				return (Debug.ResolvedFunctionCall) this.enabledFunctions_.get(index);
			}

			public int getEnabledFunctionsCount() {
				return this.enabledFunctions_.size();
			}

			public List<Debug.ResolvedFunctionCall> getEnabledFunctionsList() {
				return Collections.unmodifiableList(this.enabledFunctions_);
			}

			public Debug.ResolvedRule getRules(int index) {
				return (Debug.ResolvedRule) this.rules_.get(index);
			}

			public int getRulesCount() {
				return this.rules_.size();
			}

			public List<Debug.ResolvedRule> getRulesList() {
				return Collections.unmodifiableList(this.rules_);
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

			public Debug.RuleEvaluationStepInfo.Builder mergeFrom(Debug.RuleEvaluationStepInfo other) {
				if (other == Debug.RuleEvaluationStepInfo.getDefaultInstance()) {
					return this;
				} else {
					if (!other.rules_.isEmpty()) {
						if (this.rules_.isEmpty()) {
							this.rules_ = other.rules_;
							this.bitField0_ &= -2;
						} else {
							ensureRulesIsMutable();
							this.rules_.addAll(other.rules_);
						}
					}
					if (!other.enabledFunctions_.isEmpty()) {
						if (this.enabledFunctions_.isEmpty()) {
							this.enabledFunctions_ = other.enabledFunctions_;
							this.bitField0_ &= -3;
						} else {
							ensureEnabledFunctionsIsMutable();
							this.enabledFunctions_.addAll(other.enabledFunctions_);
						}
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Debug.RuleEvaluationStepInfo.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Debug.RuleEvaluationStepInfo parsedMessage;
				try {
					parsedMessage = (Debug.RuleEvaluationStepInfo) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Debug.RuleEvaluationStepInfo) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Debug.RuleEvaluationStepInfo.Builder removeEnabledFunctions(int index) {
				ensureEnabledFunctionsIsMutable();
				this.enabledFunctions_.remove(index);
				return this;
			}

			public Debug.RuleEvaluationStepInfo.Builder removeRules(int index) {
				ensureRulesIsMutable();
				this.rules_.remove(index);
				return this;
			}

			public Debug.RuleEvaluationStepInfo.Builder setEnabledFunctions(int index, Debug.ResolvedFunctionCall.Builder builderForValue) {
				ensureEnabledFunctionsIsMutable();
				this.enabledFunctions_.set(index, builderForValue.build());
				return this;
			}

			public Debug.RuleEvaluationStepInfo.Builder setEnabledFunctions(int index, Debug.ResolvedFunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureEnabledFunctionsIsMutable();
					this.enabledFunctions_.set(index, value);
					return this;
				}
			}

			public Debug.RuleEvaluationStepInfo.Builder setRules(int index, Debug.ResolvedRule.Builder builderForValue) {
				ensureRulesIsMutable();
				this.rules_.set(index, builderForValue.build());
				return this;
			}

			public Debug.RuleEvaluationStepInfo.Builder setRules(int index, Debug.ResolvedRule value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureRulesIsMutable();
					this.rules_.set(index, value);
					return this;
				}
			}
		}


		static {
			PARSER = new AbstractParser<Debug.RuleEvaluationStepInfo>() {
			public Debug.RuleEvaluationStepInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Debug.RuleEvaluationStepInfo(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Debug.RuleEvaluationStepInfo(true);
			defaultInstance.initFields();
		}

		private RuleEvaluationStepInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			OutputStream unknownFieldsOutput;
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			initFields();
			int mutable_bitField0_ = 0;
			unknownFieldsOutput = ByteString.newOutput();
			CodedOutputStream unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
			boolean done = false;
			while (!done) {
				int tag;
				try {
					tag = input.readTag();
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case Value.ESCAPING_FIELD_NUMBER:
						if ((mutable_bitField0_ & 1) != 1) {
							this.rules_ = new ArrayList();
							mutable_bitField0_ |= 1;
						}
						this.rules_.add(input.readMessage(Debug.ResolvedRule.PARSER, extensionRegistry));
						break;
					case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						if ((mutable_bitField0_ & 2) != 2) {
							this.enabledFunctions_ = new ArrayList();
							mutable_bitField0_ |= 2;
						}
						this.enabledFunctions_.add(input.readMessage(Debug.ResolvedFunctionCall.PARSER, extensionRegistry));
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				} catch (InvalidProtocolBufferException e) {
					throw e.setUnfinishedMessage(this);
				} catch (IOException e_2) {
					throw new InvalidProtocolBufferException(e_2.getMessage()).setUnfinishedMessage(this);
				} catch (Throwable th) {
					if ((mutable_bitField0_ & 1) == 1) {
						this.rules_ = Collections.unmodifiableList(this.rules_);
					}
					if ((mutable_bitField0_ & 2) == 2) {
						this.enabledFunctions_ = Collections.unmodifiableList(this.enabledFunctions_);
					}
					unknownFieldsCodedOutput.flush();
					this.unknownFields = unknownFieldsOutput.toByteString();
				}
			}
			if ((mutable_bitField0_ & 1) == 1) {
				this.rules_ = Collections.unmodifiableList(this.rules_);
			}
			if ((mutable_bitField0_ & 2) == 2) {
				this.enabledFunctions_ = Collections.unmodifiableList(this.enabledFunctions_);
			}
			try {
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
			} catch (IOException e_3) {
				this.unknownFields = unknownFieldsOutput.toByteString();
			}
			makeExtensionsImmutable();
		}

		private RuleEvaluationStepInfo(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private RuleEvaluationStepInfo(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Debug.RuleEvaluationStepInfo getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.rules_ = Collections.emptyList();
			this.enabledFunctions_ = Collections.emptyList();
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Debug.RuleEvaluationStepInfo prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Debug.RuleEvaluationStepInfo parseDelimitedFrom(InputStream input) throws IOException {
			return (Debug.RuleEvaluationStepInfo) PARSER.parseDelimitedFrom(input);
		}

		public static Debug.RuleEvaluationStepInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.RuleEvaluationStepInfo) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Debug.RuleEvaluationStepInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Debug.RuleEvaluationStepInfo) PARSER.parseFrom(data);
		}

		public static Debug.RuleEvaluationStepInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Debug.RuleEvaluationStepInfo) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Debug.RuleEvaluationStepInfo parseFrom(CodedInputStream input) throws IOException {
			return (Debug.RuleEvaluationStepInfo) PARSER.parseFrom(input);
		}

		public static Debug.RuleEvaluationStepInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.RuleEvaluationStepInfo) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Debug.RuleEvaluationStepInfo parseFrom(InputStream input) throws IOException {
			return (Debug.RuleEvaluationStepInfo) PARSER.parseFrom(input);
		}

		public static Debug.RuleEvaluationStepInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Debug.RuleEvaluationStepInfo) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Debug.RuleEvaluationStepInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Debug.RuleEvaluationStepInfo) PARSER.parseFrom(data);
		}

		public static Debug.RuleEvaluationStepInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Debug.RuleEvaluationStepInfo) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Debug.RuleEvaluationStepInfo))) {
				return super.equals(obj);
			} else {
				boolean result;
				Debug.RuleEvaluationStepInfo other = (Debug.RuleEvaluationStepInfo) obj;
				result = (!true || !getRulesList().equals(other.getRulesList())) ? false : true;
				result = (!result || !getEnabledFunctionsList().equals(other.getEnabledFunctionsList())) ? false : true;
				return result;
			}
		}

		public Debug.RuleEvaluationStepInfo getDefaultInstanceForType() {
			return defaultInstance;
		}

		public Debug.ResolvedFunctionCall getEnabledFunctions(int index) {
			return (Debug.ResolvedFunctionCall) this.enabledFunctions_.get(index);
		}

		public int getEnabledFunctionsCount() {
			return this.enabledFunctions_.size();
		}

		public List<Debug.ResolvedFunctionCall> getEnabledFunctionsList() {
			return this.enabledFunctions_;
		}

		public Debug.ResolvedFunctionCallOrBuilder getEnabledFunctionsOrBuilder(int index) {
			return (Debug.ResolvedFunctionCallOrBuilder) this.enabledFunctions_.get(index);
		}

		public List<Debug.ResolvedFunctionCallOrBuilder> getEnabledFunctionsOrBuilderList() {
			return this.enabledFunctions_;
		}

		public Parser<Debug.RuleEvaluationStepInfo> getParserForType() {
			return PARSER;
		}

		public Debug.ResolvedRule getRules(int index) {
			return (Debug.ResolvedRule) this.rules_.get(index);
		}

		public int getRulesCount() {
			return this.rules_.size();
		}

		public List<Debug.ResolvedRule> getRulesList() {
			return this.rules_;
		}

		public Debug.ResolvedRuleOrBuilder getRulesOrBuilder(int index) {
			return (Debug.ResolvedRuleOrBuilder) this.rules_.get(index);
		}

		public List<Debug.ResolvedRuleOrBuilder> getRulesOrBuilderList() {
			return this.rules_;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				int i = 0;
				while (i < this.rules_.size()) {
					size += CodedOutputStream.computeMessageSize(RULES_FIELD_NUMBER, (MessageLite) this.rules_.get(i));
					i++;
				}
				i = 0;
				while (i < this.enabledFunctions_.size()) {
					size += CodedOutputStream.computeMessageSize(ENABLED_FUNCTIONS_FIELD_NUMBER, (MessageLite) this.enabledFunctions_.get(i));
					i++;
				}
				size += this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
		}

		public int hashCode() {
			if (this.memoizedHashCode != 0) {
				return this.memoizedHashCode;
			} else {
				int hash = Debug.RuleEvaluationStepInfo.class.hashCode() + 779;
				if (getRulesCount() > 0) {
					hash = (((hash * 37) + 1) * 53) + getRulesList().hashCode();
				}
				if (getEnabledFunctionsCount() > 0) {
					hash = (((hash * 37) + 2) * 53) + getEnabledFunctionsList().hashCode();
				}
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableDebug$RuleEvaluationStepInfo");
			}
			return mutableDefault;
		}

		public final boolean isInitialized() {
			byte isInitialized = this.memoizedIsInitialized;
			if (isInitialized != (byte) -1) {
				return isInitialized == (byte) 1;
			} else {
				int i = 0;
				while (i < getRulesCount()) {
					if (!getRules(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				i = 0;
				while (i < getEnabledFunctionsCount()) {
					if (!getEnabledFunctions(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				this.memoizedIsInitialized = (byte) 1;
				return true;
			}
		}

		public Builder newBuilderForType() {
			return newBuilder();
		}

		public Builder toBuilder() {
			return newBuilder(this);
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeTo(CodedOutputStream output) throws IOException {
			getSerializedSize();
			int i = 0;
			while (i < this.rules_.size()) {
				output.writeMessage(RULES_FIELD_NUMBER, (MessageLite) this.rules_.get(i));
				i++;
			}
			i = 0;
			while (i < this.enabledFunctions_.size()) {
				output.writeMessage(ENABLED_FUNCTIONS_FIELD_NUMBER, (MessageLite) this.enabledFunctions_.get(i));
				i++;
			}
			output.writeRawBytes(this.unknownFields);
		}
	}


	static {
	}

	private Debug() {
	}

	public static void registerAllExtensions(ExtensionRegistryLite registry) {
		registry.add(MacroEvaluationInfo.macro);
	}
}
