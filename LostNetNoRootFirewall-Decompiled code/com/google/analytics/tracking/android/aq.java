package com.google.analytics.tracking.android;

import java.util.Map;

abstract class aq {
    aq() {
    }

    abstract void sendHit(Map map);
}
