package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.adapter.FundAdapter;
import com.chinavisionary.microtang.me.bo.RequestFundNewsParamBo;
import com.chinavisionary.microtang.me.model.FundModel;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class FundNewsFragment extends BaseFragment<FundNewsVo> {
    public FundModel B;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements c.e.a.a.c.c.a {
        public a() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            FundNewsFragment.this.I1(view, i2);
        }
    }

    public static FundNewsFragment newInstance() {
        return new FundNewsFragment();
    }

    private void o0() {
        p0(this.mSwipeRefreshLayout);
        FundAdapter fundAdapter = new FundAdapter();
        this.t = fundAdapter;
        fundAdapter.setOnClickListener(this.y);
        this.t.setOnItemClickListener(new a());
    }

    public final RequestFundNewsParamBo F1() {
        RequestFundNewsParamBo requestFundNewsParamBo = new RequestFundNewsParamBo();
        PageBo pageBoR = r();
        requestFundNewsParamBo.setPpage(pageBoR.getPage());
        requestFundNewsParamBo.setPnumber(pageBoR.getPageNumber());
        return requestFundNewsParamBo;
    }

    public final void G1(NewResponseRowsVo<FundNewsVo> newResponseRowsVo) {
        this.mSwipeRefreshLayout.setRefreshing(false);
        if (newResponseRowsVo != null) {
            if (this.f6483a == 1 && o.listIsEmpty(newResponseRowsVo.getRows())) {
                H1();
            } else {
                D(newResponseRowsVo.getRows());
            }
        }
    }

    public final void H1() {
        ArrayList arrayList = new ArrayList();
        FundNewsVo fundNewsVo = new FundNewsVo();
        fundNewsVo.setItemType(34952);
        arrayList.add(fundNewsVo);
        D(arrayList);
    }

    public final void I1(View view, int i2) {
        FundNewsVo fundNewsVo = (FundNewsVo) this.t.getList().get(i2);
        int forwardType = fundNewsVo.getForwardType();
        fundNewsVo.getMessageType();
        if (forwardType == 1) {
            c1(Integer.valueOf(forwardType), fundNewsVo.getContent(), fundNewsVo.getTitle());
            return;
        }
        if (forwardType == 2) {
            c1(1, fundNewsVo.getH5Url(), fundNewsVo.getTitle());
            return;
        }
        if (forwardType != 3) {
            if (forwardType == 7) {
                c1(15, fundNewsVo.getMiniAppId(), fundNewsVo.getMiniPagePath());
            } else if (forwardType != 8) {
                c1(1, fundNewsVo.getContent(), fundNewsVo.getTitle());
            } else {
                c1(18, fundNewsVo.getMiniAppId(), fundNewsVo.getMiniPagePath());
            }
        }
    }

    public final void L1() {
        FundModel fundModel = (FundModel) h(FundModel.class);
        this.B = fundModel;
        fundModel.getFundNewsResult().observeForever(new Observer() { // from class: c.e.c.x.d.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2102a.G1((NewResponseRowsVo) obj);
            }
        });
        this.B.getErrRequestLiveData().observeForever(new Observer() { // from class: c.e.c.x.d.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2098a.C((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_fund_news);
        o0();
        L1();
        j0();
        H1();
    }

    @OnClick({R.id.tv_back})
    public void clickBack() {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_recycler;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.B.getFundNews(F1());
    }
}
