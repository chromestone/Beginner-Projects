import java.io.*;
import java.util.*;
import java.sql.*;


////////////////////////////////////////////////////////////////////////
//          Documentation
//
//  
////////////////////////////////////////////////////////////////////////

public class Cypher
{
   // attrributes:
   int _prime;       // used for multiplaction encryption
   String _alphabet; // used to check if char of inputStr is valid 

   // constructor
   public Cypher() 
   {
      _prime = 20000297; // this prime is used for encrypt and decrpt 
      _alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890!@#$%^&*()_+-='`;:<=>?[] ";
   }

   private int computePrimedCharID(int modPrimeID)
   {
      int primedCharID = 0;
      int n = 0;
      while (true) {
         primedCharID = modPrimeID + 91 * n; //unMod algorithm
         if (primedCharID%_prime == 0) { // if the PrimeCharID is divisable by the prime then primedCharID is returned
            // System.out.println(primedCharId + "<-primedCharId   " + modPrimeID + "<-modPrimeID  " + n + "<-");
            break;
         }
         n++;
      }
      return primedCharID;
   }

   private void isValid(String inputStr) throws NoSuchFieldException 
   {
      // loop for each char in inputStr, check if it is in aphabet
      for (int a = 0; a < inputStr.length(); a++) {
         boolean found = false;

         // check this char in alphabet
         for (int b = 0; b < _alphabet.length(); b++) {
            if (inputStr.charAt(a) == _alphabet.charAt(b)) {
               found = true;
               break;
           }
         }
         // if it is not in alphabet, then throw exception
         if (found == false) {
            throw new NoSuchFieldException();
       }
     }
   }
   public String encrypt(String inputStr) throws NoSuchFieldException
   {

      isValid(inputStr);
      int shiftNum = 32; // used to shift the number so that it is 1-90 for encryption
      int totalCharIDs = 91; // it is one bigger than number range so no 0's and mods numbers after *prime 

      java.util.Date date = new java.util.Date();
      long timeStamp = date.getTime();
      // String time = "" + timeStamp; // will be later added to outputStr for decryption purposes
      // System.out.println("time=[" + time + "]");
      String outputStr = ""; //defines outputStr

      for (int n = 0; n < inputStr.length(); n++) { // used to encrypt every char of inputStr.

               int IntOfCharOfInputStr = (int)inputStr.charAt(n); // translates char of inputStr to integer
               int ShiftedInt = IntOfCharOfInputStr - shiftNum; // shifts the number so that it is shifted from 33 - 122 to 1-90 for encryption
               int encryptedNum = ShiftedInt * _prime; // multiply prime to encrypt
               int withinRangeNum = encryptedNum % totalCharIDs ; // mods to make sure withing 1-90 number range
               long timeShift = timeStamp % totalCharIDs; // uses timestamp to make a shift key from 0-90
               long shiftedByTime = withinRangeNum + timeShift; // shifts the number
               int wthnRngAftTmShft = (int)(shiftedByTime  % totalCharIDs); // makes sure withing number range 1-90
               int finalShift = wthnRngAftTmShft + shiftNum; // used add 1 to elminate 0 but decrypt has problems convertl, also to make withing range of 33-122

               // get alphabet from computed index; build output string
               //System.out.println(n + ":" + inputStr.charAt(n) + "->" + (char)(finalShift) );
               //System.out.println("n=" + n + 
                                  //"charID=" + IntOfCharOfInputStr + 
                                  //"shifted=" + ShiftedInt + 
                                  //"primed=" + encryptedNum + 
                                  //"modded=" + withinRangeNum + 
                                  //"deShifted=" + finalShift);
               //System.out.println("Encrypted String:" + outputStr);
               
               outputStr = outputStr + (char)(finalShift); 
      }
      //System.out.println("inputStr     is:" + inputStr);
      //System.out.println("outputStr after:" + outputStr);
      //for (int b = 0; b < _alphabet.length(); b++) {
         //System.out.println(_alphabet.charAt(b) + " " + (int)_alphabet.charAt(b));
      //}
      return timeStamp + outputStr;
   }

   public String decrypt(String inputStr)
   {
      String outputStr = ""; //defines outputStr
      //System.out.println(inputStr);

      if (inputStr == null) {
         return "";
      }

      // for each char at input string, first get timestamp from the head of string, with length of 10
      for (int n = 0; n < inputStr.length(); n++) {
         String subTmStmp = inputStr.substring(0,13);

         int ModOfTmStmp = (int)(Long.parseLong(subTmStmp) % 91); //gets shift key
         int aftTmShft = (int)inputStr.charAt(n) - ModOfTmStmp; // unshifts inputStr using TimeStamp's shift key
         int modPrime = aftTmShft - 32; // shifts back to 1-90 so ready for decyrption
         int primedCharID = computePrimedCharID(modPrime); //uses method to unMod
         int charID = primedCharID / _prime; //decypts multiplication encryption
         int p = charID + 32; //shifts back to 33-122 range for char

         outputStr = outputStr + (char)(p);
         //System.out.println("beforeShift(aftTmShft)=" + aftTmShft +
                            //"modPrime=" + modPrime + "primedCharID=" + primedCharID + "charID=" + charID + "=>" +p);
      }


      // when return, only return substring without timestamp head
      return outputStr.substring(13); //removes unwanted TimeStamp
   }

   public static void main(String args[])
   {

      Scanner user_input = new Scanner(System.in);
      System.out.println("Enter Password");
      String msg = user_input.next();
      String enCryptedMsg = "";


      // build object
      Cypher myCyph = new Cypher();

      try {
         // encrpyt behavior
         enCryptedMsg = myCyph.encrypt(msg);

         // write encrypted message to file
         FileWriter writer = new FileWriter("C:\\Documents and Settings\\Test\\My Documents\\_Derek\\Program\\Cypher\\cypher.txt");
         writer.write(enCryptedMsg);
         writer.close();
         System.out.println("EncryptSuccess(der.bat)");
      }
      catch (IOException A) { // Makes sure FileWriter's exceptions is caught
            System.out.println("Someting Wrong!");
      }
      catch (NoSuchFieldException A) { // exception given if not valid char give when prompted "Enter Password"
            System.out.println("Invalid Letter!");
      }
   } //end main

}
