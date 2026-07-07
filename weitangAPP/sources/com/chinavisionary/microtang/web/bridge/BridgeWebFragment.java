package com.chinavisionary.microtang.web.bridge;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
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
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.b0;
import c.e.a.d.q;
import c.e.a.d.v;
import c.e.a.d.x;
import c.e.b.c.d.h;
import c.e.b.c.d.i;
import c.e.b.c.d.m;
import c.e.b.c.d.n;
import c.e.b.c.d.o;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.event.EventUpdateUserInfoVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadImgVo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.microtang.MainActivity;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.alert.SharedAlertFragment;
import com.chinavisionary.microtang.auth.IDAuthActivity;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.clean.CleanDetailsActivity;
import com.chinavisionary.microtang.community.fragment.ActivityCommentFragment;
import com.chinavisionary.microtang.life.activity.LifeGoodsListActivity;
import com.chinavisionary.microtang.login.LoginActivity;
import com.chinavisionary.microtang.login.bo.EventUpdateUserAlertMessage;
import com.chinavisionary.microtang.map.MapDialogFragment;
import com.chinavisionary.microtang.me.vo.EventContract;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import com.chinavisionary.microtang.pdf.PdfActivity;
import com.chinavisionary.microtang.room.RoomSourceDetailsActivity;
import com.chinavisionary.microtang.sign.view.BaseWebView;
import com.chinavisionary.microtang.sign.view.NestedScrollWebView;
import com.chinavisionary.microtang.web.WebFragment;
import com.chinavisionary.microtang.web.model.PublicModel;
import com.chinavisionary.microtang.web.vo.ActivityEvaluateVo;
import com.chinavisionary.microtang.web.vo.EventUpdateOpenLockVo;
import com.chinavisionary.microtang.web.vo.PdfPreviewVo;
import com.chinavisionary.microtang.web.vo.ResponseArticleVo;
import com.chinavisionary.microtang.web.vo.UploadResponseBo;
import com.chinavisionary.paymentlibrary.PayTypeActivity;
import com.chinavisionary.paymentlibrary.vo.EventPayStateVo;
import com.chinavisionary.twlib.open.OpenDoorActivity;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.ninegrid.preview.ImagePreviewActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NonConstantResourceId"})
public class BridgeWebFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public String B;
    public n C;
    public String D;
    public PublicModel E;
    public c.e.b.c.a.c F;
    public c.e.b.c.a.b G;
    public c.e.b.a.d H;
    public int I;
    public boolean M;
    public boolean N;
    public boolean O;
    public ValueCallback<Uri[]> P;

    @BindView(R.id.img_back)
    public ImageView mBackImg;

    @BindView(R.id.view_bg)
    public View mBgView;

    @BindView(R.id.ll_err_tip)
    public LinearLayout mLinearLayout;

    @BindView(R.id.tv_permission_info)
    public TextView mPermissionInfoTv;

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
    public boolean J = false;
    public boolean K = true;
    public boolean L = false;
    public final c.e.b.c.c.a Q = new a();
    public final c.e.b.c.c.b R = new b();
    public final BaseWebView.h S = new BaseWebView.h() { // from class: c.e.c.o0.h.g
        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.h
        public final void openLockToRoomKey(String str) {
            this.f1802a.T2(str);
        }
    };
    public final BaseWebView.g T = new d();

    public class a implements c.e.b.c.c.a {
        public a() {
        }

        @Override // c.e.b.c.c.a
        public void addFragmentToActivity(i iVar, boolean z) {
            if (BridgeWebFragment.this.N) {
                BridgeWebFragment.this.m();
            }
            BridgeWebFragment.this.c0(PayTypeActivity.class, JSON.toJSONString(iVar));
        }

        @Override // c.e.b.c.c.a
        public void performActivityEvaluateActivity(String str) {
            if (!x.isNotNull(str)) {
                BridgeWebFragment.this.F0(R.string.tip_open_failed_param_failed);
                return;
            }
            try {
                ActivityEvaluateVo activityEvaluateVo = (ActivityEvaluateVo) JSON.parseObject(str, ActivityEvaluateVo.class);
                BridgeWebFragment.this.d(ActivityCommentFragment.getInstance(activityEvaluateVo.getActivityPrimaryKey(), activityEvaluateVo.getActivityName(), !activityEvaluateVo.isEvaluate()), R.id.flayout_content);
            } catch (Exception e2) {
                e2.printStackTrace();
                BridgeWebFragment.this.F0(R.string.tip_open_failed_param_failed);
            }
        }

        @Override // c.e.b.c.c.a
        public void performAuthActivity() {
            BridgeWebFragment.this.d0(IDAuthActivity.class);
        }

        @Override // c.e.b.c.c.a
        public void performCallPhone(String str) {
            BridgeWebFragment.this.f(str);
        }

        @Override // c.e.b.c.c.a
        public void performChooseImage(c.e.b.a.d dVar, int i2, c.e.b.c.d.d dVar2) {
            BridgeWebFragment.this.H = dVar;
            BridgeWebFragment.this.h3(i2, dVar2 != null && dVar2.getSourceType() != null && dVar2.getSourceType().size() == 1 && dVar2.getSourceType().contains(c.e.b.c.d.d.SOURCE_TYPE_CAMERA));
        }

        @Override // c.e.b.c.c.a
        public void performContractActivity(@NonNull String str) {
            if (!x.isNotNull(str)) {
                BridgeWebFragment.this.F0(R.string.title_electric_contract_empty);
                return;
            }
            try {
                PdfPreviewVo pdfPreviewVo = (PdfPreviewVo) JSON.parseObject(str, PdfPreviewVo.class);
                if (x.isNotNull(pdfPreviewVo.getName()) && x.isNotNull(pdfPreviewVo.getContract_downloadUrl())) {
                    Intent intent = new Intent(BridgeWebFragment.this.f6487e, (Class<?>) PdfActivity.class);
                    intent.putExtra("titleKey", pdfPreviewVo.getName());
                    intent.putExtra("key", pdfPreviewVo.getContract_downloadUrl());
                    BridgeWebFragment.this.startActivity(intent);
                } else {
                    BridgeWebFragment.this.F0(R.string.title_electric_contract_empty);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // c.e.b.c.c.a
        public void performFinishActivity() {
            BridgeWebFragment.this.m();
        }

        @Override // c.e.b.c.c.a
        public void performLogin() {
            BridgeWebFragment.this.d0(LoginActivity.class);
        }

        @Override // c.e.b.c.c.a
        public void performMainActivity() {
            if (v.getInstance().isRepeatedlyAction("performMainActivity", 2000)) {
                return;
            }
            BridgeWebFragment.this.d0(MainActivity.class);
        }

        @Override // c.e.b.c.c.a
        public void performMap(@NonNull h hVar) {
            BridgeWebFragment.this.k3(hVar);
        }

        @Override // c.e.b.c.c.a
        public void performOpenImagePreview(List<String> list, int i2) {
            BridgeWebFragment.this.i3(list, i2);
        }

        @Override // c.e.b.c.c.a
        public void performProductDetailsActivity(@NonNull String str, c.e.b.c.d.e eVar) {
            if (!x.isNotNull(str)) {
                BridgeWebFragment.this.F0(R.string.tip_product_key_is_empty);
            } else if (eVar != null) {
                BridgeWebFragment.this.f3(eVar);
            } else {
                BridgeWebFragment.this.c0(CleanDetailsActivity.class, str);
            }
        }

        @Override // c.e.b.c.c.a
        public void performReportAbnormalBo(@NonNull m mVar) {
            BridgeWebFragment.this.E2(mVar);
        }

        @Override // c.e.b.c.c.a
        public void performRoomSourceActivity(@NonNull String str, String str2) {
            if (!x.isNotNull(str)) {
                BridgeWebFragment.this.F0(R.string.tip_room_key_empty);
                return;
            }
            if (!x.isNotNull(str2)) {
                BridgeWebFragment.this.c0(RoomSourceDetailsActivity.class, str);
                return;
            }
            Intent intent = new Intent(BridgeWebFragment.this.f6487e, (Class<?>) RoomSourceDetailsActivity.class);
            intent.putExtra("key", str);
            intent.putExtra("open_sign_url_key", str2);
            BridgeWebFragment.this.startActivity(intent);
        }

        @Override // c.e.b.c.c.a
        public void performStartActivity(Intent intent) {
            if (intent != null) {
                intent.setClass(BridgeWebFragment.this.f6487e, BridgeWebViewActivity.class);
                BridgeWebFragment.this.startActivity(intent);
            }
        }

        @Override // c.e.b.c.c.a
        public void performUpdateUserInfo() {
            EventUpdateUserInfoVo eventUpdateUserInfoVo = new EventUpdateUserInfoVo();
            eventUpdateUserInfoVo.setWhatMsg(0);
            BridgeWebFragment.this.k(eventUpdateUserInfoVo);
        }

        @Override // c.e.b.c.c.a
        public void performWeChartShared(@NonNull o oVar) {
            BridgeWebFragment.this.m3(oVar);
        }

        @Override // c.e.b.c.c.a
        public void performWxMiniProgram(@NonNull String str) {
            if (!x.isNotNull(str)) {
                BridgeWebFragment.this.F0(R.string.tip_open_failed_param_failed);
                return;
            }
            try {
                AlertMessageVo alertMessageVo = (AlertMessageVo) JSON.parseObject(str, AlertMessageVo.class);
                if (alertMessageVo == null) {
                    BridgeWebFragment.this.F0(R.string.tip_open_failed_param_failed);
                    return;
                }
                if (!x.isNotNull(alertMessageVo.getTargetAppid()) || !x.isNotNull(alertMessageVo.getTargetPath())) {
                    BridgeWebFragment.this.F0(R.string.tip_open_failed_param_failed);
                    return;
                }
                int i2 = 15;
                if (x.isNotNull(alertMessageVo.getTargetMiniType()) && FundNewsVo.TYPE_ALIPAY.equals(alertMessageVo.getTargetMiniType())) {
                    i2 = 18;
                }
                BridgeWebFragment.this.c1(Integer.valueOf(i2), alertMessageVo.getTargetAppid(), alertMessageVo.getTargetPath());
            } catch (Exception e2) {
                e2.printStackTrace();
                BridgeWebFragment.this.F0(R.string.tip_open_failed_param_failed);
            }
        }

        @Override // c.e.b.c.c.a
        public void setupAppBarStyle(c.e.b.c.d.b bVar) {
            BridgeWebFragment.this.J2(bVar);
        }
    }

    public class b implements c.e.b.c.c.b {
        public b() {
        }

        @Override // c.e.b.c.c.b
        public void handle404Page(String str) {
            BridgeWebFragment.this.v3(0);
            q.d(WebFragment.class.getSimpleName(), "handle404Page httpUrl:" + str);
        }

        @Override // c.e.b.c.c.b
        public void handlerFddSignSuccess(String str) {
            BridgeWebFragment.this.I2(str);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8707a;

        public c(int i2) {
            this.f8707a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BridgeWebFragment.this.mLinearLayout.setVisibility(this.f8707a);
        }
    }

    public class d implements BaseWebView.g {
        public d() {
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.g
        public void doCellPhone(String str) {
            BridgeWebFragment.this.f(str);
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.g
        public void doLogin() {
            BridgeWebFragment.this.g();
            BridgeWebFragment.this.N();
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.g
        public String getTitle() {
            return x.getNotNullStr(BridgeWebFragment.this.B, "");
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.g
        public void onIdCardAuthentication() {
            BridgeWebFragment.this.d0(IDAuthActivity.class);
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.g
        public void showBack() {
        }
    }

    public class e extends WebChromeClient {
        public e() {
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            q.d(BridgeWebFragment.this.f6485c, "onPermissionRequest request = ");
            if (Build.VERSION.SDK_INT >= 23) {
                BridgeWebFragment.this.A2();
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
            BridgeWebFragment.this.H2(i2);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (!x.isNotNull(str) || str.equals("peanut.html")) {
                return;
            }
            BridgeWebFragment.this.mTitleTv.setText(str);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            BridgeWebFragment.this.e3(valueCallback, fileChooserParams);
            return true;
        }
    }

    public class f implements BaseWebView.f {
        public f() {
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.f
        public void catPic(int i2) {
            BridgeWebFragment.this.g3(i2);
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.f
        public void catSignPic(String str) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            BridgeWebFragment.this.i3(arrayList, 0);
        }

        @Override // com.chinavisionary.microtang.sign.view.BaseWebView.f
        public void onImagePreview(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N2() {
        this.mWebView.sendHandleName("reload");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: O2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P2() {
        this.mPermissionInfoTv.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Q2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R2() {
        this.mPermissionInfoTv.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: U2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V2() {
        int height = this.u.getHeight();
        q.d(getClass().getSimpleName(), "mWebView height:" + height);
        c.e.b.c.a.a.assistActivity(this.u, this.f6487e, height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: W2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X2() {
        this.mPermissionInfoTv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Y2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z2() {
        this.mPermissionInfoTv.setVisibility(8);
    }

    public static BridgeWebFragment getInstance(String str) {
        BridgeWebFragment bridgeWebFragment = new BridgeWebFragment();
        bridgeWebFragment.setArguments(CoreBaseFragment.q(str));
        return bridgeWebFragment;
    }

    public final void A2() {
        String[] strArr = {"android.permission.RECORD_AUDIO"};
        boolean z = false;
        for (int i2 = 0; i2 < 1; i2++) {
            if (ContextCompat.checkSelfPermission(this.f6486d, strArr[i2]) == -1) {
                z = true;
            }
        }
        if (z) {
            this.mPermissionInfoTv.post(new Runnable() { // from class: c.e.c.o0.h.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1796a.P2();
                }
            });
            ActivityCompat.requestPermissions(this.f6487e, strArr, 888);
        }
    }

    public final boolean B2() {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
        boolean z = false;
        for (int i2 = 0; i2 < 2; i2++) {
            String str = strArr[i2];
            if (ContextCompat.checkSelfPermission(this.f6486d, str) == -1) {
                arrayList.add(str);
                z = true;
            }
        }
        if (z) {
            this.mPermissionInfoTv.setText("相机权限使用说明：将用于更新头像、实名认证、咨询投诉、客服咨询、居住评价，扫描二维码中使用。\n存储权限使用说明：将用于更新头像，客服咨询，实名认证上传照片，保存图片到相册等功能中使用。");
            this.mPermissionInfoTv.post(new Runnable() { // from class: c.e.c.o0.h.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1797a.R2();
                }
            });
            ActivityCompat.requestPermissions(this.f6487e, (String[]) arrayList.toArray(new String[arrayList.size()]), 1001);
        }
        return z;
    }

    public final void C2(ResponseArticleVo responseArticleVo) {
        H();
        if (responseArticleVo != null) {
            this.D = responseArticleVo.getArticleContent();
            c3();
        }
    }

    public final void D2() {
        if (this.M) {
            return;
        }
        c3();
    }

    public final void E2(m mVar) {
        if (mVar != null) {
            q.d(this.f6485c, "handleReportAbnormalInfo ");
            String code = mVar.getCode();
            if (x.isNumeric(code)) {
                try {
                    int i2 = Integer.parseInt(code);
                    if (!c.e.a.a.a.getInstance().isDebug()) {
                        boolean zOpenTipActivity = c.e.c.m0.c.getInstance().openTipActivity(this.f6487e, i2);
                        q.d(this.f6485c, "handleResponseErr errCode = " + code);
                        if (zOpenTipActivity) {
                            n();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            b0.getInstance().handleRequestServerErr(mVar.getApiUrl(), mVar.getCode(), mVar.getErrorMessage(), mVar.isEmphasis());
        }
    }

    public final void F2(c.e.b.c.d.b bVar) {
        this.mTitleRightTv.setVisibility(0);
        q.d(getClass().getSimpleName(), "handleTitleRightView text = " + bVar.getRightButtonText());
        if (this.F.isNeedSetRightTv(bVar.getRight())) {
            this.mTitleRightTv.setText(bVar.getRightButtonText());
        } else {
            this.mTitleRightTv.setText(bVar.getRight());
        }
        if (bVar.getRightColor() != null) {
            this.mTitleRightTv.setTextColor(Color.parseColor(bVar.getRightColor()));
        }
    }

    public final void G2(UploadResponseDto uploadResponseDto) {
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
                c.e.b.a.d dVar = this.H;
                if (dVar != null) {
                    dVar.onCallBack(JSON.toJSONString(arrayList));
                }
            } else {
                F0(R.string.tip_upload_failed);
            }
        } else {
            F0(R.string.tip_upload_failed);
        }
        this.H = null;
    }

    public final void H2(int i2) {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            if (progressBar.getVisibility() == 8) {
                this.mProgressBar.setVisibility(0);
            }
            if (i2 > 98) {
                this.mProgressBar.setVisibility(8);
            }
            this.mProgressBar.setProgress(i2);
        }
    }

    public final void I2(String str) {
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
            w3();
            n3();
            y2();
        } else {
            q.d(getClass().getSimpleName(), "handlerSignSuccess url:" + str);
        }
    }

    public final void J2(c.e.b.c.d.b bVar) {
        this.mRightIv.setVisibility(8);
        this.mTitleRightTv.setVisibility(8);
        if (bVar != null && bVar.getRight() != null) {
            String right = bVar.getRight();
            if (this.F.isNeedSetRightImg(right)) {
                this.F.setupRightImageData(right, this.mRightIv);
            } else {
                F2(bVar);
            }
            this.mTitleSplitLineTv.setVisibility(bVar.isTransparent() ? 8 : 0);
        }
        this.mRightIv.setOnClickListener(this.y);
        this.mTitleRightTv.setOnClickListener(this.y);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.tv_title_right) {
            this.F.handleRightClick();
        } else if (view.getId() == R.id.img_web_right) {
            this.F.handleRightImgClick(view);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        h0(this);
        this.f6488f = new CoreBaseFragment.c(this);
        p3();
        s3();
        r3();
        D2();
        t3();
        this.f6488f.postDelayed(new Runnable() { // from class: c.e.c.o0.h.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f1798a.V2();
            }
        }, 2200L);
    }

    public final void b3() {
        this.mWebView.loadHtmlContent(this.D, "用户注销协议".equals(this.B));
    }

    @OnClick({R.id.tv_back})
    public void backClick() {
        if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            this.mWebView.postDelayed(new Runnable() { // from class: c.e.c.o0.h.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1803a.N2();
                }
            }, 100L);
        } else {
            o3();
            n();
        }
    }

    public final void c3() {
        if (this.mWebView != null) {
            if (x.isNotNull(this.D)) {
                b3();
            } else {
                d3();
            }
        }
    }

    public final void d3() {
        if (x.isNotNull(this.f6484b)) {
            this.N = this.f6484b.contains("process/sign/step?assetKey=") || this.f6484b.contains("process/reserve/form?assetKey=");
            NestedScrollWebView nestedScrollWebView = this.mWebView;
            String str = this.f6484b;
            nestedScrollWebView.loadUrl(str, this.G.getHttpHead(str));
        }
    }

    public final void e3(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        this.O = true;
        this.P = valueCallback;
        q.d(this.f6485c, "openFileChooseImpleForAndroid");
        if (fileChooserParams == null) {
            h3(1, false);
            return;
        }
        String str = fileChooserParams.getAcceptTypes()[0];
        if (str.contains("image")) {
            h3(1, false);
        } else if (str.contains(o.VIDEO_TYPE)) {
            l3();
        } else {
            q3();
        }
        q.d(this.f6485c, "openFileChooseImpleForAndroid value = " + str);
    }

    @g.b.a.m
    public void eventPaySuccess(EventPayStateVo eventPayStateVo) {
        if (eventPayStateVo.isSuccess()) {
            refreshLoad();
        }
    }

    public final void f3(c.e.b.c.d.e eVar) {
        try {
            c0(LifeGoodsListActivity.class, JSON.toJSONString(eVar));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void g3(int i2) {
        i3(this.mWebView.getImgSrcList(), i2);
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
        return R.layout.fargment_bridge_web;
    }

    public final void h3(int i2, boolean z) {
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

    public final void i3(List<String> list, int i2) {
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

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
    }

    /* JADX INFO: renamed from: j3, reason: merged with bridge method [inline-methods] */
    public final void T2(String str) {
        Intent intent = new Intent(this.f6487e, (Class<?>) OpenDoorActivity.class);
        intent.putExtra("key", str);
        startActivity(intent);
    }

    public final void k3(h hVar) {
        d(MapDialogFragment.getInstance(hVar), R.id.flayout_content);
    }

    public final void l3() {
        if (B2()) {
            return;
        }
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
        startActivityForResult(intent, 100);
    }

    public final void m3(o oVar) {
        d(SharedAlertFragment.getInstance(oVar), R.id.flayout_content);
    }

    public final void n3() {
        this.J = true;
    }

    public final void o3() {
        if (this.J) {
            this.J = false;
            g.b.a.c.getDefault().post(new EventContract());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        q.d(this.f6485c, "onActivityResult requestCode = " + i2 + ", resultCode = " + i3);
        if (i2 == 100) {
            if (intent == null || i3 != -1) {
                if (this.O) {
                    this.O = false;
                    q3();
                    return;
                }
                return;
            }
            if (this.O) {
                this.O = false;
                String fileAbsolutePath = c.e.a.d.m.getFileAbsolutePath(getContext(), intent.getData());
                q.d(this.f6485c, "onActivityResult filePath = " + fileAbsolutePath);
                if (fileAbsolutePath != null) {
                    Uri[] uriArr = {Uri.fromFile(new File(fileAbsolutePath))};
                    ValueCallback<Uri[]> valueCallback = this.P;
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(uriArr);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (i3 != 1004) {
            if (this.O) {
                this.O = false;
                q3();
                return;
            }
            return;
        }
        if (intent == null || i2 != 1000) {
            return;
        }
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("extra_result_items");
        ArrayList arrayList2 = new ArrayList();
        if (arrayList == null) {
            if (this.O) {
                this.O = false;
                q3();
                return;
            }
            return;
        }
        if (this.O) {
            this.O = false;
            int size = arrayList.size();
            Uri[] uriArr2 = new Uri[size];
            for (int i4 = 0; i4 < size; i4++) {
                uriArr2[i4] = Uri.fromFile(new File(((ImageItem) arrayList.get(i4)).path));
            }
            this.P.onReceiveValue(uriArr2);
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

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
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
        if (nestedScrollWebView != null && nestedScrollWebView.canGoBack()) {
            backClick();
            q.d(getClass().getCanonicalName(), "onKeyDown canGoBack");
            return true;
        }
        o3();
        q.d(getClass().getCanonicalName(), "onKeyDown super");
        n();
        return super.onKeyDown(i2, keyEvent);
    }

    @g.b.a.m
    public void onLoginSuccess(EventUpdateUserAlertMessage eventUpdateUserAlertMessage) {
        refreshLoad();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        q.d(this.f6485c, "onPause isRemoving = " + isRemoving());
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1001) {
            this.mPermissionInfoTv.post(new Runnable() { // from class: c.e.c.o0.h.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1804a.X2();
                }
            });
            int length = iArr.length;
            boolean z = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z = true;
                    break;
                } else if (iArr[i3] != 0) {
                    break;
                } else {
                    i3++;
                }
            }
            if (z) {
                l3();
            } else {
                q3();
            }
        }
        if (i2 == 888) {
            this.mPermissionInfoTv.post(new Runnable() { // from class: c.e.c.o0.h.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1801a.Z2();
                }
            });
        }
    }

    public final void p3() {
        this.F = new c.e.b.c.a.c(this.mWebView);
        c.e.b.c.a.b bVar = new c.e.b.c.a.b(this.mWebView, this.f6487e);
        this.G = bVar;
        bVar.setupIWebFragmentCallback(this.R);
        new c.e.b.c.b.i(this.Q).registerBridge(this.mWebView);
    }

    public final void q3() {
        ValueCallback<Uri[]> valueCallback = this.P;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(new Uri[0]);
            this.P = null;
        }
    }

    public final void r3() {
        this.E = (PublicModel) h(PublicModel.class);
        if (this.M) {
            z0(R.string.loading_text);
            this.E.getArticleResult().observeForever(new Observer() { // from class: c.e.c.o0.h.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1800a.C2((ResponseArticleVo) obj);
                }
            });
            reloadArticle();
        }
        this.E.getErrRequestLiveData().observeForever(new Observer() { // from class: c.e.c.o0.h.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1805a.C((RequestErrDto) obj);
            }
        });
        this.E.getUploadResponseDtoMutableLive().observeForever(new Observer() { // from class: c.e.c.o0.h.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1799a.G2((UploadResponseDto) obj);
            }
        });
    }

    @OnClick({R.id.btn_reload_page})
    public void refreshClick() {
        refreshLoad();
        v3(8);
    }

    public void refreshLoad() {
        c3();
    }

    public void reloadArticle() {
        if (x.isNotNull(this.D)) {
            this.E.getArticleToArticleKey(this.D);
        }
    }

    public final void s3() {
        this.mTitleTv.setText(x.getNotNullStr(this.B, ""));
        this.mTitleSplitLineTv.setVisibility(0);
        this.mTitleRightTv.setVisibility(8);
        this.mTitleRightTv.setText(R.string.title_refresh);
        this.mTitleRightTv.setOnClickListener(this.y);
        if (!this.K) {
            this.mTitleTv.setVisibility(4);
            this.mWebView.getLayoutParams().height = -1;
            ((ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(R.dimen.dp_30);
        }
        if (this.L) {
            this.mTitleTv.setVisibility(4);
            this.mBackImg.setVisibility(8);
            this.mTitleSplitLineTv.setVisibility(8);
            this.mTitleRightTv.setVisibility(8);
            this.mWebView.getLayoutParams().height = -2;
            ((ViewGroup.MarginLayoutParams) this.mWebView.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(R.dimen.dp_30);
        }
    }

    public void setHtmlContent(String str) {
        this.D = str;
    }

    public void setIsArticle(boolean z) {
        this.M = z;
    }

    public void setPayFeeType(int i2) {
        this.I = i2;
    }

    public void setResponseFddVo(n nVar) {
        this.C = nVar;
    }

    public void setShowTitle(boolean z) {
        this.K = z;
    }

    public void setTitle(String str) {
        this.B = str;
    }

    public void setupHiedLayoutTitle(boolean z) {
        this.L = z;
    }

    public final void t3() {
        this.mWebView.setIWebViewLoginListener(this.T);
        this.mWebView.setIWebViewOpenLockListener(this.S);
        this.mWebView.setWebViewClient(this.G.getMBridgeWebViewClient());
        this.mWebView.setWebChromeClient(new e());
        if (z2()) {
            u3();
        }
        this.mWebView.setIWebViewJsListener(new f());
    }

    public final void u3() {
        this.mWebView.getSettings().setTextZoom(200);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp_12);
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.mWebView.getLayoutParams())).leftMargin = dimensionPixelSize;
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.mWebView.getLayoutParams())).rightMargin = dimensionPixelSize;
    }

    @g.b.a.m
    public void updateOpenLockState(EventUpdateOpenLockVo eventUpdateOpenLockVo) {
        if (eventUpdateOpenLockVo.isSuccess()) {
            this.mWebView.loadJsMethodToNameAndParam("openLockSuccess", null);
        } else {
            this.mWebView.loadJsMethodToNameAndParam("openLockFailed", eventUpdateOpenLockVo.getMsg());
        }
    }

    public final void v3(int i2) {
        this.mLinearLayout.post(new c(i2));
    }

    public final void w3() {
        UserInfoVo userInfoVoW = w();
        if (userInfoVoW != null) {
            userInfoVoW.setCheckIn(true);
            m0(JSON.toJSONString(userInfoVoW));
        }
    }

    public final void y2() {
    }

    public final boolean z2() {
        return this.C == null && x.isNotNull(this.f6484b) && this.f6484b.contains("https://app.yuanjingweitang.com");
    }
}
