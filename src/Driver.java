
import java.util.Date;

public class Driver extends User {

    private Date availableTime;

    public Driver() {
        super();
        availableTime = new Date();

    }

    public Driver(Date availableTime, String fName, String lName, String email, String numberPhone, String password, String address, String city) {
        super(fName, lName, email, numberPhone, password, address, city);
        this.availableTime = availableTime;
    }

    public Driver(Date availableTime) {
        this.availableTime = availableTime;
    }

    public Date getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(Date availableTime) {
        this.availableTime = availableTime;
    }

    @Override
    public String toString() {
        return "\tDriver{" + "availableTime=" + availableTime + '}';
    }
    

}
