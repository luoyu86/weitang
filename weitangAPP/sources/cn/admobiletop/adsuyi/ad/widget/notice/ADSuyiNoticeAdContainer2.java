package cn.admobiletop.adsuyi.ad.widget.notice;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.admobiletop.adsuyi.a.n.a.g;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNoticeListener2;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiNoticeAdContainer2 extends g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ADSuyiNoticeListener2 f3593d;

    public ADSuyiNoticeAdContainer2(@NonNull Context context) {
        this(context, null);
    }

    @Override // cn.admobiletop.adsuyi.a.n.a.g
    public ADSuyiNoticeListener2 getNotificationListener() {
        return this.f3593d;
    }

    @Override // cn.admobiletop.adsuyi.a.n.a.g, cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        this.f3593d = null;
        super.release();
    }

    public void setNotificationListener(ADSuyiNoticeListener2 aDSuyiNoticeListener2) {
        this.f3593d = aDSuyiNoticeListener2;
    }

    public ADSuyiNoticeAdContainer2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ADSuyiNoticeAdContainer2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
