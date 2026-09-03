import java.io.*;
public class inputOntput {

    public static void main(String[]args){
        String f1="C:\\Users\\seto\\Desktop\\计科7班李明奇25011467.txt";
        String f2="C:\\Users\\seto\\Desktop\\a\\b\\d\\e.txt";
        put2(f1,f2);
    }
//    public static void put1(String a,String b){
//        File f=new File(b);
//        if(!f.getParentFile().exists())f.getParentFile().mkdirs();
//        try {
//            f.createNewFile();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        try(InputStream in=new FileInputStream(a);
//        OutputStream out=new FileOutputStream(f);) {
//            byte[] buf=new byte[1024];
//            int len;
//            while((len=in.read(buf))!=-1){
//                out.write(buf, 0, len);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public static void put2(String a,String b){
        File f=new File(b);
        if(!f.getParentFile().exists())f.getParentFile().mkdirs();
        try {
            f.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InputStream in=null;
        OutputStream out=null;
        try{
            in=new FileInputStream(a);
            out=new FileOutputStream(b);
            byte[] buf=new byte[1024];
            int len;
            while(true){
                len=in.read(buf);
                if(len==-1) break;
                out.write(buf, 0, len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            close(in,out);
        }
    }
    public static void close(Closeable... closeables){
        for(Closeable closeable:closeables){
            if(closeable!=null)try{
                closeable.close();
            }catch(IOException e){};
        }
    }
}
