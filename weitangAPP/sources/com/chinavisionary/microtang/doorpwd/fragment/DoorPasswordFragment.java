package com.chinavisionary.microtang.doorpwd.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.c.a0.f.b;
import c.e.c.m0.c;
import c.e.c.m0.j;
import c.e.c.q.d.a;
import c.e.e.a.s.d;
import c.e.e.a.s.e;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.doorpwd.adapter.DoorPasswordAdapter;
import com.chinavisionary.microtang.open.fragment.SwitchRoomFragment;
import com.chinavisionary.twlib.open.model.NewOpenDoorModel;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DoorPasswordFragment extends BaseFragment<a> {
    public String B;
    public NewOpenDoorModel C;
    public final b D = new b() { // from class: c.e.c.q.c.c
        @Override // c.e.c.a0.f.b
        public final void onSelectRoomCallback(c.e.e.a.s.e eVar) {
            this.f1812a.O1(eVar);
        }
    };

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.tv_title_split_line)
    public View mTitleLineTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static DoorPasswordFragment getInstance() {
        return new DoorPasswordFragment();
    }

    public final String E1() {
        return w.getInstance().getString("current_room_key", null);
    }

    public final void F1(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        if (iIntValue >= 0) {
            if (((a) this.t.getList().get(iIntValue)).getItemVo().isEnableSetupPwd()) {
                N1();
            } else {
                F0(R.string.tip_room_not_support_number_pwd);
            }
        }
    }

    public final void G1(NewResponseRowsVo<d> newResponseRowsVo) {
        H();
        if (newResponseRowsVo != null) {
            List<e> listSignLockSetupDefault = j.getInstance().signLockSetupDefault(newResponseRowsVo.getRows());
            if (o.isNotEmpty(listSignLockSetupDefault)) {
                for (e eVar : listSignLockSetupDefault) {
                    if (eVar != null && x.isNotNull(eVar.getAssetInstanceKey()) && eVar.getAssetInstanceKey().equals(c.getInstance().getRoomKey())) {
                        O1(eVar);
                    }
                }
            }
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void H1() {
        this.B = c.getInstance().getRoomKey();
        DoorPasswordAdapter doorPasswordAdapter = new DoorPasswordAdapter();
        this.t = doorPasswordAdapter;
        doorPasswordAdapter.setOnClickListener(this.y);
        this.t.initListData((List<T>) c.e.c.q.b.a.getDoorPasswordList(o(), false, E1()));
        p0(this.mBaseSwipeRefreshLayout);
    }

    public final void I1() {
        NewOpenDoorModel newOpenDoorModel = (NewOpenDoorModel) h(NewOpenDoorModel.class);
        this.C = newOpenDoorModel;
        newOpenDoorModel.getRoomList().observe(this, new Observer() { // from class: c.e.c.q.c.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1811a.G1((NewResponseRowsVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.q.c.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1810a.C((RequestErrDto) obj);
            }
        });
        z0(R.string.loading_text);
        this.C.getRoomList("DoorPasswordFragment-initModel");
    }

    public final void M1() {
        SwitchRoomFragment switchRoomFragment = SwitchRoomFragment.getInstance("3", this.D);
        switchRoomFragment.setSelectRoomKey(this.B);
        d(switchRoomFragment, R.id.flayout_content);
    }

    public final void N1() {
        if (!x.isNotNull(this.B)) {
            F0(R.string.tip_select_room_is_empty);
        } else {
            d(UpdateDoorPwdFragment.getInstance(this.B, ((a) this.t.getList().get(1)).getItemVo().getRoomName()), R.id.flayout_content);
        }
    }

    public final void O1(e eVar) {
        this.B = eVar.getAssetInstanceKey();
        ((a) this.t.getList().get(1)).getItemVo().setEnableSetupPwd(eVar.isSupportNumberPassword());
        ((a) this.t.getList().get(1)).getItemVo().setRoomName(eVar.getAssetInstanceName());
        this.t.notifyItemChanged(1);
        if (eVar.isSupportNumberPassword()) {
            return;
        }
        F0(R.string.tip_room_not_support_number_pwd);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.tv_setup_pwd) {
            F1(view);
        }
        if (view.getId() == R.id.tv_room_name) {
            M1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleLineTv.setVisibility(0);
        this.mTitleTv.setText(R.string.title_door_pwd);
        H1();
        I1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_door_password;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @OnClick({R.id.tv_back})
    public void pageClick(View view) {
        n();
    }
}
