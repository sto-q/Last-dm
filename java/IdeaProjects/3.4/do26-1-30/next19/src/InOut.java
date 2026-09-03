import java.io.*;

public class InOut {

    public static void main(String[] args) {
        InOut.write();
        InOut.read();
    }
    public static void write(){
        try{
            File a = new File("next19\\src\\a.txt");
            if(!a.exists())a.createNewFile();
            OutputStream out = new FileOutputStream(a);
            OutputStreamWriter osw = new OutputStreamWriter(out);
            BufferedWriter bw = new BufferedWriter(osw);
            String[] ss={
                    "asdsdfsf",
                    "adssfdsjkfghds",
                    "adssfdsjkfhdfgfdgffghds",
                    "adssfdsjkfhdssdfgdf",
                    "adssfdsjkfhasdds",
            };
            for(String s:ss){
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void read(){
        File a = new File("next19\\src\\a.txt");
        try(InputStream is=new FileInputStream(a);
            InputStreamReader os=new InputStreamReader(is);
        BufferedReader oos =new BufferedReader(os);) {
            while(true){
                String s=oos.readLine();
                if(s==null)break;
                System.out.println(s);
            }
            oos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
