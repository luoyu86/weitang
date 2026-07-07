package org.android.spdy;

/* JADX INFO: loaded from: classes2.dex */
public enum RequestPriority {
    HIGHEST(0),
    HIGH(1),
    MEDIUM(2),
    LOW(3),
    LOWEST(4),
    IDLE(5),
    DEFAULT_PRIORITY(1);

    private int priority;

    RequestPriority(int i2) {
        this.priority = i2;
    }

    public int getPriorityInt() {
        return this.priority;
    }
}
