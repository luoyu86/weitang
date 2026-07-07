package com.chinavisionary.microtang.open.record;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.open.adapter.RoomOpenLockRecordAdapter;
import com.chinavisionary.microtang.open.bo.RoomOpenLockRecordVo;
import com.chinavisionary.microtang.open.model.RoomOpenLockModel;

/* JADX INFO: loaded from: classes.dex */
public class RoomOpenLockRecordListFragment extends BaseFragment<RoomOpenLockRecordVo> {
    public RoomOpenLockModel B;
    public c.e.a.a.c.c.a C = new a();
    public TextWatcher D = new b();
    public Runnable E = new Runnable() { // from class: c.e.c.a0.j.d
        @Override // java.lang.Runnable
        public final void run() {
            this.f1377a.I1();
        }
    };

    @BindView(R.id.swipe_refresh_layout_more_rent)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.btn_reset)
    public ImageButton mResetImgBtn;

    @BindView(R.id.edt_search_room)
    public EditText mSearchRoomEdt;

    @BindView(R.id.tv_tip_msg)
    public TextView mTipSearchTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements c.e.a.a.c.c.a {
        public a() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            RoomOpenLockRecordListFragment.this.K0(RoomOpenLockRecordDetailsFragment.getInstance(((RoomOpenLockRecordVo) RoomOpenLockRecordListFragment.this.t.getList().get(i2)).getRentHouseKey()), R.id.flayout_content);
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            RoomOpenLockRecordListFragment.this.N1();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: H1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I1() {
        this.f6483a = 1;
        j0();
    }

    private void I0() {
        H();
        this.mTipSearchTv.setVisibility(8);
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K1(ResponseRowsVo responseRowsVo) {
        I0();
        if (responseRowsVo != null) {
            D(responseRowsVo.getRows());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: L1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M1(RequestErrDto requestErrDto) {
        C(requestErrDto);
        I0();
    }

    public static RoomOpenLockRecordListFragment getInstance() {
        return new RoomOpenLockRecordListFragment();
    }

    public final void N1() {
        this.f6488f.removeCallbacks(this.E);
        this.f6488f.postDelayed(this.E, 300L);
    }

    public final void O1() {
        RoomOpenLockModel roomOpenLockModel = (RoomOpenLockModel) h(RoomOpenLockModel.class);
        this.B = roomOpenLockModel;
        roomOpenLockModel.getOpenLockRecord().observe(this, new Observer() { // from class: c.e.c.a0.j.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1378a.K1((ResponseRowsVo) obj);
            }
        });
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.a0.j.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1379a.M1((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_lock_list);
        this.f6488f = new CoreBaseFragment.c(this);
        this.mSearchRoomEdt.addTextChangedListener(this.D);
        this.mSearchRoomEdt.setFocusable(true);
        this.mSearchRoomEdt.setFocusableInTouchMode(true);
        this.mSearchRoomEdt.requestFocus();
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        RoomOpenLockRecordAdapter roomOpenLockRecordAdapter = new RoomOpenLockRecordAdapter();
        this.t = roomOpenLockRecordAdapter;
        roomOpenLockRecordAdapter.setOnItemClickListener(this.C);
        O1();
        z0(R.string.loading_text);
        j0();
    }

    @OnClick({R.id.tv_back})
    public void finishFragment(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_search_room;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        String string = this.mSearchRoomEdt.getText().toString();
        this.mResetImgBtn.setVisibility(x.isNotNull(string) ? 0 : 8);
        this.B.getRoomOpenLockList(r(), string);
        if (this.mTipSearchTv.getVisibility() == 8) {
            this.mTipSearchTv.setVisibility(0);
        } else {
            if (this.mTipSearchTv.getText().toString().equals(x.getString(R.string.title_searching))) {
                return;
            }
            this.mTipSearchTv.setText(R.string.title_searching);
        }
    }

    @OnClick({R.id.btn_reset})
    public void resetClick(View view) {
        this.mSearchRoomEdt.setText("");
        this.mTipSearchTv.setVisibility(8);
        this.mResetImgBtn.setVisibility(8);
        this.f6483a = 1;
        this.B.getRoomOpenLockList(r(), null);
    }
}
