

import java.util.ArrayList;
import java.util.Scanner;

public class Accessoarie extends Product  {
	private static Buyer buyer;
	
	public Accessoarie(Buyer buyer) {
		this.buyer= buyer;
	}
     

         
	 Scanner scanner = new Scanner(System.in);
	public void BuyAccessoarie(int choice) {
	do {
        System.out.println("************ ACCESSORIES ************");
        ArrayList<Product> products = Product.getAllProductsFromFile();
           // temp array list to store all same types
           Product tempProductClass =new Product();//*************// 
             ArrayList<Product> Tempproducts=tempProductClass.getSelectedTypeProductsFromFile("Accessories");  ;//*************// 

        int i = 0;
        for (Product product : products) {
            if (product.getType().equals("Accessories")) {
                System.out.println(++i + product.toPrint());
            }

        }
        System.out.println(++i + "Exit");
         choice = scanner.nextInt();
        if (choice == i) {
            break;
        } else {
             buyer.addItemToCart(Tempproducts.get(choice-1)); //*************// 
        }
    } while (true);
	}
}
