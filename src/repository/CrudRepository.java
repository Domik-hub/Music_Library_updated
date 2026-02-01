package repository;

import java.util.List;

public interface CrudRepository<T> {
    void create(T entity) throws Exception;
    T getById(int id) throws Exception;
    List<T> getAll() throws Exception;
    void update(T entity) throws Exception;
    void delete(int id) throws Exception;
}
