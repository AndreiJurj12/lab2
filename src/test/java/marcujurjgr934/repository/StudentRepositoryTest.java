package marcujurjgr934.repository;

import marcujurjgr934.domain.Student;
import marcujurjgr934.validation.StudentValidator;
import marcujurjgr934.validation.ValidationException;
import marcujurjgr934.validation.Validator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class StudentRepositoryTest {



    @Test
    public void addStudentSuccess() {
        Validator<Student> studentValidator = new StudentValidator();
        StudentRepository studentRepository = new StudentRepository(studentValidator);

        List<Student> currentStudents = new ArrayList<Student>((Collection<? extends Student>) studentRepository.findAll());
        assertEquals(0, currentStudents.size());

        Student student = new Student("1", "John", 920);
        studentRepository.save(student);

        currentStudents = new ArrayList<Student>((Collection<? extends Student>) studentRepository.findAll());
        assertEquals(1, currentStudents.size());
        assertEquals(currentStudents.get(0).getID(), student.getID());
    }

    @Test(expected = ValidationException.class)
    public void addStudentFailure()  {
        Validator<Student> studentValidator = new StudentValidator();
        StudentRepository studentRepository = new StudentRepository(studentValidator);

        List<Student> currentStudents = new ArrayList<Student>((Collection<? extends Student>) studentRepository.findAll());
        assertEquals(0, currentStudents.size());

        Student student = new Student("1", "John", 0);
        Student result = studentRepository.save(student);

        assertNull(result);
        currentStudents = new ArrayList<Student>((Collection<? extends Student>) studentRepository.findAll());
        assertEquals(0, currentStudents.size());
    }
}
