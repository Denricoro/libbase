package net.appcloudbox.autopilot.base.service.isolated;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.appcloudbox.autopilot.base.IsolatedService;
import net.appcloudbox.autopilot.base.service.shared.SettingsSupportType;

public abstract class IsolatedSettingsService extends IsolatedService {
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
