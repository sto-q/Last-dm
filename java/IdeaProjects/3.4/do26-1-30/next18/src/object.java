import java.io.*;

public class object {
    public static void main(String[] args)  {
        String a="next18\\src\\a\\b\\c.obj";
        write(a);
        read();
    }
    public static void write(String a)  {
        File f=new File(a);
        if(!f.getParentFile().exists())f.getParentFile().mkdirs();
        try(OutputStream os=new FileOutputStream(f);
        ObjectOutputStream oos=new ObjectOutputStream(os)){
            oos.writeObject(new student("as",12));
            oos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void read(){
        String a="next18\\src\\a\\b\\c.obj";
        File f=new File(a);
        try(InputStream is=new FileInputStream(f);
        ObjectInputStream iis=new ObjectInputStream(is);) {
            student SS=(student) iis.readObject();
            SS.show();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
