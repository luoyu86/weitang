package com.chinavisionary.microtang.room.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.o;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.room.vo.RoomDeviceListItemVo;
import com.chinavisionary.microtang.web.bridge.BridgeWebFragment;

/* JADX INFO: loaded from: classes2.dex */
public class RoomSourceDeviceListAdapter extends BaseRecyclerAdapter<RoomDeviceListItemVo> {
    public FragmentManager n;
    public String o;

    public static class DeviceVh extends BaseRecyclerViewHolder<RoomDeviceListItemVo> {

        @BindView(R.id.img_device)
        public CoreRoundedImageView mDeviceImg;

        @BindView(R.id.tv_device_name)
        public TextView mDeviceNameTv;

        public DeviceVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(RoomDeviceListItemVo roomDeviceListItemVo) {
            if (roomDeviceListItemVo != null) {
                this.mDeviceImg.loadImageToUrl(roomDeviceListItemVo.getCoverUrl());
                this.mDeviceNameTv.setText(c(roomDeviceListItemVo.getName()));
            }
        }
    }

    public class DeviceVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public DeviceVh f8302b;

        @UiThread
        public DeviceVh_ViewBinding(DeviceVh deviceVh, View view) {
            this.f8302b = deviceVh;
            deviceVh.mDeviceImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_device, "field 'mDeviceImg'", CoreRoundedImageView.class);
            deviceVh.mDeviceNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_device_name, "field 'mDeviceNameTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            DeviceVh deviceVh = this.f8302b;
            if (deviceVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8302b = null;
            deviceVh.mDeviceImg = null;
            deviceVh.mDeviceNameTv = null;
        }
    }

    public static class a extends SimpleRecyclerViewHolder<RoomDeviceListItemVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public FragmentManager f8303f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public BridgeWebFragment f8304g;

        public a(View view) {
            super(view);
        }

        public void g(FragmentManager fragmentManager, String str) {
            this.f8303f = fragmentManager;
            BridgeWebFragment bridgeWebFragment = BridgeWebFragment.getInstance(str);
            this.f8304g = bridgeWebFragment;
            bridgeWebFragment.setupHiedLayoutTitle(true);
            String canonicalName = BridgeWebFragment.class.getCanonicalName();
            Fragment fragmentFindFragmentByTag = this.f8303f.findFragmentByTag(canonicalName);
            if (fragmentFindFragmentByTag != null) {
                this.f8303f.beginTransaction().remove(fragmentFindFragmentByTag).commit();
            }
            this.f8303f.beginTransaction().add(R.id.frame_layout_content, this.f8304g, canonicalName).commit();
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(RoomDeviceListItemVo roomDeviceListItemVo) {
        }
    }

    public RoomSourceDeviceListAdapter(FragmentManager fragmentManager) {
        this.n = fragmentManager;
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.f6466h == null || i2 != 0) {
            return o.isNotEmpty(this.f6460b) ? ((RoomDeviceListItemVo) this.f6460b.get(i2 - h())).getItemType() : super.getItemViewType(i2);
        }
        return 26214;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() == 3) {
            ((DeviceVh) viewHolder).g((RoomDeviceListItemVo) this.f6460b.get(i2 - h()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 != 39) {
            return i2 != 26214 ? i2 != 34952 ? new DeviceVh(i(viewGroup, R.layout.item_room_source_device_list)) : new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup)) : new BaseRecyclerAdapter.RecyclerHeadViewHodler(this.f6466h);
        }
        a aVar = new a(i(viewGroup, R.layout.item_room_web));
        aVar.g(this.n, this.o);
        return aVar;
    }

    public void setUrl(String str) {
        this.o = str;
    }
}
