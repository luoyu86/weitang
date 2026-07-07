package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.provider.FontsContractCompat;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ok.ok;
import com.ss.android.socialbase.downloader.p.p;
import com.taobao.accs.messenger.MessengerService;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static bl f9913a = null;
    private static ok bl = null;
    private static final String ok = "a";

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.a$a, reason: collision with other inner class name */
    public interface InterfaceC0144a {
        boolean ok(@NonNull Context context);
    }

    public interface bl {
        void ok(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.ok okVar);
    }

    public static class n implements p.ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static int f9914a;
        public static int ok;
        private final Context bl;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final long f9915h;
        private final Handler kf;
        private final InterfaceC0144a n;
        private Future<Boolean> p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private boolean f9916q = false;
        private final Intent s;

        public n(Context context, Intent intent, int i2, InterfaceC0144a interfaceC0144a, long j) {
            this.bl = context;
            this.s = intent;
            f9914a = i2;
            this.n = interfaceC0144a;
            this.kf = new com.ss.android.socialbase.downloader.p.p(Looper.getMainLooper(), this);
            this.f9915h = j;
        }

        @Override // com.ss.android.socialbase.downloader.p.p.ok
        public void ok(Message message) {
            if (message != null) {
                int i2 = message.what;
                if (i2 == 1) {
                    long j = this.f9915h;
                    if (j <= 0 || j > 10000) {
                        return;
                    }
                    ok = 1;
                    this.p = com.ss.android.socialbase.downloader.downloader.bl.j().submit(new s(this.kf, this.bl, this.n, this.f9915h));
                    return;
                }
                if (i2 == 2) {
                    ok = 2;
                    this.kf.removeMessages(2);
                    this.kf.removeMessages(1);
                    Future<Boolean> future = this.p;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.f9916q && (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.ok.ok.ok().a())) {
                        Intent intent = this.s;
                        if (intent != null) {
                            a.a(this.bl, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.bl).getDownloadInfo(f9914a);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.ss.android.socialbase.appdownloader.bl.a(this.bl, f9914a, false);
                            }
                        }
                        this.f9916q = true;
                    }
                    a.a(f9914a, this.s == null, a.ok(this.bl));
                }
            }
        }
    }

    public static class ok implements ok.InterfaceC0174ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9917a;
        private JSONObject bl;
        private final n ok;

        public ok(Context context, Intent intent, int i2, JSONObject jSONObject, InterfaceC0144a interfaceC0144a) {
            this.bl = jSONObject;
            int iOptInt = jSONObject.optInt("query_interval", 1000);
            this.f9917a = iOptInt;
            this.ok = new n(context, intent, i2, interfaceC0144a, iOptInt);
        }

        @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC0174ok
        public void a() {
            if (!this.ok.f9916q) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                this.ok.kf.sendMessage(messageObtain);
            }
            com.ss.android.socialbase.downloader.ok.ok.ok().a(this);
            ok unused = a.bl = null;
        }

        @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC0174ok
        public void bl() {
            int iOptInt = this.bl.optInt("time_out_second", 20);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            this.ok.kf.sendMessage(messageObtain);
            if (iOptInt <= 0 || iOptInt >= 60) {
                return;
            }
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 2;
            this.ok.kf.sendMessageDelayed(messageObtain2, iOptInt * 1000);
        }
    }

    public static class s implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InterfaceC0144a f9918a;
        private final Handler bl;
        private final Context ok;
        private final long s;

        public s(Handler handler, Context context, InterfaceC0144a interfaceC0144a, long j) {
            this.ok = context;
            this.f9918a = interfaceC0144a;
            this.bl = handler;
            this.s = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            InterfaceC0144a interfaceC0144a;
            try {
                interfaceC0144a = this.f9918a;
            } catch (Throwable unused) {
            }
            if (interfaceC0144a != null) {
                long j = this.s;
                if (j > 0 && j <= 10000) {
                    Context context = this.ok;
                    boolean zOk = context != null ? interfaceC0144a.ok(context) : false;
                    Message messageObtain = Message.obtain();
                    if (zOk) {
                        messageObtain.what = 2;
                        this.bl.sendMessage(messageObtain);
                    } else {
                        messageObtain.what = 1;
                        this.bl.sendMessageDelayed(messageObtain, this.s);
                    }
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 26)
    public static boolean n(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean s(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean a(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.ok okVar) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            okVar.s = MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM;
            com.ss.android.socialbase.appdownloader.ok.ok okVarOk = com.ss.android.socialbase.appdownloader.ok.s.ok(context, MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject, downloadInfo);
            if (okVarOk != null && okVarOk.ok()) {
                Intent intentA = okVarOk.a();
                if (intentA == null) {
                    return false;
                }
                if (!ok(new File(savePath), downloadInfo, jSONObject)) {
                    okVar.f9949a = 6;
                } else {
                    if (a(context, intentA)) {
                        okVar.f9949a = 0;
                        return true;
                    }
                    okVar.f9949a = 1;
                }
                return false;
            }
            okVar.f9949a = 3;
        }
        return false;
    }

    public static void bl(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.bl.vk().a(i2, "guide_auth_open_setting", jSONObject2);
    }

    private static void s(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.bl.vk().a(i2, "guide_auth_dialog_show", jSONObject2);
    }

    public static boolean ok(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray jSONArrayN = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).n("ah_plans");
        if (jSONArrayN == null) {
            return false;
        }
        int length = jSONArrayN.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayN.optJSONObject(i2);
            if (com.ss.android.socialbase.appdownloader.kf.ok.ok(jSONObjectOptJSONObject) && ok(context, downloadInfo, intent, jSONObjectOptJSONObject, z)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0171 A[PHI: r15
  0x0171: PHI (r15v13 com.ss.android.socialbase.appdownloader.ok) = 
  (r15v2 com.ss.android.socialbase.appdownloader.ok)
  (r15v8 com.ss.android.socialbase.appdownloader.ok)
  (r15v14 com.ss.android.socialbase.appdownloader.ok)
 binds: [B:98:0x016f, B:88:0x0147, B:60:0x00e7] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean ok(android.content.Context r11, com.ss.android.socialbase.downloader.model.DownloadInfo r12, android.content.Intent r13, org.json.JSONObject r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.a.ok(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    public static com.ss.android.socialbase.appdownloader.ok a(JSONObject jSONObject, com.ss.android.socialbase.downloader.h.ok okVar) {
        com.ss.android.socialbase.appdownloader.ok okVar2 = new com.ss.android.socialbase.appdownloader.ok();
        if (jSONObject == null) {
            return okVar2;
        }
        okVar2.ok = jSONObject.optString("type");
        okVar2.n = "vbi";
        if (com.ss.android.socialbase.appdownloader.ok.s.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), "vbi", jSONObject, okVar)) {
            okVar2.f9949a = 0;
        } else {
            ok(okVar2, 3);
        }
        return okVar2;
    }

    public static void a(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.bl.vk().a(i2, "guide_auth_dialog_cancel", jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i2, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        int i3 = 1;
        try {
            jSONObject.put("scene", z ? 1 : 2);
            if (!z2) {
                i3 = 2;
            }
            jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.bl.vk().a(i2, "guide_auth_result", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Context context, Intent intent) {
        return ok(context, intent, true);
    }

    private static boolean ok(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.ok okVar, com.ss.android.socialbase.downloader.h.ok okVar2) {
        boolean zA;
        String strOptString = jSONObject.optString("type");
        okVar.ok = strOptString;
        Intent intentA = com.ss.android.socialbase.appdownloader.ok.s.ok(context, "vbi", jSONObject, downloadInfo).a();
        StringBuilder sb = new StringBuilder();
        try {
            zA = a(context, intentA);
        } catch (Throwable th) {
            sb.append(strOptString);
            sb.append(" startActivity failed : ");
            sb.append(ok(th));
            ok(okVar, 1);
            zA = false;
        }
        if (!zA) {
            okVar.bl = sb.toString();
        } else {
            okVar.f9949a = 0;
        }
        return true;
    }

    private static boolean ok(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.ok okVar) {
        boolean z;
        if (context != null && jSONObject != null) {
            String strOptString = jSONObject.optString("device_plans");
            okVar.n = strOptString;
            if (!TextUtils.isEmpty(strOptString)) {
                String[] strArrSplit = strOptString.split(",");
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                File file = new File(savePath);
                StringBuilder sb = new StringBuilder();
                String str = null;
                int length = strArrSplit.length;
                int i2 = 0;
                while (true) {
                    z = true;
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    String str2 = strArrSplit[i2];
                    com.ss.android.socialbase.appdownloader.ok.ok okVarOk = com.ss.android.socialbase.appdownloader.ok.s.ok(context, str2, jSONObject, downloadInfo);
                    if (okVarOk != null) {
                        Intent intentA = okVarOk.a();
                        if (intentA != null) {
                            if (ok(file, downloadInfo, jSONObject)) {
                                try {
                                    ok(context, intentA, false);
                                    str = str2;
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str2);
                                    sb.append(" startActivity failed : ");
                                    sb.append(ok(th));
                                    ok(okVar, 1);
                                }
                            } else {
                                ok(okVar, 6);
                                sb.append(str2);
                                sb.append(" createDescFile failed! ");
                            }
                        } else {
                            ok(okVar, 3);
                            sb.append(str2);
                            sb.append(" resolveActivity failed! ");
                        }
                    }
                    sb.append("  ");
                    i2++;
                }
                if (!z) {
                    okVar.bl = sb.toString();
                } else {
                    okVar.s = str;
                    okVar.f9949a = 0;
                }
                return z;
            }
        }
        return false;
    }

    public static int ok(@NonNull com.ss.android.socialbase.downloader.h.ok okVar) {
        if (!(okVar.s("download_dir") != null ? !TextUtils.isEmpty(r0.optString("dir_name")) : false)) {
            return 5;
        }
        if (!com.ss.android.socialbase.downloader.h.ok.bl().ok("get_download_info_by_list")) {
            return 4;
        }
        JSONArray jSONArrayN = okVar.n("ah_plans");
        int i2 = -1;
        if (jSONArrayN != null) {
            int length = jSONArrayN.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayN.optJSONObject(i3);
                if (com.ss.android.socialbase.appdownloader.kf.ok.ok(jSONObjectOptJSONObject)) {
                    String strOptString = jSONObjectOptJSONObject.optString("type");
                    if (!"plan_a".equals(strOptString) && !"plan_b".equals(strOptString) && !"plan_e".equals(strOptString) && !"plan_f".equals(strOptString)) {
                        if ("plan_d".equalsIgnoreCase(strOptString) || "plan_h".equalsIgnoreCase(strOptString) || ("plan_g".equalsIgnoreCase(strOptString) && (i2 = a(jSONObjectOptJSONObject, okVar).f9949a) == 0)) {
                            return 0;
                        }
                    } else {
                        i2 = ok(jSONObjectOptJSONObject, okVar).f9949a;
                        if (i2 == 0) {
                            return 0;
                        }
                    }
                }
            }
        }
        return i2;
    }

    @NonNull
    public static com.ss.android.socialbase.appdownloader.ok ok(JSONObject jSONObject, com.ss.android.socialbase.downloader.h.ok okVar) {
        com.ss.android.socialbase.appdownloader.ok okVar2 = new com.ss.android.socialbase.appdownloader.ok();
        if (jSONObject == null) {
            return okVar2;
        }
        String strOptString = jSONObject.optString("type");
        okVar2.ok = strOptString;
        if ("plan_b".equals(strOptString)) {
            okVar2.n = MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM;
            if (com.ss.android.socialbase.appdownloader.ok.s.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject, okVar)) {
                okVar2.f9949a = 0;
                return okVar2;
            }
            ok(okVar2, 3);
        } else {
            String strOptString2 = jSONObject.optString("device_plans");
            okVar2.n = strOptString2;
            if (!TextUtils.isEmpty(strOptString2)) {
                for (String str : strOptString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.ok.s.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), str, jSONObject, okVar)) {
                        okVar2.f9949a = 0;
                        return okVar2;
                    }
                    ok(okVar2, 3);
                }
            }
        }
        return okVar2;
    }

    public static com.ss.android.socialbase.appdownloader.ok ok(JSONObject jSONObject, String str, Context context, com.ss.android.socialbase.downloader.h.ok okVar) {
        com.ss.android.socialbase.appdownloader.ok okVar2 = new com.ss.android.socialbase.appdownloader.ok();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.kf.n.bl()) {
            okVar2.ok = jSONObject.optString("type");
            if (okVar.ok("bi", 0) == 1) {
                okVar2.f9949a = 0;
                return okVar2;
            }
            if (ok(context)) {
                okVar2.f9949a = 2;
            } else if (com.ss.android.socialbase.appdownloader.kf.ok.ok(str) != null) {
                okVar2.f9949a = 0;
            } else {
                okVar2.f9949a = 9;
            }
        }
        return okVar2;
    }

    private static void ok(com.ss.android.socialbase.appdownloader.ok okVar, int i2) {
        int i3 = okVar.f9949a;
        if (i3 != -1) {
            okVar.f9949a = (i3 * 10) + i2;
        } else {
            okVar.f9949a = i2;
        }
    }

    private static boolean ok(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject jSONObjectS = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).s("download_dir");
        File file2 = null;
        String strOptString = jSONObjectS != null ? jSONObjectS.optString("ins_desc") : null;
        if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString)) {
            file2 = new File(path + File.separator + strOptString);
        }
        if (file2 == null) {
            return true;
        }
        try {
            if (!file2.createNewFile()) {
                return true;
            }
            file2.deleteOnExit();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean ok(Context context, @Nullable Intent intent, JSONObject jSONObject, int i2, @Nullable com.ss.android.socialbase.appdownloader.ok okVar) {
        if (context != null && jSONObject != null) {
            long jOptLong = jSONObject.optLong("jump_interval", 0L);
            if (jOptLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("sp_ah_config", 0);
            if ((System.currentTimeMillis() - sharedPreferences.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= jOptLong && !ok(context)) {
                sharedPreferences.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra(MessengerService.INTENT, intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i2);
                    try {
                        if (ok(context, intent2, false)) {
                            s(i2, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (okVar != null) {
                            okVar.f9949a = 1;
                            okVar.bl = "tryShowUnknownSourceDialog" + ok(th);
                        }
                        return false;
                    }
                }
                if (ok(context, intent, i2, jSONObject)) {
                    bl(i2, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean ok(Context context, @Nullable Intent intent, int i2, JSONObject jSONObject) {
        try {
            if (com.ss.android.socialbase.appdownloader.kf.n.bl() && Build.VERSION.SDK_INT < 26 && !s(context)) {
                com.ss.android.socialbase.appdownloader.ok.kf kfVar = new com.ss.android.socialbase.appdownloader.ok.kf(context);
                if (kfVar.ok()) {
                    ok(context, intent, i2, jSONObject, new InterfaceC0144a() { // from class: com.ss.android.socialbase.appdownloader.a.1
                        @Override // com.ss.android.socialbase.appdownloader.a.InterfaceC0144a
                        public boolean ok(@NonNull Context context2) {
                            return a.s(context2);
                        }
                    });
                    return a(context, kfVar.a());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !n(context)) {
                com.ss.android.socialbase.appdownloader.ok.a aVar = new com.ss.android.socialbase.appdownloader.ok.a(context);
                if (aVar.ok()) {
                    ok(context, intent, i2, jSONObject, new InterfaceC0144a() { // from class: com.ss.android.socialbase.appdownloader.a.2
                        @Override // com.ss.android.socialbase.appdownloader.a.InterfaceC0144a
                        public boolean ok(@NonNull Context context2) {
                            return a.n(context2);
                        }
                    });
                    return a(context, aVar.a());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean ok(Context context) {
        if (context == null) {
            return true;
        }
        if (com.ss.android.socialbase.appdownloader.kf.n.bl() && Build.VERSION.SDK_INT < 26) {
            return s(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return n(context);
        }
        return true;
    }

    public static boolean ok() {
        return n.ok == 1;
    }

    public static void ok(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.bl.vk().a(i2, "guide_auth_dialog_confirm", jSONObject2);
    }

    private static void ok(Context context, Intent intent, int i2, JSONObject jSONObject, InterfaceC0144a interfaceC0144a) {
        if (bl != null) {
            com.ss.android.socialbase.downloader.ok.ok.ok().a(bl);
            bl = null;
        }
        bl = new ok(context, intent, i2, jSONObject, interfaceC0144a);
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(bl);
    }

    public static boolean ok(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            try {
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra("start_only_for_android", true);
        context.startActivity(intent);
        return true;
    }

    public static String ok(Throwable th) {
        String string = th.toString();
        return string.length() > 800 ? string.substring(0, 500) : string;
    }

    public static void ok(bl blVar) {
        f9913a = blVar;
    }
}
