package c.e.e.a.x;

import c.e.a.d.w;
import c.e.a.d.y;
import com.chinavisionary.twlib.R;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import com.taobao.accs.utl.BaseMonitor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f2495a = new l();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<AlertMessageVo> f2501g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2496b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f2497c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f2498d = 900000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f2499e = k.getString(R.string.tw_lib_app_name);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2500f = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArrayList<String> f2502h = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashMap<String, String> f2503i = new LinkedHashMap<>();

    public l() {
        a();
    }

    public static l getInstance() {
        return f2495a;
    }

    public final void a() {
        this.f2503i.put("ssl", "网络异常");
        this.f2503i.put("reset", "网络异常");
        this.f2503i.put(com.alipay.sdk.m.m.a.h0, "网络异常");
        this.f2503i.put("timed", "网络异常");
        this.f2503i.put(BaseMonitor.ALARM_POINT_CONNECT, "网络异常");
        this.f2503i.put("connection", "网络异常");
        this.f2503i.put("http", "网络异常");
        this.f2503i.put(AgooConstants.OPEN_URL, "网络异常");
        this.f2503i.put("漫游", "网络异常");
        this.f2503i.put("请求超时", "网络异常");
        this.f2503i.put("服务器", "网络异常");
        this.f2503i.put("连接中", "蓝牙连接中，用户退出。");
        this.f2503i.put("连接超时", "蓝牙连接失败");
        this.f2503i.put("连接失败", "蓝牙连接失败");
        this.f2503i.put("请关闭蓝牙重试", "蓝牙连接失败");
        this.f2503i.put("扫描失败", "蓝牙扫描失败");
        this.f2503i.put("扫描中", "蓝牙扫描中，用户退出。");
        this.f2503i.put("错误码", "手机端主动断开蓝牙连接");
        this.f2503i.put("为空", "手机端主动断开蓝牙连接");
        this.f2503i.put("status=", "手机端主动断开蓝牙连接");
        this.f2503i.put("連接", "网络异常");
        this.f2503i.put("连接", "网络异常");
        this.f2503i.put("服务器异常", "网络异常");
        this.f2503i.put("网络", "网络异常");
        this.f2503i.put("要求逾時", "网络异常");
        this.f2503i.put("访问过多", "网络异常");
        this.f2503i.put("密码错误", "密码错误");
        this.f2503i.put("开锁超时", "开锁超时");
        this.f2503i.put("开锁中", "开锁过程中，用户退出。");
        this.f2503i.put("开门中", "开锁过程中，用户退出。");
        this.f2503i.put("指令鉴权错误", "指令鉴权错误");
        this.f2503i.put("凭证不存在", "凭证不存在");
        this.f2503i.put("code=", "未分类错误");
        this.f2503i.put("开锁失败", "未分类错误");
        this.f2503i.put("参数错误", "未分类错误");
        this.f2503i.put("未扫描到", "未扫描到门禁");
        this.f2503i.put("门禁未响应", "未扫描到门禁");
        this.f2503i.put("无权开启此门", "未授权开门");
        this.f2503i.put("您未授权开启此门", "未授权开门");
        this.f2503i.put("写入数据错误", "写入数据错误");
        this.f2503i.put("不能开门", "房间被签约或预定，不能开门。");
        Iterator<Map.Entry<String, String>> it = this.f2503i.entrySet().iterator();
        while (it.hasNext()) {
            this.f2502h.add(it.next().getValue());
        }
    }

    public void addFailed() {
        int i2 = this.f2500f + 1;
        this.f2500f = i2;
        if (i2 >= 3) {
            try {
                if (f.isScan()) {
                    return;
                }
                f.setScan(true);
                y.get().addRunnable(new Runnable() { // from class: c.e.e.a.x.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.getInstance().putBoolean("ble_scan", true);
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public String getAppName() {
        return this.f2499e;
    }

    public List<AlertMessageVo> getBillAlertMessageVo() {
        return this.f2501g;
    }

    public String getFailedMessage(String str) {
        if (str != null) {
            try {
                String lowerCase = str.toLowerCase(Locale.ROOT);
                if (!this.f2502h.contains(lowerCase)) {
                    for (Map.Entry<String, String> entry : this.f2503i.entrySet()) {
                        if (lowerCase.contains(entry.getKey())) {
                            return entry.getValue();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return str;
    }

    public long getMaxIntervalTime() {
        return this.f2498d;
    }

    public synchronized boolean isEnableCache() {
        return this.f2496b;
    }

    public boolean isEnableNetworkCache() {
        return this.f2497c;
    }

    public boolean isLinkConnect() {
        return true;
    }

    public boolean isUseCache(String str) {
        return this.f2497c && pwdIsValidTime(str);
    }

    public boolean pwdIsValidTime(String str) {
        if (!k.isNotNull(str)) {
            return false;
        }
        String cacheTimeToAssetKey = c.e.e.a.t.b.getInstance().getCacheTimeToAssetKey(str);
        i.d("OpenDoorActivity", "pwdIsValidTime createTime = " + cacheTimeToAssetKey);
        if (cacheTimeToAssetKey == null) {
            return false;
        }
        try {
            return Long.valueOf(System.currentTimeMillis()).longValue() - Long.valueOf(Long.parseLong(cacheTimeToAssetKey)).longValue() <= getMaxIntervalTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void setAppName(String str) {
        this.f2499e = str;
    }

    public void setBillAlertMessageVo(List<AlertMessageVo> list) {
        this.f2501g = list;
    }

    public synchronized void setEnableCache(boolean z) {
        this.f2496b = z;
    }

    public void setEnableNetworkCache(boolean z) {
        this.f2497c = z;
    }

    public void setMaxIntervalTime(long j) {
        this.f2498d = j;
    }
}
