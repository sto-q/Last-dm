public class text {
    public static void main(String[]args){
        run a=new run("aaa",18);
        run b=new run("aaa",18);
        System.out.println(a.toString()+" "+b.toString());
        System.out.println(a.equals(b));
        System.out.println(a.hashCode()+" "+b.hashCode());
        System.out.println(a.getClass()+" "+b.getClass());
    }
}
