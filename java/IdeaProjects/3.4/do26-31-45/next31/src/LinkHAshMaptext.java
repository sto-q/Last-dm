import java.util.LinkedHashMap;

public class LinkHAshMaptext {
    public static void main(String[] args) {
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        map.put("A","B");
        map.put("B","C");
        map.put("C","D");
        map.put("D","E");
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
