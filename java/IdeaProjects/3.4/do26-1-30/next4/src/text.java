public class text {
    public static void main(String[]args){
        xingZhuang A=new juXing(12,23);
        xingZhuang B=new yuan(23);
        xingZhuang C=new shajio(3,4,5);
        System.out.printf("周长="+A.ZhongChang()+"\n"+"面积"+A.MainJi()+"\n");
        System.out.printf("周长="+B.ZhongChang()+"\n"+"面积"+B.MainJi()+"\n");
        System.out.printf("周长="+C.ZhongChang()+"\n"+"面积"+C.MainJi());
    }
}
