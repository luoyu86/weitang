package com.tom_roush.pdfbox.pdmodel.font;

import com.tom_roush.pdfbox.util.Charsets;
import com.tom_roush.pdfbox.util.Hex;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class ToUnicodeWriter {
    public static final int MAX_ENTRIES_PER_OPERATOR = 100;
    private final Map<Integer, String> cidToUnicode = new TreeMap();
    private int wMode = 0;

    private void writeLine(BufferedWriter bufferedWriter, String str) throws IOException {
        bufferedWriter.write(str);
        bufferedWriter.write(10);
    }

    public void add(int i2, String str) {
        if (i2 < 0 || i2 > 65535) {
            throw new IllegalArgumentException("CID is not valid");
        }
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Text is null or empty");
        }
        this.cidToUnicode.put(Integer.valueOf(i2), str);
    }

    public void setWMode(int i2) {
        this.wMode = i2;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, Charsets.US_ASCII));
        writeLine(bufferedWriter, "/CIDInit /ProcSet findresource begin");
        writeLine(bufferedWriter, "12 dict begin\n");
        writeLine(bufferedWriter, "begincmap");
        writeLine(bufferedWriter, "/CIDSystemInfo");
        writeLine(bufferedWriter, "<< /Registry (Adobe)");
        writeLine(bufferedWriter, "/Ordering (UCS)");
        writeLine(bufferedWriter, "/Supplement 0");
        writeLine(bufferedWriter, ">> def\n");
        writeLine(bufferedWriter, "/CMapName /Adobe-Identity-UCS def");
        writeLine(bufferedWriter, "/CMapType 2 def\n");
        if (this.wMode != 0) {
            writeLine(bufferedWriter, "/WMode /" + this.wMode + " def");
        }
        writeLine(bufferedWriter, "1 begincodespacerange");
        writeLine(bufferedWriter, "<0000> <FFFF>");
        writeLine(bufferedWriter, "endcodespacerange\n");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        String str = null;
        int i2 = -1;
        int i3 = -1;
        for (Map.Entry<Integer, String> entry : this.cidToUnicode.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            String value = entry.getValue();
            if (iIntValue == i2 + 1 && str.codePointCount(0, str.length()) == 1 && value.codePointAt(0) == str.codePointAt(0) + 1 && str.codePointAt(0) + 1 <= 255 - (iIntValue - i3)) {
                arrayList2.set(arrayList2.size() - 1, Integer.valueOf(iIntValue));
            } else {
                arrayList.add(Integer.valueOf(iIntValue));
                arrayList2.add(Integer.valueOf(iIntValue));
                arrayList3.add(value);
                i3 = iIntValue;
            }
            str = value;
            i2 = iIntValue;
        }
        int iCeil = (int) Math.ceil(((double) arrayList.size()) / 100.0d);
        int i4 = 0;
        while (i4 < iCeil) {
            int size = i4 == iCeil + (-1) ? arrayList.size() - (i4 * 100) : 100;
            bufferedWriter.write(size + " beginbfrange\n");
            for (int i5 = 0; i5 < size; i5++) {
                int i6 = (i4 * 100) + i5;
                bufferedWriter.write(60);
                bufferedWriter.write(Hex.getChars(((Integer) arrayList.get(i6)).shortValue()));
                bufferedWriter.write("> ");
                bufferedWriter.write(60);
                bufferedWriter.write(Hex.getChars(((Integer) arrayList2.get(i6)).shortValue()));
                bufferedWriter.write("> ");
                bufferedWriter.write(60);
                bufferedWriter.write(Hex.getCharsUTF16BE((String) arrayList3.get(i6)));
                bufferedWriter.write(">\n");
            }
            writeLine(bufferedWriter, "endbfrange\n");
            i4++;
        }
        writeLine(bufferedWriter, "endcmap");
        writeLine(bufferedWriter, "CMapName currentdict /CMap defineresource pop");
        writeLine(bufferedWriter, "end");
        writeLine(bufferedWriter, "end");
        bufferedWriter.flush();
    }
}
