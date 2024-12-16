package net.appcloudbox.autopilot.base.data.userproperty;

import androidx.annotation.NonNull;
import android.text.TextUtils;

import java.util.Collections;
import java.util.Set;

public final class IMEI {
    @NonNull
    private final String primaryIMEI;
    @NonNull
    private final Set<String> othersIMEI;

    public IMEI(@NonNull String primaryIMEI,
                @NonNull Set<String> othersIMEI) {
        this.primaryIMEI = primaryIMEI;
        this.othersIMEI = Collections.unmodifiableSet(othersIMEI);
    }

    @NonNull
    public String getPrimaryIMEI() {
        return primaryIMEI;
    }

    @NonNull
    public Set<String> getOthersIMEI() {
        return othersIMEI;
    }

    @Override
    public int hashCode() {
        return primaryIMEI.hashCode() + othersIMEI.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else {
            return obj instanceof IMEI
                    && TextUtils.equals(this.primaryIMEI, ((IMEI) obj).primaryIMEI)
                    && this.othersIMEI.equals(((IMEI) obj).othersIMEI);
        }
    }
}
