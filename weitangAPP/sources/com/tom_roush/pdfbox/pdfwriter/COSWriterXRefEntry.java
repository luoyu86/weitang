package com.tom_roush.pdfbox.pdfwriter;

import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSObjectKey;

/* JADX INFO: loaded from: classes2.dex */
public class COSWriterXRefEntry implements Comparable<COSWriterXRefEntry> {
    private static final COSWriterXRefEntry NULLENTRY;
    private boolean free = false;
    private COSObjectKey key;
    private COSBase object;
    private long offset;

    static {
        COSWriterXRefEntry cOSWriterXRefEntry = new COSWriterXRefEntry(0L, null, new COSObjectKey(0L, 65535));
        NULLENTRY = cOSWriterXRefEntry;
        cOSWriterXRefEntry.setFree(true);
    }

    public COSWriterXRefEntry(long j, COSBase cOSBase, COSObjectKey cOSObjectKey) {
        setOffset(j);
        setObject(cOSBase);
        setKey(cOSObjectKey);
    }

    public static COSWriterXRefEntry getNullEntry() {
        return NULLENTRY;
    }

    private void setKey(COSObjectKey cOSObjectKey) {
        this.key = cOSObjectKey;
    }

    private void setObject(COSBase cOSBase) {
        this.object = cOSBase;
    }

    public COSObjectKey getKey() {
        return this.key;
    }

    public COSBase getObject() {
        return this.object;
    }

    public long getOffset() {
        return this.offset;
    }

    public boolean isFree() {
        return this.free;
    }

    public void setFree(boolean z) {
        this.free = z;
    }

    public final void setOffset(long j) {
        this.offset = j;
    }

    @Override // java.lang.Comparable
    public int compareTo(COSWriterXRefEntry cOSWriterXRefEntry) {
        if (cOSWriterXRefEntry == null || getKey().getNumber() < cOSWriterXRefEntry.getKey().getNumber()) {
            return -1;
        }
        return getKey().getNumber() > cOSWriterXRefEntry.getKey().getNumber() ? 1 : 0;
    }
}
