package com.tom_roush.pdfbox.text;

import android.util.Log;
import androidx.appcompat.widget.ActivityChooserView;
import com.alipay.sdk.m.u.i;
import com.tom_roush.pdfbox.android.PDFBoxResourceLoader;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.PDPage;
import com.tom_roush.pdfbox.pdmodel.PDPageTree;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import com.tom_roush.pdfbox.pdmodel.interactive.pagenavigation.PDThreadBead;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.StringWriter;
import java.io.Writer;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class PDFTextStripper extends LegacyPDFStreamEngine {
    private static final float END_OF_LAST_TEXT_X_RESET_VALUE = -1.0f;
    private static final float EXPECTED_START_OF_NEXT_WORD_X_RESET_VALUE = -3.4028235E38f;
    private static final float LAST_WORD_SPACING_RESET_VALUE = -1.0f;
    private static final String[] LIST_ITEM_EXPRESSIONS;
    private static final float MAX_HEIGHT_FOR_LINE_RESET_VALUE = -1.0f;
    private static final float MAX_Y_FOR_LINE_RESET_VALUE = -3.4028235E38f;
    private static final float MIN_Y_TOP_FOR_LINE_RESET_VALUE = Float.MAX_VALUE;
    private static Map<Character, Character> MIRRORING_CHAR_MAP = null;
    private static float defaultDropThreshold = 2.5f;
    private static float defaultIndentThreshold = 2.0f;
    public final String LINE_SEPARATOR;
    private boolean addMoreFormatting;
    private String articleEnd;
    private String articleStart;
    private float averageCharTolerance;
    private List<PDRectangle> beadRectangles;
    private Map<String, TreeMap<Float, TreeSet<Float>>> characterListMapping;
    public ArrayList<List<TextPosition>> charactersByArticle;
    private int currentPageNo;
    public PDDocument document;
    private float dropThreshold;
    private PDOutlineItem endBookmark;
    private int endBookmarkPageNumber;
    private int endPage;
    private boolean inParagraph;
    private float indentThreshold;
    private String lineSeparator;
    private List<Pattern> listOfPatterns;
    public Writer output;
    private String pageEnd;
    private String pageStart;
    private String paragraphEnd;
    private String paragraphStart;
    private boolean shouldSeparateByBeads;
    private boolean sortByPosition;
    private float spacingTolerance;
    private PDOutlineItem startBookmark;
    private int startBookmarkPageNumber;
    private int startPage;
    private boolean suppressDuplicateOverlappingText;
    private String wordSeparator;

    public static final class PositionWrapper {
        private TextPosition position;
        private boolean isLineStart = false;
        private boolean isParagraphStart = false;
        private boolean isPageBreak = false;
        private boolean isHangingIndent = false;
        private boolean isArticleStart = false;

        public PositionWrapper(TextPosition textPosition) {
            this.position = null;
            this.position = textPosition;
        }

        public TextPosition getTextPosition() {
            return this.position;
        }

        public boolean isArticleStart() {
            return this.isArticleStart;
        }

        public boolean isHangingIndent() {
            return this.isHangingIndent;
        }

        public boolean isLineStart() {
            return this.isLineStart;
        }

        public boolean isPageBreak() {
            return this.isPageBreak;
        }

        public boolean isParagraphStart() {
            return this.isParagraphStart;
        }

        public void setArticleStart() {
            this.isArticleStart = true;
        }

        public void setHangingIndent() {
            this.isHangingIndent = true;
        }

        public void setLineStart() {
            this.isLineStart = true;
        }

        public void setPageBreak() {
            this.isPageBreak = true;
        }

        public void setParagraphStart() {
            this.isParagraphStart = true;
        }
    }

    public static final class WordWithTextPositions {
        public String text;
        public List<TextPosition> textPositions;

        public WordWithTextPositions(String str, List<TextPosition> list) {
            this.text = str;
            this.textPositions = list;
        }

        public String getText() {
            return this.text;
        }

        public List<TextPosition> getTextPositions() {
            return this.textPositions;
        }
    }

    static {
        String property;
        String property2;
        BufferedInputStream bufferedInputStream = null;
        try {
            String lowerCase = PDFTextStripper.class.getSimpleName().toLowerCase();
            property = System.getProperty(lowerCase + ".indent");
            try {
                property2 = System.getProperty(lowerCase + ".drop");
            } catch (SecurityException unused) {
                property2 = null;
            }
        } catch (SecurityException unused2) {
            property = null;
        }
        if (property != null && property.length() > 0) {
            try {
                defaultIndentThreshold = Float.parseFloat(property);
            } catch (NumberFormatException unused3) {
            }
        }
        if (property2 != null && property2.length() > 0) {
            try {
                defaultDropThreshold = Float.parseFloat(property2);
            } catch (NumberFormatException unused4) {
            }
        }
        LIST_ITEM_EXPRESSIONS = new String[]{"\\.", "\\d+\\.", "\\[\\d+\\]", "\\d+\\)", "[A-Z]\\.", "[a-z]\\.", "[A-Z]\\)", "[a-z]\\)", "[IVXL]+\\.", "[ivxl]+\\."};
        MIRRORING_CHAR_MAP = new HashMap();
        try {
            try {
                try {
                    if (PDFBoxResourceLoader.isReady()) {
                        bufferedInputStream = new BufferedInputStream(PDFBoxResourceLoader.getStream("com/tom_roush/pdfbox/resources/text/BidiMirroring.txt"));
                    } else {
                        bufferedInputStream = new BufferedInputStream(PDFTextStripper.class.getResourceAsStream("/com/tom_roush/pdfbox/resources/text/BidiMirroring.txt"));
                    }
                    parseBidiFile(bufferedInputStream);
                    bufferedInputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        Log.e("PdfBox-Android", "Could not close BidiMirroring.txt ", e2);
                    }
                    throw th;
                }
            } catch (IOException e3) {
                Log.w("PdfBox-Android", "Could not parse BidiMirroring.txt, mirroring char map will be empty: " + e3.getMessage());
                bufferedInputStream.close();
            }
        } catch (IOException e4) {
            Log.e("PdfBox-Android", "Could not close BidiMirroring.txt ", e4);
        }
    }

    public PDFTextStripper() throws IOException {
        String property = System.getProperty("line.separator");
        this.LINE_SEPARATOR = property;
        this.lineSeparator = property;
        this.wordSeparator = " ";
        this.paragraphStart = "";
        this.paragraphEnd = "";
        this.pageStart = "";
        this.pageEnd = property;
        this.articleStart = "";
        this.articleEnd = "";
        this.currentPageNo = 0;
        this.startPage = 1;
        this.endPage = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.startBookmark = null;
        this.startBookmarkPageNumber = -1;
        this.endBookmarkPageNumber = -1;
        this.endBookmark = null;
        this.suppressDuplicateOverlappingText = true;
        this.shouldSeparateByBeads = true;
        this.sortByPosition = false;
        this.addMoreFormatting = false;
        this.indentThreshold = defaultIndentThreshold;
        this.dropThreshold = defaultDropThreshold;
        this.spacingTolerance = 0.5f;
        this.averageCharTolerance = 0.3f;
        this.beadRectangles = null;
        this.charactersByArticle = new ArrayList<>();
        this.characterListMapping = new HashMap();
        this.listOfPatterns = null;
    }

    private WordWithTextPositions createWord(String str, List<TextPosition> list) {
        return new WordWithTextPositions(normalizeWord(str), list);
    }

    private void fillBeadRectangles(PDPage pDPage) {
        this.beadRectangles = new ArrayList();
        for (PDThreadBead pDThreadBead : pDPage.getThreadBeads()) {
            if (pDThreadBead == null || pDThreadBead.getRectangle() == null) {
                this.beadRectangles.add(null);
            } else {
                PDRectangle rectangle = pDThreadBead.getRectangle();
                PDRectangle mediaBox = pDPage.getMediaBox();
                float upperRightY = mediaBox.getUpperRightY() - rectangle.getLowerLeftY();
                rectangle.setLowerLeftY(mediaBox.getUpperRightY() - rectangle.getUpperRightY());
                rectangle.setUpperRightY(upperRightY);
                PDRectangle cropBox = pDPage.getCropBox();
                if (cropBox.getLowerLeftX() != 0.0f || cropBox.getLowerLeftY() != 0.0f) {
                    rectangle.setLowerLeftX(rectangle.getLowerLeftX() - cropBox.getLowerLeftX());
                    rectangle.setLowerLeftY(rectangle.getLowerLeftY() - cropBox.getLowerLeftY());
                    rectangle.setUpperRightX(rectangle.getUpperRightX() - cropBox.getLowerLeftX());
                    rectangle.setUpperRightY(rectangle.getUpperRightY() - cropBox.getLowerLeftY());
                }
                this.beadRectangles.add(rectangle);
            }
        }
    }

    private String handleDirection(String str) {
        Bidi bidi = new Bidi(str, -2);
        if (!bidi.isMixed() && bidi.getBaseLevel() == 0) {
            return str;
        }
        int runCount = bidi.getRunCount();
        byte[] bArr = new byte[runCount];
        Integer[] numArr = new Integer[runCount];
        for (int i2 = 0; i2 < runCount; i2++) {
            bArr[i2] = (byte) bidi.getRunLevel(i2);
            numArr[i2] = Integer.valueOf(i2);
        }
        Bidi.reorderVisually(bArr, 0, numArr, 0, runCount);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < runCount; i3++) {
            int iIntValue = numArr[i3].intValue();
            int runStart = bidi.getRunStart(iIntValue);
            int runLimit = bidi.getRunLimit(iIntValue);
            if ((bArr[iIntValue] & 1) != 0) {
                while (true) {
                    runLimit--;
                    if (runLimit >= runStart) {
                        char cCharAt = str.charAt(runLimit);
                        if (!Character.isMirrored(str.codePointAt(runLimit))) {
                            sb.append(cCharAt);
                        } else if (MIRRORING_CHAR_MAP.containsKey(Character.valueOf(cCharAt))) {
                            sb.append(MIRRORING_CHAR_MAP.get(Character.valueOf(cCharAt)));
                        } else {
                            sb.append(cCharAt);
                        }
                    }
                }
            } else {
                sb.append((CharSequence) str, runStart, runLimit);
            }
        }
        return sb.toString();
    }

    private PositionWrapper handleLineSeparation(PositionWrapper positionWrapper, PositionWrapper positionWrapper2, PositionWrapper positionWrapper3, float f2) throws IOException {
        positionWrapper.setLineStart();
        isParagraphSeparation(positionWrapper, positionWrapper2, positionWrapper3, f2);
        if (!positionWrapper.isParagraphStart()) {
            writeLineSeparator();
        } else if (positionWrapper2.isArticleStart()) {
            if (positionWrapper2.isLineStart()) {
                writeLineSeparator();
            }
            writeParagraphStart();
        } else {
            writeLineSeparator();
            writeParagraphSeparator();
        }
        return positionWrapper;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void isParagraphSeparation(com.tom_roush.pdfbox.text.PDFTextStripper.PositionWrapper r6, com.tom_roush.pdfbox.text.PDFTextStripper.PositionWrapper r7, com.tom_roush.pdfbox.text.PDFTextStripper.PositionWrapper r8, float r9) {
        /*
            r5 = this;
            r0 = 1
            if (r8 != 0) goto L5
            goto L9f
        L5:
            com.tom_roush.pdfbox.text.TextPosition r1 = r6.getTextPosition()
            float r1 = r1.getYDirAdj()
            com.tom_roush.pdfbox.text.TextPosition r7 = r7.getTextPosition()
            float r7 = r7.getYDirAdj()
            float r1 = r1 - r7
            float r7 = java.lang.Math.abs(r1)
            float r1 = r5.getDropThreshold()
            float r9 = r5.multiplyFloat(r1, r9)
            com.tom_roush.pdfbox.text.TextPosition r1 = r6.getTextPosition()
            float r1 = r1.getXDirAdj()
            com.tom_roush.pdfbox.text.TextPosition r2 = r8.getTextPosition()
            float r2 = r2.getXDirAdj()
            float r1 = r1 - r2
            float r2 = r5.getIndentThreshold()
            com.tom_roush.pdfbox.text.TextPosition r3 = r6.getTextPosition()
            float r3 = r3.getWidthOfSpace()
            float r2 = r5.multiplyFloat(r2, r3)
            r3 = 1048576000(0x3e800000, float:0.25)
            com.tom_roush.pdfbox.text.TextPosition r4 = r6.getTextPosition()
            float r4 = r4.getWidth()
            float r3 = r5.multiplyFloat(r3, r4)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 <= 0) goto L56
            goto L9f
        L56:
            int r7 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r7 <= 0) goto L65
            boolean r7 = r8.isParagraphStart()
            if (r7 != 0) goto L61
            goto L9f
        L61:
            r6.setHangingIndent()
            goto L9e
        L65:
            com.tom_roush.pdfbox.text.TextPosition r7 = r6.getTextPosition()
            float r7 = r7.getWidthOfSpace()
            float r7 = -r7
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 >= 0) goto L79
            boolean r7 = r8.isParagraphStart()
            if (r7 != 0) goto L9e
            goto L9f
        L79:
            float r7 = java.lang.Math.abs(r1)
            int r7 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r7 >= 0) goto L9e
            boolean r7 = r8.isHangingIndent()
            if (r7 == 0) goto L8b
            r6.setHangingIndent()
            goto L9e
        L8b:
            boolean r7 = r8.isParagraphStart()
            if (r7 == 0) goto L9e
            java.util.regex.Pattern r7 = r5.matchListItemPattern(r8)
            if (r7 == 0) goto L9e
            java.util.regex.Pattern r8 = r5.matchListItemPattern(r6)
            if (r7 != r8) goto L9e
            goto L9f
        L9e:
            r0 = 0
        L9f:
            if (r0 == 0) goto La4
            r6.setParagraphStart()
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.text.PDFTextStripper.isParagraphSeparation(com.tom_roush.pdfbox.text.PDFTextStripper$PositionWrapper, com.tom_roush.pdfbox.text.PDFTextStripper$PositionWrapper, com.tom_roush.pdfbox.text.PDFTextStripper$PositionWrapper, float):void");
    }

    private Pattern matchListItemPattern(PositionWrapper positionWrapper) {
        return matchPattern(positionWrapper.getTextPosition().getUnicode(), getListItemPatterns());
    }

    public static Pattern matchPattern(String str, List<Pattern> list) {
        for (Pattern pattern : list) {
            if (pattern.matcher(str).matches()) {
                return pattern;
            }
        }
        return null;
    }

    private float multiplyFloat(float f2, float f3) {
        return Math.round((f2 * f3) * 1000.0f) / 1000.0f;
    }

    private List<WordWithTextPositions> normalize(List<LineItem> list) {
        LinkedList linkedList = new LinkedList();
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        Iterator<LineItem> it = list.iterator();
        while (it.hasNext()) {
            sb = normalizeAdd(linkedList, sb, arrayList, it.next());
        }
        if (sb.length() > 0) {
            linkedList.add(createWord(sb.toString(), arrayList));
        }
        return linkedList;
    }

    private StringBuilder normalizeAdd(List<WordWithTextPositions> list, StringBuilder sb, List<TextPosition> list2, LineItem lineItem) {
        if (lineItem.isWordSeparator()) {
            list.add(createWord(sb.toString(), new ArrayList(list2)));
            StringBuilder sb2 = new StringBuilder();
            list2.clear();
            return sb2;
        }
        TextPosition textPosition = lineItem.getTextPosition();
        sb.append(textPosition.getUnicode());
        list2.add(textPosition);
        return sb;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String normalizeWord(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = r7.length()
            r1 = 0
            r2 = 0
            r3 = r2
            r2 = 0
        L8:
            if (r1 >= r0) goto L66
            char r4 = r7.charAt(r1)
            r5 = 64256(0xfb00, float:9.0042E-41)
            if (r5 > r4) goto L18
            r5 = 65023(0xfdff, float:9.1117E-41)
            if (r4 <= r5) goto L22
        L18:
            r5 = 65136(0xfe70, float:9.1275E-41)
            if (r5 > r4) goto L63
            r5 = 65279(0xfeff, float:9.1475E-41)
            if (r4 > r5) goto L63
        L22:
            if (r3 != 0) goto L2b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r5 = r0 * 2
            r3.<init>(r5)
        L2b:
            r3.append(r7, r2, r1)
            r2 = 65010(0xfdf2, float:9.1098E-41)
            if (r4 != r2) goto L4e
            if (r1 <= 0) goto L4e
            int r2 = r1 + (-1)
            char r4 = r7.charAt(r2)
            r5 = 1575(0x627, float:2.207E-42)
            if (r4 == r5) goto L48
            char r2 = r7.charAt(r2)
            r4 = 65165(0xfe8d, float:9.1316E-41)
            if (r2 != r4) goto L4e
        L48:
            java.lang.String r2 = "لله"
            r3.append(r2)
            goto L61
        L4e:
            int r2 = r1 + 1
            java.lang.String r2 = r7.substring(r1, r2)
            java.text.Normalizer$Form r4 = java.text.Normalizer.Form.NFKC
            java.lang.String r2 = java.text.Normalizer.normalize(r2, r4)
            java.lang.String r2 = r2.trim()
            r3.append(r2)
        L61:
            int r2 = r1 + 1
        L63:
            int r1 = r1 + 1
            goto L8
        L66:
            if (r3 != 0) goto L6d
            java.lang.String r7 = r6.handleDirection(r7)
            return r7
        L6d:
            r3.append(r7, r2, r1)
            java.lang.String r7 = r3.toString()
            java.lang.String r7 = r6.handleDirection(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.text.PDFTextStripper.normalizeWord(java.lang.String):java.lang.String");
    }

    private boolean overlap(float f2, float f3, float f4, float f5) {
        return within(f2, f4, 0.1f) || (f4 <= f2 && f4 >= f2 - f3) || (f2 <= f4 && f2 >= f4 - f5);
    }

    private static void parseBidiFile(InputStream inputStream) throws IOException {
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream));
        while (true) {
            String line = lineNumberReader.readLine();
            if (line == null) {
                return;
            }
            int iIndexOf = line.indexOf(35);
            if (iIndexOf != -1) {
                line = line.substring(0, iIndexOf);
            }
            if (line.length() >= 2) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, i.f5697b);
                int iCountTokens = stringTokenizer.countTokens();
                Character[] chArr = new Character[iCountTokens];
                for (int i2 = 0; i2 < iCountTokens; i2++) {
                    chArr[i2] = Character.valueOf((char) Integer.parseInt(stringTokenizer.nextToken().trim(), 16));
                }
                if (iCountTokens == 2) {
                    MIRRORING_CHAR_MAP.put(chArr[0], chArr[1]);
                }
            }
        }
    }

    private void resetEngine() {
        this.currentPageNo = 0;
        this.document = null;
        ArrayList<List<TextPosition>> arrayList = this.charactersByArticle;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.characterListMapping.clear();
    }

    private boolean within(float f2, float f3, float f4) {
        return f3 < f2 + f4 && f3 > f2 - f4;
    }

    private void writeLine(List<WordWithTextPositions> list) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            WordWithTextPositions wordWithTextPositions = list.get(i2);
            writeString(wordWithTextPositions.getText(), wordWithTextPositions.getTextPositions());
            if (i2 < size - 1) {
                writeWordSeparator();
            }
        }
    }

    public void endArticle() throws IOException {
        this.output.write(getArticleEnd());
    }

    public void endDocument(PDDocument pDDocument) throws IOException {
    }

    public void endPage(PDPage pDPage) throws IOException {
    }

    public boolean getAddMoreFormatting() {
        return this.addMoreFormatting;
    }

    public String getArticleEnd() {
        return this.articleEnd;
    }

    public String getArticleStart() {
        return this.articleStart;
    }

    public float getAverageCharTolerance() {
        return this.averageCharTolerance;
    }

    public List<List<TextPosition>> getCharactersByArticle() {
        return this.charactersByArticle;
    }

    public int getCurrentPageNo() {
        return this.currentPageNo;
    }

    public float getDropThreshold() {
        return this.dropThreshold;
    }

    public PDOutlineItem getEndBookmark() {
        return this.endBookmark;
    }

    public int getEndPage() {
        return this.endPage;
    }

    public float getIndentThreshold() {
        return this.indentThreshold;
    }

    public String getLineSeparator() {
        return this.lineSeparator;
    }

    public List<Pattern> getListItemPatterns() {
        if (this.listOfPatterns == null) {
            this.listOfPatterns = new ArrayList();
            for (String str : LIST_ITEM_EXPRESSIONS) {
                this.listOfPatterns.add(Pattern.compile(str));
            }
        }
        return this.listOfPatterns;
    }

    public Writer getOutput() {
        return this.output;
    }

    public String getPageEnd() {
        return this.pageEnd;
    }

    public String getPageStart() {
        return this.pageStart;
    }

    public String getParagraphEnd() {
        return this.paragraphEnd;
    }

    public String getParagraphStart() {
        return this.paragraphStart;
    }

    public boolean getSeparateByBeads() {
        return this.shouldSeparateByBeads;
    }

    public boolean getSortByPosition() {
        return this.sortByPosition;
    }

    public float getSpacingTolerance() {
        return this.spacingTolerance;
    }

    public PDOutlineItem getStartBookmark() {
        return this.startBookmark;
    }

    public int getStartPage() {
        return this.startPage;
    }

    public boolean getSuppressDuplicateOverlappingText() {
        return this.suppressDuplicateOverlappingText;
    }

    public String getText(PDDocument pDDocument) throws IOException {
        StringWriter stringWriter = new StringWriter();
        writeText(pDDocument, stringWriter);
        return stringWriter.toString();
    }

    public String getWordSeparator() {
        return this.wordSeparator;
    }

    @Override // com.tom_roush.pdfbox.text.LegacyPDFStreamEngine, com.tom_roush.pdfbox.contentstream.PDFStreamEngine
    public void processPage(PDPage pDPage) throws IOException {
        int i2 = this.currentPageNo;
        if (i2 < this.startPage || i2 > this.endPage) {
            return;
        }
        int i3 = this.startBookmarkPageNumber;
        if (i3 == -1 || i2 >= i3) {
            int i4 = this.endBookmarkPageNumber;
            if (i4 == -1 || i2 <= i4) {
                startPage(pDPage);
                int size = 1;
                if (this.shouldSeparateByBeads) {
                    fillBeadRectangles(pDPage);
                    size = 1 + (this.beadRectangles.size() * 2);
                }
                int size2 = this.charactersByArticle.size();
                this.charactersByArticle.ensureCapacity(size);
                int iMax = Math.max(size, size2);
                for (int i5 = 0; i5 < iMax; i5++) {
                    if (i5 < size2) {
                        this.charactersByArticle.get(i5).clear();
                    } else if (size < size2) {
                        this.charactersByArticle.remove(i5);
                    } else {
                        this.charactersByArticle.add(new ArrayList());
                    }
                }
                this.characterListMapping.clear();
                super.processPage(pDPage);
                writePage();
                endPage(pDPage);
            }
        }
    }

    public void processPages(PDPageTree pDPageTree) throws IOException {
        PDOutlineItem pDOutlineItem;
        PDOutlineItem pDOutlineItem2 = this.startBookmark;
        PDPage pDPageFindDestinationPage = pDOutlineItem2 == null ? null : pDOutlineItem2.findDestinationPage(this.document);
        if (pDPageFindDestinationPage != null) {
            this.startBookmarkPageNumber = pDPageTree.indexOf(pDPageFindDestinationPage) + 1;
        } else {
            this.startBookmarkPageNumber = -1;
        }
        PDOutlineItem pDOutlineItem3 = this.endBookmark;
        PDPage pDPageFindDestinationPage2 = pDOutlineItem3 != null ? pDOutlineItem3.findDestinationPage(this.document) : null;
        if (pDPageFindDestinationPage2 != null) {
            this.endBookmarkPageNumber = pDPageTree.indexOf(pDPageFindDestinationPage2) + 1;
        } else {
            this.endBookmarkPageNumber = -1;
        }
        if (this.startBookmarkPageNumber == -1 && (pDOutlineItem = this.startBookmark) != null && this.endBookmarkPageNumber == -1 && this.endBookmark != null && pDOutlineItem.getCOSObject() == this.endBookmark.getCOSObject()) {
            this.startBookmarkPageNumber = 0;
            this.endBookmarkPageNumber = 0;
        }
        for (PDPage pDPage : pDPageTree) {
            this.currentPageNo++;
            if (pDPage.hasContents()) {
                processPage(pDPage);
            }
        }
    }

    @Override // com.tom_roush.pdfbox.text.LegacyPDFStreamEngine
    public void processTextPosition(TextPosition textPosition) {
        boolean z;
        int i2;
        int i3;
        int i4;
        boolean z2;
        int size = 0;
        if (this.suppressDuplicateOverlappingText) {
            String unicode = textPosition.getUnicode();
            float x = textPosition.getX();
            float y = textPosition.getY();
            TreeMap<Float, TreeSet<Float>> treeMap = this.characterListMapping.get(unicode);
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                this.characterListMapping.put(unicode, treeMap);
            }
            float width = (textPosition.getWidth() / unicode.length()) / 3.0f;
            Iterator<TreeSet<Float>> it = treeMap.subMap(Float.valueOf(x - width), Float.valueOf(x + width)).values().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!it.next().subSet(Float.valueOf(y - width), Float.valueOf(y + width)).isEmpty()) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                z = false;
            } else {
                TreeSet<Float> treeSet = treeMap.get(Float.valueOf(x));
                if (treeSet == null) {
                    treeSet = new TreeSet<>();
                    treeMap.put(Float.valueOf(x), treeSet);
                }
                treeSet.add(Float.valueOf(y));
                z = true;
            }
        } else {
            z = true;
        }
        if (z) {
            float x2 = textPosition.getX();
            float y2 = textPosition.getY();
            if (this.shouldSeparateByBeads) {
                int i5 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                for (int i6 = 0; i6 < this.beadRectangles.size() && i5 == -1; i6++) {
                    PDRectangle pDRectangle = this.beadRectangles.get(i6);
                    if (pDRectangle == null) {
                        i5 = 0;
                    } else if (pDRectangle.contains(x2, y2)) {
                        i5 = (i6 * 2) + 1;
                    } else if ((x2 < pDRectangle.getLowerLeftX() || y2 < pDRectangle.getUpperRightY()) && i2 == -1) {
                        i2 = i6 * 2;
                    } else if (x2 < pDRectangle.getLowerLeftX() && i3 == -1) {
                        i3 = i6 * 2;
                    } else if (y2 < pDRectangle.getUpperRightY() && i4 == -1) {
                        i4 = i6 * 2;
                    }
                }
                size = i5;
            } else {
                i2 = -1;
                i3 = -1;
                i4 = -1;
            }
            if (size == -1) {
                size = i2 != -1 ? i2 : i3 != -1 ? i3 : i4 != -1 ? i4 : this.charactersByArticle.size() - 1;
            }
            List<TextPosition> list = this.charactersByArticle.get(size);
            if (list.isEmpty()) {
                list.add(textPosition);
                return;
            }
            TextPosition textPosition2 = list.get(list.size() - 1);
            if (textPosition.isDiacritic() && textPosition2.contains(textPosition)) {
                textPosition2.mergeDiacritic(textPosition);
                return;
            }
            if (!textPosition2.isDiacritic() || !textPosition.contains(textPosition2)) {
                list.add(textPosition);
                return;
            }
            textPosition.mergeDiacritic(textPosition2);
            list.remove(list.size() - 1);
            list.add(textPosition);
        }
    }

    public void setAddMoreFormatting(boolean z) {
        this.addMoreFormatting = z;
    }

    public void setArticleEnd(String str) {
        this.articleEnd = str;
    }

    public void setArticleStart(String str) {
        this.articleStart = str;
    }

    public void setAverageCharTolerance(float f2) {
        this.averageCharTolerance = f2;
    }

    public void setDropThreshold(float f2) {
        this.dropThreshold = f2;
    }

    public void setEndBookmark(PDOutlineItem pDOutlineItem) {
        this.endBookmark = pDOutlineItem;
    }

    public void setEndPage(int i2) {
        this.endPage = i2;
    }

    public void setIndentThreshold(float f2) {
        this.indentThreshold = f2;
    }

    public void setLineSeparator(String str) {
        this.lineSeparator = str;
    }

    public void setListItemPatterns(List<Pattern> list) {
        this.listOfPatterns = list;
    }

    public void setPageEnd(String str) {
        this.pageEnd = str;
    }

    public void setPageStart(String str) {
        this.pageStart = str;
    }

    public void setParagraphEnd(String str) {
        this.paragraphEnd = str;
    }

    public void setParagraphStart(String str) {
        this.paragraphStart = str;
    }

    public void setShouldSeparateByBeads(boolean z) {
        this.shouldSeparateByBeads = z;
    }

    public void setSortByPosition(boolean z) {
        this.sortByPosition = z;
    }

    public void setSpacingTolerance(float f2) {
        this.spacingTolerance = f2;
    }

    public void setStartBookmark(PDOutlineItem pDOutlineItem) {
        this.startBookmark = pDOutlineItem;
    }

    public void setStartPage(int i2) {
        this.startPage = i2;
    }

    public void setSuppressDuplicateOverlappingText(boolean z) {
        this.suppressDuplicateOverlappingText = z;
    }

    public void setWordSeparator(String str) {
        this.wordSeparator = str;
    }

    public void startArticle() throws IOException {
        startArticle(true);
    }

    public void startDocument(PDDocument pDDocument) throws IOException {
    }

    public void startPage(PDPage pDPage) throws IOException {
    }

    public void writeCharacters(TextPosition textPosition) throws IOException {
        this.output.write(textPosition.getUnicode());
    }

    public void writeLineSeparator() throws IOException {
        this.output.write(getLineSeparator());
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01bf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writePage() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.text.PDFTextStripper.writePage():void");
    }

    public void writePageEnd() throws IOException {
        this.output.write(getPageEnd());
    }

    public void writePageStart() throws IOException {
        this.output.write(getPageStart());
    }

    public void writeParagraphEnd() throws IOException {
        if (!this.inParagraph) {
            writeParagraphStart();
        }
        this.output.write(getParagraphEnd());
        this.inParagraph = false;
    }

    public void writeParagraphSeparator() throws IOException {
        writeParagraphEnd();
        writeParagraphStart();
    }

    public void writeParagraphStart() throws IOException {
        if (this.inParagraph) {
            writeParagraphEnd();
            this.inParagraph = false;
        }
        this.output.write(getParagraphStart());
        this.inParagraph = true;
    }

    public void writeString(String str, List<TextPosition> list) throws IOException {
        writeString(str);
    }

    public void writeText(PDDocument pDDocument, Writer writer) throws IOException {
        resetEngine();
        this.document = pDDocument;
        this.output = writer;
        if (getAddMoreFormatting()) {
            String str = this.lineSeparator;
            this.paragraphEnd = str;
            this.pageStart = str;
            this.articleStart = str;
            this.articleEnd = str;
        }
        startDocument(this.document);
        processPages(this.document.getPages());
        endDocument(this.document);
    }

    public void writeWordSeparator() throws IOException {
        this.output.write(getWordSeparator());
    }

    public static final class LineItem {
        public static LineItem WORD_SEPARATOR = new LineItem();
        private final TextPosition textPosition;

        private LineItem() {
            this.textPosition = null;
        }

        public static LineItem getWordSeparator() {
            return WORD_SEPARATOR;
        }

        public TextPosition getTextPosition() {
            return this.textPosition;
        }

        public boolean isWordSeparator() {
            return this.textPosition == null;
        }

        public LineItem(TextPosition textPosition) {
            this.textPosition = textPosition;
        }
    }

    public void startArticle(boolean z) throws IOException {
        this.output.write(getArticleStart());
    }

    public void writeString(String str) throws IOException {
        this.output.write(str);
    }
}
