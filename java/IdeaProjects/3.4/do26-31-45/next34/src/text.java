import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class text {
//    public static void main(String[] args) {
//        String text="src\\main\\java\\a.txt";
//        Function<String,Student>function=new Function<String,Student>() {
//            @Override
//            public Student apply(String s) {
//            return new Student(s.split(","));
//            }
//        }
//        Function<String,S>
//        Function<String[],Student>function=Student::new;
//        List<Student> students=read(text,function);
//    }
//          Function<String, Student> function = s -> new
//            Student(s.split(","));
//    Function<String[],Student>function=new Function<String[],Student>() {
//    @Override
//    public Student apply(String[] strings) {
//        return new Student(strings);
//    }
//};

    public static void main(String[] args) {
        String text="C:\\Users\\seto\\IdeaProjects\\3.4\\do26-31-60\\next34\\src\\a.txt";
        Function<String[],Student>function=Student::new;
        List<Student> students=read(text,function);
        students.forEach(System.out::println);

    }
    public static List<Student> read(String path, Function<String[], Student> func) {
        List<Student> students = new ArrayList<Student>();
//        File file = new File(path);
//        if(!file.getParentFile().exists())file.getParentFile().mkdirs();
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        try(FileReader fr = new FileReader(file);
        try(FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] all = line.split(",");
                students.add(func.apply(all));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
    public static class Student{
        private String name;
       private String sex;
       private int age;

//        public Student(String name, String sex, int age) {
//            this.name = name;
//            this.sex = sex;
//            this.age = age;
//        }

        public Student(String[] split) {
            this.name = split[0];
            this.sex=split[1];
            this.age=Integer.parseInt(split[2]);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
