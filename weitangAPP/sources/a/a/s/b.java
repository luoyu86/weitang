package a.a.s;

import anet.channel.request.Request;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public interface b {

    public interface a {
        a.a.s.a callback();

        Future proceed(Request request, a.a.s.a aVar);

        Request request();
    }

    Future intercept(a aVar);
}
