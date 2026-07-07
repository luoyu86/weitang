package c.n.a;

import android.view.animation.Interpolator;
import c.n.a.f;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class c extends g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f2873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f2874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f2875i;
    public boolean j;

    public c(f.a... aVarArr) {
        super(aVarArr);
        this.j = true;
    }

    public float getFloatValue(float f2) {
        int i2 = this.f2886a;
        if (i2 == 2) {
            if (this.j) {
                this.j = false;
                this.f2873g = ((f.a) this.f2890e.get(0)).getFloatValue();
                float floatValue = ((f.a) this.f2890e.get(1)).getFloatValue();
                this.f2874h = floatValue;
                this.f2875i = floatValue - this.f2873g;
            }
            Interpolator interpolator = this.f2889d;
            if (interpolator != null) {
                f2 = interpolator.getInterpolation(f2);
            }
            k kVar = this.f2891f;
            return kVar == null ? this.f2873g + (f2 * this.f2875i) : ((Number) kVar.evaluate(f2, Float.valueOf(this.f2873g), Float.valueOf(this.f2874h))).floatValue();
        }
        if (f2 <= 0.0f) {
            f.a aVar = (f.a) this.f2890e.get(0);
            f.a aVar2 = (f.a) this.f2890e.get(1);
            float floatValue2 = aVar.getFloatValue();
            float floatValue3 = aVar2.getFloatValue();
            float fraction = aVar.getFraction();
            float fraction2 = aVar2.getFraction();
            Interpolator interpolator2 = aVar2.getInterpolator();
            if (interpolator2 != null) {
                f2 = interpolator2.getInterpolation(f2);
            }
            float f3 = (f2 - fraction) / (fraction2 - fraction);
            k kVar2 = this.f2891f;
            return kVar2 == null ? floatValue2 + (f3 * (floatValue3 - floatValue2)) : ((Number) kVar2.evaluate(f3, Float.valueOf(floatValue2), Float.valueOf(floatValue3))).floatValue();
        }
        if (f2 >= 1.0f) {
            f.a aVar3 = (f.a) this.f2890e.get(i2 - 2);
            f.a aVar4 = (f.a) this.f2890e.get(this.f2886a - 1);
            float floatValue4 = aVar3.getFloatValue();
            float floatValue5 = aVar4.getFloatValue();
            float fraction3 = aVar3.getFraction();
            float fraction4 = aVar4.getFraction();
            Interpolator interpolator3 = aVar4.getInterpolator();
            if (interpolator3 != null) {
                f2 = interpolator3.getInterpolation(f2);
            }
            float f4 = (f2 - fraction3) / (fraction4 - fraction3);
            k kVar3 = this.f2891f;
            return kVar3 == null ? floatValue4 + (f4 * (floatValue5 - floatValue4)) : ((Number) kVar3.evaluate(f4, Float.valueOf(floatValue4), Float.valueOf(floatValue5))).floatValue();
        }
        f.a aVar5 = (f.a) this.f2890e.get(0);
        int i3 = 1;
        while (true) {
            int i4 = this.f2886a;
            if (i3 >= i4) {
                return ((Number) this.f2890e.get(i4 - 1).getValue()).floatValue();
            }
            f.a aVar6 = (f.a) this.f2890e.get(i3);
            if (f2 < aVar6.getFraction()) {
                Interpolator interpolator4 = aVar6.getInterpolator();
                if (interpolator4 != null) {
                    f2 = interpolator4.getInterpolation(f2);
                }
                float fraction5 = (f2 - aVar5.getFraction()) / (aVar6.getFraction() - aVar5.getFraction());
                float floatValue6 = aVar5.getFloatValue();
                float floatValue7 = aVar6.getFloatValue();
                k kVar4 = this.f2891f;
                return kVar4 == null ? floatValue6 + (fraction5 * (floatValue7 - floatValue6)) : ((Number) kVar4.evaluate(fraction5, Float.valueOf(floatValue6), Float.valueOf(floatValue7))).floatValue();
            }
            i3++;
            aVar5 = aVar6;
        }
    }

    @Override // c.n.a.g
    public Object getValue(float f2) {
        return Float.valueOf(getFloatValue(f2));
    }

    @Override // c.n.a.g
    /* JADX INFO: renamed from: clone */
    public c mo8clone() {
        ArrayList<f> arrayList = this.f2890e;
        int size = arrayList.size();
        f.a[] aVarArr = new f.a[size];
        for (int i2 = 0; i2 < size; i2++) {
            aVarArr[i2] = (f.a) arrayList.get(i2).mo9clone();
        }
        return new c(aVarArr);
    }
}
