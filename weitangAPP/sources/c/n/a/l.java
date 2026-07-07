package c.n.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import c.n.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class l extends c.n.a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ThreadLocal<f> f2911b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ThreadLocal<ArrayList<l>> f2912c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<ArrayList<l>> f2913d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ThreadLocal<ArrayList<l>> f2914e = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ThreadLocal<ArrayList<l>> f2915f = new d();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ThreadLocal<ArrayList<l>> f2916g = new e();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Interpolator f2917h = new AccelerateDecelerateInterpolator();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k f2918i = new c.n.a.d();
    public static final k j = new c.n.a.b();
    public static long k = 10;
    public j[] C;
    public HashMap<String, j> D;
    public long l;
    public long r;
    public long m = -1;
    public boolean n = false;
    public int o = 0;
    public float p = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2919q = false;
    public int s = 0;
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public long w = 300;
    public long x = 0;
    public int y = 0;
    public int z = 1;
    public Interpolator A = f2917h;
    public ArrayList<g> B = null;

    public static class a extends ThreadLocal<ArrayList<l>> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<l> initialValue() {
            return new ArrayList<>();
        }
    }

    public static class b extends ThreadLocal<ArrayList<l>> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<l> initialValue() {
            return new ArrayList<>();
        }
    }

    public static class c extends ThreadLocal<ArrayList<l>> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<l> initialValue() {
            return new ArrayList<>();
        }
    }

    public static class d extends ThreadLocal<ArrayList<l>> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<l> initialValue() {
            return new ArrayList<>();
        }
    }

    public static class e extends ThreadLocal<ArrayList<l>> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<l> initialValue() {
            return new ArrayList<>();
        }
    }

    public static class f extends Handler {
        public f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z;
            ArrayList arrayList = (ArrayList) l.f2912c.get();
            ArrayList arrayList2 = (ArrayList) l.f2914e.get();
            int i2 = message.what;
            if (i2 == 0) {
                ArrayList arrayList3 = (ArrayList) l.f2913d.get();
                z = arrayList.size() <= 0 && arrayList2.size() <= 0;
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        l lVar = (l) arrayList4.get(i3);
                        if (lVar.x == 0) {
                            lVar.r();
                        } else {
                            arrayList2.add(lVar);
                        }
                    }
                }
            } else if (i2 != 1) {
                return;
            } else {
                z = true;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) l.f2916g.get();
            ArrayList arrayList6 = (ArrayList) l.f2915f.get();
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                l lVar2 = (l) arrayList2.get(i4);
                if (lVar2.n(jCurrentAnimationTimeMillis)) {
                    arrayList5.add(lVar2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i5 = 0; i5 < size3; i5++) {
                    l lVar3 = (l) arrayList5.get(i5);
                    lVar3.r();
                    lVar3.t = true;
                    arrayList2.remove(lVar3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i6 = 0;
            while (i6 < size4) {
                l lVar4 = (l) arrayList.get(i6);
                if (lVar4.m(jCurrentAnimationTimeMillis)) {
                    arrayList6.add(lVar4);
                }
                if (arrayList.size() == size4) {
                    i6++;
                } else {
                    size4--;
                    arrayList6.remove(lVar4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i7 = 0; i7 < arrayList6.size(); i7++) {
                    ((l) arrayList6.get(i7)).o();
                }
                arrayList6.clear();
            }
            if (z) {
                if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                    return;
                }
                sendEmptyMessageDelayed(1, Math.max(0L, l.k - (AnimationUtils.currentAnimationTimeMillis() - jCurrentAnimationTimeMillis)));
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public interface g {
        void onAnimationUpdate(l lVar);
    }

    public static void clearAllAnimations() {
        f2912c.get().clear();
        f2913d.get().clear();
        f2914e.get().clear();
    }

    public static int getCurrentAnimationsCount() {
        return f2912c.get().size();
    }

    public static long getFrameDelay() {
        return k;
    }

    public static l ofFloat(float... fArr) {
        l lVar = new l();
        lVar.setFloatValues(fArr);
        return lVar;
    }

    public static l ofInt(int... iArr) {
        l lVar = new l();
        lVar.setIntValues(iArr);
        return lVar;
    }

    public static l ofObject(k kVar, Object... objArr) {
        l lVar = new l();
        lVar.setObjectValues(objArr);
        lVar.setEvaluator(kVar);
        return lVar;
    }

    public static l ofPropertyValuesHolder(j... jVarArr) {
        l lVar = new l();
        lVar.setValues(jVarArr);
        return lVar;
    }

    public static void setFrameDelay(long j2) {
        k = j2;
    }

    public void addUpdateListener(g gVar) {
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.add(gVar);
    }

    @Override // c.n.a.a
    public void cancel() {
        ArrayList<a.InterfaceC0045a> arrayList;
        if (this.s != 0 || f2913d.get().contains(this) || f2914e.get().contains(this)) {
            if (this.t && (arrayList = this.f2872a) != null) {
                Iterator it = ((ArrayList) arrayList.clone()).iterator();
                while (it.hasNext()) {
                    ((a.InterfaceC0045a) it.next()).onAnimationCancel(this);
                }
            }
            o();
        }
    }

    @Override // c.n.a.a
    public void end() {
        if (!f2912c.get().contains(this) && !f2913d.get().contains(this)) {
            this.f2919q = false;
            r();
        } else if (!this.v) {
            p();
        }
        int i2 = this.y;
        if (i2 <= 0 || (i2 & 1) != 1) {
            l(1.0f);
        } else {
            l(0.0f);
        }
        o();
    }

    public float getAnimatedFraction() {
        return this.p;
    }

    public Object getAnimatedValue() {
        j[] jVarArr = this.C;
        if (jVarArr == null || jVarArr.length <= 0) {
            return null;
        }
        return jVarArr[0].b();
    }

    public long getCurrentPlayTime() {
        if (!this.v || this.s == 0) {
            return 0L;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.l;
    }

    @Override // c.n.a.a
    public long getDuration() {
        return this.w;
    }

    public Interpolator getInterpolator() {
        return this.A;
    }

    public int getRepeatCount() {
        return this.y;
    }

    public int getRepeatMode() {
        return this.z;
    }

    @Override // c.n.a.a
    public long getStartDelay() {
        return this.x;
    }

    public j[] getValues() {
        return this.C;
    }

    @Override // c.n.a.a
    public boolean isRunning() {
        return this.s == 1 || this.t;
    }

    @Override // c.n.a.a
    public boolean isStarted() {
        return this.u;
    }

    public void l(float f2) {
        float interpolation = this.A.getInterpolation(f2);
        this.p = interpolation;
        int length = this.C.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.C[i2].a(interpolation);
        }
        ArrayList<g> arrayList = this.B;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.B.get(i3).onAnimationUpdate(this);
            }
        }
    }

    public boolean m(long j2) {
        boolean z = true;
        if (this.s == 0) {
            this.s = 1;
            long j3 = this.m;
            if (j3 < 0) {
                this.l = j2;
            } else {
                this.l = j2 - j3;
                this.m = -1L;
            }
        }
        int i2 = this.s;
        if (i2 != 1 && i2 != 2) {
            return false;
        }
        long j4 = this.w;
        float fMin = j4 > 0 ? (j2 - this.l) / j4 : 1.0f;
        if (fMin >= 1.0f) {
            int i3 = this.o;
            int i4 = this.y;
            if (i3 < i4 || i4 == -1) {
                ArrayList<a.InterfaceC0045a> arrayList = this.f2872a;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        this.f2872a.get(i5).onAnimationRepeat(this);
                    }
                }
                if (this.z == 2) {
                    this.n = !this.n;
                }
                this.o += (int) fMin;
                fMin %= 1.0f;
                this.l += this.w;
                z = false;
            } else {
                fMin = Math.min(fMin, 1.0f);
            }
        } else {
            z = false;
        }
        if (this.n) {
            fMin = 1.0f - fMin;
        }
        l(fMin);
        return z;
    }

    public final boolean n(long j2) {
        if (!this.f2919q) {
            this.f2919q = true;
            this.r = j2;
            return false;
        }
        long j3 = j2 - this.r;
        long j4 = this.x;
        if (j3 <= j4) {
            return false;
        }
        this.l = j2 - (j3 - j4);
        this.s = 1;
        return true;
    }

    public final void o() {
        ArrayList<a.InterfaceC0045a> arrayList;
        f2912c.get().remove(this);
        f2913d.get().remove(this);
        f2914e.get().remove(this);
        this.s = 0;
        if (this.t && (arrayList = this.f2872a) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((a.InterfaceC0045a) arrayList2.get(i2)).onAnimationEnd(this);
            }
        }
        this.t = false;
        this.u = false;
    }

    public void p() {
        if (this.v) {
            return;
        }
        int length = this.C.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.C[i2].e();
        }
        this.v = true;
    }

    public final void q(boolean z) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.n = z;
        this.o = 0;
        this.s = 0;
        this.u = true;
        this.f2919q = false;
        f2913d.get().add(this);
        if (this.x == 0) {
            setCurrentPlayTime(getCurrentPlayTime());
            this.s = 0;
            this.t = true;
            ArrayList<a.InterfaceC0045a> arrayList = this.f2872a;
            if (arrayList != null) {
                ArrayList arrayList2 = (ArrayList) arrayList.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((a.InterfaceC0045a) arrayList2.get(i2)).onAnimationStart(this);
                }
            }
        }
        f fVar = f2911b.get();
        if (fVar == null) {
            fVar = new f(null);
            f2911b.set(fVar);
        }
        fVar.sendEmptyMessage(0);
    }

    public final void r() {
        ArrayList<a.InterfaceC0045a> arrayList;
        p();
        f2912c.get().add(this);
        if (this.x <= 0 || (arrayList = this.f2872a) == null) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) arrayList.clone();
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((a.InterfaceC0045a) arrayList2.get(i2)).onAnimationStart(this);
        }
    }

    public void removeAllUpdateListeners() {
        ArrayList<g> arrayList = this.B;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
        this.B = null;
    }

    public void removeUpdateListener(g gVar) {
        ArrayList<g> arrayList = this.B;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(gVar);
        if (this.B.size() == 0) {
            this.B = null;
        }
    }

    public void reverse() {
        this.n = !this.n;
        if (this.s != 1) {
            q(true);
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.l = jCurrentAnimationTimeMillis - (this.w - (jCurrentAnimationTimeMillis - this.l));
    }

    public void setCurrentPlayTime(long j2) {
        p();
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.s != 1) {
            this.m = j2;
            this.s = 2;
        }
        this.l = jCurrentAnimationTimeMillis - j2;
        m(jCurrentAnimationTimeMillis);
    }

    public void setEvaluator(k kVar) {
        j[] jVarArr;
        if (kVar == null || (jVarArr = this.C) == null || jVarArr.length <= 0) {
            return;
        }
        jVarArr[0].setEvaluator(kVar);
    }

    public void setFloatValues(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return;
        }
        j[] jVarArr = this.C;
        if (jVarArr == null || jVarArr.length == 0) {
            setValues(j.ofFloat("", fArr));
        } else {
            jVarArr[0].setFloatValues(fArr);
        }
        this.v = false;
    }

    public void setIntValues(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        j[] jVarArr = this.C;
        if (jVarArr == null || jVarArr.length == 0) {
            setValues(j.ofInt("", iArr));
        } else {
            jVarArr[0].setIntValues(iArr);
        }
        this.v = false;
    }

    @Override // c.n.a.a
    public void setInterpolator(Interpolator interpolator) {
        if (interpolator != null) {
            this.A = interpolator;
        } else {
            this.A = new LinearInterpolator();
        }
    }

    public void setObjectValues(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        j[] jVarArr = this.C;
        if (jVarArr == null || jVarArr.length == 0) {
            setValues(j.ofObject("", (k) null, objArr));
        } else {
            jVarArr[0].setObjectValues(objArr);
        }
        this.v = false;
    }

    public void setRepeatCount(int i2) {
        this.y = i2;
    }

    public void setRepeatMode(int i2) {
        this.z = i2;
    }

    @Override // c.n.a.a
    public void setStartDelay(long j2) {
        this.x = j2;
    }

    public void setValues(j... jVarArr) {
        int length = jVarArr.length;
        this.C = jVarArr;
        this.D = new HashMap<>(length);
        for (j jVar : jVarArr) {
            this.D.put(jVar.getPropertyName(), jVar);
        }
        this.v = false;
    }

    @Override // c.n.a.a
    public void start() {
        q(false);
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.C != null) {
            for (int i2 = 0; i2 < this.C.length; i2++) {
                str = str + "\n    " + this.C[i2].toString();
            }
        }
        return str;
    }

    @Override // c.n.a.a
    public l setDuration(long j2) {
        if (j2 >= 0) {
            this.w = j2;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j2);
    }

    @Override // c.n.a.a
    /* JADX INFO: renamed from: clone */
    public l mo7clone() {
        l lVar = (l) super.mo7clone();
        ArrayList<g> arrayList = this.B;
        if (arrayList != null) {
            lVar.B = new ArrayList<>();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                lVar.B.add(arrayList.get(i2));
            }
        }
        lVar.m = -1L;
        lVar.n = false;
        lVar.o = 0;
        lVar.v = false;
        lVar.s = 0;
        lVar.f2919q = false;
        j[] jVarArr = this.C;
        if (jVarArr != null) {
            int length = jVarArr.length;
            lVar.C = new j[length];
            lVar.D = new HashMap<>(length);
            for (int i3 = 0; i3 < length; i3++) {
                j jVarMo10clone = jVarArr[i3].mo10clone();
                lVar.C[i3] = jVarMo10clone;
                lVar.D.put(jVarMo10clone.getPropertyName(), jVarMo10clone);
            }
        }
        return lVar;
    }

    public Object getAnimatedValue(String str) {
        j jVar = this.D.get(str);
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }
}
