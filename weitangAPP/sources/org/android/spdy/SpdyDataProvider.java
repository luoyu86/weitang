package org.android.spdy;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SpdyDataProvider {
    public byte[] data;
    public boolean finished;
    public Map<String, String> postBody;

    public SpdyDataProvider(byte[] bArr) {
        this.finished = true;
        this.data = bArr;
        this.postBody = null;
    }

    public SpdyDataProvider(Map<String, String> map) {
        this.finished = true;
        this.data = null;
        this.postBody = map;
    }
}
