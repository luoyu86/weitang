package com.tom_roush.pdfbox.pdmodel.interactive.form;

import com.tom_roush.pdfbox.pdmodel.font.PDFont;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PlainText {
    private static final float FONTSCALE = 1000.0f;
    private final List<Paragraph> paragraphs;

    public static class Line {
        private float lineWidth;
        private final List<Word> words = new ArrayList();

        public void addWord(Word word) {
            this.words.add(word);
        }

        public float calculateWidth(PDFont pDFont, float f2) throws IOException {
            float f3 = f2 / PlainText.FONTSCALE;
            float fFloatValue = 0.0f;
            int i2 = 0;
            for (Word word : this.words) {
                fFloatValue += ((Float) word.getAttributes().getIterator().getAttribute(TextAttribute.WIDTH)).floatValue();
                String text = word.getText();
                if (i2 == this.words.size() - 1 && Character.isWhitespace(text.charAt(text.length() - 1))) {
                    fFloatValue -= pDFont.getStringWidth(text.substring(text.length() - 1)) * f3;
                }
                i2++;
            }
            return fFloatValue;
        }

        public float getInterWordSpacing(float f2) {
            return (f2 - this.lineWidth) / (this.words.size() - 1);
        }

        public float getWidth() {
            return this.lineWidth;
        }

        public List<Word> getWords() {
            return this.words;
        }

        public void setWidth(float f2) {
            this.lineWidth = f2;
        }
    }

    public static class Paragraph {
        private final String textContent;

        public Paragraph(String str) {
            this.textContent = str;
        }

        public List<Line> getLines(PDFont pDFont, float f2, float f3) throws IOException {
            String strSubstring;
            BreakIterator lineInstance = BreakIterator.getLineInstance();
            lineInstance.setText(this.textContent);
            float f4 = f2 / PlainText.FONTSCALE;
            int iFirst = lineInstance.first();
            int next = lineInstance.next();
            ArrayList arrayList = new ArrayList();
            Line line = new Line();
            float stringWidth = 0.0f;
            while (next != -1) {
                String strSubstring2 = this.textContent.substring(iFirst, next);
                float stringWidth2 = pDFont.getStringWidth(strSubstring2) * f4;
                int i2 = next - iFirst;
                stringWidth += stringWidth2;
                boolean z = true;
                if (stringWidth >= f3 && Character.isWhitespace(strSubstring2.charAt(strSubstring2.length() - 1))) {
                    stringWidth -= pDFont.getStringWidth(strSubstring2.substring(strSubstring2.length() - 1)) * f4;
                }
                if (stringWidth >= f3 && !line.getWords().isEmpty()) {
                    line.setWidth(line.calculateWidth(pDFont, f2));
                    arrayList.add(line);
                    line = new Line();
                    stringWidth = pDFont.getStringWidth(strSubstring2) * f4;
                }
                if (stringWidth2 <= f3 || !line.getWords().isEmpty()) {
                    z = false;
                } else {
                    do {
                        i2--;
                        strSubstring = strSubstring2.substring(0, i2);
                    } while (pDFont.getStringWidth(strSubstring) * f4 >= f3);
                    stringWidth2 = pDFont.getStringWidth(strSubstring) * f4;
                    strSubstring2 = strSubstring;
                    stringWidth = stringWidth2;
                }
                AttributedString attributedString = new AttributedString(strSubstring2);
                attributedString.addAttribute(TextAttribute.WIDTH, Float.valueOf(stringWidth2));
                Word word = new Word(strSubstring2);
                word.setAttributes(attributedString);
                line.addWord(word);
                if (z) {
                    iFirst += i2;
                } else {
                    int i3 = next;
                    next = lineInstance.next();
                    iFirst = i3;
                }
            }
            line.setWidth(line.calculateWidth(pDFont, f2));
            arrayList.add(line);
            return arrayList;
        }

        public String getText() {
            return this.textContent;
        }
    }

    public static class TextAttribute extends AttributedCharacterIterator.Attribute {
        public static final AttributedCharacterIterator.Attribute WIDTH = new TextAttribute("width");
        private static final long serialVersionUID = -3138885145941283005L;

        public TextAttribute(String str) {
            super(str);
        }
    }

    public static class Word {
        private AttributedString attributedString;
        private final String textContent;

        public Word(String str) {
            this.textContent = str;
        }

        public AttributedString getAttributes() {
            return this.attributedString;
        }

        public String getText() {
            return this.textContent;
        }

        public void setAttributes(AttributedString attributedString) {
            this.attributedString = attributedString;
        }
    }

    public PlainText(String str) {
        if (str.isEmpty()) {
            ArrayList arrayList = new ArrayList(1);
            this.paragraphs = arrayList;
            arrayList.add(new Paragraph(""));
            return;
        }
        String[] strArrSplit = str.replace('\t', ' ').split("\\r\\n|\\n|\\r|\\u2028|\\u2029");
        this.paragraphs = new ArrayList(strArrSplit.length);
        for (String str2 : strArrSplit) {
            if (str2.length() == 0) {
                str2 = " ";
            }
            this.paragraphs.add(new Paragraph(str2));
        }
    }

    public List<Paragraph> getParagraphs() {
        return this.paragraphs;
    }

    public PlainText(List<String> list) {
        this.paragraphs = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.paragraphs.add(new Paragraph(it.next()));
        }
    }
}
