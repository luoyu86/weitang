package com.tianmu.biz.utils;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.alibaba.android.arouter.utils.Consts;
import com.tianmu.TianmuSDK;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static void a(String str, boolean z) {
        a(a(str), z);
    }

    public static String b(String str) {
        try {
            return com.tianmu.c.h.b.a.a(str, TianmuSDK.getInstance().getContext());
        } catch (Exception unused) {
            return null;
        }
    }

    public static Intent c(String str) {
        try {
            return TianmuSDK.getInstance().getContext().getPackageManager().getLaunchIntentForPackage(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean d(String str) {
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            TianmuSDK.getInstance().getContext().startActivity(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void a(File file, boolean z) {
        if (file == null || !file.exists()) {
            if (z) {
                s0.a("文件不存在或已被删除");
                return;
            }
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            if (Build.VERSION.SDK_INT >= 24) {
                Uri uriForFile = FileProvider.getUriForFile(TianmuSDK.getInstance().getContext(), TianmuSDK.getInstance().getContext().getPackageName() + Consts.DOT + "tianmu.fileprovider", file);
                intent.addFlags(1);
                intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            }
            TianmuSDK.getInstance().getContext().startActivity(intent);
        } catch (Exception e2) {
            if (z) {
                s0.a("安装失败了");
            }
            e2.printStackTrace();
        }
    }

    public static boolean a(String str, String str2) {
        try {
            Intent intentC = c(str);
            if (intentC == null) {
                return false;
            }
            if (!TextUtils.isEmpty(str2)) {
                intentC.setData(Uri.parse(str2));
            }
            intentC.setFlags(268435456);
            TianmuSDK.getInstance().getContext().startActivity(intentC);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            s0.a("启动APP失败了");
            return false;
        }
    }

    public static File a(String str) {
        try {
            return new File(b(str));
        } catch (Exception unused) {
            return null;
        }
    }
}
