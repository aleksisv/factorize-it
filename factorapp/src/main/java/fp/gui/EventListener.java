package fp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * Listens to the events happening in the graphical interface.
 */
public class EventListener implements ActionListener {
    private Application app;
    private Map<JButton, Command> commands;

    /**
     * Constructor
     * @param test Test-execution button.
     * @param outputField Output field
     * @param inputField input field
     */
    public EventListener(JButton test, JTextField outputField, JTextField inputField) {
        this.app = new Application();
        commands = new HashMap<>();
        commands.put(test, new PrimalityTest(app, outputField, inputField));
    }

    /**
     * Executes the command if the some button is pressed.
     * @param ae Some event.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        Command command = commands.get(ae.getSource());
        if  (command!=null) {
            command.execute();
        } else {
            command.execute();
        }
    }



}
