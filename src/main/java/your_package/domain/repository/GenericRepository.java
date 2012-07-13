package your_package.domain.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class GenericRepository<T> {
    protected SessionFactory sessionFactory;
    private Class<T> type;

    private GenericRepository() {
    }

    public GenericRepository(SessionFactory sessionFactory, Class<T> type) {
        this.sessionFactory = sessionFactory;
        this.type = type;
    }

    public T save(T o) {
        int id = (Integer) getSession().save(o);
        return get(id);
    }

    public T get(int id) {
        return (T) getSession().get(type, id);
    } 
	
	public List<T> list() {
        Criteria criteria = getSession().createCriteria(type).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<T>) criteria.list();
    }

    public void update( T o) {
        getSession().update(o);
    }

    public void delete(T o) {
        getSession().delete(o);
    }

    public List<T> findAll(String field, Object param) {
        return getSession().createCriteria(type).add(Restrictions.eq(field, param)).list();
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T findBy(String propertyName, String value) {
        return (T) this.sessionFactory.getCurrentSession().createCriteria(type).add(
                Restrictions.eq(propertyName, value)).uniqueResult();
    }

    public List<T> orderByDescending(String fieldToBeFiltered, Object filterValue, String sequenceID) {
        return getSession().createCriteria(type).add(Restrictions.eq(fieldToBeFiltered, filterValue)).addOrder(Order.desc(sequenceID)).list();
    }
}
