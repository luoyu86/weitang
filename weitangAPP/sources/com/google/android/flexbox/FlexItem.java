package com.google.android.flexbox;

import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public interface FlexItem extends Parcelable {
    int getAlignSelf();

    float getFlexBasisPercent();

    float getFlexGrow();

    float getFlexShrink();

    int getHeight();

    int getMarginBottom();

    int getMarginEnd();

    int getMarginLeft();

    int getMarginRight();

    int getMarginStart();

    int getMarginTop();

    int getMaxHeight();

    int getMaxWidth();

    int getMinHeight();

    int getMinWidth();

    int getOrder();

    int getWidth();

    boolean isWrapBefore();

    void setAlignSelf(int i2);

    void setFlexBasisPercent(float f2);

    void setFlexGrow(float f2);

    void setFlexShrink(float f2);

    void setHeight(int i2);

    void setMaxHeight(int i2);

    void setMaxWidth(int i2);

    void setMinHeight(int i2);

    void setMinWidth(int i2);

    void setOrder(int i2);

    void setWidth(int i2);

    void setWrapBefore(boolean z);
}
