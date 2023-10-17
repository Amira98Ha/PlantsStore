

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Product {

    private int id;
    private String name;
    private float price;
    private String type;

    public Product(int id, String name, String type , float price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Product() {
//        this.id = 0;
//        this.name = "";
//        this.price = 0;
//        this.type = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\tname=" + name + "\n\tprice=" + price + "\n\ttype=" + type+"\n";
    }

    public String toPrint() {
        return ". "+name + "     " + price + "SR per day";
    }

   
    public static ArrayList<Product> getAllProductsFromFile() {
        File file = new File("Products.txt");
        ArrayList<Product> products = new ArrayList<>();
        if (file.exists()) {

            try {
                Scanner scan = new Scanner(file);
                while (scan.hasNext()) {
                    String name = scan.nextLine().split("=")[1];
                    float price = Float.valueOf(scan.nextLine().split("=")[1]);
                    String type = scan.nextLine().split("=")[1];

                    scan.nextLine();
                    products.add(new Product(0, name, type,price));
                }
                scan.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return products;

    }

      public static ArrayList<Product> getSelectedTypeProductsFromFile(String selectedtype) {
        File file = new File("Products.txt");
        ArrayList<Product> products = new ArrayList<>();
        if (file.exists()) {

            try {
                Scanner scan = new Scanner(file);
                while (scan.hasNext()) {
                    String name = scan.nextLine().split("=")[1];
                    float price = Float.valueOf(scan.nextLine().split("=")[1]);
                    String type = scan.nextLine().split("=")[1];

                    scan.nextLine();
                    if (type.equals(selectedtype)){
                        products.add(new Product(0, name, type,price));
                    }
                }
                scan.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return products;

    }


    public void saveToFile() {
        try (FileWriter f = new FileWriter("Products.txt", true);
                BufferedWriter b = new BufferedWriter(f);
                PrintWriter p = new PrintWriter(b);) {

            p.print(this);
            p.println("-----------------------");
            p.close();
            f.close();
            b.close();
        } catch (IOException i) {
            System.out.println("Error");
        }
    }
    
    
    
    
    
    
    
    
    

}
