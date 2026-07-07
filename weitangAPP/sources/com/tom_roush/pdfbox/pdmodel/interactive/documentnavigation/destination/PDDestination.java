package com.tom_roush.pdfbox.pdmodel.interactive.documentnavigation.destination;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSString;
import com.tom_roush.pdfbox.pdmodel.common.PDDestinationOrAction;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDDestination implements PDDestinationOrAction {
    public static PDDestination create(COSBase cOSBase) throws IOException {
        PDNamedDestination pDNamedDestination;
        if (cOSBase == null) {
            return null;
        }
        if (cOSBase instanceof COSArray) {
            COSArray cOSArray = (COSArray) cOSBase;
            if (cOSArray.size() > 1 && (cOSArray.getObject(1) instanceof COSName)) {
                COSName cOSName = (COSName) cOSArray.getObject(1);
                String name = cOSName.getName();
                if (name.equals(PDPageFitDestination.TYPE) || name.equals(PDPageFitDestination.TYPE_BOUNDED)) {
                    return new PDPageFitDestination(cOSArray);
                }
                if (name.equals(PDPageFitHeightDestination.TYPE) || name.equals(PDPageFitHeightDestination.TYPE_BOUNDED)) {
                    return new PDPageFitHeightDestination(cOSArray);
                }
                if (name.equals(PDPageFitRectangleDestination.TYPE)) {
                    return new PDPageFitRectangleDestination(cOSArray);
                }
                if (name.equals(PDPageFitWidthDestination.TYPE) || name.equals(PDPageFitWidthDestination.TYPE_BOUNDED)) {
                    return new PDPageFitWidthDestination(cOSArray);
                }
                if (name.equals(PDPageXYZDestination.TYPE)) {
                    return new PDPageXYZDestination(cOSArray);
                }
                throw new IOException("Unknown destination type: " + cOSName.getName());
            }
        }
        if (cOSBase instanceof COSString) {
            pDNamedDestination = new PDNamedDestination((COSString) cOSBase);
        } else {
            if (!(cOSBase instanceof COSName)) {
                throw new IOException("Error: can't convert to Destination " + cOSBase);
            }
            pDNamedDestination = new PDNamedDestination((COSName) cOSBase);
        }
        return pDNamedDestination;
    }
}
