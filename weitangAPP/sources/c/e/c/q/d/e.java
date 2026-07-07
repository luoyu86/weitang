package c.e.c.q.d;

import com.chinavisionary.microtang.doorpwd.vo.BleCommandListVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e extends c.e.e.a.s.a {
    public static final String DA_GUANG_JIA = "THINMOO_ROUTE";
    public static final String GUODN_ROUTE = "GUODN_ROUTE";
    public static final String MA_TAI = "MARS_TIANYIYUN_HTTP_DOOR";
    public static final String TIANWANG_ROUTE = "TIANWANG_ROUTE";
    public static final String ZISNOO_ROUTE = "ZISNOO_ROUTE";
    private List<BleCommandListVo> bleList;
    private String devicePrimaryKey;
    private String macAddress;
    private String modelAdapter;

    public List<BleCommandListVo> getBleList() {
        return this.bleList;
    }

    public String getDevicePrimaryKey() {
        return this.devicePrimaryKey;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public String getModelAdapter() {
        return this.modelAdapter;
    }

    public void setBleList(List<BleCommandListVo> list) {
        this.bleList = list;
    }

    public void setDevicePrimaryKey(String str) {
        this.devicePrimaryKey = str;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public void setModelAdapter(String str) {
        this.modelAdapter = str;
    }
}
