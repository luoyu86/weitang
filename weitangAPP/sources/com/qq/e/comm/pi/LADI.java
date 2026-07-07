package com.qq.e.comm.pi;

import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface LADI extends ApkDownloadComplianceInterface, IBidding {
    int getECPM();

    String getECPMLevel();

    Map<String, Object> getExtraInfo();

    boolean isValid();
}
