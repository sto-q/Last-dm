public class text {
    public static void main(String[] args) {
//        hello a=new hello() {
//            @Override
//            public void sayHello(String name) {
//                System.out.println(name);
//            }
//        };
        hello a=System.out::print;
        a.sayHello("world");
        a.show();
    }
}
