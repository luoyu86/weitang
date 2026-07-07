package com.chinavisionary.core.weight;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import c.e.a.d.c0.d;
import de.hdodenhof.circleimageview.CircleImageView;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class CoreCircleImageView extends CircleImageView {
    public CoreCircleImageView(Context context) {
        super(context);
    }

    public void loadImageToFile(File file) {
        if (file != null) {
            setTag(getId(), file.getAbsolutePath());
        }
        d.getInstance().display(file, this);
    }

    public void loadImageToResId(@DrawableRes int i2) {
        d.getInstance().display(i2, this);
    }

    public void loadImageToUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            setTag(getId(), str);
        }
        d.getInstance().display(str, this);
    }

    public CoreCircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CoreCircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
