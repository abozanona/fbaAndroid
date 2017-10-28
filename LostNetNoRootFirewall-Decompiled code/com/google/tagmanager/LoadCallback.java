package com.google.tagmanager;

interface LoadCallback {

    public enum Failure {
        NOT_AVAILABLE,
        IO_ERROR,
        SERVER_ERROR
    }

    void mo676a();

    void mo677a(Failure failure);

    void mo678a(Object obj);
}
