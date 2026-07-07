package a.a.x;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicInteger f289a = new AtomicInteger(0);

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(16);
        if (str != null) {
            sb.append(str);
            sb.append('.');
        }
        if (str2 != null) {
            sb.append(str2);
            sb.append(f289a.incrementAndGet() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        }
        return sb.toString();
    }
}
