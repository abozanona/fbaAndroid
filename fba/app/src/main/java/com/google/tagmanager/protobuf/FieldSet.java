package com.google.tagmanager.protobuf;

import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Escaping;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;
import com.google.tagmanager.protobuf.LazyField.LazyIterator;
import com.google.tagmanager.protobuf.MessageLite.Builder;
import com.google.tagmanager.protobuf.WireFormat.FieldType;
import com.google.tagmanager.protobuf.WireFormat.JavaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class FieldSet<Type extends FieldDescriptorLite<FieldDescriptorType>> {
	private static final FieldSet DEFAULT_INSTANCE;
	private final SmallSortedMap<FieldDescriptorType, Object> fields;
	private boolean hasLazyField;
	private boolean isImmutable;

	static /* synthetic */ class AnonymousClass_1 {
		static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;
		static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

		static {
			$SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[FieldType.values().length];
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.DOUBLE.ordinal()] = 1;
			} catch (NoSuchFieldError e) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FLOAT.ordinal()] = 2;
			} catch (NoSuchFieldError e_2) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.INT64.ordinal()] = 3;
			} catch (NoSuchFieldError e_3) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.UINT64.ordinal()] = 4;
			} catch (NoSuchFieldError e_4) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.INT32.ordinal()] = 5;
			} catch (NoSuchFieldError e_5) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FIXED64.ordinal()] = 6;
			} catch (NoSuchFieldError e_6) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FIXED32.ordinal()] = 7;
			} catch (NoSuchFieldError e_7) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.BOOL.ordinal()] = 8;
			} catch (NoSuchFieldError e_8) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.STRING.ordinal()] = 9;
			} catch (NoSuchFieldError e_9) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.BYTES.ordinal()] = 10;
			} catch (NoSuchFieldError e_10) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.UINT32.ordinal()] = 11;
			} catch (NoSuchFieldError e_11) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED32.ordinal()] = 12;
			} catch (NoSuchFieldError e_12) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED64.ordinal()] = 13;
			} catch (NoSuchFieldError e_13) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SINT32.ordinal()] = 14;
			} catch (NoSuchFieldError e_14) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SINT64.ordinal()] = 15;
			} catch (NoSuchFieldError e_15) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.GROUP.ordinal()] = 16;
			} catch (NoSuchFieldError e_16) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.MESSAGE.ordinal()] = 17;
			} catch (NoSuchFieldError e_17) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.ENUM.ordinal()] = 18;
			} catch (NoSuchFieldError e_18) {
			}
			$SwitchMap$com$google$protobuf$WireFormat$JavaType = new int[JavaType.values().length];
			try {
				$SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.INT.ordinal()] = 1;
			} catch (NoSuchFieldError e_19) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.LONG.ordinal()] = 2;
			} catch (NoSuchFieldError e_20) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.FLOAT.ordinal()] = 3;
			} catch (NoSuchFieldError e_21) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.DOUBLE.ordinal()] = 4;
			} catch (NoSuchFieldError e_22) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.BOOLEAN.ordinal()] = 5;
			} catch (NoSuchFieldError e_23) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.STRING.ordinal()] = 6;
			} catch (NoSuchFieldError e_24) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.BYTE_STRING.ordinal()] = 7;
			} catch (NoSuchFieldError e_25) {
			}
			try {
				$SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.ENUM.ordinal()] = 8;
			} catch (NoSuchFieldError e_26) {
			}
			$SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.MESSAGE.ordinal()] = 9;
		}
	}

	public static interface FieldDescriptorLite<T extends FieldSet.FieldDescriptorLite<T>> extends Comparable<T> {
		public EnumLiteMap<?> getEnumType();

		public JavaType getLiteJavaType();

		public FieldType getLiteType();

		public int getNumber();

		public Builder internalMergeFrom(Builder r1_Builder, MessageLite r2_MessageLite);

		public MutableMessageLite internalMergeFrom(MutableMessageLite r1_MutableMessageLite, MutableMessageLite r2_MutableMessageLite);

		public boolean isPacked();

		public boolean isRepeated();
	}


	static {
		DEFAULT_INSTANCE = new FieldSet(true);
	}

	private FieldSet() {
		this.hasLazyField = false;
		this.fields = SmallSortedMap.newFieldMap(Escaping.CONVERT_JS_VALUE_TO_EXPRESSION_VALUE);
	}

	private FieldSet(boolean dummy) {
		this.hasLazyField = false;
		this.fields = SmallSortedMap.newFieldMap(0);
		makeImmutable();
	}

	private void cloneFieldEntry(Map<FieldDescriptorType, Object> map, Entry<FieldDescriptorType, Object> entry) {
		FieldDescriptorType key = (FieldDescriptorLite) entry.getKey();
		Object value = entry.getValue();
		if (value instanceof LazyField) {
			map.put(key, ((LazyField) value).getValue());
			return;
		} else {
			map.put(key, value);
		}
	}

	private static int computeElementSize(FieldType type, int number, Object value) {
		int tagSize = CodedOutputStream.computeTagSize(number);
		if (type != FieldType.GROUP || Internal.isProto1Group((MessageLite) value)) {
			return computeElementSizeNoTag(type, value) + tagSize;
		} else {
			tagSize *= 2;
			return computeElementSizeNoTag(type, value) + tagSize;
		}
	}

	private static int computeElementSizeNoTag(FieldType type, Object value) {
		switch(AnonymousClass_1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[type.ordinal()]) {
		case WireFormat.WIRETYPE_FIXED64:
			return CodedOutputStream.computeDoubleSizeNoTag(((Double) value).doubleValue());
		case WireFormat.WIRETYPE_LENGTH_DELIMITED:
			return CodedOutputStream.computeFloatSizeNoTag(((Float) value).floatValue());
		case WireFormat.WIRETYPE_START_GROUP:
			return CodedOutputStream.computeInt64SizeNoTag(((Long) value).longValue());
		case WireFormat.WIRETYPE_END_GROUP:
			return CodedOutputStream.computeUInt64SizeNoTag(((Long) value).longValue());
		case WireFormat.WIRETYPE_FIXED32:
			return CodedOutputStream.computeInt32SizeNoTag(((Integer) value).intValue());
		case Value.MACRO_REFERENCE_FIELD_NUMBER:
			return CodedOutputStream.computeFixed64SizeNoTag(((Long) value).longValue());
		case Value.FUNCTION_ID_FIELD_NUMBER:
			return CodedOutputStream.computeFixed32SizeNoTag(((Integer) value).intValue());
		case CodedOutputStream.LITTLE_ENDIAN_64_SIZE:
			return CodedOutputStream.computeBoolSizeNoTag(((Boolean) value).booleanValue());
		case Value.CONTAINS_REFERENCES_FIELD_NUMBER:
			return CodedOutputStream.computeStringSizeNoTag((String) value);
		case Value.ESCAPING_FIELD_NUMBER:
			return (value instanceof ByteString) ? CodedOutputStream.computeBytesSizeNoTag((ByteString) value) : CodedOutputStream.computeByteArraySizeNoTag((byte[]) ((byte[]) value));
		case Value.TEMPLATE_TOKEN_FIELD_NUMBER:
			return CodedOutputStream.computeUInt32SizeNoTag(((Integer) value).intValue());
		case Value.BOOLEAN_FIELD_NUMBER:
			return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) value).intValue());
		case Escaping.NORMALIZE_URI_VALUE:
			return CodedOutputStream.computeSFixed64SizeNoTag(((Long) value).longValue());
		case Escaping.FILTER_NORMALIZE_URI_VALUE:
			return CodedOutputStream.computeSInt32SizeNoTag(((Integer) value).intValue());
		case Escaping.NO_AUTOESCAPE_VALUE:
			return CodedOutputStream.computeSInt64SizeNoTag(((Long) value).longValue());
		case Escaping.CONVERT_JS_VALUE_TO_EXPRESSION_VALUE:
			return CodedOutputStream.computeGroupSizeNoTag((MessageLite) value);
		case Escaping.TEXT_VALUE:
			return (value instanceof LazyField) ? CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) value) : CodedOutputStream.computeMessageSizeNoTag((MessageLite) value);
		case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
			return (value instanceof EnumLite) ? CodedOutputStream.computeEnumSizeNoTag(((EnumLite) value).getNumber()) : CodedOutputStream.computeEnumSizeNoTag(((Integer) value).intValue());
		}
		throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
	}

	public static int computeFieldSize(FieldDescriptorLite<?> descriptor, Object value) {
		FieldType type = descriptor.getLiteType();
		int number = descriptor.getNumber();
		if (descriptor.isRepeated()) {
			Iterator i$;
			if (descriptor.isPacked()) {
				int dataSize = 0;
				i$ = ((List) value).iterator();
				while (i$.hasNext()) {
					dataSize += computeElementSizeNoTag(type, i$.next());
				}
				return (CodedOutputStream.computeTagSize(number) + dataSize) + CodedOutputStream.computeRawVarint32Size(dataSize);
			} else {
				int size = 0;
				i$ = ((List) value).iterator();
				while (i$.hasNext()) {
					size += computeElementSize(type, number, i$.next());
				}
				return size;
			}
		} else {
			return computeElementSize(type, number, value);
		}
	}

	private Object convertToImmutable(FieldDescriptorType descriptor, Object value) {
		Iterator i$;
		if (descriptor.getLiteJavaType() == JavaType.MESSAGE) {
			if (descriptor.isRepeated()) {
				List<Object> immutableMessages = new ArrayList();
				i$ = ((List) value).iterator();
				while (i$.hasNext()) {
					immutableMessages.add(((MutableMessageLite) i$.next()).immutableCopy());
				}
				return immutableMessages;
			} else if (value instanceof LazyField) {
				return ((MutableMessageLite) ((LazyField) value).getValue()).immutableCopy();
			} else {
				return ((MutableMessageLite) value).immutableCopy();
			}
		} else if (descriptor.getLiteJavaType() == JavaType.BYTE_STRING) {
			if (descriptor.isRepeated()) {
				List<Object> immutableFields = new ArrayList();
				i$ = ((List) value).iterator();
				while (i$.hasNext()) {
					immutableFields.add(ByteString.copyFrom((byte[]) ((byte[]) i$.next())));
				}
				return immutableFields;
			} else {
				return ByteString.copyFrom((byte[]) ((byte[]) value));
			}
		} else {
			return value;
		}
	}

	private Object convertToMutable(FieldDescriptorType descriptor, Object value) {
		Iterator i$;
		if (descriptor.getLiteJavaType() == JavaType.MESSAGE) {
			if (descriptor.isRepeated()) {
				List<Object> mutableMessages = new ArrayList();
				i$ = ((List) value).iterator();
				while (i$.hasNext()) {
					mutableMessages.add(((MessageLite) i$.next()).mutableCopy());
				}
				return mutableMessages;
			} else if (value instanceof LazyField) {
				return ((LazyField) value).getValue().mutableCopy();
			} else {
				return ((MessageLite) value).mutableCopy();
			}
		} else if (descriptor.getLiteJavaType() == JavaType.BYTE_STRING) {
			if (descriptor.isRepeated()) {
				List<Object> mutableFields = new ArrayList();
				i$ = ((List) value).iterator();
				while (i$.hasNext()) {
					mutableFields.add(((ByteString) i$.next()).toByteArray());
				}
				return mutableFields;
			} else {
				return ((ByteString) value).toByteArray();
			}
		} else {
			return value;
		}
	}

	public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
		return DEFAULT_INSTANCE;
	}

	private int getMessageSetSerializedSize(Entry<FieldDescriptorType, Object> entry) {
		FieldDescriptorType descriptor = (FieldDescriptorLite) entry.getKey();
		Object value = entry.getValue();
		if (descriptor.getLiteJavaType() != JavaType.MESSAGE || descriptor.isRepeated() || descriptor.isPacked()) {
			return computeFieldSize(descriptor, value);
		} else if (value instanceof LazyField) {
			return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(((FieldDescriptorLite) entry.getKey()).getNumber(), (LazyField) value);
		} else {
			return CodedOutputStream.computeMessageSetExtensionSize(((FieldDescriptorLite) entry.getKey()).getNumber(), (MessageLite) value);
		}
	}

	static int getWireFormatForFieldType(FieldType type, boolean isPacked) {
		return (isPacked) ? WireFormat.WIRETYPE_LENGTH_DELIMITED : type.getWireType();
	}

	private boolean isInitialized(Entry<FieldDescriptorType, Object> entry) {
		FieldDescriptorType descriptor = (FieldDescriptorLite) entry.getKey();
		if (descriptor.getLiteJavaType() == JavaType.MESSAGE) {
			if (descriptor.isRepeated()) {
				Iterator i$ = ((List) entry.getValue()).iterator();
				while (i$.hasNext()) {
					if (!((MessageLite) i$.next()).isInitialized()) {
						return false;
					}
				}
			} else {
				Object value = entry.getValue();
				if (value instanceof MessageLite) {
					if (!((MessageLite) value).isInitialized()) {
						return false;
					}
				} else if (value instanceof LazyField) {
					return true;
				} else {
					throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
				}
			}
		}
		return true;
	}

	private void mergeFromField(Entry<FieldDescriptorType, Object> entry) {
		Comparable descriptor = (FieldDescriptorLite) entry.getKey();
		Object otherValue = entry.getValue();
		if (otherValue instanceof LazyField) {
			otherValue = ((LazyField) otherValue).getValue();
		}
		Object value;
		if (descriptor.isRepeated()) {
			value = getField(descriptor);
			if (value == null) {
				this.fields.put(descriptor, new ArrayList((List) otherValue));
				return;
			} else {
				((List) value).addAll((List) otherValue);
				return;
			}
		} else if (descriptor.getLiteJavaType() == JavaType.MESSAGE) {
			value = getField(descriptor);
			if (value == null) {
				this.fields.put(descriptor, otherValue);
				return;
			} else {
				this.fields.put(descriptor, (value instanceof MutableMessageLite) ? descriptor.internalMergeFrom((MutableMessageLite) value, (MutableMessageLite) otherValue) : descriptor.internalMergeFrom(((MessageLite) value).toBuilder(), (MessageLite) otherValue).build());
				return;
			}
		} else {
			this.fields.put(descriptor, otherValue);
		}
	}

	public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
		return new FieldSet();
	}

	public static Object readPrimitiveField(CodedInputStream input, FieldType type, boolean checkUtf8) throws IOException {
		switch(AnonymousClass_1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[type.ordinal()]) {
		case WireFormat.WIRETYPE_FIXED64:
			return Double.valueOf(input.readDouble());
		case WireFormat.WIRETYPE_LENGTH_DELIMITED:
			return Float.valueOf(input.readFloat());
		case WireFormat.WIRETYPE_START_GROUP:
			return Long.valueOf(input.readInt64());
		case WireFormat.WIRETYPE_END_GROUP:
			return Long.valueOf(input.readUInt64());
		case WireFormat.WIRETYPE_FIXED32:
			return Integer.valueOf(input.readInt32());
		case Value.MACRO_REFERENCE_FIELD_NUMBER:
			return Long.valueOf(input.readFixed64());
		case Value.FUNCTION_ID_FIELD_NUMBER:
			return Integer.valueOf(input.readFixed32());
		case CodedOutputStream.LITTLE_ENDIAN_64_SIZE:
			return Boolean.valueOf(input.readBool());
		case Value.CONTAINS_REFERENCES_FIELD_NUMBER:
			return (checkUtf8) ? input.readStringRequireUtf8() : input.readString();
		case Value.ESCAPING_FIELD_NUMBER:
			return input.readBytes();
		case Value.TEMPLATE_TOKEN_FIELD_NUMBER:
			return Integer.valueOf(input.readUInt32());
		case Value.BOOLEAN_FIELD_NUMBER:
			return Integer.valueOf(input.readSFixed32());
		case Escaping.NORMALIZE_URI_VALUE:
			return Long.valueOf(input.readSFixed64());
		case Escaping.FILTER_NORMALIZE_URI_VALUE:
			return Integer.valueOf(input.readSInt32());
		case Escaping.NO_AUTOESCAPE_VALUE:
			return Long.valueOf(input.readSInt64());
		case Escaping.CONVERT_JS_VALUE_TO_EXPRESSION_VALUE:
			throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
		case Escaping.TEXT_VALUE:
			throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
		case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
			throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
		}
		throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
	}

	public static Object readPrimitiveFieldForMutable(CodedInputStream input, FieldType type, boolean checkUtf8) throws IOException {
		return (type == FieldType.BYTES) ? input.readByteArray() : readPrimitiveField(input, type, checkUtf8);
	}

	private static void verifyType(FieldType type, Object value) {
		if (value == null) {
			throw new NullPointerException();
		} else {
			boolean isValid = false;
			switch(AnonymousClass_1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[type.getJavaType().ordinal()]) {
			case WireFormat.WIRETYPE_FIXED64:
				isValid = value instanceof Integer;
				break;
			case WireFormat.WIRETYPE_LENGTH_DELIMITED:
				isValid = value instanceof Long;
				break;
			case WireFormat.WIRETYPE_START_GROUP:
				isValid = value instanceof Float;
				break;
			case WireFormat.WIRETYPE_END_GROUP:
				isValid = value instanceof Double;
				break;
			case WireFormat.WIRETYPE_FIXED32:
				isValid = value instanceof Boolean;
				break;
			case Value.MACRO_REFERENCE_FIELD_NUMBER:
				isValid = value instanceof String;
				break;
			case Value.FUNCTION_ID_FIELD_NUMBER:
				isValid = value instanceof ByteString || value instanceof byte[];
				break;
			case CodedOutputStream.LITTLE_ENDIAN_64_SIZE:
				isValid = value instanceof Integer || value instanceof EnumLite;
				break;
			case Value.CONTAINS_REFERENCES_FIELD_NUMBER:
				isValid = value instanceof MessageLite || value instanceof LazyField;
				break;
			}
			if (!isValid) {
				throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
			}
		}
	}

	private static void writeElement(CodedOutputStream output, FieldType type, int number, Object value) throws IOException {
		if (type == FieldType.GROUP) {
			if (Internal.isProto1Group((MessageLite) value)) {
				output.writeTag(number, WireFormat.WIRETYPE_START_GROUP);
				output.writeGroupNoTag((MessageLite) value);
				return;
			} else {
				output.writeGroup(number, (MessageLite) value);
				return;
			}
		} else {
			output.writeTag(number, getWireFormatForFieldType(type, false));
			writeElementNoTag(output, type, value);
		}
	}

	private static void writeElementNoTag(CodedOutputStream output, FieldType type, Object value) throws IOException {
		switch(AnonymousClass_1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[type.ordinal()]) {
		case WireFormat.WIRETYPE_FIXED64:
			output.writeDoubleNoTag(((Double) value).doubleValue());
			break;
		case WireFormat.WIRETYPE_LENGTH_DELIMITED:
			output.writeFloatNoTag(((Float) value).floatValue());
			break;
		case WireFormat.WIRETYPE_START_GROUP:
			output.writeInt64NoTag(((Long) value).longValue());
			break;
		case WireFormat.WIRETYPE_END_GROUP:
			output.writeUInt64NoTag(((Long) value).longValue());
			break;
		case WireFormat.WIRETYPE_FIXED32:
			output.writeInt32NoTag(((Integer) value).intValue());
			break;
		case Value.MACRO_REFERENCE_FIELD_NUMBER:
			output.writeFixed64NoTag(((Long) value).longValue());
			break;
		case Value.FUNCTION_ID_FIELD_NUMBER:
			output.writeFixed32NoTag(((Integer) value).intValue());
			break;
		case CodedOutputStream.LITTLE_ENDIAN_64_SIZE:
			output.writeBoolNoTag(((Boolean) value).booleanValue());
			break;
		case Value.CONTAINS_REFERENCES_FIELD_NUMBER:
			output.writeStringNoTag((String) value);
			break;
		case Value.ESCAPING_FIELD_NUMBER:
			if (value instanceof ByteString) {
				output.writeBytesNoTag((ByteString) value);
			} else {
				output.writeByteArrayNoTag((byte[]) ((byte[]) value));
			}
			break;
		case Value.TEMPLATE_TOKEN_FIELD_NUMBER:
			output.writeUInt32NoTag(((Integer) value).intValue());
			break;
		case Value.BOOLEAN_FIELD_NUMBER:
			output.writeSFixed32NoTag(((Integer) value).intValue());
			break;
		case Escaping.NORMALIZE_URI_VALUE:
			output.writeSFixed64NoTag(((Long) value).longValue());
			break;
		case Escaping.FILTER_NORMALIZE_URI_VALUE:
			output.writeSInt32NoTag(((Integer) value).intValue());
			break;
		case Escaping.NO_AUTOESCAPE_VALUE:
			output.writeSInt64NoTag(((Long) value).longValue());
			break;
		case Escaping.CONVERT_JS_VALUE_TO_EXPRESSION_VALUE:
			output.writeGroupNoTag((MessageLite) value);
			break;
		case Escaping.TEXT_VALUE:
			output.writeMessageNoTag((MessageLite) value);
			break;
		case Resource.ENABLE_AUTO_EVENT_TRACKING_FIELD_NUMBER:
			if (value instanceof EnumLite) {
				output.writeEnumNoTag(((EnumLite) value).getNumber());
			} else {
				output.writeEnumNoTag(((Integer) value).intValue());
			}
			break;
		}
	}

	public static void writeField(FieldDescriptorLite<?> descriptor, Object value, CodedOutputStream output) throws IOException {
		FieldType type = descriptor.getLiteType();
		int number = descriptor.getNumber();
		if (descriptor.isRepeated()) {
			List<?> valueList = (List) value;
			Iterator i$;
			if (descriptor.isPacked()) {
				output.writeTag(number, WireFormat.WIRETYPE_LENGTH_DELIMITED);
				int dataSize = 0;
				i$ = valueList.iterator();
				while (i$.hasNext()) {
					dataSize += computeElementSizeNoTag(type, i$.next());
				}
				output.writeRawVarint32(dataSize);
				i$ = valueList.iterator();
				while (i$.hasNext()) {
					writeElementNoTag(output, type, i$.next());
				}
				return;
			} else {
				i$ = valueList.iterator();
				while (i$.hasNext()) {
					writeElement(output, type, number, i$.next());
				}
				return;
			}
		} else if (value instanceof LazyField) {
			writeElement(output, type, number, ((LazyField) value).getValue());
			return;
		} else {
			writeElement(output, type, number, value);
		}
	}

	private void writeMessageSetTo(Entry<FieldDescriptorType, Object> entry, CodedOutputStream output) throws IOException {
		FieldDescriptorType descriptor = (FieldDescriptorLite) entry.getKey();
		if (descriptor.getLiteJavaType() != JavaType.MESSAGE || descriptor.isRepeated() || descriptor.isPacked()) {
			writeField(descriptor, entry.getValue(), output);
			return;
		} else {
			output.writeMessageSetExtension(((FieldDescriptorLite) entry.getKey()).getNumber(), (MessageLite) entry.getValue());
		}
	}

	public void addRepeatedField(FieldDescriptorType descriptor, Object value) {
		if (!descriptor.isRepeated()) {
			throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
		} else {
			Object list;
			verifyType(descriptor.getLiteType(), value);
			List<Object> existingValue = getField(descriptor);
			if (existingValue == null) {
				list = new ArrayList();
				this.fields.put((Comparable)descriptor, list);
			} else {
				list = existingValue;
			}
			list.add(value);
		}
	}

	public void clear() {
		this.fields.clear();
		this.hasLazyField = false;
	}

	public void clearField(FieldDescriptorType descriptor) {
		this.fields.remove(descriptor);
		if (this.fields.isEmpty()) {
			this.hasLazyField = false;
		}
	}

	public FieldSet<FieldDescriptorType> clone() {
		Entry<FieldDescriptorType, Object> entry;
		FieldSet<FieldDescriptorType> clone = newFieldSet();
		int i = 0;
		while (i < this.fields.getNumArrayEntries()) {
			entry = this.fields.getArrayEntryAt(i);
			clone.setField((FieldDescriptorLite) entry.getKey(), entry.getValue());
			i++;
		}
		Iterator i$ = this.fields.getOverflowEntries().iterator();
		while (i$.hasNext()) {
			entry = i$.next();
			clone.setField((FieldDescriptorLite) entry.getKey(), entry.getValue());
		}
		clone.hasLazyField = this.hasLazyField;
		return clone;
	}

	public FieldSet<FieldDescriptorType> cloneWithAllFieldsToImmutable() {
		Entry<FieldDescriptorType, Object> entry;
		FieldDescriptorType descriptor;
		FieldSet<FieldDescriptorType> clone = newFieldSet();
		int i = 0;
		while (i < this.fields.getNumArrayEntries()) {
			entry = this.fields.getArrayEntryAt(i);
			descriptor = (FieldDescriptorLite) entry.getKey();
			clone.setField(descriptor, convertToImmutable(descriptor, entry.getValue()));
			i++;
		}
		Iterator i$ = this.fields.getOverflowEntries().iterator();
		while (i$.hasNext()) {
			entry = i$.next();
			descriptor = (FieldDescriptorLite) entry.getKey();
			clone.setField(descriptor, convertToImmutable(descriptor, entry.getValue()));
		}
		clone.hasLazyField = false;
		return clone;
	}

	public FieldSet<FieldDescriptorType> cloneWithAllFieldsToMutable() {
		Entry<FieldDescriptorType, Object> entry;
		FieldDescriptorType descriptor;
		FieldSet<FieldDescriptorType> clone = newFieldSet();
		int i = 0;
		while (i < this.fields.getNumArrayEntries()) {
			entry = this.fields.getArrayEntryAt(i);
			descriptor = (FieldDescriptorLite) entry.getKey();
			clone.setField(descriptor, convertToMutable(descriptor, entry.getValue()));
			i++;
		}
		Iterator i$ = this.fields.getOverflowEntries().iterator();
		while (i$.hasNext()) {
			entry = i$.next();
			descriptor = (FieldDescriptorLite) entry.getKey();
			clone.setField(descriptor, convertToMutable(descriptor, entry.getValue()));
		}
		clone.hasLazyField = false;
		return clone;
	}

	public Map<FieldDescriptorType, Object> getAllFields() {
		if (this.hasLazyField) {
			SmallSortedMap<FieldDescriptorType, Object> result = SmallSortedMap.newFieldMap(Escaping.CONVERT_JS_VALUE_TO_EXPRESSION_VALUE);
			int i = 0;
			while (i < this.fields.getNumArrayEntries()) {
				cloneFieldEntry(result, this.fields.getArrayEntryAt(i));
				i++;
			}
			Iterator i$ = this.fields.getOverflowEntries().iterator();
			while (i$.hasNext()) {
				cloneFieldEntry(result, (Entry) i$.next());
			}
			if (this.fields.isImmutable()) {
				result.makeImmutable();
				return result;
			}
			return result;
		} else {
			return (this.fields.isImmutable()) ? this.fields : Collections.unmodifiableMap(this.fields);
		}
	}

	public Object getField(FieldDescriptorType descriptor) {
		Object o = this.fields.get(descriptor);
		if (o instanceof LazyField) {
			return ((LazyField) o).getValue();
		}
		return o;
	}

	public int getMessageSetSerializedSize() {
		int size = 0;
		int i = 0;
		while (i < this.fields.getNumArrayEntries()) {
			size += getMessageSetSerializedSize(this.fields.getArrayEntryAt(i));
			i++;
		}
		Iterator i$ = this.fields.getOverflowEntries().iterator();
		while (i$.hasNext()) {
			size += getMessageSetSerializedSize((Entry) i$.next());
		}
		return size;
	}

	public Object getRepeatedField(FieldDescriptorType descriptor, int index) {
		if (!descriptor.isRepeated()) {
			throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
		} else {
			Object value = getField(descriptor);
			if (value == null) {
				throw new IndexOutOfBoundsException();
			} else {
				return ((List) value).get(index);
			}
		}
	}

	public int getRepeatedFieldCount(FieldDescriptorType descriptor) {
		if (!descriptor.isRepeated()) {
			throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
		} else {
			Object value = getField(descriptor);
			return (value == null) ? 0 : ((List) value).size();
		}
	}

	public int getSerializedSize() {
		Entry<FieldDescriptorType, Object> entry;
		int size = 0;
		int i = 0;
		while (i < this.fields.getNumArrayEntries()) {
			entry = this.fields.getArrayEntryAt(i);
			size += computeFieldSize((FieldDescriptorLite) entry.getKey(), entry.getValue());
			i++;
		}
		Iterator i$ = this.fields.getOverflowEntries().iterator();
		while (i$.hasNext()) {
			entry = i$.next();
			size += computeFieldSize((FieldDescriptorLite) entry.getKey(), entry.getValue());
		}
		return size;
	}

	public boolean hasField(FieldDescriptorType descriptor) {
		if (descriptor.isRepeated()) {
			throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
		} else if (this.fields.get(descriptor) != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isImmutable() {
		return this.isImmutable;
	}

	public boolean isInitialized() {
		int i = 0;
		while (i < this.fields.getNumArrayEntries()) {
			if (!isInitialized(this.fields.getArrayEntryAt(i))) {
				return false;
			} else {
				i++;
			}
		}
		Iterator i$ = this.fields.getOverflowEntries().iterator();
		while (i$.hasNext()) {
			if (!isInitialized((Entry) i$.next())) {
				return false;
			}
		}
		return true;
	}

	public Iterator<Entry<FieldDescriptorType, Object>> iterator() {
		return (this.hasLazyField) ? new LazyIterator(this.fields.entrySet().iterator()) : this.fields.entrySet().iterator();
	}

	public void makeImmutable() {
		if (this.isImmutable) {
		} else {
			this.fields.makeImmutable();
			this.isImmutable = true;
		}
	}

	public void mergeFrom(FieldSet<FieldDescriptorType> other) {
		int i = 0;
		while (i < other.fields.getNumArrayEntries()) {
			mergeFromField(other.fields.getArrayEntryAt(i));
			i++;
		}
		Iterator i$ = other.fields.getOverflowEntries().iterator();
		while (i$.hasNext()) {
			mergeFromField((Entry) i$.next());
		}
	}

	public void setField(FieldDescriptorType descriptor, Object value) {
		if (descriptor.isRepeated()) {
			if (!((value instanceof List))) {
				throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
			} else {
				List newList = new ArrayList();
				newList.addAll((List) value);
				Iterator i$ = newList.iterator();
				while (i$.hasNext()) {
					FieldType r3_FieldType = descriptor.getLiteType();
					verifyType(r3_FieldType, i$.next());
				}
				value = newList;
			}
		} else {
			verifyType(descriptor.getLiteType(), value);
		}
		if (value instanceof LazyField) {
			this.hasLazyField = true;
		}
		this.fields.put((Comparable)descriptor, value);
	}

	public void setRepeatedField(FieldDescriptorType descriptor, int index, Object value) {
		if (!descriptor.isRepeated()) {
			throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
		} else {
			Object list = getField(descriptor);
			if (list == null) {
				throw new IndexOutOfBoundsException();
			} else {
				verifyType(descriptor.getLiteType(), value);
				((List) list).set(index, value);
			}
		}
	}

	public void writeMessageSetTo(CodedOutputStream output) throws IOException {
		int i = 0;
		while (i < this.fields.getNumArrayEntries()) {
			writeMessageSetTo(this.fields.getArrayEntryAt(i), output);
			i++;
		}
		Iterator i$ = this.fields.getOverflowEntries().iterator();
		while (i$.hasNext()) {
			writeMessageSetTo((Entry) i$.next(), output);
		}
	}

	public void writeTo(CodedOutputStream output) throws IOException {
		Entry<FieldDescriptorType, Object> entry;
		int i = 0;
		while (i < this.fields.getNumArrayEntries()) {
			entry = this.fields.getArrayEntryAt(i);
			writeField((FieldDescriptorLite) entry.getKey(), entry.getValue(), output);
			i++;
		}
		Iterator i$ = this.fields.getOverflowEntries().iterator();
		while (i$.hasNext()) {
			entry = i$.next();
			writeField((FieldDescriptorLite) entry.getKey(), entry.getValue(), output);
		}
	}
}
