package repository;

import entity.Group;
import entity.Promotion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroupRepository {
    private final Connection connection;

    public GroupRepository(Connection connection) {
        this.connection = connection;
    }

    public Group findById(String id) {
        String query = "select * from \"group\" where \"id\"=?;";
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
        String query = "select * from \"group\";";
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

    public Group udpate(Group toUpdate){
        String query = """
            update "group" set "name" = ?, "year" = ? , "promotion" = ? where "id" = ?
        """;
        try{
            PreparedStatement prs = connection.prepareStatement(query);
            prs.setString (1, toUpdate.getName());
            prs.setInt(2, toUpdate.getYear());
            prs.setString(3, toUpdate.getPromotion().toString());
            prs.setString (4, toUpdate.getId());
            prs.executeUpdate();
            return this.findById(toUpdate.getId());
        }catch (SQLException error){
            throw new RuntimeException(error);
        }
    }

    public Group create(Group toCreate){
        String query = """
            insert into "group"("id", "name", "year", "promotion") 
            values (?, ?, ?, ?);
         """;
        try{
            PreparedStatement prs = connection.prepareStatement(query);
            prs.setString (1, UUID.randomUUID().toString());
            prs.setString (2, toCreate.getName());
            prs.setInt(3, toCreate.getYear());
            prs.setString(4, toCreate.getPromotion().toString());
            prs.executeUpdate();
            return this.findById(toCreate.getId());
        }catch (SQLException error){
            throw new RuntimeException(error);
        }
    }

    public Group crupdate(Group crupdateGroup){
        if(crupdateGroup.getId() == null || crupdateGroup.getId().isEmpty()) {
            return this.create(crupdateGroup);
        }
        return this.udpate(crupdateGroup);
    }

    public Group deleteById(String id){
        String query = """
            delete from "group" where "id" = ?;
        """;

        try{
            final Group toDelete = this.findById(id);
            PreparedStatement prs = connection.prepareStatement(query);
            prs.setString (1, toDelete.getId());
            prs.executeUpdate();
            return toDelete;
        }catch (SQLException error){
            throw new RuntimeException(error);
        }
    }

    public Group resultSetToGroup(ResultSet rs) throws SQLException {
        return new Group(
            rs.getString("id"),
            rs.getString("name"),
            rs.getInt("year"),
            Promotion.valueOf(rs.getString("promotion"))
        );
    }
}
