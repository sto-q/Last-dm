package src.com.lmq.layar.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

public class MD5 {
    private static final char[] chars={
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'
    };
    public static String RoundStr(int length){
        Random rand = new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
            sb.append(chars[rand.nextInt(chars.length)]);
        }
        return sb.toString();
    }
    public static String encrypt(String password, String secret){
        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
            int length1=password.length();
            int length2=secret.length();
            String Str=password.substring(0,length1)+secret.substring(0,length2)+password.substring(length1)+secret.substring(length2);
            byte[] result=md5.digest(Str.getBytes());
            return Base64.getEncoder().encodeToString(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
