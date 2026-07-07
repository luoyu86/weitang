package com.chinavisionary.microtang.order.fragment;

import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.event.EventUpdateUserInfoVo;
import com.chinavisionary.core.scan.view.ScanCodeActivity;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseTabFragment;
import com.chinavisionary.microtang.base.TabFragmentAdapter;
import com.chinavisionary.microtang.msg.MsgActivity;
import com.chinavisionary.microtang.order.vo.EventUpdateAllStateVo;
import com.chinavisionary.microtang.service.CustomerServiceActivity;
import com.chinavisionary.paymentlibrary.vo.EventPayStateVo;
import com.qq.e.comm.constants.ErrorCode;
import g.b.a.m;
import g.b.a.r;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OrderTabFragment extends BaseTabFragment {
    public boolean C;
    public int D;
    public TabFragmentAdapter E;
    public TextWatcher F = new a();

    @BindView(R.id.edt_search_room)
    public EditText mSearchOrderEdt;

    @BindView(R.id.tv_title_split_line)
    public View mSplitLineTv;

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
        }
    }

    public static OrderTabFragment getInstance() {
        return new OrderTabFragment();
    }

    public final List<Fragment> L1() {
        ArrayList arrayList = new ArrayList();
        for (int i2 : M1()) {
            arrayList.add(OrderFragment.getInstance(i2));
        }
        return arrayList;
    }

    public final int[] M1() {
        return new int[]{-1, 0, 1001, ErrorCode.MANIFEST_ERROR, 1000};
    }

    public final List<String> N1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(x.getString(R.string.title_order_all));
        arrayList.add(x.getString(R.string.title_order_pay_wait));
        arrayList.add(x.getString(R.string.title_order_wait_receive));
        arrayList.add(x.getString(R.string.title_order_expressing));
        arrayList.add(x.getString(R.string.title_order_over));
        return arrayList;
    }

    public final void O1() {
        if (this.C) {
            this.C = false;
            this.f6488f.sendEmptyMessageDelayed(this.D, 500L);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.microtang.base.BaseTabFragment, com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        super.W();
        h0(this);
        this.mSplitLineTv.setVisibility(0);
        J1(R.string.title_all_order);
        this.mSearchOrderEdt.addTextChangedListener(this.F);
        this.mSearchOrderEdt.setHint(R.string.hint_title_search_order);
        this.f6488f = new CoreBaseFragment.c(this);
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getFragmentManager(), L1());
        this.E = tabFragmentAdapter;
        tabFragmentAdapter.setTitleList(N1());
        K1(this.E);
    }

    @m(threadMode = r.MAIN)
    public void eventUpdateUserInfo(EventUpdateUserInfoVo eventUpdateUserInfoVo) {
        if (eventUpdateUserInfoVo != null) {
            if (O()) {
                k(new EventUpdateAllStateVo());
            }
            I1(O());
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @OnClick({R.id.rlayout_notify})
    public void msgClickView() {
        if (N()) {
            d0(MsgActivity.class);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        I1(O());
        O1();
    }

    @OnClick({R.id.rlayout_scan})
    public void openScan() {
        d0(ScanCodeActivity.class);
    }

    @OnClick({R.id.rlayout_server})
    public void serverClick() {
        if (c.e.a.a.a.getInstance().isIMModel()) {
            d0(CustomerServiceActivity.class);
        } else if (N()) {
            d0(CustomerServiceActivity.class);
        }
    }

    @m(threadMode = r.MAIN)
    public void subscribePayResult(EventPayStateVo eventPayStateVo) {
        if (!isResumed()) {
            this.C = true;
            this.D = eventPayStateVo.isSuccess() ? 2 : 1;
            q.d(getClass().getSimpleName(), "eventPayStateVo isSwitchTab");
        } else {
            if (eventPayStateVo.isSuccess()) {
                this.f6488f.sendEmptyMessageDelayed(2, 500L);
            } else {
                this.f6488f.sendEmptyMessageDelayed(1, 500L);
            }
            q.d(getClass().getSimpleName(), "eventPayStateVo isResumed");
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        F1().setCurrentItem(message.what);
        ((OrderFragment) this.E.getFragments().get(message.what)).j0();
        q.d(getClass().getSimpleName(), "handle message:" + message.what);
    }
}
