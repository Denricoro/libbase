package net.appcloudbox.autopilot.base.service.shared;

import androidx.annotation.NonNull;

import net.appcloudbox.autopilot.base.data.userproperty.CustomUserProperties;
import net.appcloudbox.autopilot.base.data.userproperty.IMEI;

public final class UserPropertySupportType<T> extends SettingsSupportType<T> {
    public static final UserPropertySupportType<Integer> INT =
            new UserPropertySupportType<>(Integer.class);
    public static final UserPropertySupportType<Double> DOUBLE =
            new UserPropertySupportType<>(Double.class);
    public static final UserPropertySupportType<Long> LONG =
            new UserPropertySupportType<>(Long.class);
    public static final UserPropertySupportType<Boolean> BOOL =
            new UserPropertySupportType<>(Boolean.class);
    public static final UserPropertySupportType<String> STRING =
            new UserPropertySupportType<>(String.class);
    public static final UserPropertySupportType<CustomUserProperties> CUSTOM_USER_PROPERTIES =
            new UserPropertySupportType<>(CustomUserProperties.class);
    public static final UserPropertySupportType<IMEI> IMEI =
            new UserPropertySupportType<>(IMEI.class);

    private UserPropertySupportType(@NonNull Class<T> clazz) {
        super(clazz);
    }
}
