package c.e.a.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.mail.MailBo;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadImgVo;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Long f1179a = 6000L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b0 f1180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1181c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f1185g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1182d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1183e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1184f = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<String> f1186h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f1187i = new ArrayList();

    public class a implements c.e.a.a.f.d {
        public a() {
        }

        @Override // c.e.a.a.f.d
        public void onError(@NonNull Throwable th) {
            q.e(a.class.getSimpleName(), "onError " + th.getMessage());
        }

        @Override // c.e.a.a.f.d
        public void onSuccess() {
            q.d(a.class.getSimpleName(), "onSuccess");
        }
    }

    public b0() {
        f();
        g();
    }

    public static boolean checkPass(String str) {
        return str.matches(".*[a-z]{1,}.*") && str.matches(".*[A-Z]{1,}.*") && str.matches(".*\\d{1,}.*");
    }

    public static boolean checkPasswordIsValid(String str) {
        return x.isNotNull(str) && str.length() >= 6 && checkPass(str);
    }

    public static b0 getInstance() {
        if (f1180b == null) {
            synchronized (b0.class) {
                f1180b = new b0();
            }
        }
        return f1180b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j() {
        try {
            File file = new File(f.getAppErrFile());
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                StringBuilder sb = new StringBuilder(5);
                String line = bufferedReader.readLine();
                sb.append(line);
                while (line != null) {
                    line = bufferedReader.readLine();
                    if (line != null) {
                        sb.append(line);
                    }
                }
                bufferedReader.close();
                sendAppErrorMail(sb.toString());
                file.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(String str) {
        q(str, "闪退日志");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(String str, String str2) {
        if (!x.isNotNull(str) || str.length() >= 50) {
            str = "异常信息";
        }
        q(str2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(String str, String str2) {
        try {
            Thread.sleep(1000L);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d -s AndroidBLE").getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    String string = sb.toString();
                    bufferedReader.close();
                    sendMail(d("", str, str + str2) + string);
                    return;
                }
                sb.append(line);
                sb.append("</br>");
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final String a(Uri uri, String str, Activity activity) {
        Cursor cursorQuery = activity.getApplication().getContentResolver().query(uri, null, str, null, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("_data")) : null;
            cursorQuery.close();
        }
        return string;
    }

    public final String b() {
        return w.getInstance().getString(NewLoginBo.SMS_LOGIN_NAME, "");
    }

    public final String c() {
        String strB = b();
        if (!x.isNotNull(strB)) {
            return strB;
        }
        StringBuilder sb = new StringBuilder(1);
        sb.append(strB);
        sb.replace(3, 7, "****");
        return sb.toString();
    }

    public final String d(String str, String str2, String str3) {
        try {
            if (x.isNumeric(str2) && (Integer.parseInt(str2) < 500 || Integer.parseInt(str2) == 902)) {
                return null;
            }
            StringBuilder sb = new StringBuilder(8);
            UserInfoVo userInfoVoE = e();
            sb.append("AppVersion=");
            sb.append(c.e.a.a.b.getInstance().getAppVersionName());
            sb.append("<br/>Eve=");
            sb.append(j.getInstance().f1216b);
            sb.append("<br/>Phone=");
            sb.append(c());
            if (userInfoVoE == null) {
                return null;
            }
            if (str != null) {
                sb.append("<br/>Path=");
                sb.append(str);
            }
            sb.append("<br/>Code=");
            sb.append(str2);
            sb.append("<br/>Msg=");
            sb.append(str3);
            String str4 = Build.BRAND + ":" + Build.MODEL;
            sb.append("<br/>PhoneType=");
            sb.append(str4);
            String strValueOf = String.valueOf(Build.VERSION.SDK_INT);
            sb.append("<br/>SystemVersion=");
            sb.append(strValueOf);
            sb.append("<br/>Time=");
            sb.append(z.getCurrentTimeInString(z.f1243d));
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final UserInfoVo e() {
        String string = w.getInstance().getString("userDetailsInfoKey", null);
        if (x.isNotNull(string)) {
            return (UserInfoVo) JSON.parseObject(string, UserInfoVo.class);
        }
        return null;
    }

    public final void f() {
        this.f1186h.add("v1/uas/security");
        this.f1186h.add("frameworks/systems/user/send/verification/code");
        this.f1186h.add("frameworks/systems/user/app/login");
        this.f1186h.add("business/get/secretkey");
        this.f1186h.add("houses/access/controls");
        this.f1186h.add("account/withdraw");
        this.f1186h.add("commodity/place/order");
        this.f1186h.add("business/company/pay/order/pay/sign");
        this.f1186h.add("business/company/pay/status");
        this.f1186h.add("business/company/pay/find/paymode");
        this.f1186h.add("account/recharge");
    }

    public final void g() {
        this.f1187i.add("nologin/commodity/list");
        this.f1187i.add("nologin/banner");
        this.f1187i.add("nologin/group/list");
        this.f1187i.add("nologin/project/list");
        this.f1187i.add("nologin/activity/list");
    }

    public String getPhotoToPicPath(Intent intent, Activity activity) {
        return a(intent.getData(), null, activity);
    }

    public String getProductKey() {
        return this.f1184f;
    }

    public String getProductType() {
        return this.f1183e;
    }

    public void getSystemOs(Context context) {
    }

    public List<String> getUploadSuccessPicKey(List<ResponseUploadImgVo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (ResponseUploadImgVo responseUploadImgVo : list) {
                if (responseUploadImgVo != null) {
                    arrayList.add(responseUploadImgVo.getKey());
                }
            }
        }
        return arrayList;
    }

    public List<String> getUploadSuccessPicUrl(List<ResponseUploadImgVo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (ResponseUploadImgVo responseUploadImgVo : list) {
                if (responseUploadImgVo != null) {
                    arrayList.add(responseUploadImgVo.getUrl());
                }
            }
        }
        return arrayList;
    }

    public void goToMarket(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final synchronized boolean h(String str) {
        try {
            Iterator<String> it = this.f1186h.iterator();
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public void handleRequestServerErr(String str, String str2, String str3, boolean z) {
        try {
            String strD = d(str, str2, str3);
            if (strD != null) {
                if (z) {
                    r(strD, str3);
                } else {
                    sendMail(strD);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isBuy() {
        return this.f1182d;
    }

    public boolean isConnect() {
        return this.f1181c;
    }

    public synchronized boolean isIgnoreUrl(String str) {
        try {
            Iterator<String> it = this.f1187i.iterator();
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public final void q(String str, String str2) {
        try {
            MailBo mailBo = new MailBo();
            mailBo.setMailServerHost("smtp.163.com");
            mailBo.setMailServerPort("25");
            String str3 = Build.MANUFACTURER;
            Locale locale = Locale.ROOT;
            if (str3.toLowerCase(locale).contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR) || str3.toLowerCase(locale).contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI)) {
                mailBo.setFromAddress("changkai248@163.com");
                mailBo.setPassword("TUUDQRBVWFHHWBWA");
            } else {
                mailBo.setFromAddress("kchang244@163.com");
                mailBo.setPassword("NCVFHFBYAOHSJOYK");
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("544929794@qq.com");
            mailBo.setToAddress(arrayList);
            mailBo.setSubject("微棠App-" + str2);
            mailBo.setContent(str);
            q.d(getClass().getSimpleName(), "sendMail");
            c.e.a.a.f.c.sendMail(mailBo, new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void r(final String str, final String str2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f1185g > f1179a.longValue()) {
            this.f1185g = jCurrentTimeMillis;
            y.get().addRunnable(new Runnable() { // from class: c.e.a.d.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1189a.n(str2, str);
                }
            });
        }
    }

    public void sendAppErr() {
        y.get().addRunnable(new Runnable() { // from class: c.e.a.d.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f1194a.j();
            }
        });
    }

    public synchronized void sendAppErrorMail(final String str) {
        y.get().addRunnable(new Runnable() { // from class: c.e.a.d.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f1177a.l(str);
            }
        });
    }

    public synchronized void sendMail(String str) {
        r(str, null);
    }

    public void setBuy(boolean z) {
        this.f1182d = z;
        this.f1184f = null;
        this.f1183e = null;
    }

    public void setNetworkStatus(boolean z) {
        this.f1181c = z;
    }

    public void setProductKey(String str) {
        this.f1184f = str;
    }

    public void setProductType(String str) {
        this.f1183e = str;
    }

    public void startReadLog(final String str, final String str2) {
        y.get().addRunnable(new Runnable() { // from class: c.e.a.d.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f1200a.p(str, str2);
            }
        });
    }

    public void handleRequestServerErr(String str, String str2, String str3) {
        try {
            String strD = d(str, str2, str3);
            if (strD != null) {
                if (h(str)) {
                    r(strD, str3);
                } else {
                    sendMail(strD);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
