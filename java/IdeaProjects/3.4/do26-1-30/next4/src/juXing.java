public class juXing extends xingZhuang{
    int x;
    int y;
    public juXing(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Integer MainJi(){
        return x*y;
    }
    protected Integer ZhongChang(){
        return (x+y)*2;
    }
}
