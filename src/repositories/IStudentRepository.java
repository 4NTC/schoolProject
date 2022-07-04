package repositories;

import dataObject.Student;
import dataObject.StudentRelation;
import exceptions.SchoolRepositoryException;
import java.util.Optional;

public interface IStudentRepository {

  void insertStudent(Student student) throws SchoolRepositoryException;
  Optional<StudentRelation> findStudentById(String studentId);
  String generateRandomId();

}
