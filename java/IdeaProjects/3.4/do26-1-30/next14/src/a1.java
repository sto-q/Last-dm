import java.io.File;
import java.io.IOException;

public class a1 {
    public static void main(String[] args) {
        File f1=new File("a\\d\\c");
        File f2=new File("a\\d");
        File f3=new File(f2,"c");
//        System.out.println(f1.getPath());
//        System.out.println(f2.getPath());
        System.out.println(f3.getPath());
        File f4=new File("C:\\Users\\seto\\IdeaProjects\\3.4\\a\\b\\c.txt");
        System.out.println(f4.getParent());
        System.out.println(f4.getParentFile());
        long s=f4.length();
        System.out.println(s);
        long time1=f4.lastModified();
        System.out.println(time1);
        long time2=System.currentTimeMillis();
        System.out.println(time2);
        boolean a1=f4.canRead();
        System.out.println(a1);
        boolean a2=f4.canWrite();
        System.out.println(a2);
        boolean a3=f4.isDirectory();
        System.out.println(a3);
        boolean a4=f4.isFile();
        System.out.println(a4);
        boolean a5=f4.canExecute();
        System.out.println(a5);
        boolean a6=f4.canExecute();
        System.out.println(a6);
        File f5=new File("C:\\Users\\seto\\IdeaProjects\\3.4\\a\\b\\c.txt");
        File f7=new File("C:\\Users\\seto\\IdeaProjects\\3.4\\a\\b\\cc.txt");
        File f6=f5.getParentFile();
        if(!f6.exists()){
            f6.mkdirs();
        }
        if(!f5.exists()){
            try{
                boolean us=f5.createNewFile();
                f7.createNewFile();
                System.out.println(us+"ASD");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
