import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Write {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\seto\\Desktop\\a\\b\\c.txt");
        if(!file.getParentFile().exists())file.getParentFile().mkdirs();
        try(Writer writer=new FileWriter(file,true)) {
            String tt="好累啊为什么啊";
//            char[] T=tt.toCharArray();
//            for(char c:T){
//                writer.write(c);
//            }
            writer.write(tt);
            writer.flush();
            System.out.println("ok");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
