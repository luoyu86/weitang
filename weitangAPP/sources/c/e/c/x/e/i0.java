package c.e.c.x.e;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.me.AboutAppActivity;
import com.chinavisionary.microtang.me.adapter.IncrementProductAdapter;
import com.chinavisionary.microtang.me.adapter.RoomGridSpecItemDecoration;
import com.chinavisionary.microtang.me.vo.CleanProductVo;
import com.chinavisionary.microtang.open.bo.AboutVo;
import com.chinavisionary.microtang.web.WebViewActivity;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i0 extends b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j0 f2156b;

    public i0(g0 g0Var) {
        super(g0Var);
        this.f2156b = new j0(g0Var);
    }

    public void c(BaseRecyclerAdapter<CleanProductVo> baseRecyclerAdapter, BaseRecyclerView baseRecyclerView) {
        List<AboutVo> listD = d(this.f2124a.getCurrentActivity());
        if (baseRecyclerAdapter instanceof IncrementProductAdapter) {
            ((IncrementProductAdapter) baseRecyclerAdapter).setAboutVos(listD);
        }
        ArrayList arrayList = new ArrayList();
        CleanProductVo cleanProductVo = new CleanProductVo();
        cleanProductVo.setName(c.e.a.d.x.getString(R.string.title_special_declaration));
        cleanProductVo.setType(26758);
        arrayList.add(cleanProductVo);
        baseRecyclerAdapter.appendDataToList(arrayList);
        j(baseRecyclerAdapter, baseRecyclerView, 1);
    }

    public final List<AboutVo> d(Context context) {
        ArrayList arrayList = new ArrayList();
        AboutVo aboutVo = new AboutVo();
        aboutVo.setTitle(c.e.a.d.x.getString(R.string.title_special_declaration));
        aboutVo.setType(1);
        arrayList.add(aboutVo);
        AboutVo aboutVo2 = new AboutVo();
        aboutVo2.setTitle(c.e.a.d.x.getString(R.string.title_use_help));
        aboutVo2.setType(2);
        arrayList.add(aboutVo2);
        AboutVo aboutVo3 = new AboutVo();
        aboutVo3.setType(3);
        aboutVo3.setTitle(c.e.a.d.x.getString(R.string.title_app_comment));
        arrayList.add(aboutVo3);
        AboutVo aboutVo4 = new AboutVo();
        aboutVo4.setTitle(c.e.a.d.x.getString(R.string.title_privacy_policy));
        aboutVo4.setType(4);
        arrayList.add(aboutVo4);
        AboutVo aboutVo5 = new AboutVo();
        aboutVo5.setType(5);
        aboutVo5.setTitle(c.e.a.d.x.appendStringToResId(R.string.title_placeholder_app_version, c.e.a.a.b.getInstance().getAppVersionName()));
        arrayList.add(aboutVo5);
        return arrayList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void e(int i2, AppConfigExtVo appConfigExtVo) {
        String string;
        switch (i2) {
            case 1:
                string = c.e.a.d.x.getString(R.string.title_special_declaration);
                specialDeclarationUrl = appConfigExtVo != null ? appConfigExtVo.getSpecialDeclarationUrl() : null;
                if (specialDeclarationUrl == null) {
                    specialDeclarationUrl = AlertMessageVo.REGISTER_PROTOCOL_URL;
                }
                break;
            case 2:
                string = c.e.a.d.x.getString(R.string.title_use_help);
                specialDeclarationUrl = appConfigExtVo != null ? appConfigExtVo.getHelpCourseUrl() : null;
                if (specialDeclarationUrl == null) {
                    specialDeclarationUrl = AlertMessageVo.HELP_URL;
                }
                break;
            case 3:
                g();
                string = null;
                break;
            case 4:
                string = c.e.a.d.x.getString(R.string.title_privacy_policy);
                specialDeclarationUrl = appConfigExtVo != null ? appConfigExtVo.getPrivacyPolicyUrl() : null;
                if (specialDeclarationUrl == null) {
                    specialDeclarationUrl = AlertMessageVo.PRIVACY_URL;
                }
                break;
            case 5:
                a(AboutAppActivity.class);
                string = null;
                break;
            case 6:
                h();
                string = null;
                break;
            default:
                string = null;
                break;
        }
        i(specialDeclarationUrl, string);
    }

    public void f(View view, AppConfigExtVo appConfigExtVo) {
        e(((AboutVo) view.getTag()).getType(), appConfigExtVo);
    }

    public final void g() {
        FragmentActivity currentActivity;
        g0 g0Var = this.f2124a;
        if (g0Var == null || (currentActivity = g0Var.getCurrentActivity()) == null) {
            return;
        }
        c.e.a.d.b0.getInstance().goToMarket(currentActivity, currentActivity.getPackageName());
    }

    public final void h() {
        FragmentActivity currentActivity;
        g0 g0Var = this.f2124a;
        if (g0Var == null || !g0Var.isLoginApp() || (currentActivity = this.f2124a.getCurrentActivity()) == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("alipays://platformapi/startapp?appId=2021003100660497&page=page/home/index"));
            currentActivity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f2124a.showToast(R.string.tip_open_alipay_failed);
        }
    }

    public final void i(String str, String str2) {
        g0 g0Var = this.f2124a;
        if (g0Var == null || g0Var.getCurrentActivity() == null || !c.e.a.d.x.isNotNull(str) || !c.e.a.d.x.isNotNull(str2)) {
            return;
        }
        Intent intent = new Intent(this.f2124a.getCurrentActivity(), (Class<?>) WebViewActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", str);
        intent.putExtra("titleKey", str2);
        this.f2124a.getCurrentActivity().startActivity(intent);
    }

    public void j(BaseRecyclerAdapter baseRecyclerAdapter, BaseRecyclerView baseRecyclerView, int i2) {
        if (baseRecyclerView.getItemDecorationCount() > 0) {
            baseRecyclerView.removeItemDecorationAt(0);
        }
        Resources resources = baseRecyclerView.getResources();
        RoomGridSpecItemDecoration roomGridSpecItemDecoration = new RoomGridSpecItemDecoration(2, resources.getDimensionPixelSize(R.dimen.dp_12), resources.getDimensionPixelSize(R.dimen.dp_8));
        roomGridSpecItemDecoration.setSkipPosition(i2);
        roomGridSpecItemDecoration.setOtherPosition(baseRecyclerAdapter.getItemCount() - 1);
        roomGridSpecItemDecoration.setDivider(resources.getDrawable(R.drawable.bg_me_recycler_item_line));
    }
}
