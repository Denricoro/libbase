package net.appcloudbox.autopilot.base;

import android.text.TextUtils;
import android.util.LruCache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class AccountContext {
    public static final AccountContext DEFAULT = new AccountContext("");
    private static final LruCache<String, AccountContext> CACHE = new LruCache<>(5);

    public static AccountContext obtain(@Nullable String routerId) {
        if (TextUtils.isEmpty(routerId)) {
            return DEFAULT;
        }

        AccountContext accountContext = CACHE.get(routerId);
        if (accountContext == null) {
            accountContext = new AccountContext(routerId);
            CACHE.put(routerId, accountContext);
        }

        return accountContext;
    }

    @NonNull
    private final String routerId;

    private AccountContext(@NonNull String routerId) {
        this.routerId = routerId;
    }

    @NonNull
    public String getAccountId() {
        return routerId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof AccountContext) {
            return routerId.equals(((AccountContext) obj).routerId);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return routerId.hashCode();
    }
}
