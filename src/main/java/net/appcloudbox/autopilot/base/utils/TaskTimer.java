package net.appcloudbox.autopilot.base.utils;

import android.os.Handler;

public class TaskTimer {
    private Handler mHandler;
    private Runnable mRunnable;
    private long mPeriod;
    private long mDelay;
    private boolean mRepeat;
    private boolean mCanceled;

    public TaskTimer() {
    }

    /**
     * 调用这个方法来对Timer进行Cancel。需要和schedule的调用在同一个线程上。
     */
    public void cancel() {
        mCanceled = true;

        if (mHandler != null) {
            mHandler.removeCallbacks(mRunnable);
        }

        mRunnable = null;
    }

    /**
     * 此方法会在下个周期立即执行 调用这个方法来生成并开始一个Timer，
     * 需要在一个有Looper的Thread上运行。
     * Timer触发时，目标代码会Post到调用的Thread上。
     *
     * @param runnable Timer触发时运行的目标代码
     */
    public void runAsync(Runnable runnable) {
        schedule(0, 0, false, new Handler(), runnable);
    }

    /**
     * 此方法会在下个周期 延迟 delay ms 后执行 调用这个方法来生成并开始一个Timer，
     * 需要在一个有Looper的Thread上运行。Timer触发时，目标代码会Post到调用的Thread上。
     *
     * @param delay    延迟时间
     * @param runnable Timer触发时运行的目标代码
     */
    public void runAsync(Runnable runnable, int delay) {
        schedule(delay, 0, false, new Handler(), runnable);
    }

    /**
     * 此方法会在下个周期 延迟 delay ms 后， 循环开始一个周期为 period 的任务
     * 调用这个方法来生成并开始一个Timer，需要在一个有Looper的Thread上运行。
     * Timer触发时，目标代码会Post到调用的Thread上。
     *
     * @param delay    延迟时间
     * @param period   Timer触发的间隔时间
     * @param runnable Timer触发时运行的目标代码
     */
    public void schedule(int period, Runnable runnable, int delay) {
        schedule(delay, period, true, new Handler(), runnable);
    }

    private void schedule(int delay, int period, boolean repeat,
                          Handler handler, final Runnable runnable) {
        mPeriod = period;
        mDelay = delay;
        mRepeat = repeat;
        mHandler = handler;
        mCanceled = false;

        mRunnable = new Runnable() {
            @Override
            public void run() {
                if (!mCanceled && mRunnable != null) {
                    runnable.run();
                    if (mRepeat) {
                        mHandler.postDelayed(mRunnable, mPeriod);
                    }
                }
            }
        };

        mHandler.postDelayed(mRunnable, delay);
    }

    public long getPeriod() {
        return mPeriod;
    }

    public long getDelay() {
        return mDelay;
    }

    public boolean isRepeat() {
        return mRepeat;
    }
}
