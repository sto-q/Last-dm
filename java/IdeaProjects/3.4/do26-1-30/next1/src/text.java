import java.util.Scanner;
public class text {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        T t=new T();
        for(int i=0;i<3;i++){
            String name=sc.next();
            int age=sc.nextInt();
            int xx=sc.nextInt();
            t.add(new Student(name,age,xx));
        }
        t.show();
    }
}