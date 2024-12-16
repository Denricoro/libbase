package net.appcloudbox.autopilot.base.data.topic;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.appcloudbox.autopilot.base.data.topic.x.X;

import java.util.List;

public final class Topic {
    @NonNull
    private final String topicId;
    @Nullable
    private final String caseId;
    @Nullable
    private final TopicType topicType;
    @Nullable
    private final TopicParams topicParams;
    @Nullable
    private final List<X<?>> topicXs;
    @Nullable
    private final CaseType caseType;

    public Topic(@NonNull String topicId, @Nullable String caseId,
                 @Nullable TopicType topicType, @Nullable TopicParams topicParams,
                 @Nullable List<X<?>> topicXs, @Nullable CaseType caseType) {
        this.topicId = topicId;
        this.caseId = caseId;
        this.topicType = topicType;
        this.topicParams = topicParams;
        this.topicXs = topicXs;
        this.caseType = caseType;
    }

    @NonNull
    public String getTopicId() {
        return topicId;
    }

    @Nullable
    public String getCaseId() {
        return caseId;
    }

    @Nullable
    public TopicType getTopicType() {
        return topicType;
    }

    @Nullable
    public TopicParams getTopicParams() {
        return topicParams;
    }

    @Nullable
    public List<X<?>> getTopicXs() {
        return topicXs;
    }

    @Nullable
    public CaseType getCaseType() {
        return caseType;
    }
}
