package com.chinavisionary.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import d.k0.d.p;
import d.k0.d.t;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"AppCompatCustomView"})
public final class VerificationCodeEditText extends EditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f8820a;

    public static final class a implements View.OnKeyListener {
        public a() {
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            c mVerificationCodeDelListener;
            if (i2 != 67) {
                return false;
            }
            t.checkNotNullExpressionValue(keyEvent, "keyEvent");
            if (keyEvent.getAction() != 0 || (mVerificationCodeDelListener = VerificationCodeEditText.this.getMVerificationCodeDelListener()) == null) {
                return false;
            }
            mVerificationCodeDelListener.onDelSoftListener();
            return false;
        }
    }

    public static final class b extends InputConnectionWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f8822a;

        public b(InputConnection inputConnection, boolean z, c cVar) {
            super(inputConnection, z);
            this.f8822a = cVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i2, int i3) {
            c cVar = this.f8822a;
            if (cVar != null) {
                cVar.onDelSoftListener();
            }
            return super.deleteSurroundingText(i2, i3);
        }

        public final c getMVerificationCodeDelListener() {
            return this.f8822a;
        }
    }

    public interface c {
        void onDelSoftListener();
    }

    public VerificationCodeEditText(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ VerificationCodeEditText(Context context, AttributeSet attributeSet, int i2, p pVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public final c getMVerificationCodeDelListener() {
        return this.f8820a;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new b(super.onCreateInputConnection(editorInfo), true, this.f8820a);
    }

    public final void setMVerificationCodeDelListener(c cVar) {
        this.f8820a = cVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerificationCodeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        t.checkNotNullParameter(context, TTLiveConstants.CONTEXT_KEY);
        setOnKeyListener(new a());
    }
}
