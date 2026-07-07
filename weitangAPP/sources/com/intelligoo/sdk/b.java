package com.intelligoo.sdk;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f9185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ArrayList f9186b = new ArrayList();

    public static ArrayList<String> a() {
        return (ArrayList) f9186b.clone();
    }

    public static void a(int i2) {
        f9185a = i2;
    }

    public static void a(ArrayList<String> arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            f9186b.add(arrayList.get(i2));
        }
    }

    public static void b() {
        f9186b.clear();
        f9185a = 0;
    }

    public static int c() {
        return f9185a;
    }

    public static int d() {
        return f9186b.size();
    }
}
