public class Mynoettext {
    public static void main(String[] args) {
        Mynide<String> c=new Mynide<>("a",null);
        Mynide<String> b=new Mynide<>("b",null);
        c.setNext(b);
        Mynide<String> d=new Mynide<>("c",null);
        b.setNext(d);
        Mynide<String> e=new Mynide<>("d",null);
        d.setNext(e);
        Mynide<String> f=c;
        while(f!=null){
            System.out.println(f.getData());
            f=f.getNext();
        }
    }
}
