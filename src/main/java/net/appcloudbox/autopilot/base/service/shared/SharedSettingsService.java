package net.appcloudbox.autopilot.base.service.shared;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.appcloudbox.autopilot.base.SharedService;

public abstract class SharedSettingsService extends SharedService {
    @Nullable
    public abstract <T> T get(@NonNull String key, @NonNull SettingsSupportType<T> type);

    @NonNull
    public abstract Editor edit();

    public static abstract class Editor {
        @NonNull
        public abstract <T> Editor set(@NonNull String key, @Nullable T value);

        public abstract void apply();
    }
}
