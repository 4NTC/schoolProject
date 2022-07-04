package repositories;

import exceptions.SchoolRepositoryException;
import java.util.Collection;
import java.util.Optional;

public interface IRepository<T> {

  void insert(T t, String id) throws SchoolRepositoryException;
  Optional<? extends T> findById(String id);
  String generateRandomId();
  Collection<T> findAll();
}
