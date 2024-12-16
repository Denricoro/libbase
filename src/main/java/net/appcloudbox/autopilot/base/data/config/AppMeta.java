package net.appcloudbox.autopilot.base.data.config;

import androidx.annotation.Nullable;

public final class AppMeta {
    @Nullable
    private final TriggerInterval triggerInterval;

    public AppMeta(@Nullable TriggerInterval triggerInterval) {
        this.triggerInterval = triggerInterval;
    }

    @Nullable
    public TriggerInterval getTriggerInterval() {
        return triggerInterval;
    }
}
