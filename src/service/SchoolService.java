package service;

import dataObject.Student;
import exceptions.SchoolRepositoryException;
import repositories.StudentRepository;

public class SchoolService {

  private final StudentRepository studentRepository;

  public SchoolService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public void insertStudent(String name, String surname, String birthdate)
      throws SchoolRepositoryException {
    Student student = new Student(studentRepository.generateRandomId(), name, surname, birthdate);
    studentRepository.insert(student, student.getId());
  }

}
