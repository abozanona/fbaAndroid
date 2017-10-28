package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;
import com.google.tagmanager.protobuf.MessageLite.Builder;
import com.google.tagmanager.protobuf.WireFormat.FieldType;
import com.google.tagmanager.protobuf.WireFormat.JavaType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class FieldSet {
    private static final FieldSet f1192d = new FieldSet(true);
    private final ag f1193a = ag.m1783a(16);
    private boolean f1194b;
    private boolean f1195c = false;

    public interface FieldDescriptorLite extends Comparable {
        EnumLiteMap getEnumType();

        JavaType getLiteJavaType();

        FieldType getLiteType();

        int getNumber();

        Builder internalMergeFrom(Builder builder, MessageLite messageLite);

        MutableMessageLite internalMergeFrom(MutableMessageLite mutableMessageLite, MutableMessageLite mutableMessageLite2);

        boolean isPacked();

        boolean isRepeated();
    }

    private FieldSet() {
    }

    private FieldSet(boolean z) {
        m1752c();
    }

    private static int m1728a(FieldType fieldType, int i, Object obj) {
        int computeTagSize = CodedOutputStream.computeTagSize(i);
        int i2 = (fieldType != FieldType.GROUP || Internal.isProto1Group((MessageLite) obj)) ? computeTagSize : computeTagSize * 2;
        return i2 + m1737b(fieldType, obj);
    }

    static int m1729a(FieldType fieldType, boolean z) {
        return z ? 2 : fieldType.getWireType();
    }

    public static FieldSet m1730a() {
        return new FieldSet();
    }

    public static Object m1731a(CodedInputStream codedInputStream, FieldType fieldType, boolean z) {
        switch (C0250m.f1255b[fieldType.ordinal()]) {
            case 1:
                return Double.valueOf(codedInputStream.readDouble());
            case 2:
                return Float.valueOf(codedInputStream.readFloat());
            case 3:
                return Long.valueOf(codedInputStream.readInt64());
            case 4:
                return Long.valueOf(codedInputStream.readUInt64());
            case 5:
                return Integer.valueOf(codedInputStream.readInt32());
            case 6:
                return Long.valueOf(codedInputStream.readFixed64());
            case 7:
                return Integer.valueOf(codedInputStream.readFixed32());
            case 8:
                return Boolean.valueOf(codedInputStream.readBool());
            case 9:
                return z ? codedInputStream.readStringRequireUtf8() : codedInputStream.readString();
            case 10:
                return codedInputStream.readBytes();
            case 11:
                return Integer.valueOf(codedInputStream.readUInt32());
            case 12:
                return Integer.valueOf(codedInputStream.readSFixed32());
            case 13:
                return Long.valueOf(codedInputStream.readSFixed64());
            case 14:
                return Integer.valueOf(codedInputStream.readSInt32());
            case 15:
                return Long.valueOf(codedInputStream.readSInt64());
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static void m1732a(CodedOutputStream codedOutputStream, FieldType fieldType, int i, Object obj) {
        if (fieldType != FieldType.GROUP) {
            codedOutputStream.writeTag(i, m1729a(fieldType, false));
            m1733a(codedOutputStream, fieldType, obj);
        } else if (Internal.isProto1Group((MessageLite) obj)) {
            codedOutputStream.writeTag(i, 3);
            codedOutputStream.writeGroupNoTag((MessageLite) obj);
        } else {
            codedOutputStream.writeGroup(i, (MessageLite) obj);
        }
    }

    private static void m1733a(CodedOutputStream codedOutputStream, FieldType fieldType, Object obj) {
        switch (C0250m.f1255b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.writeDoubleNoTag(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.writeFloatNoTag(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.writeInt64NoTag(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.writeBoolNoTag(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.writeStringNoTag((String) obj);
                return;
            case 10:
                if (obj instanceof ByteString) {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.writeByteArrayNoTag((byte[]) obj);
                    return;
                }
            case 11:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                return;
            case 12:
                codedOutputStream.writeSFixed32NoTag(((Integer) obj).intValue());
                return;
            case 13:
                codedOutputStream.writeSFixed64NoTag(((Long) obj).longValue());
                return;
            case 14:
                codedOutputStream.writeSInt32NoTag(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.writeSInt64NoTag(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.writeGroupNoTag((MessageLite) obj);
                return;
            case 17:
                codedOutputStream.writeMessageNoTag((MessageLite) obj);
                return;
            case 18:
                if (obj instanceof EnumLite) {
                    codedOutputStream.writeEnumNoTag(((EnumLite) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.writeEnumNoTag(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static void m1734a(FieldDescriptorLite fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) {
        FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.isRepeated()) {
            List<Object> list = (List) obj;
            if (fieldDescriptorLite.isPacked()) {
                codedOutputStream.writeTag(number, 2);
                number = 0;
                for (Object b : list) {
                    number += m1737b(liteType, b);
                }
                codedOutputStream.writeRawVarint32(number);
                for (Object a : list) {
                    m1733a(codedOutputStream, liteType, a);
                }
                return;
            }
            for (Object b2 : list) {
                m1732a(codedOutputStream, liteType, number, b2);
            }
        } else if (obj instanceof C0256s) {
            m1732a(codedOutputStream, liteType, number, ((C0256s) obj).m1835a());
        } else {
            m1732a(codedOutputStream, liteType, number, obj);
        }
    }

    private static void m1735a(FieldType fieldType, Object obj) {
        boolean z = false;
        if (obj == null) {
            throw new NullPointerException();
        }
        switch (C0250m.f1254a[fieldType.getJavaType().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if ((obj instanceof ByteString) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case 8:
                if ((obj instanceof Integer) || (obj instanceof EnumLite)) {
                    z = true;
                    break;
                }
            case 9:
                if ((obj instanceof MessageLite) || (obj instanceof C0256s)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private boolean m1736a(Entry entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        if (fieldDescriptorLite.getLiteJavaType() == JavaType.MESSAGE) {
            if (fieldDescriptorLite.isRepeated()) {
                for (MessageLite isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            }
            Object value = entry.getValue();
            if (value instanceof MessageLite) {
                if (!((MessageLite) value).isInitialized()) {
                    return false;
                }
            } else if (value instanceof C0256s) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    private static int m1737b(FieldType fieldType, Object obj) {
        switch (C0250m.f1255b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 10:
                return obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeByteArraySizeNoTag((byte[]) obj);
            case 11:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 12:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) obj).intValue());
            case 13:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) obj).longValue());
            case 14:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) obj);
            case 17:
                return obj instanceof C0256s ? CodedOutputStream.computeLazyFieldSizeNoTag((C0256s) obj) : CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            case 18:
                return obj instanceof EnumLite ? CodedOutputStream.computeEnumSizeNoTag(((EnumLite) obj).getNumber()) : CodedOutputStream.computeEnumSizeNoTag(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static FieldSet m1738b() {
        return f1192d;
    }

    public static Object m1739b(CodedInputStream codedInputStream, FieldType fieldType, boolean z) {
        return fieldType == FieldType.BYTES ? codedInputStream.readByteArray() : m1731a(codedInputStream, fieldType, z);
    }

    private void m1740b(Entry entry) {
        Comparable comparable = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof C0256s) {
            value = ((C0256s) value).m1835a();
        }
        Object b;
        if (comparable.isRepeated()) {
            b = m1750b((FieldDescriptorLite) comparable);
            if (b == null) {
                this.f1193a.m1792a(comparable, new ArrayList((List) value));
            } else {
                ((List) b).addAll((List) value);
            }
        } else if (comparable.getLiteJavaType() == JavaType.MESSAGE) {
            b = m1750b((FieldDescriptorLite) comparable);
            if (b == null) {
                this.f1193a.m1792a(comparable, value);
            } else {
                this.f1193a.m1792a(comparable, b instanceof MutableMessageLite ? comparable.internalMergeFrom((MutableMessageLite) b, (MutableMessageLite) value) : comparable.internalMergeFrom(((MessageLite) b).toBuilder(), (MessageLite) value).build());
            }
        } else {
            this.f1193a.m1792a(comparable, value);
        }
    }

    public static int m1741c(FieldDescriptorLite fieldDescriptorLite, Object obj) {
        int i = 0;
        FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (!fieldDescriptorLite.isRepeated()) {
            return m1728a(liteType, number, obj);
        }
        if (fieldDescriptorLite.isPacked()) {
            for (Object b : (List) obj) {
                i += m1737b(liteType, b);
            }
            return CodedOutputStream.computeRawVarint32Size(i) + (CodedOutputStream.computeTagSize(number) + i);
        }
        for (Object b2 : (List) obj) {
            i += m1728a(liteType, number, b2);
        }
        return i;
    }

    private int m1742c(Entry entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        return (fieldDescriptorLite.getLiteJavaType() != JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) ? m1741c(fieldDescriptorLite, value) : value instanceof C0256s ? CodedOutputStream.computeLazyFieldMessageSetExtensionSize(((FieldDescriptorLite) entry.getKey()).getNumber(), (C0256s) value) : CodedOutputStream.computeMessageSetExtensionSize(((FieldDescriptorLite) entry.getKey()).getNumber(), (MessageLite) value);
    }

    private Object m1743d(FieldDescriptorLite fieldDescriptorLite, Object obj) {
        List arrayList;
        if (fieldDescriptorLite.getLiteJavaType() == JavaType.MESSAGE) {
            if (!fieldDescriptorLite.isRepeated()) {
                return obj instanceof C0256s ? ((MutableMessageLite) ((C0256s) obj).m1835a()).immutableCopy() : ((MutableMessageLite) obj).immutableCopy();
            } else {
                List<MutableMessageLite> list = (List) obj;
                arrayList = new ArrayList();
                for (MutableMessageLite immutableCopy : list) {
                    arrayList.add(immutableCopy.immutableCopy());
                }
                return arrayList;
            }
        } else if (fieldDescriptorLite.getLiteJavaType() != JavaType.BYTE_STRING) {
            return obj;
        } else {
            if (!fieldDescriptorLite.isRepeated()) {
                return ByteString.copyFrom((byte[]) obj);
            }
            List<byte[]> list2 = (List) obj;
            arrayList = new ArrayList();
            for (byte[] copyFrom : list2) {
                arrayList.add(ByteString.copyFrom(copyFrom));
            }
            return arrayList;
        }
    }

    private Object m1744e(FieldDescriptorLite fieldDescriptorLite, Object obj) {
        List arrayList;
        if (fieldDescriptorLite.getLiteJavaType() == JavaType.MESSAGE) {
            if (!fieldDescriptorLite.isRepeated()) {
                return obj instanceof C0256s ? ((C0256s) obj).m1835a().mutableCopy() : ((MessageLite) obj).mutableCopy();
            } else {
                arrayList = new ArrayList();
                for (MessageLite mutableCopy : (List) obj) {
                    arrayList.add(mutableCopy.mutableCopy());
                }
                return arrayList;
            }
        } else if (fieldDescriptorLite.getLiteJavaType() != JavaType.BYTE_STRING) {
            return obj;
        } else {
            if (!fieldDescriptorLite.isRepeated()) {
                return ((ByteString) obj).toByteArray();
            }
            List<ByteString> list = (List) obj;
            arrayList = new ArrayList();
            for (ByteString toByteArray : list) {
                arrayList.add(toByteArray.toByteArray());
            }
            return arrayList;
        }
    }

    public Object m1745a(FieldDescriptorLite fieldDescriptorLite, int i) {
        if (fieldDescriptorLite.isRepeated()) {
            Object b = m1750b(fieldDescriptorLite);
            if (b != null) {
                return ((List) b).get(i);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void m1746a(FieldDescriptorLite fieldDescriptorLite, int i, Object obj) {
        if (fieldDescriptorLite.isRepeated()) {
            Object b = m1750b(fieldDescriptorLite);
            if (b == null) {
                throw new IndexOutOfBoundsException();
            }
            m1735a(fieldDescriptorLite.getLiteType(), obj);
            ((List) b).set(i, obj);
            return;
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void m1747a(FieldDescriptorLite fieldDescriptorLite, Object obj) {
        if (!fieldDescriptorLite.isRepeated()) {
            m1735a(fieldDescriptorLite.getLiteType(), obj);
        } else if (obj instanceof List) {
            List<Object> arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            for (Object a : arrayList) {
                m1735a(fieldDescriptorLite.getLiteType(), a);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof C0256s) {
            this.f1195c = true;
        }
        this.f1193a.m1792a((Comparable) fieldDescriptorLite, obj);
    }

    public void m1748a(FieldSet fieldSet) {
        for (int i = 0; i < fieldSet.f1193a.m1796c(); i++) {
            m1740b(fieldSet.f1193a.m1794b(i));
        }
        for (Entry b : fieldSet.f1193a.m1797d()) {
            m1740b(b);
        }
    }

    public boolean m1749a(FieldDescriptorLite fieldDescriptorLite) {
        if (!fieldDescriptorLite.isRepeated()) {
            return this.f1193a.get(fieldDescriptorLite) != null;
        } else {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
    }

    public Object m1750b(FieldDescriptorLite fieldDescriptorLite) {
        Object obj = this.f1193a.get(fieldDescriptorLite);
        return obj instanceof C0256s ? ((C0256s) obj).m1835a() : obj;
    }

    public void m1751b(FieldDescriptorLite fieldDescriptorLite, Object obj) {
        if (fieldDescriptorLite.isRepeated()) {
            List arrayList;
            m1735a(fieldDescriptorLite.getLiteType(), obj);
            Object b = m1750b(fieldDescriptorLite);
            if (b == null) {
                arrayList = new ArrayList();
                this.f1193a.m1792a((Comparable) fieldDescriptorLite, (Object) arrayList);
            } else {
                arrayList = (List) b;
            }
            arrayList.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public void m1752c() {
        if (!this.f1194b) {
            this.f1193a.mo716a();
            this.f1194b = true;
        }
    }

    public void m1753c(FieldDescriptorLite fieldDescriptorLite) {
        this.f1193a.remove(fieldDescriptorLite);
        if (this.f1193a.isEmpty()) {
            this.f1195c = false;
        }
    }

    public /* synthetic */ Object clone() {
        return m1756e();
    }

    public int m1754d(FieldDescriptorLite fieldDescriptorLite) {
        if (fieldDescriptorLite.isRepeated()) {
            Object b = m1750b(fieldDescriptorLite);
            return b == null ? 0 : ((List) b).size();
        } else {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
    }

    public boolean m1755d() {
        return this.f1194b;
    }

    public FieldSet m1756e() {
        FieldSet a = m1730a();
        for (int i = 0; i < this.f1193a.m1796c(); i++) {
            Entry b = this.f1193a.m1794b(i);
            a.m1747a((FieldDescriptorLite) b.getKey(), b.getValue());
        }
        for (Entry entry : this.f1193a.m1797d()) {
            a.m1747a((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        a.f1195c = this.f1195c;
        return a;
    }

    public FieldSet m1757f() {
        FieldSet a = m1730a();
        for (int i = 0; i < this.f1193a.m1796c(); i++) {
            Entry b = this.f1193a.m1794b(i);
            FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) b.getKey();
            a.m1747a(fieldDescriptorLite, m1743d(fieldDescriptorLite, b.getValue()));
        }
        for (Entry entry : this.f1193a.m1797d()) {
            FieldDescriptorLite fieldDescriptorLite2 = (FieldDescriptorLite) entry.getKey();
            a.m1747a(fieldDescriptorLite2, m1743d(fieldDescriptorLite2, entry.getValue()));
        }
        a.f1195c = false;
        return a;
    }

    public FieldSet m1758g() {
        FieldSet a = m1730a();
        for (int i = 0; i < this.f1193a.m1796c(); i++) {
            Entry b = this.f1193a.m1794b(i);
            FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) b.getKey();
            a.m1747a(fieldDescriptorLite, m1744e(fieldDescriptorLite, b.getValue()));
        }
        for (Entry entry : this.f1193a.m1797d()) {
            FieldDescriptorLite fieldDescriptorLite2 = (FieldDescriptorLite) entry.getKey();
            a.m1747a(fieldDescriptorLite2, m1744e(fieldDescriptorLite2, entry.getValue()));
        }
        a.f1195c = false;
        return a;
    }

    public void m1759h() {
        this.f1193a.clear();
        this.f1195c = false;
    }

    public Iterator m1760i() {
        return this.f1195c ? new C0259v(this.f1193a.entrySet().iterator()) : this.f1193a.entrySet().iterator();
    }

    public boolean m1761j() {
        for (int i = 0; i < this.f1193a.m1796c(); i++) {
            if (!m1736a(this.f1193a.m1794b(i))) {
                return false;
            }
        }
        for (Entry a : this.f1193a.m1797d()) {
            if (!m1736a(a)) {
                return false;
            }
        }
        return true;
    }

    public int m1762k() {
        int i = 0;
        for (int i2 = 0; i2 < this.f1193a.m1796c(); i2++) {
            Entry b = this.f1193a.m1794b(i2);
            i += m1741c((FieldDescriptorLite) b.getKey(), b.getValue());
        }
        for (Entry entry : this.f1193a.m1797d()) {
            i += m1741c((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public int m1763l() {
        int i = 0;
        int i2 = 0;
        while (i < this.f1193a.m1796c()) {
            i2 += m1742c(this.f1193a.m1794b(i));
            i++;
        }
        for (Entry c : this.f1193a.m1797d()) {
            i2 += m1742c(c);
        }
        return i2;
    }
}
