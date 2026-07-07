package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Analyzer {
    private Analyzer() {
    }

    public static void determineGroups(ConstraintWidgetContainer constraintWidgetContainer) {
        if ((constraintWidgetContainer.getOptimizationLevel() & 32) != 32) {
            singleGroup(constraintWidgetContainer);
            return;
        }
        constraintWidgetContainer.mSkipSolver = true;
        constraintWidgetContainer.mGroupsWrapOptimized = false;
        constraintWidgetContainer.mHorizontalWrapOptimized = false;
        constraintWidgetContainer.mVerticalWrapOptimized = false;
        ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.mChildren;
        List<ConstraintWidgetGroup> list = constraintWidgetContainer.mWidgetGroups;
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidgetContainer.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z = horizontalDimensionBehaviour == dimensionBehaviour;
        boolean z2 = constraintWidgetContainer.getVerticalDimensionBehaviour() == dimensionBehaviour;
        boolean z3 = z || z2;
        list.clear();
        for (ConstraintWidget constraintWidget : arrayList) {
            constraintWidget.mBelongingGroup = null;
            constraintWidget.mGroupsToSolver = false;
            constraintWidget.resetResolutionNodes();
        }
        for (ConstraintWidget constraintWidget2 : arrayList) {
            if (constraintWidget2.mBelongingGroup == null && !determineGroups(constraintWidget2, list, z3)) {
                singleGroup(constraintWidgetContainer);
                constraintWidgetContainer.mSkipSolver = false;
                return;
            }
        }
        int iMax = 0;
        int iMax2 = 0;
        for (ConstraintWidgetGroup constraintWidgetGroup : list) {
            iMax = Math.max(iMax, getMaxDimension(constraintWidgetGroup, 0));
            iMax2 = Math.max(iMax2, getMaxDimension(constraintWidgetGroup, 1));
        }
        if (z) {
            constraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidgetContainer.setWidth(iMax);
            constraintWidgetContainer.mGroupsWrapOptimized = true;
            constraintWidgetContainer.mHorizontalWrapOptimized = true;
            constraintWidgetContainer.mWrapFixedWidth = iMax;
        }
        if (z2) {
            constraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidgetContainer.setHeight(iMax2);
            constraintWidgetContainer.mGroupsWrapOptimized = true;
            constraintWidgetContainer.mVerticalWrapOptimized = true;
            constraintWidgetContainer.mWrapFixedHeight = iMax2;
        }
        setPosition(list, 0, constraintWidgetContainer.getWidth());
        setPosition(list, 1, constraintWidgetContainer.getHeight());
    }

    private static int getMaxDimension(ConstraintWidgetGroup constraintWidgetGroup, int i2) {
        int i3 = i2 * 2;
        List<ConstraintWidget> startWidgets = constraintWidgetGroup.getStartWidgets(i2);
        int size = startWidgets.size();
        int iMax = 0;
        for (int i4 = 0; i4 < size; i4++) {
            ConstraintWidget constraintWidget = startWidgets.get(i4);
            ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
            int i5 = i3 + 1;
            iMax = Math.max(iMax, getMaxDimensionTraversal(constraintWidget, i2, constraintAnchorArr[i5].mTarget == null || !(constraintAnchorArr[i3].mTarget == null || constraintAnchorArr[i5].mTarget == null), 0));
        }
        constraintWidgetGroup.mGroupDimensions[i2] = iMax;
        return iMax;
    }

    private static int getMaxDimensionTraversal(ConstraintWidget constraintWidget, int i2, boolean z, int i3) {
        int height;
        int baselineDistance;
        int i4;
        int i5;
        int i6;
        int width;
        int i7;
        int i8;
        int i9;
        int iMax = 0;
        if (!constraintWidget.mOptimizerMeasurable) {
            return 0;
        }
        boolean z2 = constraintWidget.mBaseline.mTarget != null && i2 == 1;
        if (z) {
            height = constraintWidget.getBaselineDistance();
            baselineDistance = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
            i5 = i2 * 2;
            i4 = i5 + 1;
        } else {
            height = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
            baselineDistance = constraintWidget.getBaselineDistance();
            i4 = i2 * 2;
            i5 = i4 + 1;
        }
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
        if (constraintAnchorArr[i4].mTarget == null || constraintAnchorArr[i5].mTarget != null) {
            i6 = 1;
        } else {
            i6 = -1;
            int i10 = i4;
            i4 = i5;
            i5 = i10;
        }
        int i11 = z2 ? i3 - height : i3;
        int margin = (constraintAnchorArr[i5].getMargin() * i6) + getParentBiasOffset(constraintWidget, i2);
        int i12 = i11 + margin;
        int width2 = (i2 == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i6;
        Iterator<ResolutionNode> it = constraintWidget.mListAnchors[i5].getResolutionNode().dependents.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, getMaxDimensionTraversal(((ResolutionAnchor) it.next()).myAnchor.mOwner, i2, z, i12));
        }
        int iMax2 = 0;
        for (Iterator<ResolutionNode> it2 = constraintWidget.mListAnchors[i4].getResolutionNode().dependents.iterator(); it2.hasNext(); it2 = it2) {
            iMax2 = Math.max(iMax2, getMaxDimensionTraversal(((ResolutionAnchor) it2.next()).myAnchor.mOwner, i2, z, width2 + i12));
        }
        if (z2) {
            iMax -= height;
            width = iMax2 + baselineDistance;
        } else {
            width = iMax2 + ((i2 == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i6);
        }
        int i13 = 1;
        if (i2 == 1) {
            Iterator<ResolutionNode> it3 = constraintWidget.mBaseline.getResolutionNode().dependents.iterator();
            int iMax3 = 0;
            while (it3.hasNext()) {
                Iterator<ResolutionNode> it4 = it3;
                ResolutionAnchor resolutionAnchor = (ResolutionAnchor) it3.next();
                if (i6 == i13) {
                    iMax3 = Math.max(iMax3, getMaxDimensionTraversal(resolutionAnchor.myAnchor.mOwner, i2, z, height + i12));
                    i9 = i4;
                } else {
                    i9 = i4;
                    iMax3 = Math.max(iMax3, getMaxDimensionTraversal(resolutionAnchor.myAnchor.mOwner, i2, z, (baselineDistance * i6) + i12));
                }
                it3 = it4;
                i4 = i9;
                i13 = 1;
            }
            i7 = i4;
            int i14 = iMax3;
            i8 = (constraintWidget.mBaseline.getResolutionNode().dependents.size() <= 0 || z2) ? i14 : i6 == 1 ? i14 + height : i14 - baselineDistance;
        } else {
            i7 = i4;
            i8 = 0;
        }
        int iMax4 = margin + Math.max(iMax, Math.max(width, i8));
        int i15 = width2 + i12;
        if (i6 == -1) {
            i15 = i12;
            i12 = i15;
        }
        if (z) {
            Optimizer.setOptimizedWidget(constraintWidget, i2, i12);
            constraintWidget.setFrame(i12, i15, i2);
        } else {
            constraintWidget.mBelongingGroup.addWidgetsToSet(constraintWidget, i2);
            constraintWidget.setRelativePositioning(i12, i2);
        }
        if (constraintWidget.getDimensionBehaviour(i2) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mDimensionRatio != 0.0f) {
            constraintWidget.mBelongingGroup.addWidgetsToSet(constraintWidget, i2);
        }
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget.mListAnchors;
        if (constraintAnchorArr2[i5].mTarget != null && constraintAnchorArr2[i7].mTarget != null) {
            ConstraintWidget parent = constraintWidget.getParent();
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget.mListAnchors;
            if (constraintAnchorArr3[i5].mTarget.mOwner == parent && constraintAnchorArr3[i7].mTarget.mOwner == parent) {
                constraintWidget.mBelongingGroup.addWidgetsToSet(constraintWidget, i2);
            }
        }
        return iMax4;
    }

    private static int getParentBiasOffset(ConstraintWidget constraintWidget, int i2) {
        ConstraintAnchor constraintAnchor;
        int i3 = i2 * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i3];
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i3 + 1];
        ConstraintAnchor constraintAnchor4 = constraintAnchor2.mTarget;
        if (constraintAnchor4 == null) {
            return 0;
        }
        ConstraintWidget constraintWidget2 = constraintAnchor4.mOwner;
        ConstraintWidget constraintWidget3 = constraintWidget.mParent;
        if (constraintWidget2 != constraintWidget3 || (constraintAnchor = constraintAnchor3.mTarget) == null || constraintAnchor.mOwner != constraintWidget3) {
            return 0;
        }
        return (int) ((((constraintWidget3.getLength(i2) - constraintAnchor2.getMargin()) - constraintAnchor3.getMargin()) - constraintWidget.getLength(i2)) * (i2 == 0 ? constraintWidget.mHorizontalBiasPercent : constraintWidget.mVerticalBiasPercent));
    }

    private static void invalidate(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidget constraintWidget, ConstraintWidgetGroup constraintWidgetGroup) {
        constraintWidgetGroup.mSkipSolver = false;
        constraintWidgetContainer.mSkipSolver = false;
        constraintWidget.mOptimizerMeasurable = false;
    }

    private static int resolveDimensionRatio(ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (horizontalDimensionBehaviour == dimensionBehaviour) {
            int height = (int) (constraintWidget.mDimensionRatioSide == 0 ? constraintWidget.getHeight() * constraintWidget.mDimensionRatio : constraintWidget.getHeight() / constraintWidget.mDimensionRatio);
            constraintWidget.setWidth(height);
            return height;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() != dimensionBehaviour) {
            return -1;
        }
        int width = (int) (constraintWidget.mDimensionRatioSide == 1 ? constraintWidget.getWidth() * constraintWidget.mDimensionRatio : constraintWidget.getWidth() / constraintWidget.mDimensionRatio);
        constraintWidget.setHeight(width);
        return width;
    }

    private static void setConnection(ConstraintAnchor constraintAnchor) {
        ResolutionAnchor resolutionNode = constraintAnchor.getResolutionNode();
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null || constraintAnchor2.mTarget == constraintAnchor) {
            return;
        }
        constraintAnchor2.getResolutionNode().addDependent(resolutionNode);
    }

    public static void setPosition(List<ConstraintWidgetGroup> list, int i2, int i3) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            for (ConstraintWidget constraintWidget : list.get(i4).getWidgetsToSet(i2)) {
                if (constraintWidget.mOptimizerMeasurable) {
                    updateSizeDependentWidgets(constraintWidget, i2, i3);
                }
            }
        }
    }

    private static void singleGroup(ConstraintWidgetContainer constraintWidgetContainer) {
        constraintWidgetContainer.mWidgetGroups.clear();
        constraintWidgetContainer.mWidgetGroups.add(0, new ConstraintWidgetGroup(constraintWidgetContainer.mChildren));
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean traverse(androidx.constraintlayout.solver.widgets.ConstraintWidget r8, androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r9, java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Analyzer.traverse(androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup, java.util.List, boolean):boolean");
    }

    private static void updateSizeDependentWidgets(ConstraintWidget constraintWidget, int i2, int i3) {
        int i4 = i2 * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
        ConstraintAnchor constraintAnchor = constraintAnchorArr[i4];
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i4 + 1];
        if ((constraintAnchor.mTarget == null || constraintAnchor2.mTarget == null) ? false : true) {
            Optimizer.setOptimizedWidget(constraintWidget, i2, getParentBiasOffset(constraintWidget, i2) + constraintAnchor.getMargin());
            return;
        }
        if (constraintWidget.mDimensionRatio == 0.0f || constraintWidget.getDimensionBehaviour(i2) != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int relativePositioning = i3 - constraintWidget.getRelativePositioning(i2);
            int length = relativePositioning - constraintWidget.getLength(i2);
            constraintWidget.setFrame(length, relativePositioning, i2);
            Optimizer.setOptimizedWidget(constraintWidget, i2, length);
            return;
        }
        int iResolveDimensionRatio = resolveDimensionRatio(constraintWidget);
        int i5 = (int) constraintWidget.mListAnchors[i4].getResolutionNode().resolvedOffset;
        constraintAnchor2.getResolutionNode().resolvedTarget = constraintAnchor.getResolutionNode();
        constraintAnchor2.getResolutionNode().resolvedOffset = iResolveDimensionRatio;
        constraintAnchor2.getResolutionNode().state = 1;
        constraintWidget.setFrame(i5, i5 + iResolveDimensionRatio, i2);
    }

    private static boolean determineGroups(ConstraintWidget constraintWidget, List<ConstraintWidgetGroup> list, boolean z) {
        ConstraintWidgetGroup constraintWidgetGroup = new ConstraintWidgetGroup(new ArrayList(), true);
        list.add(constraintWidgetGroup);
        return traverse(constraintWidget, constraintWidgetGroup, list, z);
    }
}
