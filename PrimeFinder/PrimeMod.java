import java.io.*;
import java.util.*;

public class PrimeMod { 
   public void PrimeFndr() {
      System.out.println("the following are prime numbers below 200");
      System.out.println("2");
      for (int n = 3; n < 200; n++) {
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
   public static void main(String args[]) {
      for (int a = 1; a < 82; a++) {
         int b = a * 83; 
            int c = b % 81 + 1 ;
            System.out.println(a + " " + c);
      }
   }
}
