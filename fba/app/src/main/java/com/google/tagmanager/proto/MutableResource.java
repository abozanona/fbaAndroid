package com.google.tagmanager.proto;

import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.tagmanager.protobuf.AbstractMutableMessageLite;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import com.google.tagmanager.protobuf.Utf8;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;

public final class MutableResource {
	public static final class ResourceWithMetadata extends GeneratedMutableMessageLite<MutableResource.ResourceWithMetadata> implements MutableMessageLite {
		public static Parser<MutableResource.ResourceWithMetadata> PARSER = null;
		public static final int RESOURCE_FIELD_NUMBER = 2;
		public static final int TIME_STAMP_FIELD_NUMBER = 1;
		private static final MutableResource.ResourceWithMetadata defaultInstance;
		private static volatile MessageLite immutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private Resource resource_;
		private long timeStamp_;

		static {
			immutableDefault = null;
			defaultInstance = new MutableResource.ResourceWithMetadata(true);
			defaultInstance.initFields();
			defaultInstance.makeImmutable();
			PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
		}

		private ResourceWithMetadata() {
			initFields();
		}

		private ResourceWithMetadata(boolean noInit) {
		}

		private void ensureResourceInitialized() {
			if (this.resource_ == Resource.getDefaultInstance()) {
				this.resource_ = Resource.newMessage();
			}
		}

		public static MutableResource.ResourceWithMetadata getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.resource_ = Resource.getDefaultInstance();
		}

		public static MutableResource.ResourceWithMetadata newMessage() {
			return new MutableResource.ResourceWithMetadata();
		}

		public MutableResource.ResourceWithMetadata clear() {
			assertMutable();
			super.clear();
			this.timeStamp_ = 0;
			this.bitField0_ &= -2;
			if (this.resource_ != Resource.getDefaultInstance()) {
				this.resource_.clear();
			}
			this.bitField0_ &= -3;
			return this;
		}

		public MutableResource.ResourceWithMetadata clearResource() {
			assertMutable();
			this.bitField0_ &= -3;
			if (this.resource_ != Resource.getDefaultInstance()) {
				this.resource_.clear();
			}
			return this;
		}

		public MutableResource.ResourceWithMetadata clearTimeStamp() {
			assertMutable();
			this.bitField0_ &= -2;
			this.timeStamp_ = 0;
			return this;
		}

		public MutableResource.ResourceWithMetadata clone() {
			return newMessageForType().mergeFrom(this);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof MutableResource.ResourceWithMetadata))) {
				return super.equals(obj);
			} else {
				boolean result;
				MutableResource.ResourceWithMetadata other = (MutableResource.ResourceWithMetadata) obj;
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

		public final MutableResource.ResourceWithMetadata getDefaultInstanceForType() {
			return defaultInstance;
		}

		public Resource getMutableResource() {
			assertMutable();
			ensureResourceInitialized();
			this.bitField0_ |= 2;
			return this.resource_;
		}

		public Parser<MutableResource.ResourceWithMetadata> getParserForType() {
			return PARSER;
		}

		public Resource getResource() {
			return this.resource_;
		}

		public int getSerializedSize() {
			int size = ((0 + CodedOutputStream.computeInt64Size(TIME_STAMP_FIELD_NUMBER, this.timeStamp_)) + CodedOutputStream.computeMessageSize(RESOURCE_FIELD_NUMBER, this.resource_)) + this.unknownFields.size();
			this.cachedSize = size;
			return size;
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
			int hash = 41;
			if (hasTimeStamp()) {
				hash = 1517 + 1;
				hash = 80454 + Internal.hashLong(getTimeStamp());
			}
			if (hasResource()) {
				hash = (((hash * 37) + 2) * 53) + getResource().hashCode();
			}
			return (hash * 29) + this.unknownFields.hashCode();
		}

		protected MessageLite internalImmutableDefault() {
			if (immutableDefault == null) {
				immutableDefault = internalImmutableDefault("com.google.tagmanager.proto.Resource$ResourceWithMetadata");
			}
			return immutableDefault;
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

		public MutableResource.ResourceWithMetadata mergeFrom(MutableResource.ResourceWithMetadata other) {
			if (this == other) {
				throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
			} else {
				assertMutable();
				if (other == getDefaultInstance()) {
					return this;
				} else {
					if (other.hasTimeStamp()) {
						setTimeStamp(other.getTimeStamp());
					}
					if (other.hasResource()) {
						ensureResourceInitialized();
						this.resource_.mergeFrom(other.getResource());
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
					case CodedOutputStream.LITTLE_ENDIAN_64_SIZE:
						this.bitField0_ |= 1;
						this.timeStamp_ = input.readInt64();
						break;
					case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						if (this.resource_ == Resource.getDefaultInstance()) {
							this.resource_ = Resource.newMessage();
						}
						this.bitField0_ |= 2;
						input.readMessage(this.resource_, extensionRegistry);
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

		public MutableResource.ResourceWithMetadata newMessageForType() {
			return new MutableResource.ResourceWithMetadata();
		}

		public MutableResource.ResourceWithMetadata setResource(Resource value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 2;
				this.resource_ = value;
				return this;
			}
		}

		public MutableResource.ResourceWithMetadata setTimeStamp(long value) {
			assertMutable();
			this.bitField0_ |= 1;
			this.timeStamp_ = value;
			return this;
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeToWithCachedSizes(CodedOutputStream output) throws IOException {
			int bytesWrittenBefore = output.getTotalBytesWritten();
			output.writeInt64(TIME_STAMP_FIELD_NUMBER, this.timeStamp_);
			output.writeMessageWithCachedSizes(RESOURCE_FIELD_NUMBER, this.resource_);
			output.writeRawBytes(this.unknownFields);
			if (getCachedSize() != output.getTotalBytesWritten() - bytesWrittenBefore) {
				throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
			}
		}
	}


	static {
	}

	private MutableResource() {
	}

	public static void registerAllExtensions(ExtensionRegistryLite registry) {
	}
}
