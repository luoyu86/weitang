package com.intelligoo.sdk;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f9267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ArrayList f9268b = new ArrayList();

    public static ArrayList<Map> a() {
        return (ArrayList) f9268b.clone();
    }

    public static void a(int i2) {
        f9267a = i2;
    }

    public static void a(ArrayList<Map> arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            f9268b.add(arrayList.get(i2));
        }
    }

    public static void b() {
        f9268b.clear();
        f9267a = 0;
    }

    public static int c() {
        return f9267a;
    }

    public static int d() {
        return f9268b.size();
    }
}
