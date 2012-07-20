package your_package.domain.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

@SuppressWarnings("unchecked")
@org.springframework.stereotype.Repository
public class GenericRepository<T> implements Repository<T> {

    protected SessionFactory sessionFactory;
    private Class<T> type;

    private GenericRepository() {
    }

    public GenericRepository(SessionFactory sessionFactory, Class<T> type) {
        this.sessionFactory = sessionFactory;
        this.type = type;
    }

    @Override
    public T save(T o) {
        int id = (Integer) getSession().save(o);
        return get(id);
    }

    @Override
    public T get(int id) {
        return (T) getSession().get(type, id);
    }

    @Override
    public void update(T o) {
        getSession().update(o);
    }

    @Override
    public void delete(T o) {
        getSession().delete(o);
    }

    @Override
    public List<T> findAll(String field, Object param) {
        return getCriteria().add(Restrictions.eq(field, param)).list();
    }

    @Override
    public List<T> findAll() {
        return (List<T>) getCriteria().setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public T findBy(String propertyName, String value) {
        return (T) getCriteria().add(Restrictions.eq(propertyName, value)).uniqueResult();
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Criteria getCriteria() {
        return getSession().createCriteria(type);
    }
}
