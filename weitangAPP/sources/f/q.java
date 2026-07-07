package f;

import android.support.v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static p f13026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f13027b;

    public static void a(p pVar) {
        if (pVar.f13024f != null || pVar.f13025g != null) {
            throw new IllegalArgumentException();
        }
        if (pVar.f13022d) {
            return;
        }
        synchronized (q.class) {
            long j = f13027b;
            if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            f13027b = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            pVar.f13024f = f13026a;
            pVar.f13021c = 0;
            pVar.f13020b = 0;
            f13026a = pVar;
        }
    }

    public static p b() {
        synchronized (q.class) {
            p pVar = f13026a;
            if (pVar == null) {
                return new p();
            }
            f13026a = pVar.f13024f;
            pVar.f13024f = null;
            f13027b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return pVar;
        }
    }
}
