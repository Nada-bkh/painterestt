
package painterestt.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import painterestt.models.User;
import painterestt.utils.MyConnection;

/**
 *
 * @author nadab
 */
public class ServiceUser {
    Connection cnx;
  
 

    public ServiceUser() {
        cnx = MyConnection.getInstance().getCnx();

    }
    
    //done
     public void CreateUser( User user) {
          if(user == null) {
            System.err.println("[createUser] Trying to add a null entity");
            return ;
        }
           try {
               String request = "INSERT INTO user(username,email,password,birthdate) VALUES (?, ?, ?, ?)";
               
            PreparedStatement preparedStatement = cnx.prepareStatement(request);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setDate(4, (Date) user.getBirthdate());
            preparedStatement.executeUpdate();
            System.out.println("User created succesfully!!");
        } catch (SQLException ex) {
            System.out.println("ERROR : User not created.");
        }
    }
      
     public User getUserById(int id) {
        User user = null;
        try {
            String request = "SELECT * FROM user WHERE Id = " + id+"";
            PreparedStatement preparedStatement = cnx.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery(request);
            while (resultSet.next()){
                user = createUserFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return user;
    }

//works mochkoltou kenet lezmou getUserById
     public void deleteUser(int id) {
        User user = getUserById(id);
        if(user == null) {
            System.err.println("[deleteUser] Trying to delete a null entity");
            return ;
        }
             String request = "DELETE FROM user WHERE Id = "+user.getId();
        try {
            PreparedStatement preparedStatement = cnx.prepareStatement(request);
            preparedStatement.executeUpdate();
            System.out.println("User is deleted succesfully.");
        } catch (SQLException ex) {
            System.out.println("ERROR : User is not deleted.");
        }
    }
     
     
     //works
     public List<User> getUsers()  {
           List<User> users = new ArrayList<>();
           try {
            String request = "SELECT * FROM user";
            Statement statement = cnx.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()){
                User user = createUserFromResultSet(resultSet);
                users.add(user);
            }
           
        } catch (SQLException ex) {
            System.out.println("ERROR : User list is empty");
        }
       return users;
    }
     
     public void updateUser(User user) {
        String request = "UPDATE user SET username = ?, email = ?, password = ?, birthdate = ? WHERE Id = " + user.getId();
        try {
            PreparedStatement preparedStatement = cnx.prepareStatement(request);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setDate(4, (Date) user.getBirthdate());
            preparedStatement.executeUpdate();
            System.out.println("User is updated successfully");
        } catch (SQLException ex) {
            System.out.println("ERROR: User update failed");
        }
    }
     
      public List<User> FilterByUsername(String username) {
        List<User> users = new ArrayList<>();
        String request = "SELECT * FROM user WHERE username = '"+username+"';";
        try {
            Statement statement = cnx.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while(resultSet.next()){
                User user = createUserFromResultSet(resultSet);
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

        private User createUserFromResultSet(ResultSet resultSet) throws SQLException {
        int Id = resultSet.getInt(1);
        String username = resultSet.getString(2);
        String email = resultSet.getString(3);
        String password = resultSet.getString(4);
        Date birthdate = resultSet.getDate(5);
        return new User(Id, username, email, password, birthdate);
    }

}
