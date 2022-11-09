package facades;

import dtos.UserDTO;
import entities.Role;
import entities.User;
import security.errorhandling.AuthenticationException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author lam@cphbusiness.dk
 */
public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
    }

    /**
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public UserDTO create(UserDTO rm) {
        User rme = new User(rm.getUserName(), rm.getUserPass());
        Role userRole = new Role("user");
        rme.addRole(userRole);
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rme);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new UserDTO(rme);

    }

//    public List<UserDTO> getAllUsers(){
//
//        EntityManager em = getEntityManager();
//
//        try{
//
//            TypedQuery findAll = em.createQuery("SELECT p FROM User p", User.class);
//            List<User> users = findAll.getResultList();
//            return UserDTO.getDTOs(users);
//
//        }finally {
//            em.close();
//        }
//
//    }

    public List<UserDTO> getAllUsers(){

        EntityManager em = getEntityManager();

        try{
            TypedQuery<User> query = em.createQuery("select u from User u", User.class);
            List<User> users = query.getResultList();
            return UserDTO.getDTOs(users);
        }finally {
            em.close();
        }

    }
}
