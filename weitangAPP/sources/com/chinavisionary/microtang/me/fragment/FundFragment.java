package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.x.c.c;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import com.chinavisionary.microtang.me.adapter.FundAdapter;
import com.chinavisionary.microtang.me.bo.RequestClickStatisticBo;
import com.chinavisionary.microtang.me.bo.RequestFundNewsParamBo;
import com.chinavisionary.microtang.me.model.FundModel;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class FundFragment extends BaseFragment<FundNewsVo> {
    public String B;
    public String C;
    public String D;
    public FundModel E;
    public final ReentrantLock F = new ReentrantLock();

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements c.e.a.a.c.c.a {
        public a() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            FundFragment.this.I1(view, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1() {
        this.t.notifyItemChanged(0);
    }

    public static FundFragment getInstance(String str, String str2, String str3) {
        FundFragment fundFragment = new FundFragment();
        fundFragment.D = str;
        fundFragment.B = str2;
        fundFragment.C = str3;
        return fundFragment;
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
        r();
        requestFundNewsParamBo.setPpage(1);
        requestFundNewsParamBo.setPnumber(3);
        return requestFundNewsParamBo;
    }

    public final void G1(NewResponseRowsVo<FundNewsVo> newResponseRowsVo) {
        this.mSwipeRefreshLayout.setRefreshing(false);
        if (newResponseRowsVo != null) {
            this.F.lock();
            try {
                ArrayList arrayList = new ArrayList(this.t.getList().subList(0, 2));
                if (o.isNotEmpty(newResponseRowsVo.getRows())) {
                    arrayList.addAll(newResponseRowsVo.getRows());
                } else {
                    FundNewsVo fundNewsVo = new FundNewsVo();
                    fundNewsVo.setItemType(34952);
                    arrayList.add(fundNewsVo);
                }
                D(arrayList);
            } finally {
                this.F.unlock();
            }
        }
    }

    public final void H1() {
        RequestClickStatisticBo requestClickStatisticBo = new RequestClickStatisticBo();
        if (x.isNullStr(this.C)) {
            this.C = "fund";
        }
        requestClickStatisticBo.setType(this.C);
        this.E.doClickStatistic(requestClickStatisticBo);
        if (x.isNullStr(this.D)) {
            this.D = "2019011162818890";
        }
        q.d(this.f6485c, "handleClickCatFundAccount appId = " + this.D + ", page = " + this.B);
        c1(18, this.D, this.B);
    }

    public final void I1(View view, int i2) {
        FundNewsVo fundNewsVo = (FundNewsVo) this.t.getList().get(i2);
        if (fundNewsVo.getItemType() != 34952) {
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
    }

    public final void J1(View view) {
        EditBannerView.BannerDto bannerDto = (EditBannerView.BannerDto) view.getTag(R.id.edt_banner_view_img_path_id);
        if (x.isNotNull(bannerDto.getTitle())) {
            String title = bannerDto.getTitle();
            String dataKey = bannerDto.getDataKey();
            if (x.isNotNull(bannerDto.getTargetAppid())) {
                int i2 = 15;
                if (x.isNotNull(bannerDto.getTargetMiniType()) && FundNewsVo.TYPE_ALIPAY.equals(bannerDto.getTargetMiniType())) {
                    i2 = 18;
                }
                super.c1(Integer.valueOf(i2), bannerDto.getTargetAppid(), bannerDto.getTargetPath());
            } else {
                super.c1(Integer.valueOf(bannerDto.getDataType()), dataKey, title);
            }
            V0(title);
            u1(bannerDto.getBaseKey());
        }
    }

    public final void O1() {
        FundModel fundModel = (FundModel) h(FundModel.class);
        this.E = fundModel;
        fundModel.getFundNewsResult().observeForever(new Observer() { // from class: c.e.c.x.d.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2094a.G1((NewResponseRowsVo) obj);
            }
        });
        this.E.getErrRequestLiveData().observeForever(new Observer() { // from class: c.e.c.x.d.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2085a.C((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.microtang.base.BaseFragment
    public void U0(RoomModelVo.ModulesBean modulesBean) {
        super.U0(modulesBean);
        if (modulesBean != null) {
            this.F.lock();
            try {
                ((FundNewsVo) this.t.getList().get(0)).setListData(modulesBean.getBannerDtoList());
                this.mTitleTv.post(new Runnable() { // from class: c.e.c.x.d.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2089a.N1();
                    }
                });
            } finally {
                this.F.unlock();
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.img_banner_pic) {
            J1(view);
        } else if (view.getId() == R.id.btn_cat_fund_account) {
            H1();
        } else if (view.getId() == R.id.tv_cat_more) {
            d(FundNewsFragment.newInstance(), R.id.flayout_content);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_fund);
        this.mSwipeRefreshLayout.setBackgroundColor(getResources().getColor(R.color.colorF8F8F8));
        o0();
        O1();
        z1();
        w1("fund");
        D(c.getInstance().getFundData());
        j0();
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
        this.E.getFundNews(F1());
        w1("fund");
    }
}
