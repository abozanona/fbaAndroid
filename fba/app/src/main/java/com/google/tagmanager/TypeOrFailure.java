package com.google.tagmanager;

import com.google.tagmanager.LoadCallback.Failure;

class TypeOrFailure<T> {
	private Failure mFailure;
	private T mType;

	public TypeOrFailure(Failure failure) {
		this.mFailure = failure;
	}

	public TypeOrFailure(T type) {
		this.mType = type;
	}

	public Failure getFailure() {
		return this.mFailure;
	}

	public T getType() {
		return this.mType;
	}
}
