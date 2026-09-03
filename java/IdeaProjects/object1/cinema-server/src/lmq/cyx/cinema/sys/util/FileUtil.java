package lmq.cyx.cinema.sys.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件操作工具类
 */
public class FileUtil {
    /**
     * 用户存档文件
     */
    public static final String USER_FILE="data/user.obj";
    /**
     * 影片存档文件
     */
    public static final String FILM_FILE="data/film.obj";
    /**
     * 播放计划存档文件
     */
    public static final String FILM_PLAN_FILE="data/filmPlan.obj";
    /**
     * 影厅存档文件
     */
    public static final String FILM_HALL_FILE="data/filmHAll.obj";
    /**
     * 订单存档文件
     */
    public static final String ORDER_FILE="data/order.obj";
    /**
     * 解冻申请存档文件
     */
    public static final String UNFROZEN_APPLY_FILE="data/unfrozenApply.obj";

    /**
     * 保存给的列表路径文件中
     * @param dataList 列表数据
     * @param path 路径
     * @return
     * @param <T>不知道数据类型
     */
    public static <T> boolean saveData(List<T> dataList, String path) {
        File file = new File(path);
        File parent = file.getParentFile();
        if(!parent.exists()){
            parent.mkdirs();
        }
        try(OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(os)){
            oos.writeObject(dataList);
            oos.flush();
            oos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *从文件中读取数据
     * @param path 路径
     * @return
     * @param <T> 不知道数据类型
     */
    public static <T>List<T> readData(String path){//不知道类型所以用泛型
        try(InputStream is=new FileInputStream(path);
        ObjectInputStream ois=new ObjectInputStream(is)) {
            return (List<T>)ois.readObject();//返回从地址中访问的数据
        } catch (Exception e) {
          e.printStackTrace();
          return new ArrayList<T>();
        }
    }

}
