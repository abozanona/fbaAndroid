package com.google.analytics.containertag.proto;

import com.google.analytics.containertag.proto.Serving.CacheOption.CacheLevel;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Escaping;
import com.google.analytics.midtier.proto.containertag.TypeSystem.ValueOrBuilder;
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
import com.google.tagmanager.protobuf.LazyStringArrayList;
import com.google.tagmanager.protobuf.LazyStringList;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MessageLiteOrBuilder;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import com.google.tagmanager.protobuf.UnmodifiableLazyStringList;
import com.google.tagmanager.protobuf.Utf8;
import com.google.tagmanager.protobuf.WireFormat.FieldType;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Serving {
	public static interface CacheOptionOrBuilder extends MessageLiteOrBuilder {
		public int getExpirationSeconds();

		public int getGcacheExpirationSeconds();

		public CacheLevel getLevel();

		public boolean hasExpirationSeconds();

		public boolean hasGcacheExpirationSeconds();

		public boolean hasLevel();
	}

	public static final class CacheOption extends GeneratedMessageLite implements Serving.CacheOptionOrBuilder {
		public static final int EXPIRATION_SECONDS_FIELD_NUMBER = 2;
		public static final int GCACHE_EXPIRATION_SECONDS_FIELD_NUMBER = 3;
		public static final int LEVEL_FIELD_NUMBER = 1;
		public static Parser<Serving.CacheOption> PARSER;
		private static final Serving.CacheOption defaultInstance;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private int expirationSeconds_;
		private int gcacheExpirationSeconds_;
		private CacheLevel level_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private final ByteString unknownFields;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Serving.CacheOption, Serving.CacheOption.Builder> implements Serving.CacheOptionOrBuilder {
			private int bitField0_;
			private int expirationSeconds_;
			private int gcacheExpirationSeconds_;
			private Serving.CacheOption.CacheLevel level_;

			private Builder() {
				this.level_ = Serving.CacheOption.CacheLevel.NO_CACHE;
				maybeForceBuilderInitialization();
			}

			private static Serving.CacheOption.Builder create() {
				return new Serving.CacheOption.Builder();
			}

			private void maybeForceBuilderInitialization() {
			}

			public Serving.CacheOption build() {
				Serving.CacheOption result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Serving.CacheOption buildPartial() {
				Serving.CacheOption result = new Serving.CacheOption((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
				int from_bitField0_ = this.bitField0_;
				int to_bitField0_ = 0;
				if ((from_bitField0_ & 1) == 1) {
					to_bitField0_ |= 1;
				}
				result.level_ = this.level_;
				if ((from_bitField0_ & 2) == 2) {
					to_bitField0_ |= 2;
				}
				result.expirationSeconds_ = this.expirationSeconds_;
				if ((from_bitField0_ & 4) == 4) {
					to_bitField0_ |= 4;
				}
				result.gcacheExpirationSeconds_ = this.gcacheExpirationSeconds_;
				result.bitField0_ = to_bitField0_;
				return result;
			}

			public Serving.CacheOption.Builder clear() {
				super.clear();
				this.level_ = Serving.CacheOption.CacheLevel.NO_CACHE;
				this.bitField0_ &= -2;
				this.expirationSeconds_ = 0;
				this.bitField0_ &= -3;
				this.gcacheExpirationSeconds_ = 0;
				this.bitField0_ &= -5;
				return this;
			}

			public Serving.CacheOption.Builder clearExpirationSeconds() {
				this.bitField0_ &= -3;
				this.expirationSeconds_ = 0;
				return this;
			}

			public Serving.CacheOption.Builder clearGcacheExpirationSeconds() {
				this.bitField0_ &= -5;
				this.gcacheExpirationSeconds_ = 0;
				return this;
			}

			public Serving.CacheOption.Builder clearLevel() {
				this.bitField0_ &= -2;
				this.level_ = Serving.CacheOption.CacheLevel.NO_CACHE;
				return this;
			}

			public Serving.CacheOption.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public Serving.CacheOption getDefaultInstanceForType() {
				return Serving.CacheOption.getDefaultInstance();
			}

			public int getExpirationSeconds() {
				return this.expirationSeconds_;
			}

			public int getGcacheExpirationSeconds() {
				return this.gcacheExpirationSeconds_;
			}

			public Serving.CacheOption.CacheLevel getLevel() {
				return this.level_;
			}

			public boolean hasExpirationSeconds() {
				return (this.bitField0_ & 2) == 2;
			}

			public boolean hasGcacheExpirationSeconds() {
				return (this.bitField0_ & 4) == 4;
			}

			public boolean hasLevel() {
				return (this.bitField0_ & 1) == 1;
			}

			public final boolean isInitialized() {
				return true;
			}

			public Serving.CacheOption.Builder mergeFrom(Serving.CacheOption other) {
				if (other == Serving.CacheOption.getDefaultInstance()) {
					return this;
				} else {
					if (other.hasLevel()) {
						setLevel(other.getLevel());
					}
					if (other.hasExpirationSeconds()) {
						setExpirationSeconds(other.getExpirationSeconds());
					}
					if (other.hasGcacheExpirationSeconds()) {
						setGcacheExpirationSeconds(other.getGcacheExpirationSeconds());
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Serving.CacheOption.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Serving.CacheOption parsedMessage;
				try {
					parsedMessage = (Serving.CacheOption) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Serving.CacheOption) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Serving.CacheOption.Builder setExpirationSeconds(int value) {
				this.bitField0_ |= 2;
				this.expirationSeconds_ = value;
				return this;
			}

			public Serving.CacheOption.Builder setGcacheExpirationSeconds(int value) {
				this.bitField0_ |= 4;
				this.gcacheExpirationSeconds_ = value;
				return this;
			}

			public Serving.CacheOption.Builder setLevel(Serving.CacheOption.CacheLevel value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 1;
					this.level_ = value;
					return this;
				}
			}
		}

		public static enum CacheLevel implements EnumLite {
			NO_CACHE(0, 1),
			PRIVATE(1, 2),
			PUBLIC(2, 3);

			public static final int NO_CACHE_VALUE = 1;
			public static final int PRIVATE_VALUE = 2;
			public static final int PUBLIC_VALUE = 3;
			private static EnumLiteMap<Serving.CacheOption.CacheLevel> internalValueMap;
			private final int value;


			static {
				internalValueMap = new EnumLiteMap<Serving.CacheOption.CacheLevel>() {
			public Serving.CacheOption.CacheLevel findValueByNumber(int number) {
				return Serving.CacheOption.CacheLevel.valueOf(number);
			}
		};
			}

			private CacheLevel(int index, int value) {
				this.value = value;
			}

			public static EnumLiteMap<Serving.CacheOption.CacheLevel> internalGetValueMap() {
				return internalValueMap;
			}

			public static Serving.CacheOption.CacheLevel valueOf(int value) {
				switch(value) {
				case NO_CACHE_VALUE:
					return NO_CACHE;
				case PRIVATE_VALUE:
					return PRIVATE;
				case PUBLIC_VALUE:
					return PUBLIC;
				}
				return null;
			}

			public final int getNumber() {
				return this.value;
			}
		}


		static {
			PARSER = new AbstractParser<Serving.CacheOption>() {
			public Serving.CacheOption parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Serving.CacheOption(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Serving.CacheOption(true);
			defaultInstance.initFields();
		}

		private CacheOption(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
					case CodedOutputStream.LITTLE_ENDIAN_64_SIZE:
						int rawValue = input.readEnum();
						CacheLevel value = CacheLevel.valueOf(rawValue);
						if (value == null) {
							unknownFieldsCodedOutput.writeRawVarint32(tag);
							unknownFieldsCodedOutput.writeRawVarint32(rawValue);
						} else {
							this.bitField0_ |= 1;
							this.level_ = value;
						}
						break;
					case Escaping.CONVERT_JS_VALUE_TO_EXPRESSION_VALUE:
						this.bitField0_ |= 2;
						this.expirationSeconds_ = input.readInt32();
						break;
					case 24:
						this.bitField0_ |= 4;
						this.gcacheExpirationSeconds_ = input.readInt32();
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

		private CacheOption(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private CacheOption(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Serving.CacheOption getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.level_ = CacheLevel.NO_CACHE;
			this.expirationSeconds_ = 0;
			this.gcacheExpirationSeconds_ = 0;
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Serving.CacheOption prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Serving.CacheOption parseDelimitedFrom(InputStream input) throws IOException {
			return (Serving.CacheOption) PARSER.parseDelimitedFrom(input);
		}

		public static Serving.CacheOption parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.CacheOption) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Serving.CacheOption parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Serving.CacheOption) PARSER.parseFrom(data);
		}

		public static Serving.CacheOption parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Serving.CacheOption) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Serving.CacheOption parseFrom(CodedInputStream input) throws IOException {
			return (Serving.CacheOption) PARSER.parseFrom(input);
		}

		public static Serving.CacheOption parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.CacheOption) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Serving.CacheOption parseFrom(InputStream input) throws IOException {
			return (Serving.CacheOption) PARSER.parseFrom(input);
		}

		public static Serving.CacheOption parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.CacheOption) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Serving.CacheOption parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Serving.CacheOption) PARSER.parseFrom(data);
		}

		public static Serving.CacheOption parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Serving.CacheOption) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Serving.CacheOption))) {
				return super.equals(obj);
			} else {
				boolean result;
				Serving.CacheOption other = (Serving.CacheOption) obj;
				if (!true || hasLevel() != other.hasLevel()) {
					result = false;
				} else {
					result = true;
				}
				if (hasLevel()) {
					result = (!result || getLevel() != other.getLevel()) ? false : true;
				}
				if (!result || hasExpirationSeconds() != other.hasExpirationSeconds()) {
					result = false;
				} else {
					result = true;
				}
				if (hasExpirationSeconds()) {
					result = (!result || getExpirationSeconds() != other.getExpirationSeconds()) ? false : true;
				}
				if (!result || hasGcacheExpirationSeconds() != other.hasGcacheExpirationSeconds()) {
					result = false;
				} else {
					result = true;
				}
				if (hasGcacheExpirationSeconds()) {
					result = (!result || getGcacheExpirationSeconds() != other.getGcacheExpirationSeconds()) ? false : true;
				}
				return result;
			}
		}

		public Serving.CacheOption getDefaultInstanceForType() {
			return defaultInstance;
		}

		public int getExpirationSeconds() {
			return this.expirationSeconds_;
		}

		public int getGcacheExpirationSeconds() {
			return this.gcacheExpirationSeconds_;
		}

		public CacheLevel getLevel() {
			return this.level_;
		}

		public Parser<Serving.CacheOption> getParserForType() {
			return PARSER;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				if ((this.bitField0_ & 1) == 1) {
					size += CodedOutputStream.computeEnumSize(LEVEL_FIELD_NUMBER, this.level_.getNumber());
				}
				if ((this.bitField0_ & 2) == 2) {
					size += CodedOutputStream.computeInt32Size(EXPIRATION_SECONDS_FIELD_NUMBER, this.expirationSeconds_);
				}
				if ((this.bitField0_ & 4) == 4) {
					size += CodedOutputStream.computeInt32Size(GCACHE_EXPIRATION_SECONDS_FIELD_NUMBER, this.gcacheExpirationSeconds_);
				}
				size += this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
		}

		public boolean hasExpirationSeconds() {
			return (this.bitField0_ & 2) == 2;
		}

		public boolean hasGcacheExpirationSeconds() {
			return (this.bitField0_ & 4) == 4;
		}

		public boolean hasLevel() {
			return (this.bitField0_ & 1) == 1;
		}

		public int hashCode() {
			if (this.memoizedHashCode != 0) {
				return this.memoizedHashCode;
			} else {
				int hash = Serving.CacheOption.class.hashCode() + 779;
				if (hasLevel()) {
					hash = (((hash * 37) + 1) * 53) + Internal.hashEnum(getLevel());
				}
				if (hasExpirationSeconds()) {
					hash = (((hash * 37) + 2) * 53) + getExpirationSeconds();
				}
				if (hasGcacheExpirationSeconds()) {
					hash = (((hash * 37) + 3) * 53) + getGcacheExpirationSeconds();
				}
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$CacheOption");
			}
			return mutableDefault;
		}

		public final boolean isInitialized() {
			byte isInitialized = this.memoizedIsInitialized;
			if (isInitialized != (byte) -1) {
				return isInitialized == (byte) 1;
			} else {
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
			if ((this.bitField0_ & 1) == 1) {
				output.writeEnum(LEVEL_FIELD_NUMBER, this.level_.getNumber());
			}
			if ((this.bitField0_ & 2) == 2) {
				output.writeInt32(EXPIRATION_SECONDS_FIELD_NUMBER, this.expirationSeconds_);
			}
			if ((this.bitField0_ & 4) == 4) {
				output.writeInt32(GCACHE_EXPIRATION_SECONDS_FIELD_NUMBER, this.gcacheExpirationSeconds_);
			}
			output.writeRawBytes(this.unknownFields);
		}
	}

	public static interface ContainerOrBuilder extends MessageLiteOrBuilder {
		public String getContainerId();

		public ByteString getContainerIdBytes();

		public Serving.Resource getJsResource();

		public Serving.ResourceState getState();

		public String getVersion();

		public ByteString getVersionBytes();

		public boolean hasContainerId();

		public boolean hasJsResource();

		public boolean hasState();

		public boolean hasVersion();
	}

	public static final class Container extends GeneratedMessageLite implements Serving.ContainerOrBuilder {
		public static final int CONTAINER_ID_FIELD_NUMBER = 3;
		public static final int JS_RESOURCE_FIELD_NUMBER = 1;
		public static Parser<Serving.Container> PARSER = null;
		public static final int STATE_FIELD_NUMBER = 4;
		public static final int VERSION_FIELD_NUMBER = 5;
		private static final Serving.Container defaultInstance;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private Object containerId_;
		private Serving.Resource jsResource_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private Serving.ResourceState state_;
		private final ByteString unknownFields;
		private Object version_;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Serving.Container, Serving.Container.Builder> implements Serving.ContainerOrBuilder {
			private int bitField0_;
			private Object containerId_;
			private Serving.Resource jsResource_;
			private Serving.ResourceState state_;
			private Object version_;

			private Builder() {
				this.jsResource_ = Serving.Resource.getDefaultInstance();
				this.containerId_ = "";
				this.state_ = Serving.ResourceState.PREVIEW;
				this.version_ = "";
				maybeForceBuilderInitialization();
			}

			private static Serving.Container.Builder create() {
				return new Serving.Container.Builder();
			}

			private void maybeForceBuilderInitialization() {
			}

			public Serving.Container build() {
				Serving.Container result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Serving.Container buildPartial() {
				Serving.Container result = new Serving.Container((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
				int from_bitField0_ = this.bitField0_;
				int to_bitField0_ = 0;
				if ((from_bitField0_ & 1) == 1) {
					to_bitField0_ |= 1;
				}
				result.jsResource_ = this.jsResource_;
				if ((from_bitField0_ & 2) == 2) {
					to_bitField0_ |= 2;
				}
				result.containerId_ = this.containerId_;
				if ((from_bitField0_ & 4) == 4) {
					to_bitField0_ |= 4;
				}
				result.state_ = this.state_;
				if ((from_bitField0_ & 8) == 8) {
					to_bitField0_ |= 8;
				}
				result.version_ = this.version_;
				result.bitField0_ = to_bitField0_;
				return result;
			}

			public Serving.Container.Builder clear() {
				super.clear();
				this.jsResource_ = Serving.Resource.getDefaultInstance();
				this.bitField0_ &= -2;
				this.containerId_ = "";
				this.bitField0_ &= -3;
				this.state_ = Serving.ResourceState.PREVIEW;
				this.bitField0_ &= -5;
				this.version_ = "";
				this.bitField0_ &= -9;
				return this;
			}

			public Serving.Container.Builder clearContainerId() {
				this.bitField0_ &= -3;
				this.containerId_ = Serving.Container.getDefaultInstance().getContainerId();
				return this;
			}

			public Serving.Container.Builder clearJsResource() {
				this.jsResource_ = Serving.Resource.getDefaultInstance();
				this.bitField0_ &= -2;
				return this;
			}

			public Serving.Container.Builder clearState() {
				this.bitField0_ &= -5;
				this.state_ = Serving.ResourceState.PREVIEW;
				return this;
			}

			public Serving.Container.Builder clearVersion() {
				this.bitField0_ &= -9;
				this.version_ = Serving.Container.getDefaultInstance().getVersion();
				return this;
			}

			public Serving.Container.Builder clone() {
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

			public Serving.Container getDefaultInstanceForType() {
				return Serving.Container.getDefaultInstance();
			}

			public Serving.Resource getJsResource() {
				return this.jsResource_;
			}

			public Serving.ResourceState getState() {
				return this.state_;
			}

			public String getVersion() {
				Object ref = this.version_;
				if (!((ref instanceof String))) {
					ByteString bs = (ByteString) ref;
					String s = bs.toStringUtf8();
					if (bs.isValidUtf8()) {
						this.version_ = s;
						return s;
					}
					return s;
				} else {
					return (String) ref;
				}
			}

			public ByteString getVersionBytes() {
				Object ref = this.version_;
				if (ref instanceof String) {
					ByteString b = ByteString.copyFromUtf8((String) ref);
					this.version_ = b;
					return b;
				} else {
					return (ByteString) ref;
				}
			}

			public boolean hasContainerId() {
				return (this.bitField0_ & 2) == 2;
			}

			public boolean hasJsResource() {
				return (this.bitField0_ & 1) == 1;
			}

			public boolean hasState() {
				return (this.bitField0_ & 4) == 4;
			}

			public boolean hasVersion() {
				return (this.bitField0_ & 8) == 8;
			}

			public final boolean isInitialized() {
				if (!hasJsResource()) {
					return false;
				} else {
					if (hasContainerId()) {
						if (hasState()) {
							if (getJsResource().isInitialized()) {
								return true;
							}
							return false;
						}
						return false;
					}
					return false;
				}
			}

			public Serving.Container.Builder mergeFrom(Serving.Container other) {
				if (other == Serving.Container.getDefaultInstance()) {
					return this;
				} else {
					if (other.hasJsResource()) {
						mergeJsResource(other.getJsResource());
					}
					if (other.hasContainerId()) {
						this.bitField0_ |= 2;
						this.containerId_ = other.containerId_;
					}
					if (other.hasState()) {
						setState(other.getState());
					}
					if (other.hasVersion()) {
						this.bitField0_ |= 8;
						this.version_ = other.version_;
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Serving.Container.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Serving.Container parsedMessage;
				try {
					parsedMessage = (Serving.Container) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Serving.Container) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Serving.Container.Builder mergeJsResource(Serving.Resource value) {
				if ((this.bitField0_ & 1) != 1 || this.jsResource_ == Serving.Resource.getDefaultInstance()) {
					this.jsResource_ = value;
				} else {
					this.jsResource_ = Serving.Resource.newBuilder(this.jsResource_).mergeFrom(value).buildPartial();
				}
				this.bitField0_ |= 1;
				return this;
			}

			public Serving.Container.Builder setContainerId(String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 2;
					this.containerId_ = value;
					return this;
				}
			}

			public Serving.Container.Builder setContainerIdBytes(ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 2;
					this.containerId_ = value;
					return this;
				}
			}

			public Serving.Container.Builder setJsResource(Serving.Resource.Builder builderForValue) {
				this.jsResource_ = builderForValue.build();
				this.bitField0_ |= 1;
				return this;
			}

			public Serving.Container.Builder setJsResource(Serving.Resource value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.jsResource_ = value;
					this.bitField0_ |= 1;
					return this;
				}
			}

			public Serving.Container.Builder setState(Serving.ResourceState value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 4;
					this.state_ = value;
					return this;
				}
			}

			public Serving.Container.Builder setVersion(String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 8;
					this.version_ = value;
					return this;
				}
			}

			public Serving.Container.Builder setVersionBytes(ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 8;
					this.version_ = value;
					return this;
				}
			}
		}


		static {
			PARSER = new AbstractParser<Serving.Container>() {
			public Serving.Container parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Serving.Container(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Serving.Container(true);
			defaultInstance.initFields();
		}

		private Container(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
					case Value.ESCAPING_FIELD_NUMBER:
						Serving.Resource.Builder subBuilder = null;
						if ((this.bitField0_ & 1) == 1) {
							subBuilder = this.jsResource_.toBuilder();
						}
						this.jsResource_ = (Serving.Resource) input.readMessage(Serving.Resource.PARSER, extensionRegistry);
						if (subBuilder != null) {
							subBuilder.mergeFrom(this.jsResource_);
							this.jsResource_ = subBuilder.buildPartial();
						}
						this.bitField0_ |= 1;
						break;
					case 26:
						bs = input.readBytes();
						this.bitField0_ |= 2;
						this.containerId_ = bs;
						break;
					case 32:
						int rawValue = input.readEnum();
						Serving.ResourceState value = Serving.ResourceState.valueOf(rawValue);
						if (value == null) {
							unknownFieldsCodedOutput.writeRawVarint32(tag);
							unknownFieldsCodedOutput.writeRawVarint32(rawValue);
						} else {
							this.bitField0_ |= 4;
							this.state_ = value;
						}
						break;
					case 42:
						bs = input.readBytes();
						this.bitField0_ |= 8;
						this.version_ = bs;
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

		private Container(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private Container(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Serving.Container getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.jsResource_ = Serving.Resource.getDefaultInstance();
			this.containerId_ = "";
			this.state_ = Serving.ResourceState.PREVIEW;
			this.version_ = "";
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Serving.Container prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Serving.Container parseDelimitedFrom(InputStream input) throws IOException {
			return (Serving.Container) PARSER.parseDelimitedFrom(input);
		}

		public static Serving.Container parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.Container) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Serving.Container parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Serving.Container) PARSER.parseFrom(data);
		}

		public static Serving.Container parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Serving.Container) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Serving.Container parseFrom(CodedInputStream input) throws IOException {
			return (Serving.Container) PARSER.parseFrom(input);
		}

		public static Serving.Container parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.Container) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Serving.Container parseFrom(InputStream input) throws IOException {
			return (Serving.Container) PARSER.parseFrom(input);
		}

		public static Serving.Container parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.Container) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Serving.Container parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Serving.Container) PARSER.parseFrom(data);
		}

		public static Serving.Container parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Serving.Container) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Serving.Container))) {
				return super.equals(obj);
			} else {
				boolean result;
				Serving.Container other = (Serving.Container) obj;
				if (!true || hasJsResource() != other.hasJsResource()) {
					result = false;
				} else {
					result = true;
				}
				if (hasJsResource()) {
					result = (!result || !getJsResource().equals(other.getJsResource())) ? false : true;
				}
				if (!result || hasContainerId() != other.hasContainerId()) {
					result = false;
				} else {
					result = true;
				}
				if (hasContainerId()) {
					result = (!result || !getContainerId().equals(other.getContainerId())) ? false : true;
				}
				if (!result || hasState() != other.hasState()) {
					result = false;
				} else {
					result = true;
				}
				if (hasState()) {
					result = (!result || getState() != other.getState()) ? false : true;
				}
				if (!result || hasVersion() != other.hasVersion()) {
					result = false;
				} else {
					result = true;
				}
				if (hasVersion()) {
					result = (!result || !getVersion().equals(other.getVersion())) ? false : true;
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

		public Serving.Container getDefaultInstanceForType() {
			return defaultInstance;
		}

		public Serving.Resource getJsResource() {
			return this.jsResource_;
		}

		public Parser<Serving.Container> getParserForType() {
			return PARSER;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				if ((this.bitField0_ & 1) == 1) {
					size += CodedOutputStream.computeMessageSize(JS_RESOURCE_FIELD_NUMBER, this.jsResource_);
				}
				if ((this.bitField0_ & 2) == 2) {
					size += CodedOutputStream.computeBytesSize(CONTAINER_ID_FIELD_NUMBER, getContainerIdBytes());
				}
				if ((this.bitField0_ & 4) == 4) {
					size += CodedOutputStream.computeEnumSize(STATE_FIELD_NUMBER, this.state_.getNumber());
				}
				if ((this.bitField0_ & 8) == 8) {
					size += CodedOutputStream.computeBytesSize(VERSION_FIELD_NUMBER, getVersionBytes());
				}
				size += this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
		}

		public Serving.ResourceState getState() {
			return this.state_;
		}

		public String getVersion() {
			Object ref = this.version_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				ByteString bs = (ByteString) ref;
				String s = bs.toStringUtf8();
				if (bs.isValidUtf8()) {
					this.version_ = s;
				}
				return s;
			}
		}

		public ByteString getVersionBytes() {
			Object ref = this.version_;
			if (ref instanceof String) {
				ByteString b = ByteString.copyFromUtf8((String) ref);
				this.version_ = b;
				return b;
			} else {
				return (ByteString) ref;
			}
		}

		public boolean hasContainerId() {
			return (this.bitField0_ & 2) == 2;
		}

		public boolean hasJsResource() {
			return (this.bitField0_ & 1) == 1;
		}

		public boolean hasState() {
			return (this.bitField0_ & 4) == 4;
		}

		public boolean hasVersion() {
			return (this.bitField0_ & 8) == 8;
		}

		public int hashCode() {
			if (this.memoizedHashCode != 0) {
				return this.memoizedHashCode;
			} else {
				int hash = Serving.Container.class.hashCode() + 779;
				if (hasJsResource()) {
					hash = (((hash * 37) + 1) * 53) + getJsResource().hashCode();
				}
				if (hasContainerId()) {
					hash = (((hash * 37) + 3) * 53) + getContainerId().hashCode();
				}
				if (hasState()) {
					hash = (((hash * 37) + 4) * 53) + Internal.hashEnum(getState());
				}
				if (hasVersion()) {
					hash = (((hash * 37) + 5) * 53) + getVersion().hashCode();
				}
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$Container");
			}
			return mutableDefault;
		}

		public final boolean isInitialized() {
			boolean r1z = true;
			byte isInitialized = this.memoizedIsInitialized;
			if (isInitialized != (byte) -1) {
				if (isInitialized == (byte) 1) {
					return r1z;
				} else {
					r1z = false;
					return r1z;
				}
			} else if (!hasJsResource()) {
				this.memoizedIsInitialized = (byte) 0;
				return false;
			} else if (!hasContainerId()) {
				this.memoizedIsInitialized = (byte) 0;
				return false;
			} else if (!hasState()) {
				this.memoizedIsInitialized = (byte) 0;
				return false;
			} else if (!getJsResource().isInitialized()) {
				this.memoizedIsInitialized = (byte) 0;
				return false;
			} else {
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
			if ((this.bitField0_ & 1) == 1) {
				output.writeMessage(JS_RESOURCE_FIELD_NUMBER, this.jsResource_);
			}
			if ((this.bitField0_ & 2) == 2) {
				output.writeBytes(CONTAINER_ID_FIELD_NUMBER, getContainerIdBytes());
			}
			if ((this.bitField0_ & 4) == 4) {
				output.writeEnum(STATE_FIELD_NUMBER, this.state_.getNumber());
			}
			if ((this.bitField0_ & 8) == 8) {
				output.writeBytes(VERSION_FIELD_NUMBER, getVersionBytes());
			}
			output.writeRawBytes(this.unknownFields);
		}
	}

	public static interface FunctionCallOrBuilder extends MessageLiteOrBuilder {
		public int getFunction();

		public boolean getLiveOnly();

		public int getName();

		public int getProperty(int r1i);

		public int getPropertyCount();

		public List<Integer> getPropertyList();

		public boolean getServerSide();

		public boolean hasFunction();

		public boolean hasLiveOnly();

		public boolean hasName();

		public boolean hasServerSide();
	}

	public static final class FunctionCall extends GeneratedMessageLite implements Serving.FunctionCallOrBuilder {
		public static final int FUNCTION_FIELD_NUMBER = 2;
		public static final int LIVE_ONLY_FIELD_NUMBER = 6;
		public static final int NAME_FIELD_NUMBER = 4;
		public static Parser<Serving.FunctionCall> PARSER = null;
		public static final int PROPERTY_FIELD_NUMBER = 3;
		public static final int SERVER_SIDE_FIELD_NUMBER = 1;
		private static final Serving.FunctionCall defaultInstance;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private int function_;
		private boolean liveOnly_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private int name_;
		private List<Integer> property_;
		private boolean serverSide_;
		private final ByteString unknownFields;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Serving.FunctionCall, Serving.FunctionCall.Builder> implements Serving.FunctionCallOrBuilder {
			private int bitField0_;
			private int function_;
			private boolean liveOnly_;
			private int name_;
			private List<Integer> property_;
			private boolean serverSide_;

			private Builder() {
				this.property_ = Collections.emptyList();
				maybeForceBuilderInitialization();
			}

			private static Serving.FunctionCall.Builder create() {
				return new Serving.FunctionCall.Builder();
			}

			private void ensurePropertyIsMutable() {
				if ((this.bitField0_ & 1) != 1) {
					this.property_ = new ArrayList(this.property_);
					this.bitField0_ |= 1;
				}
			}

			private void maybeForceBuilderInitialization() {
			}

			public Serving.FunctionCall.Builder addAllProperty(Iterable<Integer> values) {
				ensurePropertyIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.property_);
				return this;
			}

			public Serving.FunctionCall.Builder addProperty(int value) {
				ensurePropertyIsMutable();
				this.property_.add(Integer.valueOf(value));
				return this;
			}

			public Serving.FunctionCall build() {
				Serving.FunctionCall result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Serving.FunctionCall buildPartial() {
				Serving.FunctionCall result = new Serving.FunctionCall((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
				int from_bitField0_ = this.bitField0_;
				int to_bitField0_ = 0;
				if ((this.bitField0_ & 1) == 1) {
					this.property_ = Collections.unmodifiableList(this.property_);
					this.bitField0_ &= -2;
				}
				result.property_ = this.property_;
				if ((from_bitField0_ & 2) == 2) {
					to_bitField0_ |= 1;
				}
				result.function_ = this.function_;
				if ((from_bitField0_ & 4) == 4) {
					to_bitField0_ |= 2;
				}
				result.name_ = this.name_;
				if ((from_bitField0_ & 8) == 8) {
					to_bitField0_ |= 4;
				}
				result.liveOnly_ = this.liveOnly_;
				if ((from_bitField0_ & 16) == 16) {
					to_bitField0_ |= 8;
				}
				result.serverSide_ = this.serverSide_;
				result.bitField0_ = to_bitField0_;
				return result;
			}

			public Serving.FunctionCall.Builder clear() {
				super.clear();
				this.property_ = Collections.emptyList();
				this.bitField0_ &= -2;
				this.function_ = 0;
				this.bitField0_ &= -3;
				this.name_ = 0;
				this.bitField0_ &= -5;
				this.liveOnly_ = false;
				this.bitField0_ &= -9;
				this.serverSide_ = false;
				this.bitField0_ &= -17;
				return this;
			}

			public Serving.FunctionCall.Builder clearFunction() {
				this.bitField0_ &= -3;
				this.function_ = 0;
				return this;
			}

			public Serving.FunctionCall.Builder clearLiveOnly() {
				this.bitField0_ &= -9;
				this.liveOnly_ = false;
				return this;
			}

			public Serving.FunctionCall.Builder clearName() {
				this.bitField0_ &= -5;
				this.name_ = 0;
				return this;
			}

			public Serving.FunctionCall.Builder clearProperty() {
				this.property_ = Collections.emptyList();
				this.bitField0_ &= -2;
				return this;
			}

			public Serving.FunctionCall.Builder clearServerSide() {
				this.bitField0_ &= -17;
				this.serverSide_ = false;
				return this;
			}

			public Serving.FunctionCall.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public Serving.FunctionCall getDefaultInstanceForType() {
				return Serving.FunctionCall.getDefaultInstance();
			}

			public int getFunction() {
				return this.function_;
			}

			public boolean getLiveOnly() {
				return this.liveOnly_;
			}

			public int getName() {
				return this.name_;
			}

			public int getProperty(int index) {
				return ((Integer) this.property_.get(index)).intValue();
			}

			public int getPropertyCount() {
				return this.property_.size();
			}

			public List<Integer> getPropertyList() {
				return Collections.unmodifiableList(this.property_);
			}

			public boolean getServerSide() {
				return this.serverSide_;
			}

			public boolean hasFunction() {
				return (this.bitField0_ & 2) == 2;
			}

			public boolean hasLiveOnly() {
				return (this.bitField0_ & 8) == 8;
			}

			public boolean hasName() {
				return (this.bitField0_ & 4) == 4;
			}

			public boolean hasServerSide() {
				return (this.bitField0_ & 16) == 16;
			}

			public final boolean isInitialized() {
				return hasFunction();
			}

			public Serving.FunctionCall.Builder mergeFrom(Serving.FunctionCall other) {
				if (other == Serving.FunctionCall.getDefaultInstance()) {
					return this;
				} else {
					if (!other.property_.isEmpty()) {
						if (this.property_.isEmpty()) {
							this.property_ = other.property_;
							this.bitField0_ &= -2;
						} else {
							ensurePropertyIsMutable();
							this.property_.addAll(other.property_);
						}
					}
					if (other.hasFunction()) {
						setFunction(other.getFunction());
					}
					if (other.hasName()) {
						setName(other.getName());
					}
					if (other.hasLiveOnly()) {
						setLiveOnly(other.getLiveOnly());
					}
					if (other.hasServerSide()) {
						setServerSide(other.getServerSide());
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Serving.FunctionCall.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Serving.FunctionCall parsedMessage;
				try {
					parsedMessage = (Serving.FunctionCall) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Serving.FunctionCall) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Serving.FunctionCall.Builder setFunction(int value) {
				this.bitField0_ |= 2;
				this.function_ = value;
				return this;
			}

			public Serving.FunctionCall.Builder setLiveOnly(boolean value) {
				this.bitField0_ |= 8;
				this.liveOnly_ = value;
				return this;
			}

			public Serving.FunctionCall.Builder setName(int value) {
				this.bitField0_ |= 4;
				this.name_ = value;
				return this;
			}

			public Serving.FunctionCall.Builder setProperty(int index, int value) {
				ensurePropertyIsMutable();
				this.property_.set(index, Integer.valueOf(value));
				return this;
			}

			public Serving.FunctionCall.Builder setServerSide(boolean value) {
				this.bitField0_ |= 16;
				this.serverSide_ = value;
				return this;
			}
		}


		static {
			PARSER = new AbstractParser<Serving.FunctionCall>() {
			public Serving.FunctionCall parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Serving.FunctionCall(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Serving.FunctionCall(true);
			defaultInstance.initFields();
		}

		private FunctionCall(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
					case CodedOutputStream.LITTLE_ENDIAN_64_SIZE:
						this.bitField0_ |= 8;
						this.serverSide_ = input.readBool();
						break;
					case Escaping.CONVERT_JS_VALUE_TO_EXPRESSION_VALUE:
						this.bitField0_ |= 1;
						this.function_ = input.readInt32();
						break;
					case 24:
						if ((mutable_bitField0_ & 1) != 1) {
							this.property_ = new ArrayList();
							mutable_bitField0_ |= 1;
						}
						this.property_.add(Integer.valueOf(input.readInt32()));
						break;
					case 26:
						int limit = input.pushLimit(input.readRawVarint32());
						if ((mutable_bitField0_ & 1) == 1 || input.getBytesUntilLimit() <= 0) {
							while (input.getBytesUntilLimit() > 0) {
								this.property_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						} else {
							this.property_ = new ArrayList();
							mutable_bitField0_ |= 1;
							while (input.getBytesUntilLimit() > 0) {
								this.property_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						}
						break;
					case 32:
						this.bitField0_ |= 2;
						this.name_ = input.readInt32();
						break;
					case 48:
						this.bitField0_ |= 4;
						this.liveOnly_ = input.readBool();
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
						this.property_ = Collections.unmodifiableList(this.property_);
					}
					unknownFieldsCodedOutput.flush();
					this.unknownFields = unknownFieldsOutput.toByteString();
				}
			}
			if ((mutable_bitField0_ & 1) == 1) {
				this.property_ = Collections.unmodifiableList(this.property_);
			}
			try {
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
			} catch (IOException e_3) {
				this.unknownFields = unknownFieldsOutput.toByteString();
			}
			makeExtensionsImmutable();
		}

		private FunctionCall(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private FunctionCall(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Serving.FunctionCall getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.property_ = Collections.emptyList();
			this.function_ = 0;
			this.name_ = 0;
			this.liveOnly_ = false;
			this.serverSide_ = false;
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Serving.FunctionCall prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Serving.FunctionCall parseDelimitedFrom(InputStream input) throws IOException {
			return (Serving.FunctionCall) PARSER.parseDelimitedFrom(input);
		}

		public static Serving.FunctionCall parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.FunctionCall) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Serving.FunctionCall parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Serving.FunctionCall) PARSER.parseFrom(data);
		}

		public static Serving.FunctionCall parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Serving.FunctionCall) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Serving.FunctionCall parseFrom(CodedInputStream input) throws IOException {
			return (Serving.FunctionCall) PARSER.parseFrom(input);
		}

		public static Serving.FunctionCall parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.FunctionCall) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Serving.FunctionCall parseFrom(InputStream input) throws IOException {
			return (Serving.FunctionCall) PARSER.parseFrom(input);
		}

		public static Serving.FunctionCall parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.FunctionCall) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Serving.FunctionCall parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Serving.FunctionCall) PARSER.parseFrom(data);
		}

		public static Serving.FunctionCall parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Serving.FunctionCall) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Serving.FunctionCall))) {
				return super.equals(obj);
			} else {
				boolean result;
				Serving.FunctionCall other = (Serving.FunctionCall) obj;
				result = (!true || !getPropertyList().equals(other.getPropertyList())) ? false : true;
				if (!result || hasFunction() != other.hasFunction()) {
					result = false;
				} else {
					result = true;
				}
				if (hasFunction()) {
					result = (!result || getFunction() != other.getFunction()) ? false : true;
				}
				if (!result || hasName() != other.hasName()) {
					result = false;
				} else {
					result = true;
				}
				if (hasName()) {
					result = (!result || getName() != other.getName()) ? false : true;
				}
				if (!result || hasLiveOnly() != other.hasLiveOnly()) {
					result = false;
				} else {
					result = true;
				}
				if (hasLiveOnly()) {
					result = (!result || getLiveOnly() != other.getLiveOnly()) ? false : true;
				}
				if (!result || hasServerSide() != other.hasServerSide()) {
					result = false;
				} else {
					result = true;
				}
				if (hasServerSide()) {
					result = (!result || getServerSide() != other.getServerSide()) ? false : true;
				}
				return result;
			}
		}

		public Serving.FunctionCall getDefaultInstanceForType() {
			return defaultInstance;
		}

		public int getFunction() {
			return this.function_;
		}

		public boolean getLiveOnly() {
			return this.liveOnly_;
		}

		public int getName() {
			return this.name_;
		}

		public Parser<Serving.FunctionCall> getParserForType() {
			return PARSER;
		}

		public int getProperty(int index) {
			return ((Integer) this.property_.get(index)).intValue();
		}

		public int getPropertyCount() {
			return this.property_.size();
		}

		public List<Integer> getPropertyList() {
			return this.property_;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				if ((this.bitField0_ & 8) == 8) {
					size += CodedOutputStream.computeBoolSize(SERVER_SIDE_FIELD_NUMBER, this.serverSide_);
				}
				if ((this.bitField0_ & 1) == 1) {
					size += CodedOutputStream.computeInt32Size(FUNCTION_FIELD_NUMBER, this.function_);
				}
				int dataSize = 0;
				int i = 0;
				while (i < this.property_.size()) {
					dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.property_.get(i)).intValue());
					i++;
				}
				size = (size + dataSize) + (getPropertyList().size() * 1);
				if ((this.bitField0_ & 2) == 2) {
					size += CodedOutputStream.computeInt32Size(NAME_FIELD_NUMBER, this.name_);
				}
				if ((this.bitField0_ & 4) == 4) {
					size += CodedOutputStream.computeBoolSize(LIVE_ONLY_FIELD_NUMBER, this.liveOnly_);
				}
				size += this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
		}

		public boolean getServerSide() {
			return this.serverSide_;
		}

		public boolean hasFunction() {
			return (this.bitField0_ & 1) == 1;
		}

		public boolean hasLiveOnly() {
			return (this.bitField0_ & 4) == 4;
		}

		public boolean hasName() {
			return (this.bitField0_ & 2) == 2;
		}

		public boolean hasServerSide() {
			return (this.bitField0_ & 8) == 8;
		}

		public int hashCode() {
			if (this.memoizedHashCode != 0) {
				return this.memoizedHashCode;
			} else {
				int hash = Serving.FunctionCall.class.hashCode() + 779;
				if (getPropertyCount() > 0) {
					hash = (((hash * 37) + 3) * 53) + getPropertyList().hashCode();
				}
				if (hasFunction()) {
					hash = (((hash * 37) + 2) * 53) + getFunction();
				}
				if (hasName()) {
					hash = (((hash * 37) + 4) * 53) + getName();
				}
				if (hasLiveOnly()) {
					hash = (((hash * 37) + 6) * 53) + Internal.hashBoolean(getLiveOnly());
				}
				if (hasServerSide()) {
					hash = (((hash * 37) + 1) * 53) + Internal.hashBoolean(getServerSide());
				}
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$FunctionCall");
			}
			return mutableDefault;
		}

		public final boolean isInitialized() {
			byte isInitialized = this.memoizedIsInitialized;
			if (isInitialized != (byte) -1) {
				return isInitialized == (byte) 1;
			} else if (!hasFunction()) {
				this.memoizedIsInitialized = (byte) 0;
				return false;
			} else {
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
			if ((this.bitField0_ & 8) == 8) {
				output.writeBool(SERVER_SIDE_FIELD_NUMBER, this.serverSide_);
			}
			if ((this.bitField0_ & 1) == 1) {
				output.writeInt32(FUNCTION_FIELD_NUMBER, this.function_);
			}
			int i = 0;
			while (i < this.property_.size()) {
				output.writeInt32(PROPERTY_FIELD_NUMBER, ((Integer) this.property_.get(i)).intValue());
				i++;
			}
			if ((this.bitField0_ & 2) == 2) {
				output.writeInt32(NAME_FIELD_NUMBER, this.name_);
			}
			if ((this.bitField0_ & 4) == 4) {
				output.writeBool(LIVE_ONLY_FIELD_NUMBER, this.liveOnly_);
			}
			output.writeRawBytes(this.unknownFields);
		}
	}

	public static interface OptionalResourceOrBuilder extends MessageLiteOrBuilder {
		public Serving.Resource getResource();

		public boolean hasResource();
	}

	public static final class OptionalResource extends GeneratedMessageLite implements Serving.OptionalResourceOrBuilder {
		public static Parser<Serving.OptionalResource> PARSER = null;
		public static final int RESOURCE_FIELD_NUMBER = 2;
		private static final Serving.OptionalResource defaultInstance;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private Serving.Resource resource_;
		private final ByteString unknownFields;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Serving.OptionalResource, Serving.OptionalResource.Builder> implements Serving.OptionalResourceOrBuilder {
			private int bitField0_;
			private Serving.Resource resource_;

			private Builder() {
				this.resource_ = Serving.Resource.getDefaultInstance();
				maybeForceBuilderInitialization();
			}

			private static Serving.OptionalResource.Builder create() {
				return new Serving.OptionalResource.Builder();
			}

			private void maybeForceBuilderInitialization() {
			}

			public Serving.OptionalResource build() {
				Serving.OptionalResource result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Serving.OptionalResource buildPartial() {
				Serving.OptionalResource result = new Serving.OptionalResource((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
				int to_bitField0_ = 0;
				if ((this.bitField0_ & 1) == 1) {
					to_bitField0_ |= 1;
				}
				result.resource_ = this.resource_;
				result.bitField0_ = to_bitField0_;
				return result;
			}

			public Serving.OptionalResource.Builder clear() {
				super.clear();
				this.resource_ = Serving.Resource.getDefaultInstance();
				this.bitField0_ &= -2;
				return this;
			}

			public Serving.OptionalResource.Builder clearResource() {
				this.resource_ = Serving.Resource.getDefaultInstance();
				this.bitField0_ &= -2;
				return this;
			}

			public Serving.OptionalResource.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public Serving.OptionalResource getDefaultInstanceForType() {
				return Serving.OptionalResource.getDefaultInstance();
			}

			public Serving.Resource getResource() {
				return this.resource_;
			}

			public boolean hasResource() {
				return (this.bitField0_ & 1) == 1;
			}

			public final boolean isInitialized() {
				return !hasResource() || getResource().isInitialized();
			}

			public Serving.OptionalResource.Builder mergeFrom(Serving.OptionalResource other) {
				if (other == Serving.OptionalResource.getDefaultInstance()) {
					return this;
				} else {
					if (other.hasResource()) {
						mergeResource(other.getResource());
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Serving.OptionalResource.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Serving.OptionalResource parsedMessage;
				try {
					parsedMessage = (Serving.OptionalResource) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Serving.OptionalResource) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Serving.OptionalResource.Builder mergeResource(Serving.Resource value) {
				if ((this.bitField0_ & 1) != 1 || this.resource_ == Serving.Resource.getDefaultInstance()) {
					this.resource_ = value;
				} else {
					this.resource_ = Serving.Resource.newBuilder(this.resource_).mergeFrom(value).buildPartial();
				}
				this.bitField0_ |= 1;
				return this;
			}

			public Serving.OptionalResource.Builder setResource(Serving.Resource.Builder builderForValue) {
				this.resource_ = builderForValue.build();
				this.bitField0_ |= 1;
				return this;
			}

			public Serving.OptionalResource.Builder setResource(Serving.Resource value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.resource_ = value;
					this.bitField0_ |= 1;
					return this;
				}
			}
		}


		static {
			PARSER = new AbstractParser<Serving.OptionalResource>() {
			public Serving.OptionalResource parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Serving.OptionalResource(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Serving.OptionalResource(true);
			defaultInstance.initFields();
		}

		private OptionalResource(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
					case Serving.Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						Serving.Resource.Builder subBuilder = null;
						if ((this.bitField0_ & 1) == 1) {
							subBuilder = this.resource_.toBuilder();
						}
						this.resource_ = (Serving.Resource) input.readMessage(Serving.Resource.PARSER, extensionRegistry);
						if (subBuilder != null) {
							subBuilder.mergeFrom(this.resource_);
							this.resource_ = subBuilder.buildPartial();
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

		private OptionalResource(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private OptionalResource(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Serving.OptionalResource getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.resource_ = Serving.Resource.getDefaultInstance();
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Serving.OptionalResource prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Serving.OptionalResource parseDelimitedFrom(InputStream input) throws IOException {
			return (Serving.OptionalResource) PARSER.parseDelimitedFrom(input);
		}

		public static Serving.OptionalResource parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.OptionalResource) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Serving.OptionalResource parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Serving.OptionalResource) PARSER.parseFrom(data);
		}

		public static Serving.OptionalResource parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Serving.OptionalResource) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Serving.OptionalResource parseFrom(CodedInputStream input) throws IOException {
			return (Serving.OptionalResource) PARSER.parseFrom(input);
		}

		public static Serving.OptionalResource parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.OptionalResource) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Serving.OptionalResource parseFrom(InputStream input) throws IOException {
			return (Serving.OptionalResource) PARSER.parseFrom(input);
		}

		public static Serving.OptionalResource parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.OptionalResource) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Serving.OptionalResource parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Serving.OptionalResource) PARSER.parseFrom(data);
		}

		public static Serving.OptionalResource parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Serving.OptionalResource) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Serving.OptionalResource))) {
				return super.equals(obj);
			} else {
				boolean result;
				Serving.OptionalResource other = (Serving.OptionalResource) obj;
				if (!true || hasResource() != other.hasResource()) {
					result = false;
				} else {
					result = true;
				}
				if (hasResource()) {
					result = (!result || !getResource().equals(other.getResource())) ? false : true;
				}
				return result;
			}
		}

		public Serving.OptionalResource getDefaultInstanceForType() {
			return defaultInstance;
		}

		public Parser<Serving.OptionalResource> getParserForType() {
			return PARSER;
		}

		public Serving.Resource getResource() {
			return this.resource_;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				if ((this.bitField0_ & 1) == 1) {
					size += CodedOutputStream.computeMessageSize(RESOURCE_FIELD_NUMBER, this.resource_);
				}
				size += this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
		}

		public boolean hasResource() {
			return (this.bitField0_ & 1) == 1;
		}

		public int hashCode() {
			if (this.memoizedHashCode != 0) {
				return this.memoizedHashCode;
			} else {
				int hash = Serving.OptionalResource.class.hashCode() + 779;
				if (hasResource()) {
					hash = (((hash * 37) + 2) * 53) + getResource().hashCode();
				}
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$OptionalResource");
			}
			return mutableDefault;
		}

		public final boolean isInitialized() {
			byte isInitialized = this.memoizedIsInitialized;
			if (isInitialized != (byte) -1) {
				return isInitialized == (byte) 1;
			} else if (!hasResource() || getResource().isInitialized()) {
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
				output.writeMessage(RESOURCE_FIELD_NUMBER, this.resource_);
			}
			output.writeRawBytes(this.unknownFields);
		}
	}

	public static interface PropertyOrBuilder extends MessageLiteOrBuilder {
		public int getKey();

		public int getValue();

		public boolean hasKey();

		public boolean hasValue();
	}

	public static final class Property extends GeneratedMessageLite implements Serving.PropertyOrBuilder {
		public static final int KEY_FIELD_NUMBER = 1;
		public static Parser<Serving.Property> PARSER = null;
		public static final int VALUE_FIELD_NUMBER = 2;
		private static final Serving.Property defaultInstance;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private int key_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private final ByteString unknownFields;
		private int value_;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Serving.Property, Serving.Property.Builder> implements Serving.PropertyOrBuilder {
			private int bitField0_;
			private int key_;
			private int value_;

			private Builder() {
				maybeForceBuilderInitialization();
			}

			private static Serving.Property.Builder create() {
				return new Serving.Property.Builder();
			}

			private void maybeForceBuilderInitialization() {
			}

			public Serving.Property build() {
				Serving.Property result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Serving.Property buildPartial() {
				Serving.Property result = new Serving.Property((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
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

			public Serving.Property.Builder clear() {
				super.clear();
				this.key_ = 0;
				this.bitField0_ &= -2;
				this.value_ = 0;
				this.bitField0_ &= -3;
				return this;
			}

			public Serving.Property.Builder clearKey() {
				this.bitField0_ &= -2;
				this.key_ = 0;
				return this;
			}

			public Serving.Property.Builder clearValue() {
				this.bitField0_ &= -3;
				this.value_ = 0;
				return this;
			}

			public Serving.Property.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public Serving.Property getDefaultInstanceForType() {
				return Serving.Property.getDefaultInstance();
			}

			public int getKey() {
				return this.key_;
			}

			public int getValue() {
				return this.value_;
			}

			public boolean hasKey() {
				return (this.bitField0_ & 1) == 1;
			}

			public boolean hasValue() {
				return (this.bitField0_ & 2) == 2;
			}

			public final boolean isInitialized() {
				if (!hasKey()) {
					return false;
				} else {
					if (hasValue()) {
						return true;
					}
					return false;
				}
			}

			public Serving.Property.Builder mergeFrom(Serving.Property other) {
				if (other == Serving.Property.getDefaultInstance()) {
					return this;
				} else {
					if (other.hasKey()) {
						setKey(other.getKey());
					}
					if (other.hasValue()) {
						setValue(other.getValue());
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Serving.Property.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Serving.Property parsedMessage;
				try {
					parsedMessage = (Serving.Property) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Serving.Property) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Serving.Property.Builder setKey(int value) {
				this.bitField0_ |= 1;
				this.key_ = value;
				return this;
			}

			public Serving.Property.Builder setValue(int value) {
				this.bitField0_ |= 2;
				this.value_ = value;
				return this;
			}
		}


		static {
			PARSER = new AbstractParser<Serving.Property>() {
			public Serving.Property parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Serving.Property(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Serving.Property(true);
			defaultInstance.initFields();
		}

		private Property(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
					case CodedOutputStream.LITTLE_ENDIAN_64_SIZE:
						this.bitField0_ |= 1;
						this.key_ = input.readInt32();
						break;
					case Escaping.CONVERT_JS_VALUE_TO_EXPRESSION_VALUE:
						this.bitField0_ |= 2;
						this.value_ = input.readInt32();
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

		private Property(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private Property(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Serving.Property getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.key_ = 0;
			this.value_ = 0;
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Serving.Property prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Serving.Property parseDelimitedFrom(InputStream input) throws IOException {
			return (Serving.Property) PARSER.parseDelimitedFrom(input);
		}

		public static Serving.Property parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.Property) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Serving.Property parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Serving.Property) PARSER.parseFrom(data);
		}

		public static Serving.Property parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Serving.Property) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Serving.Property parseFrom(CodedInputStream input) throws IOException {
			return (Serving.Property) PARSER.parseFrom(input);
		}

		public static Serving.Property parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.Property) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Serving.Property parseFrom(InputStream input) throws IOException {
			return (Serving.Property) PARSER.parseFrom(input);
		}

		public static Serving.Property parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.Property) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Serving.Property parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Serving.Property) PARSER.parseFrom(data);
		}

		public static Serving.Property parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Serving.Property) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Serving.Property))) {
				return super.equals(obj);
			} else {
				boolean result;
				Serving.Property other = (Serving.Property) obj;
				if (!true || hasKey() != other.hasKey()) {
					result = false;
				} else {
					result = true;
				}
				if (hasKey()) {
					result = (!result || getKey() != other.getKey()) ? false : true;
				}
				if (!result || hasValue() != other.hasValue()) {
					result = false;
				} else {
					result = true;
				}
				if (hasValue()) {
					result = (!result || getValue() != other.getValue()) ? false : true;
				}
				return result;
			}
		}

		public Serving.Property getDefaultInstanceForType() {
			return defaultInstance;
		}

		public int getKey() {
			return this.key_;
		}

		public Parser<Serving.Property> getParserForType() {
			return PARSER;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				if ((this.bitField0_ & 1) == 1) {
					size += CodedOutputStream.computeInt32Size(KEY_FIELD_NUMBER, this.key_);
				}
				if ((this.bitField0_ & 2) == 2) {
					size += CodedOutputStream.computeInt32Size(VALUE_FIELD_NUMBER, this.value_);
				}
				size += this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
		}

		public int getValue() {
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
				int hash = Serving.Property.class.hashCode() + 779;
				if (hasKey()) {
					hash = (((hash * 37) + 1) * 53) + getKey();
				}
				if (hasValue()) {
					hash = (((hash * 37) + 2) * 53) + getValue();
				}
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$Property");
			}
			return mutableDefault;
		}

		public final boolean isInitialized() {
			byte isInitialized = this.memoizedIsInitialized;
			if (isInitialized != (byte) -1) {
				return isInitialized == (byte) 1;
			} else if (!hasKey()) {
				this.memoizedIsInitialized = (byte) 0;
				return false;
			} else if (!hasValue()) {
				this.memoizedIsInitialized = (byte) 0;
				return false;
			} else {
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
			if ((this.bitField0_ & 1) == 1) {
				output.writeInt32(KEY_FIELD_NUMBER, this.key_);
			}
			if ((this.bitField0_ & 2) == 2) {
				output.writeInt32(VALUE_FIELD_NUMBER, this.value_);
			}
			output.writeRawBytes(this.unknownFields);
		}
	}

	public static interface ResourceOrBuilder extends MessageLiteOrBuilder {
		public boolean getEnableAutoEventTracking();

		public String getKey(int r1i);

		public ByteString getKeyBytes(int r1i);

		public int getKeyCount();

		public List<String> getKeyList();

		public Serving.CacheOption getLiveJsCacheOption();

		public Serving.FunctionCall getMacro(int r1i);

		public int getMacroCount();

		public List<Serving.FunctionCall> getMacroList();

		public String getMalwareScanAuthCode();

		public ByteString getMalwareScanAuthCodeBytes();

		public Serving.FunctionCall getPredicate(int r1i);

		public int getPredicateCount();

		public List<Serving.FunctionCall> getPredicateList();

		public String getPreviewAuthCode();

		public ByteString getPreviewAuthCodeBytes();

		public Serving.Property getProperty(int r1i);

		public int getPropertyCount();

		public List<Serving.Property> getPropertyList();

		public float getReportingSampleRate();

		public int getResourceFormatVersion();

		public Serving.Rule getRule(int r1i);

		public int getRuleCount();

		public List<Serving.Rule> getRuleList();

		public Serving.FunctionCall getTag(int r1i);

		public int getTagCount();

		public List<Serving.FunctionCall> getTagList();

		public String getTemplateVersionSet();

		public ByteString getTemplateVersionSetBytes();

		public String getUsageContext(int r1i);

		public ByteString getUsageContextBytes(int r1i);

		public int getUsageContextCount();

		public List<String> getUsageContextList();

		public Value getValue(int r1i);

		public int getValueCount();

		public List<Value> getValueList();

		public String getVersion();

		public ByteString getVersionBytes();

		public boolean hasEnableAutoEventTracking();

		public boolean hasLiveJsCacheOption();

		public boolean hasMalwareScanAuthCode();

		public boolean hasPreviewAuthCode();

		public boolean hasReportingSampleRate();

		public boolean hasResourceFormatVersion();

		public boolean hasTemplateVersionSet();

		public boolean hasVersion();
	}

	public static final class Resource extends GeneratedMessageLite implements Serving.ResourceOrBuilder {
		public static final int ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER = 18;
		public static final int KEY_FIELD_NUMBER = 1;
		public static final int LIVE_JS_CACHE_OPTION_FIELD_NUMBER = 14;
		public static final int MACRO_FIELD_NUMBER = 4;
		public static final int MALWARE_SCAN_AUTH_CODE_FIELD_NUMBER = 10;
		public static Parser<Serving.Resource> PARSER = null;
		public static final int PREDICATE_FIELD_NUMBER = 6;
		public static final int PREVIEW_AUTH_CODE_FIELD_NUMBER = 9;
		public static final int PROPERTY_FIELD_NUMBER = 3;
		public static final int REPORTING_SAMPLE_RATE_FIELD_NUMBER = 15;
		public static final int RESOURCE_FORMAT_VERSION_FIELD_NUMBER = 17;
		public static final int RULE_FIELD_NUMBER = 7;
		public static final int TAG_FIELD_NUMBER = 5;
		public static final int TEMPLATE_VERSION_SET_FIELD_NUMBER = 12;
		public static final int USAGE_CONTEXT_FIELD_NUMBER = 16;
		public static final int VALUE_FIELD_NUMBER = 2;
		public static final int VERSION_FIELD_NUMBER = 13;
		private static final Serving.Resource defaultInstance;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private boolean enableAutoEventTracking_;
		private LazyStringList key_;
		private Serving.CacheOption liveJsCacheOption_;
		private List<Serving.FunctionCall> macro_;
		private Object malwareScanAuthCode_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private List<Serving.FunctionCall> predicate_;
		private Object previewAuthCode_;
		private List<Serving.Property> property_;
		private float reportingSampleRate_;
		private int resourceFormatVersion_;
		private List<Serving.Rule> rule_;
		private List<Serving.FunctionCall> tag_;
		private Object templateVersionSet_;
		private final ByteString unknownFields;
		private LazyStringList usageContext_;
		private List<Value> value_;
		private Object version_;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Serving.Resource, Serving.Resource.Builder> implements Serving.ResourceOrBuilder {
			private int bitField0_;
			private boolean enableAutoEventTracking_;
			private LazyStringList key_;
			private Serving.CacheOption liveJsCacheOption_;
			private List<Serving.FunctionCall> macro_;
			private Object malwareScanAuthCode_;
			private List<Serving.FunctionCall> predicate_;
			private Object previewAuthCode_;
			private List<Serving.Property> property_;
			private float reportingSampleRate_;
			private int resourceFormatVersion_;
			private List<Serving.Rule> rule_;
			private List<Serving.FunctionCall> tag_;
			private Object templateVersionSet_;
			private LazyStringList usageContext_;
			private List<Value> value_;
			private Object version_;

			private Builder() {
				this.key_ = LazyStringArrayList.EMPTY;
				this.value_ = Collections.emptyList();
				this.property_ = Collections.emptyList();
				this.macro_ = Collections.emptyList();
				this.tag_ = Collections.emptyList();
				this.predicate_ = Collections.emptyList();
				this.rule_ = Collections.emptyList();
				this.previewAuthCode_ = "";
				this.malwareScanAuthCode_ = "";
				this.templateVersionSet_ = "0";
				this.version_ = "";
				this.liveJsCacheOption_ = Serving.CacheOption.getDefaultInstance();
				this.usageContext_ = LazyStringArrayList.EMPTY;
				maybeForceBuilderInitialization();
			}

			private static Serving.Resource.Builder create() {
				return new Serving.Resource.Builder();
			}

			private void ensureKeyIsMutable() {
				if ((this.bitField0_ & 1) != 1) {
					this.key_ = new LazyStringArrayList(this.key_);
					this.bitField0_ |= 1;
				}
			}

			private void ensureMacroIsMutable() {
				if ((this.bitField0_ & 8) != 8) {
					this.macro_ = new ArrayList(this.macro_);
					this.bitField0_ |= 8;
				}
			}

			private void ensurePredicateIsMutable() {
				if ((this.bitField0_ & 32) != 32) {
					this.predicate_ = new ArrayList(this.predicate_);
					this.bitField0_ |= 32;
				}
			}

			private void ensurePropertyIsMutable() {
				if ((this.bitField0_ & 4) != 4) {
					this.property_ = new ArrayList(this.property_);
					this.bitField0_ |= 4;
				}
			}

			private void ensureRuleIsMutable() {
				if ((this.bitField0_ & 64) != 64) {
					this.rule_ = new ArrayList(this.rule_);
					this.bitField0_ |= 64;
				}
			}

			private void ensureTagIsMutable() {
				if ((this.bitField0_ & 16) != 16) {
					this.tag_ = new ArrayList(this.tag_);
					this.bitField0_ |= 16;
				}
			}

			private void ensureUsageContextIsMutable() {
				if ((this.bitField0_ & 16384) != 16384) {
					this.usageContext_ = new LazyStringArrayList(this.usageContext_);
					this.bitField0_ |= 16384;
				}
			}

			private void ensureValueIsMutable() {
				if ((this.bitField0_ & 2) != 2) {
					this.value_ = new ArrayList(this.value_);
					this.bitField0_ |= 2;
				}
			}

			private void maybeForceBuilderInitialization() {
			}

			public Serving.Resource.Builder addAllKey(Iterable<String> values) {
				ensureKeyIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.key_);
				return this;
			}

			public Serving.Resource.Builder addAllMacro(Iterable<Serving.FunctionCall> values) {
				ensureMacroIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.macro_);
				return this;
			}

			public Serving.Resource.Builder addAllPredicate(Iterable<Serving.FunctionCall> values) {
				ensurePredicateIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.predicate_);
				return this;
			}

			public Serving.Resource.Builder addAllProperty(Iterable<Serving.Property> values) {
				ensurePropertyIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.property_);
				return this;
			}

			public Serving.Resource.Builder addAllRule(Iterable<Serving.Rule> values) {
				ensureRuleIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.rule_);
				return this;
			}

			public Serving.Resource.Builder addAllTag(Iterable<Serving.FunctionCall> values) {
				ensureTagIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.tag_);
				return this;
			}

			public Serving.Resource.Builder addAllUsageContext(Iterable<String> values) {
				ensureUsageContextIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.usageContext_);
				return this;
			}

			public Serving.Resource.Builder addAllValue(Iterable<Value> values) {
				ensureValueIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.value_);
				return this;
			}

			public Serving.Resource.Builder addKey(String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureKeyIsMutable();
					this.key_.add(value);
					return this;
				}
			}

			public Serving.Resource.Builder addKeyBytes(ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureKeyIsMutable();
					this.key_.add(value);
					return this;
				}
			}

			public Serving.Resource.Builder addMacro(int index, Serving.FunctionCall.Builder builderForValue) {
				ensureMacroIsMutable();
				this.macro_.add(index, builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder addMacro(int index, Serving.FunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureMacroIsMutable();
					this.macro_.add(index, value);
					return this;
				}
			}

			public Serving.Resource.Builder addMacro(Serving.FunctionCall.Builder builderForValue) {
				ensureMacroIsMutable();
				this.macro_.add(builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder addMacro(Serving.FunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureMacroIsMutable();
					this.macro_.add(value);
					return this;
				}
			}

			public Serving.Resource.Builder addPredicate(int index, Serving.FunctionCall.Builder builderForValue) {
				ensurePredicateIsMutable();
				this.predicate_.add(index, builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder addPredicate(int index, Serving.FunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensurePredicateIsMutable();
					this.predicate_.add(index, value);
					return this;
				}
			}

			public Serving.Resource.Builder addPredicate(Serving.FunctionCall.Builder builderForValue) {
				ensurePredicateIsMutable();
				this.predicate_.add(builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder addPredicate(Serving.FunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensurePredicateIsMutable();
					this.predicate_.add(value);
					return this;
				}
			}

			public Serving.Resource.Builder addProperty(int index, Serving.Property.Builder builderForValue) {
				ensurePropertyIsMutable();
				this.property_.add(index, builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder addProperty(int index, Serving.Property value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensurePropertyIsMutable();
					this.property_.add(index, value);
					return this;
				}
			}

			public Serving.Resource.Builder addProperty(Serving.Property.Builder builderForValue) {
				ensurePropertyIsMutable();
				this.property_.add(builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder addProperty(Serving.Property value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensurePropertyIsMutable();
					this.property_.add(value);
					return this;
				}
			}

			public Serving.Resource.Builder addRule(int index, Serving.Rule.Builder builderForValue) {
				ensureRuleIsMutable();
				this.rule_.add(index, builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder addRule(int index, Serving.Rule value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureRuleIsMutable();
					this.rule_.add(index, value);
					return this;
				}
			}

			public Serving.Resource.Builder addRule(Serving.Rule.Builder builderForValue) {
				ensureRuleIsMutable();
				this.rule_.add(builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder addRule(Serving.Rule value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureRuleIsMutable();
					this.rule_.add(value);
					return this;
				}
			}

			public Serving.Resource.Builder addTag(int index, Serving.FunctionCall.Builder builderForValue) {
				ensureTagIsMutable();
				this.tag_.add(index, builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder addTag(int index, Serving.FunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureTagIsMutable();
					this.tag_.add(index, value);
					return this;
				}
			}

			public Serving.Resource.Builder addTag(Serving.FunctionCall.Builder builderForValue) {
				ensureTagIsMutable();
				this.tag_.add(builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder addTag(Serving.FunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureTagIsMutable();
					this.tag_.add(value);
					return this;
				}
			}

			public Serving.Resource.Builder addUsageContext(String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureUsageContextIsMutable();
					this.usageContext_.add(value);
					return this;
				}
			}

			public Serving.Resource.Builder addUsageContextBytes(ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureUsageContextIsMutable();
					this.usageContext_.add(value);
					return this;
				}
			}

			public Serving.Resource.Builder addValue(int index, com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builderForValue) {
				ensureValueIsMutable();
				this.value_.add(index, builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder addValue(int index, Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureValueIsMutable();
					this.value_.add(index, value);
					return this;
				}
			}

			public Serving.Resource.Builder addValue(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builderForValue) {
				ensureValueIsMutable();
				this.value_.add(builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder addValue(Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureValueIsMutable();
					this.value_.add(value);
					return this;
				}
			}

			public Serving.Resource build() {
				Serving.Resource result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Serving.Resource buildPartial() {
				Serving.Resource result = new Serving.Resource((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
				int from_bitField0_ = this.bitField0_;
				int to_bitField0_ = 0;
				if ((this.bitField0_ & 1) == 1) {
					this.key_ = new UnmodifiableLazyStringList(this.key_);
					this.bitField0_ &= -2;
				}
				result.key_ = this.key_;
				if ((this.bitField0_ & 2) == 2) {
					this.value_ = Collections.unmodifiableList(this.value_);
					this.bitField0_ &= -3;
				}
				result.value_ = this.value_;
				if ((this.bitField0_ & 4) == 4) {
					this.property_ = Collections.unmodifiableList(this.property_);
					this.bitField0_ &= -5;
				}
				result.property_ = this.property_;
				if ((this.bitField0_ & 8) == 8) {
					this.macro_ = Collections.unmodifiableList(this.macro_);
					this.bitField0_ &= -9;
				}
				result.macro_ = this.macro_;
				if ((this.bitField0_ & 16) == 16) {
					this.tag_ = Collections.unmodifiableList(this.tag_);
					this.bitField0_ &= -17;
				}
				result.tag_ = this.tag_;
				if ((this.bitField0_ & 32) == 32) {
					this.predicate_ = Collections.unmodifiableList(this.predicate_);
					this.bitField0_ &= -33;
				}
				result.predicate_ = this.predicate_;
				if ((this.bitField0_ & 64) == 64) {
					this.rule_ = Collections.unmodifiableList(this.rule_);
					this.bitField0_ &= -65;
				}
				result.rule_ = this.rule_;
				if ((from_bitField0_ & 128) == 128) {
					to_bitField0_ |= 1;
				}
				result.previewAuthCode_ = this.previewAuthCode_;
				if ((from_bitField0_ & 256) == 256) {
					to_bitField0_ |= 2;
				}
				result.malwareScanAuthCode_ = this.malwareScanAuthCode_;
				if ((from_bitField0_ & 512) == 512) {
					to_bitField0_ |= 4;
				}
				result.templateVersionSet_ = this.templateVersionSet_;
				if ((from_bitField0_ & 1024) == 1024) {
					to_bitField0_ |= 8;
				}
				result.version_ = this.version_;
				if ((from_bitField0_ & 2048) == 2048) {
					to_bitField0_ |= 16;
				}
				result.liveJsCacheOption_ = this.liveJsCacheOption_;
				if ((from_bitField0_ & 4096) == 4096) {
					to_bitField0_ |= 32;
				}
				result.reportingSampleRate_ = this.reportingSampleRate_;
				if ((from_bitField0_ & 8192) == 8192) {
					to_bitField0_ |= 64;
				}
				result.enableAutoEventTracking_ = this.enableAutoEventTracking_;
				if ((this.bitField0_ & 16384) == 16384) {
					this.usageContext_ = new UnmodifiableLazyStringList(this.usageContext_);
					this.bitField0_ &= -16385;
				}
				result.usageContext_ = this.usageContext_;
				if ((from_bitField0_ & 32768) == 32768) {
					to_bitField0_ |= 128;
				}
				result.resourceFormatVersion_ = this.resourceFormatVersion_;
				result.bitField0_ = to_bitField0_;
				return result;
			}

			public Serving.Resource.Builder clear() {
				super.clear();
				this.key_ = LazyStringArrayList.EMPTY;
				this.bitField0_ &= -2;
				this.value_ = Collections.emptyList();
				this.bitField0_ &= -3;
				this.property_ = Collections.emptyList();
				this.bitField0_ &= -5;
				this.macro_ = Collections.emptyList();
				this.bitField0_ &= -9;
				this.tag_ = Collections.emptyList();
				this.bitField0_ &= -17;
				this.predicate_ = Collections.emptyList();
				this.bitField0_ &= -33;
				this.rule_ = Collections.emptyList();
				this.bitField0_ &= -65;
				this.previewAuthCode_ = "";
				this.bitField0_ &= -129;
				this.malwareScanAuthCode_ = "";
				this.bitField0_ &= -257;
				this.templateVersionSet_ = "0";
				this.bitField0_ &= -513;
				this.version_ = "";
				this.bitField0_ &= -1025;
				this.liveJsCacheOption_ = Serving.CacheOption.getDefaultInstance();
				this.bitField0_ &= -2049;
				this.reportingSampleRate_ = 0.0f;
				this.bitField0_ &= -4097;
				this.enableAutoEventTracking_ = false;
				this.bitField0_ &= -8193;
				this.usageContext_ = LazyStringArrayList.EMPTY;
				this.bitField0_ &= -16385;
				this.resourceFormatVersion_ = 0;
				this.bitField0_ &= -32769;
				return this;
			}

			public Serving.Resource.Builder clearEnableAutoEventTracking() {
				this.bitField0_ &= -8193;
				this.enableAutoEventTracking_ = false;
				return this;
			}

			public Serving.Resource.Builder clearKey() {
				this.key_ = LazyStringArrayList.EMPTY;
				this.bitField0_ &= -2;
				return this;
			}

			public Serving.Resource.Builder clearLiveJsCacheOption() {
				this.liveJsCacheOption_ = Serving.CacheOption.getDefaultInstance();
				this.bitField0_ &= -2049;
				return this;
			}

			public Serving.Resource.Builder clearMacro() {
				this.macro_ = Collections.emptyList();
				this.bitField0_ &= -9;
				return this;
			}

			public Serving.Resource.Builder clearMalwareScanAuthCode() {
				this.bitField0_ &= -257;
				this.malwareScanAuthCode_ = Serving.Resource.getDefaultInstance().getMalwareScanAuthCode();
				return this;
			}

			public Serving.Resource.Builder clearPredicate() {
				this.predicate_ = Collections.emptyList();
				this.bitField0_ &= -33;
				return this;
			}

			public Serving.Resource.Builder clearPreviewAuthCode() {
				this.bitField0_ &= -129;
				this.previewAuthCode_ = Serving.Resource.getDefaultInstance().getPreviewAuthCode();
				return this;
			}

			public Serving.Resource.Builder clearProperty() {
				this.property_ = Collections.emptyList();
				this.bitField0_ &= -5;
				return this;
			}

			public Serving.Resource.Builder clearReportingSampleRate() {
				this.bitField0_ &= -4097;
				this.reportingSampleRate_ = 0.0f;
				return this;
			}

			public Serving.Resource.Builder clearResourceFormatVersion() {
				this.bitField0_ &= -32769;
				this.resourceFormatVersion_ = 0;
				return this;
			}

			public Serving.Resource.Builder clearRule() {
				this.rule_ = Collections.emptyList();
				this.bitField0_ &= -65;
				return this;
			}

			public Serving.Resource.Builder clearTag() {
				this.tag_ = Collections.emptyList();
				this.bitField0_ &= -17;
				return this;
			}

			public Serving.Resource.Builder clearTemplateVersionSet() {
				this.bitField0_ &= -513;
				this.templateVersionSet_ = Serving.Resource.getDefaultInstance().getTemplateVersionSet();
				return this;
			}

			public Serving.Resource.Builder clearUsageContext() {
				this.usageContext_ = LazyStringArrayList.EMPTY;
				this.bitField0_ &= -16385;
				return this;
			}

			public Serving.Resource.Builder clearValue() {
				this.value_ = Collections.emptyList();
				this.bitField0_ &= -3;
				return this;
			}

			public Serving.Resource.Builder clearVersion() {
				this.bitField0_ &= -1025;
				this.version_ = Serving.Resource.getDefaultInstance().getVersion();
				return this;
			}

			public Serving.Resource.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public Serving.Resource getDefaultInstanceForType() {
				return Serving.Resource.getDefaultInstance();
			}

			public boolean getEnableAutoEventTracking() {
				return this.enableAutoEventTracking_;
			}

			public String getKey(int index) {
				return (String) this.key_.get(index);
			}

			public ByteString getKeyBytes(int index) {
				return this.key_.getByteString(index);
			}

			public int getKeyCount() {
				return this.key_.size();
			}

			public List<String> getKeyList() {
				return Collections.unmodifiableList(this.key_);
			}

			public Serving.CacheOption getLiveJsCacheOption() {
				return this.liveJsCacheOption_;
			}

			public Serving.FunctionCall getMacro(int index) {
				return (Serving.FunctionCall) this.macro_.get(index);
			}

			public int getMacroCount() {
				return this.macro_.size();
			}

			public List<Serving.FunctionCall> getMacroList() {
				return Collections.unmodifiableList(this.macro_);
			}

			public String getMalwareScanAuthCode() {
				Object ref = this.malwareScanAuthCode_;
				if (!((ref instanceof String))) {
					ByteString bs = (ByteString) ref;
					String s = bs.toStringUtf8();
					if (bs.isValidUtf8()) {
						this.malwareScanAuthCode_ = s;
						return s;
					}
					return s;
				} else {
					return (String) ref;
				}
			}

			public ByteString getMalwareScanAuthCodeBytes() {
				Object ref = this.malwareScanAuthCode_;
				if (ref instanceof String) {
					ByteString b = ByteString.copyFromUtf8((String) ref);
					this.malwareScanAuthCode_ = b;
					return b;
				} else {
					return (ByteString) ref;
				}
			}

			public Serving.FunctionCall getPredicate(int index) {
				return (Serving.FunctionCall) this.predicate_.get(index);
			}

			public int getPredicateCount() {
				return this.predicate_.size();
			}

			public List<Serving.FunctionCall> getPredicateList() {
				return Collections.unmodifiableList(this.predicate_);
			}

			public String getPreviewAuthCode() {
				Object ref = this.previewAuthCode_;
				if (!((ref instanceof String))) {
					ByteString bs = (ByteString) ref;
					String s = bs.toStringUtf8();
					if (bs.isValidUtf8()) {
						this.previewAuthCode_ = s;
						return s;
					}
					return s;
				} else {
					return (String) ref;
				}
			}

			public ByteString getPreviewAuthCodeBytes() {
				Object ref = this.previewAuthCode_;
				if (ref instanceof String) {
					ByteString b = ByteString.copyFromUtf8((String) ref);
					this.previewAuthCode_ = b;
					return b;
				} else {
					return (ByteString) ref;
				}
			}

			public Serving.Property getProperty(int index) {
				return (Serving.Property) this.property_.get(index);
			}

			public int getPropertyCount() {
				return this.property_.size();
			}

			public List<Serving.Property> getPropertyList() {
				return Collections.unmodifiableList(this.property_);
			}

			public float getReportingSampleRate() {
				return this.reportingSampleRate_;
			}

			public int getResourceFormatVersion() {
				return this.resourceFormatVersion_;
			}

			public Serving.Rule getRule(int index) {
				return (Serving.Rule) this.rule_.get(index);
			}

			public int getRuleCount() {
				return this.rule_.size();
			}

			public List<Serving.Rule> getRuleList() {
				return Collections.unmodifiableList(this.rule_);
			}

			public Serving.FunctionCall getTag(int index) {
				return (Serving.FunctionCall) this.tag_.get(index);
			}

			public int getTagCount() {
				return this.tag_.size();
			}

			public List<Serving.FunctionCall> getTagList() {
				return Collections.unmodifiableList(this.tag_);
			}

			public String getTemplateVersionSet() {
				Object ref = this.templateVersionSet_;
				if (!((ref instanceof String))) {
					ByteString bs = (ByteString) ref;
					String s = bs.toStringUtf8();
					if (bs.isValidUtf8()) {
						this.templateVersionSet_ = s;
						return s;
					}
					return s;
				} else {
					return (String) ref;
				}
			}

			public ByteString getTemplateVersionSetBytes() {
				Object ref = this.templateVersionSet_;
				if (ref instanceof String) {
					ByteString b = ByteString.copyFromUtf8((String) ref);
					this.templateVersionSet_ = b;
					return b;
				} else {
					return (ByteString) ref;
				}
			}

			public String getUsageContext(int index) {
				return (String) this.usageContext_.get(index);
			}

			public ByteString getUsageContextBytes(int index) {
				return this.usageContext_.getByteString(index);
			}

			public int getUsageContextCount() {
				return this.usageContext_.size();
			}

			public List<String> getUsageContextList() {
				return Collections.unmodifiableList(this.usageContext_);
			}

			public Value getValue(int index) {
				return (Value) this.value_.get(index);
			}

			public int getValueCount() {
				return this.value_.size();
			}

			public List<Value> getValueList() {
				return Collections.unmodifiableList(this.value_);
			}

			public String getVersion() {
				Object ref = this.version_;
				if (!((ref instanceof String))) {
					ByteString bs = (ByteString) ref;
					String s = bs.toStringUtf8();
					if (bs.isValidUtf8()) {
						this.version_ = s;
						return s;
					}
					return s;
				} else {
					return (String) ref;
				}
			}

			public ByteString getVersionBytes() {
				Object ref = this.version_;
				if (ref instanceof String) {
					ByteString b = ByteString.copyFromUtf8((String) ref);
					this.version_ = b;
					return b;
				} else {
					return (ByteString) ref;
				}
			}

			public boolean hasEnableAutoEventTracking() {
				return (this.bitField0_ & 8192) == 8192;
			}

			public boolean hasLiveJsCacheOption() {
				return (this.bitField0_ & 2048) == 2048;
			}

			public boolean hasMalwareScanAuthCode() {
				return (this.bitField0_ & 256) == 256;
			}

			public boolean hasPreviewAuthCode() {
				return (this.bitField0_ & 128) == 128;
			}

			public boolean hasReportingSampleRate() {
				return (this.bitField0_ & 4096) == 4096;
			}

			public boolean hasResourceFormatVersion() {
				return (this.bitField0_ & 32768) == 32768;
			}

			public boolean hasTemplateVersionSet() {
				return (this.bitField0_ & 512) == 512;
			}

			public boolean hasVersion() {
				return (this.bitField0_ & 1024) == 1024;
			}

			public final boolean isInitialized() {
				int i = 0;
				while (i < getValueCount()) {
					if (!getValue(i).isInitialized()) {
						return false;
					} else {
						i++;
					}
				}
				i = 0;
				while (i < getPropertyCount()) {
					if (getProperty(i).isInitialized()) {
						i++;
					}
					return false;
				}
				i = 0;
				while (i < getMacroCount()) {
					if (getMacro(i).isInitialized()) {
						i++;
					}
					return false;
				}
				i = 0;
				while (i < getTagCount()) {
					if (getTag(i).isInitialized()) {
						i++;
					}
					return false;
				}
				i = 0;
				while (i < getPredicateCount()) {
					if (getPredicate(i).isInitialized()) {
						i++;
					}
					return false;
				}
				return true;
			}

			public Serving.Resource.Builder mergeFrom(Serving.Resource other) {
				if (other == Serving.Resource.getDefaultInstance()) {
					return this;
				} else {
					if (!other.key_.isEmpty()) {
						if (this.key_.isEmpty()) {
							this.key_ = other.key_;
							this.bitField0_ &= -2;
						} else {
							ensureKeyIsMutable();
							this.key_.addAll(other.key_);
						}
					}
					if (!other.value_.isEmpty()) {
						if (this.value_.isEmpty()) {
							this.value_ = other.value_;
							this.bitField0_ &= -3;
						} else {
							ensureValueIsMutable();
							this.value_.addAll(other.value_);
						}
					}
					if (!other.property_.isEmpty()) {
						if (this.property_.isEmpty()) {
							this.property_ = other.property_;
							this.bitField0_ &= -5;
						} else {
							ensurePropertyIsMutable();
							this.property_.addAll(other.property_);
						}
					}
					if (!other.macro_.isEmpty()) {
						if (this.macro_.isEmpty()) {
							this.macro_ = other.macro_;
							this.bitField0_ &= -9;
						} else {
							ensureMacroIsMutable();
							this.macro_.addAll(other.macro_);
						}
					}
					if (!other.tag_.isEmpty()) {
						if (this.tag_.isEmpty()) {
							this.tag_ = other.tag_;
							this.bitField0_ &= -17;
						} else {
							ensureTagIsMutable();
							this.tag_.addAll(other.tag_);
						}
					}
					if (!other.predicate_.isEmpty()) {
						if (this.predicate_.isEmpty()) {
							this.predicate_ = other.predicate_;
							this.bitField0_ &= -33;
						} else {
							ensurePredicateIsMutable();
							this.predicate_.addAll(other.predicate_);
						}
					}
					if (!other.rule_.isEmpty()) {
						if (this.rule_.isEmpty()) {
							this.rule_ = other.rule_;
							this.bitField0_ &= -65;
						} else {
							ensureRuleIsMutable();
							this.rule_.addAll(other.rule_);
						}
					}
					if (other.hasPreviewAuthCode()) {
						this.bitField0_ |= 128;
						this.previewAuthCode_ = other.previewAuthCode_;
					}
					if (other.hasMalwareScanAuthCode()) {
						this.bitField0_ |= 256;
						this.malwareScanAuthCode_ = other.malwareScanAuthCode_;
					}
					if (other.hasTemplateVersionSet()) {
						this.bitField0_ |= 512;
						this.templateVersionSet_ = other.templateVersionSet_;
					}
					if (other.hasVersion()) {
						this.bitField0_ |= 1024;
						this.version_ = other.version_;
					}
					if (other.hasLiveJsCacheOption()) {
						mergeLiveJsCacheOption(other.getLiveJsCacheOption());
					}
					if (other.hasReportingSampleRate()) {
						setReportingSampleRate(other.getReportingSampleRate());
					}
					if (other.hasEnableAutoEventTracking()) {
						setEnableAutoEventTracking(other.getEnableAutoEventTracking());
					}
					if (!other.usageContext_.isEmpty()) {
						if (this.usageContext_.isEmpty()) {
							this.usageContext_ = other.usageContext_;
							this.bitField0_ &= -16385;
						} else {
							ensureUsageContextIsMutable();
							this.usageContext_.addAll(other.usageContext_);
						}
					}
					if (other.hasResourceFormatVersion()) {
						setResourceFormatVersion(other.getResourceFormatVersion());
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Serving.Resource.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Serving.Resource parsedMessage;
				try {
					parsedMessage = (Serving.Resource) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Serving.Resource) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Serving.Resource.Builder mergeLiveJsCacheOption(Serving.CacheOption value) {
				if ((this.bitField0_ & 2048) != 2048 || this.liveJsCacheOption_ == Serving.CacheOption.getDefaultInstance()) {
					this.liveJsCacheOption_ = value;
				} else {
					this.liveJsCacheOption_ = Serving.CacheOption.newBuilder(this.liveJsCacheOption_).mergeFrom(value).buildPartial();
				}
				this.bitField0_ |= 2048;
				return this;
			}

			public Serving.Resource.Builder removeMacro(int index) {
				ensureMacroIsMutable();
				this.macro_.remove(index);
				return this;
			}

			public Serving.Resource.Builder removePredicate(int index) {
				ensurePredicateIsMutable();
				this.predicate_.remove(index);
				return this;
			}

			public Serving.Resource.Builder removeProperty(int index) {
				ensurePropertyIsMutable();
				this.property_.remove(index);
				return this;
			}

			public Serving.Resource.Builder removeRule(int index) {
				ensureRuleIsMutable();
				this.rule_.remove(index);
				return this;
			}

			public Serving.Resource.Builder removeTag(int index) {
				ensureTagIsMutable();
				this.tag_.remove(index);
				return this;
			}

			public Serving.Resource.Builder removeValue(int index) {
				ensureValueIsMutable();
				this.value_.remove(index);
				return this;
			}

			public Serving.Resource.Builder setEnableAutoEventTracking(boolean value) {
				this.bitField0_ |= 8192;
				this.enableAutoEventTracking_ = value;
				return this;
			}

			public Serving.Resource.Builder setKey(int index, String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureKeyIsMutable();
					this.key_.set(index, value);
					return this;
				}
			}

			public Serving.Resource.Builder setLiveJsCacheOption(Serving.CacheOption.Builder builderForValue) {
				this.liveJsCacheOption_ = builderForValue.build();
				this.bitField0_ |= 2048;
				return this;
			}

			public Serving.Resource.Builder setLiveJsCacheOption(Serving.CacheOption value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.liveJsCacheOption_ = value;
					this.bitField0_ |= 2048;
					return this;
				}
			}

			public Serving.Resource.Builder setMacro(int index, Serving.FunctionCall.Builder builderForValue) {
				ensureMacroIsMutable();
				this.macro_.set(index, builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder setMacro(int index, Serving.FunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureMacroIsMutable();
					this.macro_.set(index, value);
					return this;
				}
			}

			public Serving.Resource.Builder setMalwareScanAuthCode(String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 256;
					this.malwareScanAuthCode_ = value;
					return this;
				}
			}

			public Serving.Resource.Builder setMalwareScanAuthCodeBytes(ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 256;
					this.malwareScanAuthCode_ = value;
					return this;
				}
			}

			public Serving.Resource.Builder setPredicate(int index, Serving.FunctionCall.Builder builderForValue) {
				ensurePredicateIsMutable();
				this.predicate_.set(index, builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder setPredicate(int index, Serving.FunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensurePredicateIsMutable();
					this.predicate_.set(index, value);
					return this;
				}
			}

			public Serving.Resource.Builder setPreviewAuthCode(String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 128;
					this.previewAuthCode_ = value;
					return this;
				}
			}

			public Serving.Resource.Builder setPreviewAuthCodeBytes(ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 128;
					this.previewAuthCode_ = value;
					return this;
				}
			}

			public Serving.Resource.Builder setProperty(int index, Serving.Property.Builder builderForValue) {
				ensurePropertyIsMutable();
				this.property_.set(index, builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder setProperty(int index, Serving.Property value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensurePropertyIsMutable();
					this.property_.set(index, value);
					return this;
				}
			}

			public Serving.Resource.Builder setReportingSampleRate(float value) {
				this.bitField0_ |= 4096;
				this.reportingSampleRate_ = value;
				return this;
			}

			public Serving.Resource.Builder setResourceFormatVersion(int value) {
				this.bitField0_ |= 32768;
				this.resourceFormatVersion_ = value;
				return this;
			}

			public Serving.Resource.Builder setRule(int index, Serving.Rule.Builder builderForValue) {
				ensureRuleIsMutable();
				this.rule_.set(index, builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder setRule(int index, Serving.Rule value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureRuleIsMutable();
					this.rule_.set(index, value);
					return this;
				}
			}

			public Serving.Resource.Builder setTag(int index, Serving.FunctionCall.Builder builderForValue) {
				ensureTagIsMutable();
				this.tag_.set(index, builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder setTag(int index, Serving.FunctionCall value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureTagIsMutable();
					this.tag_.set(index, value);
					return this;
				}
			}

			public Serving.Resource.Builder setTemplateVersionSet(String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 512;
					this.templateVersionSet_ = value;
					return this;
				}
			}

			public Serving.Resource.Builder setTemplateVersionSetBytes(ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 512;
					this.templateVersionSet_ = value;
					return this;
				}
			}

			public Serving.Resource.Builder setUsageContext(int index, String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureUsageContextIsMutable();
					this.usageContext_.set(index, value);
					return this;
				}
			}

			public Serving.Resource.Builder setValue(int index, com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builderForValue) {
				ensureValueIsMutable();
				this.value_.set(index, builderForValue.build());
				return this;
			}

			public Serving.Resource.Builder setValue(int index, Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureValueIsMutable();
					this.value_.set(index, value);
					return this;
				}
			}

			public Serving.Resource.Builder setVersion(String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 1024;
					this.version_ = value;
					return this;
				}
			}

			public Serving.Resource.Builder setVersionBytes(ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 1024;
					this.version_ = value;
					return this;
				}
			}
		}


		static {
			PARSER = new AbstractParser<Serving.Resource>() {
			public Serving.Resource parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Serving.Resource(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Serving.Resource(true);
			defaultInstance.initFields();
		}

		private Resource(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
					ByteString bs;
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case MALWARE_SCAN_AUTH_CODE_FIELD_NUMBER:
						bs = input.readBytes();
						if ((mutable_bitField0_ & 1) != 1) {
							this.key_ = new LazyStringArrayList();
							mutable_bitField0_ |= 1;
						}
						this.key_.add(bs);
						break;
					case ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						if ((mutable_bitField0_ & 2) != 2) {
							this.value_ = new ArrayList();
							mutable_bitField0_ |= 2;
						}
						this.value_.add(input.readMessage(Value.PARSER, extensionRegistry));
						break;
					case 26:
						if ((mutable_bitField0_ & 4) != 4) {
							this.property_ = new ArrayList();
							mutable_bitField0_ |= 4;
						}
						this.property_.add(input.readMessage(Serving.Property.PARSER, extensionRegistry));
						break;
					case 34:
						if ((mutable_bitField0_ & 8) != 8) {
							this.macro_ = new ArrayList();
							mutable_bitField0_ |= 8;
						}
						this.macro_.add(input.readMessage(Serving.FunctionCall.PARSER, extensionRegistry));
						break;
					case 42:
						if ((mutable_bitField0_ & 16) != 16) {
							this.tag_ = new ArrayList();
							mutable_bitField0_ |= 16;
						}
						this.tag_.add(input.readMessage(Serving.FunctionCall.PARSER, extensionRegistry));
						break;
					case 50:
						if ((mutable_bitField0_ & 32) != 32) {
							this.predicate_ = new ArrayList();
							mutable_bitField0_ |= 32;
						}
						this.predicate_.add(input.readMessage(Serving.FunctionCall.PARSER, extensionRegistry));
						break;
					case 58:
						if ((mutable_bitField0_ & 64) != 64) {
							this.rule_ = new ArrayList();
							mutable_bitField0_ |= 64;
						}
						this.rule_.add(input.readMessage(Serving.Rule.PARSER, extensionRegistry));
						break;
					case 74:
						bs = input.readBytes();
						this.bitField0_ |= 1;
						this.previewAuthCode_ = bs;
						break;
					case 82:
						bs = input.readBytes();
						this.bitField0_ |= 2;
						this.malwareScanAuthCode_ = bs;
						break;
					case 98:
						bs = input.readBytes();
						this.bitField0_ |= 4;
						this.templateVersionSet_ = bs;
						break;
					case 106:
						bs = input.readBytes();
						this.bitField0_ |= 8;
						this.version_ = bs;
						break;
					case 114:
						Serving.CacheOption.Builder subBuilder = null;
						if ((this.bitField0_ & 16) == 16) {
							subBuilder = this.liveJsCacheOption_.toBuilder();
						}
						this.liveJsCacheOption_ = (Serving.CacheOption) input.readMessage(Serving.CacheOption.PARSER, extensionRegistry);
						if (subBuilder != null) {
							subBuilder.mergeFrom(this.liveJsCacheOption_);
							this.liveJsCacheOption_ = subBuilder.buildPartial();
						}
						this.bitField0_ |= 16;
						break;
					case 125:
						this.bitField0_ |= 32;
						this.reportingSampleRate_ = input.readFloat();
						break;
					case 130:
						bs = input.readBytes();
						if ((mutable_bitField0_ & 16384) != 16384) {
							this.usageContext_ = new LazyStringArrayList();
							mutable_bitField0_ |= 16384;
						}
						this.usageContext_.add(bs);
						break;
					case 136:
						this.bitField0_ |= 128;
						this.resourceFormatVersion_ = input.readInt32();
						break;
					case 144:
						this.bitField0_ |= 64;
						this.enableAutoEventTracking_ = input.readBool();
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
						this.key_ = new UnmodifiableLazyStringList(this.key_);
					}
					if ((mutable_bitField0_ & 2) == 2) {
						this.value_ = Collections.unmodifiableList(this.value_);
					}
					if ((mutable_bitField0_ & 4) == 4) {
						this.property_ = Collections.unmodifiableList(this.property_);
					}
					if ((mutable_bitField0_ & 8) == 8) {
						this.macro_ = Collections.unmodifiableList(this.macro_);
					}
					if ((mutable_bitField0_ & 16) == 16) {
						this.tag_ = Collections.unmodifiableList(this.tag_);
					}
					if ((mutable_bitField0_ & 32) == 32) {
						this.predicate_ = Collections.unmodifiableList(this.predicate_);
					}
					if ((mutable_bitField0_ & 64) == 64) {
						this.rule_ = Collections.unmodifiableList(this.rule_);
					}
					if ((mutable_bitField0_ & 16384) == 16384) {
						this.usageContext_ = new UnmodifiableLazyStringList(this.usageContext_);
					}
					unknownFieldsCodedOutput.flush();
					this.unknownFields = unknownFieldsOutput.toByteString();
				}
			}
			if ((mutable_bitField0_ & 1) == 1) {
				this.key_ = new UnmodifiableLazyStringList(this.key_);
			}
			if ((mutable_bitField0_ & 2) == 2) {
				this.value_ = Collections.unmodifiableList(this.value_);
			}
			if ((mutable_bitField0_ & 4) == 4) {
				this.property_ = Collections.unmodifiableList(this.property_);
			}
			if ((mutable_bitField0_ & 8) == 8) {
				this.macro_ = Collections.unmodifiableList(this.macro_);
			}
			if ((mutable_bitField0_ & 16) == 16) {
				this.tag_ = Collections.unmodifiableList(this.tag_);
			}
			if ((mutable_bitField0_ & 32) == 32) {
				this.predicate_ = Collections.unmodifiableList(this.predicate_);
			}
			if ((mutable_bitField0_ & 64) == 64) {
				this.rule_ = Collections.unmodifiableList(this.rule_);
			}
			if ((mutable_bitField0_ & 16384) == 16384) {
				this.usageContext_ = new UnmodifiableLazyStringList(this.usageContext_);
			}
			try {
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
			} catch (IOException e_3) {
				this.unknownFields = unknownFieldsOutput.toByteString();
			}
			makeExtensionsImmutable();
		}

		private Resource(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private Resource(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Serving.Resource getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.key_ = LazyStringArrayList.EMPTY;
			this.value_ = Collections.emptyList();
			this.property_ = Collections.emptyList();
			this.macro_ = Collections.emptyList();
			this.tag_ = Collections.emptyList();
			this.predicate_ = Collections.emptyList();
			this.rule_ = Collections.emptyList();
			this.previewAuthCode_ = "";
			this.malwareScanAuthCode_ = "";
			this.templateVersionSet_ = "0";
			this.version_ = "";
			this.liveJsCacheOption_ = Serving.CacheOption.getDefaultInstance();
			this.reportingSampleRate_ = 0.0f;
			this.enableAutoEventTracking_ = false;
			this.usageContext_ = LazyStringArrayList.EMPTY;
			this.resourceFormatVersion_ = 0;
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Serving.Resource prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Serving.Resource parseDelimitedFrom(InputStream input) throws IOException {
			return (Serving.Resource) PARSER.parseDelimitedFrom(input);
		}

		public static Serving.Resource parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.Resource) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Serving.Resource parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Serving.Resource) PARSER.parseFrom(data);
		}

		public static Serving.Resource parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Serving.Resource) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Serving.Resource parseFrom(CodedInputStream input) throws IOException {
			return (Serving.Resource) PARSER.parseFrom(input);
		}

		public static Serving.Resource parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.Resource) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Serving.Resource parseFrom(InputStream input) throws IOException {
			return (Serving.Resource) PARSER.parseFrom(input);
		}

		public static Serving.Resource parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.Resource) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Serving.Resource parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Serving.Resource) PARSER.parseFrom(data);
		}

		public static Serving.Resource parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Serving.Resource) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Serving.Resource))) {
				return super.equals(obj);
			} else {
				boolean result;
				Serving.Resource other = (Serving.Resource) obj;
				result = (!true || !getKeyList().equals(other.getKeyList())) ? false : true;
				result = (!result || !getValueList().equals(other.getValueList())) ? false : true;
				result = (!result || !getPropertyList().equals(other.getPropertyList())) ? false : true;
				result = (!result || !getMacroList().equals(other.getMacroList())) ? false : true;
				result = (!result || !getTagList().equals(other.getTagList())) ? false : true;
				result = (!result || !getPredicateList().equals(other.getPredicateList())) ? false : true;
				result = (!result || !getRuleList().equals(other.getRuleList())) ? false : true;
				if (!result || hasPreviewAuthCode() != other.hasPreviewAuthCode()) {
					result = false;
				} else {
					result = true;
				}
				if (hasPreviewAuthCode()) {
					result = (!result || !getPreviewAuthCode().equals(other.getPreviewAuthCode())) ? false : true;
				}
				if (!result || hasMalwareScanAuthCode() != other.hasMalwareScanAuthCode()) {
					result = false;
				} else {
					result = true;
				}
				if (hasMalwareScanAuthCode()) {
					result = (!result || !getMalwareScanAuthCode().equals(other.getMalwareScanAuthCode())) ? false : true;
				}
				if (!result || hasTemplateVersionSet() != other.hasTemplateVersionSet()) {
					result = false;
				} else {
					result = true;
				}
				if (hasTemplateVersionSet()) {
					result = (!result || !getTemplateVersionSet().equals(other.getTemplateVersionSet())) ? false : true;
				}
				if (!result || hasVersion() != other.hasVersion()) {
					result = false;
				} else {
					result = true;
				}
				if (hasVersion()) {
					result = (!result || !getVersion().equals(other.getVersion())) ? false : true;
				}
				if (!result || hasLiveJsCacheOption() != other.hasLiveJsCacheOption()) {
					result = false;
				} else {
					result = true;
				}
				if (hasLiveJsCacheOption()) {
					result = (!result || !getLiveJsCacheOption().equals(other.getLiveJsCacheOption())) ? false : true;
				}
				if (!result || hasReportingSampleRate() != other.hasReportingSampleRate()) {
					result = false;
				} else {
					result = true;
				}
				if (hasReportingSampleRate()) {
					result = (!result || Float.floatToIntBits(getReportingSampleRate()) != Float.floatToIntBits(other.getReportingSampleRate())) ? false : true;
				}
				if (!result || hasEnableAutoEventTracking() != other.hasEnableAutoEventTracking()) {
					result = false;
				} else {
					result = true;
				}
				if (hasEnableAutoEventTracking()) {
					result = (!result || getEnableAutoEventTracking() != other.getEnableAutoEventTracking()) ? false : true;
				}
				result = (!result || !getUsageContextList().equals(other.getUsageContextList())) ? false : true;
				if (!result || hasResourceFormatVersion() != other.hasResourceFormatVersion()) {
					result = false;
				} else {
					result = true;
				}
				if (hasResourceFormatVersion()) {
					result = (!result || getResourceFormatVersion() != other.getResourceFormatVersion()) ? false : true;
				}
				return result;
			}
		}

		public Serving.Resource getDefaultInstanceForType() {
			return defaultInstance;
		}

		public boolean getEnableAutoEventTracking() {
			return this.enableAutoEventTracking_;
		}

		public String getKey(int index) {
			return (String) this.key_.get(index);
		}

		public ByteString getKeyBytes(int index) {
			return this.key_.getByteString(index);
		}

		public int getKeyCount() {
			return this.key_.size();
		}

		public List<String> getKeyList() {
			return this.key_;
		}

		public Serving.CacheOption getLiveJsCacheOption() {
			return this.liveJsCacheOption_;
		}

		public Serving.FunctionCall getMacro(int index) {
			return (Serving.FunctionCall) this.macro_.get(index);
		}

		public int getMacroCount() {
			return this.macro_.size();
		}

		public List<Serving.FunctionCall> getMacroList() {
			return this.macro_;
		}

		public Serving.FunctionCallOrBuilder getMacroOrBuilder(int index) {
			return (Serving.FunctionCallOrBuilder) this.macro_.get(index);
		}

		public List<Serving.FunctionCallOrBuilder> getMacroOrBuilderList() {
			return this.macro_;
		}

		public String getMalwareScanAuthCode() {
			Object ref = this.malwareScanAuthCode_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				ByteString bs = (ByteString) ref;
				String s = bs.toStringUtf8();
				if (bs.isValidUtf8()) {
					this.malwareScanAuthCode_ = s;
				}
				return s;
			}
		}

		public ByteString getMalwareScanAuthCodeBytes() {
			Object ref = this.malwareScanAuthCode_;
			if (ref instanceof String) {
				ByteString b = ByteString.copyFromUtf8((String) ref);
				this.malwareScanAuthCode_ = b;
				return b;
			} else {
				return (ByteString) ref;
			}
		}

		public Parser<Serving.Resource> getParserForType() {
			return PARSER;
		}

		public Serving.FunctionCall getPredicate(int index) {
			return (Serving.FunctionCall) this.predicate_.get(index);
		}

		public int getPredicateCount() {
			return this.predicate_.size();
		}

		public List<Serving.FunctionCall> getPredicateList() {
			return this.predicate_;
		}

		public Serving.FunctionCallOrBuilder getPredicateOrBuilder(int index) {
			return (Serving.FunctionCallOrBuilder) this.predicate_.get(index);
		}

		public List<Serving.FunctionCallOrBuilder> getPredicateOrBuilderList() {
			return this.predicate_;
		}

		public String getPreviewAuthCode() {
			Object ref = this.previewAuthCode_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				ByteString bs = (ByteString) ref;
				String s = bs.toStringUtf8();
				if (bs.isValidUtf8()) {
					this.previewAuthCode_ = s;
				}
				return s;
			}
		}

		public ByteString getPreviewAuthCodeBytes() {
			Object ref = this.previewAuthCode_;
			if (ref instanceof String) {
				ByteString b = ByteString.copyFromUtf8((String) ref);
				this.previewAuthCode_ = b;
				return b;
			} else {
				return (ByteString) ref;
			}
		}

		public Serving.Property getProperty(int index) {
			return (Serving.Property) this.property_.get(index);
		}

		public int getPropertyCount() {
			return this.property_.size();
		}

		public List<Serving.Property> getPropertyList() {
			return this.property_;
		}

		public Serving.PropertyOrBuilder getPropertyOrBuilder(int index) {
			return (Serving.PropertyOrBuilder) this.property_.get(index);
		}

		public List<Serving.PropertyOrBuilder> getPropertyOrBuilderList() {
			return this.property_;
		}

		public float getReportingSampleRate() {
			return this.reportingSampleRate_;
		}

		public int getResourceFormatVersion() {
			return this.resourceFormatVersion_;
		}

		public Serving.Rule getRule(int index) {
			return (Serving.Rule) this.rule_.get(index);
		}

		public int getRuleCount() {
			return this.rule_.size();
		}

		public List<Serving.Rule> getRuleList() {
			return this.rule_;
		}

		public Serving.RuleOrBuilder getRuleOrBuilder(int index) {
			return (Serving.RuleOrBuilder) this.rule_.get(index);
		}

		public List<Serving.RuleOrBuilder> getRuleOrBuilderList() {
			return this.rule_;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				int dataSize = 0;
				int i = 0;
				while (i < this.key_.size()) {
					dataSize += CodedOutputStream.computeBytesSizeNoTag(this.key_.getByteString(i));
					i++;
				}
				size = (size + dataSize) + (getKeyList().size() * 1);
				i = 0;
				while (i < this.value_.size()) {
					size += CodedOutputStream.computeMessageSize(VALUE_FIELD_NUMBER, (MessageLite) this.value_.get(i));
					i++;
				}
				i = 0;
				while (i < this.property_.size()) {
					size += CodedOutputStream.computeMessageSize(PROPERTY_FIELD_NUMBER, (MessageLite) this.property_.get(i));
					i++;
				}
				i = 0;
				while (i < this.macro_.size()) {
					size += CodedOutputStream.computeMessageSize(MACRO_FIELD_NUMBER, (MessageLite) this.macro_.get(i));
					i++;
				}
				i = 0;
				while (i < this.tag_.size()) {
					size += CodedOutputStream.computeMessageSize(TAG_FIELD_NUMBER, (MessageLite) this.tag_.get(i));
					i++;
				}
				i = 0;
				while (i < this.predicate_.size()) {
					size += CodedOutputStream.computeMessageSize(PREDICATE_FIELD_NUMBER, (MessageLite) this.predicate_.get(i));
					i++;
				}
				i = 0;
				while (i < this.rule_.size()) {
					size += CodedOutputStream.computeMessageSize(RULE_FIELD_NUMBER, (MessageLite) this.rule_.get(i));
					i++;
				}
				if ((this.bitField0_ & 1) == 1) {
					size += CodedOutputStream.computeBytesSize(PREVIEW_AUTH_CODE_FIELD_NUMBER, getPreviewAuthCodeBytes());
				}
				if ((this.bitField0_ & 2) == 2) {
					size += CodedOutputStream.computeBytesSize(MALWARE_SCAN_AUTH_CODE_FIELD_NUMBER, getMalwareScanAuthCodeBytes());
				}
				if ((this.bitField0_ & 4) == 4) {
					size += CodedOutputStream.computeBytesSize(TEMPLATE_VERSION_SET_FIELD_NUMBER, getTemplateVersionSetBytes());
				}
				if ((this.bitField0_ & 8) == 8) {
					size += CodedOutputStream.computeBytesSize(VERSION_FIELD_NUMBER, getVersionBytes());
				}
				if ((this.bitField0_ & 16) == 16) {
					size += CodedOutputStream.computeMessageSize(LIVE_JS_CACHE_OPTION_FIELD_NUMBER, this.liveJsCacheOption_);
				}
				if ((this.bitField0_ & 32) == 32) {
					size += CodedOutputStream.computeFloatSize(REPORTING_SAMPLE_RATE_FIELD_NUMBER, this.reportingSampleRate_);
				}
				dataSize = 0;
				i = 0;
				while (i < this.usageContext_.size()) {
					dataSize += CodedOutputStream.computeBytesSizeNoTag(this.usageContext_.getByteString(i));
					i++;
				}
				size = (size + dataSize) + (getUsageContextList().size() * 2);
				if ((this.bitField0_ & 128) == 128) {
					size += CodedOutputStream.computeInt32Size(RESOURCE_FORMAT_VERSION_FIELD_NUMBER, this.resourceFormatVersion_);
				}
				if ((this.bitField0_ & 64) == 64) {
					size += CodedOutputStream.computeBoolSize(ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER, this.enableAutoEventTracking_);
				}
				size += this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
		}

		public Serving.FunctionCall getTag(int index) {
			return (Serving.FunctionCall) this.tag_.get(index);
		}

		public int getTagCount() {
			return this.tag_.size();
		}

		public List<Serving.FunctionCall> getTagList() {
			return this.tag_;
		}

		public Serving.FunctionCallOrBuilder getTagOrBuilder(int index) {
			return (Serving.FunctionCallOrBuilder) this.tag_.get(index);
		}

		public List<Serving.FunctionCallOrBuilder> getTagOrBuilderList() {
			return this.tag_;
		}

		public String getTemplateVersionSet() {
			Object ref = this.templateVersionSet_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				ByteString bs = (ByteString) ref;
				String s = bs.toStringUtf8();
				if (bs.isValidUtf8()) {
					this.templateVersionSet_ = s;
				}
				return s;
			}
		}

		public ByteString getTemplateVersionSetBytes() {
			Object ref = this.templateVersionSet_;
			if (ref instanceof String) {
				ByteString b = ByteString.copyFromUtf8((String) ref);
				this.templateVersionSet_ = b;
				return b;
			} else {
				return (ByteString) ref;
			}
		}

		public String getUsageContext(int index) {
			return (String) this.usageContext_.get(index);
		}

		public ByteString getUsageContextBytes(int index) {
			return this.usageContext_.getByteString(index);
		}

		public int getUsageContextCount() {
			return this.usageContext_.size();
		}

		public List<String> getUsageContextList() {
			return this.usageContext_;
		}

		public Value getValue(int index) {
			return (Value) this.value_.get(index);
		}

		public int getValueCount() {
			return this.value_.size();
		}

		public List<Value> getValueList() {
			return this.value_;
		}

		public ValueOrBuilder getValueOrBuilder(int index) {
			return (ValueOrBuilder) this.value_.get(index);
		}

		public List<ValueOrBuilder> getValueOrBuilderList() {
			return this.value_;
		}

		public String getVersion() {
			Object ref = this.version_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				ByteString bs = (ByteString) ref;
				String s = bs.toStringUtf8();
				if (bs.isValidUtf8()) {
					this.version_ = s;
				}
				return s;
			}
		}

		public ByteString getVersionBytes() {
			Object ref = this.version_;
			if (ref instanceof String) {
				ByteString b = ByteString.copyFromUtf8((String) ref);
				this.version_ = b;
				return b;
			} else {
				return (ByteString) ref;
			}
		}

		public boolean hasEnableAutoEventTracking() {
			return (this.bitField0_ & 64) == 64;
		}

		public boolean hasLiveJsCacheOption() {
			return (this.bitField0_ & 16) == 16;
		}

		public boolean hasMalwareScanAuthCode() {
			return (this.bitField0_ & 2) == 2;
		}

		public boolean hasPreviewAuthCode() {
			return (this.bitField0_ & 1) == 1;
		}

		public boolean hasReportingSampleRate() {
			return (this.bitField0_ & 32) == 32;
		}

		public boolean hasResourceFormatVersion() {
			return (this.bitField0_ & 128) == 128;
		}

		public boolean hasTemplateVersionSet() {
			return (this.bitField0_ & 4) == 4;
		}

		public boolean hasVersion() {
			return (this.bitField0_ & 8) == 8;
		}

		public int hashCode() {
			if (this.memoizedHashCode != 0) {
				return this.memoizedHashCode;
			} else {
				int hash = Serving.Resource.class.hashCode() + 779;
				if (getKeyCount() > 0) {
					hash = (((hash * 37) + 1) * 53) + getKeyList().hashCode();
				}
				if (getValueCount() > 0) {
					hash = (((hash * 37) + 2) * 53) + getValueList().hashCode();
				}
				if (getPropertyCount() > 0) {
					hash = (((hash * 37) + 3) * 53) + getPropertyList().hashCode();
				}
				if (getMacroCount() > 0) {
					hash = (((hash * 37) + 4) * 53) + getMacroList().hashCode();
				}
				if (getTagCount() > 0) {
					hash = (((hash * 37) + 5) * 53) + getTagList().hashCode();
				}
				if (getPredicateCount() > 0) {
					hash = (((hash * 37) + 6) * 53) + getPredicateList().hashCode();
				}
				if (getRuleCount() > 0) {
					hash = (((hash * 37) + 7) * 53) + getRuleList().hashCode();
				}
				if (hasPreviewAuthCode()) {
					hash = (((hash * 37) + 9) * 53) + getPreviewAuthCode().hashCode();
				}
				if (hasMalwareScanAuthCode()) {
					hash = (((hash * 37) + 10) * 53) + getMalwareScanAuthCode().hashCode();
				}
				if (hasTemplateVersionSet()) {
					hash = (((hash * 37) + 12) * 53) + getTemplateVersionSet().hashCode();
				}
				if (hasVersion()) {
					hash = (((hash * 37) + 13) * 53) + getVersion().hashCode();
				}
				if (hasLiveJsCacheOption()) {
					hash = (((hash * 37) + 14) * 53) + getLiveJsCacheOption().hashCode();
				}
				if (hasReportingSampleRate()) {
					hash = (((hash * 37) + 15) * 53) + Float.floatToIntBits(getReportingSampleRate());
				}
				if (hasEnableAutoEventTracking()) {
					hash = (((hash * 37) + 18) * 53) + Internal.hashBoolean(getEnableAutoEventTracking());
				}
				if (getUsageContextCount() > 0) {
					hash = (((hash * 37) + 16) * 53) + getUsageContextList().hashCode();
				}
				if (hasResourceFormatVersion()) {
					hash = (((hash * 37) + 17) * 53) + getResourceFormatVersion();
				}
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$Resource");
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
				while (i < getValueCount()) {
					if (!getValue(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				i = 0;
				while (i < getPropertyCount()) {
					if (!getProperty(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				i = 0;
				while (i < getMacroCount()) {
					if (!getMacro(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				i = 0;
				while (i < getTagCount()) {
					if (!getTag(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				i = 0;
				while (i < getPredicateCount()) {
					if (!getPredicate(i).isInitialized()) {
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
			while (i < this.key_.size()) {
				output.writeBytes(KEY_FIELD_NUMBER, this.key_.getByteString(i));
				i++;
			}
			i = 0;
			while (i < this.value_.size()) {
				output.writeMessage(VALUE_FIELD_NUMBER, (MessageLite) this.value_.get(i));
				i++;
			}
			i = 0;
			while (i < this.property_.size()) {
				output.writeMessage(PROPERTY_FIELD_NUMBER, (MessageLite) this.property_.get(i));
				i++;
			}
			i = 0;
			while (i < this.macro_.size()) {
				output.writeMessage(MACRO_FIELD_NUMBER, (MessageLite) this.macro_.get(i));
				i++;
			}
			i = 0;
			while (i < this.tag_.size()) {
				output.writeMessage(TAG_FIELD_NUMBER, (MessageLite) this.tag_.get(i));
				i++;
			}
			i = 0;
			while (i < this.predicate_.size()) {
				output.writeMessage(PREDICATE_FIELD_NUMBER, (MessageLite) this.predicate_.get(i));
				i++;
			}
			i = 0;
			while (i < this.rule_.size()) {
				output.writeMessage(RULE_FIELD_NUMBER, (MessageLite) this.rule_.get(i));
				i++;
			}
			if ((this.bitField0_ & 1) == 1) {
				output.writeBytes(PREVIEW_AUTH_CODE_FIELD_NUMBER, getPreviewAuthCodeBytes());
			}
			if ((this.bitField0_ & 2) == 2) {
				output.writeBytes(MALWARE_SCAN_AUTH_CODE_FIELD_NUMBER, getMalwareScanAuthCodeBytes());
			}
			if ((this.bitField0_ & 4) == 4) {
				output.writeBytes(TEMPLATE_VERSION_SET_FIELD_NUMBER, getTemplateVersionSetBytes());
			}
			if ((this.bitField0_ & 8) == 8) {
				output.writeBytes(VERSION_FIELD_NUMBER, getVersionBytes());
			}
			if ((this.bitField0_ & 16) == 16) {
				output.writeMessage(LIVE_JS_CACHE_OPTION_FIELD_NUMBER, this.liveJsCacheOption_);
			}
			if ((this.bitField0_ & 32) == 32) {
				output.writeFloat(REPORTING_SAMPLE_RATE_FIELD_NUMBER, this.reportingSampleRate_);
			}
			i = 0;
			while (i < this.usageContext_.size()) {
				output.writeBytes(USAGE_CONTEXT_FIELD_NUMBER, this.usageContext_.getByteString(i));
				i++;
			}
			if ((this.bitField0_ & 128) == 128) {
				output.writeInt32(RESOURCE_FORMAT_VERSION_FIELD_NUMBER, this.resourceFormatVersion_);
			}
			if ((this.bitField0_ & 64) == 64) {
				output.writeBool(ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER, this.enableAutoEventTracking_);
			}
			output.writeRawBytes(this.unknownFields);
		}
	}

	public static enum ResourceState implements EnumLite {
		PREVIEW(0, 1),
		LIVE(1, 2);

		public static final int LIVE_VALUE = 2;
		public static final int PREVIEW_VALUE = 1;
		private static EnumLiteMap<Serving.ResourceState> internalValueMap;
		private final int value;


		static {
			internalValueMap = new EnumLiteMap<Serving.ResourceState>() {
			public Serving.ResourceState findValueByNumber(int number) {
				return Serving.ResourceState.valueOf(number);
			}
		};
		}

		private ResourceState(int index, int value) {
			this.value = value;
		}

		public static EnumLiteMap<Serving.ResourceState> internalGetValueMap() {
			return internalValueMap;
		}

		public static Serving.ResourceState valueOf(int value) {
			switch(value) {
			case PREVIEW_VALUE:
				return PREVIEW;
			case LIVE_VALUE:
				return LIVE;
			}
			return null;
		}

		public final int getNumber() {
			return this.value;
		}
	}

	public static enum ResourceType implements EnumLite {
		JS_RESOURCE(0, 1),
		NS_RESOURCE(1, 2),
		PIXEL_COLLECTION(2, 3),
		SET_COOKIE(3, 4),
		GET_COOKIE(4, 5),
		CLEAR_CACHE(5, 6),
		RAW_PROTO(6, 7);

		public static final int CLEAR_CACHE_VALUE = 6;
		public static final int GET_COOKIE_VALUE = 5;
		public static final int JS_RESOURCE_VALUE = 1;
		public static final int NS_RESOURCE_VALUE = 2;
		public static final int PIXEL_COLLECTION_VALUE = 3;
		public static final int RAW_PROTO_VALUE = 7;
		public static final int SET_COOKIE_VALUE = 4;
		private static EnumLiteMap<Serving.ResourceType> internalValueMap;
		private final int value;


		static {
			internalValueMap = new EnumLiteMap<Serving.ResourceType>() {
			public Serving.ResourceType findValueByNumber(int number) {
				return Serving.ResourceType.valueOf(number);
			}
		};
		}

		private ResourceType(int index, int value) {
			this.value = value;
		}

		public static EnumLiteMap<Serving.ResourceType> internalGetValueMap() {
			return internalValueMap;
		}

		public static Serving.ResourceType valueOf(int value) {
			switch(value) {
			case JS_RESOURCE_VALUE:
				return JS_RESOURCE;
			case NS_RESOURCE_VALUE:
				return NS_RESOURCE;
			case PIXEL_COLLECTION_VALUE:
				return PIXEL_COLLECTION;
			case SET_COOKIE_VALUE:
				return SET_COOKIE;
			case GET_COOKIE_VALUE:
				return GET_COOKIE;
			case CLEAR_CACHE_VALUE:
				return CLEAR_CACHE;
			case RAW_PROTO_VALUE:
				return RAW_PROTO;
			}
			return null;
		}

		public final int getNumber() {
			return this.value;
		}
	}

	public static interface RuleOrBuilder extends MessageLiteOrBuilder {
		public int getAddMacro(int r1i);

		public int getAddMacroCount();

		public List<Integer> getAddMacroList();

		public int getAddMacroRuleName(int r1i);

		public int getAddMacroRuleNameCount();

		public List<Integer> getAddMacroRuleNameList();

		public int getAddTag(int r1i);

		public int getAddTagCount();

		public List<Integer> getAddTagList();

		public int getAddTagRuleName(int r1i);

		public int getAddTagRuleNameCount();

		public List<Integer> getAddTagRuleNameList();

		public int getNegativePredicate(int r1i);

		public int getNegativePredicateCount();

		public List<Integer> getNegativePredicateList();

		public int getPositivePredicate(int r1i);

		public int getPositivePredicateCount();

		public List<Integer> getPositivePredicateList();

		public int getRemoveMacro(int r1i);

		public int getRemoveMacroCount();

		public List<Integer> getRemoveMacroList();

		public int getRemoveMacroRuleName(int r1i);

		public int getRemoveMacroRuleNameCount();

		public List<Integer> getRemoveMacroRuleNameList();

		public int getRemoveTag(int r1i);

		public int getRemoveTagCount();

		public List<Integer> getRemoveTagList();

		public int getRemoveTagRuleName(int r1i);

		public int getRemoveTagRuleNameCount();

		public List<Integer> getRemoveTagRuleNameList();
	}

	public static final class Rule extends GeneratedMessageLite implements Serving.RuleOrBuilder {
		public static final int ADD_MACRO_FIELD_NUMBER = 7;
		public static final int ADD_MACRO_RULE_NAME_FIELD_NUMBER = 9;
		public static final int ADD_TAG_FIELD_NUMBER = 3;
		public static final int ADD_TAG_RULE_NAME_FIELD_NUMBER = 5;
		public static final int NEGATIVE_PREDICATE_FIELD_NUMBER = 2;
		public static Parser<Serving.Rule> PARSER = null;
		public static final int POSITIVE_PREDICATE_FIELD_NUMBER = 1;
		public static final int REMOVE_MACRO_FIELD_NUMBER = 8;
		public static final int REMOVE_MACRO_RULE_NAME_FIELD_NUMBER = 10;
		public static final int REMOVE_TAG_FIELD_NUMBER = 4;
		public static final int REMOVE_TAG_RULE_NAME_FIELD_NUMBER = 6;
		private static final Serving.Rule defaultInstance;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private List<Integer> addMacroRuleName_;
		private List<Integer> addMacro_;
		private List<Integer> addTagRuleName_;
		private List<Integer> addTag_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private List<Integer> negativePredicate_;
		private List<Integer> positivePredicate_;
		private List<Integer> removeMacroRuleName_;
		private List<Integer> removeMacro_;
		private List<Integer> removeTagRuleName_;
		private List<Integer> removeTag_;
		private final ByteString unknownFields;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Serving.Rule, Serving.Rule.Builder> implements Serving.RuleOrBuilder {
			private List<Integer> addMacroRuleName_;
			private List<Integer> addMacro_;
			private List<Integer> addTagRuleName_;
			private List<Integer> addTag_;
			private int bitField0_;
			private List<Integer> negativePredicate_;
			private List<Integer> positivePredicate_;
			private List<Integer> removeMacroRuleName_;
			private List<Integer> removeMacro_;
			private List<Integer> removeTagRuleName_;
			private List<Integer> removeTag_;

			private Builder() {
				this.positivePredicate_ = Collections.emptyList();
				this.negativePredicate_ = Collections.emptyList();
				this.addTag_ = Collections.emptyList();
				this.removeTag_ = Collections.emptyList();
				this.addTagRuleName_ = Collections.emptyList();
				this.removeTagRuleName_ = Collections.emptyList();
				this.addMacro_ = Collections.emptyList();
				this.removeMacro_ = Collections.emptyList();
				this.addMacroRuleName_ = Collections.emptyList();
				this.removeMacroRuleName_ = Collections.emptyList();
				maybeForceBuilderInitialization();
			}

			private static Serving.Rule.Builder create() {
				return new Serving.Rule.Builder();
			}

			private void ensureAddMacroIsMutable() {
				if ((this.bitField0_ & 64) != 64) {
					this.addMacro_ = new ArrayList(this.addMacro_);
					this.bitField0_ |= 64;
				}
			}

			private void ensureAddMacroRuleNameIsMutable() {
				if ((this.bitField0_ & 256) != 256) {
					this.addMacroRuleName_ = new ArrayList(this.addMacroRuleName_);
					this.bitField0_ |= 256;
				}
			}

			private void ensureAddTagIsMutable() {
				if ((this.bitField0_ & 4) != 4) {
					this.addTag_ = new ArrayList(this.addTag_);
					this.bitField0_ |= 4;
				}
			}

			private void ensureAddTagRuleNameIsMutable() {
				if ((this.bitField0_ & 16) != 16) {
					this.addTagRuleName_ = new ArrayList(this.addTagRuleName_);
					this.bitField0_ |= 16;
				}
			}

			private void ensureNegativePredicateIsMutable() {
				if ((this.bitField0_ & 2) != 2) {
					this.negativePredicate_ = new ArrayList(this.negativePredicate_);
					this.bitField0_ |= 2;
				}
			}

			private void ensurePositivePredicateIsMutable() {
				if ((this.bitField0_ & 1) != 1) {
					this.positivePredicate_ = new ArrayList(this.positivePredicate_);
					this.bitField0_ |= 1;
				}
			}

			private void ensureRemoveMacroIsMutable() {
				if ((this.bitField0_ & 128) != 128) {
					this.removeMacro_ = new ArrayList(this.removeMacro_);
					this.bitField0_ |= 128;
				}
			}

			private void ensureRemoveMacroRuleNameIsMutable() {
				if ((this.bitField0_ & 512) != 512) {
					this.removeMacroRuleName_ = new ArrayList(this.removeMacroRuleName_);
					this.bitField0_ |= 512;
				}
			}

			private void ensureRemoveTagIsMutable() {
				if ((this.bitField0_ & 8) != 8) {
					this.removeTag_ = new ArrayList(this.removeTag_);
					this.bitField0_ |= 8;
				}
			}

			private void ensureRemoveTagRuleNameIsMutable() {
				if ((this.bitField0_ & 32) != 32) {
					this.removeTagRuleName_ = new ArrayList(this.removeTagRuleName_);
					this.bitField0_ |= 32;
				}
			}

			private void maybeForceBuilderInitialization() {
			}

			public Serving.Rule.Builder addAddMacro(int value) {
				ensureAddMacroIsMutable();
				this.addMacro_.add(Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder addAddMacroRuleName(int value) {
				ensureAddMacroRuleNameIsMutable();
				this.addMacroRuleName_.add(Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder addAddTag(int value) {
				ensureAddTagIsMutable();
				this.addTag_.add(Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder addAddTagRuleName(int value) {
				ensureAddTagRuleNameIsMutable();
				this.addTagRuleName_.add(Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder addAllAddMacro(Iterable<Integer> values) {
				ensureAddMacroIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.addMacro_);
				return this;
			}

			public Serving.Rule.Builder addAllAddMacroRuleName(Iterable<Integer> values) {
				ensureAddMacroRuleNameIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.addMacroRuleName_);
				return this;
			}

			public Serving.Rule.Builder addAllAddTag(Iterable<Integer> values) {
				ensureAddTagIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.addTag_);
				return this;
			}

			public Serving.Rule.Builder addAllAddTagRuleName(Iterable<Integer> values) {
				ensureAddTagRuleNameIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.addTagRuleName_);
				return this;
			}

			public Serving.Rule.Builder addAllNegativePredicate(Iterable<Integer> values) {
				ensureNegativePredicateIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.negativePredicate_);
				return this;
			}

			public Serving.Rule.Builder addAllPositivePredicate(Iterable<Integer> values) {
				ensurePositivePredicateIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.positivePredicate_);
				return this;
			}

			public Serving.Rule.Builder addAllRemoveMacro(Iterable<Integer> values) {
				ensureRemoveMacroIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.removeMacro_);
				return this;
			}

			public Serving.Rule.Builder addAllRemoveMacroRuleName(Iterable<Integer> values) {
				ensureRemoveMacroRuleNameIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.removeMacroRuleName_);
				return this;
			}

			public Serving.Rule.Builder addAllRemoveTag(Iterable<Integer> values) {
				ensureRemoveTagIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.removeTag_);
				return this;
			}

			public Serving.Rule.Builder addAllRemoveTagRuleName(Iterable<Integer> values) {
				ensureRemoveTagRuleNameIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.removeTagRuleName_);
				return this;
			}

			public Serving.Rule.Builder addNegativePredicate(int value) {
				ensureNegativePredicateIsMutable();
				this.negativePredicate_.add(Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder addPositivePredicate(int value) {
				ensurePositivePredicateIsMutable();
				this.positivePredicate_.add(Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder addRemoveMacro(int value) {
				ensureRemoveMacroIsMutable();
				this.removeMacro_.add(Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder addRemoveMacroRuleName(int value) {
				ensureRemoveMacroRuleNameIsMutable();
				this.removeMacroRuleName_.add(Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder addRemoveTag(int value) {
				ensureRemoveTagIsMutable();
				this.removeTag_.add(Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder addRemoveTagRuleName(int value) {
				ensureRemoveTagRuleNameIsMutable();
				this.removeTagRuleName_.add(Integer.valueOf(value));
				return this;
			}

			public Serving.Rule build() {
				Serving.Rule result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Serving.Rule buildPartial() {
				Serving.Rule result = new Serving.Rule((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
				int from_bitField0_ = this.bitField0_;
				if ((this.bitField0_ & 1) == 1) {
					this.positivePredicate_ = Collections.unmodifiableList(this.positivePredicate_);
					this.bitField0_ &= -2;
				}
				result.positivePredicate_ = this.positivePredicate_;
				if ((this.bitField0_ & 2) == 2) {
					this.negativePredicate_ = Collections.unmodifiableList(this.negativePredicate_);
					this.bitField0_ &= -3;
				}
				result.negativePredicate_ = this.negativePredicate_;
				if ((this.bitField0_ & 4) == 4) {
					this.addTag_ = Collections.unmodifiableList(this.addTag_);
					this.bitField0_ &= -5;
				}
				result.addTag_ = this.addTag_;
				if ((this.bitField0_ & 8) == 8) {
					this.removeTag_ = Collections.unmodifiableList(this.removeTag_);
					this.bitField0_ &= -9;
				}
				result.removeTag_ = this.removeTag_;
				if ((this.bitField0_ & 16) == 16) {
					this.addTagRuleName_ = Collections.unmodifiableList(this.addTagRuleName_);
					this.bitField0_ &= -17;
				}
				result.addTagRuleName_ = this.addTagRuleName_;
				if ((this.bitField0_ & 32) == 32) {
					this.removeTagRuleName_ = Collections.unmodifiableList(this.removeTagRuleName_);
					this.bitField0_ &= -33;
				}
				result.removeTagRuleName_ = this.removeTagRuleName_;
				if ((this.bitField0_ & 64) == 64) {
					this.addMacro_ = Collections.unmodifiableList(this.addMacro_);
					this.bitField0_ &= -65;
				}
				result.addMacro_ = this.addMacro_;
				if ((this.bitField0_ & 128) == 128) {
					this.removeMacro_ = Collections.unmodifiableList(this.removeMacro_);
					this.bitField0_ &= -129;
				}
				result.removeMacro_ = this.removeMacro_;
				if ((this.bitField0_ & 256) == 256) {
					this.addMacroRuleName_ = Collections.unmodifiableList(this.addMacroRuleName_);
					this.bitField0_ &= -257;
				}
				result.addMacroRuleName_ = this.addMacroRuleName_;
				if ((this.bitField0_ & 512) == 512) {
					this.removeMacroRuleName_ = Collections.unmodifiableList(this.removeMacroRuleName_);
					this.bitField0_ &= -513;
				}
				result.removeMacroRuleName_ = this.removeMacroRuleName_;
				return result;
			}

			public Serving.Rule.Builder clear() {
				super.clear();
				this.positivePredicate_ = Collections.emptyList();
				this.bitField0_ &= -2;
				this.negativePredicate_ = Collections.emptyList();
				this.bitField0_ &= -3;
				this.addTag_ = Collections.emptyList();
				this.bitField0_ &= -5;
				this.removeTag_ = Collections.emptyList();
				this.bitField0_ &= -9;
				this.addTagRuleName_ = Collections.emptyList();
				this.bitField0_ &= -17;
				this.removeTagRuleName_ = Collections.emptyList();
				this.bitField0_ &= -33;
				this.addMacro_ = Collections.emptyList();
				this.bitField0_ &= -65;
				this.removeMacro_ = Collections.emptyList();
				this.bitField0_ &= -129;
				this.addMacroRuleName_ = Collections.emptyList();
				this.bitField0_ &= -257;
				this.removeMacroRuleName_ = Collections.emptyList();
				this.bitField0_ &= -513;
				return this;
			}

			public Serving.Rule.Builder clearAddMacro() {
				this.addMacro_ = Collections.emptyList();
				this.bitField0_ &= -65;
				return this;
			}

			public Serving.Rule.Builder clearAddMacroRuleName() {
				this.addMacroRuleName_ = Collections.emptyList();
				this.bitField0_ &= -257;
				return this;
			}

			public Serving.Rule.Builder clearAddTag() {
				this.addTag_ = Collections.emptyList();
				this.bitField0_ &= -5;
				return this;
			}

			public Serving.Rule.Builder clearAddTagRuleName() {
				this.addTagRuleName_ = Collections.emptyList();
				this.bitField0_ &= -17;
				return this;
			}

			public Serving.Rule.Builder clearNegativePredicate() {
				this.negativePredicate_ = Collections.emptyList();
				this.bitField0_ &= -3;
				return this;
			}

			public Serving.Rule.Builder clearPositivePredicate() {
				this.positivePredicate_ = Collections.emptyList();
				this.bitField0_ &= -2;
				return this;
			}

			public Serving.Rule.Builder clearRemoveMacro() {
				this.removeMacro_ = Collections.emptyList();
				this.bitField0_ &= -129;
				return this;
			}

			public Serving.Rule.Builder clearRemoveMacroRuleName() {
				this.removeMacroRuleName_ = Collections.emptyList();
				this.bitField0_ &= -513;
				return this;
			}

			public Serving.Rule.Builder clearRemoveTag() {
				this.removeTag_ = Collections.emptyList();
				this.bitField0_ &= -9;
				return this;
			}

			public Serving.Rule.Builder clearRemoveTagRuleName() {
				this.removeTagRuleName_ = Collections.emptyList();
				this.bitField0_ &= -33;
				return this;
			}

			public Serving.Rule.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public int getAddMacro(int index) {
				return ((Integer) this.addMacro_.get(index)).intValue();
			}

			public int getAddMacroCount() {
				return this.addMacro_.size();
			}

			public List<Integer> getAddMacroList() {
				return Collections.unmodifiableList(this.addMacro_);
			}

			public int getAddMacroRuleName(int index) {
				return ((Integer) this.addMacroRuleName_.get(index)).intValue();
			}

			public int getAddMacroRuleNameCount() {
				return this.addMacroRuleName_.size();
			}

			public List<Integer> getAddMacroRuleNameList() {
				return Collections.unmodifiableList(this.addMacroRuleName_);
			}

			public int getAddTag(int index) {
				return ((Integer) this.addTag_.get(index)).intValue();
			}

			public int getAddTagCount() {
				return this.addTag_.size();
			}

			public List<Integer> getAddTagList() {
				return Collections.unmodifiableList(this.addTag_);
			}

			public int getAddTagRuleName(int index) {
				return ((Integer) this.addTagRuleName_.get(index)).intValue();
			}

			public int getAddTagRuleNameCount() {
				return this.addTagRuleName_.size();
			}

			public List<Integer> getAddTagRuleNameList() {
				return Collections.unmodifiableList(this.addTagRuleName_);
			}

			public Serving.Rule getDefaultInstanceForType() {
				return Serving.Rule.getDefaultInstance();
			}

			public int getNegativePredicate(int index) {
				return ((Integer) this.negativePredicate_.get(index)).intValue();
			}

			public int getNegativePredicateCount() {
				return this.negativePredicate_.size();
			}

			public List<Integer> getNegativePredicateList() {
				return Collections.unmodifiableList(this.negativePredicate_);
			}

			public int getPositivePredicate(int index) {
				return ((Integer) this.positivePredicate_.get(index)).intValue();
			}

			public int getPositivePredicateCount() {
				return this.positivePredicate_.size();
			}

			public List<Integer> getPositivePredicateList() {
				return Collections.unmodifiableList(this.positivePredicate_);
			}

			public int getRemoveMacro(int index) {
				return ((Integer) this.removeMacro_.get(index)).intValue();
			}

			public int getRemoveMacroCount() {
				return this.removeMacro_.size();
			}

			public List<Integer> getRemoveMacroList() {
				return Collections.unmodifiableList(this.removeMacro_);
			}

			public int getRemoveMacroRuleName(int index) {
				return ((Integer) this.removeMacroRuleName_.get(index)).intValue();
			}

			public int getRemoveMacroRuleNameCount() {
				return this.removeMacroRuleName_.size();
			}

			public List<Integer> getRemoveMacroRuleNameList() {
				return Collections.unmodifiableList(this.removeMacroRuleName_);
			}

			public int getRemoveTag(int index) {
				return ((Integer) this.removeTag_.get(index)).intValue();
			}

			public int getRemoveTagCount() {
				return this.removeTag_.size();
			}

			public List<Integer> getRemoveTagList() {
				return Collections.unmodifiableList(this.removeTag_);
			}

			public int getRemoveTagRuleName(int index) {
				return ((Integer) this.removeTagRuleName_.get(index)).intValue();
			}

			public int getRemoveTagRuleNameCount() {
				return this.removeTagRuleName_.size();
			}

			public List<Integer> getRemoveTagRuleNameList() {
				return Collections.unmodifiableList(this.removeTagRuleName_);
			}

			public final boolean isInitialized() {
				return true;
			}

			public Serving.Rule.Builder mergeFrom(Serving.Rule other) {
				if (other == Serving.Rule.getDefaultInstance()) {
					return this;
				} else {
					if (!other.positivePredicate_.isEmpty()) {
						if (this.positivePredicate_.isEmpty()) {
							this.positivePredicate_ = other.positivePredicate_;
							this.bitField0_ &= -2;
						} else {
							ensurePositivePredicateIsMutable();
							this.positivePredicate_.addAll(other.positivePredicate_);
						}
					}
					if (!other.negativePredicate_.isEmpty()) {
						if (this.negativePredicate_.isEmpty()) {
							this.negativePredicate_ = other.negativePredicate_;
							this.bitField0_ &= -3;
						} else {
							ensureNegativePredicateIsMutable();
							this.negativePredicate_.addAll(other.negativePredicate_);
						}
					}
					if (!other.addTag_.isEmpty()) {
						if (this.addTag_.isEmpty()) {
							this.addTag_ = other.addTag_;
							this.bitField0_ &= -5;
						} else {
							ensureAddTagIsMutable();
							this.addTag_.addAll(other.addTag_);
						}
					}
					if (!other.removeTag_.isEmpty()) {
						if (this.removeTag_.isEmpty()) {
							this.removeTag_ = other.removeTag_;
							this.bitField0_ &= -9;
						} else {
							ensureRemoveTagIsMutable();
							this.removeTag_.addAll(other.removeTag_);
						}
					}
					if (!other.addTagRuleName_.isEmpty()) {
						if (this.addTagRuleName_.isEmpty()) {
							this.addTagRuleName_ = other.addTagRuleName_;
							this.bitField0_ &= -17;
						} else {
							ensureAddTagRuleNameIsMutable();
							this.addTagRuleName_.addAll(other.addTagRuleName_);
						}
					}
					if (!other.removeTagRuleName_.isEmpty()) {
						if (this.removeTagRuleName_.isEmpty()) {
							this.removeTagRuleName_ = other.removeTagRuleName_;
							this.bitField0_ &= -33;
						} else {
							ensureRemoveTagRuleNameIsMutable();
							this.removeTagRuleName_.addAll(other.removeTagRuleName_);
						}
					}
					if (!other.addMacro_.isEmpty()) {
						if (this.addMacro_.isEmpty()) {
							this.addMacro_ = other.addMacro_;
							this.bitField0_ &= -65;
						} else {
							ensureAddMacroIsMutable();
							this.addMacro_.addAll(other.addMacro_);
						}
					}
					if (!other.removeMacro_.isEmpty()) {
						if (this.removeMacro_.isEmpty()) {
							this.removeMacro_ = other.removeMacro_;
							this.bitField0_ &= -129;
						} else {
							ensureRemoveMacroIsMutable();
							this.removeMacro_.addAll(other.removeMacro_);
						}
					}
					if (!other.addMacroRuleName_.isEmpty()) {
						if (this.addMacroRuleName_.isEmpty()) {
							this.addMacroRuleName_ = other.addMacroRuleName_;
							this.bitField0_ &= -257;
						} else {
							ensureAddMacroRuleNameIsMutable();
							this.addMacroRuleName_.addAll(other.addMacroRuleName_);
						}
					}
					if (!other.removeMacroRuleName_.isEmpty()) {
						if (this.removeMacroRuleName_.isEmpty()) {
							this.removeMacroRuleName_ = other.removeMacroRuleName_;
							this.bitField0_ &= -513;
						} else {
							ensureRemoveMacroRuleNameIsMutable();
							this.removeMacroRuleName_.addAll(other.removeMacroRuleName_);
						}
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Serving.Rule.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Serving.Rule parsedMessage;
				try {
					parsedMessage = (Serving.Rule) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Serving.Rule) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Serving.Rule.Builder setAddMacro(int index, int value) {
				ensureAddMacroIsMutable();
				this.addMacro_.set(index, Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder setAddMacroRuleName(int index, int value) {
				ensureAddMacroRuleNameIsMutable();
				this.addMacroRuleName_.set(index, Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder setAddTag(int index, int value) {
				ensureAddTagIsMutable();
				this.addTag_.set(index, Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder setAddTagRuleName(int index, int value) {
				ensureAddTagRuleNameIsMutable();
				this.addTagRuleName_.set(index, Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder setNegativePredicate(int index, int value) {
				ensureNegativePredicateIsMutable();
				this.negativePredicate_.set(index, Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder setPositivePredicate(int index, int value) {
				ensurePositivePredicateIsMutable();
				this.positivePredicate_.set(index, Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder setRemoveMacro(int index, int value) {
				ensureRemoveMacroIsMutable();
				this.removeMacro_.set(index, Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder setRemoveMacroRuleName(int index, int value) {
				ensureRemoveMacroRuleNameIsMutable();
				this.removeMacroRuleName_.set(index, Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder setRemoveTag(int index, int value) {
				ensureRemoveTagIsMutable();
				this.removeTag_.set(index, Integer.valueOf(value));
				return this;
			}

			public Serving.Rule.Builder setRemoveTagRuleName(int index, int value) {
				ensureRemoveTagRuleNameIsMutable();
				this.removeTagRuleName_.set(index, Integer.valueOf(value));
				return this;
			}
		}


		static {
			PARSER = new AbstractParser<Serving.Rule>() {
			public Serving.Rule parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Serving.Rule(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Serving.Rule(true);
			defaultInstance.initFields();
		}

		private Rule(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
					int limit;
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case REMOVE_MACRO_FIELD_NUMBER:
						if ((mutable_bitField0_ & 1) != 1) {
							this.positivePredicate_ = new ArrayList();
							mutable_bitField0_ |= 1;
						}
						this.positivePredicate_.add(Integer.valueOf(input.readInt32()));
						break;
					case REMOVE_MACRO_RULE_NAME_FIELD_NUMBER:
						limit = input.pushLimit(input.readRawVarint32());
						if ((mutable_bitField0_ & 1) == 1 || input.getBytesUntilLimit() <= 0) {
							while (input.getBytesUntilLimit() > 0) {
								this.positivePredicate_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						} else {
							this.positivePredicate_ = new ArrayList();
							mutable_bitField0_ |= 1;
							while (input.getBytesUntilLimit() > 0) {
								this.positivePredicate_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						}
						break;
					case Escaping.CONVERT_JS_VALUE_TO_EXPRESSION_VALUE:
						if ((mutable_bitField0_ & 2) != 2) {
							this.negativePredicate_ = new ArrayList();
							mutable_bitField0_ |= 2;
						}
						this.negativePredicate_.add(Integer.valueOf(input.readInt32()));
						break;
					case Serving.Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						limit = input.pushLimit(input.readRawVarint32());
						if ((mutable_bitField0_ & 2) == 2 || input.getBytesUntilLimit() <= 0) {
							while (input.getBytesUntilLimit() > 0) {
								this.negativePredicate_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						} else {
							this.negativePredicate_ = new ArrayList();
							mutable_bitField0_ |= 2;
							while (input.getBytesUntilLimit() > 0) {
								this.negativePredicate_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						}
						break;
					case 24:
						if ((mutable_bitField0_ & 4) != 4) {
							this.addTag_ = new ArrayList();
							mutable_bitField0_ |= 4;
						}
						this.addTag_.add(Integer.valueOf(input.readInt32()));
						break;
					case 26:
						limit = input.pushLimit(input.readRawVarint32());
						if ((mutable_bitField0_ & 4) == 4 || input.getBytesUntilLimit() <= 0) {
							while (input.getBytesUntilLimit() > 0) {
								this.addTag_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						} else {
							this.addTag_ = new ArrayList();
							mutable_bitField0_ |= 4;
							while (input.getBytesUntilLimit() > 0) {
								this.addTag_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						}
						break;
					case 32:
						if ((mutable_bitField0_ & 8) != 8) {
							this.removeTag_ = new ArrayList();
							mutable_bitField0_ |= 8;
						}
						this.removeTag_.add(Integer.valueOf(input.readInt32()));
						break;
					case 34:
						limit = input.pushLimit(input.readRawVarint32());
						if ((mutable_bitField0_ & 8) == 8 || input.getBytesUntilLimit() <= 0) {
							while (input.getBytesUntilLimit() > 0) {
								this.removeTag_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						} else {
							this.removeTag_ = new ArrayList();
							mutable_bitField0_ |= 8;
							while (input.getBytesUntilLimit() > 0) {
								this.removeTag_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						}
						break;
					case 40:
						if ((mutable_bitField0_ & 16) != 16) {
							this.addTagRuleName_ = new ArrayList();
							mutable_bitField0_ |= 16;
						}
						this.addTagRuleName_.add(Integer.valueOf(input.readInt32()));
						break;
					case 42:
						limit = input.pushLimit(input.readRawVarint32());
						if ((mutable_bitField0_ & 16) == 16 || input.getBytesUntilLimit() <= 0) {
							while (input.getBytesUntilLimit() > 0) {
								this.addTagRuleName_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						} else {
							this.addTagRuleName_ = new ArrayList();
							mutable_bitField0_ |= 16;
							while (input.getBytesUntilLimit() > 0) {
								this.addTagRuleName_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						}
						break;
					case 48:
						if ((mutable_bitField0_ & 32) != 32) {
							this.removeTagRuleName_ = new ArrayList();
							mutable_bitField0_ |= 32;
						}
						this.removeTagRuleName_.add(Integer.valueOf(input.readInt32()));
						break;
					case 50:
						limit = input.pushLimit(input.readRawVarint32());
						if ((mutable_bitField0_ & 32) == 32 || input.getBytesUntilLimit() <= 0) {
							while (input.getBytesUntilLimit() > 0) {
								this.removeTagRuleName_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						} else {
							this.removeTagRuleName_ = new ArrayList();
							mutable_bitField0_ |= 32;
							while (input.getBytesUntilLimit() > 0) {
								this.removeTagRuleName_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						}
						break;
					case 56:
						if ((mutable_bitField0_ & 64) != 64) {
							this.addMacro_ = new ArrayList();
							mutable_bitField0_ |= 64;
						}
						this.addMacro_.add(Integer.valueOf(input.readInt32()));
						break;
					case 58:
						limit = input.pushLimit(input.readRawVarint32());
						if ((mutable_bitField0_ & 64) == 64 || input.getBytesUntilLimit() <= 0) {
							while (input.getBytesUntilLimit() > 0) {
								this.addMacro_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						} else {
							this.addMacro_ = new ArrayList();
							mutable_bitField0_ |= 64;
							while (input.getBytesUntilLimit() > 0) {
								this.addMacro_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						}
						break;
					case 64:
						if ((mutable_bitField0_ & 128) != 128) {
							this.removeMacro_ = new ArrayList();
							mutable_bitField0_ |= 128;
						}
						this.removeMacro_.add(Integer.valueOf(input.readInt32()));
						break;
					case 66:
						limit = input.pushLimit(input.readRawVarint32());
						if ((mutable_bitField0_ & 128) == 128 || input.getBytesUntilLimit() <= 0) {
							while (input.getBytesUntilLimit() > 0) {
								this.removeMacro_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						} else {
							this.removeMacro_ = new ArrayList();
							mutable_bitField0_ |= 128;
							while (input.getBytesUntilLimit() > 0) {
								this.removeMacro_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						}
						break;
					case 72:
						if ((mutable_bitField0_ & 256) != 256) {
							this.addMacroRuleName_ = new ArrayList();
							mutable_bitField0_ |= 256;
						}
						this.addMacroRuleName_.add(Integer.valueOf(input.readInt32()));
						break;
					case 74:
						limit = input.pushLimit(input.readRawVarint32());
						if ((mutable_bitField0_ & 256) == 256 || input.getBytesUntilLimit() <= 0) {
							while (input.getBytesUntilLimit() > 0) {
								this.addMacroRuleName_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						} else {
							this.addMacroRuleName_ = new ArrayList();
							mutable_bitField0_ |= 256;
							while (input.getBytesUntilLimit() > 0) {
								this.addMacroRuleName_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						}
						break;
					case 80:
						if ((mutable_bitField0_ & 512) != 512) {
							this.removeMacroRuleName_ = new ArrayList();
							mutable_bitField0_ |= 512;
						}
						this.removeMacroRuleName_.add(Integer.valueOf(input.readInt32()));
						break;
					case 82:
						limit = input.pushLimit(input.readRawVarint32());
						if ((mutable_bitField0_ & 512) == 512 || input.getBytesUntilLimit() <= 0) {
							while (input.getBytesUntilLimit() > 0) {
								this.removeMacroRuleName_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						} else {
							this.removeMacroRuleName_ = new ArrayList();
							mutable_bitField0_ |= 512;
							while (input.getBytesUntilLimit() > 0) {
								this.removeMacroRuleName_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						}
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
						this.positivePredicate_ = Collections.unmodifiableList(this.positivePredicate_);
					}
					if ((mutable_bitField0_ & 2) == 2) {
						this.negativePredicate_ = Collections.unmodifiableList(this.negativePredicate_);
					}
					if ((mutable_bitField0_ & 4) == 4) {
						this.addTag_ = Collections.unmodifiableList(this.addTag_);
					}
					if ((mutable_bitField0_ & 8) == 8) {
						this.removeTag_ = Collections.unmodifiableList(this.removeTag_);
					}
					if ((mutable_bitField0_ & 16) == 16) {
						this.addTagRuleName_ = Collections.unmodifiableList(this.addTagRuleName_);
					}
					if ((mutable_bitField0_ & 32) == 32) {
						this.removeTagRuleName_ = Collections.unmodifiableList(this.removeTagRuleName_);
					}
					if ((mutable_bitField0_ & 64) == 64) {
						this.addMacro_ = Collections.unmodifiableList(this.addMacro_);
					}
					if ((mutable_bitField0_ & 128) == 128) {
						this.removeMacro_ = Collections.unmodifiableList(this.removeMacro_);
					}
					if ((mutable_bitField0_ & 256) == 256) {
						this.addMacroRuleName_ = Collections.unmodifiableList(this.addMacroRuleName_);
					}
					if ((mutable_bitField0_ & 512) == 512) {
						this.removeMacroRuleName_ = Collections.unmodifiableList(this.removeMacroRuleName_);
					}
					unknownFieldsCodedOutput.flush();
					this.unknownFields = unknownFieldsOutput.toByteString();
				}
			}
			if ((mutable_bitField0_ & 1) == 1) {
				this.positivePredicate_ = Collections.unmodifiableList(this.positivePredicate_);
			}
			if ((mutable_bitField0_ & 2) == 2) {
				this.negativePredicate_ = Collections.unmodifiableList(this.negativePredicate_);
			}
			if ((mutable_bitField0_ & 4) == 4) {
				this.addTag_ = Collections.unmodifiableList(this.addTag_);
			}
			if ((mutable_bitField0_ & 8) == 8) {
				this.removeTag_ = Collections.unmodifiableList(this.removeTag_);
			}
			if ((mutable_bitField0_ & 16) == 16) {
				this.addTagRuleName_ = Collections.unmodifiableList(this.addTagRuleName_);
			}
			if ((mutable_bitField0_ & 32) == 32) {
				this.removeTagRuleName_ = Collections.unmodifiableList(this.removeTagRuleName_);
			}
			if ((mutable_bitField0_ & 64) == 64) {
				this.addMacro_ = Collections.unmodifiableList(this.addMacro_);
			}
			if ((mutable_bitField0_ & 128) == 128) {
				this.removeMacro_ = Collections.unmodifiableList(this.removeMacro_);
			}
			if ((mutable_bitField0_ & 256) == 256) {
				this.addMacroRuleName_ = Collections.unmodifiableList(this.addMacroRuleName_);
			}
			if ((mutable_bitField0_ & 512) == 512) {
				this.removeMacroRuleName_ = Collections.unmodifiableList(this.removeMacroRuleName_);
			}
			try {
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
			} catch (IOException e_3) {
				this.unknownFields = unknownFieldsOutput.toByteString();
			}
			makeExtensionsImmutable();
		}

		private Rule(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private Rule(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Serving.Rule getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.positivePredicate_ = Collections.emptyList();
			this.negativePredicate_ = Collections.emptyList();
			this.addTag_ = Collections.emptyList();
			this.removeTag_ = Collections.emptyList();
			this.addTagRuleName_ = Collections.emptyList();
			this.removeTagRuleName_ = Collections.emptyList();
			this.addMacro_ = Collections.emptyList();
			this.removeMacro_ = Collections.emptyList();
			this.addMacroRuleName_ = Collections.emptyList();
			this.removeMacroRuleName_ = Collections.emptyList();
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Serving.Rule prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Serving.Rule parseDelimitedFrom(InputStream input) throws IOException {
			return (Serving.Rule) PARSER.parseDelimitedFrom(input);
		}

		public static Serving.Rule parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.Rule) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Serving.Rule parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Serving.Rule) PARSER.parseFrom(data);
		}

		public static Serving.Rule parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Serving.Rule) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Serving.Rule parseFrom(CodedInputStream input) throws IOException {
			return (Serving.Rule) PARSER.parseFrom(input);
		}

		public static Serving.Rule parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.Rule) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Serving.Rule parseFrom(InputStream input) throws IOException {
			return (Serving.Rule) PARSER.parseFrom(input);
		}

		public static Serving.Rule parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.Rule) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Serving.Rule parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Serving.Rule) PARSER.parseFrom(data);
		}

		public static Serving.Rule parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Serving.Rule) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Serving.Rule))) {
				return super.equals(obj);
			} else {
				boolean result;
				Serving.Rule other = (Serving.Rule) obj;
				result = (!true || !getPositivePredicateList().equals(other.getPositivePredicateList())) ? false : true;
				result = (!result || !getNegativePredicateList().equals(other.getNegativePredicateList())) ? false : true;
				result = (!result || !getAddTagList().equals(other.getAddTagList())) ? false : true;
				result = (!result || !getRemoveTagList().equals(other.getRemoveTagList())) ? false : true;
				result = (!result || !getAddTagRuleNameList().equals(other.getAddTagRuleNameList())) ? false : true;
				result = (!result || !getRemoveTagRuleNameList().equals(other.getRemoveTagRuleNameList())) ? false : true;
				result = (!result || !getAddMacroList().equals(other.getAddMacroList())) ? false : true;
				result = (!result || !getRemoveMacroList().equals(other.getRemoveMacroList())) ? false : true;
				result = (!result || !getAddMacroRuleNameList().equals(other.getAddMacroRuleNameList())) ? false : true;
				result = (!result || !getRemoveMacroRuleNameList().equals(other.getRemoveMacroRuleNameList())) ? false : true;
				return result;
			}
		}

		public int getAddMacro(int index) {
			return ((Integer) this.addMacro_.get(index)).intValue();
		}

		public int getAddMacroCount() {
			return this.addMacro_.size();
		}

		public List<Integer> getAddMacroList() {
			return this.addMacro_;
		}

		public int getAddMacroRuleName(int index) {
			return ((Integer) this.addMacroRuleName_.get(index)).intValue();
		}

		public int getAddMacroRuleNameCount() {
			return this.addMacroRuleName_.size();
		}

		public List<Integer> getAddMacroRuleNameList() {
			return this.addMacroRuleName_;
		}

		public int getAddTag(int index) {
			return ((Integer) this.addTag_.get(index)).intValue();
		}

		public int getAddTagCount() {
			return this.addTag_.size();
		}

		public List<Integer> getAddTagList() {
			return this.addTag_;
		}

		public int getAddTagRuleName(int index) {
			return ((Integer) this.addTagRuleName_.get(index)).intValue();
		}

		public int getAddTagRuleNameCount() {
			return this.addTagRuleName_.size();
		}

		public List<Integer> getAddTagRuleNameList() {
			return this.addTagRuleName_;
		}

		public Serving.Rule getDefaultInstanceForType() {
			return defaultInstance;
		}

		public int getNegativePredicate(int index) {
			return ((Integer) this.negativePredicate_.get(index)).intValue();
		}

		public int getNegativePredicateCount() {
			return this.negativePredicate_.size();
		}

		public List<Integer> getNegativePredicateList() {
			return this.negativePredicate_;
		}

		public Parser<Serving.Rule> getParserForType() {
			return PARSER;
		}

		public int getPositivePredicate(int index) {
			return ((Integer) this.positivePredicate_.get(index)).intValue();
		}

		public int getPositivePredicateCount() {
			return this.positivePredicate_.size();
		}

		public List<Integer> getPositivePredicateList() {
			return this.positivePredicate_;
		}

		public int getRemoveMacro(int index) {
			return ((Integer) this.removeMacro_.get(index)).intValue();
		}

		public int getRemoveMacroCount() {
			return this.removeMacro_.size();
		}

		public List<Integer> getRemoveMacroList() {
			return this.removeMacro_;
		}

		public int getRemoveMacroRuleName(int index) {
			return ((Integer) this.removeMacroRuleName_.get(index)).intValue();
		}

		public int getRemoveMacroRuleNameCount() {
			return this.removeMacroRuleName_.size();
		}

		public List<Integer> getRemoveMacroRuleNameList() {
			return this.removeMacroRuleName_;
		}

		public int getRemoveTag(int index) {
			return ((Integer) this.removeTag_.get(index)).intValue();
		}

		public int getRemoveTagCount() {
			return this.removeTag_.size();
		}

		public List<Integer> getRemoveTagList() {
			return this.removeTag_;
		}

		public int getRemoveTagRuleName(int index) {
			return ((Integer) this.removeTagRuleName_.get(index)).intValue();
		}

		public int getRemoveTagRuleNameCount() {
			return this.removeTagRuleName_.size();
		}

		public List<Integer> getRemoveTagRuleNameList() {
			return this.removeTagRuleName_;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				int dataSize = 0;
				int i = 0;
				while (i < this.positivePredicate_.size()) {
					dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.positivePredicate_.get(i)).intValue());
					i++;
				}
				size = (size + dataSize) + (getPositivePredicateList().size() * 1);
				dataSize = 0;
				i = 0;
				while (i < this.negativePredicate_.size()) {
					dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.negativePredicate_.get(i)).intValue());
					i++;
				}
				size = (size + dataSize) + (getNegativePredicateList().size() * 1);
				dataSize = 0;
				i = 0;
				while (i < this.addTag_.size()) {
					dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.addTag_.get(i)).intValue());
					i++;
				}
				size = (size + dataSize) + (getAddTagList().size() * 1);
				dataSize = 0;
				i = 0;
				while (i < this.removeTag_.size()) {
					dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.removeTag_.get(i)).intValue());
					i++;
				}
				size = (size + dataSize) + (getRemoveTagList().size() * 1);
				dataSize = 0;
				i = 0;
				while (i < this.addTagRuleName_.size()) {
					dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.addTagRuleName_.get(i)).intValue());
					i++;
				}
				size = (size + dataSize) + (getAddTagRuleNameList().size() * 1);
				dataSize = 0;
				i = 0;
				while (i < this.removeTagRuleName_.size()) {
					dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.removeTagRuleName_.get(i)).intValue());
					i++;
				}
				size = (size + dataSize) + (getRemoveTagRuleNameList().size() * 1);
				dataSize = 0;
				i = 0;
				while (i < this.addMacro_.size()) {
					dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.addMacro_.get(i)).intValue());
					i++;
				}
				size = (size + dataSize) + (getAddMacroList().size() * 1);
				dataSize = 0;
				i = 0;
				while (i < this.removeMacro_.size()) {
					dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.removeMacro_.get(i)).intValue());
					i++;
				}
				size = (size + dataSize) + (getRemoveMacroList().size() * 1);
				dataSize = 0;
				i = 0;
				while (i < this.addMacroRuleName_.size()) {
					dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.addMacroRuleName_.get(i)).intValue());
					i++;
				}
				size = (size + dataSize) + (getAddMacroRuleNameList().size() * 1);
				dataSize = 0;
				i = 0;
				while (i < this.removeMacroRuleName_.size()) {
					dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.removeMacroRuleName_.get(i)).intValue());
					i++;
				}
				size = ((size + dataSize) + (getRemoveMacroRuleNameList().size() * 1)) + this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
		}

		public int hashCode() {
			if (this.memoizedHashCode != 0) {
				return this.memoizedHashCode;
			} else {
				int hash = Serving.Rule.class.hashCode() + 779;
				if (getPositivePredicateCount() > 0) {
					hash = (((hash * 37) + 1) * 53) + getPositivePredicateList().hashCode();
				}
				if (getNegativePredicateCount() > 0) {
					hash = (((hash * 37) + 2) * 53) + getNegativePredicateList().hashCode();
				}
				if (getAddTagCount() > 0) {
					hash = (((hash * 37) + 3) * 53) + getAddTagList().hashCode();
				}
				if (getRemoveTagCount() > 0) {
					hash = (((hash * 37) + 4) * 53) + getRemoveTagList().hashCode();
				}
				if (getAddTagRuleNameCount() > 0) {
					hash = (((hash * 37) + 5) * 53) + getAddTagRuleNameList().hashCode();
				}
				if (getRemoveTagRuleNameCount() > 0) {
					hash = (((hash * 37) + 6) * 53) + getRemoveTagRuleNameList().hashCode();
				}
				if (getAddMacroCount() > 0) {
					hash = (((hash * 37) + 7) * 53) + getAddMacroList().hashCode();
				}
				if (getRemoveMacroCount() > 0) {
					hash = (((hash * 37) + 8) * 53) + getRemoveMacroList().hashCode();
				}
				if (getAddMacroRuleNameCount() > 0) {
					hash = (((hash * 37) + 9) * 53) + getAddMacroRuleNameList().hashCode();
				}
				if (getRemoveMacroRuleNameCount() > 0) {
					hash = (((hash * 37) + 10) * 53) + getRemoveMacroRuleNameList().hashCode();
				}
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$Rule");
			}
			return mutableDefault;
		}

		public final boolean isInitialized() {
			byte isInitialized = this.memoizedIsInitialized;
			if (isInitialized != (byte) -1) {
				return isInitialized == (byte) 1;
			} else {
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
			while (i < this.positivePredicate_.size()) {
				output.writeInt32(POSITIVE_PREDICATE_FIELD_NUMBER, ((Integer) this.positivePredicate_.get(i)).intValue());
				i++;
			}
			i = 0;
			while (i < this.negativePredicate_.size()) {
				output.writeInt32(NEGATIVE_PREDICATE_FIELD_NUMBER, ((Integer) this.negativePredicate_.get(i)).intValue());
				i++;
			}
			i = 0;
			while (i < this.addTag_.size()) {
				output.writeInt32(ADD_TAG_FIELD_NUMBER, ((Integer) this.addTag_.get(i)).intValue());
				i++;
			}
			i = 0;
			while (i < this.removeTag_.size()) {
				output.writeInt32(REMOVE_TAG_FIELD_NUMBER, ((Integer) this.removeTag_.get(i)).intValue());
				i++;
			}
			i = 0;
			while (i < this.addTagRuleName_.size()) {
				output.writeInt32(ADD_TAG_RULE_NAME_FIELD_NUMBER, ((Integer) this.addTagRuleName_.get(i)).intValue());
				i++;
			}
			i = 0;
			while (i < this.removeTagRuleName_.size()) {
				output.writeInt32(REMOVE_TAG_RULE_NAME_FIELD_NUMBER, ((Integer) this.removeTagRuleName_.get(i)).intValue());
				i++;
			}
			i = 0;
			while (i < this.addMacro_.size()) {
				output.writeInt32(ADD_MACRO_FIELD_NUMBER, ((Integer) this.addMacro_.get(i)).intValue());
				i++;
			}
			i = 0;
			while (i < this.removeMacro_.size()) {
				output.writeInt32(REMOVE_MACRO_FIELD_NUMBER, ((Integer) this.removeMacro_.get(i)).intValue());
				i++;
			}
			i = 0;
			while (i < this.addMacroRuleName_.size()) {
				output.writeInt32(ADD_MACRO_RULE_NAME_FIELD_NUMBER, ((Integer) this.addMacroRuleName_.get(i)).intValue());
				i++;
			}
			i = 0;
			while (i < this.removeMacroRuleName_.size()) {
				output.writeInt32(REMOVE_MACRO_RULE_NAME_FIELD_NUMBER, ((Integer) this.removeMacroRuleName_.get(i)).intValue());
				i++;
			}
			output.writeRawBytes(this.unknownFields);
		}
	}

	public static interface ServingValueOrBuilder extends MessageLiteOrBuilder {
		public int getListItem(int r1i);

		public int getListItemCount();

		public List<Integer> getListItemList();

		public int getMacroNameReference();

		public int getMacroReference();

		public int getMapKey(int r1i);

		public int getMapKeyCount();

		public List<Integer> getMapKeyList();

		public int getMapValue(int r1i);

		public int getMapValueCount();

		public List<Integer> getMapValueList();

		public int getTemplateToken(int r1i);

		public int getTemplateTokenCount();

		public List<Integer> getTemplateTokenList();

		public boolean hasMacroNameReference();

		public boolean hasMacroReference();
	}

	public static final class ServingValue extends GeneratedMessageLite implements Serving.ServingValueOrBuilder {
		public static final int EXT_FIELD_NUMBER = 101;
		public static final int LIST_ITEM_FIELD_NUMBER = 1;
		public static final int MACRO_NAME_REFERENCE_FIELD_NUMBER = 6;
		public static final int MACRO_REFERENCE_FIELD_NUMBER = 4;
		public static final int MAP_KEY_FIELD_NUMBER = 2;
		public static final int MAP_VALUE_FIELD_NUMBER = 3;
		public static Parser<Serving.ServingValue> PARSER = null;
		public static final int TEMPLATE_TOKEN_FIELD_NUMBER = 5;
		private static final Serving.ServingValue defaultInstance;
		public static final GeneratedExtension<Value, Serving.ServingValue> ext;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private List<Integer> listItem_;
		private int macroNameReference_;
		private int macroReference_;
		private List<Integer> mapKey_;
		private List<Integer> mapValue_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private List<Integer> templateToken_;
		private final ByteString unknownFields;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Serving.ServingValue, Serving.ServingValue.Builder> implements Serving.ServingValueOrBuilder {
			private int bitField0_;
			private List<Integer> listItem_;
			private int macroNameReference_;
			private int macroReference_;
			private List<Integer> mapKey_;
			private List<Integer> mapValue_;
			private List<Integer> templateToken_;

			private Builder() {
				this.listItem_ = Collections.emptyList();
				this.mapKey_ = Collections.emptyList();
				this.mapValue_ = Collections.emptyList();
				this.templateToken_ = Collections.emptyList();
				maybeForceBuilderInitialization();
			}

			private static Serving.ServingValue.Builder create() {
				return new Serving.ServingValue.Builder();
			}

			private void ensureListItemIsMutable() {
				if ((this.bitField0_ & 1) != 1) {
					this.listItem_ = new ArrayList(this.listItem_);
					this.bitField0_ |= 1;
				}
			}

			private void ensureMapKeyIsMutable() {
				if ((this.bitField0_ & 2) != 2) {
					this.mapKey_ = new ArrayList(this.mapKey_);
					this.bitField0_ |= 2;
				}
			}

			private void ensureMapValueIsMutable() {
				if ((this.bitField0_ & 4) != 4) {
					this.mapValue_ = new ArrayList(this.mapValue_);
					this.bitField0_ |= 4;
				}
			}

			private void ensureTemplateTokenIsMutable() {
				if ((this.bitField0_ & 16) != 16) {
					this.templateToken_ = new ArrayList(this.templateToken_);
					this.bitField0_ |= 16;
				}
			}

			private void maybeForceBuilderInitialization() {
			}

			public Serving.ServingValue.Builder addAllListItem(Iterable<Integer> values) {
				ensureListItemIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.listItem_);
				return this;
			}

			public Serving.ServingValue.Builder addAllMapKey(Iterable<Integer> values) {
				ensureMapKeyIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.mapKey_);
				return this;
			}

			public Serving.ServingValue.Builder addAllMapValue(Iterable<Integer> values) {
				ensureMapValueIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.mapValue_);
				return this;
			}

			public Serving.ServingValue.Builder addAllTemplateToken(Iterable<Integer> values) {
				ensureTemplateTokenIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.templateToken_);
				return this;
			}

			public Serving.ServingValue.Builder addListItem(int value) {
				ensureListItemIsMutable();
				this.listItem_.add(Integer.valueOf(value));
				return this;
			}

			public Serving.ServingValue.Builder addMapKey(int value) {
				ensureMapKeyIsMutable();
				this.mapKey_.add(Integer.valueOf(value));
				return this;
			}

			public Serving.ServingValue.Builder addMapValue(int value) {
				ensureMapValueIsMutable();
				this.mapValue_.add(Integer.valueOf(value));
				return this;
			}

			public Serving.ServingValue.Builder addTemplateToken(int value) {
				ensureTemplateTokenIsMutable();
				this.templateToken_.add(Integer.valueOf(value));
				return this;
			}

			public Serving.ServingValue build() {
				Serving.ServingValue result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Serving.ServingValue buildPartial() {
				Serving.ServingValue result = new Serving.ServingValue((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
				int from_bitField0_ = this.bitField0_;
				int to_bitField0_ = 0;
				if ((this.bitField0_ & 1) == 1) {
					this.listItem_ = Collections.unmodifiableList(this.listItem_);
					this.bitField0_ &= -2;
				}
				result.listItem_ = this.listItem_;
				if ((this.bitField0_ & 2) == 2) {
					this.mapKey_ = Collections.unmodifiableList(this.mapKey_);
					this.bitField0_ &= -3;
				}
				result.mapKey_ = this.mapKey_;
				if ((this.bitField0_ & 4) == 4) {
					this.mapValue_ = Collections.unmodifiableList(this.mapValue_);
					this.bitField0_ &= -5;
				}
				result.mapValue_ = this.mapValue_;
				if ((from_bitField0_ & 8) == 8) {
					to_bitField0_ |= 1;
				}
				result.macroReference_ = this.macroReference_;
				if ((this.bitField0_ & 16) == 16) {
					this.templateToken_ = Collections.unmodifiableList(this.templateToken_);
					this.bitField0_ &= -17;
				}
				result.templateToken_ = this.templateToken_;
				if ((from_bitField0_ & 32) == 32) {
					to_bitField0_ |= 2;
				}
				result.macroNameReference_ = this.macroNameReference_;
				result.bitField0_ = to_bitField0_;
				return result;
			}

			public Serving.ServingValue.Builder clear() {
				super.clear();
				this.listItem_ = Collections.emptyList();
				this.bitField0_ &= -2;
				this.mapKey_ = Collections.emptyList();
				this.bitField0_ &= -3;
				this.mapValue_ = Collections.emptyList();
				this.bitField0_ &= -5;
				this.macroReference_ = 0;
				this.bitField0_ &= -9;
				this.templateToken_ = Collections.emptyList();
				this.bitField0_ &= -17;
				this.macroNameReference_ = 0;
				this.bitField0_ &= -33;
				return this;
			}

			public Serving.ServingValue.Builder clearListItem() {
				this.listItem_ = Collections.emptyList();
				this.bitField0_ &= -2;
				return this;
			}

			public Serving.ServingValue.Builder clearMacroNameReference() {
				this.bitField0_ &= -33;
				this.macroNameReference_ = 0;
				return this;
			}

			public Serving.ServingValue.Builder clearMacroReference() {
				this.bitField0_ &= -9;
				this.macroReference_ = 0;
				return this;
			}

			public Serving.ServingValue.Builder clearMapKey() {
				this.mapKey_ = Collections.emptyList();
				this.bitField0_ &= -3;
				return this;
			}

			public Serving.ServingValue.Builder clearMapValue() {
				this.mapValue_ = Collections.emptyList();
				this.bitField0_ &= -5;
				return this;
			}

			public Serving.ServingValue.Builder clearTemplateToken() {
				this.templateToken_ = Collections.emptyList();
				this.bitField0_ &= -17;
				return this;
			}

			public Serving.ServingValue.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public Serving.ServingValue getDefaultInstanceForType() {
				return Serving.ServingValue.getDefaultInstance();
			}

			public int getListItem(int index) {
				return ((Integer) this.listItem_.get(index)).intValue();
			}

			public int getListItemCount() {
				return this.listItem_.size();
			}

			public List<Integer> getListItemList() {
				return Collections.unmodifiableList(this.listItem_);
			}

			public int getMacroNameReference() {
				return this.macroNameReference_;
			}

			public int getMacroReference() {
				return this.macroReference_;
			}

			public int getMapKey(int index) {
				return ((Integer) this.mapKey_.get(index)).intValue();
			}

			public int getMapKeyCount() {
				return this.mapKey_.size();
			}

			public List<Integer> getMapKeyList() {
				return Collections.unmodifiableList(this.mapKey_);
			}

			public int getMapValue(int index) {
				return ((Integer) this.mapValue_.get(index)).intValue();
			}

			public int getMapValueCount() {
				return this.mapValue_.size();
			}

			public List<Integer> getMapValueList() {
				return Collections.unmodifiableList(this.mapValue_);
			}

			public int getTemplateToken(int index) {
				return ((Integer) this.templateToken_.get(index)).intValue();
			}

			public int getTemplateTokenCount() {
				return this.templateToken_.size();
			}

			public List<Integer> getTemplateTokenList() {
				return Collections.unmodifiableList(this.templateToken_);
			}

			public boolean hasMacroNameReference() {
				return (this.bitField0_ & 32) == 32;
			}

			public boolean hasMacroReference() {
				return (this.bitField0_ & 8) == 8;
			}

			public final boolean isInitialized() {
				return true;
			}

			public Serving.ServingValue.Builder mergeFrom(Serving.ServingValue other) {
				if (other == Serving.ServingValue.getDefaultInstance()) {
					return this;
				} else {
					if (!other.listItem_.isEmpty()) {
						if (this.listItem_.isEmpty()) {
							this.listItem_ = other.listItem_;
							this.bitField0_ &= -2;
						} else {
							ensureListItemIsMutable();
							this.listItem_.addAll(other.listItem_);
						}
					}
					if (!other.mapKey_.isEmpty()) {
						if (this.mapKey_.isEmpty()) {
							this.mapKey_ = other.mapKey_;
							this.bitField0_ &= -3;
						} else {
							ensureMapKeyIsMutable();
							this.mapKey_.addAll(other.mapKey_);
						}
					}
					if (!other.mapValue_.isEmpty()) {
						if (this.mapValue_.isEmpty()) {
							this.mapValue_ = other.mapValue_;
							this.bitField0_ &= -5;
						} else {
							ensureMapValueIsMutable();
							this.mapValue_.addAll(other.mapValue_);
						}
					}
					if (other.hasMacroReference()) {
						setMacroReference(other.getMacroReference());
					}
					if (!other.templateToken_.isEmpty()) {
						if (this.templateToken_.isEmpty()) {
							this.templateToken_ = other.templateToken_;
							this.bitField0_ &= -17;
						} else {
							ensureTemplateTokenIsMutable();
							this.templateToken_.addAll(other.templateToken_);
						}
					}
					if (other.hasMacroNameReference()) {
						setMacroNameReference(other.getMacroNameReference());
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Serving.ServingValue.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Serving.ServingValue parsedMessage;
				try {
					parsedMessage = (Serving.ServingValue) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Serving.ServingValue) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Serving.ServingValue.Builder setListItem(int index, int value) {
				ensureListItemIsMutable();
				this.listItem_.set(index, Integer.valueOf(value));
				return this;
			}

			public Serving.ServingValue.Builder setMacroNameReference(int value) {
				this.bitField0_ |= 32;
				this.macroNameReference_ = value;
				return this;
			}

			public Serving.ServingValue.Builder setMacroReference(int value) {
				this.bitField0_ |= 8;
				this.macroReference_ = value;
				return this;
			}

			public Serving.ServingValue.Builder setMapKey(int index, int value) {
				ensureMapKeyIsMutable();
				this.mapKey_.set(index, Integer.valueOf(value));
				return this;
			}

			public Serving.ServingValue.Builder setMapValue(int index, int value) {
				ensureMapValueIsMutable();
				this.mapValue_.set(index, Integer.valueOf(value));
				return this;
			}

			public Serving.ServingValue.Builder setTemplateToken(int index, int value) {
				ensureTemplateTokenIsMutable();
				this.templateToken_.set(index, Integer.valueOf(value));
				return this;
			}
		}


		static {
			PARSER = new AbstractParser<Serving.ServingValue>() {
			public Serving.ServingValue parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Serving.ServingValue(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Serving.ServingValue(true);
			defaultInstance.initFields();
			ext = GeneratedMessageLite.newSingularGeneratedExtension(Value.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, EXT_FIELD_NUMBER, FieldType.MESSAGE, Serving.ServingValue.class);
		}

		private ServingValue(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
					int limit;
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case CodedOutputStream.LITTLE_ENDIAN_64_SIZE:
						if ((mutable_bitField0_ & 1) != 1) {
							this.listItem_ = new ArrayList();
							mutable_bitField0_ |= 1;
						}
						this.listItem_.add(Integer.valueOf(input.readInt32()));
						break;
					case Value.ESCAPING_FIELD_NUMBER:
						limit = input.pushLimit(input.readRawVarint32());
						if ((mutable_bitField0_ & 1) == 1 || input.getBytesUntilLimit() <= 0) {
							while (input.getBytesUntilLimit() > 0) {
								this.listItem_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						} else {
							this.listItem_ = new ArrayList();
							mutable_bitField0_ |= 1;
							while (input.getBytesUntilLimit() > 0) {
								this.listItem_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						}
						break;
					case Escaping.CONVERT_JS_VALUE_TO_EXPRESSION_VALUE:
						if ((mutable_bitField0_ & 2) != 2) {
							this.mapKey_ = new ArrayList();
							mutable_bitField0_ |= 2;
						}
						this.mapKey_.add(Integer.valueOf(input.readInt32()));
						break;
					case Serving.Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						limit = input.pushLimit(input.readRawVarint32());
						if ((mutable_bitField0_ & 2) == 2 || input.getBytesUntilLimit() <= 0) {
							while (input.getBytesUntilLimit() > 0) {
								this.mapKey_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						} else {
							this.mapKey_ = new ArrayList();
							mutable_bitField0_ |= 2;
							while (input.getBytesUntilLimit() > 0) {
								this.mapKey_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						}
						break;
					case 24:
						if ((mutable_bitField0_ & 4) != 4) {
							this.mapValue_ = new ArrayList();
							mutable_bitField0_ |= 4;
						}
						this.mapValue_.add(Integer.valueOf(input.readInt32()));
						break;
					case 26:
						limit = input.pushLimit(input.readRawVarint32());
						if ((mutable_bitField0_ & 4) == 4 || input.getBytesUntilLimit() <= 0) {
							while (input.getBytesUntilLimit() > 0) {
								this.mapValue_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						} else {
							this.mapValue_ = new ArrayList();
							mutable_bitField0_ |= 4;
							while (input.getBytesUntilLimit() > 0) {
								this.mapValue_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						}
						break;
					case 32:
						this.bitField0_ |= 1;
						this.macroReference_ = input.readInt32();
						break;
					case 40:
						if ((mutable_bitField0_ & 16) != 16) {
							this.templateToken_ = new ArrayList();
							mutable_bitField0_ |= 16;
						}
						this.templateToken_.add(Integer.valueOf(input.readInt32()));
						break;
					case 42:
						limit = input.pushLimit(input.readRawVarint32());
						if ((mutable_bitField0_ & 16) == 16 || input.getBytesUntilLimit() <= 0) {
							while (input.getBytesUntilLimit() > 0) {
								this.templateToken_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						} else {
							this.templateToken_ = new ArrayList();
							mutable_bitField0_ |= 16;
							while (input.getBytesUntilLimit() > 0) {
								this.templateToken_.add(Integer.valueOf(input.readInt32()));
							}
							input.popLimit(limit);
						}
						break;
					case 48:
						this.bitField0_ |= 2;
						this.macroNameReference_ = input.readInt32();
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
						this.listItem_ = Collections.unmodifiableList(this.listItem_);
					}
					if ((mutable_bitField0_ & 2) == 2) {
						this.mapKey_ = Collections.unmodifiableList(this.mapKey_);
					}
					if ((mutable_bitField0_ & 4) == 4) {
						this.mapValue_ = Collections.unmodifiableList(this.mapValue_);
					}
					if ((mutable_bitField0_ & 16) == 16) {
						this.templateToken_ = Collections.unmodifiableList(this.templateToken_);
					}
					unknownFieldsCodedOutput.flush();
					this.unknownFields = unknownFieldsOutput.toByteString();
				}
			}
			if ((mutable_bitField0_ & 1) == 1) {
				this.listItem_ = Collections.unmodifiableList(this.listItem_);
			}
			if ((mutable_bitField0_ & 2) == 2) {
				this.mapKey_ = Collections.unmodifiableList(this.mapKey_);
			}
			if ((mutable_bitField0_ & 4) == 4) {
				this.mapValue_ = Collections.unmodifiableList(this.mapValue_);
			}
			if ((mutable_bitField0_ & 16) == 16) {
				this.templateToken_ = Collections.unmodifiableList(this.templateToken_);
			}
			try {
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
			} catch (IOException e_3) {
				this.unknownFields = unknownFieldsOutput.toByteString();
			}
			makeExtensionsImmutable();
		}

		private ServingValue(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private ServingValue(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Serving.ServingValue getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.listItem_ = Collections.emptyList();
			this.mapKey_ = Collections.emptyList();
			this.mapValue_ = Collections.emptyList();
			this.macroReference_ = 0;
			this.templateToken_ = Collections.emptyList();
			this.macroNameReference_ = 0;
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Serving.ServingValue prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Serving.ServingValue parseDelimitedFrom(InputStream input) throws IOException {
			return (Serving.ServingValue) PARSER.parseDelimitedFrom(input);
		}

		public static Serving.ServingValue parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.ServingValue) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Serving.ServingValue parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Serving.ServingValue) PARSER.parseFrom(data);
		}

		public static Serving.ServingValue parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Serving.ServingValue) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Serving.ServingValue parseFrom(CodedInputStream input) throws IOException {
			return (Serving.ServingValue) PARSER.parseFrom(input);
		}

		public static Serving.ServingValue parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.ServingValue) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Serving.ServingValue parseFrom(InputStream input) throws IOException {
			return (Serving.ServingValue) PARSER.parseFrom(input);
		}

		public static Serving.ServingValue parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Serving.ServingValue) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Serving.ServingValue parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Serving.ServingValue) PARSER.parseFrom(data);
		}

		public static Serving.ServingValue parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Serving.ServingValue) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Serving.ServingValue))) {
				return super.equals(obj);
			} else {
				boolean result;
				Serving.ServingValue other = (Serving.ServingValue) obj;
				result = (!true || !getListItemList().equals(other.getListItemList())) ? false : true;
				result = (!result || !getMapKeyList().equals(other.getMapKeyList())) ? false : true;
				result = (!result || !getMapValueList().equals(other.getMapValueList())) ? false : true;
				if (!result || hasMacroReference() != other.hasMacroReference()) {
					result = false;
				} else {
					result = true;
				}
				if (hasMacroReference()) {
					result = (!result || getMacroReference() != other.getMacroReference()) ? false : true;
				}
				result = (!result || !getTemplateTokenList().equals(other.getTemplateTokenList())) ? false : true;
				if (!result || hasMacroNameReference() != other.hasMacroNameReference()) {
					result = false;
				} else {
					result = true;
				}
				if (hasMacroNameReference()) {
					result = (!result || getMacroNameReference() != other.getMacroNameReference()) ? false : true;
				}
				return result;
			}
		}

		public Serving.ServingValue getDefaultInstanceForType() {
			return defaultInstance;
		}

		public int getListItem(int index) {
			return ((Integer) this.listItem_.get(index)).intValue();
		}

		public int getListItemCount() {
			return this.listItem_.size();
		}

		public List<Integer> getListItemList() {
			return this.listItem_;
		}

		public int getMacroNameReference() {
			return this.macroNameReference_;
		}

		public int getMacroReference() {
			return this.macroReference_;
		}

		public int getMapKey(int index) {
			return ((Integer) this.mapKey_.get(index)).intValue();
		}

		public int getMapKeyCount() {
			return this.mapKey_.size();
		}

		public List<Integer> getMapKeyList() {
			return this.mapKey_;
		}

		public int getMapValue(int index) {
			return ((Integer) this.mapValue_.get(index)).intValue();
		}

		public int getMapValueCount() {
			return this.mapValue_.size();
		}

		public List<Integer> getMapValueList() {
			return this.mapValue_;
		}

		public Parser<Serving.ServingValue> getParserForType() {
			return PARSER;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				int dataSize = 0;
				int i = 0;
				while (i < this.listItem_.size()) {
					dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.listItem_.get(i)).intValue());
					i++;
				}
				size = (size + dataSize) + (getListItemList().size() * 1);
				dataSize = 0;
				i = 0;
				while (i < this.mapKey_.size()) {
					dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.mapKey_.get(i)).intValue());
					i++;
				}
				size = (size + dataSize) + (getMapKeyList().size() * 1);
				dataSize = 0;
				i = 0;
				while (i < this.mapValue_.size()) {
					dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.mapValue_.get(i)).intValue());
					i++;
				}
				size = (size + dataSize) + (getMapValueList().size() * 1);
				if ((this.bitField0_ & 1) == 1) {
					size += CodedOutputStream.computeInt32Size(MACRO_REFERENCE_FIELD_NUMBER, this.macroReference_);
				}
				dataSize = 0;
				i = 0;
				while (i < this.templateToken_.size()) {
					dataSize += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.templateToken_.get(i)).intValue());
					i++;
				}
				size = (size + dataSize) + (getTemplateTokenList().size() * 1);
				if ((this.bitField0_ & 2) == 2) {
					size += CodedOutputStream.computeInt32Size(MACRO_NAME_REFERENCE_FIELD_NUMBER, this.macroNameReference_);
				}
				size += this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
		}

		public int getTemplateToken(int index) {
			return ((Integer) this.templateToken_.get(index)).intValue();
		}

		public int getTemplateTokenCount() {
			return this.templateToken_.size();
		}

		public List<Integer> getTemplateTokenList() {
			return this.templateToken_;
		}

		public boolean hasMacroNameReference() {
			return (this.bitField0_ & 2) == 2;
		}

		public boolean hasMacroReference() {
			return (this.bitField0_ & 1) == 1;
		}

		public int hashCode() {
			if (this.memoizedHashCode != 0) {
				return this.memoizedHashCode;
			} else {
				int hash = Serving.ServingValue.class.hashCode() + 779;
				if (getListItemCount() > 0) {
					hash = (((hash * 37) + 1) * 53) + getListItemList().hashCode();
				}
				if (getMapKeyCount() > 0) {
					hash = (((hash * 37) + 2) * 53) + getMapKeyList().hashCode();
				}
				if (getMapValueCount() > 0) {
					hash = (((hash * 37) + 3) * 53) + getMapValueList().hashCode();
				}
				if (hasMacroReference()) {
					hash = (((hash * 37) + 4) * 53) + getMacroReference();
				}
				if (getTemplateTokenCount() > 0) {
					hash = (((hash * 37) + 5) * 53) + getTemplateTokenList().hashCode();
				}
				if (hasMacroNameReference()) {
					hash = (((hash * 37) + 6) * 53) + getMacroNameReference();
				}
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$ServingValue");
			}
			return mutableDefault;
		}

		public final boolean isInitialized() {
			byte isInitialized = this.memoizedIsInitialized;
			if (isInitialized != (byte) -1) {
				return isInitialized == (byte) 1;
			} else {
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
			while (i < this.listItem_.size()) {
				output.writeInt32(LIST_ITEM_FIELD_NUMBER, ((Integer) this.listItem_.get(i)).intValue());
				i++;
			}
			i = 0;
			while (i < this.mapKey_.size()) {
				output.writeInt32(MAP_KEY_FIELD_NUMBER, ((Integer) this.mapKey_.get(i)).intValue());
				i++;
			}
			i = 0;
			while (i < this.mapValue_.size()) {
				output.writeInt32(MAP_VALUE_FIELD_NUMBER, ((Integer) this.mapValue_.get(i)).intValue());
				i++;
			}
			if ((this.bitField0_ & 1) == 1) {
				output.writeInt32(MACRO_REFERENCE_FIELD_NUMBER, this.macroReference_);
			}
			i = 0;
			while (i < this.templateToken_.size()) {
				output.writeInt32(TEMPLATE_TOKEN_FIELD_NUMBER, ((Integer) this.templateToken_.get(i)).intValue());
				i++;
			}
			if ((this.bitField0_ & 2) == 2) {
				output.writeInt32(MACRO_NAME_REFERENCE_FIELD_NUMBER, this.macroNameReference_);
			}
			output.writeRawBytes(this.unknownFields);
		}
	}


	static {
	}

	private Serving() {
	}

	public static void registerAllExtensions(ExtensionRegistryLite registry) {
		registry.add(ServingValue.ext);
	}
}
