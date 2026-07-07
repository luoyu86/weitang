package c.n.a;

import android.view.animation.Interpolator;
import c.n.a.f;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class e extends g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2877h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2878i;
    public boolean j;

    public e(f.b... bVarArr) {
        super(bVarArr);
        this.j = true;
    }

    public int getIntValue(float f2) {
        int i2 = this.f2886a;
        if (i2 == 2) {
            if (this.j) {
                this.j = false;
                this.f2876g = ((f.b) this.f2890e.get(0)).getIntValue();
                int intValue = ((f.b) this.f2890e.get(1)).getIntValue();
                this.f2877h = intValue;
                this.f2878i = intValue - this.f2876g;
            }
            Interpolator interpolator = this.f2889d;
            if (interpolator != null) {
                f2 = interpolator.getInterpolation(f2);
            }
            k kVar = this.f2891f;
            return kVar == null ? this.f2876g + ((int) (f2 * this.f2878i)) : ((Number) kVar.evaluate(f2, Integer.valueOf(this.f2876g), Integer.valueOf(this.f2877h))).intValue();
        }
        if (f2 <= 0.0f) {
            f.b bVar = (f.b) this.f2890e.get(0);
            f.b bVar2 = (f.b) this.f2890e.get(1);
            int intValue2 = bVar.getIntValue();
            int intValue3 = bVar2.getIntValue();
            float fraction = bVar.getFraction();
            float fraction2 = bVar2.getFraction();
            Interpolator interpolator2 = bVar2.getInterpolator();
            if (interpolator2 != null) {
                f2 = interpolator2.getInterpolation(f2);
            }
            float f3 = (f2 - fraction) / (fraction2 - fraction);
            k kVar2 = this.f2891f;
            return kVar2 == null ? intValue2 + ((int) (f3 * (intValue3 - intValue2))) : ((Number) kVar2.evaluate(f3, Integer.valueOf(intValue2), Integer.valueOf(intValue3))).intValue();
        }
        if (f2 >= 1.0f) {
            f.b bVar3 = (f.b) this.f2890e.get(i2 - 2);
            f.b bVar4 = (f.b) this.f2890e.get(this.f2886a - 1);
            int intValue4 = bVar3.getIntValue();
            int intValue5 = bVar4.getIntValue();
            float fraction3 = bVar3.getFraction();
            float fraction4 = bVar4.getFraction();
            Interpolator interpolator3 = bVar4.getInterpolator();
            if (interpolator3 != null) {
                f2 = interpolator3.getInterpolation(f2);
            }
            float f4 = (f2 - fraction3) / (fraction4 - fraction3);
            k kVar3 = this.f2891f;
            return kVar3 == null ? intValue4 + ((int) (f4 * (intValue5 - intValue4))) : ((Number) kVar3.evaluate(f4, Integer.valueOf(intValue4), Integer.valueOf(intValue5))).intValue();
        }
        f.b bVar5 = (f.b) this.f2890e.get(0);
        int i3 = 1;
        while (true) {
            int i4 = this.f2886a;
            if (i3 >= i4) {
                return ((Number) this.f2890e.get(i4 - 1).getValue()).intValue();
            }
            f.b bVar6 = (f.b) this.f2890e.get(i3);
            if (f2 < bVar6.getFraction()) {
                Interpolator interpolator4 = bVar6.getInterpolator();
                if (interpolator4 != null) {
                    f2 = interpolator4.getInterpolation(f2);
                }
                float fraction5 = (f2 - bVar5.getFraction()) / (bVar6.getFraction() - bVar5.getFraction());
                int intValue6 = bVar5.getIntValue();
                int intValue7 = bVar6.getIntValue();
                k kVar4 = this.f2891f;
                return kVar4 == null ? intValue6 + ((int) (fraction5 * (intValue7 - intValue6))) : ((Number) kVar4.evaluate(fraction5, Integer.valueOf(intValue6), Integer.valueOf(intValue7))).intValue();
            }
            i3++;
            bVar5 = bVar6;
        }
    }

    @Override // c.n.a.g
    public Object getValue(float f2) {
        return Integer.valueOf(getIntValue(f2));
    }

    @Override // c.n.a.g
    /* JADX INFO: renamed from: clone */
    public e mo8clone() {
        ArrayList<f> arrayList = this.f2890e;
        int size = arrayList.size();
        f.b[] bVarArr = new f.b[size];
        for (int i2 = 0; i2 < size; i2++) {
            bVarArr[i2] = (f.b) arrayList.get(i2).mo9clone();
        }
        return new e(bVarArr);
    }
}
