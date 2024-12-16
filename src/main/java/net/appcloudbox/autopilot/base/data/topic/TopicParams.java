package net.appcloudbox.autopilot.base.data.topic;

import androidx.annotation.NonNull;
import android.text.TextUtils;

import net.appcloudbox.autopilot.base.utils.BaseUtils;

import java.util.Map;

public final class TopicParams {
    public static final int INVALID_INDEX = -1;
    private final int version;
    @NonNull
    private final Map<String, ParamKey> nameToParamKeyMap;

    public TopicParams(int version, @NonNull Map<String, ParamKey> nameToParamKeyMap) {
        this.version = version;
        this.nameToParamKeyMap = BaseUtils.unmodifiableMap(nameToParamKeyMap);
    }

    public int getVersion() {
        return version;
    }

    public int getKeyIndex(String paramName) {
        if (!TextUtils.isEmpty(paramName)) {
            ParamKey paramKey = nameToParamKeyMap.get(paramName);
            if (paramKey != null) {
                return paramKey.getIndex();
            }
        }

        return INVALID_INDEX;
    }

    @NonNull
    public Map<String, ParamKey> getNameToParamKeyMap() {
        return nameToParamKeyMap;
    }
}
