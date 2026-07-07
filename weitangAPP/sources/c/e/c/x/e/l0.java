package c.e.c.x.e;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.auth.EduAuthActivity;
import com.chinavisionary.microtang.bill.BillTabActivity;
import com.chinavisionary.microtang.card.CardCouponActivity;
import com.chinavisionary.microtang.comment.CommentTabActivity;
import com.chinavisionary.microtang.community.CommunityActivityTabActivity;
import com.chinavisionary.microtang.contract.ContractActivity;
import com.chinavisionary.microtang.doorpwd.DoorPasswordActivity;
import com.chinavisionary.microtang.me.AboutAppActivity;
import com.chinavisionary.microtang.me.DeviceRecordTabActivity;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import com.chinavisionary.microtang.me.vo.OrderVo;
import com.chinavisionary.microtang.order.ServiceOrderTabActivity;
import com.chinavisionary.microtang.pre.ReserveListActivity;
import com.chinavisionary.microtang.repair.RepairActivity;
import com.chinavisionary.microtang.view.BadgeImageView;
import com.chinavisionary.microtang.web.bridge.BridgeWebViewActivity;
import com.nex3z.flowlayout.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BadgeImageView f2169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<FundNewsVo> f2170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<FundNewsVo> f2171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<FundNewsVo> f2172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f2174f;

    public void a(FlowLayout flowLayout, View.OnClickListener onClickListener, boolean z, int i2) {
        List<OrderVo> listC;
        List<OrderVo> list;
        flowLayout.removeAllViews();
        Resources resources = flowLayout.getResources();
        int width = flowLayout.getWidth();
        int size = width / 4;
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.dp_28);
        if (i2 == 2) {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.dp_28);
            listC = c();
            List<OrderVo> listE = e(this.f2171c);
            if (c.e.a.d.o.isNotEmpty(listE)) {
                listC.addAll(listE);
            }
        } else if (i2 == 3) {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.dp_28);
            listC = b();
            List<OrderVo> listE2 = e(this.f2172d);
            if (c.e.a.d.o.isNotEmpty(listE2)) {
                listC.addAll(listE2);
            }
        } else if (i2 != 4) {
            listC = d(z);
            size = width / listC.size();
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.dp_28);
            listC = f();
        }
        if (c.e.a.d.o.listIsEmpty(listC)) {
            flowLayout.setVisibility(8);
            return;
        }
        if (flowLayout.getVisibility() == 8) {
            flowLayout.setVisibility(0);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(size, -1, 1.0f);
        Context context = flowLayout.getContext();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams2.bottomMargin = resources.getDimensionPixelSize(R.dimen.dp_4);
        layoutParams.bottomMargin = resources.getDimensionPixelSize(R.dimen.dp_10);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.dp_3);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.dp_5);
        int color = resources.getColor(R.color.color555555);
        int size2 = listC.size();
        int i3 = 0;
        while (i3 < size2) {
            OrderVo orderVo = listC.get(i3);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setId(R.id.llayout_order_item);
            linearLayout.setTag(orderVo);
            linearLayout.setVisibility(orderVo.isHide() ? 8 : 0);
            if (orderVo.getIconUrl() != null) {
                BadgeImageView badgeImageView = new BadgeImageView(context);
                badgeImageView.loadImageToUrl(orderVo.getIconUrl());
                badgeImageView.setPadding(dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3);
                badgeImageView.setBackgroundResource(R.drawable.bg_fund_white_radius_4);
                badgeImageView.setLayoutParams(layoutParams2);
                linearLayout.addView(badgeImageView);
                list = listC;
            } else {
                BadgeImageView badgeImageView2 = new BadgeImageView(context);
                badgeImageView2.setImageResource(orderVo.getIconId());
                list = listC;
                if (R.mipmap.ic_door_pwd == orderVo.getIconId()) {
                    badgeImageView2.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
                } else {
                    badgeImageView2.setScaleType(ImageView.ScaleType.CENTER);
                }
                badgeImageView2.setLayoutParams(layoutParams2);
                if (R.mipmap.ic_menu_rent_comment == orderVo.getIconId()) {
                    this.f2169a = badgeImageView2;
                    badgeImageView2.setupShowBadge(this.f2173e, this.f2174f);
                }
                linearLayout.addView(badgeImageView2);
            }
            TextView textView = new TextView(context);
            if (orderVo.getTitleId() > 0) {
                textView.setText(orderVo.getTitleId());
            } else {
                textView.setText(c.e.a.d.x.getNotNullStr(orderVo.getTitle(), ""));
            }
            textView.setGravity(17);
            textView.setTextSize(13.0f);
            textView.setTextColor(color);
            textView.setLayoutParams(layoutParams3);
            linearLayout.addView(textView);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOnClickListener(onClickListener);
            flowLayout.addView(linearLayout);
            i3++;
            listC = list;
        }
    }

    public final List<OrderVo> b() {
        ArrayList arrayList = new ArrayList();
        OrderVo orderVo = new OrderVo();
        orderVo.setTitleId(R.string.title_special_declaration);
        orderVo.setType(1);
        orderVo.setIconId(R.mipmap.ic_important_clause);
        OrderVo orderVo2 = new OrderVo();
        orderVo2.setTitleId(R.string.title_app_comment);
        orderVo2.setType(3);
        orderVo2.setIconId(R.mipmap.ic_score_black);
        OrderVo orderVo3 = new OrderVo();
        orderVo3.setTitleId(R.string.title_privacy_policy);
        orderVo3.setIconId(R.mipmap.ic_privacy_policy);
        orderVo3.setType(4);
        OrderVo orderVo4 = new OrderVo();
        orderVo4.setTitle("V" + c.e.a.a.b.getInstance().getAppVersionName());
        orderVo4.setIconId(R.mipmap.ic_version);
        orderVo4.setType(5);
        orderVo4.setActivityClass(AboutAppActivity.class);
        arrayList.add(orderVo);
        arrayList.add(orderVo3);
        arrayList.add(orderVo2);
        arrayList.add(orderVo4);
        return arrayList;
    }

    public final List<OrderVo> c() {
        ArrayList arrayList = new ArrayList();
        OrderVo orderVo = new OrderVo();
        orderVo.setTitleId(R.string.title_repair);
        if (c.e.a.a.a.getInstance().isH5Repair()) {
            orderVo.setParam(c.e.c.r.a.getMyRepairActivity());
            orderVo.setActivityClass(BridgeWebViewActivity.class);
        } else {
            orderVo.setActivityClass(RepairActivity.class);
        }
        orderVo.setIconId(R.mipmap.ic_me_menu_repair);
        OrderVo orderVo2 = new OrderVo();
        orderVo2.setTitleId(R.string.title_cat_table_record);
        orderVo2.setParam(c.e.c.r.a.getMycatDeviceRecord());
        orderVo2.setActivityClass(BridgeWebViewActivity.class);
        orderVo2.setIconId(R.mipmap.ic_cat_device_record);
        OrderVo orderVo3 = new OrderVo();
        orderVo3.setTitleId(R.string.title_sale_activity);
        orderVo3.setIconId(R.mipmap.ic_sale_activity);
        orderVo3.setParam(c.e.c.r.a.getMySaleActivity());
        orderVo3.setActivityClass(BridgeWebViewActivity.class);
        OrderVo orderVo4 = new OrderVo();
        orderVo4.setTitleId(R.string.title_me_card);
        orderVo4.setParam(c.e.c.r.a.getMyCoupon());
        orderVo4.setActivityClass(BridgeWebViewActivity.class);
        orderVo4.setIconId(R.mipmap.ic_me_menu_card);
        OrderVo orderVo5 = new OrderVo();
        orderVo5.setTitleId(R.string.title_me_community_activity);
        orderVo5.setActivityClass(CommunityActivityTabActivity.class);
        orderVo5.setIconId(R.mipmap.ic_community_activity);
        OrderVo orderVo6 = new OrderVo();
        orderVo6.setTitleId(R.string.title_enterprise_certificate);
        orderVo6.setParam(c.e.c.r.a.getEnterpriseCertificate());
        orderVo6.setActivityClass(BridgeWebViewActivity.class);
        orderVo6.setIconId(R.mipmap.ic_enterprise_certificate);
        OrderVo orderVo7 = new OrderVo();
        orderVo7.setTitleId(R.string.title_menu_rent_comment);
        orderVo7.setActivityClass(CommentTabActivity.class);
        orderVo7.setIconId(R.mipmap.ic_menu_rent_comment);
        OrderVo orderVo8 = new OrderVo();
        orderVo8.setTitleId(R.string.title_app_comment);
        orderVo8.setIconId(R.mipmap.ic_score);
        orderVo8.setType(3);
        OrderVo orderVo9 = new OrderVo();
        orderVo9.setTitleId(R.string.title_complaint_consultation);
        orderVo9.setParam(c.e.c.r.a.getMyServiceActivity());
        orderVo9.setActivityClass(BridgeWebViewActivity.class);
        orderVo9.setIconId(R.mipmap.ic_menu_complaint_consultation);
        OrderVo orderVo10 = new OrderVo();
        orderVo10.setTitleId(R.string.title_me_manager);
        orderVo10.setParam(OrderVo.JUMP_TYPE_MINI_CALL_MANAGER);
        orderVo10.setActivityClass(BridgeWebViewActivity.class);
        orderVo10.setIconId(R.mipmap.ic_me_call_manager);
        OrderVo orderVo11 = new OrderVo();
        orderVo11.setTitleId(R.string.title_door_pwd);
        orderVo11.setActivityClass(DoorPasswordActivity.class);
        orderVo11.setIconId(R.mipmap.ic_door_pwd);
        orderVo11.setHide(!c.e.a.a.a.getInstance().isShowPwdDoor());
        arrayList.add(orderVo2);
        arrayList.add(orderVo);
        arrayList.add(orderVo3);
        arrayList.add(orderVo4);
        arrayList.add(orderVo5);
        if (c.e.a.a.a.getInstance().isEnterpriseUser()) {
            arrayList.add(orderVo6);
            arrayList.add(orderVo7);
        }
        if (c.e.a.a.a.getInstance().isIMModel()) {
            arrayList.add(orderVo9);
        }
        arrayList.add(orderVo10);
        arrayList.add(orderVo11);
        return arrayList;
    }

    public final List<OrderVo> d(boolean z) {
        ArrayList arrayList = new ArrayList();
        OrderVo orderVo = new OrderVo();
        orderVo.setTitleId(R.string.title_bill);
        if (c.e.a.a.a.getInstance().isH5Model()) {
            orderVo.setParam(c.e.c.r.a.getMyBill());
            orderVo.setActivityClass(BridgeWebViewActivity.class);
        } else {
            orderVo.setActivityClass(BillTabActivity.class);
        }
        orderVo.setIconId(R.mipmap.ic_me_menu_bill);
        arrayList.add(orderVo);
        OrderVo orderVo2 = new OrderVo();
        orderVo2.setTitleId(R.string.title_contact);
        if (c.e.a.a.a.getInstance().isH5Model()) {
            orderVo2.setParam(c.e.c.r.a.getMyContract());
            orderVo2.setActivityClass(BridgeWebViewActivity.class);
        } else {
            orderVo2.setActivityClass(ContractActivity.class);
        }
        orderVo2.setIconId(R.mipmap.ic_me_menu_contract);
        arrayList.add(orderVo2);
        OrderVo orderVo3 = new OrderVo();
        orderVo3.setTitleId(R.string.title_reserve);
        if (c.e.a.a.a.getInstance().isH5Model()) {
            orderVo3.setParam(c.e.c.r.a.getMyReserve());
            orderVo3.setActivityClass(BridgeWebViewActivity.class);
        } else {
            orderVo3.setActivityClass(ReserveListActivity.class);
        }
        orderVo3.setIconId(R.mipmap.ic_me_menu_pre);
        OrderVo orderVo4 = new OrderVo();
        orderVo4.setTitleId(R.string.title_repair);
        if (c.e.a.a.a.getInstance().isH5Repair()) {
            orderVo4.setParam(c.e.c.r.a.getMyRepairActivity());
            orderVo4.setActivityClass(BridgeWebViewActivity.class);
        } else {
            orderVo4.setActivityClass(RepairActivity.class);
        }
        orderVo4.setIconId(z ? R.mipmap.ic_me_menu_repair : R.mipmap.ic_repair_un_auth);
        OrderVo orderVo5 = new OrderVo();
        orderVo5.setTitleId(R.string.title_cat_table_record);
        orderVo5.setActivityClass(DeviceRecordTabActivity.class);
        orderVo5.setIconId(R.mipmap.ic_cat_device_record);
        OrderVo orderVo6 = new OrderVo();
        orderVo6.setTitleId(R.string.title_tab_me_service_order);
        if (c.e.a.a.a.getInstance().isH5Model()) {
            orderVo6.setParam(c.e.c.r.a.getMyOrder());
            orderVo6.setActivityClass(BridgeWebViewActivity.class);
        } else {
            orderVo6.setActivityClass(ServiceOrderTabActivity.class);
        }
        orderVo6.setIconId(R.mipmap.ic_me_menu_order);
        OrderVo orderVo7 = new OrderVo();
        orderVo7.setTitleId(R.string.title_tab_me_auth);
        if (c.e.a.a.a.getInstance().isH5Model()) {
            orderVo7.setParam(c.e.c.r.a.getAuthList());
            orderVo7.setActivityClass(BridgeWebViewActivity.class);
        }
        orderVo7.setIconId(R.mipmap.ic_me_menu_auth);
        OrderVo orderVo8 = new OrderVo();
        orderVo8.setTitleId(R.string.title_me_card);
        if (c.e.a.a.a.getInstance().isH5Model()) {
            orderVo8.setParam(c.e.c.r.a.getMyCoupon());
            orderVo8.setActivityClass(BridgeWebViewActivity.class);
        } else {
            orderVo8.setActivityClass(CardCouponActivity.class);
        }
        orderVo8.setIconId(R.mipmap.ic_me_menu_card);
        OrderVo orderVo9 = new OrderVo();
        orderVo9.setTitleId(R.string.title_me_recommend);
        orderVo9.setActivityClass(EduAuthActivity.class);
        orderVo9.setIconId(R.mipmap.ic_me_menu_recommend);
        if (!c.e.a.a.a.getInstance().isTestRepair()) {
            arrayList.add(orderVo7);
        }
        arrayList.add(orderVo6);
        arrayList.add(orderVo3);
        if (c.e.a.a.a.getInstance().isEnterpriseUser()) {
            arrayList.add(orderVo7);
        }
        c.e.a.a.a.getInstance().isH5Model();
        return arrayList;
    }

    public final List<OrderVo> e(List<FundNewsVo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && c.e.a.d.o.isNotEmpty(list)) {
            for (FundNewsVo fundNewsVo : list) {
                if (fundNewsVo != null) {
                    OrderVo orderVo = new OrderVo();
                    orderVo.setTitle(fundNewsVo.getName());
                    orderVo.setIconUrl(fundNewsVo.getIconUrl());
                    orderVo.setForwardType(fundNewsVo.getForwardType());
                    orderVo.setMessageType(fundNewsVo.getMessageType());
                    orderVo.setLoginFlag(fundNewsVo.getLoginFlag());
                    orderVo.setJumpType(fundNewsVo.getBtnType());
                    orderVo.setH5Url(fundNewsVo.getH5Url());
                    orderVo.setMiniType(fundNewsVo.getMiniType());
                    orderVo.setMiniAppId(fundNewsVo.getMiniAppId());
                    orderVo.setMiniPagePath(fundNewsVo.getMiniPagePath());
                    orderVo.setType(7);
                    arrayList.add(orderVo);
                }
            }
        }
        return arrayList;
    }

    public final List<OrderVo> f() {
        ArrayList arrayList = new ArrayList();
        List<FundNewsVo> list = this.f2170b;
        if (list != null && c.e.a.d.o.isNotEmpty(list)) {
            for (FundNewsVo fundNewsVo : this.f2170b) {
                if (fundNewsVo != null) {
                    OrderVo orderVo = new OrderVo();
                    orderVo.setTitle(fundNewsVo.getName());
                    orderVo.setIconUrl(fundNewsVo.getIconUrl());
                    orderVo.setForwardType(fundNewsVo.getForwardType());
                    orderVo.setMessageType(fundNewsVo.getMessageType());
                    orderVo.setLoginFlag(fundNewsVo.getLoginFlag());
                    orderVo.setJumpType(fundNewsVo.getBtnType());
                    orderVo.setH5Url(fundNewsVo.getH5Url());
                    orderVo.setMiniType(fundNewsVo.getMiniType());
                    orderVo.setMiniAppId(fundNewsVo.getMiniAppId());
                    orderVo.setMiniPagePath(fundNewsVo.getMiniPagePath());
                    orderVo.setType(7);
                    arrayList.add(orderVo);
                }
            }
        }
        return arrayList;
    }

    public void g(boolean z, Integer num) {
        this.f2174f = num;
        this.f2173e = z;
        BadgeImageView badgeImageView = this.f2169a;
        if (badgeImageView != null) {
            badgeImageView.setupShowBadge(z, num);
        }
    }

    public void setAboutUsConfigMenuVo(List<FundNewsVo> list) {
        this.f2172d = list;
    }

    public void setFundNewsVos(List<FundNewsVo> list) {
        this.f2170b = list;
    }

    public void setMeVtConfigMenuVo(List<FundNewsVo> list) {
        this.f2171c = list;
    }
}
