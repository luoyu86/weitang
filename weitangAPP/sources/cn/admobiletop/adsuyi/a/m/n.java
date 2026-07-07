package cn.admobiletop.adsuyi.a.m;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f3435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f3436b;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Handler f3437a;

        public a(Handler handler) {
            this.f3437a = handler;
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
            Handler handler = this.f3437a;
            if (handler != null) {
                handler.handleMessage(message);
            }
        }
    }

    static {
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            f3435a = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = f3435a.getType().getDeclaredField("mHandler");
            f3436b = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(Context context, String str) {
        Toast toastMakeText = Toast.makeText(context, str, 0);
        b(toastMakeText);
        toastMakeText.show();
    }

    public static void b(Toast toast) {
        try {
            Object obj = f3435a.get(toast);
            f3436b.set(obj, new a((Handler) f3436b.get(obj)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
