package net.appcloudbox.autopilot.base.data.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.appcloudbox.autopilot.base.data.topic.Topic;
import net.appcloudbox.autopilot.base.utils.BaseUtils;

import java.util.List;

public final class RemoteConfig {
    @Nullable
    private final Long serverTimestamp;
    @Nullable
    private final String apUid;
    @Nullable
    private final String deviceId;
    @Nullable
    private final List<String> frequentEvents;
    @NonNull
    private final List<Topic> topics;

    public RemoteConfig(@Nullable Long serverTimestamp,
                        @Nullable List<Topic> topics,
                        @Nullable String apUid,
                        @Nullable String deviceId,
                        @Nullable List<String> frequentEvents) {
        this.serverTimestamp = serverTimestamp;
        this.topics = BaseUtils.unmodifiableList(topics);
        this.apUid = apUid;
        this.deviceId = deviceId;
        this.frequentEvents = frequentEvents;
    }

    @Nullable
    public Long getServerTimestamp() {
        return serverTimestamp;
    }

    @NonNull
    public List<Topic> getTopics() {
        return topics;
    }

    @Nullable
    public String getApUid() {
        return apUid;
    }

    @Nullable
    public String getDeviceId() {
        return deviceId;
    }

    @Nullable
    public List<String> getFrequentEvents() {
        return frequentEvents;
    }
}
