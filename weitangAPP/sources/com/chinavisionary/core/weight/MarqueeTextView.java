package com.chinavisionary.core.weight;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes.dex */
public class MarqueeTextView extends AppCompatTextView {
    public MarqueeTextView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }

    public MarqueeTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MarqueeTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
