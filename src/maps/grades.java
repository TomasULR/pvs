package maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class grades {
    public static void main(String[] args) throws IOException {
        List<Student> studentsList = Files.lines(Paths.get("data\\student_scores.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(splitLine -> new Student(
                        splitLine[0],
                        splitLine[1],
                        Double.parseDouble(splitLine[2]),
                        Integer.parseInt(splitLine[3])
                ))
                .toList()
                ;

        System.out.println("Celkem zaznamu"+ studentsList.size());

        Map<String, List<Student>> unStudents = studentsList.stream()
                .collect(Collectors.groupingBy(Student::getSubject));

        Map<String, Long> uniqStudents = studentsList.stream()
                .collect(Collectors.groupingBy(Student::getSubject,
                        Collectors.mapping(s -> s, Collectors.counting())));

        System.out.println(uniqStudents);

        Map<String, Double> frriqStudents = studentsList.stream()
                .collect(Collectors.groupingBy(Student::getSubject,
                        Collectors.mapping(s -> s, Collectors.averagingDouble(Student::getScore))));

        System.out.println(frriqStudents);


        Map<String, Double> avgForName = studentsList.stream()
                .filter(s -> s.Name.equals("name"))
                .collect(Collectors.groupingBy(Student::getSubject,
                        Collectors.mapping(s -> s, Collectors.averagingDouble(Student::getScore))));


        System.out.println(avgForName);
    }

    static double getAverageScore(List<TestResults> results, String name) {
        return results.stream()
                .mapToDouble(m ->m.score)
                .average()
                .orElse(0);
    }



}
class TestResults{
    double score;
    String Name;


    public TestResults(double score, String name) {
        this.score = score;
        Name = name;
    }

}


class Student{
    String Name;
    String Subject;
    double Score;
    int TimeSpentMinutes;

    public Student(String name, String subject, double score, int timeSpentMinutes) {
        Name = name;
        Subject = subject;
        Score = score;
        TimeSpentMinutes = timeSpentMinutes;
    }


    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", Subject='" + Subject + '\'' +
                ", Score=" + Score +
                ", TimeSpentMinutes=" + TimeSpentMinutes +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double score) {
        Score = score;
    }

    public int getTimeSpentMinutes() {
        return TimeSpentMinutes;
    }

    public void setTimeSpentMinutes(int timeSpentMinutes) {
        TimeSpentMinutes = timeSpentMinutes;
    }
}

