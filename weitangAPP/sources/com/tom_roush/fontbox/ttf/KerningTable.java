package com.tom_roush.fontbox.ttf;

import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class KerningTable extends TTFTable {
    public static final String TAG = "kern";
    private KerningSubtable[] subtables;

    public KerningTable(TrueTypeFont trueTypeFont) {
        super(trueTypeFont);
    }

    public KerningSubtable getHorizontalKerningSubtable() {
        return getHorizontalKerningSubtable(false);
    }

    @Override // com.tom_roush.fontbox.ttf.TTFTable
    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        int unsignedInt;
        int unsignedShort = tTFDataStream.readUnsignedShort();
        if (unsignedShort != 0) {
            unsignedShort = (unsignedShort << 16) | tTFDataStream.readUnsignedShort();
        }
        if (unsignedShort == 0) {
            unsignedInt = tTFDataStream.readUnsignedShort();
        } else if (unsignedShort == 1) {
            unsignedInt = (int) tTFDataStream.readUnsignedInt();
        } else {
            Log.d("PdfBox-Android", "Skipped kerning table due to an unsupported kerning table version: " + unsignedShort);
            unsignedInt = 0;
        }
        if (unsignedInt > 0) {
            this.subtables = new KerningSubtable[unsignedInt];
            for (int i2 = 0; i2 < unsignedInt; i2++) {
                KerningSubtable kerningSubtable = new KerningSubtable();
                kerningSubtable.read(tTFDataStream, unsignedShort);
                this.subtables[i2] = kerningSubtable;
            }
        }
        this.initialized = true;
    }

    public KerningSubtable getHorizontalKerningSubtable(boolean z) {
        KerningSubtable[] kerningSubtableArr = this.subtables;
        if (kerningSubtableArr == null) {
            return null;
        }
        for (KerningSubtable kerningSubtable : kerningSubtableArr) {
            if (kerningSubtable.isHorizontalKerning(z)) {
                return kerningSubtable;
            }
        }
        return null;
    }
}
