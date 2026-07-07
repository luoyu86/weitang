package com.chinavisionary.paymentlibrary;

import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.d.c0.d;
import c.e.d.c0.e;
import c.e.d.c0.g;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.paymentlibrary.model.NewPayModel;
import com.chinavisionary.paymentlibrary.model.PayModel;
import com.chinavisionary.paymentlibrary.vo.EventPayStateVo;
import com.chinavisionary.paymentlibrary.vo.PayBillResultVo;
import com.chinavisionary.paymentlibrary.vo.PayBillVo;
import com.chinavisionary.paymentlibrary.vo.PayStateVo;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentPay extends CoreBaseFragment {
    public static int A = 5;
    public int B;
    public int C;
    public boolean D;
    public boolean E;
    public PayModel F;
    public NewPayModel G;
    public PayBillResultVo H;
    public d I;
    public String J;
    public final e K = new a();
    public final Runnable L = new Runnable() { // from class: c.e.d.d
        @Override // java.lang.Runnable
        public final void run() {
            this.f2301a.f1();
        }
    };

    public class a implements e {
        public a() {
        }

        @Override // c.e.d.c0.e
        public void payFailed(ResponseStateVo responseStateVo) {
            FragmentPay.this.W0(responseStateVo);
        }

        @Override // c.e.d.c0.e
        public void paySuccess() {
            FragmentPay.this.Q0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d1(ResponseStateVo responseStateVo) {
        H();
        n();
        h1(responseStateVo.isSuccess(), responseStateVo.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f1() {
        this.B++;
        NewPayModel newPayModel = this.G;
        if (newPayModel != null) {
            newPayModel.getPayStateToKey(this.f6484b);
        }
    }

    public static FragmentPay getInstance(String str, int i2) {
        FragmentPay fragmentPay = new FragmentPay();
        fragmentPay.setArguments(CoreBaseFragment.q(str));
        fragmentPay.i1(i2);
        return fragmentPay;
    }

    public final ResponseStateVo P0(String str) {
        ResponseStateVo responseStateVo = new ResponseStateVo();
        responseStateVo.setSuccess(false);
        responseStateVo.setMessage(str);
        return responseStateVo;
    }

    public final void Q0(boolean z) {
        CoreBaseFragment.c cVar;
        q.d(this.f6485c, "getPayResult isDelay :" + z);
        if (!z || (cVar = this.f6488f) == null) {
            NewPayModel newPayModel = this.G;
            if (newPayModel == null) {
                String str = this.f6485c;
                StringBuilder sb = new StringBuilder();
                sb.append("getPayResult mNewPayModel is null");
                sb.append(this.f6488f != null);
                q.d(str, sb.toString());
                return;
            }
            newPayModel.getPayStateToKey(this.f6484b);
            String str2 = this.f6485c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getPayResult getPayStateToKey");
            sb2.append(this.f6488f != null);
            q.d(str2, sb2.toString());
            return;
        }
        cVar.removeMessages(20);
        if (A <= this.B) {
            q.d(this.f6485c, "getPayResult MAX_RETRY :" + this.B);
            W0(P0(x.getString(R.string.payment_lib_tip_pay_result_time)));
            return;
        }
        q.d(this.f6485c, "getPayResult sendEmptyMessageDelayed :" + this.B);
        this.f6488f.sendEmptyMessageDelayed(20, 2000L);
    }

    public final void R0() {
        if (this.C != 0) {
            W0(P0(x.getString(R.string.payment_lib_title_init_pay_failed)));
            return;
        }
        q.d(this.f6485c, "getPaySignData");
        PayBillVo payBillVo = new PayBillVo();
        payBillVo.setPaymentKey(this.f6484b);
        payBillVo.setPayChannel(this.C);
        NewPayModel newPayModel = this.G;
        if (newPayModel != null) {
            newPayModel.getPaySign(payBillVo);
        }
    }

    public final void S0(PayBillResultVo payBillResultVo) {
        T0(payBillResultVo);
    }

    public final void T0(PayBillResultVo payBillResultVo) {
        if (payBillResultVo != null) {
            X0(payBillResultVo.getPaySign());
        } else {
            u0(x.getString(R.string.payment_lib_title_get_sign_failed));
        }
    }

    public final void U0(PayStateVo payStateVo) {
        if (payStateVo == null) {
            Q0(true);
            return;
        }
        ResponseStateVo responseStateVo = new ResponseStateVo();
        q.d(this.f6485c, "handlePayStateResult getPayStatus = " + payStateVo.getPayStatus());
        int payStatus = payStateVo.getPayStatus();
        if (payStatus == 1) {
            responseStateVo.setSuccess(true);
            responseStateVo.setMessage(x.getString(R.string.payment_lib_tip_pay_success));
            W0(responseStateVo);
            return;
        }
        if (payStatus != 2) {
            if (payStatus == 4) {
                responseStateVo.setMessage(x.getString(R.string.payment_lib_tip_pay_cancel));
                W0(responseStateVo);
                return;
            } else if (payStatus != 5) {
                Q0(true);
                return;
            }
        }
        responseStateVo.setMessage(x.getString(R.string.payment_lib_tip_pay_failed));
        W0(responseStateVo);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    public final void V0(RequestErrDto requestErrDto) {
        if (requestErrDto != null) {
            C(requestErrDto);
            W0(P0(requestErrDto.getErrMsg()));
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        Y0();
        j1();
        I1();
    }

    public final void W0(final ResponseStateVo responseStateVo) {
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null && responseStateVo != null) {
            cVar.removeMessages(20);
            this.f6488f.postDelayed(new Runnable() { // from class: c.e.d.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2303a.d1(responseStateVo);
                }
            }, 1500L);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("handlerPayResult BaseHandle is null or result null is： ");
            sb.append(responseStateVo == null);
            i(sb.toString());
        }
    }

    public final void X0(String str) {
        int i2;
        if (this.I == null || !x.isNotNull(str)) {
            W0(P0(x.getString(R.string.payment_lib_title_init_pay_failed)));
            return;
        }
        q.d(this.f6485c, "handlerPaySignData paySign = " + str);
        if ("queryPayState".equals(str)) {
            this.K.paySuccess();
            return;
        }
        if (!c.e.a.a.a.getInstance().isJHModel() || ((i2 = this.C) != 2 && i2 != 1 && i2 != 6 && i2 != 4 && i2 != 5 && i2 != 7 && i2 != 8 && i2 != 9 && i2 != 10 && i2 != 11 && i2 != 13 && i2 != 12)) {
            this.I.requestPay(str);
        } else {
            this.I.requestPay(str);
            Q0(true);
        }
    }

    public final void Y0() {
        ((TextView) this.u.findViewById(R.id.tv_tip)).setText(R.string.payment_lib_tip_pay_loading);
        this.f6488f = new CoreBaseFragment.c(this);
        if (c.e.a.a.a.getInstance().isJHModel()) {
            this.I = new g(this.f6487e, this.C, this.K);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void e0() {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void f0() {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.payment_lib_fragment_pay;
    }

    public final void h1(boolean z, String str) {
        EventPayStateVo eventPayStateVo = new EventPayStateVo();
        eventPayStateVo.setSuccess(z);
        eventPayStateVo.setMsg(str);
        eventPayStateVo.setHasRentFee(this.D);
        eventPayStateVo.setBillKey(this.J);
        k(eventPayStateVo);
        q.d(this.f6485c, "sendHandlerPayResult msg :" + str);
    }

    public final void i1(int i2) {
        this.C = i2;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        if (this.H != null) {
            q.d(this.f6485c, "requestData handlerPaySignData ");
            X0(this.H.getPaySign());
        } else {
            q.d(this.f6485c, "requestData getPaySignData ");
            R0();
        }
    }

    public final void j1() {
        if (c.e.a.a.a.getInstance().isH5Model()) {
            NewPayModel newPayModel = (NewPayModel) h(NewPayModel.class);
            this.G = newPayModel;
            newPayModel.getPayBillResult().observeForever(new Observer() { // from class: c.e.d.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2305a.S0((PayBillResultVo) obj);
                }
            });
            this.G.getPayStateResult().observeForever(new Observer() { // from class: c.e.d.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2288a.U0((PayStateVo) obj);
                }
            });
            this.G.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.d.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2283a.V0((RequestErrDto) obj);
                }
            });
        }
        PayModel payModel = (PayModel) h(PayModel.class);
        this.F = payModel;
        payModel.getPayBillResult().observeForever(new Observer() { // from class: c.e.d.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2282a.T0((PayBillResultVo) obj);
            }
        });
        this.F.getPayStateResult().observeForever(new Observer() { // from class: c.e.d.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2288a.U0((PayStateVo) obj);
            }
        });
        this.F.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.d.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2283a.V0((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.B = 0;
        d dVar = this.I;
        if (dVar != null) {
            dVar.recycler();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (4 != i2) {
            return super.onKeyDown(i2, keyEvent);
        }
        F0(R.string.payment_lib_tip_paying_unable_exit);
        return true;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        q.d(this.f6485c, "onStart isQueryPayState :" + this.E);
        if (this.E) {
            this.E = false;
            Q0(true);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.E = true;
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.removeMessages(20);
        }
        q.d(this.f6485c, "onStop isQueryPayState :" + this.E);
    }

    public void setOrderId(String str) {
        this.J = str;
    }

    public void setPayBillResultVo(PayBillResultVo payBillResultVo) {
        this.H = payBillResultVo;
    }

    public void setPayRoomFee(boolean z) {
        this.D = z;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        if (message.what == 20) {
            this.f6488f.post(this.L);
        }
    }
}
