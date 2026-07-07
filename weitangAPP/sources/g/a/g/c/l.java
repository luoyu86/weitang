package g.a.g.c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l {
    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        h.mul(iArr, iArr2, iArr3);
        h.mul(iArr, 8, iArr2, 8, iArr3, 16);
        int iAddToEachOther = h.addToEachOther(iArr3, 8, iArr3, 16);
        int iAddTo = iAddToEachOther + h.addTo(iArr3, 24, iArr3, 16, h.addTo(iArr3, 0, iArr3, 8, 0) + iAddToEachOther);
        int[] iArrCreate = h.create();
        int[] iArrCreate2 = h.create();
        boolean z = h.diff(iArr, 8, iArr, 0, iArrCreate, 0) != h.diff(iArr2, 8, iArr2, 0, iArrCreate2, 0);
        int[] iArrCreateExt = h.createExt();
        h.mul(iArrCreate, iArrCreate2, iArrCreateExt);
        n.addWordAt(32, iAddTo + (z ? n.addTo(16, iArrCreateExt, 0, iArr3, 8) : n.subFrom(16, iArrCreateExt, 0, iArr3, 8)), iArr3, 24);
    }

    public static void square(int[] iArr, int[] iArr2) {
        h.square(iArr, iArr2);
        h.square(iArr, 8, iArr2, 16);
        int iAddToEachOther = h.addToEachOther(iArr2, 8, iArr2, 16);
        int iAddTo = iAddToEachOther + h.addTo(iArr2, 24, iArr2, 16, h.addTo(iArr2, 0, iArr2, 8, 0) + iAddToEachOther);
        int[] iArrCreate = h.create();
        h.diff(iArr, 8, iArr, 0, iArrCreate, 0);
        int[] iArrCreateExt = h.createExt();
        h.square(iArrCreate, iArrCreateExt);
        n.addWordAt(32, iAddTo + n.subFrom(16, iArrCreateExt, 0, iArr2, 8), iArr2, 24);
    }
}
