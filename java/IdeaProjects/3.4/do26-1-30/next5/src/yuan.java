public class yuan extends XZ{
    double r;
    public yuan(double r){
        this.r=r;
    }
    @Override
    public Double mainji() {
        return Math.PI*r*r;
    }

    @Override
    public Double chong() {
        return 2*Math.PI*r;
    }
    public void show(){
        System.out.printf("面积%.4s周长%.4s\n",mainji(),chong());
    }
}
