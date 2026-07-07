package com.chinavisionary.microtang.me.fragment;

import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import c.e.e.a.s.d;
import c.e.e.a.s.e;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.adapter.RoomAuthAdapter;
import com.chinavisionary.twlib.open.bo.ResponseOpenDoorVo;
import com.chinavisionary.twlib.open.model.NewOpenDoorModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class RoomAuthListFragment extends BaseFragment<e> {
    public NewOpenDoorModel B;
    public e C;
    public e D;
    public List<e> E;
    public List<e> F;
    public ResponseOpenDoorVo K;
    public boolean M;

    @BindView(R.id.btn_retry_load_page)
    public AppCompatButton mAppCompatButton;

    @BindView(R.id.tv_custom_sort)
    public TextView mCustomSortTv;

    @BindView(R.id.recycler_room_list)
    public BaseRecyclerView mRoomRecyclerList;

    @BindView(R.id.edt_search_room)
    public EditText mSearchRoomEdt;

    @BindView(R.id.tv_title_split_line)
    public TextView mSplitLineTv;

    @BindView(R.id.tv_tip_msg)
    public TextView mTipMsgTv;

    @BindView(R.id.tv_tip_room_list_title)
    public TextView mTipRoomTitleTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public boolean G = false;
    public boolean H = false;
    public String I = null;
    public String J = null;
    public Map<String, ResponseOpenDoorVo> L = new HashMap();
    public final c.e.a.a.c.c.a N = new a();
    public final TextWatcher O = new b();

    public class a implements c.e.a.a.c.c.a {
        public a() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            if (i2 < 0) {
                i2 = 0;
            }
            RoomAuthListFragment roomAuthListFragment = RoomAuthListFragment.this;
            roomAuthListFragment.L1((e) roomAuthListFragment.t.getList().get(i2));
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            RoomAuthListFragment.this.mSearchRoomEdt.getText().toString();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public static RoomAuthListFragment getInstance(String str) {
        RoomAuthListFragment roomAuthListFragment = new RoomAuthListFragment();
        roomAuthListFragment.f6484b = str;
        return roomAuthListFragment;
    }

    private void o0() {
        this.F = new ArrayList();
        this.E = new ArrayList();
        this.r = this.mRoomRecyclerList;
        RoomAuthAdapter roomAuthAdapter = new RoomAuthAdapter();
        this.t = roomAuthAdapter;
        roomAuthAdapter.setOnItemClickListener(this.N);
    }

    public final void G1(View view) {
        L1((e) view.getTag());
    }

    public final void H1(NewResponseRowsVo<d> newResponseRowsVo) {
        H();
        if (newResponseRowsVo != null) {
            this.G = true;
        } else {
            c.e.c.x.c.a.getInstance().setShowWallet(false);
        }
    }

    public final void I1() {
        this.f6488f = new CoreBaseFragment.c(this);
        this.mSearchRoomEdt.setVisibility(8);
        this.mSearchRoomEdt.setRawInputType(2);
        this.mSearchRoomEdt.addTextChangedListener(this.O);
        this.mAppCompatButton.setOnClickListener(this.y);
        this.mTitleTv.setText(R.string.title_apply_rent);
        this.mSplitLineTv.setVisibility(0);
    }

    public final void L1(e eVar) {
        this.C = eVar;
    }

    public final void M1() {
        NewOpenDoorModel newOpenDoorModel = (NewOpenDoorModel) h(NewOpenDoorModel.class);
        this.B = newOpenDoorModel;
        newOpenDoorModel.getRoomList().observe(this, new Observer() { // from class: c.e.c.x.d.y1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2117a.H1((NewResponseRowsVo) obj);
            }
        });
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.z1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2120a.C((RequestErrDto) obj);
            }
        });
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void N1(List<e> list, boolean z) {
        H();
        this.t.initListData((List<T>) list);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_retry_load_page) {
            j0();
            view.setVisibility(8);
        } else {
            if (id != R.id.view_open_room) {
                return;
            }
            G1(view);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        I1();
        o0();
        M1();
        z0(R.string.loading_text);
        j0();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        g0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_switch_room_list;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.D = null;
        z0(R.string.loading_text);
        this.B.getRoomList("SwitchFragment-requestData");
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.K = null;
        this.M = false;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        super.z(message);
        if (message.what == 1) {
            N1(this.F, false);
            if (x.isNotNull(this.I)) {
                this.mSearchRoomEdt.setText(this.I);
                if (this.G) {
                    this.G = false;
                    this.I = null;
                }
            }
        }
    }
}
