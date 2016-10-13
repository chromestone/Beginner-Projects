import java.util.*;
import java.io.*;

public class InvertMatrix {

   public static void matrixInverse(ArrayList<double[]> Matrix) {

      //"unpacks" the contents in the matrix array to get a 3x3 matrix
      double[] Row1 = Matrix.get(0);
      double[] Row2 = Matrix.get(1);
      double[] Row3 = Matrix.get(2);
      //creates 3 rows with 3 columns for the identity matrix
      double[] invMaR1 = new double[3];
      double[] invMaR2 = new double[3];
      double[] invMaR3 = new double[3];
      //defines the values fore each row and column
      invMaR1[0] = 1; invMaR1[1] = 0; invMaR1[2] = 0;
      invMaR2[0] = 0; invMaR2[1] = 1; invMaR2[2] = 0;
      invMaR3[0] = 0; invMaR3[1] = 0; invMaR3[2] = 1;
/////////////////////////////////////////////////////////
     //inverse existence checker 
//1. checks for 0's in places where there should eventually be 1, a row is then added to the row of the 0
//2. checks if a column 
/////////////////////////////////////////////////////////
      //A is the matrix and [Row, Column]
      //checks if A[1x1] is 0
      if (Row1[0] == 0) {
         //checks if A[2x1] is not 0
         if (Row2[0] != 0) {
            //adds Row 2 to Row 1
            Row1[0] = Row1[0] + Row2[0];
            Row1[1] = Row1[1] + Row2[1];
            Row1[2] = Row1[2] + Row2[2];
            invMaR1[0] = invMaR1[0] + invMaR2[0];
            invMaR1[1] = invMaR1[1] + invMaR2[1];
            invMaR1[2] = invMaR1[2] + invMaR2[2];
         }
         //checks if A[3x1] is not 0
         else if (Row3[0] != 0) {
            //add Row 3 to Row 1
            Row1[0] = Row1[0] + Row2[0];
            Row1[1] = Row1[1] + Row2[1];
            Row1[2] = Row1[2] + Row2[2];
            invMaR1[0] = invMaR1[0] + invMaR2[0];
            invMaR1[1] = invMaR1[1] + invMaR2[1];
            invMaR1[2] = invMaR1[2] + invMaR2[2];
         }
         //if A[1x1], A[2x1], and A[3x1] are all 0 then the matrix is not invertable
         else {
            System.out.println("No Inverse");
         }
      }
      //checks if A[2x2] is 0
      if (Row2[1] == 0) {
         //checks if A[1x2] is not 0
         if (Row1[1] != 0) {
            //adds Row 1 to Row2 
            Row2[0] = Row2[0] + Row1[0];
            Row2[1] = Row2[1] + Row1[1];
            Row2[2] = Row2[2] + Row1[2];
            invMaR2[0] = invMaR2[0] + invMaR1[0];
            invMaR2[1] = invMaR2[1] + invMaR1[1];
            invMaR2[2] = invMaR2[2] + invMaR1[2];
         }
         //checks if A[3x2] is not 0
         else if (Row3[1] != 0) {
            //add Row 3 to Row 2 
           Row2[0] = Row2[0] + Row3[0];
           Row2[1] = Row2[1] + Row3[1];
           Row2[2] = Row2[2] + Row3[2];
           invMaR2[0] = invMaR2[0] + invMaR3[0];
           invMaR2[1] = invMaR2[1] + invMaR3[1];
           invMaR2[2] = invMaR2[2] + invMaR3[2];
         }
         //if A[lx2], A[2x2], and A[3x2] are all 0 then the matrix is not invertable
         else {
            System.out.println("No Inverse");
         }
      }
      //checks if A[3x3] is 0
      if (Row3[2] == 0) {
         //checks if A[1x3] is not 0
         if (Row1[2] != 0) {
            //adds Row 2 to Row3 
            Row3[0] = Row3[0] + Row1[0];
            Row3[1] = Row3[1] + Row1[1];
            Row3[2] = Row3[2] + Row1[2];
            invMaR3[0] = invMaR3[0] + invMaR1[0];
            invMaR3[1] = invMaR3[1] + invMaR1[1];
            invMaR3[2] = invMaR3[2] + invMaR1[2];
        }
         //checks if A[2x3] is not 0
        else if (Row2[2] != 0) {
            //add Row 2 to Row 3 
           Row3[0] = Row3[0] + Row2[0];
           Row3[1] = Row3[1] + Row2[1];
           Row3[2] = Row3[2] + Row2[2];
           invMaR3[0] = invMaR3[0] + invMaR2[0];
           invMaR3[1] = invMaR3[1] + invMaR2[1];
           invMaR3[2] = invMaR3[2] + invMaR2[2];
        }
         //if A[lx3], A[2x3], and A[3x3] are all 0 then the matrix is not invertable
        else {
           System.out.println("No Inverse");
        }
      }
/////////////////////////////////////////////////////////
//step 1:begin converting to echelon form, x is any number, and the identity matrix is left out of the drawing
      // |x x x | 
      // |0 x x |
      // |x x x | row 1 is added to row 2
      if (Row2[0] != 0) {
         //the number used to change a specific number in a row to 0 by adding a row multiplied by this number
         double factor = Row2[0]/ Row1[0];
         //changes the input matrix while changing the identity matrix
         Row2[0] = factor*Row1[0]-Row2[0];
         Row2[1] = factor*Row1[1]-Row2[1];
         Row2[2] = factor*Row1[2]-Row2[2];
         invMaR2[0] = factor*invMaR1[0]-invMaR2[0];
         invMaR2[1] = factor*invMaR1[1]-invMaR2[1];
         invMaR2[2] = factor*invMaR1[2]-invMaR2[2];
      }
//step 2: |x x x | row 1 is added to row 3
      //  |0 x x |
      //  |0 x x |
      if (Row3[0] != 0) {
         double factor = Row3[0]/ Row1[0];
         Row3[0] = factor*Row1[0]-Row3[0];
         Row3[1] = factor*Row1[1]-Row3[1];
         Row3[2] = factor*Row1[2]-Row3[2];
         invMaR3[0] = factor*invMaR1[0]-invMaR3[0];
         invMaR3[1] = factor*invMaR1[1]-invMaR3[1];
         invMaR3[2] = factor*invMaR1[2]-invMaR3[2];
      }
//step 3: row echelon form is completed by adding row 2 to row 3
      // | x x x |
      // |0 x x |
      // |0 0 x |
      if (Row3[1] != 0) {
         double factor = Row3[1]/ Row2[1];
         Row3[0] = factor*Row2[0]-Row3[0];
         Row3[1] = factor*Row2[1]-Row3[1];
         Row3[2] = factor*Row2[2]-Row3[2];
         invMaR3[0] = factor*invMaR2[0]-invMaR3[0];
         invMaR3[1] = factor*invMaR2[1]-invMaR3[1];
         invMaR3[2] = factor*invMaR2[2]-invMaR3[2];
      }
//step 4: two more zeros until inverse matrix, row 3 is added onto row 2
      // |x x x|
      // |0 x 0|
      // |0 0 x|
      if (Row2[2] != 0) {
         double factor = Row2[2]/ Row3[2];
         Row2[0] = factor*Row3[0]-Row2[0];
         Row2[1] = factor*Row3[1]-Row2[1];
         Row2[2] = factor*Row3[2]-Row2[2];
         invMaR2[0] = factor*invMaR3[0]-invMaR2[0];
         invMaR2[1] = factor*invMaR3[1]-invMaR2[1];
         invMaR2[2] = factor*invMaR3[2]-invMaR2[2];
      }
//step 5 1 more zero left until inverse matrix, row 3 is added onto row 1
      // |x x 0|
      // |0 x 0|
      // |0 0 x|
      if (Row1[2] != 0) {
         double factor = Row1[2]/ Row3[2];
         Row1[0] = factor*Row3[0]-Row1[0];
         Row1[1] = factor*Row3[1]-Row1[1];
         Row1[2] = factor*Row3[2]-Row1[2];
         invMaR1[0] = factor*invMaR3[0]-invMaR1[0];
         invMaR1[1] = factor*invMaR3[1]-invMaR1[1];
         invMaR1[2] = factor*invMaR3[2]-invMaR1[2];
      }
      //step 6: last and final step, row 2 is added onto row 1
      // |x 0 0 |
      // |0 x 0 |
      // |0 0 x |
      if (Row1[1] != 0) {
         double factor = Row1[1]/ Row2[1];
         Row1[0] = factor*Row2[0]-Row1[0];
         Row1[1] = factor*Row2[1]-Row1[1];
         Row1[2] = factor*Row2[2]-Row1[2];
         invMaR1[0] = factor*invMaR2[0]-invMaR1[0];
         invMaR1[1] = factor*invMaR2[1]-invMaR1[1];
         invMaR1[2] = factor*invMaR2[2]-invMaR1[2];
      }
      //converts where the x are to ones
      // |x 0 0 |
      // |0 x 0 |
      // |0 0 x |
      Row1[1] = Row1[1]/ Row1[0];
      Row1[2] = Row1[2]/ Row1[0];
      invMaR1[0] = invMaR1[0]/ Row1[0];
      invMaR1[1] = invMaR1[1]/ Row1[0];
      invMaR1[2] = invMaR1[2]/ Row1[0];
      //the place where the 1 should be is calculated last or incorrect calculations for the whole row
      Row1[0] = Row1[0]/ Row1[0];
      Row2[0] = Row2[0]/ Row2[1];
      Row2[2] = Row2[2]/ Row2[1];
      invMaR2[0] = invMaR2[0]/ Row2[1];
      invMaR2[1] = invMaR2[1]/ Row2[1];
      invMaR2[2] = invMaR2[2]/ Row2[1];
      Row2[1] = Row2[1]/ Row2[1];
      Row3[0] = Row3[0]/ Row3[2];
      Row3[1] = Row3[1]/ Row3[2];
      invMaR3[0] = invMaR3[0]/ Row3[2];
      invMaR3[1] = invMaR3[1]/ Row3[2];
      invMaR3[2] = invMaR3[2]/ Row3[2];
      Row3[2] = Row3[2]/ Row3[2];

      System.out.println(Row1[0] + "\t" + Row1[1] + "\t" + Row1[2] + " | " + invMaR1[0] + "\t" + invMaR1[1] + "\t" + invMaR1[2]);
      System.out.println(Row2[0] + "\t" + Row2[1] + "\t" + Row2[2] + " | " + invMaR2[0] + "\t" + invMaR2[1] + "\t" + invMaR2[2]);
      System.out.println(Row3[0] + "\t" + Row3[1] + "\t" + Row3[2] + " | " + invMaR3[0] + "\t" + invMaR3[1] + "\t" + invMaR3[2]);
   }
   public static void main (String[] args){

      try {
      //creates Buffered Reader to read file
      BufferedReader readMatrix = new BufferedReader(new FileReader("C:\\Documents and Settings\\Test\\My Documents\\_Derek\\Program\\3x3MatrixInverter\\Matrix.txt"));
      String currentRow;
      //creates 3 rows with 3 columns of the matrix to be inverted
      double[] Row1 = new double[3];
      double[] Row2 = new double[3];
      double[] Row3 = new double[3];
      //reads the first line or row
		currentRow = readMatrix.readLine();
      //splits the first row by spaces
      String[] R1 = currentRow.split(" ");
      //defines the values for each row and column by pairing with the String array
      Row1[0] = Double.parseDouble(R1[0]);
      Row1[1] = Double.parseDouble(R1[1]);
      Row1[2] = Double.parseDouble(R1[2]);
		currentRow = readMatrix.readLine();
      String[] R2 = currentRow.split(" ");
      Row2[0] = Double.parseDouble(R2[0]);
      Row2[1] = Double.parseDouble(R2[1]);
      Row2[2] = Double.parseDouble(R2[2]);
		currentRow = readMatrix.readLine();
      String[] R3 = currentRow.split(" ");
      Row3[0] = Double.parseDouble(R3[0]);
      Row3[1] = Double.parseDouble(R3[1]);
      Row3[2] = Double.parseDouble(R3[2]);
      readMatrix.close();
      //"packs" the 3 rows into an array list
      ArrayList<double[]> Matrix = new ArrayList<double[]>();
      Matrix.add(Row1);
      Matrix.add(Row2);
      Matrix.add(Row3);
      matrixInverse(Matrix);
      }
      catch (IOException a) {
         System.err.println("Error when reading file.");
         a.printStackTrace();
      }
   }
}
