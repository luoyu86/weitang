package com.chinavisionary.microtang.community.fragment;

import android.annotation.SuppressLint;
import android.os.Message;
import android.view.View;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import c.e.c.n.b.a;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.comment.event.EventRefreshCommentList;
import com.chinavisionary.microtang.community.adapter.CommunityActivityRecordAdapter;
import com.chinavisionary.microtang.community.model.CommunityModel;
import com.chinavisionary.microtang.community.vo.NewCommunityActivityItemVo;
import com.chinavisionary.microtang.web.bridge.BridgeWebViewActivity;
import g.b.a.m;

/* JADX INFO: loaded from: classes.dex */
public class CommunityActivityRecordFragment extends BaseFragment<NewCommunityActivityItemVo> {
    public CommunityModel B;
    public int C;
    public a D;
    public final c.e.a.a.c.c.a E = new c.e.a.a.c.c.a() { // from class: c.e.c.n.d.l
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1727a.N1(view, i2);
        }
    };

    @BindView(R.id.swipe_refresh_layout_activity)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(View view, int i2) {
        H1(i2);
    }

    public static CommunityActivityRecordFragment getInstance(int i2, a aVar) {
        CommunityActivityRecordFragment communityActivityRecordFragment = new CommunityActivityRecordFragment();
        communityActivityRecordFragment.C = i2;
        communityActivityRecordFragment.D = aVar;
        return communityActivityRecordFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void E1() {
        if (this.f6483a == 1 && this.t.getList().isEmpty()) {
            NewCommunityActivityItemVo newCommunityActivityItemVo = new NewCommunityActivityItemVo();
            newCommunityActivityItemVo.setViewType(34952);
            this.t.addDataToList((T) newCommunityActivityItemVo);
        }
    }

    public final void F1(NewResponseRowsVo<NewCommunityActivityItemVo> newResponseRowsVo) {
        if (newResponseRowsVo != null) {
            D(newResponseRowsVo.getRows());
        }
        E1();
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
    }

    public final void G1(int i2) {
        if (i2 >= 0) {
            NewCommunityActivityItemVo newCommunityActivityItemVo = (NewCommunityActivityItemVo) this.t.getList().get(i2);
            String title = newCommunityActivityItemVo.getTitle();
            String primaryKey = newCommunityActivityItemVo.getPrimaryKey();
            Z0(title);
            a aVar = this.D;
            if (aVar != null) {
                aVar.onAddFragmentToActivity(ActivityCommentFragment.getInstance(primaryKey, title, newCommunityActivityItemVo.getComment().booleanValue()), true);
            } else {
                F0(R.string.tip_open_failed_retry);
            }
        }
    }

    public final void H1(int i2) {
        if (i2 >= 0) {
            NewCommunityActivityItemVo newCommunityActivityItemVo = (NewCommunityActivityItemVo) this.t.getList().get(i2);
            String title = newCommunityActivityItemVo.getTitle();
            String h5Url = newCommunityActivityItemVo.getH5Url();
            Z0(title);
            c0(BridgeWebViewActivity.class, h5Url);
        }
    }

    public final void I1() {
        this.f6488f = new CoreBaseFragment.c(this);
    }

    public final void J1() {
        CommunityModel communityModel = (CommunityModel) h(CommunityModel.class);
        this.B = communityModel;
        communityModel.getMeActivityResult().observeForever(new Observer() { // from class: c.e.c.n.d.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1726a.F1((NewResponseRowsVo) obj);
            }
        });
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.n.d.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1728a.P1((RequestErrDto) obj);
            }
        });
    }

    public final void K1() {
        BaseSwipeRefreshLayout baseSwipeRefreshLayout = this.mBaseSwipeRefreshLayout;
        this.s = baseSwipeRefreshLayout;
        this.r = baseSwipeRefreshLayout.getBaseRecyclerView();
        CommunityActivityRecordAdapter communityActivityRecordAdapter = new CommunityActivityRecordAdapter(this.C);
        this.t = communityActivityRecordAdapter;
        communityActivityRecordAdapter.setEmptyTipMsg(getResources().getString(R.string.title_activity_is_empty));
        this.t.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.E);
    }

    public final void P1(RequestErrDto requestErrDto) {
        C(requestErrDto);
        E1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.btn_comment) {
            G1(((Integer) view.getTag()).intValue());
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        h0(this);
        K1();
        J1();
        j0();
        I1();
    }

    @m
    public void eventRefreshCommentList(EventRefreshCommentList eventRefreshCommentList) {
        this.f6483a = 1;
        j0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_community_activity_list;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.B.getMeActivityList(r(), this.C);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    @SuppressLint({"NotifyDataSetChanged"})
    public void z(Message message) {
        if (this.r.isComputingLayout()) {
            return;
        }
        this.t.notifyDataSetChanged();
    }
}
