package c.e.e.a.s;

/* JADX INFO: loaded from: classes2.dex */
public class e extends a {
    public static final int HAX_ROOM_TYPE = 2;
    public static final int HIGH_BETTY_LEVEL = 3;
    public static final int LOW_BETTY_LEVEL = 1;
    public static final int MEDIUM_BETTY_LEVEL = 2;
    public static final int MT_ROOM_TYPE = 15;
    public static final int NO_SHOW_BETTY_LEVEL = 0;
    public static final int OPEN_DOOR_MODEL_BLE = 0;
    public static final int OPEN_DOOR_MODEL_NETWORK = 1;
    public static final int PUBLIC_ROOM_TYPE = 1;
    public static final int ROOM_TYPE = 0;
    public static final int ZIXIN_ROOM_TYPE = 16;
    private String assetConfirmDeadline;
    private boolean assetConfirmStatus;
    private String assetInstanceKey;
    private String assetInstanceName;
    private String contractKey;
    private boolean isDefault;
    private boolean isSelect;
    private boolean isSupportNumberPassword;
    private int itemType;
    private int openDoorModel;
    private Integer soc;
    private Integer socLevel;
    private String socLevelName;
    private Integer isSupportedOpening = 0;
    private Integer lockType = 0;

    public String getAssetConfirmDeadline() {
        return this.assetConfirmDeadline;
    }

    public String getAssetInstanceKey() {
        return this.assetInstanceKey;
    }

    public String getAssetInstanceName() {
        return this.assetInstanceName;
    }

    public String getContractKey() {
        return this.contractKey;
    }

    public Integer getIsSupportedOpening() {
        return this.isSupportedOpening;
    }

    public int getItemType() {
        return this.itemType;
    }

    public Integer getLockType() {
        return this.lockType;
    }

    public int getOpenDoorModel() {
        return this.openDoorModel;
    }

    public Integer getSoc() {
        return this.soc;
    }

    public Integer getSocLevel() {
        return this.socLevel;
    }

    public String getSocLevelName() {
        return this.socLevelName;
    }

    public boolean hasSupportedOpening() {
        return getIsSupportedOpening().intValue() == 1;
    }

    public boolean isAssetConfirmStatus() {
        return this.assetConfirmStatus;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public boolean isSupportNumberPassword() {
        return this.isSupportNumberPassword;
    }

    public void setAssetConfirmDeadline(String str) {
        this.assetConfirmDeadline = str;
    }

    public void setAssetConfirmStatus(boolean z) {
        this.assetConfirmStatus = z;
    }

    public void setAssetInstanceKey(String str) {
        this.assetInstanceKey = str;
    }

    public void setAssetInstanceName(String str) {
        this.assetInstanceName = str;
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

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setLockType(Integer num) {
        this.lockType = num;
    }

    public void setOpenDoorModel(int i2) {
        this.openDoorModel = i2;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public void setSoc(Integer num) {
        this.soc = num;
    }

    public void setSocLevel(Integer num) {
        this.socLevel = num;
    }

    public void setSocLevelName(String str) {
        this.socLevelName = str;
    }

    public void setSupportNumberPassword(boolean z) {
        this.isSupportNumberPassword = z;
    }
}
