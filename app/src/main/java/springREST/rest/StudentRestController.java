package springREST.rest;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springREST.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void beforeAll() {
        students = new ArrayList<>();

        students.add(new Student("Road", "Runner"));
        students.add(new Student("Wille", "Coyote"));
        students.add(new Student("Yosemite", "Sam"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= students.size() || (studentId < 0)) {
            throw new StudentNotFoundException(
                String.format("Student with id %s is not found", studentId)
            );
        }
        return students.get(studentId);
    }
}
