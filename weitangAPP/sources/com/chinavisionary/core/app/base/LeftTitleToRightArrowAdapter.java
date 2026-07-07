package com.chinavisionary.core.app.base;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.a.c.c.b;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.R;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LeftTitleToRightArrowAdapter extends BaseRecyclerAdapter<LeftTitleToRightArrowVo> {
    public boolean n = true;
    public b o;

    public static class ItemSwitchVh extends BaseRecyclerViewHolder<LeftTitleToRightArrowVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<LeftTitleToRightArrowVo> f6497f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public b f6498g;

        @BindView(2829)
        public TextView mLeftTv;

        @BindView(2546)
        public Switch mRightSwitch;

        @BindView(2857)
        public View mSplitLineView;

        public class a implements CompoundButton.OnCheckedChangeListener {
            public a() {
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (ItemSwitchVh.this.f6468a >= 0) {
                    if (ItemSwitchVh.this.f6497f != null) {
                        ((LeftTitleToRightArrowVo) ItemSwitchVh.this.f6497f.get(ItemSwitchVh.this.f6468a)).setSelectRadio(z);
                    }
                    if (ItemSwitchVh.this.f6498g != null) {
                        ItemSwitchVh.this.f6498g.onChangeResult(ItemSwitchVh.this.f6468a, z);
                    }
                }
            }
        }

        public ItemSwitchVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mRightSwitch.setOnCheckedChangeListener(new a());
        }

        public void setISwitchChangeCallback(b bVar) {
            this.f6498g = bVar;
        }

        public void setLeftTitleToRightArrowVos(List<LeftTitleToRightArrowVo> list) {
            this.f6497f = list;
        }

        public void setData(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            int leftFontColor = leftTitleToRightArrowVo.getLeftFontColor();
            this.mLeftTv.setText(c(leftTitleToRightArrowVo.getLeft()));
            this.mRightSwitch.setChecked(leftTitleToRightArrowVo.isSelectRadio());
            TextView textView = this.mLeftTv;
            Resources resources = textView.getResources();
            if (leftFontColor <= 0) {
                leftFontColor = R.color.color555555;
            }
            textView.setTextColor(resources.getColor(leftFontColor));
            int i2 = getAdapterPosition() == this.f6472e ? 8 : 0;
            int i3 = (leftTitleToRightArrowVo.isShowSplitLine() || i2 != 0) ? i2 : 8;
            if (this.mSplitLineView.getVisibility() != i3) {
                this.mSplitLineView.setVisibility(i3);
            }
        }
    }

    public class ItemSwitchVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ItemSwitchVh f6500b;

        @UiThread
        public ItemSwitchVh_ViewBinding(ItemSwitchVh itemSwitchVh, View view) {
            this.f6500b = itemSwitchVh;
            itemSwitchVh.mSplitLineView = d.findRequiredView(view, R.id.view_split_line, "field 'mSplitLineView'");
            itemSwitchVh.mLeftTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_left_title, "field 'mLeftTv'", TextView.class);
            itemSwitchVh.mRightSwitch = (Switch) d.findRequiredViewAsType(view, R.id.switch_compat, "field 'mRightSwitch'", Switch.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ItemSwitchVh itemSwitchVh = this.f6500b;
            if (itemSwitchVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6500b = null;
            itemSwitchVh.mSplitLineView = null;
            itemSwitchVh.mLeftTv = null;
            itemSwitchVh.mRightSwitch = null;
        }
    }

    public static class ItemWhiteVh extends BaseRecyclerViewHolder<LeftTitleToRightArrowVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Drawable f6501f;

        @BindView(2806)
        public TextView mCenterTv;

        @BindView(2829)
        public TextView mLeftTv;

        @BindView(2838)
        public TextView mRightTv;

        @BindView(2857)
        public View mSplitLineView;

        public ItemWhiteVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.f6501f = view.getResources().getDrawable(R.drawable.core_lib_ic_item_arrow_right_gray);
        }

        public void setData(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            int leftFontColor = leftTitleToRightArrowVo.getLeftFontColor();
            int centerFontColor = leftTitleToRightArrowVo.getCenterFontColor();
            int rightFontColor = leftTitleToRightArrowVo.getRightFontColor();
            this.mLeftTv.setText(c(leftTitleToRightArrowVo.getLeft()));
            this.mRightTv.setText(c(leftTitleToRightArrowVo.getRight()));
            this.mCenterTv.setText(c(leftTitleToRightArrowVo.getCenter()));
            TextView textView = this.mLeftTv;
            Resources resources = textView.getResources();
            if (leftFontColor <= 0) {
                leftFontColor = R.color.color555555;
            }
            textView.setTextColor(resources.getColor(leftFontColor));
            TextView textView2 = this.mCenterTv;
            Resources resources2 = textView2.getResources();
            if (centerFontColor <= 0) {
                centerFontColor = R.color.color555555;
            }
            textView2.setTextColor(resources2.getColor(centerFontColor));
            TextView textView3 = this.mRightTv;
            Resources resources3 = this.mCenterTv.getResources();
            if (rightFontColor <= 0) {
                rightFontColor = R.color.color555555;
            }
            textView3.setTextColor(resources3.getColor(rightFontColor));
            this.mRightTv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, leftTitleToRightArrowVo.isShowArrow() ? this.f6501f : null, (Drawable) null);
            int i2 = getAdapterPosition() == this.f6472e ? 8 : 0;
            int i3 = (leftTitleToRightArrowVo.isShowSplitLine() || i2 != 0) ? i2 : 8;
            if (this.mSplitLineView.getVisibility() != i3) {
                this.mSplitLineView.setVisibility(i3);
            }
        }
    }

    public class ItemWhiteVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ItemWhiteVh f6502b;

        @UiThread
        public ItemWhiteVh_ViewBinding(ItemWhiteVh itemWhiteVh, View view) {
            this.f6502b = itemWhiteVh;
            itemWhiteVh.mSplitLineView = d.findRequiredView(view, R.id.view_split_line, "field 'mSplitLineView'");
            itemWhiteVh.mLeftTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_left_title, "field 'mLeftTv'", TextView.class);
            itemWhiteVh.mRightTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_right_value, "field 'mRightTv'", TextView.class);
            itemWhiteVh.mCenterTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_center, "field 'mCenterTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ItemWhiteVh itemWhiteVh = this.f6502b;
            if (itemWhiteVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6502b = null;
            itemWhiteVh.mSplitLineView = null;
            itemWhiteVh.mLeftTv = null;
            itemWhiteVh.mRightTv = null;
            itemWhiteVh.mCenterTv = null;
        }
    }

    public static class LeftTitleToRightArrowVH extends BaseRecyclerViewHolder<LeftTitleToRightArrowVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f6503f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f6504g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public View.OnClickListener f6505h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List<LeftTitleToRightArrowVo> f6506i;
        public TextWatcher j;

        @BindView(2481)
        public AppCompatRadioButton mAppCompatRadioButton;

        @BindView(2854)
        public View mBgView;

        @BindView(2806)
        public TextView mCenterTv;

        @BindView(2329)
        public EditText mInputEdt;

        @BindView(2828)
        public TextView mLeftTv;

        @BindView(2836)
        public TextView mRequiredTv;

        @BindView(2372)
        public ImageView mRightArrowImg;

        @BindView(2838)
        public TextView mRightTv;

        @BindView(2857)
        public View mSplitLineView;

        public class a implements TextWatcher {
            public a() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (LeftTitleToRightArrowVH.this.f6506i == null || !((LeftTitleToRightArrowVo) LeftTitleToRightArrowVH.this.f6506i.get(LeftTitleToRightArrowVH.this.f6503f)).isEdit()) {
                    return;
                }
                ((LeftTitleToRightArrowVo) LeftTitleToRightArrowVH.this.f6506i.get(LeftTitleToRightArrowVH.this.f6503f)).setRight(LeftTitleToRightArrowVH.this.mInputEdt.getText().toString());
            }
        }

        public LeftTitleToRightArrowVH(View view) {
            super(view);
            this.j = new a();
            ButterKnife.bind(this, view);
        }

        public void i(boolean z) {
            this.f6504g = z;
            if (z) {
                return;
            }
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.mLeftTv.getLayoutParams())).leftMargin = 0;
        }

        public final void j(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            this.mCenterTv.setVisibility(x.isNotNull(leftTitleToRightArrowVo.getCenter()) ? 0 : 8);
            this.mCenterTv.setText(x.getNotNullStr(leftTitleToRightArrowVo.getCenter(), ""));
        }

        public final void k(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            this.mBgView.setVisibility(leftTitleToRightArrowVo.isTitle() ? 0 : 8);
            this.mRequiredTv.setVisibility(leftTitleToRightArrowVo.isRequired() ? 0 : 8);
            this.mRightArrowImg.setVisibility(leftTitleToRightArrowVo.isShowArrow() ? 0 : 8);
        }

        public final void l(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            this.mInputEdt.setVisibility(leftTitleToRightArrowVo.isEdit() ? 0 : 8);
            this.mInputEdt.setText(x.getNotNullStr(leftTitleToRightArrowVo.getRight(), ""));
            if (leftTitleToRightArrowVo.isEdit()) {
                this.mInputEdt.removeTextChangedListener(this.j);
                this.mInputEdt.addTextChangedListener(this.j);
                if (x.isNotNull(leftTitleToRightArrowVo.getDigits())) {
                    this.mInputEdt.setKeyListener(DigitsKeyListener.getInstance(leftTitleToRightArrowVo.getDigits()));
                } else {
                    this.mInputEdt.setInputType(leftTitleToRightArrowVo.getInputType());
                }
                if (leftTitleToRightArrowVo.getMaxLength() != -1) {
                    this.mInputEdt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(leftTitleToRightArrowVo.getMaxLength())});
                } else {
                    this.mInputEdt.setFilters(new InputFilter[0]);
                }
                this.mInputEdt.setHint(x.getNotNullStr(leftTitleToRightArrowVo.getHint(), ""));
            }
        }

        public final void m(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            int leftFontColor = leftTitleToRightArrowVo.getLeftFontColor();
            this.mLeftTv.setVisibility(leftTitleToRightArrowVo.isShowRadio() ? 8 : 0);
            this.mLeftTv.setText(x.getNotNullStr(leftTitleToRightArrowVo.isTitle() ? leftTitleToRightArrowVo.getTitle() : leftTitleToRightArrowVo.getLeft(), ""));
            TextView textView = this.mLeftTv;
            Resources resources = this.mRightTv.getResources();
            if (leftFontColor <= 0) {
                leftFontColor = R.color.color383838;
            }
            textView.setTextColor(resources.getColor(leftFontColor));
        }

        public final void n(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            this.mAppCompatRadioButton.setVisibility(leftTitleToRightArrowVo.isShowRadio() ? 0 : 8);
            this.mAppCompatRadioButton.setChecked(leftTitleToRightArrowVo.isSelectRadio());
            this.mAppCompatRadioButton.setText(x.getNotNullStr(leftTitleToRightArrowVo.getLeft(), ""));
            this.mAppCompatRadioButton.setTag(Integer.valueOf(this.f6503f));
            if (leftTitleToRightArrowVo.isShowRadio()) {
                this.mAppCompatRadioButton.setOnClickListener(null);
                this.mAppCompatRadioButton.setOnClickListener(this.f6505h);
            }
        }

        public final void o(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            this.mRightTv.setAutoLinkMask(leftTitleToRightArrowVo.getAutoLink());
            this.mRightTv.setVisibility(leftTitleToRightArrowVo.isEdit() ? 8 : 0);
            boolean zIsPrice = leftTitleToRightArrowVo.isPrice();
            boolean zIsShowRmbUnit = leftTitleToRightArrowVo.isShowRmbUnit();
            String string = zIsPrice ? x.getString(R.string.core_lib_rmb_china_unit) : "";
            String string2 = zIsShowRmbUnit ? x.getString(R.string.core_lib_rmb_unit) : "";
            this.mRightTv.setText(string2 + x.getNotNullStr(leftTitleToRightArrowVo.getRight(), "") + string);
            int i2 = zIsPrice ? R.color.image_color_red : R.color.color383838;
            int rightFontColor = leftTitleToRightArrowVo.getRightFontColor();
            boolean zIsTime = leftTitleToRightArrowVo.isTime();
            String right = leftTitleToRightArrowVo.getRight();
            if (zIsTime && x.isNumeric(right)) {
                this.mRightTv.setText(z.getTime(Long.valueOf(Long.parseLong(right)), leftTitleToRightArrowVo.getSimpleDateFormat()));
            }
            if (x.isNullStr(leftTitleToRightArrowVo.getRight())) {
                this.mRightTv.setHint(x.getNotNullStr(leftTitleToRightArrowVo.getHint(), ""));
            }
            TextView textView = this.mRightTv;
            Resources resources = textView.getResources();
            if (rightFontColor > 0) {
                i2 = rightFontColor;
            }
            textView.setTextColor(resources.getColor(i2));
        }

        public final void p(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            this.mSplitLineView.setVisibility(leftTitleToRightArrowVo.isShowSplitLine() ? 0 : 8);
            this.mSplitLineView.getLayoutParams().height = leftTitleToRightArrowVo.getSplitLineHeight();
        }

        public void setData(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            k(leftTitleToRightArrowVo);
            j(leftTitleToRightArrowVo);
            n(leftTitleToRightArrowVo);
            m(leftTitleToRightArrowVo);
            o(leftTitleToRightArrowVo);
            l(leftTitleToRightArrowVo);
            p(leftTitleToRightArrowVo);
        }

        public void setLeftTitleToRightArrowVos(List<LeftTitleToRightArrowVo> list) {
            this.f6506i = list;
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f6505h = onClickListener;
        }

        public void setPosition(int i2) {
            this.f6503f = i2;
        }
    }

    public class LeftTitleToRightArrowVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LeftTitleToRightArrowVH f6508b;

        @UiThread
        public LeftTitleToRightArrowVH_ViewBinding(LeftTitleToRightArrowVH leftTitleToRightArrowVH, View view) {
            this.f6508b = leftTitleToRightArrowVH;
            leftTitleToRightArrowVH.mBgView = d.findRequiredView(view, R.id.view_bg, "field 'mBgView'");
            leftTitleToRightArrowVH.mLeftTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_left, "field 'mLeftTv'", TextView.class);
            leftTitleToRightArrowVH.mCenterTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_center, "field 'mCenterTv'", TextView.class);
            leftTitleToRightArrowVH.mRequiredTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_required, "field 'mRequiredTv'", TextView.class);
            leftTitleToRightArrowVH.mRightArrowImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_right_icon, "field 'mRightArrowImg'", ImageView.class);
            leftTitleToRightArrowVH.mInputEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_input, "field 'mInputEdt'", EditText.class);
            leftTitleToRightArrowVH.mRightTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_right_value, "field 'mRightTv'", TextView.class);
            leftTitleToRightArrowVH.mAppCompatRadioButton = (AppCompatRadioButton) d.findRequiredViewAsType(view, R.id.radio_btn, "field 'mAppCompatRadioButton'", AppCompatRadioButton.class);
            leftTitleToRightArrowVH.mSplitLineView = d.findRequiredView(view, R.id.view_split_line, "field 'mSplitLineView'");
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            LeftTitleToRightArrowVH leftTitleToRightArrowVH = this.f6508b;
            if (leftTitleToRightArrowVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6508b = null;
            leftTitleToRightArrowVH.mBgView = null;
            leftTitleToRightArrowVH.mLeftTv = null;
            leftTitleToRightArrowVH.mCenterTv = null;
            leftTitleToRightArrowVH.mRequiredTv = null;
            leftTitleToRightArrowVH.mRightArrowImg = null;
            leftTitleToRightArrowVH.mInputEdt = null;
            leftTitleToRightArrowVH.mRightTv = null;
            leftTitleToRightArrowVH.mAppCompatRadioButton = null;
            leftTitleToRightArrowVH.mSplitLineView = null;
        }
    }

    public static class LineVh extends BaseRecyclerViewHolder<LeftTitleToRightArrowVo> {

        @BindView(2402)
        public View mSplitLineView;

        public LineVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setData(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            if (leftTitleToRightArrowVo.getBgColor() != 0) {
                View view = this.mSplitLineView;
                view.setBackgroundColor(view.getResources().getColor(leftTitleToRightArrowVo.getBgColor()));
            }
            if (leftTitleToRightArrowVo.getSplitLineHeight() != 0) {
                this.mSplitLineView.getLayoutParams().height = leftTitleToRightArrowVo.getSplitLineHeight();
            }
        }
    }

    public class LineVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LineVh f6509b;

        @UiThread
        public LineVh_ViewBinding(LineVh lineVh, View view) {
            this.f6509b = lineVh;
            lineVh.mSplitLineView = d.findRequiredView(view, R.id.lib_view_split_line, "field 'mSplitLineView'");
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            LineVh lineVh = this.f6509b;
            if (lineVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6509b = null;
            lineVh.mSplitLineView = null;
        }
    }

    public LeftTitleToRightArrowAdapter() {
        p();
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.f6466h != null && i2 == 0) {
            return 26214;
        }
        if (this.f6463e && i2 == getItemCount() - 1) {
            return 39321;
        }
        List<T> list = this.f6460b;
        return (list == 0 || list.isEmpty()) ? super.getItemViewType(i2) : ((LeftTitleToRightArrowVo) this.f6460b.get(i2 - h())).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == -4) {
            ItemSwitchVh itemSwitchVh = (ItemSwitchVh) viewHolder;
            itemSwitchVh.setListPosition(i2 - h());
            itemSwitchVh.setData((LeftTitleToRightArrowVo) this.f6460b.get(i2 - h()));
            return;
        }
        if (itemViewType == -3) {
            ((ItemWhiteVh) viewHolder).setData((LeftTitleToRightArrowVo) this.f6460b.get(i2 - h()));
            return;
        }
        if (itemViewType == -2) {
            ((LineVh) viewHolder).setData((LeftTitleToRightArrowVo) this.f6460b.get(i2 - h()));
            return;
        }
        if (itemViewType != -1) {
            if (itemViewType == 26214 || itemViewType == 34952 || itemViewType == 39321) {
                return;
            }
            q(viewHolder, i2 - h());
            return;
        }
        LeftTitleToRightArrowVH leftTitleToRightArrowVH = (LeftTitleToRightArrowVH) viewHolder;
        leftTitleToRightArrowVH.setPosition(i2 - h());
        leftTitleToRightArrowVH.setLeftTitleToRightArrowVos(this.f6460b);
        leftTitleToRightArrowVH.setData((LeftTitleToRightArrowVo) this.f6460b.get(i2 - h()));
        b(leftTitleToRightArrowVH, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter$ItemSwitchVh] */
    /* JADX WARN: Type inference failed for: r4v3 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        ?? lineVh;
        if (i2 == -4) {
            ?? itemSwitchVh = new ItemSwitchVh(i(viewGroup, R.layout.core_lib_item_left_right_sw_layout));
            itemSwitchVh.setISwitchChangeCallback(this.o);
            itemSwitchVh.setLeftTitleToRightArrowVos(this.f6460b);
            lineVh = itemSwitchVh;
        } else if (i2 == -3) {
            ItemWhiteVh itemWhiteVh = new ItemWhiteVh(i(viewGroup, R.layout.core_lib_item_left_right_tv_layout));
            a(itemWhiteVh);
            lineVh = itemWhiteVh;
        } else if (i2 == -2) {
            lineVh = new LineVh(i(viewGroup, R.layout.core_lib_line_layout));
        } else if (i2 == -1) {
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.core_lib_item_left_tv_right_multiple_layout, viewGroup, false);
            LeftTitleToRightArrowVH leftTitleToRightArrowVH = new LeftTitleToRightArrowVH(viewInflate);
            leftTitleToRightArrowVH.i(this.n);
            leftTitleToRightArrowVH.setOnClickListener(this.f6461c);
            viewInflate.setTag(leftTitleToRightArrowVH);
            lineVh = leftTitleToRightArrowVH;
        } else {
            if (i2 == 26214) {
                return new BaseRecyclerAdapter.RecyclerHeadViewHodler(this.f6466h);
            }
            if (i2 == 34952) {
                lineVh = new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
            } else {
                if (i2 != 39321) {
                    return r(viewGroup, i2);
                }
                lineVh = new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
            }
        }
        return lineVh;
    }

    public final void p() {
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setType(34952);
        addDataToList(leftTitleToRightArrowVo);
    }

    public void q(RecyclerView.ViewHolder viewHolder, int i2) {
    }

    public RecyclerView.ViewHolder r(ViewGroup viewGroup, int i2) {
        return null;
    }

    public void setISwitchChangeCallback(b bVar) {
        this.o = bVar;
    }

    public void setSetLeftPadding(boolean z) {
        this.n = z;
    }
}
