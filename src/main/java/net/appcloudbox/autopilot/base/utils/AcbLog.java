package net.appcloudbox.autopilot.base.utils;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.Log;

import net.appcloudbox.autopilot.base.ApLogger;

import java.util.ArrayList;
import java.util.List;

public class AcbLog {
    private AcbLog() {
    }

    private static final ApLogger DEFAULT_LOGGER = new ApLogger() {
        @Override
        public void log(int priority, @NonNull String tag, @NonNull String msg) {
            Log.println(priority, tag, msg);
        }

        @Override
        public void debugAssert(@NonNull String msg, @Nullable Throwable cause) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                throw new AssertionError(msg, cause);
            } else {
                throw new AssertionError(msg);
            }
        }
    };

    @Nullable
    private static volatile ApLogger apLogger = DEFAULT_LOGGER;

    public static void setApLogger(@Nullable ApLogger apLogger) {
        AcbLog.apLogger = apLogger;
    }

    /**
     * Log message as verbose level, with a specified tag
     *
     * @param tag
     * @param args
     */
    public static void v(String tag, @NonNull String format, @Nullable Object... args) {
        log(Log.VERBOSE, tag, format, args);
    }

    /**
     * Log message as debug level, with a specified tag
     *
     * @param tag
     * @param args
     */
    public static void d(String tag, @NonNull String format, @Nullable Object... args) {
        log(Log.DEBUG, tag, format, args);
    }


    /**
     * Log message as info level, with a specified tag
     *
     * @param tag
     * @param args
     */
    public static void i(String tag, @NonNull String format, @Nullable Object... args) {
        log(Log.INFO, tag, format, args);
    }

    /**
     * Log message as warning level, with a specified tag
     *
     * @param tag
     * @param args
     */
    public static void w(String tag, @NonNull String format, @Nullable Object... args) {
        log(Log.WARN, tag, format, args);
    }

    /**
     * Log message as error level, with a specified tag
     *
     * @param tag
     * @param args
     */
    public static void e(String tag, @NonNull String format, @Nullable Object... args) {
        log(Log.ERROR, tag, format, args);
    }

    public static void setEnabled(boolean enabled) {
        if (enabled) {
            if (AcbLog.apLogger == null) {
                AcbLog.apLogger = DEFAULT_LOGGER;
            }
        } else {
            AcbLog.apLogger = null;
        }
    }

    public static boolean isEnable() {
        return apLogger != null;
    }

    private static void log(int priority, String tag,
                            @NonNull String format,
                            @Nullable Object... args) {
        ApLogger apLogger = AcbLog.apLogger;
        if (apLogger != null) {
            String logStr;
            if (args != null) {
                List<Object> argsStr = new ArrayList<>();
                for (Object arg : args) {
                    if (arg != null) {
                        argsStr.add(arg.toString());
                    } else {
                        argsStr.add("");
                    }
                }
                logStr = String.format(format, argsStr.toArray());
            } else {
                logStr = format;
            }

            apLogger.log(priority, tag, logStr);
        }
    }

    public static void debugAssert(@NonNull String format,
                                   @Nullable Object... args) throws AssertionError {
        ApLogger apLogger = AcbLog.apLogger;
        if (apLogger != null) {
            String logStr;
            if (args != null) {
                List<Object> argsStr = new ArrayList<>();
                for (Object arg : args) {
                    argsStr.add(arg.toString());
                }
                logStr = String.format(format, argsStr.toArray());
            } else {
                logStr = format;
            }
            AcbLog.e("", logStr);

            apLogger.debugAssert(logStr, null);
        }
    }

    public static void debugAssert(@NonNull Throwable cause,
                                   @NonNull String format,
                                   @Nullable Object... args)
            throws AssertionError {
        ApLogger apLogger = AcbLog.apLogger;
        if (apLogger != null) {
            String logStr;
            if (args != null) {
                List<Object> argsStr = new ArrayList<>();
                for (Object arg : args) {
                    argsStr.add(arg.toString());
                }
                logStr = String.format(format, argsStr.toArray());
            } else {
                logStr = format;
            }
            AcbLog.e("", logStr);

            apLogger.debugAssert(logStr, cause);
        }
    }
}
