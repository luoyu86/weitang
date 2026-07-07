package androidx.constraintlayout.solver.widgets;

import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.solver.Cache;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class WidgetContainer extends ConstraintWidget {
    public ArrayList<ConstraintWidget> mChildren;

    public WidgetContainer() {
        this.mChildren = new ArrayList<>();
    }

    public static Rectangle getBounds(ArrayList<ConstraintWidget> arrayList) {
        Rectangle rectangle = new Rectangle();
        if (arrayList.size() == 0) {
            return rectangle;
        }
        int size = arrayList.size();
        int x = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int y = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int right = 0;
        int bottom = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = arrayList.get(i2);
            if (constraintWidget.getX() < x) {
                x = constraintWidget.getX();
            }
            if (constraintWidget.getY() < y) {
                y = constraintWidget.getY();
            }
            if (constraintWidget.getRight() > right) {
                right = constraintWidget.getRight();
            }
            if (constraintWidget.getBottom() > bottom) {
                bottom = constraintWidget.getBottom();
            }
        }
        rectangle.setBounds(x, y, right - x, bottom - y);
        return rectangle;
    }

    public void add(ConstraintWidget constraintWidget) {
        this.mChildren.add(constraintWidget);
        if (constraintWidget.getParent() != null) {
            ((WidgetContainer) constraintWidget.getParent()).remove(constraintWidget);
        }
        constraintWidget.setParent(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006d A[PHI: r3
  0x006d: PHI (r3v5 androidx.constraintlayout.solver.widgets.ConstraintWidget) = 
  (r3v4 androidx.constraintlayout.solver.widgets.ConstraintWidget)
  (r3v7 androidx.constraintlayout.solver.widgets.ConstraintWidget)
 binds: [B:26:0x006b, B:17:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.constraintlayout.solver.widgets.ConstraintWidget findWidget(float r9, float r10) {
        /*
            r8 = this;
            int r0 = r8.getDrawX()
            int r1 = r8.getDrawY()
            int r2 = r8.getWidth()
            int r2 = r2 + r0
            int r3 = r8.getHeight()
            int r3 = r3 + r1
            float r0 = (float) r0
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 < 0) goto L28
            float r0 = (float) r2
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 > 0) goto L28
            float r0 = (float) r1
            int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r0 < 0) goto L28
            float r0 = (float) r3
            int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r0 > 0) goto L28
            r0 = r8
            goto L29
        L28:
            r0 = 0
        L29:
            r1 = 0
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r2 = r8.mChildren
            int r2 = r2.size()
        L30:
            if (r1 >= r2) goto L71
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r3 = r8.mChildren
            java.lang.Object r3 = r3.get(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r3
            boolean r4 = r3 instanceof androidx.constraintlayout.solver.widgets.WidgetContainer
            if (r4 == 0) goto L47
            androidx.constraintlayout.solver.widgets.WidgetContainer r3 = (androidx.constraintlayout.solver.widgets.WidgetContainer) r3
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.findWidget(r9, r10)
            if (r3 == 0) goto L6e
            goto L6d
        L47:
            int r4 = r3.getDrawX()
            int r5 = r3.getDrawY()
            int r6 = r3.getWidth()
            int r6 = r6 + r4
            int r7 = r3.getHeight()
            int r7 = r7 + r5
            float r4 = (float) r4
            int r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r4 < 0) goto L6e
            float r4 = (float) r6
            int r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r4 > 0) goto L6e
            float r4 = (float) r5
            int r4 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r4 < 0) goto L6e
            float r4 = (float) r7
            int r4 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r4 > 0) goto L6e
        L6d:
            r0 = r3
        L6e:
            int r1 = r1 + 1
            goto L30
        L71:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.WidgetContainer.findWidget(float, float):androidx.constraintlayout.solver.widgets.ConstraintWidget");
    }

    public ArrayList<ConstraintWidget> findWidgets(int i2, int i3, int i4, int i5) {
        ArrayList<ConstraintWidget> arrayList = new ArrayList<>();
        Rectangle rectangle = new Rectangle();
        rectangle.setBounds(i2, i3, i4, i5);
        int size = this.mChildren.size();
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i6);
            Rectangle rectangle2 = new Rectangle();
            rectangle2.setBounds(constraintWidget.getDrawX(), constraintWidget.getDrawY(), constraintWidget.getWidth(), constraintWidget.getHeight());
            if (rectangle.intersects(rectangle2)) {
                arrayList.add(constraintWidget);
            }
        }
        return arrayList;
    }

    public ArrayList<ConstraintWidget> getChildren() {
        return this.mChildren;
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        ConstraintWidget parent = getParent();
        ConstraintWidgetContainer constraintWidgetContainer = this instanceof ConstraintWidgetContainer ? (ConstraintWidgetContainer) this : null;
        while (parent != null) {
            ConstraintWidget parent2 = parent.getParent();
            if (parent instanceof ConstraintWidgetContainer) {
                constraintWidgetContainer = (ConstraintWidgetContainer) parent;
            }
            parent = parent2;
        }
        return constraintWidgetContainer;
    }

    public void layout() {
        updateDrawPosition();
        ArrayList<ConstraintWidget> arrayList = this.mChildren;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i2);
            if (constraintWidget instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget).layout();
            }
        }
    }

    public void remove(ConstraintWidget constraintWidget) {
        this.mChildren.remove(constraintWidget);
        constraintWidget.setParent(null);
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void resetSolverVariables(Cache cache) {
        super.resetSolverVariables(cache);
        int size = this.mChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mChildren.get(i2).resetSolverVariables(cache);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void setOffset(int i2, int i3) {
        super.setOffset(i2, i3);
        int size = this.mChildren.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mChildren.get(i4).setOffset(getRootX(), getRootY());
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateDrawPosition() {
        super.updateDrawPosition();
        ArrayList<ConstraintWidget> arrayList = this.mChildren;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i2);
            constraintWidget.setOffset(getDrawX(), getDrawY());
            if (!(constraintWidget instanceof ConstraintWidgetContainer)) {
                constraintWidget.updateDrawPosition();
            }
        }
    }

    public WidgetContainer(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5);
        this.mChildren = new ArrayList<>();
    }

    public WidgetContainer(int i2, int i3) {
        super(i2, i3);
        this.mChildren = new ArrayList<>();
    }

    public void add(ConstraintWidget... constraintWidgetArr) {
        for (ConstraintWidget constraintWidget : constraintWidgetArr) {
            add(constraintWidget);
        }
    }
}
