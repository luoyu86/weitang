package com.tom_roush.fontbox.type1;

import com.tom_roush.fontbox.afm.AFMParser;
import com.tom_roush.fontbox.encoding.BuiltInEncoding;
import com.tom_roush.fontbox.encoding.StandardEncoding;
import com.tom_roush.fontbox.type1.Token;
import com.tom_roush.pdfbox.pdfparser.BaseParser;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Type1Parser {
    private static final int CHARSTRING_KEY = 4330;
    private static final int EEXEC_KEY = 55665;
    private Type1Font font;
    private Type1Lexer lexer;

    private List<Number> arrayToNumbers(List<Token> list) throws IOException {
        ArrayList arrayList = new ArrayList();
        int size = list.size() - 1;
        for (int i2 = 1; i2 < size; i2++) {
            Token token = list.get(i2);
            if (token.getKind() == Token.REAL) {
                arrayList.add(Float.valueOf(token.floatValue()));
            } else {
                if (token.getKind() != Token.INTEGER) {
                    throw new IOException("Expected INTEGER or REAL but got " + token + " at array position " + i2);
                }
                arrayList.add(Integer.valueOf(token.intValue()));
            }
        }
        return arrayList;
    }

    private byte[] decrypt(byte[] bArr, int i2, int i3) {
        if (i3 == -1) {
            return bArr;
        }
        if (bArr.length == 0 || i3 > bArr.length) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length - i3];
        for (int i4 = 0; i4 < bArr.length; i4++) {
            int i5 = bArr[i4] & 255;
            int i6 = (i2 >> 8) ^ i5;
            if (i4 >= i3) {
                bArr2[i4 - i3] = (byte) i6;
            }
            i2 = 65535 & (((i5 + i2) * 52845) + 22719);
        }
        return bArr2;
    }

    private byte[] hexToBinary(byte[] bArr) {
        int i2 = 0;
        for (byte b2 : bArr) {
            if (Character.digit((char) b2, 16) != -1) {
                i2++;
            }
        }
        byte[] bArr2 = new byte[i2 / 2];
        int i3 = 0;
        int i4 = -1;
        for (byte b3 : bArr) {
            int iDigit = Character.digit((char) b3, 16);
            if (iDigit != -1) {
                if (i4 == -1) {
                    i4 = iDigit;
                } else {
                    bArr2[i3] = (byte) ((i4 * 16) + iDigit);
                    i3++;
                    i4 = -1;
                }
            }
        }
        return bArr2;
    }

    private boolean isBinary(byte[] bArr) {
        if (bArr.length < 4) {
            return true;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            byte b2 = bArr[i2];
            if (b2 != 10 && b2 != 13 && b2 != 32 && b2 != 9 && Character.digit((char) b2, 16) == -1) {
                return true;
            }
        }
        return false;
    }

    private void parseASCII(byte[] bArr) throws IOException {
        Token tokenPeekToken;
        if (bArr.length == 0) {
            throw new IOException("ASCII segment of type 1 font is empty");
        }
        if (bArr.length >= 2) {
            if (bArr[0] == 37 || bArr[1] == 33) {
                Type1Lexer type1Lexer = new Type1Lexer(bArr);
                this.lexer = type1Lexer;
                if (type1Lexer.peekToken().getText().equals("FontDirectory")) {
                    Token.Kind kind = Token.NAME;
                    read(kind, "FontDirectory");
                    read(Token.LITERAL);
                    read(kind, "known");
                    Token.Kind kind2 = Token.START_PROC;
                    read(kind2);
                    readProcVoid();
                    read(kind2);
                    readProcVoid();
                    read(kind, "ifelse");
                }
                int iIntValue = read(Token.INTEGER).intValue();
                Token.Kind kind3 = Token.NAME;
                read(kind3, "dict");
                readMaybe(kind3, "dup");
                read(kind3, "begin");
                for (int i2 = 0; i2 < iIntValue && (tokenPeekToken = this.lexer.peekToken()) != null && (tokenPeekToken.getKind() != Token.NAME || (!tokenPeekToken.getText().equals("currentdict") && !tokenPeekToken.getText().equals("end"))); i2++) {
                    String text = read(Token.LITERAL).getText();
                    if (text.equals("FontInfo") || text.equals("Fontinfo")) {
                        readFontInfo(readSimpleDict());
                    } else if (text.equals("Metrics")) {
                        readSimpleDict();
                    } else if (text.equals("Encoding")) {
                        readEncoding();
                    } else {
                        readSimpleValue(text);
                    }
                }
                Token.Kind kind4 = Token.NAME;
                readMaybe(kind4, "currentdict");
                read(kind4, "end");
                read(kind4, "currentfile");
                read(kind4, "eexec");
                return;
            }
        }
        throw new IOException("Invalid start of ASCII segment of type 1 font");
    }

    private void parseBinary(byte[] bArr) throws IOException {
        int iIntValue = 4;
        Type1Lexer type1Lexer = new Type1Lexer(isBinary(bArr) ? decrypt(bArr, EEXEC_KEY, 4) : decrypt(hexToBinary(bArr), EEXEC_KEY, 4));
        this.lexer = type1Lexer;
        Token tokenPeekToken = type1Lexer.peekToken();
        while (tokenPeekToken != null && !tokenPeekToken.getText().equals(StandardStructureTypes.PRIVATE)) {
            this.lexer.nextToken();
            tokenPeekToken = this.lexer.peekToken();
        }
        if (tokenPeekToken == null) {
            throw new IOException("/Private token not found");
        }
        read(Token.LITERAL, StandardStructureTypes.PRIVATE);
        int iIntValue2 = read(Token.INTEGER).intValue();
        Token.Kind kind = Token.NAME;
        read(kind, "dict");
        readMaybe(kind, "dup");
        read(kind, "begin");
        for (int i2 = 0; i2 < iIntValue2 && this.lexer.peekToken() != null; i2++) {
            Token.Kind kind2 = this.lexer.peekToken().getKind();
            Token.Kind kind3 = Token.LITERAL;
            if (kind2 != kind3) {
                break;
            }
            String text = read(kind3).getText();
            if ("Subrs".equals(text)) {
                readSubrs(iIntValue);
            } else if ("OtherSubrs".equals(text)) {
                readOtherSubrs();
            } else if ("lenIV".equals(text)) {
                iIntValue = readDictValue().get(0).intValue();
            } else if ("ND".equals(text)) {
                read(Token.START_PROC);
                Token.Kind kind4 = Token.NAME;
                readMaybe(kind4, "noaccess");
                read(kind4, BaseParser.DEF);
                read(Token.END_PROC);
                readMaybe(kind4, "executeonly");
                readMaybe(kind4, "readonly");
                read(kind4, BaseParser.DEF);
            } else if ("NP".equals(text)) {
                read(Token.START_PROC);
                Token.Kind kind5 = Token.NAME;
                readMaybe(kind5, "noaccess");
                read(kind5);
                read(Token.END_PROC);
                readMaybe(kind5, "executeonly");
                readMaybe(kind5, "readonly");
                read(kind5, BaseParser.DEF);
            } else if ("RD".equals(text)) {
                read(Token.START_PROC);
                readProcVoid();
                Token.Kind kind6 = Token.NAME;
                readMaybe(kind6, "bind");
                readMaybe(kind6, "executeonly");
                readMaybe(kind6, "readonly");
                read(kind6, BaseParser.DEF);
            } else {
                readPrivate(text, readDictValue());
            }
        }
        while (true) {
            Token.Kind kind7 = this.lexer.peekToken().getKind();
            Token.Kind kind8 = Token.LITERAL;
            if (kind7 == kind8 && this.lexer.peekToken().getText().equals("CharStrings")) {
                read(kind8, "CharStrings");
                readCharStrings(iIntValue);
                return;
            }
            this.lexer.nextToken();
        }
    }

    private Token read(Token.Kind kind) throws IOException {
        Token tokenNextToken = this.lexer.nextToken();
        if (tokenNextToken != null && tokenNextToken.getKind() == kind) {
            return tokenNextToken;
        }
        throw new IOException("Found " + tokenNextToken + " but expected " + kind);
    }

    private void readCharStrings(int i2) throws IOException {
        int iIntValue = read(Token.INTEGER).intValue();
        Token.Kind kind = Token.NAME;
        read(kind, "dict");
        read(kind, "dup");
        read(kind, "begin");
        for (int i3 = 0; i3 < iIntValue && this.lexer.peekToken() != null && (this.lexer.peekToken().getKind() != Token.NAME || !this.lexer.peekToken().getText().equals("end")); i3++) {
            String text = read(Token.LITERAL).getText();
            read(Token.INTEGER);
            this.font.charstrings.put(text, decrypt(read(Token.CHARSTRING).getData(), CHARSTRING_KEY, i2));
            readDef();
        }
        read(Token.NAME, "end");
    }

    private void readDef() throws IOException {
        Token.Kind kind = Token.NAME;
        readMaybe(kind, "readonly");
        readMaybe(kind, "noaccess");
        Token token = read(kind);
        if (token.getText().equals("ND") || token.getText().equals("|-")) {
            return;
        }
        if (token.getText().equals("noaccess")) {
            token = read(kind);
        }
        if (token.getText().equals(BaseParser.DEF)) {
            return;
        }
        throw new IOException("Found " + token + " but expected ND");
    }

    private List<Token> readDictValue() throws IOException {
        List<Token> value = readValue();
        readDef();
        return value;
    }

    private void readEncoding() throws IOException {
        Token.Kind kind;
        Token.Kind kind2 = this.lexer.peekToken().getKind();
        Token.Kind kind3 = Token.NAME;
        if (kind2 == kind3) {
            String text = this.lexer.nextToken().getText();
            if (!text.equals("StandardEncoding")) {
                throw new IOException("Unknown encoding: " + text);
            }
            this.font.encoding = StandardEncoding.INSTANCE;
            readMaybe(kind3, "readonly");
            read(kind3, BaseParser.DEF);
            return;
        }
        read(Token.INTEGER).intValue();
        readMaybe(kind3, "array");
        while (true) {
            if (this.lexer.peekToken().getKind() == Token.NAME && (this.lexer.peekToken().getText().equals("dup") || this.lexer.peekToken().getText().equals("readonly") || this.lexer.peekToken().getText().equals(BaseParser.DEF))) {
                break;
            } else {
                this.lexer.nextToken();
            }
        }
        HashMap map = new HashMap();
        while (true) {
            Token.Kind kind4 = this.lexer.peekToken().getKind();
            kind = Token.NAME;
            if (kind4 != kind || !this.lexer.peekToken().getText().equals("dup")) {
                break;
            }
            read(kind, "dup");
            int iIntValue = read(Token.INTEGER).intValue();
            String text2 = read(Token.LITERAL).getText();
            read(kind, "put");
            map.put(Integer.valueOf(iIntValue), text2);
        }
        this.font.encoding = new BuiltInEncoding(map);
        readMaybe(kind, "readonly");
        read(kind, BaseParser.DEF);
    }

    private void readFontInfo(Map<String, List<Token>> map) {
        for (Map.Entry<String, List<Token>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<Token> value = entry.getValue();
            if (key.equals("version")) {
                this.font.version = value.get(0).getText();
            } else if (key.equals(AFMParser.NOTICE)) {
                this.font.notice = value.get(0).getText();
            } else if (key.equals(AFMParser.FULL_NAME)) {
                this.font.fullName = value.get(0).getText();
            } else if (key.equals(AFMParser.FAMILY_NAME)) {
                this.font.familyName = value.get(0).getText();
            } else if (key.equals(AFMParser.WEIGHT)) {
                this.font.weight = value.get(0).getText();
            } else if (key.equals(AFMParser.ITALIC_ANGLE)) {
                this.font.italicAngle = value.get(0).floatValue();
            } else if (key.equals("isFixedPitch")) {
                this.font.isFixedPitch = value.get(0).booleanValue();
            } else if (key.equals(AFMParser.UNDERLINE_POSITION)) {
                this.font.underlinePosition = value.get(0).floatValue();
            } else if (key.equals(AFMParser.UNDERLINE_THICKNESS)) {
                this.font.underlineThickness = value.get(0).floatValue();
            }
        }
    }

    private Token readMaybe(Token.Kind kind, String str) throws IOException {
        Token tokenPeekToken = this.lexer.peekToken();
        if (tokenPeekToken != null && tokenPeekToken.getKind() == kind && tokenPeekToken.getText().equals(str)) {
            return this.lexer.nextToken();
        }
        return null;
    }

    private void readOtherSubrs() throws IOException {
        if (this.lexer.peekToken().getKind() == Token.START_ARRAY) {
            readValue();
            readDef();
            return;
        }
        int iIntValue = read(Token.INTEGER).intValue();
        read(Token.NAME, "array");
        for (int i2 = 0; i2 < iIntValue; i2++) {
            read(Token.NAME, "dup");
            read(Token.INTEGER);
            readValue();
            readPut();
        }
        readDef();
    }

    private void readPostScriptWrapper(List<Token> list) throws IOException {
        if (this.lexer.peekToken().getText().equals("systemdict")) {
            Token.Kind kind = Token.NAME;
            read(kind, "systemdict");
            read(Token.LITERAL, "internaldict");
            read(kind, "known");
            Token.Kind kind2 = Token.START_PROC;
            read(kind2);
            readProcVoid();
            read(kind2);
            readProcVoid();
            read(kind, "ifelse");
            read(kind2);
            read(kind, "pop");
            list.clear();
            list.addAll(readValue());
            read(Token.END_PROC);
            read(kind, "if");
        }
    }

    private void readPrivate(String str, List<Token> list) throws IOException {
        if (str.equals("BlueValues")) {
            this.font.blueValues = arrayToNumbers(list);
            return;
        }
        if (str.equals("OtherBlues")) {
            this.font.otherBlues = arrayToNumbers(list);
            return;
        }
        if (str.equals("FamilyBlues")) {
            this.font.familyBlues = arrayToNumbers(list);
            return;
        }
        if (str.equals("FamilyOtherBlues")) {
            this.font.familyOtherBlues = arrayToNumbers(list);
            return;
        }
        if (str.equals("BlueScale")) {
            this.font.blueScale = list.get(0).floatValue();
            return;
        }
        if (str.equals("BlueShift")) {
            this.font.blueShift = list.get(0).intValue();
            return;
        }
        if (str.equals("BlueFuzz")) {
            this.font.blueFuzz = list.get(0).intValue();
            return;
        }
        if (str.equals(AFMParser.STD_HW)) {
            this.font.stdHW = arrayToNumbers(list);
            return;
        }
        if (str.equals(AFMParser.STD_VW)) {
            this.font.stdVW = arrayToNumbers(list);
            return;
        }
        if (str.equals("StemSnapH")) {
            this.font.stemSnapH = arrayToNumbers(list);
            return;
        }
        if (str.equals("StemSnapV")) {
            this.font.stemSnapV = arrayToNumbers(list);
        } else if (str.equals("ForceBold")) {
            this.font.forceBold = list.get(0).booleanValue();
        } else if (str.equals("LanguageGroup")) {
            this.font.languageGroup = list.get(0).intValue();
        }
    }

    private List<Token> readProc() throws IOException {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        while (true) {
            if (this.lexer.peekToken().getKind() == Token.START_PROC) {
                i2++;
            }
            Token tokenNextToken = this.lexer.nextToken();
            arrayList.add(tokenNextToken);
            if (tokenNextToken.getKind() == Token.END_PROC && i2 - 1 == 0) {
                break;
            }
        }
        Token maybe = readMaybe(Token.NAME, "executeonly");
        if (maybe != null) {
            arrayList.add(maybe);
        }
        return arrayList;
    }

    private void readProcVoid() throws IOException {
        int i2 = 1;
        while (true) {
            if (this.lexer.peekToken().getKind() == Token.START_PROC) {
                i2++;
            }
            if (this.lexer.nextToken().getKind() == Token.END_PROC && i2 - 1 == 0) {
                readMaybe(Token.NAME, "executeonly");
                return;
            }
        }
    }

    private void readPut() throws IOException {
        Token.Kind kind = Token.NAME;
        readMaybe(kind, "readonly");
        Token token = read(kind);
        if (token.getText().equals("NP") || token.getText().equals("|")) {
            return;
        }
        if (token.getText().equals("noaccess")) {
            token = read(kind);
        }
        if (token.getText().equals("put")) {
            return;
        }
        throw new IOException("Found " + token + " but expected NP");
    }

    private Map<String, List<Token>> readSimpleDict() throws IOException {
        HashMap map = new HashMap();
        int iIntValue = read(Token.INTEGER).intValue();
        Token.Kind kind = Token.NAME;
        read(kind, "dict");
        readMaybe(kind, "dup");
        read(kind, "begin");
        for (int i2 = 0; i2 < iIntValue && this.lexer.peekToken() != null; i2++) {
            Token.Kind kind2 = this.lexer.peekToken().getKind();
            Token.Kind kind3 = Token.NAME;
            if (kind2 == kind3 && !this.lexer.peekToken().getText().equals("end")) {
                read(kind3);
            }
            if (this.lexer.peekToken() == null || (this.lexer.peekToken().getKind() == kind3 && this.lexer.peekToken().getText().equals("end"))) {
                break;
            }
            map.put(read(Token.LITERAL).getText(), readDictValue());
        }
        Token.Kind kind4 = Token.NAME;
        read(kind4, "end");
        readMaybe(kind4, "readonly");
        read(kind4, BaseParser.DEF);
        return map;
    }

    private void readSimpleValue(String str) throws IOException {
        List<Token> dictValue = readDictValue();
        if (str.equals(AFMParser.FONT_NAME)) {
            this.font.fontName = dictValue.get(0).getText();
            return;
        }
        if (str.equals("PaintType")) {
            this.font.paintType = dictValue.get(0).intValue();
            return;
        }
        if (str.equals("FontType")) {
            this.font.fontType = dictValue.get(0).intValue();
            return;
        }
        if (str.equals("FontMatrix")) {
            this.font.fontMatrix = arrayToNumbers(dictValue);
            return;
        }
        if (str.equals(AFMParser.FONT_BBOX)) {
            this.font.fontBBox = arrayToNumbers(dictValue);
            return;
        }
        if (str.equals("UniqueID")) {
            this.font.uniqueID = dictValue.get(0).intValue();
        } else if (str.equals("StrokeWidth")) {
            this.font.strokeWidth = dictValue.get(0).floatValue();
        } else if (str.equals("FID")) {
            this.font.fontID = dictValue.get(0).getText();
        }
    }

    private void readSubrs(int i2) throws IOException {
        int iIntValue = read(Token.INTEGER).intValue();
        for (int i3 = 0; i3 < iIntValue; i3++) {
            this.font.subrs.add(null);
        }
        read(Token.NAME, "array");
        for (int i4 = 0; i4 < iIntValue && this.lexer.peekToken() != null; i4++) {
            Token.Kind kind = this.lexer.peekToken().getKind();
            Token.Kind kind2 = Token.NAME;
            if (kind != kind2 || !this.lexer.peekToken().getText().equals("dup")) {
                break;
            }
            read(kind2, "dup");
            Token.Kind kind3 = Token.INTEGER;
            Token token = read(kind3);
            read(kind3);
            this.font.subrs.set(token.intValue(), decrypt(read(Token.CHARSTRING).getData(), CHARSTRING_KEY, i2));
            readPut();
        }
        readDef();
    }

    private List<Token> readValue() throws IOException {
        ArrayList arrayList = new ArrayList();
        Token tokenNextToken = this.lexer.nextToken();
        if (this.lexer.peekToken() == null) {
            return arrayList;
        }
        arrayList.add(tokenNextToken);
        if (tokenNextToken.getKind() == Token.START_ARRAY) {
            int i2 = 1;
            while (this.lexer.peekToken() != null) {
                if (this.lexer.peekToken().getKind() == Token.START_ARRAY) {
                    i2++;
                }
                Token tokenNextToken2 = this.lexer.nextToken();
                arrayList.add(tokenNextToken2);
                if (tokenNextToken2.getKind() != Token.END_ARRAY || i2 - 1 != 0) {
                }
            }
            return arrayList;
        }
        if (tokenNextToken.getKind() == Token.START_PROC) {
            arrayList.addAll(readProc());
        } else if (tokenNextToken.getKind() == Token.START_DICT) {
            read(Token.END_DICT);
            return arrayList;
        }
        readPostScriptWrapper(arrayList);
        return arrayList;
    }

    public Type1Font parse(byte[] bArr, byte[] bArr2) throws IOException {
        this.font = new Type1Font(bArr, bArr2);
        parseASCII(bArr);
        if (bArr2.length > 0) {
            parseBinary(bArr2);
        }
        return this.font;
    }

    private void read(Token.Kind kind, String str) throws IOException {
        Token token = read(kind);
        if (token.getText().equals(str)) {
            return;
        }
        throw new IOException("Found " + token + " but expected " + str);
    }
}
