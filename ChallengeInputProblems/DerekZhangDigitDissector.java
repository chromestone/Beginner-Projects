/* Derek Zhang
 * Digit Dissector
 * Splits the input number by user into 1st place, 2nd place, etc.
 */
import java.util.*;
public class DerekZhangDigitDissector {

	public static void main(String[] args) {

		Scanner user_input = new Scanner(System.in);

		System.out.print("Enter a five digit integer: ");
		int fiveDigitNum = user_input.nextInt();
		
		/* The modulus of a five digit number by 10000 gives us
		 * the remainder which is also a four digit number that is
		 * needed further on in the program to find the rest of the
		 * digits. (there is a need to define multiple variables as
		 * they will be used twice)
		 */
		int fourDigitNum = fiveDigitNum % 10000;
		System.out.println("The first digit is: "
				+ (fiveDigitNum-fourDigitNum)/10000);
		
		int threeDigitNum = fourDigitNum % 1000;
		System.out.println("The second digit is: "
				+ (fourDigitNum-threeDigitNum)/1000);
		
		int twoDigitNum = threeDigitNum % 100;
		System.out.println("The third digit is: "
				+ (threeDigitNum-twoDigitNum)/100);
		
		int oneDigitNum = twoDigitNum % 10;
		System.out.println("The fourth digit is: "
				+ (twoDigitNum-oneDigitNum)/10);
		
		System.out.println("The fifth digit is: "
				+ oneDigitNum);
	}
}
