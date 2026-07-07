package cn.com.heaton.blelibrary.ble.proxy;

import android.content.Context;
import cn.com.heaton.blelibrary.ble.L;
import cn.com.heaton.blelibrary.ble.request.AdvertiserRequest;
import cn.com.heaton.blelibrary.ble.request.ConnectRequest;
import cn.com.heaton.blelibrary.ble.request.MtuRequest;
import cn.com.heaton.blelibrary.ble.request.NotifyRequest;
import cn.com.heaton.blelibrary.ble.request.ReadRequest;
import cn.com.heaton.blelibrary.ble.request.ReadRssiRequest;
import cn.com.heaton.blelibrary.ble.request.Rproxy;
import cn.com.heaton.blelibrary.ble.request.ScanRequest;
import cn.com.heaton.blelibrary.ble.request.WriteRequest;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes.dex */
public class RequestProxy implements InvocationHandler {
    private static final String TAG = "RequestProxy";
    private static RequestProxy instance = new RequestProxy();
    private Object receiver;

    public static RequestProxy getInstance() {
        return instance;
    }

    public Object bindProxy(Context context, Object obj) {
        this.receiver = obj;
        L.e(TAG, "bindProxy: Binding agent successfully");
        Rproxy.getInstance().init(AdvertiserRequest.class, ConnectRequest.class, MtuRequest.class, NotifyRequest.class, ReadRequest.class, ReadRssiRequest.class, ScanRequest.class, WriteRequest.class);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        return method.invoke(this.receiver, objArr);
    }
}
