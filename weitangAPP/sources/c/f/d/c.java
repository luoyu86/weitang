package c.f.d;

import androidx.appcompat.widget.ActivityChooserView;
import com.contrarywind.view.WheelView;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2509a = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2510b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WheelView f2512d;

    public c(WheelView wheelView, int i2) {
        this.f2512d = wheelView;
        this.f2511c = i2;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f2509a == Integer.MAX_VALUE) {
            this.f2509a = this.f2511c;
        }
        int i2 = this.f2509a;
        int i3 = (int) (i2 * 0.1f);
        this.f2510b = i3;
        if (i3 == 0) {
            if (i2 < 0) {
                this.f2510b = -1;
            } else {
                this.f2510b = 1;
            }
        }
        if (Math.abs(i2) <= 1) {
            this.f2512d.cancelFuture();
            this.f2512d.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f2512d;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.f2510b);
        if (!this.f2512d.isLoop()) {
            float itemHeight = this.f2512d.getItemHeight();
            float itemsCount = ((this.f2512d.getItemsCount() - 1) - this.f2512d.getInitPosition()) * itemHeight;
            if (this.f2512d.getTotalScrollY() <= (-this.f2512d.getInitPosition()) * itemHeight || this.f2512d.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f2512d;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.f2510b);
                this.f2512d.cancelFuture();
                this.f2512d.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f2512d.getHandler().sendEmptyMessage(1000);
        this.f2509a -= this.f2510b;
    }
}
