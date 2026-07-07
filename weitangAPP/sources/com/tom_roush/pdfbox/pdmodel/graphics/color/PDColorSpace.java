package com.tom_roush.pdfbox.pdmodel.graphics.color;

import android.graphics.Bitmap;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSObject;
import com.tom_roush.pdfbox.pdmodel.PDResources;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDColorSpace implements COSObjectable {
    public COSArray array;

    public static PDColorSpace create(COSBase cOSBase) throws IOException {
        return create(cOSBase, null);
    }

    private static PDColorSpace createFromCOSObject(COSObject cOSObject, PDResources pDResources) throws IOException {
        PDColorSpace colorSpace;
        if (pDResources != null && pDResources.getResourceCache() != null && (colorSpace = pDResources.getResourceCache().getColorSpace(cOSObject)) != null) {
            return colorSpace;
        }
        PDColorSpace pDColorSpaceCreate = create(cOSObject.getObject(), pDResources);
        if (pDResources != null && pDResources.getResourceCache() != null && pDColorSpaceCreate != null) {
            pDResources.getResourceCache().put(cOSObject, pDColorSpaceCreate);
        }
        return pDColorSpaceCreate;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSBase getCOSObject() {
        return this.array;
    }

    public abstract float[] getDefaultDecode(int i2);

    public abstract PDColor getInitialColor();

    public abstract String getName();

    public abstract int getNumberOfComponents();

    public abstract float[] toRGB(float[] fArr) throws IOException;

    public abstract Bitmap toRGBImage(Bitmap bitmap) throws IOException;

    public static PDColorSpace create(COSBase cOSBase, PDResources pDResources) throws IOException {
        return create(cOSBase, pDResources, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a A[PHI: r4
  0x002a: PHI (r4v18 com.tom_roush.pdfbox.cos.COSName) = 
  (r4v15 com.tom_roush.pdfbox.cos.COSName)
  (r4v16 com.tom_roush.pdfbox.cos.COSName)
  (r4v19 com.tom_roush.pdfbox.cos.COSName)
 binds: [B:23:0x004b, B:18:0x003a, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace create(com.tom_roush.pdfbox.cos.COSBase r6, com.tom_roush.pdfbox.pdmodel.PDResources r7, boolean r8) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 617
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace.create(com.tom_roush.pdfbox.cos.COSBase, com.tom_roush.pdfbox.pdmodel.PDResources, boolean):com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace");
    }
}
