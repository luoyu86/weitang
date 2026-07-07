package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class TTDislikeDialogAbstract extends Dialog {
    private View ok;

    public TTDislikeDialogAbstract(Context context) {
        super(context);
    }

    public abstract int getLayoutId();

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract int[] getTTDislikeListViewIds();

    public void ok() {
        if (this.ok == null) {
            return;
        }
        int[] tTDislikeListViewIds = getTTDislikeListViewIds();
        if (tTDislikeListViewIds == null || tTDislikeListViewIds.length <= 0) {
            throw new IllegalArgumentException("dislike选项列表为空，请设置TTDislikeListView");
        }
        for (int i2 : tTDislikeListViewIds) {
            View viewFindViewById = this.ok.findViewById(i2);
            if (viewFindViewById == null) {
                throw new IllegalArgumentException("getTTDislikeListViewIds提供的id找不到view，请检查");
            }
            if (!(viewFindViewById instanceof DislikeListView)) {
                throw new IllegalArgumentException("getTTDislikeListViewIds找到的view类型异常，请检查");
            }
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            View viewInflate = LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) null);
            this.ok = viewInflate;
            if (viewInflate == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            View view = this.ok;
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            setContentView(view, layoutParams);
            ok();
        } catch (Exception unused) {
            Log.e("TTDislikeDialogAbstract", "getLayoutId布局文件id可能异常，请检查");
        }
    }

    @Deprecated
    public void setDislikeModel(TTDislikeController tTDislikeController) {
    }

    @Deprecated
    public void startPersonalizePromptActivity() {
    }

    public TTDislikeDialogAbstract(Context context, int i2) {
        super(context, i2);
    }
}
