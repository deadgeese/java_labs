import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return this.name;
    }

    public String getGroup() {
        return this.group;
    }

    public int getCourse() {
        return this.course;
    }

    public List<Integer> getGrades() {
        return this.grades;
    }

    public float getAverageGrade() {
        if (this.grades.isEmpty()) {
            return 0.0F;
        } else {
            int sum = 0;

            for(int i = 0; i < this.grades.size(); ++i) {
                sum += (Integer)this.grades.get(i);
            }

            return (float)sum / (float)this.grades.size();
        }
    }

    public void promote() {
        ++this.course;
    }

    public void print() {
        String var10001 = this.name;
        System.out.print("\t" + var10001 + "; " + this.group + "; " + this.course + "; grades:" + String.valueOf(this.grades) + " and the average grade is: ");
        System.out.printf("%.2f\n", this.getAverageGrade());
    }
}

