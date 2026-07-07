package org.apache.commons.codec.language;

import com.alibaba.android.arouter.utils.Consts;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: loaded from: classes2.dex */
public class ColognePhonetic implements StringEncoder {
    private static final char CHAR_IGNORE = '-';
    private static final char[] AEIJOUY = {'A', 'E', 'I', 'J', 'O', 'U', 'Y'};
    private static final char[] CSZ = {'C', 'S', 'Z'};
    private static final char[] FPVW = {'F', 'P', 'V', 'W'};
    private static final char[] GKQ = {'G', 'K', 'Q'};
    private static final char[] CKQ = {'C', 'K', 'Q'};
    private static final char[] AHKLOQRUX = {'A', 'H', 'K', 'L', 'O', 'Q', 'R', 'U', 'X'};
    private static final char[] SZ = {'S', 'Z'};
    private static final char[] AHKOQUX = {'A', 'H', 'K', 'O', 'Q', 'U', 'X'};
    private static final char[] DTX = {'D', 'T', 'X'};

    public class CologneInputBuffer extends CologneBuffer {
        public CologneInputBuffer(char[] cArr) {
            super(cArr);
        }

        @Override // org.apache.commons.codec.language.ColognePhonetic.CologneBuffer
        public char[] copyData(int i2, int i3) {
            char[] cArr = new char[i3];
            char[] cArr2 = this.data;
            System.arraycopy(cArr2, (cArr2.length - this.length) + i2, cArr, 0, i3);
            return cArr;
        }

        public char getNextChar() {
            return this.data[getNextPos()];
        }

        public int getNextPos() {
            return this.data.length - this.length;
        }

        public char removeNext() {
            this.length--;
            return getNextChar();
        }
    }

    public class CologneOutputBuffer extends CologneBuffer {
        private char lastCode;

        public CologneOutputBuffer(int i2) {
            super(i2);
            this.lastCode = '/';
        }

        @Override // org.apache.commons.codec.language.ColognePhonetic.CologneBuffer
        public char[] copyData(int i2, int i3) {
            char[] cArr = new char[i3];
            System.arraycopy(this.data, i2, cArr, 0, i3);
            return cArr;
        }

        public void put(char c2) {
            if (c2 != '-' && this.lastCode != c2 && (c2 != '0' || this.length == 0)) {
                char[] cArr = this.data;
                int i2 = this.length;
                cArr[i2] = c2;
                this.length = i2 + 1;
            }
            this.lastCode = c2;
        }
    }

    private static boolean arrayContains(char[] cArr, char c2) {
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    private char[] preprocess(String str) {
        char[] charArray = str.toUpperCase(Locale.GERMAN).toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c2 = charArray[i2];
            if (c2 == 196) {
                charArray[i2] = 'A';
            } else if (c2 == 214) {
                charArray[i2] = 'O';
            } else if (c2 == 220) {
                charArray[i2] = 'U';
            }
        }
        return charArray;
    }

    public String colognePhonetic(String str) {
        if (str == null) {
            return null;
        }
        CologneInputBuffer cologneInputBuffer = new CologneInputBuffer(preprocess(str));
        CologneOutputBuffer cologneOutputBuffer = new CologneOutputBuffer(cologneInputBuffer.length() * 2);
        char c2 = '-';
        while (cologneInputBuffer.length() > 0) {
            char cRemoveNext = cologneInputBuffer.removeNext();
            char nextChar = cologneInputBuffer.length() > 0 ? cologneInputBuffer.getNextChar() : '-';
            if (cRemoveNext >= 'A' && cRemoveNext <= 'Z') {
                if (arrayContains(AEIJOUY, cRemoveNext)) {
                    cologneOutputBuffer.put('0');
                } else if (cRemoveNext == 'B' || (cRemoveNext == 'P' && nextChar != 'H')) {
                    cologneOutputBuffer.put('1');
                } else if ((cRemoveNext == 'D' || cRemoveNext == 'T') && !arrayContains(CSZ, nextChar)) {
                    cologneOutputBuffer.put('2');
                } else if (arrayContains(FPVW, cRemoveNext)) {
                    cologneOutputBuffer.put('3');
                } else if (arrayContains(GKQ, cRemoveNext)) {
                    cologneOutputBuffer.put('4');
                } else if (cRemoveNext == 'X' && !arrayContains(CKQ, c2)) {
                    cologneOutputBuffer.put('4');
                    cologneOutputBuffer.put('8');
                } else if (cRemoveNext == 'S' || cRemoveNext == 'Z') {
                    cologneOutputBuffer.put('8');
                } else if (cRemoveNext == 'C') {
                    if (cologneOutputBuffer.length() == 0) {
                        if (arrayContains(AHKLOQRUX, nextChar)) {
                            cologneOutputBuffer.put('4');
                        } else {
                            cologneOutputBuffer.put('8');
                        }
                    } else if (arrayContains(SZ, c2) || !arrayContains(AHKOQUX, nextChar)) {
                        cologneOutputBuffer.put('8');
                    } else {
                        cologneOutputBuffer.put('4');
                    }
                } else if (arrayContains(DTX, cRemoveNext)) {
                    cologneOutputBuffer.put('8');
                } else if (cRemoveNext == 'R') {
                    cologneOutputBuffer.put('7');
                } else if (cRemoveNext == 'L') {
                    cologneOutputBuffer.put('5');
                } else if (cRemoveNext == 'M' || cRemoveNext == 'N') {
                    cologneOutputBuffer.put('6');
                } else if (cRemoveNext == 'H') {
                    cologneOutputBuffer.put('-');
                }
                c2 = cRemoveNext;
            }
        }
        return cologneOutputBuffer.toString();
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("This method's parameter was expected to be of the type " + String.class.getName() + ". But actually it was of the type " + obj.getClass().getName() + Consts.DOT);
    }

    public boolean isEncodeEqual(String str, String str2) {
        return colognePhonetic(str).equals(colognePhonetic(str2));
    }

    public abstract class CologneBuffer {
        public final char[] data;
        public int length;

        public CologneBuffer(char[] cArr) {
            this.length = 0;
            this.data = cArr;
            this.length = cArr.length;
        }

        public abstract char[] copyData(int i2, int i3);

        public int length() {
            return this.length;
        }

        public String toString() {
            return new String(copyData(0, this.length));
        }

        public CologneBuffer(int i2) {
            this.length = 0;
            this.data = new char[i2];
            this.length = 0;
        }
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return colognePhonetic(str);
    }
}
