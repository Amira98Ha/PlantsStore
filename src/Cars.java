

import java.util.ArrayList;
import java.util.Scanner;

public class Cars extends Product  {


	private static Buyer buyer;
	
public	Cars( Buyer buyer){
	this.buyer= buyer;
		
	}
public Cars(){
    
}

	
public void BuyCars(int choice) {
	Order order = new Order();
        
	 Scanner scanner = new Scanner(System.in);
      if (choice == 1) {
          do {
              System.out.println("choose your favourite!");
              ArrayList<Product> products = Product.getAllProductsFromFile();
                 // temp array list to store all same types
               Product tempProductClass =new Product();//*************// 
               ArrayList<Product> Tempproducts=tempProductClass.getSelectedTypeProductsFromFile("Sport Cars");  ;//*************//

              int i = 0;
              for (Product product : products) {
                  if (product.getType().equals("Sport Cars")) {
                      System.out.println(++i + product.toPrint());
                  }

              }
              System.out.println(++i + ". Exit");
              choice = scanner.nextInt();
                 if (choice == i) {
                  break;
              } else {
                  
               buyer.addItemToCart(Tempproducts.get(choice-1)); //*************// 
               }
          } while (true);
      } else if (choice == 2) {

          do {
              System.out.println("choose your favourite!");
               ArrayList<Product> products = Product.getAllProductsFromFile();
               // temp array list to store all same types
               Product tempProductClass =new Product();//*************// 
               ArrayList<Product> Tempproducts=tempProductClass.getSelectedTypeProductsFromFile("Classic Cars");  ;//*************//
              int i = 0;
              for (Product product : products) {
                  if (product.getType().equals("Classic Cars")) {
                      
                      System.out.println(++i + product.toPrint());

                  } 
              }
              System.out.println(++i + ". Exit");
              choice = scanner.nextInt();
              if (choice == i) {
                  break;
              } else {
                  
                  buyer.addItemToCart(Tempproducts.get(choice-1)); //*************// 
                  /////
                 
              }
          } while (true);
      }
}

 //HERE CODE VISITOR*************   
  
    ////end 

}
