package net.appcloudbox.autopilot.base.service.shared;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import net.appcloudbox.autopilot.base.SharedService;
import net.appcloudbox.autopilot.base.data.EventData;
import net.appcloudbox.autopilot.base.data.NetworkResponseMeta;
import net.appcloudbox.autopilot.base.data.RequestReason;
import net.appcloudbox.autopilot.base.data.UploadReason;
import net.appcloudbox.autopilot.base.data.config.RemoteConfig;
import net.appcloudbox.autopilot.base.data.config.ToDownloadTopic;
import net.appcloudbox.autopilot.base.data.userproperty.UserPropertyGetter;

import java.util.List;

public abstract class NetworkService extends SharedService {
    public abstract void getRemoteConfig(@NonNull RequestReason requestReason,
                                         @NonNull List<ToDownloadTopic> toDownloadTopics,
                                         @NonNull UserPropertyGetter userProperty,
                                         @NonNull Callback1<RemoteConfig> callback);

    public abstract void uploadEvents(@NonNull UploadReason uploadReason,
                                      @NonNull List<EventData> events,
                                      @NonNull UserPropertyGetter userProperty,
                                      @NonNull Callback0 callback);

    public interface Callback0 {
        void onComplete(@Nullable NetworkResponseMeta meta);
    }

    public interface Callback1<Data> {
        void onComplete(@Nullable NetworkResponseMeta meta, Data data);
    }
}
