package bao;

import java.util.Arrays;
import java.util.function.IntFunction;

public class text1 {
    public static void main(String[] args) {
        int[]i={1,3,4,6,7,8,98,54};

//        Integer[]a= Arrays.stream(i).boxed().toArray(new IntFunction<Integer[]>() {
//            @Override
//            public Integer[] apply(int value) {
//                return new Integer[value];
//            }
//        });
        Integer[]a= Arrays.stream(i).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(a));
        Integer s=5;//
        Integer S=Integer.valueOf(s);
        System.out.println(S);
        int b=S.intValue();
        System.out.println(b);
        float bb=Float.parseFloat("234.4365");
        System.out.println(bb);//long,int,double,byet,short,boolean
        boolean b1=Boolean.parseBoolean("true");
        System.out.println(b1);
        if(b1){
            System.out.println("ssstrue");
        }
    }
}
