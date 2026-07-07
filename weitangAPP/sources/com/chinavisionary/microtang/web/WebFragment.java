package com.chinavisionary.microtang.web;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import anet.channel.util.HttpConstant;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.b0;
import c.e.a.d.l;
import c.e.a.d.n;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.b.c.d.i;
import c.e.b.c.d.m;
import c.e.b.c.d.o;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.event.EventUpdateUserInfoVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadImgVo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.alert.SharedAlertFragment;
import com.chinavisionary.microtang.auth.IDAuthActivity;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.clean.CleanDetailsActivity;
import com.chinavisionary.microtang.life.activity.LifeGoodsListActivity;
import com.chinavisionary.microtang.login.LoginActivity;
import com.chinavisionary.microtang.login.bo.EventUpdateUserAlertMessage;
import com.chinavisionary.microtang.map.MapDialogFragment;
import com.chinavisionary.microtang.me.vo.EventContract;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import com.chinavisionary.microtang.pdf.PdfActivity;
import com.chinavisionary.microtang.room.RoomSourceDetailsActivity;
import com.chinavisionary.microtang.room.vo.EventFinish;
import com.chinavisionary.microtang.sign.fragments.ContractConfirmFragment;
import com.chinavisionary.microtang.sign.view.BaseWebView;
import com.chinavisionary.microtang.sign.view.NestedScrollWebView;
import com.chinavisionary.microtang.sign.vo.ResponseFddVo;
import com.chinavisionary.microtang.vo.EventUpdateRentState;
import com.chinavisionary.microtang.web.bridge.BridgeWebViewActivity;
import com.chinavisionary.microtang.web.event.EventReloadWebView;
import com.chinavisionary.microtang.web.model.PublicModel;
import com.chinavisionary.microtang.web.vo.EventUpdateOpenLockVo;
import com.chinavisionary.microtang.web.vo.EventUpdateWebPayStatus;
import com.chinavisionary.microtang.web.vo.PdfPreviewVo;
import com.chinavisionary.microtang.web.vo.ResponseArticleVo;
import com.chinavisionary.microtang.web.vo.UploadResponseBo;
import com.chinavisionary.microtang.web.vo.WebViewImagePreviewBo;
import com.chinavisionary.paymentlibrary.PayTypeActivity;
import com.chinavisionary.twlib.open.OpenDoorActivity;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.ninegrid.preview.ImagePreviewActivity;
import g.b.a.r;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class WebFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public String B;
    public ResponseFddVo C;
    public String D;
    public PublicModel E;
    public ImageView F;
    public boolean G;
    public ValueCallback<Uri[]> H;
    public int I;
    public boolean K;
    public List<LeftTitleToRightArrowVo> L;
    public c.e.b.c.a.c M;
    public c.e.b.c.a.b N;
    public c.e.b.a.d O;

    @BindView(R.id.recycler_view_command)
    public BaseRecyclerView mCommandRecyclerView;

    @BindView(R.id.ll_err_tip)
    public LinearLayout mLinearLayout;

    @BindView(R.id.progress_bar)
    public ProgressBar mProgressBar;

    @BindView(R.id.img_web_right)
    public ImageView mRightIv;

    @BindView(R.id.tv_title_right)
    public TextView mTitleRightTv;

    @BindView(R.id.tv_title_split_line)
    public TextView mTitleSplitLineTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    @BindView(R.id.web_view)
    public NestedScrollWebView mWebView;
    public boolean J = true;
    public final c.e.a.a.c.c.a P = new c.e.a.a.c.c.a() { // from class: c.e.c.o0.b
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1791a.J2(view, i2);
        }
    };
    public final c.e.b.c.c.a Q = new a();
    public final BaseWebView.h R = new b();
    public final BaseWebView.g S = new c();
    public final c.e.b.c.c.b T = new d();
    public View.OnLongClickListener U = new h();

    public class a implements c.e.b.c.c.a {
        public a() {
        }

        @Override // c.e.b.c.c.a
        public void addFragmentToActivity(i iVar, boolean z) {
            WebFragment.this.c0(PayTypeActivity.class, JSON.toJSONString(iVar));
        }

        @Override // c.e.b.c.c.a
        public void performActivityEvaluateActivity(String str) {
        }

        @Override // c.e.b.c.c.a
        public void performAuthActivity() {
            WebFragment.this.d0(IDAuthActivity.class);
        }

        @Override // c.e.b.c.c.a
        public void performCallPhone(String str) {
            WebFragment.this.f(str);
        }

        @Override // c.e.b.c.c.a
        public void performChooseImage(c.e.b.a.d dVar, int i2, c.e.b.c.d.d dVar2) {
            WebFragment.this.O = dVar;
            WebFragment.this.S2(i2, dVar2 != null && dVar2.getSourceType() != null && dVar2.getSourceType().size() == 1 && dVar2.getSourceType().contains(c.e.b.c.d.d.SOURCE_TYPE_CAMERA));
        }

        @Override // c.e.b.c.c.a
        public void performContractActivity(@NonNull String str) {
            if (!x.isNotNull(str)) {
                WebFragment.this.F0(R.string.title_electric_contract_empty);
                return;
            }
            try {
                PdfPreviewVo pdfPreviewVo = (PdfPreviewVo) JSON.parseObject(str, PdfPreviewVo.class);
                if (x.isNotNull(pdfPreviewVo.getName()) && x.isNotNull(pdfPreviewVo.getContract_downloadUrl())) {
                    Intent intent = new Intent(WebFragment.this.f6487e, (Class<?>) PdfActivity.class);
                    intent.putExtra("titleKey", pdfPreviewVo.getName());
                    intent.putExtra("key", pdfPreviewVo.getContract_downloadUrl());
                    WebFragment.this.startActivity(intent);
                } else {
                    WebFragment.this.F0(R.string.title_electric_contract_empty);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // c.e.b.c.c.a
        public void performFinishActivity() {
            WebFragment.this.m();
        }

        @Override // c.e.b.c.c.a
        public void performLogin() {
            if (WebFragment.this.isResumed()) {
                WebFragment.this.d0(LoginActivity.class);
            }
        }

        @Override // c.e.b.c.c.a
        public void performMainActivity() {
            WebFragment.this.m();
        }

        @Override // c.e.b.c.c.a
        public void performMap(@NonNull c.e.b.c.d.h hVar) {
            WebFragment.this.W2(hVar);
        }

        @Override // c.e.b.c.c.a
        public void performOpenImagePreview(List<String> list, int i2) {
            WebFragment.this.T2(list, i2);
        }

        @Override // c.e.b.c.c.a
        public void performProductDetailsActivity(@NonNull String str, c.e.b.c.d.e eVar) {
            if (!x.isNotNull(str)) {
                WebFragment.this.F0(R.string.tip_product_key_is_empty);
            } else if (eVar != null) {
                WebFragment.this.Q2(eVar);
            } else {
                WebFragment.this.c0(CleanDetailsActivity.class, str);
            }
        }

        @Override // c.e.b.c.c.a
        public void performReportAbnormalBo(@NonNull m mVar) {
            WebFragment.this.z2(mVar);
        }

        @Override // c.e.b.c.c.a
        public void performRoomSourceActivity(@NonNull String str, String str2) {
            if (!x.isNotNull(str)) {
                WebFragment.this.F0(R.string.tip_room_key_empty);
                return;
            }
            if (!x.isNotNull(str2)) {
                WebFragment.this.c0(RoomSourceDetailsActivity.class, str);
                return;
            }
            Intent intent = new Intent(WebFragment.this.f6487e, (Class<?>) RoomSourceDetailsActivity.class);
            intent.putExtra("key", str);
            intent.putExtra("open_sign_url_key", str2);
            WebFragment.this.startActivity(intent);
        }

        @Override // c.e.b.c.c.a
        public void performStartActivity(Intent intent) {
            if (intent != null) {
                intent.setClass(WebFragment.this.f6487e, BridgeWebViewActivity.class);
                WebFragment.this.startActivity(intent);
            }
        }

        @Override // c.e.b.c.c.a
        public void performUpdateUserInfo() {
            EventUpdateUserInfoVo eventUpdateUserInfoVo = new EventUpdateUserInfoVo();
            eventUpdateUserInfoVo.setWhatMsg(0);
            WebFragment.this.k(eventUpdateUserInfoVo);
        }

        @Override // c.e.b.c.c.a
        public void performWeChartShared(@NonNull o oVar) {
            WebFragment.this.X2(oVar);
        }

        @Override // c.e.b.c.c.a
        public void performWxMiniProgram(@NonNull String str) {
            if (!x.isNotNull(str)) {
                WebFragment.this.F0(R.string.tip_open_failed_param_failed);
                return;
            }
            try {
                AlertMessageVo alertMessageVo = (AlertMessageVo) JSON.parseObject(str, AlertMessageVo.class);
                if (alertMessageVo == null) {
                    WebFragment.this.F0(R.string.tip_open_failed_param_failed);
                    return;
                }
                if (!x.isNotNull(alertMessageVo.getTargetAppid()) || !x.isNotNull(alertMessageVo.getTargetPath())) {
                    WebFragment.this.F0(R.string.tip_open_failed_param_failed);
                    return;
                }
                int i2 = 15;
                if (x.isNotNull(alertMessageVo.getTargetMiniType()) && FundNewsVo.TYPE_ALIPAY.equals(alertMessageVo.getTargetMiniType())) {
                    i2 = 18;
                }
                WebFragment.this.c1(Integer.valueOf(i2), alertMessageVo.getTargetAppid(), alertMessageVo.getTargetPath());
            } catch (Exception e2) {
                e2.printStackTrace();
                WebFragment.this.F0(R.string.tip_open_failed_param_failed);
            }
        }

        @Override // c.e.b.c.c.a
        public void setupAppBarStyle(c.e.b.c.d.b bVar) {
            if (WebFragment.this.J) {
                WebFragment.this.D2(bVar);
            }
        }
    }

    public class b implements BaseWebView.h {
        public b() {
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.h
        public void openLockToRoomKey(String str) {
            WebFragment.this.V2(str);
        }
    }

    public class c implements BaseWebView.g {
        public c() {
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.g
        public void doCellPhone(String str) {
            WebFragment.this.f(str);
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.g
        public void doLogin() {
            WebFragment.this.g();
            WebFragment.this.N();
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.g
        public String getTitle() {
            q.d(WebFragment.class.getSimpleName(), "getTitle :" + WebFragment.this.B);
            return x.getNotNullStr(WebFragment.this.B, "");
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.g
        public void onIdCardAuthentication() {
            WebFragment.this.d0(IDAuthActivity.class);
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.g
        public void showBack() {
            q.d(WebFragment.class.getSimpleName(), "showBack");
        }
    }

    public class d implements c.e.b.c.c.b {
        public d() {
        }

        @Override // c.e.b.c.c.b
        public void handle404Page(String str) {
            WebFragment.this.e3(0);
            q.d(WebFragment.class.getSimpleName(), "handle404Page httpUrl:" + str);
        }

        @Override // c.e.b.c.c.b
        public void handlerFddSignSuccess(String str) {
            WebFragment.this.C2(str);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8693a;

        public e(int i2) {
            this.f8693a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebFragment.this.mLinearLayout.setVisibility(this.f8693a);
        }
    }

    public class f extends WebChromeClient {
        public f() {
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            q.d(WebFragment.this.f6485c, "onPermissionRequest request = ");
            if (Build.VERSION.SDK_INT >= 23) {
                WebFragment.this.x2();
                try {
                    permissionRequest.grant(permissionRequest.getResources());
                    permissionRequest.getOrigin();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            super.onProgressChanged(webView, i2);
            ProgressBar progressBar = WebFragment.this.mProgressBar;
            if (progressBar != null) {
                if (progressBar.getVisibility() == 8) {
                    WebFragment.this.mProgressBar.setVisibility(0);
                }
                if (i2 > 98) {
                    WebFragment.this.mProgressBar.setVisibility(8);
                }
                WebFragment.this.mProgressBar.setProgress(i2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (!x.isNotNull(str) || str.indexOf("http") == 0 || str.contains("html") || str.contains("jpg")) {
                return;
            }
            WebFragment.this.mTitleTv.setText(str);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            WebFragment.this.P2(valueCallback);
            return true;
        }
    }

    public class g implements BaseWebView.f {
        public g() {
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.f
        public void catPic(int i2) {
            WebFragment.this.R2(i2);
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.f
        public void catSignPic(String str) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            WebFragment.this.U2(arrayList, 0);
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.f
        public void onImagePreview(String str) {
            try {
                WebViewImagePreviewBo webViewImagePreviewBo = (WebViewImagePreviewBo) JSON.parseObject(str, WebViewImagePreviewBo.class);
                WebFragment.this.U2(webViewImagePreviewBo.getPicList(), webViewImagePreviewBo.getPosition());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public class h implements View.OnLongClickListener {
        public h() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z = view instanceof ImageView;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: F2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G2() {
        this.mWebView.sendHandleName("reload");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J2(View view, int i2) {
        y2(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L2() {
        int height = this.u.getHeight();
        q.d(getClass().getSimpleName(), "mWebView height:" + height);
        c.e.b.c.a.a.assistActivity(this.u, this.f6487e, height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N2(ResponseArticleVo responseArticleVo) {
        if (responseArticleVo != null) {
            this.D = responseArticleVo.getArticleContent();
            O2();
        }
        H();
    }

    public static WebFragment getInstance(String str) {
        WebFragment webFragment = new WebFragment();
        webFragment.setArguments(CoreBaseFragment.q(str));
        return webFragment;
    }

    public final void A2(c.e.b.c.d.b bVar) {
        this.mTitleRightTv.setVisibility(0);
        q.d(getClass().getSimpleName(), "handleTitleRightView text = " + bVar.getRightButtonText());
        if (this.M.isNeedSetRightTv(bVar.getRight())) {
            this.mTitleRightTv.setText(bVar.getRightButtonText());
        } else {
            this.mTitleRightTv.setText(bVar.getRight());
        }
        if (bVar.getRightColor() != null) {
            this.mTitleRightTv.setTextColor(Color.parseColor(bVar.getRightColor()));
        }
    }

    public final void B2(UploadResponseDto uploadResponseDto) {
        H();
        ArrayList arrayList = new ArrayList();
        List<ResponseUploadImgVo> uploadSuccessList = uploadResponseDto.getUploadSuccessList();
        if (c.e.a.d.o.isNotEmpty(uploadSuccessList)) {
            for (ResponseUploadImgVo responseUploadImgVo : uploadSuccessList) {
                if (responseUploadImgVo != null) {
                    UploadResponseBo uploadResponseBo = new UploadResponseBo();
                    uploadResponseBo.setFileKey(responseUploadImgVo.getKey());
                    uploadResponseBo.setFileUrl(responseUploadImgVo.getSourceUrl());
                    arrayList.add(uploadResponseBo);
                }
            }
            if (c.e.a.d.o.isNotEmpty(arrayList)) {
                c.e.b.a.d dVar = this.O;
                if (dVar != null) {
                    dVar.onCallBack(JSON.toJSONString(arrayList));
                }
            } else {
                F0(R.string.tip_upload_failed);
            }
        } else {
            F0(R.string.tip_upload_failed);
        }
        this.O = null;
    }

    public final void C2(String str) {
        if (this.C == null || !x.isNotNull(str)) {
            return;
        }
        String returnUrl = this.C.getReturnUrl();
        if (!x.isNotNull(returnUrl)) {
            G0("return url 为空.");
            return;
        }
        q.d(getClass().getSimpleName(), "handlerSignSuccess url:" + str + ", hash:" + returnUrl);
        if (str.contains(returnUrl)) {
            f3();
            Z2();
            v2();
        } else {
            q.d(getClass().getSimpleName(), "handlerSignSuccess url:" + str);
        }
    }

    public final void D2(c.e.b.c.d.b bVar) {
        this.mRightIv.setVisibility(8);
        this.mTitleRightTv.setVisibility(8);
        if (bVar != null && bVar.getRight() != null) {
            String right = bVar.getRight();
            if (this.M.isNeedSetRightImg(right)) {
                this.M.setupRightImageData(right, this.mRightIv);
            } else {
                A2(bVar);
            }
            this.mTitleSplitLineTv.setVisibility(bVar.isTransparent() ? 8 : 0);
        }
        this.mRightIv.setOnClickListener(this.y);
        this.mTitleRightTv.setOnClickListener(this.y);
    }

    public final void O2() {
        if (this.mWebView != null) {
            if (x.isNotNull(this.D)) {
                this.mWebView.loadHtmlContent(this.D, false);
            } else if (x.isNotNull(this.f6484b)) {
                NestedScrollWebView nestedScrollWebView = this.mWebView;
                String str = this.f6484b;
                nestedScrollWebView.loadUrl(str, w2(str));
            }
        }
    }

    public final void P2(ValueCallback<Uri[]> valueCallback) {
        this.G = true;
        this.H = valueCallback;
        S2(1, false);
    }

    public final void Q2(c.e.b.c.d.e eVar) {
        try {
            q.d(this.f6485c, "openGoodsListToCoupon : " + eVar.getCouponId());
            c0(LifeGoodsListActivity.class, JSON.toJSONString(eVar));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void R2(int i2) {
        U2(this.mWebView.getImgSrcList(), i2);
    }

    public final void S2(int i2, boolean z) {
        c.k.a.a aVar = c.k.a.a.getInstance();
        if (i2 <= 0) {
            i2 = 1;
        }
        aVar.setSelectLimit(i2);
        c.k.a.a.getInstance().clear();
        Intent intent = new Intent(this.f6487e, (Class<?>) ImageGridActivity.class);
        intent.putExtra("is_only_camera", z);
        startActivityForResult(intent, 1000);
    }

    public final void T2(List<String> list, int i2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
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
        this.f6487e.startActivity(intent);
    }

    public final void U2(List<String> list, int i2) {
        if (c.e.a.d.o.isNotEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                c.k.b.a aVar = new c.k.b.a();
                aVar.setBigImageUrl(str);
                aVar.setThumbnailUrl(str);
                arrayList.add(aVar);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            c.k.b.c.getInstance().setOnLongClickListener(this.U);
            Intent intent = new Intent(this.f6487e, (Class<?>) ImagePreviewActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("IMAGE_INFO", arrayList);
            bundle.putInt("CURRENT_ITEM", i2);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() != R.id.tv_title_right) {
            if (view.getId() == R.id.img_web_right) {
                this.M.handleRightImgClick(view);
            }
        } else if (x.getString(R.string.title_refresh).equals(this.mTitleRightTv.getText().toString())) {
            O2();
        } else {
            this.M.handleRightClick();
        }
    }

    public final void V2(String str) {
        Intent intent = new Intent(this.f6487e, (Class<?>) OpenDoorActivity.class);
        intent.putExtra("key", str);
        startActivity(intent);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        h0(this);
        this.f6488f = new CoreBaseFragment.c(this);
        this.mTitleTv.setText(x.getNotNullStr(this.B, ""));
        this.mTitleSplitLineTv.setVisibility(0);
        this.mTitleRightTv.setVisibility(0);
        this.mTitleRightTv.setText(R.string.title_refresh);
        this.mTitleRightTv.setOnClickListener(this.y);
        b3();
        if (!this.K) {
            O2();
        }
        d3();
        c3();
        this.f6488f.postDelayed(new Runnable() { // from class: c.e.c.o0.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f1795a.L2();
            }
        }, 1000L);
    }

    public final void W2(c.e.b.c.d.h hVar) {
        d(MapDialogFragment.getInstance(hVar), R.id.flayout_content);
    }

    public final void X2(o oVar) {
        d(SharedAlertFragment.getInstance(oVar), R.id.flayout_content);
    }

    public final void Y2() {
        Bitmap bitmap;
        Drawable drawable = this.F.getDrawable();
        if (!(drawable instanceof GlideBitmapDrawable) || (bitmap = ((GlideBitmapDrawable) drawable).getBitmap()) == null) {
            return;
        }
        String str = l.getSaveImgFolderPath() + File.separator + System.currentTimeMillis() + ".jpg";
        n.saveBitmapToSdCard(bitmap, str);
        G0(x.getString(R.string.title_save_success) + str);
    }

    public final void Z2() {
        if (Q()) {
            return;
        }
        g.b.a.c.getDefault().postSticky(new EventContract());
        k(new EventUpdateRentState());
    }

    public final void a3() {
        ValueCallback<Uri[]> valueCallback = this.H;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(new Uri[0]);
            this.H = null;
        }
    }

    public final void b3() {
        this.E = (PublicModel) h(PublicModel.class);
        if (this.K) {
            z0(R.string.loading_text);
            this.E.getArticleResult().observe(this, new Observer() { // from class: c.e.c.o0.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1790a.N2((ResponseArticleVo) obj);
                }
            });
            reloadArticle();
        }
        this.E.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.o0.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1792a.C((RequestErrDto) obj);
            }
        });
        this.E.getUploadResponseDtoMutableLive().observeForever(new Observer() { // from class: c.e.c.o0.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1793a.B2((UploadResponseDto) obj);
            }
        });
    }

    @OnClick({R.id.tv_back})
    public void backClick() {
        if (!this.mWebView.canGoBack()) {
            n();
        } else {
            this.mWebView.goBack();
            this.mWebView.postDelayed(new Runnable() { // from class: c.e.c.o0.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1794a.G2();
                }
            }, 1000L);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void c3() {
        this.r = this.mCommandRecyclerView;
        LeftTitleToRightArrowAdapter leftTitleToRightArrowAdapter = new LeftTitleToRightArrowAdapter();
        this.t = leftTitleToRightArrowAdapter;
        leftTitleToRightArrowAdapter.setOnItemClickListener(this.P);
        this.L = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setOnlyKey(1);
        leftTitleToRightArrowVo.setCenter(x.getString(R.string.title_save_pic));
        this.L.add(leftTitleToRightArrowVo);
        this.t.initListData((List<T>) this.L);
    }

    public final void d3() {
        if (!this.J) {
            ((ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams()).topMargin = 0;
            this.mProgressBar.setVisibility(8);
            this.mRightIv.setVisibility(8);
            this.mTitleTv.setVisibility(8);
            this.mTitleRightTv.setVisibility(8);
            this.mTitleSplitLineTv.setVisibility(8);
        }
        this.mWebView.setIWebViewLoginListener(this.S);
        this.mWebView.setIWebViewOpenLockListener(this.R);
        this.M = new c.e.b.c.a.c(this.mWebView);
        c.e.b.c.a.b bVar = new c.e.b.c.a.b(this.mWebView, this.f6487e);
        this.N = bVar;
        bVar.setupIWebFragmentCallback(this.T);
        new c.e.b.c.b.i(this.Q).registerBridge(this.mWebView);
        this.mWebView.setWebViewClient(this.N.getMBridgeWebViewClient());
        this.mWebView.setWebChromeClient(new f());
        if (this.C == null && x.isNotNull(this.f6484b) && this.f6484b.contains("https://app.yuanjingweitang.com")) {
            this.mWebView.getSettings().setTextZoom(200);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp_12);
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.mWebView.getLayoutParams())).leftMargin = dimensionPixelSize;
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.mWebView.getLayoutParams())).rightMargin = dimensionPixelSize;
        }
        this.mWebView.setIWebViewJsListener(new g());
    }

    public final void e3(int i2) {
        this.mLinearLayout.post(new e(i2));
    }

    public final void f3() {
        UserInfoVo userInfoVoW = w();
        if (userInfoVoW != null) {
            userInfoVoW.setCheckIn(true);
            m0(JSON.toJSONString(userInfoVoW));
        }
    }

    public Uri getImageContentUri(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        Cursor cursorQuery = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{absolutePath}, null);
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            if (!file.exists()) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", absolutePath);
            return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
        return Uri.withAppendedPath(Uri.parse("content://media/external/images/media"), "" + i2);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fargment_web;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == 1004 && intent != null && i2 == 1000) {
            ArrayList arrayList = (ArrayList) intent.getSerializableExtra("extra_result_items");
            ArrayList arrayList2 = new ArrayList();
            if (arrayList == null) {
                if (this.G) {
                    this.G = false;
                    a3();
                    return;
                }
                return;
            }
            if (this.G) {
                this.G = false;
                int size = arrayList.size();
                Uri[] uriArr = new Uri[size];
                for (int i4 = 0; i4 < size; i4++) {
                    uriArr[i4] = getImageContentUri(this.f6487e, new File(((ImageItem) arrayList.get(i4)).path));
                }
                this.H.onReceiveValue(uriArr);
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new File(((ImageItem) it.next()).path));
            }
            if (arrayList2.isEmpty()) {
                return;
            }
            z0(R.string.tip_uploading);
            this.E.uploadFile(arrayList2);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        c.k.b.c.getInstance().setOnLongClickListener(null);
        L0(this);
        NestedScrollWebView nestedScrollWebView = this.mWebView;
        if (nestedScrollWebView != null) {
            nestedScrollWebView.recycler();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        NestedScrollWebView nestedScrollWebView = this.mWebView;
        if (nestedScrollWebView == null || !nestedScrollWebView.canGoBack()) {
            q.d(getClass().getCanonicalName(), "onKeyDown super");
            n();
            return super.onKeyDown(i2, keyEvent);
        }
        backClick();
        q.d(getClass().getCanonicalName(), "onKeyDown canGoBack");
        return true;
    }

    @g.b.a.m
    public void onLoginSuccess(EventUpdateUserAlertMessage eventUpdateUserAlertMessage) {
        refreshLoad();
    }

    @g.b.a.m
    public void onReloadWebView(EventReloadWebView eventReloadWebView) {
        refreshLoad();
    }

    @OnClick({R.id.btn_reload_page})
    public void refreshClick() {
        refreshLoad();
        e3(8);
    }

    public void refreshLoad() {
        O2();
    }

    @g.b.a.m(threadMode = r.MAIN)
    public void registerEventFinish(EventFinish eventFinish) {
        n();
        q.d(getClass().getSimpleName(), "registerEventFinish");
    }

    public void reloadArticle() {
        if (x.isNotNull(this.D)) {
            this.E.getArticleToArticleKey(this.D);
        }
    }

    public void setHtmlContent(String str) {
        this.D = str;
    }

    public void setIsArticle(boolean z) {
        this.K = z;
    }

    public void setPayFeeType(int i2) {
        this.I = i2;
    }

    public void setResponseFddVo(ResponseFddVo responseFddVo) {
        this.C = responseFddVo;
    }

    public void setShowTitle(boolean z) {
        this.J = z;
    }

    public void setTitle(String str) {
        this.B = str;
    }

    @g.b.a.m
    public void updateOpenLockState(EventUpdateOpenLockVo eventUpdateOpenLockVo) {
        if (eventUpdateOpenLockVo.isSuccess()) {
            this.mWebView.loadJsMethodToNameAndParam("openLockSuccess", null);
        } else {
            this.mWebView.loadJsMethodToNameAndParam("openLockFailed", eventUpdateOpenLockVo.getMsg());
        }
    }

    @g.b.a.m(threadMode = r.MAIN)
    public void updatePayStatus(EventUpdateWebPayStatus eventUpdateWebPayStatus) {
    }

    public final void v2() {
        int i2 = this.I;
        if (16 == i2) {
            d(ContractConfirmFragment.getInstance(i2), R.id.flayout_content);
        }
    }

    public final Map<String, String> w2(String str) {
        if (x.isNotNull(str)) {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (x.isNotNull(scheme) && x.isNotNull(host)) {
                HashMap map = new HashMap();
                map.put("Referer", scheme + HttpConstant.SCHEME_SPLIT + host);
                q.d(WebFragment.class.getClass().getSimpleName(), "getHttpHead  scheme：" + scheme + ",host:" + host);
                return map;
            }
        }
        return new HashMap();
    }

    public final void x2() {
        String[] strArr = {"android.permission.RECORD_AUDIO"};
        boolean z = false;
        for (int i2 = 0; i2 < 1; i2++) {
            if (ContextCompat.checkSelfPermission(this.f6486d, strArr[i2]) == -1) {
                z = true;
            }
        }
        if (z) {
            ActivityCompat.requestPermissions(this.f6487e, strArr, 1000);
        }
    }

    public final void y2(int i2) {
        if (this.L.get(i2).getOnlyKey() == 1) {
            Y2();
        }
        this.r.setVisibility(8);
    }

    public final void z2(m mVar) {
        if (mVar != null) {
            b0.getInstance().handleRequestServerErr(mVar.getApiUrl(), mVar.getCode(), mVar.getErrorMessage(), mVar.isEmphasis());
        }
    }
}
