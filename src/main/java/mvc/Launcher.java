package mvc;

public class Launcher {

    static public void main(String[] args) {
        final Model model = new ModelImpl();
        model.addView(new ViewLogger());
        model.addView(new ViewGUI());
        final Controller controller = new ControllerFromInput(model);
        (new InputSourceGUI()).addController(controller);
        (new InputSourceStd()).addController(controller);
        new AutonomousController(model);
    }
}
