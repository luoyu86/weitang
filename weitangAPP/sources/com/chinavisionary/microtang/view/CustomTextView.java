package com.chinavisionary.microtang.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import c.e.a.d.x;

/* JADX INFO: loaded from: classes2.dex */
public class CustomTextView extends AppCompatTextView implements Cloneable {
    public CustomTextView(Context context) {
        super(context);
    }

    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CustomTextView clone() throws CloneNotSupportedException {
        return (CustomTextView) super.clone();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(x.getNotNullStr(charSequence, ""), bufferType);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
