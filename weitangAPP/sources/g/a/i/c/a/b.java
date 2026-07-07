package g.a.i.c.a;

import java.security.PrivateKey;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends PrivateKey {
    b extractKeyShard(int i2);

    /* synthetic */ int getHeight();

    long getIndex();

    /* synthetic */ int getLayers();

    /* synthetic */ String getTreeDigest();

    long getUsagesRemaining();
}
