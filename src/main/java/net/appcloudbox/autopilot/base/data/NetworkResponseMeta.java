package net.appcloudbox.autopilot.base.data;

import androidx.annotation.Nullable;

public class NetworkResponseMeta {
    private final int code;
    @Nullable
    private final String msg;

    public NetworkResponseMeta(int code, @Nullable String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    @Nullable
    public String getMsg() {
        return msg;
    }
}
