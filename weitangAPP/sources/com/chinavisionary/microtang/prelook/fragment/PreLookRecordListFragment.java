package com.chinavisionary.microtang.prelook.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.prelook.adapter.PreLookAdapter;
import com.chinavisionary.microtang.prelook.model.PreLookModel;
import com.chinavisionary.microtang.prelook.vo.PreLookVo;
import com.chinavisionary.microtang.web.WebViewActivity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class PreLookRecordListFragment extends BaseFragment<PreLookVo> {
    public PreLookModel B;

    @BindView(R.id.recycler_pre_look_record)
    public BaseRecyclerView mPreLookRecycler;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: G1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H1(ResponseRowsVo responseRowsVo) {
        D(responseRowsVo.getRows());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J1(RequestErrDto requestErrDto) {
        H();
        G0(requestErrDto.getErrMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1(ResponseStateVo responseStateVo) {
        F(responseStateVo, R.string.tip_cancel_success, R.string.tip_cancel_failed);
    }

    public static PreLookRecordListFragment getInstance() {
        return new PreLookRecordListFragment();
    }

    public final void E1(PreLookVo preLookVo) {
        if (preLookVo.getStatus() == 2) {
            u0(x.getString(R.string.title_confirm_cancel_pre));
        } else {
            K0(PreLookCommentFragment.getInstance(preLookVo.getAppintmentKey()), R.id.flayout_content);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void F1() {
        ArrayList arrayList = new ArrayList();
        PreLookVo preLookVo = new PreLookVo();
        preLookVo.setAddress("78栋1002");
        preLookVo.setAppintmentKey("1223");
        preLookVo.setAppointmentTime(Long.valueOf(System.currentTimeMillis()));
        preLookVo.setStatus(1);
        arrayList.add(preLookVo);
        this.t.initListData(arrayList);
    }

    public final void M1() {
        z0(R.string.tip_cancel_subscribe_loading);
        this.B.cancelPreLook(this.f6484b);
    }

    public final void N1() {
        PreLookModel preLookModel = (PreLookModel) h(PreLookModel.class);
        this.B = preLookModel;
        preLookModel.getRecordListLiveData().observe(this, new Observer() { // from class: c.e.c.d0.b.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1425a.H1((ResponseRowsVo) obj);
            }
        });
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.d0.b.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1424a.J1((RequestErrDto) obj);
            }
        });
        this.B.getResultLiveData().observe(this, new Observer() { // from class: c.e.c.d0.b.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1426a.L1((ResponseStateVo) obj);
            }
        });
    }

    public final void O1() {
        this.r = this.mPreLookRecycler;
        PreLookAdapter preLookAdapter = new PreLookAdapter();
        this.t = preLookAdapter;
        preLookAdapter.setOnClickListener(this.y);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_comment) {
            E1((PreLookVo) view.getTag());
        } else {
            if (id != R.id.tv_alert_confirm) {
                return;
            }
            M1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(getString(R.string.title_pre_look_record));
        N1();
        O1();
        F1();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @OnClick({R.id.tv_rent_change_info})
    public void catRentChangeInfo(View view) {
        Intent intent = new Intent(this.f6487e, (Class<?>) WebViewActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", "http://www.baidu.com");
        startActivity(intent);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_pre_look_record_list;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.B.getPreLookRecordList(r());
    }
}
