package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

class LazyField {
	private ByteString bytes;
	private final MessageLite defaultInstance;
	private final ExtensionRegistryLite extensionRegistry;
	private volatile boolean isDirty;
	private volatile MessageLite value;

	static class LazyEntry<K> implements Entry<K, Object> {
		private Entry<K, LazyField> entry;

		private LazyEntry(Entry<K, LazyField> entry) {
			this.entry = entry;
		}

		public LazyField getField() {
			return (LazyField) this.entry.getValue();
		}

		public K getKey() {
			return this.entry.getKey();
		}

		public Object getValue() {
			LazyField field = (LazyField) this.entry.getValue();
			return (field == null) ? null : field.getValue();
		}

		public Object setValue(Object value) {
			if (!((value instanceof MessageLite))) {
				throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
			} else {
				return ((LazyField) this.entry.getValue()).setValue((MessageLite) value);
			}
		}
	}

	static class LazyIterator<K> implements Iterator<Entry<K, Object>> {
		private Iterator<Entry<K, Object>> iterator;

		public LazyIterator(Iterator<Entry<K, Object>> iterator) {
			this.iterator = iterator;
		}

		public boolean hasNext() {
			return this.iterator.hasNext();
		}

		public Entry<K, Object> next() {
			Entry<K> entry = (Entry) this.iterator.next();
			if (entry.getValue() instanceof LazyField) {
				return new LazyField.LazyEntry(null);
			}
			return entry;
		}

		public void remove() {
			this.iterator.remove();
		}
	}


	public LazyField(MessageLite defaultInstance, ExtensionRegistryLite extensionRegistry, ByteString bytes) {
		this.isDirty = false;
		this.defaultInstance = defaultInstance;
		this.extensionRegistry = extensionRegistry;
		this.bytes = bytes;
	}

	private void ensureInitialized() {
		if (this.value != null) {
		} else {
			synchronized(this) {
				if (this.value != null) {
				} else {
					try {
						if (this.bytes != null) {
							this.value = (MessageLite) this.defaultInstance.getParserForType().parseFrom(this.bytes, this.extensionRegistry);
						}
					} catch (IOException e) {
					}
				}
			}
		}
	}

	public boolean equals(Object obj) {
		ensureInitialized();
		return this.value.equals(obj);
	}

	public int getSerializedSize() {
		return (this.isDirty) ? this.value.getSerializedSize() : this.bytes.size();
	}

	public MessageLite getValue() {
		ensureInitialized();
		return this.value;
	}

	public int hashCode() {
		ensureInitialized();
		return this.value.hashCode();
	}

	public MessageLite setValue(MessageLite value) {
		MessageLite originalValue = this.value;
		this.value = value;
		this.bytes = null;
		this.isDirty = true;
		return originalValue;
	}

	public ByteString toByteString() {
		if (!(this.isDirty)) {
			return this.bytes;
		} else {
			synchronized(this) {
				ByteString r0_ByteString;
				if (!(this.isDirty)) {
					r0_ByteString = this.bytes;
					return r0_ByteString;
				} else {
					this.bytes = this.value.toByteString();
					this.isDirty = false;
					r0_ByteString = this.bytes;
					return r0_ByteString;
				}
			}
		}
	}

	public String toString() {
		ensureInitialized();
		return this.value.toString();
	}
}
