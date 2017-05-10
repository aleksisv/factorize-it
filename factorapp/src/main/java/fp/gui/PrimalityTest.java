/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.gui;

import javax.swing.JTextField;

/**
 * This is a command-class that we call when we want to determine whether
 * an integer is a prime.
 * @author aleksisvuoksenmaa
 */
public class PrimalityTest implements Command {
    private Application app;
    private JTextField outputField;
    private JTextField inputField;

    /**
     * Constructor.
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
        long testedInteger = Long.parseLong(this.inputField.getText());
        boolean result = app.primalityTest(testedInteger);
        this.outputField.setText(Boolean.toString(result));
    }

}
