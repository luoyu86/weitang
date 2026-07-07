package c.e.c.x.e;

import android.content.Context;
import android.view.View;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.me.vo.NameValueVo;
import com.chinavisionary.microtang.me.vo.UpdateUserIdBo;
import com.chinavisionary.microtang.me.vo.WorkAddressVo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<NameValueVo> f2140b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<NameValueVo> f2142d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<NameValueVo> f2144f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<NameValueVo> f2146h;
    public List<NameValueVo> j;
    public List<WorkAddressVo> m;
    public int n;
    public c.b.a.f.b<NameValueVo> o;
    public c.b.a.f.b<WorkAddressVo> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Context f2148q;
    public f0 r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2139a = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2141c = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2143e = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2145g = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2147i = -1;
    public int k = -1;
    public int l = -1;

    public class a implements c.b.a.d.d {
        public a() {
        }

        @Override // c.b.a.d.d
        public void onOptionsSelectChanged(int i2, int i3, int i4) {
            c.e.a.d.q.d(a.class.getSimpleName(), "onOptionsSelectChanged options1 =" + i2 + ",mSelectWorkAddressPosition=" + e0.this.k);
            if (e0.this.k != i2) {
                e0.this.l = 0;
            } else {
                e0.this.l = i3;
            }
            e0.this.k = i2;
        }
    }

    public e0(f0 f0Var) {
        this.r = f0Var;
        this.f2148q = f0Var.getCurrentContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(int i2, int i3, int i4, View view) {
        NameValueVo nameValueVoL;
        int i5 = this.n;
        if (i5 == 3) {
            nameValueVoL = l(i2);
        } else if (i5 == 5) {
            nameValueVoL = o(i2);
        } else if (i5 == 12) {
            nameValueVoL = n(i2);
        } else if (i5 == 7) {
            nameValueVoL = p(i2);
        } else if (i5 != 8) {
            nameValueVoL = null;
        } else {
            nameValueVoL = m(i2);
            this.r.updateSelectIdType(nameValueVoL);
        }
        if (nameValueVoL != null) {
            this.r.updateSelectOptionName(nameValueVoL.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(int i2, int i3, int i4, View view) {
        WorkAddressVo workAddressVoQ = q(i2, i3);
        if (workAddressVoQ != null) {
            List<WorkAddressVo> children = workAddressVoQ.getChildren();
            String tagName = workAddressVoQ.getTagName();
            if (c.e.a.d.o.isNotEmpty(children)) {
                tagName = tagName + "-" + children.get(i3).getTagName();
            }
            this.r.updateSelectOptionName(tagName);
        }
    }

    public final void A() {
        List<WorkAddressVo> list = this.m;
        if (list != null) {
            ArrayList arrayList = null;
            if (this.k != -1) {
                arrayList = new ArrayList();
                if (this.l == -1) {
                    this.l = 0;
                }
                Iterator<WorkAddressVo> it = this.m.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getChildren());
                }
            } else if (c.e.a.d.o.isNotEmpty(list)) {
                this.k = 0;
                arrayList = new ArrayList();
                this.l = 0;
                Iterator<WorkAddressVo> it2 = this.m.iterator();
                while (it2.hasNext()) {
                    arrayList.add(it2.next().getChildren());
                }
            }
            c.e.a.d.q.d(e0.class.getSimpleName(), "mSelectWorkAddressPosition = " + this.k + ",mSelectTwoWorkAddressPosition =" + this.l);
            this.p.setPicker(this.m, arrayList);
            int i2 = this.k;
            if (i2 != -1) {
                this.p.setSelectOptions(i2, this.l);
            }
        }
    }

    public final int d(List<NameValueVo> list, int i2, List<LeftTitleToRightArrowVo> list2) {
        if (list != null && !list.isEmpty()) {
            String strE = e(i2, list2);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                NameValueVo nameValueVo = list.get(i3);
                if (nameValueVo != null) {
                    String name = nameValueVo.getName();
                    if (c.e.a.d.x.isNotNull(name) && c.e.a.d.x.isNotNull(strE) && name.equals(strE)) {
                        return i3;
                    }
                }
            }
        }
        return -1;
    }

    public final String e(int i2, List<LeftTitleToRightArrowVo> list) {
        for (LeftTitleToRightArrowVo leftTitleToRightArrowVo : list) {
            if (leftTitleToRightArrowVo != null && leftTitleToRightArrowVo.getOnlyKey() == i2) {
                return leftTitleToRightArrowVo.getRight();
            }
        }
        return null;
    }

    public final int f(List<WorkAddressVo> list, int i2, List<LeftTitleToRightArrowVo> list2) {
        if (list != null && !list.isEmpty()) {
            String strE = e(i2, list2);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                WorkAddressVo workAddressVo = list.get(i3);
                if (workAddressVo != null) {
                    String tagName = workAddressVo.getTagName();
                    if (c.e.a.d.x.isNotNull(tagName) && c.e.a.d.x.isNotNull(strE) && tagName.equals(strE)) {
                        return i3;
                    }
                }
            }
        }
        return -1;
    }

    public NameValueVo getEduSource() {
        int i2;
        List<NameValueVo> list = this.j;
        if (list == null || (i2 = this.f2147i) == -1) {
            return null;
        }
        return list.get(i2);
    }

    public int getSelectIdCardType() {
        if (c.e.a.d.o.isNotEmpty(this.f2146h)) {
            return this.f2146h.get(this.f2145g).getValue();
        }
        return 2;
    }

    public UpdateUserIdBo getUpdateUserIdBo(List<LeftTitleToRightArrowVo> list) {
        UpdateUserIdBo updateUserIdBo = new UpdateUserIdBo();
        int i2 = this.f2145g;
        if (i2 != -1) {
            this.f2146h.get(i2).getValue();
        }
        int value = this.f2140b.get(this.f2139a).getValue();
        int value2 = this.f2142d.get(this.f2141c).getValue();
        int i3 = this.f2143e;
        if (i3 != -1) {
            updateUserIdBo.setPolitical(this.f2144f.get(i3).getValue());
        }
        updateUserIdBo.setEducation(value);
        updateUserIdBo.setMarriage(value2);
        String right = list.get(list.size() - 1).getRight();
        if (c.e.a.d.x.isNotNull(right)) {
            updateUserIdBo.setCompanyAddress(right);
        }
        return updateUserIdBo;
    }

    public boolean isUnselectedEduMarriage() {
        boolean z;
        if (this.f2139a == -1) {
            this.r.showToast(R.string.title_select_edu);
            z = true;
        } else {
            z = false;
        }
        if (this.f2141c == -1) {
            this.r.showToast(R.string.title_select_marriage);
            z = true;
        }
        if (this.k != -1) {
            return z;
        }
        this.r.showToast(R.string.title_select_work_address);
        return true;
    }

    public final void k() {
        this.o = new c.b.a.b.a(this.f2148q, new c.b.a.d.e() { // from class: c.e.c.x.e.a
            @Override // c.b.a.d.e
            public final void onOptionsSelect(int i2, int i3, int i4, View view) {
                this.f2121a.h(i2, i3, i4, view);
            }
        }).build();
        y();
        this.o.show();
    }

    public final NameValueVo l(int i2) {
        List<NameValueVo> list = this.f2140b;
        if (list == null) {
            return null;
        }
        this.f2139a = i2;
        return list.get(i2);
    }

    public final NameValueVo m(int i2) {
        List<NameValueVo> list = this.j;
        if (list == null) {
            return null;
        }
        this.f2147i = i2;
        return list.get(i2);
    }

    public final NameValueVo n(int i2) {
        List<NameValueVo> list = this.f2146h;
        if (list == null) {
            return null;
        }
        this.f2145g = i2;
        return list.get(i2);
    }

    public final NameValueVo o(int i2) {
        List<NameValueVo> list = this.f2142d;
        if (list == null) {
            return null;
        }
        this.f2141c = i2;
        return list.get(i2);
    }

    public final NameValueVo p(int i2) {
        List<NameValueVo> list = this.f2144f;
        if (list == null) {
            return null;
        }
        this.f2143e = i2;
        return list.get(i2);
    }

    public final WorkAddressVo q(int i2, int i3) {
        List<WorkAddressVo> list = this.m;
        if (list == null) {
            return null;
        }
        this.k = i2;
        this.l = i3;
        return list.get(i2);
    }

    public final void r() {
        this.p = new c.b.a.b.a(this.f2148q, new c.b.a.d.e() { // from class: c.e.c.x.e.b
            @Override // c.b.a.d.e
            public final void onOptionsSelect(int i2, int i3, int i4, View view) {
                this.f2123a.j(i2, i3, i4, view);
            }
        }).setOptionsSelectChangeListener(new a()).build();
        A();
        this.p.show();
    }

    public final void s() {
        if (this.o == null) {
            k();
        } else {
            y();
            this.o.show();
        }
    }

    public void setupEduSourceVos(ResponseRowsVo<NameValueVo> responseRowsVo, List<LeftTitleToRightArrowVo> list) {
        if (responseRowsVo != null) {
            List<NameValueVo> rows = responseRowsVo.getRows();
            this.j = rows;
            this.f2147i = d(rows, 8, list);
        }
    }

    public void setupEduVos(ResponseRowsVo<NameValueVo> responseRowsVo, List<LeftTitleToRightArrowVo> list) {
        if (responseRowsVo != null) {
            List<NameValueVo> rows = responseRowsVo.getRows();
            this.f2140b = rows;
            this.f2139a = d(rows, 3, list);
        }
    }

    public void setupIDTypeVos(ResponseRowsVo<NameValueVo> responseRowsVo, List<LeftTitleToRightArrowVo> list) {
        if (responseRowsVo != null) {
            List<NameValueVo> rows = responseRowsVo.getRows();
            this.f2146h = rows;
            this.f2145g = d(rows, 12, list);
            this.r.updateSelectIdType(n(0));
        }
    }

    public void setupMarriages(ResponseRowsVo<NameValueVo> responseRowsVo, List<LeftTitleToRightArrowVo> list) {
        if (responseRowsVo != null) {
            List<NameValueVo> rows = responseRowsVo.getRows();
            this.f2142d = rows;
            this.f2141c = d(rows, 5, list);
        }
    }

    public void setupPolitical(ResponseRowsVo<NameValueVo> responseRowsVo, List<LeftTitleToRightArrowVo> list) {
        if (responseRowsVo != null) {
            List<NameValueVo> rows = responseRowsVo.getRows();
            this.f2144f = rows;
            this.f2143e = d(rows, 7, list);
        }
    }

    public void setupWorkAddressList(ResponseRowsVo<WorkAddressVo> responseRowsVo, List<LeftTitleToRightArrowVo> list) {
        if (responseRowsVo != null) {
            List<WorkAddressVo> rows = responseRowsVo.getRows();
            this.m = rows;
            this.k = f(rows, 6, list);
        }
    }

    public void showOptionToOnlyKey(int i2) {
        if (i2 != 3 && i2 != 12 && i2 != 5) {
            if (i2 == 6) {
                this.n = i2;
                t();
                return;
            } else if (i2 != 7 && i2 != 8) {
                return;
            }
        }
        this.n = i2;
        s();
    }

    public final void t() {
        if (this.p == null) {
            r();
        } else {
            A();
            this.p.show();
        }
    }

    public final void u() {
        List<NameValueVo> list = this.f2140b;
        if (list == null) {
            this.o.setPicker(null);
        } else {
            this.o.setPicker(list);
            this.o.setSelectOptions(this.f2139a);
        }
    }

    public final void v() {
        List<NameValueVo> list = this.j;
        if (list == null) {
            this.o.setPicker(null);
        } else {
            this.o.setPicker(list);
            this.o.setSelectOptions(this.f2147i);
        }
    }

    public final void w() {
        List<NameValueVo> list = this.f2146h;
        if (list != null) {
            this.o.setPicker(list);
            this.o.setSelectOptions(this.f2145g);
        }
    }

    public final void x() {
        List<NameValueVo> list = this.f2142d;
        if (list != null) {
            this.o.setPicker(list);
            this.o.setSelectOptions(this.f2141c);
        }
    }

    public final void y() {
        int i2 = this.n;
        if (i2 == 3) {
            u();
            return;
        }
        if (i2 == 5) {
            x();
            return;
        }
        if (i2 == 12) {
            w();
        } else if (i2 == 7) {
            z();
        } else {
            if (i2 != 8) {
                return;
            }
            v();
        }
    }

    public final void z() {
        List<NameValueVo> list = this.f2144f;
        if (list != null) {
            this.o.setPicker(list);
            this.o.setSelectOptions(this.f2143e);
        }
    }
}
