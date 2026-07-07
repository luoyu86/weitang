package c.e.c.x.e;

import c.e.a.d.i;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.auth.IDAuthActivity;
import com.chinavisionary.microtang.me.fragment.AboutFragment;
import com.chinavisionary.microtang.me.fragment.AccountFragment;
import com.chinavisionary.microtang.me.fragment.EditMeNewFragment;
import com.chinavisionary.microtang.me.fragment.UpdatePhoneOrPwdFragment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EditMeNewFragment f2126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CoreBaseFragment.c f2127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i.c f2128c = new a();

    public class a implements i.c {
        public a() {
        }

        @Override // c.e.a.d.i.c
        public void clearCacheOver(long j) {
            if (c0.this.f2127b != null) {
                c0.this.f2127b.sendEmptyMessage(0);
            }
        }

        @Override // c.e.a.d.i.c
        public void updateCacheSize(long j) {
            if (c0.this.f2127b != null) {
                c0.this.f2127b.obtainMessage(1, Long.valueOf(j)).sendToTarget();
            }
        }
    }

    public c0(EditMeNewFragment editMeNewFragment, CoreBaseFragment.c cVar) {
        this.f2126a = editMeNewFragment;
        this.f2127b = cVar;
    }

    public final void b() {
        c.e.a.d.i.getInstance().clearCache();
    }

    public List<LeftTitleToRightArrowVo> getAdapterData(boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setLeft(c.e.a.d.x.getString(R.string.title_password));
        leftTitleToRightArrowVo.setRight(c.e.a.d.x.getString(R.string.title_update_passwrod));
        leftTitleToRightArrowVo.setOnlyKey(11);
        leftTitleToRightArrowVo.setShowSplitLine(true);
        leftTitleToRightArrowVo.setType(-3);
        leftTitleToRightArrowVo.setShowArrow(true);
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setLeft(c.e.a.d.x.getString(R.string.title_id_info));
        leftTitleToRightArrowVo2.setOnlyKey(0);
        leftTitleToRightArrowVo2.setType(-3);
        leftTitleToRightArrowVo2.setShowArrow(true);
        leftTitleToRightArrowVo2.setShowSplitLine(true);
        leftTitleToRightArrowVo2.setRightFontColor(R.color.colorFE9900);
        leftTitleToRightArrowVo2.setRight(c.e.a.d.x.getString(z2 ? R.string.title_auth_over : R.string.title_unauth));
        arrayList.add(leftTitleToRightArrowVo2);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo3.setLeft(c.e.a.d.x.getString(R.string.title_about));
        leftTitleToRightArrowVo3.setOnlyKey(8);
        leftTitleToRightArrowVo3.setShowArrow(true);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo4.setLeft(c.e.a.d.x.getString(R.string.title_clear_cache));
        leftTitleToRightArrowVo4.setOnlyKey(2);
        leftTitleToRightArrowVo4.setType(-3);
        leftTitleToRightArrowVo4.setRight("0M");
        leftTitleToRightArrowVo4.setShowSplitLine(true);
        arrayList.add(leftTitleToRightArrowVo4);
        int i2 = c.e.a.d.w.getInstance().getInt("ad_time_key", 3);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo5.setLeft(c.e.a.d.x.getString(R.string.title_splash_ad));
        leftTitleToRightArrowVo5.setOnlyKey(4);
        leftTitleToRightArrowVo5.setRight(i2 + "S");
        leftTitleToRightArrowVo5.setType(-3);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo6 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo6.setLeft(c.e.a.d.x.getString(R.string.title_cancel_account));
        leftTitleToRightArrowVo6.setOnlyKey(5);
        leftTitleToRightArrowVo6.setShowArrow(true);
        leftTitleToRightArrowVo6.setType(-3);
        leftTitleToRightArrowVo6.setRight(c.e.a.d.x.getString(R.string.title_submit_apply_logout_account));
        arrayList.add(leftTitleToRightArrowVo6);
        if (z) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo7 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo7.setLeft(c.e.a.d.x.getString(R.string.title_notify_msg));
            leftTitleToRightArrowVo7.setOnlyKey(6);
            leftTitleToRightArrowVo7.setType(-3);
            leftTitleToRightArrowVo7.setRight(c.e.a.d.x.getString(R.string.title_enable_notify));
            leftTitleToRightArrowVo7.setShowSplitLine(false);
            arrayList.add(leftTitleToRightArrowVo7);
        } else {
            leftTitleToRightArrowVo6.setShowSplitLine(true);
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo8 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo8.setLeft(c.e.a.d.x.getString(R.string.title_ble_scan_model));
        leftTitleToRightArrowVo8.setOnlyKey(7);
        leftTitleToRightArrowVo8.setType(-4);
        leftTitleToRightArrowVo8.setRight(c.e.a.d.x.getString(R.string.title_enable_ble_connect));
        leftTitleToRightArrowVo8.setShowSplitLine(false);
        leftTitleToRightArrowVo8.setSelectRadio(c.e.e.a.x.f.isScan());
        arrayList.add(leftTitleToRightArrowVo8);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo9 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo9.setType(-2);
        leftTitleToRightArrowVo9.setBgColor(R.color.colorF8F8F8);
        leftTitleToRightArrowVo9.setSplitLineHeight(c.e.a.a.b.getInstance().getResources().getDimensionPixelSize(R.dimen.dp_10));
        arrayList.add(leftTitleToRightArrowVo9);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo10 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo10.setCenter(c.e.a.d.x.getString(R.string.title_exit_login));
        leftTitleToRightArrowVo10.setOnlyKey(3);
        leftTitleToRightArrowVo10.setType(-3);
        leftTitleToRightArrowVo10.setCenterFontColor(R.color.colorFE9900);
        return arrayList;
    }

    public void handleItemClick(int i2) {
        if (i2 == 8) {
            this.f2126a.replaceFragment(AboutFragment.getInstance());
        }
        if (i2 == 11) {
            this.f2126a.addFragment(UpdatePhoneOrPwdFragment.getInstance(2));
            return;
        }
        switch (i2) {
            case 0:
                if (!c.e.c.x.c.a.getInstance().isShowWalletTest()) {
                    this.f2126a.openActivity(IDAuthActivity.class);
                }
                break;
            case 1:
                this.f2126a.replaceFragment(AccountFragment.getInstance());
                break;
            case 2:
                b();
                break;
            case 3:
                this.f2126a.showConfirmAlertToContent(c.e.a.d.x.getString(R.string.tip_relay_confirm_exit));
                break;
            case 4:
                this.f2126a.showInputAlert(c.e.a.d.x.getString(R.string.title_setting_splash_ad_time), String.valueOf(c.e.a.d.w.getInstance().getInt("ad_time_key", 3)));
                break;
            case 5:
                this.f2126a.openLogoutAccount();
                break;
            case 6:
                this.f2126a.alertEnableNotification();
                break;
        }
    }

    public void setupCacheSize() {
        c.e.a.d.i.getInstance().setICacheSizeCallback(this.f2128c);
        c.e.a.d.i.getInstance().getCacheSize();
    }
}
