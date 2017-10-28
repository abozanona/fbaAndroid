package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.FieldSet.FieldDescriptorLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableBuilder;
import com.google.tagmanager.protobuf.GeneratedMessageLite.GeneratedExtension;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.MessageLite.Builder;
import com.google.tagmanager.protobuf.WireFormat.FieldType;
import com.google.tagmanager.protobuf.WireFormat.JavaType;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class GeneratedMutableMessageLite extends AbstractMutableMessageLite implements Serializable {
    private static final long serialVersionUID = 1;
    protected ByteString unknownFields = ByteString.EMPTY;

    public abstract class ExtendableMutableMessage extends GeneratedMutableMessageLite {
        private FieldSet extensions = FieldSet.m1738b();

        public class ExtensionWriter {
            private final Iterator iter;
            private final boolean messageSetWireFormat;
            private Entry next;

            private ExtensionWriter(boolean z) {
                this.iter = ExtendableMutableMessage.this.extensions.m1760i();
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

        protected ExtendableMutableMessage() {
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensions.m1755d()) {
                this.extensions = this.extensions.m1756e();
            }
        }

        private void verifyExtensionContainingType(GeneratedExtension generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final ExtendableMutableMessage addExtension(GeneratedExtension generatedExtension, Object obj) {
            assertMutable();
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.m1751b(generatedExtension.descriptor, generatedExtension.singularToFieldSetType(obj));
            return this;
        }

        public ExtendableMutableMessage clear() {
            assertMutable();
            this.extensions = FieldSet.m1738b();
            return (ExtendableMutableMessage) super.clear();
        }

        public final ExtendableMutableMessage clearExtension(GeneratedExtension generatedExtension) {
            assertMutable();
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.m1753c(generatedExtension.descriptor);
            return this;
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

        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        public final Object getExtension(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Object b = this.extensions.m1750b(generatedExtension.descriptor);
            return b == null ? generatedExtension.defaultValue : generatedExtension.descriptor.f1260d ? Collections.unmodifiableList((List) generatedExtension.fromFieldSetType(b)) : generatedExtension.fromFieldSetType(b);
        }

        public final Object getExtension(GeneratedExtension generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return generatedExtension.singularFromFieldSetType(this.extensions.m1745a(generatedExtension.descriptor, i));
        }

        public final int getExtensionCount(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.m1754d(generatedExtension.descriptor);
        }

        public final MutableMessageLite getMutableExtension(GeneratedExtension generatedExtension) {
            assertMutable();
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            C0252o c0252o = generatedExtension.descriptor;
            if (c0252o.getLiteJavaType() != JavaType.MESSAGE) {
                throw new UnsupportedOperationException("getMutableExtension() called on a non-Message type.");
            } else if (c0252o.isRepeated()) {
                throw new UnsupportedOperationException("getMutableExtension() called on a repeated type.");
            } else {
                Object b = this.extensions.m1750b(generatedExtension.descriptor);
                if (b != null) {
                    return (MutableMessageLite) b;
                }
                b = ((MutableMessageLite) generatedExtension.defaultValue).newMessageForType();
                this.extensions.m1747a(generatedExtension.descriptor, b);
                return b;
            }
        }

        public final boolean hasExtension(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.m1749a(generatedExtension.descriptor);
        }

        public MessageLite immutableCopy() {
            ExtendableBuilder extendableBuilder = (ExtendableBuilder) GeneratedMutableMessageLite.internalCopyToBuilder(this, internalImmutableDefault());
            extendableBuilder.internalSetExtensionSet(this.extensions.m1757f());
            return extendableBuilder.buildPartial();
        }

        void internalSetExtensionSet(FieldSet fieldSet) {
            this.extensions = fieldSet;
        }

        protected final void mergeExtensionFields(ExtendableMutableMessage extendableMutableMessage) {
            ensureExtensionsIsMutable();
            this.extensions.m1748a(extendableMutableMessage.extensions);
        }

        protected ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(false);
        }

        protected ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(true);
        }

        protected boolean parseUnknownField(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i) {
            ensureExtensionsIsMutable();
            return GeneratedMutableMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), codedInputStream, codedOutputStream, extensionRegistryLite, i);
        }

        public final ExtendableMutableMessage setExtension(GeneratedExtension generatedExtension, int i, Object obj) {
            assertMutable();
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.m1746a(generatedExtension.descriptor, i, generatedExtension.singularToFieldSetType(obj));
            return this;
        }

        public final ExtendableMutableMessage setExtension(GeneratedExtension generatedExtension, Object obj) {
            assertMutable();
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.m1747a(generatedExtension.descriptor, generatedExtension.toFieldSetType(obj));
            return this;
        }
    }

    static Builder internalCopyToBuilder(MutableMessageLite mutableMessageLite, MessageLite messageLite) {
        Builder newBuilderForType = messageLite.newBuilderForType();
        try {
            newBuilderForType.mergeFrom(mutableMessageLite.toByteArray());
            return newBuilderForType;
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException("Failed to parse serialized bytes (should not happen)");
        }
    }

    protected static MessageLite internalImmutableDefault(String str) {
        try {
            return (MessageLite) GeneratedMessageLite.invokeOrDie(GeneratedMessageLite.getMethodOrDie(Class.forName(str), "getDefaultInstance", new Class[0]), null, new Object[0]);
        } catch (ClassNotFoundException e) {
            throw new UnsupportedOperationException("Cannot load the corresponding immutable class. Please add necessary dependencies.");
        }
    }

    static boolean parseUnknownField(FieldSet fieldSet, MutableMessageLite mutableMessageLite, CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i) {
        boolean z;
        boolean z2;
        int tagWireType = WireFormat.getTagWireType(i);
        GeneratedExtension findLiteExtensionByNumber = extensionRegistryLite.findLiteExtensionByNumber(mutableMessageLite, WireFormat.getTagFieldNumber(i));
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
                    fieldSet.m1751b(findLiteExtensionByNumber.descriptor, FieldSet.m1739b(codedInputStream, findLiteExtensionByNumber.descriptor.getLiteType(), false));
                }
            }
            codedInputStream.popLimit(tagWireType);
        } else {
            Object findValueByNumber2;
            switch (C0254q.f1264a[findLiteExtensionByNumber.descriptor.getLiteJavaType().ordinal()]) {
                case 1:
                    MutableMessageLite newMessageForType = ((MutableMessageLite) findLiteExtensionByNumber.messageDefaultInstance).newMessageForType();
                    if (findLiteExtensionByNumber.descriptor.getLiteType() != FieldType.GROUP) {
                        codedInputStream.readMessage(newMessageForType, extensionRegistryLite);
                        break;
                    }
                    codedInputStream.readGroup(findLiteExtensionByNumber.getNumber(), newMessageForType, extensionRegistryLite);
                    break;
                case 2:
                    int readEnum = codedInputStream.readEnum();
                    findValueByNumber2 = findLiteExtensionByNumber.descriptor.getEnumType().findValueByNumber(readEnum);
                    if (findValueByNumber2 == null) {
                        codedOutputStream.writeRawVarint32(i);
                        codedOutputStream.writeUInt32NoTag(readEnum);
                        return true;
                    }
                    break;
                default:
                    findValueByNumber2 = FieldSet.m1739b(codedInputStream, findLiteExtensionByNumber.descriptor.getLiteType(), false);
                    break;
            }
            if (findLiteExtensionByNumber.descriptor.isRepeated()) {
                fieldSet.m1751b(findLiteExtensionByNumber.descriptor, findLiteExtensionByNumber.singularToFieldSetType(findValueByNumber2));
            } else {
                fieldSet.m1747a(findLiteExtensionByNumber.descriptor, findLiteExtensionByNumber.singularToFieldSetType(findValueByNumber2));
            }
        }
        return true;
    }

    public GeneratedMutableMessageLite clear() {
        assertMutable();
        this.unknownFields = ByteString.EMPTY;
        return this;
    }

    public abstract GeneratedMutableMessageLite getDefaultInstanceForType();

    public Parser getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public MessageLite immutableCopy() {
        MessageLite internalImmutableDefault = internalImmutableDefault();
        return this == getDefaultInstanceForType() ? internalImmutableDefault : internalCopyToBuilder(this, internalImmutableDefault).buildPartial();
    }

    protected abstract MessageLite internalImmutableDefault();

    public abstract GeneratedMutableMessageLite mergeFrom(GeneratedMutableMessageLite generatedMutableMessageLite);

    protected boolean parseUnknownField(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i) {
        return codedInputStream.skipField(i, codedOutputStream);
    }

    protected Object writeReplace() {
        return new C0255r(this);
    }
}
