package c.a.a.a.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.sdk.android.error.ErrorCode;
import com.aliyun.ams.emas.push.MsgService;
import com.aliyun.ams.emas.push.notification.CPushMessage;
import com.taobao.accs.utl.ALog;
import java.util.Calendar;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f811f = false;

    public k(Context context) {
        this.f806a = context;
    }

    public void a(boolean z) {
        this.f811f = z;
    }

    public void b(CPushMessage cPushMessage) {
        if (cPushMessage == null || TextUtils.isEmpty(cPushMessage.getMessageId())) {
            ALog.e("MPS:CloudPushService", "message is null", new Object[0]);
            return;
        }
        if (this.f806a == null) {
            ALog.e("MPS:CloudPushService", "context is null", new Object[0]);
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(m.f813b);
            intent.setClassName(this.f806a.getPackageName(), MsgService.class.getName());
            intent.putExtra(AgooConstants.ACTION_TYPE, AgooConstants.MESSAGE_TYPE_DELETE);
            intent.putExtra("msgId", cPushMessage.getMessageId());
            intent.putExtra(AgooConstants.MESSAGE_EXT, cPushMessage.getTraceInfo());
            this.f806a.startService(intent);
        } catch (Throwable th) {
            ALog.e("MPS:CloudPushService", "Dismiss message event upload failed.", th, new Object[0]);
        }
    }

    public void a(int i2, int i3, int i4, int i5, a aVar) {
        ALog.d("MPS:CloudPushService", "setDoNotDisturb " + i2 + ":" + i3 + "-" + i4 + ":" + i5, new Object[0]);
        if (i2 < 0 || i2 > 23 || i4 < 0 || i4 > 23 || i3 < 0 || i3 > 59 || i5 < 0 || i5 > 59) {
            if (aVar != null) {
                ErrorCode errorCode = com.taobao.agoo.a.INVALID_ARG;
                aVar.onFailed(errorCode.getCode(), errorCode.getMsg());
                return;
            }
            return;
        }
        this.f811f = true;
        this.f807b = i2;
        this.f808c = i3;
        this.f809d = i4;
        this.f810e = i5;
        if (aVar != null) {
            aVar.onSuccess("");
        }
    }

    public boolean a() {
        if (!this.f811f) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        int i2 = (this.f807b * 60) + this.f808c;
        int i3 = (this.f809d * 60) + this.f810e;
        int i4 = (calendar.get(11) * 60) + calendar.get(12);
        return i2 <= i3 ? i4 >= i2 && i4 <= i3 : i4 >= i2 || i4 <= i3;
    }

    public void a(CPushMessage cPushMessage) {
        if (cPushMessage != null && !TextUtils.isEmpty(cPushMessage.getMessageId())) {
            if (this.f806a == null) {
                ALog.e("MPS:CloudPushService", "context is null", new Object[0]);
                return;
            }
            try {
                Intent intent = new Intent();
                intent.setAction(m.f813b);
                intent.setClassName(this.f806a.getPackageName(), MsgService.class.getName());
                intent.putExtra(AgooConstants.ACTION_TYPE, AgooConstants.MESSAGE_TYPE_OPEN);
                intent.putExtra("msgId", cPushMessage.getMessageId());
                intent.putExtra(AgooConstants.MESSAGE_EXT, cPushMessage.getTraceInfo());
                this.f806a.startService(intent);
                return;
            } catch (Throwable th) {
                ALog.e("MPS:CloudPushService", "Click message event upload failed.", th, new Object[0]);
                return;
            }
        }
        ALog.e("MPS:CloudPushService", "message is null", new Object[0]);
    }
}
