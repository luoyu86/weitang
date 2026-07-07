package com.vivo.identifier;

import android.database.ContentObserver;

/* JADX INFO: loaded from: classes2.dex */
public class IdentifierIdObserver extends ContentObserver {
    private static final String TAG = "VMS_SDK_Observer";
    private String mAppId;
    private IdentifierIdClient mIdentifierIdClient;
    private int mType;

    public IdentifierIdObserver(IdentifierIdClient identifierIdClient, int i2, String str) {
        super(null);
        this.mIdentifierIdClient = identifierIdClient;
        this.mType = i2;
        this.mAppId = str;
    }

    @Override // android.database.ContentObserver
    public native void onChange(boolean z);
}
