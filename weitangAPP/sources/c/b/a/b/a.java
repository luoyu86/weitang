package c.b.a.b;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import c.b.a.d.d;
import c.b.a.d.e;
import com.contrarywind.view.WheelView;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c.b.a.c.a f839a;

    public a(Context context, e eVar) {
        c.b.a.c.a aVar = new c.b.a.c.a(1);
        this.f839a = aVar;
        aVar.Q = context;
        aVar.f841a = eVar;
    }

    public <T> c.b.a.f.b<T> build() {
        return new c.b.a.f.b<>(this.f839a);
    }

    public a isCenterLabel(boolean z) {
        this.f839a.j0 = z;
        return this;
    }

    public a isDialog(boolean z) {
        this.f839a.h0 = z;
        return this;
    }

    public a isRestoreItem(boolean z) {
        this.f839a.s = z;
        return this;
    }

    @Deprecated
    public a setBackgroundId(int i2) {
        this.f839a.f0 = i2;
        return this;
    }

    public a setBgColor(int i2) {
        this.f839a.X = i2;
        return this;
    }

    public a setCancelColor(int i2) {
        this.f839a.V = i2;
        return this;
    }

    public a setCancelText(String str) {
        this.f839a.S = str;
        return this;
    }

    public a setContentTextSize(int i2) {
        this.f839a.b0 = i2;
        return this;
    }

    public a setCyclic(boolean z, boolean z2, boolean z3) {
        c.b.a.c.a aVar = this.f839a;
        aVar.p = z;
        aVar.f850q = z2;
        aVar.r = z3;
        return this;
    }

    public a setDecorView(ViewGroup viewGroup) {
        this.f839a.O = viewGroup;
        return this;
    }

    public a setDividerColor(@ColorInt int i2) {
        this.f839a.e0 = i2;
        return this;
    }

    public a setDividerType(WheelView.c cVar) {
        this.f839a.l0 = cVar;
        return this;
    }

    public a setLabels(String str, String str2, String str3) {
        c.b.a.c.a aVar = this.f839a;
        aVar.f847g = str;
        aVar.f848h = str2;
        aVar.f849i = str3;
        return this;
    }

    public a setLayoutRes(int i2, c.b.a.d.a aVar) {
        c.b.a.c.a aVar2 = this.f839a;
        aVar2.N = i2;
        aVar2.f846f = aVar;
        return this;
    }

    public a setLineSpacingMultiplier(float f2) {
        this.f839a.g0 = f2;
        return this;
    }

    public a setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.f839a.f843c = onClickListener;
        return this;
    }

    public a setOptionsSelectChangeListener(d dVar) {
        this.f839a.f845e = dVar;
        return this;
    }

    public a setOutSideCancelable(boolean z) {
        this.f839a.i0 = z;
        return this;
    }

    public a setOutSideColor(int i2) {
        this.f839a.f0 = i2;
        return this;
    }

    public a setSelectOptions(int i2) {
        this.f839a.j = i2;
        return this;
    }

    public a setSubCalSize(int i2) {
        this.f839a.Z = i2;
        return this;
    }

    public a setSubmitColor(int i2) {
        this.f839a.U = i2;
        return this;
    }

    public a setSubmitText(String str) {
        this.f839a.R = str;
        return this;
    }

    public a setTextColorCenter(int i2) {
        this.f839a.d0 = i2;
        return this;
    }

    public a setTextColorOut(@ColorInt int i2) {
        this.f839a.c0 = i2;
        return this;
    }

    public a setTextXOffset(int i2, int i3, int i4) {
        c.b.a.c.a aVar = this.f839a;
        aVar.m = i2;
        aVar.n = i3;
        aVar.o = i4;
        return this;
    }

    public a setTitleBgColor(int i2) {
        this.f839a.Y = i2;
        return this;
    }

    public a setTitleColor(int i2) {
        this.f839a.W = i2;
        return this;
    }

    public a setTitleSize(int i2) {
        this.f839a.a0 = i2;
        return this;
    }

    public a setTitleText(String str) {
        this.f839a.T = str;
        return this;
    }

    public a setTypeface(Typeface typeface) {
        this.f839a.k0 = typeface;
        return this;
    }

    public a setSelectOptions(int i2, int i3) {
        c.b.a.c.a aVar = this.f839a;
        aVar.j = i2;
        aVar.k = i3;
        return this;
    }

    public a setSelectOptions(int i2, int i3, int i4) {
        c.b.a.c.a aVar = this.f839a;
        aVar.j = i2;
        aVar.k = i3;
        aVar.l = i4;
        return this;
    }
}
