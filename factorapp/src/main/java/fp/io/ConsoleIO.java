
package fp.io;

import java.util.Scanner;


public class ConsoleIO implements IO {
    private Scanner scanner;

    public ConsoleIO() {
        this.scanner = new Scanner(System.in);
    }
    
    @Override
    public void print(String string) {
        System.out.println(string);
    }
    
    

    @Override
    public long readLongInput(String prompt) {
        while(true) {
            String res = scanner.nextLine();
            try {
                long longnum = Long.parseLong(res);
                return longnum;
            } catch (Exception e) {
                System.out.println("Please enter a number!");
            }
        }
    }

    @Override
    public String readLine(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Please enter something!");
        }
    }
    
}
