package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Size(max = 20)
    @Column(name = "role_name", nullable = false)
    private String id;
    @Column(name = "role_name")
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //TODO [JPA Buddy] generate columns from DB
    public String getRoleName() {
        return roleName;
    }
}