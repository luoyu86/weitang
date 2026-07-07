package c.e.d.a0;

import com.chinavisionary.paymentlibrary.vo.PayCouponVo;
import com.chinavisionary.paymentlibrary.vo.ResponseUserCouponResultItemVo;
import com.chinavisionary.paymentlibrary.vo.SelectCouponResultVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    void onSelectCouponResult(List<PayCouponVo> list, List<ResponseUserCouponResultItemVo> list2, SelectCouponResultVo selectCouponResultVo, BigDecimal bigDecimal);
}
