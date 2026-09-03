@FunctionalInterface//表示只能有一个接口方法
public interface hello {
    void sayHello(String name);
    static void sayHello() {
        System.out.println("hello");
    }
    default void show(){
        sayHello("world");
    }
}
