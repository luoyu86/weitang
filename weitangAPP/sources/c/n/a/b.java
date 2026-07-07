package c.n.a;

/* JADX INFO: loaded from: classes2.dex */
public class b implements k<Number> {
    @Override // c.n.a.k
    public Float evaluate(float f2, Number number, Number number2) {
        float fFloatValue = number.floatValue();
        return Float.valueOf(fFloatValue + (f2 * (number2.floatValue() - fFloatValue)));
    }
}
