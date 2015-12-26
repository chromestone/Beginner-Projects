
import java.io.*;
import java.util.*;

public class PrimeFinder {
   public static void main(String args[]) {
      System.out.println("runningPrimeFinder...");
      int limit = 201;
      int b=0;
      for (int a=2; a<2000; a++) {
         for (b=2; b<a; b++) {
         }
         if (a % b == 0) {
            return;
         }
         else {
            System.out.println(a);
         }

      }
   }
}
