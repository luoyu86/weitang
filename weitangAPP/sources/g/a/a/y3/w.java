package g.a.a.y3;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public char f13554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StringBuffer f13555d;

    public w(String str) {
        this(str, ',');
    }

    public w(String str, char c2) {
        this.f13555d = new StringBuffer();
        this.f13552a = str;
        this.f13553b = -1;
        this.f13554c = c2;
    }

    public boolean hasMoreTokens() {
        return this.f13553b != this.f13552a.length();
    }

    public String nextToken() {
        if (this.f13553b == this.f13552a.length()) {
            return null;
        }
        int i2 = this.f13553b + 1;
        this.f13555d.setLength(0);
        boolean z = false;
        boolean z2 = false;
        while (i2 != this.f13552a.length()) {
            char cCharAt = this.f13552a.charAt(i2);
            if (cCharAt != '\"') {
                if (!z && !z2) {
                    if (cCharAt == '\\') {
                        this.f13555d.append(cCharAt);
                        z = true;
                    } else {
                        if (cCharAt == this.f13554c) {
                            break;
                        }
                        this.f13555d.append(cCharAt);
                    }
                }
                i2++;
            } else if (!z) {
                z2 = !z2;
            }
            this.f13555d.append(cCharAt);
            z = false;
            i2++;
        }
        this.f13553b = i2;
        return this.f13555d.toString();
    }
}
