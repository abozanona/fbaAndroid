package com.google.tagmanager.protobuf;

import java.util.Collection;
import java.util.List;

public interface LazyStringList extends List<String> {
	public void add(ByteString r1_ByteString);

	public void add(byte[] r1_byte_A);

	public boolean addAllByteArray(Collection<byte[]> r1_Collection_byte_A);

	public boolean addAllByteString(Collection<ByteString> r1_Collection_ByteString);

	public List<byte[]> asByteArrayList();

	public byte[] getByteArray(int r1i);

	public ByteString getByteString(int r1i);

	public List<?> getUnderlyingElements();

	public void mergeFrom(LazyStringList r1_LazyStringList);

	public void set(int r1i, ByteString r2_ByteString);

	public void set(int r1i, byte[] r2_byte_A);
}
