package cn.admobiletop.adsuyi.config;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiConfig {
    public static final String KEY_SP_CLICK = "sp_click";
    public static final long MIN_TIMEOUT = 3000;
    public static final String TEST_APP_ID = "3801556";

    public interface ContentSizeType {
        public static final int INTERSTITIAL_FULL_SCREEN = 2;
        public static final int INTERSTITIAL_HALF_SCREEN = 1;
    }

    public interface DeviceType {
        public static final int BOX = 7;
        public static final int PHONE = 4;
        public static final int TABLET = 5;
    }

    public interface DownloadTip {
        public static final int DOWNLOAD_TIP_ALL = 2;
        public static final int DOWNLOAD_TIP_MOBILE_TRAFFIC = 1;
        public static final int DOWNLOAD_TIP_NOTHING = 0;
    }

    public interface Position {
        public static final int L_B = 1;
        public static final int L_T = 0;
        public static final int R_B = 3;
        public static final int R_T = 2;
    }

    public interface RenderType {
        public static final int RENDER_TYPE_INTERSTITIAL_EXPRESS = 1;
        public static final int RENDER_TYPE_INTERSTITIAL_EXPRESS_2 = 3;
        public static final int RENDER_TYPE_NATIVE = 2;
        public static final int RENDER_TYPE_NATIVE_EXPRESS = 1;
        public static final int RENDER_TYPE_NATIVE_EXPRESS_2 = 3;
        public static final int RENDER_TYPE_NATIVE_EXPRESS_RENDER_SPLASH = 5;
        public static final int RENDER_TYPE_REWARD_VOD = 1;
        public static final int RENDER_TYPE_REWARD_VOD_EXPRESS = 3;
        public static final int RENDER_TYPE_SPLASH_EXPRESS = 1;
        public static final int RENDER_TYPE_SPLASH_SINCE_RENDER = 2;
        public static final int RENDER_TYPE_SPLASH_V_PLUS = 4;
    }

    public interface RequestMode {
        public static final String PARALLEL = "PARALLEL";
        public static final String SERIAL = "SERIAL";
    }

    public interface ScreenOrientation {
        public static final int SCREEN_ORIENTATION_LANDSCAPE = 2;
        public static final int SCREEN_ORIENTATION_PORTRAIT = 1;
    }

    public interface TemplateType {
        public static final String BOTTOM_PIC_FLOW = "BOTTOM_PIC_FLOW";
        public static final String FLOW = "FLOW";
        public static final String LEFT_PIC_FLOW = "LEFT_PIC_FLOW";
        public static final String PIC = "PIC";
        public static final String RIGHT_PIC_FLOW = "RIGHT_PIC_FLOW";
    }
}
