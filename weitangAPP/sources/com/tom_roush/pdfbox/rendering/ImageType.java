package com.tom_roush.pdfbox.rendering;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public enum ImageType {
    BINARY { // from class: com.tom_roush.pdfbox.rendering.ImageType.1
        @Override // com.tom_roush.pdfbox.rendering.ImageType
        public Bitmap.Config toBitmapConfig() {
            return Bitmap.Config.ALPHA_8;
        }
    },
    GRAY { // from class: com.tom_roush.pdfbox.rendering.ImageType.2
        @Override // com.tom_roush.pdfbox.rendering.ImageType
        public Bitmap.Config toBitmapConfig() {
            return Bitmap.Config.ALPHA_8;
        }
    },
    RGB { // from class: com.tom_roush.pdfbox.rendering.ImageType.3
        @Override // com.tom_roush.pdfbox.rendering.ImageType
        public Bitmap.Config toBitmapConfig() {
            return Bitmap.Config.ARGB_8888;
        }
    },
    ARGB { // from class: com.tom_roush.pdfbox.rendering.ImageType.4
        @Override // com.tom_roush.pdfbox.rendering.ImageType
        public Bitmap.Config toBitmapConfig() {
            return Bitmap.Config.ARGB_8888;
        }
    },
    BGR { // from class: com.tom_roush.pdfbox.rendering.ImageType.5
        @Override // com.tom_roush.pdfbox.rendering.ImageType
        public Bitmap.Config toBitmapConfig() {
            return Bitmap.Config.ARGB_8888;
        }
    };

    public abstract Bitmap.Config toBitmapConfig();
}
