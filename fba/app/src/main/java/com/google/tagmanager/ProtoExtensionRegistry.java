package com.google.tagmanager;

import com.google.analytics.containertag.proto.Serving;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;

class ProtoExtensionRegistry {
	private static ExtensionRegistryLite registry;

	ProtoExtensionRegistry() {
	}

	public static synchronized ExtensionRegistryLite getRegistry() {
		ExtensionRegistryLite r0_ExtensionRegistryLite;
		Class r1_Class = ProtoExtensionRegistry.class;
		synchronized(r1_Class) {
			if (registry == null) {
				registry = ExtensionRegistryLite.newInstance();
				Serving.registerAllExtensions(registry);
			}
			r0_ExtensionRegistryLite = registry;
		}
		return r0_ExtensionRegistryLite;
	}
}
