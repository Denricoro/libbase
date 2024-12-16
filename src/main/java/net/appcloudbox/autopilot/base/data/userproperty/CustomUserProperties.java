package net.appcloudbox.autopilot.base.data.userproperty;

import androidx.annotation.NonNull;

import net.appcloudbox.autopilot.base.data.config.CustomAudiencePropertyMeta;
import net.appcloudbox.autopilot.base.utils.BaseUtils;

import java.util.Map;

public final class CustomUserProperties {
    private final int version;
    @NonNull
    private final Map<String, CustomUserProperty> properties;

    public CustomUserProperties(@NonNull Map<String, CustomUserProperty> properties, int version) {
        this.version = version;
        this.properties = BaseUtils.unmodifiableMap(properties);
    }

    public int getVersion() {
        return version;
    }

    @NonNull
    public Map<String, CustomUserProperty> getProperties() {
        return properties;
    }

    @Override
    public int hashCode() {
        return version;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof CustomUserProperties) {
            return version == ((CustomUserProperties) obj).version;
        }
        return false;
    }

    public static class CustomUserProperty {
        @NonNull
        private final CustomAudiencePropertyMeta.ContentType contentType;
        private Object value;

        public CustomUserProperty(@NonNull CustomAudiencePropertyMeta.ContentType contentType) {
            this.contentType = contentType;
        }

        @NonNull
        public CustomAudiencePropertyMeta.ContentType getContentType() {
            return contentType;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}
