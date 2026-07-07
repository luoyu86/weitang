package c.m.a.e;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f2864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f2865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<a> f2866c;

    public static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<String> f2868b;

        public List<String> getCommand() {
            return this.f2868b;
        }

        public String getCommandId() {
            return this.f2867a;
        }

        public void setCommand(List<String> list) {
            this.f2868b = list;
        }

        public void setCommandId(String str) {
            this.f2867a = str;
        }
    }

    public a getOpenDoor() {
        return this.f2864a;
    }

    public a getSetTime() {
        return this.f2865b;
    }

    public List<a> getUnexecuteds() {
        return this.f2866c;
    }

    public void setOpenDoor(a aVar) {
        this.f2864a = aVar;
    }

    public void setSetTime(a aVar) {
        this.f2865b = aVar;
    }

    public void setUnexecuteds(List<a> list) {
        this.f2866c = list;
    }
}
