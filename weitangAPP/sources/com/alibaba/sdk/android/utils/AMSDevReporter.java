package com.alibaba.sdk.android.utils;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class AMSDevReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f5022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ExecutorService f123a = Executors.newSingleThreadExecutor(new a());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ConcurrentHashMap<AMSSdkTypeEnum, AMSReportStatusEnum> f122a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f124a = false;
    private static String TAG = "AMSDevReporter";

    public enum AMSReportStatusEnum {
        UNREPORTED,
        REPORTED
    }

    public enum AMSSdkExtInfoKeyEnum {
        AMS_EXTINFO_KEY_VERSION("SdkVersion"),
        AMS_EXTINFO_KEY_PACKAGE("PackageName");

        private String description;

        AMSSdkExtInfoKeyEnum(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    public enum AMSSdkTypeEnum {
        AMS_MAN("MAN"),
        AMS_HTTPDNS("HTTPDNS"),
        AMS_MPUSH("MPUSH"),
        AMS_MAC("MAC"),
        AMS_API("API"),
        AMS_HOTFIX("HOTFIX"),
        AMS_FEEDBACK("FEEDBACK"),
        AMS_IM("IM");

        private String description;

        AMSSdkTypeEnum(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    static {
        for (AMSSdkTypeEnum aMSSdkTypeEnum : AMSSdkTypeEnum.values()) {
            f122a.put(aMSSdkTypeEnum, AMSReportStatusEnum.UNREPORTED);
        }
    }

    public static void asyncReport(Context context, AMSSdkTypeEnum aMSSdkTypeEnum) {
        asyncReport(context, aMSSdkTypeEnum, null);
    }

    public static AMSReportStatusEnum getReportStatus(AMSSdkTypeEnum aMSSdkTypeEnum) {
        return f122a.get(aMSSdkTypeEnum);
    }

    public static void setLogEnabled(boolean z) {
        d.setLogEnabled(z);
    }

    public static void asyncReport(Context context, final AMSSdkTypeEnum aMSSdkTypeEnum, final Map<String, Object> map) {
        if (context == null) {
            d.c(TAG, "Context is null, return.");
            return;
        }
        f5022a = context;
        d.b(TAG, "Add [" + aMSSdkTypeEnum.toString() + "] to report queue.");
        f124a = false;
        f123a.execute(new Runnable() { // from class: com.alibaba.sdk.android.utils.AMSDevReporter.1
            @Override // java.lang.Runnable
            public void run() {
                if (AMSDevReporter.f124a) {
                    d.c(AMSDevReporter.TAG, "Unable to execute remain task in queue, return.");
                    return;
                }
                d.b(AMSDevReporter.TAG, "Get [" + aMSSdkTypeEnum.toString() + "] from report queue.");
                AMSDevReporter.a(aMSSdkTypeEnum, (Map<String, Object>) map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AMSSdkTypeEnum aMSSdkTypeEnum, Map<String, Object> map) {
        String string = aMSSdkTypeEnum.toString();
        if (f122a.get(aMSSdkTypeEnum) != AMSReportStatusEnum.UNREPORTED) {
            d.b(TAG, "[" + string + "] already reported, return.");
            return;
        }
        int i2 = 0;
        int i3 = 5;
        while (true) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Report [");
            sb.append(string);
            sb.append("], times: [");
            i2++;
            sb.append(i2);
            sb.append("].");
            d.b(str, sb.toString());
            if (!m57a(aMSSdkTypeEnum, map)) {
                if (i2 <= 10) {
                    d.b(TAG, "Report [" + string + "] failed, wait for [" + i3 + "] seconds.");
                    e.a((double) i3);
                    i3 *= 2;
                    if (i3 >= 60) {
                        i3 = 60;
                    }
                } else {
                    d.c(TAG, "Report [" + string + "] stat failed, exceed max retry times, return.");
                    f122a.put(aMSSdkTypeEnum, AMSReportStatusEnum.UNREPORTED);
                    f124a = true;
                    break;
                }
            } else {
                d.b(TAG, "Report [" + string + "] stat success.");
                f122a.put(aMSSdkTypeEnum, AMSReportStatusEnum.REPORTED);
                break;
            }
        }
        if (f124a) {
            d.c(TAG, "Report [" + string + "] failed, clear remain report in queue.");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:11|83|12|(3:13|(1:15)(1:89)|61)|16|80|17|(4:19|74|20|24)|27) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x015c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x015d, code lost:
    
        com.alibaba.sdk.android.utils.d.a(com.alibaba.sdk.android.utils.AMSDevReporter.TAG, r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01da A[Catch: IOException -> 0x01d6, TRY_LEAVE, TryCatch #2 {IOException -> 0x01d6, blocks: (B:66:0x01d2, B:70:0x01da), top: B:76:0x01d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m57a(com.alibaba.sdk.android.utils.AMSDevReporter.AMSSdkTypeEnum r10, java.util.Map<java.lang.String, java.lang.Object> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.utils.AMSDevReporter.m57a(com.alibaba.sdk.android.utils.AMSDevReporter$AMSSdkTypeEnum, java.util.Map):boolean");
    }

    private static String a(AMSSdkTypeEnum aMSSdkTypeEnum, String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(aMSSdkTypeEnum);
        sb.append("-");
        sb.append(str);
        if (map != null) {
            String str2 = (String) map.get(AMSSdkExtInfoKeyEnum.AMS_EXTINFO_KEY_VERSION.toString());
            if (!e.m64a(str2)) {
                sb.append("-");
                sb.append(str2);
            }
            String str3 = (String) map.get(AMSSdkExtInfoKeyEnum.AMS_EXTINFO_KEY_PACKAGE.toString());
            if (!e.m64a(str3)) {
                sb.append("-");
                sb.append(str3);
            }
        }
        return sb.toString();
    }
}
