import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class University {
    List<Student> students = new ArrayList<>();

    public University(int numberOfStudents) {
        for (int i = 0; i < numberOfStudents; i++) students.add(new Student());
    }

    public University(List<Student> students) {
        this.students = students;
    }

    public Map<String, Double> avgForSubjects() {
        return students.parallelStream()
                .flatMap(student -> student.avgForStudent()
                        .entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.averagingDouble(Map.Entry::getValue)));
    }

    public void avgForSubjectsPrint() {
        students.parallelStream()
                .flatMap(student -> student.avgForStudent()
                        .entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.averagingDouble(Map.Entry::getValue)))
                .entrySet().forEach(entry -> System.out.println(String.format("%1$-10.10s = %2$,.2f", entry.getKey(), entry.getValue())));
    }
}
