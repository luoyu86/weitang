package anet.channel.entity;

/* JADX INFO: loaded from: classes.dex */
public enum ENV {
    ONLINE(0),
    PREPARE(1),
    TEST(2);

    private int envMode;

    ENV(int i2) {
        this.envMode = i2;
    }

    public int getEnvMode() {
        return this.envMode;
    }

    public void setEnvMode(int i2) {
        this.envMode = i2;
    }

    public static ENV valueOf(int i2) {
        return i2 != 1 ? i2 != 2 ? ONLINE : TEST : PREPARE;
    }
}
