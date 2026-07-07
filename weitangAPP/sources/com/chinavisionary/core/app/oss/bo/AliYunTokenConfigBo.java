package com.chinavisionary.core.app.oss.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class AliYunTokenConfigBo extends BaseVo {
    private String accessKeyId = "STS.NTjzUQT8UpSGq5Bv3CBMzYm8T";
    private String secretKeyId = "BXBKnBAZBfnvcJ6X8X6owi7GXHEZRLuFXe3RbNFsxkzZ";
    private String securityToken = "CAIS8wF1q6Ft5B2yfSjIr5ffMe/lued0x5GscxPzkjMWTsJWtqiTtjz2IHBJeXVrBO4Xsfk+mG9T6v8flqNJQppiXlf4YNBstiXZG6V1JNivgde8yJBZor/HcDHhJnyW9cvWZPqDP7G5U/yxalfCuzZuyL/hD1uLVECkNpv74vwOLK5gPG+CYCFBGc1dKyZ7tcYeLgGxD/u2NQPwiWeiZygB+CgE0DwvufXin5DDs0KC3QygldV4/dqhfsKWCOB3J4p6XtuP2+h7S7HMyiY46WIRpPor0PcZp2aY44DBXAINukicUfDd99p0NxN0fbQqtG3/Lip1a5YagAE22G4fSC0UOel3q3WkttXdTjJwCJrZuc/Nx//7L71Luwmw6UN8Fwhnj/nZUP4jImg+zRQgfsQaaYwJDEcLBmHxSWGRCNfcNAP+opcWIGPOWCMNfofihD0c4nykcKGcAhbOsd3dFBMGvp26/W2VDfYspLu1gdYS87pNGnQsJy/58A==";
    private String endpoint = "oss-cn-shenzhen.aliyuncs.com";

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getSecretKeyId() {
        return this.secretKeyId;
    }

    public String getSecurityToken() {
        return this.securityToken;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setEndpoint(String str) {
        this.endpoint = str;
    }

    public void setSecretKeyId(String str) {
        this.secretKeyId = str;
    }

    public void setSecurityToken(String str) {
        this.securityToken = str;
    }
}
