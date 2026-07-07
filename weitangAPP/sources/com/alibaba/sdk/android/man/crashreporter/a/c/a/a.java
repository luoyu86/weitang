package com.alibaba.sdk.android.man.crashreporter.a.c.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Object> f4696c = new HashMap();

    public byte[] a() {
        Map<String, Object> map = this.f4696c;
        if (map != null && map.size() > 0) {
            try {
                byte[] bArrA = a(this.f4696c);
                if (bArrA != null) {
                    return bArrA;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private byte[] a(Map map) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(map);
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            return null;
        }
    }
}
