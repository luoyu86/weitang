package com.chinavisionary.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import c.e.a.d.q;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.chinavisionary.jslibrary.R;
import com.chinavisionary.view.VerificationCodeEditText;
import com.intelligoo.sdk.ConstantsUtils;
import d.k0.d.p;
import d.k0.d.t;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class VerificationCodeInputView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8828f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f8829g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f8830h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f8831i;
    public int j;
    public a k;
    public c l;
    public d m;
    public final AttributeSet n;

    public interface a {
        void complete(String str);

        void normalStyle(VerificationCodeEditText verificationCodeEditText, int i2);

        void onTextChange(String str);

        void selectdStyle(VerificationCodeEditText verificationCodeEditText, int i2);
    }

    public enum b {
        NUMBER,
        TEXT,
        NUMBER_PASSWORD,
        TEXT_PASSWORD,
        PHONE
    }

    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() == 0) {
                return;
            }
            q.d("VerificationCodeInputView", "afterTextChanged");
            VerificationCodeInputView.this.d();
            VerificationCodeInputView.this.b();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            q.d("VerificationCodeInputView", "beforeTextChanged");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            q.d("VerificationCodeInputView", "onTextChanged");
            VerificationCodeInputView.this.b();
        }
    }

    public static final class d implements VerificationCodeEditText.c {
        public d() {
        }

        @Override // com.chinavisionary.view.VerificationCodeEditText.c
        public void onDelSoftListener() {
            VerificationCodeInputView.this.c();
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f8835a;

        public e(View view) {
            this.f8835a = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            View view = this.f8835a;
            if (view != null) {
                view.setFocusableInTouchMode(true);
            }
            View view2 = this.f8835a;
            if (view2 != null) {
                view2.setFocusable(true);
            }
            View view3 = this.f8835a;
            if (view3 != null) {
                view3.requestFocus();
            }
            View view4 = this.f8835a;
            Object systemService = (view4 == null || (context = view4.getContext()) == null) ? null : context.getSystemService("input_method");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).showSoftInput(this.f8835a, 0);
        }
    }

    public VerificationCodeInputView(Context context) {
        this(context, null, 0, 6, null);
    }

    public VerificationCodeInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ VerificationCodeInputView(Context context, AttributeSet attributeSet, int i2, int i3, p pVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void a() {
        int i2 = this.f8823a;
        for (int i3 = 0; i3 < i2; i3++) {
            Context context = getContext();
            t.checkNotNullExpressionValue(context, TTLiveConstants.CONTEXT_KEY);
            VerificationCodeEditText verificationCodeEditText = new VerificationCodeEditText(context, null, 2, null);
            if (Build.VERSION.SDK_INT >= 29) {
                verificationCodeEditText.setTextCursorDrawable(getResources().getDrawable(R.drawable.bg_text_cursor_drawable));
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f8824b, this.f8825c);
            int i4 = this.f8826d;
            layoutParams.bottomMargin = i4;
            layoutParams.topMargin = i4;
            int i5 = this.f8827e;
            layoutParams.leftMargin = i5;
            layoutParams.rightMargin = i5;
            layoutParams.gravity = 17;
            int i6 = this.j;
            if (i6 != 0) {
                verificationCodeEditText.setTextColor(i6);
            }
            verificationCodeEditText.setMVerificationCodeDelListener(this.m);
            verificationCodeEditText.setLayoutParams(layoutParams);
            verificationCodeEditText.setGravity(17);
            verificationCodeEditText.setEnabled(true);
            verificationCodeEditText.setTextSize(20.0f);
            verificationCodeEditText.setTextColor(getResources().getColor(R.color.core_lib_color_black));
            verificationCodeEditText.setBackgroundColor(getResources().getColor(R.color.colorF6F6F6));
            verificationCodeEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2)});
            int i7 = this.f8828f;
            if (i7 == b.PHONE.ordinal()) {
                verificationCodeEditText.setInputType(3);
            } else if (i7 == b.NUMBER.ordinal()) {
                verificationCodeEditText.setInputType(2);
            } else if (i7 == b.NUMBER_PASSWORD.ordinal()) {
                verificationCodeEditText.setInputType(18);
            } else if (i7 == b.TEXT_PASSWORD.ordinal()) {
                verificationCodeEditText.setInputType(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA);
            } else if (i7 == b.TEXT.ordinal()) {
                verificationCodeEditText.setInputType(1);
            }
            verificationCodeEditText.setEms(1);
            verificationCodeEditText.addTextChangedListener(this.l);
            Drawable drawable = this.f8830h;
            if (drawable != null) {
                verificationCodeEditText.setBackground(drawable);
            }
            a aVar = this.k;
            if (aVar != null) {
                aVar.normalStyle(verificationCodeEditText, i3);
            }
            addView(verificationCodeEditText);
        }
        d();
        View childAt = getChildAt(0);
        Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.EditText");
        openSoftKeyboard((EditText) childAt);
    }

    public final void b() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        int i2 = this.f8823a;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            View childAt = getChildAt(i3);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.chinavisionary.view.VerificationCodeEditText");
            Editable text = ((VerificationCodeEditText) childAt).getText();
            t.checkNotNullExpressionValue(text, ConstantsUtils.DEVICEOPENDOOR_PASSWORD);
            if (text.length() == 0) {
                z = false;
                break;
            } else {
                sb.append((CharSequence) text);
                i3++;
            }
        }
        if (z) {
            a aVar = this.k;
            if (aVar != null) {
                String string = sb.toString();
                t.checkNotNullExpressionValue(string, "allPassword.toString()");
                aVar.complete(string);
            }
            setEnabled(false);
            return;
        }
        a aVar2 = this.k;
        if (aVar2 != null) {
            String string2 = sb.toString();
            t.checkNotNullExpressionValue(string2, "allPassword.toString()");
            aVar2.onTextChange(string2);
        }
    }

    public final void c() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.chinavisionary.view.VerificationCodeEditText");
            VerificationCodeEditText verificationCodeEditText = (VerificationCodeEditText) childAt;
            if (verificationCodeEditText.getText().length() == 1) {
                verificationCodeEditText.requestFocus();
                verificationCodeEditText.setSelection(1);
                Drawable drawable = this.f8829g;
                if (drawable != null) {
                    verificationCodeEditText.setBackground(drawable);
                }
                a aVar = this.k;
                if (aVar != null) {
                    aVar.selectdStyle(verificationCodeEditText, childCount);
                    return;
                }
                return;
            }
            Drawable drawable2 = this.f8830h;
            if (drawable2 != null) {
                verificationCodeEditText.setBackground(drawable2);
            }
            a aVar2 = this.k;
            if (aVar2 != null) {
                aVar2.normalStyle(verificationCodeEditText, childCount);
            }
        }
    }

    public final void d() {
        int childCount = getChildCount();
        String strSubstring = "";
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.chinavisionary.view.VerificationCodeEditText");
            VerificationCodeEditText verificationCodeEditText = (VerificationCodeEditText) childAt;
            Editable text = verificationCodeEditText.getText();
            t.checkNotNullExpressionValue(text, "childView.text");
            if (text.length() == 0) {
                verificationCodeEditText.requestFocus();
                if (strSubstring.length() > 0) {
                    verificationCodeEditText.setText(strSubstring);
                    verificationCodeEditText.setSelection(1);
                }
                Drawable drawable = this.f8829g;
                if (drawable != null) {
                    verificationCodeEditText.setBackground(drawable);
                }
                a aVar = this.k;
                if (aVar != null) {
                    aVar.selectdStyle(verificationCodeEditText, i2);
                    return;
                }
                return;
            }
            String string = verificationCodeEditText.getText().toString();
            if (string.length() > 1) {
                String strSubstring2 = string.substring(0, 1);
                t.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                verificationCodeEditText.setText(strSubstring2);
                verificationCodeEditText.setSelection(1);
                strSubstring = string.substring(1, 2);
                t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            Drawable drawable2 = this.f8831i;
            if (drawable2 != null) {
                verificationCodeEditText.setBackground(drawable2);
            } else {
                Drawable drawable3 = this.f8830h;
                if (drawable3 != null) {
                    verificationCodeEditText.setBackground(drawable3);
                }
            }
            a aVar2 = this.k;
            if (aVar2 != null) {
                aVar2.normalStyle(verificationCodeEditText, i2);
            }
        }
    }

    public final AttributeSet getAttrs() {
        return this.n;
    }

    public final a getMVerificationCodeInputChildStyleListener() {
        return this.k;
    }

    public final void openSoftKeyboard(View view) {
        postDelayed(new e(view), 200L);
    }

    public final void setMVerificationCodeInputChildStyleListener(a aVar) {
        this.k = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerificationCodeInputView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        t.checkNotNullParameter(context, TTLiveConstants.CONTEXT_KEY);
        this.n = attributeSet;
        b bVar = b.NUMBER_PASSWORD;
        this.f8828f = bVar.ordinal();
        this.l = new c();
        this.m = new d();
        setOrientation(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VerificationCodeInputView);
        t.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…erificationCodeInputView)");
        this.f8823a = typedArrayObtainStyledAttributes.getInteger(R.styleable.VerificationCodeInputView_childViewCount, 6);
        this.f8824b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.VerificationCodeInputView_childViewWidth, 120);
        this.f8829g = typedArrayObtainStyledAttributes.getDrawable(R.styleable.VerificationCodeInputView_childViewSelectedBg);
        this.f8830h = typedArrayObtainStyledAttributes.getDrawable(R.styleable.VerificationCodeInputView_childViewNormalBg);
        this.f8831i = typedArrayObtainStyledAttributes.getDrawable(R.styleable.VerificationCodeInputView_childViewFilledBg);
        this.f8825c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.VerificationCodeInputView_childViewHeight, 120);
        this.f8826d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.VerificationCodeInputView_childViewVerticalMargin, 14);
        this.f8827e = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.VerificationCodeInputView_childViewHorizontalMargin, 14);
        this.f8828f = typedArrayObtainStyledAttributes.getInteger(R.styleable.VerificationCodeInputView_inputType, bVar.ordinal());
        this.j = typedArrayObtainStyledAttributes.getColor(R.styleable.VerificationCodeInputView_childViewTextColor, 0);
        typedArrayObtainStyledAttributes.recycle();
        a();
    }
}
