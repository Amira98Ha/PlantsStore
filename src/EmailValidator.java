

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ameer
 */
public class EmailValidator extends RegisterProcessChain {

    public EmailValidator(int level) {
        this.level = level;
    }


    @Override
    protected boolean validate(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    
   
}
