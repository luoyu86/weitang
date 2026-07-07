package com.tom_roush.pdfbox.pdfparser;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSObjectKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class XrefTrailerResolver {
    private final Map<Long, XrefTrailerObj> bytePosToXrefMap = new HashMap();
    private XrefTrailerObj curXrefTrailerObj = null;
    private XrefTrailerObj resolvedXrefTrailer = null;

    public enum XRefType {
        TABLE,
        STREAM
    }

    public static class XrefTrailerObj {
        public COSDictionary trailer;
        private final Map<COSObjectKey, Long> xrefTable;
        private XRefType xrefType;

        public void reset() {
            this.xrefTable.clear();
        }

        private XrefTrailerObj() {
            this.trailer = null;
            this.xrefTable = new HashMap();
            this.xrefType = XRefType.TABLE;
        }
    }

    public Set<Long> getContainedObjectNumbers(int i2) {
        if (this.resolvedXrefTrailer == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        long j = -i2;
        for (Map.Entry entry : this.resolvedXrefTrailer.xrefTable.entrySet()) {
            if (((Long) entry.getValue()).longValue() == j) {
                hashSet.add(Long.valueOf(((COSObjectKey) entry.getKey()).getNumber()));
            }
        }
        return hashSet;
    }

    public COSDictionary getCurrentTrailer() {
        return this.curXrefTrailerObj.trailer;
    }

    public final COSDictionary getFirstTrailer() {
        if (this.bytePosToXrefMap.isEmpty()) {
            return null;
        }
        return this.bytePosToXrefMap.get(new TreeSet(this.bytePosToXrefMap.keySet()).first()).trailer;
    }

    public final COSDictionary getLastTrailer() {
        if (this.bytePosToXrefMap.isEmpty()) {
            return null;
        }
        return this.bytePosToXrefMap.get(new TreeSet(this.bytePosToXrefMap.keySet()).last()).trailer;
    }

    public COSDictionary getTrailer() {
        XrefTrailerObj xrefTrailerObj = this.resolvedXrefTrailer;
        if (xrefTrailerObj == null) {
            return null;
        }
        return xrefTrailerObj.trailer;
    }

    public final int getTrailerCount() {
        return this.bytePosToXrefMap.size();
    }

    public Map<COSObjectKey, Long> getXrefTable() {
        XrefTrailerObj xrefTrailerObj = this.resolvedXrefTrailer;
        if (xrefTrailerObj == null) {
            return null;
        }
        return xrefTrailerObj.xrefTable;
    }

    public XRefType getXrefType() {
        XrefTrailerObj xrefTrailerObj = this.resolvedXrefTrailer;
        if (xrefTrailerObj == null) {
            return null;
        }
        return xrefTrailerObj.xrefType;
    }

    public void nextXrefObj(long j, XRefType xRefType) {
        this.curXrefTrailerObj = new XrefTrailerObj();
        this.bytePosToXrefMap.put(Long.valueOf(j), this.curXrefTrailerObj);
        this.curXrefTrailerObj.xrefType = xRefType;
    }

    public void reset() {
        Iterator<XrefTrailerObj> it = this.bytePosToXrefMap.values().iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
        this.curXrefTrailerObj = null;
        this.resolvedXrefTrailer = null;
    }

    public void setStartxref(long j) {
        if (this.resolvedXrefTrailer != null) {
            Log.w("PdfBox-Android", "Method must be called only ones with last startxref value.");
            return;
        }
        XrefTrailerObj xrefTrailerObj = new XrefTrailerObj();
        this.resolvedXrefTrailer = xrefTrailerObj;
        xrefTrailerObj.trailer = new COSDictionary();
        XrefTrailerObj xrefTrailerObj2 = this.bytePosToXrefMap.get(Long.valueOf(j));
        ArrayList arrayList = new ArrayList();
        if (xrefTrailerObj2 == null) {
            Log.w("PdfBox-Android", "Did not found XRef object at specified startxref position " + j);
            arrayList.addAll(this.bytePosToXrefMap.keySet());
            Collections.sort(arrayList);
        } else {
            this.resolvedXrefTrailer.xrefType = xrefTrailerObj2.xrefType;
            arrayList.add(Long.valueOf(j));
            while (true) {
                COSDictionary cOSDictionary = xrefTrailerObj2.trailer;
                if (cOSDictionary == null) {
                    break;
                }
                long j2 = cOSDictionary.getLong(COSName.PREV, -1L);
                if (j2 == -1) {
                    break;
                }
                xrefTrailerObj2 = this.bytePosToXrefMap.get(Long.valueOf(j2));
                if (xrefTrailerObj2 == null) {
                    Log.w("PdfBox-Android", "Did not found XRef object pointed to by 'Prev' key at position " + j2);
                    break;
                }
                arrayList.add(Long.valueOf(j2));
                if (arrayList.size() >= this.bytePosToXrefMap.size()) {
                    break;
                }
            }
            Collections.reverse(arrayList);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            XrefTrailerObj xrefTrailerObj3 = this.bytePosToXrefMap.get((Long) it.next());
            COSDictionary cOSDictionary2 = xrefTrailerObj3.trailer;
            if (cOSDictionary2 != null) {
                this.resolvedXrefTrailer.trailer.addAll(cOSDictionary2);
            }
            this.resolvedXrefTrailer.xrefTable.putAll(xrefTrailerObj3.xrefTable);
        }
    }

    public void setTrailer(COSDictionary cOSDictionary) {
        XrefTrailerObj xrefTrailerObj = this.curXrefTrailerObj;
        if (xrefTrailerObj == null) {
            Log.w("PdfBox-Android", "Cannot add trailer because XRef start was not signalled.");
        } else {
            xrefTrailerObj.trailer = cOSDictionary;
        }
    }

    public void setXRef(COSObjectKey cOSObjectKey, long j) {
        XrefTrailerObj xrefTrailerObj = this.curXrefTrailerObj;
        if (xrefTrailerObj != null) {
            if (xrefTrailerObj.xrefTable.containsKey(cOSObjectKey)) {
                return;
            }
            this.curXrefTrailerObj.xrefTable.put(cOSObjectKey, Long.valueOf(j));
        } else {
            Log.w("PdfBox-Android", "Cannot add XRef entry for '" + cOSObjectKey.getNumber() + "' because XRef start was not signalled.");
        }
    }
}
