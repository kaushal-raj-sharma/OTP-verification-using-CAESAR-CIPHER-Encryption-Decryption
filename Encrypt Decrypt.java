import java.util.*;
import java.util.Random;
import java.lang.*; 
import java.io.*; 
import java.lang.reflect.Array;
/**
 * @author Kaushal
 */
public class encryption {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int len,x,num;num=0;
        len = 4; 
        x=1000;
        //initialize string
        //using random method to create new object
        Random rand = new Random();
         //Now create otp  
        int otp = rand.nextInt((9999 - 100) + 1) + 10;
        System.out.println(" Your OTP is generated below : ");
        System.out.println(otp);
        System.out.println(" Now enter the key for ENCRYPTION : ");
        int shift = sc.nextInt();
        int cipher;
        //type conversion
            cipher = 0;
        int alpha;
            alpha=otp;
         //initializing encryption sequence.....        
         // shift alphabet
             alpha = alpha + shift;
            // reshift to starting position 
             alpha = (alpha*9);
             cipher = cipher + alpha;
            
            // if alpha lies between 
             if(cipher>0) {
             // shift alphabet
             alpha = (alpha + shift);
             // if shift alpha greater than 
             if(alpha > 0) {
                 //reshift to starting position 
                 alpha =(alpha*10);
                 cipher = cipher + alpha;
             }
               } 
             // converting to string
              String st = Integer.toString(cipher);
              String reversed = reverseString(st);
    
        System.out.println(" ciphertext : " + reversed);
      
        //Initializing Decryption Sequence.....
        System.out.println(" Initializing Decryption Sequence..... ");
        System.out.println(" Enter the shift value : ");
        shift = sc.nextInt();
        //converting back to number
        st = reverseString(reversed);
        cipher = Integer.parseInt(st); 
        if(alpha>0)
        {
        cipher = cipher - alpha;
        alpha = (alpha/10);
        }
        if(cipher>0)
        {
            alpha = alpha - shift;
        }
        if(alpha >=0) 
        {
             // reshift to starting position 
             cipher = cipher - alpha;
             alpha = (alpha/9);        
        }
        alpha = (alpha - shift);
        //printing decrypted OTP
        System.out.println("Original OTP :"+alpha);
 }
 public static String reverseString(String str)
    {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
