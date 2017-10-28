package com.google.android.vending.licensing;

public class StrictPolicy implements Policy {
    private int mLastResponse = Policy.RETRY;

    public boolean allowAccess() {
        return this.mLastResponse == Policy.LICENSED;
    }

    public void processServerResponse(int i, ResponseData responseData) {
        this.mLastResponse = i;
    }
}
