package com.tom_roush.pdfbox.pdmodel.encryption;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class SecurityHandlerFactory {
    public static final SecurityHandlerFactory INSTANCE = new SecurityHandlerFactory();
    private final Map<String, Class<? extends SecurityHandler>> nameToHandler = new HashMap();
    private final Map<Class<? extends ProtectionPolicy>, Class<? extends SecurityHandler>> policyToHandler = new HashMap();

    private SecurityHandlerFactory() {
        registerHandler("Standard", StandardSecurityHandler.class, StandardProtectionPolicy.class);
        registerHandler(PublicKeySecurityHandler.FILTER, PublicKeySecurityHandler.class, PublicKeyProtectionPolicy.class);
    }

    private SecurityHandler newSecurityHandler(Class<? extends SecurityHandler> cls, Class<?>[] clsArr, Object[] objArr) {
        try {
            return cls.getDeclaredConstructor(clsArr).newInstance(objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    public SecurityHandler newSecurityHandlerForFilter(String str) {
        Class<? extends SecurityHandler> cls = this.nameToHandler.get(str);
        if (cls == null) {
            return null;
        }
        return newSecurityHandler(cls, new Class[0], new Object[0]);
    }

    public SecurityHandler newSecurityHandlerForPolicy(ProtectionPolicy protectionPolicy) {
        Class<? extends SecurityHandler> cls = this.policyToHandler.get(protectionPolicy.getClass());
        if (cls == null) {
            return null;
        }
        return newSecurityHandler(cls, new Class[]{protectionPolicy.getClass()}, new Object[]{protectionPolicy});
    }

    public void registerHandler(String str, Class<? extends SecurityHandler> cls, Class<? extends ProtectionPolicy> cls2) {
        if (this.nameToHandler.containsKey(str)) {
            throw new IllegalStateException("The security handler name is already registered");
        }
        this.nameToHandler.put(str, cls);
        this.policyToHandler.put(cls2, cls);
    }
}
