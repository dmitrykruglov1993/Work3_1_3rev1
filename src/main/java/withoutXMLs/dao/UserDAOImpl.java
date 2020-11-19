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

    public List<User> getFromId(Long id){
        return entityManager.createQuery("from User where id ="+id+"").getResultList();
    }

    public void updateUser(Long id,User updateUser){
       entityManager.createQuery("select * from User where id ="+id+"");
    }

//    @Override
//    public void DeleteUser() {
//
//    }
//
//    @Override
//    public void UpdateUser() {
//
//    }
//
//    @Override
//    public String GetUserByID(Long id) {
//        return null;
//    }

}
