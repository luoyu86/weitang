package c.f.d;

import com.contrarywind.view.WheelView;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2505a = 2.1474836E9f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f2506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WheelView f2507c;

    public a(WheelView wheelView, float f2) {
        this.f2507c = wheelView;
        this.f2506b = f2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f2505a == 2.1474836E9f) {
            if (Math.abs(this.f2506b) > 2000.0f) {
                this.f2505a = this.f2506b <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f2505a = this.f2506b;
            }
        }
        if (Math.abs(this.f2505a) >= 0.0f && Math.abs(this.f2505a) <= 20.0f) {
            this.f2507c.cancelFuture();
            this.f2507c.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i2 = (int) (this.f2505a / 100.0f);
        WheelView wheelView = this.f2507c;
        float f2 = i2;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f2);
        if (!this.f2507c.isLoop()) {
            float itemHeight = this.f2507c.getItemHeight();
            float totalScrollY = (-this.f2507c.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f2507c.getItemsCount() - 1) - this.f2507c.getInitPosition()) * itemHeight;
            double d2 = ((double) itemHeight) * 0.25d;
            if (((double) this.f2507c.getTotalScrollY()) - d2 < totalScrollY) {
                totalScrollY = this.f2507c.getTotalScrollY() + f2;
            } else if (((double) this.f2507c.getTotalScrollY()) + d2 > itemsCount) {
                itemsCount = this.f2507c.getTotalScrollY() + f2;
            }
            if (this.f2507c.getTotalScrollY() <= totalScrollY) {
                this.f2505a = 40.0f;
                this.f2507c.setTotalScrollY((int) totalScrollY);
            } else if (this.f2507c.getTotalScrollY() >= itemsCount) {
                this.f2507c.setTotalScrollY((int) itemsCount);
                this.f2505a = -40.0f;
            }
        }
        float f3 = this.f2505a;
        if (f3 < 0.0f) {
            this.f2505a = f3 + 20.0f;
        } else {
            this.f2505a = f3 - 20.0f;
        }
        this.f2507c.getHandler().sendEmptyMessage(1000);
    }
}
