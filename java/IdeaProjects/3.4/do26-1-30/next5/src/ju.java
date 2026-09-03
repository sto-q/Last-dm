public class ju extends XZ{
    int x,y;
    public ju(int x,int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public Integer mainji() {
        return x*y;
    }

    @Override
    public Integer chong() {
        return (x+y)*2;
    }
    public void show(){
        System.out.printf("面积%s周长%s\n",mainji(),chong());
    }
}
