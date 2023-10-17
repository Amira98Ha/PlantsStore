
public abstract class RegisterProcessChain {
      
    public static int EMAIL_VAL = 1;
    public static int USERNAME_VAL = 2;
    public static int PASSWORD_VAL = 3;
    public static int MOBILE_VAL = 4;

    protected int level;

    //next element in the chain of responsibility
    protected RegisterProcessChain next;


    public void setNext(RegisterProcessChain next) {
        this.next = next;
    }

    public boolean handleRegister(int level, String value) {
    	
    	boolean result = false;

        if (this.level == level) {
            result = validate(value);
        }
        else if (next != null) {
            result = next.handleRegister(level, value);
        }
        return result;
    }

    abstract protected boolean validate(String value);


    
}
