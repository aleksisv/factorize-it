package fp.factorapp;

import fp.gui.GraphicalPrimeTool;

import fp.utils.Polynomial;
import fp.utils.PrimeTools;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import static java.util.stream.Collectors.joining;

/**
 * The main class.
 */
public class App {

    public static void main(String[] args) throws IOException {
        GraphicalPrimeTool gpt = new GraphicalPrimeTool();
        gpt.run();
        
    }
}
