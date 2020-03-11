package marcujurjgr934.repository;




import marcujurjgr934.domain.Nota;
import marcujurjgr934.domain.Pair;
import marcujurjgr934.validation.Validator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NotaRepository extends AbstractCRUDRepository<Pair<String, String>, Nota> {
    public NotaRepository(Validator<Nota> validator) {
        super(validator);
    }
}
