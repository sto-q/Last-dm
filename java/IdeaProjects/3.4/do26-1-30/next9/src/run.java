public class run {
    private String name;
    private int age;
    public run(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public int hashCode(){
        return name.hashCode()+age;
    }
    public String toString(){
        return name+"\t"+age;
    }
    public boolean equals(Object obj){
        if (this==obj)return true;//应该是访问堆中地址是否相同
        if(this.getClass()!=obj.getClass())return false;//看是否为类的定义是否一样
        run r=(run)obj;//因为run是Object的子类可以将obj强制转换为run类型
        return name.equals(r.name)&&age==r.age; //里面的equals是String类型的没有重写
    }
    @Override
    protected void finalize()throws Throwable{
        this.name=null;
    }
}
