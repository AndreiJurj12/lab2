package marcujurjgr934.repository;


import marcujurjgr934.domain.Tema;
import marcujurjgr934.validation.Validator;

public class TemaRepository extends AbstractCRUDRepository<String, Tema> {
    public TemaRepository(Validator<Tema> validator) {
        super(validator);
    }
}

