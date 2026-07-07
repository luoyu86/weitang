package com.tom_roush.fontbox.cff;

import com.tom_roush.fontbox.type1.Type1CharStringReader;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class CIDKeyedType2CharString extends Type2CharString {
    private final int cid;

    public CIDKeyedType2CharString(Type1CharStringReader type1CharStringReader, String str, int i2, int i3, List<Object> list, int i4, int i5) {
        super(type1CharStringReader, str, String.format(Locale.US, "%04x", Integer.valueOf(i2)), i3, list, i4, i5);
        this.cid = i2;
    }

    public int getCID() {
        return this.cid;
    }
}
