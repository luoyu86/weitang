package com.chinavisionary.microtang.sign.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.b.a.d.g;
import c.b.a.f.c;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.main.vo.ResponseRentConfigFeeVo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SelectRentDateFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public Long B;
    public c C;
    public ResponseRentConfigFeeVo D;
    public RoomRentInfoFragment E;
    public c.e.a.a.c.c.a F = new c.e.a.a.c.c.a() { // from class: c.e.c.j0.b.b0
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1597a.N1(view, i2);
        }
    };

    @BindView(R.id.tv_title_right)
    public TextView mSaveTv;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements c.b.a.d.a {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(View view) {
            SelectRentDateFragment.this.C.returnData();
        }

        @Override // c.b.a.d.a
        public void customLayout(View view) {
            ((TextView) view.findViewById(R.id.tv_title_look_room)).setText(R.string.title_select_end_date);
            ((Button) view.findViewById(R.id.btn_confirm_time)).setOnClickListener(new View.OnClickListener() { // from class: c.e.c.j0.b.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f1595a.b(view2);
                }
            });
        }
    }

    public class b implements g {
        public b() {
        }

        @Override // c.b.a.d.g
        public void onTimeSelect(Date date, View view) {
            SelectRentDateFragment.this.P1(date);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(View view, int i2) {
        G1(i2);
    }

    public static SelectRentDateFragment getInstance(ResponseRentConfigFeeVo responseRentConfigFeeVo) {
        SelectRentDateFragment selectRentDateFragment = new SelectRentDateFragment();
        selectRentDateFragment.Q1(responseRentConfigFeeVo);
        return selectRentDateFragment;
    }

    public final void G1(int i2) {
        if (1 == ((LeftTitleToRightArrowVo) this.t.getList().get(i2)).getOnlyKey()) {
            O1();
        }
    }

    public final void H1(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        if (iIntValue != 1) {
            I1(iIntValue);
        }
        G1(iIntValue);
    }

    public final void I1(int i2) {
        List list = this.t.getList();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo = (LeftTitleToRightArrowVo) list.get(i3);
            boolean z = true;
            if (i3 != 1 && i3 != i2) {
                z = false;
            }
            leftTitleToRightArrowVo.setSelectRadio(z);
        }
        this.t.notifyDataSetChanged();
    }

    public final void J1() {
        if (this.E == null) {
            n();
            return;
        }
        if (!((LeftTitleToRightArrowVo) this.t.getList().get(this.t.getList().size() - 1)).isSelectRadio()) {
            n();
            return;
        }
        Long l = this.B;
        if (l == null) {
            F0(R.string.tip_select_end_date);
        } else {
            this.E.f2(l);
            n();
        }
    }

    public final void K1() {
        this.mTitleTv.setText(R.string.title_select_rent_date);
        this.mSaveTv.setVisibility(0);
        this.mSaveTv.setText(R.string.title_save);
        this.mSaveTv.setOnClickListener(this.y);
    }

    public final void L1(Long l, Long l2) {
        if (l == null || l2 == null || l2.longValue() < l.longValue()) {
            F0(R.string.title_start_time_great_end_time);
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(l2.longValue());
        c cVarBuild = new c.b.a.b.b(this.f6487e, new b()).setLayoutRes(R.layout.item_custom_rent_time_picker_layout, new a()).setType(new boolean[]{true, true, true, false, false, false}).setLabel("年", "月", "日", "", "", "").setDividerColor(-12303292).setContentTextSize(20).setDate(calendar).setRangDate(calendar, calendar2).isDialog(true).setOutSideColor(0).setOutSideCancelable(true).build();
        this.C = cVarBuild;
        cVarBuild.setKeyBackCancelable(true);
    }

    public final void O1() {
        c cVar = this.C;
        if (cVar != null) {
            cVar.show();
        } else {
            F0(R.string.tip_select_date_is_empty);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void P1(Date date) {
        this.B = Long.valueOf(date.getTime());
        this.C.dismiss();
        int size = this.t.getList().size() - 1;
        ((LeftTitleToRightArrowVo) this.t.getList().get(size)).setRight(z.getTimeYYMMDD(this.B));
        if (((LeftTitleToRightArrowVo) this.t.getList().get(size)).isSelectRadio()) {
            this.t.notifyItemChanged(size);
        } else {
            I1(size);
        }
    }

    public final void Q1(ResponseRentConfigFeeVo responseRentConfigFeeVo) {
        this.D = responseRentConfigFeeVo;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void R1() {
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setTitle(x.getString(R.string.title_effect_date));
        leftTitleToRightArrowVo.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setLeft(z.getTimeYYMMDD(this.D.getRentTermFrom()));
        leftTitleToRightArrowVo2.setShowRadio(true);
        leftTitleToRightArrowVo2.setSelectRadio(true);
        arrayList.add(leftTitleToRightArrowVo2);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo3.setTitle(x.getString(R.string.title_close_date));
        leftTitleToRightArrowVo3.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo3);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo4.setLeft(z.getTimeYYMMDD(this.D.getRentTermTo()));
        leftTitleToRightArrowVo4.setShowRadio(true);
        leftTitleToRightArrowVo4.setSelectRadio(true);
        arrayList.add(leftTitleToRightArrowVo4);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo5.setOnlyKey(1);
        leftTitleToRightArrowVo5.setShowRadio(true);
        leftTitleToRightArrowVo5.setLeft(x.getString(R.string.title_select_end_date));
        leftTitleToRightArrowVo5.setShowArrow(true);
        arrayList.add(leftTitleToRightArrowVo5);
        this.t.initListData(arrayList);
    }

    public final void S1() {
        this.mSwipeRefreshLayout.setEnabled(false);
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        LeftTitleToRightArrowAdapter leftTitleToRightArrowAdapter = new LeftTitleToRightArrowAdapter();
        this.t = leftTitleToRightArrowAdapter;
        leftTitleToRightArrowAdapter.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.F);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (M0(view)) {
            int id = view.getId();
            if (id == R.id.radio_btn) {
                H1(view);
            } else {
                if (id != R.id.tv_title_right) {
                    return;
                }
                J1();
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        K1();
        S1();
        R1();
        L1(this.D.getRentTermEarliestTo(), this.D.getRentTermLatestTo());
    }

    @OnClick({R.id.tv_back})
    public void finishFragment(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_recycler;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    public void setRoomRentInfoFragment(RoomRentInfoFragment roomRentInfoFragment) {
        this.E = roomRentInfoFragment;
    }
}
