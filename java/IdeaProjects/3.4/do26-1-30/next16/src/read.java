import java.io.*;

public class read {
    public static void main(String[] args) {
        try(Reader read=new FileReader("C:\\Users\\seto\\Desktop\\a\\b\\c.txt")) {
//            StringBuilder builder=new StringBuilder();
//            while(true){
//                int ch=read.read();
//                if(ch==-1) break;
//                builder.append((char)ch);
//            }
//                System.out.println(builder);
            char[] buf=new char[512];
//            int ch=read.read(buf);
            int count=0;
            while(true){
                int ch=read.read(buf,count,30);
                if(ch==-1) break;
                count+=ch;
                System.out.println(ch);
            }
            System.out.println(new String(buf,0,count));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
