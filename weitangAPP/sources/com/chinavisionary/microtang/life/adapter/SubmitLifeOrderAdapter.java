package com.chinavisionary.microtang.life.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.e.a.d.x;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.life.vo.SubmitLifeOrderVo;
import com.chinavisionary.microtang.view.CbLayoutView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SubmitLifeOrderAdapter extends BaseRecyclerAdapter<SubmitLifeOrderVo> {

    public static class a extends BaseRecyclerViewHolder<SubmitLifeOrderVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f7275f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final View f7276g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final CbLayoutView f7277h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f7278i;

        public a(View view) {
            super(view);
            this.f7278i = view.getResources().getDimensionPixelSize(R.dimen.dp_15);
            this.f7276g = view.findViewById(R.id.view_split_line);
            this.f7275f = (TextView) view.findViewById(R.id.tv_address_title);
            this.f7277h = (CbLayoutView) view.findViewById(R.id.llayouot_item);
        }

        public void g(SubmitLifeOrderVo submitLifeOrderVo) {
            this.itemView.setBackgroundResource(submitLifeOrderVo.isShowSplitLine() ? R.drawable.bg_bottom_left_right_radius_5 : R.drawable.bg_top_left_right_radius_5);
            this.itemView.setPadding(0, 0, 0, submitLifeOrderVo.isShowSplitLine() ? this.f7278i : 0);
            this.f7275f.setText(c(submitLifeOrderVo.getTitle()));
            this.f7277h.initCbData(submitLifeOrderVo.getKeyValueVos());
        }
    }

    public static class b extends BaseRecyclerViewHolder<SubmitLifeOrderVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f7279f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f7280g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final EditText f7281h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List<SubmitLifeOrderVo> f7282i;

        public class a implements TextWatcher {
            public a() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.i();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        }

        public b(View view) {
            super(view);
            this.f7279f = (TextView) view.findViewById(R.id.tv_address_title);
            this.f7280g = (TextView) view.findViewById(R.id.tv_input_number_tip);
            EditText editText = (EditText) view.findViewById(R.id.edt_remark);
            this.f7281h = editText;
            editText.addTextChangedListener(new a());
        }

        public void h(SubmitLifeOrderVo submitLifeOrderVo) {
            this.f7279f.setText(c(submitLifeOrderVo.getTitle()));
        }

        public final void i() {
            String string = this.f7281h.getText().toString();
            this.f7280g.setText(string.length() + "/200");
            if (getAdapterPosition() >= 0) {
                this.f7282i.get(getAdapterPosition()).setValue(string);
            }
        }

        public void setSubmitLifeOrderVos(List<SubmitLifeOrderVo> list) {
            this.f7282i = list;
        }
    }

    public static class c extends BaseRecyclerViewHolder<SubmitLifeOrderVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f7284f;

        public c(View view) {
            super(view);
            this.f7284f = (TextView) view.findViewById(R.id.tv_address_value);
        }

        public void g(SubmitLifeOrderVo submitLifeOrderVo) {
            this.f7284f.setText(c(submitLifeOrderVo.getValue()));
        }
    }

    public static class d extends BaseRecyclerViewHolder<SubmitLifeOrderVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f7285f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f7286g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final TextView f7287h;

        public d(View view) {
            super(view);
            this.f7286g = (TextView) view.findViewById(R.id.tv_address_title);
            this.f7285f = (TextView) view.findViewById(R.id.tv_address_value);
            this.f7287h = (TextView) view.findViewById(R.id.tv_address_tip);
        }

        public void g(SubmitLifeOrderVo submitLifeOrderVo) {
            this.f7286g.setText(c(submitLifeOrderVo.getTitle()));
            this.f7285f.setText(c(submitLifeOrderVo.getValue()));
            this.f7287h.setText(c(submitLifeOrderVo.getTip()));
        }
    }

    public static class e extends BaseRecyclerViewHolder<SubmitLifeOrderVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f7288f;

        public e(View view) {
            super(view);
            this.f7288f = (TextView) view.findViewById(R.id.tv_address_value);
        }

        public void g(SubmitLifeOrderVo submitLifeOrderVo) {
            if (x.isNotNull(submitLifeOrderVo.getValue())) {
                this.f7288f.setText(c(submitLifeOrderVo.getValue()));
            } else {
                this.f7288f.setText(c(submitLifeOrderVo.getHintValue()));
            }
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return ((SubmitLifeOrderVo) this.f6460b.get(i2)).getItemType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 221) {
            y(viewHolder, i2);
            return;
        }
        if (itemViewType == 231) {
            u(viewHolder, i2);
            return;
        }
        if (itemViewType == 233) {
            x(viewHolder, i2);
        } else if (itemViewType != 241) {
            w(viewHolder, i2);
        } else {
            v(viewHolder, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return i2 != 221 ? i2 != 231 ? i2 != 233 ? i2 != 241 ? q(viewGroup) : p(viewGroup) : s(viewGroup) : r(viewGroup) : t(viewGroup);
    }

    public final a p(ViewGroup viewGroup) {
        return new a(i(viewGroup, R.layout.item_submit_life_order_select));
    }

    public final b q(ViewGroup viewGroup) {
        b bVar = new b(i(viewGroup, R.layout.item_submit_life_order_edt));
        bVar.setSubmitLifeOrderVos(this.f6460b);
        return bVar;
    }

    public final c r(ViewGroup viewGroup) {
        return new c(i(viewGroup, R.layout.item_submit_life_order_address));
    }

    public final d s(ViewGroup viewGroup) {
        return new d(i(viewGroup, R.layout.item_submit_life_order_info));
    }

    public final e t(ViewGroup viewGroup) {
        e eVar = new e(i(viewGroup, R.layout.item_submit_life_order_time));
        a(eVar);
        return eVar;
    }

    public final void u(RecyclerView.ViewHolder viewHolder, int i2) {
        ((c) viewHolder).g((SubmitLifeOrderVo) this.f6460b.get(i2));
    }

    public final void v(RecyclerView.ViewHolder viewHolder, int i2) {
        ((a) viewHolder).g((SubmitLifeOrderVo) this.f6460b.get(i2));
    }

    public final void w(RecyclerView.ViewHolder viewHolder, int i2) {
        ((b) viewHolder).h((SubmitLifeOrderVo) this.f6460b.get(i2));
    }

    public final void x(RecyclerView.ViewHolder viewHolder, int i2) {
        ((d) viewHolder).g((SubmitLifeOrderVo) this.f6460b.get(i2));
    }

    public final void y(RecyclerView.ViewHolder viewHolder, int i2) {
        ((e) viewHolder).g((SubmitLifeOrderVo) this.f6460b.get(i2));
    }
}
