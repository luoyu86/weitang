package com.sun.mail.util;

import java.util.Properties;
import javax.mail.Session;

/* JADX INFO: loaded from: classes2.dex */
public class PropUtil {
    private PropUtil() {
    }

    private static boolean getBoolean(Object obj, boolean z) {
        return obj == null ? z : obj instanceof String ? z ? !((String) obj).equalsIgnoreCase("false") : ((String) obj).equalsIgnoreCase("true") : obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    public static boolean getBooleanProperty(Properties properties, String str, boolean z) {
        return getBoolean(getProp(properties, str), z);
    }

    @Deprecated
    public static boolean getBooleanSessionProperty(Session session, String str, boolean z) {
        return getBoolean(getProp(session.getProperties(), str), z);
    }

    public static boolean getBooleanSystemProperty(String str, boolean z) {
        try {
            try {
                return getBoolean(getProp(System.getProperties(), str), z);
            } catch (SecurityException unused) {
                String property = System.getProperty(str);
                return property == null ? z : z ? !property.equalsIgnoreCase("false") : property.equalsIgnoreCase("true");
            }
        } catch (SecurityException unused2) {
            return z;
        }
    }

    private static int getInt(Object obj, int i2) {
        if (obj == null) {
            return i2;
        }
        if (obj instanceof String) {
            try {
                String str = (String) obj;
                return str.startsWith("0x") ? Integer.parseInt(str.substring(2), 16) : Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
        }
        return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
    }

    public static int getIntProperty(Properties properties, String str, int i2) {
        return getInt(getProp(properties, str), i2);
    }

    @Deprecated
    public static int getIntSessionProperty(Session session, String str, int i2) {
        return getInt(getProp(session.getProperties(), str), i2);
    }

    private static Object getProp(Properties properties, String str) {
        Object obj = properties.get(str);
        return obj != null ? obj : properties.getProperty(str);
    }
}
