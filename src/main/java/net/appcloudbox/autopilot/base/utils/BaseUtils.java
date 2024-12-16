package net.appcloudbox.autopilot.base.utils;


import androidx.annotation.NonNull;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class BaseUtils {
    private BaseUtils() {
    }

    @NonNull
    public static String getNonNull(String s) {
        if (null == s) {
            return "";
        }

        return s;
    }

    @NonNull
    public static <T> List<T> unmodifiableList(List<? extends T> l) {
        if (null == l) {
            return Collections.emptyList();
        }

        return Collections.unmodifiableList(l);
    }

    @NonNull
    public static <K, V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> m) {
        if (null == m) {
            return Collections.emptyMap();
        }

        return Collections.unmodifiableMap(m);
    }

    @NonNull
    public static <T> Set<T> unmodifiableSet(Set<? extends T> s) {
        if (null == s) {
            return Collections.emptySet();
        }

        return Collections.unmodifiableSet(s);
    }

}
