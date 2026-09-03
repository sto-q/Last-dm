public class muen{
    public int sum;
    public String name;
    public muen(){
        this(0,"sb");
    }
    public muen(int a,String name){
        this.sum=a;
        this.name=name;
    }
    public void show(){
        System.out.println(this.sum+" "+this.name);
    }
}
