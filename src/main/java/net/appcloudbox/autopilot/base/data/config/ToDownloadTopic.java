package net.appcloudbox.autopilot.base.data.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ToDownloadTopic {
    @NonNull
    private final String topicId;
    @Nullable
    private final String caseId;

    public ToDownloadTopic(@NonNull String topicId, @Nullable String caseId) {
        this.topicId = topicId;
        this.caseId = caseId;
    }

    @NonNull
    public String getTopicId() {
        return topicId;
    }

    @Nullable
    public String getCaseId() {
        return caseId;
    }
}
