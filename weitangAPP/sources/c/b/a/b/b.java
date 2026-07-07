package c.b.a.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import c.b.a.d.f;
import c.b.a.d.g;
import c.b.a.f.c;
import com.contrarywind.view.WheelView;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c.b.a.c.a f840a;

    public b(Context context, g gVar) {
        c.b.a.c.a aVar = new c.b.a.c.a(2);
        this.f840a = aVar;
        aVar.Q = context;
        aVar.f842b = gVar;
    }

    public b addOnCancelClickListener(View.OnClickListener onClickListener) {
        this.f840a.f843c = onClickListener;
        return this;
    }

    public c build() {
        return new c(this.f840a);
    }

    public b isCenterLabel(boolean z) {
        this.f840a.j0 = z;
        return this;
    }

    public b isCyclic(boolean z) {
        this.f840a.z = z;
        return this;
    }

    public b isDialog(boolean z) {
        this.f840a.h0 = z;
        return this;
    }

    @Deprecated
    public b setBackgroundId(int i2) {
        this.f840a.f0 = i2;
        return this;
    }

    public b setBgColor(int i2) {
        this.f840a.X = i2;
        return this;
    }

    public b setCancelColor(int i2) {
        this.f840a.V = i2;
        return this;
    }

    public b setCancelText(String str) {
        this.f840a.S = str;
        return this;
    }

    public b setContentTextSize(int i2) {
        this.f840a.b0 = i2;
        return this;
    }

    public b setDate(Calendar calendar) {
        this.f840a.u = calendar;
        return this;
    }

    public b setDecorView(ViewGroup viewGroup) {
        this.f840a.O = viewGroup;
        return this;
    }

    public b setDividerColor(@ColorInt int i2) {
        this.f840a.e0 = i2;
        return this;
    }

    public b setDividerType(WheelView.c cVar) {
        this.f840a.l0 = cVar;
        return this;
    }

    public b setGravity(int i2) {
        this.f840a.P = i2;
        return this;
    }

    public b setLabel(String str, String str2, String str3, String str4, String str5, String str6) {
        c.b.a.c.a aVar = this.f840a;
        aVar.B = str;
        aVar.C = str2;
        aVar.D = str3;
        aVar.E = str4;
        aVar.F = str5;
        aVar.G = str6;
        return this;
    }

    public b setLayoutRes(int i2, c.b.a.d.a aVar) {
        c.b.a.c.a aVar2 = this.f840a;
        aVar2.N = i2;
        aVar2.f846f = aVar;
        return this;
    }

    public b setLineSpacingMultiplier(float f2) {
        this.f840a.g0 = f2;
        return this;
    }

    public b setLunarCalendar(boolean z) {
        this.f840a.A = z;
        return this;
    }

    public b setOutSideCancelable(boolean z) {
        this.f840a.i0 = z;
        return this;
    }

    public b setOutSideColor(@ColorInt int i2) {
        this.f840a.f0 = i2;
        return this;
    }

    public b setRangDate(Calendar calendar, Calendar calendar2) {
        c.b.a.c.a aVar = this.f840a;
        aVar.v = calendar;
        aVar.w = calendar2;
        return this;
    }

    public b setSubCalSize(int i2) {
        this.f840a.Z = i2;
        return this;
    }

    public b setSubmitColor(int i2) {
        this.f840a.U = i2;
        return this;
    }

    public b setSubmitText(String str) {
        this.f840a.R = str;
        return this;
    }

    public b setTextColorCenter(@ColorInt int i2) {
        this.f840a.d0 = i2;
        return this;
    }

    public b setTextColorOut(@ColorInt int i2) {
        this.f840a.c0 = i2;
        return this;
    }

    public b setTextXOffset(int i2, int i3, int i4, int i5, int i6, int i7) {
        c.b.a.c.a aVar = this.f840a;
        aVar.H = i2;
        aVar.I = i3;
        aVar.J = i4;
        aVar.K = i5;
        aVar.L = i6;
        aVar.M = i7;
        return this;
    }

    public b setTimeSelectChangeListener(f fVar) {
        this.f840a.f844d = fVar;
        return this;
    }

    public b setTitleBgColor(int i2) {
        this.f840a.Y = i2;
        return this;
    }

    public b setTitleColor(int i2) {
        this.f840a.W = i2;
        return this;
    }

    public b setTitleSize(int i2) {
        this.f840a.a0 = i2;
        return this;
    }

    public b setTitleText(String str) {
        this.f840a.T = str;
        return this;
    }

    public b setType(boolean[] zArr) {
        this.f840a.t = zArr;
        return this;
    }
}
