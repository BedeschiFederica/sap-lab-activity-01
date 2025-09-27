package mvc;

import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InputSourceGUI extends JFrame implements InputSource, ActionListener {

    final List<Controller> controllers = new ArrayList<>();

    public InputSourceGUI() {
        super("Input GUI");

        setSize(300, 70);
        setResizable(false);

        var updateButton = new JButton("Update");
        updateButton.addActionListener(this);

        var panel = new JPanel();
        panel.add(updateButton);

        setLayout(new BorderLayout());
        add(panel,BorderLayout.NORTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(-1);
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        this.controllers.forEach(Controller::stateChanged);
    }

    @Override
    public void addController(final Controller controller) {
        this.controllers.add(controller);
    }
}
