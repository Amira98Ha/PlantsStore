

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Buyer extends User {
      Scanner scanner = new Scanner(System.in);
    Order order = new Order();
    Product  Product1 = new Product();
    //codechain
    static ArrayList<User> users = new ArrayList<>();
    static RegisterProcessChain registerChain;
    
     private RegisterProcessChain getRegisterChain(){
        RegisterProcessChain emailValidator = new EmailValidator(RegisterProcessChain.EMAIL_VAL);
        RegisterProcessChain usernameValidator = new UsernameValidator(RegisterProcessChain.USERNAME_VAL);
        RegisterProcessChain passwordValidator = new PasswordValidator(RegisterProcessChain.PASSWORD_VAL);
        RegisterProcessChain mobileValidator = new MobileValidator(RegisterProcessChain.MOBILE_VAL);
        emailValidator.setNext(usernameValidator);
        usernameValidator.setNext(passwordValidator);
        passwordValidator.setNext(mobileValidator);
       
        return emailValidator;
    }

    
    public Payment pay(Scanner scanner) {
    	int cardNumber;
       
        System.out.print("Enter your card number: ");
        while(true) {
        	try {
        		cardNumber = scanner.nextInt();
        		break;
        	}
        	catch(InputMismatchException e) {
        		 System.out.print("wrong input , please enter a valid card number: ");
        		 cardNumber = scanner.nextInt();}
        
        }
            System.out.print("Enter your card name: ");
        	 String cardName = scanner.next();
        	 Date expiryDate;
        	try {
        		 System.out.print("Expiry date: (yyyy/mm/dd)");
        	        expiryDate = new Date(scanner.next());
        	}
        	catch(Exception e ) {
        		try {
        			 System.out.print("you entered the expiration date incorrectly please enter again ");
        			 System.out.print("Expiry date: (yyyy/mm/dd)");
         	        expiryDate = new Date(scanner.next());
        		}
        		catch(Exception e2 ) {
        			System.out.print("you entered the expiration date incorrectly please enter again ");
       			 System.out.print("Expiry date: (yyyy/mm/dd)");
        	        expiryDate = new Date(scanner.next());
        		}
        	}
        	System.out.print("Authorized Signature (###): ");
        	 int authorizedSigneture = scanner.nextInt();
             Payment payment = new Payment(cardNumber, expiryDate, cardName, authorizedSigneture);
             
             return payment;
        }
       
       
        
       

        

       
    
    // view cart

    public void viewCart() {
        System.out.println(order.Review());

    }
    // add item to cart

    public void addItemToCart(Object object) {
        order.AddToCart(object);

    }

    public Driver requestDriver(Scanner scanner) {

        Driver driver = new Driver();
        System.out.print("What's your city? ");
        driver.setCity(scanner.next());
        System.out.println("What date/time do you prefer to have the driver?");
        System.out.print("day: ");
        driver.getAvailableTime().setDate(scanner.nextInt());
        System.out.print("month: ");
        driver.getAvailableTime().setMonth(scanner.nextInt());
        System.out.print("year: ");
        driver.getAvailableTime().setYear(scanner.nextInt());

        System.out.print("hour: ");
        driver.getAvailableTime().setHours(scanner.nextInt());
        System.out.print("Minutes: ");
        driver.getAvailableTime().setMinutes(scanner.nextInt());
        driver.getAvailableTime().setSeconds(0);
        return driver;
    }

    public static void main(String[] args) {
        Buyer buyer = new Buyer();
         Scanner scanner = new Scanner(System.in);
         Product.getAllProductsFromFile();
         
         facade choicemaker = new facade();
         
         
         
         Product product1= new Product();
         
        
         
        int choice = 0;
        boolean notError=true;
        System.out.println("\t\tWe hope you find your desired Car!");
         while (notError) {
        try{
            
       
            System.out.println("Log in or sign up: ( choose 1 or 2)");
            System.out.println("   1.Login");
            System.out.println("   2.Signup");

           choice = scanner.nextInt();
           
            if (choice == 1) {
                
                System.out.print("Enter your email: ");
                buyer.setEmail(scanner.next());
                System.out.print("Enter your password: ");
                buyer.setPassword(scanner.next());             
                if (buyer.login("buyers.txt")) {       
                    while (choice != 0) {
                    	//refactoring for print
                    	printmenu();

                        choice = scanner.nextInt();

                        if (choice == 1) {
                      	  System.out.println("What Type Of Cars Are You Searching For? (Enter 1 or 2)");
                          System.out.println("   1-Sport Cars");
                          System.out.println("   2-Classic Cars");
                          
                            choice = scanner.nextInt();
                          //call buy car
                            choicemaker.BuyPlant(choice);
                            

                          
                        } else if (choice == 2) {

                        	 
                        	choicemaker.BuyAccessoarie(choice);

                        } else if (choice == 3) {
                           //request farmer call
                        	choicemaker.RequestFarmer();
                        } else if (choice == 4) {
                        	choicemaker.GetCart();
                        } else if (choice == 5) {
                            System.out.println("thank you");
                           return;
                        } else {
                            System.out.println("error in your choice");
                        }

                    }
                } else {
                    System.out.println("your account doesn't found please try again ");
                    continue;
                }
            } if (choice == 2) {
                
                        Buyer userAcc = new Buyer();
                        userAcc.registration();
                        continue;
                	//}//end if email
                	/*else {
                		System.out.print("your email is wrong please try again ");
                		continue;
                	}*/
                	//}
                	/*else {
                		//System.out.print("your password must contain upper and lower case latter and number and special character , please try again ");
                		continue;
                	}*/
                //}
                //end if mobile
                /*else{
                    System.out.println("your phone number is wrong please try again");
                   continue; 
                }*/
            
            }//end if choice 2 
        
         notError=false;
        
        } 
          catch(InputMismatchException e){
            
            System.out.println("wrong choice please try again");
            scanner.next();
            //continue;
            } 
        
    } }
    
    public void registration(){
        registerChain = getRegisterChain();
                Buyer userAcc = new Buyer();
                System.out.print("Enter your first name: ");
                userAcc.setfName(scanner.next());
                System.out.print("Enter your last name: ");
                userAcc.setlName(scanner.next());
                System.out.print("Enter your phone number: ");
               
                 String phone = scanner.next();
        while (!registerChain.handleRegister(RegisterProcessChain.MOBILE_VAL, phone)) {
            System.out.println("Invalid phone number, Please Enter Again :");
            phone = scanner.next();
        }
        userAcc.setNumberPhone((phone));
               // if(User.isValidMobile(Buyer.numberPhone)){
                	System.out.print("Enter your password: ");
                	password=scanner.next();
                                while (!registerChain.handleRegister(RegisterProcessChain.PASSWORD_VAL, password)) {
                       System.out.println("Password should have more than 8 characters,  Please Enter Again :");
                       password = scanner.next();
                                          }
                                userAcc.setPassword(password);
                	//if(User.isValidPassword(Buyer.password)) {
                	System.out.print("Enter your email: ");
                	email=scanner.next();
                        while (!registerChain.handleRegister(RegisterProcessChain.EMAIL_VAL, email)) {
                         System.out.println("Invalid Email, Please Enter Again :");
                         email = scanner.next();
                                                 }
                        userAcc.setEmail(email);
                	//if(User.isValidEmail(Buyer.email)){
                		System.out.print("Enter your city: ");
                        userAcc.setCity(scanner.next());
                        System.out.print("Enter your address: ");
                        userAcc.setAddress(scanner.next());
                        userAcc.register("buyers.txt");
                        System.out.println("done");
        
    }
    
 // decryption passwords
//    public static char[] decryption(String password) {
// 	   int key = 6;  
// 	   String decryptedpassword = password;
// 	   
// 	   char []chars = decryptedpassword.toCharArray();
// 	   
// 	   for(char c : chars) {
// 		   c -= key;
// 	   }
//        return chars;
//        }
     
    static void printmenu() {
    	System.out.println("Please choose an option from below: (Enter 1, 2 , 3, 4, or 5)");
        System.out.println("   1.Cars");
        System.out.println("   2.Accessories");
        System.out.println("   3.Request For Drivers");
        System.out.println("   4.Go to Cart ");
        System.out.println("   5.logout ");
    }
    @Override
    public String toString() {
        return "************ My Information ************"
                + "\nFull name: " + this.getfName() + " " + this.getlName()
                + "\nPhone number: " + this.getNumberPhone()
                + "\nCity: " + this.getCity()
                + "\nEmail: " + this.getEmail()
                + "\nMy order:" + this.order;
    }

}
