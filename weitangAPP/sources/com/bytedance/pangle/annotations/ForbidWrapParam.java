package com.bytedance.pangle.annotations;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.PARAMETER})
@Keep
@Retention(RetentionPolicy.CLASS)
public @interface ForbidWrapParam {
}
