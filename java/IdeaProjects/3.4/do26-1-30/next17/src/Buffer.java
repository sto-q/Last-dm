import java.io.*;

public class Buffer {
    public static void main(String[] args) {
        String A="C:\\Users\\seto\\Desktop\\a\\b\\c.txt";
        String B="C:\\Users\\seto\\Desktop\\a\\d\\e.txt";
        String C="C:\\Users\\seto\\Desktop\\a\\f\\g.txt";
        copy1(A,B);
        copy2(A,C);
    }
    public static void copy1(String a, String B) {//缓冲字节流
        File b=new File(B);
        if(!b.getParentFile().exists())b.getParentFile().mkdirs();
        try(InputStream is=new FileInputStream(a);
            BufferedInputStream or=new BufferedInputStream(is);
            OutputStream os=new FileOutputStream(b);
            BufferedOutputStream bos=new BufferedOutputStream(os);) {
            byte[] buf=new byte[1024];
            while(true){
                int len=or.read(buf);
                if(len==-1)break;
                bos.write(buf,0,len);
            }
            bos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void copy2(String a, String C) {//缓存字符流
        File b=new File(C);
        if(!b.getParentFile().exists())b.getParentFile().mkdirs();
        try(Reader is=new FileReader(a);
        BufferedReader or=new BufferedReader(is);
        Writer os=new FileWriter(b);
        BufferedWriter bos=new BufferedWriter(os);) {
            char[]buf=new char[1024];
            while(true){
                int len=or.read(buf);
                if(len==-1)break;
                bos.write(buf,0,len);
            }
            bos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
