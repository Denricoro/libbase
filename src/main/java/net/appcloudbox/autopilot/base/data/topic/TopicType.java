package net.appcloudbox.autopilot.base.data.topic;

import androidx.annotation.NonNull;
import android.text.TextUtils;

import net.appcloudbox.autopilot.base.utils.AcbLog;

public class TopicType {
    public static final TopicType LIFE_TIME = new TopicType(TopicKind.LIFE_TIME, "a");
    public static final TopicType LOCAL_LIFE_TIME = new TopicType(TopicKind.LIFE_TIME, "b");
    public static final TopicType UNSUPPORTED_TYPE = new TopicType(TopicKind.LIFE_TIME, "error");

    @NonNull
    private final String name;
    @NonNull
    private final TopicKind topicKind;

    public TopicType(@NonNull TopicKind topicKind, @NonNull String name) {
        this.name = name;
        this.topicKind = topicKind;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public TopicKind getTopicKind() {
        return topicKind;
    }

    public boolean isLifeTimeKind() {
        return getTopicKind().equals(TopicKind.LIFE_TIME);
    }

    public static TopicType valueOf(@NonNull String string) {
        switch (string) {
            case "a":
                return LIFE_TIME;
            case "b":
                return LOCAL_LIFE_TIME;
            default:
                AcbLog.debugAssert("err: unsupported topic type '%s',"
                        + " please upgrade the Ap SDK to the latest version.", string);
                return UNSUPPORTED_TYPE;
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else {
            return obj instanceof TopicType
                    && TextUtils.equals(this.name, ((TopicType) obj).name);
        }
    }
}