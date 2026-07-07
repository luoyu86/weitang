package com.tom_roush.pdfbox.pdmodel.interactive.form;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSInputStream;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import com.tom_roush.pdfbox.util.XMLUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes2.dex */
public final class PDXFAResource implements COSObjectable {
    private static final int BUFFER_SIZE = 1024;
    private final COSBase xfa;

    public PDXFAResource(COSBase cOSBase) {
        this.xfa = cOSBase;
    }

    public byte[] getBytes() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        COSInputStream cOSInputStreamCreateInputStream = null;
        try {
            if (getCOSObject() instanceof COSArray) {
                byte[] bArr = new byte[1024];
                COSArray cOSArray = (COSArray) getCOSObject();
                for (int i2 = 1; i2 < cOSArray.size(); i2 += 2) {
                    COSBase object = cOSArray.getObject(i2);
                    if (object instanceof COSStream) {
                        cOSInputStreamCreateInputStream = ((COSStream) object).createInputStream();
                        while (true) {
                            int i3 = cOSInputStreamCreateInputStream.read(bArr, 0, 1024);
                            if (i3 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i3);
                        }
                        byteArrayOutputStream.flush();
                    }
                }
            } else if (this.xfa.getCOSObject() instanceof COSStream) {
                byte[] bArr2 = new byte[1024];
                cOSInputStreamCreateInputStream = ((COSStream) this.xfa.getCOSObject()).createInputStream();
                while (true) {
                    int i4 = cOSInputStreamCreateInputStream.read(bArr2, 0, 1024);
                    if (i4 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i4);
                }
                byteArrayOutputStream.flush();
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            if (0 != 0) {
                cOSInputStreamCreateInputStream.close();
            }
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSBase getCOSObject() {
        return this.xfa;
    }

    public Document getDocument() throws ParserConfigurationException, SAXException, IOException {
        return XMLUtil.parse(new ByteArrayInputStream(getBytes()), true);
    }
}
