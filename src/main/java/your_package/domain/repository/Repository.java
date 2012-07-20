package your_package.domain.repository;

import java.util.List;

public interface Repository<T> {

    T save(T o);

    T get(int id);

    void update(T o);

    void delete(T o);

    List<T> findAll();

    List<T> findAll(String field, Object param);

    T findBy(String propertyName, String value);

}
