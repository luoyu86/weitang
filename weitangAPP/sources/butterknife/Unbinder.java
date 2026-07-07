package butterknife;

import androidx.annotation.UiThread;

/* JADX INFO: loaded from: classes.dex */
public interface Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unbinder f786a = new Unbinder() { // from class: b.a
        @Override // butterknife.Unbinder
        public final void unbind() {
            b.a();
        }
    };

    @UiThread
    void unbind();
}
