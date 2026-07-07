package com.heytap.openid.framework;

import android.app.OplusNotificationManager;
import android.os.Build;
import com.android.id.impl.IdProviderImpl;
import com.heytap.openid.sdk.m_h;

/* JADX INFO: loaded from: classes2.dex */
public class m_a {
    public IdProviderImpl m_a;
    public OplusNotificationManager m_b = null;

    /* JADX INFO: renamed from: com.heytap.openid.framework.m_a$m_a, reason: collision with other inner class name */
    public static class C0117m_a {
        public static final m_a m_a = new m_a();
    }

    public m_a() {
        this.m_a = null;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 != 31 && i2 != 32) {
            try {
                this.m_a = new IdProviderImpl();
                return;
            } catch (Error | Exception e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("1084: ");
                sb.append(e2.getMessage() != null ? e2.getMessage() : e2.getLocalizedMessage());
                m_h.m_b(sb.toString());
            }
        }
        m_a();
    }

    public final native void m_a();
}
