package com.chinavisionary.microtang.repair.fragment;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.b.a.d.e;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadImgVo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.core.app.upload.UploadNineFragment;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.alert.AlertListFragment;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.prelook.vo.TagVo;
import com.chinavisionary.microtang.repair.RepairHistoryActivity;
import com.chinavisionary.microtang.repair.model.RepairModel;
import com.chinavisionary.microtang.repair.vo.CreateRepairOrderVo;
import com.chinavisionary.microtang.repair.vo.RepairOrderReasonVo;
import com.nex3z.flowlayout.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AddRepairInfoFragment extends BaseFragment {
    public List<String> B;
    public List<String> C;
    public List<Long> D;
    public List<String> E;
    public List<String> F;
    public c.b.a.f.b<String> I;
    public c.b.a.f.b<String> J;
    public UploadNineFragment K;
    public RepairModel M;
    public String N;

    @BindView(R.id.tv_address_value)
    public TextView mAddressTv;

    @BindView(R.id.cb_auth)
    public CheckBox mAuthCb;

    @BindView(R.id.flow_layout_place)
    public FlowLayout mFlowLayout;

    @BindView(R.id.flow_layout_repair_info)
    public FlowLayout mFlowRepairInfoLayout;

    @BindView(R.id.edt_input_info)
    public AppCompatTextView mInputInfoEdt;

    @BindView(R.id.tv_open_door_time)
    public TextView mOpenDoorTimeTv;

    @BindView(R.id.tv_title_contact_mode_value)
    public TextView mPhoneTv;

    @BindView(R.id.tv_product_name)
    public TextView mProductNameTv;

    @BindView(R.id.edt_remark)
    public AppCompatEditText mRemarkEdt;

    @BindView(R.id.tv_repair_place)
    public TextView mRepairPlaceTv;

    @BindView(R.id.tv_service_time)
    public TextView mServiceTimeTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public int G = -1;
    public int H = -1;
    public int L = -1;
    public c.e.a.a.k.d O = new a();

    public class a implements c.e.a.a.k.d {
        public a() {
        }

        @Override // c.e.a.a.k.d
        public void uploadFailed(String str) {
        }

        @Override // c.e.a.a.k.d
        public void uploadSuccess(UploadResponseDto uploadResponseDto) {
            if (uploadResponseDto != null) {
                ArrayList arrayList = new ArrayList();
                for (ResponseUploadImgVo responseUploadImgVo : uploadResponseDto.getUploadSuccessList()) {
                    if (responseUploadImgVo != null) {
                        arrayList.add(responseUploadImgVo.getKey());
                    }
                }
                AddRepairInfoFragment.this.f2(arrayList);
            }
        }
    }

    public class b implements c.b.a.d.d {
        public b() {
        }

        @Override // c.b.a.d.d
        public void onOptionsSelectChanged(int i2, int i3, int i4) {
            if (AddRepairInfoFragment.this.G != i2) {
                AddRepairInfoFragment.this.G = i2;
                if (AddRepairInfoFragment.this.G + 1 == AddRepairInfoFragment.this.E.size()) {
                    AddRepairInfoFragment.this.J.setSelectOptions(AddRepairInfoFragment.this.G, AddRepairInfoFragment.this.G);
                } else {
                    AddRepairInfoFragment.this.J.setSelectOptions(AddRepairInfoFragment.this.G, AddRepairInfoFragment.this.G + 1);
                }
            }
        }
    }

    public class c implements e {
        public c() {
        }

        @Override // c.b.a.d.e
        public void onOptionsSelect(int i2, int i3, int i4, View view) {
            AddRepairInfoFragment.this.G = i2;
            AddRepairInfoFragment.this.H = i3;
            AddRepairInfoFragment.this.mOpenDoorTimeTv.setText(((String) AddRepairInfoFragment.this.E.get(i2)) + "-" + ((String) AddRepairInfoFragment.this.F.get(i3)));
            q.d(AddRepairInfoFragment.class.getCanonicalName(), "onOptionsSelect options1：" + i2 + "，option2:" + i3);
        }
    }

    public class d implements AlertListFragment.a {
        public d() {
        }

        @Override // com.chinavisionary.microtang.alert.AlertListFragment.a
        public void alertCancel(View view) {
        }

        @Override // com.chinavisionary.microtang.alert.AlertListFragment.a
        public void alertConfirm(View view, List<LeftTitleToRightArrowVo> list) {
            if (AddRepairInfoFragment.this.K.uploadPic()) {
                return;
            }
            AddRepairInfoFragment.this.f2(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a2(int i2, int i3, int i4, View view) {
        this.L = i2;
        this.mServiceTimeTv.setText(this.B.get(i2) + this.C.get(i3));
        l2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c2(RepairOrderReasonVo repairOrderReasonVo) {
        H();
        S1(repairOrderReasonVo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e2(ResponseStateVo responseStateVo) {
        if (F(responseStateVo, R.string.tip_submit_success, R.string.tip_submit_failed)) {
            g0();
            d0(RepairHistoryActivity.class);
        }
    }

    public static AddRepairInfoFragment getInstance(String str, String str2) {
        AddRepairInfoFragment addRepairInfoFragment = new AddRepairInfoFragment();
        addRepairInfoFragment.setArguments(CoreBaseFragment.q(str));
        addRepairInfoFragment.h2(str2);
        return addRepairInfoFragment;
    }

    public final CheckBox M1(TagVo tagVo, View.OnClickListener onClickListener, FrameLayout.LayoutParams layoutParams, int i2) {
        CheckBox checkBox = new CheckBox(this.f6487e);
        checkBox.setId(R.id.id_comment_tag);
        checkBox.setOnClickListener(onClickListener);
        checkBox.setText(tagVo.getContent());
        checkBox.setTag(tagVo.getKey());
        checkBox.setLayoutParams(layoutParams);
        checkBox.setButtonDrawable((Drawable) null);
        checkBox.setPadding(i2, i2, i2, i2);
        checkBox.setGravity(17);
        checkBox.setBackgroundResource(R.drawable.bg_cb_comment_tag);
        checkBox.setTextColor(getResources().getColor(R.color.color686868));
        checkBox.setTextSize(2, 14.0f);
        return checkBox;
    }

    public final void N1(List<RepairOrderReasonVo.PlaceListBean> list) {
        this.mFlowLayout.removeAllViews();
        if (list != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp_6);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                RepairOrderReasonVo.PlaceListBean placeListBean = list.get(i2);
                TagVo tagVo = new TagVo();
                tagVo.setContent(placeListBean.getAssetInstanceName());
                tagVo.setKey(placeListBean.getAssetInstanceKey());
                this.mFlowLayout.addView(M1(tagVo, this.y, layoutParams, dimensionPixelSize));
            }
        }
    }

    public final void O1(List<RepairOrderReasonVo.ReasonListBean> list) {
        this.mFlowRepairInfoLayout.removeAllViews();
        if (list != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp_6);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                RepairOrderReasonVo.ReasonListBean reasonListBean = list.get(i2);
                TagVo tagVo = new TagVo();
                tagVo.setContent(reasonListBean.getReasonDesc());
                tagVo.setKey(reasonListBean.getReasonCode());
                this.mFlowRepairInfoLayout.addView(M1(tagVo, this.y, layoutParams, dimensionPixelSize));
            }
        }
    }

    public final boolean P1() {
        boolean z;
        int i2;
        if (this.L == -1) {
            F0(R.string.tip_select_pre_time);
            z = false;
        } else {
            z = true;
        }
        if (this.mAuthCb.isChecked()) {
            int i3 = this.G;
            if (i3 == -1 || (i2 = this.H) == -1) {
                F0(R.string.tip_select_auth_open_door_time);
                return false;
            }
            if (i3 == i2) {
                F0(R.string.tip_select_auth_open_door_time_equals);
                z = false;
            }
            if (this.G > this.H) {
                F0(R.string.tip_select_auth_open_door_time_failed);
                return false;
            }
        }
        return z;
    }

    public final List<String> Q1() {
        ArrayList arrayList = new ArrayList();
        int childCount = this.mFlowRepairInfoLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            CheckBox checkBox = (CheckBox) this.mFlowRepairInfoLayout.getChildAt(i2);
            if (checkBox.isChecked()) {
                arrayList.add((String) checkBox.getTag());
            }
        }
        return arrayList;
    }

    public final Long[] R1() {
        Long l;
        Long l2;
        if (this.L == -1) {
            return null;
        }
        Long[] lArr = new Long[2];
        int i2 = this.L;
        if (i2 > 0) {
            int i3 = i2 * 2;
            if (i3 + 1 >= this.D.size()) {
                i3--;
            }
            l = this.D.get(i3);
            l2 = this.D.get(i3 + 1);
        } else {
            l = this.D.get(0);
            l2 = this.D.get(1);
        }
        lArr[0] = l;
        lArr[1] = l2;
        return lArr;
    }

    public final void S1(RepairOrderReasonVo repairOrderReasonVo) {
        if (repairOrderReasonVo != null) {
            V1(repairOrderReasonVo.getDates());
            this.mAddressTv.setText(x.getNotNullStr(repairOrderReasonVo.getAddress(), ""));
            N1(repairOrderReasonVo.getAssetInstanceList());
            O1(repairOrderReasonVo.getReasonList());
        }
    }

    public final void T1() {
        c.b.a.f.b<String> bVarBuild = new c.b.a.b.a(this.f6487e, new e() { // from class: c.e.c.g0.b.d
            @Override // c.b.a.d.e
            public final void onOptionsSelect(int i2, int i3, int i4, View view) {
                this.f1462a.a2(i2, i3, i4, view);
            }
        }).build();
        this.I = bVarBuild;
        bVarBuild.setNPicker(this.B, this.C, null);
    }

    public final void U1() {
        if (this.J == null) {
            this.E = new ArrayList();
            this.F = new ArrayList();
            this.J = new c.b.a.b.a(this.f6487e, new c()).setOptionsSelectChangeListener(new b()).build();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        c.b.a.f.b<String> bVar;
        int id = view.getId();
        if (id == R.id.cb_auth) {
            X1(view);
            return;
        }
        if (id == R.id.tv_open_door_time) {
            k2();
        } else if (id == R.id.tv_service_time && (bVar = this.I) != null) {
            bVar.show();
        }
    }

    public final void V1(List<Long> list) {
        if (list == null || list.size() < 2) {
            return;
        }
        this.D = list;
        this.B = new ArrayList();
        this.C = new ArrayList();
        if (list.size() % 2 != 0) {
            list.add(0, Long.valueOf(z.getTimeMillis() + 32400000));
        }
        Long l = list.get(0);
        Long l2 = list.get(1);
        List<String> list2 = this.C;
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat simpleDateFormat = z.l;
        sb.append(z.getTime(l, simpleDateFormat));
        sb.append("-");
        sb.append(z.getTime(l2, simpleDateFormat));
        list2.add(sb.toString());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 % 2 == 0) {
                Long l3 = list.get(i2);
                this.B.add(z.getTime(l3, z.m) + z.getWeek(l3.longValue()));
            }
        }
        T1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        W1();
        i2();
        z0(R.string.loading_text);
        I1();
    }

    public final void W1() {
        this.mTitleTv.setText(R.string.title_add_repair_info);
        this.mProductNameTv.setText(x.getNotNullStr(this.N, ""));
        this.mPhoneTv.setText(t());
        this.mAuthCb.setOnClickListener(this.y);
        this.mRepairPlaceTv.setVisibility(8);
        this.mFlowLayout.setVisibility(8);
        this.mServiceTimeTv.setOnClickListener(this.y);
        this.mOpenDoorTimeTv.setOnClickListener(this.y);
        g2();
    }

    public final void X1(View view) {
        this.mOpenDoorTimeTv.setVisibility(((CheckBox) view).isChecked() ? 0 : 8);
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    public final void f2(List<String> list) {
        Long l;
        Long l2;
        z0(R.string.tip_submit_data_loading);
        CreateRepairOrderVo createRepairOrderVo = new CreateRepairOrderVo();
        List<String> listQ1 = Q1();
        if (this.L == -1) {
            H();
            F0(R.string.tip_select_pre_time);
            return;
        }
        int i2 = this.L;
        if (i2 > 0) {
            int i3 = i2 * 2;
            if (i3 + 1 >= this.D.size()) {
                i3--;
            }
            l = this.D.get(i3);
            l2 = this.D.get(i3 + 1);
        } else {
            l = this.D.get(0);
            l2 = this.D.get(1);
        }
        createRepairOrderVo.setFromTime(l);
        createRepairOrderVo.setToTime(l2);
        if (this.mAuthCb.isChecked()) {
            String str = this.E.get(this.G);
            String str2 = this.E.get(this.H);
            SimpleDateFormat simpleDateFormat = z.f1240a;
            createRepairOrderVo.setOpenToTime(Long.valueOf(z.getTimeInLong(simpleDateFormat, str2)));
            createRepairOrderVo.setOpenFromTime(Long.valueOf(z.getTimeInLong(simpleDateFormat, str)));
        }
        if (!listQ1.isEmpty()) {
            createRepairOrderVo.setReasonCode(listQ1);
        }
        createRepairOrderVo.setCustomerName(w().getNickname());
        createRepairOrderVo.setAuthOpen(this.mAuthCb.isChecked());
        createRepairOrderVo.setAssetCategoryKey(this.f6484b);
        if (list != null) {
            createRepairOrderVo.setBreakdownResource(list);
        }
        String string = this.mRemarkEdt.getText().toString();
        if (x.isNotNull(string)) {
            createRepairOrderVo.setRemark(string);
        }
        createRepairOrderVo.setPhone(s());
        this.M.createRepairOrder(createRepairOrderVo);
    }

    public final void g2() {
        UploadNineFragment uploadNineFragment = UploadNineFragment.getInstance(this.O);
        this.K = uploadNineFragment;
        e(uploadNineFragment, R.id.flayout_nine_grid_view, false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_add_repair_info;
    }

    public final void h2(String str) {
        this.N = str;
    }

    public final void i2() {
        RepairModel repairModel = (RepairModel) h(RepairModel.class);
        this.M = repairModel;
        repairModel.getRepairOrderReason().observe(this, new Observer() { // from class: c.e.c.g0.b.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1461a.c2((RepairOrderReasonVo) obj);
            }
        });
        this.M.getResultLiveData().observe(this, new Observer() { // from class: c.e.c.g0.b.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1459a.e2((ResponseStateVo) obj);
            }
        });
        this.M.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.g0.b.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1460a.C((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        this.M.getRepairOrderReason(this.f6484b);
    }

    public final void j2() {
        String string = x.getString(R.string.title_alert_tip);
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setLeft(x.getString(R.string.title_device_name));
        leftTitleToRightArrowVo.setRight(this.N);
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setLeft(x.getString(R.string.title_address));
        leftTitleToRightArrowVo2.setRight(this.mAddressTv.getText().toString());
        arrayList.add(leftTitleToRightArrowVo2);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_target_time));
        leftTitleToRightArrowVo3.setRight(this.mServiceTimeTv.getText().toString());
        arrayList.add(leftTitleToRightArrowVo3);
        if (this.mAuthCb.isChecked()) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo4.setLeft(x.getString(R.string.title_auth_open_door_time));
            leftTitleToRightArrowVo4.setRight(this.mOpenDoorTimeTv.getText().toString());
            arrayList.add(leftTitleToRightArrowVo4);
        }
        String string2 = this.mRemarkEdt.getText().toString();
        if (x.isNotNull(string2)) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo5.setLeft(x.getString(R.string.title_repair_remark));
            leftTitleToRightArrowVo5.setRight(string2);
            arrayList.add(leftTitleToRightArrowVo5);
        }
        AlertListFragment alertListFragment = AlertListFragment.getInstance(arrayList, string);
        alertListFragment.setIAlertListClickListener(new d());
        d(alertListFragment, R.id.flayout_content);
    }

    public final void k2() {
        c.b.a.f.b<String> bVar = this.J;
        if (bVar == null || this.L == -1) {
            F0(R.string.title_unselect_arrive_time);
        } else {
            bVar.show();
        }
    }

    public final void l2() {
        U1();
        Long[] lArrR1 = R1();
        if (lArrR1 != null) {
            Long lValueOf = lArrR1[0];
            if (lValueOf.longValue() < System.currentTimeMillis()) {
                Long lValueOf2 = Long.valueOf(System.currentTimeMillis());
                SimpleDateFormat simpleDateFormat = z.f1248i;
                lValueOf = Long.valueOf(z.getTimeInLong(simpleDateFormat, z.getTime(lValueOf2, simpleDateFormat)));
            }
            Long l = lArrR1[1];
            if (l.longValue() < lValueOf.longValue()) {
                return;
            }
            this.E.clear();
            this.F.clear();
            Long lValueOf3 = Long.valueOf((l.longValue() - lValueOf.longValue()) / ((long) 60000));
            for (int i2 = 0; i2 < lValueOf3.longValue(); i2++) {
                Long lValueOf4 = Long.valueOf(lValueOf.longValue() + ((long) (i2 * 60000)));
                this.E.add(z.getTime(lValueOf4, z.f1240a));
                this.F.add(z.getTime(lValueOf4, z.l));
            }
            this.J.setNPicker(this.E, this.F, null);
            this.J.setSelectOptions(0, 1);
        }
    }

    @OnClick({R.id.btn_next})
    public void nextClick(View view) {
        if (P1()) {
            j2();
        }
    }
}
