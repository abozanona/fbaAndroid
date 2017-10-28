package com.google.analytics.midtier.proto.containertag;

import com.google.android.vending.licensing.Policy;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableBuilder;
import com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableMessage;
import com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableMessage.ExtensionWriter;
import com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;
import com.google.tagmanager.protobuf.InvalidProtocolBufferException;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TypeSystem {

    public interface ValueOrBuilder extends ExtendableMessageOrBuilder {
        boolean getBoolean();

        boolean getContainsReferences();

        Escaping getEscaping(int i);

        int getEscapingCount();

        List getEscapingList();

        String getFunctionId();

        ByteString getFunctionIdBytes();

        long getInteger();

        Value getListItem(int i);

        int getListItemCount();

        List getListItemList();

        String getMacroReference();

        ByteString getMacroReferenceBytes();

        Value getMapKey(int i);

        int getMapKeyCount();

        List getMapKeyList();

        Value getMapValue(int i);

        int getMapValueCount();

        List getMapValueList();

        String getString();

        ByteString getStringBytes();

        Value getTemplateToken(int i);

        int getTemplateTokenCount();

        List getTemplateTokenList();

        Type getType();

        boolean hasBoolean();

        boolean hasContainsReferences();

        boolean hasFunctionId();

        boolean hasInteger();

        boolean hasMacroReference();

        boolean hasString();

        boolean hasType();
    }

    public final class Value extends ExtendableMessage implements ValueOrBuilder {
        public static final int BOOLEAN_FIELD_NUMBER = 12;
        public static final int CONTAINS_REFERENCES_FIELD_NUMBER = 9;
        public static final int ESCAPING_FIELD_NUMBER = 10;
        public static final int FUNCTION_ID_FIELD_NUMBER = 7;
        public static final int INTEGER_FIELD_NUMBER = 8;
        public static final int LIST_ITEM_FIELD_NUMBER = 3;
        public static final int MACRO_REFERENCE_FIELD_NUMBER = 6;
        public static final int MAP_KEY_FIELD_NUMBER = 4;
        public static final int MAP_VALUE_FIELD_NUMBER = 5;
        public static Parser PARSER = new C0179d();
        public static final int STRING_FIELD_NUMBER = 2;
        public static final int TEMPLATE_TOKEN_FIELD_NUMBER = 11;
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final Value defaultInstance = new Value(true);
        private static volatile MutableMessageLite mutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean boolean_;
        private boolean containsReferences_;
        private List escaping_;
        private Object functionId_;
        private long integer_;
        private List listItem_;
        private Object macroReference_;
        private List mapKey_;
        private List mapValue_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object string_;
        private List templateToken_;
        private Type type_;
        private final ByteString unknownFields;

        public final class Builder extends ExtendableBuilder implements ValueOrBuilder {
            private int bitField0_;
            private boolean boolean_;
            private boolean containsReferences_;
            private List escaping_ = Collections.emptyList();
            private Object functionId_ = "";
            private long integer_;
            private List listItem_ = Collections.emptyList();
            private Object macroReference_ = "";
            private List mapKey_ = Collections.emptyList();
            private List mapValue_ = Collections.emptyList();
            private Object string_ = "";
            private List templateToken_ = Collections.emptyList();
            private Type type_ = Type.STRING;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureEscapingIsMutable() {
                if ((this.bitField0_ & 1024) != 1024) {
                    this.escaping_ = new ArrayList(this.escaping_);
                    this.bitField0_ |= 1024;
                }
            }

            private void ensureListItemIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.listItem_ = new ArrayList(this.listItem_);
                    this.bitField0_ |= 4;
                }
            }

            private void ensureMapKeyIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.mapKey_ = new ArrayList(this.mapKey_);
                    this.bitField0_ |= 8;
                }
            }

            private void ensureMapValueIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.mapValue_ = new ArrayList(this.mapValue_);
                    this.bitField0_ |= 16;
                }
            }

            private void ensureTemplateTokenIsMutable() {
                if ((this.bitField0_ & 512) != 512) {
                    this.templateToken_ = new ArrayList(this.templateToken_);
                    this.bitField0_ |= 512;
                }
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder addAllEscaping(Iterable iterable) {
                ensureEscapingIsMutable();
                com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(iterable, this.escaping_);
                return this;
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

            public Builder addEscaping(Escaping escaping) {
                if (escaping == null) {
                    throw new NullPointerException();
                }
                ensureEscapingIsMutable();
                this.escaping_.add(escaping);
                return this;
            }

            public Builder addListItem(int i, Builder builder) {
                ensureListItemIsMutable();
                this.listItem_.add(i, builder.build());
                return this;
            }

            public Builder addListItem(int i, Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureListItemIsMutable();
                this.listItem_.add(i, value);
                return this;
            }

            public Builder addListItem(Builder builder) {
                ensureListItemIsMutable();
                this.listItem_.add(builder.build());
                return this;
            }

            public Builder addListItem(Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureListItemIsMutable();
                this.listItem_.add(value);
                return this;
            }

            public Builder addMapKey(int i, Builder builder) {
                ensureMapKeyIsMutable();
                this.mapKey_.add(i, builder.build());
                return this;
            }

            public Builder addMapKey(int i, Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureMapKeyIsMutable();
                this.mapKey_.add(i, value);
                return this;
            }

            public Builder addMapKey(Builder builder) {
                ensureMapKeyIsMutable();
                this.mapKey_.add(builder.build());
                return this;
            }

            public Builder addMapKey(Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureMapKeyIsMutable();
                this.mapKey_.add(value);
                return this;
            }

            public Builder addMapValue(int i, Builder builder) {
                ensureMapValueIsMutable();
                this.mapValue_.add(i, builder.build());
                return this;
            }

            public Builder addMapValue(int i, Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureMapValueIsMutable();
                this.mapValue_.add(i, value);
                return this;
            }

            public Builder addMapValue(Builder builder) {
                ensureMapValueIsMutable();
                this.mapValue_.add(builder.build());
                return this;
            }

            public Builder addMapValue(Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureMapValueIsMutable();
                this.mapValue_.add(value);
                return this;
            }

            public Builder addTemplateToken(int i, Builder builder) {
                ensureTemplateTokenIsMutable();
                this.templateToken_.add(i, builder.build());
                return this;
            }

            public Builder addTemplateToken(int i, Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureTemplateTokenIsMutable();
                this.templateToken_.add(i, value);
                return this;
            }

            public Builder addTemplateToken(Builder builder) {
                ensureTemplateTokenIsMutable();
                this.templateToken_.add(builder.build());
                return this;
            }

            public Builder addTemplateToken(Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureTemplateTokenIsMutable();
                this.templateToken_.add(value);
                return this;
            }

            public Value build() {
                Object buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw com.google.tagmanager.protobuf.AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public Value buildPartial() {
                int i = 1;
                Value value = new Value((ExtendableBuilder) this);
                int i2 = this.bitField0_;
                if ((i2 & 1) != 1) {
                    i = 0;
                }
                value.type_ = this.type_;
                if ((i2 & 2) == 2) {
                    i |= 2;
                }
                value.string_ = this.string_;
                if ((this.bitField0_ & 4) == 4) {
                    this.listItem_ = Collections.unmodifiableList(this.listItem_);
                    this.bitField0_ &= -5;
                }
                value.listItem_ = this.listItem_;
                if ((this.bitField0_ & 8) == 8) {
                    this.mapKey_ = Collections.unmodifiableList(this.mapKey_);
                    this.bitField0_ &= -9;
                }
                value.mapKey_ = this.mapKey_;
                if ((this.bitField0_ & 16) == 16) {
                    this.mapValue_ = Collections.unmodifiableList(this.mapValue_);
                    this.bitField0_ &= -17;
                }
                value.mapValue_ = this.mapValue_;
                if ((i2 & 32) == 32) {
                    i |= 4;
                }
                value.macroReference_ = this.macroReference_;
                if ((i2 & 64) == 64) {
                    i |= 8;
                }
                value.functionId_ = this.functionId_;
                if ((i2 & 128) == 128) {
                    i |= 16;
                }
                value.integer_ = this.integer_;
                if ((i2 & Policy.LICENSED) == Policy.LICENSED) {
                    i |= 32;
                }
                value.boolean_ = this.boolean_;
                if ((this.bitField0_ & 512) == 512) {
                    this.templateToken_ = Collections.unmodifiableList(this.templateToken_);
                    this.bitField0_ &= -513;
                }
                value.templateToken_ = this.templateToken_;
                if ((this.bitField0_ & 1024) == 1024) {
                    this.escaping_ = Collections.unmodifiableList(this.escaping_);
                    this.bitField0_ &= -1025;
                }
                value.escaping_ = this.escaping_;
                if ((i2 & 2048) == 2048) {
                    i |= 64;
                }
                value.containsReferences_ = this.containsReferences_;
                value.bitField0_ = i;
                return value;
            }

            public Builder clear() {
                super.clear();
                this.type_ = Type.STRING;
                this.bitField0_ &= -2;
                this.string_ = "";
                this.bitField0_ &= -3;
                this.listItem_ = Collections.emptyList();
                this.bitField0_ &= -5;
                this.mapKey_ = Collections.emptyList();
                this.bitField0_ &= -9;
                this.mapValue_ = Collections.emptyList();
                this.bitField0_ &= -17;
                this.macroReference_ = "";
                this.bitField0_ &= -33;
                this.functionId_ = "";
                this.bitField0_ &= -65;
                this.integer_ = 0;
                this.bitField0_ &= -129;
                this.boolean_ = false;
                this.bitField0_ &= -257;
                this.templateToken_ = Collections.emptyList();
                this.bitField0_ &= -513;
                this.escaping_ = Collections.emptyList();
                this.bitField0_ &= -1025;
                this.containsReferences_ = false;
                this.bitField0_ &= -2049;
                return this;
            }

            public Builder clearBoolean() {
                this.bitField0_ &= -257;
                this.boolean_ = false;
                return this;
            }

            public Builder clearContainsReferences() {
                this.bitField0_ &= -2049;
                this.containsReferences_ = false;
                return this;
            }

            public Builder clearEscaping() {
                this.escaping_ = Collections.emptyList();
                this.bitField0_ &= -1025;
                return this;
            }

            public Builder clearFunctionId() {
                this.bitField0_ &= -65;
                this.functionId_ = Value.getDefaultInstance().getFunctionId();
                return this;
            }

            public Builder clearInteger() {
                this.bitField0_ &= -129;
                this.integer_ = 0;
                return this;
            }

            public Builder clearListItem() {
                this.listItem_ = Collections.emptyList();
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clearMacroReference() {
                this.bitField0_ &= -33;
                this.macroReference_ = Value.getDefaultInstance().getMacroReference();
                return this;
            }

            public Builder clearMapKey() {
                this.mapKey_ = Collections.emptyList();
                this.bitField0_ &= -9;
                return this;
            }

            public Builder clearMapValue() {
                this.mapValue_ = Collections.emptyList();
                this.bitField0_ &= -17;
                return this;
            }

            public Builder clearString() {
                this.bitField0_ &= -3;
                this.string_ = Value.getDefaultInstance().getString();
                return this;
            }

            public Builder clearTemplateToken() {
                this.templateToken_ = Collections.emptyList();
                this.bitField0_ &= -513;
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= -2;
                this.type_ = Type.STRING;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public boolean getBoolean() {
                return this.boolean_;
            }

            public boolean getContainsReferences() {
                return this.containsReferences_;
            }

            public Value getDefaultInstanceForType() {
                return Value.getDefaultInstance();
            }

            public Escaping getEscaping(int i) {
                return (Escaping) this.escaping_.get(i);
            }

            public int getEscapingCount() {
                return this.escaping_.size();
            }

            public List getEscapingList() {
                return Collections.unmodifiableList(this.escaping_);
            }

            public String getFunctionId() {
                Object obj = this.functionId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String toStringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.functionId_ = toStringUtf8;
                }
                return toStringUtf8;
            }

            public ByteString getFunctionIdBytes() {
                Object obj = this.functionId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.functionId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public long getInteger() {
                return this.integer_;
            }

            public Value getListItem(int i) {
                return (Value) this.listItem_.get(i);
            }

            public int getListItemCount() {
                return this.listItem_.size();
            }

            public List getListItemList() {
                return Collections.unmodifiableList(this.listItem_);
            }

            public String getMacroReference() {
                Object obj = this.macroReference_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String toStringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.macroReference_ = toStringUtf8;
                }
                return toStringUtf8;
            }

            public ByteString getMacroReferenceBytes() {
                Object obj = this.macroReference_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.macroReference_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Value getMapKey(int i) {
                return (Value) this.mapKey_.get(i);
            }

            public int getMapKeyCount() {
                return this.mapKey_.size();
            }

            public List getMapKeyList() {
                return Collections.unmodifiableList(this.mapKey_);
            }

            public Value getMapValue(int i) {
                return (Value) this.mapValue_.get(i);
            }

            public int getMapValueCount() {
                return this.mapValue_.size();
            }

            public List getMapValueList() {
                return Collections.unmodifiableList(this.mapValue_);
            }

            public String getString() {
                Object obj = this.string_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String toStringUtf8 = byteString.toStringUtf8();
                if (byteString.isValidUtf8()) {
                    this.string_ = toStringUtf8;
                }
                return toStringUtf8;
            }

            public ByteString getStringBytes() {
                Object obj = this.string_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.string_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public Value getTemplateToken(int i) {
                return (Value) this.templateToken_.get(i);
            }

            public int getTemplateTokenCount() {
                return this.templateToken_.size();
            }

            public List getTemplateTokenList() {
                return Collections.unmodifiableList(this.templateToken_);
            }

            public Type getType() {
                return this.type_;
            }

            public boolean hasBoolean() {
                return (this.bitField0_ & Policy.LICENSED) == Policy.LICENSED;
            }

            public boolean hasContainsReferences() {
                return (this.bitField0_ & 2048) == 2048;
            }

            public boolean hasFunctionId() {
                return (this.bitField0_ & 64) == 64;
            }

            public boolean hasInteger() {
                return (this.bitField0_ & 128) == 128;
            }

            public boolean hasMacroReference() {
                return (this.bitField0_ & 32) == 32;
            }

            public boolean hasString() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasType() {
                return (this.bitField0_ & 1) == 1;
            }

            public final boolean isInitialized() {
                if (!hasType()) {
                    return false;
                }
                int i;
                for (i = 0; i < getListItemCount(); i++) {
                    if (!getListItem(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getMapKeyCount(); i++) {
                    if (!getMapKey(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getMapValueCount(); i++) {
                    if (!getMapValue(i).isInitialized()) {
                        return false;
                    }
                }
                for (i = 0; i < getTemplateTokenCount(); i++) {
                    if (!getTemplateToken(i).isInitialized()) {
                        return false;
                    }
                }
                return extensionsAreInitialized();
            }

            public Builder mergeFrom(Value value) {
                if (value != Value.getDefaultInstance()) {
                    if (value.hasType()) {
                        setType(value.getType());
                    }
                    if (value.hasString()) {
                        this.bitField0_ |= 2;
                        this.string_ = value.string_;
                    }
                    if (!value.listItem_.isEmpty()) {
                        if (this.listItem_.isEmpty()) {
                            this.listItem_ = value.listItem_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureListItemIsMutable();
                            this.listItem_.addAll(value.listItem_);
                        }
                    }
                    if (!value.mapKey_.isEmpty()) {
                        if (this.mapKey_.isEmpty()) {
                            this.mapKey_ = value.mapKey_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureMapKeyIsMutable();
                            this.mapKey_.addAll(value.mapKey_);
                        }
                    }
                    if (!value.mapValue_.isEmpty()) {
                        if (this.mapValue_.isEmpty()) {
                            this.mapValue_ = value.mapValue_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureMapValueIsMutable();
                            this.mapValue_.addAll(value.mapValue_);
                        }
                    }
                    if (value.hasMacroReference()) {
                        this.bitField0_ |= 32;
                        this.macroReference_ = value.macroReference_;
                    }
                    if (value.hasFunctionId()) {
                        this.bitField0_ |= 64;
                        this.functionId_ = value.functionId_;
                    }
                    if (value.hasInteger()) {
                        setInteger(value.getInteger());
                    }
                    if (value.hasBoolean()) {
                        setBoolean(value.getBoolean());
                    }
                    if (!value.templateToken_.isEmpty()) {
                        if (this.templateToken_.isEmpty()) {
                            this.templateToken_ = value.templateToken_;
                            this.bitField0_ &= -513;
                        } else {
                            ensureTemplateTokenIsMutable();
                            this.templateToken_.addAll(value.templateToken_);
                        }
                    }
                    if (!value.escaping_.isEmpty()) {
                        if (this.escaping_.isEmpty()) {
                            this.escaping_ = value.escaping_;
                            this.bitField0_ &= -1025;
                        } else {
                            ensureEscapingIsMutable();
                            this.escaping_.addAll(value.escaping_);
                        }
                    }
                    if (value.hasContainsReferences()) {
                        setContainsReferences(value.getContainsReferences());
                    }
                    mergeExtensionFields(value);
                    setUnknownFields(getUnknownFields().concat(value.unknownFields));
                }
                return this;
            }

            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Throwable th;
                Value value;
                Value value2;
                try {
                    value2 = (Value) Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (value2 != null) {
                        mergeFrom(value2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    InvalidProtocolBufferException invalidProtocolBufferException = e;
                    value2 = (Value) invalidProtocolBufferException.getUnfinishedMessage();
                    throw invalidProtocolBufferException;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    value = value2;
                    th = th3;
                }
                if (value != null) {
                    mergeFrom(value);
                }
                throw th;
            }

            public Builder removeListItem(int i) {
                ensureListItemIsMutable();
                this.listItem_.remove(i);
                return this;
            }

            public Builder removeMapKey(int i) {
                ensureMapKeyIsMutable();
                this.mapKey_.remove(i);
                return this;
            }

            public Builder removeMapValue(int i) {
                ensureMapValueIsMutable();
                this.mapValue_.remove(i);
                return this;
            }

            public Builder removeTemplateToken(int i) {
                ensureTemplateTokenIsMutable();
                this.templateToken_.remove(i);
                return this;
            }

            public Builder setBoolean(boolean z) {
                this.bitField0_ |= Policy.LICENSED;
                this.boolean_ = z;
                return this;
            }

            public Builder setContainsReferences(boolean z) {
                this.bitField0_ |= 2048;
                this.containsReferences_ = z;
                return this;
            }

            public Builder setEscaping(int i, Escaping escaping) {
                if (escaping == null) {
                    throw new NullPointerException();
                }
                ensureEscapingIsMutable();
                this.escaping_.set(i, escaping);
                return this;
            }

            public Builder setFunctionId(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 64;
                this.functionId_ = str;
                return this;
            }

            public Builder setFunctionIdBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 64;
                this.functionId_ = byteString;
                return this;
            }

            public Builder setInteger(long j) {
                this.bitField0_ |= 128;
                this.integer_ = j;
                return this;
            }

            public Builder setListItem(int i, Builder builder) {
                ensureListItemIsMutable();
                this.listItem_.set(i, builder.build());
                return this;
            }

            public Builder setListItem(int i, Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureListItemIsMutable();
                this.listItem_.set(i, value);
                return this;
            }

            public Builder setMacroReference(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 32;
                this.macroReference_ = str;
                return this;
            }

            public Builder setMacroReferenceBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 32;
                this.macroReference_ = byteString;
                return this;
            }

            public Builder setMapKey(int i, Builder builder) {
                ensureMapKeyIsMutable();
                this.mapKey_.set(i, builder.build());
                return this;
            }

            public Builder setMapKey(int i, Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureMapKeyIsMutable();
                this.mapKey_.set(i, value);
                return this;
            }

            public Builder setMapValue(int i, Builder builder) {
                ensureMapValueIsMutable();
                this.mapValue_.set(i, builder.build());
                return this;
            }

            public Builder setMapValue(int i, Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureMapValueIsMutable();
                this.mapValue_.set(i, value);
                return this;
            }

            public Builder setString(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.string_ = str;
                return this;
            }

            public Builder setStringBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.string_ = byteString;
                return this;
            }

            public Builder setTemplateToken(int i, Builder builder) {
                ensureTemplateTokenIsMutable();
                this.templateToken_.set(i, builder.build());
                return this;
            }

            public Builder setTemplateToken(int i, Value value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureTemplateTokenIsMutable();
                this.templateToken_.set(i, value);
                return this;
            }

            public Builder setType(Type type) {
                if (type == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.type_ = type;
                return this;
            }
        }

        public enum Escaping implements EnumLite {
            ESCAPE_HTML(0, 1),
            ESCAPE_HTML_RCDATA(1, 2),
            ESCAPE_HTML_ATTRIBUTE(2, 3),
            ESCAPE_HTML_ATTRIBUTE_NOSPACE(3, 4),
            FILTER_HTML_ELEMENT_NAME(4, 5),
            FILTER_HTML_ATTRIBUTES(5, 6),
            ESCAPE_JS_STRING(6, 7),
            ESCAPE_JS_VALUE(7, 8),
            ESCAPE_JS_REGEX(8, 9),
            ESCAPE_CSS_STRING(9, 10),
            FILTER_CSS_VALUE(10, 11),
            ESCAPE_URI(11, 12),
            NORMALIZE_URI(12, 13),
            FILTER_NORMALIZE_URI(13, 14),
            NO_AUTOESCAPE(14, 15),
            TEXT(15, 17),
            CONVERT_JS_VALUE_TO_EXPRESSION(16, 16);
            
            public static final int CONVERT_JS_VALUE_TO_EXPRESSION_VALUE = 16;
            public static final int ESCAPE_CSS_STRING_VALUE = 10;
            public static final int ESCAPE_HTML_ATTRIBUTE_NOSPACE_VALUE = 4;
            public static final int ESCAPE_HTML_ATTRIBUTE_VALUE = 3;
            public static final int ESCAPE_HTML_RCDATA_VALUE = 2;
            public static final int ESCAPE_HTML_VALUE = 1;
            public static final int ESCAPE_JS_REGEX_VALUE = 9;
            public static final int ESCAPE_JS_STRING_VALUE = 7;
            public static final int ESCAPE_JS_VALUE_VALUE = 8;
            public static final int ESCAPE_URI_VALUE = 12;
            public static final int FILTER_CSS_VALUE_VALUE = 11;
            public static final int FILTER_HTML_ATTRIBUTES_VALUE = 6;
            public static final int FILTER_HTML_ELEMENT_NAME_VALUE = 5;
            public static final int FILTER_NORMALIZE_URI_VALUE = 14;
            public static final int NORMALIZE_URI_VALUE = 13;
            public static final int NO_AUTOESCAPE_VALUE = 15;
            public static final int TEXT_VALUE = 17;
            private static EnumLiteMap internalValueMap;
            private final int value;

            static {
                internalValueMap = new C0180e();
            }

            private Escaping(int i, int i2) {
                this.value = i2;
            }

            public static EnumLiteMap internalGetValueMap() {
                return internalValueMap;
            }

            public static Escaping valueOf(int i) {
                switch (i) {
                    case 1:
                        return ESCAPE_HTML;
                    case 2:
                        return ESCAPE_HTML_RCDATA;
                    case 3:
                        return ESCAPE_HTML_ATTRIBUTE;
                    case 4:
                        return ESCAPE_HTML_ATTRIBUTE_NOSPACE;
                    case 5:
                        return FILTER_HTML_ELEMENT_NAME;
                    case 6:
                        return FILTER_HTML_ATTRIBUTES;
                    case 7:
                        return ESCAPE_JS_STRING;
                    case 8:
                        return ESCAPE_JS_VALUE;
                    case 9:
                        return ESCAPE_JS_REGEX;
                    case 10:
                        return ESCAPE_CSS_STRING;
                    case 11:
                        return FILTER_CSS_VALUE;
                    case 12:
                        return ESCAPE_URI;
                    case 13:
                        return NORMALIZE_URI;
                    case 14:
                        return FILTER_NORMALIZE_URI;
                    case 15:
                        return NO_AUTOESCAPE;
                    case 16:
                        return CONVERT_JS_VALUE_TO_EXPRESSION;
                    case 17:
                        return TEXT;
                    default:
                        return null;
                }
            }

            public final int getNumber() {
                return this.value;
            }
        }

        public enum Type implements EnumLite {
            STRING(0, 1),
            LIST(1, 2),
            MAP(2, 3),
            MACRO_REFERENCE(3, 4),
            FUNCTION_ID(4, 5),
            INTEGER(5, 6),
            TEMPLATE(6, 7),
            BOOLEAN(7, 8);
            
            public static final int BOOLEAN_VALUE = 8;
            public static final int FUNCTION_ID_VALUE = 5;
            public static final int INTEGER_VALUE = 6;
            public static final int LIST_VALUE = 2;
            public static final int MACRO_REFERENCE_VALUE = 4;
            public static final int MAP_VALUE = 3;
            public static final int STRING_VALUE = 1;
            public static final int TEMPLATE_VALUE = 7;
            private static EnumLiteMap internalValueMap;
            private final int value;

            static {
                internalValueMap = new C0181f();
            }

            private Type(int i, int i2) {
                this.value = i2;
            }

            public static EnumLiteMap internalGetValueMap() {
                return internalValueMap;
            }

            public static Type valueOf(int i) {
                switch (i) {
                    case 1:
                        return STRING;
                    case 2:
                        return LIST;
                    case 3:
                        return MAP;
                    case 4:
                        return MACRO_REFERENCE;
                    case 5:
                        return FUNCTION_ID;
                    case 6:
                        return INTEGER;
                    case 7:
                        return TEMPLATE;
                    case 8:
                        return BOOLEAN;
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

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private Value(com.google.tagmanager.protobuf.CodedInputStream r11, com.google.tagmanager.protobuf.ExtensionRegistryLite r12) {
            /*
            r10 = this;
            r10.<init>();
            r0 = -1;
            r10.memoizedIsInitialized = r0;
            r0 = -1;
            r10.memoizedSerializedSize = r0;
            r10.initFields();
            r2 = 0;
            r3 = com.google.tagmanager.protobuf.ByteString.newOutput();
            r4 = com.google.tagmanager.protobuf.CodedOutputStream.newInstance(r3);
            r1 = 0;
        L_0x0016:
            if (r1 != 0) goto L_0x01fa;
        L_0x0018:
            r5 = r11.readTag();	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            switch(r5) {
                case 0: goto L_0x002a;
                case 8: goto L_0x002d;
                case 18: goto L_0x004b;
                case 26: goto L_0x005a;
                case 34: goto L_0x0077;
                case 42: goto L_0x0095;
                case 50: goto L_0x00b4;
                case 58: goto L_0x00c4;
                case 64: goto L_0x00d4;
                case 72: goto L_0x00e4;
                case 80: goto L_0x00f4;
                case 82: goto L_0x0121;
                case 90: goto L_0x01cb;
                case 96: goto L_0x01ea;
                default: goto L_0x001f;
            };	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
        L_0x001f:
            r0 = r10.parseUnknownField(r11, r4, r12, r5);	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            if (r0 != 0) goto L_0x01f6;
        L_0x0025:
            r0 = 1;
            r1 = r2;
        L_0x0027:
            r2 = r1;
            r1 = r0;
            goto L_0x0016;
        L_0x002a:
            r0 = 1;
            r1 = r2;
            goto L_0x0027;
        L_0x002d:
            r0 = r11.readEnum();	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r6 = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.valueOf(r0);	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            if (r6 != 0) goto L_0x0040;
        L_0x0037:
            r4.writeRawVarint32(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r4.writeRawVarint32(r0);	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r1;
            r1 = r2;
            goto L_0x0027;
        L_0x0040:
            r0 = r10.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r0 | 1;
            r10.bitField0_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r10.type_ = r6;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r1;
            r1 = r2;
            goto L_0x0027;
        L_0x004b:
            r0 = r11.readBytes();	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r5 = r10.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r5 = r5 | 2;
            r10.bitField0_ = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r10.string_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r1;
            r1 = r2;
            goto L_0x0027;
        L_0x005a:
            r0 = r2 & 4;
            r5 = 4;
            if (r0 == r5) goto L_0x0284;
        L_0x005f:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r10.listItem_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r2 | 4;
        L_0x0068:
            r2 = r10.listItem_;	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r5 = PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r5 = r11.readMessage(r5, r12);	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r2.add(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r9 = r1;
            r1 = r0;
            r0 = r9;
            goto L_0x0027;
        L_0x0077:
            r0 = r2 & 8;
            r5 = 8;
            if (r0 == r5) goto L_0x0281;
        L_0x007d:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r10.mapKey_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r2 | 8;
        L_0x0086:
            r2 = r10.mapKey_;	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r5 = PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r5 = r11.readMessage(r5, r12);	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r2.add(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r9 = r1;
            r1 = r0;
            r0 = r9;
            goto L_0x0027;
        L_0x0095:
            r0 = r2 & 16;
            r5 = 16;
            if (r0 == r5) goto L_0x027e;
        L_0x009b:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r10.mapValue_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r2 | 16;
        L_0x00a4:
            r2 = r10.mapValue_;	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r5 = PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r5 = r11.readMessage(r5, r12);	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r2.add(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r9 = r1;
            r1 = r0;
            r0 = r9;
            goto L_0x0027;
        L_0x00b4:
            r0 = r11.readBytes();	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r5 = r10.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r5 = r5 | 4;
            r10.bitField0_ = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r10.macroReference_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r1;
            r1 = r2;
            goto L_0x0027;
        L_0x00c4:
            r0 = r11.readBytes();	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r5 = r10.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r5 = r5 | 8;
            r10.bitField0_ = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r10.functionId_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r1;
            r1 = r2;
            goto L_0x0027;
        L_0x00d4:
            r0 = r10.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r0 | 16;
            r10.bitField0_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r5 = r11.readInt64();	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r10.integer_ = r5;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r1;
            r1 = r2;
            goto L_0x0027;
        L_0x00e4:
            r0 = r10.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r0 | 64;
            r10.bitField0_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r11.readBool();	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r10.containsReferences_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r1;
            r1 = r2;
            goto L_0x0027;
        L_0x00f4:
            r0 = r11.readEnum();	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r6 = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Escaping.valueOf(r0);	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            if (r6 != 0) goto L_0x0108;
        L_0x00fe:
            r4.writeRawVarint32(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r4.writeRawVarint32(r0);	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r1;
            r1 = r2;
            goto L_0x0027;
        L_0x0108:
            r0 = r2 & 1024;
            r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            if (r0 == r5) goto L_0x027b;
        L_0x010e:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r10.escaping_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r2 | 1024;
        L_0x0117:
            r2 = r10.escaping_;	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r2.add(r6);	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r9 = r1;
            r1 = r0;
            r0 = r9;
            goto L_0x0027;
        L_0x0121:
            r0 = r11.readRawVarint32();	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r6 = r11.pushLimit(r0);	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r2;
        L_0x012a:
            r2 = r11.getBytesUntilLimit();	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            if (r2 <= 0) goto L_0x01c3;
        L_0x0130:
            r2 = r11.readEnum();	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r7 = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Escaping.valueOf(r2);	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            if (r7 != 0) goto L_0x019c;
        L_0x013a:
            r4.writeRawVarint32(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r4.writeRawVarint32(r2);	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            goto L_0x012a;
        L_0x0141:
            r1 = move-exception;
            r2 = r0;
            r0 = r1;
        L_0x0144:
            r0 = r0.setUnfinishedMessage(r10);	 Catch:{ all -> 0x0149 }
            throw r0;	 Catch:{ all -> 0x0149 }
        L_0x0149:
            r0 = move-exception;
        L_0x014a:
            r1 = r2 & 4;
            r5 = 4;
            if (r1 != r5) goto L_0x0157;
        L_0x014f:
            r1 = r10.listItem_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r10.listItem_ = r1;
        L_0x0157:
            r1 = r2 & 8;
            r5 = 8;
            if (r1 != r5) goto L_0x0165;
        L_0x015d:
            r1 = r10.mapKey_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r10.mapKey_ = r1;
        L_0x0165:
            r1 = r2 & 16;
            r5 = 16;
            if (r1 != r5) goto L_0x0173;
        L_0x016b:
            r1 = r10.mapValue_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r10.mapValue_ = r1;
        L_0x0173:
            r1 = r2 & 1024;
            r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            if (r1 != r5) goto L_0x0181;
        L_0x0179:
            r1 = r10.escaping_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r10.escaping_ = r1;
        L_0x0181:
            r1 = r2 & 512;
            r2 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
            if (r1 != r2) goto L_0x018f;
        L_0x0187:
            r1 = r10.templateToken_;
            r1 = java.util.Collections.unmodifiableList(r1);
            r10.templateToken_ = r1;
        L_0x018f:
            r4.flush();	 Catch:{ IOException -> 0x025c, all -> 0x0265 }
            r1 = r3.toByteString();
            r10.unknownFields = r1;
        L_0x0198:
            r10.makeExtensionsImmutable();
            throw r0;
        L_0x019c:
            r2 = r0 & 1024;
            r8 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            if (r2 == r8) goto L_0x01ab;
        L_0x01a2:
            r2 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r2.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r10.escaping_ = r2;	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r0 = r0 | 1024;
        L_0x01ab:
            r2 = r10.escaping_;	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r2.add(r7);	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            goto L_0x012a;
        L_0x01b2:
            r1 = move-exception;
            r2 = r0;
            r0 = r1;
        L_0x01b5:
            r1 = new com.google.tagmanager.protobuf.InvalidProtocolBufferException;	 Catch:{ all -> 0x0149 }
            r0 = r0.getMessage();	 Catch:{ all -> 0x0149 }
            r1.<init>(r0);	 Catch:{ all -> 0x0149 }
            r0 = r1.setUnfinishedMessage(r10);	 Catch:{ all -> 0x0149 }
            throw r0;	 Catch:{ all -> 0x0149 }
        L_0x01c3:
            r11.popLimit(r6);	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r9 = r1;
            r1 = r0;
            r0 = r9;
            goto L_0x0027;
        L_0x01cb:
            r0 = r2 & 512;
            r5 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
            if (r0 == r5) goto L_0x0278;
        L_0x01d1:
            r0 = new java.util.ArrayList;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0.<init>();	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r10.templateToken_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r2 | 512;
        L_0x01da:
            r2 = r10.templateToken_;	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r5 = PARSER;	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r5 = r11.readMessage(r5, r12);	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r2.add(r5);	 Catch:{ InvalidProtocolBufferException -> 0x0141, IOException -> 0x01b2, all -> 0x026d }
            r9 = r1;
            r1 = r0;
            r0 = r9;
            goto L_0x0027;
        L_0x01ea:
            r0 = r10.bitField0_;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r0 | 32;
            r10.bitField0_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r0 = r11.readBool();	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
            r10.boolean_ = r0;	 Catch:{ InvalidProtocolBufferException -> 0x0275, IOException -> 0x0272 }
        L_0x01f6:
            r0 = r1;
            r1 = r2;
            goto L_0x0027;
        L_0x01fa:
            r0 = r2 & 4;
            r1 = 4;
            if (r0 != r1) goto L_0x0207;
        L_0x01ff:
            r0 = r10.listItem_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r10.listItem_ = r0;
        L_0x0207:
            r0 = r2 & 8;
            r1 = 8;
            if (r0 != r1) goto L_0x0215;
        L_0x020d:
            r0 = r10.mapKey_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r10.mapKey_ = r0;
        L_0x0215:
            r0 = r2 & 16;
            r1 = 16;
            if (r0 != r1) goto L_0x0223;
        L_0x021b:
            r0 = r10.mapValue_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r10.mapValue_ = r0;
        L_0x0223:
            r0 = r2 & 1024;
            r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            if (r0 != r1) goto L_0x0231;
        L_0x0229:
            r0 = r10.escaping_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r10.escaping_ = r0;
        L_0x0231:
            r0 = r2 & 512;
            r1 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
            if (r0 != r1) goto L_0x023f;
        L_0x0237:
            r0 = r10.templateToken_;
            r0 = java.util.Collections.unmodifiableList(r0);
            r10.templateToken_ = r0;
        L_0x023f:
            r4.flush();	 Catch:{ IOException -> 0x024c, all -> 0x0254 }
            r0 = r3.toByteString();
            r10.unknownFields = r0;
        L_0x0248:
            r10.makeExtensionsImmutable();
            return;
        L_0x024c:
            r0 = move-exception;
            r0 = r3.toByteString();
            r10.unknownFields = r0;
            goto L_0x0248;
        L_0x0254:
            r0 = move-exception;
            r1 = r3.toByteString();
            r10.unknownFields = r1;
            throw r0;
        L_0x025c:
            r1 = move-exception;
            r1 = r3.toByteString();
            r10.unknownFields = r1;
            goto L_0x0198;
        L_0x0265:
            r0 = move-exception;
            r1 = r3.toByteString();
            r10.unknownFields = r1;
            throw r0;
        L_0x026d:
            r1 = move-exception;
            r2 = r0;
            r0 = r1;
            goto L_0x014a;
        L_0x0272:
            r0 = move-exception;
            goto L_0x01b5;
        L_0x0275:
            r0 = move-exception;
            goto L_0x0144;
        L_0x0278:
            r0 = r2;
            goto L_0x01da;
        L_0x027b:
            r0 = r2;
            goto L_0x0117;
        L_0x027e:
            r0 = r2;
            goto L_0x00a4;
        L_0x0281:
            r0 = r2;
            goto L_0x0086;
        L_0x0284:
            r0 = r2;
            goto L_0x0068;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.midtier.proto.containertag.TypeSystem.Value.<init>(com.google.tagmanager.protobuf.CodedInputStream, com.google.tagmanager.protobuf.ExtensionRegistryLite):void");
        }

        private Value(ExtendableBuilder extendableBuilder) {
            super(extendableBuilder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = extendableBuilder.getUnknownFields();
        }

        private Value(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Value getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.type_ = Type.STRING;
            this.string_ = "";
            this.listItem_ = Collections.emptyList();
            this.mapKey_ = Collections.emptyList();
            this.mapValue_ = Collections.emptyList();
            this.macroReference_ = "";
            this.functionId_ = "";
            this.integer_ = 0;
            this.boolean_ = false;
            this.templateToken_ = Collections.emptyList();
            this.escaping_ = Collections.emptyList();
            this.containsReferences_ = false;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(Value value) {
            return newBuilder().mergeFrom(value);
        }

        public static Value parseDelimitedFrom(InputStream inputStream) {
            return (Value) PARSER.parseDelimitedFrom(inputStream);
        }

        public static Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Value) PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Value parseFrom(ByteString byteString) {
            return (Value) PARSER.parseFrom(byteString);
        }

        public static Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Value) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Value parseFrom(CodedInputStream codedInputStream) {
            return (Value) PARSER.parseFrom(codedInputStream);
        }

        public static Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Value) PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Value parseFrom(InputStream inputStream) {
            return (Value) PARSER.parseFrom(inputStream);
        }

        public static Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Value) PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Value parseFrom(byte[] bArr) {
            return (Value) PARSER.parseFrom(bArr);
        }

        public static Value parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Value) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Value)) {
                return super.equals(obj);
            }
            Value value = (Value) obj;
            boolean z = hasType() == value.hasType();
            if (hasType()) {
                z = z && getType() == value.getType();
            }
            z = z && hasString() == value.hasString();
            if (hasString()) {
                z = z && getString().equals(value.getString());
            }
            z = z && getListItemList().equals(value.getListItemList());
            z = z && getMapKeyList().equals(value.getMapKeyList());
            z = z && getMapValueList().equals(value.getMapValueList());
            z = z && hasMacroReference() == value.hasMacroReference();
            if (hasMacroReference()) {
                z = z && getMacroReference().equals(value.getMacroReference());
            }
            z = z && hasFunctionId() == value.hasFunctionId();
            if (hasFunctionId()) {
                z = z && getFunctionId().equals(value.getFunctionId());
            }
            z = z && hasInteger() == value.hasInteger();
            if (hasInteger()) {
                z = z && getInteger() == value.getInteger();
            }
            z = z && hasBoolean() == value.hasBoolean();
            if (hasBoolean()) {
                z = z && getBoolean() == value.getBoolean();
            }
            z = z && getTemplateTokenList().equals(value.getTemplateTokenList());
            z = z && getEscapingList().equals(value.getEscapingList());
            z = z && hasContainsReferences() == value.hasContainsReferences();
            return hasContainsReferences() ? z && getContainsReferences() == value.getContainsReferences() : z;
        }

        public boolean getBoolean() {
            return this.boolean_;
        }

        public boolean getContainsReferences() {
            return this.containsReferences_;
        }

        public Value getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Escaping getEscaping(int i) {
            return (Escaping) this.escaping_.get(i);
        }

        public int getEscapingCount() {
            return this.escaping_.size();
        }

        public List getEscapingList() {
            return this.escaping_;
        }

        public String getFunctionId() {
            Object obj = this.functionId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String toStringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.functionId_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public ByteString getFunctionIdBytes() {
            Object obj = this.functionId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.functionId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public long getInteger() {
            return this.integer_;
        }

        public Value getListItem(int i) {
            return (Value) this.listItem_.get(i);
        }

        public int getListItemCount() {
            return this.listItem_.size();
        }

        public List getListItemList() {
            return this.listItem_;
        }

        public ValueOrBuilder getListItemOrBuilder(int i) {
            return (ValueOrBuilder) this.listItem_.get(i);
        }

        public List getListItemOrBuilderList() {
            return this.listItem_;
        }

        public String getMacroReference() {
            Object obj = this.macroReference_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String toStringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.macroReference_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public ByteString getMacroReferenceBytes() {
            Object obj = this.macroReference_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.macroReference_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Value getMapKey(int i) {
            return (Value) this.mapKey_.get(i);
        }

        public int getMapKeyCount() {
            return this.mapKey_.size();
        }

        public List getMapKeyList() {
            return this.mapKey_;
        }

        public ValueOrBuilder getMapKeyOrBuilder(int i) {
            return (ValueOrBuilder) this.mapKey_.get(i);
        }

        public List getMapKeyOrBuilderList() {
            return this.mapKey_;
        }

        public Value getMapValue(int i) {
            return (Value) this.mapValue_.get(i);
        }

        public int getMapValueCount() {
            return this.mapValue_.size();
        }

        public List getMapValueList() {
            return this.mapValue_;
        }

        public ValueOrBuilder getMapValueOrBuilder(int i) {
            return (ValueOrBuilder) this.mapValue_.get(i);
        }

        public List getMapValueOrBuilderList() {
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
            i2 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.type_.getNumber()) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeBytesSize(2, getStringBytes());
            }
            int i4 = i2;
            for (i3 = 0; i3 < this.listItem_.size(); i3++) {
                i4 += CodedOutputStream.computeMessageSize(3, (MessageLite) this.listItem_.get(i3));
            }
            for (i3 = 0; i3 < this.mapKey_.size(); i3++) {
                i4 += CodedOutputStream.computeMessageSize(4, (MessageLite) this.mapKey_.get(i3));
            }
            for (i3 = 0; i3 < this.mapValue_.size(); i3++) {
                i4 += CodedOutputStream.computeMessageSize(5, (MessageLite) this.mapValue_.get(i3));
            }
            if ((this.bitField0_ & 4) == 4) {
                i4 += CodedOutputStream.computeBytesSize(6, getMacroReferenceBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                i4 += CodedOutputStream.computeBytesSize(7, getFunctionIdBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                i4 += CodedOutputStream.computeInt64Size(8, this.integer_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i4 += CodedOutputStream.computeBoolSize(9, this.containsReferences_);
            }
            int i5 = 0;
            for (i3 = 0; i3 < this.escaping_.size(); i3++) {
                i5 += CodedOutputStream.computeEnumSizeNoTag(((Escaping) this.escaping_.get(i3)).getNumber());
            }
            i3 = (i4 + i5) + (this.escaping_.size() * 1);
            while (i < this.templateToken_.size()) {
                i++;
                i3 = CodedOutputStream.computeMessageSize(11, (MessageLite) this.templateToken_.get(i)) + i3;
            }
            if ((this.bitField0_ & 32) == 32) {
                i3 += CodedOutputStream.computeBoolSize(12, this.boolean_);
            }
            i2 = (extensionsSerializedSize() + i3) + this.unknownFields.size();
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public String getString() {
            Object obj = this.string_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String toStringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.string_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public ByteString getStringBytes() {
            Object obj = this.string_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.string_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public Value getTemplateToken(int i) {
            return (Value) this.templateToken_.get(i);
        }

        public int getTemplateTokenCount() {
            return this.templateToken_.size();
        }

        public List getTemplateTokenList() {
            return this.templateToken_;
        }

        public ValueOrBuilder getTemplateTokenOrBuilder(int i) {
            return (ValueOrBuilder) this.templateToken_.get(i);
        }

        public List getTemplateTokenOrBuilderList() {
            return this.templateToken_;
        }

        public Type getType() {
            return this.type_;
        }

        public boolean hasBoolean() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasContainsReferences() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasFunctionId() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasInteger() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasMacroReference() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasString() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasType() {
            return (this.bitField0_ & 1) == 1;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = Value.class.hashCode() + 779;
            if (hasType()) {
                hashCode = (((hashCode * 37) + 1) * 53) + Internal.hashEnum(getType());
            }
            if (hasString()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getString().hashCode();
            }
            if (getListItemCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getListItemList().hashCode();
            }
            if (getMapKeyCount() > 0) {
                hashCode = (((hashCode * 37) + 4) * 53) + getMapKeyList().hashCode();
            }
            if (getMapValueCount() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + getMapValueList().hashCode();
            }
            if (hasMacroReference()) {
                hashCode = (((hashCode * 37) + 6) * 53) + getMacroReference().hashCode();
            }
            if (hasFunctionId()) {
                hashCode = (((hashCode * 37) + 7) * 53) + getFunctionId().hashCode();
            }
            if (hasInteger()) {
                hashCode = (((hashCode * 37) + 8) * 53) + Internal.hashLong(getInteger());
            }
            if (hasBoolean()) {
                hashCode = (((hashCode * 37) + 12) * 53) + Internal.hashBoolean(getBoolean());
            }
            if (getTemplateTokenCount() > 0) {
                hashCode = (((hashCode * 37) + 11) * 53) + getTemplateTokenList().hashCode();
            }
            if (getEscapingCount() > 0) {
                hashCode = (((hashCode * 37) + 10) * 53) + Internal.hashEnumList(getEscapingList());
            }
            if (hasContainsReferences()) {
                hashCode = (((hashCode * 37) + 9) * 53) + Internal.hashBoolean(getContainsReferences());
            }
            hashCode = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        protected MutableMessageLite internalMutableDefault() {
            if (mutableDefault == null) {
                mutableDefault = GeneratedMessageLite.internalMutableDefault("com.google.analytics.midtier.proto.containertag.MutableTypeSystem$Value");
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
            } else if (hasType()) {
                int i = 0;
                while (i < getListItemCount()) {
                    if (getListItem(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < getMapKeyCount()) {
                    if (getMapKey(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < getMapValueCount()) {
                    if (getMapValue(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                i = 0;
                while (i < getTemplateTokenCount()) {
                    if (getTemplateToken(i).isInitialized()) {
                        i++;
                    } else {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
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
            int i;
            int i2 = 0;
            getSerializedSize();
            ExtensionWriter newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeEnum(1, this.type_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getStringBytes());
            }
            for (i = 0; i < this.listItem_.size(); i++) {
                codedOutputStream.writeMessage(3, (MessageLite) this.listItem_.get(i));
            }
            for (i = 0; i < this.mapKey_.size(); i++) {
                codedOutputStream.writeMessage(4, (MessageLite) this.mapKey_.get(i));
            }
            for (i = 0; i < this.mapValue_.size(); i++) {
                codedOutputStream.writeMessage(5, (MessageLite) this.mapValue_.get(i));
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(6, getMacroReferenceBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(7, getFunctionIdBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt64(8, this.integer_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeBool(9, this.containsReferences_);
            }
            for (i = 0; i < this.escaping_.size(); i++) {
                codedOutputStream.writeEnum(10, ((Escaping) this.escaping_.get(i)).getNumber());
            }
            while (i2 < this.templateToken_.size()) {
                codedOutputStream.writeMessage(11, (MessageLite) this.templateToken_.get(i2));
                i2++;
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBool(12, this.boolean_);
            }
            newExtensionWriter.writeUntil(536870912, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
        }
    }

    private TypeSystem() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
