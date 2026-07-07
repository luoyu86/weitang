package com.google.gson.internal.bind;

import c.i.b.a0.b;
import c.i.b.a0.c;
import c.i.b.f;
import c.i.b.v;
import c.i.b.w;
import c.i.b.y.g;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class ObjectTypeAdapter extends v<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f9006a = new w() { // from class: com.google.gson.internal.bind.ObjectTypeAdapter.1
        @Override // c.i.b.w
        public <T> v<T> create(f fVar, c.i.b.z.a<T> aVar) {
            if (aVar.getRawType() == Object.class) {
                return new ObjectTypeAdapter(fVar);
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f9007b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9008a;

        static {
            int[] iArr = new int[b.values().length];
            f9008a = iArr;
            try {
                iArr[b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9008a[b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9008a[b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9008a[b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9008a[b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9008a[b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ObjectTypeAdapter(f fVar) {
        this.f9007b = fVar;
    }

    @Override // c.i.b.v
    public Object read(c.i.b.a0.a aVar) throws IOException {
        switch (a.f9008a[aVar.peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.beginArray();
                while (aVar.hasNext()) {
                    arrayList.add(read(aVar));
                }
                aVar.endArray();
                return arrayList;
            case 2:
                g gVar = new g();
                aVar.beginObject();
                while (aVar.hasNext()) {
                    gVar.put(aVar.nextName(), read(aVar));
                }
                aVar.endObject();
                return gVar;
            case 3:
                return aVar.nextString();
            case 4:
                return Double.valueOf(aVar.nextDouble());
            case 5:
                return Boolean.valueOf(aVar.nextBoolean());
            case 6:
                aVar.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // c.i.b.v
    public void write(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.nullValue();
            return;
        }
        v adapter = this.f9007b.getAdapter(obj.getClass());
        if (!(adapter instanceof ObjectTypeAdapter)) {
            adapter.write(cVar, obj);
        } else {
            cVar.beginObject();
            cVar.endObject();
        }
    }
}
