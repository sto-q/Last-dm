public class shajio extends xingZhuang{
    int a,b,c;

    public shajio(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public Number MainJi() {
        int p=(a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    @Override
    protected Number ZhongChang() {
        return a+b+c;
    }
}
