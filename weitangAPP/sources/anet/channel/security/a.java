package anet.channel.security;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.util.HMacUtil;

/* JADX INFO: loaded from: classes.dex */
public class a implements ISecurity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f553a;

    public a(String str) {
        this.f553a = null;
        this.f553a = str;
    }

    @Override // anet.channel.security.ISecurity
    public byte[] decrypt(Context context, String str, String str2, byte[] bArr) {
        return null;
    }

    @Override // anet.channel.security.ISecurity
    public byte[] getBytes(Context context, String str) {
        return null;
    }

    @Override // anet.channel.security.ISecurity
    public boolean isSecOff() {
        return true;
    }

    @Override // anet.channel.security.ISecurity
    public boolean saveBytes(Context context, String str, byte[] bArr) {
        return false;
    }

    @Override // anet.channel.security.ISecurity
    public String sign(Context context, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(this.f553a) && ISecurity.SIGN_ALGORITHM_HMAC_SHA1.equalsIgnoreCase(str)) {
            return HMacUtil.hmacSha1Hex(this.f553a.getBytes(), str3.getBytes());
        }
        return null;
    }
}
