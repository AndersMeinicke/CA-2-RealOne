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
    private String str1;
    private String str2;

    public UserDTO(String dummyStr1, String dummyStr2) {
        this.str1 = dummyStr1;
        this.str2 = dummyStr2;
    }
    
    public static List<UserDTO> getDtos(List<User> users){
        List<UserDTO> userdtos = new ArrayList();
        users.forEach(user->userdtos.add(new UserDTO(user)));
        return userdtos;
    }


    public UserDTO(User user) {
        if(user.getId() != null)
            this.id = user.getId();
        this.str1 = user.getDummyStr1();
        this.str2 = user.getDummyStr2();
    }

    public String getDummyStr1() {
        return str1;
    }

    public void setDummyStr1(String dummyStr1) {
        this.str1 = dummyStr1;
    }

    public String getDummyStr2() {
        return str2;
    }

    public void setDummyStr2(String dummyStr2) {
        this.str2 = dummyStr2;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "id=" + id + ", str1=" + str1 + ", str2=" + str2 + '}';
    }
    
    
    
    
    
    
}
