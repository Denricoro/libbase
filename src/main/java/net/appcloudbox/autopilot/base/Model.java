package net.appcloudbox.autopilot.base;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public abstract class Model<K, D extends Data<K>> {
    private Context context;
    public final boolean init(@NonNull Context context) {
        this.context = context;
        return init();
    }

    public boolean init() {
        return true;
    }

    protected Context getContext() {
        return context;
    }

    public abstract boolean replace(@NonNull List<D> items);

    public abstract boolean delete(@NonNull List<K> keys);

    public abstract boolean deleteAll();

    public abstract boolean update(@NonNull List<D> items);

    @NonNull
    public abstract List<D> get(@NonNull List<K> keys);

    @Nullable
    public abstract D get(@NonNull K key);

    @NonNull
    public abstract List<D> getAll();
}
