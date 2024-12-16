package net.appcloudbox.autopilot.base.data;

import androidx.annotation.NonNull;
import android.text.TextUtils;

import net.appcloudbox.autopilot.base.utils.AcbLog;

public class RequestReason {
    public static final RequestReason SESSION_START = new RequestReason("b");
    public static final RequestReason CUSTOM_AUDIENCE_CHANGE_FORCE_REFRESH = new RequestReason("c");
    public static final RequestReason CONNECTIVITY_STATUS_CHANGE = new RequestReason("d");
    public static final RequestReason SERVER_PUBLISH_DATA_READY = new RequestReason("e");
    public static final RequestReason TIMER = new RequestReason("f");
    public static final RequestReason CUSTOM_AUDIENCE_CHANGE = new RequestReason("g");
    public static final RequestReason ACCOUNT_LOGIN = new RequestReason("h");
    public static final RequestReason MANUAL = new RequestReason("i");
    public static final RequestReason UNSUPPORTED_TYPE = new RequestReason("error");

    @NonNull
    private final String name;

    public RequestReason(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public static RequestReason valueOf(@NonNull String string) {
        switch (string) {
            case "b":
                return SESSION_START;
            case "c":
                return CUSTOM_AUDIENCE_CHANGE_FORCE_REFRESH;
            case "d":
                return CONNECTIVITY_STATUS_CHANGE;
            case "e":
                return SERVER_PUBLISH_DATA_READY;
            case "f":
                return TIMER;
            case "g":
                return CUSTOM_AUDIENCE_CHANGE;
            case "h":
                return ACCOUNT_LOGIN;
            case "i":
                return MANUAL;
            default:
                AcbLog.debugAssert("err: unsupported request reason '%s'.", string);
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
            return obj instanceof RequestReason
                    && TextUtils.equals(this.name, ((RequestReason) obj).name);
        }
    }
}