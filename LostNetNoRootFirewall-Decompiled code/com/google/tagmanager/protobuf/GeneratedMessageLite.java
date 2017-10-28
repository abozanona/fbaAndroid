package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.FieldSet.FieldDescriptorLite;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite.ExtendableMutableMessage;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;
import com.google.tagmanager.protobuf.WireFormat.FieldType;
import com.google.tagmanager.protobuf.WireFormat.JavaType;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {
    private static final long serialVersionUID = 1;

    public abstract class Builder extends com.google.tagmanager.protobuf.AbstractMessageLite.Builder {
        private ByteString unknownFields = ByteString.EMPTY;

        protected Builder() {
        }

        public Builder clear() {
            this.unknownFields = ByteString.EMPTY;
            return this;
        }

        public Builder clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public abstract GeneratedMessageLite getDefaultInstanceForType();

        public final ByteString getUnknownFields() {
            return this.unknownFields;
        }

        public abstract Builder mergeFrom(GeneratedMessageLite generatedMessageLite);

        protected boolean parseUnknownField(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i) {
            return codedInputStream.skipField(i, codedOutputStream);
        }

        public final Builder setUnknownFields(ByteString byteString) {
            this.unknownFields = byteString;
            return this;
        }
    }

    public interface ExtendableMessageOrBuilder extends MessageLiteOrBuilder {
        Object getExtension(GeneratedExtension generatedExtension);

        Object getExtension(GeneratedExtension generatedExtension, int i);

        int getExtensionCount(GeneratedExtension generatedExtension);

        boolean hasExtension(GeneratedExtension generatedExtension);
    }

    public abstract class ExtendableBuilder extends Builder implements ExtendableMessageOrBuilder {
        private FieldSet extensions = FieldSet.m1738b();
        private boolean extensionsIsMutable;

        protected ExtendableBuilder() {
        }

        private FieldSet buildExtensions() {
            this.extensions.m1752c();
            this.extensionsIsMutable = false;
            return this.extensions;
        }

        private void ensureExtensionsIsMutable() {
            if (!this.extensionsIsMutable) {
                this.extensions = this.extensions.m1756e();
                this.extensionsIsMutable = true;
            }
        }

        private void verifyExtensionContainingType(GeneratedExtension generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final ExtendableBuilder addExtension(GeneratedExtension generatedExtension, Object obj) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.m1751b(generatedExtension.descriptor, generatedExtension.singularToFieldSetType(obj));
            return this;
        }

        public ExtendableBuilder clear() {
            this.extensions.m1759h();
            this.extensionsIsMutable = false;
            return (ExtendableBuilder) super.clear();
        }

        public final ExtendableBuilder clearExtension(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.m1753c(generatedExtension.descriptor);
            return this;
        }

        public ExtendableBuilder clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.m1761j();
        }

        public final Object getExtension(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Object b = this.extensions.m1750b(generatedExtension.descriptor);
            return b == null ? generatedExtension.defaultValue : generatedExtension.fromFieldSetType(b);
        }

        public final Object getExtension(GeneratedExtension generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return generatedExtension.singularFromFieldSetType(this.extensions.m1745a(generatedExtension.descriptor, i));
        }

        public final int getExtensionCount(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.m1754d(generatedExtension.descriptor);
        }

        public final boolean hasExtension(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.m1749a(generatedExtension.descriptor);
        }

        void internalSetExtensionSet(FieldSet fieldSet) {
            this.extensions = fieldSet;
        }

        protected final void mergeExtensionFields(ExtendableMessage extendableMessage) {
            ensureExtensionsIsMutable();
            this.extensions.m1748a(extendableMessage.extensions);
        }

        protected boolean parseUnknownField(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i) {
            ensureExtensionsIsMutable();
            return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), codedInputStream, codedOutputStream, extensionRegistryLite, i);
        }

        public final ExtendableBuilder setExtension(GeneratedExtension generatedExtension, int i, Object obj) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.m1746a(generatedExtension.descriptor, i, generatedExtension.singularToFieldSetType(obj));
            return this;
        }

        public final ExtendableBuilder setExtension(GeneratedExtension generatedExtension, Object obj) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.m1747a(generatedExtension.descriptor, generatedExtension.toFieldSetType(obj));
            return this;
        }
    }

    public abstract class ExtendableMessage extends GeneratedMessageLite implements ExtendableMessageOrBuilder {
        private final FieldSet extensions;

        public class ExtensionWriter {
            private final Iterator iter;
            private final boolean messageSetWireFormat;
            private Entry next;

            private ExtensionWriter(boolean z) {
                this.iter = ExtendableMessage.this.extensions.m1760i();
                if (this.iter.hasNext()) {
                    this.next = (Entry) this.iter.next();
                }
                this.messageSetWireFormat = z;
            }

            public void writeUntil(int i, CodedOutputStream codedOutputStream) {
                while (this.next != null && ((C0252o) this.next.getKey()).getNumber() < i) {
                    FieldDescriptorLite fieldDescriptorLite = (C0252o) this.next.getKey();
                    if (this.messageSetWireFormat && fieldDescriptorLite.getLiteJavaType() == JavaType.MESSAGE && !fieldDescriptorLite.isRepeated()) {
                        codedOutputStream.writeMessageSetExtension(fieldDescriptorLite.getNumber(), (MessageLite) this.next.getValue());
                    } else {
                        FieldSet.m1734a(fieldDescriptorLite, this.next.getValue(), codedOutputStream);
                    }
                    if (this.iter.hasNext()) {
                        this.next = (Entry) this.iter.next();
                    } else {
                        this.next = null;
                    }
                }
            }
        }

        protected ExtendableMessage() {
            this.extensions = FieldSet.m1730a();
        }

        protected ExtendableMessage(ExtendableBuilder extendableBuilder) {
            this.extensions = extendableBuilder.buildExtensions();
        }

        private void verifyExtensionContainingType(GeneratedExtension generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.m1761j();
        }

        protected int extensionsSerializedSize() {
            return this.extensions.m1762k();
        }

        protected int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.m1763l();
        }

        public final Object getExtension(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Object b = this.extensions.m1750b(generatedExtension.descriptor);
            return b == null ? generatedExtension.defaultValue : generatedExtension.fromFieldSetType(b);
        }

        public final Object getExtension(GeneratedExtension generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return generatedExtension.singularFromFieldSetType(this.extensions.m1745a(generatedExtension.descriptor, i));
        }

        public final int getExtensionCount(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.m1754d(generatedExtension.descriptor);
        }

        public final boolean hasExtension(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.m1749a(generatedExtension.descriptor);
        }

        protected void makeExtensionsImmutable() {
            this.extensions.m1752c();
        }

        public MutableMessageLite mutableCopy() {
            ExtendableMutableMessage extendableMutableMessage = (ExtendableMutableMessage) super.mutableCopy();
            extendableMutableMessage.internalSetExtensionSet(this.extensions.m1758g());
            return extendableMutableMessage;
        }

        protected ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(false);
        }

        protected ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(true);
        }

        protected boolean parseUnknownField(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i) {
            return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), codedInputStream, codedOutputStream, extensionRegistryLite, i);
        }
    }

    public class GeneratedExtension {
        final MessageLite containingTypeDefaultInstance;
        final Object defaultValue;
        final C0252o descriptor;
        final Method enumValueOf;
        final MessageLite messageDefaultInstance;
        final Class singularType;

        GeneratedExtension(MessageLite messageLite, Object obj, MessageLite messageLite2, C0252o c0252o, Class cls) {
            if (messageLite == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (c0252o.getLiteType() == FieldType.MESSAGE && messageLite2 == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.containingTypeDefaultInstance = messageLite;
                this.defaultValue = obj;
                this.messageDefaultInstance = messageLite2;
                this.descriptor = c0252o;
                this.singularType = cls;
                if (EnumLite.class.isAssignableFrom(cls)) {
                    this.enumValueOf = GeneratedMessageLite.getMethodOrDie(cls, "valueOf", Integer.TYPE);
                    return;
                }
                this.enumValueOf = null;
            }
        }

        Object fromFieldSetType(Object obj) {
            if (!this.descriptor.isRepeated()) {
                return singularFromFieldSetType(obj);
            }
            if (this.descriptor.getLiteJavaType() != JavaType.ENUM) {
                return obj;
            }
            List arrayList = new ArrayList();
            for (Object singularFromFieldSetType : (List) obj) {
                arrayList.add(singularFromFieldSetType(singularFromFieldSetType));
            }
            return arrayList;
        }

        public MessageLite getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        public int getNumber() {
            return this.descriptor.getNumber();
        }

        Object singularFromFieldSetType(Object obj) {
            if (this.descriptor.getLiteJavaType() != JavaType.ENUM) {
                return obj;
            }
            return GeneratedMessageLite.invokeOrDie(this.enumValueOf, null, (Integer) obj);
        }

        Object singularToFieldSetType(Object obj) {
            return this.descriptor.getLiteJavaType() == JavaType.ENUM ? Integer.valueOf(((EnumLite) obj).getNumber()) : obj;
        }

        Object toFieldSetType(Object obj) {
            if (!this.descriptor.isRepeated()) {
                return singularToFieldSetType(obj);
            }
            if (this.descriptor.getLiteJavaType() != JavaType.ENUM) {
                return obj;
            }
            List arrayList = new ArrayList();
            for (Object singularToFieldSetType : (List) obj) {
                arrayList.add(singularToFieldSetType(singularToFieldSetType));
            }
            return arrayList;
        }
    }

    protected GeneratedMessageLite() {
    }

    protected GeneratedMessageLite(Builder builder) {
    }

    static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    protected static MutableMessageLite internalMutableDefault(String str) {
        try {
            return (MutableMessageLite) invokeOrDie(getMethodOrDie(Class.forName(str), "getDefaultInstance", new Class[0]), null, new Object[0]);
        } catch (ClassNotFoundException e) {
            throw new UnsupportedOperationException("Cannot load the corresponding mutable class. Please add necessary dependencies.");
        }
    }

    static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        Throwable e;
        try {
            return method.invoke(obj, objArr);
        } catch (Throwable e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            e2 = e3.getCause();
            if (e2 instanceof RuntimeException) {
                throw ((RuntimeException) e2);
            } else if (e2 instanceof Error) {
                throw ((Error) e2);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", e2);
            }
        }
    }

    public static GeneratedExtension newRepeatedGeneratedExtension(MessageLite messageLite, MessageLite messageLite2, EnumLiteMap enumLiteMap, int i, FieldType fieldType, boolean z, Class cls) {
        return new GeneratedExtension(messageLite, Collections.emptyList(), messageLite2, new C0252o(enumLiteMap, i, fieldType, true, z), cls);
    }

    public static GeneratedExtension newSingularGeneratedExtension(MessageLite messageLite, Object obj, MessageLite messageLite2, EnumLiteMap enumLiteMap, int i, FieldType fieldType, Class cls) {
        return new GeneratedExtension(messageLite, obj, messageLite2, new C0252o(enumLiteMap, i, fieldType, false, false), cls);
    }

    private static boolean parseUnknownField(FieldSet fieldSet, MessageLite messageLite, CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i) {
        boolean z;
        boolean z2;
        int tagWireType = WireFormat.getTagWireType(i);
        GeneratedExtension findLiteExtensionByNumber = extensionRegistryLite.findLiteExtensionByNumber(messageLite, WireFormat.getTagFieldNumber(i));
        if (findLiteExtensionByNumber == null) {
            z = false;
            z2 = true;
        } else if (tagWireType == FieldSet.m1729a(findLiteExtensionByNumber.descriptor.getLiteType(), false)) {
            z = false;
            z2 = false;
        } else if (findLiteExtensionByNumber.descriptor.f1260d && findLiteExtensionByNumber.descriptor.f1259c.isPackable() && tagWireType == FieldSet.m1729a(findLiteExtensionByNumber.descriptor.getLiteType(), true)) {
            z = true;
            z2 = false;
        } else {
            z = false;
            z2 = true;
        }
        if (z2) {
            return codedInputStream.skipField(i, codedOutputStream);
        }
        if (z) {
            tagWireType = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
            if (findLiteExtensionByNumber.descriptor.getLiteType() == FieldType.ENUM) {
                while (codedInputStream.getBytesUntilLimit() > 0) {
                    EnumLite findValueByNumber = findLiteExtensionByNumber.descriptor.getEnumType().findValueByNumber(codedInputStream.readEnum());
                    if (findValueByNumber == null) {
                        return true;
                    }
                    fieldSet.m1751b(findLiteExtensionByNumber.descriptor, findLiteExtensionByNumber.singularToFieldSetType(findValueByNumber));
                }
            } else {
                while (codedInputStream.getBytesUntilLimit() > 0) {
                    fieldSet.m1751b(findLiteExtensionByNumber.descriptor, FieldSet.m1731a(codedInputStream, findLiteExtensionByNumber.descriptor.getLiteType(), false));
                }
            }
            codedInputStream.popLimit(tagWireType);
        } else {
            Object build;
            switch (C0251n.f1256a[findLiteExtensionByNumber.descriptor.getLiteJavaType().ordinal()]) {
                case 1:
                    com.google.tagmanager.protobuf.MessageLite.Builder toBuilder;
                    if (!findLiteExtensionByNumber.descriptor.isRepeated()) {
                        MessageLite messageLite2 = (MessageLite) fieldSet.m1750b(findLiteExtensionByNumber.descriptor);
                        if (messageLite2 != null) {
                            toBuilder = messageLite2.toBuilder();
                            if (toBuilder == null) {
                                toBuilder = findLiteExtensionByNumber.getMessageDefaultInstance().newBuilderForType();
                            }
                            if (findLiteExtensionByNumber.descriptor.getLiteType() != FieldType.GROUP) {
                                codedInputStream.readGroup(findLiteExtensionByNumber.getNumber(), toBuilder, extensionRegistryLite);
                            } else {
                                codedInputStream.readMessage(toBuilder, extensionRegistryLite);
                            }
                            build = toBuilder.build();
                            break;
                        }
                    }
                    toBuilder = null;
                    if (toBuilder == null) {
                        toBuilder = findLiteExtensionByNumber.getMessageDefaultInstance().newBuilderForType();
                    }
                    if (findLiteExtensionByNumber.descriptor.getLiteType() != FieldType.GROUP) {
                        codedInputStream.readMessage(toBuilder, extensionRegistryLite);
                    } else {
                        codedInputStream.readGroup(findLiteExtensionByNumber.getNumber(), toBuilder, extensionRegistryLite);
                    }
                    build = toBuilder.build();
                case 2:
                    int readEnum = codedInputStream.readEnum();
                    build = findLiteExtensionByNumber.descriptor.getEnumType().findValueByNumber(readEnum);
                    if (build == null) {
                        codedOutputStream.writeRawVarint32(i);
                        codedOutputStream.writeUInt32NoTag(readEnum);
                        return true;
                    }
                    break;
                default:
                    build = FieldSet.m1731a(codedInputStream, findLiteExtensionByNumber.descriptor.getLiteType(), false);
                    break;
            }
            if (findLiteExtensionByNumber.descriptor.isRepeated()) {
                fieldSet.m1751b(findLiteExtensionByNumber.descriptor, findLiteExtensionByNumber.singularToFieldSetType(build));
            } else {
                fieldSet.m1747a(findLiteExtensionByNumber.descriptor, findLiteExtensionByNumber.singularToFieldSetType(build));
            }
        }
        return true;
    }

    public Parser getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected MutableMessageLite internalMutableDefault() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected void makeExtensionsImmutable() {
    }

    public MutableMessageLite mutableCopy() {
        MutableMessageLite newMessageForType = internalMutableDefault().newMessageForType();
        if (this != getDefaultInstanceForType()) {
            newMessageForType.mergeFrom(CodedInputStream.newInstance(toByteArray()));
        }
        return newMessageForType;
    }

    protected boolean parseUnknownField(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i) {
        return codedInputStream.skipField(i, codedOutputStream);
    }

    protected Object writeReplace() {
        return new C0253p(this);
    }
}
