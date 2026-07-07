package com.chinavisionary.microtang.comment.adapter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
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
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.m.g.a;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.comment.vo.OptionItemVo;
import com.chinavisionary.microtang.comment.vo.ScoresBean;
import com.chinavisionary.microtang.order.vo.KeyValueVo;
import com.google.android.flexbox.FlexboxLayout;
import com.hedgehog.ratingbar.RatingBar;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NewCommentAdapter extends BaseRecyclerAdapter<a> {

    public class AddresVh extends SimpleRecyclerViewHolder<a> {

        @BindView(R.id.tv_room_address)
        public TextView leftTv;

        @BindView(R.id.tv_room_address_value)
        public TextView rightTv;

        public AddresVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(a aVar) {
            KeyValueVo keyValueVo = aVar.getKeyValueVo();
            if (keyValueVo != null) {
                this.leftTv.setText(c(keyValueVo.getKey()));
                this.rightTv.setText(c(keyValueVo.getValue()));
            }
        }
    }

    public class AddresVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AddresVh f6968b;

        @UiThread
        public AddresVh_ViewBinding(AddresVh addresVh, View view) {
            this.f6968b = addresVh;
            addresVh.leftTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_address, "field 'leftTv'", TextView.class);
            addresVh.rightTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_address_value, "field 'rightTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            AddresVh addresVh = this.f6968b;
            if (addresVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6968b = null;
            addresVh.leftTv = null;
            addresVh.rightTv = null;
        }
    }

    public class EditVh extends SimpleRecyclerViewHolder<c.e.c.m.g.a> {

        @BindView(R.id.tv_content_input_length)
        public TextView mContentInputLengthTv;

        @BindView(R.id.edt_comment_content)
        public EditText mEdtCommentContent;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public class a implements TextWatcher {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ NewCommentAdapter f6970a;

            public a(NewCommentAdapter newCommentAdapter) {
                this.f6970a = newCommentAdapter;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int length = EditVh.this.mEdtCommentContent.getText().toString().length();
                EditVh.this.mContentInputLengthTv.setText(length + "/200");
                int adapterPosition = EditVh.this.getAdapterPosition();
                if (adapterPosition >= 0) {
                    ((c.e.c.m.g.a) NewCommentAdapter.this.f6460b.get(adapterPosition)).getScoresBean().setInputContent(EditVh.this.mEdtCommentContent.getText().toString());
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        }

        public EditVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mEdtCommentContent.addTextChangedListener(new a(NewCommentAdapter.this));
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(c.e.c.m.g.a aVar) {
            ScoresBean scoresBean = aVar.getScoresBean();
            if (scoresBean != null) {
                this.mEdtCommentContent.setEnabled(scoresBean.isHasEdit());
                this.mEdtCommentContent.setText(c(scoresBean.getInputContent()));
                this.mTitleTv.setText(c(scoresBean.getScoreTypeDesc()));
            }
        }
    }

    public class EditVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public EditVh f6972b;

        @UiThread
        public EditVh_ViewBinding(EditVh editVh, View view) {
            this.f6972b = editVh;
            editVh.mEdtCommentContent = (EditText) d.findRequiredViewAsType(view, R.id.edt_comment_content, "field 'mEdtCommentContent'", EditText.class);
            editVh.mContentInputLengthTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_content_input_length, "field 'mContentInputLengthTv'", TextView.class);
            editVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            EditVh editVh = this.f6972b;
            if (editVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6972b = null;
            editVh.mEdtCommentContent = null;
            editVh.mContentInputLengthTv = null;
            editVh.mTitleTv = null;
        }
    }

    public class RadioVh extends SimpleRecyclerViewHolder<c.e.c.m.g.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Drawable f6973f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Drawable f6974g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ViewGroup.MarginLayoutParams f6975h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f6976i;
        public int j;
        public final View.OnClickListener k;

        @BindView(R.id.flexbox_layout)
        public FlexboxLayout mFlexboxLayout;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int iIntValue = ((Integer) view.getTag()).intValue();
                int iIntValue2 = ((Integer) view.getTag(R.id.id_radio_tag)).intValue();
                if (iIntValue2 < 0 || iIntValue < 0) {
                    return;
                }
                List<OptionItemVo> options = ((c.e.c.m.g.a) NewCommentAdapter.this.f6460b.get(iIntValue2)).getScoresBean().getOptions();
                int size = options.size();
                int i2 = 0;
                while (i2 < size) {
                    options.get(i2).setIfSelect(i2 == iIntValue);
                    i2++;
                }
                NewCommentAdapter.this.notifyItemChanged(iIntValue2);
            }
        }

        public RadioVh(View view) {
            super(view);
            this.f6976i = 15;
            this.j = 40;
            this.k = new a();
            ButterKnife.bind(this, view);
            this.f6976i = view.getResources().getDimensionPixelSize(R.dimen.dp_10);
            this.j = view.getResources().getDimensionPixelSize(R.dimen.dp_40);
            this.f6973f = view.getResources().getDrawable(R.mipmap.ic_radio_nomarl);
            this.f6974g = view.getResources().getDrawable(R.mipmap.ic_radio_sel);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, view.getResources().getDimensionPixelSize(R.dimen.dp_30));
            this.f6975h = marginLayoutParams;
            marginLayoutParams.rightMargin = this.j;
        }

        public final void g(OptionItemVo optionItemVo, int i2, int i3, boolean z) {
            TextView textView = new TextView(this.mFlexboxLayout.getContext());
            if (z) {
                textView.setOnClickListener(this.k);
            }
            textView.setId(R.id.id_radio_tag);
            textView.setTag(Integer.valueOf(i3));
            textView.setTag(R.id.id_radio_tag, Integer.valueOf(i2));
            textView.setText(optionItemVo.getValue());
            textView.setLayoutParams(this.f6975h);
            textView.setTextSize(14.0f);
            textView.setGravity(17);
            textView.setCompoundDrawablePadding(this.f6976i);
            if (optionItemVo.isIfSelect()) {
                textView.setCompoundDrawablesWithIntrinsicBounds(this.f6974g, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(this.f6973f, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            int i4 = this.f6976i;
            textView.setPadding(i4, 0, i4, 0);
            textView.setTextColor(this.mFlexboxLayout.getResources().getColor(R.color.color_333333));
            this.mFlexboxLayout.addView(textView);
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(c.e.c.m.g.a aVar) {
            ScoresBean scoresBean = aVar.getScoresBean();
            this.mFlexboxLayout.removeAllViews();
            if (scoresBean != null) {
                int adapterPosition = getAdapterPosition();
                this.mTitleTv.setText(adapterPosition + "、" + scoresBean.getScoreTypeDesc());
                List<OptionItemVo> options = scoresBean.getOptions();
                if (o.isNotEmpty(options)) {
                    int size = options.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        g(options.get(i2), adapterPosition, i2, scoresBean.isHasEdit());
                    }
                }
            }
        }
    }

    public class RadioVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RadioVh f6978b;

        @UiThread
        public RadioVh_ViewBinding(RadioVh radioVh, View view) {
            this.f6978b = radioVh;
            radioVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            radioVh.mFlexboxLayout = (FlexboxLayout) d.findRequiredViewAsType(view, R.id.flexbox_layout, "field 'mFlexboxLayout'", FlexboxLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            RadioVh radioVh = this.f6978b;
            if (radioVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6978b = null;
            radioVh.mTitleTv = null;
            radioVh.mFlexboxLayout = null;
        }
    }

    public class ScoreVh extends SimpleRecyclerViewHolder<a> {

        @BindView(R.id.tv_tip_praise_level)
        public TextView mLevelTv;

        @BindView(R.id.rating_bar_praise)
        public RatingBar mRatingBar;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public ScoreVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mRatingBar.setOnRatingChangeListener(new RatingBar.b() { // from class: c.e.c.m.a.a
                @Override // com.hedgehog.ratingbar.RatingBar.b
                public final void onRatingChange(float f2) {
                    this.f1652a.i(f2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(float f2) {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition >= 0) {
                ((a) NewCommentAdapter.this.f6460b.get(adapterPosition)).getScoresBean().setScore(f2);
            }
            this.mLevelTv.setText(g(f2));
        }

        public final String g(float f2) {
            return f2 <= 1.0f ? x.getString(R.string.title_very_difference) : f2 <= 2.0f ? x.getString(R.string.title_difference) : f2 <= 3.0f ? x.getString(R.string.title_commonly) : f2 <= 4.0f ? x.getString(R.string.title_good) : f2 <= 5.0f ? x.getString(R.string.title_very_good) : "";
        }

        public final void j(RatingBar ratingBar, float f2) {
            ratingBar.setStar(f2);
            q.d("ScoreVh", "updateRatingIcon ratingCount = " + f2);
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(a aVar) {
            ScoresBean scoresBean = aVar.getScoresBean();
            if (scoresBean != null) {
                this.mTitleTv.setText(getAdapterPosition() + "、" + c(scoresBean.getScoreTypeDesc()));
                this.mRatingBar.setmClickable(scoresBean.isHasEdit());
                j(this.mRatingBar, scoresBean.getScore());
            }
        }
    }

    public class ScoreVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ScoreVh f6980b;

        @UiThread
        public ScoreVh_ViewBinding(ScoreVh scoreVh, View view) {
            this.f6980b = scoreVh;
            scoreVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            scoreVh.mLevelTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_tip_praise_level, "field 'mLevelTv'", TextView.class);
            scoreVh.mRatingBar = (RatingBar) d.findRequiredViewAsType(view, R.id.rating_bar_praise, "field 'mRatingBar'", RatingBar.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ScoreVh scoreVh = this.f6980b;
            if (scoreVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6980b = null;
            scoreVh.mTitleTv = null;
            scoreVh.mLevelTv = null;
            scoreVh.mRatingBar = null;
        }
    }

    public class SeekBarVh extends SimpleRecyclerViewHolder<c.e.c.m.g.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Bitmap f6981f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Canvas f6982g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Paint f6983h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Paint f6984i;
        public Paint j;

        @BindView(R.id.tv_tip_praise_level)
        public TextView mLevelTv;

        @BindView(R.id.seek_bar)
        public SeekBar mSeekBar;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public class a implements SeekBar.OnSeekBarChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ NewCommentAdapter f6985a;

            public a(NewCommentAdapter newCommentAdapter) {
                this.f6985a = newCommentAdapter;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                SeekBarVh.this.k(i2);
                int adapterPosition = SeekBarVh.this.getAdapterPosition();
                if (adapterPosition >= 0) {
                    ((c.e.c.m.g.a) NewCommentAdapter.this.f6460b.get(adapterPosition)).getScoresBean().setScore(i2);
                }
                SeekBarVh seekBarVh = SeekBarVh.this;
                seekBarVh.mLevelTv.setText(seekBarVh.i(i2));
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        }

        public SeekBarVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            j();
            this.mSeekBar.setOnSeekBarChangeListener(new a(NewCommentAdapter.this));
        }

        public final String i(float f2) {
            return f2 <= 6.0f ? "不愿意" : (f2 > 7.0f && f2 > 8.0f) ? (f2 > 9.0f && f2 > 10.0f) ? "" : "非常愿意" : "愿意";
        }

        public final void j() {
            this.f6981f = Bitmap.createBitmap(56, 56, Bitmap.Config.ARGB_8888);
            this.f6982g = new Canvas(this.f6981f);
            Paint paint = new Paint();
            this.f6983h = paint;
            paint.setStyle(Paint.Style.FILL);
            this.f6983h.setColor(Color.parseColor("#FE9A02"));
            this.f6983h.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.j = paint2;
            paint2.setTextSize(30.0f);
            this.j.setColor(-1);
            this.j.setAntiAlias(true);
            this.j.setTextAlign(Paint.Align.CENTER);
            Paint paint3 = new Paint();
            this.f6984i = paint3;
            paint3.setColor(-1);
            this.f6984i.setAntiAlias(true);
            this.f6984i.setStyle(Paint.Style.STROKE);
            this.f6984i.setStrokeWidth(4.0f);
        }

        public final void k(int i2) {
            this.f6982g.drawColor(0);
            float width = this.f6981f.getWidth() / 2.0f;
            float height = this.f6981f.getHeight() / 2.0f;
            this.f6982g.drawCircle(width, height, this.f6981f.getWidth() / 2.0f, this.f6983h);
            this.f6982g.drawText(i2 == 0 ? "" : String.valueOf(i2), width, (height - ((this.f6983h.descent() + this.f6983h.ascent()) / 2.0f)) + 5.0f, this.j);
            this.mSeekBar.setThumb(new BitmapDrawable(this.mSeekBar.getResources(), this.f6981f));
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(c.e.c.m.g.a aVar) {
            ScoresBean scoresBean = aVar.getScoresBean();
            if (scoresBean != null) {
                this.mSeekBar.setEnabled(scoresBean.isHasEdit());
                this.mLevelTv.setVisibility(scoresBean.isHasEdit() ? 0 : 8);
                this.mSeekBar.setProgress((int) scoresBean.getScore());
                this.mTitleTv.setText(getAdapterPosition() + "、" + c(scoresBean.getScoreTypeDesc()));
                k((int) scoresBean.getScore());
            }
        }
    }

    public class SeekBarVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SeekBarVh f6987b;

        @UiThread
        public SeekBarVh_ViewBinding(SeekBarVh seekBarVh, View view) {
            this.f6987b = seekBarVh;
            seekBarVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            seekBarVh.mSeekBar = (SeekBar) d.findRequiredViewAsType(view, R.id.seek_bar, "field 'mSeekBar'", SeekBar.class);
            seekBarVh.mLevelTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_tip_praise_level, "field 'mLevelTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            SeekBarVh seekBarVh = this.f6987b;
            if (seekBarVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6987b = null;
            seekBarVh.mTitleTv = null;
            seekBarVh.mSeekBar = null;
            seekBarVh.mLevelTv = null;
        }
    }

    public class TagVh extends SimpleRecyclerViewHolder<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ViewGroup.MarginLayoutParams f6988f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f6989g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final View.OnClickListener f6990h;

        @BindView(R.id.flexbox_layout)
        public FlexboxLayout mFlexboxLayout;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public TagVh(View view) {
            super(view);
            this.f6989g = 15;
            this.f6990h = new View.OnClickListener() { // from class: c.e.c.m.a.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f1653a.i(view2);
                }
            };
            ButterKnife.bind(this, view);
            this.f6989g = view.getResources().getDimensionPixelSize(R.dimen.dp_6);
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.dp_10);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, view.getResources().getDimensionPixelSize(R.dimen.dp_30));
            this.f6988f = marginLayoutParams;
            marginLayoutParams.topMargin = dimensionPixelSize;
            marginLayoutParams.rightMargin = dimensionPixelSize;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void i(View view) {
            int i2;
            int iIntValue = ((Integer) view.getTag()).intValue();
            int adapterPosition = getAdapterPosition();
            if (adapterPosition < 0 || iIntValue < 0 || (i2 = adapterPosition + 1) >= NewCommentAdapter.this.f6460b.size()) {
                return;
            }
            String value = ((a) NewCommentAdapter.this.f6460b.get(adapterPosition)).getScoresBean().getOptions().get(iIntValue).getValue();
            ScoresBean scoresBean = ((a) NewCommentAdapter.this.f6460b.get(i2)).getScoresBean();
            String inputContent = scoresBean.getInputContent();
            if (x.isNotNull(inputContent)) {
                scoresBean.setInputContent(inputContent + "," + value);
            } else {
                scoresBean.setInputContent(value);
            }
            NewCommentAdapter.this.notifyItemChanged(i2);
        }

        public final void g(OptionItemVo optionItemVo, int i2) {
            TextView textView = new TextView(this.mFlexboxLayout.getContext());
            textView.setOnClickListener(this.f6990h);
            textView.setTag(Integer.valueOf(i2));
            textView.setText(optionItemVo.getValue());
            textView.setLayoutParams(this.f6988f);
            textView.setTextSize(14.0f);
            textView.setGravity(17);
            textView.setBackgroundResource(R.drawable.bg_btn_store_6_radius);
            int i3 = this.f6989g;
            textView.setPadding(i3, 0, i3, 0);
            textView.setTextColor(this.mFlexboxLayout.getResources().getColor(R.color.tab_item_select_color));
            this.mFlexboxLayout.addView(textView);
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(a aVar) {
            ScoresBean scoresBean = aVar.getScoresBean();
            this.mFlexboxLayout.removeAllViews();
            if (scoresBean != null) {
                this.mTitleTv.setText(getAdapterPosition() + "、" + c(scoresBean.getScoreTypeDesc()));
                List<OptionItemVo> options = scoresBean.getOptions();
                if (o.isNotEmpty(options)) {
                    int size = options.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        g(options.get(i2), i2);
                    }
                }
            }
        }
    }

    public class TagVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TagVh f6992b;

        @UiThread
        public TagVh_ViewBinding(TagVh tagVh, View view) {
            this.f6992b = tagVh;
            tagVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            tagVh.mFlexboxLayout = (FlexboxLayout) d.findRequiredViewAsType(view, R.id.flexbox_layout, "field 'mFlexboxLayout'", FlexboxLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            TagVh tagVh = this.f6992b;
            if (tagVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6992b = null;
            tagVh.mTitleTv = null;
            tagVh.mFlexboxLayout = null;
        }
    }

    public final SeekBarVh A(ViewGroup viewGroup) {
        return new SeekBarVh(i(viewGroup, R.layout.item_comment_seek_bar));
    }

    public final TagVh B(ViewGroup viewGroup) {
        return new TagVh(i(viewGroup, R.layout.item_comment_assistant_edit));
    }

    public final void C(RecyclerView.ViewHolder viewHolder, int i2) {
        ((AddresVh) viewHolder).setupData((a) this.f6460b.get(i2));
    }

    public final void D(RecyclerView.ViewHolder viewHolder, int i2) {
        ((EditVh) viewHolder).setupData((a) this.f6460b.get(i2));
    }

    public final void E(RecyclerView.ViewHolder viewHolder, int i2) {
        ((RadioVh) viewHolder).setupData((a) this.f6460b.get(i2));
    }

    public final void F(RecyclerView.ViewHolder viewHolder, int i2) {
        ((ScoreVh) viewHolder).setupData((a) this.f6460b.get(i2));
    }

    public final void G(RecyclerView.ViewHolder viewHolder, int i2) {
        ((SeekBarVh) viewHolder).setupData((a) this.f6460b.get(i2));
    }

    public final void H(RecyclerView.ViewHolder viewHolder, int i2) {
        ((TagVh) viewHolder).setupData((a) this.f6460b.get(i2));
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return ((a) this.f6460b.get(i2)).getItemType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 1) {
            E(viewHolder, i2);
            return;
        }
        if (itemViewType == 2) {
            F(viewHolder, i2);
            return;
        }
        if (itemViewType == 3) {
            G(viewHolder, i2);
            return;
        }
        if (itemViewType == 4) {
            D(viewHolder, i2);
        } else if (itemViewType == 5) {
            H(viewHolder, i2);
        } else {
            if (itemViewType != 7) {
                return;
            }
            C(viewHolder, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 7 ? new BaseRecyclerAdapter.EmptyViewHolder(i(viewGroup, R.layout.empty_view)) : w(viewGroup) : B(viewGroup) : x(viewGroup) : A(viewGroup) : z(viewGroup) : y(viewGroup);
    }

    public final AddresVh w(ViewGroup viewGroup) {
        return new AddresVh(i(viewGroup, R.layout.item_commend_address));
    }

    public final EditVh x(ViewGroup viewGroup) {
        return new EditVh(i(viewGroup, R.layout.item_comment_edit));
    }

    public final RadioVh y(ViewGroup viewGroup) {
        return new RadioVh(i(viewGroup, R.layout.item_comment_radio));
    }

    public final ScoreVh z(ViewGroup viewGroup) {
        return new ScoreVh(i(viewGroup, R.layout.item_comment_score));
    }
}
