package c.e.c.m0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import c.e.a.d.x;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.comment.CommentActivity;
import com.chinavisionary.microtang.msg.MsgActivity;
import com.chinavisionary.microtang.room.RoomDetailsActivity;
import com.chinavisionary.microtang.web.WebViewActivity;
import com.chinavisionary.paymentlibrary.PayTypeActivity;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile h f1692a;

    public static h getInstance() {
        if (f1692a == null) {
            synchronized (h.class) {
                if (f1692a == null) {
                    f1692a = new h();
                }
            }
        }
        return f1692a;
    }

    public final boolean a(String str) {
        if (x.isNotNull(str)) {
            return str.endsWith(".apk");
        }
        return false;
    }

    public final boolean b(String str) {
        if (x.isNotNull(str)) {
            return str.indexOf("http://") == 0 || str.indexOf("https://") == 0;
        }
        return false;
    }

    public final void e(String str, String str2, Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) CommentActivity.class);
        intent.putExtra("key", str);
        intent.putExtra("title", str2);
        activity.startActivity(intent);
    }

    public final void f(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            intent.resolveActivity(context.getPackageManager());
            context.startActivity(Intent.createChooser(intent, x.getString(R.string.title_select_browser)));
        }
    }

    public final void g(String str, String str2, Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) CommentActivity.class);
        intent.putExtra("key", str);
        intent.putExtra("title", str2);
        activity.startActivity(intent);
    }

    public final void h(String str, String str2, Activity activity) {
        if (b(str)) {
            m(str, activity, str2, false);
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) PayTypeActivity.class);
        PayTypeVo payTypeVo = new PayTypeVo();
        payTypeVo.setType(18);
        payTypeVo.setPrice("");
        payTypeVo.setResStrId(R.string.title_pay_food_fee);
        payTypeVo.setBaseKey(str);
        intent.setFlags(268435456);
        intent.putExtra("key", JSON.toJSONString(payTypeVo));
        activity.startActivity(intent);
    }

    public void handleForwardToType(Activity activity, int i2, String str, String str2) {
        if (activity == null || !x.isNotNull(str)) {
            return;
        }
        if (i2 == 0) {
            l(str, activity);
        }
        if (i2 == 15) {
            k(str, str2, activity);
            return;
        }
        if (i2 == 18) {
            j(str, str2, activity);
            return;
        }
        if (i2 == 1000) {
            e(str, str2, activity);
            return;
        }
        if (i2 == 2000) {
            m(c.e.c.r.a.appendH5BaseUrl(str), activity, str2, false);
            return;
        }
        switch (i2) {
            case 2:
                h(str, str2, activity);
                break;
            case 3:
                m(str, activity, str2, true);
                break;
            case 4:
                g(str, str2, activity);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                i(str, str2, activity);
                break;
            default:
                m(str, activity, str2, false);
                break;
        }
    }

    public final void i(String str, String str2, Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) MsgActivity.class);
        intent.putExtra("key", str);
        intent.putExtra("title", str2);
        activity.startActivity(intent);
    }

    public final void j(String str, String str2, final Activity activity) {
        if (m.openAliPayMiniApp(str, str2, activity) || activity == null) {
            return;
        }
        try {
            activity.runOnUiThread(new Runnable() { // from class: c.e.c.m0.b
                @Override // java.lang.Runnable
                public final void run() {
                    Toast.makeText(activity, R.string.tip_open_alipay_failed, 0).show();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void k(String str, String str2, final Activity activity) {
        if (new m().openWXProgram(activity, str, str2) || activity == null) {
            return;
        }
        try {
            activity.runOnUiThread(new Runnable() { // from class: c.e.c.m0.a
                @Override // java.lang.Runnable
                public final void run() {
                    Toast.makeText(activity, R.string.tip_open_failed_param_failed, 0).show();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void l(String str, Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) RoomDetailsActivity.class);
        intent.putExtra("key", str);
        intent.putExtra("goodsKey", str);
        intent.setFlags(268435456);
        activity.startActivity(intent);
    }

    public final void m(String str, Activity activity, String str2, boolean z) {
        if (x.isNotNull(str)) {
            if (a(str)) {
                f(activity, str);
                return;
            }
            Intent intent = new Intent(activity, (Class<?>) WebViewActivity.class);
            intent.setFlags(268435456);
            String string = x.getString(R.string.title_web);
            if (x.isNotNull(str) && b(str)) {
                intent.putExtra("key", str);
            } else {
                intent.putExtra("content", str);
            }
            intent.putExtra("isArticle", z);
            intent.putExtra("titleKey", x.getNotNullStr(str2, string));
            activity.startActivity(intent);
        }
    }
}
