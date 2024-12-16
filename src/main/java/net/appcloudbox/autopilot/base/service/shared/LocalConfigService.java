package net.appcloudbox.autopilot.base.service.shared;

import androidx.annotation.NonNull;

import net.appcloudbox.autopilot.base.SharedService;
import net.appcloudbox.autopilot.base.data.config.LocalConfig;

public abstract class LocalConfigService extends SharedService {
    @NonNull
    public abstract LocalConfig getLocalConfig();
}
