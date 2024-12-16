package net.appcloudbox.autopilot.base.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.appcloudbox.autopilot.base.Data;
import net.appcloudbox.autopilot.base.data.topic.TopicParams;
import net.appcloudbox.autopilot.base.data.topic.TopicType;

public final class TopicMeta extends Data<String> {
    public static final int VERSION = 0;
    private final TopicType topicType;
    @NonNull
    private final String topicName;
    @Nullable
    private final TopicParams topicParams;

    public TopicMeta(@NonNull String topicId, @NonNull TopicType topicType,
                     @NonNull String topicName, @Nullable TopicParams topicParams) {
        super(topicId);
        this.topicType = topicType;
        this.topicName = topicName;
        this.topicParams = topicParams;
    }

    @NonNull
    public String getTopicId() {
        //noinspection ConstantConditions
        return getKey();
    }

    @NonNull
    public TopicType getTopicType() {
        return topicType;
    }

    @NonNull
    public String getTopicName() {
        return topicName;
    }

    @Nullable
    public TopicParams getTopicParams() {
        return topicParams;
    }
}
