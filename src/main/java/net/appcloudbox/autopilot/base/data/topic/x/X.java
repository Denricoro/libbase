package net.appcloudbox.autopilot.base.data.topic.x;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class X<T> {
    @NonNull
    private final String key;
    @NonNull
    private final Values<T> values;
    @NonNull
    private final Strategy strategy;

    public X(@NonNull String key, @Nullable List<T> values, @NonNull Strategy strategy) {
        this.key = key;
        this.values = new Values<>(values);
        this.strategy = strategy;
    }

    @NonNull
    public String getKey() {
        return key;
    }

    @NonNull
    public Values<T> getValues() {
        return values;
    }

    @NonNull
    public Strategy getStrategy() {
        return strategy;
    }
}
