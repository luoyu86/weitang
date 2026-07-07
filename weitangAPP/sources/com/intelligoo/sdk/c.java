package com.intelligoo.sdk;

import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c<T>.a f9199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c<T>.a f9200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9201c = 0;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f9202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c<T>.a f9203b;

        public a(T t, c<T>.a aVar) {
            this.f9202a = t;
            this.f9203b = aVar;
        }
    }

    public c() {
        c<T>.a aVar = new a(null, null);
        aVar.f9203b = null;
        this.f9200b = aVar;
        this.f9199a = aVar;
    }

    public T a() {
        c<T>.a aVar = this.f9200b;
        c<T>.a aVar2 = this.f9199a;
        if (aVar == aVar2) {
            try {
                throw new Exception("堆栈为空");
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        c<T>.a aVar3 = aVar2.f9203b;
        T t = aVar3.f9202a;
        aVar2.f9203b = aVar3.f9203b;
        if (aVar3.f9203b == null) {
            this.f9200b = aVar2;
        }
        this.f9201c--;
        return t;
    }

    public void a(T t) {
        c<T>.a aVar = new a(t, null);
        this.f9200b.f9203b = aVar;
        this.f9200b = aVar;
        this.f9201c++;
    }

    public T b() {
        return this.f9199a.f9203b.f9202a;
    }

    public int c() {
        return this.f9201c;
    }

    public boolean d() {
        return this.f9201c == 0;
    }

    public String toString() {
        if (d()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder("[");
        c<T>.a aVar = this.f9199a;
        while (true) {
            aVar = aVar.f9203b;
            if (aVar == null) {
                int length = sb.length();
                StringBuilder sbDelete = sb.delete(length - 2, length);
                sbDelete.append("]");
                return sbDelete.toString();
            }
            sb.append(aVar.f9202a.toString() + ", ");
        }
    }
}
