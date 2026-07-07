package c.e.a.a.f;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/* JADX INFO: loaded from: classes.dex */
public class b extends Authenticator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1002b;

    public b(String str, String str2) {
        this.f1001a = str;
        this.f1002b = str2;
    }

    @Override // javax.mail.Authenticator
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.f1001a, this.f1002b);
    }
}
