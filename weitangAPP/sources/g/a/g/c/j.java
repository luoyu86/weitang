package g.a.g.c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        f.mul(iArr, iArr2, iArr3);
        f.mul(iArr, 6, iArr2, 6, iArr3, 12);
        int iAddToEachOther = f.addToEachOther(iArr3, 6, iArr3, 12);
        int iAddTo = iAddToEachOther + f.addTo(iArr3, 18, iArr3, 12, f.addTo(iArr3, 0, iArr3, 6, 0) + iAddToEachOther);
        int[] iArrCreate = f.create();
        int[] iArrCreate2 = f.create();
        boolean z = f.diff(iArr, 6, iArr, 0, iArrCreate, 0) != f.diff(iArr2, 6, iArr2, 0, iArrCreate2, 0);
        int[] iArrCreateExt = f.createExt();
        f.mul(iArrCreate, iArrCreate2, iArrCreateExt);
        n.addWordAt(24, iAddTo + (z ? n.addTo(12, iArrCreateExt, 0, iArr3, 6) : n.subFrom(12, iArrCreateExt, 0, iArr3, 6)), iArr3, 18);
    }

    public static void square(int[] iArr, int[] iArr2) {
        f.square(iArr, iArr2);
        f.square(iArr, 6, iArr2, 12);
        int iAddToEachOther = f.addToEachOther(iArr2, 6, iArr2, 12);
        int iAddTo = iAddToEachOther + f.addTo(iArr2, 18, iArr2, 12, f.addTo(iArr2, 0, iArr2, 6, 0) + iAddToEachOther);
        int[] iArrCreate = f.create();
        f.diff(iArr, 6, iArr, 0, iArrCreate, 0);
        int[] iArrCreateExt = f.createExt();
        f.square(iArrCreate, iArrCreateExt);
        n.addWordAt(24, iAddTo + n.subFrom(12, iArrCreateExt, 0, iArr2, 6), iArr2, 18);
    }
}
