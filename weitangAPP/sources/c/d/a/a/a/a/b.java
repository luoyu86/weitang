package c.d.a.a.a.a;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f925a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f926b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f927c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueSet f928d = null;

    /* JADX INFO: renamed from: c.d.a.a.a.a.b$b, reason: collision with other inner class name */
    public static final class C0014b implements Result {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ValueSet f932d;

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.f930b;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f929a;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.f931c;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.f932d;
        }

        public C0014b(boolean z, int i2, String str, ValueSet valueSet) {
            this.f929a = z;
            this.f930b = i2;
            this.f931c = str;
            this.f932d = valueSet;
        }
    }

    public static final b ok() {
        return new b();
    }

    public Result a() {
        boolean z = this.f925a;
        int i2 = this.f926b;
        String str = this.f927c;
        ValueSet valueSetA = this.f928d;
        if (valueSetA == null) {
            valueSetA = c.d.a.a.a.a.a.ok().a();
        }
        return new C0014b(z, i2, str, valueSetA);
    }

    public b ok(boolean z) {
        this.f925a = z;
        return this;
    }

    public b ok(int i2) {
        this.f926b = i2;
        return this;
    }

    public b ok(String str) {
        this.f927c = str;
        return this;
    }

    public b ok(ValueSet valueSet) {
        this.f928d = valueSet;
        return this;
    }
}
