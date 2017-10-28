package com.androidplot.util;

import java.util.List;

public interface ZIndexable {
    List elements();

    boolean moveAbove(Object obj, Object obj2);

    boolean moveBeneath(Object obj, Object obj2);

    boolean moveDown(Object obj);

    boolean moveToBottom(Object obj);

    boolean moveToTop(Object obj);

    boolean moveUp(Object obj);
}
