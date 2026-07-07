package cn.admobiletop.adsuyi.adapter.gdt.e;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static void a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }
}
