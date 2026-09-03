package List;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scatktext {
    public static void main(String[] args) {
//        List<Student> list = new ArrayList<Student>();
//        Scanner sc = new Scanner(System.in);
//        for(int i=0;i<5;i++){
//            String name=sc.next();
//            int age=sc.nextInt();
//            String sex=sc.next();
//            Double score=sc.nextDouble();
//            list.add(new Student(name,age,sex,score));
//        }
        //saveStudent(list,"C:\\Users\\seto\\IdeaProjects\\3.4\\do26-1-30\\next28\\src\\List\\Stack.txt");
        List<Student> list2 =readStudent("C:\\Users\\seto\\IdeaProjects\\3.4\\do26-1-30\\next28\\src\\List\\Stack.txt");
        for(Student s:list2){
            System.out.println(s);
        }
    }
    private static void saveStudent(List<Student> list,String path){
        File file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter writer=new FileWriter(file);
             BufferedWriter bw=new BufferedWriter(writer);){
            for(Student student:list){
                bw.write(student.toString());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Student> readStudent(String path){
        List<Student> list = new ArrayList<Student>();
        try(FileReader fr=new FileReader(path);
        BufferedReader br=new BufferedReader(fr);) {
            String line;
            while((line=br.readLine())!=null){
                String[] tokens=line.split(",");
                String name=tokens[0];
                String sex=tokens[2];
                int age=Integer.parseInt(tokens[1]);
                Double score=Double.parseDouble(tokens[3]);
                list.add( new Student(name,age,sex,score));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
