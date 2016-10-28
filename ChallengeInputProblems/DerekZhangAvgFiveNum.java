/* Derek Zhang
 * Averages Five Numbers
 * Gets user inputs of five numbers and averages them
 */
import java.util.*;
public class DerekZhangAvgFiveNum {

	public static void main(String[] args) {
		//creates scanner that will be used to get numbers from user
		Scanner user_input = new Scanner(System.in);

		/* although this double is not yet the average
		 * it will be by the end of the program
		 */
		System.out.print("Enter first digit: ");
		double average = user_input.nextDouble();
		System.out.print("Enter second digit: ");
		average += user_input.nextDouble();
		System.out.print("Enter third digit: ");
		average += user_input.nextDouble();
		System.out.print("Enter fourth digit: ");
		average += user_input.nextDouble();
		System.out.print("Enter fith(final) digit: ");
		average += user_input.nextDouble();
		
		//calculates average by dividing by 5 and displays average
		average /= 5;
		System.out.println(average);
	}
}
