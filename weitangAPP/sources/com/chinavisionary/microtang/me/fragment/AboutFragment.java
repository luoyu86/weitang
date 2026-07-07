package com.chinavisionary.microtang.me.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.b;
import c.e.a.d.b0;
import c.e.a.d.w;
import c.e.a.d.x;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.config.bo.AppUpdateVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.version.model.AppVersionModel;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.main.fragments.VersionUpdateFragment;
import com.chinavisionary.microtang.open.adapter.AboutAdapter;
import com.chinavisionary.microtang.open.bo.AboutVo;
import com.chinavisionary.microtang.web.WebViewActivity;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AboutFragment extends BaseFragment<AboutVo> {
    public AppConfigExtVo B;
    public AppVersionModel C;
    public c.e.a.a.c.c.a D = new a();

    @BindView(R.id.swipe_refresh_layout_about)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements c.e.a.a.c.c.a {
        public a() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            long type = ((AboutVo) AboutFragment.this.t.getList().get(i2)).getType();
            if (type == 3) {
                b0.getInstance().goToMarket(AboutFragment.this.f6487e, AboutFragment.this.f6487e.getPackageName());
            } else if (type != 5) {
                AboutFragment.this.P1(type);
            } else {
                AboutFragment.this.z0(R.string.title_get_new_version);
                AboutFragment.this.C.getAppVersion();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: L1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M1(AppUpdateVo appUpdateVo) {
        H();
        if (appUpdateVo == null) {
            F0(R.string.title_current_version_is_new);
            return;
        }
        int appVersion = b.getInstance().getAppVersion(this.f6487e);
        int version = appUpdateVo.getVersion();
        int minVersion = appUpdateVo.getMinVersion();
        boolean zIsForceUpdate = appUpdateVo.isForceUpdate();
        boolean z = appVersion < minVersion;
        if (appVersion >= version && !z) {
            F0(R.string.title_current_version_is_new);
            return;
        }
        if (z) {
            zIsForceUpdate = true;
        }
        if (zIsForceUpdate) {
            w.getInstance().putBoolean("isAutoOpenDoorKey", false);
        }
        e(VersionUpdateFragment.getInstance(appUpdateVo.getRemark(), appUpdateVo.getDownloadUrl(), zIsForceUpdate), R.id.flayout_content, zIsForceUpdate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: N1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O1(RequestErrDto requestErrDto) {
        H();
        F0(R.string.title_get_new_version_failed);
    }

    public static AboutFragment getInstance() {
        return new AboutFragment();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void o0() {
        ArrayList arrayList = new ArrayList();
        AboutVo aboutVo = new AboutVo();
        aboutVo.setTitle(x.getString(R.string.title_special_declaration));
        aboutVo.setType(1);
        arrayList.add(aboutVo);
        AboutVo aboutVo2 = new AboutVo();
        aboutVo2.setTitle(x.getString(R.string.title_use_help));
        aboutVo2.setType(2);
        arrayList.add(aboutVo2);
        AboutVo aboutVo3 = new AboutVo();
        aboutVo3.setType(3);
        aboutVo3.setTitle(x.getString(R.string.title_app_comment));
        arrayList.add(aboutVo3);
        AboutVo aboutVo4 = new AboutVo();
        aboutVo4.setTitle(x.getString(R.string.title_privacy_policy));
        aboutVo4.setType(4);
        arrayList.add(aboutVo4);
        AboutVo aboutVo5 = new AboutVo();
        aboutVo5.setType(5);
        aboutVo5.setTitle(x.appendStringToResId(R.string.title_placeholder_app_version, b.getInstance().getAppVersionName()));
        arrayList.add(aboutVo5);
        this.t.addHeadView(K1());
        this.t.initListData(arrayList);
    }

    public final View K1() {
        return LayoutInflater.from(this.f6487e).inflate(R.layout.item_about_head_layout, (ViewGroup) null);
    }

    public final void P1(long j) {
        String str;
        String string;
        String privacyPolicyUrl;
        String str2 = null;
        if (j == 1) {
            string = x.getString(R.string.title_special_declaration);
            AppConfigExtVo appConfigExtVo = this.B;
            privacyPolicyUrl = appConfigExtVo != null ? appConfigExtVo.getSpecialDeclarationUrl() : AlertMessageVo.REGISTER_PROTOCOL_URL;
        } else if (j == 2) {
            string = x.getString(R.string.title_use_help);
            AppConfigExtVo appConfigExtVo2 = this.B;
            privacyPolicyUrl = appConfigExtVo2 != null ? appConfigExtVo2.getHelpCourseUrl() : AlertMessageVo.HELP_URL;
        } else if (j != 4) {
            str = null;
            Q1(str2, str);
        } else {
            string = x.getString(R.string.title_privacy_policy);
            AppConfigExtVo appConfigExtVo3 = this.B;
            privacyPolicyUrl = appConfigExtVo3 != null ? appConfigExtVo3.getPrivacyPolicyUrl() : AlertMessageVo.PRIVACY_URL;
        }
        String str3 = string;
        str2 = privacyPolicyUrl;
        str = str3;
        Q1(str2, str);
    }

    public final void Q1(String str, String str2) {
        if (x.isNotNull(str) && x.isNotNull(str2)) {
            Intent intent = new Intent(this.f6487e, (Class<?>) WebViewActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("key", str);
            intent.putExtra("titleKey", str2);
            startActivity(intent);
        }
    }

    public final void R1() {
        AppVersionModel appVersionModel = (AppVersionModel) ViewModelProviders.of(this).get(AppVersionModel.class);
        this.C = appVersionModel;
        appVersionModel.getUpdateVoMutableLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2021a.M1((AppUpdateVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2025a.O1((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_about);
        this.mBaseSwipeRefreshLayout.setEnabled(false);
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        AboutAdapter aboutAdapter = new AboutAdapter();
        this.t = aboutAdapter;
        aboutAdapter.setOnItemClickListener(this.D);
        this.B = o();
        o0();
        R1();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_about;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
