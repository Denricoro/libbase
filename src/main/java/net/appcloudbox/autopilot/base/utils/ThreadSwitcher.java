package net.appcloudbox.autopilot.base.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSwitcher {
    private ThreadSwitcher() {
    }

    private static final int MAX_CON_CURRENT_THREAD_SIZE = 4;
    private static volatile Handler sSerialExecutor;
    private static volatile Handler sDBExecutor;
    private static volatile ScheduledExecutorService sConcurrentExecutor;
    private static Handler sMainHandler = new Handler(Looper.getMainLooper());

    private static String sSerialThreadName = "";
    private static String sDBThreadName = "";
    private static String sConcurrentThreadName = "";

    private static Map<Runnable, TaskTimer> runningScheduleTask = new HashMap<>();

    public static void runOnMainThread(Runnable r) {
        runOnMainThread(r, 0);
    }

    public static void runOnMainThread(Runnable r, long delay) {
        sMainHandler.postDelayed(r, delay);
    }

    public static void setSerialThreadName(@NonNull String name) {
        sSerialThreadName = name;
    }

    public static void runOnSerialThread(Runnable r) {
        runOnSerialThread(r, 0);
    }

    public static void runOnSerialThread(final Runnable r, long delay) {
        initSerialExecutor();

        sSerialExecutor.postDelayed(r, delay);
    }

    public static void scheduleOnSerialThreadWithFixedDelay(final @NonNull Runnable r,
                                                            final long initialDelay,
                                                            final long delay) {
        initSerialExecutor();
        sSerialExecutor.post(new Runnable() {
            @Override
            public void run() {
                TaskTimer taskTimer = new TaskTimer();
                taskTimer.schedule((int) delay, r, (int) initialDelay);
                TaskTimer old = runningScheduleTask.put(r, taskTimer);
                if (old != null) {
                    old.cancel();
                }
            }
        });
    }

    public static void cancelScheduleOnSerialThread(final @NonNull Runnable r) {
        initSerialExecutor();
        sSerialExecutor.post(new Runnable() {
            @Override
            public void run() {
                TaskTimer taskTimer = runningScheduleTask.remove(r);
                if (taskTimer != null) {
                    taskTimer.cancel();
                }
            }
        });
    }

    private static void initSerialExecutor() {
        if (sSerialExecutor == null) {
            synchronized (ThreadSwitcher.class) {
                if (sSerialExecutor == null) {
                    HandlerThread handlerThread = new HandlerThread(sSerialThreadName);
                    handlerThread.start();
                    sSerialExecutor = new Handler(handlerThread.getLooper());
                }
            }
        }
    }

    public static void setConcurrentThreadName(@NonNull String name) {
        sConcurrentThreadName = name;
    }

    public static void runOnConcurrentThread(Runnable r) {
        runOnConcurrentThread(r, 0);
    }

    public static void runOnConcurrentThread(Runnable r, long delay) {
        if (sConcurrentExecutor == null) {
            synchronized (ThreadSwitcher.class) {
                if (sConcurrentExecutor == null) {
                    sConcurrentExecutor = new NotCatchErrorExecutor(MAX_CON_CURRENT_THREAD_SIZE,
                            new NamedThreadFactory(sConcurrentThreadName));
                }
            }
        }

        sConcurrentExecutor.schedule(r, delay, TimeUnit.MILLISECONDS);
    }

    public static void setDBThreadName(@NonNull String name) {
        sDBThreadName = name;
    }

    public static void runOnDBThread(Runnable r) {
        runOnDBThread(r, 0);
    }

    public static void runOnDBThread(final Runnable r, long delay) {
        initDBExecutor();
        sDBExecutor.postDelayed(r, delay);
    }

    private static void initDBExecutor() {
        if (sDBExecutor == null) {
            synchronized (ThreadSwitcher.class) {
                if (sDBExecutor == null) {
                    HandlerThread handlerThread = new HandlerThread(sDBThreadName);
                    handlerThread.start();
                    sDBExecutor = new Handler(handlerThread.getLooper());
                }
            }
        }
    }

    public interface ThreadExecutor {
        void run(Runnable r);

        void run(Runnable r, long delay);
    }

    private static class NamedThreadFactory implements ThreadFactory {
        private ThreadGroup group;
        private AtomicInteger threadNumber = new AtomicInteger(1);
        private String namePrefix;
        private int priority;

        NamedThreadFactory(String namePrefix) {
            init(namePrefix, Thread.NORM_PRIORITY);
        }

        NamedThreadFactory(String namePrefix, int priority) {
            init(namePrefix, priority);
        }

        private void init(String namePrefix, int priority) {
            SecurityManager s = System.getSecurityManager();
            this.group = s != null ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = namePrefix;
            this.priority = priority;
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(this.group, r,
                    this.namePrefix + this.threadNumber.getAndIncrement(),
                    0L);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }

            if (t.getPriority() != priority) {
                t.setPriority(priority);
            }

            return t;
        }
    }

    private static final class NotCatchErrorExecutor extends ScheduledThreadPoolExecutor {
        NotCatchErrorExecutor(int corePoolSize, ThreadFactory threadFactory) {
            super(corePoolSize, threadFactory);
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
            Future<?> f = (Future<?>) r;
            try {
                f.get();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }
}
