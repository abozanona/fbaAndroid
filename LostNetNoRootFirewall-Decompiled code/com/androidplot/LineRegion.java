package com.androidplot;

public class LineRegion {
    private Number f443a;
    private Number f444b;

    public LineRegion(Number number, Number number2) {
        if (number.doubleValue() < number2.doubleValue()) {
            setMinVal(number);
            setMaxVal(number2);
            return;
        }
        setMinVal(number2);
        setMaxVal(number);
    }

    public static Number measure(Number number, Number number2) {
        return new LineRegion(number, number2).length();
    }

    public boolean contains(Number number) {
        return number.doubleValue() >= this.f443a.doubleValue() && number.doubleValue() <= this.f444b.doubleValue();
    }

    public Number getMaxVal() {
        return this.f444b;
    }

    public Number getMinVal() {
        return this.f443a;
    }

    public boolean intersects(LineRegion lineRegion) {
        return intersects(lineRegion.getMinVal(), lineRegion.getMaxVal());
    }

    public boolean intersects(Number number, Number number2) {
        return (number.doubleValue() <= this.f443a.doubleValue() && number2.doubleValue() >= this.f444b.doubleValue()) || contains(number) || contains(number2);
    }

    public Number length() {
        return Double.valueOf(this.f444b.doubleValue() - this.f443a.doubleValue());
    }

    public void setMaxVal(Number number) {
        if (number == null) {
            throw new NullPointerException("Region values can never be null.");
        }
        this.f444b = number;
    }

    public void setMinVal(Number number) {
        if (number == null) {
            throw new NullPointerException("Region values can never be null.");
        }
        this.f443a = number;
    }
}
