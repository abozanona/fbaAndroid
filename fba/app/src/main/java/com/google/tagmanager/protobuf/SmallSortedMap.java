package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.FieldSet.FieldDescriptorLite;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
	private List<SmallSortedMap<K, V>> entryList;
	private boolean isImmutable;
	private volatile SmallSortedMap<K, V> lazyEntrySet;
	private final int maxArraySize;
	private Map<K, V> overflowEntries;

	static class AnonymousClass_1 extends SmallSortedMap<FieldDescriptorType, Object> {
		AnonymousClass_1(int x0) {
			super(null);
		}

		public void makeImmutable() {
			if (!isImmutable()) {
				java.util.Map.Entry<FieldDescriptorType, Object> entry;
				int i = 0;
				while (i < getNumArrayEntries()) {
					entry = getArrayEntryAt(i);
					if (((FieldDescriptorLite) entry.getKey()).isRepeated()) {
						entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
					}
					i++;
				}
				Iterator i$ = getOverflowEntries().iterator();
				while (i$.hasNext()) {
					entry = i$.next();
					if (((FieldDescriptorLite) entry.getKey()).isRepeated()) {
						entry.setValue(Collections.unmodifiableList(entry.getValue()));
					}
				}
			}
			super.makeImmutable();
		}

		public /* bridge */ /* synthetic */ Object put(Object x0, Object x1) {
			return super.put((FieldDescriptorLite) x0, x1);
		}
	}

	private static class EmptySet {
		private static final Iterable<Object> ITERABLE;
		private static final Iterator<Object> ITERATOR;


		static {
			ITERATOR = new Iterator<Object>() {
			public boolean hasNext() {
				return false;
			}

			public Object next() {
				throw new NoSuchElementException();
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
			ITERABLE = new Iterable<Object>() {
			public Iterator<Object> iterator() {
				return ITERATOR;
			}
		};
		}

		private EmptySet() {
		}

		static <T> Iterable<T> iterable() {
			return ITERABLE;
		}
	}

	private class Entry implements java.util.Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>> {
		private final K key;
		private V value;

		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		Entry(SmallSortedMap r3_SmallSortedMap, java.util.Map.Entry<K, V> copy) {
			this((Comparable) copy.getKey(), copy.getValue());
		}

		private boolean equals(Object o1, Object o2) {
			if (o1 == null) {
				return o2 == null;
			} else {
				return o1.equals(o2);
			}
		}

		public int compareTo(SmallSortedMap<K, V> other) {
			return getKey().compareTo(other.getKey());
		}

		public boolean equals(Object o) {
			if (o == this) {
				return true;
			} else if (!((o instanceof java.util.Map.Entry))) {
				return false;
			} else {
				java.util.Map.Entry other = (java.util.Map.Entry) o;
				if (!equals(this.key, other.getKey()) || !equals(this.value, other.getValue())) {
					return false;
				}
				return true;
			}
		}

		public K getKey() {
			return this.key;
		}

		public V getValue() {
			return this.value;
		}

		public int hashCode() {
			int r0i;
			int r1i = 0;
			r0i = (this.key == null) ? 0 : this.key.hashCode();
			if (this.value == null) {
				return r0i ^ r1i;
			} else {
				r1i = this.value.hashCode();
				return r0i ^ r1i;
			}
		}

		public V setValue(V newValue) {
			checkMutable();
			V oldValue = this.value;
			this.value = newValue;
			return oldValue;
		}

		public String toString() {
			return this.key + "=" + this.value;
		}
	}

	private class EntryIterator implements Iterator<java.util.Map.Entry<K, V>> {
		private Iterator<java.util.Map.Entry<K, V>> lazyOverflowIterator;
		private boolean nextCalledBeforeRemove;
		private int pos;

		private EntryIterator() {
			this.pos = -1;
		}

		private Iterator<java.util.Map.Entry<K, V>> getOverflowIterator() {
			if (this.lazyOverflowIterator == null) {
				this.lazyOverflowIterator = overflowEntries.entrySet().iterator();
			}
			return this.lazyOverflowIterator;
		}

		public boolean hasNext() {
			return this.pos + 1 < entryList.size() || getOverflowIterator().hasNext();
		}

		public java.util.Map.Entry<K, V> next() {
			this.nextCalledBeforeRemove = true;
			int r0i = this.pos + 1;
			this.pos = r0i;
			return (r0i < entryList.size()) ? (java.util.Map.Entry) entryList.get(this.pos) : (java.util.Map.Entry) getOverflowIterator().next();
		}

		public void remove() {
			if (!(this.nextCalledBeforeRemove)) {
				throw new IllegalStateException("remove() was called before next()");
			} else {
				this.nextCalledBeforeRemove = false;
				checkMutable();
				if (this.pos < entryList.size()) {
					SmallSortedMap r0_SmallSortedMap = ;
					int r1i = this.pos;
					this.pos = r1i - 1;
					r0_SmallSortedMap.removeArrayEntryAt(r1i);
					return;
				} else {
					getOverflowIterator().remove();
				}
			}
		}
	}

	private class EntrySet extends AbstractSet<java.util.Map.Entry<K, V>> {
		private EntrySet() {
		}

		public boolean add(java.util.Map.Entry<K, V> entry) {
			if (!contains(entry)) {
				put((Comparable) entry.getKey(), entry.getValue());
				return true;
			} else {
				return false;
			}
		}

		public void clear() {
			clear();
		}

		public boolean contains(Object o) {
			java.util.Map.Entry<K, V> entry = (java.util.Map.Entry) o;
			V existing = get(entry.getKey());
			V value = entry.getValue();
			if (existing != value) {
				if (existing == null || !existing.equals(value)) {
					return false;
				}
			}
			return true;
		}

		public Iterator<java.util.Map.Entry<K, V>> iterator() {
			return new SmallSortedMap.EntryIterator(null);
		}

		public boolean remove(Object o) {
			java.util.Map.Entry<K, V> entry = (java.util.Map.Entry) o;
			if (contains(entry)) {
				remove(entry.getKey());
				return true;
			} else {
				return false;
			}
		}

		public int size() {
			return size();
		}
	}


	private SmallSortedMap(int arraySize) {
		this.maxArraySize = arraySize;
		this.entryList = Collections.emptyList();
		this.overflowEntries = Collections.emptyMap();
	}

	private int binarySearchInArray(K key) {
		int cmp;
		int left = 0;
		int right = this.entryList.size() - 1;
		if (right >= 0) {
			cmp = key.compareTo(((Entry) this.entryList.get(right)).getKey());
			if (cmp > 0) {
				return -(right + 2);
			} else if (cmp == 0) {
				return right;
			}
		}
		while (left <= right) {
			int mid = (left + right) / 2;
			cmp = key.compareTo(((Entry) this.entryList.get(mid)).getKey());
			if (cmp < 0) {
				right = mid - 1;
			} else {
				if (cmp > 0) {
					left = mid + 1;
				}
				return mid;
			}
		}
		return -(left + 1);
	}

	private void checkMutable() {
		if (this.isImmutable) {
			throw new UnsupportedOperationException();
		}
	}

	private void ensureEntryArrayMutable() {
		checkMutable();
		if (!this.entryList.isEmpty() || this.entryList instanceof ArrayList) {
		} else {
			this.entryList = new ArrayList(this.maxArraySize);
		}
	}

	private SortedMap<K, V> getOverflowEntriesMutable() {
		checkMutable();
		if (!this.overflowEntries.isEmpty() || this.overflowEntries instanceof TreeMap) {
			return (SortedMap) this.overflowEntries;
		} else {
			this.overflowEntries = new TreeMap();
			return (SortedMap) this.overflowEntries;
		}
	}

	static <Type extends FieldDescriptorLite<FieldDescriptorType>> SmallSortedMap<FieldDescriptorType, Object> newFieldMap(int arraySize) {
		return new AnonymousClass_1(arraySize);
	}

	static <K extends Comparable<K>, V> SmallSortedMap<K, V> newInstanceForTest(int arraySize) {
		return new SmallSortedMap(arraySize);
	}

	private V removeArrayEntryAt(int index) {
		checkMutable();
		V removed = ((Entry) this.entryList.remove(index)).getValue();
		if (!this.overflowEntries.isEmpty()) {
			Iterator<java.util.Map.Entry<K, V>> iterator = getOverflowEntriesMutable().entrySet().iterator();
			this.entryList.add(new Entry(this, (java.util.Map.Entry) iterator.next()));
			iterator.remove();
		}
		return removed;
	}

	public void clear() {
		checkMutable();
		if (!this.entryList.isEmpty()) {
			this.entryList.clear();
		}
		if (!this.overflowEntries.isEmpty()) {
			this.overflowEntries.clear();
		}
	}

	public boolean containsKey(Object o) {
		K key = (Comparable) o;
		return binarySearchInArray(key) >= 0 || this.overflowEntries.containsKey(key);
	}

	public Set<java.util.Map.Entry<K, V>> entrySet() {
		if (this.lazyEntrySet == null) {
			this.lazyEntrySet = new EntrySet(null);
		}
		return this.lazyEntrySet;
	}

	public V get(Object o) {
		K key = (Comparable) o;
		int index = binarySearchInArray(key);
		return (index >= 0) ? ((Entry) this.entryList.get(index)).getValue() : this.overflowEntries.get(key);
	}

	public java.util.Map.Entry<K, V> getArrayEntryAt(int index) {
		return (java.util.Map.Entry) this.entryList.get(index);
	}

	public int getNumArrayEntries() {
		return this.entryList.size();
	}

	public int getNumOverflowEntries() {
		return this.overflowEntries.size();
	}

	public Iterable<java.util.Map.Entry<K, V>> getOverflowEntries() {
		return (this.overflowEntries.isEmpty()) ? EmptySet.iterable() : this.overflowEntries.entrySet();
	}

	public boolean isImmutable() {
		return this.isImmutable;
	}

	public void makeImmutable() {
		if (!(this.isImmutable)) {
			this.overflowEntries = (this.overflowEntries.isEmpty()) ? Collections.emptyMap() : Collections.unmodifiableMap(this.overflowEntries);
			this.isImmutable = true;
		}
	}

	public V put(K key, V value) {
		checkMutable();
		int index = binarySearchInArray(key);
		if (index >= 0) {
			return ((Entry) this.entryList.get(index)).setValue(value);
		} else {
			ensureEntryArrayMutable();
			int insertionPoint = -(index + 1);
			if (insertionPoint >= this.maxArraySize) {
				return getOverflowEntriesMutable().put(key, value);
			} else {
				if (this.entryList.size() == this.maxArraySize) {
					Object lastEntryInArray = (Entry) this.entryList.remove(this.maxArraySize - 1);
					getOverflowEntriesMutable().put(lastEntryInArray.getKey(), lastEntryInArray.getValue());
				}
				this.entryList.add(insertionPoint, new Entry(key, value));
				return null;
			}
		}
	}

	public V remove(Object o) {
		checkMutable();
		K key = (Comparable) o;
		int index = binarySearchInArray(key);
		if (index >= 0) {
			return removeArrayEntryAt(index);
		} else if (this.overflowEntries.isEmpty()) {
			return null;
		} else {
			return this.overflowEntries.remove(key);
		}
	}

	public int size() {
		return this.entryList.size() + this.overflowEntries.size();
	}
}
