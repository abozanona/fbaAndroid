package com.google.tagmanager;

import com.google.tagmanager.proto.Resource.ResourceWithMetadata;

class dk implements Runnable {
    final /* synthetic */ ResourceWithMetadata f1088a;
    final /* synthetic */ di f1089b;

    dk(di diVar, ResourceWithMetadata resourceWithMetadata) {
        this.f1089b = diVar;
        this.f1088a = resourceWithMetadata;
    }

    public void run() {
        this.f1089b.m1579b(this.f1088a);
    }
}
