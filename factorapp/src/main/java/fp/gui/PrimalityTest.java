/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.gui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 * This is a command-class that we call when we want to determine whether an
 * integer is a prime.
 *
 * @author aleksisvuoksenmaa
 */
public class PrimalityTest implements Command {

    private Application app;
    private JTextField outputField;
    private JTextField inputField;

    /**
     * Constructor.
     *
     * @param app Application that we use to call utilities.
     * @param outputField Where the output goes.
     * @param inputField Where the input goes.
     */
    public PrimalityTest(Application app, JTextField outputField, JTextField inputField) {
        this.app = app;
        this.outputField = outputField;
        this.inputField = inputField;
    }

    /**
     * Executes a command.
     */
    @Override
    public void execute() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(this.inputField.getText());
        boolean b = m.matches();
        if (!b) {
            this.outputField.setText("Enter a positive integer, please!");
            return;
        }

        long testedInteger = Long.parseLong(this.inputField.getText());
        boolean result = app.primalityTest(testedInteger);
        if (result) {
            this.outputField.setText("Number " + testedInteger + " is a prime.");
        } else {
            this.outputField.setText("Number " + testedInteger + " is not a prime.");
        }
    }

}
