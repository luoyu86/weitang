package com.tom_roush.fontbox.cff;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CFFCharset {
    private final boolean isCIDFont;
    private final Map<Integer, Integer> sidOrCidToGid = new HashMap(250);
    private final Map<Integer, Integer> gidToSid = new HashMap(250);
    private final Map<String, Integer> nameToSid = new HashMap(250);
    private final Map<Integer, Integer> gidToCid = new HashMap();
    private final Map<Integer, String> gidToName = new HashMap(250);

    public CFFCharset(boolean z) {
        this.isCIDFont = z;
    }

    public void addCID(int i2, int i3) {
        if (!this.isCIDFont) {
            throw new IllegalStateException("Not a CIDFont");
        }
        this.sidOrCidToGid.put(Integer.valueOf(i3), Integer.valueOf(i2));
        this.gidToCid.put(Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public void addSID(int i2, int i3, String str) {
        if (this.isCIDFont) {
            throw new IllegalStateException("Not a Type 1-equivalent font");
        }
        this.sidOrCidToGid.put(Integer.valueOf(i3), Integer.valueOf(i2));
        this.gidToSid.put(Integer.valueOf(i2), Integer.valueOf(i3));
        this.nameToSid.put(str, Integer.valueOf(i3));
        this.gidToName.put(Integer.valueOf(i2), str);
    }

    public int getCIDForGID(int i2) {
        if (!this.isCIDFont) {
            throw new IllegalStateException("Not a CIDFont");
        }
        Integer num = this.gidToCid.get(Integer.valueOf(i2));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int getGIDForCID(int i2) {
        if (!this.isCIDFont) {
            throw new IllegalStateException("Not a CIDFont");
        }
        Integer num = this.sidOrCidToGid.get(Integer.valueOf(i2));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getGIDForSID(int i2) {
        if (this.isCIDFont) {
            throw new IllegalStateException("Not a Type 1-equivalent font");
        }
        Integer num = this.sidOrCidToGid.get(Integer.valueOf(i2));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getNameForGID(int i2) {
        if (this.isCIDFont) {
            throw new IllegalStateException("Not a Type 1-equivalent font");
        }
        return this.gidToName.get(Integer.valueOf(i2));
    }

    public int getSID(String str) {
        if (this.isCIDFont) {
            throw new IllegalStateException("Not a Type 1-equivalent font");
        }
        Integer num = this.nameToSid.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getSIDForGID(int i2) {
        if (this.isCIDFont) {
            throw new IllegalStateException("Not a Type 1-equivalent font");
        }
        Integer num = this.gidToSid.get(Integer.valueOf(i2));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean isCIDFont() {
        return this.isCIDFont;
    }
}
