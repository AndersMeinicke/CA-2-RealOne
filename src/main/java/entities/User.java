package entities;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Size(max = 25)
    @NotNull
    @Column(name = "user_name", nullable = false, length = 25)
    private String userName;

    @Size(max = 255)
    @Column(name = "user_pass")
    private String userPass;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Role> roleList = new ArrayList<>();

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }


    public User(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    // todo pls check this
    public boolean verifyPassword(String password) {

       boolean checkPass = BCrypt.checkpw(password, userPass);
        return checkPass;
    }

    // todo pls check this
    public List<String> getRolesListForUser() {
        //get the roles from the roleList and return them as a list of strings
        if (roleList != null) {
            List<String> roleNames = new ArrayList<>();
            for (Role role : roleList) {
                roleNames.add(role.getRoleName());
            }
            return roleNames;
        }

        return null;
    }


    // todo pls check this
    public void addRole(Role userRole) {
        this.roleList.add(userRole);
    }




}