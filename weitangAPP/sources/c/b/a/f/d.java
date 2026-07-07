package c.b.a.f;

import android.graphics.Typeface;
import android.view.View;
import com.bigkoo.pickerview.R;
import com.contrarywind.view.WheelView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WheelView f880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WheelView f881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WheelView f882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<T> f883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<List<T>> f884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<List<List<T>>> f885g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f886h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f887i;
    public c.f.c.b j;
    public c.f.c.b k;
    public c.b.a.d.d l;
    public int m;
    public int n;
    public int o;
    public WheelView.c p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f888q;

    public class a implements c.f.c.b {
        public a() {
        }

        @Override // c.f.c.b
        public void onItemSelected(int i2) {
            int currentItem;
            if (d.this.f884f == null) {
                if (d.this.l != null) {
                    d.this.l.onOptionsSelectChanged(d.this.f880b.getCurrentItem(), 0, 0);
                    return;
                }
                return;
            }
            if (d.this.f887i) {
                currentItem = 0;
            } else {
                currentItem = d.this.f881c.getCurrentItem();
                if (currentItem >= ((List) d.this.f884f.get(i2)).size() - 1) {
                    currentItem = ((List) d.this.f884f.get(i2)).size() - 1;
                }
            }
            d.this.f881c.setAdapter(new c.b.a.a.a((List) d.this.f884f.get(i2)));
            d.this.f881c.setCurrentItem(currentItem);
            if (d.this.f885g != null) {
                d.this.k.onItemSelected(currentItem);
            } else if (d.this.l != null) {
                d.this.l.onOptionsSelectChanged(i2, currentItem, 0);
            }
        }
    }

    public class b implements c.f.c.b {
        public b() {
        }

        @Override // c.f.c.b
        public void onItemSelected(int i2) {
            int size = 0;
            if (d.this.f885g == null) {
                if (d.this.l != null) {
                    d.this.l.onOptionsSelectChanged(d.this.f880b.getCurrentItem(), i2, 0);
                    return;
                }
                return;
            }
            int currentItem = d.this.f880b.getCurrentItem();
            if (currentItem >= d.this.f885g.size() - 1) {
                currentItem = d.this.f885g.size() - 1;
            }
            if (i2 >= ((List) d.this.f884f.get(currentItem)).size() - 1) {
                i2 = ((List) d.this.f884f.get(currentItem)).size() - 1;
            }
            if (!d.this.f887i) {
                size = d.this.f882d.getCurrentItem() >= ((List) ((List) d.this.f885g.get(currentItem)).get(i2)).size() + (-1) ? ((List) ((List) d.this.f885g.get(currentItem)).get(i2)).size() - 1 : d.this.f882d.getCurrentItem();
            }
            d.this.f882d.setAdapter(new c.b.a.a.a((List) ((List) d.this.f885g.get(d.this.f880b.getCurrentItem())).get(i2)));
            d.this.f882d.setCurrentItem(size);
            if (d.this.l != null) {
                d.this.l.onOptionsSelectChanged(d.this.f880b.getCurrentItem(), i2, size);
            }
        }
    }

    public class c implements c.f.c.b {
        public c() {
        }

        @Override // c.f.c.b
        public void onItemSelected(int i2) {
            d.this.l.onOptionsSelectChanged(d.this.f880b.getCurrentItem(), d.this.f881c.getCurrentItem(), i2);
        }
    }

    /* JADX INFO: renamed from: c.b.a.f.d$d, reason: collision with other inner class name */
    public class C0011d implements c.f.c.b {
        public C0011d() {
        }

        @Override // c.f.c.b
        public void onItemSelected(int i2) {
            d.this.l.onOptionsSelectChanged(i2, d.this.f881c.getCurrentItem(), d.this.f882d.getCurrentItem());
        }
    }

    public class e implements c.f.c.b {
        public e() {
        }

        @Override // c.f.c.b
        public void onItemSelected(int i2) {
            d.this.l.onOptionsSelectChanged(d.this.f880b.getCurrentItem(), i2, d.this.f882d.getCurrentItem());
        }
    }

    public class f implements c.f.c.b {
        public f() {
        }

        @Override // c.f.c.b
        public void onItemSelected(int i2) {
            d.this.l.onOptionsSelectChanged(d.this.f880b.getCurrentItem(), d.this.f881c.getCurrentItem(), i2);
        }
    }

    public d(View view, boolean z) {
        this.f887i = z;
        this.f879a = view;
        this.f880b = (WheelView) view.findViewById(R.id.options1);
        this.f881c = (WheelView) view.findViewById(R.id.options2);
        this.f882d = (WheelView) view.findViewById(R.id.options3);
    }

    public int[] getCurrentItems() {
        int[] iArr = new int[3];
        iArr[0] = this.f880b.getCurrentItem();
        List<List<T>> list = this.f884f;
        if (list == null || list.size() <= 0) {
            iArr[1] = this.f881c.getCurrentItem();
        } else {
            iArr[1] = this.f881c.getCurrentItem() > this.f884f.get(iArr[0]).size() - 1 ? 0 : this.f881c.getCurrentItem();
        }
        List<List<List<T>>> list2 = this.f885g;
        if (list2 == null || list2.size() <= 0) {
            iArr[2] = this.f882d.getCurrentItem();
        } else {
            iArr[2] = this.f882d.getCurrentItem() <= this.f885g.get(iArr[0]).get(iArr[1]).size() - 1 ? this.f882d.getCurrentItem() : 0;
        }
        return iArr;
    }

    public View getView() {
        return this.f879a;
    }

    public final void i(int i2, int i3, int i4) {
        if (this.f883e != null) {
            this.f880b.setCurrentItem(i2);
        }
        List<List<T>> list = this.f884f;
        if (list != null) {
            this.f881c.setAdapter(new c.b.a.a.a(list.get(i2)));
            this.f881c.setCurrentItem(i3);
        }
        List<List<List<T>>> list2 = this.f885g;
        if (list2 != null) {
            this.f882d.setAdapter(new c.b.a.a.a(list2.get(i2).get(i3)));
            this.f882d.setCurrentItem(i4);
        }
    }

    public void isCenterLabel(boolean z) {
        this.f880b.isCenterLabel(z);
        this.f881c.isCenterLabel(z);
        this.f882d.isCenterLabel(z);
    }

    public final void j() {
        this.f880b.setDividerColor(this.o);
        this.f881c.setDividerColor(this.o);
        this.f882d.setDividerColor(this.o);
    }

    public final void k() {
        this.f880b.setDividerType(this.p);
        this.f881c.setDividerType(this.p);
        this.f882d.setDividerType(this.p);
    }

    public final void l() {
        this.f880b.setLineSpacingMultiplier(this.f888q);
        this.f881c.setLineSpacingMultiplier(this.f888q);
        this.f882d.setLineSpacingMultiplier(this.f888q);
    }

    public final void m() {
        this.f880b.setTextColorCenter(this.n);
        this.f881c.setTextColorCenter(this.n);
        this.f882d.setTextColorCenter(this.n);
    }

    public final void n() {
        this.f880b.setTextColorOut(this.m);
        this.f881c.setTextColorOut(this.m);
        this.f882d.setTextColorOut(this.m);
    }

    public void setCurrentItems(int i2, int i3, int i4) {
        if (this.f886h) {
            i(i2, i3, i4);
            return;
        }
        this.f880b.setCurrentItem(i2);
        this.f881c.setCurrentItem(i3);
        this.f882d.setCurrentItem(i4);
    }

    public void setCyclic(boolean z) {
        this.f880b.setCyclic(z);
        this.f881c.setCyclic(z);
        this.f882d.setCyclic(z);
    }

    public void setDividerColor(int i2) {
        this.o = i2;
        j();
    }

    public void setDividerType(WheelView.c cVar) {
        this.p = cVar;
        k();
    }

    public void setLabels(String str, String str2, String str3) {
        if (str != null) {
            this.f880b.setLabel(str);
        }
        if (str2 != null) {
            this.f881c.setLabel(str2);
        }
        if (str3 != null) {
            this.f882d.setLabel(str3);
        }
    }

    public void setLineSpacingMultiplier(float f2) {
        this.f888q = f2;
        l();
    }

    public void setLinkage(boolean z) {
        this.f886h = z;
    }

    public void setNPicker(List<T> list, List<T> list2, List<T> list3) {
        this.f880b.setAdapter(new c.b.a.a.a(list));
        this.f880b.setCurrentItem(0);
        if (list2 != null) {
            this.f881c.setAdapter(new c.b.a.a.a(list2));
        }
        WheelView wheelView = this.f881c;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        if (list3 != null) {
            this.f882d.setAdapter(new c.b.a.a.a(list3));
        }
        WheelView wheelView2 = this.f882d;
        wheelView2.setCurrentItem(wheelView2.getCurrentItem());
        this.f880b.setIsOptions(true);
        this.f881c.setIsOptions(true);
        this.f882d.setIsOptions(true);
        if (this.l != null) {
            this.f880b.setOnItemSelectedListener(new C0011d());
        }
        if (list2 == null) {
            this.f881c.setVisibility(8);
        } else {
            this.f881c.setVisibility(0);
            if (this.l != null) {
                this.f881c.setOnItemSelectedListener(new e());
            }
        }
        if (list3 == null) {
            this.f882d.setVisibility(8);
            return;
        }
        this.f882d.setVisibility(0);
        if (this.l != null) {
            this.f882d.setOnItemSelectedListener(new f());
        }
    }

    public void setOptionsSelectChangeListener(c.b.a.d.d dVar) {
        this.l = dVar;
    }

    public void setPicker(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.f883e = list;
        this.f884f = list2;
        this.f885g = list3;
        this.f880b.setAdapter(new c.b.a.a.a(list));
        this.f880b.setCurrentItem(0);
        List<List<T>> list4 = this.f884f;
        if (list4 != null) {
            this.f881c.setAdapter(new c.b.a.a.a(list4.get(0)));
        }
        WheelView wheelView = this.f881c;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        List<List<List<T>>> list5 = this.f885g;
        if (list5 != null) {
            this.f882d.setAdapter(new c.b.a.a.a(list5.get(0).get(0)));
        }
        WheelView wheelView2 = this.f882d;
        wheelView2.setCurrentItem(wheelView2.getCurrentItem());
        this.f880b.setIsOptions(true);
        this.f881c.setIsOptions(true);
        this.f882d.setIsOptions(true);
        if (this.f884f == null) {
            this.f881c.setVisibility(8);
        } else {
            this.f881c.setVisibility(0);
        }
        if (this.f885g == null) {
            this.f882d.setVisibility(8);
        } else {
            this.f882d.setVisibility(0);
        }
        this.j = new a();
        this.k = new b();
        if (list != null && this.f886h) {
            this.f880b.setOnItemSelectedListener(this.j);
        }
        if (list2 != null && this.f886h) {
            this.f881c.setOnItemSelectedListener(this.k);
        }
        if (list3 == null || !this.f886h || this.l == null) {
            return;
        }
        this.f882d.setOnItemSelectedListener(new c());
    }

    public void setTextColorCenter(int i2) {
        this.n = i2;
        m();
    }

    public void setTextColorOut(int i2) {
        this.m = i2;
        n();
    }

    public void setTextContentSize(int i2) {
        float f2 = i2;
        this.f880b.setTextSize(f2);
        this.f881c.setTextSize(f2);
        this.f882d.setTextSize(f2);
    }

    public void setTextXOffset(int i2, int i3, int i4) {
        this.f880b.setTextXOffset(i2);
        this.f881c.setTextXOffset(i3);
        this.f882d.setTextXOffset(i4);
    }

    public void setTypeface(Typeface typeface) {
        this.f880b.setTypeface(typeface);
        this.f881c.setTypeface(typeface);
        this.f882d.setTypeface(typeface);
    }

    public void setView(View view) {
        this.f879a = view;
    }

    public void setCyclic(boolean z, boolean z2, boolean z3) {
        this.f880b.setCyclic(z);
        this.f881c.setCyclic(z2);
        this.f882d.setCyclic(z3);
    }
}
