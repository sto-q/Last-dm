import java.io.*;
public class input {
    public static void main(String[] args){
        File file =new File("C:\\Users\\seto\\Desktop\\a\\b\\c.txt");
        File fileFilter = file.getParentFile();
        if(!fileFilter.exists()){
            fileFilter.mkdirs();
        }
        String zao8="为什么要上早八啊!!!!!!";
        try{
            OutputStream out=new FileOutputStream(file,true);
            byte[] data=zao8.getBytes();
//            for(byte b:data){
//                out.write(b);
//            }
//           out.write(data,0,data.length);
            out.write(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}