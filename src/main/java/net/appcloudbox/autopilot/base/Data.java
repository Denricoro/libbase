package net.appcloudbox.autopilot.base;

import androidx.annotation.Nullable;

public abstract class Data<T> {
    @Nullable
    private final T key;

    protected Data(@Nullable T key) {
        this.key = key;
    }

    @Nullable
    public T getKey() {
        return key;
    }
}
