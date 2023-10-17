
import java.util.Date;

public class Payment  {

    private int cardNumber;
    private Date expiryDate;
    private String cardName;
    private int authorizedSigneture;

    public Payment(int cardNumber, Date expiryDate, String cardName, int authorizedSigneture) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cardName = cardName;
        this.authorizedSigneture = authorizedSigneture;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getAuthorizedSigneture() {
        return authorizedSigneture;
    }

    public void setAuthorizedSigneture(int authorizedSigneture) {
        this.authorizedSigneture = authorizedSigneture;
    }

    public boolean verifyPayment() {
        return getAuthorizedSigneture() != 0 && getCardNumber()!=0 
                & getCardName() != null && getExpiryDate() != null;
    }

}
