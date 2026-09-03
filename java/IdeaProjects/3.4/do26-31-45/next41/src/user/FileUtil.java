package user;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static <T> List<T> readdata(String path){
        List<T> dataList = new ArrayList<>();//创建链表
        File file = new File(path);
        if(file.exists()){//如果路径存在
            try (
                InputStream is = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(is);){
                dataList= (List<T>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dataList;//将读取的数据返回
    }
    public static<T> boolean writedata(String path,List<T> dataList){//写入并判断
        File file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }//自己加的如果路径不存在创建路径
        boolean success = true;
        try(  OutputStream os = new FileOutputStream(file);
              ObjectOutputStream oos=new ObjectOutputStream(os);) {
            oos.writeObject(dataList);//写入内容
            oos.flush();
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }
}
