import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private Map<String, List<Integer>> grades;

    public Student(String name, Map<String, List<Integer>> grades) {
        this.name = name;
        this.grades = grades;
    }

    public Student() {
        grades = new HashMap<>();
        init();
    }

    public Map<String, List<Integer>> getGrades() {
        return grades;
    }

    private void init() {
        Faker f = new Faker();
        Random r = new Random();
        String[] subjects = new String[]{"Math", "Physics", "Chemistry", "Music", "English", "History", "Geography"};
        name = f.name().fullName();
        for (int i = 0; i < subjects.length; i++) {
            List<Integer> marks = new ArrayList<>();
            for (int j = 0; j < 20; j++) marks.add(r.nextInt(100));
            grades.put(subjects[i], marks);
        }
    }

    public Map<String, Double> avgForStudent(){
        return grades.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        marks -> marks.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .summaryStatistics()
                                .getAverage()));
    }
}
