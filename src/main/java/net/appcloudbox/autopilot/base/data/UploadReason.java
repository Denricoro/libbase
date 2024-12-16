package net.appcloudbox.autopilot.base.data;

import androidx.annotation.NonNull;
import android.text.TextUtils;

import net.appcloudbox.autopilot.base.utils.AcbLog;

public class UploadReason {
    public static final UploadReason STORAGE_20 = new UploadReason("a");
    public static final UploadReason SESSION_END = new UploadReason("c");
    public static final UploadReason SESSION_BACKGROUND = new UploadReason("d");
    public static final UploadReason SDK_INIT = new UploadReason("e");
    public static final UploadReason INITIAL_COMPLETED = new UploadReason("f");
    public static final UploadReason FREQUENT_EVENTS = new UploadReason("g");
    public static final UploadReason UNSUPPORTED_TYPE = new UploadReason("error");
    @NonNull
    private final String name;

    public UploadReason(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public static UploadReason valueOf(@NonNull String string) {
        switch (string) {
            case "a":
                return STORAGE_20;
            case "c":
                return SESSION_END;
            case "d":
                return SESSION_BACKGROUND;
            case "e":
                return SDK_INIT;
            case "f":
                return INITIAL_COMPLETED;
            case "g":
                return FREQUENT_EVENTS;
            default:
                AcbLog.debugAssert("err: unsupported upload reason '%s'.", string);
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
            return obj instanceof UploadReason
                    && TextUtils.equals(this.name, ((UploadReason) obj).name);
        }
    }
}