public class text {
    public static void main(String[] args) {
        Ar a=new Ar() {
            @Override
            public void move() {
                System.out.println("move");
            }
        };
        a.move();
        Amonal b=new Amonal(){
            @Override
            public void eat() {
                System.out.println("eat");
            }
        };
        b.eat();
        Ar c=()-> System.out.println("cccc");
        c.move();
        asd sb=()->(int)(Math.random()*10);
        System.out.println(sb.zxc());
    }
}
