package net.appcloudbox.autopilot.base;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public abstract class SharedInnerService extends SharedService implements IRouter {
    private IRouter router;

    public final boolean init(Context context, IRouter router) {
        this.router = router;
        return init(context);
    }

    @Nullable
    public final <T extends Service> T getService(@NonNull Class<T> serviceClass) {
        if (router != null) {
            return router.getService(serviceClass);
        }

        return null;
    }

    @Nullable
    public final <T extends Model> T getModel(@NonNull Class<T> modelClass) {
        if (router != null) {
            return router.getModel(modelClass);
        }

        return null;
    }
}
