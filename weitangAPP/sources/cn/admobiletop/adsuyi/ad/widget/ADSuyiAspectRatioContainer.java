package cn.admobiletop.adsuyi.ad.widget;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiAspectRatioContainer extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3552a;

    public ADSuyiAspectRatioContainer(Context context, float f2) {
        super(context);
        this.f3552a = f2;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f3552a != 0.0f) {
            setMeasuredDimension(RelativeLayout.getDefaultSize(0, i2), RelativeLayout.getDefaultSize(0, i3));
            int measuredWidth = getMeasuredWidth();
            int i4 = (int) (measuredWidth * this.f3552a);
            i2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, WXVideoFileObject.FILE_SIZE_LIMIT);
            i3 = View.MeasureSpec.makeMeasureSpec(i4, WXVideoFileObject.FILE_SIZE_LIMIT);
        }
        super.onMeasure(i2, i3);
    }

    public void setAspectRatio(float f2) {
        this.f3552a = f2;
    }
}
