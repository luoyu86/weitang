package c.e.c.h0.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.e.a.d.o;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.b.c.d.h;
import c.e.c.m0.l;
import com.alibaba.android.arouter.utils.Consts;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.room.vo.ActivityListBean;
import com.chinavisionary.microtang.room.vo.RoomSourceDetailsVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View.OnClickListener f1530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f1531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f1532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f1533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f1534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f1535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f1536g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f1537h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f1538i;
    public LinearLayout j;
    public CoreRoundedImageView k;
    public TextView l;
    public ImageView m;
    public LayoutInflater n;

    public final View a(ActivityListBean activityListBean) {
        View viewInflate = this.n.inflate(R.layout.item_activity_layout, (ViewGroup) this.j, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_activity_content);
        textView.setTag(activityListBean);
        textView.setText(b(activityListBean.getTitle()));
        textView.setOnClickListener(this.f1530a);
        return viewInflate;
    }

    public final String b(String str) {
        return x.getNotNullStr(str, "");
    }

    public final void c() {
    }

    public final boolean d() {
        return x.getString(R.string.title_city_sh).equals(w.getInstance().getString("current_location_name_key", ""));
    }

    public final void e(List<ActivityListBean> list) {
        this.j.removeAllViews();
        if (!o.isNotEmpty(list)) {
            this.j.setVisibility(8);
            return;
        }
        if (this.j.getVisibility() != 0) {
            this.j.setVisibility(0);
        }
        for (ActivityListBean activityListBean : list) {
            if (activityListBean != null) {
                this.j.addView(a(activityListBean));
            }
        }
    }

    public final void f(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            double d2 = Double.parseDouble(str);
            double d3 = Double.parseDouble(str2);
            h hVar = new h();
            hVar.setLongitude(Double.valueOf(d2));
            hVar.setLatitude(Double.valueOf(d3));
            this.k.setVisibility(0);
            this.m.setVisibility(0);
            this.l.setVisibility(0);
            this.k.setTag(hVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void g(RoomSourceDetailsVo roomSourceDetailsVo) {
        this.f1534e.setText(b(roomSourceDetailsVo.getSpaceFullName()));
    }

    public String getRoomLocation() {
        return this.f1534e.getText().toString();
    }

    public final void h(RoomSourceDetailsVo roomSourceDetailsVo) {
        StringBuilder sb = new StringBuilder(3);
        sb.append(b(roomSourceDetailsVo.getHouseName()));
        if (x.isNotNull(roomSourceDetailsVo.getHouseStyle())) {
            sb.append(Consts.DOT);
            sb.append(b(roomSourceDetailsVo.getHouseStyle()));
        }
        this.f1531b.setText(sb.toString());
    }

    public final void i(String str) {
        l.setupRentPrice(str, this.f1532c);
    }

    public void initHeadView(View view, View.OnClickListener onClickListener) {
        this.f1530a = onClickListener;
        this.n = LayoutInflater.from(view.getContext());
        this.f1538i = view.findViewById(R.id.view_split_line);
        this.f1531b = (TextView) view.findViewById(R.id.tv_room_name);
        this.f1532c = (TextView) view.findViewById(R.id.tv_room_price);
        this.f1533d = (TextView) view.findViewById(R.id.tv_room_rent_src_price);
        this.f1535f = (TextView) view.findViewById(R.id.tv_room_location_title);
        this.f1536g = (TextView) view.findViewById(R.id.tv_cat_community_details);
        this.l = (TextView) view.findViewById(R.id.tv_cat_map);
        this.m = (ImageView) view.findViewById(R.id.img_room_source_location);
        this.f1534e = (TextView) view.findViewById(R.id.tv_room_details_location);
        this.j = (LinearLayout) view.findViewById(R.id.flayout_product_tags);
        this.k = (CoreRoundedImageView) view.findViewById(R.id.img_room_location);
        this.f1537h = (TextView) view.findViewById(R.id.tv_room_device_list);
        this.k.setOnClickListener(this.f1530a);
        this.f1536g.setOnClickListener(this.f1530a);
        TextView textView = this.f1533d;
        textView.setPaintFlags(textView.getPaintFlags() | 16);
        c();
    }

    public void loadRoomLocationImg(ResourceVo resourceVo) {
        this.k.loadImageToResourceVo(resourceVo);
    }

    public void setupHeadData(RoomSourceDetailsVo roomSourceDetailsVo) {
        if (roomSourceDetailsVo != null) {
            this.f1537h.setVisibility(o.isNotEmpty(roomSourceDetailsVo.getDeviceList()) ? 0 : 8);
            i(roomSourceDetailsVo.getRentFee());
            l.setupPriceUnit(b(roomSourceDetailsVo.getUnderlineRentFee()), this.f1533d);
            g(roomSourceDetailsVo);
            h(roomSourceDetailsVo);
            if (!d()) {
                f(roomSourceDetailsVo.getLongitude(), roomSourceDetailsVo.getLatitude());
            }
            e(roomSourceDetailsVo.getActivityList());
        }
    }
}
