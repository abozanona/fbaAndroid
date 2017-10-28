package com.google.tagmanager.protobuf;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class ac {
    private final Deque f1204a;

    private ac() {
        this.f1204a = new ArrayDeque(aa.f1197a.length);
    }

    private int m1770a(int i) {
        int binarySearch = Arrays.binarySearch(aa.f1197a, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    private ByteString m1771a(ByteString byteString, ByteString byteString2) {
        m1773a(byteString);
        m1773a(byteString2);
        ByteString byteString3 = (ByteString) this.f1204a.pop();
        while (!this.f1204a.isEmpty()) {
            byteString3 = new aa((ByteString) this.f1204a.pop(), byteString3);
        }
        return byteString3;
    }

    private void m1773a(ByteString byteString) {
        if (byteString.isBalanced()) {
            m1774b(byteString);
        } else if (byteString instanceof aa) {
            aa aaVar = (aa) byteString;
            m1773a(aaVar.f1199c);
            m1773a(aaVar.f1200d);
        } else {
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
        }
    }

    private void m1774b(ByteString byteString) {
        int a = m1770a(byteString.size());
        int i = aa.f1197a[a + 1];
        if (this.f1204a.isEmpty() || ((ByteString) this.f1204a.peek()).size() >= i) {
            this.f1204a.push(byteString);
            return;
        }
        int i2 = aa.f1197a[a];
        ByteString byteString2 = (ByteString) this.f1204a.pop();
        while (!this.f1204a.isEmpty() && ((ByteString) this.f1204a.peek()).size() < i2) {
            byteString2 = new aa((ByteString) this.f1204a.pop(), byteString2);
        }
        byteString2 = new aa(byteString2, byteString);
        while (!this.f1204a.isEmpty()) {
            if (((ByteString) this.f1204a.peek()).size() >= aa.f1197a[m1770a(byteString2.size()) + 1]) {
                break;
            }
            byteString2 = new aa((ByteString) this.f1204a.pop(), byteString2);
        }
        this.f1204a.push(byteString2);
    }
}
