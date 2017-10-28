package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.GeneratedMessageLite.GeneratedExtension;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistryLite {
	private static final ExtensionRegistryLite EMPTY;
	private static volatile boolean eagerlyParseMessageSets;
	private final Map<ObjectIntPair, GeneratedExtension<>> extensionsByNumber;

	private static final class ObjectIntPair {
		private final int number;
		private final Object object;

		ObjectIntPair(Object object, int number) {
			this.object = object;
			this.number = number;
		}

		public boolean equals(Object obj) {
			if (!((obj instanceof ExtensionRegistryLite.ObjectIntPair))) {
				return false;
			} else {
				ExtensionRegistryLite.ObjectIntPair other = (ExtensionRegistryLite.ObjectIntPair) obj;
				if (this.object == other.object) {
					if (this.number == other.number) {
						return true;
					}
					return false;
				}
				return false;
			}
		}

		public int hashCode() {
			return (System.identityHashCode(this.object) * 65535) + this.number;
		}
	}


	static {
		eagerlyParseMessageSets = false;
		EMPTY = new ExtensionRegistryLite(true);
	}

	ExtensionRegistryLite() {
		this.extensionsByNumber = new HashMap();
	}

	ExtensionRegistryLite(ExtensionRegistryLite other) {
		if (other == EMPTY) {
			this.extensionsByNumber = Collections.emptyMap();
			return;
		} else {
			this.extensionsByNumber = Collections.unmodifiableMap(other.extensionsByNumber);
		}
	}

	private ExtensionRegistryLite(boolean empty) {
		this.extensionsByNumber = Collections.emptyMap();
	}

	public static ExtensionRegistryLite getEmptyRegistry() {
		return EMPTY;
	}

	public static boolean isEagerlyParseMessageSets() {
		return eagerlyParseMessageSets;
	}

	public static ExtensionRegistryLite newInstance() {
		return new ExtensionRegistryLite();
	}

	public static void setEagerlyParseMessageSets(boolean isEagerlyParse) {
		eagerlyParseMessageSets = isEagerlyParse;
	}

	public final void add(GeneratedExtension<> extension) {
		this.extensionsByNumber.put(new ObjectIntPair(extension.getContainingTypeDefaultInstance(), extension.getNumber()), extension);
	}

	public <Type extends MessageLite> GeneratedExtension<ContainingType> findLiteExtensionByNumber(ContainingType containingTypeDefaultInstance, int fieldNumber) {
		return (GeneratedExtension) this.extensionsByNumber.get(new ObjectIntPair(containingTypeDefaultInstance, fieldNumber));
	}

	public ExtensionRegistryLite getUnmodifiable() {
		return new ExtensionRegistryLite(this);
	}
}
