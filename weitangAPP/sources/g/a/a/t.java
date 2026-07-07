package g.a.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t implements g, g.a.j.d {
    public void encodeTo(OutputStream outputStream) throws IOException {
        toASN1Primitive().encodeTo(outputStream);
    }

    public void encodeTo(OutputStream outputStream, String str) throws IOException {
        toASN1Primitive().encodeTo(outputStream, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            return toASN1Primitive().equals(((g) obj).toASN1Primitive());
        }
        return false;
    }

    @Override // g.a.j.d
    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        toASN1Primitive().encodeTo(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getEncoded(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        toASN1Primitive().encodeTo(byteArrayOutputStream, str);
        return byteArrayOutputStream.toByteArray();
    }

    public int hashCode() {
        return toASN1Primitive().hashCode();
    }

    @Override // g.a.a.g
    public abstract a0 toASN1Primitive();
}
