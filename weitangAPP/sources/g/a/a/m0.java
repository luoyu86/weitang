package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface m0 extends g, y2 {
    @Override // g.a.a.y2
    /* synthetic */ a0 getLoadedObject() throws IOException;

    g getObjectParser(int i2, boolean z) throws IOException;

    int getTagClass();

    int getTagNo();

    boolean hasContextTag(int i2);

    boolean hasTag(int i2, int i3);

    g parseBaseUniversal(boolean z, int i2) throws IOException;

    g parseExplicitBaseObject() throws IOException;

    m0 parseExplicitBaseTagged() throws IOException;

    m0 parseImplicitBaseTagged(int i2, int i3) throws IOException;

    @Override // g.a.a.g
    /* synthetic */ a0 toASN1Primitive();
}
