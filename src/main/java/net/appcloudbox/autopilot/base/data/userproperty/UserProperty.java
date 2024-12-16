package net.appcloudbox.autopilot.base.data.userproperty;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.appcloudbox.autopilot.base.service.shared.UserPropertySettingKeyAliasService;
import net.appcloudbox.autopilot.base.service.shared.UserPropertySupportType;

import java.util.Map;

public final class UserProperty implements UserPropertyGetter {
    @NonNull
    private final Map<String, UserPropertyGetter.Property> allProperty;

    @Nullable
    private UserPropertySettingKeyAliasService userPropertyKeyAlias;

    public UserProperty(@NonNull Map<String, UserPropertyGetter.Property> allProperty) {
        this.allProperty = allProperty;
    }

    public void setUserPropertyKeyAlias(
            @NonNull UserPropertySettingKeyAliasService userPropertyKeyAlias) {
        this.userPropertyKeyAlias = userPropertyKeyAlias;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    @Override
    public <T> T get(@NonNull String key, @NonNull UserPropertySupportType<T> type) {
        Property property = allProperty.get(key);
        if (property != null && property.getType().equals(type)) {
            return (T) property.getValue();
        }
        return null;
    }

    @Override
    @NonNull
    public Map<String, Property> getAll() {
        return allProperty;
    }

    @Override
    @Nullable
    public Long getTimeZone() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getTimeZone(), UserPropertySupportType.LONG);
        }
        return null;
    }

    @Override
    @Nullable
    public String getDeviceId() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getDeviceId(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Nullable
    @Override
    public String getApUid() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getApUid(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Nullable
    @Override
    public String getClientDeviceId() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getClientDeviceId(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public String getBundleId() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getBundleId(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public String getPlatform() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getPlatform(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public Boolean getIsUpgradeFromAppVersionWithoutAp() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getIsUpgradeFromAppVersionWithoutAp(),
                    UserPropertySupportType.BOOL);
        }
        return null;
    }

    @Override
    @Nullable
    public String getCustomerUserId() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getCustomerUserId(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public CustomUserProperties getCustomUserProperties() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getCustomUserProperties(),
                    UserPropertySupportType.CUSTOM_USER_PROPERTIES);
        }
        return null;
    }

    @Override
    @Nullable
    public Integer getApId() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getApId(), UserPropertySupportType.INT);
        }
        return null;
    }

    @Override
    @Nullable
    public String getOsVersion() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getOsVersion(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public String getAppVersion() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getAppVersion(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public String getDeviceType() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getDeviceType(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public String getDeviceBrand() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getDeviceBrand(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public String getDeviceModel() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getDeviceModel(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public String getSdkVersion() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getSdkVersion(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public String getJsonId() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getJsonId(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public String getAdvertisingId() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getAdvertisingId(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public String getLanguage() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getLanguage(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public Integer getApSegment() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getApSegment(), UserPropertySupportType.INT);
        }
        return null;
    }

    @Override
    @Nullable
    public String getInstallAppVersion() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getInstallAppVersion(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public String getLocaleCountry() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getLocaleCountry(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public String getSimCountry() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getSimCountry(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public String getAccountId() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getAccountId(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Override
    @Nullable
    public Integer getScreenWidthInDp() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getScreenWidthInDp(), UserPropertySupportType.INT);
        }
        return null;
    }

    @Override
    @Nullable
    public Integer getScreenHeightInDp() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getScreenHeightInDp(), UserPropertySupportType.INT);
        }
        return null;
    }

    @Nullable
    @Override
    public Integer getScreenWidthInPx() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getScreenWidthInPx(), UserPropertySupportType.INT);
        }
        return null;
    }

    @Nullable
    @Override
    public Integer getScreenHeightInPx() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getScreenHeightInPx(), UserPropertySupportType.INT);
        }
        return null;
    }

    @Nullable
    @Override
    public String getOaid() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getOaid(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Nullable
    @Override
    public String getCustomerUserIdV2() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getCustomerUserIdV2(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Nullable
    @Override
    public IMEI getIMEI() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getIMEI(), UserPropertySupportType.IMEI);
        }
        return null;
    }

    @Nullable
    @Override
    public String getAndroidId() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getAndroidId(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Nullable
    @Override
    public Long getMemSize() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getMemSize(), UserPropertySupportType.LONG);
        }
        return null;
    }

    @Nullable
    @Override
    public Integer getCPUMaxFreq() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getCPUMaxFreq(), UserPropertySupportType.INT);
        }
        return null;
    }

    @Nullable
    @Override
    public Double getFontSize() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getFontSize(), UserPropertySupportType.DOUBLE);
        }
        return null;
    }

    @Nullable
    @Override
    public Integer getCPUCores() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getCPUCores(), UserPropertySupportType.INT);
        }
        return null;
    }

    @Nullable
    @Override
    public String getDownloadChannel() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getDownloadChannel(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Nullable
    @Override
    public String getAfId() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getAfId(), UserPropertySupportType.STRING);
        }
        return null;
    }

    @Nullable
    @Override
    public String getAppKey() {
        if (userPropertyKeyAlias != null) {
            return get(userPropertyKeyAlias.getAppKey(), UserPropertySupportType.STRING);
        }
        return null;
    }
}
