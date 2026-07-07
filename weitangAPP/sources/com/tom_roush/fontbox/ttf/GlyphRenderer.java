package com.tom_roush.fontbox.ttf;

import android.graphics.Path;
import android.util.Log;
import com.tom_roush.pdfbox.android.PDFBoxConfig;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class GlyphRenderer {
    private GlyphDescription glyphDescription;

    public GlyphRenderer(GlyphDescription glyphDescription) {
        this.glyphDescription = glyphDescription;
    }

    private Path calculatePath(Point[] pointArr) {
        Path path = new Path();
        int length = pointArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (pointArr[i3].endOfContour) {
                Point point = pointArr[i2];
                Point point2 = pointArr[i3];
                ArrayList arrayList = new ArrayList();
                for (int i4 = i2; i4 <= i3; i4++) {
                    arrayList.add(pointArr[i4]);
                }
                if (pointArr[i2].onCurve) {
                    arrayList.add(point);
                } else if (pointArr[i3].onCurve) {
                    arrayList.add(0, point2);
                } else {
                    Point pointMidValue = midValue(point, point2);
                    arrayList.add(0, pointMidValue);
                    arrayList.add(pointMidValue);
                }
                moveTo(path, (Point) arrayList.get(0));
                int size = arrayList.size();
                int i5 = 1;
                while (i5 < size) {
                    Point point3 = (Point) arrayList.get(i5);
                    if (point3.onCurve) {
                        lineTo(path, point3);
                    } else {
                        int i6 = i5 + 1;
                        if (((Point) arrayList.get(i6)).onCurve) {
                            quadTo(path, point3, (Point) arrayList.get(i6));
                            i5 = i6;
                        } else {
                            quadTo(path, point3, midValue(point3, (Point) arrayList.get(i6)));
                        }
                    }
                    i5++;
                }
                path.close();
                i2 = i3 + 1;
            }
        }
        return path;
    }

    private Point[] describe(GlyphDescription glyphDescription) {
        int pointCount = glyphDescription.getPointCount();
        Point[] pointArr = new Point[pointCount];
        int i2 = 0;
        int endPtOfContours = -1;
        int i3 = 0;
        while (i2 < pointCount) {
            if (endPtOfContours == -1) {
                endPtOfContours = glyphDescription.getEndPtOfContours(i3);
            }
            boolean z = true;
            boolean z2 = endPtOfContours == i2;
            if (z2) {
                i3++;
                endPtOfContours = -1;
            }
            short xCoordinate = glyphDescription.getXCoordinate(i2);
            short yCoordinate = glyphDescription.getYCoordinate(i2);
            if ((glyphDescription.getFlags(i2) & 1) == 0) {
                z = false;
            }
            pointArr[i2] = new Point(xCoordinate, yCoordinate, z, z2);
            i2++;
        }
        return pointArr;
    }

    private void lineTo(Path path, Point point) {
        path.lineTo(point.x, point.y);
        if (PDFBoxConfig.isDebugEnabled()) {
            Log.d("PdfBox-Android", "lineTo: " + String.format(Locale.US, "%d,%d", Integer.valueOf(point.x), Integer.valueOf(point.y)));
        }
    }

    private int midValue(int i2, int i3) {
        return i2 + ((i3 - i2) / 2);
    }

    private void moveTo(Path path, Point point) {
        path.moveTo(point.x, point.y);
        if (PDFBoxConfig.isDebugEnabled()) {
            Log.d("PdfBox-Android", "moveTo: " + String.format(Locale.US, "%d,%d", Integer.valueOf(point.x), Integer.valueOf(point.y)));
        }
    }

    private void quadTo(Path path, Point point, Point point2) {
        path.quadTo(point.x, point.y, point2.x, point2.y);
        if (PDFBoxConfig.isDebugEnabled()) {
            Log.d("PdfBox-Android", "quadTo: " + String.format(Locale.US, "%d,%d %d,%d", Integer.valueOf(point.x), Integer.valueOf(point.y), Integer.valueOf(point2.x), Integer.valueOf(point2.y)));
        }
    }

    public Path getPath() {
        return calculatePath(describe(this.glyphDescription));
    }

    private Point midValue(Point point, Point point2) {
        return new Point(midValue(point.x, point2.x), midValue(point.y, point2.y));
    }

    public static class Point {
        private boolean endOfContour;
        private boolean onCurve;
        private int x;
        private int y;

        public Point(int i2, int i3, boolean z, boolean z2) {
            this.x = 0;
            this.y = 0;
            this.onCurve = true;
            this.endOfContour = false;
            this.x = i2;
            this.y = i3;
            this.onCurve = z;
            this.endOfContour = z2;
        }

        public String toString() {
            Locale locale = Locale.US;
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(this.x);
            objArr[1] = Integer.valueOf(this.y);
            objArr[2] = this.onCurve ? "onCurve" : "";
            objArr[3] = this.endOfContour ? "endOfContour" : "";
            return String.format(locale, "Point(%d,%d,%s,%s)", objArr);
        }

        public Point(int i2, int i3) {
            this(i2, i3, true, false);
        }
    }
}
