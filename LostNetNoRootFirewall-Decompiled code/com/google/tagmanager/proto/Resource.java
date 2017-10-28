package com.google.tagmanager.proto;

import com.google.android.vending.licensing.APKExpansionPolicy;
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
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class Resource {

    public interface ResourceWithMetadataOrBuilder extends MessageLiteOrBuilder {
        com.google.analytics.containertag.proto.Serving.Resource getResource();

        long getTimeStamp();

        boolean hasResource();

        boolean hasTimeStamp();
    }

    public final class ResourceWithMetadata extends GeneratedMessageLite implements ResourceWithMetadataOrBuilder {
        public static Parser PARSER = new C0236b();
        public static final int RESOURCE_FIELD_NUMBER = 2;
        public static final int TIME_STAMP_FIELD_NUMBER = 1;
        private static final ResourceWithMetadata defaultInstance = new ResourceWithMetadata(true);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private com.google.analytics.containertag.proto.Serving.Resource resource_;
        private long timeStamp_;
        private final ByteString unknownFields;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements ResourceWithMetadataOrBuilder {
            private int bitField0_;
            private com.google.analytics.containertag.proto.Serving.Resource resource_ = com.google.analytics.containertag.proto.Serving.Resource.getDefaultInstance();
            private long timeStamp_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public ResourceWithMetadata build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public ResourceWithMetadata buildPartial() {
                int i = 1;
                ResourceWithMetadata resourceWithMetadata = new ResourceWithMetadata((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0_;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                resourceWithMetadata.timeStamp_ = this.timeStamp_;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                resourceWithMetadata.resource_ = this.resource_;
                resourceWithMetadata.bitField0_ = i;
                return resourceWithMetadata;
            }

            public Builder clear() {
                super.clear();
                this.timeStamp_ = 0;
                this.bitField0_ &= -2;
                this.resource_ = com.google.analytics.containertag.proto.Serving.Resource.getDefaultInstance();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearResource() {
                this.resource_ = com.google.analytics.containertag.proto.Serving.Resource.getDefaultInstance();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearTimeStamp() {
                this.bitField0_ &= -2;
                this.timeStamp_ = 0;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public ResourceWithMetadata getDefaultInstanceForType() {
                return ResourceWithMetadata.getDefaultInstance();
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
                return hasTimeStamp() && hasResource() && getResource().isInitialized();
            }

            public Builder mergeFrom(ResourceWithMetadata resourceWithMetadata) {
                if (resourceWithMetadata != ResourceWithMetadata.getDefaultInstance()) {
                    if (resourceWithMetadata.hasTimeStamp()) {
                        setTimeStamp(resourceWithMetadata.getTimeStamp());
                    }
                    if (resourceWithMetadata.hasResource()) {
                        mergeResource(resourceWithMetadata.getResource());
                    }
                    setUnknownFields(getUnknownFields().concat(resourceWithMetadata.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                ResourceWithMetadata resourceWithMetadata;
                ResourceWithMetadata resourceWithMetadata2;
                try {
                    resourceWithMetadata2 = (ResourceWithMetadata) ResourceWithMetadata.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (resourceWithMetadata2 != null) {
                        mergeFrom(resourceWithMetadata2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    resourceWithMetadata2 = (ResourceWithMetadata) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    resourceWithMetadata = resourceWithMetadata2;
                    th = th3;
                }
                if (resourceWithMetadata != null) {
                    mergeFrom(resourceWithMetadata);
                }
                throw th;
            }

            public Builder mergeResource(com.google.analytics.containertag.proto.Serving.Resource resource) {
                if ((this.bitField0_ & 2) != 2 || this.resource_ == com.google.analytics.containertag.proto.Serving.Resource.getDefaultInstance()) {
                    this.resource_ = resource;
                } else {
                    this.resource_ = com.google.analytics.containertag.proto.Serving.Resource.newBuilder(this.resource_).mergeFrom(resource).buildPartial();
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setResource(com.google.analytics.containertag.proto.Serving.Resource.Builder builder) {
                this.resource_ = builder.build();
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setResource(com.google.analytics.containertag.proto.Serving.Resource resource) {
                if (resource == null) {
                    throw new NullPointerException();
                }
                this.resource_ = resource;
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setTimeStamp(long j) {
                this.bitField0_ |= 1;
                this.timeStamp_ = j;
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

        private ResourceWithMetadata(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            OutputStream newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
            Object obj = null;
            while (obj == null) {
                try {
                    Object obj2;
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            readTag = 1;
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.timeStamp_ = codedInputStream.readInt64();
                            obj2 = obj;
                            break;
                        case 18:
                            com.google.analytics.containertag.proto.Serving.Resource.Builder toBuilder = (this.bitField0_ & 2) == 2 ? this.resource_.toBuilder() : null;
                            this.resource_ = (com.google.analytics.containertag.proto.Serving.Resource) codedInputStream.readMessage(com.google.analytics.containertag.proto.Serving.Resource.PARSER, extensionRegistryLite);
                            if (toBuilder != null) {
                                toBuilder.mergeFrom(this.resource_);
                                this.resource_ = toBuilder.buildPartial();
                            }
                            this.bitField0_ |= 2;
                            obj2 = obj;
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                obj2 = 1;
                                break;
                            } else {
                                obj2 = obj;
                                break;
                            }
                    }
                    obj = obj2;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    try {
                        newInstance.flush();
                    } catch (IOException e3) {
                        makeExtensionsImmutable();
                    } finally {
                        this.unknownFields = newOutput.toByteString();
                    }
                    makeExtensionsImmutable();
                }
            }
            try {
                newInstance.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = newOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        private ResourceWithMetadata(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ResourceWithMetadata(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static ResourceWithMetadata getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.timeStamp_ = 0;
            this.resource_ = com.google.analytics.containertag.proto.Serving.Resource.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(ResourceWithMetadata resourceWithMetadata) {
            return newBuilder().mergeFrom(resourceWithMetadata);
        }

        public static ResourceWithMetadata parseDelimitedFrom(InputStream inputStream) {
            return (ResourceWithMetadata) PARSER.parseDelimitedFrom(inputStream);
        }

        public static ResourceWithMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ResourceWithMetadata) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static ResourceWithMetadata parseFrom(ByteString byteString) {
            return (ResourceWithMetadata) PARSER.parseFrom(byteString);
        }

        public static ResourceWithMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ResourceWithMetadata) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ResourceWithMetadata parseFrom(CodedInputStream codedInputStream) {
            return (ResourceWithMetadata) PARSER.parseFrom(codedInputStream);
        }

        public static ResourceWithMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ResourceWithMetadata) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static ResourceWithMetadata parseFrom(InputStream inputStream) {
            return (ResourceWithMetadata) PARSER.parseFrom(inputStream);
        }

        public static ResourceWithMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ResourceWithMetadata) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static ResourceWithMetadata parseFrom(byte[] bArr) {
            return (ResourceWithMetadata) PARSER.parseFrom(bArr);
        }

        public static ResourceWithMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ResourceWithMetadata) PARSER.parseFrom(bArr, extensionRegistryLite);
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

        public ResourceWithMetadata getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public com.google.analytics.containertag.proto.Serving.Resource getResource() {
            return this.resource_;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = 0 + CodedOutputStream.computeInt64Size(1, this.timeStamp_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.computeMessageSize(2, this.resource_);
            }
            i += this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
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
            }
            int hashCode = ResourceWithMetadata.class.hashCode() + 779;
            if (hasTimeStamp()) {
                hashCode = (((hashCode * 37) + 1) * 53) + Internal.hashLong(getTimeStamp());
            }
            if (hasResource()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getResource().hashCode();
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.tagmanager.proto.MutableResource$ResourceWithMetadata");
            }
            return mutableDefault;
        }

        public final boolean isInitialized() {
            boolean z = true;
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                if (b != (byte) 1) {
                    z = false;
                }
                return z;
            } else if (!hasTimeStamp()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!hasResource()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (getResource().isInitialized()) {
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

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt64(1, this.timeStamp_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.resource_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    private Resource() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
