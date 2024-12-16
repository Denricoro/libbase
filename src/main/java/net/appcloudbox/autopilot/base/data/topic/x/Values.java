package net.appcloudbox.autopilot.base.data.topic.x;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.appcloudbox.autopilot.base.utils.BaseUtils;

import java.util.List;

public final class Values<T> {
    @NonNull
    private final List<T> values;

    public Values(@Nullable List<T> values) {
        this.values = BaseUtils.unmodifiableList(values);
    }

    public int size() {
        return values.size();
    }

    @NonNull
    public List<T> getValues() {
        return values;
    }

    public T get(int index) {
        return values.get(index);
    }
}
