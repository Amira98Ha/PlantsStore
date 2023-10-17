
import java.util.ArrayList;
import java.util.Date;

public class Order {

    private ArrayList<Object> products;
    private static int cnt;
    private int orderNumber;
    private Date orderDate;

    public Order(ArrayList<Object> products, int orderNumber, Date orderDate) {
        this.products = products;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        cnt++;
    }

    public Order() {
        this.products = new ArrayList<>();
        this.orderNumber = ++cnt;
        this.orderDate = null;
    }

    public ArrayList<Object> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Object> products) {
        this.products = products;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean AddToCart(Object object) {
        return products.add(object);

    }

    public float getTotalPrice() {
        float total = 0;
        
        for (Object object : products) {
            if (object instanceof Product) {
                total += ((Product) object).getPrice();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "\nproducts=\n" + products + "\norderNumber=" + orderNumber + "\norderDate=" + orderDate ;
    }

    public String Review() {
        return "Number of items: " + products.size()
                + "\nTotal: " + getTotalPrice()
                + "\nOrder date: " + orderDate;
    }

    public void cancelOrder() {
        products.clear();
        orderDate = null;
        orderNumber = 0;
    }
}
