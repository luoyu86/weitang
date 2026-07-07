package g.a.i.c.a;

import java.security.Key;
import java.security.PrivateKey;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends Key, PrivateKey {
    a extractKeyShard(int i2);

    long getIndex();

    /* synthetic */ int getLevels();

    long getUsagesRemaining();
}
