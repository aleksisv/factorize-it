package fp.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


/**
 * Runnable interface.
 */
public class GraphicalPrimeTool implements Runnable {
    private JFrame frame;

    /**
     * Runs the interface.
     */
    @Override
    public void run() {
        frame = new JFrame("Primality test");
        frame.setPreferredSize(new Dimension(600, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }


    /**
     * Creates the needed components.
     * @param container Where the components are put.
     */
    private void createComponents(Container container) {
        frame.setLayout(new GridLayout(3, 1));
        JTextField outputField = new JTextField("Is this positive integer a prime? "
                + "(For your own safety, please stick to _primes_ less than 8000)");
        container.add(outputField);
        outputField.setEnabled(false);
        JTextField intputField = new JTextField("");
        container.add(intputField);

        JButton primalityCheck = new JButton("test");

        EventListener eventListener = new EventListener(primalityCheck, outputField, intputField);

        primalityCheck.addActionListener(eventListener);

        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.add(primalityCheck);

        container.add(panel);
    }

}
