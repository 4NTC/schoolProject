package repositories;

import dataObject.Grade;
import dataObject.Lesson;
import dataObject.Student;
import dataObject.StudentRelation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepository extends Repository<Student> {

  private final IRepository<Lesson> lessonRepository;
  private final IRepository<Grade> gradeRepository;

  public StudentRepository(IRepository<Lesson> lessonRepository,
      IRepository<Grade> gradeRepository) {
    super();
    this.lessonRepository = lessonRepository;
    this.gradeRepository = gradeRepository;
  }

  @Override
  public Optional<StudentRelation> findById(String id) {
    Optional<Student> optionalStudent = (Optional<Student>) super.findById(id);
    if (optionalStudent.isPresent()) {
      List<Lesson> studentLessons = findLessonByStudentId(id);
      List<Grade> studentGrades = findGradesByStudentId(id);
      StudentRelation studentRelation = new StudentRelation(optionalStudent.get(), studentLessons,
          studentGrades);
      return Optional.of(studentRelation);
    } else {
      return Optional.empty();
    }
  }

  public List<Lesson> findLessonByStudentId(String studentId) {
    List<Lesson> studentLessons = new ArrayList<>();
    for (Lesson lesson : lessonRepository.findAll()) {
      if (lesson.isStudentAttending(studentId)) {
        studentLessons.add(lesson);
      }
    }
    return studentLessons;
  }

  public List<Grade> findGradesByStudentId(String studentId) {
    List<Grade> studentGrades = new ArrayList<>();
    for (Grade grade : gradeRepository.findAll()) {
      if (grade.getStudentId().equals(studentId)) {
        studentGrades.add(grade);
      }
    }
    return studentGrades;
  }
}
