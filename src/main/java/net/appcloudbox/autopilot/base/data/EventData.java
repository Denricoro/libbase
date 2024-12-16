package net.appcloudbox.autopilot.base.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.text.TextUtils;

import net.appcloudbox.autopilot.base.Data;
import net.appcloudbox.autopilot.base.utils.BaseUtils;

import java.util.List;
import java.util.UUID;

// Integer 主键为自增主键
public class EventData extends Data<Integer> {
    public static final int VERSION = 1;
    @NonNull
    private final String eventId;
    //用户事件是否已经修复
    private final boolean needToFix;
    @NonNull
    private final String eventName;
    @Nullable
    private final Double eventValue;
    private final long timestamp;
    @Nullable
    private final String sessionUuid;
    @Nullable
    private final String caseId;
    @Nullable
    private final String accountId;
    @Nullable
    private final List<String> triggers;

    public EventData(@Nullable Integer countId, @Nullable String eventId, boolean needToFix,
                     @NonNull String eventName, @Nullable Double eventValue, long timestamp,
                     @Nullable String sessionUuid, @Nullable String caseId,
                     @Nullable String accountId, @Nullable List<String> triggers) {
        super(countId);
        this.accountId = accountId;
        this.triggers = triggers;
        if (!TextUtils.isEmpty(eventId)) {
            this.eventId = eventId;
        } else {
            this.eventId = UUID.randomUUID().toString();
        }
        this.eventValue = eventValue;
        this.needToFix = needToFix;
        this.eventName = eventName;
        this.timestamp = timestamp;
        this.sessionUuid = BaseUtils.getNonNull(sessionUuid);
        this.caseId = caseId;
    }

    @Nullable
    public Integer getCountId() {
        return getKey();
    }

    @NonNull
    public String getEventId() {
        return eventId;
    }

    @NonNull
    public String getEventName() {
        return eventName;
    }

    @Nullable
    public Double getEventValue() {
        return eventValue;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Nullable
    public String getSessionUuid() {
        return sessionUuid;
    }

    @Nullable
    public String getCaseId() {
        return caseId;
    }

    public boolean isNeedToFix() {
        return needToFix;
    }

    @Nullable
    public String getAccountId() {
        return accountId;
    }

    @Nullable
    public List<String> getTriggers() {
        return triggers;
    }

    @Override
    public int hashCode() {
        return eventId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this == obj) {
            return true;
        } else if (obj instanceof EventData) {
            return TextUtils.equals(eventId, ((EventData) obj).eventId);
        }
        return false;
    }
}
