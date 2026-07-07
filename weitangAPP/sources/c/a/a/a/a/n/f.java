package c.a.a.a.a.n;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.content.ContextCompat;
import c.a.a.a.a.m;
import com.alibaba.sdk.android.logger.ILog;
import com.aliyun.ams.emas.push.AgooMessageReceiver;
import com.taobao.accs.dispatch.IntentDispatch;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.TaobaoRegister;
import java.util.Iterator;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class f {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v16, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r4v10, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v11, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v4, types: [int] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public int a(Intent intent, Context context, int i2) {
        String str;
        ILog iLog;
        StringBuilder sb;
        ?? r4;
        String str2;
        String str3;
        String str4;
        ?? r7;
        ?? r42;
        ?? r43;
        ?? intent2;
        int i3;
        ?? r72;
        boolean z;
        Class<?> clsA = m.a();
        if (!AgooConstants.NOTIFICATION_TYPE_OPEN.equals(intent.getStringExtra(AgooConstants.ACTION_TYPE))) {
            if (!AgooConstants.NOTIFICATION_TYPE_DELETE.equals(intent.getStringExtra(AgooConstants.ACTION_TYPE))) {
                if (AgooConstants.MESSAGE_TYPE_OPEN.equals(intent.getStringExtra(AgooConstants.ACTION_TYPE))) {
                    TaobaoRegister.clickMessage(context, intent.getStringExtra("msgId"), intent.getStringExtra(AgooConstants.MESSAGE_EXT));
                    return 0;
                }
                if (!AgooConstants.MESSAGE_TYPE_DELETE.equals(intent.getStringExtra(AgooConstants.ACTION_TYPE))) {
                    return 0;
                }
                TaobaoRegister.dismissMessage(context, intent.getStringExtra("msgId"), intent.getStringExtra(AgooConstants.MESSAGE_EXT));
                return 0;
            }
            String stringExtra = intent.getStringExtra("msgId");
            intent.getStringExtra(AgooConstants.MESSAGE_TASK_ID);
            String stringExtra2 = intent.getStringExtra(AgooConstants.MESSAGE_EXT);
            try {
                Intent intent3 = new Intent();
                intent3.setPackage(context.getPackageName());
                intent3.setAction(AgooMessageReceiver.NOTIFICATION_REMOVED_ACTION);
                intent3.putExtra(AgooMessageReceiver.MESSAGE_ID, stringExtra);
                intent3.putExtra("title", intent.getStringExtra("title"));
                intent3.putExtra(AgooMessageReceiver.SUMMARY, intent.getStringExtra(AgooMessageReceiver.SUMMARY));
                intent3.putExtra(AgooMessageReceiver.EXTRA_MAP, intent.getStringExtra(AgooMessageReceiver.EXTRA_MAP));
                intent3.putExtra(AgooMessageReceiver.NOTIFICATION_OPEN_TYPE, intent.getIntExtra(AgooMessageReceiver.NOTIFICATION_OPEN_TYPE, 1));
                intent3.putExtra(AgooMessageReceiver.NOTIFICATION_GROUP, intent.getStringExtra(AgooMessageReceiver.NOTIFICATION_GROUP));
                if (Build.VERSION.SDK_INT >= 12) {
                    intent3.setFlags(32);
                }
                if (clsA == null) {
                    context.sendBroadcast(intent3, context.getPackageName() + ".AGOO");
                } else {
                    intent3.setClass(context, clsA);
                    IntentDispatch.dispatchIntent(context, intent3, clsA.getName());
                }
                iLog = m.f812a;
                sb = new StringBuilder();
                str = "Delete msg(";
            } catch (Throwable th) {
                str = "Delete msg(";
                try {
                    ALog.e("MPS:CPushServiceListener", "send intent failed.", th, new Object[0]);
                    iLog = m.f812a;
                    sb = new StringBuilder();
                } catch (Throwable th2) {
                    m.f812a.i(str + stringExtra + ")");
                    TaobaoRegister.dismissMessage(context, stringExtra, stringExtra2);
                    throw th2;
                }
            }
            sb.append(str);
            sb.append(stringExtra);
            sb.append(")");
            iLog.i(sb.toString());
            TaobaoRegister.dismissMessage(context, stringExtra, stringExtra2);
            return 0;
        }
        Intent intent4 = (Intent) intent.getExtras().get(AgooConstants.KEY_REAL_INTENT);
        intent4.setFlags(335544320);
        String stringExtra3 = intent4.getStringExtra("msgId");
        String stringExtra4 = intent4.getStringExtra("title");
        String stringExtra5 = intent4.getStringExtra(AgooMessageReceiver.SUMMARY);
        String stringExtra6 = intent.getStringExtra(AgooConstants.MESSAGE_EXT);
        String stringExtra7 = intent.getStringExtra(AgooMessageReceiver.NOTIFICATION_GROUP);
        int intExtra = intent4.getIntExtra(AgooMessageReceiver.NOTIFICATION_OPEN_TYPE, 1);
        ?? intExtra2 = intent4.getIntExtra(AgooMessageReceiver.NOTIFICATION_ID, 0);
        String stringExtra8 = intent4.getStringExtra(AgooMessageReceiver.EXTRA_MAP);
        try {
            intent2 = new Intent();
            intent2.setPackage(context.getPackageName());
            r4 = AgooMessageReceiver.NOTIFICATION_OPENED_ACTION;
            intent2.setAction(AgooMessageReceiver.NOTIFICATION_OPENED_ACTION);
            intent2.putExtra(AgooMessageReceiver.MESSAGE_ID, stringExtra3);
            intent2.putExtra("title", stringExtra4);
            intent2.putExtra(AgooMessageReceiver.SUMMARY, stringExtra5);
            intent2.putExtra(AgooMessageReceiver.EXTRA_MAP, stringExtra8);
            intent2.putExtra(AgooMessageReceiver.NOTIFICATION_OPEN_TYPE, intExtra);
            intent2.putExtra(AgooMessageReceiver.NOTIFICATION_ID, intExtra2);
            if (!TextUtils.isEmpty(stringExtra7)) {
                intent2.putExtra(AgooMessageReceiver.NOTIFICATION_GROUP, stringExtra7);
            }
            i3 = Build.VERSION.SDK_INT;
            if (i3 >= 12) {
                intent2.setFlags(32);
            }
        } catch (Throwable th3) {
            th = th3;
            r4 = context;
        }
        try {
            if (clsA == null) {
                ?? r44 = context;
                r44.sendBroadcast(intent2, context.getPackageName() + ".AGOO");
                r4 = r44;
            } else {
                Context context2 = context;
                intent2.setClass(context2, clsA);
                IntentDispatch.dispatchIntent(context2, intent2, clsA.getName());
                r4 = context2;
            }
            if (i2 == 0 && "android.intent.action.MAIN".equals(intent4.getAction()) && g.a(context)) {
                m.f812a.d("app is in front, action:" + intent4.getAction());
            } else {
                try {
                    if (intExtra == 4) {
                        try {
                            ALog.i("MPS:CPushServiceListener", "open with no action", new Object[0]);
                        } catch (Throwable th4) {
                            th = th4;
                            r72 = "MPS:CPushServiceListener";
                            str2 = stringExtra6;
                            str3 = ")";
                            str4 = "Open msg(";
                            r42 = r4;
                            r7 = r72;
                            try {
                                ALog.e(r7, "startActivity error", th, new Object[0]);
                                m.f812a.i(str4 + stringExtra3 + str3);
                                r43 = r42;
                            } catch (Throwable th5) {
                                m.f812a.i(str4 + stringExtra3 + str3);
                                TaobaoRegister.clickMessage(r42, stringExtra3, str2);
                                throw th5;
                            }
                        }
                    } else {
                        intExtra2 = "MPS:CPushServiceListener";
                        if (intExtra == 1) {
                            ALog.i(intExtra2, "open app", new Object[0]);
                            if (i3 < 11 || i2 != 0) {
                                ALog.w(intExtra2, "sdk version < 11 or start from activity, start app with launch activity", new Object[0]);
                                r4.startActivity(intent4);
                            } else if (ContextCompat.checkSelfPermission(r4, "android.permission.GET_TASKS") == 0 && ContextCompat.checkSelfPermission(r4, "android.permission.REORDER_TASKS") == 0) {
                                ActivityManager activityManager = (ActivityManager) r4.getSystemService("activity");
                                Iterator<ActivityManager.RunningTaskInfo> it = activityManager.getRunningTasks(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z = true;
                                        break;
                                    }
                                    ActivityManager.RunningTaskInfo next = it.next();
                                    if (next.topActivity.getPackageName().equals(context.getPackageName())) {
                                        ALog.d(intExtra2, "move task to front", new Object[0]);
                                        try {
                                            activityManager.moveTaskToFront(next.id, 0);
                                            z = false;
                                            break;
                                        } catch (Throwable th6) {
                                            ALog.w(intExtra2, "move task to front fail", th6, new Object[0]);
                                        }
                                    }
                                }
                                if (true == z) {
                                    ALog.w(intExtra2, "do not find corresponing running task, start app with launch activity", new Object[0]);
                                    r4.startActivity(intent4);
                                }
                            } else {
                                ALog.d(intExtra2, "no get tasks and reorder tasks permission, start app with launch activity", new Object[0]);
                                r4.startActivity(intent4);
                            }
                        } else {
                            if (intExtra == 2) {
                                ALog.d(intExtra2, "open activity", new Object[0]);
                            } else if (intExtra == 3) {
                                ALog.d(intExtra2, "open url", new Object[0]);
                            }
                            r4.startActivity(intent4);
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    r72 = intExtra2;
                    str2 = stringExtra6;
                    str3 = ")";
                    str4 = "Open msg(";
                    r42 = r4;
                    r7 = r72;
                    ALog.e(r7, "startActivity error", th, new Object[0]);
                    m.f812a.i(str4 + stringExtra3 + str3);
                    r43 = r42;
                }
            }
            m.f812a.i("Open msg(" + stringExtra3 + ")");
            str2 = stringExtra6;
            r43 = r4;
        } catch (Throwable th8) {
            th = th8;
            str2 = stringExtra6;
            str3 = ")";
            str4 = "Open msg(";
            r7 = "MPS:CPushServiceListener";
            r42 = r4;
            ALog.e(r7, "startActivity error", th, new Object[0]);
            m.f812a.i(str4 + stringExtra3 + str3);
            r43 = r42;
            TaobaoRegister.clickMessage(r43, stringExtra3, str2);
            return 0;
        }
        TaobaoRegister.clickMessage(r43, stringExtra3, str2);
        return 0;
    }

    @SuppressLint({"MissingPermission"})
    public int a(Intent intent, Context context) {
        return a(intent, context, 0);
    }
}
