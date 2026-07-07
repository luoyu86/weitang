package c.e.e.a.x;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.StringRes;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    public static String appendStringToResId(int i2, String str) {
        return String.format(getString(i2), str);
    }

    public static String bigDecimalToString(BigDecimal bigDecimal) {
        return bigDecimal != null ? bigDecimal.setScale(2, 4).toPlainString() : "";
    }

    public static String getNotNullStr(String str, String str2) {
        return !isNullStr(str) ? str : isNullStr(str2) ? "" : str2;
    }

    @SuppressLint({"ResourceType"})
    public static String getString(@StringRes int i2) {
        return i2 <= 0 ? "" : g.getInstance().getString(i2);
    }

    public static boolean isNotNull(String str) {
        return !isNullStr(str);
    }

    public static boolean isNullStr(String str) {
        return str == null || "".equals(str.trim()) || "null".equals(str) || str.length() == 0;
    }

    public static String getNotNullStr(CharSequence charSequence, String str) {
        return !TextUtils.isEmpty(charSequence) ? charSequence.toString() : isNullStr(str) ? "" : str;
    }

    public static String getString(@StringRes int i2, Object... objArr) {
        return g.getInstance().getResources().getString(i2, objArr);
    }
}
