package com.tom_roush.fontbox.ttf;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class VerticalOriginTable extends TTFTable {
    public static final String TAG = "VORG";
    private int defaultVertOriginY;
    private Map<Integer, Integer> origins;
    private float version;

    public VerticalOriginTable(TrueTypeFont trueTypeFont) {
        super(trueTypeFont);
    }

    public int getOriginY(int i2) {
        return this.origins.containsKey(Integer.valueOf(i2)) ? this.origins.get(Integer.valueOf(i2)).intValue() : this.defaultVertOriginY;
    }

    public float getVersion() {
        return this.version;
    }

    @Override // com.tom_roush.fontbox.ttf.TTFTable
    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        this.version = tTFDataStream.read32Fixed();
        this.defaultVertOriginY = tTFDataStream.readSignedShort();
        int unsignedShort = tTFDataStream.readUnsignedShort();
        this.origins = new ConcurrentHashMap(unsignedShort);
        for (int i2 = 0; i2 < unsignedShort; i2++) {
            this.origins.put(Integer.valueOf(tTFDataStream.readUnsignedShort()), Integer.valueOf(tTFDataStream.readSignedShort()));
        }
        this.initialized = true;
    }
}
