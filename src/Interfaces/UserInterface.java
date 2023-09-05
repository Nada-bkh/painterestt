
package painterestt.Interfaces;

import java.util.List;
import painterestt.models.User;

/**
 *
 * @author nadab
 */
public interface UserInterface {
    
      public void CreateUser(User user);
      public User getUserById(int id);
      public void deleteUser(User user);
      public List<User> getUsers();
      public void updateUser(User user);
      public List<User> FilterByUsername(String username);
            
}
