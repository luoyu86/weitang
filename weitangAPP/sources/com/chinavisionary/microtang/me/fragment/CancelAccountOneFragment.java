package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.v;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.adapter.CancelAccountAdapter;
import com.chinavisionary.microtang.me.bo.CancelAccountItemBo;
import com.chinavisionary.microtang.me.bo.CancelAccountReasonBo;
import com.chinavisionary.microtang.me.model.NewUserOperateModel;

/* JADX INFO: loaded from: classes.dex */
public class CancelAccountOneFragment extends BaseFragment<CancelAccountItemBo> {
    public int B = -1;
    public NewUserOperateModel C;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.btn_submit)
    public Button mSubmitBtn;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements c.e.c.x.b.a {
        public a() {
        }

        @Override // c.e.c.x.b.a
        public void onCbChange(int i2, boolean z) {
        }
    }

    public class b implements c.e.a.a.c.c.a {
        public b() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            CancelAccountOneFragment.this.L1(i2);
        }
    }

    public static CancelAccountOneFragment getInstance() {
        return new CancelAccountOneFragment();
    }

    private void o0() {
        this.l = false;
        CancelAccountAdapter cancelAccountAdapter = new CancelAccountAdapter();
        cancelAccountAdapter.setICbChangeCallback(new a());
        this.t = cancelAccountAdapter;
        cancelAccountAdapter.setOnItemClickListener(new b());
        p0(this.mBaseSwipeRefreshLayout);
        this.mBaseSwipeRefreshLayout.setEnabled(false);
    }

    public final void F1(boolean z) {
        if (this.mSubmitBtn.isEnabled()) {
            return;
        }
        this.mSubmitBtn.setEnabled(z);
        this.mSubmitBtn.setBackgroundResource(z ? R.drawable.bg_room_details_pre_look : R.drawable.bg_btn_disable);
    }

    public final void G1(CancelAccountReasonBo cancelAccountReasonBo) {
        H();
        c.e.c.x.c.b.initCancelAccountReasonBo(cancelAccountReasonBo);
        D(c.e.c.x.c.b.getOneData());
    }

    public final void J1() {
        CancelAccountItemBo selectCancel = c.e.c.x.c.b.getSelectCancel(this.t.getList());
        if (selectCancel != null) {
            boolean z = true;
            if (selectCancel.isNeedShowRemark() && x.isNullStr(selectCancel.getRemarkValue())) {
                z = false;
                F0(R.string.hint_cancel_account_reason);
            }
            if (z) {
                d(CancelAccountTwoFragment.getInstance(selectCancel), R.id.flayout_content);
            }
        }
    }

    public final void K1() {
        NewUserOperateModel newUserOperateModel = (NewUserOperateModel) h(NewUserOperateModel.class);
        this.C = newUserOperateModel;
        newUserOperateModel.getErrRequestLiveData().observeForever(new Observer() { // from class: c.e.c.x.d.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2049a.C((RequestErrDto) obj);
            }
        });
        this.C.getCancelAccountReasonData().observeForever(new Observer() { // from class: c.e.c.x.d.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2045a.G1((CancelAccountReasonBo) obj);
            }
        });
        z0(R.string.loading_text);
        this.C.getCancelAccountReason();
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
    public final void L1(int i2) {
        if (v.getInstance().isRepeatedlyAction("updateCbState", 500)) {
            return;
        }
        CancelAccountItemBo cancelAccountItemBo = (CancelAccountItemBo) this.t.getList().get(i2);
        cancelAccountItemBo.setCheck(true);
        int i3 = this.B;
        if (i3 != i2 && i3 >= 0) {
            ((CancelAccountItemBo) this.t.getList().get(this.B)).setCheck(false);
            ((CancelAccountItemBo) this.t.getList().get(this.B)).setShowRemark(false);
            this.t.notifyItemChanged(this.B);
        }
        if (cancelAccountItemBo.isNeedShowRemark()) {
            cancelAccountItemBo.setShowRemark(true);
        }
        this.t.notifyItemChanged(i2);
        this.B = i2;
        F1(true);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.btn_submit) {
            J1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.f6488f = new CoreBaseFragment.c(this);
        this.mTitleTv.setText(R.string.title_cancel_account);
        this.mSubmitBtn.setEnabled(false);
        this.mSubmitBtn.setOnClickListener(this.y);
        o0();
        K1();
    }

    @OnClick({R.id.tv_back})
    public void clickBack() {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_cancel_account_one;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
