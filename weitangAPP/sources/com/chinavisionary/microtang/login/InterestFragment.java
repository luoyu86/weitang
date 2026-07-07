package com.chinavisionary.microtang.login;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import butterknife.BindView;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.auth.IDAuthActivity;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.login.adapter.InterestAdapter;
import com.chinavisionary.microtang.login.bo.InterestItemVo;
import com.chinavisionary.microtang.login.bo.InterestSelectTagBo;
import com.chinavisionary.microtang.me.model.NewUserOperateModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InterestFragment extends BaseFragment<InterestItemVo> {
    public final List<InterestItemVo> B = new ArrayList();
    public NewUserOperateModel C;
    public boolean D;

    @BindView(R.id.img_back)
    public ImageView mBackImg;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.cb_confirm)
    public CheckBox mConfirmCb;

    @BindView(R.id.tv_title_split_line)
    public TextView mLineTv;

    @BindView(R.id.tv_title_right)
    public TextView mRightTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static InterestFragment getInstance() {
        return new InterestFragment();
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
    public final void E1(View view) {
        boolean zIsChecked = ((CheckBox) view).isChecked();
        int iIntValue = ((Integer) view.getTag()).intValue();
        InterestItemVo interestItemVo = (InterestItemVo) this.t.getList().get(iIntValue);
        interestItemVo.setSelect(zIsChecked);
        q.d(getClass().getSimpleName(), "handleCbClick key = " + interestItemVo.getTagName());
        if (!zIsChecked) {
            this.B.remove(interestItemVo);
        } else if (this.B.size() >= 3) {
            F0(R.string.tip_max_interest);
            interestItemVo.setSelect(false);
        } else {
            this.B.add(interestItemVo);
        }
        this.mConfirmCb.setChecked(o.isNotEmpty(this.B));
        Q1();
        this.t.notifyItemChanged(iIntValue);
    }

    public final void F1(View view) {
        if (this.B.size() == 0) {
            this.mConfirmCb.setChecked(false);
            F0(R.string.tip_unselect_interest);
            return;
        }
        z0(R.string.tip_submit_data_loading);
        this.mConfirmCb.setChecked(true);
        InterestSelectTagBo interestSelectTagBo = new InterestSelectTagBo();
        ArrayList arrayList = new ArrayList();
        for (InterestItemVo interestItemVo : this.B) {
            if (x.isNotNull(interestItemVo.getTagKey())) {
                arrayList.add(interestItemVo.getTagKey());
            }
        }
        interestSelectTagBo.setTagKeys(arrayList);
        this.C.postUserInterestTags(interestSelectTagBo);
    }

    public final void G1() {
        n();
        if (L() || M()) {
            return;
        }
        d0(IDAuthActivity.class);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void H1(NewResponseRowsVo<InterestItemVo> newResponseRowsVo) {
        H();
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
        this.B.clear();
        if (newResponseRowsVo != null) {
            this.t.initListData((List<T>) newResponseRowsVo.getRows());
        }
    }

    public final void I1(NewResponseStateVo newResponseStateVo) {
        if (this.D) {
            return;
        }
        H();
        A(newResponseStateVo, R.string.tip_submit_success, R.string.tip_submit_failed);
        G1();
    }

    public final void J1() {
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        this.r.setLayoutManager(new GridLayoutManager(this.f6487e, 3));
        InterestAdapter interestAdapter = new InterestAdapter();
        this.t = interestAdapter;
        interestAdapter.setOnClickListener(this.y);
    }

    public final void K1() {
        this.mTitleTv.setText(R.string.title_interest);
        this.mBackImg.setVisibility(8);
        this.mLineTv.setVisibility(4);
        this.mRightTv.setVisibility(0);
        this.mRightTv.setText(R.string.title_jump);
        this.mRightTv.setTextColor(getResources().getColor(R.color.colorFE9900));
        this.mRightTv.setOnClickListener(this.y);
        this.mConfirmCb.setOnClickListener(this.y);
        Q1();
    }

    public final void O1() {
        NewUserOperateModel newUserOperateModel = (NewUserOperateModel) h(NewUserOperateModel.class);
        this.C = newUserOperateModel;
        newUserOperateModel.getInterestItemList().observeForever(new Observer() { // from class: c.e.c.u.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1853a.H1((NewResponseRowsVo) obj);
            }
        });
        this.C.getSubmitInterestResult().observeForever(new Observer() { // from class: c.e.c.u.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1852a.I1((NewResponseStateVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observeForever(new Observer() { // from class: c.e.c.u.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1851a.C((RequestErrDto) obj);
            }
        });
    }

    public final void P1() {
        this.D = true;
        this.C.postUserInterestTags(new InterestSelectTagBo());
        G1();
    }

    public final void Q1() {
        this.mConfirmCb.setText(x.getString(R.string.placeholder_confirm_interest, Integer.valueOf(this.B.size())));
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.cb_confirm) {
            F1(view);
        } else if (id == R.id.cb_interest) {
            E1(view);
        } else {
            if (id != R.id.tv_title_right) {
                return;
            }
            P1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        O1();
        K1();
        J1();
        z0(R.string.loading_text);
        j0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_interest;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.C.getUserInterestTags();
    }
}
