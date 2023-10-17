
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.InvalidKeyException;
import java.security.MessageDigest; 
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class User {
Scanner scanner = new Scanner(System.in);
    private String fName;
    private String lName;
    public static String email;
    public static String numberPhone;
    public static String password;
    private String address;
    private String city;
    private static final String UNICODE_FORMAT="UTF-8";
    private byte [] encrypt;


    
    public User(String fName, String lName, String email, String numberPhone, String password, String address, String city) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.numberPhone = numberPhone;
        this.password = password;
        this.address = address;
        this.city = city;
    }

    public User() {
        this.fName = "";
        this.lName = "";
        this.email = "";
        this.numberPhone = "";
        this.password = "";
        this.address = "";
        this.city = "";
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    //valid for email
    public static boolean isValidEmail(String emailToValidate) {
    // returns boolean indicating if emailToValidate matched the regex in the Regex
   
    String Regex=  "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    Pattern EmailPattern = Pattern.compile(Regex, Pattern.CASE_INSENSITIVE);
    Matcher matcher = EmailPattern.matcher(emailToValidate);
    return matcher.find(); 
    
}
//valid for mobile number
    public static boolean isValidMobile(String numberPhone){
      String regex2="^\\d{10}$";
      Pattern MobilePattern = Pattern.compile(regex2);
      Matcher matcher = MobilePattern.matcher(numberPhone);
      return matcher.find(); 
    }
    
    public static boolean isValidPassword(String password) {
    	  final int MAX=20;
                          
         
// Specifying the number of uppercase letters in password
             final int MIN_Uppercase=2;
             // Specifying the minimum lowercase letters in password
             final int MIN_Lowercase=2;
             // Specifying the number of digits in a password
             final int NUM_Digits=2;
             // Specify the minimum number of special case letters
             final int Special=2;
             // Count number of uppercase letters in a password
             int uppercaseCounter=0;
             // Counter lowercase letters in a password
             int lowercaseCounter=0;
             // Count digits in a password
             int digitCounter=0;
             // count special case letters in a password
             int specialCounter=0;
             
             for (int i=0; i < password.length(); i++ ) {
                    char c = password.charAt(i);
                    if(Character.isUpperCase(c)) 
                          uppercaseCounter++;
                    else if(Character.isLowerCase(c)) 
                          lowercaseCounter++;
                    else if(Character.isDigit(c)) 
                          digitCounter++;     
                     if(c>=33&&c<=46||c==64){
                      specialCounter++;
                  }
                    
             }
             
             if (password.length() >= MAX && uppercaseCounter >= MIN_Uppercase 
&& lowercaseCounter >= MIN_Lowercase && digitCounter >= NUM_Digits && specialCounter >= Special) { 
                 //   System.out.println("Valid Password");
                    return true;
             }
             else {
   System.out.println("Your password does not contain the following:");
                    if(password.length() < MAX)
                          System.out.println(" atleast 8 characters");
                    if (lowercaseCounter < MIN_Lowercase) 
                          System.out.println("Minimum lowercase letters");
                    if (uppercaseCounter < MIN_Uppercase) 
                          System.out.println("Minimum uppercase letters");
                    if(digitCounter < NUM_Digits) 
                          System.out.println("Minimum number of numeric digits");
                    if(specialCounter < Special)
System.out.println("Password should contain at lest 3 special characters");
                    
             }
             
        
    return false;
    }
    
 
    // encryption passwords
//   public char[] encryption(String password) {
//	   int key = 6;  
//	   String encryptedpassword = password;
//	   
//	   char []chars = encryptedpassword.toCharArray();
//	   
//	   for(char c : chars) {
//		   c += key;
//		   System.out.print(c);
//	   }
//       return chars;
//       }
//   
    
    
    public static SecretKey generateKey(String encryptionType){
        try{
            KeyGenerator keyGenerator=KeyGenerator.getInstance(encryptionType);
            SecretKey myKey=keyGenerator.generateKey();
            return myKey;
        }
        catch(Exception e){
            return null;
            
        }
    }
    
    
    public static byte[] encryptString(String dataToEncrypt,SecretKey myKey, Cipher cipher){
        try{
             byte[] text = dataToEncrypt.getBytes(UNICODE_FORMAT);
             cipher.init(Cipher.ENCRYPT_MODE,myKey);
             byte [] textEncrypted = cipher.doFinal(text);

             return textEncrypted;
        }
        catch(Exception e){
            return null;
           
        }

    }
    
    
    
    public static String decryptString(byte[] dataToDecrypt,SecretKey myKey, Cipher cipher){
        try{
            cipher.init(Cipher.DECRYPT_MODE,myKey);
            
            byte [] textDecrypted = cipher.doFinal(dataToDecrypt);
            
            String result = new String(textDecrypted);
            
            return result;
        }
        catch(Exception e){
            return null;
           

        }

    }
    
    
    
    
    public void register(String fileName) {
    	
    	
    	try{

            SecretKey key=generateKey("AES");
            Cipher chiper;
            chiper=Cipher.getInstance("AES");

            encrypt=encryptString(password,key,chiper);
            String encrypt2=new String(encrypt);
            System.out.println(encrypt2);
    	
         FileWriter f = new FileWriter(fileName, true);
                BufferedWriter b = new BufferedWriter(f);
                PrintWriter p = new PrintWriter(b); 

            p.println("fName=" + fName
                    + "\nlName=" + lName
                    + "\nemail=" + email
                    + "\nnumberPhone=" + numberPhone
                    + "\npassword=" + encrypt2
                    + "\naddress=" + address
                    + "\ncity=" + city);
            
               p.println("-----------------------");
               p.close();
               f.close();
               b.close();
            
         }
         catch (IOException i) {
            System.out.println("File not found");
        }
    	catch(Exception e){
            System.out.println(e);
        }
    

    }

    public boolean login(String fileName) {   	
      	
        try {
        	SecretKey key=generateKey("AES");
            Cipher chiper;
            chiper=Cipher.getInstance("AES");
      
            
            
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String fName = scanner.nextLine().split("=")[1];
                String lName = scanner.nextLine().split("=")[1];
                String email = scanner.nextLine().split("=")[1];
                String numberPhone = scanner.nextLine().split("=")[1];
                String password = scanner.nextLine().split("=")[1];
                String decrypt=decryptString(encrypt,key,chiper);
                String address = scanner.nextLine().split("=")[1];
                String city = scanner.nextLine().split("=")[1];
                if (this.email.equals(email) && this.password.equals(decrypt)) {
                    setfName(fName);
                    setlName(lName);
                    setNumberPhone(numberPhone);
                    setAddress(address);
                    setCity(city);
                    return true;
                   
                }
                
                scanner.nextLine();
            }
            

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            return false;
        }
        catch(InputMismatchException e) {
            System.out.println("ERROR!! - Invald data type.");
            return false;
        }
        catch(Exception e) {
        	System.out.println(e);
        }
    
    return false;}
}

