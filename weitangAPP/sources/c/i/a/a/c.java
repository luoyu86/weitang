package c.i.a.a;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.flexbox.FlexItem;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c.i.a.a.a f2557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean[] f2558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public int[] f2559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public long[] f2560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public long[] f2561e;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<c.i.a.a.b> f2562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2563b;

        public void a() {
            this.f2562a = null;
            this.f2563b = 0;
        }
    }

    /* JADX INFO: renamed from: c.i.a.a.c$c, reason: collision with other inner class name */
    public static class C0031c implements Comparable<C0031c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2565b;

        public C0031c() {
        }

        @NonNull
        public String toString() {
            return "Order{order=" + this.f2565b + ", index=" + this.f2564a + '}';
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull C0031c c0031c) {
            int i2 = this.f2565b;
            int i3 = c0031c.f2565b;
            return i2 != i3 ? i2 - i3 : this.f2564a - c0031c.f2564a;
        }
    }

    public c(c.i.a.a.a aVar) {
        this.f2557a = aVar;
    }

    public final int A(int i2, FlexItem flexItem, int i3) {
        c.i.a.a.a aVar = this.f2557a;
        int childWidthMeasureSpec = aVar.getChildWidthMeasureSpec(i2, aVar.getPaddingLeft() + this.f2557a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i3, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(childWidthMeasureSpec);
        return size > flexItem.getMaxWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : size < flexItem.getMinWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : childWidthMeasureSpec;
    }

    public final int B(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginBottom() : flexItem.getMarginRight();
    }

    public final int C(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.getMarginBottom();
    }

    public final int D(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginTop() : flexItem.getMarginLeft();
    }

    public final int E(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginLeft() : flexItem.getMarginTop();
    }

    public final int F(FlexItem flexItem, boolean z) {
        return z ? flexItem.getHeight() : flexItem.getWidth();
    }

    public final int G(FlexItem flexItem, boolean z) {
        return z ? flexItem.getWidth() : flexItem.getHeight();
    }

    public final int H(boolean z) {
        return z ? this.f2557a.getPaddingBottom() : this.f2557a.getPaddingEnd();
    }

    public final int I(boolean z) {
        return z ? this.f2557a.getPaddingEnd() : this.f2557a.getPaddingBottom();
    }

    public final int J(boolean z) {
        return z ? this.f2557a.getPaddingTop() : this.f2557a.getPaddingStart();
    }

    public final int K(boolean z) {
        return z ? this.f2557a.getPaddingStart() : this.f2557a.getPaddingTop();
    }

    public final int L(View view, boolean z) {
        return z ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    public final int M(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    public final boolean N(int i2, int i3, c.i.a.a.b bVar) {
        return i2 == i3 - 1 && bVar.getItemCountNotGone() != 0;
    }

    public boolean O(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f2557a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i2 = 0; i2 < flexItemCount; i2++) {
            View flexItemAt = this.f2557a.getFlexItemAt(i2);
            if (flexItemAt != null && ((FlexItem) flexItemAt.getLayoutParams()).getOrder() != sparseIntArray.get(i2)) {
                return true;
            }
        }
        return false;
    }

    public final boolean P(View view, int i2, int i3, int i4, int i5, FlexItem flexItem, int i6, int i7, int i8) {
        if (this.f2557a.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (i2 == 0) {
            return false;
        }
        int maxLine = this.f2557a.getMaxLine();
        if (maxLine != -1 && maxLine <= i8 + 1) {
            return false;
        }
        int decorationLengthMainAxis = this.f2557a.getDecorationLengthMainAxis(view, i6, i7);
        if (decorationLengthMainAxis > 0) {
            i5 += decorationLengthMainAxis;
        }
        return i3 < i4 + i5;
    }

    public void Q(View view, c.i.a.a.b bVar, int i2, int i3, int i4, int i5) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f2557a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i6 = bVar.f2553g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.f2557a.getFlexWrap() == 2) {
                    view.layout(i2, (i3 - i6) + view.getMeasuredHeight() + flexItem.getMarginTop(), i4, (i5 - i6) + view.getMeasuredHeight() + flexItem.getMarginTop());
                    return;
                } else {
                    int i7 = i3 + i6;
                    view.layout(i2, (i7 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), i4, i7 - flexItem.getMarginBottom());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i6 - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                if (this.f2557a.getFlexWrap() != 2) {
                    int i8 = i3 + measuredHeight;
                    view.layout(i2, i8, i4, view.getMeasuredHeight() + i8);
                    return;
                } else {
                    int i9 = i3 - measuredHeight;
                    view.layout(i2, i9, i4, view.getMeasuredHeight() + i9);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.f2557a.getFlexWrap() != 2) {
                    int iMax = Math.max(bVar.l - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(i2, i3 + iMax, i4, i5 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((bVar.l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                    view.layout(i2, i3 - iMax2, i4, i5 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.f2557a.getFlexWrap() != 2) {
            view.layout(i2, i3 + flexItem.getMarginTop(), i4, i5 + flexItem.getMarginTop());
        } else {
            view.layout(i2, i3 - flexItem.getMarginBottom(), i4, i5 - flexItem.getMarginBottom());
        }
    }

    public void R(View view, c.i.a.a.b bVar, boolean z, int i2, int i3, int i4, int i5) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f2557a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i6 = bVar.f2553g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (z) {
                    view.layout((i2 - i6) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i3, (i4 - i6) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i5);
                    return;
                } else {
                    view.layout(((i2 + i6) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i3, ((i4 + i6) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i5);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i6 - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams)) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (z) {
                    view.layout(i2 - measuredWidth, i3, i4 - measuredWidth, i5);
                    return;
                } else {
                    view.layout(i2 + measuredWidth, i3, i4 + measuredWidth, i5);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (z) {
            view.layout(i2 - flexItem.getMarginRight(), i3, i4 - flexItem.getMarginRight(), i5);
        } else {
            view.layout(i2 + flexItem.getMarginLeft(), i3, i4 + flexItem.getMarginLeft(), i5);
        }
    }

    @VisibleForTesting
    public long S(int i2, int i3) {
        return (((long) i2) & UIDFolder.MAXUID) | (((long) i3) << 32);
    }

    public final void T(int i2, int i3, c.i.a.a.b bVar, int i4, int i5, boolean z) {
        int i6;
        int i7;
        int iMax;
        int i8 = bVar.f2551e;
        float f2 = bVar.k;
        float f3 = 0.0f;
        if (f2 <= 0.0f || i4 > i8) {
            return;
        }
        float f4 = (i8 - i4) / f2;
        bVar.f2551e = i5 + bVar.f2552f;
        if (!z) {
            bVar.f2553g = Integer.MIN_VALUE;
        }
        int i9 = 0;
        boolean z2 = false;
        int i10 = 0;
        float f5 = 0.0f;
        while (i9 < bVar.f2554h) {
            int i11 = bVar.o + i9;
            View reorderedFlexItemAt = this.f2557a.getReorderedFlexItemAt(i11);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i6 = i8;
                i7 = i9;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.f2557a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i6 = i8;
                    int i12 = i9;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.f2561e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i11]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.f2561e;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i11]);
                    }
                    if (this.f2558b[i11] || flexItem.getFlexShrink() <= 0.0f) {
                        i7 = i12;
                    } else {
                        float flexShrink = measuredWidth - (flexItem.getFlexShrink() * f4);
                        i7 = i12;
                        if (i7 == bVar.f2554h - 1) {
                            flexShrink += f5;
                            f5 = 0.0f;
                        }
                        int iRound = Math.round(flexShrink);
                        if (iRound < flexItem.getMinWidth()) {
                            iRound = flexItem.getMinWidth();
                            this.f2558b[i11] = true;
                            bVar.k -= flexItem.getFlexShrink();
                            z2 = true;
                        } else {
                            f5 += flexShrink - iRound;
                            double d2 = f5;
                            if (d2 > 1.0d) {
                                iRound++;
                                f5 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound--;
                                f5 += 1.0f;
                            }
                        }
                        int iZ = z(i3, flexItem, bVar.m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, WXVideoFileObject.FILE_SIZE_LIMIT);
                        reorderedFlexItemAt.measure(iMakeMeasureSpec, iZ);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i11, iMakeMeasureSpec, iZ, reorderedFlexItemAt);
                        this.f2557a.updateViewCache(i11, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i10, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.f2557a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    bVar.f2551e += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.f2561e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i11]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.f2561e;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i11]);
                    }
                    if (this.f2558b[i11] || flexItem.getFlexShrink() <= f3) {
                        i6 = i8;
                        i7 = i9;
                    } else {
                        float flexShrink2 = measuredHeight3 - (flexItem.getFlexShrink() * f4);
                        if (i9 == bVar.f2554h - 1) {
                            flexShrink2 += f5;
                            f5 = 0.0f;
                        }
                        int iRound2 = Math.round(flexShrink2);
                        if (iRound2 < flexItem.getMinHeight()) {
                            iRound2 = flexItem.getMinHeight();
                            this.f2558b[i11] = true;
                            bVar.k -= flexItem.getFlexShrink();
                            i6 = i8;
                            i7 = i9;
                            z2 = true;
                        } else {
                            f5 += flexShrink2 - iRound2;
                            i6 = i8;
                            i7 = i9;
                            double d3 = f5;
                            if (d3 > 1.0d) {
                                iRound2++;
                                f5 -= 1.0f;
                            } else if (d3 < -1.0d) {
                                iRound2--;
                                f5 += 1.0f;
                            }
                        }
                        int iA = A(i2, flexItem, bVar.m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, WXVideoFileObject.FILE_SIZE_LIMIT);
                        reorderedFlexItemAt.measure(iA, iMakeMeasureSpec2);
                        measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i11, iA, iMakeMeasureSpec2, reorderedFlexItemAt);
                        this.f2557a.updateViewCache(i11, reorderedFlexItemAt);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.f2557a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    bVar.f2551e += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                }
                bVar.f2553g = Math.max(bVar.f2553g, iMax);
                i10 = iMax;
            }
            i9 = i7 + 1;
            i8 = i6;
            f3 = 0.0f;
        }
        int i13 = i8;
        if (!z2 || i13 == bVar.f2551e) {
            return;
        }
        T(i2, i3, bVar, i4, i5, true);
    }

    public final int[] U(int i2, List<C0031c> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i2];
        int i3 = 0;
        for (C0031c c0031c : list) {
            int i4 = c0031c.f2564a;
            iArr[i3] = i4;
            sparseIntArray.append(i4, c0031c.f2565b);
            i3++;
        }
        return iArr;
    }

    public final void V(View view, int i2, int i3) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i2 - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.f2557a.getDecorationLengthCrossAxis(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.f2561e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? x(jArr[i3]) : view.getMeasuredHeight(), WXVideoFileObject.FILE_SIZE_LIMIT);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, WXVideoFileObject.FILE_SIZE_LIMIT);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        Z(i3, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.f2557a.updateViewCache(i3, view);
    }

    public final void W(View view, int i2, int i3) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i2 - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.f2557a.getDecorationLengthCrossAxis(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.f2561e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? y(jArr[i3]) : view.getMeasuredWidth(), WXVideoFileObject.FILE_SIZE_LIMIT);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, WXVideoFileObject.FILE_SIZE_LIMIT);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        Z(i3, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.f2557a.updateViewCache(i3, view);
    }

    public void X() {
        Y(0);
    }

    public void Y(int i2) {
        View reorderedFlexItemAt;
        if (i2 >= this.f2557a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f2557a.getFlexDirection();
        if (this.f2557a.getAlignItems() != 4) {
            for (c.i.a.a.b bVar : this.f2557a.getFlexLinesInternal()) {
                for (Integer num : bVar.n) {
                    View reorderedFlexItemAt2 = this.f2557a.getReorderedFlexItemAt(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        W(reorderedFlexItemAt2, bVar.f2553g, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                        }
                        V(reorderedFlexItemAt2, bVar.f2553g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.f2559c;
        List<c.i.a.a.b> flexLinesInternal = this.f2557a.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i3 = iArr != null ? iArr[i2] : 0; i3 < size; i3++) {
            c.i.a.a.b bVar2 = flexLinesInternal.get(i3);
            int i4 = bVar2.f2554h;
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = bVar2.o + i5;
                if (i5 < this.f2557a.getFlexItemCount() && (reorderedFlexItemAt = this.f2557a.getReorderedFlexItemAt(i6)) != null && reorderedFlexItemAt.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            W(reorderedFlexItemAt, bVar2.f2553g, i6);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            }
                            V(reorderedFlexItemAt, bVar2.f2553g, i6);
                        }
                    }
                }
            }
        }
    }

    public final void Z(int i2, int i3, int i4, View view) {
        long[] jArr = this.f2560d;
        if (jArr != null) {
            jArr[i2] = S(i3, i4);
        }
        long[] jArr2 = this.f2561e;
        if (jArr2 != null) {
            jArr2[i2] = S(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public final void a(List<c.i.a.a.b> list, c.i.a.a.b bVar, int i2, int i3) {
        bVar.m = i3;
        this.f2557a.onNewFlexLineAdded(bVar);
        bVar.p = i2;
        list.add(bVar);
    }

    public void b(b bVar, int i2, int i3, int i4, int i5, int i6, @Nullable List<c.i.a.a.b> list) {
        int i7;
        b bVar2;
        int i8;
        int i9;
        int i10;
        List<c.i.a.a.b> list2;
        int i11;
        View view;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        c.i.a.a.b bVar3;
        int i18;
        int i19 = i2;
        int i20 = i3;
        int i21 = i6;
        boolean zIsMainAxisDirectionHorizontal = this.f2557a.isMainAxisDirectionHorizontal();
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        List<c.i.a.a.b> arrayList = list == null ? new ArrayList() : list;
        bVar.f2562a = arrayList;
        boolean z = i21 == -1;
        int iK = K(zIsMainAxisDirectionHorizontal);
        int I = I(zIsMainAxisDirectionHorizontal);
        int iJ = J(zIsMainAxisDirectionHorizontal);
        int iH = H(zIsMainAxisDirectionHorizontal);
        c.i.a.a.b bVar4 = new c.i.a.a.b();
        int i22 = i5;
        bVar4.o = i22;
        int i23 = I + iK;
        bVar4.f2551e = i23;
        int flexItemCount = this.f2557a.getFlexItemCount();
        boolean z2 = z;
        int i24 = 0;
        int iCombineMeasuredStates = 0;
        int i25 = 0;
        int i26 = Integer.MIN_VALUE;
        while (true) {
            if (i22 >= flexItemCount) {
                i7 = iCombineMeasuredStates;
                bVar2 = bVar;
                break;
            }
            View reorderedFlexItemAt = this.f2557a.getReorderedFlexItemAt(i22);
            if (reorderedFlexItemAt == null) {
                if (N(i22, flexItemCount, bVar4)) {
                    a(arrayList, bVar4, i22, i24);
                }
            } else if (reorderedFlexItemAt.getVisibility() == 8) {
                bVar4.f2555i++;
                bVar4.f2554h++;
                if (N(i22, flexItemCount, bVar4)) {
                    a(arrayList, bVar4, i22, i24);
                }
            } else {
                if (reorderedFlexItemAt instanceof CompoundButton) {
                    v((CompoundButton) reorderedFlexItemAt);
                }
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int i27 = flexItemCount;
                if (flexItem.getAlignSelf() == 4) {
                    bVar4.n.add(Integer.valueOf(i22));
                }
                int iG = G(flexItem, zIsMainAxisDirectionHorizontal);
                if (flexItem.getFlexBasisPercent() != -1.0f && mode == 1073741824) {
                    iG = Math.round(size * flexItem.getFlexBasisPercent());
                }
                if (zIsMainAxisDirectionHorizontal) {
                    int childWidthMeasureSpec = this.f2557a.getChildWidthMeasureSpec(i19, i23 + E(flexItem, true) + C(flexItem, true), iG);
                    i8 = size;
                    i9 = mode;
                    int childHeightMeasureSpec = this.f2557a.getChildHeightMeasureSpec(i20, iJ + iH + D(flexItem, true) + B(flexItem, true) + i24, F(flexItem, true));
                    reorderedFlexItemAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    Z(i22, childWidthMeasureSpec, childHeightMeasureSpec, reorderedFlexItemAt);
                    i10 = childWidthMeasureSpec;
                } else {
                    i8 = size;
                    i9 = mode;
                    int childWidthMeasureSpec2 = this.f2557a.getChildWidthMeasureSpec(i20, iJ + iH + D(flexItem, false) + B(flexItem, false) + i24, F(flexItem, false));
                    int childHeightMeasureSpec2 = this.f2557a.getChildHeightMeasureSpec(i19, E(flexItem, false) + i23 + C(flexItem, false), iG);
                    reorderedFlexItemAt.measure(childWidthMeasureSpec2, childHeightMeasureSpec2);
                    Z(i22, childWidthMeasureSpec2, childHeightMeasureSpec2, reorderedFlexItemAt);
                    i10 = childHeightMeasureSpec2;
                }
                this.f2557a.updateViewCache(i22, reorderedFlexItemAt);
                i(reorderedFlexItemAt, i22);
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, reorderedFlexItemAt.getMeasuredState());
                int i28 = i24;
                int i29 = i23;
                c.i.a.a.b bVar5 = bVar4;
                int i30 = i22;
                list2 = arrayList;
                int i31 = i10;
                if (P(reorderedFlexItemAt, i9, i8, bVar4.f2551e, C(flexItem, zIsMainAxisDirectionHorizontal) + M(reorderedFlexItemAt, zIsMainAxisDirectionHorizontal) + E(flexItem, zIsMainAxisDirectionHorizontal), flexItem, i30, i25, arrayList.size())) {
                    if (bVar5.getItemCountNotGone() > 0) {
                        if (i30 > 0) {
                            i18 = i30 - 1;
                            bVar3 = bVar5;
                        } else {
                            bVar3 = bVar5;
                            i18 = 0;
                        }
                        a(list2, bVar3, i18, i28);
                        i24 = bVar3.f2553g + i28;
                    } else {
                        i24 = i28;
                    }
                    if (!zIsMainAxisDirectionHorizontal) {
                        i11 = i3;
                        view = reorderedFlexItemAt;
                        i22 = i30;
                        if (flexItem.getWidth() == -1) {
                            c.i.a.a.a aVar = this.f2557a;
                            view.measure(aVar.getChildWidthMeasureSpec(i11, aVar.getPaddingLeft() + this.f2557a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i24, flexItem.getWidth()), i31);
                            i(view, i22);
                        }
                    } else if (flexItem.getHeight() == -1) {
                        c.i.a.a.a aVar2 = this.f2557a;
                        i11 = i3;
                        i22 = i30;
                        view = reorderedFlexItemAt;
                        view.measure(i31, aVar2.getChildHeightMeasureSpec(i11, aVar2.getPaddingTop() + this.f2557a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i24, flexItem.getHeight()));
                        i(view, i22);
                    } else {
                        i11 = i3;
                        view = reorderedFlexItemAt;
                        i22 = i30;
                    }
                    bVar4 = new c.i.a.a.b();
                    bVar4.f2554h = 1;
                    i12 = i29;
                    bVar4.f2551e = i12;
                    bVar4.o = i22;
                    i13 = 0;
                    i14 = Integer.MIN_VALUE;
                } else {
                    i11 = i3;
                    view = reorderedFlexItemAt;
                    i22 = i30;
                    bVar4 = bVar5;
                    i12 = i29;
                    bVar4.f2554h++;
                    i13 = i25 + 1;
                    i24 = i28;
                    i14 = i26;
                }
                bVar4.f2556q |= flexItem.getFlexGrow() != 0.0f;
                bVar4.r |= flexItem.getFlexShrink() != 0.0f;
                int[] iArr = this.f2559c;
                if (iArr != null) {
                    iArr[i22] = list2.size();
                }
                bVar4.f2551e += M(view, zIsMainAxisDirectionHorizontal) + E(flexItem, zIsMainAxisDirectionHorizontal) + C(flexItem, zIsMainAxisDirectionHorizontal);
                bVar4.j += flexItem.getFlexGrow();
                bVar4.k += flexItem.getFlexShrink();
                this.f2557a.onNewFlexItemAdded(view, i22, i13, bVar4);
                int iMax = Math.max(i14, L(view, zIsMainAxisDirectionHorizontal) + D(flexItem, zIsMainAxisDirectionHorizontal) + B(flexItem, zIsMainAxisDirectionHorizontal) + this.f2557a.getDecorationLengthCrossAxis(view));
                bVar4.f2553g = Math.max(bVar4.f2553g, iMax);
                if (zIsMainAxisDirectionHorizontal) {
                    if (this.f2557a.getFlexWrap() != 2) {
                        bVar4.l = Math.max(bVar4.l, view.getBaseline() + flexItem.getMarginTop());
                    } else {
                        bVar4.l = Math.max(bVar4.l, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.getMarginBottom());
                    }
                }
                i15 = i27;
                if (N(i22, i15, bVar4)) {
                    a(list2, bVar4, i22, i24);
                    i24 += bVar4.f2553g;
                }
                i16 = i6;
                if (i16 != -1 && list2.size() > 0) {
                    if (list2.get(list2.size() - 1).p >= i16 && i22 >= i16 && !z2) {
                        i24 = -bVar4.getCrossSize();
                        i17 = i4;
                        z2 = true;
                    }
                    if (i24 <= i17 && z2) {
                        bVar2 = bVar;
                        i7 = iCombineMeasuredStates;
                        break;
                    }
                    i25 = i13;
                    i26 = iMax;
                    i22++;
                    i19 = i2;
                    flexItemCount = i15;
                    i20 = i11;
                    i23 = i12;
                    arrayList = list2;
                    mode = i9;
                    i21 = i16;
                    size = i8;
                }
                i17 = i4;
                if (i24 <= i17) {
                }
                i25 = i13;
                i26 = iMax;
                i22++;
                i19 = i2;
                flexItemCount = i15;
                i20 = i11;
                i23 = i12;
                arrayList = list2;
                mode = i9;
                i21 = i16;
                size = i8;
            }
            i8 = size;
            i9 = mode;
            i11 = i20;
            i16 = i21;
            list2 = arrayList;
            i12 = i23;
            i15 = flexItemCount;
            i22++;
            i19 = i2;
            flexItemCount = i15;
            i20 = i11;
            i23 = i12;
            arrayList = list2;
            mode = i9;
            i21 = i16;
            size = i8;
        }
        bVar2.f2563b = i7;
    }

    public void c(b bVar, int i2, int i3) {
        b(bVar, i2, i3, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, -1, null);
    }

    public void d(b bVar, int i2, int i3, int i4, int i5, @Nullable List<c.i.a.a.b> list) {
        b(bVar, i2, i3, i4, i5, -1, list);
    }

    public void e(b bVar, int i2, int i3, int i4, int i5, List<c.i.a.a.b> list) {
        b(bVar, i2, i3, i4, 0, i5, list);
    }

    public void f(b bVar, int i2, int i3) {
        b(bVar, i3, i2, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, -1, null);
    }

    public void g(b bVar, int i2, int i3, int i4, int i5, @Nullable List<c.i.a.a.b> list) {
        b(bVar, i3, i2, i4, i5, -1, list);
    }

    public void h(b bVar, int i2, int i3, int i4, int i5, List<c.i.a.a.b> list) {
        b(bVar, i3, i2, i4, 0, i5, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.FlexItem r0 = (com.google.android.flexbox.FlexItem) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.getMinWidth()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.getMinWidth()
        L19:
            r3 = 1
            goto L27
        L1b:
            int r3 = r0.getMaxWidth()
            if (r1 <= r3) goto L26
            int r1 = r0.getMaxWidth()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.getMinHeight()
            if (r2 >= r5) goto L32
            int r2 = r0.getMinHeight()
            goto L3e
        L32:
            int r5 = r0.getMaxHeight()
            if (r2 <= r5) goto L3d
            int r2 = r0.getMaxHeight()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.Z(r8, r1, r0, r7)
            c.i.a.a.a r0 = r6.f2557a
            r0.updateViewCache(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.i.a.a.c.i(android.view.View, int):void");
    }

    public void j(List<c.i.a.a.b> list, int i2) {
        int i3 = this.f2559c[i2];
        if (i3 == -1) {
            i3 = 0;
        }
        if (list.size() > i3) {
            list.subList(i3, list.size()).clear();
        }
        int[] iArr = this.f2559c;
        int length = iArr.length - 1;
        if (i2 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i2, length, -1);
        }
        long[] jArr = this.f2560d;
        int length2 = jArr.length - 1;
        if (i2 > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i2, length2, 0L);
        }
    }

    public final List<c.i.a.a.b> k(List<c.i.a.a.b> list, int i2, int i3) {
        int i4 = (i2 - i3) / 2;
        ArrayList arrayList = new ArrayList();
        c.i.a.a.b bVar = new c.i.a.a.b();
        bVar.f2553g = i4;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (i5 == 0) {
                arrayList.add(bVar);
            }
            arrayList.add(list.get(i5));
            if (i5 == list.size() - 1) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @NonNull
    public final List<C0031c> l(int i2) {
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            FlexItem flexItem = (FlexItem) this.f2557a.getFlexItemAt(i3).getLayoutParams();
            C0031c c0031c = new C0031c();
            c0031c.f2565b = flexItem.getOrder();
            c0031c.f2564a = i3;
            arrayList.add(c0031c);
        }
        return arrayList;
    }

    public int[] m(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f2557a.getFlexItemCount();
        return U(flexItemCount, l(flexItemCount), sparseIntArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] n(View view, int i2, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.f2557a.getFlexItemCount();
        List<C0031c> listL = l(flexItemCount);
        C0031c c0031c = new C0031c();
        if (view == null || !(layoutParams instanceof FlexItem)) {
            c0031c.f2565b = 1;
        } else {
            c0031c.f2565b = ((FlexItem) layoutParams).getOrder();
        }
        if (i2 == -1 || i2 == flexItemCount || i2 >= this.f2557a.getFlexItemCount()) {
            c0031c.f2564a = flexItemCount;
        } else {
            c0031c.f2564a = i2;
            while (i2 < flexItemCount) {
                listL.get(i2).f2564a++;
                i2++;
            }
        }
        listL.add(c0031c);
        return U(flexItemCount + 1, listL, sparseIntArray);
    }

    public void o(int i2, int i3, int i4) {
        int mode;
        int size;
        int flexDirection = this.f2557a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            mode = mode2;
            size = size2;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            mode = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
        }
        List<c.i.a.a.b> flexLinesInternal = this.f2557a.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.f2557a.getSumOfCrossSize() + i4;
            int i5 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f2553g = size - i4;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f2557a.getAlignContent();
                if (alignContent == 1) {
                    int i6 = size - sumOfCrossSize;
                    c.i.a.a.b bVar = new c.i.a.a.b();
                    bVar.f2553g = i6;
                    flexLinesInternal.add(0, bVar);
                    return;
                }
                if (alignContent == 2) {
                    this.f2557a.setFlexLines(k(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= size) {
                        return;
                    }
                    float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size4 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i5 < size4) {
                        arrayList.add(flexLinesInternal.get(i5));
                        if (i5 != flexLinesInternal.size() - 1) {
                            c.i.a.a.b bVar2 = new c.i.a.a.b();
                            if (i5 == flexLinesInternal.size() - 2) {
                                bVar2.f2553g = Math.round(f2 + size3);
                                f2 = 0.0f;
                            } else {
                                bVar2.f2553g = Math.round(size3);
                            }
                            int i7 = bVar2.f2553g;
                            f2 += size3 - i7;
                            if (f2 > 1.0f) {
                                bVar2.f2553g = i7 + 1;
                                f2 -= 1.0f;
                            } else if (f2 < -1.0f) {
                                bVar2.f2553g = i7 - 1;
                                f2 += 1.0f;
                            }
                            arrayList.add(bVar2);
                        }
                        i5++;
                    }
                    this.f2557a.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.f2557a.setFlexLines(k(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    c.i.a.a.b bVar3 = new c.i.a.a.b();
                    bVar3.f2553g = size5;
                    for (c.i.a.a.b bVar4 : flexLinesInternal) {
                        arrayList2.add(bVar3);
                        arrayList2.add(bVar4);
                        arrayList2.add(bVar3);
                    }
                    this.f2557a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f3 = 0.0f;
                    while (i5 < size7) {
                        c.i.a.a.b bVar5 = flexLinesInternal.get(i5);
                        float f4 = bVar5.f2553g + size6;
                        if (i5 == flexLinesInternal.size() - 1) {
                            f4 += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(f4);
                        f3 += f4 - iRound;
                        if (f3 > 1.0f) {
                            iRound++;
                            f3 -= 1.0f;
                        } else if (f3 < -1.0f) {
                            iRound--;
                            f3 += 1.0f;
                        }
                        bVar5.f2553g = iRound;
                        i5++;
                    }
                }
            }
        }
    }

    public void p(int i2, int i3) {
        q(i2, i3, 0);
    }

    public void q(int i2, int i3, int i4) {
        int size;
        int paddingLeft;
        int paddingRight;
        r(this.f2557a.getFlexItemCount());
        if (i4 >= this.f2557a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f2557a.getFlexDirection();
        int flexDirection2 = this.f2557a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            int largestMainSize = this.f2557a.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.f2557a.getPaddingLeft();
            paddingRight = this.f2557a.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            size = View.MeasureSpec.getSize(i3);
            if (mode2 != 1073741824) {
                size = this.f2557a.getLargestMainSize();
            }
            paddingLeft = this.f2557a.getPaddingTop();
            paddingRight = this.f2557a.getPaddingBottom();
        }
        int i5 = paddingLeft + paddingRight;
        int[] iArr = this.f2559c;
        int i6 = iArr != null ? iArr[i4] : 0;
        List<c.i.a.a.b> flexLinesInternal = this.f2557a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i7 = i6; i7 < size2; i7++) {
            c.i.a.a.b bVar = flexLinesInternal.get(i7);
            int i8 = bVar.f2551e;
            if (i8 < size && bVar.f2556q) {
                w(i2, i3, bVar, size, i5, false);
            } else if (i8 > size && bVar.r) {
                T(i2, i3, bVar, size, i5, false);
            }
        }
    }

    public final void r(int i2) {
        boolean[] zArr = this.f2558b;
        if (zArr == null) {
            this.f2558b = new boolean[Math.max(i2, 10)];
        } else if (zArr.length < i2) {
            this.f2558b = new boolean[Math.max(zArr.length * 2, i2)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    public void s(int i2) {
        int[] iArr = this.f2559c;
        if (iArr == null) {
            this.f2559c = new int[Math.max(i2, 10)];
        } else if (iArr.length < i2) {
            this.f2559c = Arrays.copyOf(this.f2559c, Math.max(iArr.length * 2, i2));
        }
    }

    public void t(int i2) {
        long[] jArr = this.f2560d;
        if (jArr == null) {
            this.f2560d = new long[Math.max(i2, 10)];
        } else if (jArr.length < i2) {
            this.f2560d = Arrays.copyOf(this.f2560d, Math.max(jArr.length * 2, i2));
        }
    }

    public void u(int i2) {
        long[] jArr = this.f2561e;
        if (jArr == null) {
            this.f2561e = new long[Math.max(i2, 10)];
        } else if (jArr.length < i2) {
            this.f2561e = Arrays.copyOf(this.f2561e, Math.max(jArr.length * 2, i2));
        }
    }

    public final void v(CompoundButton compoundButton) {
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int minWidth = flexItem.getMinWidth();
        int minHeight = flexItem.getMinHeight();
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
        int minimumWidth = buttonDrawable == null ? 0 : buttonDrawable.getMinimumWidth();
        int minimumHeight = buttonDrawable != null ? buttonDrawable.getMinimumHeight() : 0;
        if (minWidth == -1) {
            minWidth = minimumWidth;
        }
        flexItem.setMinWidth(minWidth);
        if (minHeight == -1) {
            minHeight = minimumHeight;
        }
        flexItem.setMinHeight(minHeight);
    }

    public final void w(int i2, int i3, c.i.a.a.b bVar, int i4, int i5, boolean z) {
        int i6;
        int i7;
        int iMax;
        double d2;
        int i8;
        double d3;
        float f2 = bVar.j;
        float f3 = 0.0f;
        if (f2 <= 0.0f || i4 < (i6 = bVar.f2551e)) {
            return;
        }
        float f4 = (i4 - i6) / f2;
        bVar.f2551e = i5 + bVar.f2552f;
        if (!z) {
            bVar.f2553g = Integer.MIN_VALUE;
        }
        int i9 = 0;
        boolean z2 = false;
        int i10 = 0;
        float f5 = 0.0f;
        while (i9 < bVar.f2554h) {
            int i11 = bVar.o + i9;
            View reorderedFlexItemAt = this.f2557a.getReorderedFlexItemAt(i11);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i7 = i6;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.f2557a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i12 = i6;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.f2561e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i11]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.f2561e;
                    i7 = i12;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i11]);
                    }
                    if (!this.f2558b[i11] && flexItem.getFlexGrow() > 0.0f) {
                        float flexGrow = measuredWidth + (flexItem.getFlexGrow() * f4);
                        if (i9 == bVar.f2554h - 1) {
                            flexGrow += f5;
                            f5 = 0.0f;
                        }
                        int iRound = Math.round(flexGrow);
                        if (iRound > flexItem.getMaxWidth()) {
                            iRound = flexItem.getMaxWidth();
                            this.f2558b[i11] = true;
                            bVar.j -= flexItem.getFlexGrow();
                            z2 = true;
                        } else {
                            f5 += flexGrow - iRound;
                            double d4 = f5;
                            if (d4 > 1.0d) {
                                iRound++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                iRound--;
                                d2 = d4 + 1.0d;
                            }
                            f5 = (float) d2;
                        }
                        int iZ = z(i3, flexItem, bVar.m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, WXVideoFileObject.FILE_SIZE_LIMIT);
                        reorderedFlexItemAt.measure(iMakeMeasureSpec, iZ);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i11, iMakeMeasureSpec, iZ, reorderedFlexItemAt);
                        this.f2557a.updateViewCache(i11, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i10, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.f2557a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    bVar.f2551e += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.f2561e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i11]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.f2561e;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i11]);
                    }
                    if (this.f2558b[i11] || flexItem.getFlexGrow() <= f3) {
                        i8 = i6;
                    } else {
                        float flexGrow2 = measuredHeight3 + (flexItem.getFlexGrow() * f4);
                        if (i9 == bVar.f2554h - 1) {
                            flexGrow2 += f5;
                            f5 = 0.0f;
                        }
                        int iRound2 = Math.round(flexGrow2);
                        if (iRound2 > flexItem.getMaxHeight()) {
                            iRound2 = flexItem.getMaxHeight();
                            this.f2558b[i11] = true;
                            bVar.j -= flexItem.getFlexGrow();
                            i8 = i6;
                            z2 = true;
                        } else {
                            f5 += flexGrow2 - iRound2;
                            i8 = i6;
                            double d5 = f5;
                            if (d5 > 1.0d) {
                                iRound2++;
                                d3 = d5 - 1.0d;
                            } else if (d5 < -1.0d) {
                                iRound2--;
                                d3 = d5 + 1.0d;
                            }
                            f5 = (float) d3;
                        }
                        int iA = A(i2, flexItem, bVar.m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, WXVideoFileObject.FILE_SIZE_LIMIT);
                        reorderedFlexItemAt.measure(iA, iMakeMeasureSpec2);
                        measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i11, iA, iMakeMeasureSpec2, reorderedFlexItemAt);
                        this.f2557a.updateViewCache(i11, reorderedFlexItemAt);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i10, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.f2557a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    bVar.f2551e += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                    i7 = i8;
                }
                bVar.f2553g = Math.max(bVar.f2553g, iMax);
                i10 = iMax;
            }
            i9++;
            i6 = i7;
            f3 = 0.0f;
        }
        int i13 = i6;
        if (!z2 || i13 == bVar.f2551e) {
            return;
        }
        w(i2, i3, bVar, i4, i5, true);
    }

    public int x(long j) {
        return (int) (j >> 32);
    }

    public int y(long j) {
        return (int) j;
    }

    public final int z(int i2, FlexItem flexItem, int i3) {
        c.i.a.a.a aVar = this.f2557a;
        int childHeightMeasureSpec = aVar.getChildHeightMeasureSpec(i2, aVar.getPaddingTop() + this.f2557a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i3, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(childHeightMeasureSpec);
        return size > flexItem.getMaxHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : size < flexItem.getMinHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : childHeightMeasureSpec;
    }
}
