package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes.dex */
public interface TTFeedAd extends TTNativeAd {

    public interface CustomizeVideo {
        String getVideoUrl();

        void reportVideoAutoStart();

        void reportVideoBreak(long j);

        void reportVideoContinue(long j);

        void reportVideoError(long j, int i2, int i3);

        void reportVideoFinish();

        void reportVideoPause(long j);

        void reportVideoStart();

        void reportVideoStartError(int i2, int i3);
    }

    public interface VideoAdListener {
        void onProgressUpdate(long j, long j2);

        void onVideoAdComplete(TTFeedAd tTFeedAd);

        void onVideoAdContinuePlay(TTFeedAd tTFeedAd);

        void onVideoAdPaused(TTFeedAd tTFeedAd);

        void onVideoAdStartPlay(TTFeedAd tTFeedAd);

        void onVideoError(int i2, int i3);

        void onVideoLoad(TTFeedAd tTFeedAd);
    }

    public interface VideoRewardListener {
        void onFeedRewardCountDown(int i2);
    }

    int getAdViewHeight();

    int getAdViewWidth();

    CustomizeVideo getCustomVideo();

    double getVideoDuration();

    void setVideoAdListener(VideoAdListener videoAdListener);

    void setVideoRewardListener(VideoRewardListener videoRewardListener);
}
