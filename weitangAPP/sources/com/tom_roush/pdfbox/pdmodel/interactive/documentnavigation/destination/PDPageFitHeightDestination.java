package com.tom_roush.pdfbox.pdmodel.interactive.documentnavigation.destination;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;

/* JADX INFO: loaded from: classes2.dex */
public class PDPageFitHeightDestination extends PDPageDestination {
    public static final String TYPE = "FitV";
    public static final String TYPE_BOUNDED = "FitBV";

    public PDPageFitHeightDestination() {
        this.array.growToSize(3);
        this.array.setName(1, TYPE);
    }

    public boolean fitBoundingBox() {
        return TYPE_BOUNDED.equals(this.array.getName(1));
    }

    public int getLeft() {
        return this.array.getInt(2);
    }

    public void setFitBoundingBox(boolean z) {
        this.array.growToSize(3);
        if (z) {
            this.array.setName(1, TYPE_BOUNDED);
        } else {
            this.array.setName(1, TYPE);
        }
    }

    public void setLeft(int i2) {
        this.array.growToSize(3);
        if (i2 == -1) {
            this.array.set(2, (COSBase) null);
        } else {
            this.array.setInt(2, i2);
        }
    }

    public PDPageFitHeightDestination(COSArray cOSArray) {
        super(cOSArray);
    }
}
