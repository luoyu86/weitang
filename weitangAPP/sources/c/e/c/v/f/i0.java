package c.e.c.v.f;

import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import c.e.a.a.h.c;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseActivity;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f1964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f1965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f1966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CoreRoundedImageView f1967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f1968e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CoreBaseActivity.a f1970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AppConfigExtVo.ADScreen.SplashScreenBean f1971h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1969f = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Runnable f1972i = new b();

    public class a implements c.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f1973a;

        public a(File file) {
            this.f1973a = file;
        }

        @Override // c.e.a.a.h.c.e
        public void onFailed(RequestErrDto requestErrDto) {
            try {
                this.f1973a.delete();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c.e.a.d.q.d(b0.class.getSimpleName(), "onFailed errMsg :" + requestErrDto.getErrMsg());
        }

        @Override // c.e.a.a.h.c.e
        public void onSuccess(String str) {
            c.e.a.d.q.d(b0.class.getSimpleName(), "onSuccess save path :" + str);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i0.this.f1970g.removeCallbacks(i0.this.f1972i);
            i0.d(i0.this);
            c.e.a.d.q.d(b.class.getSimpleName(), "Runnable mTimer =" + i0.this.f1969f);
            if (i0.this.f1969f <= 0) {
                i0.this.hiedSplashImg();
            } else {
                i0.this.r();
            }
        }
    }

    public i0(z zVar) {
        this.f1964a = zVar;
        FragmentActivity currentActivity = zVar.getCurrentActivity();
        this.f1965b = (TextView) currentActivity.findViewById(R.id.tv_timer);
        this.f1967d = (CoreRoundedImageView) currentActivity.findViewById(R.id.img_launcher);
        this.f1966c = currentActivity.findViewById(R.id.view_bottom_bg);
        this.f1968e = (ImageView) currentActivity.findViewById(R.id.img_bottom_launcher);
        if (currentActivity instanceof BaseActivity) {
            this.f1970g = new CoreBaseActivity.a((BaseActivity) currentActivity);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: c.e.c.v.f.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2005a.j(view);
            }
        };
        this.f1965b.setOnClickListener(onClickListener);
        this.f1967d.setOnClickListener(onClickListener);
    }

    public static /* synthetic */ int d(i0 i0Var) {
        int i2 = i0Var.f1969f;
        i0Var.f1969f = i2 - 1;
        return i2;
    }

    public static String g(String str) {
        if (!c.e.a.d.x.isNotNull(str) || str.contains("http")) {
            return str;
        }
        if (str.indexOf("/") == 0) {
            return c.e.a.d.j.getInstance().getH5BaseUrl() + str.substring(1);
        }
        return c.e.a.d.j.getInstance().getH5BaseUrl() + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(View view) {
        int id = view.getId();
        if (id == R.id.img_launcher) {
            h();
        } else {
            if (id != R.id.tv_timer) {
                return;
            }
            hiedSplashImg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(AppConfigExtVo appConfigExtVo) {
        AppConfigExtVo.ADScreen adScreenVo = appConfigExtVo.getAdScreenVo();
        if (adScreenVo != null) {
            AppConfigExtVo.ADScreen.LockScreenBean lockScreen = adScreenVo.getLockScreen();
            AppConfigExtVo.ADScreen.SplashScreenBean splashScreen = adScreenVo.getSplashScreen();
            if (splashScreen != null) {
                String resource = splashScreen.getResource();
                if (c.e.a.d.x.isNotNull(resource)) {
                    f(c.e.a.d.l.getAdSplashNamePath() + c.e.a.d.l.getFileName(resource), resource);
                }
            }
            if (lockScreen != null) {
                String resource2 = lockScreen.getResource();
                if (c.e.a.d.x.isNotNull(resource2)) {
                    f(c.e.a.d.l.getAdLockNamePath() + c.e.a.d.l.getFileName(resource2), resource2);
                }
            }
        }
    }

    public final void f(String str, String str2) {
        if (c.e.a.d.x.isNotNull(str) && c.e.a.d.x.isNotNull(str2)) {
            File file = new File(str);
            if (!file.exists()) {
                c.e.a.a.h.c.getInstance().downloadFile(str2, str, new a(file));
                return;
            }
            c.e.a.d.q.d(b0.class.getSimpleName(), "downloadFileToSave local exits path :" + str);
        }
    }

    public final void h() {
        z zVar;
        AppConfigExtVo.ADScreen.SplashScreenBean splashScreenBean = this.f1971h;
        if (splashScreenBean == null || (zVar = this.f1964a) == null) {
            return;
        }
        zVar.handleAdClickMonitor(splashScreenBean.getTitle(), this.f1971h.getBaseKey());
        if (!c.e.a.d.x.isNotNull(this.f1971h.getTargetAppid())) {
            if (c.e.a.d.x.isNotNull(this.f1971h.getHref())) {
                hiedSplashImg();
                this.f1964a.handleForward(this.f1971h.getForwardType().intValue(), g(this.f1971h.getHref()), this.f1971h.getTitle());
                return;
            }
            return;
        }
        hiedSplashImg();
        int i2 = 15;
        if (c.e.a.d.x.isNotNull(this.f1971h.getTargetMiniType()) && FundNewsVo.TYPE_ALIPAY.equals(this.f1971h.getTargetMiniType())) {
            i2 = 18;
        }
        c.e.a.d.q.d(i0.class.getSimpleName(), "handleADClick mSplashScreenBean " + JSON.toJSONString(this.f1971h));
        this.f1964a.handleForward(i2, this.f1971h.getTargetAppid(), this.f1971h.getTargetPath());
    }

    public void hiedSplashImg() {
        if (this.f1965b != null) {
            m();
            q(true);
        }
    }

    public final void m() {
        CoreBaseActivity.a aVar = this.f1970g;
        if (aVar != null) {
            aVar.removeCallbacks(this.f1972i);
            this.f1970g.removeCallbacksAndMessages(null);
        }
    }

    public void n(final AppConfigExtVo appConfigExtVo) {
        c.e.a.d.y.get().addRunnable(new Runnable() { // from class: c.e.c.v.f.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f2006a.l(appConfigExtVo);
            }
        });
    }

    public void o(AppConfigExtVo.ADScreen.SplashScreenBean splashScreenBean) {
        System.currentTimeMillis();
        hiedSplashImg();
        if (splashScreenBean != null) {
            this.f1971h = splashScreenBean;
            if (splashScreenBean.getResource() != null) {
                String resource = this.f1971h.getResource();
                long jLongValue = this.f1971h.getTimer().longValue();
                this.f1969f = ((int) jLongValue) / 1000;
                c.e.a.d.q.d(i0.class.getSimpleName(), "splashPath mTimer:" + this.f1969f + ",delayMillis=" + jLongValue);
                if (c.e.a.d.x.isNotNull(resource)) {
                    q(false);
                    p();
                    File file = new File(c.e.a.d.l.getAdSplashNamePath() + c.e.a.d.l.getFileName(resource));
                    if (file.exists()) {
                        this.f1967d.loadImageToFile(file);
                        c.e.a.d.q.d(i0.class.getSimpleName(), "splashPath exists:" + file.getPath());
                    } else {
                        this.f1967d.loadAliImageToUrl(resource);
                    }
                }
            }
        }
        c.e.a.d.q.d(i0.class.getSimpleName(), "ad end time :" + this.f1969f);
        if (this.f1969f > 0) {
            r();
        } else {
            hiedSplashImg();
        }
    }

    public final void p() {
    }

    public final void q(boolean z) {
        this.f1967d.setVisibility(z ? 8 : 0);
        this.f1966c.setVisibility(z ? 8 : 0);
        this.f1965b.setVisibility(z ? 8 : 0);
    }

    public final void r() {
        this.f1965b.setText(c.e.a.d.x.appendStringToResId(R.string.placeholder_timer_unit, String.valueOf(this.f1969f)));
        CoreBaseActivity.a aVar = this.f1970g;
        if (aVar != null) {
            aVar.postAtTime(this.f1972i, SystemClock.uptimeMillis() + 1000);
        }
    }
}
