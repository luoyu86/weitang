package com.tom_roush.fontbox.type1;

import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class Type1Lexer {
    private final ByteBuffer buffer;
    private int openParens = 0;
    private Token aheadToken = readToken(null);

    public Type1Lexer(byte[] bArr) throws IOException {
        this.buffer = ByteBuffer.wrap(bArr);
    }

    private char getChar() {
        return (char) this.buffer.get();
    }

    private Token readCharString(int i2) {
        this.buffer.get();
        byte[] bArr = new byte[i2];
        this.buffer.get(bArr);
        return new Token(bArr, Token.CHARSTRING);
    }

    private String readComment() {
        char c2;
        StringBuilder sb = new StringBuilder();
        while (this.buffer.hasRemaining() && (c2 = getChar()) != '\r' && c2 != '\n') {
            sb.append(c2);
        }
        return sb.toString();
    }

    private String readRegular() {
        StringBuilder sb = new StringBuilder();
        while (this.buffer.hasRemaining()) {
            this.buffer.mark();
            char c2 = getChar();
            if (Character.isWhitespace(c2) || c2 == '(' || c2 == ')' || c2 == '<' || c2 == '>' || c2 == '[' || c2 == ']' || c2 == '{' || c2 == '}' || c2 == '/' || c2 == '%') {
                this.buffer.reset();
                break;
            }
            sb.append(c2);
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    private Token readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        while (this.buffer.hasRemaining()) {
            char c2 = getChar();
            if (c2 == '\n' || c2 == '\r') {
                sb.append("\n");
            } else if (c2 == '\\') {
                char c3 = getChar();
                if (c3 == '(') {
                    sb.append('(');
                } else if (c3 == ')') {
                    sb.append(')');
                } else if (c3 == '\\') {
                    sb.append('\\');
                } else if (c3 == 'b') {
                    sb.append('\b');
                } else if (c3 == 'f') {
                    sb.append('\f');
                } else if (c3 == 'n' || c3 == 'r') {
                    sb.append("\n");
                } else if (c3 == 't') {
                    sb.append('\t');
                }
                if (Character.isDigit(c3)) {
                    try {
                        sb.append((char) Integer.parseInt(String.valueOf(new char[]{c3, getChar(), getChar()}), 8));
                    } catch (NumberFormatException e2) {
                        throw new IOException(e2);
                    }
                } else {
                    continue;
                }
            } else if (c2 == '(') {
                this.openParens++;
                sb.append('(');
            } else if (c2 != ')') {
                sb.append(c2);
            } else {
                if (this.openParens == 0) {
                    return new Token(sb.toString(), Token.STRING);
                }
                sb.append(')');
                this.openParens--;
            }
        }
        return null;
    }

    private Token readToken(Token token) throws IOException {
        boolean z;
        do {
            z = false;
            while (this.buffer.hasRemaining()) {
                char c2 = getChar();
                if (c2 == '%') {
                    readComment();
                } else {
                    if (c2 == '(') {
                        return readString();
                    }
                    if (c2 == ')') {
                        throw new IOException("unexpected closing parenthesis");
                    }
                    if (c2 == '[') {
                        return new Token(c2, Token.START_ARRAY);
                    }
                    if (c2 == '{') {
                        return new Token(c2, Token.START_PROC);
                    }
                    if (c2 == ']') {
                        return new Token(c2, Token.END_ARRAY);
                    }
                    if (c2 == '}') {
                        return new Token(c2, Token.END_PROC);
                    }
                    if (c2 == '/') {
                        return new Token(readRegular(), Token.LITERAL);
                    }
                    if (c2 == '<') {
                        if (getChar() == c2) {
                            return new Token("<<", Token.START_DICT);
                        }
                        ByteBuffer byteBuffer = this.buffer;
                        byteBuffer.position(byteBuffer.position() - 1);
                        return new Token(c2, Token.NAME);
                    }
                    if (c2 == '>') {
                        if (getChar() == c2) {
                            return new Token(">>", Token.END_DICT);
                        }
                        ByteBuffer byteBuffer2 = this.buffer;
                        byteBuffer2.position(byteBuffer2.position() - 1);
                        return new Token(c2, Token.NAME);
                    }
                    if (!Character.isWhitespace(c2)) {
                        if (c2 != 0) {
                            ByteBuffer byteBuffer3 = this.buffer;
                            byteBuffer3.position(byteBuffer3.position() - 1);
                            Token tokenTryReadNumber = tryReadNumber();
                            if (tokenTryReadNumber != null) {
                                return tokenTryReadNumber;
                            }
                            String regular = readRegular();
                            if (regular == null) {
                                throw new DamagedFontException("Could not read token at position " + this.buffer.position());
                            }
                            if (!regular.equals("RD") && !regular.equals("-|")) {
                                return new Token(regular, Token.NAME);
                            }
                            if (token == null || token.getKind() != Token.INTEGER) {
                                throw new IOException("expected INTEGER before -| or RD");
                            }
                            return readCharString(token.intValue());
                        }
                        Log.w("PdfBox-Android", "NULL byte in font, skipped");
                    }
                    z = true;
                }
            }
        } while (z);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094 A[LOOP:1: B:31:0x008e->B:33:0x0094, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.tom_roush.fontbox.type1.Token tryReadNumber() {
        /*
            Method dump skipped, instruction units count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.fontbox.type1.Type1Lexer.tryReadNumber():com.tom_roush.fontbox.type1.Token");
    }

    public Token nextToken() throws IOException {
        Token token = this.aheadToken;
        this.aheadToken = readToken(token);
        return token;
    }

    public Token peekToken() {
        return this.aheadToken;
    }
}
