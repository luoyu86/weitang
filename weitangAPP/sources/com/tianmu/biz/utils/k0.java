package com.tianmu.biz.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f10865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f10866b;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f10867a;

        public a(Handler handler) {
            this.f10867a = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Handler handler = this.f10867a;
            if (handler != null) {
                handler.handleMessage(message);
            }
        }
    }

    static {
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            f10865a = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = f10865a.getType().getDeclaredField("mHandler");
            f10866b = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(Toast toast) {
        try {
            Object obj = f10865a.get(toast);
            f10866b.set(obj, new a((Handler) f10866b.get(obj)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(Context context, CharSequence charSequence, int i2) {
        Toast toastMakeText = Toast.makeText(context, charSequence, i2);
        a(toastMakeText);
        toastMakeText.show();
    }
}
