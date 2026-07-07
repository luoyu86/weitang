package com.chinavisionary.microtang.room.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.j;
import c.e.a.d.o;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.room.adapter.PreLookRoomTimeAdapter;
import com.chinavisionary.microtang.room.model.RoomOperationModel;
import com.chinavisionary.microtang.room.vo.CreateRoomPreLookVo;
import com.chinavisionary.microtang.room.vo.PreLookRoomItemVo;
import com.chinavisionary.microtang.room.vo.PreRoomInfoVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PreLookRoomFragment extends BaseFragment<PreLookRoomItemVo> {
    public List<String> B;
    public List<Long> C;
    public int D;
    public RoomOperationModel F;

    @BindView(R.id.view_content_finish)
    public View mContentBgView;

    @BindView(R.id.edt_leaving_message)
    public EditText mLeavingMessageTv;

    @BindView(R.id.tv_leaving_message_limit_size)
    public TextView mLimitSizeTv;

    @BindView(R.id.radio_group)
    public RadioGroup mRadioGroup;

    @BindView(R.id.recycler_pre_time)
    public BaseRecyclerView mRecyclerView;

    @BindView(R.id.tv_look_room_time_sel)
    public TextView mRoomTimeSelTv;

    @BindView(R.id.edt_user_contact)
    public EditText mUserContactEdt;

    @BindView(R.id.edt_user_name)
    public EditText mUserNameEdt;
    public boolean E = true;
    public final TextWatcher G = new a();
    public final c.e.c.h0.e.b H = new b();

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            int length = 100 - PreLookRoomFragment.this.mLeavingMessageTv.getText().toString().length();
            PreLookRoomFragment.this.mLimitSizeTv.setText(length + "/100");
        }
    }

    public class b implements c.e.c.h0.e.b {
        public b() {
        }

        @Override // c.e.c.h0.e.b
        public void onCheckBoxClick(int i2, boolean z) {
            PreLookRoomFragment.this.D = i2;
            List list = PreLookRoomFragment.this.t.getList();
            if (o.isNotEmpty(list)) {
                int i3 = i2;
                int i4 = 0;
                while (i4 < list.size()) {
                    if (((PreLookRoomItemVo) list.get(i4)).isHasSelect()) {
                        i3 = i4;
                    }
                    ((PreLookRoomItemVo) list.get(i4)).setHasSelect(i4 == i2);
                    i4++;
                }
                PreLookRoomFragment.this.t.notifyItemChanged(i2);
                if (i3 != i2) {
                    PreLookRoomFragment.this.t.notifyItemChanged(i3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(RadioGroup radioGroup, int i2) {
        this.E = i2 == R.id.radio_am_btn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: O1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P1(View view) {
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Q1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R1(ResponseStateVo responseStateVo) {
        if (F(responseStateVo, R.string.tip_submit_success, R.string.tip_submit_failed)) {
            g0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T1(PreRoomInfoVo preRoomInfoVo) {
        I1(preRoomInfoVo);
        H();
    }

    public static PreLookRoomFragment getInstance(String str) {
        PreLookRoomFragment preLookRoomFragment = new PreLookRoomFragment();
        preLookRoomFragment.setArguments(CoreBaseFragment.q(str));
        return preLookRoomFragment;
    }

    public final void I1(PreRoomInfoVo preRoomInfoVo) {
        if (preRoomInfoVo != null) {
            UserInfoVo userInfoVoW = w();
            this.mUserNameEdt.setText(x.getNotNullStr(preRoomInfoVo.getName(), userInfoVoW != null ? userInfoVoW.getNickname() : ""));
            this.mUserContactEdt.setText(x.getNotNullStr(preRoomInfoVo.getPhone(), s()));
            J1(preRoomInfoVo.getDates());
        }
    }

    public final void J1(List<Long> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.C = list;
        if (list.size() % 2 != 0) {
            this.C.add(0, Long.valueOf(z.getTimeMillis() + 32400000));
        }
        this.B = new ArrayList();
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < size) {
            Long l = list.get(i2);
            StringBuilder sb = new StringBuilder(2);
            sb.append(z.getTime(l, z.m));
            sb.append(z.getWeek(l.longValue()));
            if (!this.B.contains(sb.toString())) {
                this.B.add(sb.toString());
                PreLookRoomItemVo preLookRoomItemVo = new PreLookRoomItemVo();
                preLookRoomItemVo.setDate(z.getTime(l, z.n));
                preLookRoomItemVo.setWeek(z.getTodayAndWeek(l.longValue()));
                preLookRoomItemVo.setHasSelect(i2 == 0);
                preLookRoomItemVo.setTime(l);
                arrayList.add(preLookRoomItemVo);
            }
            i2++;
        }
        D(arrayList);
    }

    public final void K1() {
        this.l = false;
        this.mLeavingMessageTv.addTextChangedListener(this.G);
        PreLookRoomTimeAdapter preLookRoomTimeAdapter = new PreLookRoomTimeAdapter();
        this.t = preLookRoomTimeAdapter;
        preLookRoomTimeAdapter.setCallback(this.H);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        BaseRecyclerView baseRecyclerView = this.mRecyclerView;
        this.r = baseRecyclerView;
        baseRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: c.e.c.h0.f.m
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                this.f1508a.N1(radioGroup, i2);
            }
        });
        this.mContentBgView.setOnClickListener(new View.OnClickListener() { // from class: c.e.c.h0.f.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f1510a.P1(view);
            }
        });
    }

    public final void U1() {
        CreateRoomPreLookVo createRoomPreLookVo = new CreateRoomPreLookVo();
        createRoomPreLookVo.setCustomerName(this.mUserNameEdt.getText().toString());
        if (this.C == null) {
            F0(R.string.tip_select_pre_time);
            H();
            return;
        }
        int i2 = this.D;
        createRoomPreLookVo.setAppointmentTime(i2 > 0 ? this.C.get((i2 * 2) + (!this.E ? 1 : 0)) : this.C.get(!this.E ? 1 : 0));
        createRoomPreLookVo.setPhone(this.mUserContactEdt.getText().toString());
        String string = this.mLeavingMessageTv.getText().toString();
        if (x.isNotNull(string)) {
            createRoomPreLookVo.setRemark(string);
        }
        createRoomPreLookVo.setKey(this.f6484b);
        this.F.postPreLookRoom(createRoomPreLookVo);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    public final void V1() {
        RoomOperationModel roomOperationModel = (RoomOperationModel) h(RoomOperationModel.class);
        this.F = roomOperationModel;
        roomOperationModel.updateBaseUrl(j.getInstance().getH5ApiBaseUrl());
        this.F.getPreLookResultLiveData().observe(this, new Observer() { // from class: c.e.c.h0.f.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1506a.R1((ResponseStateVo) obj);
            }
        });
        this.F.getPreRoomInfo().observe(this, new Observer() { // from class: c.e.c.h0.f.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1509a.T1((PreRoomInfoVo) obj);
            }
        });
        this.F.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.h0.f.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1507a.C((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        K1();
        V1();
        W1();
        z0(R.string.loading_text);
        j0();
    }

    public final void W1() {
        UserInfoVo userInfoVoW = w();
        if (userInfoVoW != null) {
            this.mUserNameEdt.setText(userInfoVoW.getNickname());
            this.mUserContactEdt.setText(s());
        }
    }

    @OnClick({R.id.tv_finish})
    public void finishFragment(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_pre_look_room;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.F.getRoomPreInfo();
    }

    @OnClick({R.id.btn_pre_look_room})
    public void submitClick(View view) {
        String string = this.mUserContactEdt.getText().toString();
        String string2 = this.mUserNameEdt.getText().toString();
        this.mLeavingMessageTv.getText().toString();
        if (x.isNullStr(string)) {
            F0(R.string.tip_phone_is_empty);
        } else if (x.isNullStr(string2)) {
            F0(R.string.title_name_is_empty);
        } else {
            z0(R.string.tip_submit_data_loading);
            U1();
        }
    }
}
