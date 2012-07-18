package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SessionFactoryExtensions {
    public static<T> T reload(SessionFactory sessionFactory, T objectToReload) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.flush();
        currentSession.evict(objectToReload);
        currentSession.refresh(objectToReload);
        return objectToReload;
    }

    public static <T> void persist(SessionFactory sessionFactory, T... objects) {
        Session session = sessionFactory.getCurrentSession();
        for (T object : objects) {
            session.save(object);
            session.flush();
            session.evict(object);
        }
    }
}
