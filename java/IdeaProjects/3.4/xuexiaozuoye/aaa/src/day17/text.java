package day17;

public class text {
    public static void main(String[] args) {
        User user=new User("AA",100);
        UserThead t1=new UserThead("线程1",user,20);
        UserThead t2=new UserThead("线程2",user,40);
        UserThead t3=new UserThead("线程3",user,30);
        UserThead t4=new UserThead("线程4",user,-60);
        UserThead t5=new UserThead("线程5",user,23);
        UserThead t6=new UserThead("线程6",user,-43);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
