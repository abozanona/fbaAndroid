package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.FieldSet.FieldDescriptorLite;
import com.google.tagmanager.protobuf.GeneratedMutableMessageLite.ExtendableMutableMessage;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.Internal.EnumLiteMap;
import com.google.tagmanager.protobuf.WireFormat.FieldType;
import com.google.tagmanager.protobuf.WireFormat.JavaType;
import java.io.IOException;
import java.io.ObjectStreamException;
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

	public static abstract class Builder<Type extends GeneratedMessageLite.Builder> extends AbstractMessageLite.Builder<BuilderType> {
		private ByteString unknownFields;

		protected Builder() {
			this.unknownFields = ByteString.EMPTY;
		}

		public BuilderType clear() {
			this.unknownFields = ByteString.EMPTY;
			return this;
		}

		public BuilderType clone() {
			throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
		}

		public abstract MessageType getDefaultInstanceForType();

		public final ByteString getUnknownFields() {
			return this.unknownFields;
		}

		public abstract BuilderType mergeFrom(MessageType r1_MessageType);

		protected boolean parseUnknownField(CodedInputStream input, CodedOutputStream unknownFieldsCodedOutput, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
			return input.skipField(tag, unknownFieldsCodedOutput);
		}

		public final BuilderType setUnknownFields(ByteString unknownFields) {
			this.unknownFields = unknownFields;
			return this;
		}
	}

	public static interface ExtendableMessageOrBuilder<Type extends GeneratedMessageLite.ExtendableMessage> extends MessageLiteOrBuilder {
		public <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> r1_GeneratedMessageLite_GeneratedExtension_MessageTypeType);

		public <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> r1_GeneratedMessageLite_GeneratedExtension_MessageTypeList_Type, int r2i);

		public <Type> int getExtensionCount(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> r1_GeneratedMessageLite_GeneratedExtension_MessageTypeList_Type);

		public <Type> boolean hasExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> r1_GeneratedMessageLite_GeneratedExtension_MessageTypeType);
	}

	public static abstract class ExtendableBuilder<Type extends GeneratedMessageLite.ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite.Builder<MessageType, BuilderType> implements GeneratedMessageLite.ExtendableMessageOrBuilder<MessageType> {
		private FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions;
		private boolean extensionsIsMutable;

		protected ExtendableBuilder() {
			this.extensions = FieldSet.emptySet();
		}

		private FieldSet<GeneratedMessageLite.ExtensionDescriptor> buildExtensions() {
			this.extensions.makeImmutable();
			this.extensionsIsMutable = false;
			return this.extensions;
		}

		private void ensureExtensionsIsMutable() {
			if (!(this.extensionsIsMutable)) {
				this.extensions = this.extensions.clone();
				this.extensionsIsMutable = true;
			}
		}

		private void verifyExtensionContainingType(GeneratedMessageLite.GeneratedExtension<MessageType> extension) {
			if (extension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
				throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
			}
		}

		public final <Type> BuilderType addExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension, Type value) {
			verifyExtensionContainingType(extension);
			ensureExtensionsIsMutable();
			this.extensions.addRepeatedField(extension.descriptor, extension.singularToFieldSetType(value));
			return this;
		}

		public BuilderType clear() {
			this.extensions.clear();
			this.extensionsIsMutable = false;
			return (GeneratedMessageLite.ExtendableBuilder) super.clear();
		}

		public final <Type> BuilderType clearExtension(GeneratedMessageLite.GeneratedExtension<MessageType> extension) {
			verifyExtensionContainingType(extension);
			ensureExtensionsIsMutable();
			this.extensions.clearField(extension.descriptor);
			return this;
		}

		public BuilderType clone() {
			throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
		}

		protected boolean extensionsAreInitialized() {
			return this.extensions.isInitialized();
		}

		public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> extension) {
			verifyExtensionContainingType(extension);
			Object value = this.extensions.getField(extension.descriptor);
			return (value == null) ? extension.defaultValue : extension.fromFieldSetType(value);
		}

		public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension, int index) {
			verifyExtensionContainingType(extension);
			return extension.singularFromFieldSetType(this.extensions.getRepeatedField(extension.descriptor, index));
		}

		public final <Type> int getExtensionCount(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension) {
			verifyExtensionContainingType(extension);
			return this.extensions.getRepeatedFieldCount(extension.descriptor);
		}

		public final <Type> boolean hasExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> extension) {
			verifyExtensionContainingType(extension);
			return this.extensions.hasField(extension.descriptor);
		}

		void internalSetExtensionSet(FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions) {
			this.extensions = extensions;
		}

		protected final void mergeExtensionFields(MessageType other) {
			ensureExtensionsIsMutable();
			this.extensions.mergeFrom(other.extensions);
		}

		protected boolean parseUnknownField(CodedInputStream input, CodedOutputStream unknownFieldsCodedOutput, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
			ensureExtensionsIsMutable();
			return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), input, unknownFieldsCodedOutput, extensionRegistry, tag);
		}

		public final <Type> BuilderType setExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension, int index, Type value) {
			verifyExtensionContainingType(extension);
			ensureExtensionsIsMutable();
			this.extensions.setRepeatedField(extension.descriptor, index, extension.singularToFieldSetType(value));
			return this;
		}

		public final <Type> BuilderType setExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> extension, Type value) {
			verifyExtensionContainingType(extension);
			ensureExtensionsIsMutable();
			this.extensions.setField(extension.descriptor, extension.toFieldSetType(value));
			return this;
		}
	}

	public static abstract class ExtendableMessage<Type extends GeneratedMessageLite.ExtendableMessage<MessageType>> extends GeneratedMessageLite implements GeneratedMessageLite.ExtendableMessageOrBuilder<MessageType> {
		private final FieldSet<GeneratedMessageLite.ExtensionDescriptor> extensions;

		protected class ExtensionWriter {
			private final Iterator<Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> iter;
			private final boolean messageSetWireFormat;
			private Entry<GeneratedMessageLite.ExtensionDescriptor, Object> next;

			private ExtensionWriter(boolean messageSetWireFormat) {
				this.iter = extensions.iterator();
				if (this.iter.hasNext()) {
					this.next = (Entry) this.iter.next();
				}
				this.messageSetWireFormat = messageSetWireFormat;
			}

			public void writeUntil(int end, CodedOutputStream output) throws IOException {
				while (this.next != null && ((GeneratedMessageLite.ExtensionDescriptor) this.next.getKey()).getNumber() < end) {
					GeneratedMessageLite.ExtensionDescriptor extension = (GeneratedMessageLite.ExtensionDescriptor) this.next.getKey();
					if (!(this.messageSetWireFormat) || extension.getLiteJavaType() != JavaType.MESSAGE || extension.isRepeated()) {
						FieldSet.writeField(extension, this.next.getValue(), output);
					} else {
						output.writeMessageSetExtension(extension.getNumber(), (MessageLite) this.next.getValue());
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
			this.extensions = FieldSet.newFieldSet();
		}

		protected ExtendableMessage(GeneratedMessageLite.ExtendableBuilder<MessageType> builder) {
			this.extensions = builder.buildExtensions();
		}

		private void verifyExtensionContainingType(GeneratedMessageLite.GeneratedExtension<MessageType> extension) {
			if (extension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
				throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
			}
		}

		protected boolean extensionsAreInitialized() {
			return this.extensions.isInitialized();
		}

		protected int extensionsSerializedSize() {
			return this.extensions.getSerializedSize();
		}

		protected int extensionsSerializedSizeAsMessageSet() {
			return this.extensions.getMessageSetSerializedSize();
		}

		public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> extension) {
			verifyExtensionContainingType(extension);
			Object value = this.extensions.getField(extension.descriptor);
			return (value == null) ? extension.defaultValue : extension.fromFieldSetType(value);
		}

		public final <Type> Type getExtension(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension, int index) {
			verifyExtensionContainingType(extension);
			return extension.singularFromFieldSetType(this.extensions.getRepeatedField(extension.descriptor, index));
		}

		public final <Type> int getExtensionCount(GeneratedMessageLite.GeneratedExtension<MessageType, List<Type>> extension) {
			verifyExtensionContainingType(extension);
			return this.extensions.getRepeatedFieldCount(extension.descriptor);
		}

		public final <Type> boolean hasExtension(GeneratedMessageLite.GeneratedExtension<MessageType, Type> extension) {
			verifyExtensionContainingType(extension);
			return this.extensions.hasField(extension.descriptor);
		}

		protected void makeExtensionsImmutable() {
			this.extensions.makeImmutable();
		}

		public MutableMessageLite mutableCopy() {
			ExtendableMutableMessage result = (ExtendableMutableMessage) super.mutableCopy();
			result.internalSetExtensionSet(this.extensions.cloneWithAllFieldsToMutable());
			return result;
		}

		protected GeneratedMessageLite.ExtendableMessage<MessageType> newExtensionWriter() {
			return new ExtensionWriter(false, null);
		}

		protected GeneratedMessageLite.ExtendableMessage<MessageType> newMessageSetExtensionWriter() {
			return new ExtensionWriter(true, null);
		}

		protected boolean parseUnknownField(CodedInputStream input, CodedOutputStream unknownFieldsCodedOutput, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
			return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), input, unknownFieldsCodedOutput, extensionRegistry, tag);
		}
	}

	static /* synthetic */ class AnonymousClass_1 {
		static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

		static {
			$SwitchMap$com$google$protobuf$WireFormat$JavaType = new int[JavaType.values().length];
			try {
				$SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.MESSAGE.ordinal()] = 1;
			} catch (NoSuchFieldError e) {
			}
			$SwitchMap$com$google$protobuf$WireFormat$JavaType[JavaType.ENUM.ordinal()] = 2;
		}
	}

	static final class ExtensionDescriptor implements FieldDescriptorLite<GeneratedMessageLite.ExtensionDescriptor> {
		final EnumLiteMap<?> enumTypeMap;
		final boolean isPacked;
		final boolean isRepeated;
		final int number;
		final FieldType type;

		ExtensionDescriptor(EnumLiteMap<?> enumTypeMap, int number, FieldType type, boolean isRepeated, boolean isPacked) {
			this.enumTypeMap = enumTypeMap;
			this.number = number;
			this.type = type;
			this.isRepeated = isRepeated;
			this.isPacked = isPacked;
		}

		public int compareTo(GeneratedMessageLite.ExtensionDescriptor other) {
			return this.number - other.number;
		}

		public EnumLiteMap<?> getEnumType() {
			return this.enumTypeMap;
		}

		public JavaType getLiteJavaType() {
			return this.type.getJavaType();
		}

		public FieldType getLiteType() {
			return this.type;
		}

		public int getNumber() {
			return this.number;
		}

		public MessageLite.Builder internalMergeFrom(MessageLite.Builder to, MessageLite from) {
			return ((GeneratedMessageLite.Builder) to).mergeFrom((GeneratedMessageLite) from);
		}

		public MutableMessageLite internalMergeFrom(MutableMessageLite to, MutableMessageLite from) {
			return ((GeneratedMutableMessageLite) to).mergeFrom((GeneratedMutableMessageLite) from);
		}

		public boolean isPacked() {
			return this.isPacked;
		}

		public boolean isRepeated() {
			return this.isRepeated;
		}
	}

	public static class GeneratedExtension<Type> {
		final ContainingType containingTypeDefaultInstance;
		final Type defaultValue;
		final GeneratedMessageLite.ExtensionDescriptor descriptor;
		final Method enumValueOf;
		final MessageLite messageDefaultInstance;
		final Class singularType;

		GeneratedExtension(ContainingType containingTypeDefaultInstance, Type defaultValue, MessageLite messageDefaultInstance, GeneratedMessageLite.ExtensionDescriptor descriptor, Class singularType) {
			if (containingTypeDefaultInstance == null) {
				throw new IllegalArgumentException("Null containingTypeDefaultInstance");
			} else if (descriptor.getLiteType() != FieldType.MESSAGE || messageDefaultInstance != null) {
				this.containingTypeDefaultInstance = containingTypeDefaultInstance;
				this.defaultValue = defaultValue;
				this.messageDefaultInstance = messageDefaultInstance;
				this.descriptor = descriptor;
				this.singularType = singularType;
				if (EnumLite.class.isAssignableFrom(singularType)) {
					Class[] r1_Class_A = new Class[1];
					r1_Class_A[0] = Integer.TYPE;
					this.enumValueOf = GeneratedMessageLite.getMethodOrDie(singularType, "valueOf", r1_Class_A);
					return;
				} else {
					this.enumValueOf = null;
					return;
				}
			} else {
				throw new IllegalArgumentException("Null messageDefaultInstance");
			}
		}

		Object fromFieldSetType(Object value) {
			if (this.descriptor.isRepeated()) {
				if (this.descriptor.getLiteJavaType() == JavaType.ENUM) {
					List result = new ArrayList();
					Iterator i$ = ((List) value).iterator();
					while (i$.hasNext()) {
						result.add(singularFromFieldSetType(i$.next()));
					}
					return result;
				} else {
					return value;
				}
			} else {
				return singularFromFieldSetType(value);
			}
		}

		public ContainingType getContainingTypeDefaultInstance() {
			return this.containingTypeDefaultInstance;
		}

		public MessageLite getMessageDefaultInstance() {
			return this.messageDefaultInstance;
		}

		public int getNumber() {
			return this.descriptor.getNumber();
		}

		Object singularFromFieldSetType(Object value) {
			if (this.descriptor.getLiteJavaType() == JavaType.ENUM) {
				Object[] r2_Object_A = new Object[1];
				r2_Object_A[0] = (Integer) value;
				return GeneratedMessageLite.invokeOrDie(this.enumValueOf, null, r2_Object_A);
			}
			return value;
		}

		Object singularToFieldSetType(Object value) {
			if (this.descriptor.getLiteJavaType() == JavaType.ENUM) {
				return Integer.valueOf(((EnumLite) value).getNumber());
			}
			return value;
		}

		Object toFieldSetType(Object value) {
			if (this.descriptor.isRepeated()) {
				if (this.descriptor.getLiteJavaType() == JavaType.ENUM) {
					List result = new ArrayList();
					Iterator i$ = ((List) value).iterator();
					while (i$.hasNext()) {
						result.add(singularToFieldSetType(i$.next()));
					}
					return result;
				} else {
					return value;
				}
			} else {
				return singularToFieldSetType(value);
			}
		}
	}

	static final class SerializedForm implements Serializable {
		private static final long serialVersionUID = 0;
		private byte[] asBytes;
		private String messageClassName;

		SerializedForm(MessageLite regularForm) {
			this.messageClassName = regularForm.getClass().getName();
			this.asBytes = regularForm.toByteArray();
		}

		protected Object readResolve() throws ObjectStreamException {
			try {
				MessageLite.Builder builder = (MessageLite.Builder) Class.forName(this.messageClassName).getMethod("newBuilder", new Class[0]).invoke(null, new Object[0]);
				builder.mergeFrom(this.asBytes);
				return builder.buildPartial();
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Unable to find proto buffer class", e);
			} catch (NoSuchMethodException e_2) {
				throw new RuntimeException("Unable to find newBuilder method", e_2);
			} catch (IllegalAccessException e_3) {
				throw new RuntimeException("Unable to call newBuilder method", e_3);
			} catch (InvocationTargetException e_4) {
				throw new RuntimeException("Error calling newBuilder", e_4.getCause());
			} catch (InvalidProtocolBufferException e_5) {
				throw new RuntimeException("Unable to understand proto buffer", e_5);
			}
		}
	}


	protected GeneratedMessageLite() {
	}

	protected GeneratedMessageLite(Builder builder) {
	}

	static Method getMethodOrDie(Class clazz, String name, Class ... params) {
		try {
			return clazz.getMethod(name, params);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException("Generated message class \"" + clazz.getName() + "\" missing method \"" + name + "\".", e);
		}
	}

	protected static MutableMessageLite internalMutableDefault(String name) {
		try {
			return (MutableMessageLite) invokeOrDie(getMethodOrDie(Class.forName(name), "getDefaultInstance", new Class[0]), null, new Object[0]);
		} catch (ClassNotFoundException e) {
			throw new UnsupportedOperationException("Cannot load the corresponding mutable class. Please add necessary dependencies.");
		}
	}

	static Object invokeOrDie(Method method, Object object, Object ... params) {
		try {
			return method.invoke(object, params);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
		} catch (InvocationTargetException e_2) {
			Throwable cause = e_2.getCause();
			if (cause instanceof RuntimeException) {
				throw ((RuntimeException) cause);
			} else if (cause instanceof Error) {
				throw ((Error) cause);
			} else {
				throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
			}
		}
	}

	public static <Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingTypeDefaultInstance, MessageLite messageDefaultInstance, EnumLiteMap<?> enumTypeMap, int number, FieldType type, boolean isPacked, Class singularType) {
		Type emptyList = Collections.emptyList();
		GeneratedExtension<ContainingType, Type> r1_GeneratedExtension_ContainingTypeType = new GeneratedExtension(containingTypeDefaultInstance, emptyList, messageDefaultInstance, new ExtensionDescriptor(enumTypeMap, number, type, true, isPacked), singularType);
		return r8_GeneratedExtension_ContainingTypeType;
	}

	public static <Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingTypeDefaultInstance, Type defaultValue, MessageLite messageDefaultInstance, EnumLiteMap<?> enumTypeMap, int number, FieldType type, Class singularType) {
		GeneratedExtension<ContainingType, Type> r1_GeneratedExtension_ContainingTypeType = new GeneratedExtension(containingTypeDefaultInstance, defaultValue, messageDefaultInstance, new ExtensionDescriptor(enumTypeMap, number, type, false, false), singularType);
		return r7_GeneratedExtension_ContainingTypeType;
	}

	private static <Type extends MessageLite> boolean parseUnknownField(FieldSet<ExtensionDescriptor> extensions, MessageType defaultInstance, CodedInputStream input, CodedOutputStream unknownFieldsCodedOutput, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
		int wireType = WireFormat.getTagWireType(tag);
		GeneratedExtension<MessageType> extension = extensionRegistry.findLiteExtensionByNumber(defaultInstance, WireFormat.getTagFieldNumber(tag));
		boolean unknown = false;
		boolean packed = false;
		if (extension == null) {
			unknown = true;
		} else if (wireType == FieldSet.getWireFormatForFieldType(extension.descriptor.getLiteType(), false)) {
			packed = false;
		} else if (!(extension.descriptor.isRepeated) || !extension.descriptor.type.isPackable() || wireType != FieldSet.getWireFormatForFieldType(extension.descriptor.getLiteType(), true)) {
			unknown = true;
		} else {
			packed = true;
		}
		if (unknown) {
			return input.skipField(tag, unknownFieldsCodedOutput);
		} else {
			int rawValue;
			Object value;
			if (packed) {
				int limit = input.pushLimit(input.readRawVarint32());
				if (extension.descriptor.getLiteType() == FieldType.ENUM) {
					while (input.getBytesUntilLimit() > 0) {
						rawValue = input.readEnum();
						EnumLite value_2 = extension.descriptor.getEnumType().findValueByNumber(rawValue);
						if (value_2 == null) {
							return true;
						} else {
							extensions.addRepeatedField(extension.descriptor, extension.singularToFieldSetType(value_2));
						}
					}
					input.popLimit(limit);
				}
				while (input.getBytesUntilLimit() > 0) {
					value = FieldSet.readPrimitiveField(input, extension.descriptor.getLiteType(), false);
					extensions.addRepeatedField(extension.descriptor, value);
				}
				input.popLimit(limit);
			} else {
				switch(AnonymousClass_1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[extension.descriptor.getLiteJavaType().ordinal()]) {
				case WireFormat.WIRETYPE_FIXED64:
					MessageLite.Builder subBuilder = null;
					if (!extension.descriptor.isRepeated()) {
						MessageLite existingValue = (MessageLite) extensions.getField(extension.descriptor);
						if (existingValue != null) {
							subBuilder = existingValue.toBuilder();
						}
					}
					if (subBuilder == null) {
						subBuilder = extension.getMessageDefaultInstance().newBuilderForType();
					}
					if (extension.descriptor.getLiteType() == FieldType.GROUP) {
						input.readGroup(extension.getNumber(), subBuilder, extensionRegistry);
					} else {
						input.readMessage(subBuilder, extensionRegistry);
					}
					value = subBuilder.build();
					if (extension.descriptor.isRepeated()) {
						extensions.addRepeatedField(extension.descriptor, extension.singularToFieldSetType(value));
					} else {
						extensions.setField(extension.descriptor, extension.singularToFieldSetType(value));
					}
					break;
				case WireFormat.WIRETYPE_LENGTH_DELIMITED:
					rawValue = input.readEnum();
					value = extension.descriptor.getEnumType().findValueByNumber(rawValue);
					if (value == null) {
						unknownFieldsCodedOutput.writeRawVarint32(tag);
						unknownFieldsCodedOutput.writeUInt32NoTag(rawValue);
						return true;
					}
					if (extension.descriptor.isRepeated()) {
						extensions.setField(extension.descriptor, extension.singularToFieldSetType(value));
					} else {
						extensions.addRepeatedField(extension.descriptor, extension.singularToFieldSetType(value));
					}
					break;
				}
				value = FieldSet.readPrimitiveField(input, extension.descriptor.getLiteType(), false);
				if (extension.descriptor.isRepeated()) {
					extensions.addRepeatedField(extension.descriptor, extension.singularToFieldSetType(value));
				} else {
					extensions.setField(extension.descriptor, extension.singularToFieldSetType(value));
				}
			}
			return true;
		}
	}

	public Parser<MessageLite> getParserForType() {
		throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
	}

	protected MutableMessageLite internalMutableDefault() {
		throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
	}

	protected void makeExtensionsImmutable() {
	}

	public MutableMessageLite mutableCopy() {
		MutableMessageLite result = internalMutableDefault().newMessageForType();
		if (this == getDefaultInstanceForType()) {
			return result;
		} else {
			result.mergeFrom(CodedInputStream.newInstance(toByteArray()));
			return result;
		}
	}

	protected boolean parseUnknownField(CodedInputStream input, CodedOutputStream unknownFieldsCodedOutput, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
		return input.skipField(tag, unknownFieldsCodedOutput);
	}

	protected Object writeReplace() throws ObjectStreamException {
		return new SerializedForm(this);
	}
}
