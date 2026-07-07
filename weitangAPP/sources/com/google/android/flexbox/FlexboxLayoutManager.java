package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import c.i.a.a.c;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements c.i.a.a.a, RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Rect f8940a = new Rect();
    public c.b A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<c.i.a.a.b> f8948i;
    public final c.i.a.a.c j;
    public RecyclerView.Recycler k;
    public RecyclerView.State l;
    public c m;
    public b n;
    public OrientationHelper o;
    public OrientationHelper p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SavedState f8949q;
    public int r;
    public int s;
    public int t;
    public int u;
    public boolean v;
    public SparseArray<View> w;
    public final Context x;
    public View y;
    public int z;

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8963c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8964d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8965e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8966f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f8967g;

        public b() {
            this.f8964d = 0;
        }

        public static /* synthetic */ int l(b bVar, int i2) {
            int i3 = bVar.f8964d + i2;
            bVar.f8964d = i3;
            return i3;
        }

        public final void r() {
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !FlexboxLayoutManager.this.f8946g) {
                this.f8963c = this.f8965e ? FlexboxLayoutManager.this.o.getEndAfterPadding() : FlexboxLayoutManager.this.o.getStartAfterPadding();
            } else {
                this.f8963c = this.f8965e ? FlexboxLayoutManager.this.o.getEndAfterPadding() : FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.o.getStartAfterPadding();
            }
        }

        public final void s(View view) {
            OrientationHelper orientationHelper = FlexboxLayoutManager.this.f8942c == 0 ? FlexboxLayoutManager.this.p : FlexboxLayoutManager.this.o;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !FlexboxLayoutManager.this.f8946g) {
                if (this.f8965e) {
                    this.f8963c = orientationHelper.getDecoratedEnd(view) + orientationHelper.getTotalSpaceChange();
                } else {
                    this.f8963c = orientationHelper.getDecoratedStart(view);
                }
            } else if (this.f8965e) {
                this.f8963c = orientationHelper.getDecoratedStart(view) + orientationHelper.getTotalSpaceChange();
            } else {
                this.f8963c = orientationHelper.getDecoratedEnd(view);
            }
            this.f8961a = FlexboxLayoutManager.this.getPosition(view);
            this.f8967g = false;
            int[] iArr = FlexboxLayoutManager.this.j.f2559c;
            int i2 = this.f8961a;
            if (i2 == -1) {
                i2 = 0;
            }
            int i3 = iArr[i2];
            this.f8962b = i3 != -1 ? i3 : 0;
            if (FlexboxLayoutManager.this.f8948i.size() > this.f8962b) {
                this.f8961a = ((c.i.a.a.b) FlexboxLayoutManager.this.f8948i.get(this.f8962b)).o;
            }
        }

        public final void t() {
            this.f8961a = -1;
            this.f8962b = -1;
            this.f8963c = Integer.MIN_VALUE;
            this.f8966f = false;
            this.f8967g = false;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) {
                if (FlexboxLayoutManager.this.f8942c == 0) {
                    this.f8965e = FlexboxLayoutManager.this.f8941b == 1;
                    return;
                } else {
                    this.f8965e = FlexboxLayoutManager.this.f8942c == 2;
                    return;
                }
            }
            if (FlexboxLayoutManager.this.f8942c == 0) {
                this.f8965e = FlexboxLayoutManager.this.f8941b == 3;
            } else {
                this.f8965e = FlexboxLayoutManager.this.f8942c == 2;
            }
        }

        @NonNull
        public String toString() {
            return "AnchorInfo{mPosition=" + this.f8961a + ", mFlexLinePosition=" + this.f8962b + ", mCoordinate=" + this.f8963c + ", mPerpendicularCoordinate=" + this.f8964d + ", mLayoutFromEnd=" + this.f8965e + ", mValid=" + this.f8966f + ", mAssignedFromSavedState=" + this.f8967g + '}';
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f8970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8971c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8972d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8973e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8974f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8975g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f8976h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f8977i;
        public boolean j;

        public c() {
            this.f8976h = 1;
            this.f8977i = 1;
        }

        public static /* synthetic */ int c(c cVar, int i2) {
            int i3 = cVar.f8973e + i2;
            cVar.f8973e = i3;
            return i3;
        }

        public static /* synthetic */ int d(c cVar, int i2) {
            int i3 = cVar.f8973e - i2;
            cVar.f8973e = i3;
            return i3;
        }

        public static /* synthetic */ int i(c cVar, int i2) {
            int i3 = cVar.f8969a - i2;
            cVar.f8969a = i3;
            return i3;
        }

        public static /* synthetic */ int l(c cVar) {
            int i2 = cVar.f8971c;
            cVar.f8971c = i2 + 1;
            return i2;
        }

        public static /* synthetic */ int m(c cVar) {
            int i2 = cVar.f8971c;
            cVar.f8971c = i2 - 1;
            return i2;
        }

        public static /* synthetic */ int n(c cVar, int i2) {
            int i3 = cVar.f8971c + i2;
            cVar.f8971c = i3;
            return i3;
        }

        public static /* synthetic */ int q(c cVar, int i2) {
            int i3 = cVar.f8974f + i2;
            cVar.f8974f = i3;
            return i3;
        }

        public static /* synthetic */ int u(c cVar, int i2) {
            int i3 = cVar.f8972d + i2;
            cVar.f8972d = i3;
            return i3;
        }

        public static /* synthetic */ int v(c cVar, int i2) {
            int i3 = cVar.f8972d - i2;
            cVar.f8972d = i3;
            return i3;
        }

        public final boolean D(RecyclerView.State state, List<c.i.a.a.b> list) {
            int i2;
            int i3 = this.f8972d;
            return i3 >= 0 && i3 < state.getItemCount() && (i2 = this.f8971c) >= 0 && i2 < list.size();
        }

        @NonNull
        public String toString() {
            return "LayoutState{mAvailable=" + this.f8969a + ", mFlexLinePosition=" + this.f8971c + ", mPosition=" + this.f8972d + ", mOffset=" + this.f8973e + ", mScrollingOffset=" + this.f8974f + ", mLastScrollDelta=" + this.f8975g + ", mItemDirection=" + this.f8976h + ", mLayoutDirection=" + this.f8977i + '}';
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    public static boolean isMeasurementUpToDate(int i2, int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (i4 > 0 && i2 != i4) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i2;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i2;
        }
        return true;
    }

    private boolean shouldMeasureChild(View view, int i2, int i3, RecyclerView.LayoutParams layoutParams) {
        return (!view.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
    }

    public final boolean A(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int iT = t(view);
        int iV = v(view);
        int iU = u(view);
        int iS = s(view);
        return z ? (paddingLeft <= iT && width >= iU) && (paddingTop <= iV && height >= iS) : (iT >= width || iU >= paddingLeft) && (iV >= height || iS >= paddingTop);
    }

    public final int B(c.i.a.a.b bVar, c cVar) {
        return isMainAxisDirectionHorizontal() ? C(bVar, cVar) : D(bVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int C(c.i.a.a.b r22, com.google.android.flexbox.FlexboxLayoutManager.c r23) {
        /*
            Method dump skipped, instruction units count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.C(c.i.a.a.b, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int D(c.i.a.a.b r26, com.google.android.flexbox.FlexboxLayoutManager.c r27) {
        /*
            Method dump skipped, instruction units count: 539
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.D(c.i.a.a.b, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    public final void E(RecyclerView.Recycler recycler, c cVar) {
        if (cVar.j) {
            if (cVar.f8977i == -1) {
                F(recycler, cVar);
            } else {
                G(recycler, cVar);
            }
        }
    }

    public final void F(RecyclerView.Recycler recycler, c cVar) {
        int childCount;
        int i2;
        View childAt;
        int i3;
        if (cVar.f8974f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(childCount - 1)) == null || (i3 = this.j.f2559c[getPosition(childAt)]) == -1) {
            return;
        }
        c.i.a.a.b bVar = this.f8948i.get(i3);
        int i4 = i2;
        while (true) {
            if (i4 < 0) {
                break;
            }
            View childAt2 = getChildAt(i4);
            if (childAt2 != null) {
                if (!h(childAt2, cVar.f8974f)) {
                    break;
                }
                if (bVar.o != getPosition(childAt2)) {
                    continue;
                } else if (i3 <= 0) {
                    childCount = i4;
                    break;
                } else {
                    i3 += cVar.f8977i;
                    bVar = this.f8948i.get(i3);
                    childCount = i4;
                }
            }
            i4--;
        }
        recycleChildren(recycler, childCount, i2);
    }

    public final void G(RecyclerView.Recycler recycler, c cVar) {
        int childCount;
        View childAt;
        if (cVar.f8974f < 0 || (childCount = getChildCount()) == 0 || (childAt = getChildAt(0)) == null) {
            return;
        }
        int i2 = this.j.f2559c[getPosition(childAt)];
        int i3 = -1;
        if (i2 == -1) {
            return;
        }
        c.i.a.a.b bVar = this.f8948i.get(i2);
        int i4 = 0;
        while (true) {
            if (i4 >= childCount) {
                break;
            }
            View childAt2 = getChildAt(i4);
            if (childAt2 != null) {
                if (!i(childAt2, cVar.f8974f)) {
                    break;
                }
                if (bVar.p != getPosition(childAt2)) {
                    continue;
                } else if (i2 >= this.f8948i.size() - 1) {
                    i3 = i4;
                    break;
                } else {
                    i2 += cVar.f8977i;
                    bVar = this.f8948i.get(i2);
                    i3 = i4;
                }
            }
            i4++;
        }
        recycleChildren(recycler, 0, i3);
    }

    public final void H() {
        int heightMode = isMainAxisDirectionHorizontal() ? getHeightMode() : getWidthMode();
        this.m.f8970b = heightMode == 0 || heightMode == Integer.MIN_VALUE;
    }

    public final void I() {
        int layoutDirection = getLayoutDirection();
        int i2 = this.f8941b;
        if (i2 == 0) {
            this.f8946g = layoutDirection == 1;
            this.f8947h = this.f8942c == 2;
            return;
        }
        if (i2 == 1) {
            this.f8946g = layoutDirection != 1;
            this.f8947h = this.f8942c == 2;
            return;
        }
        if (i2 == 2) {
            boolean z = layoutDirection == 1;
            this.f8946g = z;
            if (this.f8942c == 2) {
                this.f8946g = !z;
            }
            this.f8947h = false;
            return;
        }
        if (i2 != 3) {
            this.f8946g = false;
            this.f8947h = false;
            return;
        }
        boolean z2 = layoutDirection == 1;
        this.f8946g = z2;
        if (this.f8942c == 2) {
            this.f8946g = !z2;
        }
        this.f8947h = true;
    }

    public final boolean J(RecyclerView.State state, b bVar) {
        if (getChildCount() == 0) {
            return false;
        }
        View viewO = bVar.f8965e ? o(state.getItemCount()) : m(state.getItemCount());
        if (viewO == null) {
            return false;
        }
        bVar.s(viewO);
        if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
            if (this.o.getDecoratedStart(viewO) >= this.o.getEndAfterPadding() || this.o.getDecoratedEnd(viewO) < this.o.getStartAfterPadding()) {
                bVar.f8963c = bVar.f8965e ? this.o.getEndAfterPadding() : this.o.getStartAfterPadding();
            }
        }
        return true;
    }

    public final boolean K(RecyclerView.State state, b bVar, SavedState savedState) {
        int i2;
        View childAt;
        if (!state.isPreLayout() && (i2 = this.r) != -1) {
            if (i2 >= 0 && i2 < state.getItemCount()) {
                bVar.f8961a = this.r;
                bVar.f8962b = this.j.f2559c[bVar.f8961a];
                SavedState savedState2 = this.f8949q;
                if (savedState2 != null && savedState2.g(state.getItemCount())) {
                    bVar.f8963c = this.o.getStartAfterPadding() + savedState.f8960b;
                    bVar.f8967g = true;
                    bVar.f8962b = -1;
                    return true;
                }
                if (this.s != Integer.MIN_VALUE) {
                    if (isMainAxisDirectionHorizontal() || !this.f8946g) {
                        bVar.f8963c = this.o.getStartAfterPadding() + this.s;
                    } else {
                        bVar.f8963c = this.s - this.o.getEndPadding();
                    }
                    return true;
                }
                View viewFindViewByPosition = findViewByPosition(this.r);
                if (viewFindViewByPosition == null) {
                    if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
                        bVar.f8965e = this.r < getPosition(childAt);
                    }
                    bVar.r();
                } else {
                    if (this.o.getDecoratedMeasurement(viewFindViewByPosition) > this.o.getTotalSpace()) {
                        bVar.r();
                        return true;
                    }
                    if (this.o.getDecoratedStart(viewFindViewByPosition) - this.o.getStartAfterPadding() < 0) {
                        bVar.f8963c = this.o.getStartAfterPadding();
                        bVar.f8965e = false;
                        return true;
                    }
                    if (this.o.getEndAfterPadding() - this.o.getDecoratedEnd(viewFindViewByPosition) < 0) {
                        bVar.f8963c = this.o.getEndAfterPadding();
                        bVar.f8965e = true;
                        return true;
                    }
                    bVar.f8963c = bVar.f8965e ? this.o.getDecoratedEnd(viewFindViewByPosition) + this.o.getTotalSpaceChange() : this.o.getDecoratedStart(viewFindViewByPosition);
                }
                return true;
            }
            this.r = -1;
            this.s = Integer.MIN_VALUE;
        }
        return false;
    }

    public final void L(RecyclerView.State state, b bVar) {
        if (K(state, bVar, this.f8949q) || J(state, bVar)) {
            return;
        }
        bVar.r();
        bVar.f8961a = 0;
        bVar.f8962b = 0;
    }

    public final void M(int i2) {
        if (i2 >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.j.t(childCount);
        this.j.u(childCount);
        this.j.s(childCount);
        if (i2 >= this.j.f2559c.length) {
            return;
        }
        this.z = i2;
        View childClosestToStart = getChildClosestToStart();
        if (childClosestToStart == null) {
            return;
        }
        this.r = getPosition(childClosestToStart);
        if (isMainAxisDirectionHorizontal() || !this.f8946g) {
            this.s = this.o.getDecoratedStart(childClosestToStart) - this.o.getStartAfterPadding();
        } else {
            this.s = this.o.getDecoratedEnd(childClosestToStart) + this.o.getEndPadding();
        }
    }

    public final void N(int i2) {
        boolean z;
        int i3;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (isMainAxisDirectionHorizontal()) {
            int i4 = this.t;
            z = (i4 == Integer.MIN_VALUE || i4 == width) ? false : true;
            i3 = this.m.f8970b ? this.x.getResources().getDisplayMetrics().heightPixels : this.m.f8969a;
        } else {
            int i5 = this.u;
            z = (i5 == Integer.MIN_VALUE || i5 == height) ? false : true;
            i3 = this.m.f8970b ? this.x.getResources().getDisplayMetrics().widthPixels : this.m.f8969a;
        }
        int i6 = i3;
        this.t = width;
        this.u = height;
        int i7 = this.z;
        if (i7 == -1 && (this.r != -1 || z)) {
            if (this.n.f8965e) {
                return;
            }
            this.f8948i.clear();
            this.A.a();
            if (isMainAxisDirectionHorizontal()) {
                this.j.e(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i6, this.n.f8961a, this.f8948i);
            } else {
                this.j.h(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i6, this.n.f8961a, this.f8948i);
            }
            this.f8948i = this.A.f2562a;
            this.j.p(iMakeMeasureSpec, iMakeMeasureSpec2);
            this.j.X();
            b bVar = this.n;
            bVar.f8962b = this.j.f2559c[bVar.f8961a];
            this.m.f8971c = this.n.f8962b;
            return;
        }
        int iMin = i7 != -1 ? Math.min(i7, this.n.f8961a) : this.n.f8961a;
        this.A.a();
        if (isMainAxisDirectionHorizontal()) {
            if (this.f8948i.size() > 0) {
                this.j.j(this.f8948i, iMin);
                this.j.b(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i6, iMin, this.n.f8961a, this.f8948i);
            } else {
                this.j.s(i2);
                this.j.d(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i6, 0, this.f8948i);
            }
        } else if (this.f8948i.size() > 0) {
            this.j.j(this.f8948i, iMin);
            this.j.b(this.A, iMakeMeasureSpec2, iMakeMeasureSpec, i6, iMin, this.n.f8961a, this.f8948i);
        } else {
            this.j.s(i2);
            this.j.g(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i6, 0, this.f8948i);
        }
        this.f8948i = this.A.f2562a;
        this.j.q(iMakeMeasureSpec, iMakeMeasureSpec2, iMin);
        this.j.Y(iMin);
    }

    public final void O(int i2, int i3) {
        this.m.f8977i = i2;
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !zIsMainAxisDirectionHorizontal && this.f8946g;
        if (i2 == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt == null) {
                return;
            }
            this.m.f8973e = this.o.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View viewP = p(childAt, this.f8948i.get(this.j.f2559c[position]));
            this.m.f8976h = 1;
            c cVar = this.m;
            cVar.f8972d = position + cVar.f8976h;
            if (this.j.f2559c.length <= this.m.f8972d) {
                this.m.f8971c = -1;
            } else {
                c cVar2 = this.m;
                cVar2.f8971c = this.j.f2559c[cVar2.f8972d];
            }
            if (z) {
                this.m.f8973e = this.o.getDecoratedStart(viewP);
                this.m.f8974f = (-this.o.getDecoratedStart(viewP)) + this.o.getStartAfterPadding();
                c cVar3 = this.m;
                cVar3.f8974f = Math.max(cVar3.f8974f, 0);
            } else {
                this.m.f8973e = this.o.getDecoratedEnd(viewP);
                this.m.f8974f = this.o.getDecoratedEnd(viewP) - this.o.getEndAfterPadding();
            }
            if ((this.m.f8971c == -1 || this.m.f8971c > this.f8948i.size() - 1) && this.m.f8972d <= getFlexItemCount()) {
                int i4 = i3 - this.m.f8974f;
                this.A.a();
                if (i4 > 0) {
                    if (zIsMainAxisDirectionHorizontal) {
                        this.j.d(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i4, this.m.f8972d, this.f8948i);
                    } else {
                        this.j.g(this.A, iMakeMeasureSpec, iMakeMeasureSpec2, i4, this.m.f8972d, this.f8948i);
                    }
                    this.j.q(iMakeMeasureSpec, iMakeMeasureSpec2, this.m.f8972d);
                    this.j.Y(this.m.f8972d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 == null) {
                return;
            }
            this.m.f8973e = this.o.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View viewN = n(childAt2, this.f8948i.get(this.j.f2559c[position2]));
            this.m.f8976h = 1;
            int i5 = this.j.f2559c[position2];
            if (i5 == -1) {
                i5 = 0;
            }
            if (i5 > 0) {
                this.m.f8972d = position2 - this.f8948i.get(i5 - 1).getItemCount();
            } else {
                this.m.f8972d = -1;
            }
            this.m.f8971c = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.m.f8973e = this.o.getDecoratedEnd(viewN);
                this.m.f8974f = this.o.getDecoratedEnd(viewN) - this.o.getEndAfterPadding();
                c cVar4 = this.m;
                cVar4.f8974f = Math.max(cVar4.f8974f, 0);
            } else {
                this.m.f8973e = this.o.getDecoratedStart(viewN);
                this.m.f8974f = (-this.o.getDecoratedStart(viewN)) + this.o.getStartAfterPadding();
            }
        }
        c cVar5 = this.m;
        cVar5.f8969a = i3 - cVar5.f8974f;
    }

    public final void P(b bVar, boolean z, boolean z2) {
        if (z2) {
            H();
        } else {
            this.m.f8970b = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.f8946g) {
            this.m.f8969a = this.o.getEndAfterPadding() - bVar.f8963c;
        } else {
            this.m.f8969a = bVar.f8963c - getPaddingRight();
        }
        this.m.f8972d = bVar.f8961a;
        this.m.f8976h = 1;
        this.m.f8977i = 1;
        this.m.f8973e = bVar.f8963c;
        this.m.f8974f = Integer.MIN_VALUE;
        this.m.f8971c = bVar.f8962b;
        if (!z || this.f8948i.size() <= 1 || bVar.f8962b < 0 || bVar.f8962b >= this.f8948i.size() - 1) {
            return;
        }
        c.i.a.a.b bVar2 = this.f8948i.get(bVar.f8962b);
        c.l(this.m);
        c.u(this.m, bVar2.getItemCount());
    }

    public final void Q(b bVar, boolean z, boolean z2) {
        if (z2) {
            H();
        } else {
            this.m.f8970b = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.f8946g) {
            this.m.f8969a = bVar.f8963c - this.o.getStartAfterPadding();
        } else {
            this.m.f8969a = (this.y.getWidth() - bVar.f8963c) - this.o.getStartAfterPadding();
        }
        this.m.f8972d = bVar.f8961a;
        this.m.f8976h = 1;
        this.m.f8977i = -1;
        this.m.f8973e = bVar.f8963c;
        this.m.f8974f = Integer.MIN_VALUE;
        this.m.f8971c = bVar.f8962b;
        if (!z || bVar.f8962b <= 0 || this.f8948i.size() <= bVar.f8962b) {
            return;
        }
        c.i.a.a.b bVar2 = this.f8948i.get(bVar.f8962b);
        c.m(this.m);
        c.v(this.m, bVar2.getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.f8942c == 0) {
            return isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            int width = getWidth();
            View view = this.y;
            if (width <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.f8942c == 0) {
            return !isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            return true;
        }
        int height = getHeight();
        View view = this.y;
        return height > (view != null ? view.getHeight() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(@NonNull RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(@NonNull RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(@NonNull RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        k();
        View viewM = m(itemCount);
        View viewO = o(itemCount);
        if (state.getItemCount() == 0 || viewM == null || viewO == null) {
            return 0;
        }
        return Math.min(this.o.getTotalSpace(), this.o.getDecoratedEnd(viewO) - this.o.getDecoratedStart(viewM));
    }

    public final int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewM = m(itemCount);
        View viewO = o(itemCount);
        if (state.getItemCount() != 0 && viewM != null && viewO != null) {
            int position = getPosition(viewM);
            int position2 = getPosition(viewO);
            int iAbs = Math.abs(this.o.getDecoratedEnd(viewO) - this.o.getDecoratedStart(viewM));
            int i2 = this.j.f2559c[position];
            if (i2 != 0 && i2 != -1) {
                return Math.round((i2 * (iAbs / ((r4[position2] - i2) + 1))) + (this.o.getStartAfterPadding() - this.o.getDecoratedStart(viewM)));
            }
        }
        return 0;
    }

    public final int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewM = m(itemCount);
        View viewO = o(itemCount);
        if (state.getItemCount() == 0 || viewM == null || viewO == null) {
            return 0;
        }
        int iFindFirstVisibleItemPosition = findFirstVisibleItemPosition();
        return (int) ((Math.abs(this.o.getDecoratedEnd(viewO) - this.o.getDecoratedStart(viewM)) / ((findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1)) * state.getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i2) {
        View childAt;
        if (getChildCount() == 0 || (childAt = getChildAt(0)) == null) {
            return null;
        }
        int i3 = i2 < getPosition(childAt) ? -1 : 1;
        return isMainAxisDirectionHorizontal() ? new PointF(0.0f, i3) : new PointF(i3, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(@NonNull RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(@NonNull RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(@NonNull RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final void ensureLayoutState() {
        if (this.m == null) {
            this.m = new c();
        }
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View viewQ = q(0, getChildCount(), true);
        if (viewQ == null) {
            return -1;
        }
        return getPosition(viewQ);
    }

    public int findFirstVisibleItemPosition() {
        View viewQ = q(0, getChildCount(), false);
        if (viewQ == null) {
            return -1;
        }
        return getPosition(viewQ);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View viewQ = q(getChildCount() - 1, -1, true);
        if (viewQ == null) {
            return -1;
        }
        return getPosition(viewQ);
    }

    public int findLastVisibleItemPosition() {
        View viewQ = q(getChildCount() - 1, -1, false);
        if (viewQ == null) {
            return -1;
        }
        return getPosition(viewQ);
    }

    public final int fixLayoutEndGap(int i2, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int iX;
        int endAfterPadding;
        if (!isMainAxisDirectionHorizontal() && this.f8946g) {
            int startAfterPadding = i2 - this.o.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            iX = x(startAfterPadding, recycler, state);
        } else {
            int endAfterPadding2 = this.o.getEndAfterPadding() - i2;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            iX = -x(-endAfterPadding2, recycler, state);
        }
        int i3 = i2 + iX;
        if (!z || (endAfterPadding = this.o.getEndAfterPadding() - i3) <= 0) {
            return iX;
        }
        this.o.offsetChildren(endAfterPadding);
        return endAfterPadding + iX;
    }

    public final int fixLayoutStartGap(int i2, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int iX;
        int startAfterPadding;
        if (isMainAxisDirectionHorizontal() || !this.f8946g) {
            int startAfterPadding2 = i2 - this.o.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            iX = -x(startAfterPadding2, recycler, state);
        } else {
            int endAfterPadding = this.o.getEndAfterPadding() - i2;
            if (endAfterPadding <= 0) {
                return 0;
            }
            iX = x(-endAfterPadding, recycler, state);
        }
        int i3 = i2 + iX;
        if (!z || (startAfterPadding = i3 - this.o.getStartAfterPadding()) <= 0) {
            return iX;
        }
        this.o.offsetChildren(-startAfterPadding);
        return iX - startAfterPadding;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // c.i.a.a.a
    public int getAlignContent() {
        return 5;
    }

    @Override // c.i.a.a.a
    public int getAlignItems() {
        return this.f8944e;
    }

    public final View getChildClosestToStart() {
        return getChildAt(0);
    }

    @Override // c.i.a.a.a
    public int getChildHeightMeasureSpec(int i2, int i3, int i4) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), i3, i4, canScrollVertically());
    }

    @Override // c.i.a.a.a
    public int getChildWidthMeasureSpec(int i2, int i3, int i4) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), i3, i4, canScrollHorizontally());
    }

    @Override // c.i.a.a.a
    public int getDecorationLengthCrossAxis(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (isMainAxisDirectionHorizontal()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    @Override // c.i.a.a.a
    public int getDecorationLengthMainAxis(View view, int i2, int i3) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (isMainAxisDirectionHorizontal()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // c.i.a.a.a
    public int getFlexDirection() {
        return this.f8941b;
    }

    @Override // c.i.a.a.a
    public View getFlexItemAt(int i2) {
        View view = this.w.get(i2);
        return view != null ? view : this.k.getViewForPosition(i2);
    }

    @Override // c.i.a.a.a
    public int getFlexItemCount() {
        return this.l.getItemCount();
    }

    @Override // c.i.a.a.a
    @NonNull
    public List<c.i.a.a.b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f8948i.size());
        int size = this.f8948i.size();
        for (int i2 = 0; i2 < size; i2++) {
            c.i.a.a.b bVar = this.f8948i.get(i2);
            if (bVar.getItemCount() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // c.i.a.a.a
    public List<c.i.a.a.b> getFlexLinesInternal() {
        return this.f8948i;
    }

    @Override // c.i.a.a.a
    public int getFlexWrap() {
        return this.f8942c;
    }

    @Override // c.i.a.a.a
    public int getJustifyContent() {
        return this.f8943d;
    }

    @Override // c.i.a.a.a
    public int getLargestMainSize() {
        if (this.f8948i.size() == 0) {
            return 0;
        }
        int iMax = Integer.MIN_VALUE;
        int size = this.f8948i.size();
        for (int i2 = 0; i2 < size; i2++) {
            iMax = Math.max(iMax, this.f8948i.get(i2).f2551e);
        }
        return iMax;
    }

    @Override // c.i.a.a.a
    public int getMaxLine() {
        return this.f8945f;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.v;
    }

    @Override // c.i.a.a.a
    public View getReorderedFlexItemAt(int i2) {
        return getFlexItemAt(i2);
    }

    @Override // c.i.a.a.a
    public int getSumOfCrossSize() {
        int size = this.f8948i.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += this.f8948i.get(i3).f2553g;
        }
        return i2;
    }

    public final boolean h(View view, int i2) {
        return (isMainAxisDirectionHorizontal() || !this.f8946g) ? this.o.getDecoratedStart(view) >= this.o.getEnd() - i2 : this.o.getDecoratedEnd(view) <= i2;
    }

    public final boolean i(View view, int i2) {
        return (isMainAxisDirectionHorizontal() || !this.f8946g) ? this.o.getDecoratedEnd(view) <= i2 : this.o.getEnd() - this.o.getDecoratedStart(view) <= i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // c.i.a.a.a
    public boolean isMainAxisDirectionHorizontal() {
        int i2 = this.f8941b;
        return i2 == 0 || i2 == 1;
    }

    public final void j() {
        this.f8948i.clear();
        this.n.t();
        this.n.f8964d = 0;
    }

    public final void k() {
        if (this.o != null) {
            return;
        }
        if (isMainAxisDirectionHorizontal()) {
            if (this.f8942c == 0) {
                this.o = OrientationHelper.createHorizontalHelper(this);
                this.p = OrientationHelper.createVerticalHelper(this);
                return;
            } else {
                this.o = OrientationHelper.createVerticalHelper(this);
                this.p = OrientationHelper.createHorizontalHelper(this);
                return;
            }
        }
        if (this.f8942c == 0) {
            this.o = OrientationHelper.createVerticalHelper(this);
            this.p = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.o = OrientationHelper.createHorizontalHelper(this);
            this.p = OrientationHelper.createVerticalHelper(this);
        }
    }

    public final int l(RecyclerView.Recycler recycler, RecyclerView.State state, c cVar) {
        if (cVar.f8974f != Integer.MIN_VALUE) {
            if (cVar.f8969a < 0) {
                c.q(cVar, cVar.f8969a);
            }
            E(recycler, cVar);
        }
        int i2 = cVar.f8969a;
        int crossSize = cVar.f8969a;
        int iB = 0;
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        while (true) {
            if ((crossSize <= 0 && !this.m.f8970b) || !cVar.D(state, this.f8948i)) {
                break;
            }
            c.i.a.a.b bVar = this.f8948i.get(cVar.f8971c);
            cVar.f8972d = bVar.o;
            iB += B(bVar, cVar);
            if (zIsMainAxisDirectionHorizontal || !this.f8946g) {
                c.c(cVar, bVar.getCrossSize() * cVar.f8977i);
            } else {
                c.d(cVar, bVar.getCrossSize() * cVar.f8977i);
            }
            crossSize -= bVar.getCrossSize();
        }
        c.i(cVar, iB);
        if (cVar.f8974f != Integer.MIN_VALUE) {
            c.q(cVar, iB);
            if (cVar.f8969a < 0) {
                c.q(cVar, cVar.f8969a);
            }
            E(recycler, cVar);
        }
        return i2 - cVar.f8969a;
    }

    public final View m(int i2) {
        View viewR = r(0, getChildCount(), i2);
        if (viewR == null) {
            return null;
        }
        int i3 = this.j.f2559c[getPosition(viewR)];
        if (i3 == -1) {
            return null;
        }
        return n(viewR, this.f8948i.get(i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View n(android.view.View r6, c.i.a.a.b r7) {
        /*
            r5 = this;
            boolean r0 = r5.isMainAxisDirectionHorizontal()
            int r7 = r7.f2554h
            r1 = 1
        L7:
            if (r1 >= r7) goto L3f
            android.view.View r2 = r5.getChildAt(r1)
            if (r2 == 0) goto L3c
            int r3 = r2.getVisibility()
            r4 = 8
            if (r3 != r4) goto L18
            goto L3c
        L18:
            boolean r3 = r5.f8946g
            if (r3 == 0) goto L2d
            if (r0 != 0) goto L2d
            androidx.recyclerview.widget.OrientationHelper r3 = r5.o
            int r3 = r3.getDecoratedEnd(r6)
            androidx.recyclerview.widget.OrientationHelper r4 = r5.o
            int r4 = r4.getDecoratedEnd(r2)
            if (r3 >= r4) goto L3c
            goto L3b
        L2d:
            androidx.recyclerview.widget.OrientationHelper r3 = r5.o
            int r3 = r3.getDecoratedStart(r6)
            androidx.recyclerview.widget.OrientationHelper r4 = r5.o
            int r4 = r4.getDecoratedStart(r2)
            if (r3 <= r4) goto L3c
        L3b:
            r6 = r2
        L3c:
            int r1 = r1 + 1
            goto L7
        L3f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.n(android.view.View, c.i.a.a.b):android.view.View");
    }

    public final View o(int i2) {
        View viewR = r(getChildCount() - 1, -1, i2);
        if (viewR == null) {
            return null;
        }
        return p(viewR, this.f8948i.get(this.j.f2559c[getPosition(viewR)]));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.y = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.v) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(@NonNull RecyclerView recyclerView, int i2, int i3) {
        super.onItemsAdded(recyclerView, i2, i3);
        M(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(@NonNull RecyclerView recyclerView, int i2, int i3, int i4) {
        super.onItemsMoved(recyclerView, i2, i3, i4);
        M(Math.min(i2, i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i2, int i3) {
        super.onItemsRemoved(recyclerView, i2, i3);
        M(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i2, int i3, Object obj) {
        super.onItemsUpdated(recyclerView, i2, i3, obj);
        M(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2;
        int i3;
        this.k = recycler;
        this.l = state;
        int itemCount = state.getItemCount();
        if (itemCount == 0 && state.isPreLayout()) {
            return;
        }
        I();
        k();
        ensureLayoutState();
        this.j.t(itemCount);
        this.j.u(itemCount);
        this.j.s(itemCount);
        this.m.j = false;
        SavedState savedState = this.f8949q;
        if (savedState != null && savedState.g(itemCount)) {
            this.r = this.f8949q.f8959a;
        }
        if (!this.n.f8966f || this.r != -1 || this.f8949q != null) {
            this.n.t();
            L(state, this.n);
            this.n.f8966f = true;
        }
        detachAndScrapAttachedViews(recycler);
        if (this.n.f8965e) {
            Q(this.n, false, true);
        } else {
            P(this.n, false, true);
        }
        N(itemCount);
        l(recycler, state, this.m);
        if (this.n.f8965e) {
            i3 = this.m.f8973e;
            P(this.n, true, false);
            l(recycler, state, this.m);
            i2 = this.m.f8973e;
        } else {
            i2 = this.m.f8973e;
            Q(this.n, true, false);
            l(recycler, state, this.m);
            i3 = this.m.f8973e;
        }
        if (getChildCount() > 0) {
            if (this.n.f8965e) {
                fixLayoutStartGap(i3 + fixLayoutEndGap(i2, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(i2 + fixLayoutStartGap(i3, recycler, state, true), recycler, state, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f8949q = null;
        this.r = -1;
        this.s = Integer.MIN_VALUE;
        this.z = -1;
        this.n.t();
        this.w.clear();
    }

    @Override // c.i.a.a.a
    public void onNewFlexItemAdded(View view, int i2, int i3, c.i.a.a.b bVar) {
        calculateItemDecorationsForChild(view, f8940a);
        if (isMainAxisDirectionHorizontal()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.f2551e += leftDecorationWidth;
            bVar.f2552f += leftDecorationWidth;
        } else {
            int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
            bVar.f2551e += topDecorationHeight;
            bVar.f2552f += topDecorationHeight;
        }
    }

    @Override // c.i.a.a.a
    public void onNewFlexLineAdded(c.i.a.a.b bVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f8949q = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.f8949q != null) {
            return new SavedState(this.f8949q);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            View childClosestToStart = getChildClosestToStart();
            savedState.f8959a = getPosition(childClosestToStart);
            savedState.f8960b = this.o.getDecoratedStart(childClosestToStart) - this.o.getStartAfterPadding();
        } else {
            savedState.h();
        }
        return savedState;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View p(android.view.View r6, c.i.a.a.b r7) {
        /*
            r5 = this;
            boolean r0 = r5.isMainAxisDirectionHorizontal()
            int r1 = r5.getChildCount()
            int r1 = r1 + (-2)
            int r2 = r5.getChildCount()
            int r7 = r7.f2554h
            int r2 = r2 - r7
            int r2 = r2 + (-1)
        L13:
            if (r1 <= r2) goto L4b
            android.view.View r7 = r5.getChildAt(r1)
            if (r7 == 0) goto L48
            int r3 = r7.getVisibility()
            r4 = 8
            if (r3 != r4) goto L24
            goto L48
        L24:
            boolean r3 = r5.f8946g
            if (r3 == 0) goto L39
            if (r0 != 0) goto L39
            androidx.recyclerview.widget.OrientationHelper r3 = r5.o
            int r3 = r3.getDecoratedStart(r6)
            androidx.recyclerview.widget.OrientationHelper r4 = r5.o
            int r4 = r4.getDecoratedStart(r7)
            if (r3 <= r4) goto L48
            goto L47
        L39:
            androidx.recyclerview.widget.OrientationHelper r3 = r5.o
            int r3 = r3.getDecoratedEnd(r6)
            androidx.recyclerview.widget.OrientationHelper r4 = r5.o
            int r4 = r4.getDecoratedEnd(r7)
            if (r3 >= r4) goto L48
        L47:
            r6 = r7
        L48:
            int r1 = r1 + (-1)
            goto L13
        L4b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.p(android.view.View, c.i.a.a.b):android.view.View");
    }

    public final View q(int i2, int i3, boolean z) {
        int i4 = i3 > i2 ? 1 : -1;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (A(childAt, z)) {
                return childAt;
            }
            i2 += i4;
        }
        return null;
    }

    public final View r(int i2, int i3, int i4) {
        int position;
        k();
        ensureLayoutState();
        int startAfterPadding = this.o.getStartAfterPadding();
        int endAfterPadding = this.o.getEndAfterPadding();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (childAt != null && (position = getPosition(childAt)) >= 0 && position < i4) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.o.getDecoratedStart(childAt) >= startAfterPadding && this.o.getDecoratedEnd(childAt) <= endAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i2 += i5;
        }
        return view != null ? view : view2;
    }

    public final void recycleChildren(RecyclerView.Recycler recycler, int i2, int i3) {
        while (i3 >= i2) {
            removeAndRecycleViewAt(i3, recycler);
            i3--;
        }
    }

    public final int s(View view) {
        return getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!isMainAxisDirectionHorizontal() || this.f8942c == 0) {
            int iX = x(i2, recycler, state);
            this.w.clear();
            return iX;
        }
        int iY = y(i2);
        b.l(this.n, iY);
        this.p.offsetChildren(-iY);
        return iY;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i2) {
        this.r = i2;
        this.s = Integer.MIN_VALUE;
        SavedState savedState = this.f8949q;
        if (savedState != null) {
            savedState.h();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (isMainAxisDirectionHorizontal() || (this.f8942c == 0 && !isMainAxisDirectionHorizontal())) {
            int iX = x(i2, recycler, state);
            this.w.clear();
            return iX;
        }
        int iY = y(i2);
        b.l(this.n, iY);
        this.p.offsetChildren(-iY);
        return iY;
    }

    @Override // c.i.a.a.a
    public void setAlignContent(int i2) {
        throw new UnsupportedOperationException("Setting the alignContent in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to use this attribute.");
    }

    @Override // c.i.a.a.a
    public void setAlignItems(int i2) {
        int i3 = this.f8944e;
        if (i3 != i2) {
            if (i3 == 4 || i2 == 4) {
                removeAllViews();
                j();
            }
            this.f8944e = i2;
            requestLayout();
        }
    }

    @Override // c.i.a.a.a
    public void setFlexDirection(int i2) {
        if (this.f8941b != i2) {
            removeAllViews();
            this.f8941b = i2;
            this.o = null;
            this.p = null;
            j();
            requestLayout();
        }
    }

    @Override // c.i.a.a.a
    public void setFlexLines(List<c.i.a.a.b> list) {
        this.f8948i = list;
    }

    @Override // c.i.a.a.a
    public void setFlexWrap(int i2) {
        if (i2 == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i3 = this.f8942c;
        if (i3 != i2) {
            if (i3 == 0 || i2 == 0) {
                removeAllViews();
                j();
            }
            this.f8942c = i2;
            this.o = null;
            this.p = null;
            requestLayout();
        }
    }

    @Override // c.i.a.a.a
    public void setJustifyContent(int i2) {
        if (this.f8943d != i2) {
            this.f8943d = i2;
            requestLayout();
        }
    }

    @Override // c.i.a.a.a
    public void setMaxLine(int i2) {
        if (this.f8945f != i2) {
            this.f8945f = i2;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.v = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i2);
        startSmoothScroll(linearSmoothScroller);
    }

    public final int t(View view) {
        return getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    public final int u(View view) {
        return getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    @Override // c.i.a.a.a
    public void updateViewCache(int i2, View view) {
        this.w.put(i2, view);
    }

    public final int v(View view) {
        return getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    public int w(int i2) {
        return this.j.f2559c[i2];
    }

    public final int x(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        k();
        int i3 = 1;
        this.m.j = true;
        boolean z = !isMainAxisDirectionHorizontal() && this.f8946g;
        if (!z ? i2 <= 0 : i2 >= 0) {
            i3 = -1;
        }
        int iAbs = Math.abs(i2);
        O(i3, iAbs);
        int iL = this.m.f8974f + l(recycler, state, this.m);
        if (iL < 0) {
            return 0;
        }
        if (z) {
            if (iAbs > iL) {
                i2 = (-i3) * iL;
            }
        } else if (iAbs > iL) {
            i2 = i3 * iL;
        }
        this.o.offsetChildren(-i2);
        this.m.f8975g = i2;
        return i2;
    }

    public final int y(int i2) {
        int iMin;
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        k();
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        View view = this.y;
        int width = zIsMainAxisDirectionHorizontal ? view.getWidth() : view.getHeight();
        int width2 = zIsMainAxisDirectionHorizontal ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int iAbs = Math.abs(i2);
            if (i2 < 0) {
                iMin = Math.min((width2 + this.n.f8964d) - width, iAbs);
            } else {
                if (this.n.f8964d + i2 <= 0) {
                    return i2;
                }
                iMin = this.n.f8964d;
            }
        } else {
            if (i2 > 0) {
                return Math.min((width2 - this.n.f8964d) - width, i2);
            }
            if (this.n.f8964d + i2 >= 0) {
                return i2;
            }
            iMin = this.n.f8964d;
        }
        return -iMin;
    }

    public boolean z() {
        return this.f8946g;
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8960b;

        public class a implements Parcelable.Creator<SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final boolean g(int i2) {
            int i3 = this.f8959a;
            return i3 >= 0 && i3 < i2;
        }

        public final void h() {
            this.f8959a = -1;
        }

        @NonNull
        public String toString() {
            return "SavedState{mAnchorPosition=" + this.f8959a + ", mAnchorOffset=" + this.f8960b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f8959a);
            parcel.writeInt(this.f8960b);
        }

        public SavedState() {
        }

        public SavedState(Parcel parcel) {
            this.f8959a = parcel.readInt();
            this.f8960b = parcel.readInt();
        }

        public SavedState(SavedState savedState) {
            this.f8959a = savedState.f8959a;
            this.f8960b = savedState.f8960b;
        }
    }

    public FlexboxLayoutManager(Context context, int i2) {
        this(context, i2, 1);
    }

    public FlexboxLayoutManager(Context context, int i2, int i3) {
        this.f8945f = -1;
        this.f8948i = new ArrayList();
        this.j = new c.i.a.a.c(this);
        this.n = new b();
        this.r = -1;
        this.s = Integer.MIN_VALUE;
        this.t = Integer.MIN_VALUE;
        this.u = Integer.MIN_VALUE;
        this.w = new SparseArray<>();
        this.z = -1;
        this.A = new c.b();
        setFlexDirection(i2);
        setFlexWrap(i3);
        setAlignItems(4);
        this.x = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i2, int i3) {
        super.onItemsUpdated(recyclerView, i2, i3);
        M(i2);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f8950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f8951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f8953d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8954e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8955f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8956g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f8957h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f8958i;

        public class a implements Parcelable.Creator<LayoutParams> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LayoutParams[] newArray(int i2) {
                return new LayoutParams[i2];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8950a = 0.0f;
            this.f8951b = 1.0f;
            this.f8952c = -1;
            this.f8953d = -1.0f;
            this.f8956g = ViewCompat.MEASURED_SIZE_MASK;
            this.f8957h = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.f8952c;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.f8953d;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.f8950a;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.f8951b;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.f8957h;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.f8956g;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.f8955f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.f8954e;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.f8958i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setAlignSelf(int i2) {
            this.f8952c = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexBasisPercent(float f2) {
            this.f8953d = f2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexGrow(float f2) {
            this.f8950a = f2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexShrink(float f2) {
            this.f8951b = f2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int i2) {
            ((ViewGroup.MarginLayoutParams) this).height = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxHeight(int i2) {
            this.f8957h = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxWidth(int i2) {
            this.f8956g = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int i2) {
            this.f8955f = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i2) {
            this.f8954e = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setOrder(int i2) {
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWidth(int i2) {
            ((ViewGroup.MarginLayoutParams) this).width = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWrapBefore(boolean z) {
            this.f8958i = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeFloat(this.f8950a);
            parcel.writeFloat(this.f8951b);
            parcel.writeInt(this.f8952c);
            parcel.writeFloat(this.f8953d);
            parcel.writeInt(this.f8954e);
            parcel.writeInt(this.f8955f);
            parcel.writeInt(this.f8956g);
            parcel.writeInt(this.f8957h);
            parcel.writeByte(this.f8958i ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f8950a = 0.0f;
            this.f8951b = 1.0f;
            this.f8952c = -1;
            this.f8953d = -1.0f;
            this.f8956g = ViewCompat.MEASURED_SIZE_MASK;
            this.f8957h = ViewCompat.MEASURED_SIZE_MASK;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f8950a = 0.0f;
            this.f8951b = 1.0f;
            this.f8952c = -1;
            this.f8953d = -1.0f;
            this.f8956g = ViewCompat.MEASURED_SIZE_MASK;
            this.f8957h = ViewCompat.MEASURED_SIZE_MASK;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8950a = 0.0f;
            this.f8951b = 1.0f;
            this.f8952c = -1;
            this.f8953d = -1.0f;
            this.f8956g = ViewCompat.MEASURED_SIZE_MASK;
            this.f8957h = ViewCompat.MEASURED_SIZE_MASK;
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8950a = 0.0f;
            this.f8951b = 1.0f;
            this.f8952c = -1;
            this.f8953d = -1.0f;
            this.f8956g = ViewCompat.MEASURED_SIZE_MASK;
            this.f8957h = ViewCompat.MEASURED_SIZE_MASK;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((RecyclerView.LayoutParams) layoutParams);
            this.f8950a = 0.0f;
            this.f8951b = 1.0f;
            this.f8952c = -1;
            this.f8953d = -1.0f;
            this.f8956g = ViewCompat.MEASURED_SIZE_MASK;
            this.f8957h = ViewCompat.MEASURED_SIZE_MASK;
            this.f8950a = layoutParams.f8950a;
            this.f8951b = layoutParams.f8951b;
            this.f8952c = layoutParams.f8952c;
            this.f8953d = layoutParams.f8953d;
            this.f8954e = layoutParams.f8954e;
            this.f8955f = layoutParams.f8955f;
            this.f8956g = layoutParams.f8956g;
            this.f8957h = layoutParams.f8957h;
            this.f8958i = layoutParams.f8958i;
        }

        public LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.f8950a = 0.0f;
            this.f8951b = 1.0f;
            this.f8952c = -1;
            this.f8953d = -1.0f;
            this.f8956g = ViewCompat.MEASURED_SIZE_MASK;
            this.f8957h = ViewCompat.MEASURED_SIZE_MASK;
            this.f8950a = parcel.readFloat();
            this.f8951b = parcel.readFloat();
            this.f8952c = parcel.readInt();
            this.f8953d = parcel.readFloat();
            this.f8954e = parcel.readInt();
            this.f8955f = parcel.readInt();
            this.f8956g = parcel.readInt();
            this.f8957h = parcel.readInt();
            this.f8958i = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f8945f = -1;
        this.f8948i = new ArrayList();
        this.j = new c.i.a.a.c(this);
        this.n = new b();
        this.r = -1;
        this.s = Integer.MIN_VALUE;
        this.t = Integer.MIN_VALUE;
        this.u = Integer.MIN_VALUE;
        this.w = new SparseArray<>();
        this.z = -1;
        this.A = new c.b();
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i2, i3);
        int i4 = properties.orientation;
        if (i4 != 0) {
            if (i4 == 1) {
                if (properties.reverseLayout) {
                    setFlexDirection(3);
                } else {
                    setFlexDirection(2);
                }
            }
        } else if (properties.reverseLayout) {
            setFlexDirection(1);
        } else {
            setFlexDirection(0);
        }
        setFlexWrap(1);
        setAlignItems(4);
        this.x = context;
    }
}
