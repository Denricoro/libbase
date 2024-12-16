package net.appcloudbox.autopilot.base.data.topic.x;

import androidx.annotation.NonNull;
import android.text.TextUtils;

import net.appcloudbox.autopilot.base.utils.AcbLog;

public class Strategy {
    public static final Strategy SOLE = new Strategy("a");
    public static final Strategy RANDOM = new Strategy("b");
    public static final Strategy UNSUPPORTED_TYPE = new Strategy("error");

    @NonNull
    private final String name;

    public Strategy(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public static Strategy valueOf(@NonNull String string) {
        switch (string) {
            case "a":
                return SOLE;
            case "b":
                return RANDOM;
            default:
                AcbLog.debugAssert("err: unsupported strategy '%s'.", string);
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
            return obj instanceof Strategy
                    && TextUtils.equals(this.name, ((Strategy) obj).name);
        }
    }
}