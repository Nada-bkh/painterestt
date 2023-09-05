
package painterestt;

import java.time.LocalDate;
import java.util.Date;
import painterestt.models.User;
import painterestt.services.ServiceUser;

/**
 *
 * @author nadab
 */
public class Painterestt {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
      
     //add user
      User user = new User();
      ServiceUser serviceUser = new ServiceUser();
      user.setId(1);
      user.setUsername("tokksiq");
      user.setEmail("tokksiq@gmail.com");
      user.setPassword("123");
      user.setBirthdate(java.sql.Date.valueOf(LocalDate.now()));
      
      //serviceUser.CreateUser(user);
      //serviceUser.deleteUser(4);
      //serviceUser.updateUser(user);
     //System.out.println(serviceUser.getUsers());
    }
    
}
