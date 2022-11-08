package entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Size(max = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_name", nullable = false, length = 20)
    private String roleName;

    public Role() {

    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    //TODO [JPA Buddy] generate columns from DB

}