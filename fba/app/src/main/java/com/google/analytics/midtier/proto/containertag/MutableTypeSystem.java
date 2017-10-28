package com.google.analytics.midtier.proto.containertag;

import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.tagmanager.protobuf.AbstractMutableMessageLite;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite.ExtendableMutableMessage;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import com.google.tagmanager.protobuf.Utf8;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MutableTypeSystem {
	public static final class Value extends ExtendableMutableMessage<MutableTypeSystem.Value> implements MutableMessageLite {
		public static final int BOOLEAN_FIELD_NUMBER = 12;
		public static final int CONTAINS_REFERENCES_FIELD_NUMBER = 9;
		public static final int ESCAPING_FIELD_NUMBER = 10;
		public static final int FUNCTION_ID_FIELD_NUMBER = 7;
		public static final int INTEGER_FIELD_NUMBER = 8;
		public static final int LIST_ITEM_FIELD_NUMBER = 3;
		public static final int MACRO_REFERENCE_FIELD_NUMBER = 6;
		public static final int MAP_KEY_FIELD_NUMBER = 4;
		public static final int MAP_VALUE_FIELD_NUMBER = 5;
		public static Parser<MutableTypeSystem.Value> PARSER = null;
		public static final int STRING_FIELD_NUMBER = 2;
		public static final int TEMPLATE_TOKEN_FIELD_NUMBER = 11;
		public static final int TYPE_FIELD_NUMBER = 1;
		private static final MutableTypeSystem.Value defaultInstance;
		private static volatile MessageLite immutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private boolean boolean_;
		private boolean containsReferences_;
		private List<Escaping> escaping_;
		private Object functionId_;
		private long integer_;
		private List<MutableTypeSystem.Value> listItem_;
		private Object macroReference_;
		private List<MutableTypeSystem.Value> mapKey_;
		private List<MutableTypeSystem.Value> mapValue_;
		private Object string_;
		private List<MutableTypeSystem.Value> templateToken_;
		private Type type_;

		public static enum Escaping implements EnumLite {
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
			private static EnumLiteMap<MutableTypeSystem.Value.Escaping> internalValueMap;
			private final int value;


			static {
				internalValueMap = new EnumLiteMap<MutableTypeSystem.Value.Escaping>() {
			public MutableTypeSystem.Value.Escaping findValueByNumber(int number) {
				return MutableTypeSystem.Value.Escaping.valueOf(number);
			}
		};
			}

			private Escaping(int index, int value) {
				this.value = value;
			}

			public static EnumLiteMap<MutableTypeSystem.Value.Escaping> internalGetValueMap() {
				return internalValueMap;
			}

			public static MutableTypeSystem.Value.Escaping valueOf(int value) {
				switch(value) {
				case ESCAPE_HTML_VALUE:
					return ESCAPE_HTML;
				case ESCAPE_HTML_RCDATA_VALUE:
					return ESCAPE_HTML_RCDATA;
				case ESCAPE_HTML_ATTRIBUTE_VALUE:
					return ESCAPE_HTML_ATTRIBUTE;
				case ESCAPE_HTML_ATTRIBUTE_NOSPACE_VALUE:
					return ESCAPE_HTML_ATTRIBUTE_NOSPACE;
				case FILTER_HTML_ELEMENT_NAME_VALUE:
					return FILTER_HTML_ELEMENT_NAME;
				case FILTER_HTML_ATTRIBUTES_VALUE:
					return FILTER_HTML_ATTRIBUTES;
				case ESCAPE_JS_STRING_VALUE:
					return ESCAPE_JS_STRING;
				case ESCAPE_JS_VALUE_VALUE:
					return ESCAPE_JS_VALUE;
				case ESCAPE_JS_REGEX_VALUE:
					return ESCAPE_JS_REGEX;
				case ESCAPE_CSS_STRING_VALUE:
					return ESCAPE_CSS_STRING;
				case FILTER_CSS_VALUE_VALUE:
					return FILTER_CSS_VALUE;
				case ESCAPE_URI_VALUE:
					return ESCAPE_URI;
				case NORMALIZE_URI_VALUE:
					return NORMALIZE_URI;
				case FILTER_NORMALIZE_URI_VALUE:
					return FILTER_NORMALIZE_URI;
				case NO_AUTOESCAPE_VALUE:
					return NO_AUTOESCAPE;
				case CONVERT_JS_VALUE_TO_EXPRESSION_VALUE:
					return CONVERT_JS_VALUE_TO_EXPRESSION;
				case TEXT_VALUE:
					return TEXT;
				}
				return null;
			}

			public final int getNumber() {
				return this.value;
			}
		}

		public static enum Type implements EnumLite {
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
			private static EnumLiteMap<MutableTypeSystem.Value.Type> internalValueMap;
			private final int value;


			static {
				internalValueMap = new EnumLiteMap<MutableTypeSystem.Value.Type>() {
			public MutableTypeSystem.Value.Type findValueByNumber(int number) {
				return MutableTypeSystem.Value.Type.valueOf(number);
			}
		};
			}

			private Type(int index, int value) {
				this.value = value;
			}

			public static EnumLiteMap<MutableTypeSystem.Value.Type> internalGetValueMap() {
				return internalValueMap;
			}

			public static MutableTypeSystem.Value.Type valueOf(int value) {
				switch(value) {
				case STRING_VALUE:
					return STRING;
				case LIST_VALUE:
					return LIST;
				case MAP_VALUE:
					return MAP;
				case MACRO_REFERENCE_VALUE:
					return MACRO_REFERENCE;
				case FUNCTION_ID_VALUE:
					return FUNCTION_ID;
				case INTEGER_VALUE:
					return INTEGER;
				case TEMPLATE_VALUE:
					return TEMPLATE;
				case BOOLEAN_VALUE:
					return BOOLEAN;
				}
				return null;
			}

			public final int getNumber() {
				return this.value;
			}
		}


		static {
			immutableDefault = null;
			defaultInstance = new MutableTypeSystem.Value(true);
			defaultInstance.initFields();
			defaultInstance.makeImmutable();
			PARSER = AbstractMutableMessageLite.internalNewParserForType(defaultInstance);
		}

		private Value() {
			this.type_ = Type.STRING;
			this.string_ = Internal.EMPTY_BYTE_ARRAY;
			this.listItem_ = null;
			this.mapKey_ = null;
			this.mapValue_ = null;
			this.macroReference_ = Internal.EMPTY_BYTE_ARRAY;
			this.functionId_ = Internal.EMPTY_BYTE_ARRAY;
			this.templateToken_ = null;
			this.escaping_ = null;
			initFields();
		}

		private Value(boolean noInit) {
			this.type_ = Type.STRING;
			this.string_ = Internal.EMPTY_BYTE_ARRAY;
			this.listItem_ = null;
			this.mapKey_ = null;
			this.mapValue_ = null;
			this.macroReference_ = Internal.EMPTY_BYTE_ARRAY;
			this.functionId_ = Internal.EMPTY_BYTE_ARRAY;
			this.templateToken_ = null;
			this.escaping_ = null;
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

		public static MutableTypeSystem.Value getDefaultInstance() {
			return defaultInstance;
		}

		private void initFields() {
			this.type_ = Type.STRING;
		}

		public static MutableTypeSystem.Value newMessage() {
			return new MutableTypeSystem.Value();
		}

		public MutableTypeSystem.Value addAllEscaping(Iterable<Escaping> values) {
			assertMutable();
			ensureEscapingInitialized();
			AbstractMutableMessageLite.addAll(values, this.escaping_);
			return this;
		}

		public MutableTypeSystem.Value addAllListItem(Iterable<MutableTypeSystem.Value> values) {
			assertMutable();
			ensureListItemInitialized();
			AbstractMutableMessageLite.addAll(values, this.listItem_);
			return this;
		}

		public MutableTypeSystem.Value addAllMapKey(Iterable<MutableTypeSystem.Value> values) {
			assertMutable();
			ensureMapKeyInitialized();
			AbstractMutableMessageLite.addAll(values, this.mapKey_);
			return this;
		}

		public MutableTypeSystem.Value addAllMapValue(Iterable<MutableTypeSystem.Value> values) {
			assertMutable();
			ensureMapValueInitialized();
			AbstractMutableMessageLite.addAll(values, this.mapValue_);
			return this;
		}

		public MutableTypeSystem.Value addAllTemplateToken(Iterable<MutableTypeSystem.Value> values) {
			assertMutable();
			ensureTemplateTokenInitialized();
			AbstractMutableMessageLite.addAll(values, this.templateToken_);
			return this;
		}

		public MutableTypeSystem.Value addEscaping(Escaping value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureEscapingInitialized();
				this.escaping_.add(value);
				return this;
			}
		}

		public MutableTypeSystem.Value addListItem() {
			assertMutable();
			ensureListItemInitialized();
			MutableTypeSystem.Value value = newMessage();
			this.listItem_.add(value);
			return value;
		}

		public MutableTypeSystem.Value addListItem(MutableTypeSystem.Value value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureListItemInitialized();
				this.listItem_.add(value);
				return this;
			}
		}

		public MutableTypeSystem.Value addMapKey() {
			assertMutable();
			ensureMapKeyInitialized();
			MutableTypeSystem.Value value = newMessage();
			this.mapKey_.add(value);
			return value;
		}

		public MutableTypeSystem.Value addMapKey(MutableTypeSystem.Value value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureMapKeyInitialized();
				this.mapKey_.add(value);
				return this;
			}
		}

		public MutableTypeSystem.Value addMapValue() {
			assertMutable();
			ensureMapValueInitialized();
			MutableTypeSystem.Value value = newMessage();
			this.mapValue_.add(value);
			return value;
		}

		public MutableTypeSystem.Value addMapValue(MutableTypeSystem.Value value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureMapValueInitialized();
				this.mapValue_.add(value);
				return this;
			}
		}

		public MutableTypeSystem.Value addTemplateToken() {
			assertMutable();
			ensureTemplateTokenInitialized();
			MutableTypeSystem.Value value = newMessage();
			this.templateToken_.add(value);
			return value;
		}

		public MutableTypeSystem.Value addTemplateToken(MutableTypeSystem.Value value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureTemplateTokenInitialized();
				this.templateToken_.add(value);
				return this;
			}
		}

		public MutableTypeSystem.Value clear() {
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

		public MutableTypeSystem.Value clearBoolean() {
			assertMutable();
			this.bitField0_ &= -33;
			this.boolean_ = false;
			return this;
		}

		public MutableTypeSystem.Value clearContainsReferences() {
			assertMutable();
			this.bitField0_ &= -65;
			this.containsReferences_ = false;
			return this;
		}

		public MutableTypeSystem.Value clearEscaping() {
			assertMutable();
			this.escaping_ = null;
			return this;
		}

		public MutableTypeSystem.Value clearFunctionId() {
			assertMutable();
			this.bitField0_ &= -9;
			this.functionId_ = Internal.EMPTY_BYTE_ARRAY;
			return this;
		}

		public MutableTypeSystem.Value clearInteger() {
			assertMutable();
			this.bitField0_ &= -17;
			this.integer_ = 0;
			return this;
		}

		public MutableTypeSystem.Value clearListItem() {
			assertMutable();
			this.listItem_ = null;
			return this;
		}

		public MutableTypeSystem.Value clearMacroReference() {
			assertMutable();
			this.bitField0_ &= -5;
			this.macroReference_ = Internal.EMPTY_BYTE_ARRAY;
			return this;
		}

		public MutableTypeSystem.Value clearMapKey() {
			assertMutable();
			this.mapKey_ = null;
			return this;
		}

		public MutableTypeSystem.Value clearMapValue() {
			assertMutable();
			this.mapValue_ = null;
			return this;
		}

		public MutableTypeSystem.Value clearString() {
			assertMutable();
			this.bitField0_ &= -3;
			this.string_ = Internal.EMPTY_BYTE_ARRAY;
			return this;
		}

		public MutableTypeSystem.Value clearTemplateToken() {
			assertMutable();
			this.templateToken_ = null;
			return this;
		}

		public MutableTypeSystem.Value clearType() {
			assertMutable();
			this.bitField0_ &= -2;
			this.type_ = Type.STRING;
			return this;
		}

		public MutableTypeSystem.Value clone() {
			return newMessageForType().mergeFrom(this);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof MutableTypeSystem.Value))) {
				return super.equals(obj);
			} else {
				boolean result;
				MutableTypeSystem.Value other = (MutableTypeSystem.Value) obj;
				if (!true || hasType() != other.hasType()) {
					result = false;
				} else {
					result = true;
				}
				if (hasType()) {
					result = (!result || getType() != other.getType()) ? false : true;
				}
				if (!result || hasString() != other.hasString()) {
					result = false;
				} else {
					result = true;
				}
				if (hasString()) {
					result = (!result || !getString().equals(other.getString())) ? false : true;
				}
				result = (!result || !getListItemList().equals(other.getListItemList())) ? false : true;
				result = (!result || !getMapKeyList().equals(other.getMapKeyList())) ? false : true;
				result = (!result || !getMapValueList().equals(other.getMapValueList())) ? false : true;
				if (!result || hasMacroReference() != other.hasMacroReference()) {
					result = false;
				} else {
					result = true;
				}
				if (hasMacroReference()) {
					result = (!result || !getMacroReference().equals(other.getMacroReference())) ? false : true;
				}
				if (!result || hasFunctionId() != other.hasFunctionId()) {
					result = false;
				} else {
					result = true;
				}
				if (hasFunctionId()) {
					result = (!result || !getFunctionId().equals(other.getFunctionId())) ? false : true;
				}
				if (!result || hasInteger() != other.hasInteger()) {
					result = false;
				} else {
					result = true;
				}
				if (hasInteger()) {
					result = (!result || getInteger() != other.getInteger()) ? false : true;
				}
				if (!result || hasBoolean() != other.hasBoolean()) {
					result = false;
				} else {
					result = true;
				}
				if (hasBoolean()) {
					result = (!result || getBoolean() != other.getBoolean()) ? false : true;
				}
				result = (!result || !getTemplateTokenList().equals(other.getTemplateTokenList())) ? false : true;
				result = (!result || !getEscapingList().equals(other.getEscapingList())) ? false : true;
				if (!result || hasContainsReferences() != other.hasContainsReferences()) {
					result = false;
				} else {
					result = true;
				}
				if (hasContainsReferences()) {
					result = (!result || getContainsReferences() != other.getContainsReferences()) ? false : true;
				}
				return result;
			}
		}

		public boolean getBoolean() {
			return this.boolean_;
		}

		public boolean getContainsReferences() {
			return this.containsReferences_;
		}

		public final MutableTypeSystem.Value getDefaultInstanceForType() {
			return defaultInstance;
		}

		public Escaping getEscaping(int index) {
			return (Escaping) this.escaping_.get(index);
		}

		public int getEscapingCount() {
			return (this.escaping_ == null) ? 0 : this.escaping_.size();
		}

		public List<Escaping> getEscapingList() {
			return (this.escaping_ == null) ? Collections.emptyList() : Collections.unmodifiableList(this.escaping_);
		}

		public String getFunctionId() {
			Object ref = this.functionId_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				byte[] byteArray = (byte[]) ((byte[]) ref);
				String s = Internal.toStringUtf8(byteArray);
				if (Internal.isValidUtf8(byteArray)) {
					this.functionId_ = s;
				}
				return s;
			}
		}

		public byte[] getFunctionIdAsBytes() {
			Object ref = this.functionId_;
			if (ref instanceof String) {
				Object byteArray = Internal.toByteArray((String) ref);
				this.functionId_ = byteArray;
				return byteArray;
			} else {
				return (byte[]) ((byte[]) ref);
			}
		}

		public long getInteger() {
			return this.integer_;
		}

		public MutableTypeSystem.Value getListItem(int index) {
			return (MutableTypeSystem.Value) this.listItem_.get(index);
		}

		public int getListItemCount() {
			return (this.listItem_ == null) ? 0 : this.listItem_.size();
		}

		public List<MutableTypeSystem.Value> getListItemList() {
			return (this.listItem_ == null) ? Collections.emptyList() : Collections.unmodifiableList(this.listItem_);
		}

		public String getMacroReference() {
			Object ref = this.macroReference_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				byte[] byteArray = (byte[]) ((byte[]) ref);
				String s = Internal.toStringUtf8(byteArray);
				if (Internal.isValidUtf8(byteArray)) {
					this.macroReference_ = s;
				}
				return s;
			}
		}

		public byte[] getMacroReferenceAsBytes() {
			Object ref = this.macroReference_;
			if (ref instanceof String) {
				Object byteArray = Internal.toByteArray((String) ref);
				this.macroReference_ = byteArray;
				return byteArray;
			} else {
				return (byte[]) ((byte[]) ref);
			}
		}

		public MutableTypeSystem.Value getMapKey(int index) {
			return (MutableTypeSystem.Value) this.mapKey_.get(index);
		}

		public int getMapKeyCount() {
			return (this.mapKey_ == null) ? 0 : this.mapKey_.size();
		}

		public List<MutableTypeSystem.Value> getMapKeyList() {
			return (this.mapKey_ == null) ? Collections.emptyList() : Collections.unmodifiableList(this.mapKey_);
		}

		public MutableTypeSystem.Value getMapValue(int index) {
			return (MutableTypeSystem.Value) this.mapValue_.get(index);
		}

		public int getMapValueCount() {
			return (this.mapValue_ == null) ? 0 : this.mapValue_.size();
		}

		public List<MutableTypeSystem.Value> getMapValueList() {
			return (this.mapValue_ == null) ? Collections.emptyList() : Collections.unmodifiableList(this.mapValue_);
		}

		public List<Escaping> getMutableEscapingList() {
			assertMutable();
			ensureEscapingInitialized();
			return this.escaping_;
		}

		public MutableTypeSystem.Value getMutableListItem(int index) {
			return (MutableTypeSystem.Value) this.listItem_.get(index);
		}

		public List<MutableTypeSystem.Value> getMutableListItemList() {
			assertMutable();
			ensureListItemInitialized();
			return this.listItem_;
		}

		public MutableTypeSystem.Value getMutableMapKey(int index) {
			return (MutableTypeSystem.Value) this.mapKey_.get(index);
		}

		public List<MutableTypeSystem.Value> getMutableMapKeyList() {
			assertMutable();
			ensureMapKeyInitialized();
			return this.mapKey_;
		}

		public MutableTypeSystem.Value getMutableMapValue(int index) {
			return (MutableTypeSystem.Value) this.mapValue_.get(index);
		}

		public List<MutableTypeSystem.Value> getMutableMapValueList() {
			assertMutable();
			ensureMapValueInitialized();
			return this.mapValue_;
		}

		public MutableTypeSystem.Value getMutableTemplateToken(int index) {
			return (MutableTypeSystem.Value) this.templateToken_.get(index);
		}

		public List<MutableTypeSystem.Value> getMutableTemplateTokenList() {
			assertMutable();
			ensureTemplateTokenInitialized();
			return this.templateToken_;
		}

		public Parser<MutableTypeSystem.Value> getParserForType() {
			return PARSER;
		}

		public int getSerializedSize() {
			int i;
			int size = 0 + CodedOutputStream.computeEnumSize(TYPE_FIELD_NUMBER, this.type_.getNumber());
			if ((this.bitField0_ & 2) == 2) {
				size += CodedOutputStream.computeByteArraySize(STRING_FIELD_NUMBER, getStringAsBytes());
			}
			if (this.listItem_ != null) {
				i = 0;
				while (i < this.listItem_.size()) {
					size += CodedOutputStream.computeMessageSize(LIST_ITEM_FIELD_NUMBER, (MessageLite) this.listItem_.get(i));
					i++;
				}
			}
			if (this.mapKey_ != null) {
				i = 0;
				while (i < this.mapKey_.size()) {
					size += CodedOutputStream.computeMessageSize(MAP_KEY_FIELD_NUMBER, (MessageLite) this.mapKey_.get(i));
					i++;
				}
			}
			if (this.mapValue_ != null) {
				i = 0;
				while (i < this.mapValue_.size()) {
					i++;
				}
			}
			if ((this.bitField0_ & 4) == 4) {
				size += CodedOutputStream.computeByteArraySize(MACRO_REFERENCE_FIELD_NUMBER, getMacroReferenceAsBytes());
			}
			if ((this.bitField0_ & 8) == 8) {
				size += CodedOutputStream.computeByteArraySize(FUNCTION_ID_FIELD_NUMBER, getFunctionIdAsBytes());
			}
			if ((this.bitField0_ & 16) == 16) {
				size += CodedOutputStream.computeInt64Size(INTEGER_FIELD_NUMBER, this.integer_);
			}
			if ((this.bitField0_ & 32) == 32) {
				size += CodedOutputStream.computeBoolSize(BOOLEAN_FIELD_NUMBER, this.boolean_);
			}
			if (this.templateToken_ != null) {
				i = 0;
				while (i < this.templateToken_.size()) {
					size += CodedOutputStream.computeMessageSize(TEMPLATE_TOKEN_FIELD_NUMBER, (MessageLite) this.templateToken_.get(i));
					i++;
				}
			}
			if (this.escaping_ == null || this.escaping_.size() <= 0) {
				if ((this.bitField0_ & 64) != 64) {
					size += CodedOutputStream.computeBoolSize(CONTAINS_REFERENCES_FIELD_NUMBER, this.containsReferences_);
				}
				size = (size + extensionsSerializedSize()) + this.unknownFields.size();
				this.cachedSize = size;
				return size;
			} else {
				int dataSize = 0;
				i = 0;
				while (i < this.escaping_.size()) {
					dataSize += CodedOutputStream.computeEnumSizeNoTag(((Escaping) this.escaping_.get(i)).getNumber());
					i++;
				}
				size = (size + dataSize) + (this.escaping_.size() * 1);
				if ((this.bitField0_ & 64) != 64) {
					size = (size + extensionsSerializedSize()) + this.unknownFields.size();
					this.cachedSize = size;
					return size;
				} else {
					size += CodedOutputStream.computeBoolSize(CONTAINS_REFERENCES_FIELD_NUMBER, this.containsReferences_);
					size = (size + extensionsSerializedSize()) + this.unknownFields.size();
					this.cachedSize = size;
					return size;
				}
			}
		}

		public String getString() {
			Object ref = this.string_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				byte[] byteArray = (byte[]) ((byte[]) ref);
				String s = Internal.toStringUtf8(byteArray);
				if (Internal.isValidUtf8(byteArray)) {
					this.string_ = s;
				}
				return s;
			}
		}

		public byte[] getStringAsBytes() {
			Object ref = this.string_;
			if (ref instanceof String) {
				Object byteArray = Internal.toByteArray((String) ref);
				this.string_ = byteArray;
				return byteArray;
			} else {
				return (byte[]) ((byte[]) ref);
			}
		}

		public MutableTypeSystem.Value getTemplateToken(int index) {
			return (MutableTypeSystem.Value) this.templateToken_.get(index);
		}

		public int getTemplateTokenCount() {
			return (this.templateToken_ == null) ? 0 : this.templateToken_.size();
		}

		public List<MutableTypeSystem.Value> getTemplateTokenList() {
			return (this.templateToken_ == null) ? Collections.emptyList() : Collections.unmodifiableList(this.templateToken_);
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
			int hash = 41;
			if (hasType()) {
				hash = 1517 + 1;
				hash = 80454 + Internal.hashEnum(getType());
			}
			if (hasString()) {
				hash = (((hash * 37) + 2) * 53) + getString().hashCode();
			}
			if (getListItemCount() > 0) {
				hash = (((hash * 37) + 3) * 53) + getListItemList().hashCode();
			}
			if (getMapKeyCount() > 0) {
				hash = (((hash * 37) + 4) * 53) + getMapKeyList().hashCode();
			}
			if (getMapValueCount() > 0) {
				hash = (((hash * 37) + 5) * 53) + getMapValueList().hashCode();
			}
			if (hasMacroReference()) {
				hash = (((hash * 37) + 6) * 53) + getMacroReference().hashCode();
			}
			if (hasFunctionId()) {
				hash = (((hash * 37) + 7) * 53) + getFunctionId().hashCode();
			}
			if (hasInteger()) {
				hash = (((hash * 37) + 8) * 53) + Internal.hashLong(getInteger());
			}
			if (hasBoolean()) {
				hash = (((hash * 37) + 12) * 53) + Internal.hashBoolean(getBoolean());
			}
			if (getTemplateTokenCount() > 0) {
				hash = (((hash * 37) + 11) * 53) + getTemplateTokenList().hashCode();
			}
			if (getEscapingCount() > 0) {
				hash = (((hash * 37) + 10) * 53) + Internal.hashEnumList(getEscapingList());
			}
			if (hasContainsReferences()) {
				hash = (((hash * 37) + 9) * 53) + Internal.hashBoolean(getContainsReferences());
			}
			return (hash * 29) + this.unknownFields.hashCode();
		}

		protected MessageLite internalImmutableDefault() {
			if (immutableDefault == null) {
				immutableDefault = internalImmutableDefault("com.google.analytics.midtier.proto.containertag.TypeSystem$Value");
			}
			return immutableDefault;
		}

		public final boolean isInitialized() {
			if (!hasType()) {
				return false;
			} else {
				int i = 0;
				while (i < getListItemCount()) {
					if (getListItem(i).isInitialized()) {
						i++;
					}
					return false;
				}
				i = 0;
				while (i < getMapKeyCount()) {
					if (getMapKey(i).isInitialized()) {
						i++;
					}
					return false;
				}
				i = 0;
				while (i < getMapValueCount()) {
					if (getMapValue(i).isInitialized()) {
						i++;
					}
					return false;
				}
				i = 0;
				while (i < getTemplateTokenCount()) {
					if (getTemplateToken(i).isInitialized()) {
						i++;
					}
					return false;
				}
				if (extensionsAreInitialized()) {
					return true;
				}
				return false;
			}
		}

		public MutableTypeSystem.Value mergeFrom(MutableTypeSystem.Value other) {
			if (this == other) {
				throw new IllegalArgumentException("mergeFrom(message) called on the same message.");
			} else {
				assertMutable();
				if (other == getDefaultInstance()) {
					return this;
				} else {
					byte[] ba;
					if (other.hasType()) {
						setType(other.getType());
					}
					if (other.hasString()) {
						this.bitField0_ |= 2;
						if (other.string_ instanceof String) {
							this.string_ = other.string_;
						} else {
							ba = (byte[]) other.string_;
							this.string_ = Arrays.copyOf(ba, ba.length);
						}
					}
					if (other.listItem_ == null || other.listItem_.isEmpty()) {
						if (other.mapKey_ == null || other.mapKey_.isEmpty()) {
							if (other.mapValue_ == null || other.mapValue_.isEmpty()) {
								if (!other.hasMacroReference()) {
									this.bitField0_ |= 4;
									if (!((other.macroReference_ instanceof String))) {
										this.macroReference_ = other.macroReference_;
									} else {
										ba = (byte[]) other.macroReference_;
										this.macroReference_ = Arrays.copyOf(ba, ba.length);
									}
								}
								if (!other.hasFunctionId()) {
									this.bitField0_ |= 8;
									if (!((other.functionId_ instanceof String))) {
										this.functionId_ = other.functionId_;
									} else {
										ba = (byte[]) other.functionId_;
										this.functionId_ = Arrays.copyOf(ba, ba.length);
									}
								}
								if (!other.hasInteger()) {
									setInteger(other.getInteger());
								}
								if (!other.hasContainsReferences()) {
									setContainsReferences(other.getContainsReferences());
								}
								if (other.escaping_ == null || other.escaping_.isEmpty()) {
									if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
										if (!other.hasBoolean()) {
											setBoolean(other.getBoolean());
										}
										mergeExtensionFields(other);
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureTemplateTokenInitialized();
										AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
										if (!other.hasBoolean()) {
											mergeExtensionFields(other);
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											setBoolean(other.getBoolean());
											mergeExtensionFields(other);
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureEscapingInitialized();
									this.escaping_.addAll(other.escaping_);
									if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
										if (!other.hasBoolean()) {
											setBoolean(other.getBoolean());
										}
										mergeExtensionFields(other);
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureTemplateTokenInitialized();
										AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
										if (!other.hasBoolean()) {
											mergeExtensionFields(other);
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											setBoolean(other.getBoolean());
											mergeExtensionFields(other);
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							} else {
								ensureMapValueInitialized();
								AbstractMutableMessageLite.addAll(other.mapValue_, this.mapValue_);
								if (!other.hasMacroReference()) {
									if (!other.hasFunctionId()) {
										if (!other.hasInteger()) {
											if (!other.hasContainsReferences()) {
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											} else {
												setContainsReferences(other.getContainsReferences());
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											}
										} else {
											setInteger(other.getInteger());
											if (!other.hasContainsReferences()) {
												setContainsReferences(other.getContainsReferences());
											}
											if (other.escaping_ == null || other.escaping_.isEmpty()) {
												if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
													if (!other.hasBoolean()) {
														setBoolean(other.getBoolean());
													}
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												} else {
													ensureTemplateTokenInitialized();
													AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
													if (!other.hasBoolean()) {
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														setBoolean(other.getBoolean());
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													}
												}
											} else {
												ensureEscapingInitialized();
												this.escaping_.addAll(other.escaping_);
												if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
													if (!other.hasBoolean()) {
														setBoolean(other.getBoolean());
													}
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												} else {
													ensureTemplateTokenInitialized();
													AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
													if (!other.hasBoolean()) {
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														setBoolean(other.getBoolean());
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													}
												}
											}
										}
									} else {
										this.bitField0_ |= 8;
										if (!((other.functionId_ instanceof String))) {
											ba = (byte[]) other.functionId_;
											this.functionId_ = Arrays.copyOf(ba, ba.length);
											if (!other.hasInteger()) {
												setInteger(other.getInteger());
											}
											if (!other.hasContainsReferences()) {
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											} else {
												setContainsReferences(other.getContainsReferences());
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											}
										} else {
											this.functionId_ = other.functionId_;
											if (!other.hasInteger()) {
												if (!other.hasContainsReferences()) {
													setContainsReferences(other.getContainsReferences());
												}
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											} else {
												setInteger(other.getInteger());
												if (!other.hasContainsReferences()) {
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												} else {
													setContainsReferences(other.getContainsReferences());
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												}
											}
										}
									}
								} else {
									this.bitField0_ |= 4;
									if (!((other.macroReference_ instanceof String))) {
										ba = (byte[]) other.macroReference_;
										this.macroReference_ = Arrays.copyOf(ba, ba.length);
										if (!other.hasFunctionId()) {
											this.bitField0_ |= 8;
											if (!((other.functionId_ instanceof String))) {
												this.functionId_ = other.functionId_;
											} else {
												ba = (byte[]) other.functionId_;
												this.functionId_ = Arrays.copyOf(ba, ba.length);
											}
										}
										if (!other.hasInteger()) {
											setInteger(other.getInteger());
										}
										if (!other.hasContainsReferences()) {
											setContainsReferences(other.getContainsReferences());
										}
										if (other.escaping_ == null || other.escaping_.isEmpty()) {
											if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
												if (!other.hasBoolean()) {
													setBoolean(other.getBoolean());
												}
												mergeExtensionFields(other);
												this.unknownFields = this.unknownFields.concat(other.unknownFields);
												return this;
											} else {
												ensureTemplateTokenInitialized();
												AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
												if (!other.hasBoolean()) {
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												} else {
													setBoolean(other.getBoolean());
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												}
											}
										} else {
											ensureEscapingInitialized();
											this.escaping_.addAll(other.escaping_);
											if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
												if (!other.hasBoolean()) {
													setBoolean(other.getBoolean());
												}
												mergeExtensionFields(other);
												this.unknownFields = this.unknownFields.concat(other.unknownFields);
												return this;
											} else {
												ensureTemplateTokenInitialized();
												AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
												if (!other.hasBoolean()) {
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												} else {
													setBoolean(other.getBoolean());
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												}
											}
										}
									} else {
										this.macroReference_ = other.macroReference_;
										if (!other.hasFunctionId()) {
											if (!other.hasInteger()) {
												if (!other.hasContainsReferences()) {
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												} else {
													setContainsReferences(other.getContainsReferences());
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												}
											} else {
												setInteger(other.getInteger());
												if (!other.hasContainsReferences()) {
													setContainsReferences(other.getContainsReferences());
												}
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											}
										} else {
											this.bitField0_ |= 8;
											if (!((other.functionId_ instanceof String))) {
												ba = (byte[]) other.functionId_;
												this.functionId_ = Arrays.copyOf(ba, ba.length);
												if (!other.hasInteger()) {
													setInteger(other.getInteger());
												}
												if (!other.hasContainsReferences()) {
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												} else {
													setContainsReferences(other.getContainsReferences());
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												}
											} else {
												this.functionId_ = other.functionId_;
												if (!other.hasInteger()) {
													if (!other.hasContainsReferences()) {
														setContainsReferences(other.getContainsReferences());
													}
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												} else {
													setInteger(other.getInteger());
													if (!other.hasContainsReferences()) {
														if (other.escaping_ == null || other.escaping_.isEmpty()) {
															if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
																if (!other.hasBoolean()) {
																	setBoolean(other.getBoolean());
																}
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																ensureTemplateTokenInitialized();
																AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
																if (!other.hasBoolean()) {
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																} else {
																	setBoolean(other.getBoolean());
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																}
															}
														} else {
															ensureEscapingInitialized();
															this.escaping_.addAll(other.escaping_);
															if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
																if (!other.hasBoolean()) {
																	setBoolean(other.getBoolean());
																}
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																ensureTemplateTokenInitialized();
																AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
																if (!other.hasBoolean()) {
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																} else {
																	setBoolean(other.getBoolean());
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																}
															}
														}
													} else {
														setContainsReferences(other.getContainsReferences());
														if (other.escaping_ == null || other.escaping_.isEmpty()) {
															if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
																if (!other.hasBoolean()) {
																	setBoolean(other.getBoolean());
																}
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																ensureTemplateTokenInitialized();
																AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
																if (!other.hasBoolean()) {
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																} else {
																	setBoolean(other.getBoolean());
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																}
															}
														} else {
															ensureEscapingInitialized();
															this.escaping_.addAll(other.escaping_);
															if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
																if (!other.hasBoolean()) {
																	setBoolean(other.getBoolean());
																}
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																ensureTemplateTokenInitialized();
																AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
																if (!other.hasBoolean()) {
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																} else {
																	setBoolean(other.getBoolean());
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						} else {
							ensureMapKeyInitialized();
							AbstractMutableMessageLite.addAll(other.mapKey_, this.mapKey_);
							if (other.mapValue_ == null || other.mapValue_.isEmpty()) {
								if (!other.hasMacroReference()) {
									this.bitField0_ |= 4;
									if (!((other.macroReference_ instanceof String))) {
										this.macroReference_ = other.macroReference_;
									} else {
										ba = (byte[]) other.macroReference_;
										this.macroReference_ = Arrays.copyOf(ba, ba.length);
									}
								}
								if (!other.hasFunctionId()) {
									this.bitField0_ |= 8;
									if (!((other.functionId_ instanceof String))) {
										this.functionId_ = other.functionId_;
									} else {
										ba = (byte[]) other.functionId_;
										this.functionId_ = Arrays.copyOf(ba, ba.length);
									}
								}
								if (!other.hasInteger()) {
									setInteger(other.getInteger());
								}
								if (!other.hasContainsReferences()) {
									setContainsReferences(other.getContainsReferences());
								}
								if (other.escaping_ == null || other.escaping_.isEmpty()) {
									if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
										if (!other.hasBoolean()) {
											setBoolean(other.getBoolean());
										}
										mergeExtensionFields(other);
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureTemplateTokenInitialized();
										AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
										if (!other.hasBoolean()) {
											mergeExtensionFields(other);
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											setBoolean(other.getBoolean());
											mergeExtensionFields(other);
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureEscapingInitialized();
									this.escaping_.addAll(other.escaping_);
									if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
										if (!other.hasBoolean()) {
											setBoolean(other.getBoolean());
										}
										mergeExtensionFields(other);
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureTemplateTokenInitialized();
										AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
										if (!other.hasBoolean()) {
											mergeExtensionFields(other);
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											setBoolean(other.getBoolean());
											mergeExtensionFields(other);
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							} else {
								ensureMapValueInitialized();
								AbstractMutableMessageLite.addAll(other.mapValue_, this.mapValue_);
								if (!other.hasMacroReference()) {
									if (!other.hasFunctionId()) {
										if (!other.hasInteger()) {
											if (!other.hasContainsReferences()) {
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											} else {
												setContainsReferences(other.getContainsReferences());
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											}
										} else {
											setInteger(other.getInteger());
											if (!other.hasContainsReferences()) {
												setContainsReferences(other.getContainsReferences());
											}
											if (other.escaping_ == null || other.escaping_.isEmpty()) {
												if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
													if (!other.hasBoolean()) {
														setBoolean(other.getBoolean());
													}
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												} else {
													ensureTemplateTokenInitialized();
													AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
													if (!other.hasBoolean()) {
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														setBoolean(other.getBoolean());
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													}
												}
											} else {
												ensureEscapingInitialized();
												this.escaping_.addAll(other.escaping_);
												if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
													if (!other.hasBoolean()) {
														setBoolean(other.getBoolean());
													}
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												} else {
													ensureTemplateTokenInitialized();
													AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
													if (!other.hasBoolean()) {
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														setBoolean(other.getBoolean());
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													}
												}
											}
										}
									} else {
										this.bitField0_ |= 8;
										if (!((other.functionId_ instanceof String))) {
											ba = (byte[]) other.functionId_;
											this.functionId_ = Arrays.copyOf(ba, ba.length);
											if (!other.hasInteger()) {
												setInteger(other.getInteger());
											}
											if (!other.hasContainsReferences()) {
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											} else {
												setContainsReferences(other.getContainsReferences());
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											}
										} else {
											this.functionId_ = other.functionId_;
											if (!other.hasInteger()) {
												if (!other.hasContainsReferences()) {
													setContainsReferences(other.getContainsReferences());
												}
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											} else {
												setInteger(other.getInteger());
												if (!other.hasContainsReferences()) {
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												} else {
													setContainsReferences(other.getContainsReferences());
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												}
											}
										}
									}
								} else {
									this.bitField0_ |= 4;
									if (!((other.macroReference_ instanceof String))) {
										ba = (byte[]) other.macroReference_;
										this.macroReference_ = Arrays.copyOf(ba, ba.length);
										if (!other.hasFunctionId()) {
											this.bitField0_ |= 8;
											if (!((other.functionId_ instanceof String))) {
												this.functionId_ = other.functionId_;
											} else {
												ba = (byte[]) other.functionId_;
												this.functionId_ = Arrays.copyOf(ba, ba.length);
											}
										}
										if (!other.hasInteger()) {
											setInteger(other.getInteger());
										}
										if (!other.hasContainsReferences()) {
											setContainsReferences(other.getContainsReferences());
										}
										if (other.escaping_ == null || other.escaping_.isEmpty()) {
											if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
												if (!other.hasBoolean()) {
													setBoolean(other.getBoolean());
												}
												mergeExtensionFields(other);
												this.unknownFields = this.unknownFields.concat(other.unknownFields);
												return this;
											} else {
												ensureTemplateTokenInitialized();
												AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
												if (!other.hasBoolean()) {
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												} else {
													setBoolean(other.getBoolean());
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												}
											}
										} else {
											ensureEscapingInitialized();
											this.escaping_.addAll(other.escaping_);
											if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
												if (!other.hasBoolean()) {
													setBoolean(other.getBoolean());
												}
												mergeExtensionFields(other);
												this.unknownFields = this.unknownFields.concat(other.unknownFields);
												return this;
											} else {
												ensureTemplateTokenInitialized();
												AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
												if (!other.hasBoolean()) {
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												} else {
													setBoolean(other.getBoolean());
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												}
											}
										}
									} else {
										this.macroReference_ = other.macroReference_;
										if (!other.hasFunctionId()) {
											if (!other.hasInteger()) {
												if (!other.hasContainsReferences()) {
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												} else {
													setContainsReferences(other.getContainsReferences());
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												}
											} else {
												setInteger(other.getInteger());
												if (!other.hasContainsReferences()) {
													setContainsReferences(other.getContainsReferences());
												}
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											}
										} else {
											this.bitField0_ |= 8;
											if (!((other.functionId_ instanceof String))) {
												ba = (byte[]) other.functionId_;
												this.functionId_ = Arrays.copyOf(ba, ba.length);
												if (!other.hasInteger()) {
													setInteger(other.getInteger());
												}
												if (!other.hasContainsReferences()) {
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												} else {
													setContainsReferences(other.getContainsReferences());
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												}
											} else {
												this.functionId_ = other.functionId_;
												if (!other.hasInteger()) {
													if (!other.hasContainsReferences()) {
														setContainsReferences(other.getContainsReferences());
													}
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												} else {
													setInteger(other.getInteger());
													if (!other.hasContainsReferences()) {
														if (other.escaping_ == null || other.escaping_.isEmpty()) {
															if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
																if (!other.hasBoolean()) {
																	setBoolean(other.getBoolean());
																}
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																ensureTemplateTokenInitialized();
																AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
																if (!other.hasBoolean()) {
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																} else {
																	setBoolean(other.getBoolean());
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																}
															}
														} else {
															ensureEscapingInitialized();
															this.escaping_.addAll(other.escaping_);
															if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
																if (!other.hasBoolean()) {
																	setBoolean(other.getBoolean());
																}
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																ensureTemplateTokenInitialized();
																AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
																if (!other.hasBoolean()) {
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																} else {
																	setBoolean(other.getBoolean());
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																}
															}
														}
													} else {
														setContainsReferences(other.getContainsReferences());
														if (other.escaping_ == null || other.escaping_.isEmpty()) {
															if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
																if (!other.hasBoolean()) {
																	setBoolean(other.getBoolean());
																}
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																ensureTemplateTokenInitialized();
																AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
																if (!other.hasBoolean()) {
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																} else {
																	setBoolean(other.getBoolean());
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																}
															}
														} else {
															ensureEscapingInitialized();
															this.escaping_.addAll(other.escaping_);
															if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
																if (!other.hasBoolean()) {
																	setBoolean(other.getBoolean());
																}
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																ensureTemplateTokenInitialized();
																AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
																if (!other.hasBoolean()) {
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																} else {
																	setBoolean(other.getBoolean());
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						ensureListItemInitialized();
						AbstractMutableMessageLite.addAll(other.listItem_, this.listItem_);
						if (other.mapKey_ == null || other.mapKey_.isEmpty()) {
							if (other.mapValue_ == null || other.mapValue_.isEmpty()) {
								if (!other.hasMacroReference()) {
									this.bitField0_ |= 4;
									if (!((other.macroReference_ instanceof String))) {
										this.macroReference_ = other.macroReference_;
									} else {
										ba = (byte[]) other.macroReference_;
										this.macroReference_ = Arrays.copyOf(ba, ba.length);
									}
								}
								if (!other.hasFunctionId()) {
									this.bitField0_ |= 8;
									if (!((other.functionId_ instanceof String))) {
										this.functionId_ = other.functionId_;
									} else {
										ba = (byte[]) other.functionId_;
										this.functionId_ = Arrays.copyOf(ba, ba.length);
									}
								}
								if (!other.hasInteger()) {
									setInteger(other.getInteger());
								}
								if (!other.hasContainsReferences()) {
									setContainsReferences(other.getContainsReferences());
								}
								if (other.escaping_ == null || other.escaping_.isEmpty()) {
									if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
										if (!other.hasBoolean()) {
											setBoolean(other.getBoolean());
										}
										mergeExtensionFields(other);
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureTemplateTokenInitialized();
										AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
										if (!other.hasBoolean()) {
											mergeExtensionFields(other);
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											setBoolean(other.getBoolean());
											mergeExtensionFields(other);
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureEscapingInitialized();
									this.escaping_.addAll(other.escaping_);
									if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
										if (!other.hasBoolean()) {
											setBoolean(other.getBoolean());
										}
										mergeExtensionFields(other);
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureTemplateTokenInitialized();
										AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
										if (!other.hasBoolean()) {
											mergeExtensionFields(other);
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											setBoolean(other.getBoolean());
											mergeExtensionFields(other);
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							} else {
								ensureMapValueInitialized();
								AbstractMutableMessageLite.addAll(other.mapValue_, this.mapValue_);
								if (!other.hasMacroReference()) {
									if (!other.hasFunctionId()) {
										if (!other.hasInteger()) {
											if (!other.hasContainsReferences()) {
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											} else {
												setContainsReferences(other.getContainsReferences());
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											}
										} else {
											setInteger(other.getInteger());
											if (!other.hasContainsReferences()) {
												setContainsReferences(other.getContainsReferences());
											}
											if (other.escaping_ == null || other.escaping_.isEmpty()) {
												if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
													if (!other.hasBoolean()) {
														setBoolean(other.getBoolean());
													}
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												} else {
													ensureTemplateTokenInitialized();
													AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
													if (!other.hasBoolean()) {
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														setBoolean(other.getBoolean());
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													}
												}
											} else {
												ensureEscapingInitialized();
												this.escaping_.addAll(other.escaping_);
												if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
													if (!other.hasBoolean()) {
														setBoolean(other.getBoolean());
													}
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												} else {
													ensureTemplateTokenInitialized();
													AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
													if (!other.hasBoolean()) {
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														setBoolean(other.getBoolean());
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													}
												}
											}
										}
									} else {
										this.bitField0_ |= 8;
										if (!((other.functionId_ instanceof String))) {
											ba = (byte[]) other.functionId_;
											this.functionId_ = Arrays.copyOf(ba, ba.length);
											if (!other.hasInteger()) {
												setInteger(other.getInteger());
											}
											if (!other.hasContainsReferences()) {
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											} else {
												setContainsReferences(other.getContainsReferences());
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											}
										} else {
											this.functionId_ = other.functionId_;
											if (!other.hasInteger()) {
												if (!other.hasContainsReferences()) {
													setContainsReferences(other.getContainsReferences());
												}
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											} else {
												setInteger(other.getInteger());
												if (!other.hasContainsReferences()) {
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												} else {
													setContainsReferences(other.getContainsReferences());
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												}
											}
										}
									}
								} else {
									this.bitField0_ |= 4;
									if (!((other.macroReference_ instanceof String))) {
										ba = (byte[]) other.macroReference_;
										this.macroReference_ = Arrays.copyOf(ba, ba.length);
										if (!other.hasFunctionId()) {
											this.bitField0_ |= 8;
											if (!((other.functionId_ instanceof String))) {
												this.functionId_ = other.functionId_;
											} else {
												ba = (byte[]) other.functionId_;
												this.functionId_ = Arrays.copyOf(ba, ba.length);
											}
										}
										if (!other.hasInteger()) {
											setInteger(other.getInteger());
										}
										if (!other.hasContainsReferences()) {
											setContainsReferences(other.getContainsReferences());
										}
										if (other.escaping_ == null || other.escaping_.isEmpty()) {
											if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
												if (!other.hasBoolean()) {
													setBoolean(other.getBoolean());
												}
												mergeExtensionFields(other);
												this.unknownFields = this.unknownFields.concat(other.unknownFields);
												return this;
											} else {
												ensureTemplateTokenInitialized();
												AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
												if (!other.hasBoolean()) {
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												} else {
													setBoolean(other.getBoolean());
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												}
											}
										} else {
											ensureEscapingInitialized();
											this.escaping_.addAll(other.escaping_);
											if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
												if (!other.hasBoolean()) {
													setBoolean(other.getBoolean());
												}
												mergeExtensionFields(other);
												this.unknownFields = this.unknownFields.concat(other.unknownFields);
												return this;
											} else {
												ensureTemplateTokenInitialized();
												AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
												if (!other.hasBoolean()) {
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												} else {
													setBoolean(other.getBoolean());
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												}
											}
										}
									} else {
										this.macroReference_ = other.macroReference_;
										if (!other.hasFunctionId()) {
											if (!other.hasInteger()) {
												if (!other.hasContainsReferences()) {
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												} else {
													setContainsReferences(other.getContainsReferences());
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												}
											} else {
												setInteger(other.getInteger());
												if (!other.hasContainsReferences()) {
													setContainsReferences(other.getContainsReferences());
												}
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											}
										} else {
											this.bitField0_ |= 8;
											if (!((other.functionId_ instanceof String))) {
												ba = (byte[]) other.functionId_;
												this.functionId_ = Arrays.copyOf(ba, ba.length);
												if (!other.hasInteger()) {
													setInteger(other.getInteger());
												}
												if (!other.hasContainsReferences()) {
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												} else {
													setContainsReferences(other.getContainsReferences());
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												}
											} else {
												this.functionId_ = other.functionId_;
												if (!other.hasInteger()) {
													if (!other.hasContainsReferences()) {
														setContainsReferences(other.getContainsReferences());
													}
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												} else {
													setInteger(other.getInteger());
													if (!other.hasContainsReferences()) {
														if (other.escaping_ == null || other.escaping_.isEmpty()) {
															if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
																if (!other.hasBoolean()) {
																	setBoolean(other.getBoolean());
																}
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																ensureTemplateTokenInitialized();
																AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
																if (!other.hasBoolean()) {
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																} else {
																	setBoolean(other.getBoolean());
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																}
															}
														} else {
															ensureEscapingInitialized();
															this.escaping_.addAll(other.escaping_);
															if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
																if (!other.hasBoolean()) {
																	setBoolean(other.getBoolean());
																}
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																ensureTemplateTokenInitialized();
																AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
																if (!other.hasBoolean()) {
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																} else {
																	setBoolean(other.getBoolean());
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																}
															}
														}
													} else {
														setContainsReferences(other.getContainsReferences());
														if (other.escaping_ == null || other.escaping_.isEmpty()) {
															if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
																if (!other.hasBoolean()) {
																	setBoolean(other.getBoolean());
																}
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																ensureTemplateTokenInitialized();
																AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
																if (!other.hasBoolean()) {
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																} else {
																	setBoolean(other.getBoolean());
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																}
															}
														} else {
															ensureEscapingInitialized();
															this.escaping_.addAll(other.escaping_);
															if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
																if (!other.hasBoolean()) {
																	setBoolean(other.getBoolean());
																}
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																ensureTemplateTokenInitialized();
																AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
																if (!other.hasBoolean()) {
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																} else {
																	setBoolean(other.getBoolean());
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						} else {
							ensureMapKeyInitialized();
							AbstractMutableMessageLite.addAll(other.mapKey_, this.mapKey_);
							if (other.mapValue_ == null || other.mapValue_.isEmpty()) {
								if (!other.hasMacroReference()) {
									this.bitField0_ |= 4;
									if (!((other.macroReference_ instanceof String))) {
										this.macroReference_ = other.macroReference_;
									} else {
										ba = (byte[]) other.macroReference_;
										this.macroReference_ = Arrays.copyOf(ba, ba.length);
									}
								}
								if (!other.hasFunctionId()) {
									this.bitField0_ |= 8;
									if (!((other.functionId_ instanceof String))) {
										this.functionId_ = other.functionId_;
									} else {
										ba = (byte[]) other.functionId_;
										this.functionId_ = Arrays.copyOf(ba, ba.length);
									}
								}
								if (!other.hasInteger()) {
									setInteger(other.getInteger());
								}
								if (!other.hasContainsReferences()) {
									setContainsReferences(other.getContainsReferences());
								}
								if (other.escaping_ == null || other.escaping_.isEmpty()) {
									if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
										if (!other.hasBoolean()) {
											setBoolean(other.getBoolean());
										}
										mergeExtensionFields(other);
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureTemplateTokenInitialized();
										AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
										if (!other.hasBoolean()) {
											mergeExtensionFields(other);
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											setBoolean(other.getBoolean());
											mergeExtensionFields(other);
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								} else {
									ensureEscapingInitialized();
									this.escaping_.addAll(other.escaping_);
									if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
										if (!other.hasBoolean()) {
											setBoolean(other.getBoolean());
										}
										mergeExtensionFields(other);
										this.unknownFields = this.unknownFields.concat(other.unknownFields);
										return this;
									} else {
										ensureTemplateTokenInitialized();
										AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
										if (!other.hasBoolean()) {
											mergeExtensionFields(other);
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										} else {
											setBoolean(other.getBoolean());
											mergeExtensionFields(other);
											this.unknownFields = this.unknownFields.concat(other.unknownFields);
											return this;
										}
									}
								}
							} else {
								ensureMapValueInitialized();
								AbstractMutableMessageLite.addAll(other.mapValue_, this.mapValue_);
								if (!other.hasMacroReference()) {
									if (!other.hasFunctionId()) {
										if (!other.hasInteger()) {
											if (!other.hasContainsReferences()) {
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											} else {
												setContainsReferences(other.getContainsReferences());
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											}
										} else {
											setInteger(other.getInteger());
											if (!other.hasContainsReferences()) {
												setContainsReferences(other.getContainsReferences());
											}
											if (other.escaping_ == null || other.escaping_.isEmpty()) {
												if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
													if (!other.hasBoolean()) {
														setBoolean(other.getBoolean());
													}
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												} else {
													ensureTemplateTokenInitialized();
													AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
													if (!other.hasBoolean()) {
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														setBoolean(other.getBoolean());
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													}
												}
											} else {
												ensureEscapingInitialized();
												this.escaping_.addAll(other.escaping_);
												if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
													if (!other.hasBoolean()) {
														setBoolean(other.getBoolean());
													}
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												} else {
													ensureTemplateTokenInitialized();
													AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
													if (!other.hasBoolean()) {
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														setBoolean(other.getBoolean());
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													}
												}
											}
										}
									} else {
										this.bitField0_ |= 8;
										if (!((other.functionId_ instanceof String))) {
											ba = (byte[]) other.functionId_;
											this.functionId_ = Arrays.copyOf(ba, ba.length);
											if (!other.hasInteger()) {
												setInteger(other.getInteger());
											}
											if (!other.hasContainsReferences()) {
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											} else {
												setContainsReferences(other.getContainsReferences());
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											}
										} else {
											this.functionId_ = other.functionId_;
											if (!other.hasInteger()) {
												if (!other.hasContainsReferences()) {
													setContainsReferences(other.getContainsReferences());
												}
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											} else {
												setInteger(other.getInteger());
												if (!other.hasContainsReferences()) {
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												} else {
													setContainsReferences(other.getContainsReferences());
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												}
											}
										}
									}
								} else {
									this.bitField0_ |= 4;
									if (!((other.macroReference_ instanceof String))) {
										ba = (byte[]) other.macroReference_;
										this.macroReference_ = Arrays.copyOf(ba, ba.length);
										if (!other.hasFunctionId()) {
											this.bitField0_ |= 8;
											if (!((other.functionId_ instanceof String))) {
												this.functionId_ = other.functionId_;
											} else {
												ba = (byte[]) other.functionId_;
												this.functionId_ = Arrays.copyOf(ba, ba.length);
											}
										}
										if (!other.hasInteger()) {
											setInteger(other.getInteger());
										}
										if (!other.hasContainsReferences()) {
											setContainsReferences(other.getContainsReferences());
										}
										if (other.escaping_ == null || other.escaping_.isEmpty()) {
											if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
												if (!other.hasBoolean()) {
													setBoolean(other.getBoolean());
												}
												mergeExtensionFields(other);
												this.unknownFields = this.unknownFields.concat(other.unknownFields);
												return this;
											} else {
												ensureTemplateTokenInitialized();
												AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
												if (!other.hasBoolean()) {
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												} else {
													setBoolean(other.getBoolean());
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												}
											}
										} else {
											ensureEscapingInitialized();
											this.escaping_.addAll(other.escaping_);
											if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
												if (!other.hasBoolean()) {
													setBoolean(other.getBoolean());
												}
												mergeExtensionFields(other);
												this.unknownFields = this.unknownFields.concat(other.unknownFields);
												return this;
											} else {
												ensureTemplateTokenInitialized();
												AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
												if (!other.hasBoolean()) {
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												} else {
													setBoolean(other.getBoolean());
													mergeExtensionFields(other);
													this.unknownFields = this.unknownFields.concat(other.unknownFields);
													return this;
												}
											}
										}
									} else {
										this.macroReference_ = other.macroReference_;
										if (!other.hasFunctionId()) {
											if (!other.hasInteger()) {
												if (!other.hasContainsReferences()) {
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												} else {
													setContainsReferences(other.getContainsReferences());
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												}
											} else {
												setInteger(other.getInteger());
												if (!other.hasContainsReferences()) {
													setContainsReferences(other.getContainsReferences());
												}
												if (other.escaping_ == null || other.escaping_.isEmpty()) {
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												} else {
													ensureEscapingInitialized();
													this.escaping_.addAll(other.escaping_);
													if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
														if (!other.hasBoolean()) {
															setBoolean(other.getBoolean());
														}
														mergeExtensionFields(other);
														this.unknownFields = this.unknownFields.concat(other.unknownFields);
														return this;
													} else {
														ensureTemplateTokenInitialized();
														AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
														if (!other.hasBoolean()) {
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															setBoolean(other.getBoolean());
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														}
													}
												}
											}
										} else {
											this.bitField0_ |= 8;
											if (!((other.functionId_ instanceof String))) {
												ba = (byte[]) other.functionId_;
												this.functionId_ = Arrays.copyOf(ba, ba.length);
												if (!other.hasInteger()) {
													setInteger(other.getInteger());
												}
												if (!other.hasContainsReferences()) {
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												} else {
													setContainsReferences(other.getContainsReferences());
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												}
											} else {
												this.functionId_ = other.functionId_;
												if (!other.hasInteger()) {
													if (!other.hasContainsReferences()) {
														setContainsReferences(other.getContainsReferences());
													}
													if (other.escaping_ == null || other.escaping_.isEmpty()) {
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													} else {
														ensureEscapingInitialized();
														this.escaping_.addAll(other.escaping_);
														if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
															if (!other.hasBoolean()) {
																setBoolean(other.getBoolean());
															}
															mergeExtensionFields(other);
															this.unknownFields = this.unknownFields.concat(other.unknownFields);
															return this;
														} else {
															ensureTemplateTokenInitialized();
															AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
															if (!other.hasBoolean()) {
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																setBoolean(other.getBoolean());
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															}
														}
													}
												} else {
													setInteger(other.getInteger());
													if (!other.hasContainsReferences()) {
														if (other.escaping_ == null || other.escaping_.isEmpty()) {
															if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
																if (!other.hasBoolean()) {
																	setBoolean(other.getBoolean());
																}
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																ensureTemplateTokenInitialized();
																AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
																if (!other.hasBoolean()) {
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																} else {
																	setBoolean(other.getBoolean());
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																}
															}
														} else {
															ensureEscapingInitialized();
															this.escaping_.addAll(other.escaping_);
															if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
																if (!other.hasBoolean()) {
																	setBoolean(other.getBoolean());
																}
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																ensureTemplateTokenInitialized();
																AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
																if (!other.hasBoolean()) {
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																} else {
																	setBoolean(other.getBoolean());
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																}
															}
														}
													} else {
														setContainsReferences(other.getContainsReferences());
														if (other.escaping_ == null || other.escaping_.isEmpty()) {
															if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
																if (!other.hasBoolean()) {
																	setBoolean(other.getBoolean());
																}
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																ensureTemplateTokenInitialized();
																AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
																if (!other.hasBoolean()) {
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																} else {
																	setBoolean(other.getBoolean());
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																}
															}
														} else {
															ensureEscapingInitialized();
															this.escaping_.addAll(other.escaping_);
															if (other.templateToken_ == null || other.templateToken_.isEmpty()) {
																if (!other.hasBoolean()) {
																	setBoolean(other.getBoolean());
																}
																mergeExtensionFields(other);
																this.unknownFields = this.unknownFields.concat(other.unknownFields);
																return this;
															} else {
																ensureTemplateTokenInitialized();
																AbstractMutableMessageLite.addAll(other.templateToken_, this.templateToken_);
																if (!other.hasBoolean()) {
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																} else {
																	setBoolean(other.getBoolean());
																	mergeExtensionFields(other);
																	this.unknownFields = this.unknownFields.concat(other.unknownFields);
																	return this;
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		public boolean mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) {
			CodedOutputStream unknownFieldsCodedOutput;
			boolean done;
			boolean r9z;
			assertMutable();
			try {
				OutputStream unknownFieldsOutput = ByteString.newOutput();
				unknownFieldsCodedOutput = CodedOutputStream.newInstance(unknownFieldsOutput);
				done = false;
				while (!done) {
					int tag = input.readTag();
					int rawValue;
					Escaping value;
					switch(tag) {
					case Utf8.COMPLETE:
						done = true;
						break;
					case INTEGER_FIELD_NUMBER:
						rawValue = input.readEnum();
						Type value_2 = Type.valueOf(rawValue);
						if (value_2 == null) {
							unknownFieldsCodedOutput.writeRawVarint32(tag);
							unknownFieldsCodedOutput.writeRawVarint32(rawValue);
						} else {
							this.bitField0_ |= 1;
							this.type_ = value_2;
						}
						break;
					case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
						this.bitField0_ |= 2;
						this.string_ = input.readByteArray();
						break;
					case 26:
						input.readMessage(addListItem(), extensionRegistry);
						break;
					case 34:
						input.readMessage(addMapKey(), extensionRegistry);
						break;
					case 42:
						input.readMessage(addMapValue(), extensionRegistry);
						break;
					case 50:
						this.bitField0_ |= 4;
						this.macroReference_ = input.readByteArray();
						break;
					case 58:
						this.bitField0_ |= 8;
						this.functionId_ = input.readByteArray();
						break;
					case 64:
						this.bitField0_ |= 16;
						this.integer_ = input.readInt64();
						break;
					case 72:
						this.bitField0_ |= 64;
						this.containsReferences_ = input.readBool();
						break;
					case 80:
						rawValue = input.readEnum();
						value = Escaping.valueOf(rawValue);
						if (value == null) {
							unknownFieldsCodedOutput.writeRawVarint32(tag);
							unknownFieldsCodedOutput.writeRawVarint32(rawValue);
						} else {
							if (this.escaping_ == null) {
								this.escaping_ = new ArrayList();
							}
							this.escaping_.add(value);
						}
						break;
					case 82:
						int oldLimit = input.pushLimit(input.readRawVarint32());
						while (input.getBytesUntilLimit() > 0) {
							rawValue = input.readEnum();
							value = Escaping.valueOf(rawValue);
							if (value == null) {
								unknownFieldsCodedOutput.writeRawVarint32(tag);
								unknownFieldsCodedOutput.writeRawVarint32(rawValue);
							} else {
								if (this.escaping_ == null) {
									this.escaping_ = new ArrayList();
								}
								this.escaping_.add(value);
							}
						}
						input.popLimit(oldLimit);
						break;
					case 90:
						input.readMessage(addTemplateToken(), extensionRegistry);
						break;
					case 96:
						this.bitField0_ |= 32;
						this.boolean_ = input.readBool();
						break;
					}
					if (!parseUnknownField(input, unknownFieldsCodedOutput, extensionRegistry, tag)) {
						done = true;
					}
				}
				unknownFieldsCodedOutput.flush();
				this.unknownFields = unknownFieldsOutput.toByteString();
				r9z = true;
			} catch (IOException e) {
				r9z = false;
			}
			return r9z;
		}

		public MutableTypeSystem.Value newMessageForType() {
			return new MutableTypeSystem.Value();
		}

		public MutableTypeSystem.Value setBoolean(boolean value) {
			assertMutable();
			this.bitField0_ |= 32;
			this.boolean_ = value;
			return this;
		}

		public MutableTypeSystem.Value setContainsReferences(boolean value) {
			assertMutable();
			this.bitField0_ |= 64;
			this.containsReferences_ = value;
			return this;
		}

		public MutableTypeSystem.Value setEscaping(int index, Escaping value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureEscapingInitialized();
				this.escaping_.set(index, value);
				return this;
			}
		}

		public MutableTypeSystem.Value setFunctionId(String value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 8;
				this.functionId_ = value;
				return this;
			}
		}

		public MutableTypeSystem.Value setFunctionIdAsBytes(byte[] value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 8;
				this.functionId_ = value;
				return this;
			}
		}

		public MutableTypeSystem.Value setInteger(long value) {
			assertMutable();
			this.bitField0_ |= 16;
			this.integer_ = value;
			return this;
		}

		public MutableTypeSystem.Value setListItem(int index, MutableTypeSystem.Value value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureListItemInitialized();
				this.listItem_.set(index, value);
				return this;
			}
		}

		public MutableTypeSystem.Value setMacroReference(String value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 4;
				this.macroReference_ = value;
				return this;
			}
		}

		public MutableTypeSystem.Value setMacroReferenceAsBytes(byte[] value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 4;
				this.macroReference_ = value;
				return this;
			}
		}

		public MutableTypeSystem.Value setMapKey(int index, MutableTypeSystem.Value value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureMapKeyInitialized();
				this.mapKey_.set(index, value);
				return this;
			}
		}

		public MutableTypeSystem.Value setMapValue(int index, MutableTypeSystem.Value value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureMapValueInitialized();
				this.mapValue_.set(index, value);
				return this;
			}
		}

		public MutableTypeSystem.Value setString(String value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 2;
				this.string_ = value;
				return this;
			}
		}

		public MutableTypeSystem.Value setStringAsBytes(byte[] value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 2;
				this.string_ = value;
				return this;
			}
		}

		public MutableTypeSystem.Value setTemplateToken(int index, MutableTypeSystem.Value value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				ensureTemplateTokenInitialized();
				this.templateToken_.set(index, value);
				return this;
			}
		}

		public MutableTypeSystem.Value setType(Type value) {
			assertMutable();
			if (value == null) {
				throw new NullPointerException();
			} else {
				this.bitField0_ |= 1;
				this.type_ = value;
				return this;
			}
		}

		protected Object writeReplace() throws ObjectStreamException {
			return super.writeReplace();
		}

		public void writeToWithCachedSizes(CodedOutputStream output) throws IOException {
			int i;
			int bytesWrittenBefore = output.getTotalBytesWritten();
			ExtendableMutableMessage<MutableTypeSystem.Value> extensionWriter = newExtensionWriter();
			output.writeEnum(TYPE_FIELD_NUMBER, this.type_.getNumber());
			if ((this.bitField0_ & 2) == 2) {
				output.writeByteArray(STRING_FIELD_NUMBER, getStringAsBytes());
			}
			if (this.listItem_ != null) {
				i = 0;
				while (i < this.listItem_.size()) {
					output.writeMessageWithCachedSizes(LIST_ITEM_FIELD_NUMBER, (MutableMessageLite) this.listItem_.get(i));
					i++;
				}
			}
			if (this.mapKey_ != null) {
				i = 0;
				while (i < this.mapKey_.size()) {
					output.writeMessageWithCachedSizes(MAP_KEY_FIELD_NUMBER, (MutableMessageLite) this.mapKey_.get(i));
					i++;
				}
			}
			if (this.mapValue_ != null) {
				i = 0;
				while (i < this.mapValue_.size()) {
					output.writeMessageWithCachedSizes(MAP_VALUE_FIELD_NUMBER, (MutableMessageLite) this.mapValue_.get(i));
					i++;
				}
			}
			if ((this.bitField0_ & 4) == 4) {
				output.writeByteArray(MACRO_REFERENCE_FIELD_NUMBER, getMacroReferenceAsBytes());
			}
			if ((this.bitField0_ & 8) == 8) {
				output.writeByteArray(FUNCTION_ID_FIELD_NUMBER, getFunctionIdAsBytes());
			}
			if ((this.bitField0_ & 16) == 16) {
				output.writeInt64(INTEGER_FIELD_NUMBER, this.integer_);
			}
			if ((this.bitField0_ & 64) == 64) {
				output.writeBool(CONTAINS_REFERENCES_FIELD_NUMBER, this.containsReferences_);
			}
			if (this.escaping_ != null) {
				i = 0;
				while (i < this.escaping_.size()) {
					output.writeEnum(ESCAPING_FIELD_NUMBER, ((Escaping) this.escaping_.get(i)).getNumber());
					i++;
				}
			}
			if (this.templateToken_ != null) {
				i = 0;
				while (i < this.templateToken_.size()) {
					output.writeMessageWithCachedSizes(TEMPLATE_TOKEN_FIELD_NUMBER, (MutableMessageLite) this.templateToken_.get(i));
					i++;
				}
			}
			if ((this.bitField0_ & 32) == 32) {
				output.writeBool(BOOLEAN_FIELD_NUMBER, this.boolean_);
			}
			extensionWriter.writeUntil(536870912, output);
			output.writeRawBytes(this.unknownFields);
			if (getCachedSize() != output.getTotalBytesWritten() - bytesWrittenBefore) {
				throw new RuntimeException("Serialized size doesn't match cached size. You may forget to call getSerializedSize() or the message is being modified concurrently.");
			}
		}
	}


	static {
	}

	private MutableTypeSystem() {
	}

	public static void registerAllExtensions(ExtensionRegistryLite registry) {
	}
}
