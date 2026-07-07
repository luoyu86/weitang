package org.android.agoo.control;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.android.agoo.message.MessageService;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f14956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f14957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AgooFactory f14958c;

    public f(AgooFactory agooFactory, String str, String str2) {
        this.f14958c = agooFactory;
        this.f14956a = str;
        this.f14957b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        MsgDO msgDO = null;
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i("AgooFactory", "clickMessage", "msgid", this.f14956a, AgooConstants.MESSAGE_EXT, this.f14957b);
            }
            if (TextUtils.isEmpty(this.f14956a)) {
                ALog.d("AgooFactory", "messageId == null", new Object[0]);
                return;
            }
            MsgDO msgDO2 = new MsgDO();
            try {
                String str = this.f14956a;
                msgDO2.msgIds = str;
                msgDO2.extData = this.f14957b;
                msgDO2.messageSource = "accs";
                msgDO2.msgStatus = MessageService.MSG_ACCS_NOTIFY_CLICK;
                this.f14958c.updateMsgStatus(str, MessageService.MSG_ACCS_NOTIFY_CLICK);
                this.f14958c.notifyManager.reportNotifyMessage(msgDO2);
            } catch (Throwable th) {
                th = th;
                msgDO = msgDO2;
                try {
                    ALog.e("AgooFactory", "clickMessage,error=" + th, new Object[0]);
                } finally {
                    if (msgDO != null) {
                        this.f14958c.notifyManager.reportNotifyMessage(msgDO);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
