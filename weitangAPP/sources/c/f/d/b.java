package c.f.d;

import android.os.Handler;
import android.os.Message;
import com.contrarywind.view.WheelView;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f2508a;

    public b(WheelView wheelView) {
        this.f2508a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1000) {
            this.f2508a.invalidate();
        } else if (i2 == 2000) {
            this.f2508a.smoothScroll(WheelView.b.FLING);
        } else {
            if (i2 != 3000) {
                return;
            }
            this.f2508a.onItemSelected();
        }
    }
}
