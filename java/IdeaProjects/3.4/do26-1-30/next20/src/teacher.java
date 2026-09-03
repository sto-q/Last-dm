import java.util.Arrays;

public class teacher {
    private Student[] stus={};
    public void add(Student s){
        stus= Arrays.copyOf(stus,stus.length+1);
        stus[stus.length-1]=s;
    }
    public void StudentShow(StudentSort sort){
        sort.sort(stus);
        for(Student s:stus){
            System.out.println(s);
        }
    }
    static class StudentSort{
        private int index;
        public StudentSort(){
            index=0;
        }
        public StudentSort(int index) {
            this.index = index;
        }
        public void sort(Student[] stus){
            for(int i=0;i<stus.length;i++){
                for(int j=0;j<stus.length-i-1;j++){
                    int age1=stus[j].getAge();
                    int age2=stus[j+1].getAge();
                    if((index==0&&age1<age2)||(index==1&&age1>age2)){
                        Student temp=stus[j];
                        stus[j]=stus[j+1];
                        stus[j+1]=temp;
                    }
                }
            }
        }
    }
}
