package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class StringSignature implements Key {
    private final String signature;

    public StringSignature(String str) {
        Objects.requireNonNull(str, "Signature cannot be null!");
        this.signature = str;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.signature.equals(((StringSignature) obj).signature);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.signature.hashCode();
    }

    public String toString() {
        return "StringSignature{signature='" + this.signature + "'}";
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.signature.getBytes("UTF-8"));
    }
}
