package com.tianmu.c.n;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tianmu.TianmuSDK;
import com.tianmu.biz.utils.m0;
import com.tianmu.utils.TianmuClassUtil;
import com.tianmu.utils.TianmuLogUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static e f11839h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11841b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f11843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f11844e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f11840a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11842c = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11845f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Runnable f11846g = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a("other", true);
            e.this.a(false);
        }
    }

    private e() {
    }

    private void b() {
        List<Float> listB;
        int i2;
        c();
        if (TextUtils.isEmpty(this.f11841b) || (listB = b(this.f11841b)) == null || (i2 = this.f11842c) < 0 || i2 >= listB.size() || this.f11840a == null || this.f11846g == null) {
            return;
        }
        try {
            this.f11840a.postDelayed(this.f11846g, (long) (listB.get(this.f11842c).floatValue() * 1000.0f));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(String str) {
        this.f11845f = str;
    }

    public static e a() {
        if (f11839h == null) {
            synchronized (e.class) {
                if (f11839h == null) {
                    f11839h = new e();
                }
            }
        }
        return f11839h;
    }

    private void c() {
        Runnable runnable;
        Handler handler = this.f11840a;
        if (handler == null || (runnable = this.f11846g) == null) {
            return;
        }
        try {
            handler.removeCallbacks(runnable);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(com.tianmu.c.i.i iVar) {
        if (iVar == null || TextUtils.isEmpty(iVar.e())) {
            return;
        }
        boolean zIsImportAdmDependencies = TianmuClassUtil.isImportAdmDependencies();
        boolean zA = com.tianmu.apilib.utils.i.a().a("admobilePlatformEmpty");
        if (!zIsImportAdmDependencies || zA) {
            com.tianmu.b.a.a().a(iVar.c(), (long) iVar.a());
            f.b().a(TianmuSDK.getInstance().getContext(), iVar.e(), "tianmu.library.api.business.bean.AdmApiAdImp", true);
        }
    }

    public List<Float> b(String str) {
        Integer numValueOf;
        Integer numValueOf2;
        if (TextUtils.isEmpty(str) || !Pattern.compile(String.format("^(%s-%s)(#%s-%s){0,9}$", "([12]\\d{2}|[1-9]\\d?|300)", "([12]\\d{2}|[1-9]\\d?|300)", "([12]\\d{2}|[1-9]\\d?|300)", "([12]\\d{2}|[1-9]\\d?|300)")).matcher(str).find()) {
            return null;
        }
        String[] strArrSplit = str.split("#");
        if (strArrSplit.length == 0) {
            return null;
        }
        Random random = new Random();
        double dNextGaussian = random.nextGaussian();
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split("-");
            try {
                numValueOf = Integer.valueOf(strArrSplit2[0]);
                try {
                    numValueOf2 = Integer.valueOf(strArrSplit2[1]);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    numValueOf2 = null;
                }
            } catch (Exception e3) {
                e = e3;
                numValueOf = null;
            }
            if (numValueOf != null && numValueOf2 != null) {
                if (numValueOf.intValue() > numValueOf2.intValue()) {
                    Integer num = numValueOf;
                    numValueOf = numValueOf2;
                    numValueOf2 = num;
                }
                double dNextInt = ((double) ((random.nextInt(numValueOf2.intValue()) % ((numValueOf2.intValue() - numValueOf.intValue()) + 1)) + numValueOf.intValue())) + dNextGaussian;
                if (dNextInt < numValueOf.intValue()) {
                    dNextInt = numValueOf.intValue();
                }
                if (dNextInt > numValueOf2.intValue()) {
                    dNextInt = numValueOf2.intValue();
                }
                arrayList.add(Float.valueOf(dNextInt + ""));
            }
        }
        return arrayList;
    }

    public void a(String str, double d2) {
        boolean zIsImportAdmDependencies = TianmuClassUtil.isImportAdmDependencies();
        boolean zA = com.tianmu.apilib.utils.i.a().a("admobilePlatformEmpty");
        if (!zIsImportAdmDependencies || zA) {
            this.f11841b = str;
            this.f11844e = (long) (d2 * 1000.0d);
            a(false);
        }
    }

    public void a(boolean z) {
        if (z) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f11843d > this.f11844e) {
                this.f11843d = jCurrentTimeMillis;
                this.f11842c++;
                b();
                return;
            }
            return;
        }
        this.f11842c++;
        b();
    }

    public boolean a(String str) {
        return a(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, boolean z) {
        boolean zIsImportAdmDependencies = TianmuClassUtil.isImportAdmDependencies();
        boolean zA = com.tianmu.apilib.utils.i.a().a("admobilePlatformEmpty");
        if ((zIsImportAdmDependencies && !zA) || !m0.a(this.f11845f)) {
            return false;
        }
        String str2 = "other";
        if ("splash".equals(str)) {
            str2 = "startup";
        } else if ("banner".equals(str)) {
            str2 = "banner";
        } else if (!"other".equals(str)) {
            str2 = "flow";
        }
        if (z) {
            TianmuLogUtil.ti("res_nsend", "proc 0x00020");
        } else {
            TianmuLogUtil.ti("res_nsend", "proc 0x00030");
        }
        boolean zA2 = a(TianmuSDK.getInstance().getContext(), str2);
        if (!z && zA2) {
            a(true);
        }
        return zA2;
    }

    public boolean a(Context context, String str) {
        com.tianmu.c.i.i iVarD = n.D().d();
        if (iVarD == null) {
            return false;
        }
        String strC = iVarD.c();
        if (context == null || TextUtils.isEmpty(strC)) {
            return false;
        }
        return com.tianmu.b.a.a().a(context, str, strC);
    }
}
