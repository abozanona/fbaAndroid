package com.google.tagmanager;

class TypedNumber extends Number implements Comparable<TypedNumber> {
	private double mDouble;
	private long mInt64;
	private boolean mIsInt64;

	private TypedNumber(double d) {
		this.mDouble = d;
		this.mIsInt64 = false;
	}

	private TypedNumber(long l) {
		this.mInt64 = l;
		this.mIsInt64 = true;
	}

	public static TypedNumber numberWithDouble(Double d) {
		return new TypedNumber(d.doubleValue());
	}

	public static TypedNumber numberWithInt64(long l) {
		return new TypedNumber(l);
	}

	public static TypedNumber numberWithString(String s) throws NumberFormatException {
		try {
			return new TypedNumber(Long.parseLong(s));
		} catch (NumberFormatException e) {
			return new TypedNumber(Double.parseDouble(s));
		}
	}

	public byte byteValue() {
		return (byte) ((int) longValue());
	}

	public int compareTo(TypedNumber other) {
		return (!isInt64() || !other.isInt64()) ? Double.compare(doubleValue(), other.doubleValue()) : new Long(this.mInt64).compareTo(Long.valueOf(other.mInt64));
	}

	public double doubleValue() {
		return (isInt64()) ? (double) this.mInt64 : this.mDouble;
	}

	public boolean equals(Object other) {
		return other instanceof TypedNumber && compareTo((TypedNumber) other) == 0;
	}

	public float floatValue() {
		return (float) doubleValue();
	}

	public int hashCode() {
		return new Long(longValue()).hashCode();
	}

	public short int16Value() {
		return (short) ((int) longValue());
	}

	public int int32Value() {
		return (int) longValue();
	}

	public long int64Value() {
		return (isInt64()) ? this.mInt64 : (long) this.mDouble;
	}

	public int intValue() {
		return int32Value();
	}

	public boolean isDouble() {
		return !isInt64();
	}

	public boolean isInt64() {
		return this.mIsInt64;
	}

	public long longValue() {
		return int64Value();
	}

	public short shortValue() {
		return int16Value();
	}

	public String toString() {
		return (isInt64()) ? Long.toString(this.mInt64) : Double.toString(this.mDouble);
	}
}
