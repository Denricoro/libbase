package net.appcloudbox.autopilot.base.data.topic;

import androidx.annotation.NonNull;
import android.text.TextUtils;

import net.appcloudbox.autopilot.base.utils.AcbLog;

public class CaseType {
    public static final CaseType AB_TEST = new CaseType("a");
    public static final CaseType RULE = new CaseType("b");
    public static final CaseType TEXT_RTOT = new CaseType("c");
    public static final CaseType UNSUPPORTED_TYPE = new CaseType("error");

    @NonNull
    private final String name;

    public CaseType(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public static CaseType valueOf(@NonNull String string) {
        switch (string) {
            case "a":
                return AB_TEST;
            case "b":
                return RULE;
            case "c":
                return TEXT_RTOT;
            default:
                AcbLog.debugAssert("err: unsupported case type '%s'.", string);
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
            return obj instanceof CaseType
                    && TextUtils.equals(this.name, ((CaseType) obj).name);
        }
    }
}