

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cart extends Order {
	private static Buyer buyer;
	
public	Cart(Buyer buyer){
	this.buyer= buyer;
	}

Scanner scanner = new Scanner(System.in);
public void GetCart() {
	boolean notError=true;
        while(notError){
            try{
    if (buyer.order.getProducts().isEmpty()) {
        System.out.println("you have not ordered any thing!");
    } else {
        buyer.order.setOrderDate(new Date());
        buyer.viewCart();
        System.out.println("If you want to pay/cancel , enter pay or cancel :");
        String e = scanner.next();
        while(!e.equalsIgnoreCase("cancel")&&!e.equalsIgnoreCase("pay")) {
        	System.out.println("you entered a wrong input , please try again");
        	System.out.println("If you want to pay/cancel , enter pay or cancel :");
        	e = scanner.next();
        }
        if (e.equals("pay")) {
            Payment payment = buyer.pay(scanner);
            if (payment.verifyPayment()) {
                System.out.println("Thank you! We have received your order");

                System.out.println(buyer);
                break;
                
            }
            //break;
            
        } else {
            buyer.order.cancelOrder();
            break;
        }
        
                 }
                  notError=false;
            }
            catch(InputMismatchException e){
            
            System.out.println("wrong choice please try again");
            scanner.next();
            //continue;
            } 
        }//
}
}
