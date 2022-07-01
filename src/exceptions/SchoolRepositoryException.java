package exceptions;

public class SchoolRepositoryException extends Exception {

  public SchoolRepositoryException(String message, String... args) {
    super(String.format(message, (Object[]) args));
  }

}
