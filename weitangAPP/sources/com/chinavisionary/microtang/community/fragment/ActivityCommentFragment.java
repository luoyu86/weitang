package com.chinavisionary.microtang.community.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.k.d;
import c.e.a.d.b0;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.core.app.upload.UploadNineFragment;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.comment.event.EventRefreshCommentList;
import com.chinavisionary.microtang.comment.vo.ScoresBean;
import com.chinavisionary.microtang.community.model.CommunityModel;
import com.chinavisionary.microtang.community.vo.RequestActivityCommentBo;
import com.chinavisionary.microtang.community.vo.RequestActivityCommentDetailsBo;
import com.chinavisionary.microtang.community.vo.ResponseActivityCommentVo;
import com.chinavisionary.microtang.repair.fragment.RepairOrderCommentFragment;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ActivityCommentFragment extends BaseFragment<String> {
    public CommunityModel C;
    public UploadNineFragment G;
    public c.e.c.m.f.b H;
    public String I;
    public boolean J;

    @BindView(R.id.tv_activity_title)
    public TextView mActivityTitleTv;

    @BindView(R.id.tv_add_pic_title)
    public TextView mAddPicTitleTv;

    @BindView(R.id.edt_comment_content)
    public EditText mCommentContentEdt;

    @BindView(R.id.flayout_nine_grid_view)
    public FrameLayout mGridViewLayout;

    @BindView(R.id.tv_input_max_length_tip)
    public TextView mInputMaxLengthTipTv;

    @BindView(R.id.llayout_score)
    public LinearLayout mLinearLayoutScore;

    @BindView(R.id.btn_next)
    public AppCompatButton mNextBtn;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public int B = 0;
    public final LinkedHashMap<String, Float> D = new LinkedHashMap<>();
    public final LinkedHashMap<String, String> E = new LinkedHashMap<>();
    public List<String> F = new ArrayList();
    public final TextWatcher K = new a();
    public final d L = new b();
    public final c.e.c.m.d.a M = new c();

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ActivityCommentFragment.this.X1();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public class b implements d {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(String str) {
            ActivityCommentFragment.this.H();
            ActivityCommentFragment.this.G0(str);
        }

        @Override // c.e.a.a.k.d
        public void uploadFailed(final String str) {
            if (ActivityCommentFragment.this.f6488f != null) {
                ActivityCommentFragment.this.f6488f.post(new Runnable() { // from class: c.e.c.n.d.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1713a.b(str);
                    }
                });
            }
            q.e(RepairOrderCommentFragment.class.getSimpleName(), "upload failed :" + str);
        }

        @Override // c.e.a.a.k.d
        public void uploadSuccess(UploadResponseDto uploadResponseDto) {
            ActivityCommentFragment.this.W1(ActivityCommentFragment.this.mCommentContentEdt.getText().toString(), b0.getInstance().getUploadSuccessPicUrl(uploadResponseDto.getUploadSuccessList()));
        }
    }

    public class c implements c.e.c.m.d.a {
        public c() {
        }

        @Override // c.e.c.m.d.a
        public void onRagingBarCallback(String str, float f2) {
            ActivityCommentFragment.this.D.put(str, Float.valueOf(f2));
            if (ActivityCommentFragment.this.E.containsKey(str)) {
                ActivityCommentFragment.this.E.remove(str);
            }
            ActivityCommentFragment.this.H.updateRatingIcon(str, f2);
        }
    }

    public static ActivityCommentFragment getInstance(String str, String str2, boolean z) {
        ActivityCommentFragment activityCommentFragment = new ActivityCommentFragment();
        activityCommentFragment.f6484b = str;
        activityCommentFragment.J = z;
        activityCommentFragment.I = str2;
        return activityCommentFragment;
    }

    public final void N1(ResponseActivityCommentVo responseActivityCommentVo) {
        if (responseActivityCommentVo != null) {
            if (responseActivityCommentVo.getIsEvaluate()) {
                this.mInputMaxLengthTipTv.setVisibility(8);
                this.mCommentContentEdt.setEnabled(false);
                this.mNextBtn.setVisibility(8);
                this.mCommentContentEdt.setEnabled(false);
                this.mCommentContentEdt.setText(x.getNotNullStr(responseActivityCommentVo.getContent(), "-"));
                this.G.initAdapterDataToResourceVo(responseActivityCommentVo.getPictureUrlList());
                V1(false, Float.valueOf(responseActivityCommentVo.getScore()));
            } else {
                this.mInputMaxLengthTipTv.setVisibility(0);
                this.mCommentContentEdt.setEnabled(true);
                this.mNextBtn.setVisibility(0);
                V1(true, null);
            }
        }
        H();
    }

    public final void O1(NewResponseStateVo newResponseStateVo) {
        boolean zA = A(newResponseStateVo, R.string.tip_submit_success, R.string.tip_submit_failed);
        k(new EventRefreshCommentList());
        if (zA) {
            n();
        }
    }

    public final void P1() {
        CommunityModel communityModel = (CommunityModel) h(CommunityModel.class);
        this.C = communityModel;
        communityModel.getCommentResult().observeForever(new Observer() { // from class: c.e.c.n.d.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1715a.O1((NewResponseStateVo) obj);
            }
        });
        this.C.getCommentDetailsResult().observeForever(new Observer() { // from class: c.e.c.n.d.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1717a.N1((ResponseActivityCommentVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.n.d.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1716a.C((RequestErrDto) obj);
            }
        });
    }

    public final void Q1() {
        this.f6488f = new CoreBaseFragment.c(this);
        this.mNextBtn.setOnClickListener(this.y);
        this.mCommentContentEdt.addTextChangedListener(this.K);
        this.mTitleTv.setText(R.string.title_activity_comment);
        this.mActivityTitleTv.setText(x.getNotNullStr(this.I, ""));
        this.H = new c.e.c.m.f.b();
        X1();
    }

    public final void U1() {
        UploadNineFragment uploadNineFragment = UploadNineFragment.getInstance(this.L);
        this.G = uploadNineFragment;
        uploadNineFragment.setMaxPic(3);
        e(this.G, R.id.flayout_nine_grid_view, false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.btn_next) {
            if (!this.D.containsKey("comment_score_key")) {
                F0(R.string.tip_comment_score_is_empty);
                return;
            }
            String string = this.mCommentContentEdt.getText().toString();
            if (this.G.uploadPic()) {
                return;
            }
            z0(R.string.tip_submit_data_loading);
            W1(string, null);
        }
    }

    public final void V1(boolean z, Float f2) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f6487e);
        ArrayList arrayList = new ArrayList();
        ScoresBean scoresBean = new ScoresBean();
        scoresBean.setScoreType("comment_score_key");
        scoresBean.setScoreTypeDesc(x.getString(R.string.title_comprehensive_comment_score));
        if (f2 != null) {
            scoresBean.setScore(f2.floatValue());
        }
        arrayList.add(scoresBean);
        this.H.setupActivityScore(arrayList, layoutInflaterFrom, this.mLinearLayoutScore, this.M, z);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        Q1();
        P1();
        U1();
        if (this.J) {
            this.mCommentContentEdt.setEnabled(false);
            this.mNextBtn.setVisibility(8);
            this.G.initAdapterDataToResourceVo(null);
        } else {
            V1(true, null);
        }
        j0();
    }

    public final void W1(String str, List<String> list) {
        RequestActivityCommentBo requestActivityCommentBo = new RequestActivityCommentBo();
        requestActivityCommentBo.setContent(str);
        requestActivityCommentBo.setActivityPrimaryKey(this.f6484b);
        requestActivityCommentBo.setPictureUrl(list);
        Float f2 = this.D.get("comment_score_key");
        if (f2 != null) {
            requestActivityCommentBo.setScore(f2.intValue());
        }
        this.C.postActivityComment(requestActivityCommentBo);
    }

    public final void X1() {
        if (this.mInputMaxLengthTipTv.getVisibility() == 0) {
            String string = this.mCommentContentEdt.getText().toString();
            this.mInputMaxLengthTipTv.setText(x.getString(R.string.placeholder_max_length, Integer.valueOf(x.isNotNull(string) ? string.length() : 0)));
        }
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_create_activity_comment;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        if (this.J) {
            this.mInputMaxLengthTipTv.setVisibility(8);
            z0(R.string.loading_text);
        }
        RequestActivityCommentDetailsBo requestActivityCommentDetailsBo = new RequestActivityCommentDetailsBo();
        requestActivityCommentDetailsBo.setActivityPrimaryKey(this.f6484b);
        this.C.getActivityComment(requestActivityCommentDetailsBo);
    }
}
