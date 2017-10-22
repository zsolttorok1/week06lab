/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author 725899
 */
public class UserService {
    public String login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        
        if (username != null 
                && password != null 
                && !username.equals("") 
                && !password.equals("") 
                && (username.equals("adam") && password.equals("password") 
                ||  username.equals("betty") && password.equals("password"))){

            return username;
        }
        return null;
    }
}
