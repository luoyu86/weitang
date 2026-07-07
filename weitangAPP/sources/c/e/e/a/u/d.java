package c.e.e.a.u;

import android.util.Base64;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.a.d.y;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.twlib.open.bo.ResponseOpenDoorVo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f2475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<c.e.e.a.s.e> f2476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ResponseOpenDoorVo> f2477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ResponseOpenDoorVo f2478d;

    public d() {
        this.f2477c = new HashMap();
        this.f2477c = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(ResponseOpenDoorVo responseOpenDoorVo, String str) {
        try {
            String jSONString = JSON.toJSONString(responseOpenDoorVo);
            String strEncodeToString = Base64.encodeToString(jSONString.getBytes(), 0);
            q.d(getClass().getSimpleName(), "cachePublicRoomPwd pwdJson:" + jSONString + ", encodeJson = " + strEncodeToString);
            c.e.e.a.t.b.getInstance().insertPwd(str, strEncodeToString);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static d getInstance() {
        if (f2475a == null) {
            synchronized (d.class) {
                if (f2475a == null) {
                    f2475a = new d();
                }
            }
        }
        return f2475a;
    }

    public Map<String, ResponseOpenDoorVo> getAssetKeyPwsMap() {
        return this.f2477c;
    }

    public ResponseOpenDoorVo getLockPwdToAssetKey(String str) {
        Map<String, ResponseOpenDoorVo> map;
        if (x.isNotNull(str) && (map = this.f2477c) != null && map.containsKey(str)) {
            return this.f2477c.get(str);
        }
        return null;
    }

    public List<c.e.e.a.s.e> getLockResponseVoList() {
        List<c.e.e.a.s.e> list = this.f2476b;
        if (list == null) {
            return null;
        }
        try {
            return JSON.parseArray(JSON.toJSONString(list), c.e.e.a.s.e.class);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public ResponseOpenDoorVo getRoomResponseOpenDoorVo() {
        return this.f2478d;
    }

    public void putPwdToMap(final ResponseOpenDoorVo responseOpenDoorVo) {
        if (responseOpenDoorVo != null) {
            final String requestParamBaseKey = responseOpenDoorVo.getRequestParamBaseKey();
            if (x.isNotNull(requestParamBaseKey)) {
                if (responseOpenDoorVo.getAdapterModel() != null) {
                    Integer doorType = c.getDoorType(responseOpenDoorVo.getAdapterModel());
                    if (doorType == null) {
                        return;
                    }
                    if (doorType.intValue() == 15 || doorType.intValue() == 16) {
                        responseOpenDoorVo.setBluetoothPassword(responseOpenDoorVo.getResultData());
                    }
                    responseOpenDoorVo.setSupplierType(doorType.intValue());
                }
                y.get().addRunnable(new Runnable() { // from class: c.e.e.a.u.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2472a.b(responseOpenDoorVo, requestParamBaseKey);
                    }
                });
            }
        }
    }

    public void recycler() {
        List<c.e.e.a.s.e> list = this.f2476b;
        if (list != null) {
            list.clear();
            this.f2476b = null;
        }
        Map<String, ResponseOpenDoorVo> map = this.f2477c;
        if (map != null) {
            map.clear();
        }
    }

    public void setAssetKeyPwsMap(Map<String, ResponseOpenDoorVo> map) {
        this.f2477c = map;
    }

    public void setLockResponseVoList(List<c.e.e.a.s.e> list) {
        this.f2476b = list;
    }

    public void setRoomResponseOpenDoorVo(ResponseOpenDoorVo responseOpenDoorVo) {
        this.f2478d = responseOpenDoorVo;
    }
}
