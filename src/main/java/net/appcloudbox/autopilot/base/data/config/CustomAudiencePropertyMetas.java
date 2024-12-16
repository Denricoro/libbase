package net.appcloudbox.autopilot.base.data.config;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAudiencePropertyMetas {
    @NonNull
    private final List<CustomAudiencePropertyMeta> customAudiencePropertyMetas;

    public CustomAudiencePropertyMetas(
            @NonNull List<CustomAudiencePropertyMeta> customAudiencePropertyMetas
    ) {
        this.customAudiencePropertyMetas = customAudiencePropertyMetas;
    }

    @NonNull
    public List<CustomAudiencePropertyMeta> getCustomAudiencePropertyMetas() {
        return customAudiencePropertyMetas;
    }
}
