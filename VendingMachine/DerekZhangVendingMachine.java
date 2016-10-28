/* Derek Zhang
 * Vending Machine
 * 
 */
import java.util.*;
public class DerekZhangVendingMachine {

	public static void main(String[] args) {

		Scanner user_input = new Scanner(System.in);

		int item;
		double moneyOwed;
		while (true) {
			System.out.println("Select desired item:"
					+ "\n1) $1.25\n2) $0.75\n3) $0.90\n4) $0.75\n5) $1.50\n6) $0.75");
			item = user_input.nextInt();
			if (item == 1) {
				moneyOwed = 1.25;
				break;
			}
			else if (item == 2 || item == 4 || item == 6) {
				moneyOwed = .75;
				break;
			}
			else if (item == 3) {
				moneyOwed = .9;
				break;
			}
			else if (item == 5) {
				moneyOwed = 1.25;
				break;
			}
			else {
				System.out.println("Invalid Item");
			}
		}
		System.out.println("Enter the amount paid: ");
		moneyOwed -= user_input.nextDouble();
		if (moneyOwed > 0) {
			System.out.println("Please insert another $" + moneyOwed);
		}
		else {
			System.out.println("Thank you for buying item " + item + ". Your change is " + moneyOwed*-1);
		}
	}
}
