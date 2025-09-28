package mvc;

public class Launcher {

    static public void main(String[] args) {
        final Model model = new ModelImpl();
        model.addView(new ViewLogger());
        model.addView(new ViewGUI());
        final Controller controller = new ControllerImpl(model);
        final InputSource inputSource = new InputSourceGUI();
        inputSource.addController(controller);
    }
}
