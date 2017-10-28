package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.FieldSet.FieldDescriptorLite;
import com.google.tagmanager.protobuf.GeneratedMessageLite.ExtendableBuilder;
import com.google.tagmanager.protobuf.GeneratedMessageLite.ExtensionDescriptor;
import com.google.tagmanager.protobuf.GeneratedMessageLite.GeneratedExtension;
import com.google.tagmanager.protobuf.Internal.EnumLite;
import com.google.tagmanager.protobuf.MessageLite.Builder;
import com.google.tagmanager.protobuf.WireFormat.FieldType;
import com.google.tagmanager.protobuf.WireFormat.JavaType;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class GeneratedMutableMessageLite<Type extends GeneratedMutableMessageLite<MessageType>> extends AbstractMutableMessageLite implements Serializable {
	private static final long serialVersionUID = 1;
	protected ByteString unknownFields;

	public static abstract class ExtendableMutableMessage<Type extends GeneratedMutableMessageLite.ExtendableMutableMessage<MessageType>> extends GeneratedMutableMessageLite<MessageType> {
		private FieldSet<ExtensionDescriptor> extensions;

		protected class ExtensionWriter {
			private final Iterator<Entry<ExtensionDescriptor, Object>> iter;
			private final boolean messageSetWireFormat;
			private Entry<ExtensionDescriptor, Object> next;

			private ExtensionWriter(boolean messageSetWireFormat) {
				this.iter = extensions.iterator();
				if (this.iter.hasNext()) {
					this.next = (Entry) this.iter.next();
				}
				this.messageSetWireFormat = messageSetWireFormat;
			}

			public void writeUntil(int end, CodedOutputStream output) throws IOException {
				while (this.next != null && ((ExtensionDescriptor) this.next.getKey()).getNumber() < end) {
					ExtensionDescriptor extension = (ExtensionDescriptor) this.next.getKey();
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


		protected ExtendableMutableMessage() {
			this.extensions = FieldSet.emptySet();
		}

		private void ensureExtensionsIsMutable() {
			if (this.extensions.isImmutable()) {
				this.extensions = this.extensions.clone();
			}
		}

		private void verifyExtensionContainingType(GeneratedExtension<MessageType> extension) {
			if (extension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
				throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
			}
		}

		public final <Type> MessageType addExtension(GeneratedExtension<MessageType, List<Type>> extension, Type value) {
			assertMutable();
			verifyExtensionContainingType(extension);
			ensureExtensionsIsMutable();
			this.extensions.addRepeatedField(extension.descriptor, extension.singularToFieldSetType(value));
			return this;
		}

		public MessageType clear() {
			assertMutable();
			this.extensions = FieldSet.emptySet();
			return (GeneratedMutableMessageLite.ExtendableMutableMessage) super.clear();
		}

		public final <Type> MessageType clearExtension(GeneratedExtension<MessageType> extension) {
			assertMutable();
			verifyExtensionContainingType(extension);
			ensureExtensionsIsMutable();
			this.extensions.clearField(extension.descriptor);
			return this;
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

		public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
			return super.getDefaultInstanceForType();
		}

		public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> extension) {
			verifyExtensionContainingType(extension);
			Object value = this.extensions.getField(extension.descriptor);
			if (value == null) {
				return extension.defaultValue;
			} else if (extension.descriptor.isRepeated) {
				return Collections.unmodifiableList((List) extension.fromFieldSetType(value));
			} else {
				return extension.fromFieldSetType(value);
			}
		}

		public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> extension, int index) {
			verifyExtensionContainingType(extension);
			return extension.singularFromFieldSetType(this.extensions.getRepeatedField(extension.descriptor, index));
		}

		public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> extension) {
			verifyExtensionContainingType(extension);
			return this.extensions.getRepeatedFieldCount(extension.descriptor);
		}

		public final <Type extends MutableMessageLite> Type getMutableExtension(GeneratedExtension<MessageType, Type> extension) {
			assertMutable();
			verifyExtensionContainingType(extension);
			ensureExtensionsIsMutable();
			ExtensionDescriptor descriptor = extension.descriptor;
			if (descriptor.getLiteJavaType() != JavaType.MESSAGE) {
				throw new UnsupportedOperationException("getMutableExtension() called on a non-Message type.");
			} else if (descriptor.isRepeated()) {
				throw new UnsupportedOperationException("getMutableExtension() called on a repeated type.");
			} else {
				Object value = this.extensions.getField(extension.descriptor);
				if (value == null) {
					Type message = ((MutableMessageLite) extension.defaultValue).newMessageForType();
					this.extensions.setField(extension.descriptor, message);
					return message;
				} else {
					return (MutableMessageLite) value;
				}
			}
		}

		public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> extension) {
			verifyExtensionContainingType(extension);
			return this.extensions.hasField(extension.descriptor);
		}

		public MessageLite immutableCopy() {
			ExtendableBuilder builder = (ExtendableBuilder) internalCopyToBuilder(this, internalImmutableDefault());
			builder.internalSetExtensionSet(this.extensions.cloneWithAllFieldsToImmutable());
			return builder.buildPartial();
		}

		void internalSetExtensionSet(FieldSet<ExtensionDescriptor> extensions) {
			this.extensions = extensions;
		}

		protected final void mergeExtensionFields(MessageType other) {
			ensureExtensionsIsMutable();
			this.extensions.mergeFrom(other.extensions);
		}

		protected GeneratedMutableMessageLite.ExtendableMutableMessage<MessageType> newExtensionWriter() {
			return new ExtensionWriter(false, null);
		}

		protected GeneratedMutableMessageLite.ExtendableMutableMessage<MessageType> newMessageSetExtensionWriter() {
			return new ExtensionWriter(true, null);
		}

		protected boolean parseUnknownField(CodedInputStream input, CodedOutputStream unknownFieldsCodedOutput, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
			ensureExtensionsIsMutable();
			return GeneratedMutableMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), input, unknownFieldsCodedOutput, extensionRegistry, tag);
		}

		public final <Type> MessageType setExtension(GeneratedExtension<MessageType, List<Type>> extension, int index, Type value) {
			assertMutable();
			verifyExtensionContainingType(extension);
			ensureExtensionsIsMutable();
			this.extensions.setRepeatedField(extension.descriptor, index, extension.singularToFieldSetType(value));
			return this;
		}

		public final <Type> MessageType setExtension(GeneratedExtension<MessageType, Type> extension, Type value) {
			assertMutable();
			verifyExtensionContainingType(extension);
			ensureExtensionsIsMutable();
			this.extensions.setField(extension.descriptor, extension.toFieldSetType(value));
			return this;
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

	static final class SerializedForm implements Serializable {
		private static final long serialVersionUID = 0;
		private byte[] asBytes;
		private String messageClassName;

		SerializedForm(MutableMessageLite regularForm) {
			this.messageClassName = regularForm.getClass().getName();
			this.asBytes = regularForm.toByteArray();
		}

		protected Object readResolve() throws ObjectStreamException {
			MutableMessageLite message;
			try {
				message = (MutableMessageLite) Class.forName(this.messageClassName).getMethod("newMessage", new Class[0]).invoke(null, new Object[0]);
				if (!message.mergeFrom(CodedInputStream.newInstance(this.asBytes))) {
					throw new RuntimeException("Unable to understand proto buffer");
				}
				return message;
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Unable to find proto buffer class", e);
			} catch (NoSuchMethodException e_2) {
				throw new RuntimeException("Unable to find newMessage method", e_2);
			} catch (IllegalAccessException e_3) {
				throw new RuntimeException("Unable to call newMessage method", e_3);
			} catch (InvocationTargetException e_4) {
				throw new RuntimeException("Error calling newMessage", e_4.getCause());
			}
		}
	}


	public GeneratedMutableMessageLite() {
		this.unknownFields = ByteString.EMPTY;
	}

	static Builder internalCopyToBuilder(MutableMessageLite fromMessage, MessageLite toMessagePrototype) {
		Builder builder = toMessagePrototype.newBuilderForType();
		try {
			builder.mergeFrom(fromMessage.toByteArray());
			return builder;
		} catch (InvalidProtocolBufferException e) {
			throw new RuntimeException("Failed to parse serialized bytes (should not happen)");
		}
	}

	protected static MessageLite internalImmutableDefault(String name) {
		try {
			return (MessageLite) GeneratedMessageLite.invokeOrDie(GeneratedMessageLite.getMethodOrDie(Class.forName(name), "getDefaultInstance", new Class[0]), null, new Object[0]);
		} catch (ClassNotFoundException e) {
			throw new UnsupportedOperationException("Cannot load the corresponding immutable class. Please add necessary dependencies.");
		}
	}

	static <Type extends MutableMessageLite> boolean parseUnknownField(FieldSet<ExtensionDescriptor> extensions, MessageType defaultInstance, CodedInputStream input, CodedOutputStream unknownFieldsCodedOutput, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
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
			if (packed) {
				int limit = input.pushLimit(input.readRawVarint32());
				if (extension.descriptor.getLiteType() == FieldType.ENUM) {
					while (input.getBytesUntilLimit() > 0) {
						rawValue = input.readEnum();
						EnumLite value = extension.descriptor.getEnumType().findValueByNumber(rawValue);
						if (value == null) {
							return true;
						} else {
							extensions.addRepeatedField(extension.descriptor, extension.singularToFieldSetType(value));
						}
					}
					input.popLimit(limit);
				}
				while (input.getBytesUntilLimit() > 0) {
					FieldDescriptorLite r13_FieldDescriptorLite = extension.descriptor;
					extensions.addRepeatedField(r13_FieldDescriptorLite, FieldSet.readPrimitiveFieldForMutable(input, extension.descriptor.getLiteType(), false));
				}
				input.popLimit(limit);
			} else {
				MutableMessageLite value_2;
				switch(AnonymousClass_1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[extension.descriptor.getLiteJavaType().ordinal()]) {
				case WireFormat.WIRETYPE_FIXED64:
					MutableMessageLite message = ((MutableMessageLite) extension.messageDefaultInstance).newMessageForType();
					if (extension.descriptor.getLiteType() == FieldType.GROUP) {
						input.readGroup(extension.getNumber(), message, extensionRegistry);
					} else {
						input.readMessage(message, extensionRegistry);
					}
					value_2 = message;
					if (extension.descriptor.isRepeated()) {
						extensions.addRepeatedField(extension.descriptor, extension.singularToFieldSetType(value_2));
					} else {
						extensions.setField(extension.descriptor, extension.singularToFieldSetType(value_2));
					}
					break;
				case WireFormat.WIRETYPE_LENGTH_DELIMITED:
					rawValue = input.readEnum();
					value_2 = extension.descriptor.getEnumType().findValueByNumber(rawValue);
					if (value_2 == null) {
						unknownFieldsCodedOutput.writeRawVarint32(tag);
						unknownFieldsCodedOutput.writeUInt32NoTag(rawValue);
						return true;
					}
					if (extension.descriptor.isRepeated()) {
						extensions.setField(extension.descriptor, extension.singularToFieldSetType(value_2));
					} else {
						extensions.addRepeatedField(extension.descriptor, extension.singularToFieldSetType(value_2));
					}
					break;
				}
				value_2 = FieldSet.readPrimitiveFieldForMutable(input, extension.descriptor.getLiteType(), false);
				if (extension.descriptor.isRepeated()) {
					extensions.addRepeatedField(extension.descriptor, extension.singularToFieldSetType(value_2));
				} else {
					extensions.setField(extension.descriptor, extension.singularToFieldSetType(value_2));
				}
			}
			return true;
		}
	}

	public MessageType clear() {
		assertMutable();
		this.unknownFields = ByteString.EMPTY;
		return this;
	}

	public abstract MessageType getDefaultInstanceForType();

	public Parser<MessageType> getParserForType() {
		throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
	}

	public MessageLite immutableCopy() {
		MessageLite immutableDefaultInstance = internalImmutableDefault();
		return (this == getDefaultInstanceForType()) ? immutableDefaultInstance : internalCopyToBuilder(this, immutableDefaultInstance).buildPartial();
	}

	protected abstract MessageLite internalImmutableDefault();

	public abstract MessageType mergeFrom(MessageType r1_MessageType);

	protected boolean parseUnknownField(CodedInputStream input, CodedOutputStream unknownFieldsCodedOutput, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
		return input.skipField(tag, unknownFieldsCodedOutput);
	}

	protected Object writeReplace() throws ObjectStreamException {
		return new SerializedForm(this);
	}
}
