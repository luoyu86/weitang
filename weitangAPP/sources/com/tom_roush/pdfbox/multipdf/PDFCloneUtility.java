package com.tom_roush.pdfbox.multipdf;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSObject;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class PDFCloneUtility {
    private final PDDocument destination;
    private final Map<Object, COSBase> clonedVersion = new HashMap();
    private final Set<COSBase> clonedValues = new HashSet();

    public PDFCloneUtility(PDDocument pDDocument) {
        this.destination = pDDocument;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v19, types: [com.tom_roush.pdfbox.cos.COSArray] */
    /* JADX WARN: Type inference failed for: r0v23, types: [com.tom_roush.pdfbox.cos.COSBase] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.tom_roush.pdfbox.cos.COSBase] */
    /* JADX WARN: Type inference failed for: r0v28, types: [com.tom_roush.pdfbox.cos.COSBase, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v29, types: [com.tom_roush.pdfbox.cos.COSArray] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.tom_roush.pdfbox.cos.COSBase] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.tom_roush.pdfbox.cos.COSDictionary, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.tom_roush.pdfbox.cos.COSDictionary, com.tom_roush.pdfbox.cos.COSStream, java.lang.Object] */
    public COSBase cloneForNewDocument(Object obj) throws IOException {
        ?? cOSArray;
        ?? cOSDictionary;
        if (obj == null) {
            return null;
        }
        COSBase cOSBase = this.clonedVersion.get(obj);
        if (cOSBase != null) {
            return cOSBase;
        }
        boolean z = obj instanceof COSBase;
        if (z && this.clonedValues.contains(obj)) {
            return (COSBase) obj;
        }
        if (obj instanceof List) {
            cOSArray = new COSArray();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                cOSArray.add(cloneForNewDocument(it.next()));
            }
        } else if ((obj instanceof COSObjectable) && !z) {
            cOSArray = cloneForNewDocument(((COSObjectable) obj).getCOSObject());
        } else if (obj instanceof COSObject) {
            cOSArray = cloneForNewDocument(((COSObject) obj).getObject());
        } else if (obj instanceof COSArray) {
            cOSArray = new COSArray();
            COSArray cOSArray2 = (COSArray) obj;
            for (int i2 = 0; i2 < cOSArray2.size(); i2++) {
                cOSArray.add(cloneForNewDocument(cOSArray2.get(i2)));
            }
        } else {
            if (obj instanceof COSStream) {
                COSStream cOSStream = (COSStream) obj;
                cOSDictionary = this.destination.getDocument().createCOSStream();
                OutputStream outputStreamCreateRawOutputStream = cOSDictionary.createRawOutputStream();
                InputStream inputStreamCreateRawInputStream = cOSStream.createRawInputStream();
                IOUtils.copy(inputStreamCreateRawInputStream, outputStreamCreateRawOutputStream);
                inputStreamCreateRawInputStream.close();
                outputStreamCreateRawOutputStream.close();
                this.clonedVersion.put(obj, (COSBase) cOSDictionary);
                for (Map.Entry<COSName, COSBase> entry : cOSStream.entrySet()) {
                    cOSDictionary.setItem(entry.getKey(), cloneForNewDocument(entry.getValue()));
                }
            } else if (obj instanceof COSDictionary) {
                cOSDictionary = new COSDictionary();
                this.clonedVersion.put(obj, (COSBase) cOSDictionary);
                for (Map.Entry<COSName, COSBase> entry2 : ((COSDictionary) obj).entrySet()) {
                    cOSDictionary.setItem(entry2.getKey(), cloneForNewDocument(entry2.getValue()));
                }
            } else {
                cOSArray = (COSBase) obj;
            }
            cOSArray = cOSDictionary;
        }
        this.clonedVersion.put(obj, (COSBase) cOSArray);
        this.clonedValues.add((COSBase) cOSArray);
        return cOSArray;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.tom_roush.pdfbox.cos.COSBase, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.tom_roush.pdfbox.cos.COSBase] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.tom_roush.pdfbox.cos.COSDictionary, com.tom_roush.pdfbox.cos.COSStream, java.lang.Object] */
    public void cloneMerge(COSObjectable cOSObjectable, COSObjectable cOSObjectable2) throws IOException {
        COSBase cOSBaseCreateCOSStream;
        if (cOSObjectable == null || cOSObjectable == cOSObjectable2 || (cOSBaseCreateCOSStream = this.clonedVersion.get(cOSObjectable)) != 0) {
            return;
        }
        if (!(cOSObjectable instanceof COSBase)) {
            cloneMerge(cOSObjectable.getCOSObject(), cOSObjectable2.getCOSObject());
        } else if (cOSObjectable instanceof COSObject) {
            if (cOSObjectable2 instanceof COSObject) {
                cloneMerge(((COSObject) cOSObjectable).getObject(), ((COSObject) cOSObjectable2).getObject());
            } else if ((cOSObjectable2 instanceof COSDictionary) || (cOSObjectable2 instanceof COSArray)) {
                cloneMerge(((COSObject) cOSObjectable).getObject(), cOSObjectable2);
            }
        } else if (cOSObjectable instanceof COSArray) {
            if (cOSObjectable2 instanceof COSObject) {
                cloneMerge(cOSObjectable, ((COSObject) cOSObjectable2).getObject());
            } else {
                COSArray cOSArray = (COSArray) cOSObjectable;
                for (int i2 = 0; i2 < cOSArray.size(); i2++) {
                    ((COSArray) cOSObjectable2).add(cloneForNewDocument(cOSArray.get(i2)));
                }
            }
        } else if (cOSObjectable instanceof COSStream) {
            COSStream cOSStream = (COSStream) cOSObjectable;
            cOSBaseCreateCOSStream = this.destination.getDocument().createCOSStream();
            OutputStream outputStreamCreateOutputStream = cOSBaseCreateCOSStream.createOutputStream(cOSStream.getFilters());
            IOUtils.copy(cOSStream.createInputStream(), outputStreamCreateOutputStream);
            outputStreamCreateOutputStream.close();
            this.clonedVersion.put(cOSObjectable, (COSBase) cOSBaseCreateCOSStream);
            for (Map.Entry<COSName, COSBase> entry : cOSStream.entrySet()) {
                cOSBaseCreateCOSStream.setItem(entry.getKey(), cloneForNewDocument(entry.getValue()));
            }
        } else if (!(cOSObjectable instanceof COSDictionary)) {
            cOSBaseCreateCOSStream = (COSBase) cOSObjectable;
        } else if (cOSObjectable2 instanceof COSObject) {
            cloneMerge(cOSObjectable, ((COSObject) cOSObjectable2).getObject());
        } else {
            this.clonedVersion.put(cOSObjectable, cOSBaseCreateCOSStream);
            for (Map.Entry<COSName, COSBase> entry2 : ((COSDictionary) cOSObjectable).entrySet()) {
                COSName key = entry2.getKey();
                COSBase value = entry2.getValue();
                COSDictionary cOSDictionary = (COSDictionary) cOSObjectable2;
                if (cOSDictionary.getItem(key) != null) {
                    cloneMerge(value, cOSDictionary.getItem(key));
                } else {
                    cOSDictionary.setItem(key, cloneForNewDocument(value));
                }
            }
        }
        this.clonedVersion.put(cOSObjectable, (COSBase) cOSBaseCreateCOSStream);
        this.clonedValues.add((COSBase) cOSBaseCreateCOSStream);
    }

    public PDDocument getDestination() {
        return this.destination;
    }
}
