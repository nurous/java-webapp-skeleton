package your_package;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath:spring/db-config.xml", "classpath:spring/app-config.xml"})
public abstract class IntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    protected SessionFactory sessionFactory;

    @After
    public void tearDown() {
        sessionFactory.getCurrentSession().clear();
    }
}
