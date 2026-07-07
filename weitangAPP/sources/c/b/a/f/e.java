package c.b.a.f;

import android.view.View;
import com.bigkoo.pickerview.R;
import com.bytedance.pangle.ZeusPluginEventCallback;
import com.contrarywind.view.WheelView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DateFormat f895a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WheelView f897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WheelView f898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WheelView f899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WheelView f900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WheelView f901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WheelView f902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f903i;
    public boolean[] j;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f904q;
    public int r;
    public int s;
    public int t;
    public int u;
    public float v;
    public WheelView.c w;
    public c.b.a.d.b y;
    public int k = 1900;
    public int l = ZeusPluginEventCallback.EVENT_FINISH_LOAD;
    public int m = 1;
    public int n = 12;
    public int o = 1;
    public int p = 31;
    public boolean x = false;

    public class a implements c.f.c.b {
        public a() {
        }

        @Override // c.f.c.b
        public void onItemSelected(int i2) {
            int iMonthDays;
            int i3 = i2 + e.this.k;
            e.this.f898d.setAdapter(new c.b.a.a.a(c.b.a.e.a.getMonths(i3)));
            if (c.b.a.e.a.leapMonth(i3) == 0 || e.this.f898d.getCurrentItem() <= c.b.a.e.a.leapMonth(i3) - 1) {
                e.this.f898d.setCurrentItem(e.this.f898d.getCurrentItem());
            } else {
                e.this.f898d.setCurrentItem(e.this.f898d.getCurrentItem() + 1);
            }
            if (c.b.a.e.a.leapMonth(i3) == 0 || e.this.f898d.getCurrentItem() <= c.b.a.e.a.leapMonth(i3) - 1) {
                e.this.f899e.setAdapter(new c.b.a.a.a(c.b.a.e.a.getLunarDays(c.b.a.e.a.monthDays(i3, e.this.f898d.getCurrentItem() + 1))));
                iMonthDays = c.b.a.e.a.monthDays(i3, e.this.f898d.getCurrentItem() + 1);
            } else if (e.this.f898d.getCurrentItem() == c.b.a.e.a.leapMonth(i3) + 1) {
                e.this.f899e.setAdapter(new c.b.a.a.a(c.b.a.e.a.getLunarDays(c.b.a.e.a.leapDays(i3))));
                iMonthDays = c.b.a.e.a.leapDays(i3);
            } else {
                e.this.f899e.setAdapter(new c.b.a.a.a(c.b.a.e.a.getLunarDays(c.b.a.e.a.monthDays(i3, e.this.f898d.getCurrentItem()))));
                iMonthDays = c.b.a.e.a.monthDays(i3, e.this.f898d.getCurrentItem());
            }
            int i4 = iMonthDays - 1;
            if (e.this.f899e.getCurrentItem() > i4) {
                e.this.f899e.setCurrentItem(i4);
            }
            if (e.this.y != null) {
                e.this.y.onTimeSelectChanged();
            }
        }
    }

    public class b implements c.f.c.b {
        public b() {
        }

        @Override // c.f.c.b
        public void onItemSelected(int i2) {
            int iMonthDays;
            int currentItem = e.this.f897c.getCurrentItem() + e.this.k;
            if (c.b.a.e.a.leapMonth(currentItem) == 0 || i2 <= c.b.a.e.a.leapMonth(currentItem) - 1) {
                int i3 = i2 + 1;
                e.this.f899e.setAdapter(new c.b.a.a.a(c.b.a.e.a.getLunarDays(c.b.a.e.a.monthDays(currentItem, i3))));
                iMonthDays = c.b.a.e.a.monthDays(currentItem, i3);
            } else if (e.this.f898d.getCurrentItem() == c.b.a.e.a.leapMonth(currentItem) + 1) {
                e.this.f899e.setAdapter(new c.b.a.a.a(c.b.a.e.a.getLunarDays(c.b.a.e.a.leapDays(currentItem))));
                iMonthDays = c.b.a.e.a.leapDays(currentItem);
            } else {
                e.this.f899e.setAdapter(new c.b.a.a.a(c.b.a.e.a.getLunarDays(c.b.a.e.a.monthDays(currentItem, i2))));
                iMonthDays = c.b.a.e.a.monthDays(currentItem, i2);
            }
            int i4 = iMonthDays - 1;
            if (e.this.f899e.getCurrentItem() > i4) {
                e.this.f899e.setCurrentItem(i4);
            }
            if (e.this.y != null) {
                e.this.y.onTimeSelectChanged();
            }
        }
    }

    public class c implements c.f.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f908b;

        public c(List list, List list2) {
            this.f907a = list;
            this.f908b = list2;
        }

        @Override // c.f.c.b
        public void onItemSelected(int i2) {
            int i3 = i2 + e.this.k;
            e.this.f904q = i3;
            int currentItem = e.this.f898d.getCurrentItem();
            if (e.this.k == e.this.l) {
                e.this.f898d.setAdapter(new c.b.a.a.b(e.this.m, e.this.n));
                if (currentItem > e.this.f898d.getAdapter().getItemsCount() - 1) {
                    currentItem = e.this.f898d.getAdapter().getItemsCount() - 1;
                    e.this.f898d.setCurrentItem(currentItem);
                }
                int i4 = currentItem + e.this.m;
                if (e.this.m == e.this.n) {
                    e eVar = e.this;
                    eVar.u(i3, i4, eVar.o, e.this.p, this.f907a, this.f908b);
                } else if (i4 == e.this.m) {
                    e eVar2 = e.this;
                    eVar2.u(i3, i4, eVar2.o, 31, this.f907a, this.f908b);
                } else if (i4 == e.this.n) {
                    e eVar3 = e.this;
                    eVar3.u(i3, i4, 1, eVar3.p, this.f907a, this.f908b);
                } else {
                    e.this.u(i3, i4, 1, 31, this.f907a, this.f908b);
                }
            } else if (i3 == e.this.k) {
                e.this.f898d.setAdapter(new c.b.a.a.b(e.this.m, 12));
                if (currentItem > e.this.f898d.getAdapter().getItemsCount() - 1) {
                    currentItem = e.this.f898d.getAdapter().getItemsCount() - 1;
                    e.this.f898d.setCurrentItem(currentItem);
                }
                int i5 = currentItem + e.this.m;
                if (i5 == e.this.m) {
                    e eVar4 = e.this;
                    eVar4.u(i3, i5, eVar4.o, 31, this.f907a, this.f908b);
                } else {
                    e.this.u(i3, i5, 1, 31, this.f907a, this.f908b);
                }
            } else if (i3 == e.this.l) {
                e.this.f898d.setAdapter(new c.b.a.a.b(1, e.this.n));
                if (currentItem > e.this.f898d.getAdapter().getItemsCount() - 1) {
                    currentItem = e.this.f898d.getAdapter().getItemsCount() - 1;
                    e.this.f898d.setCurrentItem(currentItem);
                }
                int i6 = 1 + currentItem;
                if (i6 == e.this.n) {
                    e eVar5 = e.this;
                    eVar5.u(i3, i6, 1, eVar5.p, this.f907a, this.f908b);
                } else {
                    e.this.u(i3, i6, 1, 31, this.f907a, this.f908b);
                }
            } else {
                e.this.f898d.setAdapter(new c.b.a.a.b(1, 12));
                e eVar6 = e.this;
                eVar6.u(i3, 1 + eVar6.f898d.getCurrentItem(), 1, 31, this.f907a, this.f908b);
            }
            if (e.this.y != null) {
                e.this.y.onTimeSelectChanged();
            }
        }
    }

    public class d implements c.f.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f911b;

        public d(List list, List list2) {
            this.f910a = list;
            this.f911b = list2;
        }

        @Override // c.f.c.b
        public void onItemSelected(int i2) {
            int i3 = i2 + 1;
            if (e.this.k == e.this.l) {
                int i4 = (i3 + e.this.m) - 1;
                if (e.this.m == e.this.n) {
                    e eVar = e.this;
                    eVar.u(eVar.f904q, i4, e.this.o, e.this.p, this.f910a, this.f911b);
                } else if (e.this.m == i4) {
                    e eVar2 = e.this;
                    eVar2.u(eVar2.f904q, i4, e.this.o, 31, this.f910a, this.f911b);
                } else if (e.this.n == i4) {
                    e eVar3 = e.this;
                    eVar3.u(eVar3.f904q, i4, 1, e.this.p, this.f910a, this.f911b);
                } else {
                    e eVar4 = e.this;
                    eVar4.u(eVar4.f904q, i4, 1, 31, this.f910a, this.f911b);
                }
            } else if (e.this.f904q == e.this.k) {
                int i5 = (i3 + e.this.m) - 1;
                if (i5 == e.this.m) {
                    e eVar5 = e.this;
                    eVar5.u(eVar5.f904q, i5, e.this.o, 31, this.f910a, this.f911b);
                } else {
                    e eVar6 = e.this;
                    eVar6.u(eVar6.f904q, i5, 1, 31, this.f910a, this.f911b);
                }
            } else if (e.this.f904q != e.this.l) {
                e eVar7 = e.this;
                eVar7.u(eVar7.f904q, i3, 1, 31, this.f910a, this.f911b);
            } else if (i3 == e.this.n) {
                e eVar8 = e.this;
                eVar8.u(eVar8.f904q, e.this.f898d.getCurrentItem() + 1, 1, e.this.p, this.f910a, this.f911b);
            } else {
                e eVar9 = e.this;
                eVar9.u(eVar9.f904q, e.this.f898d.getCurrentItem() + 1, 1, 31, this.f910a, this.f911b);
            }
            if (e.this.y != null) {
                e.this.y.onTimeSelectChanged();
            }
        }
    }

    /* JADX INFO: renamed from: c.b.a.f.e$e, reason: collision with other inner class name */
    public class C0012e implements c.f.c.b {
        public C0012e() {
        }

        @Override // c.f.c.b
        public void onItemSelected(int i2) {
            e.this.y.onTimeSelectChanged();
        }
    }

    public e(View view, boolean[] zArr, int i2, int i3) {
        this.f896b = view;
        this.j = zArr;
        this.f903i = i2;
        this.r = i3;
    }

    public int getEndYear() {
        return this.l;
    }

    public int getStartYear() {
        return this.k;
    }

    public String getTime() {
        if (this.x) {
            return n();
        }
        StringBuilder sb = new StringBuilder();
        if (this.f904q == this.k) {
            int currentItem = this.f898d.getCurrentItem();
            int i2 = this.m;
            if (currentItem + i2 == i2) {
                sb.append(this.f897c.getCurrentItem() + this.k);
                sb.append("-");
                sb.append(this.f898d.getCurrentItem() + this.m);
                sb.append("-");
                sb.append(this.f899e.getCurrentItem() + this.o);
                sb.append(" ");
                sb.append(this.f900f.getCurrentItem());
                sb.append(":");
                sb.append(this.f901g.getCurrentItem());
                sb.append(":");
                sb.append(this.f902h.getCurrentItem());
            } else {
                sb.append(this.f897c.getCurrentItem() + this.k);
                sb.append("-");
                sb.append(this.f898d.getCurrentItem() + this.m);
                sb.append("-");
                sb.append(this.f899e.getCurrentItem() + 1);
                sb.append(" ");
                sb.append(this.f900f.getCurrentItem());
                sb.append(":");
                sb.append(this.f901g.getCurrentItem());
                sb.append(":");
                sb.append(this.f902h.getCurrentItem());
            }
        } else {
            sb.append(this.f897c.getCurrentItem() + this.k);
            sb.append("-");
            sb.append(this.f898d.getCurrentItem() + 1);
            sb.append("-");
            sb.append(this.f899e.getCurrentItem() + 1);
            sb.append(" ");
            sb.append(this.f900f.getCurrentItem());
            sb.append(":");
            sb.append(this.f901g.getCurrentItem());
            sb.append(":");
            sb.append(this.f902h.getCurrentItem());
        }
        return sb.toString();
    }

    public View getView() {
        return this.f896b;
    }

    public void isCenterLabel(boolean z) {
        this.f899e.isCenterLabel(z);
        this.f898d.isCenterLabel(z);
        this.f897c.isCenterLabel(z);
        this.f900f.isCenterLabel(z);
        this.f901g.isCenterLabel(z);
        this.f902h.isCenterLabel(z);
    }

    public boolean isLunarMode() {
        return this.x;
    }

    public final String n() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.f897c.getCurrentItem() + this.k;
        if (c.b.a.e.a.leapMonth(currentItem2) == 0 || (this.f898d.getCurrentItem() + 1) - c.b.a.e.a.leapMonth(currentItem2) <= 0) {
            int currentItem3 = this.f898d.getCurrentItem();
            currentItem = currentItem3 + 1;
            z = false;
            int[] iArrLunarToSolar = c.b.a.e.b.lunarToSolar(currentItem2, currentItem, this.f899e.getCurrentItem() + 1, z);
            sb.append(iArrLunarToSolar[0]);
            sb.append("-");
            sb.append(iArrLunarToSolar[1]);
            sb.append("-");
            sb.append(iArrLunarToSolar[2]);
            sb.append(" ");
            sb.append(this.f900f.getCurrentItem());
            sb.append(":");
            sb.append(this.f901g.getCurrentItem());
            sb.append(":");
            sb.append(this.f902h.getCurrentItem());
            return sb.toString();
        }
        if ((this.f898d.getCurrentItem() + 1) - c.b.a.e.a.leapMonth(currentItem2) == 1) {
            currentItem = this.f898d.getCurrentItem();
            z = true;
            int[] iArrLunarToSolar2 = c.b.a.e.b.lunarToSolar(currentItem2, currentItem, this.f899e.getCurrentItem() + 1, z);
            sb.append(iArrLunarToSolar2[0]);
            sb.append("-");
            sb.append(iArrLunarToSolar2[1]);
            sb.append("-");
            sb.append(iArrLunarToSolar2[2]);
            sb.append(" ");
            sb.append(this.f900f.getCurrentItem());
            sb.append(":");
            sb.append(this.f901g.getCurrentItem());
            sb.append(":");
            sb.append(this.f902h.getCurrentItem());
            return sb.toString();
        }
        currentItem = this.f898d.getCurrentItem();
        z = false;
        int[] iArrLunarToSolar22 = c.b.a.e.b.lunarToSolar(currentItem2, currentItem, this.f899e.getCurrentItem() + 1, z);
        sb.append(iArrLunarToSolar22[0]);
        sb.append("-");
        sb.append(iArrLunarToSolar22[1]);
        sb.append("-");
        sb.append(iArrLunarToSolar22[2]);
        sb.append(" ");
        sb.append(this.f900f.getCurrentItem());
        sb.append(":");
        sb.append(this.f901g.getCurrentItem());
        sb.append(":");
        sb.append(this.f902h.getCurrentItem());
        return sb.toString();
    }

    public final void o(WheelView wheelView) {
        if (this.y != null) {
            wheelView.setOnItemSelectedListener(new C0012e());
        }
    }

    public final void p() {
        this.f899e.setTextSize(this.r);
        this.f898d.setTextSize(this.r);
        this.f897c.setTextSize(this.r);
        this.f900f.setTextSize(this.r);
        this.f901g.setTextSize(this.r);
        this.f902h.setTextSize(this.r);
    }

    public final void q() {
        this.f899e.setDividerColor(this.u);
        this.f898d.setDividerColor(this.u);
        this.f897c.setDividerColor(this.u);
        this.f900f.setDividerColor(this.u);
        this.f901g.setDividerColor(this.u);
        this.f902h.setDividerColor(this.u);
    }

    public final void r() {
        this.f899e.setDividerType(this.w);
        this.f898d.setDividerType(this.w);
        this.f897c.setDividerType(this.w);
        this.f900f.setDividerType(this.w);
        this.f901g.setDividerType(this.w);
        this.f902h.setDividerType(this.w);
    }

    public final void s() {
        this.f899e.setLineSpacingMultiplier(this.v);
        this.f898d.setLineSpacingMultiplier(this.v);
        this.f897c.setLineSpacingMultiplier(this.v);
        this.f900f.setLineSpacingMultiplier(this.v);
        this.f901g.setLineSpacingMultiplier(this.v);
        this.f902h.setLineSpacingMultiplier(this.v);
    }

    public void setCyclic(boolean z) {
        this.f897c.setCyclic(z);
        this.f898d.setCyclic(z);
        this.f899e.setCyclic(z);
        this.f900f.setCyclic(z);
        this.f901g.setCyclic(z);
        this.f902h.setCyclic(z);
    }

    public void setDividerColor(int i2) {
        this.u = i2;
        q();
    }

    public void setDividerType(WheelView.c cVar) {
        this.w = cVar;
        r();
    }

    public void setEndYear(int i2) {
        this.l = i2;
    }

    public void setLabels(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.x) {
            return;
        }
        if (str != null) {
            this.f897c.setLabel(str);
        } else {
            this.f897c.setLabel(this.f896b.getContext().getString(R.string.pickerview_year));
        }
        if (str2 != null) {
            this.f898d.setLabel(str2);
        } else {
            this.f898d.setLabel(this.f896b.getContext().getString(R.string.pickerview_month));
        }
        if (str3 != null) {
            this.f899e.setLabel(str3);
        } else {
            this.f899e.setLabel(this.f896b.getContext().getString(R.string.pickerview_day));
        }
        if (str4 != null) {
            this.f900f.setLabel(str4);
        } else {
            this.f900f.setLabel(this.f896b.getContext().getString(R.string.pickerview_hours));
        }
        if (str5 != null) {
            this.f901g.setLabel(str5);
        } else {
            this.f901g.setLabel(this.f896b.getContext().getString(R.string.pickerview_minutes));
        }
        if (str6 != null) {
            this.f902h.setLabel(str6);
        } else {
            this.f902h.setLabel(this.f896b.getContext().getString(R.string.pickerview_seconds));
        }
    }

    public void setLineSpacingMultiplier(float f2) {
        this.v = f2;
        s();
    }

    public void setLunarMode(boolean z) {
        this.x = z;
    }

    public void setPicker(int i2, int i3, int i4) {
        setPicker(i2, i3, i4, 0, 0, 0);
    }

    public void setRangDate(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i2 = calendar2.get(1);
            int i3 = calendar2.get(2) + 1;
            int i4 = calendar2.get(5);
            int i5 = this.k;
            if (i2 > i5) {
                this.l = i2;
                this.n = i3;
                this.p = i4;
                return;
            } else {
                if (i2 == i5) {
                    int i6 = this.m;
                    if (i3 > i6) {
                        this.l = i2;
                        this.n = i3;
                        this.p = i4;
                        return;
                    } else {
                        if (i3 != i6 || i4 <= this.o) {
                            return;
                        }
                        this.l = i2;
                        this.n = i3;
                        this.p = i4;
                        return;
                    }
                }
                return;
            }
        }
        if (calendar == null || calendar2 != null) {
            if (calendar == null || calendar2 == null) {
                return;
            }
            this.k = calendar.get(1);
            this.l = calendar2.get(1);
            this.m = calendar.get(2) + 1;
            this.n = calendar2.get(2) + 1;
            this.o = calendar.get(5);
            this.p = calendar2.get(5);
            return;
        }
        int i7 = calendar.get(1);
        int i8 = calendar.get(2) + 1;
        int i9 = calendar.get(5);
        int i10 = this.l;
        if (i7 < i10) {
            this.m = i8;
            this.o = i9;
            this.k = i7;
        } else if (i7 == i10) {
            int i11 = this.n;
            if (i8 < i11) {
                this.m = i8;
                this.o = i9;
                this.k = i7;
            } else {
                if (i8 != i11 || i9 >= this.p) {
                    return;
                }
                this.m = i8;
                this.o = i9;
                this.k = i7;
            }
        }
    }

    public void setSelectChangeCallback(c.b.a.d.b bVar) {
        this.y = bVar;
    }

    public void setStartYear(int i2) {
        this.k = i2;
    }

    public void setTextColorCenter(int i2) {
        this.t = i2;
        w();
    }

    public void setTextColorOut(int i2) {
        this.s = i2;
        x();
    }

    public void setTextXOffset(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f897c.setTextXOffset(i2);
        this.f898d.setTextXOffset(i3);
        this.f899e.setTextXOffset(i4);
        this.f900f.setTextXOffset(i5);
        this.f901g.setTextXOffset(i6);
        this.f902h.setTextXOffset(i7);
    }

    public final void t(int i2, int i3, int i4, boolean z, int i5, int i6, int i7) {
        WheelView wheelView = (WheelView) this.f896b.findViewById(R.id.year);
        this.f897c = wheelView;
        wheelView.setAdapter(new c.b.a.a.a(c.b.a.e.a.getYears(this.k, this.l)));
        this.f897c.setLabel("");
        this.f897c.setCurrentItem(i2 - this.k);
        this.f897c.setGravity(this.f903i);
        WheelView wheelView2 = (WheelView) this.f896b.findViewById(R.id.month);
        this.f898d = wheelView2;
        wheelView2.setAdapter(new c.b.a.a.a(c.b.a.e.a.getMonths(i2)));
        this.f898d.setLabel("");
        int iLeapMonth = c.b.a.e.a.leapMonth(i2);
        if (iLeapMonth == 0 || (i3 <= iLeapMonth - 1 && !z)) {
            this.f898d.setCurrentItem(i3);
        } else {
            this.f898d.setCurrentItem(i3 + 1);
        }
        this.f898d.setGravity(this.f903i);
        this.f899e = (WheelView) this.f896b.findViewById(R.id.day);
        if (c.b.a.e.a.leapMonth(i2) == 0) {
            this.f899e.setAdapter(new c.b.a.a.a(c.b.a.e.a.getLunarDays(c.b.a.e.a.monthDays(i2, i3))));
        } else {
            this.f899e.setAdapter(new c.b.a.a.a(c.b.a.e.a.getLunarDays(c.b.a.e.a.leapDays(i2))));
        }
        this.f899e.setLabel("");
        this.f899e.setCurrentItem(i4 - 1);
        this.f899e.setGravity(this.f903i);
        WheelView wheelView3 = (WheelView) this.f896b.findViewById(R.id.hour);
        this.f900f = wheelView3;
        wheelView3.setAdapter(new c.b.a.a.b(0, 23));
        this.f900f.setCurrentItem(i5);
        this.f900f.setGravity(this.f903i);
        WheelView wheelView4 = (WheelView) this.f896b.findViewById(R.id.min);
        this.f901g = wheelView4;
        wheelView4.setAdapter(new c.b.a.a.b(0, 59));
        this.f901g.setCurrentItem(i6);
        this.f901g.setGravity(this.f903i);
        WheelView wheelView5 = (WheelView) this.f896b.findViewById(R.id.second);
        this.f902h = wheelView5;
        wheelView5.setAdapter(new c.b.a.a.b(0, 59));
        this.f902h.setCurrentItem(i6);
        this.f902h.setGravity(this.f903i);
        this.f897c.setOnItemSelectedListener(new a());
        this.f898d.setOnItemSelectedListener(new b());
        o(this.f899e);
        o(this.f900f);
        o(this.f901g);
        o(this.f902h);
        boolean[] zArr = this.j;
        if (zArr.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.f897c.setVisibility(zArr[0] ? 0 : 8);
        this.f898d.setVisibility(this.j[1] ? 0 : 8);
        this.f899e.setVisibility(this.j[2] ? 0 : 8);
        this.f900f.setVisibility(this.j[3] ? 0 : 8);
        this.f901g.setVisibility(this.j[4] ? 0 : 8);
        this.f902h.setVisibility(this.j[5] ? 0 : 8);
        p();
    }

    public final void u(int i2, int i3, int i4, int i5, List<String> list, List<String> list2) {
        int currentItem = this.f899e.getCurrentItem();
        if (list.contains(String.valueOf(i3))) {
            if (i5 > 31) {
                i5 = 31;
            }
            this.f899e.setAdapter(new c.b.a.a.b(i4, i5));
        } else if (list2.contains(String.valueOf(i3))) {
            if (i5 > 30) {
                i5 = 30;
            }
            this.f899e.setAdapter(new c.b.a.a.b(i4, i5));
        } else if ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) {
            if (i5 > 28) {
                i5 = 28;
            }
            this.f899e.setAdapter(new c.b.a.a.b(i4, i5));
        } else {
            if (i5 > 29) {
                i5 = 29;
            }
            this.f899e.setAdapter(new c.b.a.a.b(i4, i5));
        }
        if (currentItem > this.f899e.getAdapter().getItemsCount() - 1) {
            this.f899e.setCurrentItem(this.f899e.getAdapter().getItemsCount() - 1);
        }
    }

    public final void v(int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        String[] strArr = {"1", "3", "5", "7", MessageService.MSG_ACCS_NOTIFY_CLICK, AgooConstants.ACK_REMOVE_PACKAGE, AgooConstants.ACK_PACK_NULL};
        String[] strArr2 = {MessageService.MSG_ACCS_READY_REPORT, "6", MessageService.MSG_ACCS_NOTIFY_DISMISS, AgooConstants.ACK_BODY_NULL};
        List listAsList = Arrays.asList(strArr);
        List listAsList2 = Arrays.asList(strArr2);
        this.f904q = i2;
        WheelView wheelView = (WheelView) this.f896b.findViewById(R.id.year);
        this.f897c = wheelView;
        wheelView.setAdapter(new c.b.a.a.b(this.k, this.l));
        this.f897c.setCurrentItem(i2 - this.k);
        this.f897c.setGravity(this.f903i);
        WheelView wheelView2 = (WheelView) this.f896b.findViewById(R.id.month);
        this.f898d = wheelView2;
        int i10 = this.k;
        int i11 = this.l;
        if (i10 == i11) {
            wheelView2.setAdapter(new c.b.a.a.b(this.m, this.n));
            this.f898d.setCurrentItem((i3 + 1) - this.m);
        } else if (i2 == i10) {
            wheelView2.setAdapter(new c.b.a.a.b(this.m, 12));
            this.f898d.setCurrentItem((i3 + 1) - this.m);
        } else if (i2 == i11) {
            wheelView2.setAdapter(new c.b.a.a.b(1, this.n));
            this.f898d.setCurrentItem(i3);
        } else {
            wheelView2.setAdapter(new c.b.a.a.b(1, 12));
            this.f898d.setCurrentItem(i3);
        }
        this.f898d.setGravity(this.f903i);
        this.f899e = (WheelView) this.f896b.findViewById(R.id.day);
        int i12 = this.k;
        int i13 = this.l;
        if (i12 == i13 && this.m == this.n) {
            int i14 = i3 + 1;
            if (listAsList.contains(String.valueOf(i14))) {
                if (this.p > 31) {
                    this.p = 31;
                }
                this.f899e.setAdapter(new c.b.a.a.b(this.o, this.p));
            } else if (listAsList2.contains(String.valueOf(i14))) {
                if (this.p > 30) {
                    this.p = 30;
                }
                this.f899e.setAdapter(new c.b.a.a.b(this.o, this.p));
            } else if ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) {
                if (this.p > 28) {
                    this.p = 28;
                }
                this.f899e.setAdapter(new c.b.a.a.b(this.o, this.p));
            } else {
                if (this.p > 29) {
                    this.p = 29;
                }
                this.f899e.setAdapter(new c.b.a.a.b(this.o, this.p));
            }
            this.f899e.setCurrentItem(i4 - this.o);
        } else if (i2 == i12 && (i9 = i3 + 1) == this.m) {
            if (listAsList.contains(String.valueOf(i9))) {
                this.f899e.setAdapter(new c.b.a.a.b(this.o, 31));
            } else if (listAsList2.contains(String.valueOf(i9))) {
                this.f899e.setAdapter(new c.b.a.a.b(this.o, 30));
            } else if ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) {
                this.f899e.setAdapter(new c.b.a.a.b(this.o, 28));
            } else {
                this.f899e.setAdapter(new c.b.a.a.b(this.o, 29));
            }
            this.f899e.setCurrentItem(i4 - this.o);
        } else if (i2 == i13 && (i8 = i3 + 1) == this.n) {
            if (listAsList.contains(String.valueOf(i8))) {
                if (this.p > 31) {
                    this.p = 31;
                }
                this.f899e.setAdapter(new c.b.a.a.b(1, this.p));
            } else if (listAsList2.contains(String.valueOf(i8))) {
                if (this.p > 30) {
                    this.p = 30;
                }
                this.f899e.setAdapter(new c.b.a.a.b(1, this.p));
            } else if ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) {
                if (this.p > 28) {
                    this.p = 28;
                }
                this.f899e.setAdapter(new c.b.a.a.b(1, this.p));
            } else {
                if (this.p > 29) {
                    this.p = 29;
                }
                this.f899e.setAdapter(new c.b.a.a.b(1, this.p));
            }
            this.f899e.setCurrentItem(i4 - 1);
        } else {
            int i15 = i3 + 1;
            if (listAsList.contains(String.valueOf(i15))) {
                this.f899e.setAdapter(new c.b.a.a.b(1, 31));
            } else if (listAsList2.contains(String.valueOf(i15))) {
                this.f899e.setAdapter(new c.b.a.a.b(1, 30));
            } else if ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) {
                this.f899e.setAdapter(new c.b.a.a.b(1, 28));
            } else {
                this.f899e.setAdapter(new c.b.a.a.b(1, 29));
            }
            this.f899e.setCurrentItem(i4 - 1);
        }
        this.f899e.setGravity(this.f903i);
        WheelView wheelView3 = (WheelView) this.f896b.findViewById(R.id.hour);
        this.f900f = wheelView3;
        wheelView3.setAdapter(new c.b.a.a.b(0, 23));
        this.f900f.setCurrentItem(i5);
        this.f900f.setGravity(this.f903i);
        WheelView wheelView4 = (WheelView) this.f896b.findViewById(R.id.min);
        this.f901g = wheelView4;
        wheelView4.setAdapter(new c.b.a.a.b(0, 59));
        this.f901g.setCurrentItem(i6);
        this.f901g.setGravity(this.f903i);
        WheelView wheelView5 = (WheelView) this.f896b.findViewById(R.id.second);
        this.f902h = wheelView5;
        wheelView5.setAdapter(new c.b.a.a.b(0, 59));
        this.f902h.setCurrentItem(i7);
        this.f902h.setGravity(this.f903i);
        this.f897c.setOnItemSelectedListener(new c(listAsList, listAsList2));
        this.f898d.setOnItemSelectedListener(new d(listAsList, listAsList2));
        o(this.f899e);
        o(this.f900f);
        o(this.f901g);
        o(this.f902h);
        boolean[] zArr = this.j;
        if (zArr.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.f897c.setVisibility(zArr[0] ? 0 : 8);
        this.f898d.setVisibility(this.j[1] ? 0 : 8);
        this.f899e.setVisibility(this.j[2] ? 0 : 8);
        this.f900f.setVisibility(this.j[3] ? 0 : 8);
        this.f901g.setVisibility(this.j[4] ? 0 : 8);
        this.f902h.setVisibility(this.j[5] ? 0 : 8);
        p();
    }

    public final void w() {
        this.f899e.setTextColorCenter(this.t);
        this.f898d.setTextColorCenter(this.t);
        this.f897c.setTextColorCenter(this.t);
        this.f900f.setTextColorCenter(this.t);
        this.f901g.setTextColorCenter(this.t);
        this.f902h.setTextColorCenter(this.t);
    }

    public final void x() {
        this.f899e.setTextColorOut(this.s);
        this.f898d.setTextColorOut(this.s);
        this.f897c.setTextColorOut(this.s);
        this.f900f.setTextColorOut(this.s);
        this.f901g.setTextColorOut(this.s);
        this.f902h.setTextColorOut(this.s);
    }

    public void setPicker(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (!this.x) {
            v(i2, i3, i4, i5, i6, i7);
        } else {
            int[] iArrSolarToLunar = c.b.a.e.b.solarToLunar(i2, i3 + 1, i4);
            t(iArrSolarToLunar[0], iArrSolarToLunar[1] - 1, iArrSolarToLunar[2], iArrSolarToLunar[3] == 1, i5, i6, i7);
        }
    }
}
