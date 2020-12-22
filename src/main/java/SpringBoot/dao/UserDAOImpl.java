package SpringBoot.dao;


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

    public boolean saveUser(User user) {
            entityManager.persist(user);
            return true;
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
    user.setId(userUp.getId());
    user.setPassword(userUp.getPassword());
    }

    public void deleteUser(Long id) {
        entityManager.remove(getFromId(id));
    }

    @Override
    public List<Role> readRole() {
        TypedQuery<Role> query= entityManager.createQuery("from Role", Role.class);
        return query.getResultList();
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

    @Override
    public Set<Role> getRoles(String[] ids) {
        TypedQuery<Role> query= entityManager.createQuery("from Role where id = :id", Role.class);
        Set<Role> roles = new HashSet<>();
        Arrays.stream(ids).forEach(roleId -> {query.setParameter("id", Long.parseLong(roleId)); roles.add(query.getSingleResult());});
        return roles;
    }

}
