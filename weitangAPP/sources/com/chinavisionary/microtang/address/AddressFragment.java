package com.chinavisionary.microtang.address;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.address.adapter.AddressAdapter;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.room.vo.ExpressVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AddressFragment extends BaseFragment<ExpressVo> {
    public c.e.c.f.a B;
    public List<ExpressVo> C;
    public c.e.a.a.c.c.a D = new a();

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements c.e.a.a.c.c.a {
        public a() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            ExpressVo expressVo = (ExpressVo) AddressFragment.this.C.get(i2);
            AddressFragment.this.K1(expressVo.getAddressKey());
            AddressFragment.this.B.setupSelectAddress(expressVo);
            AddressFragment.this.n();
        }
    }

    public static AddressFragment getInstance(String str, c.e.c.f.a aVar) {
        AddressFragment addressFragment = new AddressFragment();
        addressFragment.setArguments(CoreBaseFragment.q(str));
        addressFragment.I1(aVar);
        return addressFragment;
    }

    public final void I1(c.e.c.f.a aVar) {
        this.B = aVar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void J1() {
        this.t = new AddressAdapter();
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        this.t.setOnItemClickListener(this.D);
        K1(this.f6484b);
        this.t.initListData((List<T>) this.C);
    }

    public final void K1(String str) {
        if (x.isNotNull(str)) {
            for (ExpressVo expressVo : this.C) {
                expressVo.setSelect(str.equals(expressVo.getAddressKey()));
            }
            this.t.notifyDataSetChanged();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_select_address);
        J1();
    }

    @OnClick({R.id.tv_back})
    public void backClick() {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_recycler;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    public void setExpressVos(List<ExpressVo> list) {
        this.C = list;
    }
}
