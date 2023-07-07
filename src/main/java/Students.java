//Create a Student class that contains a name and a list of grades.
//        Implement a method that takes a list of Student objects and returns the name of the student with the highest average grade.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Students {
    String  name;
    List<Double> grades;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public Students(String name, List<Double> grades) {
        this.name = name;
        this.grades = grades;
    }

    public static String topGradeStudent(List<Students> students) {
        HashMap<Double, String> studentGrades = new HashMap<>();
        for(Students stu:students){
            Double avgGrade = getAverageGrade(stu.grades);
            studentGrades.put(avgGrade, stu.getName());
        }
        Double topGrade = 0.0;
        for(Double avgGrade:studentGrades.keySet()){
            if(avgGrade > topGrade){
                topGrade = avgGrade;
            }
        }
        return studentGrades.get(topGrade);
    }

    private static Double getAverageGrade(List<Double> grades) {
        Double totalGrades = 0.0;
        for(int i = 0; i<grades.size(); i++){
            totalGrades += grades.get(i);
        }
        return totalGrades/grades.size();
    }

    public static void main(String[] args) {
        List<Students> studentsInputList = new ArrayList<>();
        studentsInputList.add(new Students("Ram", List.of(9.0, 8.5, 8.5, 9.0)));
        studentsInputList.add(new Students("Jack", List.of(9.0, 6.0, 6.0, 9.0)));
        studentsInputList.add(new Students("John", List.of(8.0, 8.0, 8.0, 8.0)));
        studentsInputList.add(new Students("Peter", List.of(9.0, 9.5, 9.5, 9.0)));

        System.out.println("Student with the top grade: "+topGradeStudent(studentsInputList));
    }
}
