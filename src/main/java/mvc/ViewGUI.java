package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewGUI extends JFrame implements View {

    private final JTextField outputField;

    public ViewGUI() {
        super("Output GUI");

        setSize(300, 70);
        setResizable(false);

        var outputLabel = new JLabel("State: ");

        outputField = new JTextField(5);
        outputField.setEditable(false);

        var panel = new JPanel();
        panel.add(outputLabel);
        panel.add(outputField);

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
    public void stateChanged(final int state) {
        SwingUtilities.invokeLater(() -> outputField.setText(Integer.toString(state)));
    }
}
