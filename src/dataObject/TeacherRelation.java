package dataObject;

import java.util.List;

public class TeacherRelation extends Teacher {

  private List<Lesson> lessons;
  private List<Grade> grades;

  public TeacherRelation(Teacher teacher) {
    super(teacher.selectId(),
        teacher.selectName(),
        teacher.selectSurname(),
        teacher.selectBirthDate());
  }

  public TeacherRelation(Teacher teacher, List<Lesson> lessons, List<Grade> grades) {
    this(teacher);
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
