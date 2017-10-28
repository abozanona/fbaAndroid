package com.google.tagmanager.protobuf;

public final class WireFormat {
	static final int MESSAGE_SET_ITEM = 1;
	static final int MESSAGE_SET_ITEM_END_TAG;
	static final int MESSAGE_SET_ITEM_TAG;
	static final int MESSAGE_SET_MESSAGE = 3;
	static final int MESSAGE_SET_MESSAGE_TAG;
	static final int MESSAGE_SET_TYPE_ID = 2;
	static final int MESSAGE_SET_TYPE_ID_TAG;
	static final int TAG_TYPE_BITS = 3;
	static final int TAG_TYPE_MASK = 7;
	public static final int WIRETYPE_END_GROUP = 4;
	public static final int WIRETYPE_FIXED32 = 5;
	public static final int WIRETYPE_FIXED64 = 1;
	public static final int WIRETYPE_LENGTH_DELIMITED = 2;
	public static final int WIRETYPE_START_GROUP = 3;
	public static final int WIRETYPE_VARINT = 0;

	public static enum FieldType {
		DOUBLE(WireFormat.JavaType.DOUBLE, 1),
		FLOAT(WireFormat.JavaType.FLOAT, 5),
		INT64(WireFormat.JavaType.LONG, 0),
		UINT64(WireFormat.JavaType.LONG, 0),
		INT32(WireFormat.JavaType.INT, 0),
		FIXED64(WireFormat.JavaType.LONG, 1),
		FIXED32(WireFormat.JavaType.INT, 5),
		BOOL(WireFormat.JavaType.BOOLEAN, 0),
		STRING(WireFormat.JavaType.STRING, 2){
			public boolean isPackable() {
				return false;
			}
		},
		GROUP(WireFormat.JavaType.MESSAGE, 3){
			public boolean isPackable() {
				return false;
			}
		},
		MESSAGE(WireFormat.JavaType.MESSAGE, 2){
			public boolean isPackable() {
				return false;
			}
		},
		BYTES(WireFormat.JavaType.BYTE_STRING, 2){
			public boolean isPackable() {
				return false;
			}
		},
		UINT32(WireFormat.JavaType.INT, 0),
		ENUM(WireFormat.JavaType.ENUM, 0),
		SFIXED32(WireFormat.JavaType.INT, 5),
		SFIXED64(WireFormat.JavaType.LONG, 1),
		SINT32(WireFormat.JavaType.INT, 0),
		SINT64(WireFormat.JavaType.LONG, 0);

		private final WireFormat.JavaType javaType;
		private final int wireType;


		private FieldType(WireFormat.JavaType javaType, int wireType) {
			this.javaType = javaType;
			this.wireType = wireType;
		}

		public WireFormat.JavaType getJavaType() {
			return this.javaType;
		}

		public int getWireType() {
			return this.wireType;
		}

		public boolean isPackable() {
			return true;
		}
	}

	public static enum JavaType {
		INT(Integer.valueOf(MESSAGE_SET_TYPE_ID_TAG)),
		LONG(Long.valueOf(0)),
		FLOAT(Float.valueOf(0.0f)),
		DOUBLE(Double.valueOf(0.0d)),
		BOOLEAN(Boolean.valueOf(false)),
		STRING(""),
		BYTE_STRING(ByteString.EMPTY),
		ENUM(null),
		MESSAGE(null);

		private final Object defaultDefault;

		private JavaType(Object defaultDefault) {
			this.defaultDefault = defaultDefault;
		}

		Object getDefaultDefault() {
			return this.defaultDefault;
		}
	}


	static {
		MESSAGE_SET_ITEM_TAG = makeTag(WIRETYPE_FIXED64, WIRETYPE_START_GROUP);
		MESSAGE_SET_ITEM_END_TAG = makeTag(WIRETYPE_FIXED64, WIRETYPE_END_GROUP);
		MESSAGE_SET_TYPE_ID_TAG = makeTag(WIRETYPE_LENGTH_DELIMITED, MESSAGE_SET_TYPE_ID_TAG);
		MESSAGE_SET_MESSAGE_TAG = makeTag(WIRETYPE_START_GROUP, WIRETYPE_LENGTH_DELIMITED);
	}

	private WireFormat() {
	}

	public static int getTagFieldNumber(int tag) {
		return tag >>> 3;
	}

	static int getTagWireType(int tag) {
		return tag & 7;
	}

	static int makeTag(int fieldNumber, int wireType) {
		return (fieldNumber << 3) | wireType;
	}
}
