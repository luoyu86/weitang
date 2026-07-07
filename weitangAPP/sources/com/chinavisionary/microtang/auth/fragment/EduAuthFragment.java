package com.chinavisionary.microtang.auth.fragment;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.b.a.d.g;
import c.b.a.f.c;
import c.e.a.d.l;
import c.e.a.d.x;
import c.e.a.d.z;
import c.e.c.m0.i;
import c.e.c.m0.n;
import c.e.c.x.e.e0;
import c.e.c.x.e.f0;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.auth.adapter.EduAuthAdapter;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.vo.NameValueVo;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EduAuthFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public int B;
    public Long C;
    public c.e.c.h.b.a D;
    public c E;
    public e0 F;
    public final c.e.a.a.c.c.a G = new c.e.a.a.c.c.a() { // from class: c.e.c.h.c.a
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1482a.N1(view, i2);
        }
    };
    public final f0 H = new a();

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.btn_submit)
    public Button mSubmitBtn;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements f0 {
        public a() {
        }

        @Override // c.e.c.x.e.f0
        public Activity getCurrentContext() {
            return EduAuthFragment.this.f6487e;
        }

        @Override // c.e.c.x.e.f0
        public void openIDCardCamera(int i2) {
        }

        @Override // c.e.c.x.e.f0
        public void openImageGridActivity(int i2) {
        }

        @Override // c.e.c.x.e.f0
        public void showToast(int i2) {
        }

        @Override // c.e.c.x.e.f0
        public void updateSelectIdType(NameValueVo nameValueVo) {
        }

        @Override // c.e.c.x.e.f0
        public void updateSelectOptionName(String str) {
            EduAuthFragment.this.S1(str);
        }

        @Override // c.e.c.x.e.f0
        public void uploadFile(List<File> list) {
        }
    }

    public class b implements g {
        public b() {
        }

        @Override // c.b.a.d.g
        public void onTimeSelect(Date date, View view) {
            EduAuthFragment.this.P1(date);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(View view, int i2) {
        this.B = i2;
        int onlyKey = ((LeftTitleToRightArrowVo) this.t.getList().get(i2)).getOnlyKey();
        if (onlyKey == 8) {
            this.F.showOptionToOnlyKey(8);
        } else if (onlyKey == 9) {
            H1();
        } else {
            if (onlyKey != 11) {
                return;
            }
            R1();
        }
    }

    public static EduAuthFragment getInstance() {
        return new EduAuthFragment();
    }

    public final void H1() {
        startActivityForResult(new Intent(this.f6487e, (Class<?>) ImageGridActivity.class), 1004);
    }

    public final void I1() {
        this.E.returnData();
        this.E.dismiss();
    }

    public final void J1() {
        if (this.C == null) {
            F0(R.string.hint_please_select_graduation_time);
            return;
        }
        ((LeftTitleToRightArrowVo) this.t.getList().get(i.getItemIndexToOnlyKey(this.t.getList(), 10))).getRight();
        if (x.isNullStr(((LeftTitleToRightArrowVo) this.t.getList().get(i.getItemIndexToOnlyKey(this.t.getList(), 9))).getRight())) {
            F0(R.string.title_upload_edu_photo_prove);
        } else {
            A1("本人在此保证所提交的学历学位信息及上传的证书照片的真实性及有效性，如有不实或不符情况，由本人承担因此造成的一切后果。");
        }
    }

    public final void K1() {
        this.F = new e0(this.H);
        ResponseRowsVo<NameValueVo> responseRowsVo = new ResponseRowsVo<>();
        responseRowsVo.setRows(this.D.getEduSourceList());
        this.F.setupEduSourceVos(responseRowsVo, this.t.getList());
    }

    public final void L1(Activity activity) {
        long nextYear = z.getNextYear(System.currentTimeMillis());
        Calendar.getInstance().setTimeInMillis(946656000000L);
        Calendar.getInstance().setTimeInMillis(nextYear);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(z.getYearMonthToLong(System.currentTimeMillis()).longValue());
        c timePickerViewYMD = new n().getTimePickerViewYMD(activity, 946656000000L, Long.valueOf(nextYear), new b(), this.y);
        this.E = timePickerViewYMD;
        timePickerViewYMD.setDate(calendar);
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
    public final void O1(String str) {
        int itemIndexToOnlyKey = i.getItemIndexToOnlyKey(this.t.getList(), 9);
        Object extObj = ((LeftTitleToRightArrowVo) this.t.getList().get(itemIndexToOnlyKey)).getExtObj();
        ((LeftTitleToRightArrowVo) this.t.getList().get(itemIndexToOnlyKey)).setRight(str);
        if (extObj instanceof ResourceVo) {
            ((ResourceVo) extObj).setUrl(str);
        }
        this.t.notifyItemChanged(itemIndexToOnlyKey);
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
        long time = date.getTime();
        this.C = Long.valueOf(time);
        Log.d(getClass().getSimpleName(), "postSubscribe date :$selectTime");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        this.E.dismiss();
        this.E.setDate(calendar);
        String timeYYMMDD = z.getTimeYYMMDD(Long.valueOf(time));
        int itemIndexToOnlyKey = i.getItemIndexToOnlyKey(this.t.getList(), 11);
        ((LeftTitleToRightArrowVo) this.t.getList().get(itemIndexToOnlyKey)).setRight(timeYYMMDD);
        this.t.notifyItemChanged(itemIndexToOnlyKey);
    }

    public final void Q1() {
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        EduAuthAdapter eduAuthAdapter = new EduAuthAdapter();
        this.t = eduAuthAdapter;
        eduAuthAdapter.setOnItemClickListener(this.G);
        c.e.c.h.b.a aVar = new c.e.c.h.b.a();
        this.D = aVar;
        D(aVar.getEduData());
    }

    public final void R1() {
        c cVar = this.E;
        if (cVar != null) {
            cVar.show();
        }
    }

    public final void S1(String str) {
        ((LeftTitleToRightArrowVo) this.t.getList().get(this.B)).setRight(str);
        this.t.notifyDataSetChanged();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm_time /* 2131230863 */:
                I1();
                break;
            case R.id.btn_submit /* 2131230908 */:
                J1();
                break;
            case R.id.tv_alert_confirm /* 2131231942 */:
                F0(R.string.tip_submit_success);
                m();
                break;
            case R.id.tv_alert_photo_select /* 2131231944 */:
                H1();
                break;
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mSubmitBtn.setVisibility(0);
        this.mSubmitBtn.setOnClickListener(this.y);
        this.mTitleTv.setText(R.string.title_upload_edu_info);
        Q1();
        K1();
        L1(this.f6487e);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_recycler;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        ArrayList arrayList;
        if (i3 == 17) {
            String imagePath = c.r.a.a.c.getImagePath(intent);
            if (TextUtils.isEmpty(imagePath)) {
                return;
            }
            O1(l.renameFile(imagePath));
            return;
        }
        if (i3 != 1004 || intent == null || (arrayList = (ArrayList) intent.getSerializableExtra("extra_result_items")) == null || arrayList.isEmpty()) {
            return;
        }
        O1(((ImageItem) arrayList.get(0)).path);
    }

    @OnClick({R.id.tv_back})
    public void onBackClick() {
        n();
    }
}
