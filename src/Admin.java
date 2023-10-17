
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {

    private Product addNewProduct(Scanner scanner) {
        Product product = new Product();
        System.out.println("Please choose an option from below: (Enter 1, 2 )");
        System.out.println("   1.Cars");
        System.out.println("   2.Accessories");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("What Type Of Cars Are You going to add ? (Enter 1 or 2)");
            System.out.println("   1-Sport Cars");
            System.out.println("   2-Classic Cars");
            choice = scanner.nextInt();
            if (choice == 1) {
                product.setType("Sport Cars");

            } else if (choice == 2) {
                product.setType("Classic Cars");
            }
            System.out.println("Enter Car’s Name :");
            product.setName(scanner.next());
            System.out.println("Enter Car’s Price :");
            product.setPrice(scanner.nextFloat());
            System.out.println("If you want to continue choose 1 and if its not choose 2: ");
            System.out.println("   1-Save");
            System.out.println("   2-Exit");
            choice = scanner.nextInt();
            if (choice == 2) {
                return null;
            }
        } else if (choice == 2) {

            product.setType("Accessories");

            System.out.println("Enter accessories’  Name :");
            product.setName(scanner.next());
            System.out.println("Enter accessories’ Price :");
            product.setPrice(scanner.nextFloat());
            System.out.println("If you want to continue choose 1 and if its not choose 2: ");
            System.out.println("   1-Save");
            System.out.println("   2-Exit");
            choice = scanner.nextInt();
            if (choice == 2) {
                return null;
            }
        }

        return product;

    }

 public boolean deleteProduct(ArrayList<Product> products, Scanner scanner) {
        System.out.println("Please choose an option from below: (Enter 1, 2 )");
        System.out.println("   1.Cars");
        System.out.println("   2.Accessories");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("What Type Of Cars Are You going to delete ? (Enter 1 or 2)");
            System.out.println("   1-Sport Cars");
            System.out.println("   2-Classic Cars");
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Choose one Cars to delete at time (Enter Car’s Number)");
                int i = 0;
                for (Product product : products) {
                    if (product.getType().equals("Sport Cars")) {
                        System.out.println(++i + product.toPrint());
                    }
                }
                System.out.println(++i + ". Exit");
                choice = scanner.nextInt();
                if (choice == i) {
                    return false;
                } else {
                    products.remove(choice - 1);
                }

            } else if (choice == 2) {
                System.out.println("Choose one car to delete at time (Enter Car’s Number)");
                int i = 0;
                for (Product product : products) {
                    if (product.getType().equals("Classic Cars")) {
                        System.out.println(++i + product.toPrint());
                    }
                }
                System.out.println(++i + ". Exit");
                choice = scanner.nextInt();
                if (choice == i - 1) {
                    return false;
                } else {
                    products.remove(choice - 1);
                }
            }
        } else if (choice == 2) {
            System.out.println("************ ACCESSORIES ************");
            int i = 0;
            for (Product product : products) {
                if (product.getType().equals("Accessories")) {
                    System.out.println(++i + product.toPrint());
                }
            }
            System.out.println(++i + ". Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            if (choice == i) {
                return false;
            } else {
                products.remove(choice - 1);
            }
        }
        return true;
    }

    public boolean editProduct(ArrayList<Product> products, Scanner scanner) {
        System.out.println("Please choose an option from below: (Enter 1, 2 )");
        System.out.println("   1.Cars");
        System.out.println("   2.Accessories");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("What Type Of Cars Are You going to edit ? (Enter 1 or 2)");
            System.out.println("   1-Sport Cars");
            System.out.println("   2-Classic Cars");
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Choose one car to edit at time (Enter Car’s Number)");
                int i = 0;
                for (Product product : products) {
                    if (product.getType().equals("Sport Cars")) {
                        System.out.println(++i + product.toPrint());
                    }
                }
                System.out.println(++i + ". Exit");
                System.out.println(i);
                choice = scanner.nextInt();
                if (choice == i) {
                    return false;
                } else {
                    System.out.print("Enter new price :");
                    products.get(choice - 1).setPrice(scanner.nextFloat());
                }

            } else if (choice == 2) {
                System.out.println("Choose one Car to delete at time (Enter Car’s Number)");
                int i = 0;
                for (Product product : products) {
                    if (product.getType().equals("Classic Cars")) {
                        System.out.println(++i + product.toPrint());
                    }
                }
                System.out.println(++i + ". Exit");
                choice = scanner.nextInt();
                if (choice == i - 1) {
                    return false;
                } else {
                    System.out.print("Enter new price :");
                    products.get(choice - 1).setPrice(scanner.nextFloat());
                }
            }
        } else if (choice == 2) {
            System.out.println("************ ACCESSORIES ************");
            int i = 0;
            for (Product product : products) {
                if (product.getType().equals("Accessories")) {
                    System.out.println(++i + product.toPrint());
                }
            }
            System.out.println(++i + ". Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            if (choice == i - 1) {
                return false;
            } else {
                System.out.print("Enter new price :");
                products.get(choice - 1).setPrice(scanner.nextFloat());
            }
        }
        return true;
    }

  public static void main(String[] args) {
        Admin admin = new Admin();
        ArrayList<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        //you can insert
        //email = admin@gmail.com
        //password = admin
        System.out.print("Enter your email: ");
        admin.setEmail(scanner.next());
        System.out.print("Enter your password: ");
        admin.setPassword(scanner.next());
        if (admin.login("admins.txt")) {
            products = Product.getAllProductsFromFile();
            System.out.println("\t**** ~ WELCOME (" + admin.getfName() + " " + admin.getlName() + ") ~ ****");
            int choice = -1;
            while (choice != 0) {
            	//refactoring for print
            	printmenu();
                choice = scanner.nextInt();
                if (choice == 1) {
                    Product product = admin.addNewProduct(scanner);
                    if (product != null) {
                        product.saveToFile();
                        products.add(product);
                    }
                } else if (choice == 2) {
                    if (admin.deleteProduct(products, scanner)) {
                        System.out.println("If you want to continue choose 1 and if its not choose 2: ");
                        System.out.println("   1-Save");
                        System.out.println("   2-Exit");
                        choice = scanner.nextInt();
                        if (choice == 1) {
                            new File("Products.txt").delete();
                            for (Product product : products) {
                                product.saveToFile();
                            }
                        } else {
                            products = Product.getAllProductsFromFile();
                        }
                    }
                } else if (choice == 3) {
                    if (admin.editProduct(products, scanner)) {
                        System.out.println("If you want to continue choose 1 and if its not choose 2: ");
                        System.out.println("   1-Save");
                        System.out.println("   2-Exit");
                        choice = scanner.nextInt();
                        if (choice == 1) {
                            new File("Products.txt").delete();
                            for (Product product : products) {
                                product.saveToFile();
                            }
                        } else {
                            products = Product.getAllProductsFromFile();
                        }
                    }
                }

            }
        } else {
            System.out.println("your email or password incorrect");
        }
       
    }
    static void printmenu() {
    	System.out.println("Please choose one option from below : 1 , 2 , or 3 :");
        System.out.println("   1-Add new product ");
        System.out.println("   2-Delete product ");
        System.out.println("   3-Edit product ");
        System.out.println("   4-Log out ");
    }
}
