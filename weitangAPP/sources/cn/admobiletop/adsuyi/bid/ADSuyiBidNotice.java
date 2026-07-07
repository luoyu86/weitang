package cn.admobiletop.adsuyi.bid;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiBidNotice {
    void sendLossNotice(int i2, ArrayList<Double> arrayList);

    void sendWinNotice(ArrayList<Double> arrayList);
}
