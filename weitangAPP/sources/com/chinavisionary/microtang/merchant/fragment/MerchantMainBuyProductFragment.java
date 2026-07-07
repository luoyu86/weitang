package com.chinavisionary.microtang.merchant.fragment;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearSmoothScroller;
import butterknife.BindView;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.y.c.g;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.buycart.vo.BuyCartProductVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.merchant.adapter.MerchantLeftMenuAdapter;
import com.chinavisionary.microtang.merchant.adapter.MerchantRightContentAdapter;
import com.chinavisionary.microtang.merchant.model.MerchantModel;
import com.chinavisionary.microtang.merchant.vo.BuyCartCountVo;
import com.chinavisionary.microtang.merchant.vo.CommodityKeyPositionVo;
import com.chinavisionary.microtang.merchant.vo.FoodDetailsInParam;
import com.chinavisionary.microtang.merchant.vo.MerchantDetailsVo;
import com.chinavisionary.microtang.merchant.vo.MerchantProductVo;
import com.chinavisionary.microtang.merchant.vo.MerchantRightContentVo;
import com.chinavisionary.microtang.merchant.vo.SpecificationsVo;
import com.chinavisionary.microtang.repair.vo.RepairLeftVo;
import com.chinavisionary.microtang.view.CustomTextView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MerchantMainBuyProductFragment extends BaseFragment<MerchantRightContentVo> {
    public int B;
    public MerchantLeftMenuAdapter C;
    public c.e.c.y.e.c D;
    public c.e.c.y.c.d E;
    public MerchantModel F;
    public MerchantDetailsVo G;
    public g H;
    public boolean I;
    public c.e.c.y.e.b J = new a();
    public c.e.a.a.c.c.a K = new c.e.a.a.c.c.a() { // from class: c.e.c.y.b.r
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f2242a.X1(view, i2);
        }
    };
    public c.e.a.a.c.c.a L = new c.e.a.a.c.c.a() { // from class: c.e.c.y.b.t
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f2244a.Z1(view, i2);
        }
    };
    public c.e.c.y.e.d M = new c.e.c.y.e.d() { // from class: c.e.c.y.b.n
        @Override // c.e.c.y.e.d
        public final void updateToPositionSelectedSpec(int i2, SpecificationsVo specificationsVo) {
            this.f2238a.b2(i2, specificationsVo);
        }
    };
    public c.e.c.y.e.a N = new b();

    @BindView(R.id.include_banner_layout)
    public View mBannerLayoutView;

    @BindView(R.id.tv_float_title)
    public CustomTextView mFloatTitleTv;

    @BindView(R.id.recycler_layout_left_menu)
    public BaseRecyclerView mLeftRecyclerView;

    @BindView(R.id.banner_view)
    public EditBannerView mMerchantActivityBanner;

    @BindView(R.id.swipe_refresh_layout_right)
    public BaseSwipeRefreshLayout mRightSwipeRefreshLayout;

    public class a implements c.e.c.y.e.b {
        public a() {
        }

        @Override // c.e.c.y.e.b
        public void buyCartList(List<BuyCartVo> list) {
            if (MerchantMainBuyProductFragment.this.D != null) {
                MerchantMainBuyProductFragment.this.D.buyCartList(list);
            }
            MerchantMainBuyProductFragment.this.o2(list);
        }

        @Override // c.e.c.y.e.b
        public Fragment getCurrentFragment() {
            return MerchantMainBuyProductFragment.this;
        }

        @Override // c.e.c.y.e.b
        public void setupBuyCartCountVo(BuyCartCountVo buyCartCountVo) {
            MerchantMainBuyProductFragment.this.l2(buyCartCountVo);
        }
    }

    public class b implements c.e.c.y.e.a {
        public b() {
        }

        @Override // c.e.c.y.e.a
        public void clearBuyCart() {
            MerchantMainBuyProductFragment.this.L1();
        }

        @Override // c.e.c.y.e.a
        public void updateSelectedSpecToFoodVo(BuyCartProductVo buyCartProductVo) {
            MerchantMainBuyProductFragment.this.L1();
        }
    }

    public class c implements CoreBaseFragment.d {
        public c() {
        }

        @Override // com.chinavisionary.core.app.base.CoreBaseFragment.d
        public void updatePosition(int i2, int i3) {
            MerchantMainBuyProductFragment.this.c2(i2);
        }
    }

    public class d extends LinearSmoothScroller {
        public d(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b() {
            MerchantMainBuyProductFragment.this.I = false;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int getVerticalSnapPreference() {
            return -1;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onStart() {
            super.onStart();
            MerchantMainBuyProductFragment.this.I = true;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onStop() {
            super.onStop();
            if (MerchantMainBuyProductFragment.this.f6488f != null) {
                MerchantMainBuyProductFragment.this.f6488f.postDelayed(new Runnable() { // from class: c.e.c.y.b.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2240a.b();
                    }
                }, 200L);
            }
        }
    }

    private void I0() {
        H();
        this.mRightSwipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: W1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X1(View view, int i2) {
        n2(i2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Y1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z1(View view, int i2) {
        e2(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b2(int i2, SpecificationsVo specificationsVo) {
        L1();
    }

    public static MerchantMainBuyProductFragment getInstance(MerchantDetailsVo merchantDetailsVo) {
        MerchantMainBuyProductFragment merchantMainBuyProductFragment = new MerchantMainBuyProductFragment();
        merchantMainBuyProductFragment.setMerchantDetailsVo(merchantDetailsVo);
        return merchantMainBuyProductFragment;
    }

    public final void L1() {
        if (O()) {
            this.E.getBuyCartToMerchantKey();
        }
    }

    public final CommodityKeyPositionVo M1(String str) {
        List<MerchantRightContentVo> list = this.t.getList();
        if (!o.isNotEmpty(list)) {
            return null;
        }
        CommodityKeyPositionVo commodityKeyPositionVo = new CommodityKeyPositionVo();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (MerchantRightContentVo merchantRightContentVo : list) {
            if (merchantRightContentVo != null && merchantRightContentVo.getFoodVo() != null) {
                String productKey = merchantRightContentVo.getFoodVo().getProductKey();
                if (x.isNotNull(productKey)) {
                    arrayList.add(productKey);
                    if (str.equals(productKey)) {
                        commodityKeyPositionVo.setPosition(i2);
                    }
                }
                i2++;
            }
        }
        commodityKeyPositionVo.setCommodityKeys(arrayList);
        return commodityKeyPositionVo;
    }

    public final void N1(ResponseRowsVo<EditBannerView.BannerDto> responseRowsVo) {
        if (responseRowsVo == null || !responseRowsVo.getSuccess()) {
            this.mMerchantActivityBanner.setVisibility(8);
        } else {
            this.mMerchantActivityBanner.setAdapterListData(responseRowsVo.getRows());
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void O1(ResponseRowsVo<MerchantProductVo> responseRowsVo) {
        List<RepairLeftVo> listHandleMerchantProductResult = this.H.handleMerchantProductResult(responseRowsVo, this.t);
        this.C.initListData(listHandleMerchantProductResult);
        RepairLeftVo repairLeftVo = (RepairLeftVo) o.getFirstElement(listHandleMerchantProductResult);
        if (repairLeftVo != null) {
            repairLeftVo.setSelect(true);
            m2(repairLeftVo.getTitle());
        }
        L1();
        I0();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void P1(View view, boolean z) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        int iIntValue2 = ((Integer) view.getTag(R.id.tv_spec_number)).intValue();
        if (m1()) {
            p2(iIntValue, iIntValue2);
        } else {
            ((MerchantRightContentVo) this.t.getList().get(iIntValue)).getFoodVo().setBuyNumber(z ? iIntValue2 - 1 : iIntValue2 + 1);
            this.t.notifyItemChanged(iIntValue);
        }
    }

    public final void Q1(View view) {
        EditBannerView.BannerDto bannerDto = (EditBannerView.BannerDto) view.getTag(R.id.edt_banner_view_img_path_id);
        if (x.isNotNull(bannerDto.getDataKey())) {
            String title = bannerDto.getTitle();
            super.c1(Integer.valueOf(bannerDto.getDataType()), bannerDto.getDataKey(), title);
            super.V0(title);
        }
    }

    public final void R1() {
        this.f6488f = new CoreBaseFragment.c(this);
        this.E = new c.e.c.y.c.d(this.J, this.f6484b);
        this.H = new g();
    }

    public final boolean S1() {
        boolean zK = K(FoodBuyCartFragment.class);
        if (zK) {
            g0();
        }
        return !zK;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.img_add_spec /* 2131231181 */:
            case R.id.img_btn_add /* 2131231196 */:
                P1(view, true);
                break;
            case R.id.img_btn_reduce /* 2131231200 */:
                P1(view, false);
                break;
            case R.id.tv_select_spec /* 2131232387 */:
                f2(view);
                break;
        }
        if (view.getId() == R.id.img_banner_pic) {
            Q1(view);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        R1();
        g2();
        h2();
        k2();
        i2();
        z0(R.string.loading_text);
        I1();
    }

    public final void c2(int i2) {
        if (!o.isNotEmpty(this.t.getList()) || this.t.getList().size() < i2) {
            return;
        }
        MerchantRightContentVo merchantRightContentVo = (MerchantRightContentVo) this.t.getList().get(i2);
        if (merchantRightContentVo.getItemType() == 101) {
            m2(merchantRightContentVo.getTitle());
            n2(merchantRightContentVo.getTitlePosition(), false);
        }
    }

    public final void d2() {
        if (m1() && S1()) {
            d(FoodBuyCartFragment.getInstance(this.N, this.f6484b), R.id.flayout_content);
        }
    }

    public final void e2(int i2) {
        MerchantDetailsVo merchantDetailsVo = this.G;
        if (merchantDetailsVo != null) {
            boolean z = merchantDetailsVo.getMerchantOpeningStatus() != null && this.G.getMerchantOpeningStatus().intValue() == 1;
            MerchantRightContentVo merchantRightContentVo = (MerchantRightContentVo) this.t.getList().get(i2);
            FoodDetailsInParam foodDetailsInParam = new FoodDetailsInParam();
            foodDetailsInParam.setiBuyCartView(this.J);
            foodDetailsInParam.setMerchantKey(this.f6484b);
            foodDetailsInParam.setProductKey(merchantRightContentVo.getFoodVo().getBaseKey());
            foodDetailsInParam.setMerchantName(this.G.getMerchantName());
            foodDetailsInParam.setMerchantPhone(this.G.getPhone());
            foodDetailsInParam.setOpenMerchant(z);
            CommodityKeyPositionVo commodityKeyPositionVoM1 = M1(foodDetailsInParam.getProductKey());
            K0(FoodDetailsTabFragment.getInstance(commodityKeyPositionVoM1.getCommodityKeys(), foodDetailsInParam, commodityKeyPositionVoM1.getPosition()), R.id.flayout_content);
        }
        q.d(MerchantMainBuyProductFragment.class.getSimpleName(), "position " + i2);
    }

    public final void f2(View view) {
        if (m1()) {
            int iIntValue = ((Integer) view.getTag()).intValue();
            MerchantRightContentVo.FoodVo foodVo = ((MerchantRightContentVo) this.t.getList().get(iIntValue)).getFoodVo();
            FoodSpecFragment foodSpecFragment = FoodSpecFragment.getInstance(foodVo.getBaseKey(), iIntValue);
            if (foodVo.getBuyNumber() > 0) {
                foodSpecFragment.setCommoditySelectSpecVo(foodVo.getSelectSpec());
                foodSpecFragment.setFoodVo(foodVo);
            }
            foodSpecFragment.setIFoodSpecUpdateCallback(this.M);
            d(foodSpecFragment, R.id.flayout_content);
        }
    }

    public final void g2() {
        this.mBannerLayoutView.setVisibility(0);
        this.mMerchantActivityBanner.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.dp_90);
        this.mMerchantActivityBanner.setFragment(null);
        this.mMerchantActivityBanner.setItemClickListener(this.y);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_merchant_main_buy_product_layout;
    }

    public final void h2() {
        MerchantLeftMenuAdapter merchantLeftMenuAdapter = new MerchantLeftMenuAdapter();
        this.C = merchantLeftMenuAdapter;
        merchantLeftMenuAdapter.setOnClickListener(this.y);
        this.C.setOnItemClickListener(this.K);
        this.mLeftRecyclerView.setAdapter(this.C);
    }

    public final void i2() {
        MerchantModel merchantModel = (MerchantModel) h(MerchantModel.class);
        this.F = merchantModel;
        merchantModel.getMerchantBannerResult().observe(this, new Observer() { // from class: c.e.c.y.b.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2243a.N1((ResponseRowsVo) obj);
            }
        });
        this.F.getMerchantProductResult().observe(this, new Observer() { // from class: c.e.c.y.b.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2241a.O1((ResponseRowsVo) obj);
            }
        });
        this.F.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.y.b.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2239a.C((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        this.F.getMerchantProductList(this.f6484b);
        this.F.getMerchantBanner(this.f6484b);
    }

    public final void j2(int i2) {
        d dVar = new d(this.f6486d);
        dVar.setTargetPosition(i2);
        this.r.getLayoutManager().startSmoothScroll(dVar);
    }

    public final void k2() {
        this.n = false;
        MerchantRightContentAdapter merchantRightContentAdapter = new MerchantRightContentAdapter();
        this.t = merchantRightContentAdapter;
        merchantRightContentAdapter.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.L);
        this.r = this.mRightSwipeRefreshLayout.getBaseRecyclerView();
        this.v = new c();
    }

    public final void l2(BuyCartCountVo buyCartCountVo) {
        c.e.c.y.e.c cVar = this.D;
        if (cVar != null) {
            cVar.updateBuyCart(buyCartCountVo);
        }
    }

    public final void m2(String str) {
        this.mFloatTitleTv.setText(str);
    }

    public final void n2(int i2, boolean z) {
        q.d(getClass().getSimpleName(), "position :" + i2 + ",mCacheLeftItemPosition:" + this.B + ",isLeftClick:" + z);
        if (this.B != i2) {
            RepairLeftVo repairLeftVo = this.C.getList().get(i2);
            if (!this.I) {
                this.C.getList().get(i2).setSelect(true);
                this.C.getList().get(this.B).setSelect(false);
                this.C.notifyItemChanged(this.B);
                this.B = i2;
                this.C.notifyItemChanged(i2);
            }
            if (z) {
                j2(repairLeftVo.getRelationPosition());
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void o2(List<BuyCartVo> list) {
        this.H.matchBuyCartProductList(list, this.t);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        L1();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void p2(int i2, int i3) {
        MerchantRightContentVo.FoodVo foodVo = ((MerchantRightContentVo) this.t.getList().get(i2)).getFoodVo();
        foodVo.setBuyNumber(i3);
        this.t.notifyItemChanged(i2);
        SpecificationsVo specificationsVo = (SpecificationsVo) o.getFirstElement(foodVo.getSpecifications());
        if (specificationsVo != null) {
            specificationsVo.setBuyNumber(i3);
            foodVo.setSelectSpec(specificationsVo);
            this.E.addToBuyCart(specificationsVo);
        }
    }

    public void setIBuyProductCallback(c.e.c.y.e.c cVar) {
        this.D = cVar;
    }

    public void setMerchantDetailsVo(MerchantDetailsVo merchantDetailsVo) {
        this.G = merchantDetailsVo;
        this.f6484b = merchantDetailsVo.getMerchantKey();
    }
}
