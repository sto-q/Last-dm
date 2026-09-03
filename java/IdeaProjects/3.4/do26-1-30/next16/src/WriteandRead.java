import java.io.*;

public class WriteandRead {
    public void copy(String a, String b) {
        File f = new File(b);
        if(!f.getParentFile().exists())f.getParentFile().mkdirs();
        try(Writer out = new FileWriter(f);
            Reader read=new FileReader(a)) {
            char [] buffer = new char[1024];
            while(true){
                int c = read.read(buffer);
                if(c==-1) break;
                out.write(buffer,0,c);
            }
            out.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
