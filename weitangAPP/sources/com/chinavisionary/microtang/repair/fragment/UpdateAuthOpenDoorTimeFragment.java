package com.chinavisionary.microtang.repair.fragment;

import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.b.a.d.e;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.a.d.y;
import c.e.a.d.z;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.repair.event.UpdateAuthOpenDoorTimeEvent;
import com.chinavisionary.microtang.repair.model.RepairModel;
import com.chinavisionary.microtang.repair.vo.UpdateAuthOpenDoorParamBo;
import com.chinavisionary.microtang.repair.vo.UpdateAuthOpenDoorTimeFragmentParamBo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateAuthOpenDoorTimeFragment extends BaseFragment<String> {
    public Long B;
    public Long C;
    public Long D;
    public Long E;
    public Integer F;
    public Integer G;
    public int H;
    public String J;
    public List<String> K;
    public List<String> L;
    public c.b.a.f.b<String> O;
    public c.b.a.f.b<String> P;
    public RepairModel Q;

    @BindView(R.id.cb_auth)
    public CheckBox mAuthCb;

    @BindView(R.id.tv_open_door_end_time)
    public TextView mOpenDoorEndTimeTitleTv;

    @BindView(R.id.tv_open_door_end_time_value)
    public TextView mOpenDoorEndTimeTv;

    @BindView(R.id.tv_open_door_start_time)
    public TextView mOpenDoorStartTimeTitleTv;

    @BindView(R.id.tv_open_door_start_time_value)
    public TextView mOpenDoorStartTimeTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public boolean I = false;
    public int M = -1;
    public int N = -1;

    public class a implements c.b.a.d.d {
        public a() {
        }

        @Override // c.b.a.d.d
        public void onOptionsSelectChanged(int i2, int i3, int i4) {
            if (UpdateAuthOpenDoorTimeFragment.this.M != i2) {
                UpdateAuthOpenDoorTimeFragment.this.M = i2;
                UpdateAuthOpenDoorTimeFragment.this.O.setSelectOptions(UpdateAuthOpenDoorTimeFragment.this.M);
            }
        }
    }

    public class b implements e {
        public b() {
        }

        @Override // c.b.a.d.e
        public void onOptionsSelect(int i2, int i3, int i4, View view) {
            UpdateAuthOpenDoorTimeFragment.this.M = i2;
            if (o.isNotEmpty(UpdateAuthOpenDoorTimeFragment.this.K)) {
                UpdateAuthOpenDoorTimeFragment.this.mOpenDoorStartTimeTv.setText((String) UpdateAuthOpenDoorTimeFragment.this.K.get(i2));
            }
            q.d(UpdateAuthOpenDoorTimeFragment.class.getCanonicalName(), "onOptionsSelect options1：" + i2 + "，option2:" + i3);
        }
    }

    public class c implements c.b.a.d.d {
        public c() {
        }

        @Override // c.b.a.d.d
        public void onOptionsSelectChanged(int i2, int i3, int i4) {
            if (UpdateAuthOpenDoorTimeFragment.this.N != i2) {
                UpdateAuthOpenDoorTimeFragment.this.N = i2;
                UpdateAuthOpenDoorTimeFragment.this.P.setSelectOptions(UpdateAuthOpenDoorTimeFragment.this.N);
            }
        }
    }

    public class d implements e {
        public d() {
        }

        @Override // c.b.a.d.e
        public void onOptionsSelect(int i2, int i3, int i4, View view) {
            UpdateAuthOpenDoorTimeFragment.this.N = i2;
            if (o.isNotEmpty(UpdateAuthOpenDoorTimeFragment.this.L)) {
                UpdateAuthOpenDoorTimeFragment.this.mOpenDoorEndTimeTv.setText((String) UpdateAuthOpenDoorTimeFragment.this.L.get(i2));
            }
            q.d(UpdateAuthOpenDoorTimeFragment.class.getCanonicalName(), "onOptionsSelect options1：" + i2 + "，option2:" + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: X1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y1() {
        Long[] lArrP1 = P1(this.B, this.C);
        if (lArrP1 != null) {
            Long l = lArrP1[0];
            l.longValue();
            System.currentTimeMillis();
            Long l2 = lArrP1[1];
            if (l2.longValue() < l.longValue()) {
                return;
            }
            this.K.clear();
            this.L.clear();
            long jLongValue = (l2.longValue() - l.longValue()) / ((long) 60000);
            for (int i2 = 0; i2 < jLongValue; i2++) {
                long jLongValue2 = l.longValue() + ((long) (i2 * 60000));
                Long l3 = this.D;
                if (l3 != null && l3.longValue() == jLongValue2) {
                    this.F = Integer.valueOf(i2);
                }
                Long l4 = this.E;
                if (l4 != null && l4.longValue() == jLongValue2) {
                    this.G = Integer.valueOf(i2);
                }
                Long lValueOf = Long.valueOf(jLongValue2);
                SimpleDateFormat simpleDateFormat = z.f1240a;
                this.K.add(z.getTime(lValueOf, simpleDateFormat));
                this.L.add(z.getTime(Long.valueOf(jLongValue2), simpleDateFormat));
            }
            Integer num = this.F;
            if (num != null) {
                this.M = num.intValue();
            }
            Integer num2 = this.G;
            if (num2 != null) {
                this.N = num2.intValue();
            }
            q.d(getClass().getSimpleName(), "initDoorPicker selectStartIndex = " + this.F + ",selectEndIndex=" + this.G);
        }
        this.f6488f.obtainMessage().sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a2(CompoundButton compoundButton, boolean z) {
        f2();
    }

    public static UpdateAuthOpenDoorTimeFragment getInstance(UpdateAuthOpenDoorTimeFragmentParamBo updateAuthOpenDoorTimeFragmentParamBo) {
        UpdateAuthOpenDoorTimeFragment updateAuthOpenDoorTimeFragment = new UpdateAuthOpenDoorTimeFragment();
        updateAuthOpenDoorTimeFragment.f6484b = updateAuthOpenDoorTimeFragmentParamBo.getOrderKey();
        updateAuthOpenDoorTimeFragment.I = updateAuthOpenDoorTimeFragmentParamBo.isAuth();
        updateAuthOpenDoorTimeFragment.H = updateAuthOpenDoorTimeFragmentParamBo.getType();
        updateAuthOpenDoorTimeFragment.J = updateAuthOpenDoorTimeFragmentParamBo.getWorkOrderKey();
        updateAuthOpenDoorTimeFragment.C = updateAuthOpenDoorTimeFragmentParamBo.getEndServiceTime();
        updateAuthOpenDoorTimeFragment.B = updateAuthOpenDoorTimeFragmentParamBo.getStartServiceTime();
        updateAuthOpenDoorTimeFragment.D = updateAuthOpenDoorTimeFragmentParamBo.getStartTime();
        updateAuthOpenDoorTimeFragment.E = updateAuthOpenDoorTimeFragmentParamBo.getEndTime();
        return updateAuthOpenDoorTimeFragment;
    }

    public final boolean M1() {
        int i2;
        boolean z = true;
        if (!this.mAuthCb.isChecked()) {
            return true;
        }
        int i3 = this.M;
        if (i3 == -1 || (i2 = this.N) == -1) {
            F0(R.string.tip_select_auth_open_door_time);
            return false;
        }
        if (i3 == i2) {
            F0(R.string.tip_select_auth_open_door_time_equals);
            z = false;
        }
        if (this.M <= this.N) {
            return z;
        }
        F0(R.string.tip_select_auth_open_door_time_failed);
        return false;
    }

    public final String N1() {
        return this.mAuthCb.isChecked() ? x.appendStringToResId(R.string.placeholder_open_door, O1()) : x.getString(R.string.tip_close_auth_open_door);
    }

    public final String O1() {
        return this.K.get(this.M) + "到" + this.K.get(this.N);
    }

    public final Long[] P1(Long l, Long l2) {
        q.d(this.f6485c, "getSelectTime startTime = " + l + ",endTime:" + l2);
        if (l == null) {
            l = Long.valueOf(System.currentTimeMillis());
        }
        return new Long[]{l, Long.valueOf(z.getNextDayToAmount(30))};
    }

    public final UpdateAuthOpenDoorParamBo Q1() {
        UpdateAuthOpenDoorParamBo updateAuthOpenDoorParamBo = new UpdateAuthOpenDoorParamBo();
        boolean zIsChecked = this.mAuthCb.isChecked();
        updateAuthOpenDoorParamBo.setWorkOrderKey(this.J);
        updateAuthOpenDoorParamBo.setType(this.H);
        if (zIsChecked) {
            String str = this.K.get(this.M);
            String str2 = this.K.get(this.N);
            SimpleDateFormat simpleDateFormat = z.f1240a;
            updateAuthOpenDoorParamBo.setStartTime(Long.valueOf(z.getTimeInLong(simpleDateFormat, str)));
            updateAuthOpenDoorParamBo.setEndTime(Long.valueOf(z.getTimeInLong(simpleDateFormat, str2)));
        }
        return updateAuthOpenDoorParamBo;
    }

    public final void R1(ResponseStateVo responseStateVo) {
        F(responseStateVo, R.string.tip_update_success, R.string.tip_update_failed);
        if (responseStateVo == null || !responseStateVo.isSuccess()) {
            return;
        }
        k(new UpdateAuthOpenDoorTimeEvent());
        n();
    }

    public final void S1() {
        V1();
        U1();
        y.get().addRunnable(new Runnable() { // from class: c.e.c.g0.b.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f1479a.Y1();
            }
        });
    }

    public final void T1() {
        RepairModel repairModel = (RepairModel) h(RepairModel.class);
        this.Q = repairModel;
        repairModel.getResultLiveData().observe(this, new Observer() { // from class: c.e.c.g0.b.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1480a.R1((ResponseStateVo) obj);
            }
        });
        this.Q.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.g0.b.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1481a.C((RequestErrDto) obj);
            }
        });
    }

    public final void U1() {
        if (this.P == null) {
            this.L = new ArrayList();
            this.P = new c.b.a.b.a(this.f6487e, new d()).setOptionsSelectChangeListener(new c()).setTitleText(x.getString(R.string.title_select_auth_open_door_end_time)).build();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.tv_alert_confirm) {
            z0(R.string.tip_save_loading);
            UpdateAuthOpenDoorParamBo updateAuthOpenDoorParamBoQ1 = Q1();
            this.Q.updateAuthOpenDoorTime(updateAuthOpenDoorParamBoQ1);
            q.d(getClass().getSimpleName(), "saveClick paramBo = " + JSON.toJSONString(updateAuthOpenDoorParamBoQ1));
        }
    }

    public final void V1() {
        if (this.O == null) {
            this.K = new ArrayList();
            this.O = new c.b.a.b.a(this.f6487e, new b()).setOptionsSelectChangeListener(new a()).setTitleText(x.getString(R.string.title_select_auth_open_door_start_time)).build();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.f6488f = new CoreBaseFragment.c(this);
        this.mTitleTv.setText(R.string.title_update_auth_open_door_time);
        this.mAuthCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: c.e.c.g0.b.t
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f1478a.a2(compoundButton, z);
            }
        });
        this.mAuthCb.setChecked(this.I);
        f2();
        T1();
        S1();
    }

    public final void W1() {
        this.O.setPicker(this.K);
        Integer num = this.F;
        if (num != null) {
            this.O.setSelectOptions(num.intValue());
        }
        this.P.setPicker(this.L);
        Integer num2 = this.G;
        if (num2 != null) {
            this.P.setSelectOptions(num2.intValue());
        }
        Long l = this.D;
        if (l != null) {
            this.mOpenDoorStartTimeTv.setText(z.getTime(l, z.f1240a));
        }
        Long l2 = this.E;
        if (l2 != null) {
            this.mOpenDoorEndTimeTv.setText(z.getTime(l2, z.f1240a));
        }
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    public final void d2() {
        c.b.a.f.b<String> bVar = this.P;
        if (bVar != null) {
            bVar.show();
        }
    }

    public final void e2() {
        c.b.a.f.b<String> bVar = this.O;
        if (bVar != null) {
            bVar.show();
        }
    }

    public final void f2() {
        boolean zIsChecked = this.mAuthCb.isChecked();
        int color = getResources().getColor(R.color.color000000);
        int color2 = getResources().getColor(R.color.color8F8F8F);
        this.mOpenDoorStartTimeTv.setTextColor(zIsChecked ? color : color2);
        this.mOpenDoorEndTimeTv.setTextColor(zIsChecked ? color : color2);
        this.mOpenDoorStartTimeTitleTv.setTextColor(zIsChecked ? color : color2);
        TextView textView = this.mOpenDoorEndTimeTitleTv;
        if (!zIsChecked) {
            color = color2;
        }
        textView.setTextColor(color);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_update_auth_door_time;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @OnClick({R.id.tv_open_door_end_time})
    public void openDoorEndTimeClick(View view) {
        d2();
    }

    @OnClick({R.id.tv_open_door_start_time})
    public void openDoorStartTimeClick(View view) {
        e2();
    }

    @OnClick({R.id.btn_save})
    public void saveClick(View view) {
        if (M1()) {
            u0(N1());
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        W1();
    }
}
