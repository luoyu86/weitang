package com.tom_roush.pdfbox.pdmodel.fdf;

import java.io.IOException;
import java.io.InputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class XMLUtil {
    private XMLUtil() {
    }

    public static String getNodeValue(Element element) {
        return com.tom_roush.pdfbox.util.XMLUtil.getNodeValue(element);
    }

    public static Document parse(InputStream inputStream) throws IOException {
        return com.tom_roush.pdfbox.util.XMLUtil.parse(inputStream);
    }
}
