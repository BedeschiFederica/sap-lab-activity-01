package mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputSourceStd implements InputSource {

    final List<Controller> controllers = new ArrayList<>();

    public InputSourceStd() {
        System.out.println("Press <enter> to update the state");
        new Thread(() -> {
            final Scanner scanner = new Scanner(System.in);
            while (true) {
                scanner.nextLine();
                this.controllers.forEach(Controller::stateChanged);
            }
        }).start();
    }

    @Override
    public void addController(final Controller controller) {
        this.controllers.add(controller);
    }
}

