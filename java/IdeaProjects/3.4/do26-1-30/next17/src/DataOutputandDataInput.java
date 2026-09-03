import java.io.*;

public class DataOutputandDataInput {
    public static void main(String[] args)  {
        dataOut();
        dataIn();
    }
    public static void dataOut(){
        String A="next17\\src\\a\\b\\c.txt";
        File file=new File(A);
        if(!file.getParentFile().exists())file.getParentFile().mkdirs();
        try{
            if(!file.exists())file.createNewFile();
            OutputStream out=new FileOutputStream(file);
            DataOutputStream dos=new DataOutputStream(out);
            dos.writeBoolean(true);
            dos.writeUTF("UTF-8编码");
            dos.writeInt(123345546);
            dos.writeLong(System.currentTimeMillis());
            dos.writeFloat(3.14f);
            dos.writeShort(-12);
            dos.writeChar('a');
            dos.writeByte(-12);
            dos.flush();
            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void dataIn(){
        String A="next17\\src\\a\\b\\c.txt";
        File file=new File(A);
        try(InputStream is=new FileInputStream(file);
        DataInputStream os=new DataInputStream(is);) {
            System.out.println(os.readBoolean());
            System.out.println(os.readUTF());
            System.out.println(os.readInt());
            System.out.println(os.readLong());
            System.out.println(os.readFloat());
            System.out.println(os.readShort());
            System.out.println(os.readChar());
            System.out.println(os.readByte());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
