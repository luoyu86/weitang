package com.tom_roush.fontbox.util.autodetect;

import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.tom_roush.pdfbox.android.PDFBoxConfig;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class FontFileFinder {
    private FontDirFinder fontDirFinder = null;

    private boolean checkFontfile(File file) {
        String lowerCase = file.getName().toLowerCase(Locale.US);
        return (lowerCase.endsWith(".ttf") || lowerCase.endsWith(".otf") || lowerCase.endsWith(".pfb") || lowerCase.endsWith(".ttc")) && !lowerCase.startsWith("fonts.");
    }

    private FontDirFinder determineDirFinder() {
        if (System.getProperty("java.vendor").equals("The Android Project")) {
            return new AndroidFontDirFinder();
        }
        String property = System.getProperty("os.name");
        return property.startsWith("Windows") ? new WindowsFontDirFinder() : property.startsWith("Mac") ? new MacFontDirFinder() : property.startsWith("OS/400") ? new OS400FontDirFinder() : new UnixFontDirFinder();
    }

    private void walk(File file, List<URI> list) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (!file2.isDirectory()) {
                    if (PDFBoxConfig.isDebugEnabled()) {
                        Log.d("PdfBox-Android", "checkFontfile check " + file2);
                    }
                    if (checkFontfile(file2)) {
                        if (PDFBoxConfig.isDebugEnabled()) {
                            Log.d("PdfBox-Android", "checkFontfile found " + file2);
                        }
                        list.add(file2.toURI());
                    }
                } else if (!file2.getName().startsWith(Consts.DOT)) {
                    walk(file2, list);
                }
            }
        }
    }

    public List<URI> find() {
        if (this.fontDirFinder == null) {
            this.fontDirFinder = determineDirFinder();
        }
        List<File> listFind = this.fontDirFinder.find();
        ArrayList arrayList = new ArrayList();
        Iterator<File> it = listFind.iterator();
        while (it.hasNext()) {
            walk(it.next(), arrayList);
        }
        return arrayList;
    }

    public List<URI> find(String str) {
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        if (file.isDirectory()) {
            walk(file, arrayList);
        }
        return arrayList;
    }
}
