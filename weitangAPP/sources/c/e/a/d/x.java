package c.e.a.d;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.StringRes;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class x {
    public static String a(int i2) {
        StringBuilder sb = new StringBuilder(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("*");
        }
        return sb.toString();
    }

    public static String appendStringToResId(int i2, String str) {
        return String.format(getString(i2), str);
    }

    public static String bigDecimalAdd(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal != null ? bigDecimal2 != null ? bigDecimal.add(bigDecimal2).setScale(2, 4).toPlainString() : bigDecimal.setScale(2, 4).toPlainString() : "";
    }

    public static BigDecimal bigDecimalAddToBigDecimal(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        if (bigDecimal != null) {
            return bigDecimal2 != null ? bigDecimal.add(bigDecimal2).setScale(2, 4) : bigDecimal.setScale(2, 4);
        }
        return null;
    }

    public static BigDecimal bigDecimalMultiplyToBigDecimal(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        if (bigDecimal != null) {
            return bigDecimal2 != null ? bigDecimal.multiply(bigDecimal2).setScale(2, 4) : bigDecimal.setScale(2, 4);
        }
        return null;
    }

    public static String bigDecimalSubtract(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        return bigDecimal != null ? bigDecimal2 != null ? bigDecimal.subtract(bigDecimal2).setScale(2, 4).toPlainString() : bigDecimal.setScale(2, 4).toPlainString() : "";
    }

    public static String bigDecimalToPlainString(BigDecimal bigDecimal) {
        return bigDecimal != null ? bigDecimal.toPlainString() : "";
    }

    public static String bigDecimalToPlainStringAddRMBUnit(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return "";
        }
        return "(" + bigDecimalToPlainString(bigDecimal) + "元)";
    }

    public static String bigDecimalToPlainStringAddUnit(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return "";
        }
        return "￥" + bigDecimalToPlainString(bigDecimal);
    }

    public static String bigDecimalToString(BigDecimal bigDecimal) {
        return bigDecimal != null ? bigDecimal.setScale(2, 4).toPlainString() : "";
    }

    public static String bigDecimalToZeroPlainString(BigDecimal bigDecimal) {
        return bigDecimal != null ? bigDecimal.compareTo(BigDecimal.ZERO) == 0 ? "0" : bigDecimal.stripTrailingZeros().toPlainString() : "";
    }

    public static String bigDecimalToZerosPlainString(BigDecimal bigDecimal) {
        return bigDecimal != null ? bigDecimal.compareTo(BigDecimal.ZERO) == 0 ? "0" : bigDecimal.stripTrailingZeros().toPlainString() : "";
    }

    public static void copyTextToClipboard(String str) {
        ((ClipboardManager) c.e.a.a.b.getInstance().getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, String.valueOf(str)));
    }

    public static float doubleToFloat(Double d2) {
        if (d2 != null) {
            return d2.floatValue();
        }
        return 0.0f;
    }

    public static String formatSeconds(int i2) {
        String str;
        String str2;
        int i3 = i2 / 3600;
        int i4 = i2 % 3600;
        int i5 = i4 / 60;
        int i6 = i4 % 60;
        if (i3 > 0) {
            str = i3 + ":";
        } else {
            str = "";
        }
        if (i5 < 10) {
            str2 = str + "0" + i5 + ":";
        } else {
            str2 = str + i5 + ":";
        }
        if (i6 >= 10) {
            return str2 + i6;
        }
        return str2 + "0" + i6;
    }

    public static String getFormatMoney(double d2) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMaximumFractionDigits(2);
        numberInstance.setMinimumFractionDigits(2);
        numberInstance.setGroupingUsed(false);
        return numberInstance.format(d2);
    }

    public static String getIDNoMask(String str) {
        if (!isNotNull(str) || str.length() != 18) {
            return str;
        }
        StringBuilder sb = new StringBuilder(1);
        sb.append(str.substring(0, 1));
        sb.append("****************");
        sb.append(str.substring(str.length() - 1, str.length()));
        return sb.toString();
    }

    public static String getIntegerToString(Integer num) {
        return num != null ? num.toString() : "";
    }

    public static String getNameMask(String str) {
        if (!isNotNull(str)) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(1);
        sb.append(str);
        sb.replace(1, length, a(length - 1));
        return sb.toString();
    }

    public static String getNotNullStr(String str, String str2) {
        return !isNullStr(str) ? str : isNullStr(str2) ? "" : str2;
    }

    public static String getPhoneMask(String str) {
        if (!isNotNull(str) || !isMobile(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(1);
        sb.append(str);
        sb.replace(3, 7, "****");
        return sb.toString();
    }

    @SuppressLint({"ResourceType"})
    public static String getString(@StringRes int i2) {
        return i2 <= 0 ? "" : c.e.a.a.b.getInstance().getString(i2);
    }

    public static boolean isBigDecimal(BigDecimal bigDecimal) {
        if (bigDecimal != null) {
            try {
                return bigDecimal.floatValue() > 0.0f;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isChineseName(String str) {
        return Pattern.compile("^([\\u4e00-\\u9fa5]{1,20}|[a-zA-Z\\.\\s]{1,20})$").matcher(str).matches();
    }

    public static boolean isHttpUrl(String str) {
        return isNotNull(str) && str.indexOf("http") == 0;
    }

    public static boolean isMobile(String str) {
        return isNotNull(str) && str.length() == 11;
    }

    public static boolean isNotNull(String str) {
        return !isNullStr(str);
    }

    public static boolean isNullStr(String str) {
        return str == null || "".equals(str.trim()) || "null".equals(str) || str.length() == 0;
    }

    public static boolean isNumeric(String str) {
        return isNotNull(str) && Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static String spanTextColor(String str, int i2, int i3, int i4) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i4), i2, i3, 33);
        return spannableStringBuilder.toString();
    }

    public static String transPhoneNumber(String str) {
        try {
            int length = str.length();
            if (length != 11) {
                return "";
            }
            try {
                return str.substring(0, 3) + "****" + str.substring(length - 4, length);
            } catch (Exception unused) {
                return str;
            }
        } catch (Exception unused2) {
            return str;
        }
    }

    public static String trimAll(String str) {
        return isNotNull(str) ? str.replaceAll(" ", "") : str;
    }

    public static String trimAndUpperCase(String str) {
        return isNotNull(str) ? str.trim().toUpperCase() : str;
    }

    public static String getNotNullStr(CharSequence charSequence, String str) {
        return !TextUtils.isEmpty(charSequence) ? charSequence.toString() : isNullStr(str) ? "" : str;
    }

    public static String getString(@StringRes int i2, Object... objArr) {
        return c.e.a.a.b.getInstance().getResources().getString(i2, objArr);
    }
}
