package com.chinavisionary.microtang.msg.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.m0.e;
import c.e.c.z.c.a;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.main.event.EventBadgeMsgVo;
import com.chinavisionary.microtang.msg.adpater.MsgNewAdapter;
import com.chinavisionary.microtang.msg.model.MsgModel;
import com.chinavisionary.microtang.msg.vo.BadgeCountVo;
import com.chinavisionary.microtang.msg.vo.MsgVo;
import com.chinavisionary.microtang.msg.vo.RequestReadBadgeBo;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import g.b.a.m;
import g.b.a.r;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MsgFragment extends BaseFragment<MsgVo> {
    public boolean B;
    public boolean D;
    public MsgModel E;
    public a F;

    @BindView(R.id.tv_badge_paint)
    public TextView mBadgePaintTv;

    @BindView(R.id.tv_badge_value)
    public TextView mBadgeValueTv;

    @BindView(R.id.swipe_refresh_layout_msg)
    public BaseSwipeRefreshLayout mMsgSwipeRefreshLayout;

    @BindView(R.id.tv_title_right)
    public TextView mReadAllTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public int C = -1;
    public final c.e.a.a.c.c.a G = new c.e.a.a.c.c.a() { // from class: c.e.c.z.b.a
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f2278a.S1(view, i2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: R1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S1(View view, int i2) {
        this.C = i2;
        F1((MsgVo) this.t.getList().get(i2));
    }

    public static MsgFragment getInstance() {
        return new MsgFragment();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void E1(List<MsgVo> list) {
        if (list == null || list.isEmpty()) {
            this.t.addDataToList((T) new MsgVo());
        }
    }

    public final void F1(MsgVo msgVo) {
        a.checkIsClearNotify(msgVo.getMessageKey());
        V1(msgVo.getMessageKey(), false);
        if (msgVo.getForwardType() == null || !x.isNotNull(msgVo.getHref())) {
            K0(MsgDetailsFragment.getInstance(JSON.toJSONString(msgVo)), R.id.flayout_content);
        } else {
            c1(msgVo.getForwardType(), msgVo.getHref(), msgVo.getTitle());
        }
    }

    public final void G1(BadgeCountVo badgeCountVo) {
        q.d(getClass().getSimpleName(), "handleMsgCount :" + badgeCountVo.getUnreadCount());
        M1();
        L1();
        W1(badgeCountVo);
    }

    public final void H1(RequestErrDto requestErrDto) {
        Z1();
        C(requestErrDto);
    }

    public final void I1(ResponseVo<MsgVo> responseVo) {
        Z1();
        if (responseVo != null) {
            D(responseVo.getRows());
            E1(responseVo.getRows());
        }
    }

    public final void J1() {
        if (!this.D) {
            this.f6483a = 1;
            this.E.getMsgList(r());
        }
        if (this.D) {
            this.D = false;
        }
    }

    public final void K1(int i2) {
        int i3 = i2 > 0 ? 0 : 8;
        if (this.mReadAllTv.getVisibility() != i3) {
            this.mReadAllTv.setVisibility(i3);
        }
    }

    public final void L1() {
        if (this.B) {
            H();
            this.f6483a = 1;
            this.B = false;
            a.clearNotification();
            this.E.getMsgList(r());
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
    public final void M1() {
        if (this.C != -1) {
            ((MsgVo) this.t.getList().get(this.C)).setHasRead(true);
            this.t.notifyItemChanged(this.C);
        }
    }

    public final void N1() {
        h0(this);
        this.F = new a();
        this.mTitleTv.setText(R.string.title_msg);
        this.mReadAllTv.setText(R.string.title_read_all);
        this.mReadAllTv.setOnClickListener(this.y);
    }

    public final void O1() {
        z0(R.string.loading_text);
        j0();
    }

    public final void U1() {
        if (this.f6483a == 1) {
            this.E.getMsgCount();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.tv_cat_details) {
            F1((MsgVo) this.t.getList().get(((Integer) view.getTag()).intValue()));
        } else {
            if (id != R.id.tv_title_right) {
                return;
            }
            V1(null, true);
        }
    }

    public final void V1(String str, boolean z) {
        RequestReadBadgeBo requestReadBadgeBo = new RequestReadBadgeBo();
        if (x.isNotNull(str)) {
            requestReadBadgeBo.setMessageKey(str);
        }
        if (z) {
            this.C = -1;
            this.B = true;
            z0(R.string.tip_submit_data_loading);
        }
        requestReadBadgeBo.setReadAll(z);
        this.E.postReadBadge(requestReadBadgeBo);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        N1();
        X1();
        Y1();
        O1();
    }

    public final void W1(BadgeCountVo badgeCountVo) {
        this.D = true;
        l(this.F.getEventBadgeMsgVo(badgeCountVo));
    }

    public final void X1() {
        MsgModel msgModel = (MsgModel) h(MsgModel.class);
        this.E = msgModel;
        msgModel.getMsgList().observe(this, new Observer() { // from class: c.e.c.z.b.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2280a.I1((ResponseVo) obj);
            }
        });
        this.E.getMsgCountLiveData().observe(this, new Observer() { // from class: c.e.c.z.b.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2279a.G1((BadgeCountVo) obj);
            }
        });
        this.E.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.z.b.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2281a.H1((RequestErrDto) obj);
            }
        });
    }

    public final void Y1() {
        this.r = this.mMsgSwipeRefreshLayout.getBaseRecyclerView();
        MsgNewAdapter msgNewAdapter = new MsgNewAdapter();
        this.t = msgNewAdapter;
        msgNewAdapter.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.G);
        this.t.setEmptyTipMsg(x.getString(R.string.tip_msg_is_empty));
    }

    public final void Z1() {
        H();
        this.mMsgSwipeRefreshLayout.setRefreshing(false);
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_msg;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        U1();
        this.E.getMsgList(r());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @m(threadMode = r.MAIN)
    public void updateBadgeEvent(EventBadgeMsgVo eventBadgeMsgVo) {
        K1(eventBadgeMsgVo.getBadgeNumber());
        e.setupBadge(eventBadgeMsgVo, this.mBadgeValueTv, this.mBadgePaintTv);
        J1();
    }
}
