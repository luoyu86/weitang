package com.bytedance.sdk.openadsdk.mediation.bridge;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes.dex */
public class MediationResultBuilder {
    private boolean ok = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6417a = -1;
    private String bl = null;
    private ValueSet s = null;

    public static final class ResultImpl implements Result {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6418a;
        private final String bl;
        private final boolean ok;
        private final ValueSet s;

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.f6418a;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.ok;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.bl;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.s;
        }

        private ResultImpl(boolean z, int i2, String str, ValueSet valueSet) {
            this.ok = z;
            this.f6418a = i2;
            this.bl = str;
            this.s = valueSet;
        }
    }

    private MediationResultBuilder() {
    }

    public static final MediationResultBuilder create() {
        return new MediationResultBuilder();
    }

    public Result build() {
        boolean z = this.ok;
        int i2 = this.f6417a;
        String str = this.bl;
        ValueSet valueSetBuild = this.s;
        if (valueSetBuild == null) {
            valueSetBuild = MediationValueSetBuilder.create().build();
        }
        return new ResultImpl(z, i2, str, valueSetBuild);
    }

    public MediationResultBuilder setCode(int i2) {
        this.f6417a = i2;
        return this;
    }

    public MediationResultBuilder setMessage(String str) {
        this.bl = str;
        return this;
    }

    public MediationResultBuilder setSuccess(boolean z) {
        this.ok = z;
        return this;
    }

    public MediationResultBuilder setValues(ValueSet valueSet) {
        this.s = valueSet;
        return this;
    }
}
