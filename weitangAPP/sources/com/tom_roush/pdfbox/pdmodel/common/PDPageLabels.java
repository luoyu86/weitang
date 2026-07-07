package com.tom_roush.pdfbox.pdmodel.common;

import com.taobao.accs.AccsState;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSInteger;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class PDPageLabels implements COSObjectable {
    private PDDocument doc;
    private Map<Integer, PDPageLabelRange> labels;

    public static class LabelGenerator implements Iterator<String> {
        private static final String[][] ROMANS = {new String[]{"", OperatorName.SET_FLATNESS, "ii", "iii", "iv", "v", "vi", "vii", "viii", "ix"}, new String[]{"", "x", "xx", "xxx", "xl", OperatorName.LINE_TO, "lx", "lxx", "lxxx", "xc"}, new String[]{"", OperatorName.CURVE_TO, AccsState.CONNECTION_CHANGE, "ccc", "cd", OperatorName.SET_LINE_DASHPATTERN, "dc", "dcc", "dccc", OperatorName.CONCAT}};
        private int currentPage = 0;
        private final PDPageLabelRange labelInfo;
        private final int numPages;

        public LabelGenerator(PDPageLabelRange pDPageLabelRange, int i2) {
            this.labelInfo = pDPageLabelRange;
            this.numPages = i2;
        }

        private String getNumber(int i2, String str) {
            return "D".equals(str) ? Integer.toString(i2) : PDPageLabelRange.STYLE_LETTERS_LOWER.equals(str) ? makeLetterLabel(i2) : "A".equals(str) ? makeLetterLabel(i2).toUpperCase() : PDPageLabelRange.STYLE_ROMAN_LOWER.equals(str) ? makeRomanLabel(i2) : "R".equals(str) ? makeRomanLabel(i2).toUpperCase() : Integer.toString(i2);
        }

        private static String makeLetterLabel(int i2) {
            StringBuilder sb = new StringBuilder();
            int i3 = i2 / 26;
            int i4 = i2 % 26;
            int iSignum = i3 + Integer.signum(i4);
            int iSignum2 = ((i4 + ((1 - Integer.signum(i4)) * 26)) + 97) - 1;
            for (int i5 = 0; i5 < iSignum; i5++) {
                sb.appendCodePoint(iSignum2);
            }
            return sb.toString();
        }

        private static String makeRomanLabel(int i2) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < 3 && i2 > 0; i3++) {
                sb.insert(0, ROMANS[i3][i2 % 10]);
                i2 /= 10;
            }
            for (int i4 = 0; i4 < i2; i4++) {
                sb.insert(0, 'm');
            }
            return sb.toString();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.currentPage < this.numPages;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            StringBuilder sb = new StringBuilder();
            String prefix = this.labelInfo.getPrefix();
            if (prefix != null) {
                int iIndexOf = prefix.indexOf(0);
                if (iIndexOf > -1) {
                    prefix = prefix.substring(0, iIndexOf);
                }
                sb.append(prefix);
            }
            String style = this.labelInfo.getStyle();
            if (style != null) {
                sb.append(getNumber(this.labelInfo.getStart() + this.currentPage, style));
            }
            this.currentPage++;
            return sb.toString();
        }
    }

    public interface LabelHandler {
        void newLabel(int i2, String str);
    }

    public PDPageLabels(PDDocument pDDocument) {
        this.labels = new TreeMap();
        this.doc = pDDocument;
        PDPageLabelRange pDPageLabelRange = new PDPageLabelRange();
        pDPageLabelRange.setStyle("D");
        this.labels.put(0, pDPageLabelRange);
    }

    private void computeLabels(LabelHandler labelHandler) {
        Iterator<Map.Entry<Integer, PDPageLabelRange>> it = this.labels.entrySet().iterator();
        if (it.hasNext()) {
            int i2 = 0;
            Map.Entry<Integer, PDPageLabelRange> next = it.next();
            while (it.hasNext()) {
                Map.Entry<Integer, PDPageLabelRange> next2 = it.next();
                LabelGenerator labelGenerator = new LabelGenerator(next.getValue(), next2.getKey().intValue() - next.getKey().intValue());
                while (labelGenerator.hasNext()) {
                    labelHandler.newLabel(i2, labelGenerator.next());
                    i2++;
                }
                next = next2;
            }
            LabelGenerator labelGenerator2 = new LabelGenerator(next.getValue(), this.doc.getNumberOfPages() - next.getKey().intValue());
            while (labelGenerator2.hasNext()) {
                labelHandler.newLabel(i2, labelGenerator2.next());
                i2++;
            }
        }
    }

    private void findLabels(PDNumberTreeNode pDNumberTreeNode) throws IOException {
        List<PDNumberTreeNode> kids = pDNumberTreeNode.getKids();
        if (pDNumberTreeNode.getKids() != null) {
            Iterator<PDNumberTreeNode> it = kids.iterator();
            while (it.hasNext()) {
                findLabels(it.next());
            }
            return;
        }
        Map<Integer, COSObjectable> numbers = pDNumberTreeNode.getNumbers();
        if (numbers != null) {
            for (Map.Entry<Integer, COSObjectable> entry : numbers.entrySet()) {
                if (entry.getKey().intValue() >= 0) {
                    this.labels.put(entry.getKey(), (PDPageLabelRange) entry.getValue());
                }
            }
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSBase getCOSObject() {
        COSDictionary cOSDictionary = new COSDictionary();
        COSArray cOSArray = new COSArray();
        for (Map.Entry<Integer, PDPageLabelRange> entry : this.labels.entrySet()) {
            cOSArray.add((COSBase) COSInteger.get(entry.getKey().intValue()));
            cOSArray.add(entry.getValue());
        }
        cOSDictionary.setItem(COSName.NUMS, (COSBase) cOSArray);
        return cOSDictionary;
    }

    public String[] getLabelsByPageIndices() {
        final int numberOfPages = this.doc.getNumberOfPages();
        final String[] strArr = new String[numberOfPages];
        computeLabels(new LabelHandler() { // from class: com.tom_roush.pdfbox.pdmodel.common.PDPageLabels.2
            @Override // com.tom_roush.pdfbox.pdmodel.common.PDPageLabels.LabelHandler
            public void newLabel(int i2, String str) {
                if (i2 < numberOfPages) {
                    strArr[i2] = str;
                }
            }
        });
        return strArr;
    }

    public NavigableSet<Integer> getPageIndices() {
        return new TreeSet(this.labels.keySet());
    }

    public Map<String, Integer> getPageIndicesByLabels() {
        final HashMap map = new HashMap(this.doc.getNumberOfPages());
        computeLabels(new LabelHandler() { // from class: com.tom_roush.pdfbox.pdmodel.common.PDPageLabels.1
            @Override // com.tom_roush.pdfbox.pdmodel.common.PDPageLabels.LabelHandler
            public void newLabel(int i2, String str) {
                map.put(str, Integer.valueOf(i2));
            }
        });
        return map;
    }

    public PDPageLabelRange getPageLabelRange(int i2) {
        return this.labels.get(Integer.valueOf(i2));
    }

    public int getPageRangeCount() {
        return this.labels.size();
    }

    public void setLabelItem(int i2, PDPageLabelRange pDPageLabelRange) {
        if (i2 < 0) {
            throw new IllegalArgumentException("startPage parameter of setLabelItem may not be < 0");
        }
        this.labels.put(Integer.valueOf(i2), pDPageLabelRange);
    }

    public PDPageLabels(PDDocument pDDocument, COSDictionary cOSDictionary) throws IOException {
        this(pDDocument);
        if (cOSDictionary == null) {
            return;
        }
        findLabels(new PDNumberTreeNode(cOSDictionary, PDPageLabelRange.class));
    }
}
