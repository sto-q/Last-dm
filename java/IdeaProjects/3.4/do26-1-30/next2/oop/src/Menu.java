public class Menu {
    int nuber;
    String name;
    public Menu(int nuber, String name) {
        this.nuber = nuber;
        this.name = name;
    }
    public void show(){
        System.out.println(nuber + " " + name);
    }
}
