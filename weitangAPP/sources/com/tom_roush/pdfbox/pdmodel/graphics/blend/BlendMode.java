package com.tom_roush.pdfbox.pdmodel.graphics.blend;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSName;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BlendMode {
    private static final Map<COSName, BlendMode> BLEND_MODES;
    private static final Map<BlendMode, COSName> BLEND_MODE_NAMES;
    public static final NonSeparableBlendMode COLOR;
    public static final SeparableBlendMode COLOR_BURN;
    public static final SeparableBlendMode COLOR_DODGE;
    public static final SeparableBlendMode COMPATIBLE;
    public static final SeparableBlendMode DARKEN;
    public static final SeparableBlendMode DIFFERENCE;
    public static final SeparableBlendMode EXCLUSION;
    public static final SeparableBlendMode HARD_LIGHT;
    public static final NonSeparableBlendMode HUE;
    public static final SeparableBlendMode LIGHTEN;
    public static final NonSeparableBlendMode LUMINOSITY;
    public static final SeparableBlendMode MULTIPLY;
    public static final SeparableBlendMode NORMAL;
    public static final SeparableBlendMode OVERLAY;
    public static final NonSeparableBlendMode SATURATION;
    public static final SeparableBlendMode SCREEN;
    public static final SeparableBlendMode SOFT_LIGHT;

    static {
        SeparableBlendMode separableBlendMode = new SeparableBlendMode() { // from class: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.1
            @Override // com.tom_roush.pdfbox.pdmodel.graphics.blend.SeparableBlendMode
            public float blendChannel(float f2, float f3) {
                return f2;
            }
        };
        NORMAL = separableBlendMode;
        COMPATIBLE = separableBlendMode;
        MULTIPLY = new SeparableBlendMode() { // from class: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.2
            @Override // com.tom_roush.pdfbox.pdmodel.graphics.blend.SeparableBlendMode
            public float blendChannel(float f2, float f3) {
                return f2 * f3;
            }
        };
        SCREEN = new SeparableBlendMode() { // from class: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.3
            @Override // com.tom_roush.pdfbox.pdmodel.graphics.blend.SeparableBlendMode
            public float blendChannel(float f2, float f3) {
                return (f2 + f3) - (f2 * f3);
            }
        };
        OVERLAY = new SeparableBlendMode() { // from class: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.4
            @Override // com.tom_roush.pdfbox.pdmodel.graphics.blend.SeparableBlendMode
            public float blendChannel(float f2, float f3) {
                return ((double) f3) <= 0.5d ? f3 * 2.0f * f2 : (((f2 + f3) - (f2 * f3)) * 2.0f) - 1.0f;
            }
        };
        DARKEN = new SeparableBlendMode() { // from class: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.5
            @Override // com.tom_roush.pdfbox.pdmodel.graphics.blend.SeparableBlendMode
            public float blendChannel(float f2, float f3) {
                return Math.min(f2, f3);
            }
        };
        LIGHTEN = new SeparableBlendMode() { // from class: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.6
            @Override // com.tom_roush.pdfbox.pdmodel.graphics.blend.SeparableBlendMode
            public float blendChannel(float f2, float f3) {
                return Math.max(f2, f3);
            }
        };
        COLOR_DODGE = new SeparableBlendMode() { // from class: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.7
            @Override // com.tom_roush.pdfbox.pdmodel.graphics.blend.SeparableBlendMode
            public float blendChannel(float f2, float f3) {
                if (f3 == 0.0f) {
                    return 0.0f;
                }
                float f4 = 1.0f - f2;
                if (f3 >= f4) {
                    return 1.0f;
                }
                return f3 / f4;
            }
        };
        COLOR_BURN = new SeparableBlendMode() { // from class: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.8
            @Override // com.tom_roush.pdfbox.pdmodel.graphics.blend.SeparableBlendMode
            public float blendChannel(float f2, float f3) {
                if (f3 == 1.0f) {
                    return 1.0f;
                }
                float f4 = 1.0f - f3;
                if (f4 >= f2) {
                    return 0.0f;
                }
                return 1.0f - (f4 / f2);
            }
        };
        HARD_LIGHT = new SeparableBlendMode() { // from class: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.9
            @Override // com.tom_roush.pdfbox.pdmodel.graphics.blend.SeparableBlendMode
            public float blendChannel(float f2, float f3) {
                return ((double) f2) <= 0.5d ? f3 * 2.0f * f2 : (((f2 + f3) - (f2 * f3)) * 2.0f) - 1.0f;
            }
        };
        SOFT_LIGHT = new SeparableBlendMode() { // from class: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.10
            @Override // com.tom_roush.pdfbox.pdmodel.graphics.blend.SeparableBlendMode
            public float blendChannel(float f2, float f3) {
                if (f2 <= 0.5d) {
                    return f3 - (((1.0f - (f2 * 2.0f)) * f3) * (1.0f - f3));
                }
                double d2 = f3;
                return f3 + (((f2 * 2.0f) - 1.0f) * ((d2 <= 0.25d ? ((((16.0f * f3) - 12.0f) * f3) + 4.0f) * f3 : (float) Math.sqrt(d2)) - f3));
            }
        };
        DIFFERENCE = new SeparableBlendMode() { // from class: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.11
            @Override // com.tom_roush.pdfbox.pdmodel.graphics.blend.SeparableBlendMode
            public float blendChannel(float f2, float f3) {
                return Math.abs(f3 - f2);
            }
        };
        EXCLUSION = new SeparableBlendMode() { // from class: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.12
            @Override // com.tom_roush.pdfbox.pdmodel.graphics.blend.SeparableBlendMode
            public float blendChannel(float f2, float f3) {
                return (f3 + f2) - ((f3 * 2.0f) * f2);
            }
        };
        HUE = new NonSeparableBlendMode() { // from class: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.13
            @Override // com.tom_roush.pdfbox.pdmodel.graphics.blend.NonSeparableBlendMode
            public void blend(float[] fArr, float[] fArr2, float[] fArr3) {
                float[] fArr4 = new float[3];
                BlendMode.getSaturationRGB(fArr2, fArr, fArr4);
                BlendMode.getLuminosityRGB(fArr2, fArr4, fArr3);
            }
        };
        SATURATION = new NonSeparableBlendMode() { // from class: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.14
            @Override // com.tom_roush.pdfbox.pdmodel.graphics.blend.NonSeparableBlendMode
            public void blend(float[] fArr, float[] fArr2, float[] fArr3) {
                BlendMode.getSaturationRGB(fArr, fArr2, fArr3);
            }
        };
        COLOR = new NonSeparableBlendMode() { // from class: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.15
            @Override // com.tom_roush.pdfbox.pdmodel.graphics.blend.NonSeparableBlendMode
            public void blend(float[] fArr, float[] fArr2, float[] fArr3) {
                BlendMode.getLuminosityRGB(fArr2, fArr, fArr3);
            }
        };
        LUMINOSITY = new NonSeparableBlendMode() { // from class: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.16
            @Override // com.tom_roush.pdfbox.pdmodel.graphics.blend.NonSeparableBlendMode
            public void blend(float[] fArr, float[] fArr2, float[] fArr3) {
                BlendMode.getLuminosityRGB(fArr, fArr2, fArr3);
            }
        };
        BLEND_MODES = createBlendModeMap();
        BLEND_MODE_NAMES = createBlendModeNamesMap();
    }

    private static Map<COSName, BlendMode> createBlendModeMap() {
        HashMap map = new HashMap(13);
        COSName cOSName = COSName.NORMAL;
        SeparableBlendMode separableBlendMode = NORMAL;
        map.put(cOSName, separableBlendMode);
        map.put(COSName.COMPATIBLE, separableBlendMode);
        map.put(COSName.MULTIPLY, MULTIPLY);
        map.put(COSName.SCREEN, SCREEN);
        map.put(COSName.OVERLAY, OVERLAY);
        map.put(COSName.DARKEN, DARKEN);
        map.put(COSName.LIGHTEN, LIGHTEN);
        map.put(COSName.COLOR_DODGE, COLOR_DODGE);
        map.put(COSName.COLOR_BURN, COLOR_BURN);
        map.put(COSName.HARD_LIGHT, HARD_LIGHT);
        map.put(COSName.SOFT_LIGHT, SOFT_LIGHT);
        map.put(COSName.DIFFERENCE, DIFFERENCE);
        map.put(COSName.EXCLUSION, EXCLUSION);
        map.put(COSName.HUE, HUE);
        map.put(COSName.SATURATION, SATURATION);
        map.put(COSName.LUMINOSITY, LUMINOSITY);
        map.put(COSName.COLOR, COLOR);
        return map;
    }

    private static Map<BlendMode, COSName> createBlendModeNamesMap() {
        HashMap map = new HashMap(13);
        SeparableBlendMode separableBlendMode = NORMAL;
        COSName cOSName = COSName.NORMAL;
        map.put(separableBlendMode, cOSName);
        map.put(COMPATIBLE, cOSName);
        map.put(MULTIPLY, COSName.MULTIPLY);
        map.put(SCREEN, COSName.SCREEN);
        map.put(OVERLAY, COSName.OVERLAY);
        map.put(DARKEN, COSName.DARKEN);
        map.put(LIGHTEN, COSName.LIGHTEN);
        map.put(COLOR_DODGE, COSName.COLOR_DODGE);
        map.put(COLOR_BURN, COSName.COLOR_BURN);
        map.put(HARD_LIGHT, COSName.HARD_LIGHT);
        map.put(SOFT_LIGHT, COSName.SOFT_LIGHT);
        map.put(DIFFERENCE, COSName.DIFFERENCE);
        map.put(EXCLUSION, COSName.EXCLUSION);
        map.put(HUE, COSName.HUE);
        map.put(SATURATION, COSName.SATURATION);
        map.put(LUMINOSITY, COSName.LUMINOSITY);
        map.put(COLOR, COSName.COLOR);
        return map;
    }

    private static int get255Value(float f2) {
        double d2 = f2;
        return (int) Math.floor(d2 < 1.0d ? 255.0d * d2 : 255.0d);
    }

    public static COSName getCOSName(BlendMode blendMode) {
        return BLEND_MODE_NAMES.get(blendMode);
    }

    public static BlendMode getInstance(COSBase cOSBase) {
        BlendMode blendMode = null;
        if (cOSBase instanceof COSName) {
            blendMode = BLEND_MODES.get(cOSBase);
        } else if (cOSBase instanceof COSArray) {
            COSArray cOSArray = (COSArray) cOSBase;
            for (int i2 = 0; i2 < cOSArray.size() && (blendMode = BLEND_MODES.get(cOSArray.getObject(i2))) == null; i2++) {
            }
        }
        return blendMode != null ? blendMode : NORMAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void getLuminosityRGB(float[] r10, float[] r11, float[] r12) {
        /*
            r0 = 0
            r1 = r11[r0]
            int r1 = get255Value(r1)
            r2 = 1
            r3 = r11[r2]
            int r3 = get255Value(r3)
            r4 = 2
            r11 = r11[r4]
            int r11 = get255Value(r11)
            r5 = r10[r0]
            int r5 = get255Value(r5)
            r6 = r10[r2]
            int r6 = get255Value(r6)
            r10 = r10[r4]
            int r10 = get255Value(r10)
            int r7 = r5 - r1
            int r7 = r7 * 77
            int r8 = r6 - r3
            int r8 = r8 * 151
            int r7 = r7 + r8
            int r8 = r10 - r11
            int r8 = r8 * 28
            int r7 = r7 + r8
            int r7 = r7 + 128
            int r7 = r7 >> 8
            int r1 = r1 + r7
            int r3 = r3 + r7
            int r11 = r11 + r7
            r8 = r1 | r3
            r8 = r8 | r11
            r9 = 256(0x100, float:3.59E-43)
            r8 = r8 & r9
            if (r8 != r9) goto L8d
            int r5 = r5 * 77
            int r6 = r6 * 151
            int r5 = r5 + r6
            int r10 = r10 * 28
            int r5 = r5 + r10
            int r5 = r5 + 128
            int r10 = r5 >> 8
            if (r7 <= 0) goto L65
            int r5 = java.lang.Math.max(r3, r11)
            int r5 = java.lang.Math.max(r1, r5)
            if (r5 != r10) goto L5e
        L5c:
            r6 = 0
            goto L75
        L5e:
            int r6 = 255 - r10
            int r6 = r6 << 16
            int r5 = r5 - r10
            int r6 = r6 / r5
            goto L75
        L65:
            int r5 = java.lang.Math.min(r3, r11)
            int r5 = java.lang.Math.min(r1, r5)
            if (r10 != r5) goto L70
            goto L5c
        L70:
            int r6 = r10 << 16
            int r5 = r10 - r5
            int r6 = r6 / r5
        L75:
            int r1 = r1 - r10
            int r1 = r1 * r6
            r5 = 32768(0x8000, float:4.5918E-41)
            int r1 = r1 + r5
            int r1 = r1 >> 16
            int r1 = r1 + r10
            int r3 = r3 - r10
            int r3 = r3 * r6
            int r3 = r3 + r5
            int r3 = r3 >> 16
            int r3 = r3 + r10
            int r11 = r11 - r10
            int r11 = r11 * r6
            int r11 = r11 + r5
            int r11 = r11 >> 16
            int r11 = r11 + r10
        L8d:
            float r10 = (float) r1
            r1 = 1132396544(0x437f0000, float:255.0)
            float r10 = r10 / r1
            r12[r0] = r10
            float r10 = (float) r3
            float r10 = r10 / r1
            r12[r2] = r10
            float r10 = (float) r11
            float r10 = r10 / r1
            r12[r4] = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.graphics.blend.BlendMode.getLuminosityRGB(float[], float[], float[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getSaturationRGB(float[] fArr, float[] fArr2, float[] fArr3) {
        int i2 = get255Value(fArr2[0]);
        int i3 = get255Value(fArr2[1]);
        int i4 = get255Value(fArr2[2]);
        int i5 = get255Value(fArr[0]);
        int i6 = get255Value(fArr[1]);
        int i7 = get255Value(fArr[2]);
        int iMin = Math.min(i2, Math.min(i3, i4));
        int iMax = Math.max(i2, Math.max(i3, i4));
        if (iMin == iMax) {
            float f2 = i3 / 255.0f;
            fArr3[0] = f2;
            fArr3[1] = f2;
            fArr3[2] = f2;
            return;
        }
        int iMax2 = ((Math.max(i5, Math.max(i6, i7)) - Math.min(i5, Math.min(i6, i7))) << 16) / (iMax - iMin);
        int i8 = ((((i2 * 77) + (i3 * TTDownloadField.CALL_DOWNLOAD_MODEL_SET_QUICK_APP_MODEL)) + (i4 * 28)) + 128) >> 8;
        int i9 = ((((i2 - i8) * iMax2) + 32768) >> 16) + i8;
        int i10 = ((((i3 - i8) * iMax2) + 32768) >> 16) + i8;
        int i11 = ((((i4 - i8) * iMax2) + 32768) >> 16) + i8;
        if (((i9 | i10 | i11) & 256) == 256) {
            int iMin2 = Math.min(i9, Math.min(i10, i11));
            int iMax3 = Math.max(i9, Math.max(i10, i11));
            int iMin3 = Math.min(iMin2 < 0 ? (i8 << 16) / (i8 - iMin2) : 65536, iMax3 > 255 ? ((255 - i8) << 16) / (iMax3 - i8) : 65536);
            i9 = ((((i9 - i8) * iMin3) + 32768) >> 16) + i8;
            i10 = ((((i10 - i8) * iMin3) + 32768) >> 16) + i8;
            i11 = ((((i11 - i8) * iMin3) + 32768) >> 16) + i8;
        }
        fArr3[0] = i9 / 255.0f;
        fArr3[1] = i10 / 255.0f;
        fArr3[2] = i11 / 255.0f;
    }
}
