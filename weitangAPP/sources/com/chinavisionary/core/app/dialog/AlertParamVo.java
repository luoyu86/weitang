package com.chinavisionary.core.app.dialog;

import android.app.Activity;
import android.view.View;
import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class AlertParamVo extends BaseVo {
    private Activity activity;
    private String cancel;
    private String confirm;
    private String content;
    private boolean contentCanIsEmpty;
    private String hintText;
    private int inputType = 1;
    private boolean isCancelable;
    private View.OnClickListener onClickListener;
    private String title;
    private float titleFontSize;

    public Activity getActivity() {
        return this.activity;
    }

    public String getCancel() {
        return this.cancel;
    }

    public String getConfirm() {
        return this.confirm;
    }

    public String getContent() {
        return this.content;
    }

    public String getHintText() {
        return this.hintText;
    }

    public int getInputType() {
        return this.inputType;
    }

    public View.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public String getTitle() {
        return this.title;
    }

    public float getTitleFontSize() {
        return this.titleFontSize;
    }

    public boolean isCancelable() {
        return this.isCancelable;
    }

    public boolean isContentCanIsEmpty() {
        return this.contentCanIsEmpty;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setCancel(String str) {
        this.cancel = str;
    }

    public void setCancelable(boolean z) {
        this.isCancelable = z;
    }

    public void setConfirm(String str) {
        this.confirm = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setContentCanIsEmpty(boolean z) {
        this.contentCanIsEmpty = z;
    }

    public void setHintText(String str) {
        this.hintText = str;
    }

    public void setInputType(int i2) {
        this.inputType = i2;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTitleFontSize(float f2) {
        this.titleFontSize = f2;
    }
}
