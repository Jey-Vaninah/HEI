import entity.Gender;
import entity.Group;
import entity.Promotion;
import entity.Student;
import repository.GroupRepository;
import repository.StudentRepository;
import repository.conf.DatabaseConnection;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Connection connection = DatabaseConnection.getConnection();
        final GroupRepository groupRepository  = new GroupRepository(connection);
        final StudentRepository studentRepository = new StudentRepository(connection);

        Group groupJ = new Group("groupJ_id", "Test", 2024, Promotion.J);
        Student vaninah = new Student(
            "vaninah_id",
            "Vaninah",
            "STD23042",
            LocalDate.now(),
            Gender.F,
            groupJ
        );

        groupRepository.crupdate(groupJ);
        studentRepository.crupdate(vaninah);

        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }
}
