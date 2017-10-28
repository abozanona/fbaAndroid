package com.androidplot.xy;

import android.graphics.PointF;
import android.graphics.RectF;
import com.androidplot.LineRegion;
import com.androidplot.util.ValPixConverter;
import java.util.ArrayList;
import java.util.List;

public class RectRegion {
    private LineRegion f620a;
    private LineRegion f621b;
    private String f622c;

    public RectRegion(Number number, Number number2, Number number3, Number number4) {
        this(number, number2, number3, number4, null);
    }

    public RectRegion(Number number, Number number2, Number number3, Number number4, String str) {
        this.f620a = new LineRegion(number, number2);
        this.f621b = new LineRegion(number3, number4);
        setLabel(str);
    }

    public static List regionsWithin(List list, Number number, Number number2, Number number3, Number number4) {
        List arrayList = new ArrayList();
        for (RectRegion rectRegion : list) {
            if (rectRegion.intersects(number, number2, number3, number4)) {
                arrayList.add(rectRegion);
            }
        }
        return arrayList;
    }

    public boolean containsDomainValue(Number number) {
        return this.f620a.contains(number);
    }

    public boolean containsPoint(PointF pointF) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public boolean containsRangeValue(Number number) {
        return this.f621b.contains(number);
    }

    public boolean containsValue(Number number, Number number2) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public String getLabel() {
        return this.f622c;
    }

    public Number getMaxX() {
        return this.f620a.getMaxVal();
    }

    public Number getMaxY() {
        return this.f621b.getMaxVal();
    }

    public Number getMinX() {
        return this.f620a.getMinVal();
    }

    public Number getMinY() {
        return this.f621b.getMinVal();
    }

    public RectF getRectF(RectF rectF, Number number, Number number2, Number number3, Number number4) {
        PointF valToPix = ValPixConverter.valToPix(this.f620a.getMinVal().doubleValue() != Double.NEGATIVE_INFINITY ? this.f620a.getMinVal() : number, this.f621b.getMaxVal().doubleValue() != Double.POSITIVE_INFINITY ? this.f621b.getMaxVal() : number4, rectF, number, number2, number3, number4);
        PointF valToPix2 = ValPixConverter.valToPix(this.f620a.getMaxVal().doubleValue() != Double.POSITIVE_INFINITY ? this.f620a.getMaxVal() : number2, this.f621b.getMinVal().doubleValue() != Double.NEGATIVE_INFINITY ? this.f621b.getMinVal() : number3, rectF, number, number2, number3, number4);
        return new RectF(valToPix.x, valToPix.y, valToPix2.x, valToPix2.y);
    }

    public boolean intersects(RectF rectF, Number number, Number number2, Number number3, Number number4) {
        return RectF.intersects(getRectF(rectF, Double.valueOf(number.doubleValue()), Double.valueOf(number2.doubleValue()), Double.valueOf(number3.doubleValue()), Double.valueOf(number4.doubleValue())), rectF);
    }

    public boolean intersects(RectRegion rectRegion) {
        return intersects(rectRegion.getMinX(), rectRegion.getMaxX(), rectRegion.getMinY(), rectRegion.getMaxY());
    }

    public boolean intersects(Number number, Number number2, Number number3, Number number4) {
        return this.f620a.intersects(number, number2) && this.f621b.intersects(number3, number4);
    }

    public void setLabel(String str) {
        this.f622c = str;
    }

    public void setMaxX(Number number) {
        this.f620a.setMaxVal(number);
    }

    public void setMaxY(Number number) {
        this.f621b.setMaxVal(number);
    }

    public void setMinX(double d) {
        this.f620a.setMinVal(Double.valueOf(d));
    }

    public void setMinY(Number number) {
        this.f621b.setMinVal(number);
    }
}
