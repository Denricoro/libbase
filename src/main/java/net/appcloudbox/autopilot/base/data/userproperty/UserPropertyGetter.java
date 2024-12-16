package net.appcloudbox.autopilot.base.data.userproperty;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.appcloudbox.autopilot.base.service.shared.UserPropertySupportType;

import java.util.Map;

public interface UserPropertyGetter {
    @Nullable
    <T> T get(@NonNull String key, @NonNull UserPropertySupportType<T> type);

    @NonNull
    Map<String, Property> getAll();

    @Nullable
    Long getTimeZone();

    @Nullable
    String getDeviceId();

    @Nullable
    String getApUid();

    @Nullable
    String getClientDeviceId();

    @Nullable
    String getBundleId();

    @Nullable
    String getPlatform();

    @Nullable
    Boolean getIsUpgradeFromAppVersionWithoutAp();

    @Nullable
    String getCustomerUserId();

    @Nullable
    CustomUserProperties getCustomUserProperties();

    @Nullable
    Integer getApId();

    @Nullable
    String getOsVersion();

    @Nullable
    String getAppVersion();

    @Nullable
    String getDeviceType();

    @Nullable
    String getDeviceBrand();

    @Nullable
    String getDeviceModel();

    @Nullable
    String getSdkVersion();

    @Nullable
    String getJsonId();

    @Nullable
    String getAdvertisingId();

    @Nullable
    String getLanguage();

    @Nullable
    Integer getApSegment();

    @Nullable
    String getInstallAppVersion();

    @Nullable
    String getLocaleCountry();

    @Nullable
    String getSimCountry();

    @Nullable
    String getAccountId();

    @Nullable
    Integer getScreenWidthInDp();

    @Nullable
    Integer getScreenHeightInDp();

    @Nullable
    Integer getScreenWidthInPx();

    @Nullable
    Integer getScreenHeightInPx();

    @Nullable
    String getOaid();

    @Nullable
    String getCustomerUserIdV2();

    @Nullable
    IMEI getIMEI();

    @Nullable
    String getAndroidId();

    @Nullable
    Long getMemSize();

    @Nullable
    Integer getCPUMaxFreq();

    @Nullable
    Double getFontSize();

    @Nullable
    Integer getCPUCores();

    @Nullable
    String getDownloadChannel();

    @Nullable
    String getAfId();

    @Nullable
    String getAppKey();

    class Property<T> {
        @NonNull
        private final String key;
        @NonNull
        private final T value;
        @NonNull
        private final UserPropertySupportType<T> type;

        public Property(@NonNull String key,
                        @NonNull T value,
                        @NonNull UserPropertySupportType<T> type) {
            this.key = key;
            this.value = value;
            this.type = type;
        }

        @NonNull
        public String getKey() {
            return key;
        }

        @NonNull
        public T getValue() {
            return value;
        }

        @NonNull
        public UserPropertySupportType<T> getType() {
            return type;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            } else {
                return obj instanceof Property
                        && value.equals(((Property) obj).value);
            }
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }
    }
}

