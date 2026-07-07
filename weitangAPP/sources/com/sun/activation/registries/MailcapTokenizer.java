package com.sun.activation.registries;

import com.chinavisionary.microtang.main.bo.RequestBannerParamBo;

/* JADX INFO: loaded from: classes2.dex */
public class MailcapTokenizer {
    public static final int EOI_TOKEN = 5;
    public static final int EQUALS_TOKEN = 61;
    public static final int SEMICOLON_TOKEN = 59;
    public static final int SLASH_TOKEN = 47;
    public static final int START_TOKEN = 1;
    public static final int STRING_TOKEN = 2;
    public static final int UNKNOWN_TOKEN = 0;
    private String data;
    private int dataLength;
    private int dataIndex = 0;
    private int currentToken = 1;
    private String currentTokenValue = "";
    private boolean isAutoquoting = false;
    private char autoquoteChar = ';';

    public MailcapTokenizer(String str) {
        this.data = str;
        this.dataLength = str.length();
    }

    private static String fixEscapeSequences(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(length);
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\\') {
                stringBuffer.append(cCharAt);
            } else if (i2 < length - 1) {
                i2++;
                stringBuffer.append(str.charAt(i2));
            } else {
                stringBuffer.append(cCharAt);
            }
            i2++;
        }
        return stringBuffer.toString();
    }

    private static boolean isControlChar(char c2) {
        return Character.isISOControl(c2);
    }

    private static boolean isSpecialChar(char c2) {
        if (c2 != '\"' && c2 != ',' && c2 != '/' && c2 != '(' && c2 != ')') {
            switch (c2) {
                default:
                    switch (c2) {
                        case '[':
                        case '\\':
                        case ']':
                            break;
                        default:
                            return false;
                    }
                case ':':
                case ';':
                case '<':
                case '=':
                case '>':
                case '?':
                case '@':
                    return true;
            }
        }
        return true;
    }

    private static boolean isStringTokenChar(char c2) {
        return (isSpecialChar(c2) || isControlChar(c2) || isWhiteSpaceChar(c2)) ? false : true;
    }

    private static boolean isWhiteSpaceChar(char c2) {
        return Character.isWhitespace(c2);
    }

    public static String nameForToken(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 5 ? i2 != 47 ? i2 != 59 ? i2 != 61 ? "really unknown" : "'='" : "';'" : "'/'" : "EOI" : "string" : RequestBannerParamBo.GET_SPLASH_TYPE : "unknown";
    }

    private void processAutoquoteToken() {
        int i2;
        int i3 = this.dataIndex;
        boolean z = false;
        while (true) {
            i2 = this.dataIndex;
            if (i2 >= this.dataLength || z) {
                break;
            } else if (this.data.charAt(i2) != this.autoquoteChar) {
                this.dataIndex++;
            } else {
                z = true;
            }
        }
        this.currentToken = 2;
        this.currentTokenValue = fixEscapeSequences(this.data.substring(i3, i2));
    }

    private void processStringToken() {
        int i2 = this.dataIndex;
        while (true) {
            int i3 = this.dataIndex;
            if (i3 >= this.dataLength || !isStringTokenChar(this.data.charAt(i3))) {
                break;
            } else {
                this.dataIndex++;
            }
        }
        this.currentToken = 2;
        this.currentTokenValue = this.data.substring(i2, this.dataIndex);
    }

    public int getCurrentToken() {
        return this.currentToken;
    }

    public String getCurrentTokenValue() {
        return this.currentTokenValue;
    }

    public int nextToken() {
        if (this.dataIndex < this.dataLength) {
            while (true) {
                int i2 = this.dataIndex;
                if (i2 >= this.dataLength || !isWhiteSpaceChar(this.data.charAt(i2))) {
                    break;
                }
                this.dataIndex++;
            }
            int i3 = this.dataIndex;
            if (i3 < this.dataLength) {
                char cCharAt = this.data.charAt(i3);
                if (this.isAutoquoting) {
                    if (cCharAt == ';' || cCharAt == '=') {
                        this.currentToken = cCharAt;
                        this.currentTokenValue = new Character(cCharAt).toString();
                        this.dataIndex++;
                    } else {
                        processAutoquoteToken();
                    }
                } else if (isStringTokenChar(cCharAt)) {
                    processStringToken();
                } else if (cCharAt == '/' || cCharAt == ';' || cCharAt == '=') {
                    this.currentToken = cCharAt;
                    this.currentTokenValue = new Character(cCharAt).toString();
                    this.dataIndex++;
                } else {
                    this.currentToken = 0;
                    this.currentTokenValue = new Character(cCharAt).toString();
                    this.dataIndex++;
                }
            } else {
                this.currentToken = 5;
                this.currentTokenValue = null;
            }
        } else {
            this.currentToken = 5;
            this.currentTokenValue = null;
        }
        return this.currentToken;
    }

    public void setIsAutoquoting(boolean z) {
        this.isAutoquoting = z;
    }
}
