package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.util.LogWriter;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerImpl;
import com.alipay.sdk.m.u.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManagerImpl.OpGenerator {
    public static final int OP_ADD = 1;
    public static final int OP_ATTACH = 7;
    public static final int OP_DETACH = 6;
    public static final int OP_HIDE = 4;
    public static final int OP_NULL = 0;
    public static final int OP_REMOVE = 3;
    public static final int OP_REPLACE = 2;
    public static final int OP_SET_PRIMARY_NAV = 8;
    public static final int OP_SHOW = 5;
    public static final int OP_UNSET_PRIMARY_NAV = 9;
    public static final String TAG = "FragmentManager";
    public boolean mAddToBackStack;
    public int mBreadCrumbShortTitleRes;
    public CharSequence mBreadCrumbShortTitleText;
    public int mBreadCrumbTitleRes;
    public CharSequence mBreadCrumbTitleText;
    public ArrayList<Runnable> mCommitRunnables;
    public boolean mCommitted;
    public int mEnterAnim;
    public int mExitAnim;
    public final FragmentManagerImpl mManager;

    @Nullable
    public String mName;
    public int mPopEnterAnim;
    public int mPopExitAnim;
    public ArrayList<String> mSharedElementSourceNames;
    public ArrayList<String> mSharedElementTargetNames;
    public int mTransition;
    public int mTransitionStyle;
    public ArrayList<Op> mOps = new ArrayList<>();
    public boolean mAllowAddToBackStack = true;
    public int mIndex = -1;
    public boolean mReorderingAllowed = false;

    public static final class Op {
        public int cmd;
        public int enterAnim;
        public int exitAnim;
        public Fragment fragment;
        public int popEnterAnim;
        public int popExitAnim;

        public Op() {
        }

        public Op(int i2, Fragment fragment) {
            this.cmd = i2;
            this.fragment = fragment;
        }
    }

    public BackStackRecord(FragmentManagerImpl fragmentManagerImpl) {
        this.mManager = fragmentManagerImpl;
    }

    private void doAddOp(int i2, Fragment fragment, @Nullable String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        fragment.mFragmentManager = this.mManager;
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i2 != 0) {
            if (i2 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i4 = fragment.mFragmentId;
            if (i4 != 0 && i4 != i2) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
            }
            fragment.mFragmentId = i2;
            fragment.mContainerId = i2;
        }
        addOp(new Op(i3, fragment));
    }

    private static boolean isFragmentPostponed(Op op) {
        Fragment fragment = op.fragment;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction add(Fragment fragment, @Nullable String str) {
        doAddOp(0, fragment, str, 1);
        return this;
    }

    public void addOp(Op op) {
        this.mOps.add(op);
        op.enterAnim = this.mEnterAnim;
        op.exitAnim = this.mExitAnim;
        op.popEnterAnim = this.mPopEnterAnim;
        op.popExitAnim = this.mPopExitAnim;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction addSharedElement(View view, String str) {
        if (FragmentTransition.supportsTransition()) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.mSharedElementSourceNames == null) {
                this.mSharedElementSourceNames = new ArrayList<>();
                this.mSharedElementTargetNames = new ArrayList<>();
            } else {
                if (this.mSharedElementTargetNames.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                }
                if (this.mSharedElementSourceNames.contains(transitionName)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + transitionName + " has already been added to the transaction.");
                }
            }
            this.mSharedElementSourceNames.add(transitionName);
            this.mSharedElementTargetNames.add(str);
        }
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction addToBackStack(@Nullable String str) {
        if (!this.mAllowAddToBackStack) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.mAddToBackStack = true;
        this.mName = str;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction attach(Fragment fragment) {
        addOp(new Op(7, fragment));
        return this;
    }

    public void bumpBackStackNesting(int i2) {
        if (this.mAddToBackStack) {
            if (FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.mOps.size();
            for (int i3 = 0; i3 < size; i3++) {
                Op op = this.mOps.get(i3);
                Fragment fragment = op.fragment;
                if (fragment != null) {
                    fragment.mBackStackNesting += i2;
                    if (FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "Bump nesting of " + op.fragment + " to " + op.fragment.mBackStackNesting);
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commit() {
        return commitInternal(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    public int commitInternal(boolean z) {
        if (this.mCommitted) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
            dump("  ", null, printWriter, null);
            printWriter.close();
        }
        this.mCommitted = true;
        if (this.mAddToBackStack) {
            this.mIndex = this.mManager.allocBackStackIndex(this);
        } else {
            this.mIndex = -1;
        }
        this.mManager.enqueueAction(this, z);
        return this.mIndex;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNow() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction detach(Fragment fragment) {
        addOp(new Op(6, fragment));
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction disallowAddToBackStack() {
        if (this.mAddToBackStack) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.mAllowAddToBackStack = false;
        return this;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        dump(str, printWriter, true);
    }

    public void executeOps() {
        int size = this.mOps.size();
        for (int i2 = 0; i2 < size; i2++) {
            Op op = this.mOps.get(i2);
            Fragment fragment = op.fragment;
            if (fragment != null) {
                fragment.setNextTransition(this.mTransition, this.mTransitionStyle);
            }
            switch (op.cmd) {
                case 1:
                    fragment.setNextAnim(op.enterAnim);
                    this.mManager.addFragment(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
                case 3:
                    fragment.setNextAnim(op.exitAnim);
                    this.mManager.removeFragment(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(op.exitAnim);
                    this.mManager.hideFragment(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(op.enterAnim);
                    this.mManager.showFragment(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(op.exitAnim);
                    this.mManager.detachFragment(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(op.enterAnim);
                    this.mManager.attachFragment(fragment);
                    break;
                case 8:
                    this.mManager.setPrimaryNavigationFragment(fragment);
                    break;
                case 9:
                    this.mManager.setPrimaryNavigationFragment(null);
                    break;
            }
            if (!this.mReorderingAllowed && op.cmd != 1 && fragment != null) {
                this.mManager.moveFragmentToExpectedState(fragment);
            }
        }
        if (this.mReorderingAllowed) {
            return;
        }
        FragmentManagerImpl fragmentManagerImpl = this.mManager;
        fragmentManagerImpl.moveToState(fragmentManagerImpl.mCurState, true);
    }

    public void executePopOps(boolean z) {
        for (int size = this.mOps.size() - 1; size >= 0; size--) {
            Op op = this.mOps.get(size);
            Fragment fragment = op.fragment;
            if (fragment != null) {
                fragment.setNextTransition(FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
            }
            switch (op.cmd) {
                case 1:
                    fragment.setNextAnim(op.popExitAnim);
                    this.mManager.removeFragment(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
                case 3:
                    fragment.setNextAnim(op.popEnterAnim);
                    this.mManager.addFragment(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(op.popEnterAnim);
                    this.mManager.showFragment(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(op.popExitAnim);
                    this.mManager.hideFragment(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(op.popEnterAnim);
                    this.mManager.attachFragment(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(op.popExitAnim);
                    this.mManager.detachFragment(fragment);
                    break;
                case 8:
                    this.mManager.setPrimaryNavigationFragment(null);
                    break;
                case 9:
                    this.mManager.setPrimaryNavigationFragment(fragment);
                    break;
            }
            if (!this.mReorderingAllowed && op.cmd != 3 && fragment != null) {
                this.mManager.moveFragmentToExpectedState(fragment);
            }
        }
        if (this.mReorderingAllowed || !z) {
            return;
        }
        FragmentManagerImpl fragmentManagerImpl = this.mManager;
        fragmentManagerImpl.moveToState(fragmentManagerImpl.mCurState, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.fragment.app.Fragment expandOps(java.util.ArrayList<androidx.fragment.app.Fragment> r17, androidx.fragment.app.Fragment r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = 0
        L7:
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r5 = r0.mOps
            int r5 = r5.size()
            if (r4 >= r5) goto Lba
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r5 = r0.mOps
            java.lang.Object r5 = r5.get(r4)
            androidx.fragment.app.BackStackRecord$Op r5 = (androidx.fragment.app.BackStackRecord.Op) r5
            int r6 = r5.cmd
            r7 = 0
            r8 = 1
            if (r6 == r8) goto Lb2
            r9 = 2
            r10 = 3
            r11 = 9
            if (r6 == r9) goto L58
            if (r6 == r10) goto L41
            r9 = 6
            if (r6 == r9) goto L41
            r7 = 7
            if (r6 == r7) goto Lb2
            r7 = 8
            if (r6 == r7) goto L31
            goto Lb7
        L31:
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r6 = r0.mOps
            androidx.fragment.app.BackStackRecord$Op r7 = new androidx.fragment.app.BackStackRecord$Op
            r7.<init>(r11, r3)
            r6.add(r4, r7)
            int r4 = r4 + 1
            androidx.fragment.app.Fragment r3 = r5.fragment
            goto Lb7
        L41:
            androidx.fragment.app.Fragment r6 = r5.fragment
            r1.remove(r6)
            androidx.fragment.app.Fragment r5 = r5.fragment
            if (r5 != r3) goto Lb7
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r3 = r0.mOps
            androidx.fragment.app.BackStackRecord$Op r6 = new androidx.fragment.app.BackStackRecord$Op
            r6.<init>(r11, r5)
            r3.add(r4, r6)
            int r4 = r4 + 1
            r3 = r7
            goto Lb7
        L58:
            androidx.fragment.app.Fragment r6 = r5.fragment
            int r9 = r6.mContainerId
            int r12 = r17.size()
            int r12 = r12 - r8
            r13 = 0
        L62:
            if (r12 < 0) goto La2
            java.lang.Object r14 = r1.get(r12)
            androidx.fragment.app.Fragment r14 = (androidx.fragment.app.Fragment) r14
            int r15 = r14.mContainerId
            if (r15 != r9) goto L9f
            if (r14 != r6) goto L72
            r13 = 1
            goto L9f
        L72:
            if (r14 != r3) goto L81
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r3 = r0.mOps
            androidx.fragment.app.BackStackRecord$Op r15 = new androidx.fragment.app.BackStackRecord$Op
            r15.<init>(r11, r14)
            r3.add(r4, r15)
            int r4 = r4 + 1
            r3 = r7
        L81:
            androidx.fragment.app.BackStackRecord$Op r15 = new androidx.fragment.app.BackStackRecord$Op
            r15.<init>(r10, r14)
            int r2 = r5.enterAnim
            r15.enterAnim = r2
            int r2 = r5.popEnterAnim
            r15.popEnterAnim = r2
            int r2 = r5.exitAnim
            r15.exitAnim = r2
            int r2 = r5.popExitAnim
            r15.popExitAnim = r2
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r2 = r0.mOps
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r8
        L9f:
            int r12 = r12 + (-1)
            goto L62
        La2:
            if (r13 == 0) goto Lac
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r2 = r0.mOps
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lb7
        Lac:
            r5.cmd = r8
            r1.add(r6)
            goto Lb7
        Lb2:
            androidx.fragment.app.Fragment r2 = r5.fragment
            r1.add(r2)
        Lb7:
            int r4 = r4 + r8
            goto L7
        Lba:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.BackStackRecord.expandOps(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    @Override // androidx.fragment.app.FragmentManagerImpl.OpGenerator
    public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.mAddToBackStack) {
            return true;
        }
        this.mManager.addBackStackState(this);
        return true;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbShortTitle() {
        return this.mBreadCrumbShortTitleRes != 0 ? this.mManager.mHost.getContext().getText(this.mBreadCrumbShortTitleRes) : this.mBreadCrumbShortTitleText;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public CharSequence getBreadCrumbTitle() {
        return this.mBreadCrumbTitleRes != 0 ? this.mManager.mHost.getContext().getText(this.mBreadCrumbTitleRes) : this.mBreadCrumbTitleText;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getId() {
        return this.mIndex;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    @Nullable
    public String getName() {
        return this.mName;
    }

    public int getTransition() {
        return this.mTransition;
    }

    public int getTransitionStyle() {
        return this.mTransitionStyle;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction hide(Fragment fragment) {
        addOp(new Op(4, fragment));
        return this;
    }

    public boolean interactsWith(int i2) {
        int size = this.mOps.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = this.mOps.get(i3).fragment;
            int i4 = fragment != null ? fragment.mContainerId : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    public boolean isPostponed() {
        for (int i2 = 0; i2 < this.mOps.size(); i2++) {
            if (isFragmentPostponed(this.mOps.get(i2))) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction remove(Fragment fragment) {
        addOp(new Op(3, fragment));
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction replace(int i2, Fragment fragment) {
        return replace(i2, fragment, null);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction runOnCommit(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("runnable cannot be null");
        }
        disallowAddToBackStack();
        if (this.mCommitRunnables == null) {
            this.mCommitRunnables = new ArrayList<>();
        }
        this.mCommitRunnables.add(runnable);
        return this;
    }

    public void runOnCommitRunnables() {
        ArrayList<Runnable> arrayList = this.mCommitRunnables;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mCommitRunnables.get(i2).run();
            }
            this.mCommitRunnables = null;
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setAllowOptimization(boolean z) {
        return setReorderingAllowed(z);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbShortTitle(int i2) {
        this.mBreadCrumbShortTitleRes = i2;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbTitle(int i2) {
        this.mBreadCrumbTitleRes = i2;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setCustomAnimations(int i2, int i3) {
        return setCustomAnimations(i2, i3, 0, 0);
    }

    public void setOnStartPostponedListener(Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener) {
        for (int i2 = 0; i2 < this.mOps.size(); i2++) {
            Op op = this.mOps.get(i2);
            if (isFragmentPostponed(op)) {
                op.fragment.setOnStartEnterTransitionListener(onStartEnterTransitionListener);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        addOp(new Op(8, fragment));
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setReorderingAllowed(boolean z) {
        this.mReorderingAllowed = z;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setTransition(int i2) {
        this.mTransition = i2;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setTransitionStyle(int i2) {
        this.mTransitionStyle = i2;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction show(Fragment fragment) {
        addOp(new Op(5, fragment));
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mName != null) {
            sb.append(" ");
            sb.append(this.mName);
        }
        sb.append(i.f5699d);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.fragment.app.Fragment trackAddedFragmentsInPop(java.util.ArrayList<androidx.fragment.app.Fragment> r5, androidx.fragment.app.Fragment r6) {
        /*
            r4 = this;
            r0 = 0
        L1:
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r1 = r4.mOps
            int r1 = r1.size()
            if (r0 >= r1) goto L30
            java.util.ArrayList<androidx.fragment.app.BackStackRecord$Op> r1 = r4.mOps
            java.lang.Object r1 = r1.get(r0)
            androidx.fragment.app.BackStackRecord$Op r1 = (androidx.fragment.app.BackStackRecord.Op) r1
            int r2 = r1.cmd
            r3 = 1
            if (r2 == r3) goto L28
            r3 = 3
            if (r2 == r3) goto L22
            switch(r2) {
                case 6: goto L22;
                case 7: goto L28;
                case 8: goto L20;
                case 9: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L2d
        L1d:
            androidx.fragment.app.Fragment r6 = r1.fragment
            goto L2d
        L20:
            r6 = 0
            goto L2d
        L22:
            androidx.fragment.app.Fragment r1 = r1.fragment
            r5.add(r1)
            goto L2d
        L28:
            androidx.fragment.app.Fragment r1 = r1.fragment
            r5.remove(r1)
        L2d:
            int r0 = r0 + 1
            goto L1
        L30:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.BackStackRecord.trackAddedFragmentsInPop(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction add(int i2, Fragment fragment) {
        doAddOp(i2, fragment, null, 1);
        return this;
    }

    public void dump(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.mTransitionStyle));
            }
            if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (this.mOps.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        String str3 = str + "    ";
        int size = this.mOps.size();
        for (int i2 = 0; i2 < size; i2++) {
            Op op = this.mOps.get(i2);
            switch (op.cmd) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                default:
                    str2 = "cmd=" + op.cmd;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(op.fragment);
            if (z) {
                if (op.enterAnim != 0 || op.exitAnim != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(op.enterAnim));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(op.exitAnim));
                }
                if (op.popEnterAnim != 0 || op.popExitAnim != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(op.popEnterAnim));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(op.popExitAnim));
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction replace(int i2, Fragment fragment, @Nullable String str) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        doAddOp(i2, fragment, str, 2);
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setCustomAnimations(int i2, int i3, int i4, int i5) {
        this.mEnterAnim = i2;
        this.mExitAnim = i3;
        this.mPopEnterAnim = i4;
        this.mPopExitAnim = i5;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction add(int i2, Fragment fragment, @Nullable String str) {
        doAddOp(i2, fragment, str, 1);
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbShortTitle(@Nullable CharSequence charSequence) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = charSequence;
        return this;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbTitle(@Nullable CharSequence charSequence) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = charSequence;
        return this;
    }

    public boolean interactsWith(ArrayList<BackStackRecord> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.mOps.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            Fragment fragment = this.mOps.get(i5).fragment;
            int i6 = fragment != null ? fragment.mContainerId : 0;
            if (i6 != 0 && i6 != i4) {
                for (int i7 = i2; i7 < i3; i7++) {
                    BackStackRecord backStackRecord = arrayList.get(i7);
                    int size2 = backStackRecord.mOps.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        Fragment fragment2 = backStackRecord.mOps.get(i8).fragment;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }
}
