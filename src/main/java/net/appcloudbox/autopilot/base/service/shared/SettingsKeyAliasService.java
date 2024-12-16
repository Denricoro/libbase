package net.appcloudbox.autopilot.base.service.shared;

import androidx.annotation.NonNull;

import net.appcloudbox.autopilot.base.SharedService;

public abstract class SettingsKeyAliasService extends SharedService {
    public static final int VERSION = 6;

    @NonNull
    public abstract String getFirstLaunchTime();

    @NonNull
    public abstract String getFirstLaunchSdkVersion();

    @NonNull
    public abstract String getSharedLastAppVersion();

    @NonNull
    public abstract String getIsolatedLastAppVersion();

    @NonNull
    public abstract String getSharedLastAppVersionCode();

    @NonNull
    public abstract String getIsolatedLastAppVersionCode();

    @NonNull
    public abstract String getSharedLastSdkVersion();

    @NonNull
    public abstract String getIsolatedLastSdkVersion();

    @NonNull
    public abstract String getServerTimeMillisOffset();

    @NonNull
    public abstract String getCustomAudienceChangedGetIntervalInSecs();

    @NonNull
    public abstract String getConnectivityChangedGetIntervalInSecs();

    @NonNull
    public abstract String getTimerGetIntervalInSecs();

    @NonNull
    public abstract String getCustomAudiencePropertyMetas();

    @NonNull
    public abstract String getLoginAccount();

    @NonNull
    public abstract String getLogActiveTime();

    @NonNull
    public abstract String getLastRequestSucceedTime();

    @NonNull
    public abstract String getFirstLoginTime();

    @NonNull
    public abstract String getFirstLoginAppVersion();

    @NonNull
    public abstract String getFirstLoginAppVersionCode();

    @NonNull
    public abstract String getLastServerSideUserProperty();

    @NonNull
    public abstract String getHasUserRefreshConfigRequest();

    @NonNull
    public abstract String getFakeMainAppCloseCache();

    @NonNull
    public abstract String getGdprConsentStatus();

    @NonNull
    public abstract String getIsNewInitialUser();

    @NonNull
    public abstract String getFirstGrantGdprTime();

    @NonNull
    public abstract String getHasUserRequestRefreshConfigVersion();

    @NonNull
    public abstract String getLastUpgradeTime();

    @NonNull
    public abstract String getCpmAssociation();
}
