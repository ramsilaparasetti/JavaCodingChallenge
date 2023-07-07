//Create a Student class that contains a name and a list of grades.
//        Implement a method that takes a list of Student objects and returns the name of the student with the highest average grade.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    String name;
    List<Integer> grades;


    public Student(String name, List<Integer> grades){
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

   public void setName(String name){
        this.name = name;
   }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public static String getTopStudent(List<Student> stu) {
        Map<Integer, String> topStudentMap = new HashMap<>();
        int totGrade = 0;
        int topGrade = 0;
        for(Student student: stu){
            List<Integer> stuGrades = student.grades;
            for(int stug: stuGrades){
                totGrade += stug;
            }
            int avgGrade = totGrade/stuGrades.size();
            topStudentMap.put(avgGrade, student.getName());
            totGrade = 0;
        }

        for (int grade: topStudentMap.keySet()){
            if (topGrade < grade) {
                topGrade = grade;
            }
        }
        return topStudentMap.get(topGrade);
    }

    public static void main(String[] args) {
        List<Student> studentInfo = new ArrayList<>();
        studentInfo.add(new Student("Ram", List.of(8,8,8,8,8)));
        studentInfo.add(new Student("Kalyan", List.of(6,4,7,7,5)));
        studentInfo.add(new Student("Siva", List.of(4,4,7,4,5)));
        studentInfo.add(new Student("Akshith", List.of(8,8,7,7,8)));
        studentInfo.add(new Student("Srinivas", List.of(6,6,7,6,5)));
        System.out.println("Topper of the batch :"+getTopStudent(studentInfo));
    }

}
