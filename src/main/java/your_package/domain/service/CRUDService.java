package your_package.domain.service;

public interface CRUDService<T> {
    T create(T object);

    T retrieve(int id);
}
