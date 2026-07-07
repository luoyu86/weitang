package c.o.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal<String> f2971a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f2972b = new ArrayList();

    @NonNull
    public final String a(@NonNull String str, @Nullable Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }

    @Override // c.o.a.i
    public void addAdapter(@NonNull c cVar) {
        this.f2972b.add((c) j.a(cVar));
    }

    @Nullable
    public final String b() {
        String str = this.f2971a.get();
        if (str == null) {
            return null;
        }
        this.f2971a.remove();
        return str;
    }

    public final synchronized void c(int i2, @Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        j.a(str);
        log(i2, b(), a(str, objArr), th);
    }

    @Override // c.o.a.i
    public void clearLogAdapters() {
        this.f2972b.clear();
    }

    @Override // c.o.a.i
    public void d(@NonNull String str, @Nullable Object... objArr) {
        c(3, null, str, objArr);
    }

    @Override // c.o.a.i
    public void e(@NonNull String str, @Nullable Object... objArr) {
        e(null, str, objArr);
    }

    @Override // c.o.a.i
    public void i(@NonNull String str, @Nullable Object... objArr) {
        c(4, null, str, objArr);
    }

    @Override // c.o.a.i
    public void json(@Nullable String str) {
        if (j.d(str)) {
            d("Empty/Null json content");
            return;
        }
        try {
            String strTrim = str.trim();
            if (strTrim.startsWith("{")) {
                d(new JSONObject(strTrim).toString(2));
            } else if (strTrim.startsWith("[")) {
                d(new JSONArray(strTrim).toString(2));
            } else {
                e("Invalid Json", new Object[0]);
            }
        } catch (JSONException unused) {
            e("Invalid Json", new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0039 A[Catch: all -> 0x004b, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x0021, B:9:0x0025, B:12:0x002d, B:13:0x0033, B:15:0x0039, B:17:0x0045), top: B:24:0x0005 }] */
    @Override // c.o.a.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void log(int r3, @androidx.annotation.Nullable java.lang.String r4, @androidx.annotation.Nullable java.lang.String r5, @androidx.annotation.Nullable java.lang.Throwable r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r6 == 0) goto L1d
            if (r5 == 0) goto L1d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4b
            r0.<init>()     // Catch: java.lang.Throwable -> L4b
            r0.append(r5)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = " : "
            r0.append(r5)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = c.o.a.j.c(r6)     // Catch: java.lang.Throwable -> L4b
            r0.append(r5)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Throwable -> L4b
        L1d:
            if (r6 == 0) goto L25
            if (r5 != 0) goto L25
            java.lang.String r5 = c.o.a.j.c(r6)     // Catch: java.lang.Throwable -> L4b
        L25:
            boolean r6 = c.o.a.j.d(r5)     // Catch: java.lang.Throwable -> L4b
            if (r6 == 0) goto L2d
            java.lang.String r5 = "Empty/NULL log message"
        L2d:
            java.util.List<c.o.a.c> r6 = r2.f2972b     // Catch: java.lang.Throwable -> L4b
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L4b
        L33:
            boolean r0 = r6.hasNext()     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L49
            java.lang.Object r0 = r6.next()     // Catch: java.lang.Throwable -> L4b
            c.o.a.c r0 = (c.o.a.c) r0     // Catch: java.lang.Throwable -> L4b
            boolean r1 = r0.isLoggable(r3, r4)     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L33
            r0.log(r3, r4, r5)     // Catch: java.lang.Throwable -> L4b
            goto L33
        L49:
            monitor-exit(r2)
            return
        L4b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c.o.a.g.log(int, java.lang.String, java.lang.String, java.lang.Throwable):void");
    }

    @Override // c.o.a.i
    public i t(String str) {
        if (str != null) {
            this.f2971a.set(str);
        }
        return this;
    }

    @Override // c.o.a.i
    public void v(@NonNull String str, @Nullable Object... objArr) {
        c(2, null, str, objArr);
    }

    @Override // c.o.a.i
    public void w(@NonNull String str, @Nullable Object... objArr) {
        c(5, null, str, objArr);
    }

    @Override // c.o.a.i
    public void wtf(@NonNull String str, @Nullable Object... objArr) {
        c(7, null, str, objArr);
    }

    @Override // c.o.a.i
    public void xml(@Nullable String str) {
        if (j.d(str)) {
            d("Empty/Null xml content");
            return;
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformerNewTransformer.transform(streamSource, streamResult);
            d(streamResult.getWriter().toString().replaceFirst(">", ">\n"));
        } catch (TransformerException unused) {
            e("Invalid xml", new Object[0]);
        }
    }

    @Override // c.o.a.i
    public void d(@Nullable Object obj) {
        c(3, null, j.toString(obj), new Object[0]);
    }

    @Override // c.o.a.i
    public void e(@Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        c(6, th, str, objArr);
    }
}
