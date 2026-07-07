package com.lzy.imagepicker.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;

/* JADX INFO: loaded from: classes2.dex */
public class SuperCheckBox extends AppCompatCheckBox {
    public SuperCheckBox(Context context) {
        super(context);
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        boolean zPerformClick = super.performClick();
        if (!zPerformClick) {
            playSoundEffect(0);
        }
        return zPerformClick;
    }

    public SuperCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SuperCheckBox(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
