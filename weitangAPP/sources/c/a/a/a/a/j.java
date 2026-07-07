package c.a.a.a.a;

import android.app.Notification;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.logger.ILog;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public final class j implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.a.a.a.a.n.a f802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c.a.a.a.a.n.b f803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ b f805e;

    public j(Map map, c.a.a.a.a.n.a aVar, c.a.a.a.a.n.b bVar, Context context, b bVar2) {
        this.f801a = map;
        this.f802b = aVar;
        this.f803c = bVar;
        this.f804d = context;
        this.f805e = bVar2;
    }

    @Override // c.a.a.a.a.l
    public void a(Notification notification, Notification notification2) {
        String str = (String) this.f801a.get(AgooConstants.MESSAGE_BODY_EMAS_GROUP);
        if (!TextUtils.isEmpty(str)) {
            this.f802b.m(str);
        }
        ILog iLog = m.f812a;
        iLog.d("push created notification" + this.f802b.b());
        this.f803c.a(this.f804d, notification, notification2, this.f802b);
        iLog.d("push onNotificationShow " + this.f802b.b());
        this.f805e.onNotificationShow(this.f804d, this.f802b.b(), this.f802b.c(), this.f802b.e());
    }
}
