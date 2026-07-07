package com.sun.activation.registries;

import java.util.NoSuchElementException;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public class LineTokenizer {
    private static final String singles = "=";
    private int maxPosition;
    private String str;
    private Vector stack = new Vector();
    private int currentPosition = 0;

    public LineTokenizer(String str) {
        this.str = str;
        this.maxPosition = str.length();
    }

    private void skipWhiteSpace() {
        while (true) {
            int i2 = this.currentPosition;
            if (i2 >= this.maxPosition || !Character.isWhitespace(this.str.charAt(i2))) {
                return;
            } else {
                this.currentPosition++;
            }
        }
    }

    public boolean hasMoreTokens() {
        if (this.stack.size() > 0) {
            return true;
        }
        skipWhiteSpace();
        return this.currentPosition < this.maxPosition;
    }

    public String nextToken() {
        int size = this.stack.size();
        if (size > 0) {
            int i2 = size - 1;
            String str = (String) this.stack.elementAt(i2);
            this.stack.removeElementAt(i2);
            return str;
        }
        skipWhiteSpace();
        int i3 = this.currentPosition;
        if (i3 >= this.maxPosition) {
            throw new NoSuchElementException();
        }
        char cCharAt = this.str.charAt(i3);
        if (cCharAt == '\"') {
            this.currentPosition++;
            boolean z = false;
            while (true) {
                int i4 = this.currentPosition;
                if (i4 >= this.maxPosition) {
                    break;
                }
                String str2 = this.str;
                this.currentPosition = i4 + 1;
                char cCharAt2 = str2.charAt(i4);
                if (cCharAt2 == '\\') {
                    this.currentPosition++;
                    z = true;
                } else if (cCharAt2 == '\"') {
                    if (!z) {
                        return this.str.substring(i3 + 1, this.currentPosition - 1);
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i5 = i3 + 1; i5 < this.currentPosition - 1; i5++) {
                        char cCharAt3 = this.str.charAt(i5);
                        if (cCharAt3 != '\\') {
                            stringBuffer.append(cCharAt3);
                        }
                    }
                    return stringBuffer.toString();
                }
            }
        } else if (singles.indexOf(cCharAt) >= 0) {
            this.currentPosition++;
        } else {
            while (true) {
                int i6 = this.currentPosition;
                if (i6 >= this.maxPosition || singles.indexOf(this.str.charAt(i6)) >= 0 || Character.isWhitespace(this.str.charAt(this.currentPosition))) {
                    break;
                }
                this.currentPosition++;
            }
        }
        return this.str.substring(i3, this.currentPosition);
    }

    public void pushToken(String str) {
        this.stack.addElement(str);
    }
}
