/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.UserDTO;

import javax.persistence.EntityManagerFactory;

import entities.Role;
import entities.User;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        UserFacade uf= UserFacade.getUserFacade(emf);

        Role user = new Role ("user");
        Role admin = new Role ("admin");

        User firstUser = new User("userName", "userPass");
        User secondUser = new User("userName2", "userPass2");
        User thirdUser = new User("userName3", "userPass3");

//        firstUser.addRole(user);
//        secondUser.addRole(user);
//        thirdUser.addRole(admin);


        uf.create(new UserDTO(firstUser));
        uf.create(new UserDTO(secondUser));
        uf.create(new UserDTO(thirdUser));
    }
    
    public static void main(String[] args) {
        populate();
//        User testuser = new User("test", "test");
//        testuser.addRole(new Role("user"));
//        UserDTO testuserDTO = new UserDTO(testuser);
//        System.out.println(testuserDTO.getRoleListForUser());
//        System.out.println(testuserDTO);
    }

}
