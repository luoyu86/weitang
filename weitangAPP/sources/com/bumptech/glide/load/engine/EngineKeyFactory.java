package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;

/* JADX INFO: loaded from: classes.dex */
public class EngineKeyFactory {
    public EngineKey buildKey(String str, Key key, int i2, int i3, ResourceDecoder resourceDecoder, ResourceDecoder resourceDecoder2, Transformation transformation, ResourceEncoder resourceEncoder, ResourceTranscoder resourceTranscoder, Encoder encoder) {
        return new EngineKey(str, key, i2, i3, resourceDecoder, resourceDecoder2, transformation, resourceEncoder, resourceTranscoder, encoder);
    }
}
