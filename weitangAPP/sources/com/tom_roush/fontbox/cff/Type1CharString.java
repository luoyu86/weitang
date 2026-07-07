package com.tom_roush.fontbox.cff;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import com.tom_roush.fontbox.encoding.StandardEncoding;
import com.tom_roush.fontbox.type1.Type1CharStringReader;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Type1CharString {
    public int commandCount;
    private PointF current;
    private final List<PointF> flexPoints;
    private Type1CharStringReader font;
    private final String fontName;
    private final String glyphName;
    private boolean isFlex;
    private PointF leftSideBearing;
    private Path path;
    public List<Object> type1Sequence;
    private int width;

    public Type1CharString(Type1CharStringReader type1CharStringReader, String str, String str2, List<Object> list) {
        this(type1CharStringReader, str, str2);
        this.type1Sequence = list;
    }

    private void callothersubr(int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                this.isFlex = true;
                return;
            }
            Log.w("PdfBox-Android", "Invalid callothersubr parameter: " + i2);
            return;
        }
        this.isFlex = false;
        if (this.flexPoints.size() < 7) {
            Log.w("PdfBox-Android", "flex without moveTo in font " + this.fontName + ", glyph " + this.glyphName + ", command " + this.commandCount);
            return;
        }
        PointF pointF = this.flexPoints.get(0);
        PointF pointF2 = this.current;
        pointF.set(pointF2.x + pointF.x, pointF2.y + pointF.y);
        PointF pointF3 = this.flexPoints.get(1);
        pointF3.set(pointF.x + pointF3.x, pointF.y + pointF3.y);
        float f2 = pointF3.x;
        PointF pointF4 = this.current;
        pointF3.set(f2 - pointF4.x, pointF3.y - pointF4.y);
        PointF pointF5 = this.flexPoints.get(1);
        PointF pointF6 = this.flexPoints.get(2);
        PointF pointF7 = this.flexPoints.get(3);
        rrcurveTo(Float.valueOf(pointF5.x), Float.valueOf(pointF5.y), Float.valueOf(pointF6.x), Float.valueOf(pointF6.y), Float.valueOf(pointF7.x), Float.valueOf(pointF7.y));
        PointF pointF8 = this.flexPoints.get(4);
        PointF pointF9 = this.flexPoints.get(5);
        PointF pointF10 = this.flexPoints.get(6);
        rrcurveTo(Float.valueOf(pointF8.x), Float.valueOf(pointF8.y), Float.valueOf(pointF9.x), Float.valueOf(pointF9.y), Float.valueOf(pointF10.x), Float.valueOf(pointF10.y));
        this.flexPoints.clear();
    }

    private void closeCharString1Path() {
        if (this.path.isEmpty()) {
            Log.w("PdfBox-Android", "closepath without initial moveTo in font " + this.fontName + ", glyph " + this.glyphName);
        } else {
            this.path.close();
        }
        Path path = this.path;
        PointF pointF = this.current;
        path.moveTo(pointF.x, pointF.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Number> handleCommand(List<Number> list, CharStringCommand charStringCommand) {
        this.commandCount++;
        String str = CharStringCommand.TYPE1_VOCABULARY.get(charStringCommand.getKey());
        if ("rmoveto".equals(str)) {
            if (list.size() < 2) {
                return null;
            }
            if (this.isFlex) {
                this.flexPoints.add(new PointF(list.get(0).floatValue(), list.get(1).floatValue()));
                return null;
            }
            rmoveTo(list.get(0), list.get(1));
            return null;
        }
        if ("vmoveto".equals(str)) {
            if (list.isEmpty()) {
                return null;
            }
            if (this.isFlex) {
                this.flexPoints.add(new PointF(0.0f, list.get(0).floatValue()));
                return null;
            }
            rmoveTo(0, list.get(0));
            return null;
        }
        if ("hmoveto".equals(str)) {
            if (list.isEmpty()) {
                return null;
            }
            if (this.isFlex) {
                this.flexPoints.add(new PointF(list.get(0).floatValue(), 0.0f));
                return null;
            }
            rmoveTo(list.get(0), 0);
            return null;
        }
        if ("rlineto".equals(str)) {
            if (list.size() < 2) {
                return null;
            }
            rlineTo(list.get(0), list.get(1));
            return null;
        }
        if ("hlineto".equals(str)) {
            if (list.isEmpty()) {
                return null;
            }
            rlineTo(list.get(0), 0);
            return null;
        }
        if ("vlineto".equals(str)) {
            if (list.isEmpty()) {
                return null;
            }
            rlineTo(0, list.get(0));
            return null;
        }
        if ("rrcurveto".equals(str)) {
            if (list.size() < 6) {
                return null;
            }
            rrcurveTo(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5));
            return null;
        }
        if ("closepath".equals(str)) {
            closeCharString1Path();
            return null;
        }
        if ("sbw".equals(str)) {
            if (list.size() < 3) {
                return null;
            }
            this.leftSideBearing = new PointF(list.get(0).floatValue(), list.get(1).floatValue());
            this.width = list.get(2).intValue();
            this.current.set(this.leftSideBearing);
            return null;
        }
        if ("hsbw".equals(str)) {
            if (list.size() < 2) {
                return null;
            }
            this.leftSideBearing = new PointF(list.get(0).floatValue(), 0.0f);
            this.width = list.get(1).intValue();
            this.current.set(this.leftSideBearing);
            return null;
        }
        if ("vhcurveto".equals(str)) {
            if (list.size() < 4) {
                return null;
            }
            rrcurveTo(0, list.get(0), list.get(1), list.get(2), list.get(3), 0);
            return null;
        }
        if ("hvcurveto".equals(str)) {
            if (list.size() < 4) {
                return null;
            }
            rrcurveTo(list.get(0), 0, list.get(1), list.get(2), 0, list.get(3));
            return null;
        }
        if ("seac".equals(str)) {
            if (list.size() < 5) {
                return null;
            }
            seac(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
            return null;
        }
        if ("setcurrentpoint".equals(str)) {
            if (list.size() < 2) {
                return null;
            }
            setcurrentpoint(list.get(0), list.get(1));
            return null;
        }
        if ("callothersubr".equals(str)) {
            if (list.isEmpty()) {
                return null;
            }
            callothersubr(list.get(0).intValue());
            return null;
        }
        if ("div".equals(str)) {
            float fFloatValue = list.get(list.size() - 2).floatValue() / list.get(list.size() - 1).floatValue();
            ArrayList arrayList = new ArrayList(list);
            arrayList.remove(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            arrayList.add(Float.valueOf(fFloatValue));
            return arrayList;
        }
        if ("hstem".equals(str) || "vstem".equals(str) || "hstem3".equals(str) || "vstem3".equals(str) || "dotsection".equals(str) || "endchar".equals(str)) {
            return null;
        }
        if ("return".equals(str) || "callsubr".equals(str)) {
            Log.w("PdfBox-Android", "Unexpected charstring command: " + str + " in glyph " + this.glyphName + " of font " + this.fontName);
            return null;
        }
        if (str != null) {
            throw new IllegalArgumentException("Unhandled command: " + str);
        }
        Log.w("PdfBox-Android", "Unknown charstring command: " + charStringCommand.getKey() + " in glyph " + this.glyphName + " of font " + this.fontName);
        return null;
    }

    private void render() {
        this.path = new Path();
        this.leftSideBearing = new PointF(0.0f, 0.0f);
        this.width = 0;
        new CharStringHandler() { // from class: com.tom_roush.fontbox.cff.Type1CharString.1
            @Override // com.tom_roush.fontbox.cff.CharStringHandler
            public List<Number> handleCommand(List<Number> list, CharStringCommand charStringCommand) {
                return Type1CharString.this.handleCommand(list, charStringCommand);
            }
        }.handleSequence(this.type1Sequence);
    }

    private void rlineTo(Number number, Number number2) {
        float fFloatValue = this.current.x + number.floatValue();
        float fFloatValue2 = this.current.y + number2.floatValue();
        if (this.path.isEmpty()) {
            Log.w("PdfBox-Android", "rlineTo without initial moveTo in font " + this.fontName + ", glyph " + this.glyphName);
            this.path.moveTo(fFloatValue, fFloatValue2);
        } else {
            this.path.lineTo(fFloatValue, fFloatValue2);
        }
        this.current.set(fFloatValue, fFloatValue2);
    }

    private void rmoveTo(Number number, Number number2) {
        float fFloatValue = this.current.x + number.floatValue();
        float fFloatValue2 = this.current.y + number2.floatValue();
        this.path.moveTo(fFloatValue, fFloatValue2);
        this.current.set(fFloatValue, fFloatValue2);
    }

    private void rrcurveTo(Number number, Number number2, Number number3, Number number4, Number number5, Number number6) {
        float fFloatValue = this.current.x + number.floatValue();
        float fFloatValue2 = this.current.y + number2.floatValue();
        float fFloatValue3 = fFloatValue + number3.floatValue();
        float fFloatValue4 = fFloatValue2 + number4.floatValue();
        float fFloatValue5 = number5.floatValue() + fFloatValue3;
        float fFloatValue6 = number6.floatValue() + fFloatValue4;
        if (this.path.isEmpty()) {
            Log.w("PdfBox-Android", "rrcurveTo without initial moveTo in font " + this.fontName + ", glyph " + this.glyphName);
            this.path.moveTo(fFloatValue5, fFloatValue6);
        } else {
            this.path.cubicTo(fFloatValue, fFloatValue2, fFloatValue3, fFloatValue4, fFloatValue5, fFloatValue6);
        }
        this.current.set(fFloatValue5, fFloatValue6);
    }

    private void seac(Number number, Number number2, Number number3, Number number4, Number number5) {
        try {
            this.path.op(this.font.getType1CharString(StandardEncoding.INSTANCE.getName(number4.intValue())).getPath(), Path.Op.UNION);
        } catch (IOException unused) {
            Log.w("PdfBox-Android", "invalid seac character in glyph " + this.glyphName + " of font " + this.fontName);
        }
        try {
            Type1CharString type1CharString = this.font.getType1CharString(StandardEncoding.INSTANCE.getName(number5.intValue()));
            AffineTransform.getTranslateInstance((this.leftSideBearing.x + number2.floatValue()) - number.floatValue(), this.leftSideBearing.y + number3.floatValue());
            this.path.op(type1CharString.getPath(), Path.Op.UNION);
        } catch (IOException unused2) {
            Log.w("PdfBox-Android", "invalid seac character in glyph " + this.glyphName + " of font " + this.fontName);
        }
    }

    private void setcurrentpoint(Number number, Number number2) {
        this.current.set(number.floatValue(), number2.floatValue());
    }

    public RectF getBounds() {
        if (this.path == null) {
            render();
        }
        RectF rectF = new RectF();
        this.path.computeBounds(rectF, true);
        return rectF;
    }

    public String getName() {
        return this.glyphName;
    }

    public Path getPath() {
        if (this.path == null) {
            render();
        }
        return this.path;
    }

    public List<Object> getType1Sequence() {
        return this.type1Sequence;
    }

    public int getWidth() {
        if (this.path == null) {
            render();
        }
        return this.width;
    }

    public String toString() {
        return this.type1Sequence.toString().replace("|", "\n").replace(",", " ");
    }

    public Type1CharString(Type1CharStringReader type1CharStringReader, String str, String str2) {
        this.path = null;
        this.width = 0;
        this.leftSideBearing = null;
        this.current = null;
        this.isFlex = false;
        this.flexPoints = new ArrayList();
        this.font = type1CharStringReader;
        this.fontName = str;
        this.glyphName = str2;
        this.current = new PointF(0.0f, 0.0f);
    }
}
