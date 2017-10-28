package com.google.tagmanager;

interface LoadCallback<T> {
	public static enum Failure {
		NOT_AVAILABLE,
		IO_ERROR,
		SERVER_ERROR;

	}


	public void onFailure(Failure r1_Failure);

	public void onSuccess(T r1_T);

	public void startLoad();
}
