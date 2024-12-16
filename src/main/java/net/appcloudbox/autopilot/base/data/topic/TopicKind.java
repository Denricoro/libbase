package net.appcloudbox.autopilot.base.data.topic;

import androidx.annotation.NonNull;
import android.text.TextUtils;

import net.appcloudbox.autopilot.base.utils.AcbLog;

public class TopicKind {
    public static final TopicKind LIFE_TIME = new TopicKind("a");
    public static final TopicKind UNSUPPORTED_TYPE = new TopicKind("error");
    @NonNull
    private final String name;

    public TopicKind(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public static TopicKind valueOf(@NonNull String string) {
        switch (string) {
            case "a":
                return LIFE_TIME;
            default:
                AcbLog.debugAssert("err: unsupported topic kind '%s'.", string);
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
            return obj instanceof TopicKind
                    && TextUtils.equals(this.name, ((TopicKind) obj).name);
        }
    }
}