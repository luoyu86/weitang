package com.chinavisionary.microtang.repair.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.k.d;
import c.e.a.d.b0;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.m0.f;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.core.app.upload.UploadNineFragment;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.comment.vo.ScoresBean;
import com.chinavisionary.microtang.prelook.vo.TagVo;
import com.chinavisionary.microtang.repair.model.RepairModel;
import com.chinavisionary.microtang.repair.vo.CreateRepairOrderCommentVo;
import com.chinavisionary.microtang.repair.vo.EventUpdateOrderState;
import com.chinavisionary.microtang.repair.vo.RepairCommentDetailsVo;
import com.chinavisionary.microtang.repair.vo.RepairOrderCommentScoreVo;
import com.hedgehog.ratingbar.RatingBar;
import com.nex3z.flowlayout.FlowLayout;
import g.b.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RepairOrderCommentFragment extends BaseFragment {
    public RepairModel C;
    public UploadNineFragment D;

    @BindView(R.id.edt_comment_content)
    public AppCompatEditText mCommentContentEdt;

    @BindView(R.id.tv_comment_title)
    public TextView mCommentTitleTv;

    @BindView(R.id.flow_layout_comment_tag)
    public FlowLayout mFlowLayout;

    @BindView(R.id.tv_product_satisfied)
    public TextView mHandleResultTitle;

    @BindView(R.id.cb_over)
    public CheckBox mOverCb;

    @BindView(R.id.tv_add_pic_title)
    public TextView mPicTitleTv;

    @BindView(R.id.llayout_score)
    public LinearLayout mScoreLinearLayout;

    @BindView(R.id.btn_next)
    public AppCompatButton mSubmitBtn;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    @BindView(R.id.cb_un_over)
    public CheckBox mUnOverCb;
    public Map<String, Float> B = new HashMap();
    public d E = new a();

    public class a implements d {
        public a() {
        }

        @Override // c.e.a.a.k.d
        public void uploadFailed(String str) {
            q.e(RepairOrderCommentFragment.class.getSimpleName(), "upload failed :" + str);
        }

        @Override // c.e.a.a.k.d
        public void uploadSuccess(UploadResponseDto uploadResponseDto) {
            RepairOrderCommentFragment.this.W1(RepairOrderCommentFragment.this.mCommentContentEdt.getText().toString(), b0.getInstance().getUploadSuccessPicKey(uploadResponseDto.getUploadSuccessList()));
        }
    }

    public class b implements RatingBar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8247a;

        public b() {
        }

        @Override // com.hedgehog.ratingbar.RatingBar.b
        public void onRatingChange(float f2) {
            RepairOrderCommentFragment.this.B.remove(this.f8247a);
            RepairOrderCommentFragment.this.B.put(this.f8247a, Float.valueOf(f2));
        }

        public void setType(String str) {
            this.f8247a = str;
            RepairOrderCommentFragment.this.B.put(str, Float.valueOf(4.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1(ResponseStateVo responseStateVo) {
        if (F(responseStateVo, R.string.tip_comment_success, R.string.title_send_comment_failed)) {
            P1();
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(RepairOrderCommentScoreVo repairOrderCommentScoreVo) {
        H();
        if (repairOrderCommentScoreVo != null) {
            List<RepairOrderCommentScoreVo.TagsBean> tags = repairOrderCommentScoreVo.getTags();
            V1(repairOrderCommentScoreVo.getScores(), true);
            S1(tags, true);
        }
    }

    public static RepairOrderCommentFragment getInstance(String str) {
        RepairOrderCommentFragment repairOrderCommentFragment = new RepairOrderCommentFragment();
        repairOrderCommentFragment.setArguments(CoreBaseFragment.q(str));
        return repairOrderCommentFragment;
    }

    public final void G1(RepairCommentDetailsVo repairCommentDetailsVo) {
        if (repairCommentDetailsVo == null) {
            T1(true);
            I1();
        } else if (repairCommentDetailsVo.isComment()) {
            T1(false);
            R1(repairCommentDetailsVo);
        } else {
            T1(true);
            I1();
        }
    }

    public final void H1(boolean z) {
        this.mUnOverCb.setChecked(!z);
        this.mOverCb.setChecked(z);
        I1();
    }

    public final void I1() {
        this.mTitleTv.setText(R.string.title_repair_comment);
        this.mUnOverCb.setOnClickListener(this.y);
        this.mOverCb.setOnClickListener(this.y);
    }

    public final void P1() {
        c.getDefault().post(new EventUpdateOrderState());
    }

    public final void Q1() {
        UploadNineFragment uploadNineFragment = UploadNineFragment.getInstance(this.E);
        this.D = uploadNineFragment;
        e(uploadNineFragment, R.id.flayout_nine_grid_view, false);
    }

    public final void R1(RepairCommentDetailsVo repairCommentDetailsVo) {
        this.mTitleTv.setText(R.string.title_repair_comment_details);
        this.mCommentTitleTv.setText(R.string.title_comment_content);
        this.mCommentContentEdt.setBackgroundResource(R.drawable.bg_btn_fill_grad_6_radius);
        this.mCommentContentEdt.setText(x.getNotNullStr(repairCommentDetailsVo.getContent(), ""));
        this.D.initAdapterDataToResourceVo(repairCommentDetailsVo.getResources());
        V1(repairCommentDetailsVo.getScores(), false);
        S1(repairCommentDetailsVo.getTags(), false);
    }

    public final void S1(List<RepairOrderCommentScoreVo.TagsBean> list, boolean z) {
        this.mFlowLayout.removeAllViews();
        if (list == null || list.isEmpty()) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp_6);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            RepairOrderCommentScoreVo.TagsBean tagsBean = list.get(i2);
            if (tagsBean != null) {
                TagVo tagVo = new TagVo();
                tagVo.setContent(tagsBean.getTagDesc());
                tagVo.setKey(tagsBean.getTagCode());
                if (z) {
                    this.mFlowLayout.addView(f.getInstance().addCommentTag(this.f6487e, tagVo, this.y, layoutParams, dimensionPixelSize));
                } else {
                    this.mFlowLayout.addView(f.getInstance().addCommentTagReturnTv(this.f6487e, tagVo, layoutParams, dimensionPixelSize));
                }
            }
        }
    }

    public final void T1(boolean z) {
        this.mSubmitBtn.setVisibility(z ? 0 : 8);
        this.mHandleResultTitle.setVisibility(z ? 0 : 8);
        this.mOverCb.setVisibility(z ? 0 : 8);
        this.mUnOverCb.setVisibility(z ? 0 : 8);
        this.mPicTitleTv.setText(z ? R.string.title_add_pic : R.string.title_comment_pic);
        this.mCommentContentEdt.setEnabled(z);
    }

    public final void U1() {
        RepairModel repairModel = (RepairModel) h(RepairModel.class);
        this.C = repairModel;
        repairModel.getResultLiveData().observe(this, new Observer() { // from class: c.e.c.g0.b.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1467a.L1((ResponseStateVo) obj);
            }
        });
        this.C.getRepairOrderCommentDetails().observe(this, new Observer() { // from class: c.e.c.g0.b.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1470a.G1((RepairCommentDetailsVo) obj);
            }
        });
        this.C.getRepairOrderCommentScore().observe(this, new Observer() { // from class: c.e.c.g0.b.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1469a.N1((RepairOrderCommentScoreVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.g0.b.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1468a.C((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.cb_over) {
            H1(true);
        } else {
            if (id != R.id.cb_un_over) {
                return;
            }
            H1(false);
        }
    }

    public final void V1(List<ScoresBean> list, boolean z) {
        H();
        this.mScoreLinearLayout.removeAllViews();
        this.B.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f6487e);
        for (ScoresBean scoresBean : list) {
            if (scoresBean != null) {
                View viewInflate = layoutInflaterFrom.inflate(R.layout.item_title_score_layout, (ViewGroup) null);
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_product_service_satisfied);
                RatingBar ratingBar = (RatingBar) viewInflate.findViewById(R.id.rating_bar_service_satisfied);
                ratingBar.setTag(scoresBean.getScoreType());
                if (z) {
                    ratingBar.setStar(4.0f);
                } else {
                    ratingBar.setStar(scoresBean.getScore());
                }
                ratingBar.halfStar(true);
                ratingBar.setmClickable(z);
                b bVar = new b();
                bVar.setType(scoresBean.getScoreType());
                ratingBar.setOnRatingChangeListener(bVar);
                textView.setText(scoresBean.getScoreTypeDesc());
                this.mScoreLinearLayout.addView(viewInflate);
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        I1();
        Q1();
        U1();
        this.mOverCb.setChecked(true);
        T1(false);
        if (x.isNotNull(this.f6484b)) {
            z0(R.string.loading_text);
            this.C.getRepairOrderCommentDetails(this.f6484b);
        } else {
            F0(R.string.tip_data_load_failed);
            n();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void W1(String str, List<String> list) {
        z0(R.string.tip_submit_data_loading);
        List<String> selectTag = f.getInstance().getSelectTag(this.mFlowLayout);
        CreateRepairOrderCommentVo createRepairOrderCommentVo = new CreateRepairOrderCommentVo();
        createRepairOrderCommentVo.setCommentContent(str);
        createRepairOrderCommentVo.setCommentResources(list);
        createRepairOrderCommentVo.setRepairOrderKey(this.f6484b);
        createRepairOrderCommentVo.setCommentResult(this.mOverCb.isChecked() ? 1 : 0);
        createRepairOrderCommentVo.setTags(selectTag);
        if (this.B != null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Float> entry : this.B.entrySet()) {
                CreateRepairOrderCommentVo.ScoresBean scoresBean = new CreateRepairOrderCommentVo.ScoresBean();
                scoresBean.setScore(entry.getValue().floatValue());
                scoresBean.setScoreType(entry.getKey());
                arrayList.add(scoresBean);
            }
            createRepairOrderCommentVo.setScores(arrayList);
        }
        this.C.createRepairOrderComment(createRepairOrderCommentVo);
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @OnClick({R.id.btn_next})
    public void commentClick(View view) {
        String string = this.mCommentContentEdt.getText().toString();
        if (x.isNullStr(string)) {
            F0(R.string.tip_comment_content_is_empty);
        } else {
            if (this.D.uploadPic()) {
                return;
            }
            W1(string, null);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_repair_order_comment;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        this.C.getRepairOrderCommentScore(this.mOverCb.isChecked() ? 1 : 0);
    }
}
