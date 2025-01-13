package repository;

import entity.Group;
import entity.Promotion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupRepository {
    private final Connection connection;

    public GroupRepository(Connection connection) {
        this.connection = connection;
    }

    public Group findById(String id) {
        String query = "select * from \"group\" where \"id\"=?";
        try{
            PreparedStatement prs = connection.prepareStatement(query);
            prs.setString (1, id);
            ResultSet rs = prs.executeQuery();
            if(rs.next()){
                return resultSetToGroup(rs);
            }
            return null;
        }catch (SQLException error){
            throw new RuntimeException(error);
        }
    }

    public List<Group> findAll() {
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
