package com.chinavisionary.microtang.me.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.o;
import c.e.a.d.x;
import c.e.c.x.b.a;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.me.bo.CancelAccountItemBo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CancelAccountAdapter extends BaseRecyclerAdapter<CancelAccountItemBo> {
    public a n;

    public static class ContentVh extends BaseRecyclerViewHolder<CancelAccountItemBo> {

        @BindView(R.id.tv_content)
        public TextView mContentTv;

        public ContentVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(CancelAccountItemBo cancelAccountItemBo) {
            this.mContentTv.setText(c(cancelAccountItemBo.getContent()));
        }
    }

    public class ContentVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ContentVh f7513b;

        @UiThread
        public ContentVh_ViewBinding(ContentVh contentVh, View view) {
            this.f7513b = contentVh;
            contentVh.mContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_content, "field 'mContentTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ContentVh contentVh = this.f7513b;
            if (contentVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7513b = null;
            contentVh.mContentTv = null;
        }
    }

    public static class ReasonSelectVh extends BaseRecyclerViewHolder<CancelAccountItemBo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<CancelAccountItemBo> f7514f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public c.e.c.x.b.a f7515g;

        @BindView(R.id.cb_reason)
        public CheckBox mReasonCb;

        @BindView(R.id.tv_reason)
        public TextView mReasonTv;

        @BindView(R.id.edt_remark)
        public EditText mRemarkEdt;

        @BindView(R.id.tv_input_max_length_tip)
        public TextView mTipInputMaxLengthTv;

        public class a implements TextWatcher {
            public a() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int adapterPosition;
                if (!o.isNotEmpty(ReasonSelectVh.this.f7514f) || (adapterPosition = ReasonSelectVh.this.getAdapterPosition()) < 0) {
                    return;
                }
                String string = ReasonSelectVh.this.mRemarkEdt.getText().toString();
                int length = x.isNotNull(string) ? string.length() : 0;
                ((CancelAccountItemBo) ReasonSelectVh.this.f7514f.get(adapterPosition)).setRemarkValue(ReasonSelectVh.this.mRemarkEdt.getText().toString());
                ReasonSelectVh.this.mTipInputMaxLengthTv.setText(x.getString(R.string.placeholder_max_length, Integer.valueOf(length)));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        }

        public class b implements CompoundButton.OnCheckedChangeListener {
            public b() {
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int adapterPosition = ReasonSelectVh.this.getAdapterPosition();
                if (adapterPosition < 0 || ReasonSelectVh.this.f7515g == null) {
                    return;
                }
                ReasonSelectVh.this.f7515g.onCbChange(adapterPosition, true);
            }
        }

        public ReasonSelectVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mRemarkEdt.addTextChangedListener(new a());
            this.mReasonCb.setEnabled(false);
            this.mReasonCb.setOnCheckedChangeListener(new b());
        }

        public void i(CancelAccountItemBo cancelAccountItemBo) {
            this.mReasonTv.setText(c(cancelAccountItemBo.getReason()));
            this.mReasonCb.setChecked(cancelAccountItemBo.isCheck());
            this.mRemarkEdt.setText(c(cancelAccountItemBo.getRemarkValue()));
            this.mRemarkEdt.setVisibility(cancelAccountItemBo.isShowRemark() ? 0 : 8);
            this.mTipInputMaxLengthTv.setVisibility(cancelAccountItemBo.isShowRemark() ? 0 : 8);
        }

        public void setICbChangeCallback(c.e.c.x.b.a aVar) {
            this.f7515g = aVar;
        }

        public void setList(List<CancelAccountItemBo> list) {
            this.f7514f = list;
        }
    }

    public class ReasonSelectVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ReasonSelectVh f7518b;

        @UiThread
        public ReasonSelectVh_ViewBinding(ReasonSelectVh reasonSelectVh, View view) {
            this.f7518b = reasonSelectVh;
            reasonSelectVh.mReasonCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_reason, "field 'mReasonCb'", CheckBox.class);
            reasonSelectVh.mReasonTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_reason, "field 'mReasonTv'", TextView.class);
            reasonSelectVh.mTipInputMaxLengthTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_input_max_length_tip, "field 'mTipInputMaxLengthTv'", TextView.class);
            reasonSelectVh.mRemarkEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_remark, "field 'mRemarkEdt'", EditText.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ReasonSelectVh reasonSelectVh = this.f7518b;
            if (reasonSelectVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7518b = null;
            reasonSelectVh.mReasonCb = null;
            reasonSelectVh.mReasonTv = null;
            reasonSelectVh.mTipInputMaxLengthTv = null;
            reasonSelectVh.mRemarkEdt = null;
        }
    }

    public static class TitleContentVh extends BaseRecyclerViewHolder<CancelAccountItemBo> {

        @BindView(R.id.tv_subtitle)
        public TextView mContentTv;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public TitleContentVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(CancelAccountItemBo cancelAccountItemBo) {
            this.mTitleTv.setText(c(cancelAccountItemBo.getTitle()));
            this.mContentTv.setText(c(cancelAccountItemBo.getContent()));
        }
    }

    public class TitleContentVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TitleContentVh f7519b;

        @UiThread
        public TitleContentVh_ViewBinding(TitleContentVh titleContentVh, View view) {
            this.f7519b = titleContentVh;
            titleContentVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            titleContentVh.mContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_subtitle, "field 'mContentTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            TitleContentVh titleContentVh = this.f7519b;
            if (titleContentVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7519b = null;
            titleContentVh.mTitleTv = null;
            titleContentVh.mContentTv = null;
        }
    }

    public static class TitleVh extends BaseRecyclerViewHolder<CancelAccountItemBo> {

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public TitleVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(CancelAccountItemBo cancelAccountItemBo) {
            this.mTitleTv.setText(c(cancelAccountItemBo.getTitle()));
        }
    }

    public class TitleVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TitleVh f7520b;

        @UiThread
        public TitleVh_ViewBinding(TitleVh titleVh, View view) {
            this.f7520b = titleVh;
            titleVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            TitleVh titleVh = this.f7520b;
            if (titleVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7520b = null;
            titleVh.mTitleTv = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return o.isNotEmpty(this.f6460b) ? ((CancelAccountItemBo) this.f6460b.get(i2)).getItemType() : super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 1) {
            ((ContentVh) viewHolder).g((CancelAccountItemBo) this.f6460b.get(i2));
            return;
        }
        if (itemViewType == 2) {
            ((TitleVh) viewHolder).g((CancelAccountItemBo) this.f6460b.get(i2));
        } else if (itemViewType != 3) {
            ((ReasonSelectVh) viewHolder).i((CancelAccountItemBo) this.f6460b.get(i2));
        } else {
            ((TitleContentVh) viewHolder).g((CancelAccountItemBo) this.f6460b.get(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new ContentVh(i(viewGroup, R.layout.item_cancel_account_content));
        }
        if (i2 == 2) {
            return new TitleVh(i(viewGroup, R.layout.item_cancel_account_title));
        }
        if (i2 == 3) {
            return new TitleContentVh(i(viewGroup, R.layout.item_cancel_account_tip_content));
        }
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cancel_account_selected, viewGroup, false);
        ReasonSelectVh reasonSelectVh = new ReasonSelectVh(viewInflate);
        reasonSelectVh.setList(this.f6460b);
        reasonSelectVh.setICbChangeCallback(this.n);
        a(reasonSelectVh);
        viewInflate.setTag(reasonSelectVh);
        return reasonSelectVh;
    }

    public void setICbChangeCallback(a aVar) {
        this.n = aVar;
    }
}
