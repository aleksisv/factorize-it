/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.gui;

import javax.swing.JTextField;

/**
 *
 * @author aleksisvuoksenmaa
 */
public class PrimalityTest implements Command {
    private Application app;
    private JTextField outputField;
    private JTextField inputField;

    public PrimalityTest(Application app, JTextField outputField, JTextField inputField) {
        this.app = app;
        this.outputField = outputField;
        this.inputField = inputField;
    }
    
    @Override
    public void execute() {
        int testedInteger = Integer.parseInt(this.inputField.getText());
        boolean result = app.primalityTest(testedInteger);
        this.outputField.setText(Boolean.toString(result));
    }
    
}
