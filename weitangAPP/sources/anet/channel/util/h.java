package anet.channel.util;

import anet.channel.request.Request;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Integer> f730a;

    static {
        HashMap map = new HashMap();
        f730a = map;
        map.put("tpatch", 3);
        f730a.put("so", 3);
        f730a.put("json", 3);
        f730a.put("html", 4);
        f730a.put("htm", 4);
        f730a.put("css", 5);
        f730a.put("js", 5);
        f730a.put("webp", 6);
        f730a.put("png", 6);
        f730a.put("jpg", 6);
        f730a.put("do", 6);
        f730a.put("zip", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
        f730a.put("bin", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
        f730a.put("apk", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
    }

    public static int a(Request request) {
        Integer num;
        Objects.requireNonNull(request, "url is null!");
        if (request.getHeaders().containsKey(HttpConstant.X_PV)) {
            return 1;
        }
        String strTrySolveFileExtFromUrlPath = HttpHelper.trySolveFileExtFromUrlPath(request.getHttpUrl().path());
        if (strTrySolveFileExtFromUrlPath == null || (num = f730a.get(strTrySolveFileExtFromUrlPath)) == null) {
            return 6;
        }
        return num.intValue();
    }
}
