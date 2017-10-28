package com.google.tagmanager.protobuf;

import com.google.tagmanager.protobuf.FieldSet.FieldDescriptorLite;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

final class ah extends ag {
    ah(int i) {
        super(i);
    }

    public void mo716a() {
        if (!m1795b()) {
            for (int i = 0; i < m1796c(); i++) {
                Entry b = m1794b(i);
                if (((FieldDescriptorLite) b.getKey()).isRepeated()) {
                    b.setValue(Collections.unmodifiableList((List) b.getValue()));
                }
            }
            for (Entry entry : m1797d()) {
                if (((FieldDescriptorLite) entry.getKey()).isRepeated()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.mo716a();
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return super.m1792a((FieldDescriptorLite) obj, obj2);
    }
}
