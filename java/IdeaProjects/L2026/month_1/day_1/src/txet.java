import java.util.Scanner;
import java.util.Arrays;

public class txet {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        muen[] HH=new muen[]{};
        for(int i=0;i<3;i++) {
            muen[] MM = Arrays.copyOf(HH, HH.length + 1);
            int e = sc.nextInt();
            String L = sc.next();
            MM[MM.length - 1] = new muen(e, L);
            HH = MM;
        }
        for (int i = 0; i < HH.length; i++) {
            System.out.println("HH[" + i + "] = " + HH[i].name+" "+HH[i].sum);
        }
    }
}
