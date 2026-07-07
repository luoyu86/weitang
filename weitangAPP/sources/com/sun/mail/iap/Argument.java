package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Argument {
    public List<Object> items = new ArrayList(1);

    private void astring(byte[] bArr, Protocol protocol) throws ProtocolException, IOException {
        nastring(bArr, protocol, false);
    }

    private void literal(byte[] bArr, Protocol protocol) throws ProtocolException, IOException {
        startLiteral(protocol, bArr.length).write(bArr);
    }

    private void nastring(byte[] bArr, Protocol protocol, boolean z) throws ProtocolException, IOException {
        int i2;
        DataOutputStream dataOutputStream = (DataOutputStream) protocol.getOutputStream();
        int length = bArr.length;
        if (length > 1024) {
            literal(bArr, protocol);
            return;
        }
        boolean z2 = true;
        boolean z3 = length == 0 ? true : z;
        boolean zSupportsUtf8 = protocol.supportsUtf8();
        boolean z4 = false;
        for (byte b2 : bArr) {
            if (b2 == 0 || b2 == 13 || b2 == 10 || (!zSupportsUtf8 && (b2 & 255) > 127)) {
                literal(bArr, protocol);
                return;
            }
            if (b2 == 42 || b2 == 37 || b2 == 40 || b2 == 41 || b2 == 123 || b2 == 34 || b2 == 92 || (i2 = b2 & 255) <= 32 || i2 > 127) {
                if (b2 == 34 || b2 == 92) {
                    z3 = true;
                    z4 = true;
                } else {
                    z3 = true;
                }
            }
        }
        if (z3 || bArr.length != 3 || ((bArr[0] != 78 && bArr[0] != 110) || ((bArr[1] != 73 && bArr[1] != 105) || (bArr[2] != 76 && bArr[2] != 108)))) {
            z2 = z3;
        }
        if (z2) {
            dataOutputStream.write(34);
        }
        if (z4) {
            for (byte b3 : bArr) {
                if (b3 == 34 || b3 == 92) {
                    dataOutputStream.write(92);
                }
                dataOutputStream.write(b3);
            }
        } else {
            dataOutputStream.write(bArr);
        }
        if (z2) {
            dataOutputStream.write(34);
        }
    }

    private void nstring(byte[] bArr, Protocol protocol) throws ProtocolException, IOException {
        if (bArr == null) {
            ((DataOutputStream) protocol.getOutputStream()).writeBytes("NIL");
        } else {
            nastring(bArr, protocol, true);
        }
    }

    private OutputStream startLiteral(Protocol protocol, int i2) throws ProtocolException, IOException {
        Response response;
        DataOutputStream dataOutputStream = (DataOutputStream) protocol.getOutputStream();
        boolean zSupportsNonSyncLiterals = protocol.supportsNonSyncLiterals();
        dataOutputStream.write(123);
        dataOutputStream.writeBytes(Integer.toString(i2));
        if (zSupportsNonSyncLiterals) {
            dataOutputStream.writeBytes("+}\r\n");
        } else {
            dataOutputStream.writeBytes("}\r\n");
        }
        dataOutputStream.flush();
        if (!zSupportsNonSyncLiterals) {
            do {
                response = protocol.readResponse();
                if (response.isContinuation()) {
                }
            } while (!response.isTagged());
            throw new LiteralException(response);
        }
        return dataOutputStream;
    }

    public Argument append(Argument argument) {
        this.items.addAll(argument.items);
        return this;
    }

    public void write(Protocol protocol) throws ProtocolException, IOException {
        List<Object> list = this.items;
        int size = list != null ? list.size() : 0;
        DataOutputStream dataOutputStream = (DataOutputStream) protocol.getOutputStream();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                dataOutputStream.write(32);
            }
            Object obj = this.items.get(i2);
            if (obj instanceof Atom) {
                dataOutputStream.writeBytes(((Atom) obj).string);
            } else if (obj instanceof Number) {
                dataOutputStream.writeBytes(((Number) obj).toString());
            } else if (obj instanceof AString) {
                astring(((AString) obj).bytes, protocol);
            } else if (obj instanceof NString) {
                nstring(((NString) obj).bytes, protocol);
            } else if (obj instanceof byte[]) {
                literal((byte[]) obj, protocol);
            } else if (obj instanceof ByteArrayOutputStream) {
                literal((ByteArrayOutputStream) obj, protocol);
            } else if (obj instanceof Literal) {
                literal((Literal) obj, protocol);
            } else if (obj instanceof Argument) {
                dataOutputStream.write(40);
                ((Argument) obj).write(protocol);
                dataOutputStream.write(41);
            }
        }
    }

    public Argument writeArgument(Argument argument) {
        this.items.add(argument);
        return this;
    }

    public Argument writeAtom(String str) {
        this.items.add(new Atom(str));
        return this;
    }

    public Argument writeBytes(byte[] bArr) {
        this.items.add(bArr);
        return this;
    }

    public Argument writeNString(String str) {
        if (str == null) {
            this.items.add(new NString(null));
        } else {
            this.items.add(new NString(ASCIIUtility.getBytes(str)));
        }
        return this;
    }

    public Argument writeNumber(int i2) {
        this.items.add(Integer.valueOf(i2));
        return this;
    }

    public Argument writeString(String str) {
        this.items.add(new AString(ASCIIUtility.getBytes(str)));
        return this;
    }

    private void literal(ByteArrayOutputStream byteArrayOutputStream, Protocol protocol) throws ProtocolException, IOException {
        byteArrayOutputStream.writeTo(startLiteral(protocol, byteArrayOutputStream.size()));
    }

    public Argument writeBytes(ByteArrayOutputStream byteArrayOutputStream) {
        this.items.add(byteArrayOutputStream);
        return this;
    }

    public Argument writeNumber(long j) {
        this.items.add(Long.valueOf(j));
        return this;
    }

    public Argument writeString(String str, String str2) throws UnsupportedEncodingException {
        if (str2 == null) {
            writeString(str);
        } else {
            this.items.add(new AString(str.getBytes(str2)));
        }
        return this;
    }

    private void literal(Literal literal, Protocol protocol) throws ProtocolException, IOException {
        literal.writeTo(startLiteral(protocol, literal.size()));
    }

    public Argument writeBytes(Literal literal) {
        this.items.add(literal);
        return this;
    }

    public Argument writeNString(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            this.items.add(new NString(null));
        } else if (str2 == null) {
            writeString(str);
        } else {
            this.items.add(new NString(str.getBytes(str2)));
        }
        return this;
    }

    public Argument writeString(String str, Charset charset) {
        if (charset == null) {
            writeString(str);
        } else {
            this.items.add(new AString(str.getBytes(charset)));
        }
        return this;
    }

    public Argument writeNString(String str, Charset charset) {
        if (str == null) {
            this.items.add(new NString(null));
        } else if (charset == null) {
            writeString(str);
        } else {
            this.items.add(new NString(str.getBytes(charset)));
        }
        return this;
    }
}
