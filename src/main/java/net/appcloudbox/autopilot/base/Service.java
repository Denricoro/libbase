package net.appcloudbox.autopilot.base;

import android.content.Context;
import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

import net.appcloudbox.autopilot.base.utils.AcbLog;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class Service {
    public static final int NOT_INITED = 0;
    public static final int INITING = 1;
    public static final int INIT_FAILED = 2;
    public static final int INITED = 3;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({NOT_INITED, INITING, INITED, INIT_FAILED})
    public @interface InitStatus {
    }

    private Context context;
    private @InitStatus int initStatus = NOT_INITED;

    public final boolean init(@NonNull Context context) {
        if (this.initStatus == INITED) {
            return true;
        }
        if (this.initStatus == INIT_FAILED) {
            return false;
        }

        if (this.initStatus == INITING) {
            AcbLog.debugAssert("There is a circular dependency happened when init %s",
                    this.getClass().getSimpleName());
            return false;
        }

        this.initStatus = INITING;

        this.context = context;
        boolean success = init();
        this.initStatus = success ? INITED : INIT_FAILED;
        return success;
    }

    public boolean init() {
        return true;
    }

    public void delayInit() {
    }

    @NonNull
    protected Context getContext() {
        return context;
    }

    public @InitStatus int getInitStatus() {
        return this.initStatus;
    }
}
