package repository.conf;

import entity.Group;
import entity.Promotion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupRepository {
    private final Connection connection = DatabaseConnection.getConnection();

    public List<Group> getGroups() {
        String query = "select * from \"group\"";
        List<Group> groups = new ArrayList<>();
        try{
            ResultSet rs = connection.createStatement().executeQuery(query);
            while(rs.next()) {
                groups.add(resultSetToGroup(rs));
            }
            return groups;
        }catch (SQLException error){
            throw new RuntimeException(error);
        }
    }

    public Group resultSetToGroup(ResultSet rs) throws SQLException {
        return new Group(
            rs.getString("\"id\""),
            rs.getString("\"name\""),
            rs.getInt("\"year\""),
            Promotion.valueOf(rs.getString("\"promotion\""))
        );
    }
}
