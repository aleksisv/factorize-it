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

public class GraphicalPrimeTool implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Primality test");
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        frame.setLayout(new GridLayout(3, 1));
        JTextField outputField = new JTextField("Is this integer a prime?");
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
