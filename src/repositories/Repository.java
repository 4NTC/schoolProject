package repositories;

import dataObject.Lesson;
import exceptions.SchoolRepositoryException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import utils.Util;

public class Repository<T> implements IRepository<T> {

  private final Map<String, T> database;

  public Repository() {
    this.database = new HashMap<>();
  }

  @Override
  public void insert(T t, String id) throws SchoolRepositoryException {
    if (!database.containsKey(id)) {
      database.put(id, t);
    } else {
      throw new SchoolRepositoryException("%s with id %s already exists", t.getClass()
          .getName(), id);
    }
  }

  @Override
  public Optional<? extends T> findById(String id) {
    return Optional.ofNullable(database.get(id));
  }

  @Override
  public String generateRandomId() {
    Set<String> keySet = database.keySet();
    String randomId = Util.generateRandomId();
    while (keySet.contains(randomId)) {
      randomId = Util.generateRandomId();
    }
    return randomId;
  }

  @Override
  public Collection<T> findAll() {
    return database.values();
  }
}
