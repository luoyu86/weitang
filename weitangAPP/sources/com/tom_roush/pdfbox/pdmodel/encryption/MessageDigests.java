package com.tom_roush.pdfbox.pdmodel.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes2.dex */
public final class MessageDigests {
    private MessageDigests() {
    }

    public static MessageDigest getMD5() {
        try {
            return MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static MessageDigest getSHA1() {
        try {
            return MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static MessageDigest getSHA256() {
        try {
            return MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }
}
