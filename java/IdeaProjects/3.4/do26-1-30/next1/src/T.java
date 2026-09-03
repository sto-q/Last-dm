import java.util.Arrays;

public class T {
    public Student[] S={};
    public void add(Student s){
    S= Arrays.copyOf(S,S.length+1);
    S[S.length-1]=s;
    }
    public void show(){
        for(int i=0;i<S.length;i++){
            System.out.println(S[i].name+" "+S[i].age+" "+S[i].xx);
        }
    }
}

