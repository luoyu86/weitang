package h;

import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Response f14822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final T f14823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final ResponseBody f14824c;

    public l(Response response, @Nullable T t, @Nullable ResponseBody responseBody) {
        this.f14822a = response;
        this.f14823b = t;
        this.f14824c = responseBody;
    }

    public static <T> l<T> error(int i2, ResponseBody responseBody) {
        if (i2 >= 400) {
            return error(responseBody, new Response.Builder().code(i2).message("Response.error()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 400: " + i2);
    }

    public static <T> l<T> success(@Nullable T t) {
        return success(t, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    @Nullable
    public T body() {
        return this.f14823b;
    }

    public int code() {
        return this.f14822a.code();
    }

    @Nullable
    public ResponseBody errorBody() {
        return this.f14824c;
    }

    public Headers headers() {
        return this.f14822a.headers();
    }

    public boolean isSuccessful() {
        return this.f14822a.isSuccessful();
    }

    public String message() {
        return this.f14822a.message();
    }

    public Response raw() {
        return this.f14822a;
    }

    public String toString() {
        return this.f14822a.toString();
    }

    public static <T> l<T> success(@Nullable T t, Headers headers) {
        o.b(headers, "headers == null");
        return success(t, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).headers(headers).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> l<T> error(ResponseBody responseBody, Response response) {
        o.b(responseBody, "body == null");
        o.b(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new l<>(response, null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> l<T> success(@Nullable T t, Response response) {
        o.b(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new l<>(response, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
