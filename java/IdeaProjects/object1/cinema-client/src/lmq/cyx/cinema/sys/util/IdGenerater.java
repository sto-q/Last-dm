package lmq.cyx.cinema.sys.util;

import java.util.Random;

/**
 * ID生成器
 */
public class IdGenerater {
    private static Random RANDOM = new Random();
    private static final char[] characters={
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'
    };

    /**
     * 跟给定字符串生成ID
     * @param length 长度
     * @return
     */
    public static String generaterId(int length){
        StringBuilder sb=new StringBuilder("CYX_");
        for(int i=0;i<length;i++){
            int index=RANDOM.nextInt(characters.length);
            sb.append(characters[index]);
        }
        return sb.toString();
    }
}
