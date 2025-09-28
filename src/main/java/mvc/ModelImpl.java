package mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ModelImpl implements Model {

    private int state;
    private final List<View> views = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    @Override
    public void update() {
        try {
            lock.lock();
            this.state++;
            this.views.forEach(v -> v.stateChanged(this.state));
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void addView(final View view) {
        this.views.add(view);
        view.stateChanged(this.state);
    }
}
