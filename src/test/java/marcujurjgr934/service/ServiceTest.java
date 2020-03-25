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
import java.util.UUID;

import static org.junit.Assert.*;

public class ServiceTest {

    @Test
    public void saveTemaSuccess() {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme_test.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        String new_id = UUID.randomUUID().toString();

        int response = service.saveTema(new_id, "description", 7, 5);
        assertEquals(response, 1);
    }

    @Test
    public void saveTemaFailure()  {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme_test.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        String new_id = UUID.randomUUID().toString();
        int response = service.saveTema(new_id, "description", 4, 5);
        assertEquals(response, 0);
    }

}
