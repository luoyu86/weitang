package cn.admobiletop.adsuyi.util;

import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiTLogUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SimpleDateFormat f4353a = new SimpleDateFormat("yyyy-MM-dd");

    public static void createLogCollector(final String str) {
        if (str == null) {
            Log.d("LogUtils", "未设置path");
        } else {
            new Thread() { // from class: cn.admobiletop.adsuyi.util.ADSuyiTLogUtil.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    super.run();
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(ADSuyiTLogUtil.f4353a.format(Calendar.getInstance().getTime()));
                        sb.append(".txt");
                        String string = sb.toString();
                        try {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add("logcat");
                            arrayList.add("-f");
                            arrayList.add(string);
                            arrayList.add("-v");
                            arrayList.add("time");
                            arrayList.add("ADSuyiLog:I");
                            arrayList.add("System.err:W");
                            arrayList.add("System.out:I");
                            arrayList.add("AndroidRuntime:E");
                            arrayList.add("ADSuyiLog:V");
                            arrayList.add("ADSuyiLog:D");
                            arrayList.add("*:S");
                            try {
                                Runtime.getRuntime().exec((String[]) arrayList.toArray(new String[arrayList.size()]));
                                Thread.sleep(1000L);
                            } catch (Exception e2) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("CollectorThread == >");
                                sb2.append(e2.getMessage());
                                Log.e("ADSuyiLog", sb2.toString(), e2);
                            }
                        } catch (Exception unused) {
                            try {
                                Thread.sleep(100L);
                            } catch (InterruptedException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (Exception e4) {
                        Log.d("ADSuyiLog", e4.getMessage());
                    }
                    Log.d("ADSuyiLog", "收集日志循环已完全启动!!!");
                }
            }.start();
        }
    }
}
