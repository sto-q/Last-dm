public class LocalClass {
    public static void main(String[] args) {
        Mo(123,345);
    }
    public static void Mo(int a,int b){
        class q{
            private int a,b;
            public q(int a, int b) {
                this.a = a;
                this.b = b;
            }
            public void aa(){
                System.out.println(a+b);
            }
        }
        q m = new q(a,b);
        m.aa();
    }
}
