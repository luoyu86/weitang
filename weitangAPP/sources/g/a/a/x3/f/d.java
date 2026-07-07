package g.a.a.x3.f;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public char f13443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StringBuffer f13444d;

    public d(String str) {
        this(str, ',');
    }

    public d(String str, char c2) {
        this.f13444d = new StringBuffer();
        this.f13441a = str;
        this.f13442b = -1;
        this.f13443c = c2;
    }

    public boolean hasMoreTokens() {
        return this.f13442b != this.f13441a.length();
    }

    public String nextToken() {
        if (this.f13442b == this.f13441a.length()) {
            return null;
        }
        int i2 = this.f13442b + 1;
        this.f13444d.setLength(0);
        boolean z = false;
        boolean z2 = false;
        while (i2 != this.f13441a.length()) {
            char cCharAt = this.f13441a.charAt(i2);
            if (cCharAt != '\"') {
                if (!z && !z2) {
                    if (cCharAt == '\\') {
                        this.f13444d.append(cCharAt);
                        z = true;
                    } else {
                        if (cCharAt == this.f13443c) {
                            break;
                        }
                        this.f13444d.append(cCharAt);
                    }
                }
                i2++;
            } else if (!z) {
                z2 = !z2;
            }
            this.f13444d.append(cCharAt);
            z = false;
            i2++;
        }
        this.f13442b = i2;
        return this.f13444d.toString();
    }
}
