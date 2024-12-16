package net.appcloudbox.autopilot.base.service.shared;

import androidx.annotation.NonNull;

import net.appcloudbox.autopilot.base.data.EventData;
import net.appcloudbox.autopilot.base.data.config.CpmAssociation;
import net.appcloudbox.autopilot.base.data.config.CustomAudiencePropertyMetas;
import net.appcloudbox.autopilot.base.data.userproperty.CustomUserProperties;
import net.appcloudbox.autopilot.base.data.userproperty.GdprConsentStatus;
import net.appcloudbox.autopilot.base.data.userproperty.IMEI;
import net.appcloudbox.autopilot.base.data.userproperty.UserProperty;

public class SettingsSupportType<T> {
    public static final SettingsSupportType<Integer> INT = new SettingsSupportType<>(Integer.class);
    public static final SettingsSupportType<Double> DOUBLE
            = new SettingsSupportType<>(Double.class);
    public static final SettingsSupportType<Long> LONG = new SettingsSupportType<>(Long.class);
    public static final SettingsSupportType<Boolean> BOOL
            = new SettingsSupportType<>(Boolean.class);
    public static final SettingsSupportType<String> STRING
            = new SettingsSupportType<>(String.class);
    public static final SettingsSupportType<CustomAudiencePropertyMetas>
            CUSTOM_AUDIENCE_PROPERTY_METAS
            = new SettingsSupportType<>(CustomAudiencePropertyMetas.class);
    public static final SettingsSupportType<GdprConsentStatus> GDPR_CONSENT_STATUS
            = new SettingsSupportType<>(GdprConsentStatus.class);
    public static final SettingsSupportType<UserProperty> USER_PROPERTY
            = new SettingsSupportType<>(UserProperty.class);
    public static final SettingsSupportType<EventData> EVENT_DATA
            = new SettingsSupportType<>(EventData.class);
    public static final SettingsSupportType<CustomUserProperties> CUSTOM_USER_PROPERTIES
            = new SettingsSupportType<>(CustomUserProperties.class);
    public static final SettingsSupportType<IMEI> IMEI = new SettingsSupportType<>(IMEI.class);
    public static final SettingsSupportType<CpmAssociation> CPM_ASSOCIATION =
            new SettingsSupportType<>(CpmAssociation.class);

    @NonNull
    private final Class<T> clazz;

    protected SettingsSupportType(@NonNull Class<T> clazz) {
        this.clazz = clazz;
    }

    @NonNull
    public Class<T> getClazz() {
        return clazz;
    }
}
