package com.google.tagmanager;

class er extends Number implements Comparable {
    private double f1155a;
    private long f1156b;
    private boolean f1157c = false;

    private er(double d) {
        this.f1155a = d;
    }

    private er(long j) {
        this.f1156b = j;
    }

    public static er m1657a(long j) {
        return new er(j);
    }

    public static er m1658a(Double d) {
        return new er(d.doubleValue());
    }

    public static er m1659a(String str) {
        try {
            return new er(Long.parseLong(str));
        } catch (NumberFormatException e) {
            try {
                return new er(Double.parseDouble(str));
            } catch (NumberFormatException e2) {
                throw new NumberFormatException(str + " is not a valid TypedNumber");
            }
        }
    }

    public int m1660a(er erVar) {
        return (m1662b() && erVar.m1662b()) ? new Long(this.f1156b).compareTo(Long.valueOf(erVar.f1156b)) : Double.compare(doubleValue(), erVar.doubleValue());
    }

    public boolean m1661a() {
        return !m1662b();
    }

    public boolean m1662b() {
        return this.f1157c;
    }

    public byte byteValue() {
        return (byte) ((int) longValue());
    }

    public long m1663c() {
        return m1662b() ? this.f1156b : (long) this.f1155a;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m1660a((er) obj);
    }

    public int m1664d() {
        return (int) longValue();
    }

    public double doubleValue() {
        return m1662b() ? (double) this.f1156b : this.f1155a;
    }

    public short m1665e() {
        return (short) ((int) longValue());
    }

    public boolean equals(Object obj) {
        return (obj instanceof er) && m1660a((er) obj) == 0;
    }

    public float floatValue() {
        return (float) doubleValue();
    }

    public int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public int intValue() {
        return m1664d();
    }

    public long longValue() {
        return m1663c();
    }

    public short shortValue() {
        return m1665e();
    }

    public String toString() {
        return m1662b() ? Long.toString(this.f1156b) : Double.toString(this.f1155a);
    }
}
