
public class UsernameValidator extends RegisterProcessChain {

   public UsernameValidator(int level) {
        this.level = level;
    }


    @Override
    protected boolean validate(String username) {
        if (username.length() < 8) {
            return false;
        }
        return true;
    }


    
 
    
}
