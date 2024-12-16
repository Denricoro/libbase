package net.appcloudbox.autopilot.base.data.config;

import androidx.annotation.Nullable;

public final class TriggerInterval {
    @Nullable
    private final Integer cusAudience;
    @Nullable
    private final Integer connectivity;
    @Nullable
    private final Integer timer;

    public TriggerInterval(@Nullable Integer cusAudience, @Nullable Integer connectivity,
                           @Nullable Integer timer) {
        this.cusAudience = cusAudience;
        this.connectivity = connectivity;
        this.timer = timer;
    }

    @Nullable
    public Integer getCusAudience() {
        return cusAudience;
    }

    @Nullable
    public Integer getConnectivity() {
        return connectivity;
    }

    @Nullable
    public Integer getTimer() {
        return timer;
    }
}
