package c.e.d.y;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import c.e.a.d.x;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.paymentlibrary.R;
import com.chinavisionary.paymentlibrary.adapter.PayProductListAdapter;
import com.chinavisionary.paymentlibrary.model.BillModel;
import com.chinavisionary.paymentlibrary.model.NewBillModel;
import com.chinavisionary.paymentlibrary.vo.CreateFoodOrderVo;
import com.chinavisionary.paymentlibrary.vo.DiscountVo;
import com.chinavisionary.paymentlibrary.vo.H5CreatePayBillBo;
import com.chinavisionary.paymentlibrary.vo.PayBillVo;
import com.chinavisionary.paymentlibrary.vo.ResponseDiscountResultVo;
import com.chinavisionary.paymentlibrary.vo.ResponseDiscountVo;
import com.chinavisionary.paymentlibrary.vo.ResponseFoodVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m extends l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BaseRecyclerView f2343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f2344i;
    public TextView j;
    public TextView k;
    public int l;
    public String m;
    public String n;
    public boolean o;
    public PayProductListAdapter p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<String> f2345q;
    public List<String> r;
    public int s;
    public c.b.a.f.b<String> t;
    public final View.OnClickListener u;

    public m(View view, BillModel billModel, o oVar) {
        super(view, billModel, oVar);
        this.u = new View.OnClickListener() { // from class: c.e.d.y.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f2328a.y(view2);
            }
        };
        r(view);
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(View view) {
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(int i2, int i3, int i4, View view) {
        this.s = i2;
        I();
    }

    public final void B() {
        this.f2341f.getDiscountListToOrderKey(this.m);
    }

    public final void C(NewResponseStateVo newResponseStateVo) {
        NewBillModel newBillModel = this.f2341f;
        if (newBillModel == null || newResponseStateVo == null) {
            b();
            return;
        }
        if (this.n == null) {
            newBillModel.getPayMode(newResponseStateVo.getKey());
            this.n = newResponseStateVo.getKey();
            this.o = true;
            return;
        }
        this.n = newResponseStateVo.getKey();
        PayBillVo payBillVo = new PayBillVo();
        payBillVo.setPaymentKey(this.n);
        payBillVo.setPayChannel(this.l);
        if (this.f2341f != null) {
            H5CreatePayBillBo h5CreatePayBillBo = new H5CreatePayBillBo();
            h5CreatePayBillBo.setPayType(Integer.valueOf(this.l));
            h5CreatePayBillBo.setOrderId(this.n);
            payBillVo.setCreatePayBillBo(h5CreatePayBillBo);
            this.f2341f.postPayBill(payBillVo);
        }
    }

    public final void D(String str) {
        if (this.f2340e == null || !x.isNotNull(str)) {
            b();
            return;
        }
        this.n = str;
        PayBillVo payBillVo = new PayBillVo();
        payBillVo.setPaymentKey(str);
        payBillVo.setPayChannel(this.l);
        if (this.f2341f == null) {
            this.f2340e.postPayBill(payBillVo);
            return;
        }
        this.o = true;
        H5CreatePayBillBo h5CreatePayBillBo = new H5CreatePayBillBo();
        h5CreatePayBillBo.setPayType(Integer.valueOf(this.l));
        h5CreatePayBillBo.setOrderId(str);
        payBillVo.setCreatePayBillBo(h5CreatePayBillBo);
        this.f2341f.postPayBill(payBillVo);
    }

    public final void E() {
        if (this.f2341f != null) {
            h(R.string.loading_text);
            this.f2341f.getFoodPayData(this.m);
        }
    }

    public final void F() {
        o oVar = this.f2338c;
        if (oVar == null || oVar.getCurrentFragment() == null) {
            return;
        }
        this.f2340e.getFoodDiscountResult().observe(this.f2338c.getCurrentFragment(), new e(this));
        this.f2340e.getFoodOrderResult().observe(this.f2338c.getCurrentFragment(), new Observer() { // from class: c.e.d.y.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2331a.D((String) obj);
            }
        });
        this.f2340e.getFoodResult().observe(this.f2338c.getCurrentFragment(), new b(this));
        this.f2340e.getDiscountListResult().observe(this.f2338c.getCurrentFragment(), new f(this));
    }

    public final void G() {
        if (this.f2345q == null) {
            this.f2345q = new ArrayList();
        }
        o oVar = this.f2338c;
        if (oVar != null) {
            c.b.a.f.b<String> bVarBuild = new c.b.a.b.a(oVar.getCurrentActivity(), new c.b.a.d.e() { // from class: c.e.d.y.a
                @Override // c.b.a.d.e
                public final void onOptionsSelect(int i2, int i3, int i4, View view) {
                    this.f2325a.A(i2, i3, i4, view);
                }
            }).build();
            this.t = bVarBuild;
            bVarBuild.setPicker(this.f2345q);
        }
    }

    public final void H() {
        c.b.a.f.b<String> bVar = this.t;
        if (bVar != null) {
            bVar.show();
        }
    }

    public final void I() {
        h(R.string.loading_text);
        this.j.setText(x.getNotNullStr(this.f2345q.get(this.s), ""));
        this.f2341f.countFoodDiscountPrice(m());
    }

    public final void J(String str) {
        o oVar = this.f2338c;
        if (oVar != null) {
            oVar.updatePayPrice(str);
        }
    }

    @Override // c.e.d.y.l
    public void handlePayFailed() {
        o();
    }

    @Override // c.e.d.y.l
    public void handlePaySuccessResult() {
        o();
    }

    @Override // c.e.d.y.l
    public void initData(BaseVo baseVo) {
        if (baseVo == null) {
            b();
        } else {
            this.m = baseVo.getBaseKey();
            E();
        }
    }

    public final void l(int i2) {
        NewBillModel newBillModel = this.f2341f;
        if (newBillModel != null) {
            String str = this.n;
            if (str == null || !this.o) {
                this.l = i2;
                newBillModel.createFoodPayBill(m());
            } else {
                this.l = i2;
                D(str);
            }
        }
    }

    public final CreateFoodOrderVo m() {
        CreateFoodOrderVo createFoodOrderVo = new CreateFoodOrderVo();
        List<String> list = this.r;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.r.get(this.s));
            createFoodOrderVo.setDiscountKey(arrayList);
        }
        createFoodOrderVo.setToBePurchasedCommoditiesKey(this.m);
        return createFoodOrderVo;
    }

    public final void n(ResponseDiscountVo responseDiscountVo) {
        c();
        c.e.a.d.q.d(m.class.getSimpleName(), "handleDiscountList  discountVoResponseVo:" + responseDiscountVo.getDiscount().size());
        if (responseDiscountVo.getDiscount() == null || responseDiscountVo.getDiscount().isEmpty()) {
            this.j.setVisibility(8);
            return;
        }
        this.j.setVisibility(0);
        List<DiscountVo> discount = responseDiscountVo.getDiscount();
        if (this.f2345q == null) {
            this.f2345q = new ArrayList();
        }
        if (this.r == null) {
            this.r = new ArrayList();
        }
        this.f2345q.clear();
        this.r.clear();
        if (discount == null || discount.isEmpty()) {
            return;
        }
        for (DiscountVo discountVo : discount) {
            if (discountVo != null) {
                this.f2345q.add(discountVo.getName());
                this.r.add(discountVo.getDiscountKey());
            }
        }
        G();
        this.j.setText(x.getNotNullStr(this.f2345q.get(this.s), ""));
        this.f2341f.countFoodDiscountPrice(m());
    }

    public final void o() {
        a(false);
        e(2);
    }

    public final void p(ResponseFoodVo responseFoodVo) {
        ArrayList arrayList = new ArrayList();
        if (responseFoodVo == null) {
            c();
            return;
        }
        List<ResponseFoodVo.CommoditiesBean> rows = responseFoodVo.getRows();
        if (rows != null && !rows.isEmpty()) {
            for (ResponseFoodVo.CommoditiesBean commoditiesBean : rows) {
                if (commoditiesBean != null) {
                    LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
                    leftTitleToRightArrowVo.setLeft(commoditiesBean.getCommodityName());
                    leftTitleToRightArrowVo.setRight(x.bigDecimalToPlainString(commoditiesBean.getPrice()));
                    leftTitleToRightArrowVo.setPrice(true);
                    arrayList.add(leftTitleToRightArrowVo);
                }
            }
        }
        this.p.initListData(arrayList);
        if (arrayList.size() > 2) {
            this.f2343h.getLayoutParams().height = this.f2343h.getResources().getDimensionPixelSize(R.dimen.dp_230);
        }
        String strBigDecimalToPlainString = x.bigDecimalToPlainString(responseFoodVo.getAmount());
        J(strBigDecimalToPlainString);
        TextView textView = this.f2337b;
        int i2 = R.string.payment_lib_placeholder_rmb_china_unit;
        textView.setText(x.appendStringToResId(i2, strBigDecimalToPlainString));
        this.f2344i.setText(x.appendStringToResId(i2, strBigDecimalToPlainString));
        B();
    }

    public final void q(ResponseDiscountResultVo responseDiscountResultVo) {
        if (responseDiscountResultVo != null && responseDiscountResultVo.getDiscountAmount() != null) {
            this.k.setText(x.appendStringToResId(R.string.payment_lib_title_discount_price, x.bigDecimalToPlainString(responseDiscountResultVo.getDiscountAmount())));
            String strBigDecimalToPlainString = x.bigDecimalToPlainString(responseDiscountResultVo.getPayAmount());
            J(strBigDecimalToPlainString);
            this.f2337b.setText(x.appendStringToResId(R.string.payment_lib_placeholder_rmb_china_unit, strBigDecimalToPlainString));
        }
        c();
    }

    public final void r(View view) {
        if (view != null) {
            this.p = new PayProductListAdapter();
            View viewFindViewById = view.findViewById(R.id.view_split_line_discount);
            this.f2344i = (TextView) view.findViewById(R.id.tv_count_pay_price);
            TextView textView = (TextView) view.findViewById(R.id.tv_count_title);
            TextView textView2 = (TextView) view.findViewById(R.id.tv_pay_details_title);
            this.j = (TextView) view.findViewById(R.id.tv_discount_title);
            this.k = (TextView) view.findViewById(R.id.tv_pay_discount_price);
            textView2.setVisibility(0);
            textView.setVisibility(0);
            viewFindViewById.setVisibility(0);
            this.f2344i.setVisibility(0);
            this.k.setVisibility(0);
            this.j.setOnClickListener(this.u);
            BaseRecyclerView baseRecyclerView = (BaseRecyclerView) view.findViewById(R.id.recycler_pay_content);
            this.f2343h = baseRecyclerView;
            baseRecyclerView.setVisibility(0);
            this.f2343h.setAdapter(this.p);
        }
    }

    @Override // c.e.d.y.l
    public void requestGetPaySign(BaseVo baseVo, int i2) {
        if (baseVo != null) {
            l(i2);
        } else {
            b();
        }
    }

    @Override // c.e.d.y.l
    public void setNewBillModel(NewBillModel newBillModel) {
        super.setNewBillModel(newBillModel);
        this.f2341f.getFoodDiscountResult().observe(this.f2338c.getCurrentFragment(), new e(this));
        this.f2341f.getFoodOrderResult().observe(this.f2338c.getCurrentFragment(), new Observer() { // from class: c.e.d.y.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2327a.C((NewResponseStateVo) obj);
            }
        });
        this.f2341f.getFoodResult().observe(this.f2338c.getCurrentFragment(), new b(this));
        this.f2341f.getDiscountListResult().observe(this.f2338c.getCurrentFragment(), new f(this));
    }
}
