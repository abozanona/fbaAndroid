package com.google.analytics.midtier.proto.containertag;

import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Escaping;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;
import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.ByteString;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.CodedOutputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableBuilder;
import com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableMessage;
import com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder;
import com.google.tagmanager.protobuf.Internal;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;
import com.google.tagmanager.protobuf.InvalidProtocolBufferException;
import com.google.tagmanager.protobuf.MessageLite;
import com.google.tagmanager.protobuf.MutableMessageLite;
import com.google.tagmanager.protobuf.Parser;
import com.google.tagmanager.protobuf.Utf8;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TypeSystem {
	public static interface ValueOrBuilder extends ExtendableMessageOrBuilder<TypeSystem.Value> {
		public boolean getBoolean();

		public boolean getContainsReferences();

		public Escaping getEscaping(int r1i);

		public int getEscapingCount();

		public List<Escaping> getEscapingList();

		public String getFunctionId();

		public ByteString getFunctionIdBytes();

		public long getInteger();

		public TypeSystem.Value getListItem(int r1i);

		public int getListItemCount();

		public List<TypeSystem.Value> getListItemList();

		public String getMacroReference();

		public ByteString getMacroReferenceBytes();

		public TypeSystem.Value getMapKey(int r1i);

		public int getMapKeyCount();

		public List<TypeSystem.Value> getMapKeyList();

		public TypeSystem.Value getMapValue(int r1i);

		public int getMapValueCount();

		public List<TypeSystem.Value> getMapValueList();

		public String getString();

		public ByteString getStringBytes();

		public TypeSystem.Value getTemplateToken(int r1i);

		public int getTemplateTokenCount();

		public List<TypeSystem.Value> getTemplateTokenList();

		public Type getType();

		public boolean hasBoolean();

		public boolean hasContainsReferences();

		public boolean hasFunctionId();

		public boolean hasInteger();

		public boolean hasMacroReference();

		public boolean hasString();

		public boolean hasType();
	}

	public static final class Value extends ExtendableMessage<TypeSystem.Value> implements TypeSystem.ValueOrBuilder {
		public static final int BOOLEAN_FIELD_NUMBER = 12;
		public static final int CONTAINS_REFERENCES_FIELD_NUMBER = 9;
		public static final int ESCAPING_FIELD_NUMBER = 10;
		public static final int FUNCTION_ID_FIELD_NUMBER = 7;
		public static final int INTEGER_FIELD_NUMBER = 8;
		public static final int LIST_ITEM_FIELD_NUMBER = 3;
		public static final int MACRO_REFERENCE_FIELD_NUMBER = 6;
		public static final int MAP_KEY_FIELD_NUMBER = 4;
		public static final int MAP_VALUE_FIELD_NUMBER = 5;
		public static Parser<TypeSystem.Value> PARSER = null;
		public static final int STRING_FIELD_NUMBER = 2;
		public static final int TEMPLATE_TOKEN_FIELD_NUMBER = 11;
		public static final int TYPE_FIELD_NUMBER = 1;
		private static final TypeSystem.Value defaultInstance;
		private static volatile MutableMessageLite mutableDefault;
		private static final long serialVersionUID = 0;
		private int bitField0_;
		private boolean boolean_;
		private boolean containsReferences_;
		private List<Escaping> escaping_;
		private Object functionId_;
		private long integer_;
		private List<TypeSystem.Value> listItem_;
		private Object macroReference_;
		private List<TypeSystem.Value> mapKey_;
		private List<TypeSystem.Value> mapValue_;
		private byte memoizedIsInitialized;
		private int memoizedSerializedSize;
		private Object string_;
		private List<TypeSystem.Value> templateToken_;
		private Type type_;
		private final ByteString unknownFields;

		public static final class Builder extends ExtendableBuilder<TypeSystem.Value, TypeSystem.Value.Builder> implements TypeSystem.ValueOrBuilder {
			private int bitField0_;
			private boolean boolean_;
			private boolean containsReferences_;
			private List<TypeSystem.Value.Escaping> escaping_;
			private Object functionId_;
			private long integer_;
			private List<TypeSystem.Value> listItem_;
			private Object macroReference_;
			private List<TypeSystem.Value> mapKey_;
			private List<TypeSystem.Value> mapValue_;
			private Object string_;
			private List<TypeSystem.Value> templateToken_;
			private TypeSystem.Value.Type type_;

			private Builder() {
				this.type_ = TypeSystem.Value.Type.STRING;
				this.string_ = "";
				this.listItem_ = Collections.emptyList();
				this.mapKey_ = Collections.emptyList();
				this.mapValue_ = Collections.emptyList();
				this.macroReference_ = "";
				this.functionId_ = "";
				this.templateToken_ = Collections.emptyList();
				this.escaping_ = Collections.emptyList();
				maybeForceBuilderInitialization();
			}

			private static TypeSystem.Value.Builder create() {
				return new TypeSystem.Value.Builder();
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

			public TypeSystem.Value.Builder addAllEscaping(Iterable<TypeSystem.Value.Escaping> values) {
				ensureEscapingIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.escaping_);
				return this;
			}

			public TypeSystem.Value.Builder addAllListItem(Iterable<TypeSystem.Value> values) {
				ensureListItemIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.listItem_);
				return this;
			}

			public TypeSystem.Value.Builder addAllMapKey(Iterable<TypeSystem.Value> values) {
				ensureMapKeyIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.mapKey_);
				return this;
			}

			public TypeSystem.Value.Builder addAllMapValue(Iterable<TypeSystem.Value> values) {
				ensureMapValueIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.mapValue_);
				return this;
			}

			public TypeSystem.Value.Builder addAllTemplateToken(Iterable<TypeSystem.Value> values) {
				ensureTemplateTokenIsMutable();
				com.google.tagmanager.protobuf.AbstractMessageLite.Builder.addAll(values, this.templateToken_);
				return this;
			}

			public TypeSystem.Value.Builder addEscaping(TypeSystem.Value.Escaping value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureEscapingIsMutable();
					this.escaping_.add(value);
					return this;
				}
			}

			public TypeSystem.Value.Builder addListItem(int index, TypeSystem.Value.Builder builderForValue) {
				ensureListItemIsMutable();
				this.listItem_.add(index, builderForValue.build());
				return this;
			}

			public TypeSystem.Value.Builder addListItem(int index, TypeSystem.Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureListItemIsMutable();
					this.listItem_.add(index, value);
					return this;
				}
			}

			public TypeSystem.Value.Builder addListItem(TypeSystem.Value.Builder builderForValue) {
				ensureListItemIsMutable();
				this.listItem_.add(builderForValue.build());
				return this;
			}

			public TypeSystem.Value.Builder addListItem(TypeSystem.Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureListItemIsMutable();
					this.listItem_.add(value);
					return this;
				}
			}

			public TypeSystem.Value.Builder addMapKey(int index, TypeSystem.Value.Builder builderForValue) {
				ensureMapKeyIsMutable();
				this.mapKey_.add(index, builderForValue.build());
				return this;
			}

			public TypeSystem.Value.Builder addMapKey(int index, TypeSystem.Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureMapKeyIsMutable();
					this.mapKey_.add(index, value);
					return this;
				}
			}

			public TypeSystem.Value.Builder addMapKey(TypeSystem.Value.Builder builderForValue) {
				ensureMapKeyIsMutable();
				this.mapKey_.add(builderForValue.build());
				return this;
			}

			public TypeSystem.Value.Builder addMapKey(TypeSystem.Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureMapKeyIsMutable();
					this.mapKey_.add(value);
					return this;
				}
			}

			public TypeSystem.Value.Builder addMapValue(int index, TypeSystem.Value.Builder builderForValue) {
				ensureMapValueIsMutable();
				this.mapValue_.add(index, builderForValue.build());
				return this;
			}

			public TypeSystem.Value.Builder addMapValue(int index, TypeSystem.Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureMapValueIsMutable();
					this.mapValue_.add(index, value);
					return this;
				}
			}

			public TypeSystem.Value.Builder addMapValue(TypeSystem.Value.Builder builderForValue) {
				ensureMapValueIsMutable();
				this.mapValue_.add(builderForValue.build());
				return this;
			}

			public TypeSystem.Value.Builder addMapValue(TypeSystem.Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureMapValueIsMutable();
					this.mapValue_.add(value);
					return this;
				}
			}

			public TypeSystem.Value.Builder addTemplateToken(int index, TypeSystem.Value.Builder builderForValue) {
				ensureTemplateTokenIsMutable();
				this.templateToken_.add(index, builderForValue.build());
				return this;
			}

			public TypeSystem.Value.Builder addTemplateToken(int index, TypeSystem.Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureTemplateTokenIsMutable();
					this.templateToken_.add(index, value);
					return this;
				}
			}

			public TypeSystem.Value.Builder addTemplateToken(TypeSystem.Value.Builder builderForValue) {
				ensureTemplateTokenIsMutable();
				this.templateToken_.add(builderForValue.build());
				return this;
			}

			public TypeSystem.Value.Builder addTemplateToken(TypeSystem.Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureTemplateTokenIsMutable();
					this.templateToken_.add(value);
					return this;
				}
			}

			public TypeSystem.Value build() {
				TypeSystem.Value result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public TypeSystem.Value buildPartial() {
				TypeSystem.Value result = new TypeSystem.Value((ExtendableBuilder)null);
				int from_bitField0_ = this.bitField0_;
				int to_bitField0_ = 0;
				if ((from_bitField0_ & 1) == 1) {
					to_bitField0_ |= 1;
				}
				result.type_ = this.type_;
				if ((from_bitField0_ & 2) == 2) {
					to_bitField0_ |= 2;
				}
				result.string_ = this.string_;
				if ((this.bitField0_ & 4) == 4) {
					this.listItem_ = Collections.unmodifiableList(this.listItem_);
					this.bitField0_ &= -5;
				}
				result.listItem_ = this.listItem_;
				if ((this.bitField0_ & 8) == 8) {
					this.mapKey_ = Collections.unmodifiableList(this.mapKey_);
					this.bitField0_ &= -9;
				}
				result.mapKey_ = this.mapKey_;
				if ((this.bitField0_ & 16) == 16) {
					this.mapValue_ = Collections.unmodifiableList(this.mapValue_);
					this.bitField0_ &= -17;
				}
				result.mapValue_ = this.mapValue_;
				if ((from_bitField0_ & 32) == 32) {
					to_bitField0_ |= 4;
				}
				result.macroReference_ = this.macroReference_;
				if ((from_bitField0_ & 64) == 64) {
					to_bitField0_ |= 8;
				}
				result.functionId_ = this.functionId_;
				if ((from_bitField0_ & 128) == 128) {
					to_bitField0_ |= 16;
				}
				result.integer_ = this.integer_;
				if ((from_bitField0_ & 256) == 256) {
					to_bitField0_ |= 32;
				}
				result.boolean_ = this.boolean_;
				if ((this.bitField0_ & 512) == 512) {
					this.templateToken_ = Collections.unmodifiableList(this.templateToken_);
					this.bitField0_ &= -513;
				}
				result.templateToken_ = this.templateToken_;
				if ((this.bitField0_ & 1024) == 1024) {
					this.escaping_ = Collections.unmodifiableList(this.escaping_);
					this.bitField0_ &= -1025;
				}
				result.escaping_ = this.escaping_;
				if ((from_bitField0_ & 2048) == 2048) {
					to_bitField0_ |= 64;
				}
				result.containsReferences_ = this.containsReferences_;
				result.bitField0_ = to_bitField0_;
				return result;
			}

			public TypeSystem.Value.Builder clear() {
				super.clear();
				this.type_ = TypeSystem.Value.Type.STRING;
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

			public TypeSystem.Value.Builder clearBoolean() {
				this.bitField0_ &= -257;
				this.boolean_ = false;
				return this;
			}

			public TypeSystem.Value.Builder clearContainsReferences() {
				this.bitField0_ &= -2049;
				this.containsReferences_ = false;
				return this;
			}

			public TypeSystem.Value.Builder clearEscaping() {
				this.escaping_ = Collections.emptyList();
				this.bitField0_ &= -1025;
				return this;
			}

			public TypeSystem.Value.Builder clearFunctionId() {
				this.bitField0_ &= -65;
				this.functionId_ = TypeSystem.Value.getDefaultInstance().getFunctionId();
				return this;
			}

			public TypeSystem.Value.Builder clearInteger() {
				this.bitField0_ &= -129;
				this.integer_ = 0;
				return this;
			}

			public TypeSystem.Value.Builder clearListItem() {
				this.listItem_ = Collections.emptyList();
				this.bitField0_ &= -5;
				return this;
			}

			public TypeSystem.Value.Builder clearMacroReference() {
				this.bitField0_ &= -33;
				this.macroReference_ = TypeSystem.Value.getDefaultInstance().getMacroReference();
				return this;
			}

			public TypeSystem.Value.Builder clearMapKey() {
				this.mapKey_ = Collections.emptyList();
				this.bitField0_ &= -9;
				return this;
			}

			public TypeSystem.Value.Builder clearMapValue() {
				this.mapValue_ = Collections.emptyList();
				this.bitField0_ &= -17;
				return this;
			}

			public TypeSystem.Value.Builder clearString() {
				this.bitField0_ &= -3;
				this.string_ = TypeSystem.Value.getDefaultInstance().getString();
				return this;
			}

			public TypeSystem.Value.Builder clearTemplateToken() {
				this.templateToken_ = Collections.emptyList();
				this.bitField0_ &= -513;
				return this;
			}

			public TypeSystem.Value.Builder clearType() {
				this.bitField0_ &= -2;
				this.type_ = TypeSystem.Value.Type.STRING;
				return this;
			}

			public TypeSystem.Value.Builder clone() {
				return create().mergeFrom(buildPartial());
			}

			public boolean getBoolean() {
				return this.boolean_;
			}

			public boolean getContainsReferences() {
				return this.containsReferences_;
			}

			public TypeSystem.Value getDefaultInstanceForType() {
				return TypeSystem.Value.getDefaultInstance();
			}

			public TypeSystem.Value.Escaping getEscaping(int index) {
				return (TypeSystem.Value.Escaping) this.escaping_.get(index);
			}

			public int getEscapingCount() {
				return this.escaping_.size();
			}

			public List<TypeSystem.Value.Escaping> getEscapingList() {
				return Collections.unmodifiableList(this.escaping_);
			}

			public String getFunctionId() {
				Object ref = this.functionId_;
				if (!((ref instanceof String))) {
					ByteString bs = (ByteString) ref;
					String s = bs.toStringUtf8();
					if (bs.isValidUtf8()) {
						this.functionId_ = s;
						return s;
					}
					return s;
				} else {
					return (String) ref;
				}
			}

			public ByteString getFunctionIdBytes() {
				Object ref = this.functionId_;
				if (ref instanceof String) {
					ByteString b = ByteString.copyFromUtf8((String) ref);
					this.functionId_ = b;
					return b;
				} else {
					return (ByteString) ref;
				}
			}

			public long getInteger() {
				return this.integer_;
			}

			public TypeSystem.Value getListItem(int index) {
				return (TypeSystem.Value) this.listItem_.get(index);
			}

			public int getListItemCount() {
				return this.listItem_.size();
			}

			public List<TypeSystem.Value> getListItemList() {
				return Collections.unmodifiableList(this.listItem_);
			}

			public String getMacroReference() {
				Object ref = this.macroReference_;
				if (!((ref instanceof String))) {
					ByteString bs = (ByteString) ref;
					String s = bs.toStringUtf8();
					if (bs.isValidUtf8()) {
						this.macroReference_ = s;
						return s;
					}
					return s;
				} else {
					return (String) ref;
				}
			}

			public ByteString getMacroReferenceBytes() {
				Object ref = this.macroReference_;
				if (ref instanceof String) {
					ByteString b = ByteString.copyFromUtf8((String) ref);
					this.macroReference_ = b;
					return b;
				} else {
					return (ByteString) ref;
				}
			}

			public TypeSystem.Value getMapKey(int index) {
				return (TypeSystem.Value) this.mapKey_.get(index);
			}

			public int getMapKeyCount() {
				return this.mapKey_.size();
			}

			public List<TypeSystem.Value> getMapKeyList() {
				return Collections.unmodifiableList(this.mapKey_);
			}

			public TypeSystem.Value getMapValue(int index) {
				return (TypeSystem.Value) this.mapValue_.get(index);
			}

			public int getMapValueCount() {
				return this.mapValue_.size();
			}

			public List<TypeSystem.Value> getMapValueList() {
				return Collections.unmodifiableList(this.mapValue_);
			}

			public String getString() {
				Object ref = this.string_;
				if (!((ref instanceof String))) {
					ByteString bs = (ByteString) ref;
					String s = bs.toStringUtf8();
					if (bs.isValidUtf8()) {
						this.string_ = s;
						return s;
					}
					return s;
				} else {
					return (String) ref;
				}
			}

			public ByteString getStringBytes() {
				Object ref = this.string_;
				if (ref instanceof String) {
					ByteString b = ByteString.copyFromUtf8((String) ref);
					this.string_ = b;
					return b;
				} else {
					return (ByteString) ref;
				}
			}

			public TypeSystem.Value getTemplateToken(int index) {
				return (TypeSystem.Value) this.templateToken_.get(index);
			}

			public int getTemplateTokenCount() {
				return this.templateToken_.size();
			}

			public List<TypeSystem.Value> getTemplateTokenList() {
				return Collections.unmodifiableList(this.templateToken_);
			}

			public TypeSystem.Value.Type getType() {
				return this.type_;
			}

			public boolean hasBoolean() {
				return (this.bitField0_ & 256) == 256;
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

			public TypeSystem.Value.Builder mergeFrom(TypeSystem.Value other) {
				if (other == TypeSystem.Value.getDefaultInstance()) {
					return this;
				} else {
					if (other.hasType()) {
						setType(other.getType());
					}
					if (other.hasString()) {
						this.bitField0_ |= 2;
						this.string_ = other.string_;
					}
					if (!other.listItem_.isEmpty()) {
						if (this.listItem_.isEmpty()) {
							this.listItem_ = other.listItem_;
							this.bitField0_ &= -5;
						} else {
							ensureListItemIsMutable();
							this.listItem_.addAll(other.listItem_);
						}
					}
					if (!other.mapKey_.isEmpty()) {
						if (this.mapKey_.isEmpty()) {
							this.mapKey_ = other.mapKey_;
							this.bitField0_ &= -9;
						} else {
							ensureMapKeyIsMutable();
							this.mapKey_.addAll(other.mapKey_);
						}
					}
					if (!other.mapValue_.isEmpty()) {
						if (this.mapValue_.isEmpty()) {
							this.mapValue_ = other.mapValue_;
							this.bitField0_ &= -17;
						} else {
							ensureMapValueIsMutable();
							this.mapValue_.addAll(other.mapValue_);
						}
					}
					if (other.hasMacroReference()) {
						this.bitField0_ |= 32;
						this.macroReference_ = other.macroReference_;
					}
					if (other.hasFunctionId()) {
						this.bitField0_ |= 64;
						this.functionId_ = other.functionId_;
					}
					if (other.hasInteger()) {
						setInteger(other.getInteger());
					}
					if (other.hasBoolean()) {
						setBoolean(other.getBoolean());
					}
					if (!other.templateToken_.isEmpty()) {
						if (this.templateToken_.isEmpty()) {
							this.templateToken_ = other.templateToken_;
							this.bitField0_ &= -513;
						} else {
							ensureTemplateTokenIsMutable();
							this.templateToken_.addAll(other.templateToken_);
						}
					}
					if (!other.escaping_.isEmpty()) {
						if (this.escaping_.isEmpty()) {
							this.escaping_ = other.escaping_;
							this.bitField0_ &= -1025;
						} else {
							ensureEscapingIsMutable();
							this.escaping_.addAll(other.escaping_);
						}
					}
					if (other.hasContainsReferences()) {
						setContainsReferences(other.getContainsReferences());
					}
					mergeExtensionFields(other);
					setUnknownFields(getUnknownFields().concat(other.unknownFields));
					return this;
				}
			}

			public TypeSystem.Value.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
				TypeSystem.Value parsedMessage;
				try {
					parsedMessage = (TypeSystem.Value) PARSER.parsePartialFrom(input, extensionRegistry);
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
					return this;
				} catch (InvalidProtocolBufferException e) {
					InvalidProtocolBufferException e_2 = e;
					parsedMessage = (TypeSystem.Value) e_2.getUnfinishedMessage();
					throw e_2;
				} catch (Throwable th) {
					if (false) {
						mergeFrom(null);
					}
				}
			}

			public TypeSystem.Value.Builder removeListItem(int index) {
				ensureListItemIsMutable();
				this.listItem_.remove(index);
				return this;
			}

			public TypeSystem.Value.Builder removeMapKey(int index) {
				ensureMapKeyIsMutable();
				this.mapKey_.remove(index);
				return this;
			}

			public TypeSystem.Value.Builder removeMapValue(int index) {
				ensureMapValueIsMutable();
				this.mapValue_.remove(index);
				return this;
			}

			public TypeSystem.Value.Builder removeTemplateToken(int index) {
				ensureTemplateTokenIsMutable();
				this.templateToken_.remove(index);
				return this;
			}

			public TypeSystem.Value.Builder setBoolean(boolean value) {
				this.bitField0_ |= 256;
				this.boolean_ = value;
				return this;
			}

			public TypeSystem.Value.Builder setContainsReferences(boolean value) {
				this.bitField0_ |= 2048;
				this.containsReferences_ = value;
				return this;
			}

			public TypeSystem.Value.Builder setEscaping(int index, TypeSystem.Value.Escaping value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureEscapingIsMutable();
					this.escaping_.set(index, value);
					return this;
				}
			}

			public TypeSystem.Value.Builder setFunctionId(String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 64;
					this.functionId_ = value;
					return this;
				}
			}

			public TypeSystem.Value.Builder setFunctionIdBytes(ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 64;
					this.functionId_ = value;
					return this;
				}
			}

			public TypeSystem.Value.Builder setInteger(long value) {
				this.bitField0_ |= 128;
				this.integer_ = value;
				return this;
			}

			public TypeSystem.Value.Builder setListItem(int index, TypeSystem.Value.Builder builderForValue) {
				ensureListItemIsMutable();
				this.listItem_.set(index, builderForValue.build());
				return this;
			}

			public TypeSystem.Value.Builder setListItem(int index, TypeSystem.Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureListItemIsMutable();
					this.listItem_.set(index, value);
					return this;
				}
			}

			public TypeSystem.Value.Builder setMacroReference(String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 32;
					this.macroReference_ = value;
					return this;
				}
			}

			public TypeSystem.Value.Builder setMacroReferenceBytes(ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 32;
					this.macroReference_ = value;
					return this;
				}
			}

			public TypeSystem.Value.Builder setMapKey(int index, TypeSystem.Value.Builder builderForValue) {
				ensureMapKeyIsMutable();
				this.mapKey_.set(index, builderForValue.build());
				return this;
			}

			public TypeSystem.Value.Builder setMapKey(int index, TypeSystem.Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureMapKeyIsMutable();
					this.mapKey_.set(index, value);
					return this;
				}
			}

			public TypeSystem.Value.Builder setMapValue(int index, TypeSystem.Value.Builder builderForValue) {
				ensureMapValueIsMutable();
				this.mapValue_.set(index, builderForValue.build());
				return this;
			}

			public TypeSystem.Value.Builder setMapValue(int index, TypeSystem.Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureMapValueIsMutable();
					this.mapValue_.set(index, value);
					return this;
				}
			}

			public TypeSystem.Value.Builder setString(String value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 2;
					this.string_ = value;
					return this;
				}
			}

			public TypeSystem.Value.Builder setStringBytes(ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 2;
					this.string_ = value;
					return this;
				}
			}

			public TypeSystem.Value.Builder setTemplateToken(int index, TypeSystem.Value.Builder builderForValue) {
				ensureTemplateTokenIsMutable();
				this.templateToken_.set(index, builderForValue.build());
				return this;
			}

			public TypeSystem.Value.Builder setTemplateToken(int index, TypeSystem.Value value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					ensureTemplateTokenIsMutable();
					this.templateToken_.set(index, value);
					return this;
				}
			}

			public TypeSystem.Value.Builder setType(TypeSystem.Value.Type value) {
				if (value == null) {
					throw new NullPointerException();
				} else {
					this.bitField0_ |= 1;
					this.type_ = value;
					return this;
				}
			}
		}

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
			private static EnumLiteMap<TypeSystem.Value.Escaping> internalValueMap;
			private final int value;


			static {
				internalValueMap = new EnumLiteMap<TypeSystem.Value.Escaping>() {
			public TypeSystem.Value.Escaping findValueByNumber(int number) {
				return TypeSystem.Value.Escaping.valueOf(number);
			}
		};
			}

			private Escaping(int index, int value) {
				this.value = value;
			}

			public static EnumLiteMap<TypeSystem.Value.Escaping> internalGetValueMap() {
				return internalValueMap;
			}

			public static TypeSystem.Value.Escaping valueOf(int value) {
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
			private static EnumLiteMap<TypeSystem.Value.Type> internalValueMap;
			private final int value;


			static {
				internalValueMap = new EnumLiteMap<TypeSystem.Value.Type>() {
			public TypeSystem.Value.Type findValueByNumber(int number) {
				return TypeSystem.Value.Type.valueOf(number);
			}
		};
			}

			private Type(int index, int value) {
				this.value = value;
			}

			public static EnumLiteMap<TypeSystem.Value.Type> internalGetValueMap() {
				return internalValueMap;
			}

			public static TypeSystem.Value.Type valueOf(int value) {
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
			PARSER = new AbstractParser<TypeSystem.Value>() {
			public TypeSystem.Value parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
				return new TypeSystem.Value(extensionRegistry, null);
			}
		};
			mutableDefault = null;
			defaultInstance = new TypeSystem.Value(true);
			defaultInstance.initFields();
		}

		private Value(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
					int rawValue;
					ByteString bs;
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
						bs = input.readBytes();
						this.bitField0_ |= 2;
						this.string_ = bs;
						break;
					case 26:
						if ((mutable_bitField0_ & 4) != 4) {
							this.listItem_ = new ArrayList();
							mutable_bitField0_ |= 4;
						}
						this.listItem_.add(input.readMessage(PARSER, extensionRegistry));
						break;
					case 34:
						if ((mutable_bitField0_ & 8) != 8) {
							this.mapKey_ = new ArrayList();
							mutable_bitField0_ |= 8;
						}
						this.mapKey_.add(input.readMessage(PARSER, extensionRegistry));
						break;
					case 42:
						if ((mutable_bitField0_ & 16) != 16) {
							this.mapValue_ = new ArrayList();
							mutable_bitField0_ |= 16;
						}
						this.mapValue_.add(input.readMessage(PARSER, extensionRegistry));
						break;
					case 50:
						bs = input.readBytes();
						this.bitField0_ |= 4;
						this.macroReference_ = bs;
						break;
					case 58:
						bs = input.readBytes();
						this.bitField0_ |= 8;
						this.functionId_ = bs;
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
							if ((mutable_bitField0_ & 1024) != 1024) {
								this.escaping_ = new ArrayList();
								mutable_bitField0_ |= 1024;
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
								if ((mutable_bitField0_ & 1024) != 1024) {
									this.escaping_ = new ArrayList();
									mutable_bitField0_ |= 1024;
								}
								this.escaping_.add(value);
							}
						}
						input.popLimit(oldLimit);
						break;
					case 90:
						if ((mutable_bitField0_ & 512) != 512) {
							this.templateToken_ = new ArrayList();
							mutable_bitField0_ |= 512;
						}
						this.templateToken_.add(input.readMessage(PARSER, extensionRegistry));
						break;
					case 96:
						this.bitField0_ |= 32;
						this.boolean_ = input.readBool();
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
					if ((mutable_bitField0_ & 4) == 4) {
						this.listItem_ = Collections.unmodifiableList(this.listItem_);
					}
					if ((mutable_bitField0_ & 8) == 8) {
						this.mapKey_ = Collections.unmodifiableList(this.mapKey_);
					}
					if ((mutable_bitField0_ & 16) == 16) {
						this.mapValue_ = Collections.unmodifiableList(this.mapValue_);
					}
					if ((mutable_bitField0_ & 1024) == 1024) {
						this.escaping_ = Collections.unmodifiableList(this.escaping_);
					}
					if ((mutable_bitField0_ & 512) == 512) {
						this.templateToken_ = Collections.unmodifiableList(this.templateToken_);
					}
					unknownFieldsCodedOutput.flush();
					this.unknownFields = unknownFieldsOutput.toByteString();
				}
			}
			if ((mutable_bitField0_ & 4) == 4) {
				this.listItem_ = Collections.unmodifiableList(this.listItem_);
			}
			if ((mutable_bitField0_ & 8) == 8) {
				this.mapKey_ = Collections.unmodifiableList(this.mapKey_);
			}
			if ((mutable_bitField0_ & 16) == 16) {
				this.mapValue_ = Collections.unmodifiableList(this.mapValue_);
			}
			if ((mutable_bitField0_ & 1024) == 1024) {
				this.escaping_ = Collections.unmodifiableList(this.escaping_);
			}
			if ((mutable_bitField0_ & 512) == 512) {
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

		private Value(ExtendableBuilder<TypeSystem.Value> builder) {
			super(builder);
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = builder.getUnknownFields();
		}

		private Value(boolean noInit) {
			this.memoizedIsInitialized = (byte) -1;
			this.memoizedSerializedSize = -1;
			this.unknownFields = ByteString.EMPTY;
		}

		public static TypeSystem.Value getDefaultInstance() {
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

		public static Builder newBuilder(TypeSystem.Value prototype) {
			return newBuilder().mergeFrom(prototype);
		}

		public static TypeSystem.Value parseDelimitedFrom(InputStream input) throws IOException {
			return (TypeSystem.Value) PARSER.parseDelimitedFrom(input);
		}

		public static TypeSystem.Value parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (TypeSystem.Value) PARSER.parseDelimitedFrom(input, extensionRegistry);
		}

		public static TypeSystem.Value parseFrom(ByteString data) throws InvalidProtocolBufferException {
			return (TypeSystem.Value) PARSER.parseFrom(data);
		}

		public static TypeSystem.Value parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (TypeSystem.Value) PARSER.parseFrom(data, extensionRegistry);
		}

		public static TypeSystem.Value parseFrom(CodedInputStream input) throws IOException {
			return (TypeSystem.Value) PARSER.parseFrom(input);
		}

		public static TypeSystem.Value parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (TypeSystem.Value) PARSER.parseFrom(input, extensionRegistry);
		}

		public static TypeSystem.Value parseFrom(InputStream input) throws IOException {
			return (TypeSystem.Value) PARSER.parseFrom(input);
		}

		public static TypeSystem.Value parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			return (TypeSystem.Value) PARSER.parseFrom(input, extensionRegistry);
		}

		public static TypeSystem.Value parseFrom(byte[] data) throws InvalidProtocolBufferException {
			return (TypeSystem.Value) PARSER.parseFrom(data);
		}

		public static TypeSystem.Value parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return (TypeSystem.Value) PARSER.parseFrom(data, extensionRegistry);
		}

		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			} else if (!((obj instanceof TypeSystem.Value))) {
				return super.equals(obj);
			} else {
				boolean result;
				TypeSystem.Value other = (TypeSystem.Value) obj;
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

		public TypeSystem.Value getDefaultInstanceForType() {
			return defaultInstance;
		}

		public Escaping getEscaping(int index) {
			return (Escaping) this.escaping_.get(index);
		}

		public int getEscapingCount() {
			return this.escaping_.size();
		}

		public List<Escaping> getEscapingList() {
			return this.escaping_;
		}

		public String getFunctionId() {
			Object ref = this.functionId_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				ByteString bs = (ByteString) ref;
				String s = bs.toStringUtf8();
				if (bs.isValidUtf8()) {
					this.functionId_ = s;
				}
				return s;
			}
		}

		public ByteString getFunctionIdBytes() {
			Object ref = this.functionId_;
			if (ref instanceof String) {
				ByteString b = ByteString.copyFromUtf8((String) ref);
				this.functionId_ = b;
				return b;
			} else {
				return (ByteString) ref;
			}
		}

		public long getInteger() {
			return this.integer_;
		}

		public TypeSystem.Value getListItem(int index) {
			return (TypeSystem.Value) this.listItem_.get(index);
		}

		public int getListItemCount() {
			return this.listItem_.size();
		}

		public List<TypeSystem.Value> getListItemList() {
			return this.listItem_;
		}

		public TypeSystem.ValueOrBuilder getListItemOrBuilder(int index) {
			return (TypeSystem.ValueOrBuilder) this.listItem_.get(index);
		}

		public List<TypeSystem.ValueOrBuilder> getListItemOrBuilderList() {
			return this.listItem_;
		}

		public String getMacroReference() {
			Object ref = this.macroReference_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				ByteString bs = (ByteString) ref;
				String s = bs.toStringUtf8();
				if (bs.isValidUtf8()) {
					this.macroReference_ = s;
				}
				return s;
			}
		}

		public ByteString getMacroReferenceBytes() {
			Object ref = this.macroReference_;
			if (ref instanceof String) {
				ByteString b = ByteString.copyFromUtf8((String) ref);
				this.macroReference_ = b;
				return b;
			} else {
				return (ByteString) ref;
			}
		}

		public TypeSystem.Value getMapKey(int index) {
			return (TypeSystem.Value) this.mapKey_.get(index);
		}

		public int getMapKeyCount() {
			return this.mapKey_.size();
		}

		public List<TypeSystem.Value> getMapKeyList() {
			return this.mapKey_;
		}

		public TypeSystem.ValueOrBuilder getMapKeyOrBuilder(int index) {
			return (TypeSystem.ValueOrBuilder) this.mapKey_.get(index);
		}

		public List<TypeSystem.ValueOrBuilder> getMapKeyOrBuilderList() {
			return this.mapKey_;
		}

		public TypeSystem.Value getMapValue(int index) {
			return (TypeSystem.Value) this.mapValue_.get(index);
		}

		public int getMapValueCount() {
			return this.mapValue_.size();
		}

		public List<TypeSystem.Value> getMapValueList() {
			return this.mapValue_;
		}

		public TypeSystem.ValueOrBuilder getMapValueOrBuilder(int index) {
			return (TypeSystem.ValueOrBuilder) this.mapValue_.get(index);
		}

		public List<TypeSystem.ValueOrBuilder> getMapValueOrBuilderList() {
			return this.mapValue_;
		}

		public Parser<TypeSystem.Value> getParserForType() {
			return PARSER;
		}

		public int getSerializedSize() {
			int size = this.memoizedSerializedSize;
			if (size != -1) {
				return size;
			} else {
				size = 0;
				if ((this.bitField0_ & 1) == 1) {
					size += CodedOutputStream.computeEnumSize(TYPE_FIELD_NUMBER, this.type_.getNumber());
				}
				if ((this.bitField0_ & 2) == 2) {
					size += CodedOutputStream.computeBytesSize(STRING_FIELD_NUMBER, getStringBytes());
				}
				int i = 0;
				while (i < this.listItem_.size()) {
					size += CodedOutputStream.computeMessageSize(LIST_ITEM_FIELD_NUMBER, (MessageLite) this.listItem_.get(i));
					i++;
				}
				i = 0;
				while (i < this.mapKey_.size()) {
					size += CodedOutputStream.computeMessageSize(MAP_KEY_FIELD_NUMBER, (MessageLite) this.mapKey_.get(i));
					i++;
				}
				i = 0;
				while (i < this.mapValue_.size()) {
					size += CodedOutputStream.computeMessageSize(MAP_VALUE_FIELD_NUMBER, (MessageLite) this.mapValue_.get(i));
					i++;
				}
				if ((this.bitField0_ & 4) == 4) {
					size += CodedOutputStream.computeBytesSize(MACRO_REFERENCE_FIELD_NUMBER, getMacroReferenceBytes());
				}
				if ((this.bitField0_ & 8) == 8) {
					size += CodedOutputStream.computeBytesSize(FUNCTION_ID_FIELD_NUMBER, getFunctionIdBytes());
				}
				if ((this.bitField0_ & 16) == 16) {
					size += CodedOutputStream.computeInt64Size(INTEGER_FIELD_NUMBER, this.integer_);
				}
				if ((this.bitField0_ & 64) == 64) {
					size += CodedOutputStream.computeBoolSize(CONTAINS_REFERENCES_FIELD_NUMBER, this.containsReferences_);
				}
				int dataSize = 0;
				i = 0;
				while (i < this.escaping_.size()) {
					dataSize += CodedOutputStream.computeEnumSizeNoTag(((Escaping) this.escaping_.get(i)).getNumber());
					i++;
				}
				size = (size + dataSize) + (this.escaping_.size() * 1);
				i = 0;
				while (i < this.templateToken_.size()) {
					size += CodedOutputStream.computeMessageSize(TEMPLATE_TOKEN_FIELD_NUMBER, (MessageLite) this.templateToken_.get(i));
					i++;
				}
				if ((this.bitField0_ & 32) == 32) {
					size += CodedOutputStream.computeBoolSize(BOOLEAN_FIELD_NUMBER, this.boolean_);
				}
				size = (size + extensionsSerializedSize()) + this.unknownFields.size();
				this.memoizedSerializedSize = size;
				return size;
			}
		}

		public String getString() {
			Object ref = this.string_;
			if (ref instanceof String) {
				return (String) ref;
			} else {
				ByteString bs = (ByteString) ref;
				String s = bs.toStringUtf8();
				if (bs.isValidUtf8()) {
					this.string_ = s;
				}
				return s;
			}
		}

		public ByteString getStringBytes() {
			Object ref = this.string_;
			if (ref instanceof String) {
				ByteString b = ByteString.copyFromUtf8((String) ref);
				this.string_ = b;
				return b;
			} else {
				return (ByteString) ref;
			}
		}

		public TypeSystem.Value getTemplateToken(int index) {
			return (TypeSystem.Value) this.templateToken_.get(index);
		}

		public int getTemplateTokenCount() {
			return this.templateToken_.size();
		}

		public List<TypeSystem.Value> getTemplateTokenList() {
			return this.templateToken_;
		}

		public TypeSystem.ValueOrBuilder getTemplateTokenOrBuilder(int index) {
			return (TypeSystem.ValueOrBuilder) this.templateToken_.get(index);
		}

		public List<TypeSystem.ValueOrBuilder> getTemplateTokenOrBuilderList() {
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
			} else {
				int hash = TypeSystem.Value.class.hashCode() + 779;
				if (hasType()) {
					hash = (((hash * 37) + 1) * 53) + Internal.hashEnum(getType());
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
				hash = (hash * 29) + this.unknownFields.hashCode();
				this.memoizedHashCode = hash;
				return hash;
			}
		}

		protected MutableMessageLite internalMutableDefault() {
			if (mutableDefault == null) {
				mutableDefault = internalMutableDefault("com.google.analytics.midtier.proto.containertag.MutableTypeSystem$Value");
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
			} else if (!hasType()) {
				this.memoizedIsInitialized = (byte) 0;
				return false;
			} else {
				int i = 0;
				while (i < getListItemCount()) {
					if (!getListItem(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				i = 0;
				while (i < getMapKeyCount()) {
					if (!getMapKey(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				i = 0;
				while (i < getMapValueCount()) {
					if (!getMapValue(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				i = 0;
				while (i < getTemplateTokenCount()) {
					if (!getTemplateToken(i).isInitialized()) {
						this.memoizedIsInitialized = (byte) 0;
						return false;
					} else {
						i++;
					}
				}
				if (!extensionsAreInitialized()) {
					this.memoizedIsInitialized = (byte) 0;
					return false;
				} else {
					this.memoizedIsInitialized = (byte) 1;
					return true;
				}
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
			ExtendableMessage<TypeSystem.Value> extensionWriter = newExtensionWriter();
			if ((this.bitField0_ & 1) == 1) {
				output.writeEnum(TYPE_FIELD_NUMBER, this.type_.getNumber());
			}
			if ((this.bitField0_ & 2) == 2) {
				output.writeBytes(STRING_FIELD_NUMBER, getStringBytes());
			}
			int i = 0;
			while (i < this.listItem_.size()) {
				output.writeMessage(LIST_ITEM_FIELD_NUMBER, (MessageLite) this.listItem_.get(i));
				i++;
			}
			i = 0;
			while (i < this.mapKey_.size()) {
				output.writeMessage(MAP_KEY_FIELD_NUMBER, (MessageLite) this.mapKey_.get(i));
				i++;
			}
			i = 0;
			while (i < this.mapValue_.size()) {
				output.writeMessage(MAP_VALUE_FIELD_NUMBER, (MessageLite) this.mapValue_.get(i));
				i++;
			}
			if ((this.bitField0_ & 4) == 4) {
				output.writeBytes(MACRO_REFERENCE_FIELD_NUMBER, getMacroReferenceBytes());
			}
			if ((this.bitField0_ & 8) == 8) {
				output.writeBytes(FUNCTION_ID_FIELD_NUMBER, getFunctionIdBytes());
			}
			if ((this.bitField0_ & 16) == 16) {
				output.writeInt64(INTEGER_FIELD_NUMBER, this.integer_);
			}
			if ((this.bitField0_ & 64) == 64) {
				output.writeBool(CONTAINS_REFERENCES_FIELD_NUMBER, this.containsReferences_);
			}
			i = 0;
			while (i < this.escaping_.size()) {
				output.writeEnum(ESCAPING_FIELD_NUMBER, ((Escaping) this.escaping_.get(i)).getNumber());
				i++;
			}
			i = 0;
			while (i < this.templateToken_.size()) {
				output.writeMessage(TEMPLATE_TOKEN_FIELD_NUMBER, (MessageLite) this.templateToken_.get(i));
				i++;
			}
			if ((this.bitField0_ & 32) == 32) {
				output.writeBool(BOOLEAN_FIELD_NUMBER, this.boolean_);
			}
			extensionWriter.writeUntil(536870912, output);
			output.writeRawBytes(this.unknownFields);
		}
	}


	static {
	}

	private TypeSystem() {
	}

	public static void registerAllExtensions(ExtensionRegistryLite registry) {
	}
}
