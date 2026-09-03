public class yuan extends xingZhuang{
    double R;
    public yuan(double R){
        this.R=R;
    }

    @Override
    public Number MainJi() {
        return Math.PI*R*R;
    }
    public Number ZhongChang(){
        return Math.PI*2*R;
    }
}
