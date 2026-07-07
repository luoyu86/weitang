package c.n.a;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class f2880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interpolator f2881c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2882d = false;

    public static f ofFloat(float f2, float f3) {
        return new a(f2, f3);
    }

    public static f ofInt(float f2, int i2) {
        return new b(f2, i2);
    }

    public static f ofObject(float f2, Object obj) {
        return new c(f2, obj);
    }

    @Override // 
    /* JADX INFO: renamed from: clone */
    public abstract f mo9clone();

    public float getFraction() {
        return this.f2879a;
    }

    public Interpolator getInterpolator() {
        return this.f2881c;
    }

    public Class getType() {
        return this.f2880b;
    }

    public abstract Object getValue();

    public boolean hasValue() {
        return this.f2882d;
    }

    public void setFraction(float f2) {
        this.f2879a = f2;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f2881c = interpolator;
    }

    public abstract void setValue(Object obj);

    public static class a extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f2883e;

        public a(float f2, float f3) {
            this.f2879a = f2;
            this.f2883e = f3;
            this.f2880b = Float.TYPE;
            this.f2882d = true;
        }

        public float getFloatValue() {
            return this.f2883e;
        }

        @Override // c.n.a.f
        public Object getValue() {
            return Float.valueOf(this.f2883e);
        }

        @Override // c.n.a.f
        public void setValue(Object obj) {
            if (obj == null || obj.getClass() != Float.class) {
                return;
            }
            this.f2883e = ((Float) obj).floatValue();
            this.f2882d = true;
        }

        @Override // c.n.a.f
        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public a mo9clone() {
            a aVar = new a(getFraction(), this.f2883e);
            aVar.setInterpolator(getInterpolator());
            return aVar;
        }

        public a(float f2) {
            this.f2879a = f2;
            this.f2880b = Float.TYPE;
        }
    }

    public static class b extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2884e;

        public b(float f2, int i2) {
            this.f2879a = f2;
            this.f2884e = i2;
            this.f2880b = Integer.TYPE;
            this.f2882d = true;
        }

        public int getIntValue() {
            return this.f2884e;
        }

        @Override // c.n.a.f
        public Object getValue() {
            return Integer.valueOf(this.f2884e);
        }

        @Override // c.n.a.f
        public void setValue(Object obj) {
            if (obj == null || obj.getClass() != Integer.class) {
                return;
            }
            this.f2884e = ((Integer) obj).intValue();
            this.f2882d = true;
        }

        @Override // c.n.a.f
        /* JADX INFO: renamed from: clone */
        public b mo9clone() {
            b bVar = new b(getFraction(), this.f2884e);
            bVar.setInterpolator(getInterpolator());
            return bVar;
        }

        public b(float f2) {
            this.f2879a = f2;
            this.f2880b = Integer.TYPE;
        }
    }

    public static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f2885e;

        public c(float f2, Object obj) {
            this.f2879a = f2;
            this.f2885e = obj;
            boolean z = obj != null;
            this.f2882d = z;
            this.f2880b = z ? obj.getClass() : Object.class;
        }

        @Override // c.n.a.f
        public Object getValue() {
            return this.f2885e;
        }

        @Override // c.n.a.f
        public void setValue(Object obj) {
            this.f2885e = obj;
            this.f2882d = obj != null;
        }

        @Override // c.n.a.f
        /* JADX INFO: renamed from: clone */
        public c mo9clone() {
            c cVar = new c(getFraction(), this.f2885e);
            cVar.setInterpolator(getInterpolator());
            return cVar;
        }
    }

    public static f ofFloat(float f2) {
        return new a(f2);
    }

    public static f ofInt(float f2) {
        return new b(f2);
    }

    public static f ofObject(float f2) {
        return new c(f2, null);
    }
}
