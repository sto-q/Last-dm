package KK;

public class juxing extends shape {
    public int chang;
    public int kuan;

    public juxing(int kuan,int chang) {
        this.kuan = kuan;
        this.chang=chang;
    }
    public Integer zho(){
        return kuan*2+chang*2;
    }
    public int mainji(){
        return kuan*chang;

    }
}
