package com.google.tagmanager.protobuf;

import java.util.Collections;
import java.util.List;

public class UninitializedMessageException extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    private final List missingFields;

    public UninitializedMessageException(MessageLite messageLite) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }

    public UninitializedMessageException(List list) {
        super(buildDescription(list));
        this.missingFields = list;
    }

    private static String buildDescription(List list) {
        StringBuilder stringBuilder = new StringBuilder("Message missing required fields: ");
        Object obj = 1;
        for (String str : list) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(getMessage());
    }

    public List getMissingFields() {
        return Collections.unmodifiableList(this.missingFields);
    }
}
