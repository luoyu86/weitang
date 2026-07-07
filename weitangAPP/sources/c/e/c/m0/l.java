package c.e.c.m0;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.widget.TextView;
import c.e.a.d.x;
import com.alibaba.android.arouter.utils.Consts;
import com.chinavisionary.microtang.R;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbsoluteSizeSpan f1694a = new AbsoluteSizeSpan(12, true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbsoluteSizeSpan f1695b = new AbsoluteSizeSpan(12, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AbsoluteSizeSpan f1696c = new AbsoluteSizeSpan(10, true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AbsoluteSizeSpan f1697d = new AbsoluteSizeSpan(10, true);

    public static void setupMethodRentPrice(String str, TextView textView) {
        if (textView != null) {
            if (!x.isNotNull(str) || str.length() <= 3 || !str.contains("元/月起")) {
                textView.setText(x.getNotNullStr(str, ""));
                return;
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(f1696c, 0, 1, 17);
            spannableString.setSpan(f1697d, str.lastIndexOf("元"), str.length(), 17);
            textView.setText(spannableString);
            textView.setTextColor(textView.getResources().getColor(R.color.colorFE9900));
        }
    }

    public static void setupPrice(BigDecimal bigDecimal, TextView textView) {
        setupPrice(bigDecimal != null ? x.bigDecimalToPlainString(bigDecimal) : null, textView);
    }

    public static void setupPriceUnit(String str, TextView textView) {
        if (textView != null) {
            if (!x.isNotNull(str)) {
                textView.setText("");
                return;
            }
            if (!str.contains(x.getString(R.string.rmb_china_price_unit))) {
                str = x.appendStringToResId(R.string.rmb_placeholder, str);
            }
            textView.setText(str);
        }
    }

    public static void setupRentPrice(String str, TextView textView) {
        if (textView != null) {
            if (!x.isNotNull(str)) {
                textView.setText("");
                return;
            }
            try {
                textView.setText(x.bigDecimalToZeroPlainString(new BigDecimal(str)));
            } catch (Exception e2) {
                e2.printStackTrace();
                textView.setText(str);
            }
        }
    }

    public static void setupPrice(String str, TextView textView) {
        if (textView != null) {
            if (!x.isNotNull(str) || str.length() <= 3 || str.lastIndexOf(Consts.DOT) <= 0) {
                textView.setText("");
                return;
            }
            if (!str.contains(x.getString(R.string.rmb_china_price_unit))) {
                str = x.appendStringToResId(R.string.rmb_placeholder, str);
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(f1694a, 0, 1, 17);
            spannableString.setSpan(f1695b, str.lastIndexOf(Consts.DOT), str.length(), 17);
            textView.setText(spannableString);
            textView.setTextColor(textView.getResources().getColor(R.color.colorFE9900));
        }
    }
}
