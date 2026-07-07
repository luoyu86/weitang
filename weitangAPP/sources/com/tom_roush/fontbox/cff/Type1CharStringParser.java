package com.tom_roush.fontbox.cff;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Type1CharStringParser {
    public static final int CALLOTHERSUBR = 16;
    public static final int CALLSUBR = 10;
    public static final int POP = 17;
    public static final int RETURN = 11;
    public static final int TWO_BYTE = 12;
    private final String fontName;
    private final String glyphName;

    public Type1CharStringParser(String str, String str2) {
        this.fontName = str;
        this.glyphName = str2;
    }

    private CharStringCommand readCommand(DataInput dataInput, int i2) throws IOException {
        return i2 == 12 ? new CharStringCommand(i2, dataInput.readUnsignedByte()) : new CharStringCommand(i2);
    }

    private Integer readNumber(DataInput dataInput, int i2) throws IOException {
        if (i2 >= 32 && i2 <= 246) {
            return Integer.valueOf(i2 - 139);
        }
        if (i2 >= 247 && i2 <= 250) {
            return Integer.valueOf(((i2 - 247) * 256) + dataInput.readUnsignedByte() + 108);
        }
        if (i2 >= 251 && i2 <= 254) {
            return Integer.valueOf((((-(i2 - 251)) * 256) - dataInput.readUnsignedByte()) - 108);
        }
        if (i2 == 255) {
            return Integer.valueOf(dataInput.readInt());
        }
        throw new IllegalArgumentException();
    }

    private static Integer removeInteger(List<Object> list) throws IOException {
        Object objRemove = list.remove(list.size() - 1);
        if (objRemove instanceof Integer) {
            return (Integer) objRemove;
        }
        CharStringCommand charStringCommand = (CharStringCommand) objRemove;
        if (charStringCommand.getKey().getValue()[0] == 12 && charStringCommand.getKey().getValue()[1] == 12) {
            return Integer.valueOf(((Integer) list.remove(list.size() - 1)).intValue() / ((Integer) list.remove(list.size() - 1)).intValue());
        }
        throw new IOException("Unexpected char string command: " + charStringCommand.getKey());
    }

    public List<Object> parse(byte[] bArr, List<byte[]> list) throws IOException {
        return parse(bArr, list, new ArrayList());
    }

    private List<Object> parse(byte[] bArr, List<byte[]> list, List<Object> list2) throws IOException {
        DataInput dataInput = new DataInput(bArr);
        while (dataInput.hasRemaining()) {
            int unsignedByte = dataInput.readUnsignedByte();
            if (unsignedByte == 10) {
                Object objRemove = list2.remove(list2.size() - 1);
                if (objRemove instanceof Integer) {
                    Integer num = (Integer) objRemove;
                    if (num.intValue() < 0 || num.intValue() >= list.size()) {
                        Log.w("PdfBox-Android", "CALLSUBR is ignored, operand: " + num + ", subrs.size(): " + list.size() + " in glyph '" + this.glyphName + "' of font " + this.fontName);
                        while (list2.get(list2.size() - 1) instanceof Integer) {
                            list2.remove(list2.size() - 1);
                        }
                    } else {
                        parse(list.get(num.intValue()), list, list2);
                        Object obj = list2.get(list2.size() - 1);
                        if ((obj instanceof CharStringCommand) && ((CharStringCommand) obj).getKey().getValue()[0] == 11) {
                            list2.remove(list2.size() - 1);
                        }
                    }
                } else {
                    Log.w("PdfBox-Android", "Parameter " + objRemove + " for CALLSUBR is ignored, integer expected in glyph '" + this.glyphName + "' of font " + this.fontName);
                }
            } else if (unsignedByte == 12 && dataInput.peekUnsignedByte(0) == 16) {
                dataInput.readByte();
                Integer num2 = (Integer) list2.remove(list2.size() - 1);
                Integer num3 = (Integer) list2.remove(list2.size() - 1);
                ArrayDeque arrayDeque = new ArrayDeque();
                int iIntValue = num2.intValue();
                if (iIntValue == 0) {
                    arrayDeque.push(removeInteger(list2));
                    arrayDeque.push(removeInteger(list2));
                    list2.remove(list2.size() - 1);
                    list2.add(0);
                    list2.add(new CharStringCommand(12, 16));
                } else if (iIntValue == 1) {
                    list2.add(1);
                    list2.add(new CharStringCommand(12, 16));
                } else if (iIntValue != 3) {
                    for (int i2 = 0; i2 < num3.intValue(); i2++) {
                        arrayDeque.push(removeInteger(list2));
                    }
                } else {
                    arrayDeque.push(removeInteger(list2));
                }
                while (dataInput.peekUnsignedByte(0) == 12 && dataInput.peekUnsignedByte(1) == 17) {
                    dataInput.readByte();
                    dataInput.readByte();
                    list2.add(arrayDeque.pop());
                }
                if (arrayDeque.size() > 0) {
                    Log.w("PdfBox-Android", "Value left on the PostScript stack in glyph " + this.glyphName + " of font " + this.fontName);
                }
            } else if (unsignedByte >= 0 && unsignedByte <= 31) {
                list2.add(readCommand(dataInput, unsignedByte));
            } else {
                if (unsignedByte < 32 || unsignedByte > 255) {
                    throw new IllegalArgumentException();
                }
                list2.add(readNumber(dataInput, unsignedByte));
            }
        }
        return list2;
    }
}
