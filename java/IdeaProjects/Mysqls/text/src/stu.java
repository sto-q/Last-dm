//感觉如果使用stu就要使用list列表存储学生，在列表中进行操作

public class stu {
    private int id;
    private String studentName;
    private String course;
    private int score;


    public stu(int id, String studentName, String course, int score) {
        this.id = id;
        this.studentName = studentName;
        this.course = course;
        this.score = score;
    }

    @Override
    public String toString() {
        String format = "Jsp".equals(course) ?
                "%d\t%s\t%s\t\t%d" : "%d\t%s\t%s\t%d";
        return String.format(format, id, studentName, course, score);
    }
}
