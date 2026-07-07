package com.alibaba.sdk.android.utils.crashdefend;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.accs.common.Constants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static void a(Context context, a aVar, List<c> list) {
        String str;
        String str2;
        if (context == null) {
            return;
        }
        synchronized (list) {
            FileOutputStream fileOutputStreamOpenFileOutput = null;
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (aVar != null) {
                        jSONObject.put("startSerialNumber", aVar.f5031a);
                    }
                    try {
                        JSONArray jSONArray = new JSONArray();
                        for (c cVar : list) {
                            if (cVar != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("sdkId", cVar.f138a);
                                jSONObject2.put(Constants.KEY_SDK_VERSION, cVar.f140b);
                                jSONObject2.put("crashLimit", cVar.f5037a);
                                jSONObject2.put("crashCount", cVar.crashCount);
                                jSONObject2.put("waitTime", cVar.f5038b);
                                jSONObject2.put("registerSerialNumber", cVar.f139b);
                                jSONObject2.put("startSerialNumber", cVar.f136a);
                                jSONObject2.put("restoreCount", cVar.f5039c);
                                jSONArray.put(jSONObject2);
                            }
                        }
                        jSONObject.put("sdkList", jSONArray);
                    } catch (JSONException e2) {
                        Log.e("CrashUtils", "save sdk json fail:", e2);
                    }
                    String string = jSONObject.toString();
                    fileOutputStreamOpenFileOutput = m62a(context) ? context.openFileOutput("com_alibaba_aliyun_crash_defend_sdk_info", 0) : context.openFileOutput("com_alibaba_aliyun_crash_defend_sdk_info_" + a(context), 0);
                    fileOutputStreamOpenFileOutput.write(string.getBytes());
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e3) {
                        e = e3;
                        str = "CrashUtils";
                        str2 = "save sdk io fail:";
                        Log.e(str, str2, e);
                    }
                } catch (IOException e4) {
                    Log.e("CrashUtils", "save sdk io fail:", e4);
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException e5) {
                            e = e5;
                            str = "CrashUtils";
                            str2 = "save sdk io fail:";
                            Log.e(str, str2, e);
                        }
                    }
                } catch (Exception e6) {
                    Log.e("CrashUtils", "save sdk exception:", e6);
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException e7) {
                            e = e7;
                            str = "CrashUtils";
                            str2 = "save sdk io fail:";
                            Log.e(str, str2, e);
                        }
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m63a(Context context, a aVar, List<c> list) {
        String str;
        String str2;
        if (context == null) {
            return false;
        }
        FileInputStream fileInputStreamOpenFileInput = null;
        StringBuilder sb = new StringBuilder();
        synchronized (list) {
            try {
                try {
                    try {
                        fileInputStreamOpenFileInput = m62a(context) ? context.openFileInput("com_alibaba_aliyun_crash_defend_sdk_info") : context.openFileInput("com_alibaba_aliyun_crash_defend_sdk_info_" + a(context));
                        byte[] bArr = new byte[512];
                        while (true) {
                            int i2 = fileInputStreamOpenFileInput.read(bArr);
                            if (i2 != -1) {
                                sb.append(new String(bArr, 0, i2));
                            } else {
                                try {
                                    break;
                                } catch (IOException e2) {
                                    e = e2;
                                    str = "CrashUtils";
                                    str2 = "load sdk io fail:";
                                    Log.e(str, str2, e);
                                }
                            }
                        }
                        fileInputStreamOpenFileInput.close();
                    } catch (FileNotFoundException e3) {
                        Log.e("CrashUtils", "load sdk file fail:", e3);
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                            } catch (IOException e4) {
                                e = e4;
                                str = "CrashUtils";
                                str2 = "load sdk io fail:";
                                Log.e(str, str2, e);
                            }
                        }
                    } catch (Exception e5) {
                        Log.e("CrashUtils", "load sdk exception:", e5);
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                            } catch (IOException e6) {
                                e = e6;
                                str = "CrashUtils";
                                str2 = "load sdk io fail:";
                                Log.e(str, str2, e);
                            }
                        }
                    }
                } catch (IOException e7) {
                    Log.e("CrashUtils", "load sdk io fail:", e7);
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (IOException e8) {
                            e = e8;
                            str = "CrashUtils";
                            str2 = "load sdk io fail:";
                            Log.e(str, str2, e);
                        }
                    }
                }
                if (sb.length() == 0) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(sb.toString());
                    aVar.f5031a = jSONObject.optLong("startSerialNumber", 1L);
                    JSONArray jSONArray = jSONObject.getJSONArray("sdkList");
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        if (jSONObject2 != null) {
                            c cVar = new c();
                            cVar.f138a = jSONObject2.optString("sdkId", "");
                            cVar.f140b = jSONObject2.optString(Constants.KEY_SDK_VERSION, "");
                            cVar.f5037a = jSONObject2.optInt("crashLimit", -1);
                            cVar.crashCount = jSONObject2.optInt("crashCount", 0);
                            cVar.f5038b = jSONObject2.optInt("waitTime", 0);
                            cVar.f139b = jSONObject2.optLong("registerSerialNumber", 0L);
                            cVar.f136a = jSONObject2.optLong("startSerialNumber", 0L);
                            cVar.f5039c = jSONObject2.optInt("restoreCount", 0);
                            if (!TextUtils.isEmpty(cVar.f138a)) {
                                list.add(cVar);
                            }
                        }
                    }
                } catch (JSONException e9) {
                    Log.e("CrashUtils", "load sdk json fail:", e9);
                } catch (Exception e10) {
                    Log.e("CrashUtils", "load sdk exception:", e10);
                }
                return true;
            } finally {
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m62a(Context context) {
        return context.getPackageName().equalsIgnoreCase(a(context));
    }

    private static String a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return "";
        }
        int iMyPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }
}
