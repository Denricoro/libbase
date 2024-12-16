package net.appcloudbox.autopilot.base.data.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.text.TextUtils;

import net.appcloudbox.autopilot.base.utils.AcbLog;
import net.appcloudbox.autopilot.base.utils.BaseUtils;

import java.util.List;

public final class CustomAudiencePropertyMeta {
    @NonNull
    private final String field;
    @NonNull
    private final ContentType contentType;
    @NonNull
    private final List<SelectValue> selectValue;

    public CustomAudiencePropertyMeta(@NonNull String field,
                                      @NonNull ContentType contentType,
                                      @Nullable List<SelectValue> selectValue) {
        this.field = field;
        this.contentType = contentType;
        this.selectValue = BaseUtils.unmodifiableList(selectValue);
    }

    @NonNull
    public String getField() {
        return field;
    }

    @NonNull
    public ContentType getContentType() {
        return contentType;
    }

    @NonNull
    public List<SelectValue> getSelectValue() {
        return selectValue;
    }

    public static class ContentType {
        public static final ContentType STRING = new ContentType("a");
        public static final ContentType NUMBER = new ContentType("b");
        public static final ContentType BOOLEAN = new ContentType("c");
        public static final ContentType LEVEL = new ContentType("d");
        public static final ContentType UNSUPPORTED_TYPE = new ContentType("error");

        @NonNull
        private final String name;

        public ContentType(@NonNull String name) {
            this.name = name;
        }

        @NonNull
        public String getName() {
            return name;
        }

        @NonNull
        public static ContentType valueOf(@NonNull String string) {
            switch (string) {
                case "a":
                    return STRING;
                case "b":
                    return NUMBER;
                case "c":
                    return BOOLEAN;
                case "d":
                    return LEVEL;
                default:
                    AcbLog.debugAssert("err: unsupported content type '%s'.", string);
                    return UNSUPPORTED_TYPE;
            }
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            } else {
                return obj instanceof ContentType
                        && TextUtils.equals(this.name, ((ContentType) obj).name);
            }
        }
    }

    public static final class SelectValue {
        @NonNull
        private final String value;

        public SelectValue(@NonNull String value) {
            this.value = value;
        }

        @NonNull
        public String getValue() {
            return value;
        }
    }
}
