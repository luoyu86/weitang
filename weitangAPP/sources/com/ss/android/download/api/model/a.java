package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9721a;
    public String bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f9722h;
    public int k;
    public boolean kf;
    public String n;
    public Context ok;
    public InterfaceC0128a p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f9723q;
    public String s;

    /* JADX INFO: renamed from: com.ss.android.download.api.model.a$a, reason: collision with other inner class name */
    public interface InterfaceC0128a {
        void a(DialogInterface dialogInterface);

        void bl(DialogInterface dialogInterface);

        void ok(DialogInterface dialogInterface);
    }

    public static final class ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9724a;
        private Context bl;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f9725h;
        private InterfaceC0128a k;
        private String kf;
        private String n;
        public View ok;
        private boolean p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private Drawable f9726q;
        private String s;

        public ok(Context context) {
            this.bl = context;
        }

        public ok a(String str) {
            this.n = str;
            return this;
        }

        public ok bl(String str) {
            this.kf = str;
            return this;
        }

        public ok ok(String str) {
            this.s = str;
            return this;
        }

        public ok s(String str) {
            this.f9725h = str;
            return this;
        }

        public ok ok(boolean z) {
            this.p = z;
            return this;
        }

        public ok ok(Drawable drawable) {
            this.f9726q = drawable;
            return this;
        }

        public ok ok(InterfaceC0128a interfaceC0128a) {
            this.k = interfaceC0128a;
            return this;
        }

        public ok ok(int i2) {
            this.f9724a = i2;
            return this;
        }

        public a ok() {
            return new a(this);
        }
    }

    private a(ok okVar) {
        this.kf = true;
        this.ok = okVar.bl;
        this.f9721a = okVar.s;
        this.bl = okVar.n;
        this.s = okVar.kf;
        this.n = okVar.f9725h;
        this.kf = okVar.p;
        this.f9722h = okVar.f9726q;
        this.p = okVar.k;
        this.f9723q = okVar.ok;
        this.k = okVar.f9724a;
    }
}
