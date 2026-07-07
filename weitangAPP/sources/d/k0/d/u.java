package d.k0.d;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u<R> implements q<R>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12660a;

    public u(int i2) {
        this.f12660a = i2;
    }

    @Override // d.k0.d.q
    public int getArity() {
        return this.f12660a;
    }

    public String toString() {
        String strRenderLambdaToString = f0.renderLambdaToString((u) this);
        t.checkNotNullExpressionValue(strRenderLambdaToString, "Reflection.renderLambdaToString(this)");
        return strRenderLambdaToString;
    }
}
