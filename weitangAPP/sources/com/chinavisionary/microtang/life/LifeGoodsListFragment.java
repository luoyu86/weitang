package com.chinavisionary.microtang.life;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import butterknife.BindView;
import c.e.a.d.x;
import c.e.b.c.d.e;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.clean.CleanDetailsActivity;
import com.chinavisionary.microtang.clean.model.NewCleanModel;
import com.chinavisionary.microtang.life.bo.RequestGetCouponGoodsParam;
import com.chinavisionary.microtang.life.event.FinishGoodsEvent;
import com.chinavisionary.microtang.main.adapter.LifeMainAdapter;
import com.chinavisionary.microtang.me.vo.CleanProductVo;
import g.b.a.m;

/* JADX INFO: loaded from: classes.dex */
public class LifeGoodsListFragment extends BaseFragment<CleanProductVo> {
    public e B;
    public NewCleanModel C;
    public final c.e.a.a.c.c.a D = new c.e.a.a.c.c.a() { // from class: c.e.c.t.g
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1842a.H1(view, i2);
        }
    };

    @BindView(R.id.img_back)
    public ImageView mBackImgView;

    @BindView(R.id.swipe_refresh_layout_life)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.edt_product_name_search)
    public EditText mProductNameSearchEdt;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            LifeGoodsListFragment.this.j0();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public class b extends GridLayoutManager.SpanSizeLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseRecyclerView f7248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseRecyclerAdapter f7249b;

        public b(BaseRecyclerView baseRecyclerView, BaseRecyclerAdapter baseRecyclerAdapter) {
            this.f7248a = baseRecyclerView;
            this.f7249b = baseRecyclerAdapter;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            return ((i2 == this.f7248a.getAdapter().getItemCount() - 1 && this.f7249b.isShowFooterView()) || ((CleanProductVo) this.f7249b.getList().get(i2)).getType() == 34952) ? 2 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: G1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H1(View view, int i2) {
        if (i2 < 0 || !(view.getTag() instanceof LifeMainAdapter.IncrementProductVH)) {
            return;
        }
        L1(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J1(ResponseRowsVo responseRowsVo) {
        if (responseRowsVo != null) {
            D(responseRowsVo.getRows());
        }
        E1();
        O1(null);
    }

    public static LifeGoodsListFragment getInstance(e eVar) {
        LifeGoodsListFragment lifeGoodsListFragment = new LifeGoodsListFragment();
        lifeGoodsListFragment.B = eVar;
        return lifeGoodsListFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void E1() {
        if (this.f6483a == 1 && this.t.getList().isEmpty()) {
            CleanProductVo cleanProductVo = new CleanProductVo();
            cleanProductVo.setType(34952);
            this.t.addDataToList((T) cleanProductVo);
        }
    }

    public final void K1(CleanProductVo cleanProductVo) {
        String strBigDecimalToString = x.bigDecimalToString(cleanProductVo.getPrice());
        Intent intent = new Intent(this.f6486d, (Class<?>) CleanDetailsActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", cleanProductVo.getValueaddedKey());
        intent.putExtra("payPriceKey", strBigDecimalToString);
        e eVar = this.B;
        if (eVar != null) {
            intent.putExtra("coupon_key", eVar.getCouponId());
        }
        startActivity(intent);
    }

    public final void L1(int i2) {
        CleanProductVo cleanProductVo = (CleanProductVo) this.t.getList().get(i2);
        if (cleanProductVo != null) {
            K1(cleanProductVo);
        }
    }

    public final void M1() {
        NewCleanModel newCleanModel = (NewCleanModel) h(NewCleanModel.class);
        this.C = newCleanModel;
        newCleanModel.getCouponGoodsListResult().observe(this, new Observer() { // from class: c.e.c.t.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1841a.J1((ResponseRowsVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.t.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1843a.O1((RequestErrDto) obj);
            }
        });
    }

    public final void N1() {
        this.mProductNameSearchEdt.addTextChangedListener(new a());
    }

    public final void O1(RequestErrDto requestErrDto) {
        H();
        if (requestErrDto != null) {
            B();
            C(requestErrDto);
        }
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.img_back) {
            m();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        h0(this);
        this.mBackImgView.setOnClickListener(this.y);
        p0(this.mBaseSwipeRefreshLayout);
        LifeMainAdapter lifeMainAdapter = new LifeMainAdapter();
        this.t = lifeMainAdapter;
        lifeMainAdapter.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.D);
        setupGridLayoutManager(this.t, this.r);
        M1();
        N1();
        z0(R.string.loading_text);
        j0();
    }

    @m
    public void eventFinish(FinishGoodsEvent finishGoodsEvent) {
        m();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_life_goods_list;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        if (this.B != null) {
            RequestGetCouponGoodsParam requestGetCouponGoodsParam = new RequestGetCouponGoodsParam();
            requestGetCouponGoodsParam.setName(this.mProductNameSearchEdt.getText().toString());
            requestGetCouponGoodsParam.setCouponTemplateKey(this.B.getCouponTemplateKey());
            this.C.getCouponGoodsList(requestGetCouponGoodsParam);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    public final void setupGridLayoutManager(BaseRecyclerAdapter<CleanProductVo> baseRecyclerAdapter, BaseRecyclerView baseRecyclerView) {
        if (baseRecyclerView == null || baseRecyclerAdapter == null) {
            return;
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(baseRecyclerView.getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new b(baseRecyclerView, baseRecyclerAdapter));
        baseRecyclerView.setLayoutManager(gridLayoutManager);
    }
}
