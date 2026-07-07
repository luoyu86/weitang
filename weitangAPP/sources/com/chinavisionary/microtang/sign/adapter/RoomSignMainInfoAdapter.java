package com.chinavisionary.microtang.sign.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.me.vo.IDTypeNameValueVo;
import com.chinavisionary.microtang.sign.view.TogetherLiveLayout;
import com.chinavisionary.microtang.sign.vo.ContactDetailsVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RoomSignMainInfoAdapter extends LeftTitleToRightArrowAdapter {
    public List<IDTypeNameValueVo> p;

    public static class TogetherLiveVh extends BaseRecyclerViewHolder<LeftTitleToRightArrowVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8491f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<IDTypeNameValueVo> f8492g;

        @BindView(R.id.llayout_together_live)
        public LinearLayout mTogetherLiveLayout;

        public TogetherLiveVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(List<LeftTitleToRightArrowVo> list, View.OnClickListener onClickListener, int i2) {
            this.mTogetherLiveLayout.removeAllViews();
            LeftTitleToRightArrowVo leftTitleToRightArrowVo = list.get(i2);
            List list2 = (List) leftTitleToRightArrowVo.getExtObj();
            int size = list2.size();
            for (int i3 = 0; i3 < size; i3++) {
                TogetherLiveLayout togetherLiveLayout = new TogetherLiveLayout(this.mTogetherLiveLayout.getContext());
                togetherLiveLayout.setupIdTypeList(this.f8492g);
                togetherLiveLayout.setupList(list, (ContactDetailsVo.RoommatesBean) list2.get(i3), i2, onClickListener, i3, leftTitleToRightArrowVo.isEdit());
                this.mTogetherLiveLayout.addView(togetherLiveLayout);
            }
        }

        public void h(List<IDTypeNameValueVo> list) {
            this.f8492g = list;
        }

        public void setRent(boolean z) {
            this.f8491f = z;
        }
    }

    public class TogetherLiveVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TogetherLiveVh f8493b;

        @UiThread
        public TogetherLiveVh_ViewBinding(TogetherLiveVh togetherLiveVh, View view) {
            this.f8493b = togetherLiveVh;
            togetherLiveVh.mTogetherLiveLayout = (LinearLayout) d.findRequiredViewAsType(view, R.id.llayout_together_live, "field 'mTogetherLiveLayout'", LinearLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            TogetherLiveVh togetherLiveVh = this.f8493b;
            if (togetherLiveVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8493b = null;
            togetherLiveVh.mTogetherLiveLayout = null;
        }
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter
    public void q(RecyclerView.ViewHolder viewHolder, int i2) {
        ((TogetherLiveVh) viewHolder).g(this.f6460b, this.f6461c, i2);
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter
    public RecyclerView.ViewHolder r(ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_together_live_info, viewGroup, false);
        TogetherLiveVh togetherLiveVh = new TogetherLiveVh(viewInflate);
        togetherLiveVh.h(this.p);
        viewInflate.setTag(togetherLiveVh);
        return togetherLiveVh;
    }

    public void setNameValueVos(List<IDTypeNameValueVo> list) {
        this.p = list;
    }
}
