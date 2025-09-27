package mvc;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

    private int state;
    private final List<View> views = new ArrayList<>();

    @Override
    public void update() {
        this.state++;
        this.views.forEach(v -> v.stateChanged(this.state));
    }

    @Override
    public void addView(final View view) {
        this.views.add(view);
        view.stateChanged(this.state);
    }
}
