import entity.Group;
import entity.Promotion;
import repository.GroupRepository;
import repository.conf.DatabaseConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        final Connection connection = DatabaseConnection.getConnection();
        final GroupRepository groupRepository  = new GroupRepository(connection);
        Group toCreate = new Group("myId", "Test", 2024, Promotion.J);
        final Group  result = groupRepository.deleteById(toCreate.getId());
        System.out.println(
            result
        );
    }
}
