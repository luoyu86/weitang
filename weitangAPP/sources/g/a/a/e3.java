package g.a.a;

import androidx.appcompat.widget.ActivityChooserView;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
public class e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f13072a = Runtime.getRuntime().maxMemory();

    public static int a(InputStream inputStream) {
        if (inputStream instanceof c3) {
            return ((c3) inputStream).a();
        }
        if (inputStream instanceof p) {
            return ((p) inputStream).g();
        }
        if (inputStream instanceof ByteArrayInputStream) {
            return ((ByteArrayInputStream) inputStream).available();
        }
        if (inputStream instanceof FileInputStream) {
            try {
                FileChannel channel = ((FileInputStream) inputStream).getChannel();
                long size = channel != null ? channel.size() : 2147483647L;
                if (size < 2147483647L) {
                    return (int) size;
                }
            } catch (IOException unused) {
            }
        }
        long j = f13072a;
        return j > 2147483647L ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) j;
    }
}
