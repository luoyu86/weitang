package c.e.e.a.s;

/* JADX INFO: loaded from: classes2.dex */
public class d extends a {
    public static final int PUBLIC_ARCE_LOCK = 1;
    public static final int ROOM_LOCK = 0;
    private String address;
    private String assetKey;
    private String contractCode;
    private String contractKey;
    private boolean isDefault;
    private boolean isSupportNumberPassword;
    private Integer isSupportedOpening = 0;

    public String getAddress() {
        return this.address;
    }

    public String getAssetKey() {
        return this.assetKey;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractKey() {
        return this.contractKey;
    }

    public Integer getIsSupportedOpening() {
        return this.isSupportedOpening;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public boolean isSupportNumberPassword() {
        return this.isSupportNumberPassword;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAssetKey(String str) {
        this.assetKey = str;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }

    public void setDefault(boolean z) {
        this.isDefault = z;
    }

    public void setIsSupportedOpening(Integer num) {
        this.isSupportedOpening = num;
    }

    public void setSupportNumberPassword(boolean z) {
        this.isSupportNumberPassword = z;
    }
}
