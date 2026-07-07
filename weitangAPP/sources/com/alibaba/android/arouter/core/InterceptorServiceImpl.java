package com.alibaba.android.arouter.core;

import android.content.Context;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.thread.CancelableCountDownLatch;
import com.alibaba.android.arouter.utils.MapUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@Route(path = "/arouter/service/interceptor")
public class InterceptorServiceImpl implements InterceptorService {
    private static boolean interceptorHasInit;
    private static final Object interceptorInitLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    public static void _excute(final int i2, final CancelableCountDownLatch cancelableCountDownLatch, final Postcard postcard) {
        if (i2 < Warehouse.interceptors.size()) {
            Warehouse.interceptors.get(i2).process(postcard, new InterceptorCallback() { // from class: com.alibaba.android.arouter.core.InterceptorServiceImpl.2
                @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
                public void onContinue(Postcard postcard2) {
                    cancelableCountDownLatch.countDown();
                    InterceptorServiceImpl._excute(i2 + 1, cancelableCountDownLatch, postcard2);
                }

                @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
                public void onInterrupt(Throwable th) {
                    postcard.setTag(th == null ? new HandlerException("No message.") : th.getMessage());
                    cancelableCountDownLatch.cancel();
                }
            });
        }
    }

    private static void checkInterceptorsInitStatus() {
        synchronized (interceptorInitLock) {
            while (!interceptorHasInit) {
                try {
                    interceptorInitLock.wait(10000L);
                } catch (InterruptedException e2) {
                    throw new HandlerException("ARouter::Interceptor init cost too much time error! reason = [" + e2.getMessage() + "]");
                }
            }
        }
    }

    @Override // com.alibaba.android.arouter.facade.service.InterceptorService
    public void doInterceptions(final Postcard postcard, final InterceptorCallback interceptorCallback) {
        List<IInterceptor> list = Warehouse.interceptors;
        if (list == null || list.size() <= 0) {
            interceptorCallback.onContinue(postcard);
            return;
        }
        checkInterceptorsInitStatus();
        if (interceptorHasInit) {
            LogisticsCenter.executor.execute(new Runnable() { // from class: com.alibaba.android.arouter.core.InterceptorServiceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    CancelableCountDownLatch cancelableCountDownLatch = new CancelableCountDownLatch(Warehouse.interceptors.size());
                    try {
                        InterceptorServiceImpl._excute(0, cancelableCountDownLatch, postcard);
                        cancelableCountDownLatch.await(postcard.getTimeout(), TimeUnit.SECONDS);
                        if (cancelableCountDownLatch.getCount() > 0) {
                            interceptorCallback.onInterrupt(new HandlerException("The interceptor processing timed out."));
                        } else if (postcard.getTag() != null) {
                            interceptorCallback.onInterrupt(new HandlerException(postcard.getTag().toString()));
                        } else {
                            interceptorCallback.onContinue(postcard);
                        }
                    } catch (Exception e2) {
                        interceptorCallback.onInterrupt(e2);
                    }
                }
            });
        } else {
            interceptorCallback.onInterrupt(new HandlerException("Interceptors initialization takes too much time."));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(final Context context) {
        LogisticsCenter.executor.execute(new Runnable() { // from class: com.alibaba.android.arouter.core.InterceptorServiceImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (MapUtils.isNotEmpty(Warehouse.interceptorsIndex)) {
                    Iterator<Map.Entry<Integer, Class<? extends IInterceptor>>> it = Warehouse.interceptorsIndex.entrySet().iterator();
                    while (it.hasNext()) {
                        Class<? extends IInterceptor> value = it.next().getValue();
                        try {
                            IInterceptor iInterceptorNewInstance = value.getConstructor(new Class[0]).newInstance(new Object[0]);
                            iInterceptorNewInstance.init(context);
                            Warehouse.interceptors.add(iInterceptorNewInstance);
                        } catch (Exception e2) {
                            throw new HandlerException("ARouter::ARouter init interceptor error! name = [" + value.getName() + "], reason = [" + e2.getMessage() + "]");
                        }
                    }
                    boolean unused = InterceptorServiceImpl.interceptorHasInit = true;
                    ARouter.logger.info("ARouter::", "ARouter interceptors init over.");
                    synchronized (InterceptorServiceImpl.interceptorInitLock) {
                        InterceptorServiceImpl.interceptorInitLock.notifyAll();
                    }
                }
            }
        });
    }
}
