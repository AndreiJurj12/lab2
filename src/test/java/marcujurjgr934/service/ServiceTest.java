package marcujurjgr934.service;

import marcujurjgr934.domain.Nota;
import marcujurjgr934.domain.Student;
import marcujurjgr934.domain.Tema;
import marcujurjgr934.repository.NotaXMLRepository;
import marcujurjgr934.repository.StudentRepository;
import marcujurjgr934.repository.StudentXMLRepository;
import marcujurjgr934.repository.TemaXMLRepository;
import marcujurjgr934.validation.NotaValidator;
import marcujurjgr934.validation.StudentValidator;
import marcujurjgr934.validation.TemaValidator;
import marcujurjgr934.validation.Validator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class ServiceTest {

    @Test
    public void saveTemaSuccess() {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);


        int response = service.saveTema("10", "description", 7, 5);
        assertEquals(response, 1);
    }

    @Test
    public void saveTemaFailure()  {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);


        int response = service.saveTema("10", "description", 4, 5);
        assertEquals(response, 0);
    }

}
