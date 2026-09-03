package KK;

public class yuan extends shape{
    public double banjin;
    public yuan(double banjin){
        this.banjin=banjin;
    }
    public Double zho(){
        return 2*Math.PI*banjin;
    }
    public Double mianji(){
        return Math.PI*banjin*banjin;
    }

}
