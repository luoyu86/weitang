package com.tom_roush.fontbox.ttf;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class MaximumProfileTable extends TTFTable {
    public static final String TAG = "maxp";
    private int maxComponentDepth;
    private int maxComponentElements;
    private int maxCompositeContours;
    private int maxCompositePoints;
    private int maxContours;
    private int maxFunctionDefs;
    private int maxInstructionDefs;
    private int maxPoints;
    private int maxSizeOfInstructions;
    private int maxStackElements;
    private int maxStorage;
    private int maxTwilightPoints;
    private int maxZones;
    private int numGlyphs;
    private float version;

    public MaximumProfileTable(TrueTypeFont trueTypeFont) {
        super(trueTypeFont);
    }

    public int getMaxComponentDepth() {
        return this.maxComponentDepth;
    }

    public int getMaxComponentElements() {
        return this.maxComponentElements;
    }

    public int getMaxCompositeContours() {
        return this.maxCompositeContours;
    }

    public int getMaxCompositePoints() {
        return this.maxCompositePoints;
    }

    public int getMaxContours() {
        return this.maxContours;
    }

    public int getMaxFunctionDefs() {
        return this.maxFunctionDefs;
    }

    public int getMaxInstructionDefs() {
        return this.maxInstructionDefs;
    }

    public int getMaxPoints() {
        return this.maxPoints;
    }

    public int getMaxSizeOfInstructions() {
        return this.maxSizeOfInstructions;
    }

    public int getMaxStackElements() {
        return this.maxStackElements;
    }

    public int getMaxStorage() {
        return this.maxStorage;
    }

    public int getMaxTwilightPoints() {
        return this.maxTwilightPoints;
    }

    public int getMaxZones() {
        return this.maxZones;
    }

    public int getNumGlyphs() {
        return this.numGlyphs;
    }

    public float getVersion() {
        return this.version;
    }

    @Override // com.tom_roush.fontbox.ttf.TTFTable
    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        this.version = tTFDataStream.read32Fixed();
        this.numGlyphs = tTFDataStream.readUnsignedShort();
        this.maxPoints = tTFDataStream.readUnsignedShort();
        this.maxContours = tTFDataStream.readUnsignedShort();
        this.maxCompositePoints = tTFDataStream.readUnsignedShort();
        this.maxCompositeContours = tTFDataStream.readUnsignedShort();
        this.maxZones = tTFDataStream.readUnsignedShort();
        this.maxTwilightPoints = tTFDataStream.readUnsignedShort();
        this.maxStorage = tTFDataStream.readUnsignedShort();
        this.maxFunctionDefs = tTFDataStream.readUnsignedShort();
        this.maxInstructionDefs = tTFDataStream.readUnsignedShort();
        this.maxStackElements = tTFDataStream.readUnsignedShort();
        this.maxSizeOfInstructions = tTFDataStream.readUnsignedShort();
        this.maxComponentElements = tTFDataStream.readUnsignedShort();
        this.maxComponentDepth = tTFDataStream.readUnsignedShort();
        this.initialized = true;
    }

    public void setMaxComponentDepth(int i2) {
        this.maxComponentDepth = i2;
    }

    public void setMaxComponentElements(int i2) {
        this.maxComponentElements = i2;
    }

    public void setMaxCompositeContours(int i2) {
        this.maxCompositeContours = i2;
    }

    public void setMaxCompositePoints(int i2) {
        this.maxCompositePoints = i2;
    }

    public void setMaxContours(int i2) {
        this.maxContours = i2;
    }

    public void setMaxFunctionDefs(int i2) {
        this.maxFunctionDefs = i2;
    }

    public void setMaxInstructionDefs(int i2) {
        this.maxInstructionDefs = i2;
    }

    public void setMaxPoints(int i2) {
        this.maxPoints = i2;
    }

    public void setMaxSizeOfInstructions(int i2) {
        this.maxSizeOfInstructions = i2;
    }

    public void setMaxStackElements(int i2) {
        this.maxStackElements = i2;
    }

    public void setMaxStorage(int i2) {
        this.maxStorage = i2;
    }

    public void setMaxTwilightPoints(int i2) {
        this.maxTwilightPoints = i2;
    }

    public void setMaxZones(int i2) {
        this.maxZones = i2;
    }

    public void setNumGlyphs(int i2) {
        this.numGlyphs = i2;
    }

    public void setVersion(float f2) {
        this.version = f2;
    }
}
