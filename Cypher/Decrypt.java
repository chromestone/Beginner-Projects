import java.io.*;
import java.util.*;

public class Decrypt {

   private static String readFile(String filename ) throws IOException {
      BufferedReader reader = new BufferedReader( new FileReader (filename));
      String         line = "";
      StringBuilder  stringBuilder = new StringBuilder();
      String         lineSeparator = System.getProperty("line.separator");
  
      while( ( line = reader.readLine() ) != null ) {
          stringBuilder.append( line );
          // stringBuilder.append( lineSeparator );
      }
  
      return stringBuilder.toString();
   }

   public static void main(String args[]) {
      Cypher myCyph = new Cypher();

      try{
         String filename = "C:\\Documents and Settings\\Test\\My Documents\\_Derek\\Program\\Cypher\\cypher.txt";
         String encryptedStr = readFile(filename); 
         System.out.println("Encrypted String is:[" + encryptedStr + "]");
         System.out.println("Decyrpting...");
         String decryptStr = myCyph.decrypt(encryptedStr);
         System.out.println("[" + decryptStr + "]");

      }
      catch (IOException A) {
         System.out.println("Something Wrong!");
      }
      //catch (NoSuchMethodError B) {
         //System.out.println("No Such Method Exception");
      //}
  }
}
