package com.taobao.accs.client;

import android.text.TextUtils;
import com.taobao.accs.IAppReceiver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, HashSet<IAppReceiver>> f10258a;

    /* JADX INFO: renamed from: com.taobao.accs.client.a$a, reason: collision with other inner class name */
    public static class C0178a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f10259a = new a();

        private C0178a() {
        }
    }

    public static a a() {
        return C0178a.f10259a;
    }

    public ArrayList<IAppReceiver> b() {
        HashSet hashSet = new HashSet();
        Iterator<HashSet<IAppReceiver>> it = this.f10258a.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next());
        }
        return new ArrayList<>(hashSet);
    }

    private a() {
        this.f10258a = new ConcurrentHashMap<>(2);
    }

    public void a(String str, IAppReceiver iAppReceiver) {
        if (iAppReceiver != null) {
            HashSet<IAppReceiver> hashSet = this.f10258a.get(str);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.f10258a.put(str, hashSet);
            }
            if (hashSet.contains(iAppReceiver)) {
                return;
            }
            hashSet.add(iAppReceiver);
        }
    }

    public void b(String str) {
        try {
            this.f10258a.remove(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ArrayList<IAppReceiver> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet<IAppReceiver> hashSet = this.f10258a.get(str);
        if (hashSet == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(hashSet);
    }
}
