package c.e.c.x.e;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.chinavisionary.core.app.ad.manager.ADManager;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import com.chinavisionary.microtang.me.vo.OrderVo;
import com.chinavisionary.microtang.view.BadgeImageView;
import com.nex3z.flowlayout.FlowLayout;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m0 extends b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FlowLayout f2176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FlowLayout f2177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FlowLayout f2178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConstraintLayout f2179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FlowLayout f2180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EditBannerView f2181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l0 f2182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i0 f2183i;
    public AppConfigExtVo j;
    public boolean k;
    public final View.OnClickListener l;

    public m0(g0 g0Var) {
        super(g0Var);
        this.l = new View.OnClickListener() { // from class: c.e.c.x.e.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2150a.l(view);
            }
        };
        this.f2182h = new l0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(boolean z) {
        this.f2182h.a(this.f2176b, this.l, z, 1);
        this.f2182h.a(this.f2177c, this.l, z, 2);
        this.f2182h.a(this.f2178d, this.l, z, 4);
        this.f2182h.a(this.f2180f, this.l, z, 3);
        this.f2179e.setVisibility(this.f2178d.getVisibility());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(View view) {
        g0 g0Var = this.f2124a;
        if (g0Var != null) {
            g0Var.clickBannerItem(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(View view) {
        if (this.f2124a == null || view.getId() != R.id.llayout_order_item) {
            return;
        }
        try {
            OrderVo orderVo = (OrderVo) view.getTag();
            if (orderVo.getType() == 7) {
                e(orderVo);
            } else if (orderVo.getType() > 0) {
                e(orderVo);
                this.f2183i.e(orderVo.getType(), this.j);
            } else if (this.f2124a.isLoginApp()) {
                this.f2124a.clickFunction(orderVo.getTitle());
                if (!c.e.a.d.x.isNotNull(orderVo.getParam())) {
                    a(orderVo.getActivityClass());
                } else if (orderVo.getParam().equals(OrderVo.JUMP_TYPE_MINI_CALL_MANAGER)) {
                    u();
                } else {
                    b(orderVo.getActivityClass(), orderVo.getParam());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n() {
        this.f2182h.a(this.f2180f, this.l, this.k, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p(boolean z) {
        this.f2176b.setBackgroundResource(z ? R.drawable.bg_item_head_menu_gradient_bottom_radius : R.drawable.bg_item_head_menu_gradient_radius);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r() {
        this.f2182h.a(this.f2177c, this.l, this.k, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t() {
        this.f2182h.a(this.f2178d, this.l, this.k, 4);
        this.f2179e.setVisibility(this.f2178d.getVisibility());
    }

    public void c(final boolean z) {
        this.k = z;
        c.e.a.d.q.d(m0.class.getSimpleName(), "addMenuItemToIsRent  isRent = " + z);
        FlowLayout flowLayout = this.f2176b;
        if (flowLayout != null) {
            flowLayout.postDelayed(new Runnable() { // from class: c.e.c.x.e.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2151a.h(z);
                }
            }, 500L);
        } else {
            c.e.a.d.q.d(m0.class.getSimpleName(), "addMenuItemToIsRent mFlowLayout is null");
        }
    }

    public void d(boolean z) {
    }

    public final void e(OrderVo orderVo) {
        if (!orderVo.hasNeedLogin()) {
            this.f2124a.clickFunctionType(orderVo.getJumpType());
            this.f2124a.clickForward(orderVo);
        } else if (this.f2124a.isLoginApp()) {
            this.f2124a.clickFunctionType(orderVo.getJumpType());
            this.f2124a.clickForward(orderVo);
        }
    }

    public void f(View view) {
        this.f2181g = (EditBannerView) view.findViewById(R.id.edt_banner_cover);
        this.f2180f = (FlowLayout) view.findViewById(R.id.llayout_about_list);
        this.f2177c = (FlowLayout) view.findViewById(R.id.llayout_function_list);
        this.f2178d = (FlowLayout) view.findViewById(R.id.llayout_function_server_list);
        this.f2179e = (ConstraintLayout) view.findViewById(R.id.constraint_layout_me_wt_server);
        this.f2176b = (FlowLayout) view.findViewById(R.id.llayout_order_list);
        this.f2181g.setVisibility(8);
        this.f2181g.setFragment(null);
        this.f2181g.setItemClickListener(new View.OnClickListener() { // from class: c.e.c.x.e.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f2138a.j(view2);
            }
        });
    }

    public final void u() {
        g0 g0Var = this.f2124a;
        if (g0Var != null) {
            g0Var.clickWxMiniAppManager();
        }
    }

    public void updateAboutUsConfig(List<FundNewsVo> list) {
        this.f2182h.setAboutUsConfigMenuVo(list);
        FlowLayout flowLayout = this.f2176b;
        if (flowLayout != null) {
            flowLayout.postDelayed(new Runnable() { // from class: c.e.c.x.e.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2157a.n();
                }
            }, 500L);
        } else {
            c.e.a.d.q.d(m0.class.getSimpleName(), "updateAboutUsConfig mFlowLayout is null");
        }
    }

    public void updateApplyRentBadge(Integer num) {
        LinearLayout linearLayout;
        int childCount;
        int childCount2 = this.f2177c.getChildCount();
        if (childCount2 > 0) {
            for (int i2 = 0; i2 < childCount2; i2++) {
                if (this.f2177c.getChildAt(i2).getTag() != null && (childCount = (linearLayout = (LinearLayout) this.f2177c.getChildAt(i2)).getChildCount()) > 0 && "入住申请".equals(((OrderVo) linearLayout.getTag()).getTitle())) {
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = linearLayout.getChildAt(i3);
                        if (childAt instanceof BadgeImageView) {
                            ((BadgeImageView) childAt).setupShowBadge(num.intValue() > 0, num);
                        }
                    }
                }
            }
        }
    }

    public void updateMeVtConfig(List<FundNewsVo> list) {
        this.f2182h.setMeVtConfigMenuVo(list);
        if (this.f2176b == null) {
            c.e.a.d.q.d(m0.class.getSimpleName(), "updateMeVtConfig mFlowLayout is null");
            return;
        }
        if (!c.e.a.a.a.getInstance().isShowPwdDoor()) {
            c.e.a.a.a.getInstance().setShowPwdDoor(c.e.a.d.w.getInstance().getBoolean("is_show_pwd_door", false));
        }
        this.f2176b.postDelayed(new Runnable() { // from class: c.e.c.x.e.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f2153a.r();
            }
        }, 500L);
    }

    public void updatePwdDoorEntryState() {
        int childCount = this.f2177c.getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (this.f2177c.getChildAt(i2).getTag() != null) {
                    try {
                        if (((OrderVo) this.f2177c.getChildAt(i2).getTag()).getTitleId() == R.string.title_door_pwd) {
                            this.f2177c.getChildAt(i2).setVisibility(c.e.a.a.a.getInstance().isShowPwdDoor() ? 0 : 8);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public void updateServeConfig(List<FundNewsVo> list) {
        this.f2182h.setFundNewsVos(list);
        FlowLayout flowLayout = this.f2176b;
        if (flowLayout != null) {
            flowLayout.postDelayed(new Runnable() { // from class: c.e.c.x.e.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2130a.t();
                }
            }, 500L);
        } else {
            c.e.a.d.q.d(m0.class.getSimpleName(), "addMenuItemToIsRent mFlowLayout is null");
        }
    }

    public void v(AppConfigExtVo appConfigExtVo) {
        this.j = appConfigExtVo;
    }

    public void w(i0 i0Var) {
        this.f2183i = i0Var;
    }

    public void x(List<EditBannerView.BannerDto> list, Fragment fragment) {
        if (this.f2181g.getVisibility() == 8) {
            this.f2181g.setVisibility(0);
        }
        this.f2181g.setAdapterListData(list);
        if (fragment == null || !c.e.a.d.g.getInstance().isHasEnableMeBannerAd()) {
            return;
        }
        FrameLayout frameLayoutCreateBannerMeFrameLayout = ADManager.getInstance().createBannerMeFrameLayout(this.f2181g.getContext());
        this.f2181g.addViewToAdapter(frameLayoutCreateBannerMeFrameLayout);
        ADManager.getInstance().loadMeBannerAd(fragment, frameLayoutCreateBannerMeFrameLayout);
    }

    public void y(final boolean z) {
        this.f2176b.post(new Runnable() { // from class: c.e.c.x.e.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f2154a.p(z);
            }
        });
    }

    public void z(boolean z, Integer num) {
        this.f2182h.g(z, num);
    }
}
