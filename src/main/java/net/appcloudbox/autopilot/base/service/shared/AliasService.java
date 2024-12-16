package net.appcloudbox.autopilot.base.service.shared;

import androidx.annotation.NonNull;

import net.appcloudbox.autopilot.base.SharedService;

public abstract class AliasService extends SharedService {
    public static final int VERSION = 1;

    @NonNull
    public abstract String getCurrentSdkVersion();

    public abstract boolean isRule(@NonNull String caseId);

    @NonNull
    public abstract String getEventActiveAlias();

    @NonNull
    public abstract String getEventMainAppOpenAlias();

    @NonNull
    public abstract String getEventMainAppCloseAlias();

    @NonNull
    public abstract String getEventGetRemoteConfigAlias();

    @NonNull
    public abstract String getEventTestAlias();

    @NonNull
    public abstract String getEventTestSentAlias();

    @NonNull
    public abstract String getUserPropertyTimeZoneAlias();

    @NonNull
    public abstract String getUserPropertyRegionAlias();

    @NonNull
    public abstract String getUserPropertyPlatformAlias();

    @NonNull
    public abstract String getUserPropertyDeviceBrandAlias();

    @NonNull
    public abstract String getUserPropertyDeviceModelAlias();

    @NonNull
    public abstract String getUserPropertyAppVersionAlias();

    @NonNull
    public abstract String getUserPropertyOsVersionAlias();

    @NonNull
    public abstract String getUserPropertyBundleIdAlias();
}
