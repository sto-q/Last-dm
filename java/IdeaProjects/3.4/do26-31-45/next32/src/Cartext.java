public class Cartext{
    public static void main(String[] args) {
//        Car A=new Car() {
//            @Override
//            public void show() {
//
//            }
//        };
//        Car A=color-> System.out.println(color);
//        A.show("asd");
        Car A= System.out::println;
        A.show("Asd");
//        Car B=new Car(){
//            @Override
//            public void show(String color) {
//                Cartext.add("As");
//            }
//        };
        Car B=Cartext::add;
        B.show("ASD");
//        Car B=Cartext::add;
//        B.show("AS");
    }
    public static void add(String a){
        System.out.println(a);
    }
}
