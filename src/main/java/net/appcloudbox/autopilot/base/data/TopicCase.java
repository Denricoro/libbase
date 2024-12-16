package net.appcloudbox.autopilot.base.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.text.TextUtils;

import net.appcloudbox.autopilot.base.Data;
import net.appcloudbox.autopilot.base.data.topic.CaseType;
import net.appcloudbox.autopilot.base.data.topic.x.X;
import net.appcloudbox.autopilot.base.utils.BaseUtils;

import java.util.Map;

public final class TopicCase extends Data<String> {
    public static final int VERSION = 0;
    @NonNull
    private final String caseId;
    @Nullable
    private final CaseType caseType;
    @NonNull
    private final Map<String, X<?>> xMap;
    private final boolean isDefault;

    public TopicCase(@NonNull String topicId, @NonNull String caseId, @Nullable CaseType caseType,
                     @NonNull Map<String, X<?>> xMap, boolean isDefault) {
        super(topicId);
        this.caseId = caseId;
        this.caseType = caseType;
        this.isDefault = isDefault;
        this.xMap = BaseUtils.unmodifiableMap(xMap);
    }

    @NonNull
    public String getCaseId() {
        return caseId;
    }

    @NonNull
    public String getTopicId() {
        //noinspection ConstantConditions
        return getKey();
    }

    @Nullable
    public CaseType getCaseType() {
        return caseType;
    }

    @NonNull
    public Map<String, X<?>> getXMap() {
        return xMap;
    }

    public boolean isDefault() {
        return isDefault;
    }

    @Override
    public int hashCode() {
        return getCaseId().hashCode() + getTopicId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this == obj) {
            return true;
        } else if (obj instanceof TopicCase) {
            return TextUtils.equals(getCaseId(), ((TopicCase) obj).getCaseId())
                    && TextUtils.equals(getTopicId(), ((TopicCase) obj).getTopicId());

        }
        return false;
    }
}
