package com.tom_roush.fontbox.ttf;

import android.graphics.Path;
import com.tom_roush.fontbox.FontBoxFont;
import com.tom_roush.fontbox.util.BoundingBox;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TrueTypeFont implements FontBoxFont, Closeable {
    private final TTFDataStream data;
    private Map<String, Integer> postScriptNames;
    private float version;
    private int numberOfGlyphs = -1;
    private int unitsPerEm = -1;
    public Map<String, TTFTable> tables = new HashMap();
    private final List<String> enabledGsubFeatures = new ArrayList();

    public TrueTypeFont(TTFDataStream tTFDataStream) {
        this.data = tTFDataStream;
    }

    private CmapSubtable getUnicodeCmapImpl(boolean z) throws IOException {
        CmapTable cmap = getCmap();
        if (cmap == null) {
            if (!z) {
                return null;
            }
            throw new IOException("The TrueType font " + getName() + " does not contain a 'cmap' table");
        }
        CmapSubtable subtable = cmap.getSubtable(0, 4);
        if (subtable == null) {
            subtable = cmap.getSubtable(3, 10);
        }
        if (subtable == null) {
            subtable = cmap.getSubtable(0, 3);
        }
        if (subtable == null) {
            subtable = cmap.getSubtable(3, 1);
        }
        if (subtable == null) {
            subtable = cmap.getSubtable(3, 0);
        }
        if (subtable != null) {
            return subtable;
        }
        if (z) {
            throw new IOException("The TrueType font does not contain a Unicode cmap");
        }
        return cmap.getCmaps().length > 0 ? cmap.getCmaps()[0] : subtable;
    }

    private int parseUniName(String str) {
        if (str.startsWith("uni") && str.length() == 7) {
            int length = str.length();
            StringBuilder sb = new StringBuilder();
            int i2 = 3;
            while (true) {
                int i3 = i2 + 4;
                if (i3 > length) {
                    break;
                }
                try {
                    int i4 = Integer.parseInt(str.substring(i2, i3), 16);
                    if (i4 <= 55295 || i4 >= 57344) {
                        sb.append((char) i4);
                    }
                    i2 = i3;
                } catch (NumberFormatException unused) {
                }
            }
            String string = sb.toString();
            if (string.length() == 0) {
                return -1;
            }
            return string.codePointAt(0);
        }
        return -1;
    }

    private synchronized void readPostScriptNames() throws IOException {
        if (this.postScriptNames == null && getPostScript() != null) {
            String[] glyphNames = getPostScript().getGlyphNames();
            if (glyphNames != null) {
                this.postScriptNames = new HashMap(glyphNames.length);
                for (int i2 = 0; i2 < glyphNames.length; i2++) {
                    this.postScriptNames.put(glyphNames[i2], Integer.valueOf(i2));
                }
            } else {
                this.postScriptNames = new HashMap();
            }
        }
    }

    public void addTable(TTFTable tTFTable) {
        this.tables.put(tTFTable.getTag(), tTFTable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.data.close();
    }

    public void disableGsubFeature(String str) {
        this.enabledGsubFeatures.remove(str);
    }

    public void enableGsubFeature(String str) {
        this.enabledGsubFeatures.add(str);
    }

    public void enableVerticalSubstitutions() {
        enableGsubFeature("vrt2");
        enableGsubFeature("vert");
    }

    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    public int getAdvanceHeight(int i2) throws IOException {
        VerticalMetricsTable verticalMetrics = getVerticalMetrics();
        if (verticalMetrics != null) {
            return verticalMetrics.getAdvanceHeight(i2);
        }
        return 250;
    }

    public int getAdvanceWidth(int i2) throws IOException {
        HorizontalMetricsTable horizontalMetrics = getHorizontalMetrics();
        if (horizontalMetrics != null) {
            return horizontalMetrics.getAdvanceWidth(i2);
        }
        return 250;
    }

    public CmapTable getCmap() throws IOException {
        return (CmapTable) getTable(CmapTable.TAG);
    }

    @Override // com.tom_roush.fontbox.FontBoxFont
    public BoundingBox getFontBBox() throws IOException {
        HeaderTable header = getHeader();
        short xMin = header.getXMin();
        short xMax = header.getXMax();
        float unitsPerEm = 1000.0f / getUnitsPerEm();
        return new BoundingBox(xMin * unitsPerEm, header.getYMin() * unitsPerEm, xMax * unitsPerEm, header.getYMax() * unitsPerEm);
    }

    @Override // com.tom_roush.fontbox.FontBoxFont
    public List<Number> getFontMatrix() throws IOException {
        float unitsPerEm = (1000.0f / getUnitsPerEm()) * 0.001f;
        return Arrays.asList(Float.valueOf(unitsPerEm), 0, 0, Float.valueOf(unitsPerEm), 0, 0);
    }

    public GlyphTable getGlyph() throws IOException {
        return (GlyphTable) getTable(GlyphTable.TAG);
    }

    public GlyphSubstitutionTable getGsub() throws IOException {
        return (GlyphSubstitutionTable) getTable(GlyphSubstitutionTable.TAG);
    }

    public HeaderTable getHeader() throws IOException {
        return (HeaderTable) getTable(HeaderTable.TAG);
    }

    public HorizontalHeaderTable getHorizontalHeader() throws IOException {
        return (HorizontalHeaderTable) getTable(HorizontalHeaderTable.TAG);
    }

    public HorizontalMetricsTable getHorizontalMetrics() throws IOException {
        return (HorizontalMetricsTable) getTable(HorizontalMetricsTable.TAG);
    }

    public IndexToLocationTable getIndexToLocation() throws IOException {
        return (IndexToLocationTable) getTable(IndexToLocationTable.TAG);
    }

    public KerningTable getKerning() throws IOException {
        return (KerningTable) getTable(KerningTable.TAG);
    }

    public MaximumProfileTable getMaximumProfile() throws IOException {
        return (MaximumProfileTable) getTable(MaximumProfileTable.TAG);
    }

    @Override // com.tom_roush.fontbox.FontBoxFont
    public String getName() throws IOException {
        NamingTable naming = getNaming();
        if (naming != null) {
            return naming.getPostScriptName();
        }
        return null;
    }

    public NamingTable getNaming() throws IOException {
        return (NamingTable) getTable("name");
    }

    public int getNumberOfGlyphs() throws IOException {
        if (this.numberOfGlyphs == -1) {
            MaximumProfileTable maximumProfile = getMaximumProfile();
            if (maximumProfile != null) {
                this.numberOfGlyphs = maximumProfile.getNumGlyphs();
            } else {
                this.numberOfGlyphs = 0;
            }
        }
        return this.numberOfGlyphs;
    }

    public OS2WindowsMetricsTable getOS2Windows() throws IOException {
        return (OS2WindowsMetricsTable) getTable(OS2WindowsMetricsTable.TAG);
    }

    public InputStream getOriginalData() throws IOException {
        return this.data.getOriginalData();
    }

    public long getOriginalDataSize() {
        return this.data.getOriginalDataSize();
    }

    @Override // com.tom_roush.fontbox.FontBoxFont
    public Path getPath(String str) throws IOException {
        GlyphData glyph = getGlyph().getGlyph(nameToGID(str));
        return glyph == null ? new Path() : glyph.getPath();
    }

    public PostScriptTable getPostScript() throws IOException {
        return (PostScriptTable) getTable(PostScriptTable.TAG);
    }

    public synchronized TTFTable getTable(String str) throws IOException {
        TTFTable tTFTable;
        tTFTable = this.tables.get(str);
        if (tTFTable != null && !tTFTable.getInitialized()) {
            readTable(tTFTable);
        }
        return tTFTable;
    }

    public synchronized byte[] getTableBytes(TTFTable tTFTable) throws IOException {
        byte[] bArr;
        long currentPosition = this.data.getCurrentPosition();
        this.data.seek(tTFTable.getOffset());
        bArr = this.data.read((int) tTFTable.getLength());
        this.data.seek(currentPosition);
        return bArr;
    }

    public Map<String, TTFTable> getTableMap() {
        return this.tables;
    }

    public Collection<TTFTable> getTables() {
        return this.tables.values();
    }

    @Deprecated
    public CmapSubtable getUnicodeCmap() throws IOException {
        return getUnicodeCmap(true);
    }

    public CmapLookup getUnicodeCmapLookup() throws IOException {
        return getUnicodeCmapLookup(true);
    }

    public int getUnitsPerEm() throws IOException {
        if (this.unitsPerEm == -1) {
            HeaderTable header = getHeader();
            if (header != null) {
                this.unitsPerEm = header.getUnitsPerEm();
            } else {
                this.unitsPerEm = 0;
            }
        }
        return this.unitsPerEm;
    }

    public float getVersion() {
        return this.version;
    }

    public VerticalHeaderTable getVerticalHeader() throws IOException {
        return (VerticalHeaderTable) getTable(VerticalHeaderTable.TAG);
    }

    public VerticalMetricsTable getVerticalMetrics() throws IOException {
        return (VerticalMetricsTable) getTable(VerticalMetricsTable.TAG);
    }

    public VerticalOriginTable getVerticalOrigin() throws IOException {
        return (VerticalOriginTable) getTable(VerticalOriginTable.TAG);
    }

    @Override // com.tom_roush.fontbox.FontBoxFont
    public float getWidth(String str) throws IOException {
        return getAdvanceWidth(nameToGID(str));
    }

    @Override // com.tom_roush.fontbox.FontBoxFont
    public boolean hasGlyph(String str) throws IOException {
        return nameToGID(str) != 0;
    }

    public int nameToGID(String str) throws IOException {
        Integer num;
        readPostScriptNames();
        Map<String, Integer> map = this.postScriptNames;
        if (map != null && (num = map.get(str)) != null && num.intValue() > 0 && num.intValue() < getMaximumProfile().getNumGlyphs()) {
            return num.intValue();
        }
        int uniName = parseUniName(str);
        if (uniName > -1) {
            return getUnicodeCmapLookup(false).getGlyphId(uniName);
        }
        return 0;
    }

    public void readTable(TTFTable tTFTable) throws IOException {
        synchronized (this.data) {
            long currentPosition = this.data.getCurrentPosition();
            this.data.seek(tTFTable.getOffset());
            tTFTable.read(this, this.data);
            this.data.seek(currentPosition);
        }
    }

    public void setVersion(float f2) {
        this.version = f2;
    }

    public String toString() {
        try {
            NamingTable naming = getNaming();
            return naming != null ? naming.getPostScriptName() : "(null)";
        } catch (IOException e2) {
            return "(null - " + e2.getMessage() + ")";
        }
    }

    @Deprecated
    public CmapSubtable getUnicodeCmap(boolean z) throws IOException {
        return getUnicodeCmapImpl(z);
    }

    public CmapLookup getUnicodeCmapLookup(boolean z) throws IOException {
        GlyphSubstitutionTable gsub;
        CmapSubtable unicodeCmapImpl = getUnicodeCmapImpl(z);
        return (this.enabledGsubFeatures.isEmpty() || (gsub = getGsub()) == null) ? unicodeCmapImpl : new SubstitutingCmapLookup(unicodeCmapImpl, gsub, Collections.unmodifiableList(this.enabledGsubFeatures));
    }
}
