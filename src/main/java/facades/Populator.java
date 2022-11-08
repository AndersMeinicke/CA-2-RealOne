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
        //FacadeExample fe = FacadeExample.getFacadeExample(emf);
   //     fe.create(new UserDTO(new RenameMe("First 1", "Last 1")));
        //    fe.create(new UserDTO(new RenameMe("First 2", "Last 2")));
   //     fe.create(new UserDTO(new RenameMe("First 3", "Last 3")));
        Role role = new Role ("user");
        User firstUser = new User("userName", "userPass");
        firstUser.addRole(role);

        uf.create(new UserDTO(firstUser));
    }
    
    public static void main(String[] args) {
        populate();
    }
}
