package net.appcloudbox.autopilot.base.service.shared;

import androidx.annotation.NonNull;

import net.appcloudbox.autopilot.base.SharedService;

public abstract class UserPropertySettingKeyAliasService extends SharedService {
    public static final int VERSION = 6;

    @NonNull
    public abstract String getTimeZone();

    @NonNull
    public abstract String getDeviceId();

    @NonNull
    public abstract String getClientDeviceId();

    @NonNull
    public abstract String getApUid();

    @NonNull
    public abstract String getBundleId();

    @NonNull
    public abstract String getPlatform();

    @NonNull
    public abstract String getIsUpgradeFromAppVersionWithoutAp();

    @NonNull
    public abstract String getCustomerUserId();

    @NonNull
    public abstract String getCustomerUserIdV2();

    @NonNull
    public abstract String getCustomUserProperties();

    @NonNull
    public abstract String getApId();

    @NonNull
    public abstract String getOsVersion();

    @NonNull
    public abstract String getAppVersion();

    @NonNull
    public abstract String getDeviceType();

    @NonNull
    public abstract String getDeviceBrand();

    @NonNull
    public abstract String getDeviceModel();

    @NonNull
    public abstract String getSdkVersion();

    @NonNull
    public abstract String getJsonId();

    @NonNull
    public abstract String getAdvertisingId();

    @NonNull
    public abstract String getLanguage();

    @NonNull
    public abstract String getApSegment();

    @NonNull
    public abstract String getInstallAppVersion();

    @NonNull
    public abstract String getLocaleCountry();

    @NonNull
    public abstract String getSimCountry();

    @NonNull
    public abstract String getAccountId();

    @NonNull
    public abstract String getScreenWidthInDp();

    @NonNull
    public abstract String getScreenHeightInDp();

    @NonNull
    public abstract String getScreenWidthInPx();

    @NonNull
    public abstract String getScreenHeightInPx();

    @NonNull
    public abstract String getOaid();

    @NonNull
    public abstract String getAndroidId();

    @NonNull
    public abstract String getIMEI();

    @NonNull
    public abstract String getFontSize();

    @NonNull
    public abstract String getCPUCores();

    @NonNull
    public abstract String getCPUMaxFreq();

    @NonNull
    public abstract String getMemSize();

    @NonNull
    public abstract String getDownloadChannel();

    @NonNull
    public abstract String getAfId();

    @NonNull
    public abstract String getAppKey();
}
