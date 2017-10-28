package com.google.tagmanager;

interface Cache<K, V> {
	public V get(K r1_K);

	public void put(K r1_K, V r2_V);
}
