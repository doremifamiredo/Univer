import org.junit.jupiter.api.Test;

import java.util.*;

public class UniverTest {

    List<Student> simpleTestData() {
        return Arrays.asList(
                new Student("Student1", Map.of("Ten", List.of(10), "Twenty", List.of(20))),
                new Student("Student2", Map.of("Ten", List.of(10), "Twenty", List.of(20))),
                new Student("Student3", Map.of("Ten", List.of(10), "Thirty", List.of(30))),
                new Student("Student4", Map.of("Twenty", List.of(20), "Thirty", List.of(30)))
        );
    }

    @Test
    void simpleTest() {
        University university = new University(simpleTestData());
        System.out.println(university.avgForSubjects());
    }
}
