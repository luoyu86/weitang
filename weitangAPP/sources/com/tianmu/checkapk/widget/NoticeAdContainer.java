package com.tianmu.checkapk.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class NoticeAdContainer extends a {
    private com.tianmu.d.b.a p;

    public NoticeAdContainer(@NonNull Context context) {
        this(context, null);
    }

    public void a(com.tianmu.d.b.a aVar) {
        this.p = aVar;
    }

    @Override // com.tianmu.checkapk.widget.a
    public void b() {
        this.p = null;
        super.b();
    }

    public NoticeAdContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.tianmu.checkapk.widget.a
    public com.tianmu.d.b.a a() {
        return this.p;
    }

    public NoticeAdContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
