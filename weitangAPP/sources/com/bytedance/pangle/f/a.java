package com.bytedance.pangle.f;

import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.c;
import com.bytedance.pangle.d;
import com.bytedance.pangle.i;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f6045a;

    public static a b() {
        if (f6045a == null) {
            synchronized (a.class) {
                if (f6045a == null) {
                    f6045a = new a();
                }
            }
        }
        return f6045a;
    }

    @Override // com.bytedance.pangle.c
    public final boolean a(String str) {
        return PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.bytedance.pangle.c
    public final boolean a(String str, String str2) {
        return PluginManager.getInstance().syncInstall(str, new File(str2));
    }

    @Override // com.bytedance.pangle.c
    public final void a(int i2, d dVar) {
        Zeus.registerPluginStateListener(new c(dVar, i2));
    }

    @Override // com.bytedance.pangle.c
    public final void a(int i2) {
        ZeusPluginStateListener next;
        List<ZeusPluginStateListener> list = i.a().f6116b;
        Iterator<ZeusPluginStateListener> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if ((next instanceof c) && ((c) next).f6065a == i2) {
                break;
            }
        }
        if (next != null) {
            list.remove(next);
        }
    }

    @Override // com.bytedance.pangle.c
    public final int b(String str) {
        return PluginManager.getInstance().getPlugin(str).getVersion();
    }
}
