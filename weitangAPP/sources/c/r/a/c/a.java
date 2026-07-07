package c.r.a.c;

import c.r.a.d.b;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3155b;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("MicroTang");
        String str = File.separator;
        sb.append(str);
        String string = sb.toString();
        f3154a = string;
        f3155b = b.getRootPath() + str + string;
    }
}
