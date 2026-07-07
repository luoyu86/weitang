package com.tom_roush.fontbox.ttf;

import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class TrueTypeCollection implements Closeable {
    private final long[] fontOffsets;
    private final int numFonts;
    private final TTFDataStream stream;

    public interface TrueTypeFontProcessor {
        void process(TrueTypeFont trueTypeFont) throws IOException;
    }

    public TrueTypeCollection(File file) throws IOException {
        this(new RAFDataStream(file, PDPageLabelRange.STYLE_ROMAN_LOWER));
    }

    private TrueTypeFont getFontAtIndex(int i2) throws IOException {
        this.stream.seek(this.fontOffsets[i2]);
        TTFParser oTFParser = this.stream.readTag().equals("OTTO") ? new OTFParser(false, true) : new TTFParser(false, true);
        this.stream.seek(this.fontOffsets[i2]);
        return oTFParser.parse(new TTCDataStream(this.stream));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stream.close();
    }

    public TrueTypeFont getFontByName(String str) throws IOException {
        for (int i2 = 0; i2 < this.numFonts; i2++) {
            TrueTypeFont fontAtIndex = getFontAtIndex(i2);
            if (fontAtIndex.getName().equals(str)) {
                return fontAtIndex;
            }
        }
        return null;
    }

    public void processAllFonts(TrueTypeFontProcessor trueTypeFontProcessor) throws IOException {
        for (int i2 = 0; i2 < this.numFonts; i2++) {
            trueTypeFontProcessor.process(getFontAtIndex(i2));
        }
    }

    public TrueTypeCollection(InputStream inputStream) throws IOException {
        this(new MemoryTTFDataStream(inputStream));
    }

    public TrueTypeCollection(TTFDataStream tTFDataStream) throws IOException {
        this.stream = tTFDataStream;
        if (tTFDataStream.readTag().equals("ttcf")) {
            float f2 = tTFDataStream.read32Fixed();
            int unsignedInt = (int) tTFDataStream.readUnsignedInt();
            this.numFonts = unsignedInt;
            if (unsignedInt > 0 && unsignedInt <= 1024) {
                this.fontOffsets = new long[unsignedInt];
                for (int i2 = 0; i2 < this.numFonts; i2++) {
                    this.fontOffsets[i2] = tTFDataStream.readUnsignedInt();
                }
                if (f2 >= 2.0f) {
                    tTFDataStream.readUnsignedShort();
                    tTFDataStream.readUnsignedShort();
                    tTFDataStream.readUnsignedShort();
                    return;
                }
                return;
            }
            throw new IOException("Invalid number of fonts " + unsignedInt);
        }
        throw new IOException("Missing TTC header");
    }
}
