package com.chinavisionary.microtang.open.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.x;
import c.e.c.h0.e.b;
import c.e.e.a.s.e;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.open.adapter.SetupOftenUseRoomAdapter;
import com.chinavisionary.microtang.open.event.EventUpdateOftenRoomCache;
import com.chinavisionary.twlib.open.model.OpenDoorModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OftenUseDeviceSetupFragment extends BaseFragment<e> {
    public OpenDoorModel C;
    public c.e.c.a0.f.a D;
    public List<e> E;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.tv_title_right)
    public TextView mRightTv;

    @BindView(R.id.edt_search_room)
    public EditText mSearchRoomEdt;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public boolean B = false;
    public final TextWatcher F = new a();

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            OftenUseDeviceSetupFragment.this.G1();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J1(int i2) {
        this.t.notifyItemChanged(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1(final int i2, boolean z) {
        if (!z) {
            ((e) this.t.getList().get(i2)).setSelect(false);
            return;
        }
        if (F1() != c.e.c.x.c.a.getInstance().getMaxCount()) {
            ((e) this.t.getList().get(i2)).setSelect(true);
            return;
        }
        G0("最多可设置" + c.e.c.x.c.a.getInstance().getMaxCountValue() + "个常用门锁");
        ((e) this.t.getList().get(i2)).setSelect(false);
        this.mTitleTv.postDelayed(new Runnable() { // from class: c.e.c.a0.h.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f1337a.J1(i2);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(NewResponseRowsVo newResponseRowsVo) {
        R1();
        if (newResponseRowsVo != null) {
            List<e> rows = newResponseRowsVo.getRows();
            H1(rows);
            this.E = rows;
            this.t.initListData((List<T>) rows);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: O1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P1(RequestErrDto requestErrDto) {
        super.C(requestErrDto);
        R1();
    }

    public static OftenUseDeviceSetupFragment getInstance(List<e> list, c.e.c.a0.f.a aVar) {
        OftenUseDeviceSetupFragment oftenUseDeviceSetupFragment = new OftenUseDeviceSetupFragment();
        oftenUseDeviceSetupFragment.D = aVar;
        return oftenUseDeviceSetupFragment;
    }

    private void o0() {
        SetupOftenUseRoomAdapter setupOftenUseRoomAdapter = new SetupOftenUseRoomAdapter();
        setupOftenUseRoomAdapter.setICheckBoxCallback(new b() { // from class: c.e.c.a0.h.e
            @Override // c.e.c.h0.e.b
            public final void onCheckBoxClick(int i2, boolean z) {
                this.f1334a.L1(i2, z);
            }
        });
        this.t = setupOftenUseRoomAdapter;
        this.mBaseSwipeRefreshLayout.setEnabled(false);
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
    }

    public final int F1() {
        List list = this.t.getList();
        int i2 = 0;
        if (o.isNotEmpty(list)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((e) it.next()).isSelect()) {
                    i2++;
                }
            }
        }
        return i2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void G1() {
        String string = this.mSearchRoomEdt.getText().toString();
        if (!x.isNotNull(string)) {
            this.t.initListData((List<T>) this.E);
            return;
        }
        if (o.isNotEmpty(this.E)) {
            ArrayList arrayList = new ArrayList();
            for (e eVar : this.E) {
                if (eVar != null && x.isNotNull(eVar.getAssetInstanceName()) && (eVar.getAssetInstanceName().contains(string) || eVar.isSelect())) {
                    arrayList.add(eVar);
                }
            }
            H1(arrayList);
            this.t.initListData(arrayList);
        }
    }

    public final void H1(List<e> list) {
        List<String> oftenDeviceKeyList = c.e.c.x.c.a.getInstance().getOftenDeviceKeyList();
        if (o.isNotEmpty(list) && o.isNotEmpty(oftenDeviceKeyList)) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = list.get(i2);
                if (eVar != null && eVar.getAssetInstanceKey() != null) {
                    eVar.setSelect(oftenDeviceKeyList.contains(eVar.getAssetInstanceKey()));
                    if (eVar.isSelect()) {
                        arrayList.add(eVar);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            list.removeAll(arrayList);
            list.addAll(0, arrayList);
        }
    }

    public final void Q1() {
        OpenDoorModel openDoorModel = (OpenDoorModel) h(OpenDoorModel.class);
        this.C = openDoorModel;
        openDoorModel.getLockListLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1340a.N1((NewResponseRowsVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1332a.P1((RequestErrDto) obj);
            }
        });
    }

    public final void R1() {
        H();
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
    }

    public final void S1() {
        List<e> list = this.t.getList();
        ArrayList arrayList = new ArrayList();
        if (o.isNotEmpty(list)) {
            for (e eVar : list) {
                if (eVar.isSelect()) {
                    arrayList.add(eVar);
                }
            }
        }
        c.e.c.x.c.a.getInstance().setOftenDeviceList(arrayList);
        k(new EventUpdateOftenRoomCache());
        c.e.c.a0.f.a aVar = this.D;
        if (aVar != null) {
            aVar.onOftenUseDevice(arrayList);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mRightTv.setVisibility(8);
        this.mTitleTv.setText(R.string.title_setup_often_use_device);
        this.mSearchRoomEdt.addTextChangedListener(this.F);
        this.mSearchRoomEdt.setRawInputType(2);
        o0();
        Q1();
        if (!o.isNotEmpty(this.E)) {
            j0();
        } else {
            H1(this.E);
            this.t.initListData((List<T>) this.E);
        }
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_often_use_device;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.C.getLockList();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @OnClick({R.id.btn_submit})
    public void saveUpdate(View view) {
        S1();
        F0(R.string.title_save_success);
        g0();
    }
}
