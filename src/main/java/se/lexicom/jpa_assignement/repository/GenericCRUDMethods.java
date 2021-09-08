package se.lexicom.jpa_assignement.repository;

import java.util.Collection;

public interface GenericCRUDMethods <T, ID> {

    T create(T t);
    boolean delete(ID id);
    Collection<T> findAll();
    T findById(ID id);
    boolean update(T t);
    void clear();
}
