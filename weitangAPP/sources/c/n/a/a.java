package c.n.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<InterfaceC0045a> f2872a = null;

    /* JADX INFO: renamed from: c.n.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0045a {
        void onAnimationCancel(a aVar);

        void onAnimationEnd(a aVar);

        void onAnimationRepeat(a aVar);

        void onAnimationStart(a aVar);
    }

    public void addListener(InterfaceC0045a interfaceC0045a) {
        if (this.f2872a == null) {
            this.f2872a = new ArrayList<>();
        }
        this.f2872a.add(interfaceC0045a);
    }

    public void cancel() {
    }

    public void end() {
    }

    public abstract long getDuration();

    public ArrayList<InterfaceC0045a> getListeners() {
        return this.f2872a;
    }

    public abstract long getStartDelay();

    public abstract boolean isRunning();

    public boolean isStarted() {
        return isRunning();
    }

    public void removeAllListeners() {
        ArrayList<InterfaceC0045a> arrayList = this.f2872a;
        if (arrayList != null) {
            arrayList.clear();
            this.f2872a = null;
        }
    }

    public void removeListener(InterfaceC0045a interfaceC0045a) {
        ArrayList<InterfaceC0045a> arrayList = this.f2872a;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(interfaceC0045a);
        if (this.f2872a.size() == 0) {
            this.f2872a = null;
        }
    }

    public abstract a setDuration(long j);

    public abstract void setInterpolator(Interpolator interpolator);

    public abstract void setStartDelay(long j);

    public void setTarget(Object obj) {
    }

    public void setupEndValues() {
    }

    public void setupStartValues() {
    }

    public void start() {
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public a mo7clone() {
        try {
            a aVar = (a) super.clone();
            ArrayList<InterfaceC0045a> arrayList = this.f2872a;
            if (arrayList != null) {
                aVar.f2872a = new ArrayList<>();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    aVar.f2872a.add(arrayList.get(i2));
                }
            }
            return aVar;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }
}
