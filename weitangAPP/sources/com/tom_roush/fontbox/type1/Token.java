package com.tom_roush.fontbox.type1;

/* JADX INFO: loaded from: classes2.dex */
public class Token {
    private byte[] data;
    private final Kind kind;
    private String text;
    public static final Kind STRING = Kind.STRING;
    public static final Kind NAME = Kind.NAME;
    public static final Kind LITERAL = Kind.LITERAL;
    public static final Kind REAL = Kind.REAL;
    public static final Kind INTEGER = Kind.INTEGER;
    public static final Kind START_ARRAY = Kind.START_ARRAY;
    public static final Kind END_ARRAY = Kind.END_ARRAY;
    public static final Kind START_PROC = Kind.START_PROC;
    public static final Kind END_PROC = Kind.END_PROC;
    public static final Kind CHARSTRING = Kind.CHARSTRING;
    public static final Kind START_DICT = Kind.START_DICT;
    public static final Kind END_DICT = Kind.END_DICT;

    public enum Kind {
        NONE,
        STRING,
        NAME,
        LITERAL,
        REAL,
        INTEGER,
        START_ARRAY,
        END_ARRAY,
        START_PROC,
        END_PROC,
        START_DICT,
        END_DICT,
        CHARSTRING
    }

    public Token(String str, Kind kind) {
        this.text = str;
        this.kind = kind;
    }

    public boolean booleanValue() {
        return this.text.equals("true");
    }

    public float floatValue() {
        return Float.parseFloat(this.text);
    }

    public byte[] getData() {
        return this.data;
    }

    public Kind getKind() {
        return this.kind;
    }

    public String getText() {
        return this.text;
    }

    public int intValue() {
        return (int) Float.parseFloat(this.text);
    }

    public String toString() {
        if (this.kind == CHARSTRING) {
            return "Token[kind=CHARSTRING, data=" + this.data.length + " bytes]";
        }
        return "Token[kind=" + this.kind + ", text=" + this.text + "]";
    }

    public Token(char c2, Kind kind) {
        this.text = Character.toString(c2);
        this.kind = kind;
    }

    public Token(byte[] bArr, Kind kind) {
        this.data = bArr;
        this.kind = kind;
    }
}
