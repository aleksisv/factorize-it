package fp.io;

import fp.utils.PrimeTools;
import java.io.IOException;

public class ConsoleInterface {

    private IO io;
    private PrimeTools pt;

    public ConsoleInterface(IO io) {
        this.io = io;
        this.pt = new PrimeTools();
    }

    public void run() throws IOException {
        boolean isFirst = true;

        while (true) {
            if (isFirst) {
                io.print("This is you number theoretic friend!");
                isFirst = false;
            }

            System.out.println("Please select what you want to do.");
            String command = io.readLine("Commands: [pc] (Primality check), [q] (quit)");

            if (command.equals("pc")) {
                io.print("Test whether an integer is a prime!");
                primalityTest(io);
                break;
            }

            if (command.equals("quit")) {
                io.print("This was the best we could do.");
                break;
            }
        }
    }

    private void primalityTest(IO io) {
        String command = io.readLine("Give a number:");
        long number = io.readLongInput(command);
        if (pt.aksPrimalityTest(number)) {
            io.print("Number " + number + " is indeed a prime!");
        } else {
            io.print("Nope.");
        }
    }
}
