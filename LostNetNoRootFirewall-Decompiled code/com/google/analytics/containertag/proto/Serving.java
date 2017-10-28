package com.google.analytics.containertag.proto;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.ValueOrBuilder;
import com.google.android.vending.licensing.APKExpansionPolicy;
import com.google.android.vending.licensing.Policy;
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
import com.google.tagmanager.protobuf.WireFormat.FieldType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Serving {

    public interface CacheOptionOrBuilder extends MessageLiteOrBuilder {
        int getExpirationSeconds();

        int getGcacheExpirationSeconds();

        CacheLevel getLevel();

        boolean hasExpirationSeconds();

        boolean hasGcacheExpirationSeconds();

        boolean hasLevel();
    }

    public final class CacheOption extends GeneratedMessageLite implements CacheOptionOrBuilder {
        public static final int EXPIRATION_SECONDS_FIELD_NUMBER = 2;
        public static final int GCACHE_EXPIRATION_SECONDS_FIELD_NUMBER = 3;
        public static final int LEVEL_FIELD_NUMBER = 1;
        public static Parser PARSER = new C0165p();
        private static final CacheOption defaultInstance = new CacheOption(true);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int expirationSeconds_;
        private int gcacheExpirationSeconds_;
        private CacheLevel level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements CacheOptionOrBuilder {
            private int bitField0_;
            private int expirationSeconds_;
            private int gcacheExpirationSeconds_;
            private CacheLevel level_ = CacheLevel.NO_CACHE;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public CacheOption build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public CacheOption buildPartial() {
                int i = 1;
                CacheOption cacheOption = new CacheOption((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0_;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                cacheOption.level_ = this.level_;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                cacheOption.expirationSeconds_ = this.expirationSeconds_;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                cacheOption.gcacheExpirationSeconds_ = this.gcacheExpirationSeconds_;
                cacheOption.bitField0_ = i;
                return cacheOption;
            }

            public Builder clear() {
                super.clear();
                this.level_ = CacheLevel.NO_CACHE;
                this.bitField0_ &= -2;
                this.expirationSeconds_ = 0;
                this.bitField0_ &= -3;
                this.gcacheExpirationSeconds_ = 0;
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clearExpirationSeconds() {
                this.bitField0_ &= -3;
                this.expirationSeconds_ = 0;
                return this;
            }

            public Builder clearGcacheExpirationSeconds() {
                this.bitField0_ &= -5;
                this.gcacheExpirationSeconds_ = 0;
                return this;
            }

            public Builder clearLevel() {
                this.bitField0_ &= -2;
                this.level_ = CacheLevel.NO_CACHE;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public CacheOption getDefaultInstanceForType() {
                return CacheOption.getDefaultInstance();
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

            public Builder mergeFrom(CacheOption cacheOption) {
                if (cacheOption != CacheOption.getDefaultInstance()) {
                    if (cacheOption.hasLevel()) {
                        setLevel(cacheOption.getLevel());
                    }
                    if (cacheOption.hasExpirationSeconds()) {
                        setExpirationSeconds(cacheOption.getExpirationSeconds());
                    }
                    if (cacheOption.hasGcacheExpirationSeconds()) {
                        setGcacheExpirationSeconds(cacheOption.getGcacheExpirationSeconds());
                    }
                    setUnknownFields(getUnknownFields().concat(cacheOption.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                CacheOption cacheOption;
                CacheOption cacheOption2;
                try {
                    cacheOption2 = (CacheOption) CacheOption.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (cacheOption2 != null) {
                        mergeFrom(cacheOption2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    cacheOption2 = (CacheOption) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    cacheOption = cacheOption2;
                    th = th3;
                }
                if (cacheOption != null) {
                    mergeFrom(cacheOption);
                }
                throw th;
            }

            public Builder setExpirationSeconds(int i) {
                this.bitField0_ |= 2;
                this.expirationSeconds_ = i;
                return this;
            }

            public Builder setGcacheExpirationSeconds(int i) {
                this.bitField0_ |= 4;
                this.gcacheExpirationSeconds_ = i;
                return this;
            }

            public Builder setLevel(CacheLevel cacheLevel) {
                if (cacheLevel == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.level_ = cacheLevel;
                return this;
            }
        }

        public enum CacheLevel implements EnumLite {
            NO_CACHE(0, 1),
            PRIVATE(1, 2),
            PUBLIC(2, 3);
            
            public static final int NO_CACHE_VALUE = 1;
            public static final int PRIVATE_VALUE = 2;
            public static final int PUBLIC_VALUE = 3;
            private static EnumLiteMap internalValueMap;
            private final int value;

            static {
                internalValueMap = new C0166q();
            }

            private CacheLevel(int i, int i2) {
                this.value = i2;
            }

            public static EnumLiteMap internalGetValueMap() {
                return internalValueMap;
            }

            public static CacheLevel valueOf(int i) {
                switch (i) {
                    case 1:
                        return NO_CACHE;
                    case 2:
                        return PRIVATE;
                    case 3:
                        return PUBLIC;
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
        }

        private CacheOption(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            OutputStream newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
            Object obj = null;
            while (obj == null) {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            obj = 1;
                            break;
                        case 8:
                            int readEnum = codedInputStream.readEnum();
                            CacheLevel valueOf = CacheLevel.valueOf(readEnum);
                            if (valueOf != null) {
                                this.bitField0_ |= 1;
                                this.level_ = valueOf;
                                break;
                            }
                            newInstance.writeRawVarint32(readTag);
                            newInstance.writeRawVarint32(readEnum);
                            break;
                        case 16:
                            this.bitField0_ |= 2;
                            this.expirationSeconds_ = codedInputStream.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 4;
                            this.gcacheExpirationSeconds_ = codedInputStream.readInt32();
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
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

        private CacheOption(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CacheOption(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static CacheOption getDefaultInstance() {
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

        public static Builder newBuilder(CacheOption cacheOption) {
            return newBuilder().mergeFrom(cacheOption);
        }

        public static CacheOption parseDelimitedFrom(InputStream inputStream) {
            return (CacheOption) PARSER.parseDelimitedFrom(inputStream);
        }

        public static CacheOption parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CacheOption) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CacheOption parseFrom(ByteString byteString) {
            return (CacheOption) PARSER.parseFrom(byteString);
        }

        public static CacheOption parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (CacheOption) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CacheOption parseFrom(CodedInputStream codedInputStream) {
            return (CacheOption) PARSER.parseFrom(codedInputStream);
        }

        public static CacheOption parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CacheOption) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static CacheOption parseFrom(InputStream inputStream) {
            return (CacheOption) PARSER.parseFrom(inputStream);
        }

        public static CacheOption parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CacheOption) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CacheOption parseFrom(byte[] bArr) {
            return (CacheOption) PARSER.parseFrom(bArr);
        }

        public static CacheOption parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (CacheOption) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CacheOption)) {
                return super.equals(obj);
            }
            CacheOption cacheOption = (CacheOption) obj;
            boolean z = hasLevel() == cacheOption.hasLevel();
            if (hasLevel()) {
                z = z && getLevel() == cacheOption.getLevel();
            }
            z = z && hasExpirationSeconds() == cacheOption.hasExpirationSeconds();
            if (hasExpirationSeconds()) {
                z = z && getExpirationSeconds() == cacheOption.getExpirationSeconds();
            }
            z = z && hasGcacheExpirationSeconds() == cacheOption.hasGcacheExpirationSeconds();
            return hasGcacheExpirationSeconds() ? z && getGcacheExpirationSeconds() == cacheOption.getGcacheExpirationSeconds() : z;
        }

        public CacheOption getDefaultInstanceForType() {
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

        public Parser getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = 0 + CodedOutputStream.computeEnumSize(1, this.level_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.computeInt32Size(2, this.expirationSeconds_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.computeInt32Size(3, this.gcacheExpirationSeconds_);
            }
            i += this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
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
            }
            int hashCode = CacheOption.class.hashCode() + 779;
            if (hasLevel()) {
                hashCode = (((hashCode * 37) + 1) * 53) + Internal.hashEnum(getLevel());
            }
            if (hasExpirationSeconds()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getExpirationSeconds();
            }
            if (hasGcacheExpirationSeconds()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getGcacheExpirationSeconds();
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$CacheOption");
            }
            return mutableDefault;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                return b == (byte) 1;
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

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeEnum(1, this.level_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.expirationSeconds_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.gcacheExpirationSeconds_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    public interface ContainerOrBuilder extends MessageLiteOrBuilder {
        String getContainerId();

        ByteString getContainerIdBytes();

        Resource getJsResource();

        ResourceState getState();

        String getVersion();

        ByteString getVersionBytes();

        boolean hasContainerId();

        boolean hasJsResource();

        boolean hasState();

        boolean hasVersion();
    }

    public final class Container extends GeneratedMessageLite implements ContainerOrBuilder {
        public static final int CONTAINER_ID_FIELD_NUMBER = 3;
        public static final int JS_RESOURCE_FIELD_NUMBER = 1;
        public static Parser PARSER = new C0167r();
        public static final int STATE_FIELD_NUMBER = 4;
        public static final int VERSION_FIELD_NUMBER = 5;
        private static final Container defaultInstance = new Container(true);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object containerId_;
        private Resource jsResource_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private ResourceState state_;
        private final ByteString unknownFields;
        private Object version_;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements ContainerOrBuilder {
            private int bitField0_;
            private Object containerId_ = "";
            private Resource jsResource_ = Resource.getDefaultInstance();
            private ResourceState state_ = ResourceState.PREVIEW;
            private Object version_ = "";

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Container build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public Container buildPartial() {
                int i = 1;
                Container container = new Container((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0_;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                container.jsResource_ = this.jsResource_;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                container.containerId_ = this.containerId_;
                if ((i2 & 4) == 4) {
                    i |= 4;
                }
                container.state_ = this.state_;
                if ((i2 & 8) == 8) {
                    i |= 8;
                }
                container.version_ = this.version_;
                container.bitField0_ = i;
                return container;
            }

            public Builder clear() {
                super.clear();
                this.jsResource_ = Resource.getDefaultInstance();
                this.bitField0_ &= -2;
                this.containerId_ = "";
                this.bitField0_ &= -3;
                this.state_ = ResourceState.PREVIEW;
                this.bitField0_ &= -5;
                this.version_ = "";
                this.bitField0_ &= -9;
                return this;
            }

            public Builder clearContainerId() {
                this.bitField0_ &= -3;
                this.containerId_ = Container.getDefaultInstance().getContainerId();
                return this;
            }

            public Builder clearJsResource() {
                this.jsResource_ = Resource.getDefaultInstance();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clearState() {
                this.bitField0_ &= -5;
                this.state_ = ResourceState.PREVIEW;
                return this;
            }

            public Builder clearVersion() {
                this.bitField0_ &= -9;
                this.version_ = Container.getDefaultInstance().getVersion();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public String getContainerId() {
                Object obj = this.containerId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String toStringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.containerId_ = toStringUtf8;
                }
                return toStringUtf8;
            }

            public ByteString getContainerIdBytes() {
                Object obj = this.containerId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.containerId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Container getDefaultInstanceForType() {
                return Container.getDefaultInstance();
            }

            public Resource getJsResource() {
                return this.jsResource_;
            }

            public ResourceState getState() {
                return this.state_;
            }

            public String getVersion() {
                Object obj = this.version_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String toStringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.version_ = toStringUtf8;
                }
                return toStringUtf8;
            }

            public ByteString getVersionBytes() {
                Object obj = this.version_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.version_ = copyFromUtf8;
                return copyFromUtf8;
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
                return hasJsResource() && hasContainerId() && hasState() && getJsResource().isInitialized();
            }

            public Builder mergeFrom(Container container) {
                if (container != Container.getDefaultInstance()) {
                    if (container.hasJsResource()) {
                        mergeJsResource(container.getJsResource());
                    }
                    if (container.hasContainerId()) {
                        this.bitField0_ |= 2;
                        this.containerId_ = container.containerId_;
                    }
                    if (container.hasState()) {
                        setState(container.getState());
                    }
                    if (container.hasVersion()) {
                        this.bitField0_ |= 8;
                        this.version_ = container.version_;
                    }
                    setUnknownFields(getUnknownFields().concat(container.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                Container container;
                Container container2;
                try {
                    container2 = (Container) Container.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (container2 != null) {
                        mergeFrom(container2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    container2 = (Container) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    container = container2;
                    th = th3;
                }
                if (container != null) {
                    mergeFrom(container);
                }
                throw th;
            }

            public Builder mergeJsResource(Resource resource) {
                if ((this.bitField0_ & 1) != 1 || this.jsResource_ == Resource.getDefaultInstance()) {
                    this.jsResource_ = resource;
                } else {
                    this.jsResource_ = Resource.newBuilder(this.jsResource_).mergeFrom(resource).buildPartial();
                }
                this.bitField0_ |= 1;
                return this;
            }

            public Builder setContainerId(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.containerId_ = str;
                return this;
            }

            public Builder setContainerIdBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.containerId_ = byteString;
                return this;
            }

            public Builder setJsResource(Builder builder) {
                this.jsResource_ = builder.build();
                this.bitField0_ |= 1;
                return this;
            }

            public Builder setJsResource(Resource resource) {
                if (resource == null) {
                    throw new NullPointerException();
                }
                this.jsResource_ = resource;
                this.bitField0_ |= 1;
                return this;
            }

            public Builder setState(ResourceState resourceState) {
                if (resourceState == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.state_ = resourceState;
                return this;
            }

            public Builder setVersion(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.version_ = str;
                return this;
            }

            public Builder setVersionBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.version_ = byteString;
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

        private Container(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                    ByteString readBytes;
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            readTag = 1;
                            break;
                        case 10:
                            Builder toBuilder = (this.bitField0_ & 1) == 1 ? this.jsResource_.toBuilder() : null;
                            this.jsResource_ = (Resource) codedInputStream.readMessage(Resource.PARSER, extensionRegistryLite);
                            if (toBuilder != null) {
                                toBuilder.mergeFrom(this.jsResource_);
                                this.jsResource_ = toBuilder.buildPartial();
                            }
                            this.bitField0_ |= 1;
                            obj2 = obj;
                            break;
                        case 26:
                            readBytes = codedInputStream.readBytes();
                            this.bitField0_ |= 2;
                            this.containerId_ = readBytes;
                            obj2 = obj;
                            break;
                        case 32:
                            int readEnum = codedInputStream.readEnum();
                            ResourceState valueOf = ResourceState.valueOf(readEnum);
                            if (valueOf != null) {
                                this.bitField0_ |= 4;
                                this.state_ = valueOf;
                                obj2 = obj;
                                break;
                            }
                            newInstance.writeRawVarint32(readTag);
                            newInstance.writeRawVarint32(readEnum);
                            obj2 = obj;
                            break;
                        case 42:
                            readBytes = codedInputStream.readBytes();
                            this.bitField0_ |= 8;
                            this.version_ = readBytes;
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

        private Container(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Container(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Container getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.jsResource_ = Resource.getDefaultInstance();
            this.containerId_ = "";
            this.state_ = ResourceState.PREVIEW;
            this.version_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(Container container) {
            return newBuilder().mergeFrom(container);
        }

        public static Container parseDelimitedFrom(InputStream inputStream) {
            return (Container) PARSER.parseDelimitedFrom(inputStream);
        }

        public static Container parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Container) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Container parseFrom(ByteString byteString) {
            return (Container) PARSER.parseFrom(byteString);
        }

        public static Container parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Container) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Container parseFrom(CodedInputStream codedInputStream) {
            return (Container) PARSER.parseFrom(codedInputStream);
        }

        public static Container parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Container) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Container parseFrom(InputStream inputStream) {
            return (Container) PARSER.parseFrom(inputStream);
        }

        public static Container parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Container) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Container parseFrom(byte[] bArr) {
            return (Container) PARSER.parseFrom(bArr);
        }

        public static Container parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Container) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Container)) {
                return super.equals(obj);
            }
            Container container = (Container) obj;
            boolean z = hasJsResource() == container.hasJsResource();
            if (hasJsResource()) {
                z = z && getJsResource().equals(container.getJsResource());
            }
            z = z && hasContainerId() == container.hasContainerId();
            if (hasContainerId()) {
                z = z && getContainerId().equals(container.getContainerId());
            }
            z = z && hasState() == container.hasState();
            if (hasState()) {
                z = z && getState() == container.getState();
            }
            z = z && hasVersion() == container.hasVersion();
            return hasVersion() ? z && getVersion().equals(container.getVersion()) : z;
        }

        public String getContainerId() {
            Object obj = this.containerId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String toStringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.containerId_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public ByteString getContainerIdBytes() {
            Object obj = this.containerId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.containerId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Container getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Resource getJsResource() {
            return this.jsResource_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = 0 + CodedOutputStream.computeMessageSize(1, this.jsResource_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.computeBytesSize(3, getContainerIdBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.computeEnumSize(4, this.state_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.computeBytesSize(5, getVersionBytes());
            }
            i += this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
        }

        public ResourceState getState() {
            return this.state_;
        }

        public String getVersion() {
            Object obj = this.version_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String toStringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.version_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public ByteString getVersionBytes() {
            Object obj = this.version_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.version_ = copyFromUtf8;
            return copyFromUtf8;
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
            }
            int hashCode = Container.class.hashCode() + 779;
            if (hasJsResource()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getJsResource().hashCode();
            }
            if (hasContainerId()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getContainerId().hashCode();
            }
            if (hasState()) {
                hashCode = (((hashCode * 37) + 4) * 53) + Internal.hashEnum(getState());
            }
            if (hasVersion()) {
                hashCode = (((hashCode * 37) + 5) * 53) + getVersion().hashCode();
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$Container");
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
            } else if (!hasJsResource()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!hasContainerId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!hasState()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (getJsResource().isInitialized()) {
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
                codedOutputStream.writeMessage(1, this.jsResource_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(3, getContainerIdBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(4, this.state_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(5, getVersionBytes());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    public interface FunctionCallOrBuilder extends MessageLiteOrBuilder {
        int getFunction();

        boolean getLiveOnly();

        int getName();

        int getProperty(int i);

        int getPropertyCount();

        List getPropertyList();

        boolean getServerSide();

        boolean hasFunction();

        boolean hasLiveOnly();

        boolean hasName();

        boolean hasServerSide();
    }

    public final class FunctionCall extends GeneratedMessageLite implements FunctionCallOrBuilder {
        public static final int FUNCTION_FIELD_NUMBER = 2;
        public static final int LIVE_ONLY_FIELD_NUMBER = 6;
        public static final int NAME_FIELD_NUMBER = 4;
        public static Parser PARSER = new C0168s();
        public static final int PROPERTY_FIELD_NUMBER = 3;
        public static final int SERVER_SIDE_FIELD_NUMBER = 1;
        private static final FunctionCall defaultInstance = new FunctionCall(true);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int function_;
        private boolean liveOnly_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private List property_;
        private boolean serverSide_;
        private final ByteString unknownFields;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements FunctionCallOrBuilder {
            private int bitField0_;
            private int function_;
            private boolean liveOnly_;
            private int name_;
            private List property_ = Collections.emptyList();
            private boolean serverSide_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.property_ = new ArrayList(this.property_);
                    this.bitField0_ |= 1;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder addAllProperty(Iterable iterable) {
                ensurePropertyIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.property_);
                return this;
            }

            public Builder addProperty(int i) {
                ensurePropertyIsMutable();
                this.property_.add(Integer.valueOf(i));
                return this;
            }

            public FunctionCall build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public FunctionCall buildPartial() {
                int i = 1;
                FunctionCall functionCall = new FunctionCall((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                    this.bitField0_ &= -2;
                }
                functionCall.property_ = this.property_;
                if ((i2 & 2) != 2) {
                    i = 0;
                }
                functionCall.function_ = this.function_;
                if ((i2 & 4) == 4) {
                    i |= 2;
                }
                functionCall.name_ = this.name_;
                if ((i2 & 8) == 8) {
                    i |= 4;
                }
                functionCall.liveOnly_ = this.liveOnly_;
                if ((i2 & 16) == 16) {
                    i |= 8;
                }
                functionCall.serverSide_ = this.serverSide_;
                functionCall.bitField0_ = i;
                return functionCall;
            }

            public Builder clear() {
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

            public Builder clearFunction() {
                this.bitField0_ &= -3;
                this.function_ = 0;
                return this;
            }

            public Builder clearLiveOnly() {
                this.bitField0_ &= -9;
                this.liveOnly_ = false;
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -5;
                this.name_ = 0;
                return this;
            }

            public Builder clearProperty() {
                this.property_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clearServerSide() {
                this.bitField0_ &= -17;
                this.serverSide_ = false;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public FunctionCall getDefaultInstanceForType() {
                return FunctionCall.getDefaultInstance();
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

            public int getProperty(int i) {
                return ((Integer) this.property_.get(i)).intValue();
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public List getPropertyList() {
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

            public Builder mergeFrom(FunctionCall functionCall) {
                if (functionCall != FunctionCall.getDefaultInstance()) {
                    if (!functionCall.property_.isEmpty()) {
                        if (this.property_.isEmpty()) {
                            this.property_ = functionCall.property_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePropertyIsMutable();
                            this.property_.addAll(functionCall.property_);
                        }
                    }
                    if (functionCall.hasFunction()) {
                        setFunction(functionCall.getFunction());
                    }
                    if (functionCall.hasName()) {
                        setName(functionCall.getName());
                    }
                    if (functionCall.hasLiveOnly()) {
                        setLiveOnly(functionCall.getLiveOnly());
                    }
                    if (functionCall.hasServerSide()) {
                        setServerSide(functionCall.getServerSide());
                    }
                    setUnknownFields(getUnknownFields().concat(functionCall.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                FunctionCall functionCall;
                Throwable th;
                FunctionCall functionCall2;
                try {
                    functionCall = (FunctionCall) FunctionCall.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (functionCall != null) {
                        mergeFrom(functionCall);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    functionCall = (FunctionCall) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    functionCall2 = functionCall;
                    th = th3;
                }
                if (functionCall2 != null) {
                    mergeFrom(functionCall2);
                }
                throw th;
            }

            public Builder setFunction(int i) {
                this.bitField0_ |= 2;
                this.function_ = i;
                return this;
            }

            public Builder setLiveOnly(boolean z) {
                this.bitField0_ |= 8;
                this.liveOnly_ = z;
                return this;
            }

            public Builder setName(int i) {
                this.bitField0_ |= 4;
                this.name_ = i;
                return this;
            }

            public Builder setProperty(int i, int i2) {
                ensurePropertyIsMutable();
                this.property_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder setServerSide(boolean z) {
                this.bitField0_ |= 16;
                this.serverSide_ = z;
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

        private FunctionCall(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            Object obj = null;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            OutputStream newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
            int i = 0;
            while (obj == null) {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            obj = 1;
                            break;
                        case 8:
                            this.bitField0_ |= 8;
                            this.serverSide_ = codedInputStream.readBool();
                            break;
                        case 16:
                            this.bitField0_ |= 1;
                            this.function_ = codedInputStream.readInt32();
                            break;
                        case 24:
                            if ((i & 1) != 1) {
                                this.property_ = new ArrayList();
                                i |= 1;
                            }
                            this.property_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 26:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 1) != 1 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.property_ = new ArrayList();
                                i |= 1;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.property_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 32:
                            this.bitField0_ |= 2;
                            this.name_ = codedInputStream.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 4;
                            this.liveOnly_ = codedInputStream.readBool();
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if ((i & 1) == 1) {
                        this.property_ = Collections.unmodifiableList(this.property_);
                    }
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
            if ((i & 1) == 1) {
                this.property_ = Collections.unmodifiableList(this.property_);
            }
            try {
                newInstance.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = newOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        private FunctionCall(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private FunctionCall(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static FunctionCall getDefaultInstance() {
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

        public static Builder newBuilder(FunctionCall functionCall) {
            return newBuilder().mergeFrom(functionCall);
        }

        public static FunctionCall parseDelimitedFrom(InputStream inputStream) {
            return (FunctionCall) PARSER.parseDelimitedFrom(inputStream);
        }

        public static FunctionCall parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FunctionCall) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static FunctionCall parseFrom(ByteString byteString) {
            return (FunctionCall) PARSER.parseFrom(byteString);
        }

        public static FunctionCall parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (FunctionCall) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static FunctionCall parseFrom(CodedInputStream codedInputStream) {
            return (FunctionCall) PARSER.parseFrom(codedInputStream);
        }

        public static FunctionCall parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FunctionCall) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static FunctionCall parseFrom(InputStream inputStream) {
            return (FunctionCall) PARSER.parseFrom(inputStream);
        }

        public static FunctionCall parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (FunctionCall) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static FunctionCall parseFrom(byte[] bArr) {
            return (FunctionCall) PARSER.parseFrom(bArr);
        }

        public static FunctionCall parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (FunctionCall) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FunctionCall)) {
                return super.equals(obj);
            }
            FunctionCall functionCall = (FunctionCall) obj;
            boolean z = (getPropertyList().equals(functionCall.getPropertyList())) && hasFunction() == functionCall.hasFunction();
            if (hasFunction()) {
                z = z && getFunction() == functionCall.getFunction();
            }
            z = z && hasName() == functionCall.hasName();
            if (hasName()) {
                z = z && getName() == functionCall.getName();
            }
            z = z && hasLiveOnly() == functionCall.hasLiveOnly();
            if (hasLiveOnly()) {
                z = z && getLiveOnly() == functionCall.getLiveOnly();
            }
            z = z && hasServerSide() == functionCall.hasServerSide();
            return hasServerSide() ? z && getServerSide() == functionCall.getServerSide() : z;
        }

        public FunctionCall getDefaultInstanceForType() {
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

        public Parser getParserForType() {
            return PARSER;
        }

        public int getProperty(int i) {
            return ((Integer) this.property_.get(i)).intValue();
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List getPropertyList() {
            return this.property_;
        }

        public int getSerializedSize() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            i2 = (this.bitField0_ & 8) == 8 ? CodedOutputStream.computeBoolSize(1, this.serverSide_) + 0 : 0;
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? i2 + CodedOutputStream.computeInt32Size(2, this.function_) : i2;
            int i3 = 0;
            while (i < this.property_.size()) {
                i++;
                i3 = CodedOutputStream.computeInt32SizeNoTag(((Integer) this.property_.get(i)).intValue()) + i3;
            }
            i2 = (computeInt32Size + i3) + (getPropertyList().size() * 1);
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(4, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeBoolSize(6, this.liveOnly_);
            }
            i2 += this.unknownFields.size();
            this.memoizedSerializedSize = i2;
            return i2;
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
            }
            int hashCode = FunctionCall.class.hashCode() + 779;
            if (getPropertyCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getPropertyList().hashCode();
            }
            if (hasFunction()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getFunction();
            }
            if (hasName()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getName();
            }
            if (hasLiveOnly()) {
                hashCode = (((hashCode * 37) + 6) * 53) + Internal.hashBoolean(getLiveOnly());
            }
            if (hasServerSide()) {
                hashCode = (((hashCode * 37) + 1) * 53) + Internal.hashBoolean(getServerSide());
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$FunctionCall");
            }
            return mutableDefault;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                return b == (byte) 1;
            } else {
                if (hasFunction()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
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
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBool(1, this.serverSide_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(2, this.function_);
            }
            for (int i = 0; i < this.property_.size(); i++) {
                codedOutputStream.writeInt32(3, ((Integer) this.property_.get(i)).intValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(4, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBool(6, this.liveOnly_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    public interface OptionalResourceOrBuilder extends MessageLiteOrBuilder {
        Resource getResource();

        boolean hasResource();
    }

    public final class OptionalResource extends GeneratedMessageLite implements OptionalResourceOrBuilder {
        public static Parser PARSER = new C0169t();
        public static final int RESOURCE_FIELD_NUMBER = 2;
        private static final OptionalResource defaultInstance = new OptionalResource(true);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Resource resource_;
        private final ByteString unknownFields;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements OptionalResourceOrBuilder {
            private int bitField0_;
            private Resource resource_ = Resource.getDefaultInstance();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public OptionalResource build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public OptionalResource buildPartial() {
                int i = 1;
                OptionalResource optionalResource = new OptionalResource((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                if ((this.bitField0_ & 1) != 1) {
                    i = 0;
                }
                optionalResource.resource_ = this.resource_;
                optionalResource.bitField0_ = i;
                return optionalResource;
            }

            public Builder clear() {
                super.clear();
                this.resource_ = Resource.getDefaultInstance();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clearResource() {
                this.resource_ = Resource.getDefaultInstance();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public OptionalResource getDefaultInstanceForType() {
                return OptionalResource.getDefaultInstance();
            }

            public Resource getResource() {
                return this.resource_;
            }

            public boolean hasResource() {
                return (this.bitField0_ & 1) == 1;
            }

            public final boolean isInitialized() {
                return !hasResource() || getResource().isInitialized();
            }

            public Builder mergeFrom(OptionalResource optionalResource) {
                if (optionalResource != OptionalResource.getDefaultInstance()) {
                    if (optionalResource.hasResource()) {
                        mergeResource(optionalResource.getResource());
                    }
                    setUnknownFields(getUnknownFields().concat(optionalResource.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                OptionalResource optionalResource;
                Throwable th;
                OptionalResource optionalResource2;
                try {
                    optionalResource = (OptionalResource) OptionalResource.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (optionalResource != null) {
                        mergeFrom(optionalResource);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    optionalResource = (OptionalResource) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    optionalResource2 = optionalResource;
                    th = th3;
                }
                if (optionalResource2 != null) {
                    mergeFrom(optionalResource2);
                }
                throw th;
            }

            public Builder mergeResource(Resource resource) {
                if ((this.bitField0_ & 1) != 1 || this.resource_ == Resource.getDefaultInstance()) {
                    this.resource_ = resource;
                } else {
                    this.resource_ = Resource.newBuilder(this.resource_).mergeFrom(resource).buildPartial();
                }
                this.bitField0_ |= 1;
                return this;
            }

            public Builder setResource(Builder builder) {
                this.resource_ = builder.build();
                this.bitField0_ |= 1;
                return this;
            }

            public Builder setResource(Resource resource) {
                if (resource == null) {
                    throw new NullPointerException();
                }
                this.resource_ = resource;
                this.bitField0_ |= 1;
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

        private OptionalResource(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                        case 18:
                            Builder toBuilder = (this.bitField0_ & 1) == 1 ? this.resource_.toBuilder() : null;
                            this.resource_ = (Resource) codedInputStream.readMessage(Resource.PARSER, extensionRegistryLite);
                            if (toBuilder != null) {
                                toBuilder.mergeFrom(this.resource_);
                                this.resource_ = toBuilder.buildPartial();
                            }
                            this.bitField0_ |= 1;
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

        private OptionalResource(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private OptionalResource(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static OptionalResource getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.resource_ = Resource.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(OptionalResource optionalResource) {
            return newBuilder().mergeFrom(optionalResource);
        }

        public static OptionalResource parseDelimitedFrom(InputStream inputStream) {
            return (OptionalResource) PARSER.parseDelimitedFrom(inputStream);
        }

        public static OptionalResource parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (OptionalResource) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static OptionalResource parseFrom(ByteString byteString) {
            return (OptionalResource) PARSER.parseFrom(byteString);
        }

        public static OptionalResource parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (OptionalResource) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static OptionalResource parseFrom(CodedInputStream codedInputStream) {
            return (OptionalResource) PARSER.parseFrom(codedInputStream);
        }

        public static OptionalResource parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (OptionalResource) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static OptionalResource parseFrom(InputStream inputStream) {
            return (OptionalResource) PARSER.parseFrom(inputStream);
        }

        public static OptionalResource parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (OptionalResource) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static OptionalResource parseFrom(byte[] bArr) {
            return (OptionalResource) PARSER.parseFrom(bArr);
        }

        public static OptionalResource parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (OptionalResource) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OptionalResource)) {
                return super.equals(obj);
            }
            OptionalResource optionalResource = (OptionalResource) obj;
            boolean z = hasResource() == optionalResource.hasResource();
            return hasResource() ? z && getResource().equals(optionalResource.getResource()) : z;
        }

        public OptionalResource getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public Resource getResource() {
            return this.resource_;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = 0 + CodedOutputStream.computeMessageSize(2, this.resource_);
            }
            i += this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
        }

        public boolean hasResource() {
            return (this.bitField0_ & 1) == 1;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = OptionalResource.class.hashCode() + 779;
            if (hasResource()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getResource().hashCode();
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$OptionalResource");
            }
            return mutableDefault;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                return b == (byte) 1;
            } else {
                if (!hasResource() || getResource().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
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
                codedOutputStream.writeMessage(2, this.resource_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    public interface PropertyOrBuilder extends MessageLiteOrBuilder {
        int getKey();

        int getValue();

        boolean hasKey();

        boolean hasValue();
    }

    public final class Property extends GeneratedMessageLite implements PropertyOrBuilder {
        public static final int KEY_FIELD_NUMBER = 1;
        public static Parser PARSER = new C0170u();
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final Property defaultInstance = new Property(true);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int key_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;
        private int value_;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements PropertyOrBuilder {
            private int bitField0_;
            private int key_;
            private int value_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Property build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public Property buildPartial() {
                int i = 1;
                Property property = new Property((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0_;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                property.key_ = this.key_;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                property.value_ = this.value_;
                property.bitField0_ = i;
                return property;
            }

            public Builder clear() {
                super.clear();
                this.key_ = 0;
                this.bitField0_ &= -2;
                this.value_ = 0;
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearKey() {
                this.bitField0_ &= -2;
                this.key_ = 0;
                return this;
            }

            public Builder clearValue() {
                this.bitField0_ &= -3;
                this.value_ = 0;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Property getDefaultInstanceForType() {
                return Property.getDefaultInstance();
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
                return hasKey() && hasValue();
            }

            public Builder mergeFrom(Property property) {
                if (property != Property.getDefaultInstance()) {
                    if (property.hasKey()) {
                        setKey(property.getKey());
                    }
                    if (property.hasValue()) {
                        setValue(property.getValue());
                    }
                    setUnknownFields(getUnknownFields().concat(property.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                Property property;
                Property property2;
                try {
                    property2 = (Property) Property.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (property2 != null) {
                        mergeFrom(property2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    property2 = (Property) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    property = property2;
                    th = th3;
                }
                if (property != null) {
                    mergeFrom(property);
                }
                throw th;
            }

            public Builder setKey(int i) {
                this.bitField0_ |= 1;
                this.key_ = i;
                return this;
            }

            public Builder setValue(int i) {
                this.bitField0_ |= 2;
                this.value_ = i;
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

        private Property(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            OutputStream newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
            Object obj = null;
            while (obj == null) {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            obj = 1;
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.key_ = codedInputStream.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 2;
                            this.value_ = codedInputStream.readInt32();
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
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

        private Property(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Property(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Property getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.key_ = 0;
            this.value_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(Property property) {
            return newBuilder().mergeFrom(property);
        }

        public static Property parseDelimitedFrom(InputStream inputStream) {
            return (Property) PARSER.parseDelimitedFrom(inputStream);
        }

        public static Property parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Property) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Property parseFrom(ByteString byteString) {
            return (Property) PARSER.parseFrom(byteString);
        }

        public static Property parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Property) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Property parseFrom(CodedInputStream codedInputStream) {
            return (Property) PARSER.parseFrom(codedInputStream);
        }

        public static Property parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Property) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Property parseFrom(InputStream inputStream) {
            return (Property) PARSER.parseFrom(inputStream);
        }

        public static Property parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Property) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Property parseFrom(byte[] bArr) {
            return (Property) PARSER.parseFrom(bArr);
        }

        public static Property parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Property) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Property)) {
                return super.equals(obj);
            }
            Property property = (Property) obj;
            boolean z = hasKey() == property.hasKey();
            if (hasKey()) {
                z = z && getKey() == property.getKey();
            }
            z = z && hasValue() == property.hasValue();
            return hasValue() ? z && getValue() == property.getValue() : z;
        }

        public Property getDefaultInstanceForType() {
            return defaultInstance;
        }

        public int getKey() {
            return this.key_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = 0 + CodedOutputStream.computeInt32Size(1, this.key_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.computeInt32Size(2, this.value_);
            }
            i += this.unknownFields.size();
            this.memoizedSerializedSize = i;
            return i;
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
            }
            int hashCode = Property.class.hashCode() + 779;
            if (hasKey()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getKey();
            }
            if (hasValue()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getValue();
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$Property");
            }
            return mutableDefault;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                return b == (byte) 1;
            } else {
                if (!hasKey()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (hasValue()) {
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

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.key_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.value_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    public interface ResourceOrBuilder extends MessageLiteOrBuilder {
        boolean getEnableAutoEventTracking();

        String getKey(int i);

        ByteString getKeyBytes(int i);

        int getKeyCount();

        List getKeyList();

        CacheOption getLiveJsCacheOption();

        FunctionCall getMacro(int i);

        int getMacroCount();

        List getMacroList();

        String getMalwareScanAuthCode();

        ByteString getMalwareScanAuthCodeBytes();

        FunctionCall getPredicate(int i);

        int getPredicateCount();

        List getPredicateList();

        String getPreviewAuthCode();

        ByteString getPreviewAuthCodeBytes();

        Property getProperty(int i);

        int getPropertyCount();

        List getPropertyList();

        float getReportingSampleRate();

        int getResourceFormatVersion();

        Rule getRule(int i);

        int getRuleCount();

        List getRuleList();

        FunctionCall getTag(int i);

        int getTagCount();

        List getTagList();

        String getTemplateVersionSet();

        ByteString getTemplateVersionSetBytes();

        String getUsageContext(int i);

        ByteString getUsageContextBytes(int i);

        int getUsageContextCount();

        List getUsageContextList();

        Value getValue(int i);

        int getValueCount();

        List getValueList();

        String getVersion();

        ByteString getVersionBytes();

        boolean hasEnableAutoEventTracking();

        boolean hasLiveJsCacheOption();

        boolean hasMalwareScanAuthCode();

        boolean hasPreviewAuthCode();

        boolean hasReportingSampleRate();

        boolean hasResourceFormatVersion();

        boolean hasTemplateVersionSet();

        boolean hasVersion();
    }

    public final class Resource extends GeneratedMessageLite implements ResourceOrBuilder {
        public static final int ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER = 18;
        public static final int KEY_FIELD_NUMBER = 1;
        public static final int LIVE_JS_CACHE_OPTION_FIELD_NUMBER = 14;
        public static final int MACRO_FIELD_NUMBER = 4;
        public static final int MALWARE_SCAN_AUTH_CODE_FIELD_NUMBER = 10;
        public static Parser PARSER = new C0171v();
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
        private static final Resource defaultInstance = new Resource(true);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean enableAutoEventTracking_;
        private LazyStringList key_;
        private CacheOption liveJsCacheOption_;
        private List macro_;
        private Object malwareScanAuthCode_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List predicate_;
        private Object previewAuthCode_;
        private List property_;
        private float reportingSampleRate_;
        private int resourceFormatVersion_;
        private List rule_;
        private List tag_;
        private Object templateVersionSet_;
        private final ByteString unknownFields;
        private LazyStringList usageContext_;
        private List value_;
        private Object version_;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements ResourceOrBuilder {
            private int bitField0_;
            private boolean enableAutoEventTracking_;
            private LazyStringList key_ = LazyStringArrayList.EMPTY;
            private CacheOption liveJsCacheOption_ = CacheOption.getDefaultInstance();
            private List macro_ = Collections.emptyList();
            private Object malwareScanAuthCode_ = "";
            private List predicate_ = Collections.emptyList();
            private Object previewAuthCode_ = "";
            private List property_ = Collections.emptyList();
            private float reportingSampleRate_;
            private int resourceFormatVersion_;
            private List rule_ = Collections.emptyList();
            private List tag_ = Collections.emptyList();
            private Object templateVersionSet_ = "0";
            private LazyStringList usageContext_ = LazyStringArrayList.EMPTY;
            private List value_ = Collections.emptyList();
            private Object version_ = "";

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
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

            public Builder addAllKey(Iterable iterable) {
                ensureKeyIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.key_);
                return this;
            }

            public Builder addAllMacro(Iterable iterable) {
                ensureMacroIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.macro_);
                return this;
            }

            public Builder addAllPredicate(Iterable iterable) {
                ensurePredicateIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.predicate_);
                return this;
            }

            public Builder addAllProperty(Iterable iterable) {
                ensurePropertyIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.property_);
                return this;
            }

            public Builder addAllRule(Iterable iterable) {
                ensureRuleIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.rule_);
                return this;
            }

            public Builder addAllTag(Iterable iterable) {
                ensureTagIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.tag_);
                return this;
            }

            public Builder addAllUsageContext(Iterable iterable) {
                ensureUsageContextIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.usageContext_);
                return this;
            }

            public Builder addAllValue(Iterable iterable) {
                ensureValueIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.value_);
                return this;
            }

            public Builder addKey(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                ensureKeyIsMutable();
                this.key_.add(str);
                return this;
            }

            public Builder addKeyBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                ensureKeyIsMutable();
                this.key_.add(byteString);
                return this;
            }

            public Builder addMacro(int i, Builder builder) {
                ensureMacroIsMutable();
                this.macro_.add(i, builder.build());
                return this;
            }

            public Builder addMacro(int i, FunctionCall functionCall) {
                if (functionCall == null) {
                    throw new NullPointerException();
                }
                ensureMacroIsMutable();
                this.macro_.add(i, functionCall);
                return this;
            }

            public Builder addMacro(Builder builder) {
                ensureMacroIsMutable();
                this.macro_.add(builder.build());
                return this;
            }

            public Builder addMacro(FunctionCall functionCall) {
                if (functionCall == null) {
                    throw new NullPointerException();
                }
                ensureMacroIsMutable();
                this.macro_.add(functionCall);
                return this;
            }

            public Builder addPredicate(int i, Builder builder) {
                ensurePredicateIsMutable();
                this.predicate_.add(i, builder.build());
                return this;
            }

            public Builder addPredicate(int i, FunctionCall functionCall) {
                if (functionCall == null) {
                    throw new NullPointerException();
                }
                ensurePredicateIsMutable();
                this.predicate_.add(i, functionCall);
                return this;
            }

            public Builder addPredicate(Builder builder) {
                ensurePredicateIsMutable();
                this.predicate_.add(builder.build());
                return this;
            }

            public Builder addPredicate(FunctionCall functionCall) {
                if (functionCall == null) {
                    throw new NullPointerException();
                }
                ensurePredicateIsMutable();
                this.predicate_.add(functionCall);
                return this;
            }

            public Builder addProperty(int i, Builder builder) {
                ensurePropertyIsMutable();
                this.property_.add(i, builder.build());
                return this;
            }

            public Builder addProperty(int i, Property property) {
                if (property == null) {
                    throw new NullPointerException();
                }
                ensurePropertyIsMutable();
                this.property_.add(i, property);
                return this;
            }

            public Builder addProperty(Builder builder) {
                ensurePropertyIsMutable();
                this.property_.add(builder.build());
                return this;
            }

            public Builder addProperty(Property property) {
                if (property == null) {
                    throw new NullPointerException();
                }
                ensurePropertyIsMutable();
                this.property_.add(property);
                return this;
            }

            public Builder addRule(int i, Builder builder) {
                ensureRuleIsMutable();
                this.rule_.add(i, builder.build());
                return this;
            }

            public Builder addRule(int i, Rule rule) {
                if (rule == null) {
                    throw new NullPointerException();
                }
                ensureRuleIsMutable();
                this.rule_.add(i, rule);
                return this;
            }

            public Builder addRule(Builder builder) {
                ensureRuleIsMutable();
                this.rule_.add(builder.build());
                return this;
            }

            public Builder addRule(Rule rule) {
                if (rule == null) {
                    throw new NullPointerException();
                }
                ensureRuleIsMutable();
                this.rule_.add(rule);
                return this;
            }

            public Builder addTag(int i, Builder builder) {
                ensureTagIsMutable();
                this.tag_.add(i, builder.build());
                return this;
            }

            public Builder addTag(int i, FunctionCall functionCall) {
                if (functionCall == null) {
                    throw new NullPointerException();
                }
                ensureTagIsMutable();
                this.tag_.add(i, functionCall);
                return this;
            }

            public Builder addTag(Builder builder) {
                ensureTagIsMutable();
                this.tag_.add(builder.build());
                return this;
            }

            public Builder addTag(FunctionCall functionCall) {
                if (functionCall == null) {
                    throw new NullPointerException();
                }
                ensureTagIsMutable();
                this.tag_.add(functionCall);
                return this;
            }

            public Builder addUsageContext(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                ensureUsageContextIsMutable();
                this.usageContext_.add(str);
                return this;
            }

            public Builder addUsageContextBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                ensureUsageContextIsMutable();
                this.usageContext_.add(byteString);
                return this;
            }

            public Builder addValue(int i, com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder) {
                ensureValueIsMutable();
                this.value_.add(i, builder.build());
                return this;
            }

            public Builder addValue(int i, Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureValueIsMutable();
                this.value_.add(i, value);
                return this;
            }

            public Builder addValue(com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder) {
                ensureValueIsMutable();
                this.value_.add(builder.build());
                return this;
            }

            public Builder addValue(Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureValueIsMutable();
                this.value_.add(value);
                return this;
            }

            public Resource build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public Resource buildPartial() {
                int i = 1;
                Resource resource = new Resource((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.key_ = new UnmodifiableLazyStringList(this.key_);
                    this.bitField0_ &= -2;
                }
                resource.key_ = this.key_;
                if ((this.bitField0_ & 2) == 2) {
                    this.value_ = Collections.unmodifiableList(this.value_);
                    this.bitField0_ &= -3;
                }
                resource.value_ = this.value_;
                if ((this.bitField0_ & 4) == 4) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                    this.bitField0_ &= -5;
                }
                resource.property_ = this.property_;
                if ((this.bitField0_ & 8) == 8) {
                    this.macro_ = Collections.unmodifiableList(this.macro_);
                    this.bitField0_ &= -9;
                }
                resource.macro_ = this.macro_;
                if ((this.bitField0_ & 16) == 16) {
                    this.tag_ = Collections.unmodifiableList(this.tag_);
                    this.bitField0_ &= -17;
                }
                resource.tag_ = this.tag_;
                if ((this.bitField0_ & 32) == 32) {
                    this.predicate_ = Collections.unmodifiableList(this.predicate_);
                    this.bitField0_ &= -33;
                }
                resource.predicate_ = this.predicate_;
                if ((this.bitField0_ & 64) == 64) {
                    this.rule_ = Collections.unmodifiableList(this.rule_);
                    this.bitField0_ &= -65;
                }
                resource.rule_ = this.rule_;
                if ((i2 & 128) != 128) {
                    i = 0;
                }
                resource.previewAuthCode_ = this.previewAuthCode_;
                if ((i2 & Policy.LICENSED) == Policy.LICENSED) {
                    i |= 2;
                }
                resource.malwareScanAuthCode_ = this.malwareScanAuthCode_;
                if ((i2 & 512) == 512) {
                    i |= 4;
                }
                resource.templateVersionSet_ = this.templateVersionSet_;
                if ((i2 & 1024) == 1024) {
                    i |= 8;
                }
                resource.version_ = this.version_;
                if ((i2 & 2048) == 2048) {
                    i |= 16;
                }
                resource.liveJsCacheOption_ = this.liveJsCacheOption_;
                if ((i2 & CodedOutputStream.DEFAULT_BUFFER_SIZE) == CodedOutputStream.DEFAULT_BUFFER_SIZE) {
                    i |= 32;
                }
                resource.reportingSampleRate_ = this.reportingSampleRate_;
                if ((i2 & 8192) == 8192) {
                    i |= 64;
                }
                resource.enableAutoEventTracking_ = this.enableAutoEventTracking_;
                if ((this.bitField0_ & 16384) == 16384) {
                    this.usageContext_ = new UnmodifiableLazyStringList(this.usageContext_);
                    this.bitField0_ &= -16385;
                }
                resource.usageContext_ = this.usageContext_;
                if ((i2 & 32768) == 32768) {
                    i |= 128;
                }
                resource.resourceFormatVersion_ = this.resourceFormatVersion_;
                resource.bitField0_ = i;
                return resource;
            }

            public Builder clear() {
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
                this.liveJsCacheOption_ = CacheOption.getDefaultInstance();
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

            public Builder clearEnableAutoEventTracking() {
                this.bitField0_ &= -8193;
                this.enableAutoEventTracking_ = false;
                return this;
            }

            public Builder clearKey() {
                this.key_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clearLiveJsCacheOption() {
                this.liveJsCacheOption_ = CacheOption.getDefaultInstance();
                this.bitField0_ &= -2049;
                return this;
            }

            public Builder clearMacro() {
                this.macro_ = Collections.emptyList();
                this.bitField0_ &= -9;
                return this;
            }

            public Builder clearMalwareScanAuthCode() {
                this.bitField0_ &= -257;
                this.malwareScanAuthCode_ = Resource.getDefaultInstance().getMalwareScanAuthCode();
                return this;
            }

            public Builder clearPredicate() {
                this.predicate_ = Collections.emptyList();
                this.bitField0_ &= -33;
                return this;
            }

            public Builder clearPreviewAuthCode() {
                this.bitField0_ &= -129;
                this.previewAuthCode_ = Resource.getDefaultInstance().getPreviewAuthCode();
                return this;
            }

            public Builder clearProperty() {
                this.property_ = Collections.emptyList();
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clearReportingSampleRate() {
                this.bitField0_ &= -4097;
                this.reportingSampleRate_ = 0.0f;
                return this;
            }

            public Builder clearResourceFormatVersion() {
                this.bitField0_ &= -32769;
                this.resourceFormatVersion_ = 0;
                return this;
            }

            public Builder clearRule() {
                this.rule_ = Collections.emptyList();
                this.bitField0_ &= -65;
                return this;
            }

            public Builder clearTag() {
                this.tag_ = Collections.emptyList();
                this.bitField0_ &= -17;
                return this;
            }

            public Builder clearTemplateVersionSet() {
                this.bitField0_ &= -513;
                this.templateVersionSet_ = Resource.getDefaultInstance().getTemplateVersionSet();
                return this;
            }

            public Builder clearUsageContext() {
                this.usageContext_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -16385;
                return this;
            }

            public Builder clearValue() {
                this.value_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearVersion() {
                this.bitField0_ &= -1025;
                this.version_ = Resource.getDefaultInstance().getVersion();
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Resource getDefaultInstanceForType() {
                return Resource.getDefaultInstance();
            }

            public boolean getEnableAutoEventTracking() {
                return this.enableAutoEventTracking_;
            }

            public String getKey(int i) {
                return (String) this.key_.get(i);
            }

            public ByteString getKeyBytes(int i) {
                return this.key_.getByteString(i);
            }

            public int getKeyCount() {
                return this.key_.size();
            }

            public List getKeyList() {
                return Collections.unmodifiableList(this.key_);
            }

            public CacheOption getLiveJsCacheOption() {
                return this.liveJsCacheOption_;
            }

            public FunctionCall getMacro(int i) {
                return (FunctionCall) this.macro_.get(i);
            }

            public int getMacroCount() {
                return this.macro_.size();
            }

            public List getMacroList() {
                return Collections.unmodifiableList(this.macro_);
            }

            public String getMalwareScanAuthCode() {
                Object obj = this.malwareScanAuthCode_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String toStringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.malwareScanAuthCode_ = toStringUtf8;
                }
                return toStringUtf8;
            }

            public ByteString getMalwareScanAuthCodeBytes() {
                Object obj = this.malwareScanAuthCode_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.malwareScanAuthCode_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public FunctionCall getPredicate(int i) {
                return (FunctionCall) this.predicate_.get(i);
            }

            public int getPredicateCount() {
                return this.predicate_.size();
            }

            public List getPredicateList() {
                return Collections.unmodifiableList(this.predicate_);
            }

            public String getPreviewAuthCode() {
                Object obj = this.previewAuthCode_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String toStringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.previewAuthCode_ = toStringUtf8;
                }
                return toStringUtf8;
            }

            public ByteString getPreviewAuthCodeBytes() {
                Object obj = this.previewAuthCode_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.previewAuthCode_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Property getProperty(int i) {
                return (Property) this.property_.get(i);
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public List getPropertyList() {
                return Collections.unmodifiableList(this.property_);
            }

            public float getReportingSampleRate() {
                return this.reportingSampleRate_;
            }

            public int getResourceFormatVersion() {
                return this.resourceFormatVersion_;
            }

            public Rule getRule(int i) {
                return (Rule) this.rule_.get(i);
            }

            public int getRuleCount() {
                return this.rule_.size();
            }

            public List getRuleList() {
                return Collections.unmodifiableList(this.rule_);
            }

            public FunctionCall getTag(int i) {
                return (FunctionCall) this.tag_.get(i);
            }

            public int getTagCount() {
                return this.tag_.size();
            }

            public List getTagList() {
                return Collections.unmodifiableList(this.tag_);
            }

            public String getTemplateVersionSet() {
                Object obj = this.templateVersionSet_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String toStringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.templateVersionSet_ = toStringUtf8;
                }
                return toStringUtf8;
            }

            public ByteString getTemplateVersionSetBytes() {
                Object obj = this.templateVersionSet_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.templateVersionSet_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public String getUsageContext(int i) {
                return (String) this.usageContext_.get(i);
            }

            public ByteString getUsageContextBytes(int i) {
                return this.usageContext_.getByteString(i);
            }

            public int getUsageContextCount() {
                return this.usageContext_.size();
            }

            public List getUsageContextList() {
                return Collections.unmodifiableList(this.usageContext_);
            }

            public Value getValue(int i) {
                return (Value) this.value_.get(i);
            }

            public int getValueCount() {
                return this.value_.size();
            }

            public List getValueList() {
                return Collections.unmodifiableList(this.value_);
            }

            public String getVersion() {
                Object obj = this.version_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String toStringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.version_ = toStringUtf8;
                }
                return toStringUtf8;
            }

            public ByteString getVersionBytes() {
                Object obj = this.version_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.version_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public boolean hasEnableAutoEventTracking() {
                return (this.bitField0_ & 8192) == 8192;
            }

            public boolean hasLiveJsCacheOption() {
                return (this.bitField0_ & 2048) == 2048;
            }

            public boolean hasMalwareScanAuthCode() {
                return (this.bitField0_ & Policy.LICENSED) == Policy.LICENSED;
            }

            public boolean hasPreviewAuthCode() {
                return (this.bitField0_ & 128) == 128;
            }

            public boolean hasReportingSampleRate() {
                return (this.bitField0_ & CodedOutputStream.DEFAULT_BUFFER_SIZE) == CodedOutputStream.DEFAULT_BUFFER_SIZE;
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
                int i;
                for (i = 0; i < getValueCount(); i++) {
                    if (!getValue(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getPropertyCount(); i++) {
                    if (!getProperty(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getMacroCount(); i++) {
                    if (!getMacro(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getTagCount(); i++) {
                    if (!getTag(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getPredicateCount(); i++) {
                    if (!getPredicate(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(Resource resource) {
                if (resource != Resource.getDefaultInstance()) {
                    if (!resource.key_.isEmpty()) {
                        if (this.key_.isEmpty()) {
                            this.key_ = resource.key_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureKeyIsMutable();
                            this.key_.addAll(resource.key_);
                        }
                    }
                    if (!resource.value_.isEmpty()) {
                        if (this.value_.isEmpty()) {
                            this.value_ = resource.value_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureValueIsMutable();
                            this.value_.addAll(resource.value_);
                        }
                    }
                    if (!resource.property_.isEmpty()) {
                        if (this.property_.isEmpty()) {
                            this.property_ = resource.property_;
                            this.bitField0_ &= -5;
                        } else {
                            ensurePropertyIsMutable();
                            this.property_.addAll(resource.property_);
                        }
                    }
                    if (!resource.macro_.isEmpty()) {
                        if (this.macro_.isEmpty()) {
                            this.macro_ = resource.macro_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureMacroIsMutable();
                            this.macro_.addAll(resource.macro_);
                        }
                    }
                    if (!resource.tag_.isEmpty()) {
                        if (this.tag_.isEmpty()) {
                            this.tag_ = resource.tag_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureTagIsMutable();
                            this.tag_.addAll(resource.tag_);
                        }
                    }
                    if (!resource.predicate_.isEmpty()) {
                        if (this.predicate_.isEmpty()) {
                            this.predicate_ = resource.predicate_;
                            this.bitField0_ &= -33;
                        } else {
                            ensurePredicateIsMutable();
                            this.predicate_.addAll(resource.predicate_);
                        }
                    }
                    if (!resource.rule_.isEmpty()) {
                        if (this.rule_.isEmpty()) {
                            this.rule_ = resource.rule_;
                            this.bitField0_ &= -65;
                        } else {
                            ensureRuleIsMutable();
                            this.rule_.addAll(resource.rule_);
                        }
                    }
                    if (resource.hasPreviewAuthCode()) {
                        this.bitField0_ |= 128;
                        this.previewAuthCode_ = resource.previewAuthCode_;
                    }
                    if (resource.hasMalwareScanAuthCode()) {
                        this.bitField0_ |= Policy.LICENSED;
                        this.malwareScanAuthCode_ = resource.malwareScanAuthCode_;
                    }
                    if (resource.hasTemplateVersionSet()) {
                        this.bitField0_ |= 512;
                        this.templateVersionSet_ = resource.templateVersionSet_;
                    }
                    if (resource.hasVersion()) {
                        this.bitField0_ |= 1024;
                        this.version_ = resource.version_;
                    }
                    if (resource.hasLiveJsCacheOption()) {
                        mergeLiveJsCacheOption(resource.getLiveJsCacheOption());
                    }
                    if (resource.hasReportingSampleRate()) {
                        setReportingSampleRate(resource.getReportingSampleRate());
                    }
                    if (resource.hasEnableAutoEventTracking()) {
                        setEnableAutoEventTracking(resource.getEnableAutoEventTracking());
                    }
                    if (!resource.usageContext_.isEmpty()) {
                        if (this.usageContext_.isEmpty()) {
                            this.usageContext_ = resource.usageContext_;
                            this.bitField0_ &= -16385;
                        } else {
                            ensureUsageContextIsMutable();
                            this.usageContext_.addAll(resource.usageContext_);
                        }
                    }
                    if (resource.hasResourceFormatVersion()) {
                        setResourceFormatVersion(resource.getResourceFormatVersion());
                    }
                    setUnknownFields(getUnknownFields().concat(resource.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                Resource resource;
                Resource resource2;
                try {
                    resource2 = (Resource) Resource.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (resource2 != null) {
                        mergeFrom(resource2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    resource2 = (Resource) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    resource = resource2;
                    th = th3;
                }
                if (resource != null) {
                    mergeFrom(resource);
                }
                throw th;
            }

            public Builder mergeLiveJsCacheOption(CacheOption cacheOption) {
                if ((this.bitField0_ & 2048) != 2048 || this.liveJsCacheOption_ == CacheOption.getDefaultInstance()) {
                    this.liveJsCacheOption_ = cacheOption;
                } else {
                    this.liveJsCacheOption_ = CacheOption.newBuilder(this.liveJsCacheOption_).mergeFrom(cacheOption).buildPartial();
                }
                this.bitField0_ |= 2048;
                return this;
            }

            public Builder removeMacro(int i) {
                ensureMacroIsMutable();
                this.macro_.remove(i);
                return this;
            }

            public Builder removePredicate(int i) {
                ensurePredicateIsMutable();
                this.predicate_.remove(i);
                return this;
            }

            public Builder removeProperty(int i) {
                ensurePropertyIsMutable();
                this.property_.remove(i);
                return this;
            }

            public Builder removeRule(int i) {
                ensureRuleIsMutable();
                this.rule_.remove(i);
                return this;
            }

            public Builder removeTag(int i) {
                ensureTagIsMutable();
                this.tag_.remove(i);
                return this;
            }

            public Builder removeValue(int i) {
                ensureValueIsMutable();
                this.value_.remove(i);
                return this;
            }

            public Builder setEnableAutoEventTracking(boolean z) {
                this.bitField0_ |= 8192;
                this.enableAutoEventTracking_ = z;
                return this;
            }

            public Builder setKey(int i, String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                ensureKeyIsMutable();
                this.key_.set(i, str);
                return this;
            }

            public Builder setLiveJsCacheOption(Builder builder) {
                this.liveJsCacheOption_ = builder.build();
                this.bitField0_ |= 2048;
                return this;
            }

            public Builder setLiveJsCacheOption(CacheOption cacheOption) {
                if (cacheOption == null) {
                    throw new NullPointerException();
                }
                this.liveJsCacheOption_ = cacheOption;
                this.bitField0_ |= 2048;
                return this;
            }

            public Builder setMacro(int i, Builder builder) {
                ensureMacroIsMutable();
                this.macro_.set(i, builder.build());
                return this;
            }

            public Builder setMacro(int i, FunctionCall functionCall) {
                if (functionCall == null) {
                    throw new NullPointerException();
                }
                ensureMacroIsMutable();
                this.macro_.set(i, functionCall);
                return this;
            }

            public Builder setMalwareScanAuthCode(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= Policy.LICENSED;
                this.malwareScanAuthCode_ = str;
                return this;
            }

            public Builder setMalwareScanAuthCodeBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= Policy.LICENSED;
                this.malwareScanAuthCode_ = byteString;
                return this;
            }

            public Builder setPredicate(int i, Builder builder) {
                ensurePredicateIsMutable();
                this.predicate_.set(i, builder.build());
                return this;
            }

            public Builder setPredicate(int i, FunctionCall functionCall) {
                if (functionCall == null) {
                    throw new NullPointerException();
                }
                ensurePredicateIsMutable();
                this.predicate_.set(i, functionCall);
                return this;
            }

            public Builder setPreviewAuthCode(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 128;
                this.previewAuthCode_ = str;
                return this;
            }

            public Builder setPreviewAuthCodeBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 128;
                this.previewAuthCode_ = byteString;
                return this;
            }

            public Builder setProperty(int i, Builder builder) {
                ensurePropertyIsMutable();
                this.property_.set(i, builder.build());
                return this;
            }

            public Builder setProperty(int i, Property property) {
                if (property == null) {
                    throw new NullPointerException();
                }
                ensurePropertyIsMutable();
                this.property_.set(i, property);
                return this;
            }

            public Builder setReportingSampleRate(float f) {
                this.bitField0_ |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
                this.reportingSampleRate_ = f;
                return this;
            }

            public Builder setResourceFormatVersion(int i) {
                this.bitField0_ |= 32768;
                this.resourceFormatVersion_ = i;
                return this;
            }

            public Builder setRule(int i, Builder builder) {
                ensureRuleIsMutable();
                this.rule_.set(i, builder.build());
                return this;
            }

            public Builder setRule(int i, Rule rule) {
                if (rule == null) {
                    throw new NullPointerException();
                }
                ensureRuleIsMutable();
                this.rule_.set(i, rule);
                return this;
            }

            public Builder setTag(int i, Builder builder) {
                ensureTagIsMutable();
                this.tag_.set(i, builder.build());
                return this;
            }

            public Builder setTag(int i, FunctionCall functionCall) {
                if (functionCall == null) {
                    throw new NullPointerException();
                }
                ensureTagIsMutable();
                this.tag_.set(i, functionCall);
                return this;
            }

            public Builder setTemplateVersionSet(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 512;
                this.templateVersionSet_ = str;
                return this;
            }

            public Builder setTemplateVersionSetBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 512;
                this.templateVersionSet_ = byteString;
                return this;
            }

            public Builder setUsageContext(int i, String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                ensureUsageContextIsMutable();
                this.usageContext_.set(i, str);
                return this;
            }

            public Builder setValue(int i, com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder) {
                ensureValueIsMutable();
                this.value_.set(i, builder.build());
                return this;
            }

            public Builder setValue(int i, Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureValueIsMutable();
                this.value_.set(i, value);
                return this;
            }

            public Builder setVersion(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1024;
                this.version_ = str;
                return this;
            }

            public Builder setVersionBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1024;
                this.version_ = byteString;
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private Resource(com.google.tagmanager.protobuf.CodedInputStream r14, com.google.tagmanager.protobuf.ExtensionRegistryLite r15) {
            /*
            r13 = this;
            r11 = 8;
            r10 = 4;
            r9 = 2;
            r8 = 16;
            r1 = 1;
            r13.<init>();
            r0 = -1;
            r13.memoizedIsInitialized = r0;
            r0 = -1;
            r13.memoizedSerializedSize = r0;
            r13.initFields();
            r3 = 0;
            r5 = com.google.tagmanager.protobuf.ByteString.newOutput();
            r6 = com.google.tagmanager.protobuf.CodedOutputStream.newInstance(r5);
            r2 = 0;
        L_0x001d:
            if (r2 != 0) goto L_0x01b9;
        L_0x001f:
            r0 = r14.readTag();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            switch(r0) {
                case 0: goto L_0x0031;
                case 10: goto L_0x0034;
                case 18: goto L_0x004e;
                case 26: goto L_0x006a;
                case 34: goto L_0x0086;
                case 42: goto L_0x00a2;
                case 50: goto L_0x00bf;
                case 58: goto L_0x00de;
                case 74: goto L_0x00fd;
                case 82: goto L_0x010d;
                case 98: goto L_0x011d;
                case 106: goto L_0x012d;
                case 114: goto L_0x013d;
                case 125: goto L_0x016c;
                case 130: goto L_0x017c;
                case 136: goto L_0x0199;
                case 144: goto L_0x01a9;
                default: goto L_0x0026;
            };	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
        L_0x0026:
            r0 = r13.parseUnknownField(r14, r6, r15, r0);	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            if (r0 != 0) goto L_0x01b5;
        L_0x002c:
            r0 = r1;
            r2 = r3;
        L_0x002e:
            r3 = r2;
            r2 = r0;
            goto L_0x001d;
        L_0x0031:
            r0 = r1;
            r2 = r3;
            goto L_0x002e;
        L_0x0034:
            r4 = r14.readBytes();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r3 & 1;
            if (r0 == r1) goto L_0x02ff;
        L_0x003c:
            r0 = new com.google.tagmanager.protobuf.LazyStringArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.key_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r3 | 1;
        L_0x0045:
            r3 = r13.key_;	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r3.add(r4);	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r12 = r2;
            r2 = r0;
            r0 = r12;
            goto L_0x002e;
        L_0x004e:
            r0 = r3 & 2;
            if (r0 == r9) goto L_0x02fc;
        L_0x0052:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.value_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r3 | 2;
        L_0x005b:
            r3 = r13.value_;	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r4 = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r4 = r14.readMessage(r4, r15);	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r3.add(r4);	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r12 = r2;
            r2 = r0;
            r0 = r12;
            goto L_0x002e;
        L_0x006a:
            r0 = r3 & 4;
            if (r0 == r10) goto L_0x02f9;
        L_0x006e:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.property_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r3 | 4;
        L_0x0077:
            r3 = r13.property_;	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r4 = com.google.analytics.containertag.proto.Serving.Property.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r4 = r14.readMessage(r4, r15);	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r3.add(r4);	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r12 = r2;
            r2 = r0;
            r0 = r12;
            goto L_0x002e;
        L_0x0086:
            r0 = r3 & 8;
            if (r0 == r11) goto L_0x02f6;
        L_0x008a:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.macro_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r3 | 8;
        L_0x0093:
            r3 = r13.macro_;	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r4 = com.google.analytics.containertag.proto.Serving.FunctionCall.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r4 = r14.readMessage(r4, r15);	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r3.add(r4);	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r12 = r2;
            r2 = r0;
            r0 = r12;
            goto L_0x002e;
        L_0x00a2:
            r0 = r3 & 16;
            if (r0 == r8) goto L_0x02f3;
        L_0x00a6:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.tag_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r3 | 16;
        L_0x00af:
            r3 = r13.tag_;	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r4 = com.google.analytics.containertag.proto.Serving.FunctionCall.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r4 = r14.readMessage(r4, r15);	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r3.add(r4);	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r12 = r2;
            r2 = r0;
            r0 = r12;
            goto L_0x002e;
        L_0x00bf:
            r0 = r3 & 32;
            r4 = 32;
            if (r0 == r4) goto L_0x02f0;
        L_0x00c5:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.predicate_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r3 | 32;
        L_0x00ce:
            r3 = r13.predicate_;	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r4 = com.google.analytics.containertag.proto.Serving.FunctionCall.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r4 = r14.readMessage(r4, r15);	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r3.add(r4);	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r12 = r2;
            r2 = r0;
            r0 = r12;
            goto L_0x002e;
        L_0x00de:
            r0 = r3 & 64;
            r4 = 64;
            if (r0 == r4) goto L_0x02ed;
        L_0x00e4:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.rule_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r3 | 64;
        L_0x00ed:
            r3 = r13.rule_;	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r4 = com.google.analytics.containertag.proto.Serving.Rule.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r4 = r14.readMessage(r4, r15);	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r3.add(r4);	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r12 = r2;
            r2 = r0;
            r0 = r12;
            goto L_0x002e;
        L_0x00fd:
            r0 = r14.readBytes();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r4 = r13.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r4 = r4 | 1;
            r13.bitField0_ = r4;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.previewAuthCode_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r2;
            r2 = r3;
            goto L_0x002e;
        L_0x010d:
            r0 = r14.readBytes();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r4 = r13.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r4 = r4 | 2;
            r13.bitField0_ = r4;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.malwareScanAuthCode_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r2;
            r2 = r3;
            goto L_0x002e;
        L_0x011d:
            r0 = r14.readBytes();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r4 = r13.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r4 = r4 | 4;
            r13.bitField0_ = r4;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.templateVersionSet_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r2;
            r2 = r3;
            goto L_0x002e;
        L_0x012d:
            r0 = r14.readBytes();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r4 = r13.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r4 = r4 | 8;
            r13.bitField0_ = r4;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.version_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r2;
            r2 = r3;
            goto L_0x002e;
        L_0x013d:
            r0 = 0;
            r4 = r13.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r4 = r4 & 16;
            if (r4 != r8) goto L_0x02ea;
        L_0x0144:
            r0 = r13.liveJsCacheOption_;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r0.toBuilder();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r4 = r0;
        L_0x014b:
            r0 = com.google.analytics.containertag.proto.Serving.CacheOption.PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r14.readMessage(r0, r15);	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = (com.google.analytics.containertag.proto.Serving.CacheOption) r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.liveJsCacheOption_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            if (r4 == 0) goto L_0x0162;
        L_0x0157:
            r0 = r13.liveJsCacheOption_;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r4.mergeFrom(r0);	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r4.buildPartial();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.liveJsCacheOption_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
        L_0x0162:
            r0 = r13.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r0 | 16;
            r13.bitField0_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r2;
            r2 = r3;
            goto L_0x002e;
        L_0x016c:
            r0 = r13.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r0 | 32;
            r13.bitField0_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r14.readFloat();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.reportingSampleRate_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r2;
            r2 = r3;
            goto L_0x002e;
        L_0x017c:
            r4 = r14.readBytes();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r3 & 16384;
            r7 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
            if (r0 == r7) goto L_0x02e7;
        L_0x0186:
            r0 = new com.google.tagmanager.protobuf.LazyStringArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.usageContext_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r3 | 16384;
        L_0x018f:
            r3 = r13.usageContext_;	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r3.add(r4);	 Catch:{ InvalidProtocolBufferException -> 0x02e2, IOException -> 0x02de, all -> 0x02d9 }
            r12 = r2;
            r2 = r0;
            r0 = r12;
            goto L_0x002e;
        L_0x0199:
            r0 = r13.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r0 | 128;
            r13.bitField0_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r14.readInt32();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.resourceFormatVersion_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r2;
            r2 = r3;
            goto L_0x002e;
        L_0x01a9:
            r0 = r13.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r0 | 64;
            r13.bitField0_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r0 = r14.readBool();	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
            r13.enableAutoEventTracking_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x023e, IOException -> 0x02ba }
        L_0x01b5:
            r0 = r2;
            r2 = r3;
            goto L_0x002e;
        L_0x01b9:
            r0 = r3 & 1;
            if (r0 != r1) goto L_0x01c6;
        L_0x01bd:
            r0 = new com.google.tagmanager.protobuf.UnmodifiableLazyStringList;
            r1 = r13.key_;
            r0.<init>(r1);
            r13.key_ = r0;
        L_0x01c6:
            r0 = r3 & 2;
            if (r0 != r9) goto L_0x01d2;
        L_0x01ca:
            r0 = r13.value_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r13.value_ = r0;
        L_0x01d2:
            r0 = r3 & 4;
            if (r0 != r10) goto L_0x01de;
        L_0x01d6:
            r0 = r13.property_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r13.property_ = r0;
        L_0x01de:
            r0 = r3 & 8;
            if (r0 != r11) goto L_0x01ea;
        L_0x01e2:
            r0 = r13.macro_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r13.macro_ = r0;
        L_0x01ea:
            r0 = r3 & 16;
            if (r0 != r8) goto L_0x01f6;
        L_0x01ee:
            r0 = r13.tag_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r13.tag_ = r0;
        L_0x01f6:
            r0 = r3 & 32;
            r1 = 32;
            if (r0 != r1) goto L_0x0204;
        L_0x01fc:
            r0 = r13.predicate_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r13.predicate_ = r0;
        L_0x0204:
            r0 = r3 & 64;
            r1 = 64;
            if (r0 != r1) goto L_0x0212;
        L_0x020a:
            r0 = r13.rule_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r13.rule_ = r0;
        L_0x0212:
            r0 = r3 & 16384;
            r1 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
            if (r0 != r1) goto L_0x0221;
        L_0x0218:
            r0 = new com.google.tagmanager.protobuf.UnmodifiableLazyStringList;
            r1 = r13.usageContext_;
            r0.<init>(r1);
            r13.usageContext_ = r0;
        L_0x0221:
            r6.flush();	 Catch:{ IOException -> 0x022e, all -> 0x0236 }
            r0 = r5.toByteString();
            r13.unknownFields = r0;
        L_0x022a:
            r13.makeExtensionsImmutable();
            return;
        L_0x022e:
            r0 = move-exception;
            r0 = r5.toByteString();
            r13.unknownFields = r0;
            goto L_0x022a;
        L_0x0236:
            r0 = move-exception;
            r1 = r5.toByteString();
            r13.unknownFields = r1;
            throw r0;
        L_0x023e:
            r0 = move-exception;
        L_0x023f:
            r0 = r0.setUnfinishedMessage(r13);	 Catch:{ all -> 0x0244 }
            throw r0;	 Catch:{ all -> 0x0244 }
        L_0x0244:
            r0 = move-exception;
        L_0x0245:
            r2 = r3 & 1;
            if (r2 != r1) goto L_0x0252;
        L_0x0249:
            r1 = new com.google.tagmanager.protobuf.UnmodifiableLazyStringList;
            r2 = r13.key_;
            r1.<init>(r2);
            r13.key_ = r1;
        L_0x0252:
            r1 = r3 & 2;
            if (r1 != r9) goto L_0x025e;
        L_0x0256:
            r1 = r13.value_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r13.value_ = r1;
        L_0x025e:
            r1 = r3 & 4;
            if (r1 != r10) goto L_0x026a;
        L_0x0262:
            r1 = r13.property_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r13.property_ = r1;
        L_0x026a:
            r1 = r3 & 8;
            if (r1 != r11) goto L_0x0276;
        L_0x026e:
            r1 = r13.macro_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r13.macro_ = r1;
        L_0x0276:
            r1 = r3 & 16;
            if (r1 != r8) goto L_0x0282;
        L_0x027a:
            r1 = r13.tag_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r13.tag_ = r1;
        L_0x0282:
            r1 = r3 & 32;
            r2 = 32;
            if (r1 != r2) goto L_0x0290;
        L_0x0288:
            r1 = r13.predicate_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r13.predicate_ = r1;
        L_0x0290:
            r1 = r3 & 64;
            r2 = 64;
            if (r1 != r2) goto L_0x029e;
        L_0x0296:
            r1 = r13.rule_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r13.rule_ = r1;
        L_0x029e:
            r1 = r3 & 16384;
            r2 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
            if (r1 != r2) goto L_0x02ad;
        L_0x02a4:
            r1 = new com.google.tagmanager.protobuf.UnmodifiableLazyStringList;
            r2 = r13.usageContext_;
            r1.<init>(r2);
            r13.usageContext_ = r1;
        L_0x02ad:
            r6.flush();	 Catch:{ IOException -> 0x02c9, all -> 0x02d1 }
            r1 = r5.toByteString();
            r13.unknownFields = r1;
        L_0x02b6:
            r13.makeExtensionsImmutable();
            throw r0;
        L_0x02ba:
            r0 = move-exception;
        L_0x02bb:
            r2 = new com.google.tagmanager.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0244 }
            r0 = r0.getMessage();	 Catch:{ all -> 0x0244 }
            r2.<init>(r0);	 Catch:{ all -> 0x0244 }
            r0 = r2.setUnfinishedMessage(r13);	 Catch:{ all -> 0x0244 }
            throw r0;	 Catch:{ all -> 0x0244 }
        L_0x02c9:
            r1 = move-exception;
            r1 = r5.toByteString();
            r13.unknownFields = r1;
            goto L_0x02b6;
        L_0x02d1:
            r0 = move-exception;
            r1 = r5.toByteString();
            r13.unknownFields = r1;
            throw r0;
        L_0x02d9:
            r2 = move-exception;
            r3 = r0;
            r0 = r2;
            goto L_0x0245;
        L_0x02de:
            r2 = move-exception;
            r3 = r0;
            r0 = r2;
            goto L_0x02bb;
        L_0x02e2:
            r2 = move-exception;
            r3 = r0;
            r0 = r2;
            goto L_0x023f;
        L_0x02e7:
            r0 = r3;
            goto L_0x018f;
        L_0x02ea:
            r4 = r0;
            goto L_0x014b;
        L_0x02ed:
            r0 = r3;
            goto L_0x00ed;
        L_0x02f0:
            r0 = r3;
            goto L_0x00ce;
        L_0x02f3:
            r0 = r3;
            goto L_0x00af;
        L_0x02f6:
            r0 = r3;
            goto L_0x0093;
        L_0x02f9:
            r0 = r3;
            goto L_0x0077;
        L_0x02fc:
            r0 = r3;
            goto L_0x005b;
        L_0x02ff:
            r0 = r3;
            goto L_0x0045;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.containertag.proto.Serving.Resource.<init>(com.google.tagmanager.protobuf.CodedInputStream, com.google.tagmanager.protobuf.ExtensionRegistryLite):void");
        }

        private Resource(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Resource(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Resource getDefaultInstance() {
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
            this.liveJsCacheOption_ = CacheOption.getDefaultInstance();
            this.reportingSampleRate_ = 0.0f;
            this.enableAutoEventTracking_ = false;
            this.usageContext_ = LazyStringArrayList.EMPTY;
            this.resourceFormatVersion_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(Resource resource) {
            return newBuilder().mergeFrom(resource);
        }

        public static Resource parseDelimitedFrom(InputStream inputStream) {
            return (Resource) PARSER.parseDelimitedFrom(inputStream);
        }

        public static Resource parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Resource) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Resource parseFrom(ByteString byteString) {
            return (Resource) PARSER.parseFrom(byteString);
        }

        public static Resource parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Resource) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Resource parseFrom(CodedInputStream codedInputStream) {
            return (Resource) PARSER.parseFrom(codedInputStream);
        }

        public static Resource parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Resource) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Resource parseFrom(InputStream inputStream) {
            return (Resource) PARSER.parseFrom(inputStream);
        }

        public static Resource parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Resource) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Resource parseFrom(byte[] bArr) {
            return (Resource) PARSER.parseFrom(bArr);
        }

        public static Resource parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Resource) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Resource)) {
                return super.equals(obj);
            }
            Resource resource = (Resource) obj;
            boolean z = (getKeyList().equals(resource.getKeyList())) && getValueList().equals(resource.getValueList());
            z = z && getPropertyList().equals(resource.getPropertyList());
            z = z && getMacroList().equals(resource.getMacroList());
            z = z && getTagList().equals(resource.getTagList());
            z = z && getPredicateList().equals(resource.getPredicateList());
            z = z && getRuleList().equals(resource.getRuleList());
            z = z && hasPreviewAuthCode() == resource.hasPreviewAuthCode();
            if (hasPreviewAuthCode()) {
                z = z && getPreviewAuthCode().equals(resource.getPreviewAuthCode());
            }
            z = z && hasMalwareScanAuthCode() == resource.hasMalwareScanAuthCode();
            if (hasMalwareScanAuthCode()) {
                z = z && getMalwareScanAuthCode().equals(resource.getMalwareScanAuthCode());
            }
            z = z && hasTemplateVersionSet() == resource.hasTemplateVersionSet();
            if (hasTemplateVersionSet()) {
                z = z && getTemplateVersionSet().equals(resource.getTemplateVersionSet());
            }
            z = z && hasVersion() == resource.hasVersion();
            if (hasVersion()) {
                z = z && getVersion().equals(resource.getVersion());
            }
            z = z && hasLiveJsCacheOption() == resource.hasLiveJsCacheOption();
            if (hasLiveJsCacheOption()) {
                z = z && getLiveJsCacheOption().equals(resource.getLiveJsCacheOption());
            }
            z = z && hasReportingSampleRate() == resource.hasReportingSampleRate();
            if (hasReportingSampleRate()) {
                z = z && Float.floatToIntBits(getReportingSampleRate()) == Float.floatToIntBits(resource.getReportingSampleRate());
            }
            z = z && hasEnableAutoEventTracking() == resource.hasEnableAutoEventTracking();
            if (hasEnableAutoEventTracking()) {
                z = z && getEnableAutoEventTracking() == resource.getEnableAutoEventTracking();
            }
            z = z && getUsageContextList().equals(resource.getUsageContextList());
            z = z && hasResourceFormatVersion() == resource.hasResourceFormatVersion();
            return hasResourceFormatVersion() ? z && getResourceFormatVersion() == resource.getResourceFormatVersion() : z;
        }

        public Resource getDefaultInstanceForType() {
            return defaultInstance;
        }

        public boolean getEnableAutoEventTracking() {
            return this.enableAutoEventTracking_;
        }

        public String getKey(int i) {
            return (String) this.key_.get(i);
        }

        public ByteString getKeyBytes(int i) {
            return this.key_.getByteString(i);
        }

        public int getKeyCount() {
            return this.key_.size();
        }

        public List getKeyList() {
            return this.key_;
        }

        public CacheOption getLiveJsCacheOption() {
            return this.liveJsCacheOption_;
        }

        public FunctionCall getMacro(int i) {
            return (FunctionCall) this.macro_.get(i);
        }

        public int getMacroCount() {
            return this.macro_.size();
        }

        public List getMacroList() {
            return this.macro_;
        }

        public FunctionCallOrBuilder getMacroOrBuilder(int i) {
            return (FunctionCallOrBuilder) this.macro_.get(i);
        }

        public List getMacroOrBuilderList() {
            return this.macro_;
        }

        public String getMalwareScanAuthCode() {
            Object obj = this.malwareScanAuthCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String toStringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.malwareScanAuthCode_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public ByteString getMalwareScanAuthCodeBytes() {
            Object obj = this.malwareScanAuthCode_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.malwareScanAuthCode_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public FunctionCall getPredicate(int i) {
            return (FunctionCall) this.predicate_.get(i);
        }

        public int getPredicateCount() {
            return this.predicate_.size();
        }

        public List getPredicateList() {
            return this.predicate_;
        }

        public FunctionCallOrBuilder getPredicateOrBuilder(int i) {
            return (FunctionCallOrBuilder) this.predicate_.get(i);
        }

        public List getPredicateOrBuilderList() {
            return this.predicate_;
        }

        public String getPreviewAuthCode() {
            Object obj = this.previewAuthCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String toStringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.previewAuthCode_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public ByteString getPreviewAuthCodeBytes() {
            Object obj = this.previewAuthCode_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.previewAuthCode_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Property getProperty(int i) {
            return (Property) this.property_.get(i);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List getPropertyList() {
            return this.property_;
        }

        public PropertyOrBuilder getPropertyOrBuilder(int i) {
            return (PropertyOrBuilder) this.property_.get(i);
        }

        public List getPropertyOrBuilderList() {
            return this.property_;
        }

        public float getReportingSampleRate() {
            return this.reportingSampleRate_;
        }

        public int getResourceFormatVersion() {
            return this.resourceFormatVersion_;
        }

        public Rule getRule(int i) {
            return (Rule) this.rule_.get(i);
        }

        public int getRuleCount() {
            return this.rule_.size();
        }

        public List getRuleList() {
            return this.rule_;
        }

        public RuleOrBuilder getRuleOrBuilder(int i) {
            return (RuleOrBuilder) this.rule_.get(i);
        }

        public List getRuleOrBuilderList() {
            return this.rule_;
        }

        public int getSerializedSize() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (i2 = 0; i2 < this.key_.size(); i2++) {
                i3 += CodedOutputStream.computeBytesSizeNoTag(this.key_.getByteString(i2));
            }
            i2 = (0 + i3) + (getKeyList().size() * 1);
            int i4 = i2;
            for (i3 = 0; i3 < this.value_.size(); i3++) {
                i4 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.value_.get(i3));
            }
            for (i3 = 0; i3 < this.property_.size(); i3++) {
                i4 += CodedOutputStream.computeMessageSize(3, (MessageLite) this.property_.get(i3));
            }
            for (i3 = 0; i3 < this.macro_.size(); i3++) {
                i4 += CodedOutputStream.computeMessageSize(4, (MessageLite) this.macro_.get(i3));
            }
            for (i3 = 0; i3 < this.tag_.size(); i3++) {
                i4 += CodedOutputStream.computeMessageSize(5, (MessageLite) this.tag_.get(i3));
            }
            for (i3 = 0; i3 < this.predicate_.size(); i3++) {
                i4 += CodedOutputStream.computeMessageSize(6, (MessageLite) this.predicate_.get(i3));
            }
            for (i3 = 0; i3 < this.rule_.size(); i3++) {
                i4 += CodedOutputStream.computeMessageSize(7, (MessageLite) this.rule_.get(i3));
            }
            if ((this.bitField0_ & 1) == 1) {
                i4 += CodedOutputStream.computeBytesSize(9, getPreviewAuthCodeBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                i4 += CodedOutputStream.computeBytesSize(10, getMalwareScanAuthCodeBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                i4 += CodedOutputStream.computeBytesSize(12, getTemplateVersionSetBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                i4 += CodedOutputStream.computeBytesSize(13, getVersionBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                i4 += CodedOutputStream.computeMessageSize(14, this.liveJsCacheOption_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i4 += CodedOutputStream.computeFloatSize(15, this.reportingSampleRate_);
            }
            i2 = 0;
            while (i < this.usageContext_.size()) {
                i2 += CodedOutputStream.computeBytesSizeNoTag(this.usageContext_.getByteString(i));
                i++;
            }
            i2 = (i2 + i4) + (getUsageContextList().size() * 2);
            if ((this.bitField0_ & 128) == 128) {
                i2 += CodedOutputStream.computeInt32Size(17, this.resourceFormatVersion_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i2 += CodedOutputStream.computeBoolSize(18, this.enableAutoEventTracking_);
            }
            i2 += this.unknownFields.size();
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public FunctionCall getTag(int i) {
            return (FunctionCall) this.tag_.get(i);
        }

        public int getTagCount() {
            return this.tag_.size();
        }

        public List getTagList() {
            return this.tag_;
        }

        public FunctionCallOrBuilder getTagOrBuilder(int i) {
            return (FunctionCallOrBuilder) this.tag_.get(i);
        }

        public List getTagOrBuilderList() {
            return this.tag_;
        }

        public String getTemplateVersionSet() {
            Object obj = this.templateVersionSet_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String toStringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.templateVersionSet_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public ByteString getTemplateVersionSetBytes() {
            Object obj = this.templateVersionSet_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.templateVersionSet_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public String getUsageContext(int i) {
            return (String) this.usageContext_.get(i);
        }

        public ByteString getUsageContextBytes(int i) {
            return this.usageContext_.getByteString(i);
        }

        public int getUsageContextCount() {
            return this.usageContext_.size();
        }

        public List getUsageContextList() {
            return this.usageContext_;
        }

        public Value getValue(int i) {
            return (Value) this.value_.get(i);
        }

        public int getValueCount() {
            return this.value_.size();
        }

        public List getValueList() {
            return this.value_;
        }

        public ValueOrBuilder getValueOrBuilder(int i) {
            return (ValueOrBuilder) this.value_.get(i);
        }

        public List getValueOrBuilderList() {
            return this.value_;
        }

        public String getVersion() {
            Object obj = this.version_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String toStringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.version_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public ByteString getVersionBytes() {
            Object obj = this.version_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.version_ = copyFromUtf8;
            return copyFromUtf8;
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
            }
            int hashCode = Resource.class.hashCode() + 779;
            if (getKeyCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getKeyList().hashCode();
            }
            if (getValueCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getValueList().hashCode();
            }
            if (getPropertyCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getPropertyList().hashCode();
            }
            if (getMacroCount() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + getMacroList().hashCode();
            }
            if (getTagCount() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + getTagList().hashCode();
            }
            if (getPredicateCount() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + getPredicateList().hashCode();
            }
            if (getRuleCount() > 0) {
                hashCode = (((hashCode * 37) + 7) * 53) + getRuleList().hashCode();
            }
            if (hasPreviewAuthCode()) {
                hashCode = (((hashCode * 37) + 9) * 53) + getPreviewAuthCode().hashCode();
            }
            if (hasMalwareScanAuthCode()) {
                hashCode = (((hashCode * 37) + 10) * 53) + getMalwareScanAuthCode().hashCode();
            }
            if (hasTemplateVersionSet()) {
                hashCode = (((hashCode * 37) + 12) * 53) + getTemplateVersionSet().hashCode();
            }
            if (hasVersion()) {
                hashCode = (((hashCode * 37) + 13) * 53) + getVersion().hashCode();
            }
            if (hasLiveJsCacheOption()) {
                hashCode = (((hashCode * 37) + 14) * 53) + getLiveJsCacheOption().hashCode();
            }
            if (hasReportingSampleRate()) {
                hashCode = (((hashCode * 37) + 15) * 53) + Float.floatToIntBits(getReportingSampleRate());
            }
            if (hasEnableAutoEventTracking()) {
                hashCode = (((hashCode * 37) + 18) * 53) + Internal.hashBoolean(getEnableAutoEventTracking());
            }
            if (getUsageContextCount() > 0) {
                hashCode = (((hashCode * 37) + 16) * 53) + getUsageContextList().hashCode();
            }
            if (hasResourceFormatVersion()) {
                hashCode = (((hashCode * 37) + 17) * 53) + getResourceFormatVersion();
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$Resource");
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
            }
            int i = 0;
            while (i < getValueCount()) {
                if (getValue(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getPropertyCount()) {
                if (getProperty(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getMacroCount()) {
                if (getMacro(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getTagCount()) {
                if (getTag(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            i = 0;
            while (i < getPredicateCount()) {
                if (getPredicate(i).isInitialized()) {
                    i++;
                } else {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
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
            int i;
            int i2 = 0;
            getSerializedSize();
            for (int i3 = 0; i3 < this.key_.size(); i3++) {
                codedOutputStream.writeBytes(1, this.key_.getByteString(i3));
            }
            for (i = 0; i < this.value_.size(); i++) {
                codedOutputStream.writeMessage(2, (MessageLite) this.value_.get(i));
            }
            for (i = 0; i < this.property_.size(); i++) {
                codedOutputStream.writeMessage(3, (MessageLite) this.property_.get(i));
            }
            for (i = 0; i < this.macro_.size(); i++) {
                codedOutputStream.writeMessage(4, (MessageLite) this.macro_.get(i));
            }
            for (i = 0; i < this.tag_.size(); i++) {
                codedOutputStream.writeMessage(5, (MessageLite) this.tag_.get(i));
            }
            for (i = 0; i < this.predicate_.size(); i++) {
                codedOutputStream.writeMessage(6, (MessageLite) this.predicate_.get(i));
            }
            for (i = 0; i < this.rule_.size(); i++) {
                codedOutputStream.writeMessage(7, (MessageLite) this.rule_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBytes(9, getPreviewAuthCodeBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(10, getMalwareScanAuthCodeBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(12, getTemplateVersionSetBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(13, getVersionBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessage(14, this.liveJsCacheOption_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeFloat(15, this.reportingSampleRate_);
            }
            while (i2 < this.usageContext_.size()) {
                codedOutputStream.writeBytes(16, this.usageContext_.getByteString(i2));
                i2++;
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeInt32(17, this.resourceFormatVersion_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeBool(18, this.enableAutoEventTracking_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    public enum ResourceState implements EnumLite {
        PREVIEW(0, 1),
        LIVE(1, 2);
        
        public static final int LIVE_VALUE = 2;
        public static final int PREVIEW_VALUE = 1;
        private static EnumLiteMap internalValueMap;
        private final int value;

        static {
            internalValueMap = new C0172w();
        }

        private ResourceState(int i, int i2) {
            this.value = i2;
        }

        public static EnumLiteMap internalGetValueMap() {
            return internalValueMap;
        }

        public static ResourceState valueOf(int i) {
            switch (i) {
                case 1:
                    return PREVIEW;
                case 2:
                    return LIVE;
                default:
                    return null;
            }
        }

        public final int getNumber() {
            return this.value;
        }
    }

    public enum ResourceType implements EnumLite {
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
        private static EnumLiteMap internalValueMap;
        private final int value;

        static {
            internalValueMap = new C0173x();
        }

        private ResourceType(int i, int i2) {
            this.value = i2;
        }

        public static EnumLiteMap internalGetValueMap() {
            return internalValueMap;
        }

        public static ResourceType valueOf(int i) {
            switch (i) {
                case 1:
                    return JS_RESOURCE;
                case 2:
                    return NS_RESOURCE;
                case 3:
                    return PIXEL_COLLECTION;
                case 4:
                    return SET_COOKIE;
                case 5:
                    return GET_COOKIE;
                case 6:
                    return CLEAR_CACHE;
                case 7:
                    return RAW_PROTO;
                default:
                    return null;
            }
        }

        public final int getNumber() {
            return this.value;
        }
    }

    public interface RuleOrBuilder extends MessageLiteOrBuilder {
        int getAddMacro(int i);

        int getAddMacroCount();

        List getAddMacroList();

        int getAddMacroRuleName(int i);

        int getAddMacroRuleNameCount();

        List getAddMacroRuleNameList();

        int getAddTag(int i);

        int getAddTagCount();

        List getAddTagList();

        int getAddTagRuleName(int i);

        int getAddTagRuleNameCount();

        List getAddTagRuleNameList();

        int getNegativePredicate(int i);

        int getNegativePredicateCount();

        List getNegativePredicateList();

        int getPositivePredicate(int i);

        int getPositivePredicateCount();

        List getPositivePredicateList();

        int getRemoveMacro(int i);

        int getRemoveMacroCount();

        List getRemoveMacroList();

        int getRemoveMacroRuleName(int i);

        int getRemoveMacroRuleNameCount();

        List getRemoveMacroRuleNameList();

        int getRemoveTag(int i);

        int getRemoveTagCount();

        List getRemoveTagList();

        int getRemoveTagRuleName(int i);

        int getRemoveTagRuleNameCount();

        List getRemoveTagRuleNameList();
    }

    public final class Rule extends GeneratedMessageLite implements RuleOrBuilder {
        public static final int ADD_MACRO_FIELD_NUMBER = 7;
        public static final int ADD_MACRO_RULE_NAME_FIELD_NUMBER = 9;
        public static final int ADD_TAG_FIELD_NUMBER = 3;
        public static final int ADD_TAG_RULE_NAME_FIELD_NUMBER = 5;
        public static final int NEGATIVE_PREDICATE_FIELD_NUMBER = 2;
        public static Parser PARSER = new C0174y();
        public static final int POSITIVE_PREDICATE_FIELD_NUMBER = 1;
        public static final int REMOVE_MACRO_FIELD_NUMBER = 8;
        public static final int REMOVE_MACRO_RULE_NAME_FIELD_NUMBER = 10;
        public static final int REMOVE_TAG_FIELD_NUMBER = 4;
        public static final int REMOVE_TAG_RULE_NAME_FIELD_NUMBER = 6;
        private static final Rule defaultInstance = new Rule(true);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private List addMacroRuleName_;
        private List addMacro_;
        private List addTagRuleName_;
        private List addTag_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List negativePredicate_;
        private List positivePredicate_;
        private List removeMacroRuleName_;
        private List removeMacro_;
        private List removeTagRuleName_;
        private List removeTag_;
        private final ByteString unknownFields;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements RuleOrBuilder {
            private List addMacroRuleName_ = Collections.emptyList();
            private List addMacro_ = Collections.emptyList();
            private List addTagRuleName_ = Collections.emptyList();
            private List addTag_ = Collections.emptyList();
            private int bitField0_;
            private List negativePredicate_ = Collections.emptyList();
            private List positivePredicate_ = Collections.emptyList();
            private List removeMacroRuleName_ = Collections.emptyList();
            private List removeMacro_ = Collections.emptyList();
            private List removeTagRuleName_ = Collections.emptyList();
            private List removeTag_ = Collections.emptyList();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureAddMacroIsMutable() {
                if ((this.bitField0_ & 64) != 64) {
                    this.addMacro_ = new ArrayList(this.addMacro_);
                    this.bitField0_ |= 64;
                }
            }

            private void ensureAddMacroRuleNameIsMutable() {
                if ((this.bitField0_ & Policy.LICENSED) != Policy.LICENSED) {
                    this.addMacroRuleName_ = new ArrayList(this.addMacroRuleName_);
                    this.bitField0_ |= Policy.LICENSED;
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

            public Builder addAddMacro(int i) {
                ensureAddMacroIsMutable();
                this.addMacro_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAddMacroRuleName(int i) {
                ensureAddMacroRuleNameIsMutable();
                this.addMacroRuleName_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAddTag(int i) {
                ensureAddTagIsMutable();
                this.addTag_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAddTagRuleName(int i) {
                ensureAddTagRuleNameIsMutable();
                this.addTagRuleName_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addAllAddMacro(Iterable iterable) {
                ensureAddMacroIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.addMacro_);
                return this;
            }

            public Builder addAllAddMacroRuleName(Iterable iterable) {
                ensureAddMacroRuleNameIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.addMacroRuleName_);
                return this;
            }

            public Builder addAllAddTag(Iterable iterable) {
                ensureAddTagIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.addTag_);
                return this;
            }

            public Builder addAllAddTagRuleName(Iterable iterable) {
                ensureAddTagRuleNameIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.addTagRuleName_);
                return this;
            }

            public Builder addAllNegativePredicate(Iterable iterable) {
                ensureNegativePredicateIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.negativePredicate_);
                return this;
            }

            public Builder addAllPositivePredicate(Iterable iterable) {
                ensurePositivePredicateIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.positivePredicate_);
                return this;
            }

            public Builder addAllRemoveMacro(Iterable iterable) {
                ensureRemoveMacroIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.removeMacro_);
                return this;
            }

            public Builder addAllRemoveMacroRuleName(Iterable iterable) {
                ensureRemoveMacroRuleNameIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.removeMacroRuleName_);
                return this;
            }

            public Builder addAllRemoveTag(Iterable iterable) {
                ensureRemoveTagIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.removeTag_);
                return this;
            }

            public Builder addAllRemoveTagRuleName(Iterable iterable) {
                ensureRemoveTagRuleNameIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.removeTagRuleName_);
                return this;
            }

            public Builder addNegativePredicate(int i) {
                ensureNegativePredicateIsMutable();
                this.negativePredicate_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addPositivePredicate(int i) {
                ensurePositivePredicateIsMutable();
                this.positivePredicate_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addRemoveMacro(int i) {
                ensureRemoveMacroIsMutable();
                this.removeMacro_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addRemoveMacroRuleName(int i) {
                ensureRemoveMacroRuleNameIsMutable();
                this.removeMacroRuleName_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addRemoveTag(int i) {
                ensureRemoveTagIsMutable();
                this.removeTag_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addRemoveTagRuleName(int i) {
                ensureRemoveTagRuleNameIsMutable();
                this.removeTagRuleName_.add(Integer.valueOf(i));
                return this;
            }

            public Rule build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public Rule buildPartial() {
                Rule rule = new Rule((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.positivePredicate_ = Collections.unmodifiableList(this.positivePredicate_);
                    this.bitField0_ &= -2;
                }
                rule.positivePredicate_ = this.positivePredicate_;
                if ((this.bitField0_ & 2) == 2) {
                    this.negativePredicate_ = Collections.unmodifiableList(this.negativePredicate_);
                    this.bitField0_ &= -3;
                }
                rule.negativePredicate_ = this.negativePredicate_;
                if ((this.bitField0_ & 4) == 4) {
                    this.addTag_ = Collections.unmodifiableList(this.addTag_);
                    this.bitField0_ &= -5;
                }
                rule.addTag_ = this.addTag_;
                if ((this.bitField0_ & 8) == 8) {
                    this.removeTag_ = Collections.unmodifiableList(this.removeTag_);
                    this.bitField0_ &= -9;
                }
                rule.removeTag_ = this.removeTag_;
                if ((this.bitField0_ & 16) == 16) {
                    this.addTagRuleName_ = Collections.unmodifiableList(this.addTagRuleName_);
                    this.bitField0_ &= -17;
                }
                rule.addTagRuleName_ = this.addTagRuleName_;
                if ((this.bitField0_ & 32) == 32) {
                    this.removeTagRuleName_ = Collections.unmodifiableList(this.removeTagRuleName_);
                    this.bitField0_ &= -33;
                }
                rule.removeTagRuleName_ = this.removeTagRuleName_;
                if ((this.bitField0_ & 64) == 64) {
                    this.addMacro_ = Collections.unmodifiableList(this.addMacro_);
                    this.bitField0_ &= -65;
                }
                rule.addMacro_ = this.addMacro_;
                if ((this.bitField0_ & 128) == 128) {
                    this.removeMacro_ = Collections.unmodifiableList(this.removeMacro_);
                    this.bitField0_ &= -129;
                }
                rule.removeMacro_ = this.removeMacro_;
                if ((this.bitField0_ & Policy.LICENSED) == Policy.LICENSED) {
                    this.addMacroRuleName_ = Collections.unmodifiableList(this.addMacroRuleName_);
                    this.bitField0_ &= -257;
                }
                rule.addMacroRuleName_ = this.addMacroRuleName_;
                if ((this.bitField0_ & 512) == 512) {
                    this.removeMacroRuleName_ = Collections.unmodifiableList(this.removeMacroRuleName_);
                    this.bitField0_ &= -513;
                }
                rule.removeMacroRuleName_ = this.removeMacroRuleName_;
                return rule;
            }

            public Builder clear() {
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

            public Builder clearAddMacro() {
                this.addMacro_ = Collections.emptyList();
                this.bitField0_ &= -65;
                return this;
            }

            public Builder clearAddMacroRuleName() {
                this.addMacroRuleName_ = Collections.emptyList();
                this.bitField0_ &= -257;
                return this;
            }

            public Builder clearAddTag() {
                this.addTag_ = Collections.emptyList();
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clearAddTagRuleName() {
                this.addTagRuleName_ = Collections.emptyList();
                this.bitField0_ &= -17;
                return this;
            }

            public Builder clearNegativePredicate() {
                this.negativePredicate_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearPositivePredicate() {
                this.positivePredicate_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clearRemoveMacro() {
                this.removeMacro_ = Collections.emptyList();
                this.bitField0_ &= -129;
                return this;
            }

            public Builder clearRemoveMacroRuleName() {
                this.removeMacroRuleName_ = Collections.emptyList();
                this.bitField0_ &= -513;
                return this;
            }

            public Builder clearRemoveTag() {
                this.removeTag_ = Collections.emptyList();
                this.bitField0_ &= -9;
                return this;
            }

            public Builder clearRemoveTagRuleName() {
                this.removeTagRuleName_ = Collections.emptyList();
                this.bitField0_ &= -33;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public int getAddMacro(int i) {
                return ((Integer) this.addMacro_.get(i)).intValue();
            }

            public int getAddMacroCount() {
                return this.addMacro_.size();
            }

            public List getAddMacroList() {
                return Collections.unmodifiableList(this.addMacro_);
            }

            public int getAddMacroRuleName(int i) {
                return ((Integer) this.addMacroRuleName_.get(i)).intValue();
            }

            public int getAddMacroRuleNameCount() {
                return this.addMacroRuleName_.size();
            }

            public List getAddMacroRuleNameList() {
                return Collections.unmodifiableList(this.addMacroRuleName_);
            }

            public int getAddTag(int i) {
                return ((Integer) this.addTag_.get(i)).intValue();
            }

            public int getAddTagCount() {
                return this.addTag_.size();
            }

            public List getAddTagList() {
                return Collections.unmodifiableList(this.addTag_);
            }

            public int getAddTagRuleName(int i) {
                return ((Integer) this.addTagRuleName_.get(i)).intValue();
            }

            public int getAddTagRuleNameCount() {
                return this.addTagRuleName_.size();
            }

            public List getAddTagRuleNameList() {
                return Collections.unmodifiableList(this.addTagRuleName_);
            }

            public Rule getDefaultInstanceForType() {
                return Rule.getDefaultInstance();
            }

            public int getNegativePredicate(int i) {
                return ((Integer) this.negativePredicate_.get(i)).intValue();
            }

            public int getNegativePredicateCount() {
                return this.negativePredicate_.size();
            }

            public List getNegativePredicateList() {
                return Collections.unmodifiableList(this.negativePredicate_);
            }

            public int getPositivePredicate(int i) {
                return ((Integer) this.positivePredicate_.get(i)).intValue();
            }

            public int getPositivePredicateCount() {
                return this.positivePredicate_.size();
            }

            public List getPositivePredicateList() {
                return Collections.unmodifiableList(this.positivePredicate_);
            }

            public int getRemoveMacro(int i) {
                return ((Integer) this.removeMacro_.get(i)).intValue();
            }

            public int getRemoveMacroCount() {
                return this.removeMacro_.size();
            }

            public List getRemoveMacroList() {
                return Collections.unmodifiableList(this.removeMacro_);
            }

            public int getRemoveMacroRuleName(int i) {
                return ((Integer) this.removeMacroRuleName_.get(i)).intValue();
            }

            public int getRemoveMacroRuleNameCount() {
                return this.removeMacroRuleName_.size();
            }

            public List getRemoveMacroRuleNameList() {
                return Collections.unmodifiableList(this.removeMacroRuleName_);
            }

            public int getRemoveTag(int i) {
                return ((Integer) this.removeTag_.get(i)).intValue();
            }

            public int getRemoveTagCount() {
                return this.removeTag_.size();
            }

            public List getRemoveTagList() {
                return Collections.unmodifiableList(this.removeTag_);
            }

            public int getRemoveTagRuleName(int i) {
                return ((Integer) this.removeTagRuleName_.get(i)).intValue();
            }

            public int getRemoveTagRuleNameCount() {
                return this.removeTagRuleName_.size();
            }

            public List getRemoveTagRuleNameList() {
                return Collections.unmodifiableList(this.removeTagRuleName_);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Rule rule) {
                if (rule != Rule.getDefaultInstance()) {
                    if (!rule.positivePredicate_.isEmpty()) {
                        if (this.positivePredicate_.isEmpty()) {
                            this.positivePredicate_ = rule.positivePredicate_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePositivePredicateIsMutable();
                            this.positivePredicate_.addAll(rule.positivePredicate_);
                        }
                    }
                    if (!rule.negativePredicate_.isEmpty()) {
                        if (this.negativePredicate_.isEmpty()) {
                            this.negativePredicate_ = rule.negativePredicate_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureNegativePredicateIsMutable();
                            this.negativePredicate_.addAll(rule.negativePredicate_);
                        }
                    }
                    if (!rule.addTag_.isEmpty()) {
                        if (this.addTag_.isEmpty()) {
                            this.addTag_ = rule.addTag_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureAddTagIsMutable();
                            this.addTag_.addAll(rule.addTag_);
                        }
                    }
                    if (!rule.removeTag_.isEmpty()) {
                        if (this.removeTag_.isEmpty()) {
                            this.removeTag_ = rule.removeTag_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureRemoveTagIsMutable();
                            this.removeTag_.addAll(rule.removeTag_);
                        }
                    }
                    if (!rule.addTagRuleName_.isEmpty()) {
                        if (this.addTagRuleName_.isEmpty()) {
                            this.addTagRuleName_ = rule.addTagRuleName_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureAddTagRuleNameIsMutable();
                            this.addTagRuleName_.addAll(rule.addTagRuleName_);
                        }
                    }
                    if (!rule.removeTagRuleName_.isEmpty()) {
                        if (this.removeTagRuleName_.isEmpty()) {
                            this.removeTagRuleName_ = rule.removeTagRuleName_;
                            this.bitField0_ &= -33;
                        } else {
                            ensureRemoveTagRuleNameIsMutable();
                            this.removeTagRuleName_.addAll(rule.removeTagRuleName_);
                        }
                    }
                    if (!rule.addMacro_.isEmpty()) {
                        if (this.addMacro_.isEmpty()) {
                            this.addMacro_ = rule.addMacro_;
                            this.bitField0_ &= -65;
                        } else {
                            ensureAddMacroIsMutable();
                            this.addMacro_.addAll(rule.addMacro_);
                        }
                    }
                    if (!rule.removeMacro_.isEmpty()) {
                        if (this.removeMacro_.isEmpty()) {
                            this.removeMacro_ = rule.removeMacro_;
                            this.bitField0_ &= -129;
                        } else {
                            ensureRemoveMacroIsMutable();
                            this.removeMacro_.addAll(rule.removeMacro_);
                        }
                    }
                    if (!rule.addMacroRuleName_.isEmpty()) {
                        if (this.addMacroRuleName_.isEmpty()) {
                            this.addMacroRuleName_ = rule.addMacroRuleName_;
                            this.bitField0_ &= -257;
                        } else {
                            ensureAddMacroRuleNameIsMutable();
                            this.addMacroRuleName_.addAll(rule.addMacroRuleName_);
                        }
                    }
                    if (!rule.removeMacroRuleName_.isEmpty()) {
                        if (this.removeMacroRuleName_.isEmpty()) {
                            this.removeMacroRuleName_ = rule.removeMacroRuleName_;
                            this.bitField0_ &= -513;
                        } else {
                            ensureRemoveMacroRuleNameIsMutable();
                            this.removeMacroRuleName_.addAll(rule.removeMacroRuleName_);
                        }
                    }
                    setUnknownFields(getUnknownFields().concat(rule.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                Rule rule;
                Rule rule2;
                try {
                    rule2 = (Rule) Rule.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (rule2 != null) {
                        mergeFrom(rule2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    rule2 = (Rule) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    rule = rule2;
                    th = th3;
                }
                if (rule != null) {
                    mergeFrom(rule);
                }
                throw th;
            }

            public Builder setAddMacro(int i, int i2) {
                ensureAddMacroIsMutable();
                this.addMacro_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder setAddMacroRuleName(int i, int i2) {
                ensureAddMacroRuleNameIsMutable();
                this.addMacroRuleName_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder setAddTag(int i, int i2) {
                ensureAddTagIsMutable();
                this.addTag_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder setAddTagRuleName(int i, int i2) {
                ensureAddTagRuleNameIsMutable();
                this.addTagRuleName_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder setNegativePredicate(int i, int i2) {
                ensureNegativePredicateIsMutable();
                this.negativePredicate_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder setPositivePredicate(int i, int i2) {
                ensurePositivePredicateIsMutable();
                this.positivePredicate_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder setRemoveMacro(int i, int i2) {
                ensureRemoveMacroIsMutable();
                this.removeMacro_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder setRemoveMacroRuleName(int i, int i2) {
                ensureRemoveMacroRuleNameIsMutable();
                this.removeMacroRuleName_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder setRemoveTag(int i, int i2) {
                ensureRemoveTagIsMutable();
                this.removeTag_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder setRemoveTagRuleName(int i, int i2) {
                ensureRemoveTagRuleNameIsMutable();
                this.removeTagRuleName_.set(i, Integer.valueOf(i2));
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

        private Rule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int i = 0;
            OutputStream newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
            Object obj = null;
            while (obj == null) {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            obj = 1;
                            break;
                        case 8:
                            if ((i & 1) != 1) {
                                this.positivePredicate_ = new ArrayList();
                                i |= 1;
                            }
                            this.positivePredicate_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 10:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 1) != 1 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.positivePredicate_ = new ArrayList();
                                i |= 1;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.positivePredicate_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 16:
                            if ((i & 2) != 2) {
                                this.negativePredicate_ = new ArrayList();
                                i |= 2;
                            }
                            this.negativePredicate_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 18:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 2) != 2 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.negativePredicate_ = new ArrayList();
                                i |= 2;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.negativePredicate_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 24:
                            if ((i & 4) != 4) {
                                this.addTag_ = new ArrayList();
                                i |= 4;
                            }
                            this.addTag_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 26:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 4) != 4 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.addTag_ = new ArrayList();
                                i |= 4;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.addTag_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 32:
                            if ((i & 8) != 8) {
                                this.removeTag_ = new ArrayList();
                                i |= 8;
                            }
                            this.removeTag_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 34:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 8) != 8 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.removeTag_ = new ArrayList();
                                i |= 8;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.removeTag_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 40:
                            if ((i & 16) != 16) {
                                this.addTagRuleName_ = new ArrayList();
                                i |= 16;
                            }
                            this.addTagRuleName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 42:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 16) != 16 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.addTagRuleName_ = new ArrayList();
                                i |= 16;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.addTagRuleName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 48:
                            if ((i & 32) != 32) {
                                this.removeTagRuleName_ = new ArrayList();
                                i |= 32;
                            }
                            this.removeTagRuleName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 50:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 32) != 32 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.removeTagRuleName_ = new ArrayList();
                                i |= 32;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.removeTagRuleName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 56:
                            if ((i & 64) != 64) {
                                this.addMacro_ = new ArrayList();
                                i |= 64;
                            }
                            this.addMacro_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 58:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 64) != 64 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.addMacro_ = new ArrayList();
                                i |= 64;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.addMacro_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 64:
                            if ((i & 128) != 128) {
                                this.removeMacro_ = new ArrayList();
                                i |= 128;
                            }
                            this.removeMacro_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 66:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 128) != 128 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.removeMacro_ = new ArrayList();
                                i |= 128;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.removeMacro_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 72:
                            if ((i & Policy.LICENSED) != Policy.LICENSED) {
                                this.addMacroRuleName_ = new ArrayList();
                                i |= Policy.LICENSED;
                            }
                            this.addMacroRuleName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 74:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & Policy.LICENSED) != Policy.LICENSED && codedInputStream.getBytesUntilLimit() > 0) {
                                this.addMacroRuleName_ = new ArrayList();
                                i |= Policy.LICENSED;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.addMacroRuleName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 80:
                            if ((i & 512) != 512) {
                                this.removeMacroRuleName_ = new ArrayList();
                                i |= 512;
                            }
                            this.removeMacroRuleName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 82:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 512) != 512 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.removeMacroRuleName_ = new ArrayList();
                                i |= 512;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.removeMacroRuleName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if ((i & 1) == 1) {
                        this.positivePredicate_ = Collections.unmodifiableList(this.positivePredicate_);
                    }
                    if ((i & 2) == 2) {
                        this.negativePredicate_ = Collections.unmodifiableList(this.negativePredicate_);
                    }
                    if ((i & 4) == 4) {
                        this.addTag_ = Collections.unmodifiableList(this.addTag_);
                    }
                    if ((i & 8) == 8) {
                        this.removeTag_ = Collections.unmodifiableList(this.removeTag_);
                    }
                    if ((i & 16) == 16) {
                        this.addTagRuleName_ = Collections.unmodifiableList(this.addTagRuleName_);
                    }
                    if ((i & 32) == 32) {
                        this.removeTagRuleName_ = Collections.unmodifiableList(this.removeTagRuleName_);
                    }
                    if ((i & 64) == 64) {
                        this.addMacro_ = Collections.unmodifiableList(this.addMacro_);
                    }
                    if ((i & 128) == 128) {
                        this.removeMacro_ = Collections.unmodifiableList(this.removeMacro_);
                    }
                    if ((i & Policy.LICENSED) == Policy.LICENSED) {
                        this.addMacroRuleName_ = Collections.unmodifiableList(this.addMacroRuleName_);
                    }
                    if ((i & 512) == 512) {
                        this.removeMacroRuleName_ = Collections.unmodifiableList(this.removeMacroRuleName_);
                    }
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
            if ((i & 1) == 1) {
                this.positivePredicate_ = Collections.unmodifiableList(this.positivePredicate_);
            }
            if ((i & 2) == 2) {
                this.negativePredicate_ = Collections.unmodifiableList(this.negativePredicate_);
            }
            if ((i & 4) == 4) {
                this.addTag_ = Collections.unmodifiableList(this.addTag_);
            }
            if ((i & 8) == 8) {
                this.removeTag_ = Collections.unmodifiableList(this.removeTag_);
            }
            if ((i & 16) == 16) {
                this.addTagRuleName_ = Collections.unmodifiableList(this.addTagRuleName_);
            }
            if ((i & 32) == 32) {
                this.removeTagRuleName_ = Collections.unmodifiableList(this.removeTagRuleName_);
            }
            if ((i & 64) == 64) {
                this.addMacro_ = Collections.unmodifiableList(this.addMacro_);
            }
            if ((i & 128) == 128) {
                this.removeMacro_ = Collections.unmodifiableList(this.removeMacro_);
            }
            if ((i & Policy.LICENSED) == Policy.LICENSED) {
                this.addMacroRuleName_ = Collections.unmodifiableList(this.addMacroRuleName_);
            }
            if ((i & 512) == 512) {
                this.removeMacroRuleName_ = Collections.unmodifiableList(this.removeMacroRuleName_);
            }
            try {
                newInstance.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = newOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        private Rule(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Rule(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Rule getDefaultInstance() {
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

        public static Builder newBuilder(Rule rule) {
            return newBuilder().mergeFrom(rule);
        }

        public static Rule parseDelimitedFrom(InputStream inputStream) {
            return (Rule) PARSER.parseDelimitedFrom(inputStream);
        }

        public static Rule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Rule) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Rule parseFrom(ByteString byteString) {
            return (Rule) PARSER.parseFrom(byteString);
        }

        public static Rule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Rule) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Rule parseFrom(CodedInputStream codedInputStream) {
            return (Rule) PARSER.parseFrom(codedInputStream);
        }

        public static Rule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Rule) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Rule parseFrom(InputStream inputStream) {
            return (Rule) PARSER.parseFrom(inputStream);
        }

        public static Rule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Rule) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Rule parseFrom(byte[] bArr) {
            return (Rule) PARSER.parseFrom(bArr);
        }

        public static Rule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Rule) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Rule)) {
                return super.equals(obj);
            }
            Rule rule = (Rule) obj;
            boolean z = (getPositivePredicateList().equals(rule.getPositivePredicateList())) && getNegativePredicateList().equals(rule.getNegativePredicateList());
            z = z && getAddTagList().equals(rule.getAddTagList());
            z = z && getRemoveTagList().equals(rule.getRemoveTagList());
            z = z && getAddTagRuleNameList().equals(rule.getAddTagRuleNameList());
            z = z && getRemoveTagRuleNameList().equals(rule.getRemoveTagRuleNameList());
            z = z && getAddMacroList().equals(rule.getAddMacroList());
            z = z && getRemoveMacroList().equals(rule.getRemoveMacroList());
            z = z && getAddMacroRuleNameList().equals(rule.getAddMacroRuleNameList());
            return z && getRemoveMacroRuleNameList().equals(rule.getRemoveMacroRuleNameList());
        }

        public int getAddMacro(int i) {
            return ((Integer) this.addMacro_.get(i)).intValue();
        }

        public int getAddMacroCount() {
            return this.addMacro_.size();
        }

        public List getAddMacroList() {
            return this.addMacro_;
        }

        public int getAddMacroRuleName(int i) {
            return ((Integer) this.addMacroRuleName_.get(i)).intValue();
        }

        public int getAddMacroRuleNameCount() {
            return this.addMacroRuleName_.size();
        }

        public List getAddMacroRuleNameList() {
            return this.addMacroRuleName_;
        }

        public int getAddTag(int i) {
            return ((Integer) this.addTag_.get(i)).intValue();
        }

        public int getAddTagCount() {
            return this.addTag_.size();
        }

        public List getAddTagList() {
            return this.addTag_;
        }

        public int getAddTagRuleName(int i) {
            return ((Integer) this.addTagRuleName_.get(i)).intValue();
        }

        public int getAddTagRuleNameCount() {
            return this.addTagRuleName_.size();
        }

        public List getAddTagRuleNameList() {
            return this.addTagRuleName_;
        }

        public Rule getDefaultInstanceForType() {
            return defaultInstance;
        }

        public int getNegativePredicate(int i) {
            return ((Integer) this.negativePredicate_.get(i)).intValue();
        }

        public int getNegativePredicateCount() {
            return this.negativePredicate_.size();
        }

        public List getNegativePredicateList() {
            return this.negativePredicate_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public int getPositivePredicate(int i) {
            return ((Integer) this.positivePredicate_.get(i)).intValue();
        }

        public int getPositivePredicateCount() {
            return this.positivePredicate_.size();
        }

        public List getPositivePredicateList() {
            return this.positivePredicate_;
        }

        public int getRemoveMacro(int i) {
            return ((Integer) this.removeMacro_.get(i)).intValue();
        }

        public int getRemoveMacroCount() {
            return this.removeMacro_.size();
        }

        public List getRemoveMacroList() {
            return this.removeMacro_;
        }

        public int getRemoveMacroRuleName(int i) {
            return ((Integer) this.removeMacroRuleName_.get(i)).intValue();
        }

        public int getRemoveMacroRuleNameCount() {
            return this.removeMacroRuleName_.size();
        }

        public List getRemoveMacroRuleNameList() {
            return this.removeMacroRuleName_;
        }

        public int getRemoveTag(int i) {
            return ((Integer) this.removeTag_.get(i)).intValue();
        }

        public int getRemoveTagCount() {
            return this.removeTag_.size();
        }

        public List getRemoveTagList() {
            return this.removeTag_;
        }

        public int getRemoveTagRuleName(int i) {
            return ((Integer) this.removeTagRuleName_.get(i)).intValue();
        }

        public int getRemoveTagRuleNameCount() {
            return this.removeTagRuleName_.size();
        }

        public List getRemoveTagRuleNameList() {
            return this.removeTagRuleName_;
        }

        public int getSerializedSize() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3;
            int i4 = 0;
            for (i3 = 0; i3 < this.positivePredicate_.size(); i3++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.positivePredicate_.get(i3)).intValue());
            }
            int size = (0 + i4) + (getPositivePredicateList().size() * 1);
            i4 = 0;
            for (i3 = 0; i3 < this.negativePredicate_.size(); i3++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.negativePredicate_.get(i3)).intValue());
            }
            size = (size + i4) + (getNegativePredicateList().size() * 1);
            i4 = 0;
            for (i3 = 0; i3 < this.addTag_.size(); i3++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.addTag_.get(i3)).intValue());
            }
            size = (size + i4) + (getAddTagList().size() * 1);
            i4 = 0;
            for (i3 = 0; i3 < this.removeTag_.size(); i3++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.removeTag_.get(i3)).intValue());
            }
            size = (size + i4) + (getRemoveTagList().size() * 1);
            i4 = 0;
            for (i3 = 0; i3 < this.addTagRuleName_.size(); i3++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.addTagRuleName_.get(i3)).intValue());
            }
            size = (size + i4) + (getAddTagRuleNameList().size() * 1);
            i4 = 0;
            for (i3 = 0; i3 < this.removeTagRuleName_.size(); i3++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.removeTagRuleName_.get(i3)).intValue());
            }
            size = (size + i4) + (getRemoveTagRuleNameList().size() * 1);
            i4 = 0;
            for (i3 = 0; i3 < this.addMacro_.size(); i3++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.addMacro_.get(i3)).intValue());
            }
            size = (size + i4) + (getAddMacroList().size() * 1);
            i4 = 0;
            for (i3 = 0; i3 < this.removeMacro_.size(); i3++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.removeMacro_.get(i3)).intValue());
            }
            size = (size + i4) + (getRemoveMacroList().size() * 1);
            i4 = 0;
            for (i3 = 0; i3 < this.addMacroRuleName_.size(); i3++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.addMacroRuleName_.get(i3)).intValue());
            }
            i4 = (size + i4) + (getAddMacroRuleNameList().size() * 1);
            i3 = 0;
            while (i < this.removeMacroRuleName_.size()) {
                i++;
                i3 = CodedOutputStream.computeInt32SizeNoTag(((Integer) this.removeMacroRuleName_.get(i)).intValue()) + i3;
            }
            i2 = ((i4 + i3) + (getRemoveMacroRuleNameList().size() * 1)) + this.unknownFields.size();
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = Rule.class.hashCode() + 779;
            if (getPositivePredicateCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getPositivePredicateList().hashCode();
            }
            if (getNegativePredicateCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getNegativePredicateList().hashCode();
            }
            if (getAddTagCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getAddTagList().hashCode();
            }
            if (getRemoveTagCount() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + getRemoveTagList().hashCode();
            }
            if (getAddTagRuleNameCount() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + getAddTagRuleNameList().hashCode();
            }
            if (getRemoveTagRuleNameCount() > 0) {
                hashCode = (((hashCode * 37) + 6) * 53) + getRemoveTagRuleNameList().hashCode();
            }
            if (getAddMacroCount() > 0) {
                hashCode = (((hashCode * 37) + 7) * 53) + getAddMacroList().hashCode();
            }
            if (getRemoveMacroCount() > 0) {
                hashCode = (((hashCode * 37) + 8) * 53) + getRemoveMacroList().hashCode();
            }
            if (getAddMacroRuleNameCount() > 0) {
                hashCode = (((hashCode * 37) + 9) * 53) + getAddMacroRuleNameList().hashCode();
            }
            if (getRemoveMacroRuleNameCount() > 0) {
                hashCode = (((hashCode * 37) + 10) * 53) + getRemoveMacroRuleNameList().hashCode();
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$Rule");
            }
            return mutableDefault;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                return b == (byte) 1;
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

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) {
            int i;
            int i2 = 0;
            getSerializedSize();
            for (i = 0; i < this.positivePredicate_.size(); i++) {
                codedOutputStream.writeInt32(1, ((Integer) this.positivePredicate_.get(i)).intValue());
            }
            for (i = 0; i < this.negativePredicate_.size(); i++) {
                codedOutputStream.writeInt32(2, ((Integer) this.negativePredicate_.get(i)).intValue());
            }
            for (i = 0; i < this.addTag_.size(); i++) {
                codedOutputStream.writeInt32(3, ((Integer) this.addTag_.get(i)).intValue());
            }
            for (i = 0; i < this.removeTag_.size(); i++) {
                codedOutputStream.writeInt32(4, ((Integer) this.removeTag_.get(i)).intValue());
            }
            for (i = 0; i < this.addTagRuleName_.size(); i++) {
                codedOutputStream.writeInt32(5, ((Integer) this.addTagRuleName_.get(i)).intValue());
            }
            for (i = 0; i < this.removeTagRuleName_.size(); i++) {
                codedOutputStream.writeInt32(6, ((Integer) this.removeTagRuleName_.get(i)).intValue());
            }
            for (i = 0; i < this.addMacro_.size(); i++) {
                codedOutputStream.writeInt32(7, ((Integer) this.addMacro_.get(i)).intValue());
            }
            for (i = 0; i < this.removeMacro_.size(); i++) {
                codedOutputStream.writeInt32(8, ((Integer) this.removeMacro_.get(i)).intValue());
            }
            for (i = 0; i < this.addMacroRuleName_.size(); i++) {
                codedOutputStream.writeInt32(9, ((Integer) this.addMacroRuleName_.get(i)).intValue());
            }
            while (i2 < this.removeMacroRuleName_.size()) {
                codedOutputStream.writeInt32(10, ((Integer) this.removeMacroRuleName_.get(i2)).intValue());
                i2++;
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    public interface ServingValueOrBuilder extends MessageLiteOrBuilder {
        int getListItem(int i);

        int getListItemCount();

        List getListItemList();

        int getMacroNameReference();

        int getMacroReference();

        int getMapKey(int i);

        int getMapKeyCount();

        List getMapKeyList();

        int getMapValue(int i);

        int getMapValueCount();

        List getMapValueList();

        int getTemplateToken(int i);

        int getTemplateTokenCount();

        List getTemplateTokenList();

        boolean hasMacroNameReference();

        boolean hasMacroReference();
    }

    public final class ServingValue extends GeneratedMessageLite implements ServingValueOrBuilder {
        public static final int EXT_FIELD_NUMBER = 101;
        public static final int LIST_ITEM_FIELD_NUMBER = 1;
        public static final int MACRO_NAME_REFERENCE_FIELD_NUMBER = 6;
        public static final int MACRO_REFERENCE_FIELD_NUMBER = 4;
        public static final int MAP_KEY_FIELD_NUMBER = 2;
        public static final int MAP_VALUE_FIELD_NUMBER = 3;
        public static Parser PARSER = new C0175z();
        public static final int TEMPLATE_TOKEN_FIELD_NUMBER = 5;
        private static final ServingValue defaultInstance = new ServingValue(true);
        public static final GeneratedExtension ext = GeneratedMessageLite.newSingularGeneratedExtension(Value.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, 101, FieldType.MESSAGE, ServingValue.class);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List listItem_;
        private int macroNameReference_;
        private int macroReference_;
        private List mapKey_;
        private List mapValue_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List templateToken_;
        private final ByteString unknownFields;

        public final class Builder extends com.google.tagmanager.protobuf.GeneratedMessageLite.Builder implements ServingValueOrBuilder {
            private int bitField0_;
            private List listItem_ = Collections.emptyList();
            private int macroNameReference_;
            private int macroReference_;
            private List mapKey_ = Collections.emptyList();
            private List mapValue_ = Collections.emptyList();
            private List templateToken_ = Collections.emptyList();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
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

            public Builder addAllListItem(Iterable iterable) {
                ensureListItemIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.listItem_);
                return this;
            }

            public Builder addAllMapKey(Iterable iterable) {
                ensureMapKeyIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.mapKey_);
                return this;
            }

            public Builder addAllMapValue(Iterable iterable) {
                ensureMapValueIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.mapValue_);
                return this;
            }

            public Builder addAllTemplateToken(Iterable iterable) {
                ensureTemplateTokenIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.templateToken_);
                return this;
            }

            public Builder addListItem(int i) {
                ensureListItemIsMutable();
                this.listItem_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addMapKey(int i) {
                ensureMapKeyIsMutable();
                this.mapKey_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addMapValue(int i) {
                ensureMapValueIsMutable();
                this.mapValue_.add(Integer.valueOf(i));
                return this;
            }

            public Builder addTemplateToken(int i) {
                ensureTemplateTokenIsMutable();
                this.templateToken_.add(Integer.valueOf(i));
                return this;
            }

            public ServingValue build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public ServingValue buildPartial() {
                int i = 1;
                ServingValue servingValue = new ServingValue((com.google.tagmanager.protobuf.GeneratedMessageLite.Builder) this);
                int i2 = this.bitField0_;
                if ((this.bitField0_ & 1) == 1) {
                    this.listItem_ = Collections.unmodifiableList(this.listItem_);
                    this.bitField0_ &= -2;
                }
                servingValue.listItem_ = this.listItem_;
                if ((this.bitField0_ & 2) == 2) {
                    this.mapKey_ = Collections.unmodifiableList(this.mapKey_);
                    this.bitField0_ &= -3;
                }
                servingValue.mapKey_ = this.mapKey_;
                if ((this.bitField0_ & 4) == 4) {
                    this.mapValue_ = Collections.unmodifiableList(this.mapValue_);
                    this.bitField0_ &= -5;
                }
                servingValue.mapValue_ = this.mapValue_;
                if ((i2 & 8) != 8) {
                    i = 0;
                }
                servingValue.macroReference_ = this.macroReference_;
                if ((this.bitField0_ & 16) == 16) {
                    this.templateToken_ = Collections.unmodifiableList(this.templateToken_);
                    this.bitField0_ &= -17;
                }
                servingValue.templateToken_ = this.templateToken_;
                if ((i2 & 32) == 32) {
                    i |= 2;
                }
                servingValue.macroNameReference_ = this.macroNameReference_;
                servingValue.bitField0_ = i;
                return servingValue;
            }

            public Builder clear() {
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

            public Builder clearListItem() {
                this.listItem_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clearMacroNameReference() {
                this.bitField0_ &= -33;
                this.macroNameReference_ = 0;
                return this;
            }

            public Builder clearMacroReference() {
                this.bitField0_ &= -9;
                this.macroReference_ = 0;
                return this;
            }

            public Builder clearMapKey() {
                this.mapKey_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearMapValue() {
                this.mapValue_ = Collections.emptyList();
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clearTemplateToken() {
                this.templateToken_ = Collections.emptyList();
                this.bitField0_ &= -17;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public ServingValue getDefaultInstanceForType() {
                return ServingValue.getDefaultInstance();
            }

            public int getListItem(int i) {
                return ((Integer) this.listItem_.get(i)).intValue();
            }

            public int getListItemCount() {
                return this.listItem_.size();
            }

            public List getListItemList() {
                return Collections.unmodifiableList(this.listItem_);
            }

            public int getMacroNameReference() {
                return this.macroNameReference_;
            }

            public int getMacroReference() {
                return this.macroReference_;
            }

            public int getMapKey(int i) {
                return ((Integer) this.mapKey_.get(i)).intValue();
            }

            public int getMapKeyCount() {
                return this.mapKey_.size();
            }

            public List getMapKeyList() {
                return Collections.unmodifiableList(this.mapKey_);
            }

            public int getMapValue(int i) {
                return ((Integer) this.mapValue_.get(i)).intValue();
            }

            public int getMapValueCount() {
                return this.mapValue_.size();
            }

            public List getMapValueList() {
                return Collections.unmodifiableList(this.mapValue_);
            }

            public int getTemplateToken(int i) {
                return ((Integer) this.templateToken_.get(i)).intValue();
            }

            public int getTemplateTokenCount() {
                return this.templateToken_.size();
            }

            public List getTemplateTokenList() {
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

            public Builder mergeFrom(ServingValue servingValue) {
                if (servingValue != ServingValue.getDefaultInstance()) {
                    if (!servingValue.listItem_.isEmpty()) {
                        if (this.listItem_.isEmpty()) {
                            this.listItem_ = servingValue.listItem_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureListItemIsMutable();
                            this.listItem_.addAll(servingValue.listItem_);
                        }
                    }
                    if (!servingValue.mapKey_.isEmpty()) {
                        if (this.mapKey_.isEmpty()) {
                            this.mapKey_ = servingValue.mapKey_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureMapKeyIsMutable();
                            this.mapKey_.addAll(servingValue.mapKey_);
                        }
                    }
                    if (!servingValue.mapValue_.isEmpty()) {
                        if (this.mapValue_.isEmpty()) {
                            this.mapValue_ = servingValue.mapValue_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureMapValueIsMutable();
                            this.mapValue_.addAll(servingValue.mapValue_);
                        }
                    }
                    if (servingValue.hasMacroReference()) {
                        setMacroReference(servingValue.getMacroReference());
                    }
                    if (!servingValue.templateToken_.isEmpty()) {
                        if (this.templateToken_.isEmpty()) {
                            this.templateToken_ = servingValue.templateToken_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureTemplateTokenIsMutable();
                            this.templateToken_.addAll(servingValue.templateToken_);
                        }
                    }
                    if (servingValue.hasMacroNameReference()) {
                        setMacroNameReference(servingValue.getMacroNameReference());
                    }
                    setUnknownFields(getUnknownFields().concat(servingValue.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                ServingValue servingValue;
                Throwable th;
                ServingValue servingValue2;
                try {
                    servingValue = (ServingValue) ServingValue.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (servingValue != null) {
                        mergeFrom(servingValue);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    servingValue = (ServingValue) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    servingValue2 = servingValue;
                    th = th3;
                }
                if (servingValue2 != null) {
                    mergeFrom(servingValue2);
                }
                throw th;
            }

            public Builder setListItem(int i, int i2) {
                ensureListItemIsMutable();
                this.listItem_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder setMacroNameReference(int i) {
                this.bitField0_ |= 32;
                this.macroNameReference_ = i;
                return this;
            }

            public Builder setMacroReference(int i) {
                this.bitField0_ |= 8;
                this.macroReference_ = i;
                return this;
            }

            public Builder setMapKey(int i, int i2) {
                ensureMapKeyIsMutable();
                this.mapKey_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder setMapValue(int i, int i2) {
                ensureMapValueIsMutable();
                this.mapValue_.set(i, Integer.valueOf(i2));
                return this;
            }

            public Builder setTemplateToken(int i, int i2) {
                ensureTemplateTokenIsMutable();
                this.templateToken_.set(i, Integer.valueOf(i2));
                return this;
            }
        }

        static {
            defaultInstance.initFields();
        }

        private ServingValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            int i = 0;
            OutputStream newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput);
            Object obj = null;
            while (obj == null) {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            obj = 1;
                            break;
                        case 8:
                            if ((i & 1) != 1) {
                                this.listItem_ = new ArrayList();
                                i |= 1;
                            }
                            this.listItem_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 10:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 1) != 1 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.listItem_ = new ArrayList();
                                i |= 1;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.listItem_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 16:
                            if ((i & 2) != 2) {
                                this.mapKey_ = new ArrayList();
                                i |= 2;
                            }
                            this.mapKey_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 18:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 2) != 2 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.mapKey_ = new ArrayList();
                                i |= 2;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.mapKey_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 24:
                            if ((i & 4) != 4) {
                                this.mapValue_ = new ArrayList();
                                i |= 4;
                            }
                            this.mapValue_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 26:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 4) != 4 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.mapValue_ = new ArrayList();
                                i |= 4;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.mapValue_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 32:
                            this.bitField0_ |= 1;
                            this.macroReference_ = codedInputStream.readInt32();
                            break;
                        case 40:
                            if ((i & 16) != 16) {
                                this.templateToken_ = new ArrayList();
                                i |= 16;
                            }
                            this.templateToken_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 42:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 16) != 16 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.templateToken_ = new ArrayList();
                                i |= 16;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.templateToken_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 48:
                            this.bitField0_ |= 2;
                            this.macroNameReference_ = codedInputStream.readInt32();
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    if ((i & 1) == 1) {
                        this.listItem_ = Collections.unmodifiableList(this.listItem_);
                    }
                    if ((i & 2) == 2) {
                        this.mapKey_ = Collections.unmodifiableList(this.mapKey_);
                    }
                    if ((i & 4) == 4) {
                        this.mapValue_ = Collections.unmodifiableList(this.mapValue_);
                    }
                    if ((i & 16) == 16) {
                        this.templateToken_ = Collections.unmodifiableList(this.templateToken_);
                    }
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
            if ((i & 1) == 1) {
                this.listItem_ = Collections.unmodifiableList(this.listItem_);
            }
            if ((i & 2) == 2) {
                this.mapKey_ = Collections.unmodifiableList(this.mapKey_);
            }
            if ((i & 4) == 4) {
                this.mapValue_ = Collections.unmodifiableList(this.mapValue_);
            }
            if ((i & 16) == 16) {
                this.templateToken_ = Collections.unmodifiableList(this.templateToken_);
            }
            try {
                newInstance.flush();
            } catch (IOException e4) {
            } finally {
                this.unknownFields = newOutput.toByteString();
            }
            makeExtensionsImmutable();
        }

        private ServingValue(com.google.tagmanager.protobuf.GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ServingValue(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static ServingValue getDefaultInstance() {
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

        public static Builder newBuilder(ServingValue servingValue) {
            return newBuilder().mergeFrom(servingValue);
        }

        public static ServingValue parseDelimitedFrom(InputStream inputStream) {
            return (ServingValue) PARSER.parseDelimitedFrom(inputStream);
        }

        public static ServingValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ServingValue) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static ServingValue parseFrom(ByteString byteString) {
            return (ServingValue) PARSER.parseFrom(byteString);
        }

        public static ServingValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ServingValue) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ServingValue parseFrom(CodedInputStream codedInputStream) {
            return (ServingValue) PARSER.parseFrom(codedInputStream);
        }

        public static ServingValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ServingValue) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static ServingValue parseFrom(InputStream inputStream) {
            return (ServingValue) PARSER.parseFrom(inputStream);
        }

        public static ServingValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ServingValue) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static ServingValue parseFrom(byte[] bArr) {
            return (ServingValue) PARSER.parseFrom(bArr);
        }

        public static ServingValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ServingValue) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ServingValue)) {
                return super.equals(obj);
            }
            ServingValue servingValue = (ServingValue) obj;
            boolean z = (getListItemList().equals(servingValue.getListItemList())) && getMapKeyList().equals(servingValue.getMapKeyList());
            z = z && getMapValueList().equals(servingValue.getMapValueList());
            z = z && hasMacroReference() == servingValue.hasMacroReference();
            if (hasMacroReference()) {
                z = z && getMacroReference() == servingValue.getMacroReference();
            }
            z = z && getTemplateTokenList().equals(servingValue.getTemplateTokenList());
            z = z && hasMacroNameReference() == servingValue.hasMacroNameReference();
            return hasMacroNameReference() ? z && getMacroNameReference() == servingValue.getMacroNameReference() : z;
        }

        public ServingValue getDefaultInstanceForType() {
            return defaultInstance;
        }

        public int getListItem(int i) {
            return ((Integer) this.listItem_.get(i)).intValue();
        }

        public int getListItemCount() {
            return this.listItem_.size();
        }

        public List getListItemList() {
            return this.listItem_;
        }

        public int getMacroNameReference() {
            return this.macroNameReference_;
        }

        public int getMacroReference() {
            return this.macroReference_;
        }

        public int getMapKey(int i) {
            return ((Integer) this.mapKey_.get(i)).intValue();
        }

        public int getMapKeyCount() {
            return this.mapKey_.size();
        }

        public List getMapKeyList() {
            return this.mapKey_;
        }

        public int getMapValue(int i) {
            return ((Integer) this.mapValue_.get(i)).intValue();
        }

        public int getMapValueCount() {
            return this.mapValue_.size();
        }

        public List getMapValueList() {
            return this.mapValue_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = 0;
            int i2 = this.memoizedSerializedSize;
            if (i2 != -1) {
                return i2;
            }
            int i3;
            int i4 = 0;
            for (i3 = 0; i3 < this.listItem_.size(); i3++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.listItem_.get(i3)).intValue());
            }
            int size = (0 + i4) + (getListItemList().size() * 1);
            i4 = 0;
            for (i3 = 0; i3 < this.mapKey_.size(); i3++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.mapKey_.get(i3)).intValue());
            }
            size = (size + i4) + (getMapKeyList().size() * 1);
            i4 = 0;
            for (i3 = 0; i3 < this.mapValue_.size(); i3++) {
                i4 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.mapValue_.get(i3)).intValue());
            }
            i2 = (size + i4) + (getMapValueList().size() * 1);
            i3 = (this.bitField0_ & 1) == 1 ? i2 + CodedOutputStream.computeInt32Size(4, this.macroReference_) : i2;
            i4 = 0;
            while (i < this.templateToken_.size()) {
                i++;
                i4 = CodedOutputStream.computeInt32SizeNoTag(((Integer) this.templateToken_.get(i)).intValue()) + i4;
            }
            i2 = (i3 + i4) + (getTemplateTokenList().size() * 1);
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(6, this.macroNameReference_);
            }
            i2 += this.unknownFields.size();
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public int getTemplateToken(int i) {
            return ((Integer) this.templateToken_.get(i)).intValue();
        }

        public int getTemplateTokenCount() {
            return this.templateToken_.size();
        }

        public List getTemplateTokenList() {
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
            }
            int hashCode = ServingValue.class.hashCode() + 779;
            if (getListItemCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getListItemList().hashCode();
            }
            if (getMapKeyCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getMapKeyList().hashCode();
            }
            if (getMapValueCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getMapValueList().hashCode();
            }
            if (hasMacroReference()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getMacroReference();
            }
            if (getTemplateTokenCount() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + getTemplateTokenList().hashCode();
            }
            if (hasMacroNameReference()) {
                hashCode = (((hashCode * 37) + 6) * 53) + getMacroNameReference();
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.containertag.proto.MutableServing$ServingValue");
            }
            return mutableDefault;
        }

        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != (byte) -1) {
                return b == (byte) 1;
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

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeTo(CodedOutputStream codedOutputStream) {
            int i;
            int i2 = 0;
            getSerializedSize();
            for (i = 0; i < this.listItem_.size(); i++) {
                codedOutputStream.writeInt32(1, ((Integer) this.listItem_.get(i)).intValue());
            }
            for (i = 0; i < this.mapKey_.size(); i++) {
                codedOutputStream.writeInt32(2, ((Integer) this.mapKey_.get(i)).intValue());
            }
            for (i = 0; i < this.mapValue_.size(); i++) {
                codedOutputStream.writeInt32(3, ((Integer) this.mapValue_.get(i)).intValue());
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(4, this.macroReference_);
            }
            while (i2 < this.templateToken_.size()) {
                codedOutputStream.writeInt32(5, ((Integer) this.templateToken_.get(i2)).intValue());
                i2++;
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(6, this.macroNameReference_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    private Serving() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add(ServingValue.ext);
    }
}
