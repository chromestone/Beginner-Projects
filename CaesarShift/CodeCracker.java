import java.io.*; import java.util.*;

public class CodeCracker {
   public static void main(String args[]) {
      String inputStr="";
      String decryStr="";
      Scanner user_input = new Scanner(System.in);
      System.out.println("Enter Password");
      inputStr = user_input.next();
      BufferedReader br = null;
      try {
         // assign user input string to inputStr
         //String sCurrentLine;
         //break= new BufferedReader(new FileReader("C:\Document and Settings\Test\My Documents\_Derek\SimpleSocket"));
         //while ((sCurrentLine = br.readLine()) != null {
         //   System.out.println(sCurrentLine);
         //}
         //e.printStackTrace()
         String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz123456789";
         String shift3 =   "DdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZzAaBbCc456789123";
         int length = inputStr.length();
         for (int n = 0; n < length; n++) { 
            for (int p = 0; p < 61; p++) {
               if (inputStr.charAt(n)==alphabet.charAt(p)) {
               //args first char equal to alphabet nth char
               // found first char of password, which is alphabet's index at N
               // System.out.println(n + " " + alphabet.charAt(p));
               // build decryptPss
               //String decryptPss=shift3.charAt(q);
                  decryStr= decryStr + shift3.charAt(p);
                  break; // out of inner loop
               } //end if
            }
         }
         //after finish building , write it to the file
         //FileWriter writer = new FileWriter("C:\\Documents and Settings\\Test\\My Documents\\_Derek\\SimpleSocket\\decrypt.txt");
         //writer.write(decryptPss);
         //writer.close();
      FileWriter writer = new FileWriter("C:\\Documents and Settings\\Test\\My Documents\\_Derek\\Program\\CodeCracker\\decrypt.txt");
      writer.write(decryStr);
         writer.close();
      }
      catch (IOException A) {
         System.out.println("Someting Wrong!");
      }
   }
}
                                       
