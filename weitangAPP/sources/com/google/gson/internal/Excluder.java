package com.google.gson.internal;

import c.i.b.a0.c;
import c.i.b.b;
import c.i.b.f;
import c.i.b.v;
import c.i.b.w;
import c.i.b.x.d;
import c.i.b.x.e;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Excluder implements w, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Excluder f8978a = new Excluder();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8982e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f8979b = -1.0d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8980c = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8981d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<b> f8983f = Collections.emptyList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<b> f8984g = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> extends v<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public v<T> f8985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f8986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f8987c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f f8988d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ c.i.b.z.a f8989e;

        public a(boolean z, boolean z2, f fVar, c.i.b.z.a aVar) {
            this.f8986b = z;
            this.f8987c = z2;
            this.f8988d = fVar;
            this.f8989e = aVar;
        }

        public final v<T> a() {
            v<T> vVar = this.f8985a;
            if (vVar != null) {
                return vVar;
            }
            v<T> delegateAdapter = this.f8988d.getDelegateAdapter(Excluder.this, this.f8989e);
            this.f8985a = delegateAdapter;
            return delegateAdapter;
        }

        @Override // c.i.b.v
        public T read(c.i.b.a0.a aVar) throws IOException {
            if (!this.f8986b) {
                return a().read(aVar);
            }
            aVar.skipValue();
            return null;
        }

        @Override // c.i.b.v
        public void write(c cVar, T t) throws IOException {
            if (this.f8987c) {
                cVar.nullValue();
            } else {
                a().write(cVar, t);
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final boolean b(Class<?> cls) {
        if (this.f8979b == -1.0d || i((d) cls.getAnnotation(d.class), (e) cls.getAnnotation(e.class))) {
            return (!this.f8981d && e(cls)) || d(cls);
        }
        return true;
    }

    public final boolean c(Class<?> cls, boolean z) {
        Iterator<b> it = (z ? this.f8983f : this.f8984g).iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // c.i.b.w
    public <T> v<T> create(f fVar, c.i.b.z.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        boolean zB = b(rawType);
        boolean z = zB || c(rawType, true);
        boolean z2 = zB || c(rawType, false);
        if (z || z2) {
            return new a(z2, z, fVar, aVar);
        }
        return null;
    }

    public final boolean d(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    public Excluder disableInnerClassSerialization() {
        Excluder excluderClone = clone();
        excluderClone.f8981d = false;
        return excluderClone;
    }

    public final boolean e(Class<?> cls) {
        return cls.isMemberClass() && !f(cls);
    }

    public boolean excludeClass(Class<?> cls, boolean z) {
        return b(cls) || c(cls, z);
    }

    public boolean excludeField(Field field, boolean z) {
        c.i.b.x.a aVar;
        if ((this.f8980c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f8979b != -1.0d && !i((d) field.getAnnotation(d.class), (e) field.getAnnotation(e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f8982e && ((aVar = (c.i.b.x.a) field.getAnnotation(c.i.b.x.a.class)) == null || (!z ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.f8981d && e(field.getType())) || d(field.getType())) {
            return true;
        }
        List<b> list = z ? this.f8983f : this.f8984g;
        if (list.isEmpty()) {
            return false;
        }
        c.i.b.c cVar = new c.i.b.c(field);
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipField(cVar)) {
                return true;
            }
        }
        return false;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder excluderClone = clone();
        excluderClone.f8982e = true;
        return excluderClone;
    }

    public final boolean f(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public final boolean g(d dVar) {
        return dVar == null || dVar.value() <= this.f8979b;
    }

    public final boolean h(e eVar) {
        return eVar == null || eVar.value() > this.f8979b;
    }

    public final boolean i(d dVar, e eVar) {
        return g(dVar) && h(eVar);
    }

    public Excluder withExclusionStrategy(b bVar, boolean z, boolean z2) {
        Excluder excluderClone = clone();
        if (z) {
            ArrayList arrayList = new ArrayList(this.f8983f);
            excluderClone.f8983f = arrayList;
            arrayList.add(bVar);
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList(this.f8984g);
            excluderClone.f8984g = arrayList2;
            arrayList2.add(bVar);
        }
        return excluderClone;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder excluderClone = clone();
        excluderClone.f8980c = 0;
        for (int i2 : iArr) {
            excluderClone.f8980c = i2 | excluderClone.f8980c;
        }
        return excluderClone;
    }

    public Excluder withVersion(double d2) {
        Excluder excluderClone = clone();
        excluderClone.f8979b = d2;
        return excluderClone;
    }
}
