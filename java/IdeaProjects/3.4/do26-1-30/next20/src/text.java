public class text {
    public static void main(String[] args) {
        teacher t = new teacher();
        t.add(new Student("a",18));
        t.add(new Student("b",19));
        t.add(new Student("c",20));
        t.StudentShow(new teacher.StudentSort(1));
    }
}
