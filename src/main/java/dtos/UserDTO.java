package dtos;

import entities.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link entities.User} entity
 */
public class UserDTO implements Serializable {
    private final Integer id;
    @Size(max = 25)
    @NotNull
    private final String userName;
    @Size(max = 255)
    private final String userPass;
    private final List<String> roleListForUser;

    public UserDTO(User u) {
        this.id = u.getId();
        this.userName = u.getUserName();
        this.userPass = u.getUserPass();
        this.roleListForUser = u.getRolesListForUser();
    }


    public UserDTO(Integer id, String userName, String userPass, List<String> roleListForUser) {
        this.id = id;
        this.userName = userName;
        this.userPass = userPass;
        this.roleListForUser = roleListForUser;
    }

    public UserDTO(String userName, String userPass, List<String> roleListForUser) {

        this.id = 0;
        this.userName = userName;
        this.userPass = userPass;
        this.roleListForUser = roleListForUser;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public List<String> getRoleListForUser() {
        return roleListForUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO entity = (UserDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.userName, entity.userName) &&
                Objects.equals(this.userPass, entity.userPass) &&
                Objects.equals(this.roleListForUser, entity.roleListForUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userPass, roleListForUser);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "userName = " + userName + ", " +
                "userPass = " + userPass + ", " +
                "roleListForUser = " + roleListForUser + ")";
    }

    public static List<UserDTO> getDTOs (List<User> users){
        List<UserDTO> userDTOList = new ArrayList<>();
        users.forEach(u -> userDTOList.add(new UserDTO(u)));
        return userDTOList;
    }
}