package anet.channel.util;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f731a = new AtomicInteger();

    public static String a(String str) {
        if (f731a.get() == Integer.MAX_VALUE) {
            f731a.set(0);
        }
        return !TextUtils.isEmpty(str) ? StringUtils.concatString(str, ".AWCN", String.valueOf(f731a.incrementAndGet())) : StringUtils.concatString("AWCN", String.valueOf(f731a.incrementAndGet()));
    }
}
