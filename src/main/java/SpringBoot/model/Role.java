package SpringBoot.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role implements GrantedAuthority {

    @Id
    private Long id;

    @Column
    private String role;


//    @ManyToMany(mappedBy = "role")
//    @Transient
//    private Set<User> user;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public Set<User> getUser() {
//        return user;
//    }

//    public void setUser(Set<User> user) {
//        this.user = user;
//    }

    @Override
    public String getAuthority() {
        return getRole();
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
//                ", user" + user +
                '}';
    }
}
