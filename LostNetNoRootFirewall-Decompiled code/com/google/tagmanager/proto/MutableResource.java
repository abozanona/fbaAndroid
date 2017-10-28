package com.google.tagmanager.proto;

import com.google.analytics.containertag.proto.MutableServing.Resource;
import com.google.android.vending.licensing.APKExpansionPolicy;
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
import java.io.IOException;
import java.io.OutputStream;

public final class MutableResource {

    public final class ResourceWithMetadata extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        public static final int RESOURCE_FIELD_NUMBER = 2;
        public static final int TIME_STAMP_FIELD_NUMBER = 1;
        private static final ResourceWithMetadata defaultInstance = new ResourceWithMetadata(true);
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Resource resource_;
        private long timeStamp_;

        static {
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
        }

        private ResourceWithMetadata() {
            initFields();
        }

        private ResourceWithMetadata(boolean z) {
        }

        private void ensureResourceInitialized() {
            if (this.resource_ == Resource.getDefaultInstance()) {
                this.resource_ = Resource.newMessage();
            }
        }

        public static ResourceWithMetadata getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.resource_ = Resource.getDefaultInstance();
        }

        public static ResourceWithMetadata newMessage() {
            return new ResourceWithMetadata();
        }

        public ResourceWithMetadata clear() {
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

        public ResourceWithMetadata clearResource() {
            assertMutable();
            this.bitField0_ &= -3;
            if (this.resource_ != Resource.getDefaultInstance()) {
                this.resource_.clear();
            }
            return this;
        }

        public ResourceWithMetadata clearTimeStamp() {
            assertMutable();
            this.bitField0_ &= -2;
            this.timeStamp_ = 0;
            return this;
        }

        public ResourceWithMetadata clone() {
            return newMessageForType().mergeFrom(this);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ResourceWithMetadata)) {
                return super.equals(obj);
            }
            ResourceWithMetadata resourceWithMetadata = (ResourceWithMetadata) obj;
            boolean z = hasTimeStamp() == resourceWithMetadata.hasTimeStamp();
            if (hasTimeStamp()) {
                z = z && getTimeStamp() == resourceWithMetadata.getTimeStamp();
            }
            z = z && hasResource() == resourceWithMetadata.hasResource();
            return hasResource() ? z && getResource().equals(resourceWithMetadata.getResource()) : z;
        }

        public final ResourceWithMetadata getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Resource getMutableResource() {
            assertMutable();
            ensureResourceInitialized();
            this.bitField0_ |= 2;
            return this.resource_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public Resource getResource() {
            return this.resource_;
        }

        public int getSerializedSize() {
            int computeInt64Size = ((0 + CodedOutputStream.computeInt64Size(1, this.timeStamp_)) + CodedOutputStream.computeMessageSize(2, this.resource_)) + this.unknownFields.size();
            this.cachedSize = computeInt64Size;
            return computeInt64Size;
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
            int i = 41;
            if (hasTimeStamp()) {
                i = 80454 + Internal.hashLong(getTimeStamp());
            }
            if (hasResource()) {
                i = (((i * 37) + 2) * 53) + getResource().hashCode();
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.tagmanager.proto.Resource$ResourceWithMetadata");
            }
            return immutableDefault;
        }

        public final boolean isInitialized() {
            return hasTimeStamp() && hasResource() && getResource().isInitialized();
        }

        public ResourceWithMetadata mergeFrom(ResourceWithMetadata resourceWithMetadata) {
            if (this == resourceWithMetadata) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (resourceWithMetadata != getDefaultInstance()) {
                if (resourceWithMetadata.hasTimeStamp()) {
                    setTimeStamp(resourceWithMetadata.getTimeStamp());
                }
                if (resourceWithMetadata.hasResource()) {
                    ensureResourceInitialized();
                    this.resource_.mergeFrom(resourceWithMetadata.getResource());
                    this.bitField0_ |= 2;
                }
                this.unknownFields = this.unknownFields.concat(resourceWithMetadata.unknownFields);
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
                            this.bitField0_ |= 1;
                            this.timeStamp_ = codedInputStream.readInt64();
                            break;
                        case 18:
                            if (this.resource_ == Resource.getDefaultInstance()) {
                                this.resource_ = Resource.newMessage();
                            }
                            this.bitField0_ |= 2;
                            codedInputStream.readMessage(this.resource_, extensionRegistryLite);
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

        public ResourceWithMetadata newMessageForType() {
            return new ResourceWithMetadata();
        }

        public ResourceWithMetadata setResource(Resource resource) {
            assertMutable();
            if (resource == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.resource_ = resource;
            return this;
        }

        public ResourceWithMetadata setTimeStamp(long j) {
            assertMutable();
            this.bitField0_ |= 1;
            this.timeStamp_ = j;
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            codedOutputStream.writeInt64(1, this.timeStamp_);
            codedOutputStream.writeMessageWithCachedSizes(2, this.resource_);
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    private MutableResource() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
