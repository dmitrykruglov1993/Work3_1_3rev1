package SpringBoot.dao;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import SpringBoot.model.Role;
import SpringBoot.model.User;


import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RoleDAO roleDAO;

    public boolean saveUser(User user) {
        entityManager.persist(user);
        return true;
    }

    public User SetUserRole(String user){

        Gson gson = new Gson();
        User userFromJson = gson.fromJson(user,User.class);

        Set<Role> role_User = new HashSet<>();
        role_User.add(roleDAO.getRoleFromId(1L));

        Set<Role> role_Admin = new HashSet<>();
        role_Admin.add(roleDAO.getRoleFromId(2L));

        if(user.contains("ROLE_USER")){
            userFromJson.setRole(role_User);
        }else if(user.contains("ROLE_ADMIN")) {
            userFromJson.setRole(role_Admin);
        }
        return userFromJson;
    }

    public List<User> getUsers(){
       return entityManager.createQuery("from User ").getResultList();
    }

    public User getFromId(Long id){
        return entityManager.find(User.class,id);
    }

    public void updateUser(User userUp){
//    User user =  getFromId(userUp.getId());
//    user.setName(userUp.getName());
//    user.setId(userUp.getId());
//    user.setPassword(userUp.getPassword());
        entityManager.merge(userUp);
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
