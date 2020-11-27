package withoutXMLs.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;
import withoutXMLs.model.Role;
import withoutXMLs.model.User;


import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


@Component
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

//        User user = new User("User1","User1@mail.ru","1234",(byte)98);
//        User user2 = new User("User2","User1@mail.ru","4321",(byte)36);
//
//        Role role_user = new Role(1L,"ROLE_USER");
//        Role role_admin = new Role(2L,"ROLE_ADMIN");
//
//    public void AddRolesAndAdmin() {
//        entityManager.persist(user);
//        entityManager.persist(user2);
//        entityManager.persist(role_user);
//        entityManager.persist(role_admin);
//    }

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

    public void updateUser(Long id,User userUp){
    User user =  getFromId(id);
    user.setName(userUp.getName());
    user.setAge(userUp.getAge());
    user.setMail(userUp.getMail());
    user.setId(userUp.getId());

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
