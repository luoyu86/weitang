package com.tom_roush.pdfbox.pdmodel.encryption;

import g.a.f.c.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.Provider;
import java.security.Security;

/* JADX INFO: loaded from: classes2.dex */
public class SecurityProvider {
    private static Provider provider;

    private SecurityProvider() {
    }

    public static Provider getProvider() throws IOException {
        if (provider == null) {
            try {
                Security.removeProvider(a.PROVIDER_NAME);
                Security.addProvider(new a());
                provider = (Provider) Class.forName("g.a.f.c.a").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e2) {
                throw new IOException(e2);
            } catch (IllegalAccessException e3) {
                throw new IOException(e3);
            } catch (InstantiationException e4) {
                throw new IOException(e4);
            } catch (NoSuchMethodException e5) {
                throw new IOException(e5);
            } catch (InvocationTargetException e6) {
                throw new IOException(e6);
            }
        }
        return provider;
    }

    public static void setProvider(Provider provider2) {
        provider = provider2;
    }
}
