import java.io.*;
import java.util.*;

public class Prime { 
   public static void main(String args[]) {
      System.out.println("the following are prime numbers below 200");
      System.out.println("2");
      for (int n = 20000200; n < 20000301; n++) {
         boolean isPrime=true; 
         for (int i = n - 1; i > 1; i--) {
            if (n % i == 0) {
               isPrime=false;
               //System.out.println(n+" " +i);
               break;
            }
         }
         if (isPrime==true) {
            System.out.println(n);
         }
         //System.out.println("Im always here"+n);
      }
   }
}
