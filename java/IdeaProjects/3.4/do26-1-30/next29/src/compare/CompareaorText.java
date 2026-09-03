package compare;

import java.util.Arrays;
import java.util.Comparator;

public class CompareaorText {
    public static void main(String[] args) {
        Course[] courses ={
                new Course("Compare A", 115),
                new Course("Compare B", 32),
                new Course("Compare C", 32),
                new Course("Compare D", 43),
        };
        Comparator<Course> c=( o1, o2)->{
            if(o1.getScore()==o2.getScore())
                return 0;
            else if(o1.getScore()>o2.getScore())
                return 1;
            else
                return -1;
        };
        Arrays.sort(courses,c);
        for(Course h:courses){
            System.out.println(h);
        }
    }
}
