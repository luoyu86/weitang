package c.e.c.o.d;

import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.contract.vo.ExitRentFeeConfigVo;
import com.chinavisionary.microtang.contract.vo.RentBackFeePreviewListVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public List<LeftTitleToRightArrowVo> getRentBackList(RentBackFeePreviewListVo rentBackFeePreviewListVo, ExitRentFeeConfigVo exitRentFeeConfigVo) {
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setTitle(x.getString(R.string.tab_title_room_info));
        leftTitleToRightArrowVo.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setLeft(x.getString(R.string.title_exit_rent_room_address));
        leftTitleToRightArrowVo2.setRight(exitRentFeeConfigVo.getRentAddress());
        arrayList.add(leftTitleToRightArrowVo2);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_exit_rent_date));
        leftTitleToRightArrowVo3.setShowArrow(true);
        leftTitleToRightArrowVo3.setOnlyKey(1233);
        leftTitleToRightArrowVo3.setRight(z.getTimeYYMMDD(Long.valueOf(exitRentFeeConfigVo.getExitRentDate())) + a.getExitAdvanceDay(Long.valueOf(exitRentFeeConfigVo.getExitRentDate())));
        arrayList.add(leftTitleToRightArrowVo3);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo4.setTitle(x.getString(R.string.title_cost));
        leftTitleToRightArrowVo4.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo4);
        for (RentBackFeePreviewListVo.RentBackExpensesVo rentBackExpensesVo : rentBackFeePreviewListVo.getExpensesIncurreds()) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo5.setLeft(x.getNotNullStr(rentBackExpensesVo.getExpensesIncurredName(), ""));
            leftTitleToRightArrowVo5.setRight(x.bigDecimalToString(rentBackExpensesVo.getExpensesIncurredAmount()));
            arrayList.add(leftTitleToRightArrowVo5);
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo6 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo6.setTitle(x.getString(R.string.title_exit_cost));
        leftTitleToRightArrowVo6.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo6);
        for (RentBackFeePreviewListVo.RefundVo refundVo : rentBackFeePreviewListVo.getRefunds()) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo7 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo7.setLeft(x.getNotNullStr(refundVo.getRefundName(), ""));
            leftTitleToRightArrowVo7.setRight(x.bigDecimalToString(refundVo.getRefundAmount()));
            arrayList.add(leftTitleToRightArrowVo7);
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo8 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo8.setTitle(x.getString(R.string.title_receive_cost));
        leftTitleToRightArrowVo8.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo8);
        for (RentBackFeePreviewListVo.ReceivableFeeVo receivableFeeVo : rentBackFeePreviewListVo.getReceivables()) {
            LeftTitleToRightArrowVo leftTitleToRightArrowVo9 = new LeftTitleToRightArrowVo();
            leftTitleToRightArrowVo9.setLeft(x.getNotNullStr(receivableFeeVo.getReceivablesName(), ""));
            leftTitleToRightArrowVo9.setRight(x.bigDecimalToString(receivableFeeVo.getReceivablesAmount()));
            arrayList.add(leftTitleToRightArrowVo9);
        }
        LeftTitleToRightArrowVo leftTitleToRightArrowVo10 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo10.setTitle(x.getString(R.string.title_exit_price));
        leftTitleToRightArrowVo10.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo10);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo11 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo11.setLeft(x.getString(R.string.title_exit_price));
        leftTitleToRightArrowVo11.setRight(x.bigDecimalToString(rentBackFeePreviewListVo.getRefundTotalAmount()));
        arrayList.add(leftTitleToRightArrowVo11);
        return arrayList;
    }
}
