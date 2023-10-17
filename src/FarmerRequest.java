

import java.util.Scanner;

public class FarmerRequest extends Driver  {
	private static Buyer buyer;
	
	public FarmerRequest(Buyer buyer) {
		this.buyer= buyer;
	}
	
	 Scanner scanner = new Scanner(System.in);
public void RequestFarmer() {
	 buyer.addItemToCart(buyer.requestDriver(scanner));
     System.out.println("Thank you, we will contact you as soon as possible!");
	
}
}
