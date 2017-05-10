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
          PrimeTools pt = new PrimeTools();
          Polynomial p1 = new Polynomial(1, 23);
          System.out.println(p1);
          long t1 = System.currentTimeMillis();
          p1 = p1.modularExponentiation(500, 23);
          //p1 = p1.exponentiation(5000);
          long t2 = System.currentTimeMillis();
          System.out.println("2. Version: " + (t2-t1));
          
          long t3 = System.currentTimeMillis();
          long t4 = System.currentTimeMillis();
          System.out.println("1. Version: " + (t4-t3));
//        System.out.println(pt.aksPrimalityTest(5209));


//        GraphicalPrimeTool gpt = new GraphicalPrimeTool();
//        gpt.run();



//        boolean[] primeOrNot = new boolean[1000];
//        long[] time = new long[1000];
//        for (int i = 2; i < primeOrNot.length; i++) {
//            long t1 = System.currentTimeMillis();
//            boolean prime = pt.aksPrimalityTest(i);
//            long t2 = System.currentTimeMillis();
//
//            time[i] = t2 - t1;
//
//            if (prime) {
//                primeOrNot[i] = true;
//            } else {
//                primeOrNot[i] = false;
//            }
//        }
//        FileWriter writer = new FileWriter("first1000primetime.csv");
//
//        for (int j = 0; j < time.length; j++) {
//            writer.append(String.valueOf(time[j]));
//            writer.append("\n");
//        }
//        writer.close();
//        long t1 = System.nanoTime();
//        pt.areCoprime(311343244232L, 33321332134214L);
//        long t2 = System.nanoTime();
//        p1 = p1.exponentiation(320);
//        long t3 = System.nanoTime();
//        System.out.println(t3-t2);
    }
}
