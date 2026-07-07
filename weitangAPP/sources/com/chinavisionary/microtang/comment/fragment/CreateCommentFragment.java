package com.chinavisionary.microtang.comment.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.b0;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.core.app.upload.UploadNineFragment;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.comment.event.EventRefreshCommentList;
import com.chinavisionary.microtang.comment.model.CommentModel;
import com.chinavisionary.microtang.comment.vo.CommentDetailsScoreVo;
import com.chinavisionary.microtang.comment.vo.CommentDetailsVo;
import com.chinavisionary.microtang.comment.vo.CreateCommentBo;
import com.chinavisionary.microtang.comment.vo.CreateCommentResponseVo;
import com.chinavisionary.microtang.comment.vo.CreateCommentScoresBo;
import com.chinavisionary.microtang.comment.vo.ScoresBean;
import com.chinavisionary.microtang.order.vo.KeyValueVo;
import com.chinavisionary.microtang.repair.fragment.RepairOrderCommentFragment;
import com.hedgehog.ratingbar.RatingBar;
import com.lzy.imagepicker.bean.ImageItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CreateCommentFragment extends BaseFragment<String> {
    public boolean C;
    public String D;
    public CommentModel E;
    public float F;
    public UploadNineFragment J;
    public c.e.c.m.f.b K;

    @BindView(R.id.tv_add_pic_title)
    public TextView mAddPicTitleTv;

    @BindView(R.id.edt_comment_content)
    public EditText mCommentContentEdt;

    @BindView(R.id.tv_comment_top_content)
    public TextView mCommentTopContentTv;

    @BindView(R.id.flayout_nine_grid_view)
    public FrameLayout mGridViewLayout;

    @BindView(R.id.tv_input_max_length_tip)
    public TextView mInputMaxLengthTipTv;

    @BindView(R.id.llayout_info)
    public LinearLayout mLinearLayoutInfo;

    @BindView(R.id.llayout_score)
    public LinearLayout mLinearLayoutScore;

    @BindView(R.id.btn_next)
    public AppCompatButton mNextBtn;

    @BindView(R.id.view_praise_split_line)
    public View mPraiseLevelLineView;

    @BindView(R.id.tv_one_key_praise_title)
    public TextView mPraiseLevelTitleTv;

    @BindView(R.id.tv_tip_praise_level)
    public TextView mPraiseLevelTv;

    @BindView(R.id.tv_tip_praise_tip)
    public TextView mPraiseTipTv;

    @BindView(R.id.rating_bar_praise)
    public RatingBar mRatingBarPraise;

    @BindView(R.id.constraint_layout_recommend)
    public ConstraintLayout mRecommendLayout;

    @BindView(R.id.rating_bar_recommend)
    public RatingBar mRecommendRatingBarPraise;

    @BindView(R.id.tv_recommend_raging_result)
    public TextView mRecommendResultTv;

    @BindView(R.id.tv_tip_recommend_subtitle)
    public TextView mRecommendSubTitleTv;

    @BindView(R.id.tv_tip_recommend_msg)
    public TextView mRecommendTitleTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    @BindView(R.id.constraint_top_layout)
    public ConstraintLayout mTopLayout;
    public int B = 0;
    public final LinkedHashMap<String, Float> G = new LinkedHashMap<>();
    public final LinkedHashMap<String, String> H = new LinkedHashMap<>();
    public List<String> I = new ArrayList();
    public final TextWatcher L = new a();
    public final c.e.a.a.k.d M = new b();
    public final c.e.c.m.d.a N = new c();
    public final c.e.c.m.d.a O = new d();
    public final c.e.c.m.d.a P = new e();

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CreateCommentFragment.this.Z1();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public class b implements c.e.a.a.k.d {
        public b() {
        }

        @Override // c.e.a.a.k.d
        public void uploadFailed(String str) {
            q.e(RepairOrderCommentFragment.class.getSimpleName(), "upload failed :" + str);
        }

        @Override // c.e.a.a.k.d
        public void uploadSuccess(UploadResponseDto uploadResponseDto) {
            CreateCommentFragment.this.Y1(CreateCommentFragment.this.mCommentContentEdt.getText().toString(), b0.getInstance().getUploadSuccessPicUrl(uploadResponseDto.getUploadSuccessList()));
        }
    }

    public class c implements c.e.c.m.d.a {
        public c() {
        }

        @Override // c.e.c.m.d.a
        public void onRagingBarCallback(String str, float f2) {
            TextView textView;
            CreateCommentFragment.this.G.put(str, Float.valueOf(f2));
            if (CreateCommentFragment.this.H.containsKey(str)) {
                CreateCommentFragment.this.H.remove(str);
            }
            if (!CreateCommentFragment.this.K.getTypeTextViewMap().containsKey(str) || (textView = CreateCommentFragment.this.K.getTypeTextViewMap().get(str)) == null) {
                return;
            }
            textView.setText(CreateCommentFragment.this.K.getValueToScore(f2));
        }
    }

    public class d implements c.e.c.m.d.a {
        public d() {
        }

        @Override // c.e.c.m.d.a
        public void onRagingBarCallback(String str, float f2) {
            CreateCommentFragment.this.F = f2;
            CreateCommentFragment createCommentFragment = CreateCommentFragment.this;
            createCommentFragment.mRecommendResultTv.setText(createCommentFragment.K.getValueToRecommendScore(f2));
        }
    }

    public class e implements c.e.c.m.d.a {
        public e() {
        }

        @Override // c.e.c.m.d.a
        public void onRagingBarCallback(String str, float f2) {
            CreateCommentFragment createCommentFragment = CreateCommentFragment.this;
            createCommentFragment.mPraiseLevelTv.setText(createCommentFragment.K.getValueToScore(f2));
            if (f2 >= 5.0f) {
                CreateCommentFragment.this.K.handleOneKeyPraise();
            }
        }
    }

    public class f implements c.e.a.a.k.e {
        public f() {
        }

        @Override // c.e.a.a.k.e
        public void onSelectPicChange(List<ImageItem> list) {
            CreateCommentFragment.this.a2();
        }
    }

    public static CreateCommentFragment getInstance(String str, String str2) {
        CreateCommentFragment createCommentFragment = new CreateCommentFragment();
        createCommentFragment.setArguments(CoreBaseFragment.q(str));
        createCommentFragment.setTitle(str2);
        return createCommentFragment;
    }

    public final void L1(ResponseStateVo responseStateVo) {
        boolean zF = F(responseStateVo, R.string.tip_submit_success, R.string.tip_submit_failed);
        k(new EventRefreshCommentList());
        if (zF) {
            m();
        }
    }

    public final void M1(CommentDetailsVo commentDetailsVo) {
        if (commentDetailsVo == null) {
            F0(R.string.data_error);
            H();
            return;
        }
        V1(commentDetailsVo.isIsComment());
        if (commentDetailsVo.isIsComment()) {
            W1(commentDetailsVo);
        } else {
            this.E.getCreateNewCommentInfo(this.f6484b);
        }
    }

    public final void N1(CreateCommentResponseVo createCommentResponseVo) {
        this.G.clear();
        this.mNextBtn.setVisibility(0);
        this.mTitleTv.setText(x.getNotNullStr(createCommentResponseVo.getCommentTypeName(), getString(R.string.title_comment)));
        this.C = true;
        this.mCommentTopContentTv.setText(x.getNotNullStr(createCommentResponseVo.getCommentBannerText(), ""));
        this.mTopLayout.setVisibility(0);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f6487e);
        this.K.setupInfo(createCommentResponseVo.getAddress(), layoutInflaterFrom, this.mLinearLayoutInfo);
        if (o.isNotEmpty(createCommentResponseVo.getScores())) {
            this.B = createCommentResponseVo.getScores().size();
            for (ScoresBean scoresBean : createCommentResponseVo.getScores()) {
                if (scoresBean != null && !"19".equals(scoresBean.getScoreType())) {
                    this.I.add(scoresBean.getScoreType());
                    this.H.put(scoresBean.getScoreType(), scoresBean.getScoreTypeDesc());
                }
            }
        } else {
            this.B = 0;
        }
        List<ScoresBean> scores = createCommentResponseVo.getScores();
        if (o.isNotEmpty(scores)) {
            ScoresBean scoresBean2 = null;
            Iterator<ScoresBean> it = scores.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ScoresBean next = it.next();
                if (next != null && "19".equals(next.getScoreType())) {
                    scoresBean2 = next;
                    break;
                }
            }
            if (scoresBean2 != null) {
                CommentDetailsScoreVo commentDetailsScoreVo = new CommentDetailsScoreVo();
                commentDetailsScoreVo.setScore(scoresBean2.getScore());
                commentDetailsScoreVo.setScoreType(scoresBean2.getScoreType());
                commentDetailsScoreVo.setScoreTypeContent(scoresBean2.getScoreTypeContent());
                commentDetailsScoreVo.setScoreTypeDesc(scoresBean2.getScoreTypeDesc());
                commentDetailsScoreVo.setScoreTypeName(scoresBean2.getScoreTypeName());
                O1(commentDetailsScoreVo, true);
                scores.remove(scoresBean2);
            }
        }
        this.K.setupScore(scores, layoutInflaterFrom, this.mLinearLayoutScore, this.N, true);
        H();
    }

    public final void O1(CommentDetailsScoreVo commentDetailsScoreVo, boolean z) {
        this.mRecommendLayout.setVisibility(0);
        this.mRecommendRatingBarPraise.setmClickable(z);
        this.mRecommendRatingBarPraise.setStar(commentDetailsScoreVo.getScore());
        this.mRecommendTitleTv.setText(commentDetailsScoreVo.getScoreTypeDesc());
        this.mRecommendSubTitleTv.setText(commentDetailsScoreVo.getScoreTypeContent());
        this.mRecommendSubTitleTv.setVisibility(x.isNotNull(commentDetailsScoreVo.getScoreTypeContent()) ? 0 : 8);
        this.mRecommendResultTv.setText(this.K.getValueToRecommendScore(commentDetailsScoreVo.getScore()));
    }

    public final void P1() {
        this.mCommentContentEdt.addTextChangedListener(this.L);
        this.mTitleTv.setText(x.getNotNullStr(this.D, getString(R.string.title_comment)));
        this.K = new c.e.c.m.f.b();
        this.mRatingBarPraise.setOnRatingChangeListener(new c.e.c.m.f.a(this.P));
        this.mRecommendRatingBarPraise.setOnRatingChangeListener(new c.e.c.m.f.a(this.O));
        Z1();
    }

    public final void U1() {
        UploadNineFragment uploadNineFragment = UploadNineFragment.getInstance(this.M);
        this.J = uploadNineFragment;
        uploadNineFragment.setIUploadPicCallback(new f());
        e(this.J, R.id.flayout_nine_grid_view, false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    public final void V1(boolean z) {
        int i2 = z ? 8 : 0;
        this.mPraiseLevelTitleTv.setVisibility(i2);
        this.mRatingBarPraise.setVisibility(i2);
        this.mInputMaxLengthTipTv.setVisibility(i2);
        this.mPraiseTipTv.setVisibility(i2);
        this.mPraiseLevelTv.setVisibility(i2);
        this.mPraiseLevelLineView.setVisibility(i2);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        P1();
        U1();
        X1();
        I1();
    }

    public final void W1(CommentDetailsVo commentDetailsVo) {
        KeyValueVo keyValueVo;
        String content = commentDetailsVo.getContent();
        this.mNextBtn.setVisibility(8);
        this.mRecommendLayout.setVisibility(8);
        this.mTopLayout.setVisibility(8);
        this.mTitleTv.setText(x.getNotNullStr(commentDetailsVo.getCommentTypeName(), getString(R.string.title_comment)) + x.getString(R.string.title_details));
        this.mCommentContentEdt.setText(content);
        this.mCommentContentEdt.setEnabled(false);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f6487e);
        List<CommentDetailsScoreVo> scores = commentDetailsVo.getScores();
        if (o.isNotEmpty(scores)) {
            CommentDetailsScoreVo commentDetailsScoreVo = null;
            Iterator<CommentDetailsScoreVo> it = scores.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CommentDetailsScoreVo next = it.next();
                if (next != null && "19".equals(next.getScoreType())) {
                    commentDetailsScoreVo = next;
                    break;
                }
            }
            if (commentDetailsScoreVo != null) {
                O1(commentDetailsScoreVo, false);
                scores.remove(commentDetailsScoreVo);
            }
        }
        this.K.setupCommentScore(scores, layoutInflaterFrom, this.mLinearLayoutScore);
        this.K.setupInfo(commentDetailsVo.getAddress(), layoutInflaterFrom, this.mLinearLayoutInfo);
        boolean zIsNotEmpty = o.isNotEmpty(commentDetailsVo.getResources());
        this.mAddPicTitleTv.setVisibility(zIsNotEmpty ? 0 : 8);
        this.mGridViewLayout.setVisibility(zIsNotEmpty ? 0 : 8);
        this.mAddPicTitleTv.setText(R.string.title_comment_pic);
        this.J.initAdapterDataToResourceVo(commentDetailsVo.getResources());
        a2();
        List<KeyValueVo> address = commentDetailsVo.getAddress();
        Y0(this.mTitleTv.getText().toString(), (!o.isNotEmpty(address) || (keyValueVo = address.get(0)) == null) ? "" : keyValueVo.getValue());
        H();
    }

    public final void X1() {
        CommentModel commentModel = (CommentModel) h(CommentModel.class);
        this.E = commentModel;
        commentModel.getCreateResultLive().observeForever(new Observer() { // from class: c.e.c.m.e.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1661a.L1((ResponseStateVo) obj);
            }
        });
        this.E.getNewCreateCommentLive().observe(this, new Observer() { // from class: c.e.c.m.e.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1660a.N1((CreateCommentResponseVo) obj);
            }
        });
        this.E.getCommentDetailsLive().observe(this, new Observer() { // from class: c.e.c.m.e.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1659a.M1((CommentDetailsVo) obj);
            }
        });
        this.E.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.m.e.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1658a.C((RequestErrDto) obj);
            }
        });
    }

    public final void Y1(String str, List<String> list) {
        if (!this.C) {
            F0(R.string.tip_data_init_faile_);
            return;
        }
        z0(R.string.tip_submit_data_loading);
        CreateCommentBo createCommentBo = new CreateCommentBo();
        createCommentBo.setContent(str);
        createCommentBo.setResourceKeys(list);
        createCommentBo.setImageUrls(list);
        createCommentBo.setRentCommentKey(this.f6484b);
        if (!this.G.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            try {
                for (String str2 : this.I) {
                    if (this.G.containsKey(str2)) {
                        CreateCommentScoresBo createCommentScoresBo = new CreateCommentScoresBo();
                        createCommentScoresBo.setScore(this.G.get(str2));
                        createCommentScoresBo.setScoreType(str2);
                        arrayList.add(createCommentScoresBo);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.mRecommendLayout.getVisibility() == 0 && this.F > 0.0f) {
                CreateCommentScoresBo createCommentScoresBo2 = new CreateCommentScoresBo();
                createCommentScoresBo2.setScore(Float.valueOf(this.F));
                createCommentScoresBo2.setScoreType("19");
                arrayList.add(createCommentScoresBo2);
            }
            createCommentBo.setScores(arrayList);
        }
        q.d(this.f6485c, "commentVo = " + JSON.toJSONString(createCommentBo));
        this.E.createComment(createCommentBo);
    }

    public final void Z1() {
        if (this.mInputMaxLengthTipTv.getVisibility() == 0) {
            String string = this.mCommentContentEdt.getText().toString();
            this.mInputMaxLengthTipTv.setText(x.getString(R.string.placeholder_max_length, Integer.valueOf(x.isNotNull(string) ? string.length() : 0)));
        }
    }

    public final void a2() {
        int imageCount = this.J.getImageCount();
        if (imageCount <= 3) {
            this.mGridViewLayout.getLayoutParams().height = this.mGridViewLayout.getResources().getDimensionPixelSize(R.dimen.dp_80);
        } else if (imageCount <= 6) {
            this.mGridViewLayout.getLayoutParams().height = this.mGridViewLayout.getResources().getDimensionPixelSize(R.dimen.dp_160);
        } else {
            this.mGridViewLayout.getLayoutParams().height = this.mGridViewLayout.getResources().getDimensionPixelSize(R.dimen.dp_240);
        }
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @OnClick({R.id.btn_next})
    public void commentClick(View view) {
        if (this.G.size() == 0) {
            F0(R.string.tip_comment_score_is_empty);
            return;
        }
        if (!this.H.isEmpty()) {
            G0(x.appendStringToResId(R.string.tip_comment_score, this.H.entrySet().iterator().next().getValue()));
            return;
        }
        if (this.F <= 0.0f && this.mRecommendLayout.getVisibility() == 0) {
            G0(x.appendStringToResId(R.string.placeholder_select, this.mRecommendTitleTv.getText().toString()));
            return;
        }
        String string = this.mCommentContentEdt.getText().toString();
        if (this.J.uploadPic()) {
            return;
        }
        Y1(string, null);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_create_comment;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        z0(R.string.loading_text);
        this.E.getCommentDetails(this.f6484b);
    }

    public final void setTitle(String str) {
        this.D = str;
    }
}
