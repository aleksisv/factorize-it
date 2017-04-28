package fp.factorapp;

import fp.io.ConsoleIO;

import fp.io.ConsoleInterface;
import fp.utils.Polynomial;
import fp.utils.PrimeTools;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import static java.util.stream.Collectors.joining;

/**
 * The main class.
 */
public class App {

    public static void main(String[] args) throws IOException {
//        ConsoleInterface ci = new ConsoleInterface(new ConsoleIO());
//        ci.run();

        PrimeTools pt = new PrimeTools();

        boolean[] primeOrNot = new boolean[200];
        long[] time = new long[200];
        for (int i = 2; i < primeOrNot.length; i++) {
            long t1 = System.currentTimeMillis();
            boolean prime = pt.aksPrimalityTest(i);
            long t2 = System.currentTimeMillis();

            time[i] = t2 - t1;

            if (prime) {
                primeOrNot[i] = true;
            } else {
                primeOrNot[i] = false;
            }
        }

        System.out.println(Arrays.toString(primeOrNot));
        System.out.println(Arrays.toString(time));

        FileWriter writer = new FileWriter("first200primetime.csv");

        for (int j = 0; j < time.length; j++) {
            writer.append(String.valueOf(time[j]));
            writer.append("\n");
        }
        writer.close();

//        long t1 = System.nanoTime();
//        pt.areCoprime(311343244232L, 33321332134214L);
//        long t2 = System.nanoTime();
//        p1 = p1.exponentiation(320);
//        long t3 = System.nanoTime();
//        System.out.println(t3-t2);
    }
}
