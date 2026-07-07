package com.tom_roush.pdfbox.pdmodel.font;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.tom_roush.fontbox.FontBoxFont;
import com.tom_roush.fontbox.ttf.OpenTypeFont;
import com.tom_roush.fontbox.ttf.TTFParser;
import com.tom_roush.fontbox.ttf.TrueTypeFont;
import com.tom_roush.fontbox.type1.Type1Font;
import com.tom_roush.pdfbox.android.PDFBoxConfig;
import com.tom_roush.pdfbox.android.PDFBoxResourceLoader;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class FontMapperImpl implements FontMapper {
    private static final FontCache fontCache = new FontCache();
    private Map<String, FontInfo> fontInfoByName;
    private FontProvider fontProvider;
    private final TrueTypeFont lastResortFont;
    private final Map<String, List<String>> substitutes;

    public static class DefaultFontProvider {
        private static final FontProvider INSTANCE = new FileSystemFontProvider(FontMapperImpl.fontCache);

        private DefaultFontProvider() {
        }
    }

    public static class FontMatch implements Comparable<FontMatch> {
        public final FontInfo info;
        public double score;

        public FontMatch(FontInfo fontInfo) {
            this.info = fontInfo;
        }

        @Override // java.lang.Comparable
        public int compareTo(FontMatch fontMatch) {
            return Double.compare(fontMatch.score, this.score);
        }
    }

    public FontMapperImpl() {
        HashMap map = new HashMap();
        this.substitutes = map;
        map.put("Courier", new ArrayList(Arrays.asList("CourierNew", "CourierNewPSMT", "LiberationMono", "NimbusMonL-Regu", "DroidSansMono")));
        map.put("Courier-Bold", new ArrayList(Arrays.asList("CourierNewPS-BoldMT", "CourierNew-Bold", "LiberationMono-Bold", "NimbusMonL-Bold", "DroidSansMono")));
        map.put("Courier-Oblique", new ArrayList(Arrays.asList("CourierNewPS-ItalicMT", "CourierNew-Italic", "LiberationMono-Italic", "NimbusMonL-ReguObli", "DroidSansMono")));
        map.put("Courier-BoldOblique", new ArrayList(Arrays.asList("CourierNewPS-BoldItalicMT", "CourierNew-BoldItalic", "LiberationMono-BoldItalic", "NimbusMonL-BoldObli", "DroidSansMono")));
        map.put("Helvetica", new ArrayList(Arrays.asList("ArialMT", "Arial", "LiberationSans", "NimbusSanL-Regu", "Roboto-Regular")));
        map.put("Helvetica-Bold", new ArrayList(Arrays.asList("Arial-BoldMT", "Arial-Bold", "LiberationSans-Bold", "NimbusSanL-Bold", "Roboto-Bold")));
        map.put("Helvetica-Oblique", new ArrayList(Arrays.asList("Arial-ItalicMT", "Arial-Italic", "Helvetica-Italic", "LiberationSans-Italic", "NimbusSanL-ReguItal", "Roboto-Italic")));
        map.put("Helvetica-BoldOblique", new ArrayList(Arrays.asList("Arial-BoldItalicMT", "Helvetica-BoldItalic", "LiberationSans-BoldItalic", "NimbusSanL-BoldItal", "Roboto-BoldItalic")));
        map.put("Times-Roman", new ArrayList(Arrays.asList("TimesNewRomanPSMT", "TimesNewRoman", "TimesNewRomanPS", "LiberationSerif", "NimbusRomNo9L-Regu", "Roboto-Regular")));
        map.put("Times-Bold", new ArrayList(Arrays.asList("TimesNewRomanPS-BoldMT", "TimesNewRomanPS-Bold", "TimesNewRoman-Bold", "LiberationSerif-Bold", "NimbusRomNo9L-Medi", "DroidSerif-Bold", "Roboto-Bold")));
        map.put("Times-Italic", new ArrayList(Arrays.asList("TimesNewRomanPS-ItalicMT", "TimesNewRomanPS-Italic", "TimesNewRoman-Italic", "LiberationSerif-Italic", "NimbusRomNo9L-ReguItal", "DroidSerif-Italic", "Roboto-Italic")));
        map.put("Times-BoldItalic", new ArrayList(Arrays.asList("TimesNewRomanPS-BoldItalicMT", "TimesNewRomanPS-BoldItalic", "TimesNewRoman-BoldItalic", "LiberationSerif-BoldItalic", "NimbusRomNo9L-MediItal", "DroidSerif-BoldItalic", "Roboto-BoldItalic")));
        map.put("Symbol", new ArrayList(Arrays.asList("Symbol", "SymbolMT", "StandardSymL")));
        map.put("ZapfDingbats", new ArrayList(Arrays.asList("ZapfDingbatsITCbyBT-Regular", "ZapfDingbatsITC", "Dingbats", "MS-Gothic")));
        for (String str : Standard14Fonts.getNames()) {
            if (!this.substitutes.containsKey(str)) {
                this.substitutes.put(str, copySubstitutes(Standard14Fonts.getMappedFontName(str)));
            }
        }
        try {
            InputStream stream = PDFBoxResourceLoader.isReady() ? PDFBoxResourceLoader.getStream("com/tom_roush/pdfbox/resources/ttf/LiberationSans-Regular.ttf") : FontMapper.class.getResourceAsStream("/com/tom_roush/pdfbox/resources/ttf/LiberationSans-Regular.ttf");
            if (stream == null) {
                throw new IOException("resource 'com/tom_roush/pdfbox/resources/ttf/LiberationSans-Regular.ttf' not found");
            }
            this.lastResortFont = new TTFParser().parse(new BufferedInputStream(stream));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private List<String> copySubstitutes(String str) {
        return new ArrayList(this.substitutes.get(str));
    }

    private Map<String, FontInfo> createFontInfoByName(List<? extends FontInfo> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (FontInfo fontInfo : list) {
            Iterator<String> it = getPostScriptNames(fontInfo.getPostScriptName()).iterator();
            while (it.hasNext()) {
                linkedHashMap.put(it.next(), fontInfo);
            }
        }
        return linkedHashMap;
    }

    private FontBoxFont findFont(FontFormat fontFormat, String str) {
        if (str == null) {
            return null;
        }
        if (this.fontProvider == null) {
            getProvider();
        }
        FontInfo font = getFont(fontFormat, str);
        if (font != null) {
            return font.getFont();
        }
        FontInfo font2 = getFont(fontFormat, str.replace("-", ""));
        if (font2 != null) {
            return font2.getFont();
        }
        Iterator<String> it = getSubstitutes(str).iterator();
        while (it.hasNext()) {
            FontInfo font3 = getFont(fontFormat, it.next());
            if (font3 != null) {
                return font3.getFont();
            }
        }
        FontInfo font4 = getFont(fontFormat, str.replace(",", "-"));
        if (font4 != null) {
            return font4.getFont();
        }
        FontInfo font5 = getFont(fontFormat, str + "-Regular");
        if (font5 != null) {
            return font5.getFont();
        }
        return null;
    }

    private FontBoxFont findFontBoxFont(String str) {
        Type1Font type1Font = (Type1Font) findFont(FontFormat.PFB, str);
        if (type1Font != null) {
            return type1Font;
        }
        TrueTypeFont trueTypeFont = (TrueTypeFont) findFont(FontFormat.TTF, str);
        if (trueTypeFont != null) {
            return trueTypeFont;
        }
        OpenTypeFont openTypeFont = (OpenTypeFont) findFont(FontFormat.OTF, str);
        if (openTypeFont != null) {
            return openTypeFont;
        }
        return null;
    }

    private String getFallbackFontName(PDFontDescriptor pDFontDescriptor) {
        if (pDFontDescriptor == null) {
            return "Times-Roman";
        }
        boolean z = false;
        if (pDFontDescriptor.getFontName() != null) {
            String lowerCase = pDFontDescriptor.getFontName().toLowerCase();
            if (lowerCase.contains("bold") || lowerCase.contains("black") || lowerCase.contains("heavy")) {
                z = true;
            }
        }
        if (pDFontDescriptor.isFixedPitch()) {
            if (z && pDFontDescriptor.isItalic()) {
                return "Courier-BoldOblique";
            }
            if (z) {
                return "Courier-Bold";
            }
            if (!pDFontDescriptor.isItalic()) {
                return "Courier";
            }
            return "Courier-Oblique";
        }
        if (!pDFontDescriptor.isSerif()) {
            if (z && pDFontDescriptor.isItalic()) {
                return "Helvetica-BoldOblique";
            }
            if (z) {
                return "Helvetica-Bold";
            }
            if (!pDFontDescriptor.isItalic()) {
                return "Helvetica";
            }
            return "Helvetica-Oblique";
        }
        if (z && pDFontDescriptor.isItalic()) {
            return "Times-BoldItalic";
        }
        if (z) {
            return "Times-Bold";
        }
        if (pDFontDescriptor.isItalic()) {
            return "Times-Italic";
        }
        return "Times-Roman";
    }

    private FontInfo getFont(FontFormat fontFormat, String str) {
        if (str.contains("+")) {
            str = str.substring(str.indexOf(43) + 1);
        }
        FontInfo fontInfo = this.fontInfoByName.get(str);
        if (fontInfo == null || fontInfo.getFormat() != fontFormat) {
            return null;
        }
        if (PDFBoxConfig.isDebugEnabled()) {
            Log.d("PdfBox-Android", String.format("getFont('%s','%s') returns %s", fontFormat, str, fontInfo));
        }
        return fontInfo;
    }

    private PriorityQueue<FontMatch> getFontMatches(PDFontDescriptor pDFontDescriptor, PDCIDSystemInfo pDCIDSystemInfo) {
        PriorityQueue<FontMatch> priorityQueue = new PriorityQueue<>(20);
        for (FontInfo fontInfo : this.fontInfoByName.values()) {
            if (pDCIDSystemInfo == null || isCharSetMatch(pDCIDSystemInfo, fontInfo)) {
                FontMatch fontMatch = new FontMatch(fontInfo);
                if (pDFontDescriptor.getPanose() == null || fontInfo.getPanose() == null) {
                    if (pDFontDescriptor.getFontWeight() > 0.0f && fontInfo.getWeightClass() > 0) {
                        fontMatch.score += 1.0d - (((double) (Math.abs(pDFontDescriptor.getFontWeight() - fontInfo.getWeightClass()) / 100.0f)) * 0.5d);
                    }
                    priorityQueue.add(fontMatch);
                } else {
                    PDPanoseClassification panose = pDFontDescriptor.getPanose().getPanose();
                    if (panose.getFamilyKind() == fontInfo.getPanose().getFamilyKind()) {
                        if (panose.getFamilyKind() != 0 || ((!fontInfo.getPostScriptName().toLowerCase().contains("barcode") && !fontInfo.getPostScriptName().startsWith(StandardStructureTypes.CODE)) || probablyBarcodeFont(pDFontDescriptor))) {
                            if (panose.getSerifStyle() == fontInfo.getPanose().getSerifStyle()) {
                                fontMatch.score += 2.0d;
                            } else if (panose.getSerifStyle() >= 2 && panose.getSerifStyle() <= 5 && fontInfo.getPanose().getSerifStyle() >= 2 && fontInfo.getPanose().getSerifStyle() <= 5) {
                                fontMatch.score += 1.0d;
                            } else if (panose.getSerifStyle() >= 11 && panose.getSerifStyle() <= 13 && fontInfo.getPanose().getSerifStyle() >= 11 && fontInfo.getPanose().getSerifStyle() <= 13) {
                                fontMatch.score += 1.0d;
                            } else if (panose.getSerifStyle() != 0 && fontInfo.getPanose().getSerifStyle() != 0) {
                                fontMatch.score -= 1.0d;
                            }
                            int weight = fontInfo.getPanose().getWeight();
                            int weightClassAsPanose = fontInfo.getWeightClassAsPanose();
                            if (Math.abs(weight - weightClassAsPanose) > 2) {
                                weight = weightClassAsPanose;
                            }
                            if (panose.getWeight() == weight) {
                                fontMatch.score += 2.0d;
                            } else if (panose.getWeight() > 1 && weight > 1) {
                                fontMatch.score += 1.0d - (((double) Math.abs(panose.getWeight() - weight)) * 0.5d);
                            }
                        }
                    }
                    priorityQueue.add(fontMatch);
                }
            }
        }
        return priorityQueue;
    }

    private Set<String> getPostScriptNames(String str) {
        HashSet hashSet = new HashSet(2);
        hashSet.add(str);
        hashSet.add(str.replace("-", ""));
        return hashSet;
    }

    private List<String> getSubstitutes(String str) {
        List<String> list = this.substitutes.get(str.replace(" ", ""));
        return list != null ? list : Collections.emptyList();
    }

    private boolean isCharSetMatch(PDCIDSystemInfo pDCIDSystemInfo, FontInfo fontInfo) {
        if (fontInfo.getCIDSystemInfo() != null) {
            return fontInfo.getCIDSystemInfo().getRegistry().equals(pDCIDSystemInfo.getRegistry()) && fontInfo.getCIDSystemInfo().getOrdering().equals(pDCIDSystemInfo.getOrdering());
        }
        long codePageRange = fontInfo.getCodePageRange();
        if ("MalgunGothic-Semilight".equals(fontInfo.getPostScriptName())) {
            codePageRange &= -1441793;
        }
        if (pDCIDSystemInfo.getOrdering().equals("GB1") && (codePageRange & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) == PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return true;
        }
        if (pDCIDSystemInfo.getOrdering().equals("CNS1") && (codePageRange & 1048576) == 1048576) {
            return true;
        }
        if (pDCIDSystemInfo.getOrdering().equals("Japan1") && (codePageRange & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) == PlaybackStateCompat.ACTION_PREPARE_FROM_URI) {
            return true;
        }
        if (pDCIDSystemInfo.getOrdering().equals("Korea1")) {
            return (codePageRange & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) == PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED || (codePageRange & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) == PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        }
        return false;
    }

    private FontMatch printMatches(PriorityQueue<FontMatch> priorityQueue) {
        FontMatch fontMatchPeek = priorityQueue.peek();
        System.out.println("-------");
        while (!priorityQueue.isEmpty()) {
            FontMatch fontMatchPoll = priorityQueue.poll();
            FontInfo fontInfo = fontMatchPoll.info;
            System.out.println(fontMatchPoll.score + " | " + fontInfo.getMacStyle() + " " + fontInfo.getFamilyClass() + " " + fontInfo.getPanose() + " " + fontInfo.getCIDSystemInfo() + " " + fontInfo.getPostScriptName() + " " + fontInfo.getFormat());
        }
        System.out.println("-------");
        return fontMatchPeek;
    }

    private boolean probablyBarcodeFont(PDFontDescriptor pDFontDescriptor) {
        String fontFamily = pDFontDescriptor.getFontFamily();
        if (fontFamily == null) {
            fontFamily = "";
        }
        String fontName = pDFontDescriptor.getFontName();
        String str = fontName != null ? fontName : "";
        return fontFamily.startsWith(StandardStructureTypes.CODE) || fontFamily.toLowerCase().contains("barcode") || str.startsWith(StandardStructureTypes.CODE) || str.toLowerCase().contains("barcode");
    }

    public void addSubstitute(String str, String str2) {
        if (!this.substitutes.containsKey(str)) {
            this.substitutes.put(str, new ArrayList());
        }
        this.substitutes.get(str).add(str2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.FontMapper
    public CIDFontMapping getCIDFont(String str, PDFontDescriptor pDFontDescriptor, PDCIDSystemInfo pDCIDSystemInfo) {
        FontMatch fontMatchPoll;
        OpenTypeFont openTypeFont = (OpenTypeFont) findFont(FontFormat.OTF, str);
        if (openTypeFont != null) {
            return new CIDFontMapping(openTypeFont, null, false);
        }
        TrueTypeFont trueTypeFont = (TrueTypeFont) findFont(FontFormat.TTF, str);
        if (trueTypeFont != null) {
            return new CIDFontMapping(null, trueTypeFont, false);
        }
        if (pDCIDSystemInfo != null) {
            String str2 = pDCIDSystemInfo.getRegistry() + "-" + pDCIDSystemInfo.getOrdering();
            if ((str2.equals("Adobe-GB1") || str2.equals("Adobe-CNS1") || str2.equals("Adobe-Japan1") || str2.equals("Adobe-Korea1")) && (fontMatchPoll = getFontMatches(pDFontDescriptor, pDCIDSystemInfo).poll()) != null) {
                if (PDFBoxConfig.isDebugEnabled()) {
                    Log.d("PdfBox-Android", "Best match for '" + str + "': " + fontMatchPoll.info);
                }
                FontBoxFont font = fontMatchPoll.info.getFont();
                if (font instanceof OpenTypeFont) {
                    return new CIDFontMapping((OpenTypeFont) font, null, true);
                }
                if (font != null) {
                    return new CIDFontMapping(null, font, true);
                }
            }
        }
        return new CIDFontMapping(null, this.lastResortFont, true);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.FontMapper
    public FontMapping<FontBoxFont> getFontBoxFont(String str, PDFontDescriptor pDFontDescriptor) {
        FontBoxFont fontBoxFontFindFontBoxFont = findFontBoxFont(str);
        if (fontBoxFontFindFontBoxFont != null) {
            return new FontMapping<>(fontBoxFontFindFontBoxFont, false);
        }
        FontBoxFont fontBoxFontFindFontBoxFont2 = findFontBoxFont(getFallbackFontName(pDFontDescriptor));
        if (fontBoxFontFindFontBoxFont2 == null) {
            fontBoxFontFindFontBoxFont2 = this.lastResortFont;
        }
        return new FontMapping<>(fontBoxFontFindFontBoxFont2, true);
    }

    public FontCache getFontCache() {
        return fontCache;
    }

    public synchronized FontProvider getProvider() {
        if (this.fontProvider == null) {
            setProvider(DefaultFontProvider.INSTANCE);
        }
        return this.fontProvider;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.FontMapper
    public FontMapping<TrueTypeFont> getTrueTypeFont(String str, PDFontDescriptor pDFontDescriptor) {
        FontFormat fontFormat = FontFormat.TTF;
        TrueTypeFont trueTypeFont = (TrueTypeFont) findFont(fontFormat, str);
        if (trueTypeFont != null) {
            return new FontMapping<>(trueTypeFont, false);
        }
        TrueTypeFont trueTypeFont2 = (TrueTypeFont) findFont(fontFormat, getFallbackFontName(pDFontDescriptor));
        if (trueTypeFont2 == null) {
            trueTypeFont2 = this.lastResortFont;
        }
        return new FontMapping<>(trueTypeFont2, true);
    }

    public synchronized void setProvider(FontProvider fontProvider) {
        this.fontInfoByName = createFontInfoByName(fontProvider.getFontInfo());
        this.fontProvider = fontProvider;
    }
}
