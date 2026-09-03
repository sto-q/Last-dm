package A.day10;

public  class metoo implements yanyuan {
    public String name;
    public void performance(){
        System.out.printf("神秘男%s表演\n",getName());
    }
    public void sing(){
        System.out.printf("神秘男%s唱歌\n",getName());
    }
    public metoo(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
