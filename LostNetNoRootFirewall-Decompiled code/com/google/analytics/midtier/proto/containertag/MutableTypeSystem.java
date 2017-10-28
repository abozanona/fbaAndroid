package com.google.analytics.midtier.proto.containertag;

import com.google.android.vending.licensing.APKExpansionPolicy;
import com.google.tagmanager.protobuf.AbstractMutableMessageLite;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite.ExtendableMutableMessage;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite.ExtendableMutableMessage.ExtensionWriter;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MutableTypeSystem {

    public final class Value extends ExtendableMutableMessage implements MutableMessageLite {
        public static final int BOOLEAN_FIELD_NUMBER = 12;
        public static final int CONTAINS_REFERENCES_FIELD_NUMBER = 9;
        public static final int ESCAPING_FIELD_NUMBER = 10;
        public static final int FUNCTION_ID_FIELD_NUMBER = 7;
        public static final int INTEGER_FIELD_NUMBER = 8;
        public static final int LIST_ITEM_FIELD_NUMBER = 3;
        public static final int MACRO_REFERENCE_FIELD_NUMBER = 6;
        public static final int MAP_KEY_FIELD_NUMBER = 4;
        public static final int MAP_VALUE_FIELD_NUMBER = 5;
        public static Parser PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
        public static final int STRING_FIELD_NUMBER = 2;
        public static final int TEMPLATE_TOKEN_FIELD_NUMBER = 11;
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final Value defaultInstance = new Value(true);
        private static volatile MessageLite immutableDefault = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean boolean_;
        private boolean containsReferences_;
        private List escaping_ = null;
        private Object functionId_ = Internal.EMPTY_BYTE_ARRAY;
        private long integer_;
        private List listItem_ = null;
        private Object macroReference_ = Internal.EMPTY_BYTE_ARRAY;
        private List mapKey_ = null;
        private List mapValue_ = null;
        private Object string_ = Internal.EMPTY_BYTE_ARRAY;
        private List templateToken_ = null;
        private Type type_ = Type.STRING;

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
                internalValueMap = new C0176a();
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
                internalValueMap = new C0177b();
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
            defaultInstance.makeImmutable();
        }

        private Value() {
            initFields();
        }

        private Value(boolean z) {
        }

        private void ensureEscapingInitialized() {
            if (this.escaping_ == null) {
                this.escaping_ = new ArrayList();
            }
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

        public static Value getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.type_ = Type.STRING;
        }

        public static Value newMessage() {
            return new Value();
        }

        public Value addAllEscaping(Iterable iterable) {
            assertMutable();
            ensureEscapingInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.escaping_);
            return this;
        }

        public Value addAllListItem(Iterable iterable) {
            assertMutable();
            ensureListItemInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.listItem_);
            return this;
        }

        public Value addAllMapKey(Iterable iterable) {
            assertMutable();
            ensureMapKeyInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.mapKey_);
            return this;
        }

        public Value addAllMapValue(Iterable iterable) {
            assertMutable();
            ensureMapValueInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.mapValue_);
            return this;
        }

        public Value addAllTemplateToken(Iterable iterable) {
            assertMutable();
            ensureTemplateTokenInitialized();
            AbstractMutableMessageLite.addAll(iterable, this.templateToken_);
            return this;
        }

        public Value addEscaping(Escaping escaping) {
            assertMutable();
            if (escaping == null) {
                throw new NullPointerException();
            }
            ensureEscapingInitialized();
            this.escaping_.add(escaping);
            return this;
        }

        public Value addListItem() {
            assertMutable();
            ensureListItemInitialized();
            Value newMessage = newMessage();
            this.listItem_.add(newMessage);
            return newMessage;
        }

        public Value addListItem(Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureListItemInitialized();
            this.listItem_.add(value);
            return this;
        }

        public Value addMapKey() {
            assertMutable();
            ensureMapKeyInitialized();
            Value newMessage = newMessage();
            this.mapKey_.add(newMessage);
            return newMessage;
        }

        public Value addMapKey(Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureMapKeyInitialized();
            this.mapKey_.add(value);
            return this;
        }

        public Value addMapValue() {
            assertMutable();
            ensureMapValueInitialized();
            Value newMessage = newMessage();
            this.mapValue_.add(newMessage);
            return newMessage;
        }

        public Value addMapValue(Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureMapValueInitialized();
            this.mapValue_.add(value);
            return this;
        }

        public Value addTemplateToken() {
            assertMutable();
            ensureTemplateTokenInitialized();
            Value newMessage = newMessage();
            this.templateToken_.add(newMessage);
            return newMessage;
        }

        public Value addTemplateToken(Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureTemplateTokenInitialized();
            this.templateToken_.add(value);
            return this;
        }

        public Value clear() {
            assertMutable();
            super.clear();
            this.type_ = Type.STRING;
            this.bitField0_ &= -2;
            this.string_ = Internal.EMPTY_BYTE_ARRAY;
            this.bitField0_ &= -3;
            this.listItem_ = null;
            this.mapKey_ = null;
            this.mapValue_ = null;
            this.macroReference_ = Internal.EMPTY_BYTE_ARRAY;
            this.bitField0_ &= -5;
            this.functionId_ = Internal.EMPTY_BYTE_ARRAY;
            this.bitField0_ &= -9;
            this.integer_ = 0;
            this.bitField0_ &= -17;
            this.boolean_ = false;
            this.bitField0_ &= -33;
            this.templateToken_ = null;
            this.escaping_ = null;
            this.containsReferences_ = false;
            this.bitField0_ &= -65;
            return this;
        }

        public Value clearBoolean() {
            assertMutable();
            this.bitField0_ &= -33;
            this.boolean_ = false;
            return this;
        }

        public Value clearContainsReferences() {
            assertMutable();
            this.bitField0_ &= -65;
            this.containsReferences_ = false;
            return this;
        }

        public Value clearEscaping() {
            assertMutable();
            this.escaping_ = null;
            return this;
        }

        public Value clearFunctionId() {
            assertMutable();
            this.bitField0_ &= -9;
            this.functionId_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public Value clearInteger() {
            assertMutable();
            this.bitField0_ &= -17;
            this.integer_ = 0;
            return this;
        }

        public Value clearListItem() {
            assertMutable();
            this.listItem_ = null;
            return this;
        }

        public Value clearMacroReference() {
            assertMutable();
            this.bitField0_ &= -5;
            this.macroReference_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public Value clearMapKey() {
            assertMutable();
            this.mapKey_ = null;
            return this;
        }

        public Value clearMapValue() {
            assertMutable();
            this.mapValue_ = null;
            return this;
        }

        public Value clearString() {
            assertMutable();
            this.bitField0_ &= -3;
            this.string_ = Internal.EMPTY_BYTE_ARRAY;
            return this;
        }

        public Value clearTemplateToken() {
            assertMutable();
            this.templateToken_ = null;
            return this;
        }

        public Value clearType() {
            assertMutable();
            this.bitField0_ &= -2;
            this.type_ = Type.STRING;
            return this;
        }

        public Value clone() {
            return newMessageForType().mergeFrom(this);
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

        public final Value getDefaultInstanceForType() {
            return defaultInstance;
        }

        public Escaping getEscaping(int i) {
            return (Escaping) this.escaping_.get(i);
        }

        public int getEscapingCount() {
            return this.escaping_ == null ? 0 : this.escaping_.size();
        }

        public List getEscapingList() {
            return this.escaping_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.escaping_);
        }

        public String getFunctionId() {
            Object obj = this.functionId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            byte[] bArr = (byte[]) obj;
            String toStringUtf8 = Internal.toStringUtf8(bArr);
            if (Internal.isValidUtf8(bArr)) {
                this.functionId_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public byte[] getFunctionIdAsBytes() {
            Object obj = this.functionId_;
            if (!(obj instanceof String)) {
                return (byte[]) obj;
            }
            obj = Internal.toByteArray((String) obj);
            this.functionId_ = obj;
            return obj;
        }

        public long getInteger() {
            return this.integer_;
        }

        public Value getListItem(int i) {
            return (Value) this.listItem_.get(i);
        }

        public int getListItemCount() {
            return this.listItem_ == null ? 0 : this.listItem_.size();
        }

        public List getListItemList() {
            return this.listItem_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.listItem_);
        }

        public String getMacroReference() {
            Object obj = this.macroReference_;
            if (obj instanceof String) {
                return (String) obj;
            }
            byte[] bArr = (byte[]) obj;
            String toStringUtf8 = Internal.toStringUtf8(bArr);
            if (Internal.isValidUtf8(bArr)) {
                this.macroReference_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public byte[] getMacroReferenceAsBytes() {
            Object obj = this.macroReference_;
            if (!(obj instanceof String)) {
                return (byte[]) obj;
            }
            obj = Internal.toByteArray((String) obj);
            this.macroReference_ = obj;
            return obj;
        }

        public Value getMapKey(int i) {
            return (Value) this.mapKey_.get(i);
        }

        public int getMapKeyCount() {
            return this.mapKey_ == null ? 0 : this.mapKey_.size();
        }

        public List getMapKeyList() {
            return this.mapKey_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.mapKey_);
        }

        public Value getMapValue(int i) {
            return (Value) this.mapValue_.get(i);
        }

        public int getMapValueCount() {
            return this.mapValue_ == null ? 0 : this.mapValue_.size();
        }

        public List getMapValueList() {
            return this.mapValue_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.mapValue_);
        }

        public List getMutableEscapingList() {
            assertMutable();
            ensureEscapingInitialized();
            return this.escaping_;
        }

        public Value getMutableListItem(int i) {
            return (Value) this.listItem_.get(i);
        }

        public List getMutableListItemList() {
            assertMutable();
            ensureListItemInitialized();
            return this.listItem_;
        }

        public Value getMutableMapKey(int i) {
            return (Value) this.mapKey_.get(i);
        }

        public List getMutableMapKeyList() {
            assertMutable();
            ensureMapKeyInitialized();
            return this.mapKey_;
        }

        public Value getMutableMapValue(int i) {
            return (Value) this.mapValue_.get(i);
        }

        public List getMutableMapValueList() {
            assertMutable();
            ensureMapValueInitialized();
            return this.mapValue_;
        }

        public Value getMutableTemplateToken(int i) {
            return (Value) this.templateToken_.get(i);
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
            int i3 = 0;
            int computeEnumSize = CodedOutputStream.computeEnumSize(1, this.type_.getNumber()) + 0;
            if ((this.bitField0_ & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeByteArraySize(2, getStringAsBytes());
            }
            if (this.listItem_ != null) {
                i = computeEnumSize;
                for (i2 = 0; i2 < this.listItem_.size(); i2++) {
                    i += CodedOutputStream.computeMessageSize(3, (MessageLite) this.listItem_.get(i2));
                }
            } else {
                i = computeEnumSize;
            }
            if (this.mapKey_ != null) {
                for (i2 = 0; i2 < this.mapKey_.size(); i2++) {
                    i += CodedOutputStream.computeMessageSize(4, (MessageLite) this.mapKey_.get(i2));
                }
            }
            if (this.mapValue_ != null) {
                for (i2 = 0; i2 < this.mapValue_.size(); i2++) {
                    i += CodedOutputStream.computeMessageSize(5, (MessageLite) this.mapValue_.get(i2));
                }
            }
            if ((this.bitField0_ & 4) == 4) {
                i += CodedOutputStream.computeByteArraySize(6, getMacroReferenceAsBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                i += CodedOutputStream.computeByteArraySize(7, getFunctionIdAsBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                i += CodedOutputStream.computeInt64Size(8, this.integer_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i += CodedOutputStream.computeBoolSize(12, this.boolean_);
            }
            if (this.templateToken_ != null) {
                for (i2 = 0; i2 < this.templateToken_.size(); i2++) {
                    i += CodedOutputStream.computeMessageSize(11, (MessageLite) this.templateToken_.get(i2));
                }
            }
            if (this.escaping_ != null && this.escaping_.size() > 0) {
                i2 = 0;
                while (i3 < this.escaping_.size()) {
                    i3++;
                    i2 = CodedOutputStream.computeEnumSizeNoTag(((Escaping) this.escaping_.get(i3)).getNumber()) + i2;
                }
                i = (i + i2) + (this.escaping_.size() * 1);
            }
            if ((this.bitField0_ & 64) == 64) {
                i += CodedOutputStream.computeBoolSize(9, this.containsReferences_);
            }
            computeEnumSize = (extensionsSerializedSize() + i) + this.unknownFields.size();
            this.cachedSize = computeEnumSize;
            return computeEnumSize;
        }

        public String getString() {
            Object obj = this.string_;
            if (obj instanceof String) {
                return (String) obj;
            }
            byte[] bArr = (byte[]) obj;
            String toStringUtf8 = Internal.toStringUtf8(bArr);
            if (Internal.isValidUtf8(bArr)) {
                this.string_ = toStringUtf8;
            }
            return toStringUtf8;
        }

        public byte[] getStringAsBytes() {
            Object obj = this.string_;
            if (!(obj instanceof String)) {
                return (byte[]) obj;
            }
            obj = Internal.toByteArray((String) obj);
            this.string_ = obj;
            return obj;
        }

        public Value getTemplateToken(int i) {
            return (Value) this.templateToken_.get(i);
        }

        public int getTemplateTokenCount() {
            return this.templateToken_ == null ? 0 : this.templateToken_.size();
        }

        public List getTemplateTokenList() {
            return this.templateToken_ == null ? Collections.emptyList() : Collections.unmodifiableList(this.templateToken_);
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
            int i = 41;
            if (hasType()) {
                i = 80454 + Internal.hashEnum(getType());
            }
            if (hasString()) {
                i = (((i * 37) + 2) * 53) + getString().hashCode();
            }
            if (getListItemCount() > 0) {
                i = (((i * 37) + 3) * 53) + getListItemList().hashCode();
            }
            if (getMapKeyCount() > 0) {
                i = (((i * 37) + 4) * 53) + getMapKeyList().hashCode();
            }
            if (getMapValueCount() > 0) {
                i = (((i * 37) + 5) * 53) + getMapValueList().hashCode();
            }
            if (hasMacroReference()) {
                i = (((i * 37) + 6) * 53) + getMacroReference().hashCode();
            }
            if (hasFunctionId()) {
                i = (((i * 37) + 7) * 53) + getFunctionId().hashCode();
            }
            if (hasInteger()) {
                i = (((i * 37) + 8) * 53) + Internal.hashLong(getInteger());
            }
            if (hasBoolean()) {
                i = (((i * 37) + 12) * 53) + Internal.hashBoolean(getBoolean());
            }
            if (getTemplateTokenCount() > 0) {
                i = (((i * 37) + 11) * 53) + getTemplateTokenList().hashCode();
            }
            if (getEscapingCount() > 0) {
                i = (((i * 37) + 10) * 53) + Internal.hashEnumList(getEscapingList());
            }
            if (hasContainsReferences()) {
                i = (((i * 37) + 9) * 53) + Internal.hashBoolean(getContainsReferences());
            }
            return (i * 29) + this.unknownFields.hashCode();
        }

        protected MessageLite internalImmutableDefault() {
            if (immutableDefault == null) {
                immutableDefault = GeneratedMutableMessageLite.internalImmutableDefault("com.google.analytics.midtier.proto.containertag.TypeSystem$Value");
            }
            return immutableDefault;
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

        public Value mergeFrom(Value value) {
            if (this == value) {
                throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
            }
            assertMutable();
            if (value != getDefaultInstance()) {
                byte[] bArr;
                if (value.hasType()) {
                    setType(value.getType());
                }
                if (value.hasString()) {
                    this.bitField0_ |= 2;
                    if (value.string_ instanceof String) {
                        this.string_ = value.string_;
                    } else {
                        bArr = (byte[]) value.string_;
                        this.string_ = Arrays.copyOf(bArr, bArr.length);
                    }
                }
                if (!(value.listItem_ == null || value.listItem_.isEmpty())) {
                    ensureListItemInitialized();
                    AbstractMutableMessageLite.addAll(value.listItem_, this.listItem_);
                }
                if (!(value.mapKey_ == null || value.mapKey_.isEmpty())) {
                    ensureMapKeyInitialized();
                    AbstractMutableMessageLite.addAll(value.mapKey_, this.mapKey_);
                }
                if (!(value.mapValue_ == null || value.mapValue_.isEmpty())) {
                    ensureMapValueInitialized();
                    AbstractMutableMessageLite.addAll(value.mapValue_, this.mapValue_);
                }
                if (value.hasMacroReference()) {
                    this.bitField0_ |= 4;
                    if (value.macroReference_ instanceof String) {
                        this.macroReference_ = value.macroReference_;
                    } else {
                        bArr = (byte[]) value.macroReference_;
                        this.macroReference_ = Arrays.copyOf(bArr, bArr.length);
                    }
                }
                if (value.hasFunctionId()) {
                    this.bitField0_ |= 8;
                    if (value.functionId_ instanceof String) {
                        this.functionId_ = value.functionId_;
                    } else {
                        bArr = (byte[]) value.functionId_;
                        this.functionId_ = Arrays.copyOf(bArr, bArr.length);
                    }
                }
                if (value.hasInteger()) {
                    setInteger(value.getInteger());
                }
                if (value.hasContainsReferences()) {
                    setContainsReferences(value.getContainsReferences());
                }
                if (!(value.escaping_ == null || value.escaping_.isEmpty())) {
                    ensureEscapingInitialized();
                    this.escaping_.addAll(value.escaping_);
                }
                if (!(value.templateToken_ == null || value.templateToken_.isEmpty())) {
                    ensureTemplateTokenInitialized();
                    AbstractMutableMessageLite.addAll(value.templateToken_, this.templateToken_);
                }
                if (value.hasBoolean()) {
                    setBoolean(value.getBoolean());
                }
                mergeExtensionFields(value);
                this.unknownFields = this.unknownFields.concat(value.unknownFields);
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
                    int readEnum;
                    switch (readTag) {
                        case APKExpansionPolicy.MAIN_FILE_URL_INDEX /*0*/:
                            z = true;
                            break;
                        case 8:
                            readEnum = codedInputStream.readEnum();
                            Type valueOf = Type.valueOf(readEnum);
                            if (valueOf != null) {
                                this.bitField0_ |= 1;
                                this.type_ = valueOf;
                                break;
                            }
                            newInstance.writeRawVarint32(readTag);
                            newInstance.writeRawVarint32(readEnum);
                            break;
                        case 18:
                            this.bitField0_ |= 2;
                            this.string_ = codedInputStream.readByteArray();
                            break;
                        case 26:
                            codedInputStream.readMessage(addListItem(), extensionRegistryLite);
                            break;
                        case 34:
                            codedInputStream.readMessage(addMapKey(), extensionRegistryLite);
                            break;
                        case 42:
                            codedInputStream.readMessage(addMapValue(), extensionRegistryLite);
                            break;
                        case 50:
                            this.bitField0_ |= 4;
                            this.macroReference_ = codedInputStream.readByteArray();
                            break;
                        case 58:
                            this.bitField0_ |= 8;
                            this.functionId_ = codedInputStream.readByteArray();
                            break;
                        case 64:
                            this.bitField0_ |= 16;
                            this.integer_ = codedInputStream.readInt64();
                            break;
                        case 72:
                            this.bitField0_ |= 64;
                            this.containsReferences_ = codedInputStream.readBool();
                            break;
                        case 80:
                            readEnum = codedInputStream.readEnum();
                            Escaping valueOf2 = Escaping.valueOf(readEnum);
                            if (valueOf2 != null) {
                                if (this.escaping_ == null) {
                                    this.escaping_ = new ArrayList();
                                }
                                this.escaping_.add(valueOf2);
                                break;
                            }
                            newInstance.writeRawVarint32(readTag);
                            newInstance.writeRawVarint32(readEnum);
                            break;
                        case 82:
                            readEnum = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                int readEnum2 = codedInputStream.readEnum();
                                Escaping valueOf3 = Escaping.valueOf(readEnum2);
                                if (valueOf3 == null) {
                                    newInstance.writeRawVarint32(readTag);
                                    newInstance.writeRawVarint32(readEnum2);
                                } else {
                                    if (this.escaping_ == null) {
                                        this.escaping_ = new ArrayList();
                                    }
                                    this.escaping_.add(valueOf3);
                                }
                            }
                            codedInputStream.popLimit(readEnum);
                            break;
                        case 90:
                            codedInputStream.readMessage(addTemplateToken(), extensionRegistryLite);
                            break;
                        case 96:
                            this.bitField0_ |= 32;
                            this.boolean_ = codedInputStream.readBool();
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

        public Value newMessageForType() {
            return new Value();
        }

        public Value setBoolean(boolean z) {
            assertMutable();
            this.bitField0_ |= 32;
            this.boolean_ = z;
            return this;
        }

        public Value setContainsReferences(boolean z) {
            assertMutable();
            this.bitField0_ |= 64;
            this.containsReferences_ = z;
            return this;
        }

        public Value setEscaping(int i, Escaping escaping) {
            assertMutable();
            if (escaping == null) {
                throw new NullPointerException();
            }
            ensureEscapingInitialized();
            this.escaping_.set(i, escaping);
            return this;
        }

        public Value setFunctionId(String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 8;
            this.functionId_ = str;
            return this;
        }

        public Value setFunctionIdAsBytes(byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 8;
            this.functionId_ = bArr;
            return this;
        }

        public Value setInteger(long j) {
            assertMutable();
            this.bitField0_ |= 16;
            this.integer_ = j;
            return this;
        }

        public Value setListItem(int i, Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureListItemInitialized();
            this.listItem_.set(i, value);
            return this;
        }

        public Value setMacroReference(String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 4;
            this.macroReference_ = str;
            return this;
        }

        public Value setMacroReferenceAsBytes(byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 4;
            this.macroReference_ = bArr;
            return this;
        }

        public Value setMapKey(int i, Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureMapKeyInitialized();
            this.mapKey_.set(i, value);
            return this;
        }

        public Value setMapValue(int i, Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureMapValueInitialized();
            this.mapValue_.set(i, value);
            return this;
        }

        public Value setString(String str) {
            assertMutable();
            if (str == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.string_ = str;
            return this;
        }

        public Value setStringAsBytes(byte[] bArr) {
            assertMutable();
            if (bArr == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 2;
            this.string_ = bArr;
            return this;
        }

        public Value setTemplateToken(int i, Value value) {
            assertMutable();
            if (value == null) {
                throw new NullPointerException();
            }
            ensureTemplateTokenInitialized();
            this.templateToken_.set(i, value);
            return this;
        }

        public Value setType(Type type) {
            assertMutable();
            if (type == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 1;
            this.type_ = type;
            return this;
        }

        protected Object writeReplace() {
            return super.writeReplace();
        }

        public void writeToWithCachedSizes(CodedOutputStream codedOutputStream) {
            int i;
            int i2 = 0;
            int totalBytesWritten = codedOutputStream.getTotalBytesWritten();
            ExtensionWriter newExtensionWriter = newExtensionWriter();
            codedOutputStream.writeEnum(1, this.type_.getNumber());
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeByteArray(2, getStringAsBytes());
            }
            if (this.listItem_ != null) {
                for (i = 0; i < this.listItem_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(3, (MutableMessageLite) this.listItem_.get(i));
                }
            }
            if (this.mapKey_ != null) {
                for (i = 0; i < this.mapKey_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(4, (MutableMessageLite) this.mapKey_.get(i));
                }
            }
            if (this.mapValue_ != null) {
                for (i = 0; i < this.mapValue_.size(); i++) {
                    codedOutputStream.writeMessageWithCachedSizes(5, (MutableMessageLite) this.mapValue_.get(i));
                }
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeByteArray(6, getMacroReferenceAsBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeByteArray(7, getFunctionIdAsBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeInt64(8, this.integer_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeBool(9, this.containsReferences_);
            }
            if (this.escaping_ != null) {
                for (i = 0; i < this.escaping_.size(); i++) {
                    codedOutputStream.writeEnum(10, ((Escaping) this.escaping_.get(i)).getNumber());
                }
            }
            if (this.templateToken_ != null) {
                while (i2 < this.templateToken_.size()) {
                    codedOutputStream.writeMessageWithCachedSizes(11, (MutableMessageLite) this.templateToken_.get(i2));
                    i2++;
                }
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBool(12, this.boolean_);
            }
            newExtensionWriter.writeUntil(536870912, codedOutputStream);
            codedOutputStream.writeRawBytes(this.unknownFields);
            if (getCachedSize() != codedOutputStream.getTotalBytesWritten() - totalBytesWritten) {
                throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
            }
        }
    }

    private MutableTypeSystem() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
