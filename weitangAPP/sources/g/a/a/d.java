package g.a.a;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface d extends g, y2 {
    InputStream getBitStream() throws IOException;

    @Override // g.a.a.y2
    /* synthetic */ a0 getLoadedObject() throws IOException;

    InputStream getOctetStream() throws IOException;

    int getPadBits();

    @Override // g.a.a.g
    /* synthetic */ a0 toASN1Primitive();
}
