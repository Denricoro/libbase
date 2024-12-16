package net.appcloudbox.autopilot.base.data.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.appcloudbox.autopilot.base.data.topic.Topic;
import net.appcloudbox.autopilot.base.utils.BaseUtils;

import java.util.List;

public final class LocalConfig {
    @Nullable
    private final Integer apId;
    @Nullable
    private final String appKey;
    @Nullable
    private final String jsonId;
    @Nullable
    private final AppMeta appMeta;
    @Nullable
    private final CustomAudiencePropertyMetas customAudiencePropertyMetas;
    @NonNull
    private final List<String> appEvents;
    @Nullable
    private final LocalTestSets localTestSets;
    @NonNull
    private final List<Topic> topics;
    @Nullable
    private final CpmAssociation cpmAssociation;

    public LocalConfig(@Nullable Integer apId,
                       @Nullable String appKey,
                       @Nullable String jsonId,
                       @Nullable AppMeta appMeta,
                       @Nullable CustomAudiencePropertyMetas customAudiencePropertyMetas,
                       @NonNull List<String> appEvents,
                       @Nullable LocalTestSets localTestSets,
                       @NonNull List<Topic> topics,
                       @Nullable CpmAssociation cpmAssociation) {
        this.apId = apId;
        this.appKey = appKey;
        this.jsonId = jsonId;
        this.appMeta = appMeta;
        this.customAudiencePropertyMetas = customAudiencePropertyMetas;
        this.appEvents = BaseUtils.unmodifiableList(appEvents);
        this.localTestSets = localTestSets;
        this.topics = BaseUtils.unmodifiableList(topics);
        this.cpmAssociation = cpmAssociation;
    }

    @Nullable
    public Integer getApId() {
        return apId;
    }

    @Nullable
    public String getAppKey() {
        return appKey;
    }

    @Nullable
    public String getJsonId() {
        return jsonId;
    }

    @Nullable
    public AppMeta getAppMeta() {
        return appMeta;
    }

    @Nullable
    public CustomAudiencePropertyMetas getCustomAudiencePropertyMetas() {
        return customAudiencePropertyMetas;
    }

    @NonNull
    public List<String> getAppEvents() {
        return appEvents;
    }

    @Nullable
    public LocalTestSets getLocalTestSets() {
        return localTestSets;
    }

    @NonNull
    public List<Topic> getTopics() {
        return topics;
    }

    @Nullable
    public CpmAssociation getCpmAssociation() {
        return cpmAssociation;
    }
}
