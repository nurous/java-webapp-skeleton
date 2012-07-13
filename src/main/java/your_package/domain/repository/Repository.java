package your_package.domain.repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository<T> {
    T save(T o);

    T get(int id);

    List<T> list();

    void update(T o);

    void delete(T o);

    List<T> findAll(String field, Object param);

    T findBy(String propertyName, String value);

    List<T> orderByDescending(String fieldToBeFiltered, Object filterValue, String sequenceID);
}
