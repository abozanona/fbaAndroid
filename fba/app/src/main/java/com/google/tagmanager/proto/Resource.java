package com.google.tagmanager.proto;

import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.InvalidProtocolBufferException;
import com.google.tagmanager.protobuf.MessageLiteOrBuilder;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import com.google.tagmanager.protobuf.Utf8;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.OutputStream;

public final class Resource {
	public static interface ResourceWithMetadataOrBuilder extends MessageLiteOrBuilder {
		public com.google.analytics.containertag.proto.Serving.Resource getResource();

		public long getTimeStamp();

		public boolean hasResource();

		public boolean hasTimeStamp();
	}

	public static final class ResourceWithMetadata extends GeneratedMessageLite implements Resource.ResourceWithMetadataOrBuilder {
		public static Parser<Resource.ResourceWithMetadata> PARSER = null;
		public static final int RESOURCE_FIELD_NUMBER = 2;
		public static final int TIME_STAMP_FIELD_NUMBER = 1;
		private static final Resource.ResourceWithMetadata defaultInstance;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private com.google.analytics.containertag.proto.Serving.Resource resource_;
		private long timeStamp_;
		private final ByteString unknownFields;

		public static final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder<Resource.ResourceWithMetadata, Resource.ResourceWithMetadata.Builder> implements Resource.ResourceWithMetadataOrBuilder {
			private int bitField0_;
			private com.google.analytics.containertag.proto.Serving.Resource resource_;
			private long timeStamp_;

			private Builder() {
				this.resource_ = com.google.analytics.containertag.proto.Serving.Resource.getDefaultInstance();
				maybeForceBuilderInitialization();
			}

			private static Resource.ResourceWithMetadata.Builder create() {
				return new Resource.ResourceWithMetadata.Builder();
			}

			private void maybeForceBuilderInitialization() {
			}

			public Resource.ResourceWithMetadata build() {
				Resource.ResourceWithMetadata result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public Resource.ResourceWithMetadata buildPartial() {
				Resource.ResourceWithMetadata result = new Resource.ResourceWithMetadata((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder)null);
				int from_bitField0_ = this.bitField0_;
				int to_bitField0_ = 0;
				if ((from_bitField0_ & 1) == 1) {
					to_bitField0_ |= 1;
				}
				result.timeStamp_ = this.timeStamp_;
				if ((from_bitField0_ & 2) == 2) {
					to_bitField0_ |= 2;
				}
				result.resource_ = this.resource_;
				result.bitField0_ = to_bitField0_;
				return result;
			}

			public Resource.ResourceWithMetadata.Builder clear() {
				super.clear();
				this.timeStamp_ = 0;
				this.bitField0_ &= -2;
				this.resource_ = com.google.analytics.containertag.proto.Serving.Resource.getDefaultInstance();
				this.bitField0_ &= -3;
				return this;
			}

			public Resource.ResourceWithMetadata.Builder clearResource() {
				this.resource_ = com.google.analytics.containertag.proto.Serving.Resource.getDefaultInstance();
				this.bitField0_ &= -3;
				return this;
			}

			public Resource.ResourceWithMetadata.Builder clearTimeStamp() {
				this.bitField0_ &= -2;
				this.timeStamp_ = 0;
				return this;
			}

			public Resource.ResourceWithMetadata.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public Resource.ResourceWithMetadata getDefaultInstanceForType() {
				return Resource.ResourceWithMetadata.getDefaultInstance();
			}

			public com.google.analytics.containertag.proto.Serving.Resource getResource() {
				return this.resource_;
			}

			public long getTimeStamp() {
				return this.timeStamp_;
			}

			public boolean hasResource() {
				return (this.bitField0_ & 2) == 2;
			}

			public boolean hasTimeStamp() {
				return (this.bitField0_ & 1) == 1;
			}

			public final boolean isInitialized() {
				if (!hasTimeStamp()) {
					return false;
				} else {
					if (hasResource()) {
						if (getResource().isInitialized()) {
							return true;
						}
						return false;
					}
					return false;
				}
			}

			public Resource.ResourceWithMetadata.Builder mergeFrom(Resource.ResourceWithMetadata other) {
				if (other == Resource.ResourceWithMetadata.getDefaultInstance()) {
					return this;
				} else {
					if (other.hasTimeStamp()) {
						setTimeStamp(other.getTimeStamp());
					}
					if (other.hasResource()) {
						mergeResource(other.getResource());
					}
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public Resource.ResourceWithMetadata.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				Resource.ResourceWithMetadata parsedMessage;
				try {
					parsedMessage = (Resource.ResourceWithMetadata) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (Resource.ResourceWithMetadata) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public Resource.ResourceWithMetadata.Builder mergeResource(com.google.analytics.containertag.proto.Serving.Resource value) {
				if ((this.bitField0_ & 2) != 2 || this.resource_ == com.google.analytics.containertag.proto.Serving.Resource.getDefaultInstance()) {
					this.resource_ = value;
				} else {
					this.resource_ = com.google.analytics.containertag.proto.Serving.Resource.newBuilder(this.resource_).mergeFrom(value).buildPartial();
				}
				this.bitField0_ |= 2;
				return this;
			}

			public Resource.ResourceWithMetadata.Builder setResource(com.google.analytics.containertag.proto.Serving.Resource.Builder builderForValue) {
				this.resource_ = builderForValue.build();
				this.bitField0_ |= 2;
				return this;
			}

			public Resource.ResourceWithMetadata.Builder setResource(com.google.analytics.containertag.proto.Serving.Resource value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.resource_ = value;
					this.bitField0_ |= 2;
					return this;
				}
			}

			public Resource.ResourceWithMetadata.Builder setTimeStamp(long value) {
				this.bitField0_ |= 1;
				this.timeStamp_ = value;
				return this;
			}
		}


		static {
			PARSER = new AbstractParser<Resource.ResourceWithMetadata>() {
			public Resource.ResourceWithMetadata parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new Resource.ResourceWithMetadata(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new Resource.ResourceWithMetadata(true);
			defaultInstance.initFields();
		}

		private ResourceWithMetadata(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
						this.timeStamp_ = input.readInt64();
						break;
					case com.google.analytics.containertag.proto.Serving.Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						com.google.analytics.containertag.proto.Serving.Resource.Builder subBuilder = null;
						if ((this.bitField0_ & 2) == 2) {
							subBuilder = this.resource_.toBuilder();
						}
						this.resource_ = (com.google.analytics.containertag.proto.Serving.Resource) input.readMessage(com.google.analytics.containertag.proto.Serving.Resource.PARSER, extensionRegistry);
						if (subBuilder != null) {
							subBuilder.mergeFrom(this.resource_);
							this.resource_ = subBuilder.buildPartial();
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

		private ResourceWithMetadata(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private ResourceWithMetadata(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static Resource.ResourceWithMetadata getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.timeStamp_ = 0;
			this.resource_ = com.google.analytics.containertag.proto.Serving.Resource.getDefaultInstance();
		}

		public static Builder newBuilder() {
			return Builder.create();
		}

		public static Builder newBuilder(Resource.ResourceWithMetadata prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static Resource.ResourceWithMetadata parseDelimitedFrom(InputStream input) throws IOException {
			return (Resource.ResourceWithMetadata) PARSER.parseDelimitedFrom(input);
		}

		public static Resource.ResourceWithMetadata parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Resource.ResourceWithMetadata) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static Resource.ResourceWithMetadata parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (Resource.ResourceWithMetadata) PARSER.parseFrom(data);
		}

		public static Resource.ResourceWithMetadata parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Resource.ResourceWithMetadata) PARSER.parseFrom(data, extensionRegistry);
		}

		public static Resource.ResourceWithMetadata parseFrom(CodedInputStream input) throws IOException {
			return (Resource.ResourceWithMetadata) PARSER.parseFrom(input);
		}

		public static Resource.ResourceWithMetadata parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Resource.ResourceWithMetadata) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Resource.ResourceWithMetadata parseFrom(InputStream input) throws IOException {
			return (Resource.ResourceWithMetadata) PARSER.parseFrom(input);
		}

		public static Resource.ResourceWithMetadata parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (Resource.ResourceWithMetadata) PARSER.parseFrom(input, extensionRegistry);
		}

		public static Resource.ResourceWithMetadata parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (Resource.ResourceWithMetadata) PARSER.parseFrom(data);
		}

		public static Resource.ResourceWithMetadata parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (Resource.ResourceWithMetadata) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof Resource.ResourceWithMetadata))) {
				return super.equals(obj);
			} else {
				boolean result;
				Resource.ResourceWithMetadata other = (Resource.ResourceWithMetadata) obj;
				if (!true || hasTimeStamp() != other.hasTimeStamp()) {
					result = false;
				} else {
					result = true;
				}
				if (hasTimeStamp()) {
					result = (!result || getTimeStamp() != other.getTimeStamp()) ? false : true;
				}
				if (!result || hasResource() != other.hasResource()) {
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

		public Resource.ResourceWithMetadata getDefaultInstanceForType() {
			return defaultInstance;
		}

		public Parser<Resource.ResourceWithMetadata> getParserForType() {
			return PARSER;
		}

		public com.google.analytics.containertag.proto.Serving.Resource getResource() {
			return this.resource_;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				if ((this.bitField0_ & 1) == 1) {
					size += CodedOutputStream.computeInt64Size(TIME_STAMP_FIELD_NUMBER, this.timeStamp_);
				}
				if ((this.bitField0_ & 2) == 2) {
					size += CodedOutputStream.computeMessageSize(RESOURCE_FIELD_NUMBER, this.resource_);
				}
				size += this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
		}

		public long getTimeStamp() {
			return this.timeStamp_;
		}

		public boolean hasResource() {
			return (this.bitField0_ & 2) == 2;
		}

		public boolean hasTimeStamp() {
			return (this.bitField0_ & 1) == 1;
		}

		public int hashCode() {
			if (this.memoizedHashCode != 0) {
				return this.memoizedHashCode;
			} else {
				int hash = Resource.ResourceWithMetadata.class.hashCode() + 779;
				if (hasTimeStamp()) {
					hash = (((hash * 37) + 1) * 53) + Internal.hashLong(getTimeStamp());
				}
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
				mutableDefault = internalMutableDefault("com.google.tagmanager.proto.MutableResource$ResourceWithMetadata");
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
			} else if (!hasTimeStamp()) {
				this.memoizedIsInitialized = (byte) 0;
				return false;
			} else if (!hasResource()) {
				this.memoizedIsInitialized = (byte) 0;
				return false;
			} else if (!getResource().isInitialized()) {
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
				output.writeInt64(TIME_STAMP_FIELD_NUMBER, this.timeStamp_);
			}
			if ((this.bitField0_ & 2) == 2) {
				output.writeMessage(RESOURCE_FIELD_NUMBER, this.resource_);
			}
			output.writeRawBytes(this.unknownFields);
		}
	}


	static {
	}

	private Resource() {
	}

	public static void registerAllExtensions(ExtensionRegistryLite registry) {
	}
}
