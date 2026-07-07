package com.tom_roush.pdfbox.text;

import android.util.Log;
import com.tom_roush.fontbox.ttf.OS2WindowsMetricsTable;
import com.tom_roush.pdfbox.pdmodel.font.PDFont;
import com.tom_roush.pdfbox.util.Matrix;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class TextPosition {
    private static final Map<Integer, String> DIACRITICS = createDiacritics();
    private final int[] charCodes;
    private float direction = -1.0f;
    private final float endX;
    private final float endY;
    private final PDFont font;
    private final float fontSize;
    private final int fontSizePt;
    private final float maxHeight;
    private final float pageHeight;
    private final float pageWidth;
    private final int rotation;
    private final Matrix textMatrix;
    private String unicode;
    private final float widthOfSpace;
    private float[] widths;
    private final float x;
    private final float y;

    public TextPosition(int i2, float f2, float f3, Matrix matrix, float f4, float f5, float f6, float f7, float f8, String str, int[] iArr, PDFont pDFont, float f9, int i3) {
        this.textMatrix = matrix;
        this.endX = f4;
        this.endY = f5;
        this.rotation = i2;
        this.maxHeight = f6;
        this.pageHeight = f3;
        this.pageWidth = f2;
        this.widths = new float[]{f7};
        this.widthOfSpace = f8;
        this.unicode = str;
        this.charCodes = iArr;
        this.font = pDFont;
        this.fontSize = f9;
        this.fontSizePt = i3;
        this.x = getXRot(i2);
        if (i2 == 0 || i2 == 180) {
            this.y = f3 - getYLowerLeftRot(i2);
        } else {
            this.y = f2 - getYLowerLeftRot(i2);
        }
    }

    private String combineDiacritic(String str) {
        int iCodePointAt = str.codePointAt(0);
        Map<Integer, String> map = DIACRITICS;
        return map.containsKey(Integer.valueOf(iCodePointAt)) ? map.get(Integer.valueOf(iCodePointAt)) : Normalizer.normalize(str, Normalizer.Form.NFKC).trim();
    }

    private static Map<Integer, String> createDiacritics() {
        HashMap map = new HashMap(31);
        map.put(96, "̀");
        map.put(715, "̀");
        map.put(39, "́");
        map.put(697, "́");
        map.put(714, "́");
        map.put(94, "̂");
        map.put(710, "̂");
        map.put(126, "̃");
        map.put(713, "̄");
        map.put(176, "̊");
        map.put(698, "̋");
        map.put(711, "̌");
        map.put(712, "̍");
        map.put(34, "̎");
        map.put(699, "̒");
        map.put(Integer.valueOf(OS2WindowsMetricsTable.WEIGHT_CLASS_BOLD), "̓");
        map.put(1158, "̓");
        map.put(1370, "̓");
        map.put(701, "̔");
        map.put(1157, "̔");
        map.put(1369, "̔");
        map.put(724, "̝");
        map.put(725, "̞");
        map.put(726, "̟");
        map.put(727, "̠");
        map.put(690, "̡");
        map.put(716, "̩");
        map.put(695, "̫");
        map.put(717, "̱");
        map.put(95, "̲");
        map.put(8270, "͙");
        return map;
    }

    private float getWidthRot(float f2) {
        return (f2 == 90.0f || f2 == 270.0f) ? Math.abs(this.endY - this.textMatrix.getTranslateY()) : Math.abs(this.endX - this.textMatrix.getTranslateX());
    }

    private float getXRot(float f2) {
        if (f2 == 0.0f) {
            return this.textMatrix.getTranslateX();
        }
        if (f2 == 90.0f) {
            return this.textMatrix.getTranslateY();
        }
        if (f2 == 180.0f) {
            return this.pageWidth - this.textMatrix.getTranslateX();
        }
        if (f2 == 270.0f) {
            return this.pageHeight - this.textMatrix.getTranslateY();
        }
        return 0.0f;
    }

    private float getYLowerLeftRot(float f2) {
        if (f2 == 0.0f) {
            return this.textMatrix.getTranslateY();
        }
        if (f2 == 90.0f) {
            return this.pageWidth - this.textMatrix.getTranslateX();
        }
        if (f2 == 180.0f) {
            return this.pageHeight - this.textMatrix.getTranslateY();
        }
        if (f2 == 270.0f) {
            return this.textMatrix.getTranslateX();
        }
        return 0.0f;
    }

    private void insertDiacritic(int i2, TextPosition textPosition) {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) this.unicode, 0, i2);
        float[] fArr = this.widths;
        float[] fArr2 = new float[fArr.length + 1];
        System.arraycopy(fArr, 0, fArr2, 0, i2);
        sb.append(this.unicode.charAt(i2));
        fArr2[i2] = this.widths[i2];
        sb.append(combineDiacritic(textPosition.getUnicode()));
        int i3 = i2 + 1;
        fArr2[i3] = 0.0f;
        sb.append(this.unicode.substring(i3));
        System.arraycopy(this.widths, i3, fArr2, i2 + 2, (r1.length - i2) - 1);
        this.unicode = sb.toString();
        this.widths = fArr2;
    }

    public boolean contains(TextPosition textPosition) {
        double xDirAdj = getXDirAdj();
        double widthDirAdj = getWidthDirAdj();
        double d2 = xDirAdj + widthDirAdj;
        double xDirAdj2 = textPosition.getXDirAdj();
        double widthDirAdj2 = ((double) textPosition.getWidthDirAdj()) + xDirAdj2;
        if (widthDirAdj2 > xDirAdj && xDirAdj2 < d2) {
            double yDirAdj = getYDirAdj();
            double yDirAdj2 = textPosition.getYDirAdj();
            if (((double) textPosition.getHeightDir()) + yDirAdj2 >= yDirAdj && yDirAdj2 <= yDirAdj + ((double) getHeightDir())) {
                return (xDirAdj2 <= xDirAdj || widthDirAdj2 <= d2) ? xDirAdj2 >= xDirAdj || widthDirAdj2 >= d2 || (widthDirAdj2 - xDirAdj) / widthDirAdj > 0.15d : (d2 - xDirAdj2) / widthDirAdj > 0.15d;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextPosition)) {
            return false;
        }
        TextPosition textPosition = (TextPosition) obj;
        if (Float.compare(textPosition.endX, this.endX) != 0 || Float.compare(textPosition.endY, this.endY) != 0 || Float.compare(textPosition.maxHeight, this.maxHeight) != 0 || this.rotation != textPosition.rotation || Float.compare(textPosition.x, this.x) != 0 || Float.compare(textPosition.y, this.y) != 0 || Float.compare(textPosition.pageHeight, this.pageHeight) != 0 || Float.compare(textPosition.pageWidth, this.pageWidth) != 0 || Float.compare(textPosition.widthOfSpace, this.widthOfSpace) != 0 || Float.compare(textPosition.fontSize, this.fontSize) != 0 || this.fontSizePt != textPosition.fontSizePt) {
            return false;
        }
        Matrix matrix = this.textMatrix;
        if (matrix == null ? textPosition.textMatrix != null : !matrix.equals(textPosition.textMatrix)) {
            return false;
        }
        if (!Arrays.equals(this.charCodes, textPosition.charCodes)) {
            return false;
        }
        PDFont pDFont = this.font;
        PDFont pDFont2 = textPosition.font;
        return pDFont != null ? pDFont.equals(pDFont2) : pDFont2 == null;
    }

    public int[] getCharacterCodes() {
        return this.charCodes;
    }

    public float getDir() {
        if (this.direction < 0.0f) {
            float scaleY = this.textMatrix.getScaleY();
            float shearY = this.textMatrix.getShearY();
            float shearX = this.textMatrix.getShearX();
            float scaleX = this.textMatrix.getScaleX();
            if (scaleY > 0.0f && Math.abs(shearY) < scaleX && Math.abs(shearX) < scaleY && scaleX > 0.0f) {
                this.direction = 0.0f;
            } else if (scaleY < 0.0f && Math.abs(shearY) < Math.abs(scaleX) && Math.abs(shearX) < Math.abs(scaleY) && scaleX < 0.0f) {
                this.direction = 180.0f;
            } else if (Math.abs(scaleY) < Math.abs(shearX) && shearY > 0.0f && shearX < 0.0f && Math.abs(scaleX) < shearY) {
                this.direction = 90.0f;
            } else if (Math.abs(scaleY) >= shearX || shearY >= 0.0f || shearX <= 0.0f || Math.abs(scaleX) >= Math.abs(shearY)) {
                this.direction = 0.0f;
            } else {
                this.direction = 270.0f;
            }
        }
        return this.direction;
    }

    public float getEndX() {
        return this.endX;
    }

    public float getEndY() {
        return this.endY;
    }

    public PDFont getFont() {
        return this.font;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public float getFontSizeInPt() {
        return this.fontSizePt;
    }

    public float getHeight() {
        return this.maxHeight;
    }

    public float getHeightDir() {
        return this.maxHeight;
    }

    public float[] getIndividualWidths() {
        return this.widths;
    }

    public float getPageHeight() {
        return this.pageHeight;
    }

    public float getPageWidth() {
        return this.pageWidth;
    }

    public int getRotation() {
        return this.rotation;
    }

    public Matrix getTextMatrix() {
        return this.textMatrix;
    }

    public String getUnicode() {
        return this.unicode;
    }

    public float getWidth() {
        return getWidthRot(this.rotation);
    }

    public float getWidthDirAdj() {
        return getWidthRot(getDir());
    }

    public float getWidthOfSpace() {
        return this.widthOfSpace;
    }

    public float getX() {
        return this.x;
    }

    public float getXDirAdj() {
        return getXRot(getDir());
    }

    public float getXScale() {
        return this.textMatrix.getScalingFactorX();
    }

    public float getY() {
        return this.y;
    }

    public float getYDirAdj() {
        float f2;
        float yLowerLeftRot;
        float dir = getDir();
        if (dir == 0.0f || dir == 180.0f) {
            f2 = this.pageHeight;
            yLowerLeftRot = getYLowerLeftRot(dir);
        } else {
            f2 = this.pageWidth;
            yLowerLeftRot = getYLowerLeftRot(dir);
        }
        return f2 - yLowerLeftRot;
    }

    public float getYScale() {
        return this.textMatrix.getScalingFactorY();
    }

    public int hashCode() {
        Matrix matrix = this.textMatrix;
        int iHashCode = (((((((((((((((((((((matrix != null ? matrix.hashCode() : 0) * 31) + Float.floatToIntBits(this.endX)) * 31) + Float.floatToIntBits(this.endY)) * 31) + Float.floatToIntBits(this.maxHeight)) * 31) + this.rotation) * 31) + Float.floatToIntBits(this.x)) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.pageHeight)) * 31) + Float.floatToIntBits(this.pageWidth)) * 31) + Float.floatToIntBits(this.widthOfSpace)) * 31) + Arrays.hashCode(this.charCodes)) * 31;
        PDFont pDFont = this.font;
        return ((((iHashCode + (pDFont != null ? pDFont.hashCode() : 0)) * 31) + Float.floatToIntBits(this.fontSize)) * 31) + this.fontSizePt;
    }

    public boolean isDiacritic() {
        String unicode = getUnicode();
        if (unicode.length() != 1 || "ー".equals(unicode)) {
            return false;
        }
        int type = Character.getType(unicode.charAt(0));
        return type == 6 || type == 27 || type == 4;
    }

    public void mergeDiacritic(TextPosition textPosition) {
        if (textPosition.getUnicode().length() > 1) {
            return;
        }
        float xDirAdj = textPosition.getXDirAdj();
        int i2 = 0;
        float f2 = textPosition.widths[0] + xDirAdj;
        float xDirAdj2 = getXDirAdj();
        int length = this.unicode.length();
        float f3 = xDirAdj2;
        boolean z = false;
        while (i2 < length && !z) {
            float[] fArr = this.widths;
            if (i2 >= fArr.length) {
                Log.i("PdfBox-Android", "diacritic " + textPosition.getUnicode() + " on ligature " + this.unicode + " is not supported yet and is ignored (PDFBOX-2831)");
                return;
            }
            float f4 = fArr[i2] + f3;
            if (xDirAdj >= f3 || f2 > f4) {
                if (xDirAdj >= f3 && f2 > f4 && i2 != length - 1) {
                    f3 += this.widths[i2];
                    i2++;
                } else {
                    insertDiacritic(i2, textPosition);
                }
            } else if (i2 == 0) {
                insertDiacritic(i2, textPosition);
            } else {
                int i3 = i2 - 1;
                if ((f2 - f3) / fArr[i2] >= (f3 - xDirAdj) / fArr[i3]) {
                    insertDiacritic(i2, textPosition);
                } else {
                    insertDiacritic(i3, textPosition);
                }
            }
            z = true;
            f3 += this.widths[i2];
            i2++;
        }
    }

    public String toString() {
        return getUnicode();
    }
}
