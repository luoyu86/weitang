package com.tom_roush.pdfbox.pdmodel.interactive.form;

import com.tom_roush.pdfbox.pdmodel.PDPageContentStream;
import com.tom_roush.pdfbox.pdmodel.interactive.form.PlainText;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PlainTextFormatter {
    private static final int FONTSCALE = 1000;
    private final AppearanceStyle appearanceStyle;
    private final PDPageContentStream contents;
    private float horizontalOffset;
    private final TextAlign textAlignment;
    private final PlainText textContent;
    private float verticalOffset;
    private final float width;
    private final boolean wrapLines;

    /* JADX INFO: renamed from: com.tom_roush.pdfbox.pdmodel.interactive.form.PlainTextFormatter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$tom_roush$pdfbox$pdmodel$interactive$form$PlainTextFormatter$TextAlign;

        static {
            int[] iArr = new int[TextAlign.values().length];
            $SwitchMap$com$tom_roush$pdfbox$pdmodel$interactive$form$PlainTextFormatter$TextAlign = iArr;
            try {
                iArr[TextAlign.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tom_roush$pdfbox$pdmodel$interactive$form$PlainTextFormatter$TextAlign[TextAlign.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tom_roush$pdfbox$pdmodel$interactive$form$PlainTextFormatter$TextAlign[TextAlign.JUSTIFY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Builder {
        private AppearanceStyle appearanceStyle;
        private PDPageContentStream contents;
        private PlainText textContent;
        private boolean wrapLines = false;
        private float width = 0.0f;
        private TextAlign textAlignment = TextAlign.LEFT;
        private float horizontalOffset = 0.0f;
        private float verticalOffset = 0.0f;

        public Builder(PDPageContentStream pDPageContentStream) {
            this.contents = pDPageContentStream;
        }

        public PlainTextFormatter build() {
            return new PlainTextFormatter(this, null);
        }

        public Builder initialOffset(float f2, float f3) {
            this.horizontalOffset = f2;
            this.verticalOffset = f3;
            return this;
        }

        public Builder style(AppearanceStyle appearanceStyle) {
            this.appearanceStyle = appearanceStyle;
            return this;
        }

        public Builder text(PlainText plainText) {
            this.textContent = plainText;
            return this;
        }

        public Builder textAlign(int i2) {
            this.textAlignment = TextAlign.valueOf(i2);
            return this;
        }

        public Builder width(float f2) {
            this.width = f2;
            return this;
        }

        public Builder wrapLines(boolean z) {
            this.wrapLines = z;
            return this;
        }

        public Builder textAlign(TextAlign textAlign) {
            this.textAlignment = textAlign;
            return this;
        }
    }

    public enum TextAlign {
        LEFT(0),
        CENTER(1),
        RIGHT(2),
        JUSTIFY(4);

        private final int alignment;

        TextAlign(int i2) {
            this.alignment = i2;
        }

        public int getTextAlign() {
            return this.alignment;
        }

        public static TextAlign valueOf(int i2) {
            for (TextAlign textAlign : values()) {
                if (textAlign.getTextAlign() == i2) {
                    return textAlign;
                }
            }
            return LEFT;
        }
    }

    public /* synthetic */ PlainTextFormatter(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private void processLines(List<PlainText.Line> list, boolean z) throws IOException {
        float f2 = 0.0f;
        float width = 0.0f;
        float interWordSpacing = 0.0f;
        for (PlainText.Line line : list) {
            int i2 = AnonymousClass1.$SwitchMap$com$tom_roush$pdfbox$pdmodel$interactive$form$PlainTextFormatter$TextAlign[this.textAlignment.ordinal()];
            if (i2 == 1) {
                width = (this.width - line.getWidth()) / 2.0f;
            } else if (i2 == 2) {
                width = this.width - line.getWidth();
            } else if (i2 != 3) {
                width = 0.0f;
            } else if (list.indexOf(line) != list.size() - 1) {
                interWordSpacing = line.getInterWordSpacing(this.width);
            }
            float f3 = (-f2) + width + this.horizontalOffset;
            if (list.indexOf(line) == 0 && z) {
                this.contents.newLineAtOffset(f3, this.verticalOffset);
            } else {
                this.verticalOffset -= this.appearanceStyle.getLeading();
                this.contents.newLineAtOffset(f3, -this.appearanceStyle.getLeading());
            }
            f2 += f3;
            List<PlainText.Word> words = line.getWords();
            int i3 = 0;
            for (PlainText.Word word : words) {
                this.contents.showText(word.getText());
                float fFloatValue = ((Float) word.getAttributes().getIterator().getAttribute(PlainText.TextAttribute.WIDTH)).floatValue();
                if (i3 != words.size() - 1) {
                    this.contents.newLineAtOffset(fFloatValue + interWordSpacing, 0.0f);
                    f2 = f2 + fFloatValue + interWordSpacing;
                }
                i3++;
            }
        }
        this.horizontalOffset -= f2;
    }

    public void format() throws IOException {
        PlainText plainText = this.textContent;
        if (plainText == null || plainText.getParagraphs().isEmpty()) {
            return;
        }
        boolean z = true;
        for (PlainText.Paragraph paragraph : this.textContent.getParagraphs()) {
            if (this.wrapLines) {
                processLines(paragraph.getLines(this.appearanceStyle.getFont(), this.appearanceStyle.getFontSize(), this.width), z);
                z = false;
            } else {
                float stringWidth = (this.appearanceStyle.getFont().getStringWidth(paragraph.getText()) * this.appearanceStyle.getFontSize()) / 1000.0f;
                float f2 = 0.0f;
                if (stringWidth < this.width) {
                    int i2 = AnonymousClass1.$SwitchMap$com$tom_roush$pdfbox$pdmodel$interactive$form$PlainTextFormatter$TextAlign[this.textAlignment.ordinal()];
                    if (i2 == 1) {
                        f2 = (this.width - stringWidth) / 2.0f;
                    } else if (i2 == 2) {
                        f2 = this.width - stringWidth;
                    }
                }
                this.contents.newLineAtOffset(this.horizontalOffset + f2, this.verticalOffset);
                this.contents.showText(paragraph.getText());
            }
        }
    }

    private PlainTextFormatter(Builder builder) {
        this.appearanceStyle = builder.appearanceStyle;
        this.wrapLines = builder.wrapLines;
        this.width = builder.width;
        this.contents = builder.contents;
        this.textContent = builder.textContent;
        this.textAlignment = builder.textAlignment;
        this.horizontalOffset = builder.horizontalOffset;
        this.verticalOffset = builder.verticalOffset;
    }
}
