package net.appcloudbox.autopilot.base.data;

import androidx.annotation.NonNull;

import net.appcloudbox.autopilot.base.Data;
import net.appcloudbox.autopilot.base.utils.BaseUtils;

import java.util.List;

public final class AppEventMeta extends Data<String> {
    public static final int VERSION = 0;
    public AppEventMeta(String eventName) {
        super(eventName);
    }

    @NonNull
    public String getEventName() {
        //noinspection ConstantConditions
        return getKey();
    }
}
