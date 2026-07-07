package com.chinavisionary.microtang.prelook.fragment;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.k.d;
import c.e.a.d.q;
import c.e.a.d.x;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadImgVo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.core.app.upload.UploadNineFragment;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.contract.model.ContractModel;
import com.chinavisionary.microtang.contract.vo.ContractCommentVo;
import com.chinavisionary.microtang.contract.vo.SubmitContractCommentBo;
import com.chinavisionary.microtang.prelook.model.PreLookModel;
import com.chinavisionary.microtang.prelook.vo.TagVo;
import com.hedgehog.ratingbar.RatingBar;
import com.nex3z.flowlayout.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PreLookCommentFragment extends BaseFragment {
    public UploadNineFragment B;
    public List<ContractCommentVo.CommentItemsBean> C;
    public PreLookModel D;
    public ContractModel E;
    public LayoutInflater F;
    public d G = new a();

    @BindView(R.id.edt_comment_content)
    public AppCompatEditText mCommentContentEdt;

    @BindView(R.id.flow_layout_comment_tag)
    public FlowLayout mFlowLayout;

    @BindView(R.id.llayout_score)
    public LinearLayout mScoreLLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements d {
        public a() {
        }

        @Override // c.e.a.a.k.d
        public void uploadFailed(String str) {
            q.e(PreLookCommentFragment.class.getSimpleName(), "upload failed :" + str);
        }

        @Override // c.e.a.a.k.d
        public void uploadSuccess(UploadResponseDto uploadResponseDto) {
            q.d(PreLookCommentFragment.class.getSimpleName(), "upload success :" + JSON.toJSONString(uploadResponseDto));
            PreLookCommentFragment.this.z0(R.string.tip_submit_data_loading);
            String string = PreLookCommentFragment.this.mCommentContentEdt.getText().toString();
            List<ResponseUploadImgVo> uploadSuccessList = uploadResponseDto.getUploadSuccessList();
            ArrayList arrayList = new ArrayList();
            if (uploadSuccessList != null && !uploadSuccessList.isEmpty()) {
                for (ResponseUploadImgVo responseUploadImgVo : uploadSuccessList) {
                    if (responseUploadImgVo != null) {
                        arrayList.add(responseUploadImgVo.getKey());
                    }
                }
            }
            PreLookCommentFragment.this.b2(string, arrayList);
        }
    }

    public class b implements RatingBar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8192a;

        public b(int i2) {
            this.f8192a = i2;
        }

        @Override // com.hedgehog.ratingbar.RatingBar.b
        public void onRatingChange(float f2) {
            ((ContractCommentVo.CommentItemsBean) PreLookCommentFragment.this.C.get(this.f8192a)).setScore((int) f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(ContractCommentVo contractCommentVo) {
        H();
        L1(contractCommentVo);
        K1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: O1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P1(ResponseStateVo responseStateVo) {
        if (F(responseStateVo, R.string.tip_submit_success, R.string.tip_submit_failed)) {
            g0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Q1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R1(RequestErrDto requestErrDto) {
        C(requestErrDto);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T1(ResponseStateVo responseStateVo) {
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: U1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V1(RequestErrDto requestErrDto) {
        H();
        B0(requestErrDto.getErrMsg());
    }

    public static PreLookCommentFragment getInstance(String str) {
        PreLookCommentFragment preLookCommentFragment = new PreLookCommentFragment();
        preLookCommentFragment.setArguments(CoreBaseFragment.q(str));
        return preLookCommentFragment;
    }

    public final CheckBox H1(TagVo tagVo, View.OnClickListener onClickListener, FrameLayout.LayoutParams layoutParams, int i2) {
        CheckBox checkBox = new CheckBox(this.f6487e);
        checkBox.setId(R.id.id_comment_tag);
        checkBox.setOnClickListener(onClickListener);
        checkBox.setText(tagVo.getContent());
        checkBox.setTag(tagVo.getKey());
        checkBox.setLayoutParams(layoutParams);
        checkBox.setButtonDrawable((Drawable) null);
        checkBox.setPadding(i2, i2, i2, i2);
        checkBox.setGravity(17);
        checkBox.setBackgroundResource(R.drawable.bg_cb_comment_tag);
        checkBox.setTextColor(getResources().getColor(R.color.color686868));
        checkBox.setTextSize(2, 14.0f);
        return checkBox;
    }

    public final void I1(ContractCommentVo.CommentItemsBean commentItemsBean, int i2) {
        View viewInflate = this.F.inflate(R.layout.item_score_layout, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_product_satisfied);
        RatingBar ratingBar = (RatingBar) viewInflate.findViewById(R.id.rating_bar_satisfied);
        textView.setText(x.getNotNullStr(commentItemsBean.getScoreName(), ""));
        ratingBar.setStar(commentItemsBean.getScore());
        ratingBar.setOnRatingChangeListener(new b(i2));
        this.mScoreLLayout.addView(viewInflate);
    }

    public final List<String> J1() {
        ArrayList arrayList = new ArrayList();
        int childCount = this.mFlowLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            CheckBox checkBox = (CheckBox) this.mFlowLayout.getChildAt(i2);
            if (checkBox.isChecked()) {
                arrayList.add((String) checkBox.getTag());
            }
        }
        return arrayList;
    }

    public final void K1() {
        this.mScoreLLayout.removeAllViews();
        List<ContractCommentVo.CommentItemsBean> list = this.C;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.C.size();
        for (int i2 = 0; i2 < size; i2++) {
            ContractCommentVo.CommentItemsBean commentItemsBean = this.C.get(i2);
            if (commentItemsBean != null) {
                I1(commentItemsBean, i2);
            }
        }
    }

    public final void L1(ContractCommentVo contractCommentVo) {
        if (contractCommentVo != null) {
            X1(contractCommentVo.getCommentTags());
            this.C = contractCommentVo.getCommentItems();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_comment);
        Z1();
        Y1();
        this.F = LayoutInflater.from(this.f6487e);
        W1();
        a2();
        z0(R.string.loading_text);
        j0();
    }

    public final void W1() {
        UploadNineFragment uploadNineFragment = UploadNineFragment.getInstance(this.G);
        this.B = uploadNineFragment;
        e(uploadNineFragment, R.id.flayout_nine_grid_view, false);
    }

    public final void X1(List<ContractCommentVo.CommentTagsBean> list) {
        this.mFlowLayout.removeAllViews();
        if (list == null || list.isEmpty()) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp_6);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ContractCommentVo.CommentTagsBean commentTagsBean = list.get(i2);
            if (commentTagsBean != null) {
                TagVo tagVo = new TagVo();
                tagVo.setContent(commentTagsBean.getTagName());
                tagVo.setKey(commentTagsBean.getTagKey());
                this.mFlowLayout.addView(H1(tagVo, this.y, layoutParams, dimensionPixelSize));
            }
        }
    }

    public final void Y1() {
        ContractModel contractModel = (ContractModel) h(ContractModel.class);
        this.E = contractModel;
        contractModel.getContractCommentInfo().observe(this, new Observer() { // from class: c.e.c.d0.b.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1421a.N1((ContractCommentVo) obj);
            }
        });
        this.E.getRequestResult().observe(this, new Observer() { // from class: c.e.c.d0.b.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1423a.P1((ResponseStateVo) obj);
            }
        });
        this.E.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.d0.b.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1422a.R1((RequestErrDto) obj);
            }
        });
    }

    public final void Z1() {
        PreLookModel preLookModel = (PreLookModel) h(PreLookModel.class);
        this.D = preLookModel;
        preLookModel.getResultLiveData().observe(this, new Observer() { // from class: c.e.c.d0.b.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1419a.T1((ResponseStateVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.d0.b.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1420a.V1((RequestErrDto) obj);
            }
        });
    }

    public final void a2() {
    }

    public final void b2(String str, List<String> list) {
        List<String> listJ1 = J1();
        SubmitContractCommentBo submitContractCommentBo = new SubmitContractCommentBo();
        if (list != null) {
            submitContractCommentBo.setEnclosureKeys(list);
        }
        if (listJ1 != null) {
            submitContractCommentBo.setTagKeys(listJ1);
        }
        if (str != null) {
            submitContractCommentBo.setCommentContent(str);
        }
        submitContractCommentBo.setContractKey(this.f6484b);
        List<ContractCommentVo.CommentItemsBean> list2 = this.C;
        if (list2 != null) {
            submitContractCommentBo.setCommentItems(list2);
        }
        this.E.postContractCommentInfo(this.f6484b, submitContractCommentBo);
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_pre_look_comment;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.E.getContractCommentInfo(this.f6484b);
    }

    @OnClick({R.id.btn_next})
    public void submitClick(View view) {
        String string = this.mCommentContentEdt.getText().toString();
        if (x.isNullStr(string)) {
            F0(R.string.tip_comment_content_is_empty);
        } else {
            if (this.B.uploadPic()) {
                return;
            }
            z0(R.string.tip_submit_data_loading);
            b2(string, null);
        }
    }
}
