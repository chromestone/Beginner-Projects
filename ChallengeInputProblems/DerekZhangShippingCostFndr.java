/* Derek Zhang
 * Shipping Cost Finder(by pounds)
 * Calculates the total shipping cost given cost per pound
 * and total weight from user
 */
import java.util.*;
public class DerekZhangShippingCostFndr {

	public static void main(String[] args) {
		
		Scanner user_input = new Scanner(System.in);
		
		System.out.print("Enter weight of package(pounds): ");
		double packageWeight = user_input.nextFloat();
		
		System.out.print("Enter shipping price: ");
		double shippingPrice = user_input.nextFloat();
		
		//calculates the total cost
		//also refines the number by rounding and 
		double totalCost = ((int)(100*(shippingPrice*packageWeight+.005)))/100;
		System.out.println(totalCost);
	}
}
