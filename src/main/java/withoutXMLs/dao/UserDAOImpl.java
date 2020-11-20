package withoutXMLs.dao;


import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;
import withoutXMLs.model.User;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Component
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    User user = new User("User1","User1@mail.ru",(byte)98);

    public void FirstSave() {
        entityManager.persist(user);
    }

    public void save(User user) {
        entityManager.persist(user);
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

}
