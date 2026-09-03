package classeslib;

import static java. lang.Math.sqrt;

public class MyMath{
    public static boolean isPrime(int x) {
        if(x<=1)
            return false;
        int y=(int)sqrt(x);
        for(int i=2;i<=y;i++)
            if(x%i==0)
                return false;
        return true;
    }}