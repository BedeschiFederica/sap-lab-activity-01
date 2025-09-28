package mvc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ControllerFromInput implements Controller {

    private final Model model;
    private final Lock lock = new ReentrantLock();

    public ControllerFromInput(final Model model) {
        this.model = model;
    }

    @Override
    public void stateChanged() {
        try {
            this.lock.lock();
            this.model.update();
        } finally {
            this.lock.unlock();
        }
    }
}
