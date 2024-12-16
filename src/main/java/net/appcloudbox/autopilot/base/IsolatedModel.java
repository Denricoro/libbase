package net.appcloudbox.autopilot.base;

import android.content.Context;
import androidx.annotation.NonNull;

public abstract class IsolatedModel<K, D extends Data<K>> extends Model<K, D> {
    private AccountContext accountContext;

    public final boolean init(@NonNull Context context,
                              @NonNull AccountContext accountContext) {
        this.accountContext = accountContext;
        return super.init(context);
    }

    @NonNull
    public AccountContext getAccountContext() {
        return accountContext;
    }

    public abstract void del();
}
