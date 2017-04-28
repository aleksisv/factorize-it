package fp.io;

public class CommandCentral {

    private IO io;

    public CommandCentral() {
    }

    public CommandCentral(IO io) {
        this.io = io;
    }

    public void run() {
        while (true) {
            System.out.println("This is you number theoretic friend!\n Please select what you want to do.");
            String command = io.readLine("Commands: [pc] (Primality check), [q] (quit)");
            if (command.equals("pc")) {
                io.print("Test whether an integer is a prime!");
                break;
            }
            

            if (command.equals("q")) {
                io.print("This was the best we could do.");
                break;
            }
        }
    }

}
