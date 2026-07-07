package com.chinavisionary.microtang.order.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.k.d;
import c.e.a.d.b0;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.core.app.upload.UploadNineFragment;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.comment.vo.ScoresBean;
import com.chinavisionary.microtang.repair.fragment.RepairOrderCommentFragment;
import com.chinavisionary.microtang.repair.vo.CreateRepairOrderCommentVo;
import com.hedgehog.ratingbar.RatingBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class OrderCommentFragment extends BaseFragment {
    public UploadNineFragment C;
    public String D;

    @BindView(R.id.edt_comment_content)
    public AppCompatEditText mCommentContentEdt;

    @BindView(R.id.llayout_comment_score)
    public LinearLayout mCommentScoreLLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public Map<String, Integer> B = new HashMap();
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
            OrderCommentFragment.this.I1(OrderCommentFragment.this.mCommentContentEdt.getText().toString(), b0.getInstance().getUploadSuccessPicKey(uploadResponseDto.getUploadSuccessList()));
        }
    }

    public class b implements RatingBar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8082a;

        public b() {
        }

        @Override // com.hedgehog.ratingbar.RatingBar.b
        public void onRatingChange(float f2) {
            OrderCommentFragment.this.B.remove(this.f8082a);
            OrderCommentFragment.this.B.put(this.f8082a, Integer.valueOf((int) f2));
        }

        public void setType(String str) {
            this.f8082a = str;
        }
    }

    public static OrderCommentFragment getInstance(String str, String str2) {
        OrderCommentFragment orderCommentFragment = new OrderCommentFragment();
        orderCommentFragment.setArguments(CoreBaseFragment.q(str));
        orderCommentFragment.G1(str2);
        return orderCommentFragment;
    }

    public final void G1(String str) {
        this.D = str;
    }

    public final void H1(List<ScoresBean> list) {
        H();
        this.mCommentScoreLLayout.removeAllViews();
        this.B.clear();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f6487e);
        for (ScoresBean scoresBean : list) {
            if (scoresBean != null) {
                View viewInflate = layoutInflaterFrom.inflate(R.layout.item_title_score_layout, (ViewGroup) null);
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_product_service_satisfied);
                RatingBar ratingBar = (RatingBar) viewInflate.findViewById(R.id.rating_bar_service_satisfied);
                ratingBar.setTag(scoresBean.getScoreType());
                b bVar = new b();
                bVar.setType(scoresBean.getScoreType());
                ratingBar.setOnRatingChangeListener(bVar);
                textView.setText(scoresBean.getScoreTypeDesc());
                this.mCommentScoreLLayout.addView(viewInflate);
            }
        }
    }

    public final void I1(String str, List<String> list) {
        z0(R.string.tip_submit_data_loading);
        CreateRepairOrderCommentVo createRepairOrderCommentVo = new CreateRepairOrderCommentVo();
        createRepairOrderCommentVo.setCommentContent(str);
        createRepairOrderCommentVo.setCommentResources(list);
        createRepairOrderCommentVo.setRepairOrderKey(this.f6484b);
        if (this.B != null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Integer> entry : this.B.entrySet()) {
                CreateRepairOrderCommentVo.ScoresBean scoresBean = new CreateRepairOrderCommentVo.ScoresBean();
                scoresBean.setScore(entry.getValue().intValue());
                scoresBean.setScoreType(entry.getKey());
                arrayList.add(scoresBean);
            }
            createRepairOrderCommentVo.setScores(arrayList);
        }
        H();
        F0(R.string.tip_submit_success);
        n();
    }

    public final void J1() {
        H1(c.e.c.y.d.a.getCommentScore());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(x.getNotNullStr(this.D, ""));
        UploadNineFragment uploadNineFragment = UploadNineFragment.getInstance(this.E);
        this.C = uploadNineFragment;
        e(uploadNineFragment, R.id.flayout_comment_pic_content, false);
        J1();
    }

    @OnClick({R.id.tv_back})
    public void backClick() {
        n();
    }

    @OnClick({R.id.btn_next})
    public void commentClick() {
        String string = this.mCommentContentEdt.getText().toString();
        if (x.isNullStr(string)) {
            F0(R.string.tip_comment_content_is_empty);
        } else {
            if (this.C.uploadPic()) {
                return;
            }
            I1(string, null);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_order_comment_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
