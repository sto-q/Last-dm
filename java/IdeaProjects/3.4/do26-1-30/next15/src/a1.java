import java.io.File;
import java.io.IOException;

public class a1 {
    public static void main(String[] args) {
        File a=new File("C:\\Users\\seto\\Desktop\\a");
        File a1=new File("C:\\Users\\seto\\Desktop\\a\\b\\c\\d\\e");
        boolean b=a1.mkdirs();
        System.out.println("创建目录"+b);
        File a2=new File("C:\\Users\\seto\\Desktop\\a\\b\\c\\d\\e\\f.txt");
        File a3=a2.getParentFile();
        if(a3==null||!a3.exists()){
            if (a3 != null) {
                a3.mkdirs();
            }
        }
        if(!a2.exists()){
            try {
                a2.createNewFile();
                System.out.println("创建成功");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        File a4=new File("C:\\Users\\seto\\Desktop\\a");
        File[] f=a4.listFiles();
//        for(File file:f){
//            System.out.println(file.getName());
//        }
//        FileFilter f1=new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.getName().startsWith("10");
//            }
//        };
//        File[] f2=a4.listFiles(f1);
//        for(File f22:f2){
//            System.out.println(f22.getName());
//        }
        re(a4);
        detelFile(a4);
    }
    public static void re(File file){
        if(file.isDirectory()){
            File[] f=file.listFiles();
            if (f != null) {
                for(File ff:f){
                    if(ff.isDirectory()){
                        re(ff);
                    }else{
                        System.out.println(ff.getName());
                    }
                }
            }
        }else{
            System.out.println(file.getName());
            System.out.println("遍历成功");
        }
    }
    public static void detelFile(File file){
        if(file.isDirectory()){
            File[] f=file.listFiles();
            if (f != null) {
                for(File fil:f){
                    if(fil.isDirectory()){
                        detelFile(fil);
                    }else{
                        fil.delete();
                    }
                }
            }
            file.delete();
        }else{
            file.delete();
        }
    }
}
