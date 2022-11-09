package facades;

import dtos.UserDTO;
import entities.User;
import security.errorhandling.AuthenticationException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
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

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     *
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
    public List<UserDTO> getAll(){
        EntityManager em =getEntityManager();
        TypedQuery findAll = em.createQuery("SELECT u FROM User u", User.class);
        List<User> userList =findAll.getResultList();
        return UserDTO.getDtos(userList);
    }
    public UserDTO create(UserDTO userDTO){
        EntityManager em = getEntityManager();
        User user = new User(userDTO.getUsername(),userDTO.getUserPass());
        try{
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new UserDTO(user);
    }
    public User update(User user) throws EntityNotFoundException {
        if (user.getId() == 0)
            throw new IllegalArgumentException("No User can be updated when id is missing");
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        User u = em.merge(user);
        em.getTransaction().commit();
        return u;
    }

    public User delete(int id) throws EntityNotFoundException{
        EntityManager em = getEntityManager();
        User u = em.find(User.class, id);
        if (u == null)
            throw new EntityNotFoundException("Could not remove user with id: "+id);
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        return u;
    }
}
