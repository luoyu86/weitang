package com.qq.e.ads.nativ;

import android.content.Context;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.adevent.AdEventType;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NativeExpressAD extends NativeAbstractAD<NEADI> implements IReward {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f9592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile int f9593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<Integer> f9594h = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VideoOption f9595i;
    public ADSize j;
    public NativeExpressADListener k;
    public final ADListenerAdapter l;
    public LoadAdParams m;
    public volatile ServerSideVerificationOptions n;

    public static class ADListenerAdapter implements ADListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NativeExpressADListener f9596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public NativeExpressMediaListener f9597b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public NegativeFeedbackListener f9598c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ADRewardListener f9599d;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            this.f9596a = nativeExpressADListener;
        }

        public ADListenerAdapter(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f9597b = nativeExpressMediaListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (NativeExpressAD.e(this.f9596a, aDEvent) || NativeExpressAD.f(this.f9597b, aDEvent) || NativeExpressAD.h(this.f9598c, aDEvent)) {
                return;
            }
            NativeExpressAD.g(this.f9599d, aDEvent);
        }

        public void setAdRewardListener(ADRewardListener aDRewardListener) {
            this.f9599d = aDRewardListener;
        }

        public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f9597b = nativeExpressMediaListener;
        }

        public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
            this.f9598c = negativeFeedbackListener;
        }
    }

    public interface NativeExpressADListener extends NativeAbstractAD.BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        void onRenderFail(NativeExpressADView nativeExpressADView);

        void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener) {
        this.k = nativeExpressADListener;
        this.l = new ADListenerAdapter(nativeExpressADListener);
        if (d(aDSize)) {
            return;
        }
        a(context, str);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener, String str2) {
        this.k = nativeExpressADListener;
        this.l = new ADListenerAdapter(nativeExpressADListener);
        if (d(aDSize)) {
            return;
        }
        a(context, str, str2);
    }

    public static boolean e(NativeExpressADListener nativeExpressADListener, ADEvent aDEvent) {
        if (nativeExpressADListener != null) {
            int type = aDEvent.getType();
            if (type == 100) {
                List<NativeExpressADView> list = (List) aDEvent.getParam(List.class);
                if (list != null) {
                    nativeExpressADListener.onADLoaded(list);
                }
            } else if (type == 101) {
                Integer num = (Integer) aDEvent.getParam(Integer.class);
                if (num != null) {
                    nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                }
            } else if (type == 103) {
                NativeExpressADView nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView != null) {
                    nativeExpressADListener.onADExposure(nativeExpressADView);
                }
            } else if (type == 303) {
                NativeExpressADView nativeExpressADView2 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView2 != null) {
                    nativeExpressADListener.onADLeftApplication(nativeExpressADView2);
                }
            } else if (type == 105) {
                NativeExpressADView nativeExpressADView3 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView3 != null) {
                    nativeExpressADListener.onADClicked(nativeExpressADView3);
                }
            } else if (type == 106) {
                NativeExpressADView nativeExpressADView4 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView4 != null) {
                    nativeExpressADListener.onADClosed(nativeExpressADView4);
                    nativeExpressADView4.negativeFeedback();
                }
            } else if (type == 109) {
                NativeExpressADView nativeExpressADView5 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView5 != null) {
                    nativeExpressADListener.onRenderSuccess(nativeExpressADView5);
                }
            } else if (type == 110) {
                NativeExpressADView nativeExpressADView6 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView6 != null) {
                    nativeExpressADListener.onRenderFail(nativeExpressADView6);
                }
            }
            return true;
        }
        return false;
    }

    public static boolean f(NativeExpressMediaListener nativeExpressMediaListener, ADEvent aDEvent) {
        NativeExpressADView nativeExpressADView;
        if (nativeExpressMediaListener != null && (nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class)) != null) {
            int type = aDEvent.getType();
            if (type == 201) {
                nativeExpressMediaListener.onVideoCached(nativeExpressADView);
                return true;
            }
            if (type == 202) {
                nativeExpressMediaListener.onVideoStart(nativeExpressADView);
                return true;
            }
            if (type == 204) {
                nativeExpressMediaListener.onVideoPause(nativeExpressADView);
                return true;
            }
            if (type == 206) {
                nativeExpressMediaListener.onVideoComplete(nativeExpressADView);
                return true;
            }
            if (type == 207) {
                Integer num = (Integer) aDEvent.getParam(1, Integer.class);
                if (num == null) {
                    return true;
                }
                nativeExpressMediaListener.onVideoError(nativeExpressADView, AdErrorConvertor.formatErrorCode(num.intValue()));
                return true;
            }
            if (type == 301) {
                nativeExpressMediaListener.onVideoPageOpen(nativeExpressADView);
                return true;
            }
            if (type == 302) {
                nativeExpressMediaListener.onVideoPageClose(nativeExpressADView);
                return true;
            }
            switch (type) {
                case AdEventType.VIDEO_INIT /* 209 */:
                    nativeExpressMediaListener.onVideoInit(nativeExpressADView);
                    break;
                case AdEventType.VIDEO_READY /* 210 */:
                    if (((Integer) aDEvent.getParam(1, Integer.class)) != null) {
                        nativeExpressMediaListener.onVideoReady(nativeExpressADView, r6.intValue());
                    }
                    break;
                case AdEventType.VIDEO_LOADING /* 211 */:
                    nativeExpressMediaListener.onVideoLoading(nativeExpressADView);
                    break;
            }
            return true;
        }
        return false;
    }

    public static boolean g(ADRewardListener aDRewardListener, ADEvent aDEvent) {
        if (aDRewardListener == null || aDEvent.getType() != 104) {
            return false;
        }
        String str = (String) aDEvent.getParam(String.class);
        if (str != null) {
            HashMap map = new HashMap();
            map.put("transId", str);
            aDRewardListener.onReward(map);
        }
        return true;
    }

    public static boolean h(NegativeFeedbackListener negativeFeedbackListener, ADEvent aDEvent) {
        if (negativeFeedbackListener == null || aDEvent.getType() != 304) {
            return false;
        }
        negativeFeedbackListener.onComplainSuccess();
        return true;
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeExpressADDelegate(context, this.j, str, str2, str3, this.l);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        NativeExpressADListener nativeExpressADListener = this.k;
        if (nativeExpressADListener != null) {
            nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public final boolean d(ADSize aDSize) {
        if (aDSize != null) {
            this.j = aDSize;
            return false;
        }
        GDTLogger.e("初始化错误：参数adSize不能为空");
        a(ErrorCode.INIT_ERROR);
        return true;
    }

    public String getAdNetWorkName() {
        T t = this.f9515a;
        if (t != 0) {
            return ((NEADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadAD(int i2) {
        loadAD(i2, null);
    }

    public void loadAD(int i2, LoadAdParams loadAdParams) {
        if (a()) {
            if (loadAdParams != null) {
                setAdParams(loadAdParams);
            }
            if (!b()) {
                synchronized (this.f9594h) {
                    this.f9594h.add(Integer.valueOf(i2));
                }
                return;
            }
            T t = this.f9515a;
            if (t == 0) {
                a("loadAD");
                return;
            }
            LoadAdParams loadAdParams2 = this.m;
            NEADI neadi = (NEADI) t;
            if (loadAdParams2 != null) {
                neadi.loadAd(i2, loadAdParams2);
            } else {
                neadi.loadAd(i2);
            }
        }
    }

    public void setAdParams(LoadAdParams loadAdParams) {
        this.m = loadAdParams;
    }

    public void setMaxVideoDuration(int i2) {
        this.f9593g = i2;
        if (this.f9593g > 0 && this.f9592f > this.f9593g) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.f9515a;
        if (t != 0) {
            ((NEADI) t).setMaxVideoDuration(this.f9593g);
        }
    }

    public void setMinVideoDuration(int i2) {
        this.f9592f = i2;
        if (this.f9593g > 0 && this.f9592f > this.f9593g) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.f9515a;
        if (t != 0) {
            ((NEADI) t).setMinVideoDuration(this.f9592f);
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.l.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.n = serverSideVerificationOptions;
        T t = this.f9515a;
        if (t != 0) {
            ((NEADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f9595i = videoOption;
        T t = this.f9515a;
        if (t == 0 || videoOption == null) {
            return;
        }
        ((NEADI) t).setVideoOption(videoOption);
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        NEADI neadi = (NEADI) obj;
        neadi.setMinVideoDuration(this.f9592f);
        neadi.setMaxVideoDuration(this.f9593g);
        ((NEADI) this.f9515a).setServerSideVerificationOptions(this.n);
        VideoOption videoOption = this.f9595i;
        if (videoOption != null) {
            setVideoOption(videoOption);
        }
        synchronized (this.f9594h) {
            Iterator<Integer> it = this.f9594h.iterator();
            while (it.hasNext()) {
                T t = this.f9515a;
                if (t != 0) {
                    if (this.m != null) {
                        ((NEADI) t).loadAd(it.next().intValue(), this.m);
                    } else {
                        ((NEADI) t).loadAd(it.next().intValue());
                    }
                }
            }
        }
    }
}
