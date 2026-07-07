package com.chinavisionary.microtang.open.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.y;
import c.e.c.a0.i.b;
import c.e.e.a.s.e;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.open.adapter.LockAdapter;
import com.chinavisionary.twlib.open.model.OpenDoorModel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LockSortFragment extends BaseFragment<e> {
    public boolean B = false;
    public OpenDoorModel C;
    public b D;
    public List<e> E;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.tv_title_right)
    public TextView mRightTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements BaseRecyclerView.e {
        public a() {
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.e
        public void swapPosition(int i2, int i3) {
            LockSortFragment.this.B = true;
            q.d(a.class.getSimpleName(), "swapPosition fromPosition =" + i2 + ",toPosition =" + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: F1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G1(NewResponseRowsVo newResponseRowsVo) {
        O1();
        if (newResponseRowsVo != null) {
            this.t.initListData((List<T>) newResponseRowsVo.getRows());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: H1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I1(RequestErrDto requestErrDto) {
        super.C(requestErrDto);
        O1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K1(List list) {
        c.e.c.p.b.getInstance().insertLockSortData(list, s());
    }

    public static LockSortFragment getInstance(List<e> list, b bVar) {
        LockSortFragment lockSortFragment = new LockSortFragment();
        lockSortFragment.M1(list);
        lockSortFragment.L1(bVar);
        return lockSortFragment;
    }

    private void o0() {
        this.t = new LockAdapter();
        this.mBaseSwipeRefreshLayout.setEnabled(false);
        BaseRecyclerView baseRecyclerView = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        this.r = baseRecyclerView;
        baseRecyclerView.setEnableItemDrag(true);
        this.r.setIOnRecyclerSwapCallback(new a());
    }

    public final void L1(b bVar) {
        this.D = bVar;
    }

    public final void M1(List<e> list) {
        this.E = list;
    }

    public final void N1() {
        OpenDoorModel openDoorModel = (OpenDoorModel) h(OpenDoorModel.class);
        this.C = openDoorModel;
        openDoorModel.getLockListLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1330a.G1((NewResponseRowsVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1327a.I1((RequestErrDto) obj);
            }
        });
    }

    public final void O1() {
        H();
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
    }

    public final void P1() {
        final List<e> list = this.t.getList();
        if (this.B) {
            this.D.sortResult(list);
        }
        y.get().addRunnable(new Runnable() { // from class: c.e.c.a0.h.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f1323a.K1(list);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.u.setBackgroundColor(getResources().getColor(R.color.color_white));
        this.mTitleTv.setText(R.string.title_lock_sort);
        this.mRightTv.setText(R.string.title_save);
        o0();
        N1();
        if (o.isNotEmpty(this.E)) {
            this.t.initListData((List<T>) this.E);
        } else {
            j0();
        }
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_lock_sort_recycler;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.C.getLockList();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        P1();
    }

    @OnClick({R.id.tv_title_right})
    public void saveSort(View view) {
        P1();
        F0(R.string.title_save_success);
        g0();
    }
}
