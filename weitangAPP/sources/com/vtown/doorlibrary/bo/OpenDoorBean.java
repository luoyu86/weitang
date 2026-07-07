package com.vtown.doorlibrary.bo;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class OpenDoorBean {
    private List<String> command;
    private String commandId;

    public List<String> getCommand() {
        return this.command;
    }

    public String getCommandId() {
        return this.commandId;
    }

    public void setCommand(List<String> list) {
        this.command = list;
    }

    public void setCommandId(String str) {
        this.commandId = str;
    }
}
