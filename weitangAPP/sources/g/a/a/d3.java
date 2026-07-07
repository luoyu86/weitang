package g.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13066b = 0;

    public d3(String str) {
        this.f13065a = str;
    }

    public boolean hasMoreTokens() {
        return this.f13066b != -1;
    }

    public String nextToken() {
        int i2 = this.f13066b;
        if (i2 == -1) {
            return null;
        }
        int iIndexOf = this.f13065a.indexOf(46, i2);
        if (iIndexOf == -1) {
            String strSubstring = this.f13065a.substring(this.f13066b);
            this.f13066b = -1;
            return strSubstring;
        }
        String strSubstring2 = this.f13065a.substring(this.f13066b, iIndexOf);
        this.f13066b = iIndexOf + 1;
        return strSubstring2;
    }
}
