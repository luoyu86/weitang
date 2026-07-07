package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public class MapDeserializer implements ObjectDeserializer {
    public static MapDeserializer instance = new MapDeserializer();

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0127, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map parseMap(com.alibaba.fastjson.parser.DefaultJSONParser r9, java.util.Map<java.lang.String, java.lang.Object> r10, java.lang.reflect.Type r11, java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.MapDeserializer.parseMap(com.alibaba.fastjson.parser.DefaultJSONParser, java.util.Map, java.lang.reflect.Type, java.lang.Object):java.util.Map");
    }

    public Map<?, ?> createMap(Type type) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class || type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type == JSONObject.class) {
            return new JSONObject();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return EnumMap.class.equals(rawType) ? new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]) : createMap(rawType);
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            throw new JSONException("unsupport type " + type);
        }
        try {
            return (Map) cls.newInstance();
        } catch (Exception e2) {
            throw new JSONException("unsupport type " + type, e2);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == JSONObject.class && defaultJSONParser.fieldTypeResolver == null) {
            return (T) defaultJSONParser.parseObject();
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        Map<?, ?> mapCreateMap = createMap(type);
        ParseContext parseContext = defaultJSONParser.contex;
        try {
            defaultJSONParser.setContext(parseContext, mapCreateMap, obj);
            if (!(type instanceof ParameterizedType)) {
                return (T) defaultJSONParser.parseObject(mapCreateMap, obj);
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            return String.class == type2 ? (T) parseMap(defaultJSONParser, mapCreateMap, type3, obj) : (T) parseMap(defaultJSONParser, mapCreateMap, type2, type3, obj);
        } finally {
            defaultJSONParser.setContext(parseContext);
        }
    }

    public static Object parseMap(DefaultJSONParser defaultJSONParser, Map<Object, Object> map, Type type, Type type2, Object obj) {
        Object obj2;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i2 = jSONLexer.token;
        int i3 = 16;
        if (i2 != 12 && i2 != 16) {
            throw new JSONException("syntax error, expect {, actual " + JSONToken.name(i2));
        }
        ObjectDeserializer deserializer = defaultJSONParser.config.getDeserializer(type);
        ObjectDeserializer deserializer2 = defaultJSONParser.config.getDeserializer(type2);
        jSONLexer.nextToken();
        ParseContext parseContext = defaultJSONParser.contex;
        while (true) {
            try {
                int i4 = jSONLexer.token;
                if (i4 == 13) {
                    jSONLexer.nextToken(i3);
                    return map;
                }
                if (i4 == 4 && jSONLexer.sp == 4 && jSONLexer.text.startsWith("$ref", jSONLexer.np + 1) && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextTokenWithChar(':');
                    if (jSONLexer.token == 4) {
                        String strStringVal = jSONLexer.stringVal();
                        if ("..".equals(strStringVal)) {
                            obj2 = parseContext.parent.object;
                        } else if ("$".equals(strStringVal)) {
                            ParseContext parseContext2 = parseContext;
                            while (true) {
                                ParseContext parseContext3 = parseContext2.parent;
                                if (parseContext3 == null) {
                                    break;
                                }
                                parseContext2 = parseContext3;
                            }
                            obj2 = parseContext2.object;
                        } else {
                            defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext, strStringVal));
                            defaultJSONParser.resolveStatus = 1;
                            obj2 = null;
                        }
                        jSONLexer.nextToken(13);
                        if (jSONLexer.token == 13) {
                            jSONLexer.nextToken(16);
                            return obj2;
                        }
                        throw new JSONException("illegal ref");
                    }
                    throw new JSONException("illegal ref, " + JSONToken.name(i4));
                }
                if (map.size() == 0 && i4 == 4 && JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal()) && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextTokenWithChar(':');
                    jSONLexer.nextToken(16);
                    if (jSONLexer.token == 13) {
                        jSONLexer.nextToken();
                        return map;
                    }
                    jSONLexer.nextToken();
                }
                Object objDeserialze = deserializer.deserialze(defaultJSONParser, type, null);
                if (jSONLexer.token == 17) {
                    jSONLexer.nextToken();
                    Object objDeserialze2 = deserializer2.deserialze(defaultJSONParser, type2, objDeserialze);
                    if (defaultJSONParser.resolveStatus == 1) {
                        defaultJSONParser.checkMapResolve(map, objDeserialze);
                    }
                    map.put(objDeserialze, objDeserialze2);
                    if (jSONLexer.token == 16) {
                        jSONLexer.nextToken();
                    }
                    i3 = 16;
                } else {
                    throw new JSONException("syntax error, expect :, actual " + jSONLexer.token);
                }
            } finally {
                defaultJSONParser.setContext(parseContext);
            }
        }
    }
}
