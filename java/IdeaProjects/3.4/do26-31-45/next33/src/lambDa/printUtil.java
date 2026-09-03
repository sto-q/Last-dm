package lambDa;

public class printUtil {
    public static void print(boolean value,String msg) {
        if(value) {
            System.out.println(msg);
        }
    }
    public static void print(boolean value,String... args ) {
        if(value) {
//            msgBuilder builder=(String...arg)->printUtil.build(arg);
            msgBuilder builder=printUtil::build;
            System.out.println(builder.buildMsg(args));
        }
    }
    public static String build(String...sty){
        StringBuilder str=new StringBuilder();
        for(String s:sty) {
            str.append(s);
        }
        return str.toString();
    }
}
