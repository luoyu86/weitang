package c.e.a.d;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile j f1215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1216b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1217c;

    public static j getInstance() {
        if (f1215a == null) {
            synchronized (j.class) {
                f1215a = new j();
            }
        }
        return f1215a;
    }

    public final String a() {
        return "http://sz-iapp.hogolife.com/v1/vtapp/";
    }

    public String getBaseUrl() {
        int i2 = this.f1216b;
        if (i2 == 1001) {
            return "http://192.168.0.200:20036/";
        }
        switch (i2) {
            case 1:
            default:
                return "https://n-iapp.yuanjingweitang.com/v1/vtapp/";
            case 2:
                return "http://sit-vtown-app.block-os.com/server-api/";
            case 3:
                return "http://iapp.yuanjingvtown.com/v1/vtapp/";
            case 4:
                return a();
            case 5:
                return "http://uat-iapp.yuanjingvtown.com/v1/vtapp/";
            case 6:
                return "http://uat2-iapp.yuanjingvtown.com/v1/vtapp/";
            case 7:
                return "https://iapp.yuanjingweitang.com/v1/vtapp/";
            case 8:
                return "https://sit-vtown-app.v-town.com/v1/vtapp/";
            case 9:
                return "https://ha-n-iapp.yuanjingweitang.com/v1/vtapp/";
            case 10:
                return "http://k8s-uat-n-iapp.yuanjingweitang.com/v1/vtapp/";
        }
    }

    public String getBjApiBaseUrl() {
        int i2 = this.f1216b;
        if (i2 == 1) {
            return "https://n-rent-vtown-app.yuanjingweitang.com/server-api/";
        }
        if (i2 == 2 || i2 == 3) {
            return "http://sit-vtown-app.block-os.com/server-api/";
        }
        if (i2 == 1001) {
            return "http://192.168.0.200:20036/";
        }
        switch (i2) {
        }
        return "https://n-rent-vtown-app.yuanjingweitang.com/server-api/";
    }

    public String getH5ApiBaseUrl() {
        int i2 = this.f1216b;
        if (i2 == 1) {
            return "https://n-rent-vtown-app.yuanjingweitang.com/server-api/vtapp/v1/";
        }
        if (i2 == 2 || i2 == 3) {
            return "http://sit-vtown-app.block-os.com/server-api/vtapp/v1/";
        }
        if (i2 == 1001) {
            return "http://192.168.0.200:20036/";
        }
        switch (i2) {
        }
        return "https://n-rent-vtown-app.yuanjingweitang.com/server-api/vtapp/v1/";
    }

    public String getH5BaseUrl() {
        int i2 = this.f1216b;
        if (i2 == 1) {
            return "https://n-rent-vtown-app.yuanjingweitang.com/";
        }
        if (i2 == 2 || i2 == 3) {
            return "http://sit-vtown-app.block-os.com/";
        }
        if (i2 == 1001) {
            return "http://192.168.0.200:20036/";
        }
        switch (i2) {
        }
        return "https://n-rent-vtown-app.yuanjingweitang.com/";
    }

    public String getPublicBaseUrl() {
        int i2 = this.f1216b;
        if (i2 == 1001) {
            return "http://192.168.0.200:20036/";
        }
        switch (i2) {
            case 1:
            default:
                return "https://n-iapp.yuanjingweitang.com/v1/";
            case 2:
                return "http://sit-vtown-app.block-os.com/server-api/";
            case 3:
                return "http://iapp.yuanjingvtown.com/v1/";
            case 4:
                return "http://sz-iapp.hogolife.com/v1/";
            case 5:
                return "http://uat-iapp.yuanjingvtown.com/v1/";
            case 6:
                return "http://uat2-iapp.yuanjingvtown.com/v1/";
            case 7:
                return "https://iapp.yuanjingweitang.com/v1/";
            case 8:
                return "https://sit-vtown-app.v-town.com/v1/";
            case 9:
                return "https://ha-n-iapp.yuanjingweitang.com/v1/";
            case 10:
                return "http://k8s-uat-n-iapp.yuanjingweitang.com/v1/";
        }
    }

    public String getPublicH5BaseUrl() {
        int i2 = this.f1216b;
        if (i2 == 1001) {
            return "http://192.168.0.200:20036/";
        }
        switch (i2) {
            case 1:
            default:
                return "https://n-rent-vtown-app.yuanjingweitang.com/server-api/";
            case 2:
            case 3:
                return "http://sit-vtown-app.block-os.com/server-api/";
            case 4:
                return "http://sz-iapp.hogolife.com/v1/";
            case 5:
                return "http://uat-vtown-app.yuanjingweitang.com/server-api/";
            case 6:
                return "http://uat-vtown-app.v-town.com/server-api/";
            case 7:
                return "https://rent-vtown-app.yuanjingweitang.com/server-api/";
            case 8:
                return "https://sit-vtown-app.v-town.com/server-api/";
            case 9:
                return "https://ha-n-rent-vtown-app.yuanjingweitang.com/server-api/";
            case 10:
                return "http://k8s-uat-n-rent-vtown-app.yuanjingweitang.com/server-api/";
        }
    }

    public String getPublicKey() {
        return this.f1217c;
    }

    public String getRentBaseUrl() {
        switch (this.f1216b) {
            case 1:
            case 4:
            default:
                return "https://n-irent.yuanjingweitang.com/v1/vtcenters/";
            case 2:
                return "http://sit-vtown-app.block-os.com/server-api/";
            case 3:
                return "http://irent.yuanjingvtown.com/v1/vtcenters/";
            case 5:
                return "http://uat-iapp.yuanjingvtown.com/v1/vtcenters/";
            case 6:
                return "http://uat2-iapp.yuanjingvtown.com/v1/vtcenters/";
            case 7:
                return "https://irent.yuanjingweitang.com/v1/vtcenters/";
            case 8:
                return "https://sit-vtown-app.v-town.com/v1/vtcenters/";
            case 9:
                return "https://ha-n-irent.yuanjingweitang.com/v1/vtcenters/";
            case 10:
                return "http://k8s-uat-n-irent.yuanjingweitang.com/v1/vtcenters/";
        }
    }

    public void setPublicKey(String str) {
        this.f1217c = str;
    }
}
