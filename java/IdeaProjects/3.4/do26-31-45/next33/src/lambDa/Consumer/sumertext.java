package lambDa.Consumer;

import java.util.function.Consumer;

public class sumertext {
    public static void main(String[] args) {
//        Consumer<String> c = new Consumer<>(){
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
        Consumer<String> c=System.out::println;
        c.accept("Hello");
//        Consumer<String> c1=new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s.charAt(0));
//            }
//        };
        Consumer<String> c1=s->System.out.println(s.charAt(0));
        c1.accept("Hello");
        Consumer<String> c2=c.andThen(c1);
        c2.accept("Hello");
    }
}
