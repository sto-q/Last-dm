import java.io.*;

public class output {
    public static void main(String[] args) {
    try{
        File file = new File("C:\\Users\\seto\\Desktop\\a\\b\\c.txt");
        File fileFather =file.getParentFile();
        if(!fileFather.exists()){
            fileFather.mkdir();
        }
        InputStream inputStream = new FileInputStream(file);
        int length = inputStream.available();
//        byte[]buffer =new byte[9];
        byte[] buffer = new byte[length];
//        while(true){
//            int len=inputStream.read(buffer);
//            if(len==-1)break;
//            System.out.println(len);
//            System.out.println(new String(buffer));
//        }
        inputStream.read(buffer);
        System.out.println(length);
        System.out.println(new String(buffer));
        inputStream.close();
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }
}
