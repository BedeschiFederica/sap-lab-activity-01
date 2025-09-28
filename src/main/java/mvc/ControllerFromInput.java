package mvc;

public class ControllerFromInput implements Controller {

    private final Model model;

    public ControllerFromInput(final Model model) {
        this.model = model;
    }

    @Override
    public void stateChanged() {
        this.model.update();
    }
}
