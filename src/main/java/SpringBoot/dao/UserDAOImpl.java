package SpringBoot.dao;


import org.springframework.stereotype.Component;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import SpringBoot.model.Role;
import SpringBoot.model.User;


import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public boolean saveUser(User user) {
        Set<Role> roles_USER = new HashSet<>();
        Set<Role> roles_ADMIN = new HashSet<>();
        roles_USER.add(getRoleFromId(1L));
        roles_ADMIN.add(getRoleFromId(2L));

        if(user.getRoleMarker().equals("ROLE_USER")){
            user.setRole(roles_USER);
            user.setRoleMarker("ROLE_USER");
            entityManager.persist(user);
            return true;
        }else if(user.getRoleMarker().equals("ROLE_ADMIN")){
            user.setRole(roles_ADMIN);
            user.setRoleMarker("ROLE_ADMIN");
            entityManager.persist(user);
            return true;
        }
        return false;
    }

    public List<User> getUsers(){
       return entityManager.createQuery("from User ").getResultList();
    }

    public User getFromId(Long id){
        return entityManager.find(User.class,id);
    }

    public Role getRoleFromId(Long id){return entityManager.find(Role.class,id);}

    public void updateUser(Long id,User userUp){
    User user =  getFromId(id);
    user.setName(userUp.getName());
    user.setAge(userUp.getAge());
    user.setMail(userUp.getMail());
    user.setId(userUp.getId());
    user.setPassword(userUp.getPassword());

    Set<Role> roles_USER = new HashSet<>();
    Set<Role> roles_ADMIN = new HashSet<>();
    roles_USER.add(getRoleFromId(1L));
    roles_ADMIN.add(getRoleFromId(2L));

    if(userUp.getRoleMarker().equals("ROLE_USER")){
        user.setRole(roles_USER);
        user.setRoleMarker("ROLE_USER");
    }else if(userUp.getRoleMarker().equals("ROLE_ADMIN")){
        user.setRole(roles_ADMIN);
        user.setRoleMarker("ROLE_ADMIN");
    }
    }

    public void deleteUser(Long id) {
        entityManager.remove(getFromId(id));
    }

    @Override
    public User getUserByName(String login) {
        User user = new User();
        user.setName(login);
        return user;
    }

    public User findUserByName(String name){
        TypedQuery<User> query = entityManager.createQuery("from User where name = :name",User.class);
        User user = query.setParameter("name",name).getSingleResult();
        return user;
    }

}
