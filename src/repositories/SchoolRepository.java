package repositories;

import dataObject.Grade;
import dataObject.Lesson;
import dataObject.Student;
import dataObject.StudentRelation;
import dataObject.Teacher;
import dataObject.TeacherRelation;
import exceptions.SchoolRepositoryException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SchoolRepository {

  private final Map<String, Grade> grades;
  private final Map<String, Lesson> lessons;
  private final Map<String, Student> students;
  private final Map<String, Teacher> teachers;

  public SchoolRepository() {
    this.grades = new HashMap<>();
    this.lessons = new HashMap<>();
    this.students = new HashMap<>();
    this.teachers = new HashMap<>();
  }

  public void insertTeacher(Teacher teacher) throws SchoolRepositoryException {
    if (!teachers.containsKey(teacher.selectId())) {
      teachers.put(teacher.selectId(), teacher);
    } else {
      throw new SchoolRepositoryException("Teacher with id %s already exists", teacher.selectId());
    }
  }

  public void insertGrade(Grade grade) throws SchoolRepositoryException {
    if (!grades.containsKey(grade.getId())) {
      grades.put(grade.getId(), grade);
    } else {
      throw new SchoolRepositoryException("Grade with id %s already exists", grade.getId());
    }
  }

  public void insertLesson(Lesson lesson) throws SchoolRepositoryException {
    if (!lessons.containsKey(lesson.getId())) {
      lessons.put(lesson.getId(), lesson);
    } else {
      throw new SchoolRepositoryException("Lesson with id %s already exists", lesson.getId());
    }
  }

  public void insertStudent(Student student) throws SchoolRepositoryException {
    if (!students.containsKey(student.getId())) {
      students.put(student.getId(), student);
    } else {
      throw new SchoolRepositoryException("Student with id %s already exists", student.getId());
    }
  }

  public Optional<TeacherRelation> findTeacherById(String teacherId) {
    Optional<Teacher> optionalTeacher = Optional.ofNullable(teachers.get(teacherId));
    if (optionalTeacher.isPresent()) {
      List<Lesson> teacherLessons = findLessonByTeacherId(teacherId);
      List<Grade> teacherGrades = findGradesByTeacherId(teacherId);
      TeacherRelation teacherRelation = new TeacherRelation(optionalTeacher.get(), teacherLessons,
          teacherGrades);
      return Optional.of(teacherRelation);
    } else {
      return Optional.empty();
    }
  }

  public List<Lesson> findLessonByTeacherId(String teacherId) {
    List<Lesson> teacherLessons = new ArrayList<>();
    for (Lesson lesson : lessons.values()) {
      if (lesson.getTeacherId().equals(teacherId)) {
        teacherLessons.add(lesson);
      }
    }
    return teacherLessons;
  }

  public Optional<StudentRelation> findStudentById(String studentId) {
    Optional<Student> optionalStudent = Optional.ofNullable(students.get(studentId));
    if (optionalStudent.isPresent()) {
      List<Lesson> studentLessons = findLessonByStudentId(studentId);
      List<Grade> studentGrades = findGradesByStudentId(studentId);
      StudentRelation studentRelation = new StudentRelation(optionalStudent.get(), studentLessons,
          studentGrades);
      return Optional.of(studentRelation);
    } else {
      return Optional.empty();
    }
  }

  public List<Grade> findGradesByStudentId(String studentId) {
    List<Grade> studentGrades = new ArrayList<>();
    for (Grade grade : grades.values()) {
      if (grade.getStudentId().equals(studentId)) {
        studentGrades.add(grade);
      }
    }
    return studentGrades;
  }

  public List<Grade> findGradesByTeacherId(String teacherId) {
    List<Grade> teacherGrades = new ArrayList<>();
    for (Grade grade : grades.values()) {
      if (grade.getTeacherId().equals(teacherId)) {
        teacherGrades.add(grade);
      }
    }
    return teacherGrades;
  }

  public List<Lesson> findLessonByStudentId(String studentId) {
    List<Lesson> studentLessons = new ArrayList<>();
    for (Lesson lesson : lessons.values()) {
      if (lesson.isStudentAttending(studentId)) {
        studentLessons.add(lesson);
      }
    }
    return studentLessons;
  }


}
