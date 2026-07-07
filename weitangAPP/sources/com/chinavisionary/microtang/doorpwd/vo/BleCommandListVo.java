package com.chinavisionary.microtang.doorpwd.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BleCommandListVo extends BaseVo {
    public static final String FREEZE_ONLINE_PASSWORD = "freezeOnlinePassword";
    public static final String SETUP_PWD_COMMAND_TYPE = "createOnlinePassword";
    public static final String SETUP_TIME_COMMAND_TYPE = "setTime";
    public static final String UNFREEZE_ONLINE_PASSWORD = "unfreezeOnlinePassword";
    public static final String UPDATE_PWD_COMMAND_TYPE = "updateOnlinePassword";
    private List<String> ble;
    private String commandId;
    private String type;

    public List<String> getBle() {
        return this.ble;
    }

    public String getCommandId() {
        return this.commandId;
    }

    public String getType() {
        return this.type;
    }

    public void setBle(List<String> list) {
        this.ble = list;
    }

    public void setCommandId(String str) {
        this.commandId = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
