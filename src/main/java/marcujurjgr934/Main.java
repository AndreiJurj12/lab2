package marcujurjgr934;

import marcujurjgr934.console.UI;
import marcujurjgr934.domain.Nota;
import marcujurjgr934.domain.Student;
import marcujurjgr934.domain.Tema;
import marcujurjgr934.repository.NotaXMLRepository;
import marcujurjgr934.repository.StudentXMLRepository;
import marcujurjgr934.repository.TemaXMLRepository;
import marcujurjgr934.service.Service;
import marcujurjgr934.validation.NotaValidator;
import marcujurjgr934.validation.StudentValidator;
import marcujurjgr934.validation.TemaValidator;
import marcujurjgr934.validation.Validator;

public class Main {
    public static void main(String[] args) {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        UI consola = new UI(service);
        consola.run();

        //PENTRU GUI
        // de avut un check: daca profesorul introduce sau nu saptamana la timp
        // daca se introduce nota la timp, se preia saptamana din sistem
        // altfel, se introduce de la tastatura
    }
}
