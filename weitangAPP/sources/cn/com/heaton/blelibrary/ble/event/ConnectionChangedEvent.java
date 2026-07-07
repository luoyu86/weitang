package cn.com.heaton.blelibrary.ble.event;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionChangedEvent {
    private String macAddress;
    private int status;

    public ConnectionChangedEvent(String str, int i2) {
        this.macAddress = str;
        this.status = i2;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public int getStatus() {
        return this.status;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public String toString() {
        return "ConnectionChangedEvent{macAddress='" + this.macAddress + "', status=" + this.status + '}';
    }
}
