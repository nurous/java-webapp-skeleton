package your_package.domain.repository;

import org.junit.Before;
import org.junit.Test;
import your_package.IntegrationTest;
import your_package.domain.model.Thingy;

import static org.hibernate.validator.internal.util.Contracts.*;
import static util.SessionFactoryExtensions.*;

public class GenericRepositoryTest extends IntegrationTest {

    private Repository<Thingy> repository;

    @Before
    public void setUp() throws Exception {
        repository = new GenericRepository<Thingy>(sessionFactory, Thingy.class);
    }

    @Test
    public void shouldBeAbleToSaveANewObject() throws Exception {
        Thingy thingy = new Thingy("Hello World!");
        repository.save(thingy);

        assertNotNull(reload(sessionFactory, thingy));
    }

}
