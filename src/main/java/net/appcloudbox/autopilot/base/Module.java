package net.appcloudbox.autopilot.base;

import android.content.Context;
import androidx.annotation.NonNull;

public abstract class Module {
    private Context context;

    public final boolean init(@NonNull Context context) {
        this.context = context;
        return init();
    }

    public boolean init() {
        return true;
    }

    @NonNull
    protected Context getContext() {
        return context;
    }
}
