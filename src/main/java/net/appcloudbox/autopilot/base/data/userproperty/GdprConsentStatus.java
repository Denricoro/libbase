package net.appcloudbox.autopilot.base.data.userproperty;

import androidx.annotation.NonNull;
import android.text.TextUtils;

import net.appcloudbox.autopilot.base.utils.AcbLog;

public class GdprConsentStatus {
    public static final GdprConsentStatus UNDETERMINED = new GdprConsentStatus("a");
    public static final GdprConsentStatus GRANTED = new GdprConsentStatus("b");
    public static final GdprConsentStatus DECLINED = new GdprConsentStatus("c");
    public static final GdprConsentStatus UNSUPPORTED_TYPE = new GdprConsentStatus("error");
    @NonNull
    private final String name;

    public GdprConsentStatus(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public static GdprConsentStatus valueOf(@NonNull String string) {
        switch (string) {
            case "a":
                return UNDETERMINED;
            case "b":
                return GRANTED;
            case "c":
                return DECLINED;
            default:
                AcbLog.debugAssert("err: unsupported GDPR consent status '%s'.", string);
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
            return obj instanceof GdprConsentStatus
                    && TextUtils.equals(this.name, ((GdprConsentStatus) obj).name);
        }
    }
}