package g.a.i.c.a;

import java.security.PrivateKey;

/* JADX INFO: loaded from: classes3.dex */
public interface c extends PrivateKey {
    c extractKeyShard(int i2);

    /* synthetic */ int getHeight();

    long getIndex();

    /* synthetic */ String getTreeDigest();

    long getUsagesRemaining();
}
