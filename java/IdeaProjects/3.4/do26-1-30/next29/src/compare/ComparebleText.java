package compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparebleText {
    public static void main(String[] args) {
        Student[] students ={
                new Student("a",1),
                new Student("b",2),
                new Student("c",3),
                new Student("d",4),
                new Student("e",5),
        };
        Arrays.sort(students);
        for(Student student : students) {
            System.out.println(student);
        }
    }
}
