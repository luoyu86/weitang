package com.chinavisionary.microtang.clean;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.b0;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.m0.c;
import c.e.c.m0.d;
import c.e.c.m0.l;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.event.EventUpdateUserInfoVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.framework.mobile.comment.vo.CommentListItemVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.clean.adapter.CleanCommendAdapter;
import com.chinavisionary.microtang.clean.model.CleanModel;
import com.chinavisionary.microtang.clean.model.NewCleanModel;
import com.chinavisionary.microtang.clean.vo.CreateCleanOrderVo;
import com.chinavisionary.microtang.life.SubmitLifeOrderFragment;
import com.chinavisionary.microtang.life.event.FinishGoodsEvent;
import com.chinavisionary.microtang.me.vo.CleanProductDetailsVo;
import com.chinavisionary.microtang.me.vo.CleanProductVo;
import com.chinavisionary.microtang.sign.view.BaseWebView;
import com.chinavisionary.paymentlibrary.PayTypeFragment;
import com.chinavisionary.paymentlibrary.model.NewBillModel;
import com.chinavisionary.paymentlibrary.vo.CreateIncrementOrderParamBo;
import com.chinavisionary.paymentlibrary.vo.PayBillResultVo;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import com.chinavisionary.paymentlibrary.vo.ResponseH5BillDetailsVo;
import com.lzy.ninegrid.preview.ImagePreviewActivity;
import g.b.a.m;
import g.b.a.r;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CleanDetailsFragment extends BaseFragment<CommentListItemVo> {
    public EditBannerView B;
    public BaseWebView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public List<ResourceVo> H;
    public CleanModel I;
    public NewCleanModel J;
    public NewBillModel K;
    public String L;
    public String M;
    public ResponseH5BillDetailsVo N;
    public String O;
    public int P;
    public boolean Q = true;
    public boolean R = false;
    public boolean S = false;
    public boolean T = false;

    @BindView(R.id.swipe_refresh_layout_clean_details)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.view_title_bg)
    public View mTitleBgView;

    @BindView(R.id.tv_title_split_line)
    public TextView mTitleLineTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.proceed();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str != null && str.contains("peanut.html")) {
                str = "";
            }
            CleanDetailsFragment.this.c1(1, str, CleanDetailsFragment.this.mTitleTv.getText().toString());
            return true;
        }
    }

    public class b implements BaseWebView.f {
        public b() {
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.f
        public void catPic(int i2) {
            CleanDetailsFragment.this.V1(i2);
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.f
        public void catSignPic(String str) {
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.f
        public void onImagePreview(String str) {
        }
    }

    private void I0() {
        H();
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: R1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S1(RequestErrDto requestErrDto) {
        if (requestErrDto != null) {
            G0(requestErrDto.getErrMsg());
        }
        I0();
    }

    public static CleanDetailsFragment getInstance(String str, String str2, String str3, int i2) {
        CleanDetailsFragment cleanDetailsFragment = new CleanDetailsFragment();
        cleanDetailsFragment.setArguments(CoreBaseFragment.q(str));
        cleanDetailsFragment.a2(str2);
        cleanDetailsFragment.M = str3;
        cleanDetailsFragment.P = i2;
        return cleanDetailsFragment;
    }

    public final List<c.k.b.a> G1() {
        ArrayList arrayList = new ArrayList();
        List<ResourceVo> list = this.H;
        if (list != null && !list.isEmpty()) {
            int size = this.H.size();
            for (int i2 = 0; i2 < size; i2++) {
                c.k.b.a aVar = new c.k.b.a();
                ResourceVo resourceVo = this.H.get(i2);
                if (resourceVo != null) {
                    aVar.setBigImageUrl(resourceVo.getUrl());
                    aVar.setThumbnailUrl(resourceVo.getUrl());
                }
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public final void H1() {
        if (this.N != null) {
            H();
            W1(this.N);
            return;
        }
        z0(R.string.loading_text);
        CreateIncrementOrderParamBo createIncrementOrderParamBo = new CreateIncrementOrderParamBo();
        createIncrementOrderParamBo.setCommodityId(this.f6484b);
        createIncrementOrderParamBo.setSpaceId(v());
        createIncrementOrderParamBo.setPayChannel(1);
        this.K.createNewCleanOrder(createIncrementOrderParamBo);
    }

    public final void I1(String str) {
        q.d(this.f6485c, "createOrder method = " + str + ", ifOrderPage = " + this.T);
        if (this.T) {
            h2();
        } else {
            H1();
        }
    }

    public final void J1() {
        NewCleanModel newCleanModel = this.J;
        if (newCleanModel != null) {
            newCleanModel.getCleanDetails(this.f6484b);
        } else {
            this.I.getCleanDetails(this.f6484b);
        }
    }

    public final void K1(PayBillResultVo payBillResultVo) {
        if (payBillResultVo != null) {
            ResponseH5BillDetailsVo responseH5BillDetailsVo = new ResponseH5BillDetailsVo();
            this.N = responseH5BillDetailsVo;
            responseH5BillDetailsVo.setOrderId(payBillResultVo.getPaymentKey());
            if (this.L != null) {
                this.N.setActualAmount(new BigDecimal(this.L));
            }
            I1("handleIncrementPayBillResult");
        }
    }

    public final void L1(ResponseRowsVo<CleanProductVo> responseRowsVo) {
    }

    public final void M1(boolean z) {
        try {
            String string = this.E.getText().toString();
            if (this.R || !x.isNotNull(string)) {
                return;
            }
            this.R = true;
            String string2 = "";
            int i2 = this.P;
            if (i2 == 2) {
                string2 = x.getString(R.string.title_wt_clear);
            } else if (i2 == 4) {
                string2 = x.getString(R.string.title_wt_food);
            } else if (i2 == 6) {
                string2 = x.getString(R.string.title_wt_preferred);
            }
            q.d(this.f6485c, "handleProductMonitor isOrder = " + z);
            e1(string, string2, z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void N1(RequestErrDto requestErrDto) {
        if (requestErrDto != null) {
            int code = requestErrDto.getCode();
            boolean zOpenTipActivity = c.getInstance().openTipActivity(this.f6487e, code);
            q.d(this.f6485c, "handleResponseErr errCode = " + code);
            if (zOpenTipActivity) {
                n();
            }
        }
        I0();
    }

    public final List<EditBannerView.BannerDto> U1(List<ResourceVo> list) {
        this.H = list;
        ArrayList arrayList = new ArrayList();
        this.D.setText(String.valueOf(list.size()));
        if (!list.isEmpty()) {
            int i2 = 0;
            for (ResourceVo resourceVo : list) {
                if (resourceVo != null) {
                    EditBannerView.BannerDto bannerDto = new EditBannerView.BannerDto();
                    bannerDto.setBaseKey(resourceVo.getBaseKey());
                    bannerDto.setCover(resourceVo);
                    bannerDto.setKey(resourceVo.getKey());
                    bannerDto.setTitle(resourceVo.getKey());
                    bannerDto.setForwardType(i2);
                    bannerDto.setPicFitXy(false);
                    arrayList.add(bannerDto);
                    i2++;
                }
            }
        }
        return arrayList;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.img_banner_pic) {
            X1(((EditBannerView.BannerDto) view.getTag(R.id.edt_banner_view_img_path_id)).getForwardType());
        }
    }

    public final void V1(int i2) {
        ArrayList<String> imgSrcList = this.C.getImgSrcList();
        ArrayList arrayList = new ArrayList();
        for (String str : imgSrcList) {
            c.k.b.a aVar = new c.k.b.a();
            aVar.setBigImageUrl(str);
            aVar.setThumbnailUrl(str);
            arrayList.add(aVar);
        }
        Intent intent = new Intent(this.f6487e, (Class<?>) ImagePreviewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("IMAGE_INFO", arrayList);
        bundle.putInt("CURRENT_ITEM", i2);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleLineTv.setVisibility(8);
        this.mTitleBgView.setVisibility(0);
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        this.t = new CleanCommendAdapter();
        AppConfigExtVo appConfigExtVoO = o();
        if (appConfigExtVoO != null) {
            this.O = appConfigExtVoO.getValueaddTip();
        }
        b2();
        d2();
        this.mTitleTv.setText(R.string.title_product_info_details);
        CleanProductDetailsVo cleanProductDetailsVo = d.getInstance().getCleanProductDetailsVo(this.f6484b);
        if (cleanProductDetailsVo != null) {
            this.S = true;
            e2(cleanProductDetailsVo);
        } else {
            z0(R.string.loading_text);
        }
        j0();
    }

    public final void W1(ResponseH5BillDetailsVo responseH5BillDetailsVo) {
        CreateCleanOrderVo createCleanOrderVo = new CreateCleanOrderVo();
        createCleanOrderVo.setValueaddedKey(this.f6484b);
        createCleanOrderVo.setRoomKey(v());
        PayTypeVo payTypeVo = new PayTypeVo();
        payTypeVo.setType(17);
        payTypeVo.setPrice(this.L);
        payTypeVo.setResStrId(R.string.title_pay_increment_fee);
        payTypeVo.setCouponKey(this.M);
        payTypeVo.setTitle(this.E.getText().toString());
        payTypeVo.setInitBJPay(c.e.a.a.a.getInstance().isBjIncrement());
        payTypeVo.setExtJson(JSON.toJSONString(createCleanOrderVo));
        payTypeVo.setResponseH5BillDetailsVoJson(JSON.toJSONString(responseH5BillDetailsVo));
        K0(PayTypeFragment.getInstance(payTypeVo), R.id.flayout_content);
        Z1();
    }

    public final void X1(int i2) {
        Intent intent = new Intent(this.f6487e, (Class<?>) ImagePreviewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("IMAGE_INFO", (Serializable) G1());
        bundle.putInt("CURRENT_ITEM", i2);
        intent.putExtras(bundle);
        this.f6487e.startActivity(intent);
        this.f6487e.overridePendingTransition(0, 0);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void Y(int i2, int i3) {
    }

    public final void Y1() {
        if (this.P != -1) {
            this.J.getCleanList(r(), R0(), v(), this.P);
        }
    }

    public final void Z1() {
        if (this.M != null) {
            k(new FinishGoodsEvent());
        }
    }

    public final void a2(String str) {
        this.L = str;
    }

    public final void b2() {
        View viewInflate = LayoutInflater.from(this.f6487e).inflate(R.layout.item_clean_details_head_layout, (ViewGroup) null);
        this.C = (BaseWebView) viewInflate.findViewById(R.id.web_view_clean_info);
        this.B = (EditBannerView) viewInflate.findViewById(R.id.view_pager_clean_cover);
        this.D = (TextView) viewInflate.findViewById(R.id.tv_cover_pic_number);
        this.E = (TextView) viewInflate.findViewById(R.id.tv_title_name);
        this.F = (TextView) viewInflate.findViewById(R.id.tv_price);
        this.G = (TextView) viewInflate.findViewById(R.id.tv_src_price);
        this.t.addHeadView(viewInflate);
        TextView textView = this.G;
        textView.setPaintFlags(textView.getPaintFlags() | 16);
        g2();
        f2();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    public final void c2(CleanProductDetailsVo cleanProductDetailsVo) {
        if (cleanProductDetailsVo == null) {
            cleanProductDetailsVo = new CleanProductDetailsVo();
        }
        q.d(this.f6485c, "setupDetails: " + cleanProductDetailsVo.getAlbumPhotos());
        I0();
        if (!O()) {
            b0.getInstance().setProductKey(cleanProductDetailsVo.getKey());
        }
        this.T = cleanProductDetailsVo.isIfOrderPage();
        d.getInstance().addLifeDetails(cleanProductDetailsVo.getKey(), cleanProductDetailsVo);
        if (this.S) {
            return;
        }
        e2(cleanProductDetailsVo);
    }

    public final void d2() {
        if (c.e.a.a.a.getInstance().isBjIncrement()) {
            NewCleanModel newCleanModel = (NewCleanModel) h(NewCleanModel.class);
            this.J = newCleanModel;
            newCleanModel.getDetailsLiveData().observe(this, new Observer() { // from class: c.e.c.l.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1649a.c2((CleanProductDetailsVo) obj);
                }
            });
            this.J.getListMutableLiveData().observe(this, new Observer() { // from class: c.e.c.l.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1648a.L1((ResponseRowsVo) obj);
                }
            });
            this.J.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.l.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1646a.N1((RequestErrDto) obj);
                }
            });
            NewBillModel newBillModel = (NewBillModel) h(NewBillModel.class);
            this.K = newBillModel;
            newBillModel.getIncrementPayBillResultLiveData().observe(this, new Observer() { // from class: c.e.c.l.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1650a.K1((PayBillResultVo) obj);
                }
            });
            this.K.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.l.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1647a.S1((RequestErrDto) obj);
                }
            });
        }
        CleanModel cleanModel = (CleanModel) h(CleanModel.class);
        this.I = cleanModel;
        cleanModel.getDetailsLiveData().observe(this, new Observer() { // from class: c.e.c.l.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1649a.c2((CleanProductDetailsVo) obj);
            }
        });
        this.I.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.l.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1646a.N1((RequestErrDto) obj);
            }
        });
    }

    public final void e2(CleanProductDetailsVo cleanProductDetailsVo) {
        this.T = cleanProductDetailsVo.isIfOrderPage();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cleanProductDetailsVo.getCover());
        if (cleanProductDetailsVo.getAlbumPhotos() != null) {
            arrayList.addAll(cleanProductDetailsVo.getAlbumPhotos());
        }
        this.E.setText(x.getNotNullStr(cleanProductDetailsVo.getName(), ""));
        l.setupPrice(cleanProductDetailsVo.getPrice(), this.F);
        a2(x.bigDecimalToString(cleanProductDetailsVo.getPrice()));
        this.G.setText(x.bigDecimalToString(cleanProductDetailsVo.getUnderlinePrice()));
        this.G.setVisibility(cleanProductDetailsVo.getUnderlinePrice() != null ? 0 : 8);
        List<EditBannerView.BannerDto> listU1 = U1(arrayList);
        if (listU1 != null) {
            this.B.setAdapterListData(listU1);
        }
        String desc = cleanProductDetailsVo.getDesc();
        if (x.isNotNull(desc)) {
            if ("http".indexOf(desc) == 0) {
                this.C.loadUrl(desc);
            } else {
                this.C.loadHtmlContent(cleanProductDetailsVo.getDesc(), true);
            }
        }
    }

    public final void f2() {
        this.B.setItemClickListener(this.y);
        this.B.setFragment(null);
    }

    public final void g2() {
        this.C.setWebViewClient(new a());
        this.C.setIWebViewJsListener(new b());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_clean_details;
    }

    public final void h2() {
        d(SubmitLifeOrderFragment.getInstance(this.f6484b, this.E.getText().toString(), this.L, this.M), R.id.flayout_content);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        J1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        M1(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        b0.getInstance().setBuy(true);
    }

    @m(threadMode = r.BACKGROUND)
    public void registerEventUpdateUserInfoVo(EventUpdateUserInfoVo eventUpdateUserInfoVo) {
        int whatMsg = eventUpdateUserInfoVo.getWhatMsg();
        if (whatMsg == 0 || whatMsg == 2) {
            return;
        }
        j0();
        Y1();
    }

    @OnClick({R.id.btn_subscribe_clean})
    public void subscribeClean(View view) {
        M1(true);
        if (N()) {
            if (!Q()) {
                G0(x.isNotNull(this.O) ? this.O : x.getString(R.string.tip_is_not_rent));
            } else if (this.Q) {
                I1("subscribeClean");
            } else {
                F0(R.string.tip_not_can_buy_goods);
            }
        }
    }
}
