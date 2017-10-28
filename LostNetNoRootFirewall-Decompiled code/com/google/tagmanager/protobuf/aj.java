package com.google.tagmanager.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class aj implements Iterator {
    aj() {
    }

    public boolean hasNext() {
        return false;
    }

    public Object next() {
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
