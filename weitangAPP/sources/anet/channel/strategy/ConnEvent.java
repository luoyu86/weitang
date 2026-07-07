package anet.channel.strategy;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class ConnEvent {
    public boolean isSuccess = false;
    public long connTime = RecyclerView.FOREVER_NS;
    public boolean isAccs = false;

    public String toString() {
        return this.isSuccess ? "ConnEvent#Success" : "ConnEvent#Fail";
    }
}
