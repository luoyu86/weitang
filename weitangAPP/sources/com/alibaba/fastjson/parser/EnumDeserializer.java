package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class EnumDeserializer implements ObjectDeserializer {
    private final Class<?> enumClass;
    public long[] enumNameHashCodes;
    public final Enum[] enums;
    public final Enum[] ordinalEnums;

    public EnumDeserializer(Class<?> cls) {
        this.enumClass = cls;
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        this.ordinalEnums = enumArr;
        int length = enumArr.length;
        long[] jArr = new long[length];
        this.enumNameHashCodes = new long[enumArr.length];
        int i2 = 0;
        while (true) {
            Enum[] enumArr2 = this.ordinalEnums;
            if (i2 >= enumArr2.length) {
                break;
            }
            String strName = enumArr2[i2].name();
            long jCharAt = -3750763034362895579L;
            for (int i3 = 0; i3 < strName.length(); i3++) {
                jCharAt = (jCharAt ^ ((long) strName.charAt(i3))) * 1099511628211L;
            }
            jArr[i2] = jCharAt;
            this.enumNameHashCodes[i2] = jCharAt;
            i2++;
        }
        Arrays.sort(this.enumNameHashCodes);
        this.enums = new Enum[this.ordinalEnums.length];
        for (int i4 = 0; i4 < this.enumNameHashCodes.length; i4++) {
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                if (this.enumNameHashCodes[i4] == jArr[i5]) {
                    this.enums[i4] = this.ordinalEnums[i5];
                    break;
                }
                i5++;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i2 = jSONLexer.token;
            if (i2 == 2) {
                int iIntValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                if (iIntValue >= 0) {
                    Object[] objArr = this.ordinalEnums;
                    if (iIntValue <= objArr.length) {
                        return (T) objArr[iIntValue];
                    }
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + iIntValue);
            }
            if (i2 != 4) {
                if (i2 == 8) {
                    jSONLexer.nextToken(16);
                    return null;
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + defaultJSONParser.parse());
            }
            String strStringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (strStringVal.length() == 0) {
                return null;
            }
            long jCharAt = -3750763034362895579L;
            for (int i3 = 0; i3 < strStringVal.length(); i3++) {
                jCharAt = (jCharAt ^ ((long) strStringVal.charAt(i3))) * 1099511628211L;
            }
            int iBinarySearch = Arrays.binarySearch(this.enumNameHashCodes, jCharAt);
            if (iBinarySearch < 0) {
                return null;
            }
            return (T) this.enums[iBinarySearch];
        } catch (JSONException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new JSONException(e3.getMessage(), e3);
        }
    }
}
