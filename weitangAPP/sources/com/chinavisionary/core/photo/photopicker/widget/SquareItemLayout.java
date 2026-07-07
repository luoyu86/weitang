package com.chinavisionary.core.photo.photopicker.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* JADX INFO: loaded from: classes.dex */
public class SquareItemLayout extends RelativeLayout {
    public SquareItemLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(RelativeLayout.getDefaultSize(0, i2), RelativeLayout.getDefaultSize(0, i3));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), WXVideoFileObject.FILE_SIZE_LIMIT);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    public SquareItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareItemLayout(Context context) {
        super(context);
    }
}
