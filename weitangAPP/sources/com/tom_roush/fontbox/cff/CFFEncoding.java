package com.tom_roush.fontbox.cff;

import com.tom_roush.fontbox.encoding.Encoding;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CFFEncoding extends Encoding {
    public void add(int i2, int i3, String str) {
        addCharacterEncoding(i2, str);
    }

    public void add(int i2, int i3) {
        addCharacterEncoding(i2, CFFStandardString.getName(i3));
    }
}
