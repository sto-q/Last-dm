public class a2 {
    public static void main(String[]args){
        String s="a1b2c3d4e5";
        String s1=s.replace('a','s');
        System.out.println(s1);
        String s2=s.replace("a1b2","sasd");
        System.out.println(s2);
        System.out.println(s.replaceAll("[0-9a-z]","|"));
        char[] S=s.toCharArray();
        for(int i=0;i<S.length;i++){
            System.out.printf("%c",S[i]);
        }
        byte[] a=s.getBytes();
        for(int i=0;i<a.length;i++){
            System.out.printf("%d\t",a[i]);
        }

    }
}
