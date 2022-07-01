package dataObject;

import java.util.List;

public class StudentRelation extends Student {

  private List<Lesson> lessons;
  private List<Grade> grades;

  public StudentRelation(Student student) {
    super(student.getId(), student.getName(), student.getSurname(), student.getBirthDate());
  }

  public StudentRelation(Student student, List<Lesson> lessons, List<Grade> grades) {
    this(student);
    this.lessons = lessons;
    this.grades = grades;
  }


  public List<Lesson> getLessons() {
    return lessons;
  }

  public void setLessons(List<Lesson> lessons) {
    this.lessons = lessons;
  }

  public List<Grade> getGrades() {
    return grades;
  }

  public void setGrades(List<Grade> grades) {
    this.grades = grades;
  }
}
