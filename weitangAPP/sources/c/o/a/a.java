package c.o.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final b f2969a;

    public a() {
        this.f2969a = h.newBuilder().build();
    }

    @Override // c.o.a.c
    public boolean isLoggable(int i2, @Nullable String str) {
        return true;
    }

    @Override // c.o.a.c
    public void log(int i2, @Nullable String str, @NonNull String str2) {
        this.f2969a.log(i2, str, str2);
    }

    public a(@NonNull b bVar) {
        this.f2969a = (b) j.a(bVar);
    }
}
