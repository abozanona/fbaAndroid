package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.ByteString.ByteIterator;
import java.util.NoSuchElementException;

class BoundedByteString extends LiteralByteString {
	private final int bytesLength;
	private final int bytesOffset;

	private class BoundedByteIterator implements ByteIterator {
		private final int limit;
		private int position;

		private BoundedByteIterator() {
			this.position = getOffsetIntoBytes();
			this.limit = this.position + size();
		}

		public boolean hasNext() {
			return this.position < this.limit;
		}

		public Byte next() {
			return Byte.valueOf(nextByte());
		}

		public byte nextByte() {
			if (this.position >= this.limit) {
				throw new NoSuchElementException();
			} else {
				byte[] r0_byte_A = bytes;
				int r1i = this.position;
				this.position = r1i + 1;
				return r0_byte_A[r1i];
			}
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}


	BoundedByteString(byte[] bytes, int offset, int length) {
		super(bytes);
		if (offset < 0) {
			throw new IllegalArgumentException("Offset too small: " + offset);
		} else if (length < 0) {
			throw new IllegalArgumentException("Length too small: " + offset);
		} else if (((long) offset) + ((long) length) > ((long) bytes.length)) {
			throw new IllegalArgumentException("Offset+Length too large: " + offset + "+" + length);
		} else {
			this.bytesOffset = offset;
			this.bytesLength = length;
		}
	}

	public byte byteAt(int index) {
		if (index < 0) {
			throw new ArrayIndexOutOfBoundsException("Index too small: " + index);
		} else if (index >= size()) {
			throw new ArrayIndexOutOfBoundsException("Index too large: " + index + ", " + size());
		} else {
			return this.bytes[this.bytesOffset + index];
		}
	}

	protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
		System.arraycopy(this.bytes, getOffsetIntoBytes() + sourceOffset, target, targetOffset, numberToCopy);
	}

	protected int getOffsetIntoBytes() {
		return this.bytesOffset;
	}

	public ByteIterator iterator() {
		return new BoundedByteIterator(null);
	}

	public int size() {
		return this.bytesLength;
	}
}
