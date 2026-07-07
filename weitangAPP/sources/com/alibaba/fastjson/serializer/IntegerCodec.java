package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class IntegerCodec implements ObjectSerializer, ObjectDeserializer {
    public static IntegerCodec instance = new IntegerCodec();

    private IntegerCodec() {
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i2 = jSONLexer.token();
        if (i2 == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        if (i2 == 2) {
            if (type == Long.TYPE || type == Long.class) {
                t = (T) Long.valueOf(jSONLexer.longValue());
            } else {
                try {
                    t = (T) Integer.valueOf(jSONLexer.intValue());
                } catch (NumberFormatException e2) {
                    throw new JSONException("int value overflow, field : " + obj, e2);
                }
            }
            jSONLexer.nextToken(16);
            return t;
        }
        if (i2 == 3) {
            BigDecimal bigDecimalDecimalValue = jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return (type == Long.TYPE || type == Long.class) ? (T) Long.valueOf(bigDecimalDecimalValue.longValueExact()) : (T) Integer.valueOf(bigDecimalDecimalValue.intValueExact());
        }
        T t2 = (T) defaultJSONParser.parse();
        try {
            t2 = (type == Long.TYPE || type == Long.class) ? (T) TypeUtils.castToLong(t2) : (T) TypeUtils.castToInt(t2);
            return t2;
        } catch (Exception e3) {
            throw new JSONException("cast error, field : " + obj + ", value " + t2, e3);
        }
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Number number = (Number) obj;
        if (number == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
                serializeWriter.write(48);
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        if (obj instanceof Long) {
            serializeWriter.writeLong(number.longValue());
        } else {
            serializeWriter.writeInt(number.intValue());
        }
        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
            Class<?> cls = number.getClass();
            if (cls == Byte.class) {
                serializeWriter.write(66);
                return;
            }
            if (cls == Short.class) {
                serializeWriter.write(83);
                return;
            }
            if (cls == Long.class) {
                long jLongValue = number.longValue();
                if (jLongValue > 2147483647L || jLongValue < -2147483648L || type == Long.class) {
                    return;
                }
                serializeWriter.write(76);
            }
        }
    }
}
