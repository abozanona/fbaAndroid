package com.androidplot.util;

import java.util.List;
import java.util.Set;

public abstract class MultiSynch {

    public interface Action {
        void run(Object[] objArr);
    }

    private static void m979a(Object[] objArr, Object[] objArr2, Action action, int i) {
        if (objArr2 != null) {
            synchronized (objArr2[i]) {
                if (i < objArr2.length - 1) {
                    m979a(objArr, objArr2, action, i + 1);
                } else {
                    action.run(objArr);
                }
            }
        }
        action.run(objArr);
    }

    public static void run(Object[] objArr, List list, Action action) {
        m979a(objArr, list.toArray(), action, 0);
    }

    public static void run(Object[] objArr, Set set, Action action) {
        m979a(objArr, set.toArray(), action, 0);
    }

    public static void run(Object[] objArr, Object[] objArr2, Action action) {
        m979a(objArr, objArr2, action, 0);
    }
}
