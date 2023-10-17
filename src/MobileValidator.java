
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ameer
 */
public class MobileValidator extends RegisterProcessChain {

    public MobileValidator(int level) {
        this.level = level;
    }


    @Override
    protected boolean validate(String mobile) {
        String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }

    
    
}
