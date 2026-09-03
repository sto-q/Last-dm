package classeslib;

import static java.lang.System.out;

public class MyArray{
    public static void print(int a[]) {
        for(int x:a)
            out.print(" "+x);
        out.println();
    }
}