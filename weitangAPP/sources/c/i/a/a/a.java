package c.i.a.a;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    void addView(View view);

    void addView(View view, int i2);

    int getAlignContent();

    int getAlignItems();

    int getChildHeightMeasureSpec(int i2, int i3, int i4);

    int getChildWidthMeasureSpec(int i2, int i3, int i4);

    int getDecorationLengthCrossAxis(View view);

    int getDecorationLengthMainAxis(View view, int i2, int i3);

    int getFlexDirection();

    View getFlexItemAt(int i2);

    int getFlexItemCount();

    List<b> getFlexLines();

    List<b> getFlexLinesInternal();

    int getFlexWrap();

    int getJustifyContent();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    View getReorderedFlexItemAt(int i2);

    int getSumOfCrossSize();

    boolean isMainAxisDirectionHorizontal();

    void onNewFlexItemAdded(View view, int i2, int i3, b bVar);

    void onNewFlexLineAdded(b bVar);

    void removeAllViews();

    void removeViewAt(int i2);

    void setAlignContent(int i2);

    void setAlignItems(int i2);

    void setFlexDirection(int i2);

    void setFlexLines(List<b> list);

    void setFlexWrap(int i2);

    void setJustifyContent(int i2);

    void setMaxLine(int i2);

    void updateViewCache(int i2, View view);
}
