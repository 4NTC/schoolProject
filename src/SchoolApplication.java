import dataObject.Grade;
import dataObject.Lesson;
import dataObject.Student;
import dataObject.StudentRelation;
import exceptions.SchoolRepositoryException;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import repositories.IRepository;
import repositories.Repository;
import repositories.StudentRepository;
import service.SchoolService;

public class SchoolApplication {

  private static final IRepository<Lesson> lessonRepository = new Repository<>();
  private static final IRepository<Grade> gradeRepository = new Repository<>();
  private static final StudentRepository studentRepository = new StudentRepository(lessonRepository, gradeRepository);

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    SchoolService schoolService = new SchoolService(studentRepository);
    boolean stop = false;
    while (!stop) {
      try {
        insertStudentFromScanner(scanner, schoolService);
        findAllStudent();
      } catch (SchoolRepositoryException e) {
        System.out.println(e.getMessage());
      } finally {
        stop = stopMain(scanner);
      }
    }
  }

  private static boolean stopMain(Scanner scanner) {
    System.out.print("\nDo you want to stop? (y/n) ");
    String choice = scanner.nextLine();
    return choice.equalsIgnoreCase("y");
  }

  private static void findAllStudent() {
    Collection<Student> allStudents = studentRepository.findAll();
    System.out.println(allStudents.toString());

  }

  private static void insertStudentFromScanner(Scanner scanner, SchoolService service)
      throws SchoolRepositoryException {
    System.out.print("\nInsert name for student: ");
    String name = scanner.nextLine();

    System.out.print("\nInsert surname for student: ");
    String surname = scanner.nextLine();

    System.out.print("\nInsert birthdate for student: ");
    String birthdate = scanner.nextLine();

    service.insertStudent(name, surname, birthdate);
  }
}
