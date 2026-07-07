package h;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i<T> {

    public class a extends i<Iterable<T>> {
        public a() {
        }

        @Override // h.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h.k kVar, @Nullable Iterable<T> iterable) throws IOException {
            if (iterable == null) {
                return;
            }
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                i.this.a(kVar, it.next());
            }
        }
    }

    public class b extends i<Object> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.i
        public void a(h.k kVar, @Nullable Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                i.this.a(kVar, Array.get(obj, i2));
            }
        }
    }

    public static final class c<T> extends i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h.e<T, RequestBody> f14785a;

        public c(h.e<T, RequestBody> eVar) {
            this.f14785a = eVar;
        }

        @Override // h.i
        public void a(h.k kVar, @Nullable T t) {
            if (t == null) {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
            try {
                kVar.j(this.f14785a.convert(t));
            } catch (IOException e2) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
            }
        }
    }

    public static final class d<T> extends i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f14786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h.e<T, String> f14787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f14788c;

        public d(String str, h.e<T, String> eVar, boolean z) {
            this.f14786a = (String) h.o.b(str, "name == null");
            this.f14787b = eVar;
            this.f14788c = z;
        }

        @Override // h.i
        public void a(h.k kVar, @Nullable T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.f14787b.convert(t)) == null) {
                return;
            }
            kVar.a(this.f14786a, strConvert, this.f14788c);
        }
    }

    public static final class e<T> extends i<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h.e<T, String> f14789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f14790b;

        public e(h.e<T, String> eVar, boolean z) {
            this.f14789a = eVar;
            this.f14790b = z;
        }

        @Override // h.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h.k kVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Field map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Field map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Field map contained null value for key '" + key + "'.");
                }
                String strConvert = this.f14789a.convert(value);
                if (strConvert == null) {
                    throw new IllegalArgumentException("Field map value '" + value + "' converted to null by " + this.f14789a.getClass().getName() + " for key '" + key + "'.");
                }
                kVar.a(key, strConvert, this.f14790b);
            }
        }
    }

    public static final class f<T> extends i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f14791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h.e<T, String> f14792b;

        public f(String str, h.e<T, String> eVar) {
            this.f14791a = (String) h.o.b(str, "name == null");
            this.f14792b = eVar;
        }

        @Override // h.i
        public void a(h.k kVar, @Nullable T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.f14792b.convert(t)) == null) {
                return;
            }
            kVar.b(this.f14791a, strConvert);
        }
    }

    public static final class g<T> extends i<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h.e<T, String> f14793a;

        public g(h.e<T, String> eVar) {
            this.f14793a = eVar;
        }

        @Override // h.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h.k kVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Header map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Header map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Header map contained null value for key '" + key + "'.");
                }
                kVar.b(key, this.f14793a.convert(value));
            }
        }
    }

    public static final class h<T> extends i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Headers f14794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h.e<T, RequestBody> f14795b;

        public h(Headers headers, h.e<T, RequestBody> eVar) {
            this.f14794a = headers;
            this.f14795b = eVar;
        }

        @Override // h.i
        public void a(h.k kVar, @Nullable T t) {
            if (t == null) {
                return;
            }
            try {
                kVar.c(this.f14794a, this.f14795b.convert(t));
            } catch (IOException e2) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
            }
        }
    }

    /* JADX INFO: renamed from: h.i$i, reason: collision with other inner class name */
    public static final class C0268i<T> extends i<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h.e<T, RequestBody> f14796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f14797b;

        public C0268i(h.e<T, RequestBody> eVar, String str) {
            this.f14796a = eVar;
            this.f14797b = str;
        }

        @Override // h.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h.k kVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Part map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Part map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Part map contained null value for key '" + key + "'.");
                }
                kVar.c(Headers.of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f14797b), this.f14796a.convert(value));
            }
        }
    }

    public static final class j<T> extends i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f14798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h.e<T, String> f14799b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f14800c;

        public j(String str, h.e<T, String> eVar, boolean z) {
            this.f14798a = (String) h.o.b(str, "name == null");
            this.f14799b = eVar;
            this.f14800c = z;
        }

        @Override // h.i
        public void a(h.k kVar, @Nullable T t) throws IOException {
            if (t != null) {
                kVar.e(this.f14798a, this.f14799b.convert(t), this.f14800c);
                return;
            }
            throw new IllegalArgumentException("Path parameter \"" + this.f14798a + "\" value must not be null.");
        }
    }

    public static final class k<T> extends i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f14801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h.e<T, String> f14802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f14803c;

        public k(String str, h.e<T, String> eVar, boolean z) {
            this.f14801a = (String) h.o.b(str, "name == null");
            this.f14802b = eVar;
            this.f14803c = z;
        }

        @Override // h.i
        public void a(h.k kVar, @Nullable T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.f14802b.convert(t)) == null) {
                return;
            }
            kVar.f(this.f14801a, strConvert, this.f14803c);
        }
    }

    public static final class l<T> extends i<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h.e<T, String> f14804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f14805b;

        public l(h.e<T, String> eVar, boolean z) {
            this.f14804a = eVar;
            this.f14805b = z;
        }

        @Override // h.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h.k kVar, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Query map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Query map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Query map contained null value for key '" + key + "'.");
                }
                String strConvert = this.f14804a.convert(value);
                if (strConvert == null) {
                    throw new IllegalArgumentException("Query map value '" + value + "' converted to null by " + this.f14804a.getClass().getName() + " for key '" + key + "'.");
                }
                kVar.f(key, strConvert, this.f14805b);
            }
        }
    }

    public static final class m<T> extends i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h.e<T, String> f14806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f14807b;

        public m(h.e<T, String> eVar, boolean z) {
            this.f14806a = eVar;
            this.f14807b = z;
        }

        @Override // h.i
        public void a(h.k kVar, @Nullable T t) throws IOException {
            if (t == null) {
                return;
            }
            kVar.f(this.f14806a.convert(t), null, this.f14807b);
        }
    }

    public static final class n extends i<MultipartBody.Part> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f14808a = new n();

        @Override // h.i
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(h.k kVar, @Nullable MultipartBody.Part part) {
            if (part != null) {
                kVar.d(part);
            }
        }
    }

    public static final class o extends i<Object> {
        @Override // h.i
        public void a(h.k kVar, @Nullable Object obj) {
            h.o.b(obj, "@Url parameter is null.");
            kVar.k(obj);
        }
    }

    public abstract void a(h.k kVar, @Nullable T t) throws IOException;

    public final i<Object> b() {
        return new b();
    }

    public final i<Iterable<T>> c() {
        return new a();
    }
}
