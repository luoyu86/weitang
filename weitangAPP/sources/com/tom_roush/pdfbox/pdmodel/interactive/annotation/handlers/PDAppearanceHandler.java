package com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers;

/* JADX INFO: loaded from: classes2.dex */
public interface PDAppearanceHandler {
    void generateAppearanceStreams();

    void generateDownAppearance();

    void generateNormalAppearance();

    void generateRolloverAppearance();
}
