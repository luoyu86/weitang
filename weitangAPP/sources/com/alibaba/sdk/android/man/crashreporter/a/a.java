package com.alibaba.sdk.android.man.crashreporter.a;

import android.content.Context;
import android.os.Looper;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.man.crashreporter.MotuCrashReporter;
import com.alibaba.sdk.android.man.crashreporter.ReporterConfigure;
import com.alibaba.sdk.android.man.crashreporter.c;
import com.alibaba.sdk.android.man.crashreporter.e.e;
import com.alibaba.sdk.android.man.crashreporter.e.i;
import com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent;
import com.alibaba.sdk.android.man.crashreporter.global.CrashReportDataForSave;
import com.google.zxing.common.StringUtils;
import com.taobao.accs.common.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    private static int k = 0;
    private static int l = 0;
    private static int m = 10;
    private static int n = 10;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.man.crashreporter.a.a.b f78a = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4679a = null;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    private String f81m = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, String> f80a = null;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    private String f82n = null;
    private String o = null;
    private String p = "";
    private c environment = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.man.crashreporter.d.c f79a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.alibaba.sdk.android.man.crashreporter.d.c f4680b = null;

    private String a() {
        return null;
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.b
    public boolean a(Context context, ReporterConfigure reporterConfigure, c cVar, com.alibaba.sdk.android.man.crashreporter.d.c cVar2, com.alibaba.sdk.android.man.crashreporter.d.c cVar3) {
        try {
            if (context == null) {
                com.alibaba.sdk.android.man.crashreporter.b.a.h("init builder failure!");
                return false;
            }
            if (this.f78a == null) {
                this.f78a = new com.alibaba.sdk.android.man.crashreporter.a.a.a();
            }
            this.f4679a = context;
            this.f78a.a(reporterConfigure, context, cVar3, this);
            this.environment = cVar;
            this.f79a = cVar3;
            this.f4680b = cVar2;
            return true;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("init builder err!", e2);
            return false;
        }
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.b
    public CrashReportDataForSave b(String str, String str2, String str3, Map map) {
        if (str == null) {
            try {
                str = this.o;
            } catch (Exception e2) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("buildNativeCrashReport err!", e2);
                return null;
            }
        }
        if (str3 == null) {
            str3 = this.p;
        }
        if (str2 == null) {
            str2 = this.f82n;
        }
        if (map == null) {
            map = this.f80a;
        }
        ReporterConfigure configure = MotuCrashReporter.getInstance().getConfigure();
        k = 15;
        l = 15;
        m = 100;
        n = 50;
        a(configure, 15, 15, 100, 50);
        String strA = a(configure, com.alibaba.sdk.android.man.crashreporter.a.b.a.a("", false), new com.alibaba.sdk.android.man.crashreporter.a.b.b());
        com.alibaba.sdk.android.man.crashreporter.a.c.a.a aVar = new com.alibaba.sdk.android.man.crashreporter.a.c.a.a();
        CrashReportDataForSave crashReportDataForSave = new CrashReportDataForSave();
        crashReportDataForSave.triggeredTime = Long.valueOf(System.currentTimeMillis());
        if (str3.length() <= 0) {
            str3 = strA;
        }
        crashReportDataForSave.hashCode = String.format("%s", Integer.valueOf(i.a(str3)));
        crashReportDataForSave.nativeCrashPath = str;
        crashReportDataForSave.type = 1;
        String strI = this.f4680b.i();
        String strTrim = str.trim();
        String strSubstring = strTrim.substring(strTrim.lastIndexOf("/") + 1);
        crashReportDataForSave.path = String.format("%s/%s", strI, strSubstring);
        crashReportDataForSave.fileName = strSubstring;
        a(aVar);
        CrashReportDataForSave crashReportDataForSaveA = a(crashReportDataForSave.type.intValue(), configure, crashReportDataForSave.hashCode, crashReportDataForSave.path, this.environment.userNick);
        if (crashReportDataForSaveA != null) {
            return crashReportDataForSaveA;
        }
        aVar.f4696c.put("triggeredTime", crashReportDataForSave.triggeredTime);
        aVar.f4696c.put("exception", str2);
        aVar.f4696c.put("threads", strA);
        aVar.f4696c.put("currentThread", str3);
        if (m36a()) {
            aVar.f4696c.put("isMainThread", Boolean.TRUE);
        } else {
            aVar.f4696c.put("isMainThread", Boolean.FALSE);
        }
        aVar.f4696c.put("type", "ANDROID_NATIVE");
        aVar.f4696c.put(AgooConstants.MESSAGE_EXT, com.alibaba.sdk.android.man.crashreporter.a.c.a.b((Map<String, String>) map));
        crashReportDataForSave.content = a(aVar, configure);
        crashReportDataForSave.metaDataBase64 = a(configure, crashReportDataForSave);
        crashReportDataForSave.utPage = a();
        com.alibaba.sdk.android.man.crashreporter.b.a.e("build native crash data end!");
        this.f4680b.b(crashReportDataForSave);
        return crashReportDataForSave;
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.b
    public synchronized Map<com.alibaba.sdk.android.man.crashreporter.global.a, String> a(int i2, int i3, int i4, int i5) {
        try {
            ReporterConfigure configure = MotuCrashReporter.getInstance().getConfigure();
            k = i2;
            l = i3;
            m = i4;
            n = i5;
            a(configure, i2, i3, i4, i5);
            if (this.f78a == null) {
                this.f78a = new com.alibaba.sdk.android.man.crashreporter.a.a.a();
            }
            com.alibaba.sdk.android.man.crashreporter.a.a.b bVar = this.f78a;
            if (bVar == null || this.environment == null || this.f79a == null) {
                return null;
            }
            Map<com.alibaba.sdk.android.man.crashreporter.global.a, String> mapMo40b = bVar.mo40b();
            a((com.alibaba.sdk.android.man.crashreporter.a.c.a.a) null);
            mapMo40b.put(com.alibaba.sdk.android.man.crashreporter.global.a.IMSI, com.alibaba.sdk.android.man.crashreporter.e.a.f(this.f4679a));
            mapMo40b.put(com.alibaba.sdk.android.man.crashreporter.global.a.IMEI, com.alibaba.sdk.android.man.crashreporter.e.a.e(this.f4679a));
            mapMo40b.put(com.alibaba.sdk.android.man.crashreporter.global.a.APP_KEY, this.environment.appKey);
            mapMo40b.put(com.alibaba.sdk.android.man.crashreporter.global.a.APP_VERSION, this.environment.appVersion);
            mapMo40b.put(com.alibaba.sdk.android.man.crashreporter.global.a.CHANNEL, this.environment.channel);
            mapMo40b.put(com.alibaba.sdk.android.man.crashreporter.global.a.USER_NICK, this.environment.userNick);
            mapMo40b.put(com.alibaba.sdk.android.man.crashreporter.global.a.IS_BACKGROUD, this.f78a.b());
            return mapMo40b;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("get internal Data failed", e2);
            return null;
        }
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.b
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, String> mo39a() {
        com.alibaba.sdk.android.man.crashreporter.a.a.b bVar = this.f78a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public synchronized boolean a(ReporterConfigure reporterConfigure) {
        return false;
    }

    private void a(ReporterConfigure reporterConfigure, int i2, int i3, int i4, int i5) {
        if (reporterConfigure != null) {
            reporterConfigure.enableMaxThreadNumber = i2;
            reporterConfigure.enableMaxThreadStackTraceNumber = i3;
            reporterConfigure.enableSysLogcatMaxCount = i4;
            reporterConfigure.enableSysLogcatLinkMaxCount = i5;
        }
    }

    private String a(ReporterConfigure reporterConfigure, com.alibaba.sdk.android.man.crashreporter.a.b.a aVar, com.alibaba.sdk.android.man.crashreporter.a.b.b bVar) {
        return (reporterConfigure == null || !reporterConfigure.enableDumpAllThread) ? "" : bVar.a(aVar.c());
    }

    private String a(com.alibaba.sdk.android.man.crashreporter.a.b.a aVar, com.alibaba.sdk.android.man.crashreporter.a.b.b bVar) {
        return bVar.a(com.alibaba.sdk.android.man.crashreporter.a.b.a.d());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m36a() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    private void a(com.alibaba.sdk.android.man.crashreporter.a.c.a.a aVar) {
        try {
            c cVar = this.environment;
            if (cVar == null) {
                return;
            }
            String str = cVar.userNick;
            if (str == null || str.length() <= 0) {
                com.alibaba.sdk.android.man.crashreporter.b.a.e("user nick is null or length <= 0!");
                this.environment.userNick = this.f79a.h();
            }
            if (this.environment.appKey == null) {
                com.alibaba.sdk.android.man.crashreporter.b.a.e("use taobao default appKey,because your appKey is null!");
                c cVar2 = this.environment;
                cVar2.appKey = cVar2.k;
            }
            if (this.environment.appVersion == null) {
                com.alibaba.sdk.android.man.crashreporter.b.a.e("use taobao app base or default Version,because your appVersion is null!");
                String strD = com.alibaba.sdk.android.man.crashreporter.a.d.a.d(this.f4679a);
                if (strD != null) {
                    this.environment.appVersion = strD;
                } else {
                    c cVar3 = this.environment;
                    cVar3.appVersion = cVar3.l;
                }
            }
            if (aVar != null) {
                aVar.f4696c.put("sdkname", "MOTU");
                aVar.f4696c.put(Constants.KEY_SDK_VERSION, "2.0.0");
                aVar.f4696c.put(DispatchConstants.PLATFORM, "ANDROID");
                aVar.f4696c.put("launchedTime", Long.valueOf(this.environment.startupTime));
                aVar.f4696c.put("channel", this.environment.channel);
                aVar.f4696c.put("user", this.environment.userNick);
                aVar.f4696c.put(Constants.KEY_APP_KEY, this.environment.appKey);
                aVar.f4696c.put("appVersion", this.environment.appVersion);
            }
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("set base info failure", e2);
        }
    }

    private void a(CrashReportDataForSave crashReportDataForSave) {
        try {
            String strI = this.f4680b.i();
            String strA = this.f4680b.a(crashReportDataForSave.triggeredTime.longValue());
            crashReportDataForSave.path = String.format("%s/%s%s", strI, strA, this.f4680b.j());
            crashReportDataForSave.fileName = strA;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("set crash report file path err", e2);
        }
    }

    private String a(com.alibaba.sdk.android.man.crashreporter.a.c.a.a aVar, ReporterConfigure reporterConfigure) {
        try {
            byte[] bArrA = new com.alibaba.sdk.android.man.crashreporter.a.c.b().a(aVar, this.f4679a, a(reporterConfigure.enableMaxThreadNumber, reporterConfigure.enableMaxThreadStackTraceNumber, reporterConfigure.enableSysLogcatMaxCount, reporterConfigure.enableSysLogcatLinkMaxCount));
            if (bArrA == null) {
                com.alibaba.sdk.android.man.crashreporter.b.a.e("reporter build failure!");
            }
            return com.alibaba.sdk.android.man.crashreporter.e.b.b(bArrA);
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("reporter build err!", e2);
            return null;
        }
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.b
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo38a(String str) {
        if (str == null) {
            return "";
        }
        String str2 = null;
        try {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                str2 = new String(bArr, StringUtils.GB2312);
                e.i(str);
            }
            return str2 != null ? str2 : "";
        } catch (FileNotFoundException e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("native file not found err!", e2);
            return "";
        } catch (Exception e3) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("get native stack trace err!", e3);
            return "";
        }
    }

    private String a(ReporterConfigure reporterConfigure, CrashReportDataForSave crashReportDataForSave) {
        String strB;
        BaseDataContent baseDataContentA;
        try {
            HashMap map = new HashMap();
            com.alibaba.sdk.android.man.crashreporter.a.d.a.a(map, this.f4679a);
            com.alibaba.sdk.android.man.crashreporter.a.a.b bVar = this.f78a;
            if (bVar != null) {
                String strB2 = bVar.b();
                if (strB2 == null) {
                    strB2 = "no status info";
                }
                map.put("appStatus", strB2);
            }
            Integer numValueOf = Integer.valueOf((!reporterConfigure.enableDeduplication || (baseDataContentA = this.f79a.a()) == null) ? 1 : baseDataContentA.times.intValue());
            crashReportDataForSave.times = numValueOf;
            if (numValueOf != null) {
                if (numValueOf.intValue() > 1) {
                    map.put("ts", String.format("%s", Integer.valueOf(crashReportDataForSave.times.intValue() - 1)));
                } else {
                    map.put("ts", "1");
                }
            }
            String strB3 = com.alibaba.sdk.android.man.crashreporter.a.c.a.b(map);
            strB = strB3 != null ? com.alibaba.sdk.android.man.crashreporter.e.b.b(strB3.getBytes()) : null;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("getMetaData err!", e2);
        }
        if (strB != null) {
            return strB;
        }
        return null;
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.b
    public void a(Map map, String str, String str2, String str3) {
        this.f80a = map;
        this.f82n = str;
        this.o = str2;
        this.p = str3;
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.b
    public CrashReportDataForSave a(String str, String str2, String str3, Map map) {
        try {
            ReporterConfigure configure = MotuCrashReporter.getInstance().getConfigure();
            k = 0;
            l = 0;
            m = 400;
            n = 200;
            a(configure, 0, 0, 400, 200);
            com.alibaba.sdk.android.man.crashreporter.a.b.a aVarA = com.alibaba.sdk.android.man.crashreporter.a.b.a.a("", false);
            com.alibaba.sdk.android.man.crashreporter.a.b.b bVar = new com.alibaba.sdk.android.man.crashreporter.a.b.b();
            String strA = a(configure, aVarA, bVar);
            String strA2 = a(aVarA, bVar);
            com.alibaba.sdk.android.man.crashreporter.a.c.a.a aVar = new com.alibaba.sdk.android.man.crashreporter.a.c.a.a();
            CrashReportDataForSave crashReportDataForSave = new CrashReportDataForSave();
            crashReportDataForSave.triggeredTime = Long.valueOf(System.currentTimeMillis());
            crashReportDataForSave.toUTCrashMsg = str3;
            crashReportDataForSave.hashCode = String.format("%s", Integer.valueOf(i.a(str2)));
            crashReportDataForSave.type = 0;
            a(crashReportDataForSave);
            a(aVar);
            CrashReportDataForSave crashReportDataForSaveA = a(crashReportDataForSave.type.intValue(), configure, crashReportDataForSave.hashCode, crashReportDataForSave.path, this.environment.userNick);
            if (crashReportDataForSaveA != null) {
                return crashReportDataForSaveA;
            }
            aVar.f4696c.put("triggeredTime", crashReportDataForSave.triggeredTime);
            aVar.f4696c.put("exception", str);
            aVar.f4696c.put("backtrace", str2);
            aVar.f4696c.put("threads", strA);
            aVar.f4696c.put("currentThread", strA2);
            if (m36a()) {
                aVar.f4696c.put("isMainThread", Boolean.TRUE);
            } else {
                aVar.f4696c.put("isMainThread", Boolean.FALSE);
            }
            aVar.f4696c.put("type", "ANDROID");
            aVar.f4696c.put(AgooConstants.MESSAGE_EXT, com.alibaba.sdk.android.man.crashreporter.a.c.a.b((Map<String, String>) map));
            crashReportDataForSave.content = a(aVar, configure);
            crashReportDataForSave.metaDataBase64 = a(configure, crashReportDataForSave);
            crashReportDataForSave.utPage = a();
            com.alibaba.sdk.android.man.crashreporter.b.a.e("build java crash data end!");
            this.f4680b.b(crashReportDataForSave);
            return crashReportDataForSave;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("buildJavaCrashReport err!", e2);
            return null;
        }
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.b
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public CrashReportDataForSave mo37a() {
        return b(null, null, null, null);
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.b
    public CrashReportDataForSave a(String str) {
        com.alibaba.sdk.android.man.crashreporter.a.b.a aVarA;
        try {
            ReporterConfigure configure = MotuCrashReporter.getInstance().getConfigure();
            k = 30;
            l = 5;
            m = 60;
            n = 20;
            a(configure, 30, 5, 60, 20);
            if (str != null) {
                aVarA = com.alibaba.sdk.android.man.crashreporter.a.b.a.a(str, false);
            } else {
                aVarA = com.alibaba.sdk.android.man.crashreporter.a.b.a.a();
            }
            com.alibaba.sdk.android.man.crashreporter.a.b.b bVar = new com.alibaba.sdk.android.man.crashreporter.a.b.b();
            String string = aVarA.toString();
            String strA = bVar.a(aVarA.c());
            String strA2 = bVar.a(com.alibaba.sdk.android.man.crashreporter.a.b.a.e());
            com.alibaba.sdk.android.man.crashreporter.a.c.a.a aVar = new com.alibaba.sdk.android.man.crashreporter.a.c.a.a();
            CrashReportDataForSave crashReportDataForSave = new CrashReportDataForSave();
            crashReportDataForSave.triggeredTime = Long.valueOf(System.currentTimeMillis());
            crashReportDataForSave.type = 2;
            a(crashReportDataForSave);
            a(aVar);
            aVar.f4696c.put("triggeredTime", crashReportDataForSave.triggeredTime);
            aVar.f4696c.put("exception", string);
            aVar.f4696c.put("threads", strA);
            aVar.f4696c.put("backtrace", strA2);
            aVar.f4696c.put("isMainThread", Boolean.TRUE);
            aVar.f4696c.put("type", "ANDROID_ANR");
            crashReportDataForSave.content = a(aVar, configure);
            crashReportDataForSave.metaDataBase64 = a(configure, crashReportDataForSave);
            crashReportDataForSave.utPage = a();
            com.alibaba.sdk.android.man.crashreporter.b.a.e("build stuck data end!");
            this.f4680b.b(crashReportDataForSave);
            return crashReportDataForSave;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("buildStuckReport err!", e2);
            return null;
        }
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.b
    public void a(ReporterConfigure reporterConfigure, BaseDataContent baseDataContent, int i2) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (baseDataContent == null || !reporterConfigure.enableAbortCount) {
                if (reporterConfigure.enableAbortCount && i2 == 1) {
                    com.alibaba.sdk.android.man.crashreporter.b.a.e("abort content APPLICATION_STARTED");
                    BaseDataContent baseDataContent2 = new BaseDataContent();
                    baseDataContent2.appVersion = this.environment.appVersion;
                    baseDataContent2.abortFlag = String.format("%s%s", com.alibaba.sdk.android.man.crashreporter.b.f92f, Long.valueOf(jCurrentTimeMillis));
                    return;
                }
                return;
            }
            if (i2 == 0) {
                String str = baseDataContent.abortFlag;
                if (str != null && !str.contains(com.alibaba.sdk.android.man.crashreporter.b.f91e)) {
                    baseDataContent.abortFlag = String.format("%s%s%s", str, com.alibaba.sdk.android.man.crashreporter.b.f91e, Long.valueOf(jCurrentTimeMillis));
                    return;
                } else {
                    if (str == null) {
                        baseDataContent.abortFlag = String.format("%s%s", com.alibaba.sdk.android.man.crashreporter.b.f91e, Long.valueOf(jCurrentTimeMillis));
                        return;
                    }
                    return;
                }
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    com.alibaba.sdk.android.man.crashreporter.b.a.e("remove abort content flag ");
                    if (baseDataContent.abortFlag == null) {
                        return;
                    }
                    baseDataContent.abortFlag = null;
                    return;
                }
                return;
            }
            com.alibaba.sdk.android.man.crashreporter.b.a.e("abort content APPLICATION_STARTED");
            String str2 = baseDataContent.abortFlag;
            if (str2 == null || !str2.contains(com.alibaba.sdk.android.man.crashreporter.b.f92f)) {
                baseDataContent.appVersion = this.environment.appVersion;
                baseDataContent.abortFlag = String.format("%s%s", com.alibaba.sdk.android.man.crashreporter.b.f92f, Long.valueOf(jCurrentTimeMillis));
            }
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("build abort flag failure!", e2);
        }
    }

    private CrashReportDataForSave a(int i2, ReporterConfigure reporterConfigure, String str, String str2, String str3) {
        if (i2 == 2) {
            return null;
        }
        BaseDataContent baseDataContentA = this.f79a.a();
        if (baseDataContentA != null) {
            try {
                a(reporterConfigure, baseDataContentA, 0);
                baseDataContentA.userNick = str3;
                baseDataContentA.appVersion = this.environment.appVersion;
                if (!reporterConfigure.enableDeduplication) {
                    baseDataContentA.path = null;
                    baseDataContentA.times = 0;
                    baseDataContentA.hashCode = null;
                    this.f79a.a(baseDataContentA);
                    return null;
                }
                String str4 = baseDataContentA.hashCode;
                String str5 = baseDataContentA.path;
                Integer num = baseDataContentA.times;
                if (str4 != null && num.intValue() != 0 && str.equals(str4)) {
                    if (num.intValue() == 1) {
                        baseDataContentA.hashCode = str4;
                        baseDataContentA.times = Integer.valueOf(num.intValue() + 1);
                        baseDataContentA.path = str2;
                        this.f79a.a(baseDataContentA);
                    } else if (num.intValue() >= 2) {
                        baseDataContentA.hashCode = str4;
                        Integer numValueOf = Integer.valueOf(num.intValue() + 1);
                        baseDataContentA.times = numValueOf;
                        baseDataContentA.path = str5;
                        this.f79a.a(baseDataContentA);
                        CrashReportDataForSave crashReportDataForSaveA = this.f4680b.a(str5, numValueOf.intValue());
                        if (crashReportDataForSaveA != null) {
                            return crashReportDataForSaveA;
                        }
                        this.f79a.b(true);
                        return null;
                    }
                } else {
                    baseDataContentA.hashCode = str;
                    baseDataContentA.times = 1;
                    baseDataContentA.path = str2;
                    this.f79a.a(baseDataContentA);
                }
            } catch (Exception e2) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("parse base data file error.", e2);
            }
        } else {
            BaseDataContent baseDataContent = new BaseDataContent();
            baseDataContent.abortFlag = String.format("%s%s", com.alibaba.sdk.android.man.crashreporter.b.f91e, Long.valueOf(System.currentTimeMillis()));
            baseDataContent.path = str2;
            baseDataContent.times = 1;
            baseDataContent.appVersion = this.environment.appVersion;
            baseDataContent.userNick = str3;
            baseDataContent.hashCode = str;
            this.f79a.a(baseDataContent);
        }
        return null;
    }
}
