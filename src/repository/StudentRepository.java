package repository;

import entity.Gender;
import entity.Group;
import entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
  private final Connection connection;
  private final GroupRepository groupRepository;

  public StudentRepository(Connection connection) {
    this.connection = connection;
    this.groupRepository = new GroupRepository(connection);
  }

  public Student findById(String id) {
    String query = "select * from \"student\" where \"id\"=?;";
    try{
      PreparedStatement prs = connection.prepareStatement(query);
      prs.setString (1, id);
      ResultSet rs = prs.executeQuery();
      if(rs.next()){
        return resultSetToStudent(rs);
      }
      return null;
    }catch (SQLException error){
      throw new RuntimeException(error);
    }
  }

  public List<Student> findAll() {
    String query = "select * from \"student\";";
    List<Student> students = new ArrayList<>();
    try{
      ResultSet rs = connection.createStatement().executeQuery(query);
      while(rs.next()) {
        students.add(resultSetToStudent(rs));
      }
      return students;
    }catch (SQLException error){
      throw new RuntimeException(error);
    }
  }

  public Student udpate(Student toUpdate){
    String query = """
            update "student" 
                set "name" = ?, 
                    "ref" = ? , 
                    "birthdate" = ? ,
                    "gender" = ? ,
                    "group_id" = ? 
                where "id" = ?
        """;
    try{
      PreparedStatement prs = connection.prepareStatement(query);
      prs.setString (1, toUpdate.getName());
      prs.setString(2, toUpdate.getRef());
      prs.setDate(3, Date.valueOf(toUpdate.getBirthdate()));
      prs.setString (4, toUpdate.getGender().toString());
      prs.setString (5, toUpdate.getGroup().getId());
      prs.setString (6, toUpdate.getId());
      prs.executeUpdate();
      return this.findById(toUpdate.getId());
    }catch (SQLException error){
      throw new RuntimeException(error);
    }
  }

  public Student create(Student toCreate){
    String query = """
            insert into "student"("id", "name", "ref", "birthdate", "gender", "group_id") 
            values (?, ?, ?, ?, ?, ?);
         """;
    try{
      PreparedStatement prs = connection.prepareStatement(query);
      prs.setString (1, toCreate.getId());
      prs.setString (2, toCreate.getName());
      prs.setString(3, toCreate.getRef());
      prs.setDate(4, Date.valueOf(toCreate.getBirthdate()));
      prs.setString (5, toCreate.getGender().toString());
      prs.setString (6, toCreate.getGroup().getId());
      prs.executeUpdate();
      return this.findById(toCreate.getId());
    }catch (SQLException error){
      throw new RuntimeException(error);
    }
  }

  public Student crupdate(Student crupdateStudent){
    final boolean isCreate = this.findById(crupdateStudent.getId()) == null;
    if(isCreate) {
      return this.create(crupdateStudent);
    }
    return this.udpate(crupdateStudent);
  }

  public Student deleteById(String id){
    String query = """
            delete from "student" where "id" = ?;
        """;

    try{
      final Student toDelete = this.findById(id);
      PreparedStatement prs = connection.prepareStatement(query);
      prs.setString (1, toDelete.getId());
      prs.executeUpdate();
      return toDelete;
    }catch (SQLException error){
      throw new RuntimeException(error);
    }
  }

  public Student resultSetToStudent(ResultSet rs) throws SQLException {
    final Group group = this.groupRepository.findById(rs.getString("group_id"));

    return new Student(
        rs.getString("id"),
        rs.getString("name"),
        rs.getString("ref"),
        rs.getDate("birthdate").toLocalDate(),
        Gender.valueOf(rs.getString("gender")),
        group
    );
  }
}
