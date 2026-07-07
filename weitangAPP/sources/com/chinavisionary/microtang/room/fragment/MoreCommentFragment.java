package com.chinavisionary.microtang.room.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import c.e.c.m0.g;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.merchant.vo.MerchantCommentVo;
import com.chinavisionary.microtang.room.adapter.MoreRentCommentAdapter;
import com.chinavisionary.microtang.room.model.RoomOperationModel;
import com.chinavisionary.microtang.room.vo.ResponseMoreRentCommentVo;
import com.chinavisionary.microtang.view.FlowLayout;
import com.hedgehog.ratingbar.RatingBar;

/* JADX INFO: loaded from: classes2.dex */
public class MoreCommentFragment extends BaseFragment<MerchantCommentVo> {
    public CoreBaseFragment.c B;
    public RoomOperationModel C;
    public TextWatcher D = new a();
    public Runnable E = new b();

    @BindView(R.id.flow_layout_comment_tag)
    public FlowLayout mCommentTagLayout;

    @BindView(R.id.rating_bar_satisfied)
    public RatingBar mSatisfiedRatingBar;

    @BindView(R.id.edt_search_room)
    public EditText mSearchRoomEdt;

    @BindView(R.id.rating_bar_service_satisfied)
    public RatingBar mServiceSatisfiedRatingBar;

    @BindView(R.id.swipe_refresh_layout_more_comment)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (MoreCommentFragment.this.B != null) {
                MoreCommentFragment.this.B.removeCallbacks(MoreCommentFragment.this.E);
                MoreCommentFragment.this.B.postDelayed(MoreCommentFragment.this.E, 300L);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MoreCommentFragment.this.j0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: G1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H1(ResponseMoreRentCommentVo responseMoreRentCommentVo) {
        I0();
        g.getInstance().setupCommentTag(responseMoreRentCommentVo.getTags(), this.mCommentTagLayout, this.f6487e);
        this.mSatisfiedRatingBar.setStar(responseMoreRentCommentVo.getAverageScore());
    }

    private void I0() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J1(RequestErrDto requestErrDto) {
        B();
        I0();
        C(requestErrDto);
    }

    public static MoreCommentFragment getInstance(String str) {
        MoreCommentFragment moreCommentFragment = new MoreCommentFragment();
        moreCommentFragment.setArguments(CoreBaseFragment.q(str));
        return moreCommentFragment;
    }

    public final void K1() {
        RoomOperationModel roomOperationModel = (RoomOperationModel) h(RoomOperationModel.class);
        this.C = roomOperationModel;
        roomOperationModel.getRoomCommentList().observe(this, new Observer() { // from class: c.e.c.h0.f.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1498a.H1((ResponseMoreRentCommentVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.h0.f.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1499a.J1((RequestErrDto) obj);
            }
        });
    }

    public final void L1() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        this.t = new MoreRentCommentAdapter();
        this.B = new CoreBaseFragment.c(this);
        this.mSearchRoomEdt.addTextChangedListener(this.D);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        K1();
        L1();
        j0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_more_comment;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        z0(R.string.loading_text);
        this.C.getRoomCommentList(this.f6484b);
    }

    @OnClick({R.id.btn_reset})
    public void resetClick(View view) {
        this.mSearchRoomEdt.setText("");
    }

    @OnClick({R.id.btn_search})
    public void searchClick(View view) {
        if (x.isNotNull(this.mSearchRoomEdt.getText().toString())) {
            return;
        }
        F0(R.string.tip_search_content_is_empty);
    }
}
