package cn.admobiletop.adsuyi.ad.widget.notice;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.admobiletop.adsuyi.a.n.a.h;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNoticeListener;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ADSuyiNoticeAdContainer extends h {
    public ADSuyiNoticeListener p;

    public ADSuyiNoticeAdContainer(@NonNull Context context) {
        this(context, null);
    }

    @Override // cn.admobiletop.adsuyi.a.n.a.h
    public ADSuyiNoticeListener getNotificationListener() {
        return this.p;
    }

    @Override // cn.admobiletop.adsuyi.a.n.a.h, cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        this.p = null;
        super.release();
    }

    public void setNotificationListener(ADSuyiNoticeListener aDSuyiNoticeListener) {
        this.p = aDSuyiNoticeListener;
    }

    public ADSuyiNoticeAdContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ADSuyiNoticeAdContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
