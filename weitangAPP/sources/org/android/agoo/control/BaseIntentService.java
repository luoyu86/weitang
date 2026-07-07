package org.android.agoo.control;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.Utils;
import org.android.agoo.common.Config;
import org.android.agoo.message.MessageService;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseIntentService extends Service {
    private static final String TAG = "BaseIntentService";
    private static final String msgStatus = "4";
    private AgooFactory agooFactory;
    private MessageService messageService;
    private NotifManager notifyManager;
    private Context mContext = null;
    private Messenger messenger = new Messenger(new h(this));

    private String getTrace(long j) {
        return "appkey|" + j + "|" + System.currentTimeMillis() + "|" + (TextUtils.isEmpty(null) ? "unknow" : null) + "|" + (TextUtils.isEmpty(null) ? "unknow" : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1 A[Catch: all -> 0x0318, TryCatch #13 {all -> 0x0318, blocks: (B:33:0x00b1, B:35:0x00c1, B:36:0x00fe, B:38:0x0127, B:40:0x0131, B:42:0x0143, B:44:0x014d, B:47:0x015f, B:52:0x0177, B:50:0x016e, B:32:0x00a9), top: B:139:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0127 A[Catch: all -> 0x0318, TryCatch #13 {all -> 0x0318, blocks: (B:33:0x00b1, B:35:0x00c1, B:36:0x00fe, B:38:0x0127, B:40:0x0131, B:42:0x0143, B:44:0x014d, B:47:0x015f, B:52:0x0177, B:50:0x016e, B:32:0x00a9), top: B:139:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0177 A[Catch: all -> 0x0318, TRY_LEAVE, TryCatch #13 {all -> 0x0318, blocks: (B:33:0x00b1, B:35:0x00c1, B:36:0x00fe, B:38:0x0127, B:40:0x0131, B:42:0x0143, B:44:0x014d, B:47:0x015f, B:52:0x0177, B:50:0x016e, B:32:0x00a9), top: B:139:0x00a9 }] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void handleRemoteMessage(android.content.Context r34, android.content.Intent r35) {
        /*
            Method dump skipped, instruction units count: 867
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.control.BaseIntentService.handleRemoteMessage(android.content.Context, android.content.Intent):void");
    }

    private void handleRemovePackage(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        Uri data = intent.getData();
        String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : null;
        if (TextUtils.isEmpty(schemeSpecificPart)) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(TAG, "handleRemovePackage---->[replacing:" + booleanExtra + "],uninstallPack=" + schemeSpecificPart, new Object[0]);
        }
        if (booleanExtra) {
            return;
        }
        this.notifyManager.doUninstall(schemeSpecificPart, booleanExtra);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (OrangeAdapter.isBindService(this) && Utils.isTarget26(this)) {
            getApplicationContext().bindService(new Intent(this, getClass()), new j(this), 1);
        }
        return this.messenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ThreadPoolExecutorFactory.execute(new k(this));
    }

    @Deprecated
    public abstract void onError(Context context, String str);

    public void onHandleIntent(Intent intent) {
        this.mContext = getApplicationContext();
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        ALog.i(TAG, "onHandleIntent,action=" + action, new Object[0]);
        try {
            if (action.equals("org.agoo.android.intent.action.RECEIVE")) {
                handleRemoteMessage(this.mContext, intent);
            } else if (TextUtils.equals(action, "org.agoo.android.intent.action.REPORT")) {
                try {
                    ALog.i(TAG, "is report cache msg,Config.isReportCacheMsg(mContext)=" + Config.e(this.mContext), new Object[0]);
                    if (Config.e(this.mContext) && AdapterUtilityImpl.isNetworkConnected(this.mContext)) {
                        Config.f(this.mContext);
                        this.agooFactory.reportCacheMsg();
                        this.messageService.deleteCacheMessage();
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (ALog.isPrintLog(ALog.Level.I)) {
                        ALog.i(TAG, "is clear all msg=" + Config.b(this.mContext, jCurrentTimeMillis), new Object[0]);
                    }
                    if (Config.b(this.mContext, jCurrentTimeMillis)) {
                        Config.a(this.mContext, jCurrentTimeMillis);
                        this.messageService.deleteCacheMessage();
                    }
                } catch (Throwable th) {
                    ALog.e(TAG, "reportCacheMsg", th, new Object[0]);
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public abstract void onMessage(Context context, Intent intent);

    @Deprecated
    public abstract void onRegistered(Context context, String str);

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        ThreadPoolExecutorFactory.execute(new l(this, intent));
        return 2;
    }
}
