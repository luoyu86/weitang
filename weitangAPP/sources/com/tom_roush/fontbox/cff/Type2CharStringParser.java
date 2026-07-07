package com.tom_roush.fontbox.cff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class Type2CharStringParser {
    private final String fontName;
    private final String glyphName;
    private int hstemCount = 0;
    private int vstemCount = 0;
    private List<Object> sequence = null;

    public Type2CharStringParser(String str, String str2) {
        this.fontName = str;
        this.glyphName = str2;
    }

    private int getMaskLength() {
        int i2 = this.hstemCount + this.vstemCount;
        int i3 = i2 / 8;
        return i2 % 8 > 0 ? i3 + 1 : i3;
    }

    private List<Number> peekNumbers() {
        ArrayList arrayList = new ArrayList();
        int size = this.sequence.size();
        while (true) {
            size--;
            if (size <= -1) {
                return arrayList;
            }
            Object obj = this.sequence.get(size);
            if (!(obj instanceof Number)) {
                return arrayList;
            }
            arrayList.add(0, (Number) obj);
        }
    }

    private CharStringCommand readCommand(int i2, DataInput dataInput) throws IOException {
        if (i2 == 1 || i2 == 18) {
            this.hstemCount += peekNumbers().size() / 2;
        } else if (i2 == 3 || i2 == 19 || i2 == 20 || i2 == 23) {
            this.vstemCount += peekNumbers().size() / 2;
        }
        if (i2 == 12) {
            return new CharStringCommand(i2, dataInput.readUnsignedByte());
        }
        if (i2 != 19 && i2 != 20) {
            return new CharStringCommand(i2);
        }
        int maskLength = getMaskLength() + 1;
        int[] iArr = new int[maskLength];
        iArr[0] = i2;
        for (int i3 = 1; i3 < maskLength; i3++) {
            iArr[i3] = dataInput.readUnsignedByte();
        }
        return new CharStringCommand(iArr);
    }

    private Number readNumber(int i2, DataInput dataInput) throws IOException {
        if (i2 == 28) {
            return Integer.valueOf(dataInput.readShort());
        }
        if (i2 >= 32 && i2 <= 246) {
            return Integer.valueOf(i2 - 139);
        }
        if (i2 >= 247 && i2 <= 250) {
            return Integer.valueOf(((i2 - 247) * 256) + dataInput.readUnsignedByte() + 108);
        }
        if (i2 >= 251 && i2 <= 254) {
            return Integer.valueOf((((-(i2 - 251)) * 256) - dataInput.readUnsignedByte()) - 108);
        }
        if (i2 != 255) {
            throw new IllegalArgumentException();
        }
        return Double.valueOf(((double) dataInput.readShort()) + (((double) dataInput.readUnsignedShort()) / 65535.0d));
    }

    public List<Object> parse(byte[] bArr, byte[][] bArr2, byte[][] bArr3) throws IOException {
        return parse(bArr, bArr2, bArr3, true);
    }

    private List<Object> parse(byte[] bArr, byte[][] bArr2, byte[][] bArr3, boolean z) throws IOException {
        if (z) {
            this.hstemCount = 0;
            this.vstemCount = 0;
            this.sequence = new ArrayList();
        }
        DataInput dataInput = new DataInput(bArr);
        boolean z2 = bArr3 != null && bArr3.length > 0;
        boolean z3 = bArr2 != null && bArr2.length > 0;
        while (dataInput.hasRemaining()) {
            int unsignedByte = dataInput.readUnsignedByte();
            int i2 = 1131;
            if (unsignedByte == 10 && z2) {
                List<Object> list = this.sequence;
                Integer num = (Integer) list.remove(list.size() - 1);
                int length = bArr3.length;
                if (length < 1240) {
                    i2 = 107;
                } else if (length >= 33900) {
                    i2 = 32768;
                }
                int iIntValue = i2 + num.intValue();
                if (iIntValue < bArr3.length) {
                    parse(bArr3[iIntValue], bArr2, bArr3, false);
                    List<Object> list2 = this.sequence;
                    Object obj = list2.get(list2.size() - 1);
                    if ((obj instanceof CharStringCommand) && ((CharStringCommand) obj).getKey().getValue()[0] == 11) {
                        List<Object> list3 = this.sequence;
                        list3.remove(list3.size() - 1);
                    }
                }
            } else if (unsignedByte == 29 && z3) {
                List<Object> list4 = this.sequence;
                Integer num2 = (Integer) list4.remove(list4.size() - 1);
                int length2 = bArr2.length;
                if (length2 < 1240) {
                    i2 = 107;
                } else if (length2 >= 33900) {
                    i2 = 32768;
                }
                int iIntValue2 = i2 + num2.intValue();
                if (iIntValue2 < bArr2.length) {
                    parse(bArr2[iIntValue2], bArr2, bArr3, false);
                    List<Object> list5 = this.sequence;
                    Object obj2 = list5.get(list5.size() - 1);
                    if ((obj2 instanceof CharStringCommand) && ((CharStringCommand) obj2).getKey().getValue()[0] == 11) {
                        List<Object> list6 = this.sequence;
                        list6.remove(list6.size() - 1);
                    }
                }
            } else if (unsignedByte >= 0 && unsignedByte <= 27) {
                this.sequence.add(readCommand(unsignedByte, dataInput));
            } else if (unsignedByte == 28) {
                this.sequence.add(readNumber(unsignedByte, dataInput));
            } else if (unsignedByte >= 29 && unsignedByte <= 31) {
                this.sequence.add(readCommand(unsignedByte, dataInput));
            } else {
                if (unsignedByte < 32 || unsignedByte > 255) {
                    throw new IllegalArgumentException();
                }
                this.sequence.add(readNumber(unsignedByte, dataInput));
            }
        }
        return this.sequence;
    }

    public Type2CharStringParser(String str, int i2) {
        this.fontName = str;
        this.glyphName = String.format(Locale.US, "%04x", Integer.valueOf(i2));
    }
}
