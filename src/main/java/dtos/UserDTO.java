/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class UserDTO {
    private long id;
    private String Username;
    private String UserPass;
    private String personalJoke;

    public UserDTO(String Username, String UserPass) {
        this.Username = Username;
        this.UserPass = UserPass;
    }
    
    public static List<UserDTO> getDtos(List<User> users){
        List<UserDTO> userdtos = new ArrayList();
        users.forEach(user->userdtos.add(new UserDTO(user)));
        return userdtos;
    }


    public UserDTO(User user) {
        if(user.getId() != null)
            this.id = user.getId();
        this.Username = user.getUserName();
        this.UserPass = user.getUserPass();
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public String getUserPass() {
        return UserPass;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setUserPass(String userPass) {
        UserPass = userPass;
    }

    public String getPersonalJoke() {
        return personalJoke;
    }

    public void setPersonalJoke(String personalJoke) {
        this.personalJoke = personalJoke;
    }
}
