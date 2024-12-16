package net.appcloudbox.autopilot.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface ApLogger {
    void log(int priority, @NonNull String tag, @NonNull String msg);
    void debugAssert(@NonNull String msg, @Nullable Throwable cause);
}
