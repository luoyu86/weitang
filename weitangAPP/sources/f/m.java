package f;

import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends AbstractList<f> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f[] f13010a;

    public m(f[] fVarArr) {
        this.f13010a = fVarArr;
    }

    public static m of(f... fVarArr) {
        return new m((f[]) fVarArr.clone());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f13010a.length;
    }

    @Override // java.util.AbstractList, java.util.List
    public f get(int i2) {
        return this.f13010a[i2];
    }
}
