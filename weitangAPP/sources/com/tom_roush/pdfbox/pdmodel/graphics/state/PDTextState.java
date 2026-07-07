package com.tom_roush.pdfbox.pdmodel.graphics.state;

import com.tom_roush.pdfbox.pdmodel.font.PDFont;

/* JADX INFO: loaded from: classes2.dex */
public class PDTextState implements Cloneable {
    private PDFont font;
    private float fontSize;
    private float characterSpacing = 0.0f;
    private float wordSpacing = 0.0f;
    private float horizontalScaling = 100.0f;
    private float leading = 0.0f;
    private RenderingMode renderingMode = RenderingMode.FILL;
    private float rise = 0.0f;
    private boolean knockout = true;

    public float getCharacterSpacing() {
        return this.characterSpacing;
    }

    public PDFont getFont() {
        return this.font;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public float getHorizontalScaling() {
        return this.horizontalScaling;
    }

    public boolean getKnockoutFlag() {
        return this.knockout;
    }

    public float getLeading() {
        return this.leading;
    }

    public RenderingMode getRenderingMode() {
        return this.renderingMode;
    }

    public float getRise() {
        return this.rise;
    }

    public float getWordSpacing() {
        return this.wordSpacing;
    }

    public void setCharacterSpacing(float f2) {
        this.characterSpacing = f2;
    }

    public void setFont(PDFont pDFont) {
        this.font = pDFont;
    }

    public void setFontSize(float f2) {
        this.fontSize = f2;
    }

    public void setHorizontalScaling(float f2) {
        this.horizontalScaling = f2;
    }

    public void setKnockoutFlag(boolean z) {
        this.knockout = z;
    }

    public void setLeading(float f2) {
        this.leading = f2;
    }

    public void setRenderingMode(RenderingMode renderingMode) {
        this.renderingMode = renderingMode;
    }

    public void setRise(float f2) {
        this.rise = f2;
    }

    public void setWordSpacing(float f2) {
        this.wordSpacing = f2;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public PDTextState m86clone() {
        try {
            return (PDTextState) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
