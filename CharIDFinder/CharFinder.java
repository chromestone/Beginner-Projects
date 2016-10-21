import java.io.*;
import java.util.*;

public class CharFinder {
   public static void main (String args[]) { 
      Scanner user_input = new Scanner(System.in);
      System.out.println("Enter CharID");
      //" " hex is A0 or a with 2 tone mark 
      String CharID = user_input.next();
      int a = Integer.parseInt(CharID);
      System.out.println("[" + (char)a + "]");
   }
}
