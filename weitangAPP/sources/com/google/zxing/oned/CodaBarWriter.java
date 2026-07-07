package com.google.zxing.oned;

/* JADX INFO: loaded from: classes2.dex */
public class CodaBarWriter extends OneDimensionalCodeWriter {
    public CodaBarWriter() {
        super(20);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public byte[] encode(String str) {
        int i2;
        if (!CodaBarReader.arrayContains(new char[]{'A', 'B', 'C', 'D'}, Character.toUpperCase(str.charAt(0)))) {
            throw new IllegalArgumentException("Codabar should start with one of the following: 'A', 'B', 'C' or 'D'");
        }
        if (!CodaBarReader.arrayContains(new char[]{'T', 'N', '*', 'E'}, Character.toUpperCase(str.charAt(str.length() - 1)))) {
            throw new IllegalArgumentException("Codabar should end with one of the following: 'T', 'N', '*' or 'E'");
        }
        int i3 = 20;
        char[] cArr = {'/', ':', '+', '.'};
        for (int i4 = 1; i4 < str.length() - 1; i4++) {
            if (Character.isDigit(str.charAt(i4)) || str.charAt(i4) == '-' || str.charAt(i4) == '$') {
                i3 += 9;
            } else {
                if (!CodaBarReader.arrayContains(cArr, str.charAt(i4))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i4) + '\'');
                }
                i3 += 10;
            }
        }
        byte[] bArr = new byte[i3 + (str.length() - 1)];
        int i5 = 0;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char upperCase = Character.toUpperCase(str.charAt(i6));
            if (i6 == str.length() - 1) {
                if (upperCase == '*') {
                    upperCase = 'C';
                } else if (upperCase == 'E') {
                    upperCase = 'D';
                }
            }
            int i7 = 0;
            while (true) {
                char[] cArr2 = CodaBarReader.ALPHABET;
                if (i7 >= cArr2.length) {
                    i2 = 0;
                    break;
                }
                if (upperCase == cArr2[i7]) {
                    i2 = CodaBarReader.CHARACTER_ENCODINGS[i7];
                    break;
                }
                i7++;
            }
            int i8 = 0;
            byte b2 = 1;
            while (true) {
                int i9 = 0;
                while (i8 < 7) {
                    bArr[i5] = b2;
                    i5++;
                    if (((i2 >> (6 - i8)) & 1) == 0 || i9 == 1) {
                        break;
                    }
                    i9++;
                }
                b2 = (byte) (b2 ^ 1);
                i8++;
            }
            if (i6 < str.length() - 1) {
                bArr[i5] = 0;
                i5++;
            }
        }
        return bArr;
    }
}
