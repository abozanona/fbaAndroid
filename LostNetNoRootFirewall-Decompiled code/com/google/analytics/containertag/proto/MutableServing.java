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
import com.google.tagmanager.protobuf.LazyStringArrayList;
import com.google.tagmanager.protobuf.LazyStringList;
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

public final class MutableServing {

    public final class CacheOption extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static final int EXPIRATION_SECONDS_FIELD_NUMBER = 2;
        public static final int GCACHE_EXPIRATION_SECONDS_FIELD_NUMBER = 3;
        public static final int LEVEL_FIELD_NUMBER = 1;
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        private static final CacheOption defaultInstance = new CacheOption(true);
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int expirationSeconds_;
        private int gcacheExpirationSeconds_;
        private CacheLevel level_ = CacheLevel.NO_CACHE;

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
                internalValueMap = new C0161l();
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
            defaultInstance.makeImmutable();
        }

        private CacheOption() {
            initFields();
        }

        private CacheOption(boolean z) {
        }

        public static CacheOption getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.level_ = CacheLevel.NO_CACHE;
        }

        public static CacheOption newMessage() {
            return new CacheOption();
        }

        public CacheOption clear() {
            assertMutable();
            super.clear();
            this.level_ = CacheLevel.NO_CACHE;
            this.bitField0_ &= -2;
            this.expirationSeconds_ = 0;
            this.bitField0_ &= -3;
            this.gcacheExpirationSeconds_ = 0;
            this.bitField0_ &= -5;
            return this;
        }

        public CacheOption clearExpirationSeconds() {
            assertMutable();
            this.bitField0_ &= -3;
            this.expirationSeconds_ = 0;
            return this;
        }

        public CacheOption clearGcacheExpirationSeconds() {
            assertMutable();
            this.bitField0_ &= -5;
            this.gcacheExpirationSeconds_ = 0;
            return this;
        }

        public CacheOption clearLevel() {
            assertMutable();
            this.bitField0_ &= -2;
            this.level_ = CacheLevel.NO_CACHE;
            return this;
        }

        public CacheOption clone() {
            return newMessageForType().mergeFrom(this);
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

        public final CacheOption getDefaultInstanceForType() {
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
            int i = 0;
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
            this.cachedSize = i;
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
            int i = 41;
            if (hasLevel()) {
                i = 80454 + Internal.hashEnum(getLevel());
            }
            if (hasExpirationSeconds()) {
                i = (((i * 37) + 2) * 53) + getExpirationSeconds();
            }
            if (hasGcacheExpirationSeconds()) {
                i = (((i * 37) + 3) * 53) + getGcacheExpirationSeconds();
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.containertag.proto.Serving$CacheOption");
            }
            return immutableDefault;
        }

        public final boolean isInitialized() {
            return true;
        }

        public CacheOption mergeFrom(CacheOption cacheOption) {
            if (this == cacheOption) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (cacheOption != getDefaultInstance()) {
                if (cacheOption.hasLevel()) {
                    setLevel(cacheOption.getLevel());
                }
                if (cacheOption.hasExpirationSeconds()) {
                    setExpirationSeconds(cacheOption.getExpirationSeconds());
                }
                if (cacheOption.hasGcacheExpirationSeconds()) {
                    setGcacheExpirationSeconds(cacheOption.getGcacheExpirationSeconds());
                }
                this.unknownFields = this.unknownFields.concat(cacheOption.unknownFields);
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

        public CacheOption newMessageForType() {
            return new CacheOption();
        }

        public CacheOption setExpirationSeconds(int i) {
            assertMutable();
            this.bitField0_ |= 2;
            this.expirationSeconds_ = i;
            return this;
        }

        public CacheOption setGcacheExpirationSeconds(int i) {
            assertMutable();
            this.bitField0_ |= 4;
            this.gcacheExpirationSeconds_ = i;
            return this;
        }

        public CacheOption setLevel(CacheLevel cacheLevel) {
            assertMutable();
            if (cacheLevel == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.level_ = cacheLevel;
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
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
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    public final class Container extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static final int CONTAINER_ID_FIELD_NUMBER = 3;
        public static final int JS_RESOURCE_FIELD_NUMBER = 1;
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        public static final int STATE_FIELD_NUMBER = 4;
        public static final int VERSION_FIELD_NUMBER = 5;
        private static final Container defaultInstance = new Container(true);
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object containerId_ = Internal.EMPTY_BYTE_ARRAY;
        private Resource jsResource_;
        private ResourceState state_ = ResourceState.PREVIEW;
        private Object version_ = Internal.EMPTY_BYTE_ARRAY;

        static {
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
        }

        private Container() {
            initFields();
        }

        private Container(boolean z) {
        }

        private void ensureJsResourceInitialized() {
            if (this.jsResource_ == Resource.getDefaultInstance()) {
                this.jsResource_ = Resource.newMessage();
            }
        }

        public static Container getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.jsResource_ = Resource.getDefaultInstance();
            this.state_ = ResourceState.PREVIEW;
        }

        public static Container newMessage() {
            return new Container();
        }

        public Container clear() {
            assertMutable();
            super.clear();
            if (this.jsResource_ != Resource.getDefaultInstance()) {
                this.jsResource_.clear();
            }
            this.bitField0_ &= -2;
            this.containerId_ = Internal.EMPTY_BYTE_ARRAY;
            this.bitField0_ &= -3;
            this.state_ = ResourceState.PREVIEW;
            this.bitField0_ &= -5;
            this.version_ = Internal.EMPTY_BYTE_ARRAY;
            this.bitField0_ &= -9;
            return this;
        }

        public Container clearContainerId() {
            assertMutable();
            this.bitField0_ &= -3;
            this.containerId_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public Container clearJsResource() {
            assertMutable();
            this.bitField0_ &= -2;
            if (this.jsResource_ != Resource.getDefaultInstance()) {
                this.jsResource_.clear();
            }
            return this;
        }

        public Container clearState() {
            assertMutable();
            this.bitField0_ &= -5;
            this.state_ = ResourceState.PREVIEW;
            return this;
        }

        public Container clearVersion() {
            assertMutable();
            this.bitField0_ &= -9;
            this.version_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public Container clone() {
            return newMessageForType().mergeFrom(this);
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

        public final Container getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Resource getJsResource() {
            return this.jsResource_;
        }

        public Resource getMutableJsResource() {
            assertMutable();
            ensureJsResourceInitialized();
            this.bitField0_ |= 1;
            return this.jsResource_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int computeMessageSize = ((0 + CodedOutputStream.computeMessageSize(1, this.jsResource_)) + CodedOutputStream.computeByteArraySize(3, getContainerIdAsBytes())) + CodedOutputStream.computeEnumSize(4, this.state_.getNumber());
            if ((this.bitField0_ & 8) == 8) {
                computeMessageSize += CodedOutputStream.computeByteArraySize(5, getVersionAsBytes());
            }
            computeMessageSize += this.unknownFields.size();
            this.cachedSize = computeMessageSize;
            return computeMessageSize;
        }

        public ResourceState getState() {
            return this.state_;
        }

        public String getVersion() {
            Object obj = this.version_;
            if (obj instanceof String) {
                return (String) obj;
            }
            byte[] bArr = (byte[]) obj;
            String toStringUtf8 = Internal.toStringUtf8(bArr);
            if (Internal.isValidUtf8(bArr)) {
                this.version_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public byte[] getVersionAsBytes() {
            Object obj = this.version_;
            if (!(obj instanceof String)) {
                return (byte[]) obj;
            }
            obj = Internal.toByteArray((String) obj);
            this.version_ = obj;
            return obj;
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
            int i = 41;
            if (hasJsResource()) {
                i = 80454 + getJsResource().hashCode();
            }
            if (hasContainerId()) {
                i = (((i * 37) + 3) * 53) + getContainerId().hashCode();
            }
            if (hasState()) {
                i = (((i * 37) + 4) * 53) + Internal.hashEnum(getState());
            }
            if (hasVersion()) {
                i = (((i * 37) + 5) * 53) + getVersion().hashCode();
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.containertag.proto.Serving$Container");
            }
            return immutableDefault;
        }

        public final boolean isInitialized() {
            return hasJsResource() && hasContainerId() && hasState() && getJsResource().isInitialized();
        }

        public Container mergeFrom(Container container) {
            if (this == container) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (container != getDefaultInstance()) {
                byte[] bArr;
                if (container.hasJsResource()) {
                    ensureJsResourceInitialized();
                    this.jsResource_.mergeFrom(container.getJsResource());
                    this.bitField0_ |= 1;
                }
                if (container.hasContainerId()) {
                    this.bitField0_ |= 2;
                    if (container.containerId_ instanceof String) {
                        this.containerId_ = container.containerId_;
                    } else {
                        bArr = (byte[]) container.containerId_;
                        this.containerId_ = Arrays.copyOf(bArr, bArr.length);
                    }
                }
                if (container.hasState()) {
                    setState(container.getState());
                }
                if (container.hasVersion()) {
                    this.bitField0_ |= 8;
                    if (container.version_ instanceof String) {
                        this.version_ = container.version_;
                    } else {
                        bArr = (byte[]) container.version_;
                        this.version_ = Arrays.copyOf(bArr, bArr.length);
                    }
                }
                this.unknownFields = this.unknownFields.concat(container.unknownFields);
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
                            if (this.jsResource_ == Resource.getDefaultInstance()) {
                                this.jsResource_ = Resource.newMessage();
                            }
                            this.bitField0_ |= 1;
                            codedInputStream.readMessage(this.jsResource_, extensionRegistryLite);
                            break;
                        case 26:
                            this.bitField0_ |= 2;
                            this.containerId_ = codedInputStream.readByteArray();
                            break;
                        case 32:
                            int readEnum = codedInputStream.readEnum();
                            ResourceState valueOf = ResourceState.valueOf(readEnum);
                            if (valueOf != null) {
                                this.bitField0_ |= 4;
                                this.state_ = valueOf;
                                break;
                            }
                            newInstance.writeRawVarint32(readTag);
                            newInstance.writeRawVarint32(readEnum);
                            break;
                        case 42:
                            this.bitField0_ |= 8;
                            this.version_ = codedInputStream.readByteArray();
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

        public Container newMessageForType() {
            return new Container();
        }

        public Container setContainerId(String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.containerId_ = str;
            return this;
        }

        public Container setContainerIdAsBytes(byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.containerId_ = bArr;
            return this;
        }

        public Container setJsResource(Resource resource) {
            assertMutable();
            if (resource == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.jsResource_ = resource;
            return this;
        }

        public Container setState(ResourceState resourceState) {
            assertMutable();
            if (resourceState == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 4;
            this.state_ = resourceState;
            return this;
        }

        public Container setVersion(String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 8;
            this.version_ = str;
            return this;
        }

        public Container setVersionAsBytes(byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 8;
            this.version_ = bArr;
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            codedOutputStream.writeMessageWithCachedSizes(1, this.jsResource_);
            codedOutputStream.writeByteArray(3, getContainerIdAsBytes());
            codedOutputStream.writeEnum(4, this.state_.getNumber());
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeByteArray(5, getVersionAsBytes());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    public final class FunctionCall extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static final int FUNCTION_FIELD_NUMBER = 2;
        public static final int LIVE_ONLY_FIELD_NUMBER = 6;
        public static final int NAME_FIELD_NUMBER = 4;
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        public static final int PROPERTY_FIELD_NUMBER = 3;
        public static final int SERVER_SIDE_FIELD_NUMBER = 1;
        private static final FunctionCall defaultInstance = new FunctionCall(true);
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int function_;
        private boolean liveOnly_;
        private int name_;
        private List property_ = null;
        private boolean serverSide_;

        static {
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
        }

        private FunctionCall() {
            initFields();
        }

        private FunctionCall(boolean z) {
        }

        private void ensurePropertyInitialized() {
            if (this.property_ == null) {
                this.property_ = new ArrayList();
            }
        }

        public static FunctionCall getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static FunctionCall newMessage() {
            return new FunctionCall();
        }

        public FunctionCall addAllProperty(Iterable iterable) {
            assertMutable();
            ensurePropertyInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.property_);
            return this;
        }

        public FunctionCall addProperty(int i) {
            assertMutable();
            ensurePropertyInitialized();
            this.property_.add(Integer.valueOf(i));
            return this;
        }

        public FunctionCall clear() {
            assertMutable();
            super.clear();
            this.property_ = null;
            this.function_ = 0;
            this.bitField0_ &= -2;
            this.name_ = 0;
            this.bitField0_ &= -3;
            this.liveOnly_ = false;
            this.bitField0_ &= -5;
            this.serverSide_ = false;
            this.bitField0_ &= -9;
            return this;
        }

        public FunctionCall clearFunction() {
            assertMutable();
            this.bitField0_ &= -2;
            this.function_ = 0;
            return this;
        }

        public FunctionCall clearLiveOnly() {
            assertMutable();
            this.bitField0_ &= -5;
            this.liveOnly_ = false;
            return this;
        }

        public FunctionCall clearName() {
            assertMutable();
            this.bitField0_ &= -3;
            this.name_ = 0;
            return this;
        }

        public FunctionCall clearProperty() {
            assertMutable();
            this.property_ = null;
            return this;
        }

        public FunctionCall clearServerSide() {
            assertMutable();
            this.bitField0_ &= -9;
            this.serverSide_ = false;
            return this;
        }

        public FunctionCall clone() {
            return newMessageForType().mergeFrom(this);
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

        public final FunctionCall getDefaultInstanceForType() {
            return defaultInstance;
        }

        public int getFunction() {
            return this.function_;
        }

        public boolean getLiveOnly() {
            return this.liveOnly_;
        }

        public List getMutablePropertyList() {
            assertMutable();
            ensurePropertyInitialized();
            return this.property_;
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
            return this.property_ == null ? 0 : this.property_.size();
        }

        public List getPropertyList() {
            return this.property_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.property_);
        }

        public int getSerializedSize() {
            int i = 0;
            if (this.property_ != null && this.property_.size() > 0) {
                int i2 = 0;
                for (int i3 = 0; i3 < this.property_.size(); i3++) {
                    i2 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.property_.get(i3)).intValue());
                }
                i = (0 + i2) + (getPropertyList().size() * 1);
            }
            int computeInt32Size = CodedOutputStream.computeInt32Size(2, this.function_) + i;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(4, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeBoolSize(6, this.liveOnly_);
            }
            if ((this.bitField0_ & 8) == 8) {
                computeInt32Size += CodedOutputStream.computeBoolSize(1, this.serverSide_);
            }
            computeInt32Size += this.unknownFields.size();
            this.cachedSize = computeInt32Size;
            return computeInt32Size;
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
            int i = 41;
            if (getPropertyCount() > 0) {
                i = 80560 + getPropertyList().hashCode();
            }
            if (hasFunction()) {
                i = (((i * 37) + 2) * 53) + getFunction();
            }
            if (hasName()) {
                i = (((i * 37) + 4) * 53) + getName();
            }
            if (hasLiveOnly()) {
                i = (((i * 37) + 6) * 53) + Internal.hashBoolean(getLiveOnly());
            }
            if (hasServerSide()) {
                i = (((i * 37) + 1) * 53) + Internal.hashBoolean(getServerSide());
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.containertag.proto.Serving$FunctionCall");
            }
            return immutableDefault;
        }

        public final boolean isInitialized() {
            return hasFunction();
        }

        public FunctionCall mergeFrom(FunctionCall functionCall) {
            if (this == functionCall) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (functionCall != getDefaultInstance()) {
                if (functionCall.hasServerSide()) {
                    setServerSide(functionCall.getServerSide());
                }
                if (functionCall.hasFunction()) {
                    setFunction(functionCall.getFunction());
                }
                if (!(functionCall.property_ == null || functionCall.property_.isEmpty())) {
                    ensurePropertyInitialized();
                    this.property_.addAll(functionCall.property_);
                }
                if (functionCall.hasName()) {
                    setName(functionCall.getName());
                }
                if (functionCall.hasLiveOnly()) {
                    setLiveOnly(functionCall.getLiveOnly());
                }
                this.unknownFields = this.unknownFields.concat(functionCall.unknownFields);
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
                            this.bitField0_ |= 8;
                            this.serverSide_ = codedInputStream.readBool();
                            break;
                        case 16:
                            this.bitField0_ |= 1;
                            this.function_ = codedInputStream.readInt32();
                            break;
                        case 24:
                            if (this.property_ == null) {
                                this.property_ = new ArrayList();
                            }
                            this.property_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 26:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (this.property_ == null) {
                                this.property_ = new ArrayList();
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

        public FunctionCall newMessageForType() {
            return new FunctionCall();
        }

        public FunctionCall setFunction(int i) {
            assertMutable();
            this.bitField0_ |= 1;
            this.function_ = i;
            return this;
        }

        public FunctionCall setLiveOnly(boolean z) {
            assertMutable();
            this.bitField0_ |= 4;
            this.liveOnly_ = z;
            return this;
        }

        public FunctionCall setName(int i) {
            assertMutable();
            this.bitField0_ |= 2;
            this.name_ = i;
            return this;
        }

        public FunctionCall setProperty(int i, int i2) {
            assertMutable();
            ensurePropertyInitialized();
            this.property_.set(i, Integer.valueOf(i2));
            return this;
        }

        public FunctionCall setServerSide(boolean z) {
            assertMutable();
            this.bitField0_ |= 8;
            this.serverSide_ = z;
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBool(1, this.serverSide_);
            }
            codedOutputStream.writeInt32(2, this.function_);
            if (this.property_ != null) {
                for (int i = 0; i < this.property_.size(); i++) {
                    codedOutputStream.writeInt32(3, ((Integer) this.property_.get(i)).intValue());
                }
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(4, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBool(6, this.liveOnly_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    public final class OptionalResource extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        public static final int RESOURCE_FIELD_NUMBER = 2;
        private static final OptionalResource defaultInstance = new OptionalResource(true);
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Resource resource_;

        static {
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
        }

        private OptionalResource() {
            initFields();
        }

        private OptionalResource(boolean z) {
        }

        private void ensureResourceInitialized() {
            if (this.resource_ == Resource.getDefaultInstance()) {
                this.resource_ = Resource.newMessage();
            }
        }

        public static OptionalResource getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.resource_ = Resource.getDefaultInstance();
        }

        public static OptionalResource newMessage() {
            return new OptionalResource();
        }

        public OptionalResource clear() {
            assertMutable();
            super.clear();
            if (this.resource_ != Resource.getDefaultInstance()) {
                this.resource_.clear();
            }
            this.bitField0_ &= -2;
            return this;
        }

        public OptionalResource clearResource() {
            assertMutable();
            this.bitField0_ &= -2;
            if (this.resource_ != Resource.getDefaultInstance()) {
                this.resource_.clear();
            }
            return this;
        }

        public OptionalResource clone() {
            return newMessageForType().mergeFrom(this);
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

        public final OptionalResource getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Resource getMutableResource() {
            assertMutable();
            ensureResourceInitialized();
            this.bitField0_ |= 1;
            return this.resource_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public Resource getResource() {
            return this.resource_;
        }

        public int getSerializedSize() {
            int i = 0;
            if ((this.bitField0_ & 1) == 1) {
                i = 0 + CodedOutputStream.computeMessageSize(2, this.resource_);
            }
            i += this.unknownFields.size();
            this.cachedSize = i;
            return i;
        }

        public boolean hasResource() {
            return (this.bitField0_ & 1) == 1;
        }

        public int hashCode() {
            int i = 41;
            if (hasResource()) {
                i = 80507 + getResource().hashCode();
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.containertag.proto.Serving$OptionalResource");
            }
            return immutableDefault;
        }

        public final boolean isInitialized() {
            return !hasResource() || getResource().isInitialized();
        }

        public OptionalResource mergeFrom(OptionalResource optionalResource) {
            if (this == optionalResource) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (optionalResource != getDefaultInstance()) {
                if (optionalResource.hasResource()) {
                    ensureResourceInitialized();
                    this.resource_.mergeFrom(optionalResource.getResource());
                    this.bitField0_ |= 1;
                }
                this.unknownFields = this.unknownFields.concat(optionalResource.unknownFields);
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
                        case 18:
                            if (this.resource_ == Resource.getDefaultInstance()) {
                                this.resource_ = Resource.newMessage();
                            }
                            this.bitField0_ |= 1;
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

        public OptionalResource newMessageForType() {
            return new OptionalResource();
        }

        public OptionalResource setResource(Resource resource) {
            assertMutable();
            if (resource == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.resource_ = resource;
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessageWithCachedSizes(2, this.resource_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    public final class Property extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static final int KEY_FIELD_NUMBER = 1;
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final Property defaultInstance = new Property(true);
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int key_;
        private int value_;

        static {
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
        }

        private Property() {
            initFields();
        }

        private Property(boolean z) {
        }

        public static Property getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static Property newMessage() {
            return new Property();
        }

        public Property clear() {
            assertMutable();
            super.clear();
            this.key_ = 0;
            this.bitField0_ &= -2;
            this.value_ = 0;
            this.bitField0_ &= -3;
            return this;
        }

        public Property clearKey() {
            assertMutable();
            this.bitField0_ &= -2;
            this.key_ = 0;
            return this;
        }

        public Property clearValue() {
            assertMutable();
            this.bitField0_ &= -3;
            this.value_ = 0;
            return this;
        }

        public Property clone() {
            return newMessageForType().mergeFrom(this);
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

        public final Property getDefaultInstanceForType() {
            return defaultInstance;
        }

        public int getKey() {
            return this.key_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int computeInt32Size = ((0 + CodedOutputStream.computeInt32Size(1, this.key_)) + CodedOutputStream.computeInt32Size(2, this.value_)) + this.unknownFields.size();
            this.cachedSize = computeInt32Size;
            return computeInt32Size;
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
            int i = 41;
            if (hasKey()) {
                i = 80454 + getKey();
            }
            if (hasValue()) {
                i = (((i * 37) + 2) * 53) + getValue();
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.containertag.proto.Serving$Property");
            }
            return immutableDefault;
        }

        public final boolean isInitialized() {
            return hasKey() && hasValue();
        }

        public Property mergeFrom(Property property) {
            if (this == property) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (property != getDefaultInstance()) {
                if (property.hasKey()) {
                    setKey(property.getKey());
                }
                if (property.hasValue()) {
                    setValue(property.getValue());
                }
                this.unknownFields = this.unknownFields.concat(property.unknownFields);
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
                            this.key_ = codedInputStream.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 2;
                            this.value_ = codedInputStream.readInt32();
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

        public Property newMessageForType() {
            return new Property();
        }

        public Property setKey(int i) {
            assertMutable();
            this.bitField0_ |= 1;
            this.key_ = i;
            return this;
        }

        public Property setValue(int i) {
            assertMutable();
            this.bitField0_ |= 2;
            this.value_ = i;
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            codedOutputStream.writeInt32(1, this.key_);
            codedOutputStream.writeInt32(2, this.value_);
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    public final class Resource extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static final int ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER = 18;
        public static final int KEY_FIELD_NUMBER = 1;
        public static final int LIVE_JS_CACHE_OPTION_FIELD_NUMBER = 14;
        public static final int MACRO_FIELD_NUMBER = 4;
        public static final int MALWARE_SCAN_AUTH_CODE_FIELD_NUMBER = 10;
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
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
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean enableAutoEventTracking_;
        private LazyStringList key_ = null;
        private CacheOption liveJsCacheOption_;
        private List macro_ = null;
        private Object malwareScanAuthCode_ = Internal.EMPTY_BYTE_ARRAY;
        private List predicate_ = null;
        private Object previewAuthCode_ = Internal.EMPTY_BYTE_ARRAY;
        private List property_ = null;
        private float reportingSampleRate_;
        private int resourceFormatVersion_;
        private List rule_ = null;
        private List tag_ = null;
        private Object templateVersionSet_ = Internal.byteArrayDefaultValue("0");
        private LazyStringList usageContext_ = null;
        private List value_ = null;
        private Object version_ = Internal.EMPTY_BYTE_ARRAY;

        static {
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
        }

        private Resource() {
            initFields();
        }

        private Resource(boolean z) {
        }

        private void ensureKeyInitialized() {
            if (this.key_ == null) {
                this.key_ = new LazyStringArrayList();
            }
        }

        private void ensureLiveJsCacheOptionInitialized() {
            if (this.liveJsCacheOption_ == CacheOption.getDefaultInstance()) {
                this.liveJsCacheOption_ = CacheOption.newMessage();
            }
        }

        private void ensureMacroInitialized() {
            if (this.macro_ == null) {
                this.macro_ = new ArrayList();
            }
        }

        private void ensurePredicateInitialized() {
            if (this.predicate_ == null) {
                this.predicate_ = new ArrayList();
            }
        }

        private void ensurePropertyInitialized() {
            if (this.property_ == null) {
                this.property_ = new ArrayList();
            }
        }

        private void ensureRuleInitialized() {
            if (this.rule_ == null) {
                this.rule_ = new ArrayList();
            }
        }

        private void ensureTagInitialized() {
            if (this.tag_ == null) {
                this.tag_ = new ArrayList();
            }
        }

        private void ensureUsageContextInitialized() {
            if (this.usageContext_ == null) {
                this.usageContext_ = new LazyStringArrayList();
            }
        }

        private void ensureValueInitialized() {
            if (this.value_ == null) {
                this.value_ = new ArrayList();
            }
        }

        public static Resource getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.liveJsCacheOption_ = CacheOption.getDefaultInstance();
        }

        public static Resource newMessage() {
            return new Resource();
        }

        public Resource addAllKey(Iterable iterable) {
            assertMutable();
            ensureKeyInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.key_);
            return this;
        }

        public Resource addAllMacro(Iterable iterable) {
            assertMutable();
            ensureMacroInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.macro_);
            return this;
        }

        public Resource addAllPredicate(Iterable iterable) {
            assertMutable();
            ensurePredicateInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.predicate_);
            return this;
        }

        public Resource addAllProperty(Iterable iterable) {
            assertMutable();
            ensurePropertyInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.property_);
            return this;
        }

        public Resource addAllRule(Iterable iterable) {
            assertMutable();
            ensureRuleInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.rule_);
            return this;
        }

        public Resource addAllTag(Iterable iterable) {
            assertMutable();
            ensureTagInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.tag_);
            return this;
        }

        public Resource addAllUsageContext(Iterable iterable) {
            assertMutable();
            ensureUsageContextInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.usageContext_);
            return this;
        }

        public Resource addAllValue(Iterable iterable) {
            assertMutable();
            ensureValueInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.value_);
            return this;
        }

        public Resource addKey(String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            ensureKeyInitialized();
            this.key_.add(str);
            return this;
        }

        public Resource addKeyAsBytes(byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            ensureKeyInitialized();
            this.key_.add(bArr);
            return this;
        }

        public FunctionCall addMacro() {
            assertMutable();
            ensureMacroInitialized();
            FunctionCall newMessage = FunctionCall.newMessage();
            this.macro_.add(newMessage);
            return newMessage;
        }

        public Resource addMacro(FunctionCall functionCall) {
            assertMutable();
            if (functionCall == null) {
                throw new NullPointerException();
            }
            ensureMacroInitialized();
            this.macro_.add(functionCall);
            return this;
        }

        public FunctionCall addPredicate() {
            assertMutable();
            ensurePredicateInitialized();
            FunctionCall newMessage = FunctionCall.newMessage();
            this.predicate_.add(newMessage);
            return newMessage;
        }

        public Resource addPredicate(FunctionCall functionCall) {
            assertMutable();
            if (functionCall == null) {
                throw new NullPointerException();
            }
            ensurePredicateInitialized();
            this.predicate_.add(functionCall);
            return this;
        }

        public Property addProperty() {
            assertMutable();
            ensurePropertyInitialized();
            Property newMessage = Property.newMessage();
            this.property_.add(newMessage);
            return newMessage;
        }

        public Resource addProperty(Property property) {
            assertMutable();
            if (property == null) {
                throw new NullPointerException();
            }
            ensurePropertyInitialized();
            this.property_.add(property);
            return this;
        }

        public Resource addRule(Rule rule) {
            assertMutable();
            if (rule == null) {
                throw new NullPointerException();
            }
            ensureRuleInitialized();
            this.rule_.add(rule);
            return this;
        }

        public Rule addRule() {
            assertMutable();
            ensureRuleInitialized();
            Rule newMessage = Rule.newMessage();
            this.rule_.add(newMessage);
            return newMessage;
        }

        public FunctionCall addTag() {
            assertMutable();
            ensureTagInitialized();
            FunctionCall newMessage = FunctionCall.newMessage();
            this.tag_.add(newMessage);
            return newMessage;
        }

        public Resource addTag(FunctionCall functionCall) {
            assertMutable();
            if (functionCall == null) {
                throw new NullPointerException();
            }
            ensureTagInitialized();
            this.tag_.add(functionCall);
            return this;
        }

        public Resource addUsageContext(String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            ensureUsageContextInitialized();
            this.usageContext_.add(str);
            return this;
        }

        public Resource addUsageContextAsBytes(byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            ensureUsageContextInitialized();
            this.usageContext_.add(bArr);
            return this;
        }

        public Resource addValue(Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureValueInitialized();
            this.value_.add(value);
            return this;
        }

        public Value addValue() {
            assertMutable();
            ensureValueInitialized();
            Value newMessage = Value.newMessage();
            this.value_.add(newMessage);
            return newMessage;
        }

        public Resource clear() {
            assertMutable();
            super.clear();
            this.key_ = null;
            this.value_ = null;
            this.property_ = null;
            this.macro_ = null;
            this.tag_ = null;
            this.predicate_ = null;
            this.rule_ = null;
            this.previewAuthCode_ = Internal.EMPTY_BYTE_ARRAY;
            this.bitField0_ &= -2;
            this.malwareScanAuthCode_ = Internal.EMPTY_BYTE_ARRAY;
            this.bitField0_ &= -3;
            this.templateVersionSet_ = getDefaultInstance().getTemplateVersionSetAsBytes();
            this.bitField0_ &= -5;
            this.version_ = Internal.EMPTY_BYTE_ARRAY;
            this.bitField0_ &= -9;
            if (this.liveJsCacheOption_ != CacheOption.getDefaultInstance()) {
                this.liveJsCacheOption_.clear();
            }
            this.bitField0_ &= -17;
            this.reportingSampleRate_ = 0.0f;
            this.bitField0_ &= -33;
            this.enableAutoEventTracking_ = false;
            this.bitField0_ &= -65;
            this.usageContext_ = null;
            this.resourceFormatVersion_ = 0;
            this.bitField0_ &= -129;
            return this;
        }

        public Resource clearEnableAutoEventTracking() {
            assertMutable();
            this.bitField0_ &= -65;
            this.enableAutoEventTracking_ = false;
            return this;
        }

        public Resource clearKey() {
            assertMutable();
            this.key_ = null;
            return this;
        }

        public Resource clearLiveJsCacheOption() {
            assertMutable();
            this.bitField0_ &= -17;
            if (this.liveJsCacheOption_ != CacheOption.getDefaultInstance()) {
                this.liveJsCacheOption_.clear();
            }
            return this;
        }

        public Resource clearMacro() {
            assertMutable();
            this.macro_ = null;
            return this;
        }

        public Resource clearMalwareScanAuthCode() {
            assertMutable();
            this.bitField0_ &= -3;
            this.malwareScanAuthCode_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public Resource clearPredicate() {
            assertMutable();
            this.predicate_ = null;
            return this;
        }

        public Resource clearPreviewAuthCode() {
            assertMutable();
            this.bitField0_ &= -2;
            this.previewAuthCode_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public Resource clearProperty() {
            assertMutable();
            this.property_ = null;
            return this;
        }

        public Resource clearReportingSampleRate() {
            assertMutable();
            this.bitField0_ &= -33;
            this.reportingSampleRate_ = 0.0f;
            return this;
        }

        public Resource clearResourceFormatVersion() {
            assertMutable();
            this.bitField0_ &= -129;
            this.resourceFormatVersion_ = 0;
            return this;
        }

        public Resource clearRule() {
            assertMutable();
            this.rule_ = null;
            return this;
        }

        public Resource clearTag() {
            assertMutable();
            this.tag_ = null;
            return this;
        }

        public Resource clearTemplateVersionSet() {
            assertMutable();
            this.bitField0_ &= -5;
            this.templateVersionSet_ = getDefaultInstance().getTemplateVersionSetAsBytes();
            return this;
        }

        public Resource clearUsageContext() {
            assertMutable();
            this.usageContext_ = null;
            return this;
        }

        public Resource clearValue() {
            assertMutable();
            this.value_ = null;
            return this;
        }

        public Resource clearVersion() {
            assertMutable();
            this.bitField0_ &= -9;
            this.version_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public Resource clone() {
            return newMessageForType().mergeFrom(this);
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

        public final Resource getDefaultInstanceForType() {
            return defaultInstance;
        }

        public boolean getEnableAutoEventTracking() {
            return this.enableAutoEventTracking_;
        }

        public String getKey(int i) {
            return (String) this.key_.get(i);
        }

        public byte[] getKeyAsBytes(int i) {
            return this.key_.getByteArray(i);
        }

        public int getKeyCount() {
            return this.key_ == null ? 0 : this.key_.size();
        }

        public List getKeyList() {
            return this.key_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.key_);
        }

        public List getKeyListAsBytes() {
            return this.key_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.key_.asByteArrayList());
        }

        public CacheOption getLiveJsCacheOption() {
            return this.liveJsCacheOption_;
        }

        public FunctionCall getMacro(int i) {
            return (FunctionCall) this.macro_.get(i);
        }

        public int getMacroCount() {
            return this.macro_ == null ? 0 : this.macro_.size();
        }

        public List getMacroList() {
            return this.macro_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.macro_);
        }

        public String getMalwareScanAuthCode() {
            Object obj = this.malwareScanAuthCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            byte[] bArr = (byte[]) obj;
            String toStringUtf8 = Internal.toStringUtf8(bArr);
            if (Internal.isValidUtf8(bArr)) {
                this.malwareScanAuthCode_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public byte[] getMalwareScanAuthCodeAsBytes() {
            Object obj = this.malwareScanAuthCode_;
            if (!(obj instanceof String)) {
                return (byte[]) obj;
            }
            obj = Internal.toByteArray((String) obj);
            this.malwareScanAuthCode_ = obj;
            return obj;
        }

        public List getMutableKeyList() {
            assertMutable();
            ensureKeyInitialized();
            return this.key_;
        }

        public List getMutableKeyListAsBytes() {
            assertMutable();
            ensureKeyInitialized();
            return this.key_.asByteArrayList();
        }

        public CacheOption getMutableLiveJsCacheOption() {
            assertMutable();
            ensureLiveJsCacheOptionInitialized();
            this.bitField0_ |= 16;
            return this.liveJsCacheOption_;
        }

        public FunctionCall getMutableMacro(int i) {
            return (FunctionCall) this.macro_.get(i);
        }

        public List getMutableMacroList() {
            assertMutable();
            ensureMacroInitialized();
            return this.macro_;
        }

        public FunctionCall getMutablePredicate(int i) {
            return (FunctionCall) this.predicate_.get(i);
        }

        public List getMutablePredicateList() {
            assertMutable();
            ensurePredicateInitialized();
            return this.predicate_;
        }

        public Property getMutableProperty(int i) {
            return (Property) this.property_.get(i);
        }

        public List getMutablePropertyList() {
            assertMutable();
            ensurePropertyInitialized();
            return this.property_;
        }

        public Rule getMutableRule(int i) {
            return (Rule) this.rule_.get(i);
        }

        public List getMutableRuleList() {
            assertMutable();
            ensureRuleInitialized();
            return this.rule_;
        }

        public FunctionCall getMutableTag(int i) {
            return (FunctionCall) this.tag_.get(i);
        }

        public List getMutableTagList() {
            assertMutable();
            ensureTagInitialized();
            return this.tag_;
        }

        public List getMutableUsageContextList() {
            assertMutable();
            ensureUsageContextInitialized();
            return this.usageContext_;
        }

        public List getMutableUsageContextListAsBytes() {
            assertMutable();
            ensureUsageContextInitialized();
            return this.usageContext_.asByteArrayList();
        }

        public Value getMutableValue(int i) {
            return (Value) this.value_.get(i);
        }

        public List getMutableValueList() {
            assertMutable();
            ensureValueInitialized();
            return this.value_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public FunctionCall getPredicate(int i) {
            return (FunctionCall) this.predicate_.get(i);
        }

        public int getPredicateCount() {
            return this.predicate_ == null ? 0 : this.predicate_.size();
        }

        public List getPredicateList() {
            return this.predicate_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.predicate_);
        }

        public String getPreviewAuthCode() {
            Object obj = this.previewAuthCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            byte[] bArr = (byte[]) obj;
            String toStringUtf8 = Internal.toStringUtf8(bArr);
            if (Internal.isValidUtf8(bArr)) {
                this.previewAuthCode_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public byte[] getPreviewAuthCodeAsBytes() {
            Object obj = this.previewAuthCode_;
            if (!(obj instanceof String)) {
                return (byte[]) obj;
            }
            obj = Internal.toByteArray((String) obj);
            this.previewAuthCode_ = obj;
            return obj;
        }

        public Property getProperty(int i) {
            return (Property) this.property_.get(i);
        }

        public int getPropertyCount() {
            return this.property_ == null ? 0 : this.property_.size();
        }

        public List getPropertyList() {
            return this.property_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.property_);
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
            return this.rule_ == null ? 0 : this.rule_.size();
        }

        public List getRuleList() {
            return this.rule_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.rule_);
        }

        public int getSerializedSize() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            if (this.key_ == null || this.key_.size() <= 0) {
                i = 0;
            } else {
                i2 = 0;
                for (i = 0; i < this.key_.size(); i++) {
                    i2 += CodedOutputStream.computeByteArraySizeNoTag(this.key_.getByteArray(i));
                }
                i = (0 + i2) + (this.key_.size() * 1);
            }
            if (this.value_ != null) {
                i3 = i;
                for (i2 = 0; i2 < this.value_.size(); i2++) {
                    i3 += CodedOutputStream.computeMessageSize(2, (MessageLite) this.value_.get(i2));
                }
            } else {
                i3 = i;
            }
            if (this.property_ != null) {
                for (i2 = 0; i2 < this.property_.size(); i2++) {
                    i3 += CodedOutputStream.computeMessageSize(3, (MessageLite) this.property_.get(i2));
                }
            }
            if (this.macro_ != null) {
                for (i2 = 0; i2 < this.macro_.size(); i2++) {
                    i3 += CodedOutputStream.computeMessageSize(4, (MessageLite) this.macro_.get(i2));
                }
            }
            if (this.tag_ != null) {
                for (i2 = 0; i2 < this.tag_.size(); i2++) {
                    i3 += CodedOutputStream.computeMessageSize(5, (MessageLite) this.tag_.get(i2));
                }
            }
            if (this.predicate_ != null) {
                for (i2 = 0; i2 < this.predicate_.size(); i2++) {
                    i3 += CodedOutputStream.computeMessageSize(6, (MessageLite) this.predicate_.get(i2));
                }
            }
            if (this.rule_ != null) {
                for (i2 = 0; i2 < this.rule_.size(); i2++) {
                    i3 += CodedOutputStream.computeMessageSize(7, (MessageLite) this.rule_.get(i2));
                }
            }
            if ((this.bitField0_ & 1) == 1) {
                i3 += CodedOutputStream.computeByteArraySize(9, getPreviewAuthCodeAsBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                i3 += CodedOutputStream.computeByteArraySize(10, getMalwareScanAuthCodeAsBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                i3 += CodedOutputStream.computeByteArraySize(12, getTemplateVersionSetAsBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                i3 += CodedOutputStream.computeByteArraySize(13, getVersionAsBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                i3 += CodedOutputStream.computeMessageSize(14, this.liveJsCacheOption_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i3 += CodedOutputStream.computeFloatSize(15, this.reportingSampleRate_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i3 += CodedOutputStream.computeBoolSize(18, this.enableAutoEventTracking_);
            }
            if (this.usageContext_ != null && this.usageContext_.size() > 0) {
                i = 0;
                while (i4 < this.usageContext_.size()) {
                    i += CodedOutputStream.computeByteArraySizeNoTag(this.usageContext_.getByteArray(i4));
                    i4++;
                }
                i3 = (i + i3) + (this.usageContext_.size() * 2);
            }
            if ((this.bitField0_ & 128) == 128) {
                i3 += CodedOutputStream.computeInt32Size(17, this.resourceFormatVersion_);
            }
            i = this.unknownFields.size() + i3;
            this.cachedSize = i;
            return i;
        }

        public FunctionCall getTag(int i) {
            return (FunctionCall) this.tag_.get(i);
        }

        public int getTagCount() {
            return this.tag_ == null ? 0 : this.tag_.size();
        }

        public List getTagList() {
            return this.tag_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.tag_);
        }

        public String getTemplateVersionSet() {
            Object obj = this.templateVersionSet_;
            if (obj instanceof String) {
                return (String) obj;
            }
            byte[] bArr = (byte[]) obj;
            String toStringUtf8 = Internal.toStringUtf8(bArr);
            if (Internal.isValidUtf8(bArr)) {
                this.templateVersionSet_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public byte[] getTemplateVersionSetAsBytes() {
            Object obj = this.templateVersionSet_;
            if (!(obj instanceof String)) {
                return (byte[]) obj;
            }
            obj = Internal.toByteArray((String) obj);
            this.templateVersionSet_ = obj;
            return obj;
        }

        public String getUsageContext(int i) {
            return (String) this.usageContext_.get(i);
        }

        public byte[] getUsageContextAsBytes(int i) {
            return this.usageContext_.getByteArray(i);
        }

        public int getUsageContextCount() {
            return this.usageContext_ == null ? 0 : this.usageContext_.size();
        }

        public List getUsageContextList() {
            return this.usageContext_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.usageContext_);
        }

        public List getUsageContextListAsBytes() {
            return this.usageContext_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.usageContext_.asByteArrayList());
        }

        public Value getValue(int i) {
            return (Value) this.value_.get(i);
        }

        public int getValueCount() {
            return this.value_ == null ? 0 : this.value_.size();
        }

        public List getValueList() {
            return this.value_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.value_);
        }

        public String getVersion() {
            Object obj = this.version_;
            if (obj instanceof String) {
                return (String) obj;
            }
            byte[] bArr = (byte[]) obj;
            String toStringUtf8 = Internal.toStringUtf8(bArr);
            if (Internal.isValidUtf8(bArr)) {
                this.version_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public byte[] getVersionAsBytes() {
            Object obj = this.version_;
            if (!(obj instanceof String)) {
                return (byte[]) obj;
            }
            obj = Internal.toByteArray((String) obj);
            this.version_ = obj;
            return obj;
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
            int i = 41;
            if (getKeyCount() > 0) {
                i = 80454 + getKeyList().hashCode();
            }
            if (getValueCount() > 0) {
                i = (((i * 37) + 2) * 53) + getValueList().hashCode();
            }
            if (getPropertyCount() > 0) {
                i = (((i * 37) + 3) * 53) + getPropertyList().hashCode();
            }
            if (getMacroCount() > 0) {
                i = (((i * 37) + 4) * 53) + getMacroList().hashCode();
            }
            if (getTagCount() > 0) {
                i = (((i * 37) + 5) * 53) + getTagList().hashCode();
            }
            if (getPredicateCount() > 0) {
                i = (((i * 37) + 6) * 53) + getPredicateList().hashCode();
            }
            if (getRuleCount() > 0) {
                i = (((i * 37) + 7) * 53) + getRuleList().hashCode();
            }
            if (hasPreviewAuthCode()) {
                i = (((i * 37) + 9) * 53) + getPreviewAuthCode().hashCode();
            }
            if (hasMalwareScanAuthCode()) {
                i = (((i * 37) + 10) * 53) + getMalwareScanAuthCode().hashCode();
            }
            if (hasTemplateVersionSet()) {
                i = (((i * 37) + 12) * 53) + getTemplateVersionSet().hashCode();
            }
            if (hasVersion()) {
                i = (((i * 37) + 13) * 53) + getVersion().hashCode();
            }
            if (hasLiveJsCacheOption()) {
                i = (((i * 37) + 14) * 53) + getLiveJsCacheOption().hashCode();
            }
            if (hasReportingSampleRate()) {
                i = (((i * 37) + 15) * 53) + Float.floatToIntBits(getReportingSampleRate());
            }
            if (hasEnableAutoEventTracking()) {
                i = (((i * 37) + 18) * 53) + Internal.hashBoolean(getEnableAutoEventTracking());
            }
            if (getUsageContextCount() > 0) {
                i = (((i * 37) + 16) * 53) + getUsageContextList().hashCode();
            }
            if (hasResourceFormatVersion()) {
                i = (((i * 37) + 17) * 53) + getResourceFormatVersion();
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.containertag.proto.Serving$Resource");
            }
            return immutableDefault;
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

        public Resource mergeFrom(Resource resource) {
            if (this == resource) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (resource != getDefaultInstance()) {
                byte[] bArr;
                if (!(resource.key_ == null || resource.key_.isEmpty())) {
                    ensureKeyInitialized();
                    this.key_.mergeFrom(resource.key_);
                }
                if (!(resource.value_ == null || resource.value_.isEmpty())) {
                    ensureValueInitialized();
                    AbstractMutableMessageLite.addAll(resource.value_, this.value_);
                }
                if (!(resource.property_ == null || resource.property_.isEmpty())) {
                    ensurePropertyInitialized();
                    AbstractMutableMessageLite.addAll(resource.property_, this.property_);
                }
                if (!(resource.macro_ == null || resource.macro_.isEmpty())) {
                    ensureMacroInitialized();
                    AbstractMutableMessageLite.addAll(resource.macro_, this.macro_);
                }
                if (!(resource.tag_ == null || resource.tag_.isEmpty())) {
                    ensureTagInitialized();
                    AbstractMutableMessageLite.addAll(resource.tag_, this.tag_);
                }
                if (!(resource.predicate_ == null || resource.predicate_.isEmpty())) {
                    ensurePredicateInitialized();
                    AbstractMutableMessageLite.addAll(resource.predicate_, this.predicate_);
                }
                if (!(resource.rule_ == null || resource.rule_.isEmpty())) {
                    ensureRuleInitialized();
                    AbstractMutableMessageLite.addAll(resource.rule_, this.rule_);
                }
                if (resource.hasPreviewAuthCode()) {
                    this.bitField0_ |= 1;
                    if (resource.previewAuthCode_ instanceof String) {
                        this.previewAuthCode_ = resource.previewAuthCode_;
                    } else {
                        bArr = (byte[]) resource.previewAuthCode_;
                        this.previewAuthCode_ = Arrays.copyOf(bArr, bArr.length);
                    }
                }
                if (resource.hasMalwareScanAuthCode()) {
                    this.bitField0_ |= 2;
                    if (resource.malwareScanAuthCode_ instanceof String) {
                        this.malwareScanAuthCode_ = resource.malwareScanAuthCode_;
                    } else {
                        bArr = (byte[]) resource.malwareScanAuthCode_;
                        this.malwareScanAuthCode_ = Arrays.copyOf(bArr, bArr.length);
                    }
                }
                if (resource.hasTemplateVersionSet()) {
                    this.bitField0_ |= 4;
                    if (resource.templateVersionSet_ instanceof String) {
                        this.templateVersionSet_ = resource.templateVersionSet_;
                    } else {
                        bArr = (byte[]) resource.templateVersionSet_;
                        this.templateVersionSet_ = Arrays.copyOf(bArr, bArr.length);
                    }
                }
                if (resource.hasVersion()) {
                    this.bitField0_ |= 8;
                    if (resource.version_ instanceof String) {
                        this.version_ = resource.version_;
                    } else {
                        bArr = (byte[]) resource.version_;
                        this.version_ = Arrays.copyOf(bArr, bArr.length);
                    }
                }
                if (resource.hasLiveJsCacheOption()) {
                    ensureLiveJsCacheOptionInitialized();
                    this.liveJsCacheOption_.mergeFrom(resource.getLiveJsCacheOption());
                    this.bitField0_ |= 16;
                }
                if (resource.hasReportingSampleRate()) {
                    setReportingSampleRate(resource.getReportingSampleRate());
                }
                if (!(resource.usageContext_ == null || resource.usageContext_.isEmpty())) {
                    ensureUsageContextInitialized();
                    this.usageContext_.mergeFrom(resource.usageContext_);
                }
                if (resource.hasResourceFormatVersion()) {
                    setResourceFormatVersion(resource.getResourceFormatVersion());
                }
                if (resource.hasEnableAutoEventTracking()) {
                    setEnableAutoEventTracking(resource.getEnableAutoEventTracking());
                }
                this.unknownFields = this.unknownFields.concat(resource.unknownFields);
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
                            ensureKeyInitialized();
                            this.key_.add(codedInputStream.readByteArray());
                            break;
                        case 18:
                            codedInputStream.readMessage(addValue(), extensionRegistryLite);
                            break;
                        case 26:
                            codedInputStream.readMessage(addProperty(), extensionRegistryLite);
                            break;
                        case 34:
                            codedInputStream.readMessage(addMacro(), extensionRegistryLite);
                            break;
                        case 42:
                            codedInputStream.readMessage(addTag(), extensionRegistryLite);
                            break;
                        case 50:
                            codedInputStream.readMessage(addPredicate(), extensionRegistryLite);
                            break;
                        case 58:
                            codedInputStream.readMessage(addRule(), extensionRegistryLite);
                            break;
                        case 74:
                            this.bitField0_ |= 1;
                            this.previewAuthCode_ = codedInputStream.readByteArray();
                            break;
                        case 82:
                            this.bitField0_ |= 2;
                            this.malwareScanAuthCode_ = codedInputStream.readByteArray();
                            break;
                        case 98:
                            this.bitField0_ |= 4;
                            this.templateVersionSet_ = codedInputStream.readByteArray();
                            break;
                        case 106:
                            this.bitField0_ |= 8;
                            this.version_ = codedInputStream.readByteArray();
                            break;
                        case 114:
                            if (this.liveJsCacheOption_ == CacheOption.getDefaultInstance()) {
                                this.liveJsCacheOption_ = CacheOption.newMessage();
                            }
                            this.bitField0_ |= 16;
                            codedInputStream.readMessage(this.liveJsCacheOption_, extensionRegistryLite);
                            break;
                        case 125:
                            this.bitField0_ |= 32;
                            this.reportingSampleRate_ = codedInputStream.readFloat();
                            break;
                        case 130:
                            ensureUsageContextInitialized();
                            this.usageContext_.add(codedInputStream.readByteArray());
                            break;
                        case 136:
                            this.bitField0_ |= 128;
                            this.resourceFormatVersion_ = codedInputStream.readInt32();
                            break;
                        case 144:
                            this.bitField0_ |= 64;
                            this.enableAutoEventTracking_ = codedInputStream.readBool();
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

        public Resource newMessageForType() {
            return new Resource();
        }

        public Resource setEnableAutoEventTracking(boolean z) {
            assertMutable();
            this.bitField0_ |= 64;
            this.enableAutoEventTracking_ = z;
            return this;
        }

        public Resource setKey(int i, String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            ensureKeyInitialized();
            this.key_.set(i, str);
            return this;
        }

        public Resource setKeyAsBytes(int i, byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            ensureKeyInitialized();
            this.key_.set(i, bArr);
            return this;
        }

        public Resource setLiveJsCacheOption(CacheOption cacheOption) {
            assertMutable();
            if (cacheOption == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 16;
            this.liveJsCacheOption_ = cacheOption;
            return this;
        }

        public Resource setMacro(int i, FunctionCall functionCall) {
            assertMutable();
            if (functionCall == null) {
                throw new NullPointerException();
            }
            ensureMacroInitialized();
            this.macro_.set(i, functionCall);
            return this;
        }

        public Resource setMalwareScanAuthCode(String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.malwareScanAuthCode_ = str;
            return this;
        }

        public Resource setMalwareScanAuthCodeAsBytes(byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.malwareScanAuthCode_ = bArr;
            return this;
        }

        public Resource setPredicate(int i, FunctionCall functionCall) {
            assertMutable();
            if (functionCall == null) {
                throw new NullPointerException();
            }
            ensurePredicateInitialized();
            this.predicate_.set(i, functionCall);
            return this;
        }

        public Resource setPreviewAuthCode(String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.previewAuthCode_ = str;
            return this;
        }

        public Resource setPreviewAuthCodeAsBytes(byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.previewAuthCode_ = bArr;
            return this;
        }

        public Resource setProperty(int i, Property property) {
            assertMutable();
            if (property == null) {
                throw new NullPointerException();
            }
            ensurePropertyInitialized();
            this.property_.set(i, property);
            return this;
        }

        public Resource setReportingSampleRate(float f) {
            assertMutable();
            this.bitField0_ |= 32;
            this.reportingSampleRate_ = f;
            return this;
        }

        public Resource setResourceFormatVersion(int i) {
            assertMutable();
            this.bitField0_ |= 128;
            this.resourceFormatVersion_ = i;
            return this;
        }

        public Resource setRule(int i, Rule rule) {
            assertMutable();
            if (rule == null) {
                throw new NullPointerException();
            }
            ensureRuleInitialized();
            this.rule_.set(i, rule);
            return this;
        }

        public Resource setTag(int i, FunctionCall functionCall) {
            assertMutable();
            if (functionCall == null) {
                throw new NullPointerException();
            }
            ensureTagInitialized();
            this.tag_.set(i, functionCall);
            return this;
        }

        public Resource setTemplateVersionSet(String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 4;
            this.templateVersionSet_ = str;
            return this;
        }

        public Resource setTemplateVersionSetAsBytes(byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 4;
            this.templateVersionSet_ = bArr;
            return this;
        }

        public Resource setUsageContext(int i, String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            ensureUsageContextInitialized();
            this.usageContext_.set(i, str);
            return this;
        }

        public Resource setUsageContextAsBytes(int i, byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            ensureUsageContextInitialized();
            this.usageContext_.set(i, bArr);
            return this;
        }

        public Resource setValue(int i, Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureValueInitialized();
            this.value_.set(i, value);
            return this;
        }

        public Resource setVersion(String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 8;
            this.version_ = str;
            return this;
        }

        public Resource setVersionAsBytes(byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 8;
            this.version_ = bArr;
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int i;
            int i2 = 0;
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            if (this.key_ != null) {
                for (int i3 = 0; i3 < this.key_.size(); i3++) {
                    codedOutputStream.writeByteArray(1, this.key_.getByteArray(i3));
                }
            }
            if (this.value_ != null) {
                for (i = 0; i < this.value_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(2, (MutableMessageLite) this.value_.get(i));
                }
            }
            if (this.property_ != null) {
                for (i = 0; i < this.property_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(3, (MutableMessageLite) this.property_.get(i));
                }
            }
            if (this.macro_ != null) {
                for (i = 0; i < this.macro_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(4, (MutableMessageLite) this.macro_.get(i));
                }
            }
            if (this.tag_ != null) {
                for (i = 0; i < this.tag_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(5, (MutableMessageLite) this.tag_.get(i));
                }
            }
            if (this.predicate_ != null) {
                for (i = 0; i < this.predicate_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(6, (MutableMessageLite) this.predicate_.get(i));
                }
            }
            if (this.rule_ != null) {
                for (i = 0; i < this.rule_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(7, (MutableMessageLite) this.rule_.get(i));
                }
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeByteArray(9, getPreviewAuthCodeAsBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeByteArray(10, getMalwareScanAuthCodeAsBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeByteArray(12, getTemplateVersionSetAsBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeByteArray(13, getVersionAsBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeMessageWithCachedSizes(14, this.liveJsCacheOption_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeFloat(15, this.reportingSampleRate_);
            }
            if (this.usageContext_ != null) {
                while (i2 < this.usageContext_.size()) {
                    codedOutputStream.writeByteArray(16, this.usageContext_.getByteArray(i2));
                    i2++;
                }
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeInt32(17, this.resourceFormatVersion_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeBool(18, this.enableAutoEventTracking_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
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
            internalValueMap = new C0162m();
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
            internalValueMap = new C0163n();
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

    public final class Rule extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static final int ADD_MACRO_FIELD_NUMBER = 7;
        public static final int ADD_MACRO_RULE_NAME_FIELD_NUMBER = 9;
        public static final int ADD_TAG_FIELD_NUMBER = 3;
        public static final int ADD_TAG_RULE_NAME_FIELD_NUMBER = 5;
        public static final int NEGATIVE_PREDICATE_FIELD_NUMBER = 2;
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        public static final int POSITIVE_PREDICATE_FIELD_NUMBER = 1;
        public static final int REMOVE_MACRO_FIELD_NUMBER = 8;
        public static final int REMOVE_MACRO_RULE_NAME_FIELD_NUMBER = 10;
        public static final int REMOVE_TAG_FIELD_NUMBER = 4;
        public static final int REMOVE_TAG_RULE_NAME_FIELD_NUMBER = 6;
        private static final Rule defaultInstance = new Rule(true);
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private List addMacroRuleName_ = null;
        private List addMacro_ = null;
        private List addTagRuleName_ = null;
        private List addTag_ = null;
        private List negativePredicate_ = null;
        private List positivePredicate_ = null;
        private List removeMacroRuleName_ = null;
        private List removeMacro_ = null;
        private List removeTagRuleName_ = null;
        private List removeTag_ = null;

        static {
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
        }

        private Rule() {
            initFields();
        }

        private Rule(boolean z) {
        }

        private void ensureAddMacroInitialized() {
            if (this.addMacro_ == null) {
                this.addMacro_ = new ArrayList();
            }
        }

        private void ensureAddMacroRuleNameInitialized() {
            if (this.addMacroRuleName_ == null) {
                this.addMacroRuleName_ = new ArrayList();
            }
        }

        private void ensureAddTagInitialized() {
            if (this.addTag_ == null) {
                this.addTag_ = new ArrayList();
            }
        }

        private void ensureAddTagRuleNameInitialized() {
            if (this.addTagRuleName_ == null) {
                this.addTagRuleName_ = new ArrayList();
            }
        }

        private void ensureNegativePredicateInitialized() {
            if (this.negativePredicate_ == null) {
                this.negativePredicate_ = new ArrayList();
            }
        }

        private void ensurePositivePredicateInitialized() {
            if (this.positivePredicate_ == null) {
                this.positivePredicate_ = new ArrayList();
            }
        }

        private void ensureRemoveMacroInitialized() {
            if (this.removeMacro_ == null) {
                this.removeMacro_ = new ArrayList();
            }
        }

        private void ensureRemoveMacroRuleNameInitialized() {
            if (this.removeMacroRuleName_ == null) {
                this.removeMacroRuleName_ = new ArrayList();
            }
        }

        private void ensureRemoveTagInitialized() {
            if (this.removeTag_ == null) {
                this.removeTag_ = new ArrayList();
            }
        }

        private void ensureRemoveTagRuleNameInitialized() {
            if (this.removeTagRuleName_ == null) {
                this.removeTagRuleName_ = new ArrayList();
            }
        }

        public static Rule getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static Rule newMessage() {
            return new Rule();
        }

        public Rule addAddMacro(int i) {
            assertMutable();
            ensureAddMacroInitialized();
            this.addMacro_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addAddMacroRuleName(int i) {
            assertMutable();
            ensureAddMacroRuleNameInitialized();
            this.addMacroRuleName_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addAddTag(int i) {
            assertMutable();
            ensureAddTagInitialized();
            this.addTag_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addAddTagRuleName(int i) {
            assertMutable();
            ensureAddTagRuleNameInitialized();
            this.addTagRuleName_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addAllAddMacro(Iterable iterable) {
            assertMutable();
            ensureAddMacroInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.addMacro_);
            return this;
        }

        public Rule addAllAddMacroRuleName(Iterable iterable) {
            assertMutable();
            ensureAddMacroRuleNameInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.addMacroRuleName_);
            return this;
        }

        public Rule addAllAddTag(Iterable iterable) {
            assertMutable();
            ensureAddTagInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.addTag_);
            return this;
        }

        public Rule addAllAddTagRuleName(Iterable iterable) {
            assertMutable();
            ensureAddTagRuleNameInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.addTagRuleName_);
            return this;
        }

        public Rule addAllNegativePredicate(Iterable iterable) {
            assertMutable();
            ensureNegativePredicateInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.negativePredicate_);
            return this;
        }

        public Rule addAllPositivePredicate(Iterable iterable) {
            assertMutable();
            ensurePositivePredicateInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.positivePredicate_);
            return this;
        }

        public Rule addAllRemoveMacro(Iterable iterable) {
            assertMutable();
            ensureRemoveMacroInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.removeMacro_);
            return this;
        }

        public Rule addAllRemoveMacroRuleName(Iterable iterable) {
            assertMutable();
            ensureRemoveMacroRuleNameInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.removeMacroRuleName_);
            return this;
        }

        public Rule addAllRemoveTag(Iterable iterable) {
            assertMutable();
            ensureRemoveTagInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.removeTag_);
            return this;
        }

        public Rule addAllRemoveTagRuleName(Iterable iterable) {
            assertMutable();
            ensureRemoveTagRuleNameInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.removeTagRuleName_);
            return this;
        }

        public Rule addNegativePredicate(int i) {
            assertMutable();
            ensureNegativePredicateInitialized();
            this.negativePredicate_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addPositivePredicate(int i) {
            assertMutable();
            ensurePositivePredicateInitialized();
            this.positivePredicate_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addRemoveMacro(int i) {
            assertMutable();
            ensureRemoveMacroInitialized();
            this.removeMacro_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addRemoveMacroRuleName(int i) {
            assertMutable();
            ensureRemoveMacroRuleNameInitialized();
            this.removeMacroRuleName_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addRemoveTag(int i) {
            assertMutable();
            ensureRemoveTagInitialized();
            this.removeTag_.add(Integer.valueOf(i));
            return this;
        }

        public Rule addRemoveTagRuleName(int i) {
            assertMutable();
            ensureRemoveTagRuleNameInitialized();
            this.removeTagRuleName_.add(Integer.valueOf(i));
            return this;
        }

        public Rule clear() {
            assertMutable();
            super.clear();
            this.positivePredicate_ = null;
            this.negativePredicate_ = null;
            this.addTag_ = null;
            this.removeTag_ = null;
            this.addTagRuleName_ = null;
            this.removeTagRuleName_ = null;
            this.addMacro_ = null;
            this.removeMacro_ = null;
            this.addMacroRuleName_ = null;
            this.removeMacroRuleName_ = null;
            return this;
        }

        public Rule clearAddMacro() {
            assertMutable();
            this.addMacro_ = null;
            return this;
        }

        public Rule clearAddMacroRuleName() {
            assertMutable();
            this.addMacroRuleName_ = null;
            return this;
        }

        public Rule clearAddTag() {
            assertMutable();
            this.addTag_ = null;
            return this;
        }

        public Rule clearAddTagRuleName() {
            assertMutable();
            this.addTagRuleName_ = null;
            return this;
        }

        public Rule clearNegativePredicate() {
            assertMutable();
            this.negativePredicate_ = null;
            return this;
        }

        public Rule clearPositivePredicate() {
            assertMutable();
            this.positivePredicate_ = null;
            return this;
        }

        public Rule clearRemoveMacro() {
            assertMutable();
            this.removeMacro_ = null;
            return this;
        }

        public Rule clearRemoveMacroRuleName() {
            assertMutable();
            this.removeMacroRuleName_ = null;
            return this;
        }

        public Rule clearRemoveTag() {
            assertMutable();
            this.removeTag_ = null;
            return this;
        }

        public Rule clearRemoveTagRuleName() {
            assertMutable();
            this.removeTagRuleName_ = null;
            return this;
        }

        public Rule clone() {
            return newMessageForType().mergeFrom(this);
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
            return this.addMacro_ == null ? 0 : this.addMacro_.size();
        }

        public List getAddMacroList() {
            return this.addMacro_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.addMacro_);
        }

        public int getAddMacroRuleName(int i) {
            return ((Integer) this.addMacroRuleName_.get(i)).intValue();
        }

        public int getAddMacroRuleNameCount() {
            return this.addMacroRuleName_ == null ? 0 : this.addMacroRuleName_.size();
        }

        public List getAddMacroRuleNameList() {
            return this.addMacroRuleName_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.addMacroRuleName_);
        }

        public int getAddTag(int i) {
            return ((Integer) this.addTag_.get(i)).intValue();
        }

        public int getAddTagCount() {
            return this.addTag_ == null ? 0 : this.addTag_.size();
        }

        public List getAddTagList() {
            return this.addTag_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.addTag_);
        }

        public int getAddTagRuleName(int i) {
            return ((Integer) this.addTagRuleName_.get(i)).intValue();
        }

        public int getAddTagRuleNameCount() {
            return this.addTagRuleName_ == null ? 0 : this.addTagRuleName_.size();
        }

        public List getAddTagRuleNameList() {
            return this.addTagRuleName_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.addTagRuleName_);
        }

        public final Rule getDefaultInstanceForType() {
            return defaultInstance;
        }

        public List getMutableAddMacroList() {
            assertMutable();
            ensureAddMacroInitialized();
            return this.addMacro_;
        }

        public List getMutableAddMacroRuleNameList() {
            assertMutable();
            ensureAddMacroRuleNameInitialized();
            return this.addMacroRuleName_;
        }

        public List getMutableAddTagList() {
            assertMutable();
            ensureAddTagInitialized();
            return this.addTag_;
        }

        public List getMutableAddTagRuleNameList() {
            assertMutable();
            ensureAddTagRuleNameInitialized();
            return this.addTagRuleName_;
        }

        public List getMutableNegativePredicateList() {
            assertMutable();
            ensureNegativePredicateInitialized();
            return this.negativePredicate_;
        }

        public List getMutablePositivePredicateList() {
            assertMutable();
            ensurePositivePredicateInitialized();
            return this.positivePredicate_;
        }

        public List getMutableRemoveMacroList() {
            assertMutable();
            ensureRemoveMacroInitialized();
            return this.removeMacro_;
        }

        public List getMutableRemoveMacroRuleNameList() {
            assertMutable();
            ensureRemoveMacroRuleNameInitialized();
            return this.removeMacroRuleName_;
        }

        public List getMutableRemoveTagList() {
            assertMutable();
            ensureRemoveTagInitialized();
            return this.removeTag_;
        }

        public List getMutableRemoveTagRuleNameList() {
            assertMutable();
            ensureRemoveTagRuleNameInitialized();
            return this.removeTagRuleName_;
        }

        public int getNegativePredicate(int i) {
            return ((Integer) this.negativePredicate_.get(i)).intValue();
        }

        public int getNegativePredicateCount() {
            return this.negativePredicate_ == null ? 0 : this.negativePredicate_.size();
        }

        public List getNegativePredicateList() {
            return this.negativePredicate_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.negativePredicate_);
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public int getPositivePredicate(int i) {
            return ((Integer) this.positivePredicate_.get(i)).intValue();
        }

        public int getPositivePredicateCount() {
            return this.positivePredicate_ == null ? 0 : this.positivePredicate_.size();
        }

        public List getPositivePredicateList() {
            return this.positivePredicate_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.positivePredicate_);
        }

        public int getRemoveMacro(int i) {
            return ((Integer) this.removeMacro_.get(i)).intValue();
        }

        public int getRemoveMacroCount() {
            return this.removeMacro_ == null ? 0 : this.removeMacro_.size();
        }

        public List getRemoveMacroList() {
            return this.removeMacro_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.removeMacro_);
        }

        public int getRemoveMacroRuleName(int i) {
            return ((Integer) this.removeMacroRuleName_.get(i)).intValue();
        }

        public int getRemoveMacroRuleNameCount() {
            return this.removeMacroRuleName_ == null ? 0 : this.removeMacroRuleName_.size();
        }

        public List getRemoveMacroRuleNameList() {
            return this.removeMacroRuleName_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.removeMacroRuleName_);
        }

        public int getRemoveTag(int i) {
            return ((Integer) this.removeTag_.get(i)).intValue();
        }

        public int getRemoveTagCount() {
            return this.removeTag_ == null ? 0 : this.removeTag_.size();
        }

        public List getRemoveTagList() {
            return this.removeTag_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.removeTag_);
        }

        public int getRemoveTagRuleName(int i) {
            return ((Integer) this.removeTagRuleName_.get(i)).intValue();
        }

        public int getRemoveTagRuleNameCount() {
            return this.removeTagRuleName_ == null ? 0 : this.removeTagRuleName_.size();
        }

        public List getRemoveTagRuleNameList() {
            return this.removeTagRuleName_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.removeTagRuleName_);
        }

        public int getSerializedSize() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            if (this.positivePredicate_ == null || this.positivePredicate_.size() <= 0) {
                i = 0;
            } else {
                i2 = 0;
                for (i = 0; i < this.positivePredicate_.size(); i++) {
                    i2 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.positivePredicate_.get(i)).intValue());
                }
                i = (0 + i2) + (getPositivePredicateList().size() * 1);
            }
            if (this.negativePredicate_ != null && this.negativePredicate_.size() > 0) {
                i3 = 0;
                for (i2 = 0; i2 < this.negativePredicate_.size(); i2++) {
                    i3 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.negativePredicate_.get(i2)).intValue());
                }
                i = (getNegativePredicateList().size() * 1) + (i + i3);
            }
            if (this.addTag_ != null && this.addTag_.size() > 0) {
                i3 = 0;
                for (i2 = 0; i2 < this.addTag_.size(); i2++) {
                    i3 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.addTag_.get(i2)).intValue());
                }
                i = (getAddTagList().size() * 1) + (i + i3);
            }
            if (this.removeTag_ != null && this.removeTag_.size() > 0) {
                i3 = 0;
                for (i2 = 0; i2 < this.removeTag_.size(); i2++) {
                    i3 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.removeTag_.get(i2)).intValue());
                }
                i = (getRemoveTagList().size() * 1) + (i + i3);
            }
            if (this.addTagRuleName_ != null && this.addTagRuleName_.size() > 0) {
                i3 = 0;
                for (i2 = 0; i2 < this.addTagRuleName_.size(); i2++) {
                    i3 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.addTagRuleName_.get(i2)).intValue());
                }
                i = (getAddTagRuleNameList().size() * 1) + (i + i3);
            }
            if (this.removeTagRuleName_ != null && this.removeTagRuleName_.size() > 0) {
                i3 = 0;
                for (i2 = 0; i2 < this.removeTagRuleName_.size(); i2++) {
                    i3 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.removeTagRuleName_.get(i2)).intValue());
                }
                i = (getRemoveTagRuleNameList().size() * 1) + (i + i3);
            }
            if (this.addMacro_ != null && this.addMacro_.size() > 0) {
                i3 = 0;
                for (i2 = 0; i2 < this.addMacro_.size(); i2++) {
                    i3 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.addMacro_.get(i2)).intValue());
                }
                i = (getAddMacroList().size() * 1) + (i + i3);
            }
            if (this.removeMacro_ != null && this.removeMacro_.size() > 0) {
                i3 = 0;
                for (i2 = 0; i2 < this.removeMacro_.size(); i2++) {
                    i3 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.removeMacro_.get(i2)).intValue());
                }
                i = (getRemoveMacroList().size() * 1) + (i + i3);
            }
            if (this.addMacroRuleName_ != null && this.addMacroRuleName_.size() > 0) {
                i3 = 0;
                for (i2 = 0; i2 < this.addMacroRuleName_.size(); i2++) {
                    i3 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.addMacroRuleName_.get(i2)).intValue());
                }
                i = (getAddMacroRuleNameList().size() * 1) + (i + i3);
            }
            if (this.removeMacroRuleName_ != null && this.removeMacroRuleName_.size() > 0) {
                i2 = 0;
                while (i4 < this.removeMacroRuleName_.size()) {
                    i4++;
                    i2 = CodedOutputStream.computeInt32SizeNoTag(((Integer) this.removeMacroRuleName_.get(i4)).intValue()) + i2;
                }
                i = (getRemoveMacroRuleNameList().size() * 1) + (i + i2);
            }
            int size = this.unknownFields.size() + i;
            this.cachedSize = size;
            return size;
        }

        public int hashCode() {
            int i = 41;
            if (getPositivePredicateCount() > 0) {
                i = 80454 + getPositivePredicateList().hashCode();
            }
            if (getNegativePredicateCount() > 0) {
                i = (((i * 37) + 2) * 53) + getNegativePredicateList().hashCode();
            }
            if (getAddTagCount() > 0) {
                i = (((i * 37) + 3) * 53) + getAddTagList().hashCode();
            }
            if (getRemoveTagCount() > 0) {
                i = (((i * 37) + 4) * 53) + getRemoveTagList().hashCode();
            }
            if (getAddTagRuleNameCount() > 0) {
                i = (((i * 37) + 5) * 53) + getAddTagRuleNameList().hashCode();
            }
            if (getRemoveTagRuleNameCount() > 0) {
                i = (((i * 37) + 6) * 53) + getRemoveTagRuleNameList().hashCode();
            }
            if (getAddMacroCount() > 0) {
                i = (((i * 37) + 7) * 53) + getAddMacroList().hashCode();
            }
            if (getRemoveMacroCount() > 0) {
                i = (((i * 37) + 8) * 53) + getRemoveMacroList().hashCode();
            }
            if (getAddMacroRuleNameCount() > 0) {
                i = (((i * 37) + 9) * 53) + getAddMacroRuleNameList().hashCode();
            }
            if (getRemoveMacroRuleNameCount() > 0) {
                i = (((i * 37) + 10) * 53) + getRemoveMacroRuleNameList().hashCode();
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.containertag.proto.Serving$Rule");
            }
            return immutableDefault;
        }

        public final boolean isInitialized() {
            return true;
        }

        public Rule mergeFrom(Rule rule) {
            if (this == rule) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (rule != getDefaultInstance()) {
                if (!(rule.positivePredicate_ == null || rule.positivePredicate_.isEmpty())) {
                    ensurePositivePredicateInitialized();
                    this.positivePredicate_.addAll(rule.positivePredicate_);
                }
                if (!(rule.negativePredicate_ == null || rule.negativePredicate_.isEmpty())) {
                    ensureNegativePredicateInitialized();
                    this.negativePredicate_.addAll(rule.negativePredicate_);
                }
                if (!(rule.addTag_ == null || rule.addTag_.isEmpty())) {
                    ensureAddTagInitialized();
                    this.addTag_.addAll(rule.addTag_);
                }
                if (!(rule.removeTag_ == null || rule.removeTag_.isEmpty())) {
                    ensureRemoveTagInitialized();
                    this.removeTag_.addAll(rule.removeTag_);
                }
                if (!(rule.addTagRuleName_ == null || rule.addTagRuleName_.isEmpty())) {
                    ensureAddTagRuleNameInitialized();
                    this.addTagRuleName_.addAll(rule.addTagRuleName_);
                }
                if (!(rule.removeTagRuleName_ == null || rule.removeTagRuleName_.isEmpty())) {
                    ensureRemoveTagRuleNameInitialized();
                    this.removeTagRuleName_.addAll(rule.removeTagRuleName_);
                }
                if (!(rule.addMacro_ == null || rule.addMacro_.isEmpty())) {
                    ensureAddMacroInitialized();
                    this.addMacro_.addAll(rule.addMacro_);
                }
                if (!(rule.removeMacro_ == null || rule.removeMacro_.isEmpty())) {
                    ensureRemoveMacroInitialized();
                    this.removeMacro_.addAll(rule.removeMacro_);
                }
                if (!(rule.addMacroRuleName_ == null || rule.addMacroRuleName_.isEmpty())) {
                    ensureAddMacroRuleNameInitialized();
                    this.addMacroRuleName_.addAll(rule.addMacroRuleName_);
                }
                if (!(rule.removeMacroRuleName_ == null || rule.removeMacroRuleName_.isEmpty())) {
                    ensureRemoveMacroRuleNameInitialized();
                    this.removeMacroRuleName_.addAll(rule.removeMacroRuleName_);
                }
                this.unknownFields = this.unknownFields.concat(rule.unknownFields);
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
                            if (this.positivePredicate_ == null) {
                                this.positivePredicate_ = new ArrayList();
                            }
                            this.positivePredicate_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 10:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (this.positivePredicate_ == null) {
                                this.positivePredicate_ = new ArrayList();
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.positivePredicate_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 16:
                            if (this.negativePredicate_ == null) {
                                this.negativePredicate_ = new ArrayList();
                            }
                            this.negativePredicate_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 18:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (this.negativePredicate_ == null) {
                                this.negativePredicate_ = new ArrayList();
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.negativePredicate_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 24:
                            if (this.addTag_ == null) {
                                this.addTag_ = new ArrayList();
                            }
                            this.addTag_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 26:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (this.addTag_ == null) {
                                this.addTag_ = new ArrayList();
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.addTag_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 32:
                            if (this.removeTag_ == null) {
                                this.removeTag_ = new ArrayList();
                            }
                            this.removeTag_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 34:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (this.removeTag_ == null) {
                                this.removeTag_ = new ArrayList();
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.removeTag_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 40:
                            if (this.addTagRuleName_ == null) {
                                this.addTagRuleName_ = new ArrayList();
                            }
                            this.addTagRuleName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 42:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (this.addTagRuleName_ == null) {
                                this.addTagRuleName_ = new ArrayList();
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.addTagRuleName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 48:
                            if (this.removeTagRuleName_ == null) {
                                this.removeTagRuleName_ = new ArrayList();
                            }
                            this.removeTagRuleName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 50:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (this.removeTagRuleName_ == null) {
                                this.removeTagRuleName_ = new ArrayList();
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.removeTagRuleName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 56:
                            if (this.addMacro_ == null) {
                                this.addMacro_ = new ArrayList();
                            }
                            this.addMacro_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 58:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (this.addMacro_ == null) {
                                this.addMacro_ = new ArrayList();
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.addMacro_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 64:
                            if (this.removeMacro_ == null) {
                                this.removeMacro_ = new ArrayList();
                            }
                            this.removeMacro_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 66:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (this.removeMacro_ == null) {
                                this.removeMacro_ = new ArrayList();
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.removeMacro_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 72:
                            if (this.addMacroRuleName_ == null) {
                                this.addMacroRuleName_ = new ArrayList();
                            }
                            this.addMacroRuleName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 74:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (this.addMacroRuleName_ == null) {
                                this.addMacroRuleName_ = new ArrayList();
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.addMacroRuleName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 80:
                            if (this.removeMacroRuleName_ == null) {
                                this.removeMacroRuleName_ = new ArrayList();
                            }
                            this.removeMacroRuleName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 82:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (this.removeMacroRuleName_ == null) {
                                this.removeMacroRuleName_ = new ArrayList();
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.removeMacroRuleName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
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

        public Rule newMessageForType() {
            return new Rule();
        }

        public Rule setAddMacro(int i, int i2) {
            assertMutable();
            ensureAddMacroInitialized();
            this.addMacro_.set(i, Integer.valueOf(i2));
            return this;
        }

        public Rule setAddMacroRuleName(int i, int i2) {
            assertMutable();
            ensureAddMacroRuleNameInitialized();
            this.addMacroRuleName_.set(i, Integer.valueOf(i2));
            return this;
        }

        public Rule setAddTag(int i, int i2) {
            assertMutable();
            ensureAddTagInitialized();
            this.addTag_.set(i, Integer.valueOf(i2));
            return this;
        }

        public Rule setAddTagRuleName(int i, int i2) {
            assertMutable();
            ensureAddTagRuleNameInitialized();
            this.addTagRuleName_.set(i, Integer.valueOf(i2));
            return this;
        }

        public Rule setNegativePredicate(int i, int i2) {
            assertMutable();
            ensureNegativePredicateInitialized();
            this.negativePredicate_.set(i, Integer.valueOf(i2));
            return this;
        }

        public Rule setPositivePredicate(int i, int i2) {
            assertMutable();
            ensurePositivePredicateInitialized();
            this.positivePredicate_.set(i, Integer.valueOf(i2));
            return this;
        }

        public Rule setRemoveMacro(int i, int i2) {
            assertMutable();
            ensureRemoveMacroInitialized();
            this.removeMacro_.set(i, Integer.valueOf(i2));
            return this;
        }

        public Rule setRemoveMacroRuleName(int i, int i2) {
            assertMutable();
            ensureRemoveMacroRuleNameInitialized();
            this.removeMacroRuleName_.set(i, Integer.valueOf(i2));
            return this;
        }

        public Rule setRemoveTag(int i, int i2) {
            assertMutable();
            ensureRemoveTagInitialized();
            this.removeTag_.set(i, Integer.valueOf(i2));
            return this;
        }

        public Rule setRemoveTagRuleName(int i, int i2) {
            assertMutable();
            ensureRemoveTagRuleNameInitialized();
            this.removeTagRuleName_.set(i, Integer.valueOf(i2));
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int i;
            int i2 = 0;
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            if (this.positivePredicate_ != null) {
                for (i = 0; i < this.positivePredicate_.size(); i++) {
                    codedOutputStream.writeInt32(1, ((Integer) this.positivePredicate_.get(i)).intValue());
                }
            }
            if (this.negativePredicate_ != null) {
                for (i = 0; i < this.negativePredicate_.size(); i++) {
                    codedOutputStream.writeInt32(2, ((Integer) this.negativePredicate_.get(i)).intValue());
                }
            }
            if (this.addTag_ != null) {
                for (i = 0; i < this.addTag_.size(); i++) {
                    codedOutputStream.writeInt32(3, ((Integer) this.addTag_.get(i)).intValue());
                }
            }
            if (this.removeTag_ != null) {
                for (i = 0; i < this.removeTag_.size(); i++) {
                    codedOutputStream.writeInt32(4, ((Integer) this.removeTag_.get(i)).intValue());
                }
            }
            if (this.addTagRuleName_ != null) {
                for (i = 0; i < this.addTagRuleName_.size(); i++) {
                    codedOutputStream.writeInt32(5, ((Integer) this.addTagRuleName_.get(i)).intValue());
                }
            }
            if (this.removeTagRuleName_ != null) {
                for (i = 0; i < this.removeTagRuleName_.size(); i++) {
                    codedOutputStream.writeInt32(6, ((Integer) this.removeTagRuleName_.get(i)).intValue());
                }
            }
            if (this.addMacro_ != null) {
                for (i = 0; i < this.addMacro_.size(); i++) {
                    codedOutputStream.writeInt32(7, ((Integer) this.addMacro_.get(i)).intValue());
                }
            }
            if (this.removeMacro_ != null) {
                for (i = 0; i < this.removeMacro_.size(); i++) {
                    codedOutputStream.writeInt32(8, ((Integer) this.removeMacro_.get(i)).intValue());
                }
            }
            if (this.addMacroRuleName_ != null) {
                for (i = 0; i < this.addMacroRuleName_.size(); i++) {
                    codedOutputStream.writeInt32(9, ((Integer) this.addMacroRuleName_.get(i)).intValue());
                }
            }
            if (this.removeMacroRuleName_ != null) {
                while (i2 < this.removeMacroRuleName_.size()) {
                    codedOutputStream.writeInt32(10, ((Integer) this.removeMacroRuleName_.get(i2)).intValue());
                    i2++;
                }
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    public final class ServingValue extends GeneratedMutableMessageLite implements MutableMessageLite {
        public static final int EXT_FIELD_NUMBER = 101;
        public static final int LIST_ITEM_FIELD_NUMBER = 1;
        public static final int MACRO_NAME_REFERENCE_FIELD_NUMBER = 6;
        public static final int MACRO_REFERENCE_FIELD_NUMBER = 4;
        public static final int MAP_KEY_FIELD_NUMBER = 2;
        public static final int MAP_VALUE_FIELD_NUMBER = 3;
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        public static final int TEMPLATE_TOKEN_FIELD_NUMBER = 5;
        private static final ServingValue defaultInstance = new ServingValue(true);
        public static final GeneratedExtension ext = GeneratedMessageLite.newSingularGeneratedExtension(Value.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, 101, FieldType.MESSAGE, ServingValue.class);
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List listItem_ = null;
        private int macroNameReference_;
        private int macroReference_;
        private List mapKey_ = null;
        private List mapValue_ = null;
        private List templateToken_ = null;

        static {
            defaultInstance.initFields();
            defaultInstance.makeImmutable();
        }

        private ServingValue() {
            initFields();
        }

        private ServingValue(boolean z) {
        }

        private void ensureListItemInitialized() {
            if (this.listItem_ == null) {
                this.listItem_ = new ArrayList();
            }
        }

        private void ensureMapKeyInitialized() {
            if (this.mapKey_ == null) {
                this.mapKey_ = new ArrayList();
            }
        }

        private void ensureMapValueInitialized() {
            if (this.mapValue_ == null) {
                this.mapValue_ = new ArrayList();
            }
        }

        private void ensureTemplateTokenInitialized() {
            if (this.templateToken_ == null) {
                this.templateToken_ = new ArrayList();
            }
        }

        public static ServingValue getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static ServingValue newMessage() {
            return new ServingValue();
        }

        public ServingValue addAllListItem(Iterable iterable) {
            assertMutable();
            ensureListItemInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.listItem_);
            return this;
        }

        public ServingValue addAllMapKey(Iterable iterable) {
            assertMutable();
            ensureMapKeyInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.mapKey_);
            return this;
        }

        public ServingValue addAllMapValue(Iterable iterable) {
            assertMutable();
            ensureMapValueInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.mapValue_);
            return this;
        }

        public ServingValue addAllTemplateToken(Iterable iterable) {
            assertMutable();
            ensureTemplateTokenInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.templateToken_);
            return this;
        }

        public ServingValue addListItem(int i) {
            assertMutable();
            ensureListItemInitialized();
            this.listItem_.add(Integer.valueOf(i));
            return this;
        }

        public ServingValue addMapKey(int i) {
            assertMutable();
            ensureMapKeyInitialized();
            this.mapKey_.add(Integer.valueOf(i));
            return this;
        }

        public ServingValue addMapValue(int i) {
            assertMutable();
            ensureMapValueInitialized();
            this.mapValue_.add(Integer.valueOf(i));
            return this;
        }

        public ServingValue addTemplateToken(int i) {
            assertMutable();
            ensureTemplateTokenInitialized();
            this.templateToken_.add(Integer.valueOf(i));
            return this;
        }

        public ServingValue clear() {
            assertMutable();
            super.clear();
            this.listItem_ = null;
            this.mapKey_ = null;
            this.mapValue_ = null;
            this.macroReference_ = 0;
            this.bitField0_ &= -2;
            this.templateToken_ = null;
            this.macroNameReference_ = 0;
            this.bitField0_ &= -3;
            return this;
        }

        public ServingValue clearListItem() {
            assertMutable();
            this.listItem_ = null;
            return this;
        }

        public ServingValue clearMacroNameReference() {
            assertMutable();
            this.bitField0_ &= -3;
            this.macroNameReference_ = 0;
            return this;
        }

        public ServingValue clearMacroReference() {
            assertMutable();
            this.bitField0_ &= -2;
            this.macroReference_ = 0;
            return this;
        }

        public ServingValue clearMapKey() {
            assertMutable();
            this.mapKey_ = null;
            return this;
        }

        public ServingValue clearMapValue() {
            assertMutable();
            this.mapValue_ = null;
            return this;
        }

        public ServingValue clearTemplateToken() {
            assertMutable();
            this.templateToken_ = null;
            return this;
        }

        public ServingValue clone() {
            return newMessageForType().mergeFrom(this);
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

        public final ServingValue getDefaultInstanceForType() {
            return defaultInstance;
        }

        public int getListItem(int i) {
            return ((Integer) this.listItem_.get(i)).intValue();
        }

        public int getListItemCount() {
            return this.listItem_ == null ? 0 : this.listItem_.size();
        }

        public List getListItemList() {
            return this.listItem_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.listItem_);
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
            return this.mapKey_ == null ? 0 : this.mapKey_.size();
        }

        public List getMapKeyList() {
            return this.mapKey_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.mapKey_);
        }

        public int getMapValue(int i) {
            return ((Integer) this.mapValue_.get(i)).intValue();
        }

        public int getMapValueCount() {
            return this.mapValue_ == null ? 0 : this.mapValue_.size();
        }

        public List getMapValueList() {
            return this.mapValue_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.mapValue_);
        }

        public List getMutableListItemList() {
            assertMutable();
            ensureListItemInitialized();
            return this.listItem_;
        }

        public List getMutableMapKeyList() {
            assertMutable();
            ensureMapKeyInitialized();
            return this.mapKey_;
        }

        public List getMutableMapValueList() {
            assertMutable();
            ensureMapValueInitialized();
            return this.mapValue_;
        }

        public List getMutableTemplateTokenList() {
            assertMutable();
            ensureTemplateTokenInitialized();
            return this.templateToken_;
        }

        public Parser getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            if (this.listItem_ == null || this.listItem_.size() <= 0) {
                i = 0;
            } else {
                i2 = 0;
                for (i = 0; i < this.listItem_.size(); i++) {
                    i2 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.listItem_.get(i)).intValue());
                }
                i = (0 + i2) + (getListItemList().size() * 1);
            }
            if (this.mapKey_ != null && this.mapKey_.size() > 0) {
                i3 = 0;
                for (i2 = 0; i2 < this.mapKey_.size(); i2++) {
                    i3 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.mapKey_.get(i2)).intValue());
                }
                i = (getMapKeyList().size() * 1) + (i + i3);
            }
            if (this.mapValue_ != null && this.mapValue_.size() > 0) {
                i3 = 0;
                for (i2 = 0; i2 < this.mapValue_.size(); i2++) {
                    i3 += CodedOutputStream.computeInt32SizeNoTag(((Integer) this.mapValue_.get(i2)).intValue());
                }
                i = (getMapValueList().size() * 1) + (i + i3);
            }
            if ((this.bitField0_ & 1) == 1) {
                i += CodedOutputStream.computeInt32Size(4, this.macroReference_);
            }
            if (this.templateToken_ != null && this.templateToken_.size() > 0) {
                i2 = 0;
                while (i4 < this.templateToken_.size()) {
                    i4++;
                    i2 = CodedOutputStream.computeInt32SizeNoTag(((Integer) this.templateToken_.get(i4)).intValue()) + i2;
                }
                i = (getTemplateTokenList().size() * 1) + (i + i2);
            }
            if ((this.bitField0_ & 2) == 2) {
                i += CodedOutputStream.computeInt32Size(6, this.macroNameReference_);
            }
            int size = this.unknownFields.size() + i;
            this.cachedSize = size;
            return size;
        }

        public int getTemplateToken(int i) {
            return ((Integer) this.templateToken_.get(i)).intValue();
        }

        public int getTemplateTokenCount() {
            return this.templateToken_ == null ? 0 : this.templateToken_.size();
        }

        public List getTemplateTokenList() {
            return this.templateToken_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.templateToken_);
        }

        public boolean hasMacroNameReference() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasMacroReference() {
            return (this.bitField0_ & 1) == 1;
        }

        public int hashCode() {
            int i = 41;
            if (getListItemCount() > 0) {
                i = 80454 + getListItemList().hashCode();
            }
            if (getMapKeyCount() > 0) {
                i = (((i * 37) + 2) * 53) + getMapKeyList().hashCode();
            }
            if (getMapValueCount() > 0) {
                i = (((i * 37) + 3) * 53) + getMapValueList().hashCode();
            }
            if (hasMacroReference()) {
                i = (((i * 37) + 4) * 53) + getMacroReference();
            }
            if (getTemplateTokenCount() > 0) {
                i = (((i * 37) + 5) * 53) + getTemplateTokenList().hashCode();
            }
            if (hasMacroNameReference()) {
                i = (((i * 37) + 6) * 53) + getMacroNameReference();
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.containertag.proto.Serving$ServingValue");
            }
            return immutableDefault;
        }

        public final boolean isInitialized() {
            return true;
        }

        public ServingValue mergeFrom(ServingValue servingValue) {
            if (this == servingValue) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (servingValue != getDefaultInstance()) {
                if (!(servingValue.listItem_ == null || servingValue.listItem_.isEmpty())) {
                    ensureListItemInitialized();
                    this.listItem_.addAll(servingValue.listItem_);
                }
                if (!(servingValue.mapKey_ == null || servingValue.mapKey_.isEmpty())) {
                    ensureMapKeyInitialized();
                    this.mapKey_.addAll(servingValue.mapKey_);
                }
                if (!(servingValue.mapValue_ == null || servingValue.mapValue_.isEmpty())) {
                    ensureMapValueInitialized();
                    this.mapValue_.addAll(servingValue.mapValue_);
                }
                if (servingValue.hasMacroReference()) {
                    setMacroReference(servingValue.getMacroReference());
                }
                if (!(servingValue.templateToken_ == null || servingValue.templateToken_.isEmpty())) {
                    ensureTemplateTokenInitialized();
                    this.templateToken_.addAll(servingValue.templateToken_);
                }
                if (servingValue.hasMacroNameReference()) {
                    setMacroNameReference(servingValue.getMacroNameReference());
                }
                this.unknownFields = this.unknownFields.concat(servingValue.unknownFields);
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
                            if (this.listItem_ == null) {
                                this.listItem_ = new ArrayList();
                            }
                            this.listItem_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 10:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (this.listItem_ == null) {
                                this.listItem_ = new ArrayList();
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.listItem_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 16:
                            if (this.mapKey_ == null) {
                                this.mapKey_ = new ArrayList();
                            }
                            this.mapKey_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 18:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (this.mapKey_ == null) {
                                this.mapKey_ = new ArrayList();
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.mapKey_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(readTag);
                            break;
                        case 24:
                            if (this.mapValue_ == null) {
                                this.mapValue_ = new ArrayList();
                            }
                            this.mapValue_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 26:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (this.mapValue_ == null) {
                                this.mapValue_ = new ArrayList();
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
                            if (this.templateToken_ == null) {
                                this.templateToken_ = new ArrayList();
                            }
                            this.templateToken_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 42:
                            readTag = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if (this.templateToken_ == null) {
                                this.templateToken_ = new ArrayList();
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

        public ServingValue newMessageForType() {
            return new ServingValue();
        }

        public ServingValue setListItem(int i, int i2) {
            assertMutable();
            ensureListItemInitialized();
            this.listItem_.set(i, Integer.valueOf(i2));
            return this;
        }

        public ServingValue setMacroNameReference(int i) {
            assertMutable();
            this.bitField0_ |= 2;
            this.macroNameReference_ = i;
            return this;
        }

        public ServingValue setMacroReference(int i) {
            assertMutable();
            this.bitField0_ |= 1;
            this.macroReference_ = i;
            return this;
        }

        public ServingValue setMapKey(int i, int i2) {
            assertMutable();
            ensureMapKeyInitialized();
            this.mapKey_.set(i, Integer.valueOf(i2));
            return this;
        }

        public ServingValue setMapValue(int i, int i2) {
            assertMutable();
            ensureMapValueInitialized();
            this.mapValue_.set(i, Integer.valueOf(i2));
            return this;
        }

        public ServingValue setTemplateToken(int i, int i2) {
            assertMutable();
            ensureTemplateTokenInitialized();
            this.templateToken_.set(i, Integer.valueOf(i2));
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int i;
            int i2 = 0;
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            if (this.listItem_ != null) {
                for (i = 0; i < this.listItem_.size(); i++) {
                    codedOutputStream.writeInt32(1, ((Integer) this.listItem_.get(i)).intValue());
                }
            }
            if (this.mapKey_ != null) {
                for (i = 0; i < this.mapKey_.size(); i++) {
                    codedOutputStream.writeInt32(2, ((Integer) this.mapKey_.get(i)).intValue());
                }
            }
            if (this.mapValue_ != null) {
                for (i = 0; i < this.mapValue_.size(); i++) {
                    codedOutputStream.writeInt32(3, ((Integer) this.mapValue_.get(i)).intValue());
                }
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(4, this.macroReference_);
            }
            if (this.templateToken_ != null) {
                while (i2 < this.templateToken_.size()) {
                    codedOutputStream.writeInt32(5, ((Integer) this.templateToken_.get(i2)).intValue());
                    i2++;
                }
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(6, this.macroNameReference_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    private MutableServing() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add(ServingValue.ext);
    }
}
