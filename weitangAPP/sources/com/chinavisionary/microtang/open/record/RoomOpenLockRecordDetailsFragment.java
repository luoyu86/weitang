package com.chinavisionary.microtang.open.record;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.b.a.d.g;
import c.b.a.f.c;
import c.e.a.d.z;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.open.adapter.RoomOpenLockRecordDetailsAdapter;
import com.chinavisionary.microtang.open.bo.RoomOpenLockRecordDetailsVo;
import com.chinavisionary.microtang.open.model.RoomOpenLockModel;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class RoomOpenLockRecordDetailsFragment extends BaseFragment<RoomOpenLockRecordDetailsVo> {
    public RoomOpenLockModel B;
    public boolean C;
    public Long D = Long.valueOf(System.currentTimeMillis());
    public Long E;
    public c F;

    @BindView(R.id.swipe_refresh_layout_record)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.tv_end_date)
    public TextView mEndDateTv;

    @BindView(R.id.tv_start_date)
    public TextView mStartDateTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements c.b.a.d.a {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(View view) {
            RoomOpenLockRecordDetailsFragment.this.F.returnData();
        }

        @Override // c.b.a.d.a
        public void customLayout(View view) {
            ((TextView) view.findViewById(R.id.tv_title_look_room)).setText(R.string.title_select_end_date);
            ((Button) view.findViewById(R.id.btn_confirm_time)).setOnClickListener(new View.OnClickListener() { // from class: c.e.c.a0.j.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f1374a.b(view2);
                }
            });
        }
    }

    public class b implements g {
        public b() {
        }

        @Override // c.b.a.d.g
        public void onTimeSelect(Date date, View view) {
            RoomOpenLockRecordDetailsFragment.this.K1(date);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: G1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H1(ResponseRowsVo responseRowsVo) {
        I0();
        if (responseRowsVo != null) {
            D(responseRowsVo.getRows());
        }
    }

    private void I0() {
        H();
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J1(RequestErrDto requestErrDto) {
        I0();
        C(requestErrDto);
    }

    public static RoomOpenLockRecordDetailsFragment getInstance(String str) {
        RoomOpenLockRecordDetailsFragment roomOpenLockRecordDetailsFragment = new RoomOpenLockRecordDetailsFragment();
        roomOpenLockRecordDetailsFragment.setArguments(CoreBaseFragment.q(str));
        return roomOpenLockRecordDetailsFragment;
    }

    public final void K1(Date date) {
        if (this.C) {
            Long lValueOf = Long.valueOf(date.getTime());
            this.E = lValueOf;
            this.mStartDateTv.setText(z.getTimeYYMMDD(lValueOf));
        } else {
            this.D = Long.valueOf(date.getTime());
            this.mEndDateTv.setText(z.getTimeYYMMDD(this.E));
        }
        this.F.dismiss();
    }

    public final void L1() {
        RoomOpenLockModel roomOpenLockModel = (RoomOpenLockModel) h(RoomOpenLockModel.class);
        this.B = roomOpenLockModel;
        roomOpenLockModel.getOpenLockRecordDetails().observe(this, new Observer() { // from class: c.e.c.a0.j.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1376a.H1((ResponseRowsVo) obj);
            }
        });
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.a0.j.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1375a.J1((RequestErrDto) obj);
            }
        });
    }

    public final void M1(Long l, Long l2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(l2.longValue());
        c cVarBuild = new c.b.a.b.b(this.f6487e, new b()).setLayoutRes(R.layout.item_custom_rent_time_picker_layout, new a()).setType(new boolean[]{true, true, true, false, false, false}).setLabel("年", "月", "日", "", "", "").setDividerColor(-12303292).setContentTextSize(20).setDate(calendar).setRangDate(calendar, calendar2).isDialog(true).setOutSideColor(0).setOutSideCancelable(true).build();
        this.F = cVarBuild;
        cVarBuild.setKeyBackCancelable(true);
    }

    public final void N1() {
        c cVar = this.F;
        if (cVar != null) {
            cVar.show();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.tv_end_date) {
            this.C = false;
            N1();
        } else {
            if (id != R.id.tv_start_date) {
                return;
            }
            this.C = true;
            N1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_open_lock_record_list);
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        this.t = new RoomOpenLockRecordDetailsAdapter();
        this.mStartDateTv.setOnClickListener(this.y);
        this.mEndDateTv.setOnClickListener(this.y);
        L1();
        M1(Long.valueOf(z.getDateBefore(new Date(System.currentTimeMillis()), 30).getTime()), Long.valueOf(System.currentTimeMillis()));
        F0(R.string.loading_text);
        j0();
    }

    @OnClick({R.id.btn_reset})
    public void doResetClick(View view) {
        this.E = null;
        this.D = null;
        this.f6483a = 1;
        this.mStartDateTv.setText("");
        this.mEndDateTv.setText("");
        j0();
    }

    @OnClick({R.id.btn_search})
    public void doSearchClick(View view) {
        j0();
    }

    @OnClick({R.id.tv_back})
    public void finishFragment(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_search_record_time;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.B.getRoomOpenLockRecordDetailsList(r(), this.f6484b, this.E, this.D);
    }
}
