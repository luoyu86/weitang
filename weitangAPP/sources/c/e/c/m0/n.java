package c.e.c.m0;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.microtang.R;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    public class a implements c.b.a.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f1698a;

        public a(View.OnClickListener onClickListener) {
            this.f1698a = onClickListener;
        }

        @Override // c.b.a.d.a
        public void customLayout(View view) {
            ((AppCompatButton) view.findViewById(R.id.btn_confirm_time)).setOnClickListener(this.f1698a);
        }
    }

    public class b implements c.b.a.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f1700a;

        public b(View.OnClickListener onClickListener) {
            this.f1700a = onClickListener;
        }

        @Override // c.b.a.d.a
        public void customLayout(View view) {
            ((AppCompatButton) view.findViewById(R.id.btn_confirm_time)).setOnClickListener(this.f1700a);
        }
    }

    public c.b.a.f.c createTimePickerView(Context context, c.b.a.d.g gVar, View.OnClickListener onClickListener) {
        Long l = 1546272000000L;
        Long currentYearMonthDayToLong = z.getCurrentYearMonthDayToLong();
        Calendar.getInstance().setTimeInMillis(l.longValue());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentYearMonthDayToLong.longValue());
        c.b.a.f.c timePickerView = getTimePickerView(context, l, currentYearMonthDayToLong, gVar, onClickListener);
        timePickerView.setDate(calendar);
        return timePickerView;
    }

    public c.b.a.f.c createYMDTimePickerView(Context context, c.b.a.d.g gVar, View.OnClickListener onClickListener) {
        Long l = 1546272000000L;
        Long currentYearMonthDayToLong = z.getCurrentYearMonthDayToLong();
        Calendar.getInstance().setTimeInMillis(l.longValue());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentYearMonthDayToLong.longValue());
        c.b.a.f.c timePickerView = getTimePickerView(context, l, currentYearMonthDayToLong, gVar, onClickListener);
        timePickerView.setDate(calendar);
        return timePickerView;
    }

    public Calendar getSelectDate(Long l) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        return calendar;
    }

    public c.b.a.f.c getTimePickerView(Context context, Long l, Long l2, c.b.a.d.g gVar, View.OnClickListener onClickListener) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(l2.longValue());
        return new c.b.a.b.b(context, gVar).setLayoutRes(R.layout.item_custom_time_picker_layout, new a(onClickListener)).setType(new boolean[]{true, true, true, true, true, false}).setLabel(x.getString(R.string.title_unit_year), x.getString(R.string.title_unit_month), x.getString(R.string.title_unit_day), x.getString(R.string.title_unit_hour), x.getString(R.string.title_unit_min), "").setDividerColor(-12303292).setContentTextSize(20).setDate(calendar).setRangDate(calendar, calendar2).isDialog(false).setOutSideColor(0).setOutSideCancelable(true).build();
    }

    public c.b.a.f.c getTimePickerViewYMD(Context context, Long l, Long l2, c.b.a.d.g gVar, View.OnClickListener onClickListener) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l.longValue());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(l2.longValue());
        return new c.b.a.b.b(context, gVar).setLayoutRes(R.layout.item_custom_time_picker_layout, new b(onClickListener)).setType(new boolean[]{true, true, true, false, false, false}).setLabel(x.getString(R.string.title_unit_year), x.getString(R.string.title_unit_month), x.getString(R.string.title_unit_day), "", "", "").setDividerColor(-12303292).setContentTextSize(20).setDate(calendar).setRangDate(calendar, calendar2).isDialog(false).setOutSideColor(0).setOutSideCancelable(true).build();
    }
}
