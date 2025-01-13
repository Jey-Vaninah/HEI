import entity.Group;
import repository.GroupRepository;
import repository.conf.DatabaseConnection;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Connection connection = DatabaseConnection.getConnection();
        final GroupRepository groupRepository  = new GroupRepository(connection);
        List<Group> groups = groupRepository.findAll();
        System.out.println(
            groups
        );
    }
}
