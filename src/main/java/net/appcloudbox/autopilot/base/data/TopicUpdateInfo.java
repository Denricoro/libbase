package net.appcloudbox.autopilot.base.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.appcloudbox.autopilot.base.Data;

public final class TopicUpdateInfo extends Data<String> {
    public static final int VERSION = 0;
    @NonNull
    private final String caseId;
    private final long lastFetchSuccessTime;
    private final boolean isDefault;

    public TopicUpdateInfo(@NonNull String topicId, @Nullable String caseId,
                           long lastFetchSuccessTime, boolean isDefault) {
        super(topicId);
        this.isDefault = isDefault;
        if (caseId != null) {
            this.caseId = caseId;
        } else {
            this.caseId = "";
        }
        this.lastFetchSuccessTime = lastFetchSuccessTime;
    }

    @NonNull
    public String getTopicId() {
        //noinspection ConstantConditions
        return getKey();
    }

    @NonNull
    public String getCaseId() {
        return caseId;
    }

    public long getLastFetchSuccessTime() {
        return lastFetchSuccessTime;
    }

    public boolean isDefault() {
        return isDefault;
    }
}
