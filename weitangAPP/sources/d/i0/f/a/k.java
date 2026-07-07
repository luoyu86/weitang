package d.i0.f.a;

import d.k0.d.f0;
import d.k0.d.q;
import d.k0.d.t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends j implements q<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12605b;

    public k(int i2, d.i0.a<Object> aVar) {
        super(aVar);
        this.f12605b = i2;
    }

    @Override // d.k0.d.q
    public int getArity() {
        return this.f12605b;
    }

    @Override // d.i0.f.a.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strRenderLambdaToString = f0.renderLambdaToString(this);
        t.checkNotNullExpressionValue(strRenderLambdaToString, "Reflection.renderLambdaToString(this)");
        return strRenderLambdaToString;
    }

    public k(int i2) {
        this(i2, null);
    }
}
