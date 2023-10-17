
public class PasswordValidator extends RegisterProcessChain{
    
    
    public PasswordValidator(int level) {
        this.level = level;
    }


    @Override
    protected boolean validate(String password) {
        if (password.length() < 8) {
            return false;
        }
        return true;
    }

    
    
}

