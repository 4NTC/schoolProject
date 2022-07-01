package dataObject;

import enumObject.GradeValueEnum;
import enumObject.SubjectTypeEnum;

public class Grade {

  private final String id;
  private final GradeValueEnum grade;
  private final SubjectTypeEnum subject;
  private final String studentId;
  private final String teacherId;
  private final String createDateTime;

  private String updateDateTime;

  public Grade(String id, GradeValueEnum grade, SubjectTypeEnum subject, String studentId,
      String teacherId, String createDateTime) {
    this.id = id;
    this.grade = grade;
    this.subject = subject;
    this.studentId = studentId;
    this.teacherId = teacherId;
    this.createDateTime = createDateTime;
  }

  public String getId() {
    return id;
  }

  public GradeValueEnum getGrade() {
    return grade;
  }

  public SubjectTypeEnum getSubject() {
    return subject;
  }

  public String getStudentId() {
    return studentId;
  }

  public String getTeacherId() {
    return teacherId;
  }

  public String getCreateDateTime() {
    return createDateTime;
  }
}
