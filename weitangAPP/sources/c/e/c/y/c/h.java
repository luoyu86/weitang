package c.e.c.y.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c.e.a.d.k;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.merchant.vo.MerchantDetailsVo;
import com.lzy.ninegrid.preview.ImagePreviewActivity;
import com.nex3z.flowlayout.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CoreRoundedImageView f2267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CoreRoundedImageView f2268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f2269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f2270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f2271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FlowLayout f2272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BaseRecyclerView f2273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f2274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f2275i;
    public c.e.c.y.e.e j;
    public LeftTitleToRightArrowAdapter k;
    public c.e.a.a.c.c.a l = new a();
    public BaseRecyclerView.d m = new b();

    public class a implements c.e.a.a.c.c.a {
        public a() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo = h.this.k.getList().get(i2);
            if (1 == leftTitleToRightArrowVo.getOnlyKey()) {
                h.this.g(false);
                h.this.f((ResourceVo) leftTitleToRightArrowVo.getExtObj());
            }
        }
    }

    public class b implements BaseRecyclerView.d {
        public b() {
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.d
        public void upMove() {
            h.this.g(false);
        }
    }

    public h(View view) {
        this.f2267a = (CoreRoundedImageView) view.findViewById(R.id.img_merchant_cover);
        this.f2268b = (CoreRoundedImageView) view.findViewById(R.id.img_merchant_icon);
        this.f2269c = (TextView) view.findViewById(R.id.tv_merchant_name);
        this.f2270d = (TextView) view.findViewById(R.id.tv_merchant_notice);
        this.f2271e = (ImageView) view.findViewById(R.id.img_merchant_state);
        FlowLayout flowLayout = (FlowLayout) view.findViewById(R.id.flow_layout_sale_tag);
        this.f2272f = flowLayout;
        flowLayout.setVisibility(4);
        this.f2275i = (ImageView) view.findViewById(R.id.img_open_merchant_details);
        this.f2274h = (ImageView) view.findViewById(R.id.img_close_merchant_details);
        BaseRecyclerView baseRecyclerView = (BaseRecyclerView) view.findViewById(R.id.recycler_merchant_info);
        this.f2273g = baseRecyclerView;
        baseRecyclerView.setIOnRecyclerMove(this.m);
        j(view.getContext());
        this.f2267a.getLayoutParams().height = k.getBannerHeight(this.f2267a.getContext());
        i();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(View view) {
        int id = view.getId();
        if (id == R.id.img_close_merchant_details) {
            g(false);
        } else {
            if (id != R.id.img_open_merchant_details) {
                return;
            }
            g(true);
        }
    }

    public final void f(ResourceVo resourceVo) {
        ArrayList arrayList = new ArrayList();
        c.k.b.a aVar = new c.k.b.a();
        aVar.bigImageUrl = resourceVo.getUrl();
        aVar.thumbnailUrl = resourceVo.getSampleUrl();
        arrayList.add(aVar);
        Intent intent = new Intent(this.j.getCurrentActivity(), (Class<?>) ImagePreviewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("IMAGE_INFO", arrayList);
        bundle.putInt("CURRENT_ITEM", 0);
        intent.putExtras(bundle);
        this.j.getCurrentActivity().startActivity(intent);
    }

    public final void g(boolean z) {
        this.f2274h.setVisibility(z ? 0 : 8);
        this.f2273g.setVisibility(z ? 0 : 8);
        this.f2270d.setMaxLines(z ? 2 : 1);
        this.f2270d.setSingleLine(!z);
        this.f2275i.setVisibility(z ? 8 : 0);
        this.f2272f.setVisibility(z ? 8 : 4);
        c.e.c.y.e.e eVar = this.j;
        if (eVar != null) {
            eVar.showHideBottomView(!z);
        }
    }

    public final void h() {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: c.e.c.y.c.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2252a.e(view);
            }
        };
        this.f2275i.setOnClickListener(onClickListener);
        this.f2274h.setOnClickListener(onClickListener);
    }

    public final void i() {
        LeftTitleToRightArrowAdapter leftTitleToRightArrowAdapter = new LeftTitleToRightArrowAdapter();
        this.k = leftTitleToRightArrowAdapter;
        leftTitleToRightArrowAdapter.setSetLeftPadding(false);
        this.k.setOnItemClickListener(this.l);
        this.f2273g.setAdapter(this.k);
    }

    public final void j(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f2273g.getLayoutParams().height = displayMetrics.heightPixels - 500;
    }

    public final void k(List<LeftTitleToRightArrowVo> list) {
        this.k.initListData(list);
    }

    public void setIView(c.e.c.y.e.e eVar) {
        this.j = eVar;
    }

    public void setupData(MerchantDetailsVo merchantDetailsVo) {
        this.f2269c.setText(merchantDetailsVo.getMerchantName());
        this.f2270d.setText(merchantDetailsVo.getNotice());
        this.f2267a.loadImageToResourceVo(merchantDetailsVo.getCover());
        this.f2268b.loadImageToResourceVo(merchantDetailsVo.getLogo());
        if (merchantDetailsVo.getMerchantOpeningStatus() == null || merchantDetailsVo.getMerchantOpeningStatus().intValue() != 0) {
            this.f2271e.setVisibility(8);
        } else {
            this.f2271e.setVisibility(0);
        }
        MerchantDetailsVo.QualificationsBean qualifications = merchantDetailsVo.getQualifications();
        if (qualifications != null) {
            ArrayList arrayList = new ArrayList();
            LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo.setLeft(x.getString(R.string.title_merchant_service_phone));
            leftTitleToRightArrowVo.setRight(qualifications.getPhone());
            arrayList.add(leftTitleToRightArrowVo);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo2.setLeft(x.getString(R.string.title_merchant_contact_address));
            leftTitleToRightArrowVo2.setRight(merchantDetailsVo.getAddress());
            arrayList.add(leftTitleToRightArrowVo2);
            LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_licence_info));
            leftTitleToRightArrowVo3.setShowArrow(true);
            leftTitleToRightArrowVo3.setOnlyKey(1);
            if (qualifications.getLicence() != null) {
                leftTitleToRightArrowVo3.setExtObj(qualifications.getLicence());
                arrayList.add(leftTitleToRightArrowVo3);
            }
            k(arrayList);
        }
    }
}
