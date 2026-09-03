package day6;

public class text {
    public static void main(String[] args) {
        Derived derived = new Derived();
        derived.setBasseVar(10,20);
        derived.setDerived_var(-15,-25);
        derived.PrintBasseVar();
        derived.PrintDerivedVar();
        System.out.println("-----------------------------------------");
        derived.Print();
    }
}