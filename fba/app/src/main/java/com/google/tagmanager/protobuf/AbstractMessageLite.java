package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.ByteString.CodedBuilder;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractMessageLite implements MessageLite {
	protected int memoizedHashCode;

	public static abstract class Builder<Type extends AbstractMessageLite.Builder> implements MessageLite.Builder {
		static final class LimitedInputStream extends FilterInputStream {
			private int limit;

			LimitedInputStream(InputStream in, int limit) {
				super(in);
				this.limit = limit;
			}

			public int available() throws IOException {
				return Math.min(super.available(), this.limit);
			}

			public int read() throws IOException {
				if (this.limit <= 0) {
					return -1;
				} else {
					int result = super.read();
					if (result >= 0) {
						this.limit--;
						return result;
					}
					return result;
				}
			}

			public int read(byte[] b, int off, int len) throws IOException {
				if (this.limit <= 0) {
					return -1;
				} else {
					int result = super.read(b, off, Math.min(len, this.limit));
					if (result >= 0) {
						this.limit -= result;
						return result;
					}
					return result;
				}
			}

			public long skip(long n) throws IOException {
				long result = super.skip(Math.min(n, (long) this.limit));
				if (result >= 0) {
					this.limit = (int) (((long) this.limit) - result);
				}
				return result;
			}
		}


		protected static <T> void addAll(Iterable<T> values, Collection<T> list) {
			if (values instanceof LazyStringList) {
				checkForNullValues(((LazyStringList) values).getUnderlyingElements());
				list.addAll((Collection) values);
				return;
			} else if (values instanceof Collection) {
				checkForNullValues(values);
				list.addAll((Collection) values);
				return;
			} else {
				Iterator i$ = values.iterator();
				while (i$.hasNext()) {
					T value = i$.next();
					if (value == null) {
						throw new NullPointerException();
					} else {
						list.add(value);
					}
				}
			}
		}

		private static void checkForNullValues(Iterable<?> values) {
			Iterator i$ = values.iterator();
			while (i$.hasNext()) {
				if (i$.next() == null) {
					throw new NullPointerException();
				}
			}
		}

		protected static UninitializedMessageException newUninitializedMessageException(MessageLite message) {
			return new UninitializedMessageException(message);
		}

		public abstract BuilderType clone();

		public boolean mergeDelimitedFrom(InputStream input) throws IOException {
			return mergeDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());
		}

		public boolean mergeDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			int firstByte = input.read();
			if (firstByte == -1) {
				return false;
			} else {
				mergeFrom(new LimitedInputStream(input, CodedInputStream.readRawVarint32(firstByte, input)), extensionRegistry);
				return true;
			}
		}

		public BuilderType mergeFrom(ByteString data) throws InvalidProtocolBufferException {
			try {
				CodedInputStream input = data.newCodedInput();
				mergeFrom(input);
				input.checkLastTagWas(0);
				return this;
			} catch (InvalidProtocolBufferException e) {
				throw e;
			} catch (IOException e_2) {
				throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e_2);
			}
		}

		public BuilderType mergeFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			try {
				CodedInputStream input = data.newCodedInput();
				mergeFrom(input, extensionRegistry);
				input.checkLastTagWas(0);
				return this;
			} catch (InvalidProtocolBufferException e) {
				throw e;
			} catch (IOException e_2) {
				throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e_2);
			}
		}

		public BuilderType mergeFrom(CodedInputStream input) throws IOException {
			return mergeFrom(input, ExtensionRegistryLite.getEmptyRegistry());
		}

		public abstract BuilderType mergeFrom(CodedInputStream r1_CodedInputStream, ExtensionRegistryLite r2_ExtensionRegistryLite) throws IOException;

		public BuilderType mergeFrom(InputStream input) throws IOException {
			CodedInputStream codedInput = CodedInputStream.newInstance(input);
			mergeFrom(codedInput);
			codedInput.checkLastTagWas(0);
			return this;
		}

		public BuilderType mergeFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
			CodedInputStream codedInput = CodedInputStream.newInstance(input);
			mergeFrom(codedInput, extensionRegistry);
			codedInput.checkLastTagWas(0);
			return this;
		}

		public BuilderType mergeFrom(byte[] data) throws InvalidProtocolBufferException {
			return mergeFrom(data, 0, data.length);
		}

		public BuilderType mergeFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
			try {
				CodedInputStream input = CodedInputStream.newInstance(data, off, len);
				mergeFrom(input);
				input.checkLastTagWas(0);
				return this;
			} catch (InvalidProtocolBufferException e) {
				throw e;
			} catch (IOException e_2) {
				throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e_2);
			}
		}

		public BuilderType mergeFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			try {
				CodedInputStream input = CodedInputStream.newInstance(data, off, len);
				mergeFrom(input, extensionRegistry);
				input.checkLastTagWas(0);
				return this;
			} catch (InvalidProtocolBufferException e) {
				throw e;
			} catch (IOException e_2) {
				throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e_2);
			}
		}

		public BuilderType mergeFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
			return mergeFrom(data, 0, data.length, extensionRegistry);
		}
	}


	public AbstractMessageLite() {
		this.memoizedHashCode = 0;
	}

	protected static void checkByteStringIsUtf8(ByteString byteString) throws IllegalArgumentException {
		if (!byteString.isValidUtf8()) {
			throw new IllegalArgumentException("Byte string is not UTF-8.");
		}
	}

	public MutableMessageLite mutableCopy() {
		throw new UnsupportedOperationException("mutableCopy() is not implemented.");
	}

	UninitializedMessageException newUninitializedMessageException() {
		return new UninitializedMessageException((MessageLite)this);
	}

	public byte[] toByteArray() {
		try {
			byte[] result = new byte[getSerializedSize()];
			CodedOutputStream output = CodedOutputStream.newInstance(result);
			writeTo(output);
			output.checkNoSpaceLeft();
			return result;
		} catch (IOException e) {
			throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
		}
	}

	public ByteString toByteString() {
		try {
			CodedBuilder out = ByteString.newCodedBuilder(getSerializedSize());
			writeTo(out.getCodedOutput());
			return out.build();
		} catch (IOException e) {
			throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
		}
	}

	public void writeDelimitedTo(OutputStream output) throws IOException {
		int serialized = getSerializedSize();
		CodedOutputStream codedOutput = CodedOutputStream.newInstance(output, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(serialized) + serialized));
		codedOutput.writeRawVarint32(serialized);
		writeTo(codedOutput);
		codedOutput.flush();
	}

	public void writeTo(OutputStream output) throws IOException {
		CodedOutputStream codedOutput = CodedOutputStream.newInstance(output, CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
		writeTo(codedOutput);
		codedOutput.flush();
	}
}
