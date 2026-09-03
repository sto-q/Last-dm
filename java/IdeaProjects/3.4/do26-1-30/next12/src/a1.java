import java.nio.charset.Charset;
import java.sql.SQLOutput;

public class a1 {
    public static void main(String[]args){
        String a="asddf--";
        System.out.println(a);
        a+="asdasd";
        System.out.println(a);
        String a2=new String("asdadsad");
        System.out.println(a2);
//        String[] a3={"asd","ewrtr","srfdsf","werf","rtyg"};
//        System.out.println(a3);
        char[] a3={'a','b','c','d','e','f'};
        String aa3=new String(a3);
        System.out.println(aa3);
        String a4=new String(a3,2,4);
        System.out.println(a4);
        byte[] a5={122,123,124,115,126};
        for(int i=0;i<a5.length;i++){
            System.out.printf("%d\t",a5[i]);
        }
        System.out.println();
        String a6=new String(a5);
        System.out.println(a6);
        System.out.println(new String(a5,2,2));
        //Charset a7=Charset.forName("US-ASCII");
        String a8=new String(a5,Charset.forName("UTF-8"));
        System.out.println(a8);
        String s="asdadsdafdsfsdf";
        System.out.println(s.length());
        String s1="abc";
        String s2="ABC";
        String s3="abc";
        System.out.println(s1.equals(s3));
        System.out.println(s2.equalsIgnoreCase(s3));
        System.out.println(s1.toUpperCase());
        System.out.println(s2.toLowerCase());
        String S="asdg@swe@fj.*";
        int index1=S.indexOf("@");
        System.out.println(index1);
        int index2=S.lastIndexOf("@");
        System.out.println(index2);
        if(index1!=index2){
            System.out.println("不止一个@");
        }
        int index3=S.indexOf(".");
        int index4=S.lastIndexOf(".");
        if(index3==index4){
            System.out.println("o_o");
        }
    }
}
