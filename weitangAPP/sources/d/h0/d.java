package d.h0;

import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import d.k0.d.t;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Comparator<Comparable<? super Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12574a = new d();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Comparable<? super Object> comparable, Comparable<? super Object> comparable2) {
        return compare2((Comparable<Object>) comparable, (Comparable<Object>) comparable2);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return e.f12575a;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Comparable<Object> comparable, Comparable<Object> comparable2) {
        t.checkNotNullParameter(comparable, PDPageLabelRange.STYLE_LETTERS_LOWER);
        t.checkNotNullParameter(comparable2, OperatorName.CLOSE_FILL_NON_ZERO_AND_STROKE);
        return comparable.compareTo(comparable2);
    }
}
