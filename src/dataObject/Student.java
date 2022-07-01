package dataObject;

public class Student {

  private final String id;
  private final String name;
  private final String surname;
  private final String birthDate;

  public Student(String id, String name, String surname, String birthDate) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.birthDate = birthDate;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getBirthDate() {
    return birthDate;
  }
}
