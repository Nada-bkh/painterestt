/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package painterestt.models;

import java.util.Date;

/**
 *
 * @author nadab
 */
public class User {
    int id;
    String username;
    String email;
    String password;
    Date birthdate;
    
    public User() {
    }

    public User(int id, String username, String email, String password, Date birthdate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
    }
    

      public User(String username) {
        this.username = username;
       
    }
          

    public User(String username, String email, String password, Date birthdate) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }


    @Override
    public String toString() {
        return "user{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", birthdate=" + birthdate + '}';
    }
    
     @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
    

