package c.e.c.o.d;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import c.b.a.d.f;
import c.b.a.d.g;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.contract.vo.ContractExitRentVo;
import com.chinavisionary.microtang.contract.vo.ExitRentVo;
import com.chinavisionary.microtang.contract.vo.RequestExitRentVo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f1784a;

    /* JADX INFO: renamed from: c.e.c.o.d.a$a, reason: collision with other inner class name */
    public class C0029a implements f {
        public C0029a() {
        }

        @Override // c.b.a.d.f
        public void onTimeSelectChanged(Date date) {
            a.this.d(Long.valueOf(date.getTime()));
        }
    }

    public class b implements c.b.a.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Long f1786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f1787b;

        public b(Long l, View.OnClickListener onClickListener) {
            this.f1786a = l;
            this.f1787b = onClickListener;
        }

        @Override // c.b.a.d.a
        public void customLayout(View view) {
            TextView textView = (TextView) view.findViewById(R.id.tv_title_look_room);
            a.this.f1784a = (TextView) view.findViewById(R.id.tv_look_room_surplus_time);
            a.this.f1784a.setVisibility(0);
            a.this.d(this.f1786a);
            textView.setText(R.string.title_exit_rent_time);
            ((Button) view.findViewById(R.id.btn_confirm_time)).setOnClickListener(this.f1787b);
        }
    }

    public static String getExitAdvanceDay(Long l) {
        if (l == null) {
            return "";
        }
        Date date = new Date();
        date.setTime(z.getCurrentYearMonthDayToLong().longValue());
        return x.getString(R.string.placeholder_advance_exit_day, Integer.valueOf(z.daysBetween(date, new Date(l.longValue()))));
    }

    public final void d(Long l) {
        TextView textView = this.f1784a;
        if (textView != null) {
            textView.setText(getExitAdvanceDay(l));
        }
    }

    public LeftTitleToRightArrowVo getExitRentFeeItem() {
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setLeft(x.getString(R.string.title_exit_rent_fee));
        leftTitleToRightArrowVo.setRight(x.getString(R.string.title_cat_exit_rent_fee));
        leftTitleToRightArrowVo.setOnlyKey(17);
        leftTitleToRightArrowVo.setShowArrow(true);
        return leftTitleToRightArrowVo;
    }

    public RequestExitRentVo getExitRentVo(List<LeftTitleToRightArrowVo> list) {
        RequestExitRentVo requestExitRentVo = new RequestExitRentVo();
        ArrayList arrayList = new ArrayList();
        String str = null;
        for (LeftTitleToRightArrowVo leftTitleToRightArrowVo : list) {
            if (leftTitleToRightArrowVo != null && 12333 == leftTitleToRightArrowVo.getType()) {
                ExitRentVo exitRentVo = (ExitRentVo) leftTitleToRightArrowVo.getExtObj();
                String reason = exitRentVo.getReason();
                List<ExitRentVo.ExitRentTag> tags = exitRentVo.getTags();
                if (tags != null && !tags.isEmpty()) {
                    for (ExitRentVo.ExitRentTag exitRentTag : tags) {
                        if (exitRentTag != null && exitRentTag.isSelect()) {
                            arrayList.add(exitRentTag.getTagKey());
                        }
                    }
                }
                str = reason;
            }
        }
        requestExitRentVo.setRentBackTagKeys(arrayList);
        requestExitRentVo.setOtherReason(str);
        return requestExitRentVo;
    }

    public List<LeftTitleToRightArrowVo> getListData(ContractExitRentVo contractExitRentVo) {
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setLeft(x.getString(R.string.title_exit_rent_room_address));
        leftTitleToRightArrowVo.setRight(contractExitRentVo.getAddress());
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setTitle(x.getString(R.string.title_sign_main_info));
        leftTitleToRightArrowVo2.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo2);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_user_name));
        leftTitleToRightArrowVo3.setRight(x.getNameMask(contractExitRentVo.getSignUserName()));
        arrayList.add(leftTitleToRightArrowVo3);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo4.setLeft(x.getString(R.string.title_card_type));
        leftTitleToRightArrowVo4.setRight(contractExitRentVo.getCardType());
        arrayList.add(leftTitleToRightArrowVo4);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo5.setLeft(x.getString(R.string.title_id_card_no));
        leftTitleToRightArrowVo5.setRight(x.getIDNoMask(contractExitRentVo.getCardNo()));
        arrayList.add(leftTitleToRightArrowVo5);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo6 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo6.setLeft(x.getString(R.string.title_phone_no));
        leftTitleToRightArrowVo6.setRight(x.getPhoneMask(contractExitRentVo.getSignUserPhone()));
        arrayList.add(leftTitleToRightArrowVo6);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo7 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo7.setTitle(x.getString(R.string.title_apply_exit_rent_info));
        leftTitleToRightArrowVo7.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo7);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo8 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo8.setLeft(x.getString(R.string.title_apply_date));
        leftTitleToRightArrowVo8.setRight(z.getTimeYYMMDD(contractExitRentVo.getRentBackApplyDate()));
        arrayList.add(leftTitleToRightArrowVo8);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo9 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo9.setLeft(x.getString(R.string.title_exit_rent_date));
        leftTitleToRightArrowVo9.setRight(x.getString(R.string.title_exit_rent_time));
        leftTitleToRightArrowVo9.setShowArrow(true);
        leftTitleToRightArrowVo9.setRequired(true);
        leftTitleToRightArrowVo9.setOnlyKey(1233);
        arrayList.add(leftTitleToRightArrowVo9);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo10 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo10.setType(12333);
        leftTitleToRightArrowVo9.setRequired(true);
        ExitRentVo exitRentVo = new ExitRentVo();
        exitRentVo.setTags(contractExitRentVo.getRentBackTags());
        leftTitleToRightArrowVo10.setExtObj(exitRentVo);
        arrayList.add(leftTitleToRightArrowVo10);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo11 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo11.setTitle(x.getString(R.string.title_exit_rent_bank_info));
        leftTitleToRightArrowVo11.setTitle(true);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo12 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo12.setLeft(x.getString(R.string.title_bank_account));
        leftTitleToRightArrowVo12.setOnlyKey(3);
        leftTitleToRightArrowVo12.setEdit(true);
        leftTitleToRightArrowVo12.setRequired(true);
        leftTitleToRightArrowVo12.setHint(x.getString(R.string.title_hint_input_bank_accoun));
        leftTitleToRightArrowVo12.setInputType(2);
        leftTitleToRightArrowVo12.setShowArrow(true);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo13 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo13.setLeft(x.getString(R.string.title_exit_bank));
        leftTitleToRightArrowVo13.setHint(x.getString(R.string.title_hint_input_bank_name));
        leftTitleToRightArrowVo13.setOnlyKey(2);
        leftTitleToRightArrowVo13.setEdit(true);
        leftTitleToRightArrowVo13.setRequired(true);
        leftTitleToRightArrowVo13.setShowArrow(true);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo14 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo14.setLeft("");
        leftTitleToRightArrowVo14.setRight(x.getString(R.string.title_cat_exit_rent_info));
        leftTitleToRightArrowVo14.setShowArrow(true);
        leftTitleToRightArrowVo14.setOnlyKey(12);
        arrayList.add(leftTitleToRightArrowVo14);
        return arrayList;
    }

    public Calendar getSelectDate(Long l) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        d(l);
        return calendar;
    }

    public c.b.a.f.c getTimePickerView(Context context, Long l, Long l2, g gVar, View.OnClickListener onClickListener) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(l2.longValue());
        return new c.b.a.b.b(context, gVar).setLayoutRes(R.layout.item_custom_time_picker_layout, new b(l, onClickListener)).setTimeSelectChangeListener(new C0029a()).setType(new boolean[]{true, true, true, false, false, false}).setLabel(x.getString(R.string.title_unit_year), x.getString(R.string.title_unit_month), x.getString(R.string.title_unit_day), "", "", "").setDividerColor(-12303292).setContentTextSize(20).setDate(calendar).setRangDate(calendar, calendar2).isDialog(true).setOutSideColor(0).setOutSideCancelable(true).build();
    }
}
