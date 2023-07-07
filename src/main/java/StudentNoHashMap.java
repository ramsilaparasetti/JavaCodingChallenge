//Create a Student class that contains a name and a list of grades.
//        Implement a method that takes a list of Student objects and returns the name of the student with the highest average grade.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentNoHashMap {
    String name;
    List<Double> grades;


    public StudentNoHashMap(String name, List<Double> grades){
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

   public void setName(String name){
        this.name = name;
   }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public double getAverageGrade(){
      double totGrade = 0.0;
      for(double grade: grades) {
          totGrade += grade;
      }
      return totGrade/grades.size();
    }
    public static String getTopStudentName(List<StudentNoHashMap> stu) {
        StudentNoHashMap topStudent = stu.get(0);

        for(StudentNoHashMap student: stu){
           if(topStudent.getAverageGrade() < student.getAverageGrade()){
               topStudent = student;
           }
        }
        return topStudent.getName();
    }

    public static void main(String[] args) {
        List<StudentNoHashMap> studentInfo = new ArrayList<>();
        studentInfo.add(new StudentNoHashMap("Ram", List.of(8.0,8.0,8.0,8.0,8.0)));
        studentInfo.add(new StudentNoHashMap("Kalyan", List.of(6.5,4.5,7.5,7.0,5.0)));
        studentInfo.add(new StudentNoHashMap("Siva", List.of(4.5,4.0,7.0,4.5,5.5)));
        studentInfo.add(new StudentNoHashMap("Akshith", List.of(8.0,8.0,7.0,7.0,8.0)));
        studentInfo.add(new StudentNoHashMap("Srinivas", List.of(6.0,6.0,7.5,6.5,5.5)));
        System.out.println("Topper of the batch :"+getTopStudentName(studentInfo));
    }

}
