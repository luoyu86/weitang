package anet.channel.strategy;

import android.content.Context;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.statist.StrategyStatObject;
import anet.channel.util.ALog;
import anet.channel.util.SerializeHelper;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static File f691a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f692b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Comparator<File> f693c = new n();

    public static void a(Context context) {
        if (context != null) {
            try {
                File file = new File(context.getFilesDir(), "awcn_strategy");
                f691a = file;
                if (!a(file)) {
                    ALog.e("awcn.StrategySerializeHelper", "create directory failed!!!", null, "dir", f691a.getAbsolutePath());
                }
                if (!GlobalAppRuntimeInfo.isTargetProcess()) {
                    String currentProcess = GlobalAppRuntimeInfo.getCurrentProcess();
                    File file2 = new File(f691a, currentProcess.substring(currentProcess.indexOf(58) + 1));
                    f691a = file2;
                    if (!a(file2)) {
                        ALog.e("awcn.StrategySerializeHelper", "create directory failed!!!", null, "dir", f691a.getAbsolutePath());
                    }
                }
                ALog.i("awcn.StrategySerializeHelper", "StrateyFolder", null, "path", f691a.getAbsolutePath());
                if (!f692b) {
                    c();
                } else {
                    a();
                    f692b = false;
                }
            } catch (Throwable th) {
                ALog.e("awcn.StrategySerializeHelper", "StrategySerializeHelper initialize failed!!!", null, th, new Object[0]);
            }
        }
    }

    public static synchronized File[] b() {
        File file = f691a;
        if (file == null) {
            return null;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            Arrays.sort(fileArrListFiles, f693c);
        }
        return fileArrListFiles;
    }

    public static synchronized void c() {
        File[] fileArrB = b();
        if (fileArrB == null) {
            return;
        }
        int i2 = 0;
        for (File file : fileArrB) {
            if (!file.isDirectory()) {
                if (System.currentTimeMillis() - file.lastModified() > 172800000) {
                    file.delete();
                } else if (file.getName().startsWith("WIFI")) {
                    int i3 = i2 + 1;
                    if (i2 > 10) {
                        file.delete();
                    }
                    i2 = i3;
                }
            }
        }
    }

    private static boolean a(File file) {
        if (file == null || file.exists()) {
            return true;
        }
        return file.mkdir();
    }

    public static File a(String str) {
        a(f691a);
        return new File(f691a, str);
    }

    public static synchronized void a() {
        ALog.i("awcn.StrategySerializeHelper", "clear start.", null, new Object[0]);
        File file = f691a;
        if (file == null) {
            ALog.w("awcn.StrategySerializeHelper", "folder path not initialized, wait to clear", null, new Object[0]);
            f692b = true;
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                file2.delete();
            }
        }
        ALog.i("awcn.StrategySerializeHelper", "clear end.", null, new Object[0]);
    }

    public static synchronized void a(Serializable serializable, String str, StrategyStatObject strategyStatObject) {
        SerializeHelper.persist(serializable, a(str), strategyStatObject);
    }

    public static synchronized <T> T a(String str, StrategyStatObject strategyStatObject) {
        return (T) SerializeHelper.restore(a(str), strategyStatObject);
    }
}
