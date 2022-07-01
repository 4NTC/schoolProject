package dataObject;

import enumObject.SubjectTypeEnum;
import java.util.List;

public class Lesson {

  // DECLARATION
  private final String id;
  private final String dateTimeEnd;
  private final String dateTimeStart;
  private final SubjectTypeEnum subjectTypeEnum;
  private final List<String> students;
  private final String teacherId;

  // CONSTRUCTOR
  public Lesson(String idArg, String dateTimeEndArg, String dateTimeStartArg,
      SubjectTypeEnum classIdArg, List<String> studentIdArg, String teacherIdArg) {
    this.id = idArg;
    this.dateTimeEnd = dateTimeEndArg;
    this.dateTimeStart = dateTimeStartArg;
    this.subjectTypeEnum = classIdArg;
    this.students = studentIdArg;
    this.teacherId = teacherIdArg;
  }

  public String getId() {
    return id;
  }

  public String getDateTimeEnd() {
    return dateTimeEnd;
  }

  public String getDateTimeStart() {
    return dateTimeStart;
  }

  public List<String> getStudents() {
    return students;
  }

  public String getTeacherId() {
    return teacherId;
  }

  public SubjectTypeEnum getSubjectTypeEnum() {
    return subjectTypeEnum;
  }

  public boolean isStudentAttending(String studentId) {
    return students.contains(studentId);
  }
}