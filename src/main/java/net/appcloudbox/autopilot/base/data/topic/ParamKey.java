package net.appcloudbox.autopilot.base.data.topic;

import androidx.annotation.NonNull;

public final class ParamKey {
    @NonNull
    private final String paramName;
    private final int index;

    public ParamKey(@NonNull String paramName, int index) {
        this.paramName = paramName;
        this.index = index;
    }

    @NonNull
    public String getParamName() {
        return paramName;
    }

    public int getIndex() {
        return index;
    }
}
