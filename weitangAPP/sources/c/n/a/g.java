package c.n.a;

import android.view.animation.Interpolator;
import c.n.a.f;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f2887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f2888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Interpolator f2889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<f> f2890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k f2891f;

    public g(f... fVarArr) {
        this.f2886a = fVarArr.length;
        ArrayList<f> arrayList = new ArrayList<>();
        this.f2890e = arrayList;
        arrayList.addAll(Arrays.asList(fVarArr));
        this.f2887b = this.f2890e.get(0);
        f fVar = this.f2890e.get(this.f2886a - 1);
        this.f2888c = fVar;
        this.f2889d = fVar.getInterpolator();
    }

    public static g ofFloat(float... fArr) {
        int length = fArr.length;
        f.a[] aVarArr = new f.a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (f.a) f.ofFloat(0.0f);
            aVarArr[1] = (f.a) f.ofFloat(1.0f, fArr[0]);
        } else {
            aVarArr[0] = (f.a) f.ofFloat(0.0f, fArr[0]);
            for (int i2 = 1; i2 < length; i2++) {
                aVarArr[i2] = (f.a) f.ofFloat(i2 / (length - 1), fArr[i2]);
            }
        }
        return new c(aVarArr);
    }

    public static g ofInt(int... iArr) {
        int length = iArr.length;
        f.b[] bVarArr = new f.b[Math.max(length, 2)];
        if (length == 1) {
            bVarArr[0] = (f.b) f.ofInt(0.0f);
            bVarArr[1] = (f.b) f.ofInt(1.0f, iArr[0]);
        } else {
            bVarArr[0] = (f.b) f.ofInt(0.0f, iArr[0]);
            for (int i2 = 1; i2 < length; i2++) {
                bVarArr[i2] = (f.b) f.ofInt(i2 / (length - 1), iArr[i2]);
            }
        }
        return new e(bVarArr);
    }

    public static g ofKeyframe(f... fVarArr) {
        int length = fVarArr.length;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 = 0; i3 < length; i3++) {
            if (fVarArr[i3] instanceof f.a) {
                z = true;
            } else if (fVarArr[i3] instanceof f.b) {
                z2 = true;
            } else {
                z3 = true;
            }
        }
        if (z && !z2 && !z3) {
            f.a[] aVarArr = new f.a[length];
            while (i2 < length) {
                aVarArr[i2] = (f.a) fVarArr[i2];
                i2++;
            }
            return new c(aVarArr);
        }
        if (!z2 || z || z3) {
            return new g(fVarArr);
        }
        f.b[] bVarArr = new f.b[length];
        while (i2 < length) {
            bVarArr[i2] = (f.b) fVarArr[i2];
            i2++;
        }
        return new e(bVarArr);
    }

    public static g ofObject(Object... objArr) {
        int length = objArr.length;
        f.c[] cVarArr = new f.c[Math.max(length, 2)];
        if (length == 1) {
            cVarArr[0] = (f.c) f.ofObject(0.0f);
            cVarArr[1] = (f.c) f.ofObject(1.0f, objArr[0]);
        } else {
            cVarArr[0] = (f.c) f.ofObject(0.0f, objArr[0]);
            for (int i2 = 1; i2 < length; i2++) {
                cVarArr[i2] = (f.c) f.ofObject(i2 / (length - 1), objArr[i2]);
            }
        }
        return new g(cVarArr);
    }

    public Object getValue(float f2) {
        int i2 = this.f2886a;
        if (i2 == 2) {
            Interpolator interpolator = this.f2889d;
            if (interpolator != null) {
                f2 = interpolator.getInterpolation(f2);
            }
            return this.f2891f.evaluate(f2, this.f2887b.getValue(), this.f2888c.getValue());
        }
        int i3 = 1;
        if (f2 <= 0.0f) {
            f fVar = this.f2890e.get(1);
            Interpolator interpolator2 = fVar.getInterpolator();
            if (interpolator2 != null) {
                f2 = interpolator2.getInterpolation(f2);
            }
            float fraction = this.f2887b.getFraction();
            return this.f2891f.evaluate((f2 - fraction) / (fVar.getFraction() - fraction), this.f2887b.getValue(), fVar.getValue());
        }
        if (f2 >= 1.0f) {
            f fVar2 = this.f2890e.get(i2 - 2);
            Interpolator interpolator3 = this.f2888c.getInterpolator();
            if (interpolator3 != null) {
                f2 = interpolator3.getInterpolation(f2);
            }
            float fraction2 = fVar2.getFraction();
            return this.f2891f.evaluate((f2 - fraction2) / (this.f2888c.getFraction() - fraction2), fVar2.getValue(), this.f2888c.getValue());
        }
        f fVar3 = this.f2887b;
        while (i3 < this.f2886a) {
            f fVar4 = this.f2890e.get(i3);
            if (f2 < fVar4.getFraction()) {
                Interpolator interpolator4 = fVar4.getInterpolator();
                if (interpolator4 != null) {
                    f2 = interpolator4.getInterpolation(f2);
                }
                float fraction3 = fVar3.getFraction();
                return this.f2891f.evaluate((f2 - fraction3) / (fVar4.getFraction() - fraction3), fVar3.getValue(), fVar4.getValue());
            }
            i3++;
            fVar3 = fVar4;
        }
        return this.f2888c.getValue();
    }

    public void setEvaluator(k kVar) {
        this.f2891f = kVar;
    }

    public String toString() {
        String str = " ";
        for (int i2 = 0; i2 < this.f2886a; i2++) {
            str = str + this.f2890e.get(i2).getValue() + "  ";
        }
        return str;
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public g mo8clone() {
        ArrayList<f> arrayList = this.f2890e;
        int size = arrayList.size();
        f[] fVarArr = new f[size];
        for (int i2 = 0; i2 < size; i2++) {
            fVarArr[i2] = arrayList.get(i2).mo9clone();
        }
        return new g(fVarArr);
    }
}
