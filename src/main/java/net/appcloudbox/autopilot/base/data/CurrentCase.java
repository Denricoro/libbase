package net.appcloudbox.autopilot.base.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.appcloudbox.autopilot.base.Data;

public final class CurrentCase extends Data<String> {
    public static final int VERSION = 0;

    @NonNull
    private final String caseId;
    private final boolean isDefault;

    public CurrentCase(@NonNull String topicId, @Nullable String caseId, boolean isDefault) {
        super(topicId);
        if (caseId == null) {
            this.caseId = "";
        } else {
            this.caseId = caseId;
        }
        this.isDefault = isDefault;
    }

    public CurrentCase(TopicCase topicCase) {
        this(topicCase.getTopicId(), topicCase.getCaseId(), topicCase.isDefault());
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

    public boolean isDefault() {
        return isDefault;
    }
}
