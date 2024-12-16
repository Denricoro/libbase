package net.appcloudbox.autopilot.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface IRouter {
    @Nullable
    <T extends Service> T getService(@NonNull Class<T> serviceClass);

    @Nullable
    <T extends Model> T getModel(@NonNull Class<T> modelClass);
}
