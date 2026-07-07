package com.chinavisionary.microtang.doorpwd.vo;

import c.e.c.q.d.e;
import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResponseDoorPasswordBleCommandBo extends NewBaseVo {
    public static final String MAC_ADDRESS = "DBB2440B0185";
    public static final String MT_MAC_ADDRESS = "0BDCD6FF41AF";
    private String assetKey;
    private String command;
    private String commandId;
    private List<String> commandIdList;
    private String doorPwd;
    private String freezeOnlinePassword;
    private String freezeOnlinePasswordId;
    private String macAddress;
    private String modelName;
    private e outputProperties;
    private String roomName;
    private String setupCommand;
    private String setupCommandId;
    private String unfreezeOnlinePassword;
    private String unfreezeOnlinePasswordId;

    public String getAssetKey() {
        return this.assetKey;
    }

    public String getCommand() {
        return this.command;
    }

    public String getCommandId() {
        return this.commandId;
    }

    public List<String> getCommandIdList() {
        return this.commandIdList;
    }

    public String getDoorPwd() {
        return this.doorPwd;
    }

    public String getFreezeOnlinePassword() {
        return this.freezeOnlinePassword;
    }

    public String getFreezeOnlinePasswordId() {
        return this.freezeOnlinePasswordId;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public String getModelName() {
        return this.modelName;
    }

    public e getOutputProperties() {
        return this.outputProperties;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public String getSetupCommand() {
        return this.setupCommand;
    }

    public String getSetupCommandId() {
        return this.setupCommandId;
    }

    public String getUnfreezeOnlinePassword() {
        return this.unfreezeOnlinePassword;
    }

    public String getUnfreezeOnlinePasswordId() {
        return this.unfreezeOnlinePasswordId;
    }

    public void setAssetKey(String str) {
        this.assetKey = str;
    }

    public void setCommand(String str) {
        this.command = str;
    }

    public void setCommandId(String str) {
        this.commandId = str;
    }

    public void setCommandIdList(List<String> list) {
        this.commandIdList = list;
    }

    public void setDoorPwd(String str) {
        this.doorPwd = str;
    }

    public void setFreezeOnlinePassword(String str) {
        this.freezeOnlinePassword = str;
    }

    public void setFreezeOnlinePasswordId(String str) {
        this.freezeOnlinePasswordId = str;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public void setModelName(String str) {
        this.modelName = str;
    }

    public void setOutputProperties(e eVar) {
        this.outputProperties = eVar;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }

    public void setSetupCommand(String str) {
        this.setupCommand = str;
    }

    public void setSetupCommandId(String str) {
        this.setupCommandId = str;
    }

    public void setUnfreezeOnlinePassword(String str) {
        this.unfreezeOnlinePassword = str;
    }

    public void setUnfreezeOnlinePasswordId(String str) {
        this.unfreezeOnlinePasswordId = str;
    }
}
